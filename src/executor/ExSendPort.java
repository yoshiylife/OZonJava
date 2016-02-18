/*
 Copyright(c) 1996-1998
 IPA, ETL, AT21, FSIABC, FXIS, InArc, MRI, NUL, SBC, Sharp, TEC, TIS

 All rights reserved.  No guarantee.
 This technology is a result of the Advanced Software  Enrichment 
 Project of Information-technology Promotion Agency, Japan (IPA).

 Permissions  to  use,  copy, modify and distribute this software
 are governed by the terms and conditions set forth in  the  file 
 COPYRIGHT, located on the top directory of this software.
 */

package JP.go.ipa.oz.system;

import java.io.*;
import java.net.*;
import java.util.*;

/***
 * Socket-level communication port for sending.
 * @see ExReceivePort
 * @see ExAcceptPort
 * @see ExCommAddress
 */ 
final class ExSendPort implements Runnable{
  private static String CN = "ExSendPort";
  ExCommAddress destination;
  Socket    socket;
  OutputStream ostream;
  InputStream  istream;
  
  ExSendPort next,prev;
  
  boolean connected = false;
  boolean closeRequested = false;
  boolean deleted=false;

  int forgottenCount=0;
  ExSendBuffer buffers;

  Vector terminals = new Vector(8,4);

  static final int PingInterval=10000;

  /***
   * @param ExCommAddress dest : Destination address to send.
   */
  ExSendPort(ExCommAddress dest)
    {
      destination = dest;
    }

  /***
   * Set new destination address<br>
   * SetDestination method may be used when connection had been failed
   * and to retry connection with other communication address.
   * @param ExCommAddress dest : New destination address to send.
   */
  final void SetDestination(ExCommAddress dest)
    {
      destination = dest;
    }

  /***
   * Make socket connection.<br>
   * If connected already, do nothing.
   * @exception OzConnectionFailureException raised if connection failed,
   * other exception may be raised.
   */
  synchronized final void connect() throws ExCommException,ExException 
    {
      if(connected) 
	return;

      if(destination==null)
	throw new ExCommConnectionFailureException("OzConnectionError:Null address");
      try{
	socket = new Socket(destination.address,destination.port);
	socket.setTcpNoDelay(true);
      } catch (IOException ex) {
	/* Feb. 18th, 1998. replaced by Nishioka */
	/* this can be occur in normal sequence (i.e., resolver replies an
	   old cache entry. */
	Executor.debug("SendPort connection failure: "+ex.getMessage());
	// Executor.message("SendPort connection failure: "+ex.getMessage());
	throw new ExCommConnectionFailureException();
      }

      try{
	ostream = socket.getOutputStream();
	istream = socket.getInputStream();
      } catch (IOException ex) {
	Executor.message("SendPort get stream failure: "+ex.getMessage());
	try{
	  ostream.close();
	  ostream=null;
	  istream.close();
	  istream=null;
	  socket.close();
	} catch(IOException exx) {
	}
	throw new ExCommException("fail to start send port because of stream creation failure");
      }
      connected=true;
      ExCommPortManager.incrementConnectedSendSockets();
      Executor.debug(CN,"connect","connected to "+destination);
    }

  /***
   *
   */
  synchronized final void disconnect(){
    if(!connected)
      return;
    try{
      ostream.close();
      istream.close();
      socket.close();
    } catch (IOException exxx){
    }
    ostream=null;
    istream=null;
    socket=null;
    connected=false;
    ExCommPortManager.decrementConnectedSendSockets();
    Executor.debug(CN,"disconnect","disconnected to "+destination);
  }

  /***
   * reset to initial state. This method is for recycling.
   */
  synchronized final void reset(){
    destination=null;
    if(connected){
      try{
	socket.close();
	ostream.close();
	istream.close();
      } catch (IOException ex){
	// ignore error even if fail to close socket
      }
    }
    connected=false;
    closeRequested=false;
    socket=null;
    istream=null;
    ostream=null;
    terminals = new Vector(8,4);
  }

  /***
   * routine for deamon thread of ExSendPort.
   */
  public synchronized final void run(){
    ExSendBuffer buf;
    int avail=0;

    ExSendBuffer pingPacket;
    
    for(;;){

      while(buffers==null)
	{

	  try {
	    wait(PingInterval); /* wait for 10 second */
	  } catch(InterruptedException ie) {
	  }

	  if(deleted)
	    {
	      Executor.debug(CN,"run","deamon terminated because port is deleted");
	      return;
	    }

	  if(buffers==null && !(terminals.isEmpty()))
	    {			/* No buffer to send available but terminals exist */
	      forgottenCount=0;
	      try{		/* Ping */
		if(!connected)
		  {
		    closeRequested=true;
		    try{
		      connect();
		    }catch(Exception ex){
		      Executor.message(CN+"#run:Fail to reconnect for PINGConnection.");
		      reportError();
		      deleteSelf();
		      return;
		    }
		  }
		pingPacket = new ExSendBuffer();
		pingPacket.writeInt(ExCommBuffer.ExPing);
		pingPacket.writeInt(0);
		pingPacket.writeLong(0L);
		pingPacket.writeTo(ostream);
		ostream.flush();
		if(closeRequested || ExCommPortManager.connectedSendSockets >=ExCommPortManager.SendConnectionMax)
		  {
//		    Executor.message(CN,"run","disconnect request="+closeRequested+" connected="+ExCommPortManager.connectedSendSockets);
		    disconnect();
		  }
	      } catch (IOException ioex){
		deleteSelf();
		ExCommManager.deadExecutorFound(destination);
//		Executor.message("ExSendPort:Connection closed(PING).");
		reportError();
		return;
	      }
	    }
	  else if(buffers==null && terminals.isEmpty())
	    {			/* Currently not used at all */
	      if(connected 
		 && ((ExCommPortManager.connectedSendSockets>ExCommPortManager.SendConnectionKeep)
		     ||closeRequested))
		{
//		  Executor.message(CN,"run","disconnect too many connection:connected="+ExCommPortManager.connectedSendSockets);
		  disconnect();
		}
	      forgottenCount++;
	      if(forgottenCount>2)
		{
//		  Executor.message(CN,"run","forgotten long time");
		  disconnect();
		  deleteSelf();
		  return;
		}
	    }

	  /* check disconnect request from receiver side */
	  if(connected){

	    try{
	      avail=istream.available();
	      Executor.debug(CN,"run","check disconnect request: "+avail);

	    } catch(IOException ioex){
	      disconnect();
	      reportError();
	      deleteSelf();
	      Executor.debug(CN,"run","exception at available",ioex);
	      return;
	    }

	    if(avail>0){
	      byte[] trashbuf=new byte[avail];
	      try{
		istream.read(trashbuf,0,avail);
	      } catch(IOException ioex){
	      }
	      Executor.debug(CN,"run","check disconnect request comes!");
	      closeRequested=true;
	      if(avail==3)
		{ 
		  Executor.debug(CN,"run","final disconnect request comes!");
		  disconnect();
		  reportError();
		  deleteSelf();
		  return;
		}
	    }
	  }

	}

      buf = buffers;
      buffers = buffers.next;
      if(!connected)
	try{
	  connect();
	} catch (ExException exex){
	  Executor.syslog(CN,"run","fail to reconnect",exex);
	  buf.next=buffers;
	  buffers=buf;
	  reportError();
	  deleteSelf();
	  return;
	}
      try{
	buf.writeTo(ostream);	/* send to */
	if(buffers==null)
	  {
	    ostream.flush();
	    Executor.debug(CN+"#run output stream was flushed");
	  }
	else
	  {
	    Executor.debug(CN+"#run output stream has not been flushed, because more buffer(s) to be sent exists.");
	  }
	Executor.debug(CN+"#run one buffer has been sent");
      } catch (IOException ex){
	Executor.message("ExSendPort#run:exception at writeTo "+ex.getMessage());	/* Error detected */
	buf.next=buffers;
	buffers=buf;
	reportError();
	deleteSelf();
	return;
      }
      ExCommBuffer.freeExSendBuffer(buf);
    }
  }

  private void deleteSelf()
    {
      Executor.debug(CN,"deleteSelf","send port is deleted");
      ExCommPortManager.removeSendPort(this);
      deleted=true;

    }

  /***
   * report error to all of terminals which use this ExSendPort.
   */
  private final void reportError(){
    for(Enumeration e = terminals.elements() ; e.hasMoreElements();){
      ((ExSessionTerminal)(e.nextElement())).notifyError(1);
    }
  }

  /***
   * put a ExSendBuffer to ExSendPort<br>
   * The buffer is put at end of buffer queue, and will be send by daemn thread.
   * @param b buffer to be send.
   */
  synchronized void putSendBuffer(ExSendBuffer b){
    Executor.debug(CN+" putSendBuffer");

    if(buffers==null)
      buffers=b;
    else
      {
	ExSendBuffer bb,bbb;
	for(bb=buffers;bb.next!=null;bbb=bb,bb=bbb.next)
	  ;
	bb.next=b;
      }
    notifyAll();
  }

  /***
   * request to temporal closure of socket.<br>
   * Socket  will be closed when buffer queue becomes empty.<br>
   * This method does not remove ExSendPort but intends to close socket.
   */
  void close(){
    closeRequested=true;
    notifyAll();
  }


  /*
   * bug fix : addTerminal and removeTerminal become non-synchronized.
   *   It caused dead-lock in some timing.
   *   (One is ExSendPort#run invokes ExCommSystem#freeExSendBuffer,
   *   othres is ExCommSystem#findSendPort invokes ExSendPort#addTerminal)
   *   These method is not necessary to be synchronized, because
   *    Vector#{addElement,removeElement} are synchronized.
   */
  /***
   * add a session terminal to the send-port-users-list.<br>
   * Session terminals in the send-port-users-list will be informed about 
   * error and temporal closure of connection.
   * @param terminal session terminal to be added.
   * @see removeTerminal
   */

  void addTerminal(ExSessionTerminal terminal){
    terminals.addElement(terminal);
  }

  /***
   * remove a session terminal from the send-port-users-list.<br>
   * @param terminal session terminal to be removed.
   * @see #addTerminal
   */
  void removeTerminal(ExSessionTerminal terminal){
    terminals.removeElement(terminal);
  }

  final void shutdown(){
      deleted=true;
      disconnect();
  }

  final synchronized void checkDisconnection(){
    Executor.debug(CN,"checkDisconnection","invoked connected="+connected);

    int avail=0;

    try{
      avail=istream.available();
      Executor.debug(CN,"checkDisconnection","check disconnect request: "+avail);
      
    } catch(IOException ioex){
      disconnect();
      reportError();
      deleteSelf();
      Executor.debug(CN,"checkDisconnection","exception at available",ioex);
      return;
    }
    
    if(avail>0){
      byte[] trashbuf=new byte[avail];
      try{
	istream.read(trashbuf,0,avail);
      } catch(IOException ioex){
      }
      Executor.debug(CN,"checkDisconnection","check disconnect request comes!");
      closeRequested=true;
      if(avail==3)
	{ 
	  Executor.debug(CN,"checkDisconnection","final disconnect request comes!");
	  disconnect();
	  reportError();
	  deleteSelf();
	  return;
	}
    }
    notifyAll();
  }
  
}

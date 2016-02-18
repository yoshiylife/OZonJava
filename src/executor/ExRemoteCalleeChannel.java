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

/*
 * $Id: ExRemoteCalleeChannel.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 */

package JP.go.ipa.oz.system;

import java.io.*;
import java.lang.*;

/***
 * ExCalleeChannel for remote invocation.<br>
 * ExRemoteCalleeChannel exists on the same executor of caller object and
 * works as if the remote callee object exists here.<br>
 * Deamon thread is created when ExRemoteCalleeChannel is created, and
 * the deamon thread makes communication to ExRemoteCallerChannel on
 * the executor where callee object exists.<br>
 * 
 * @see ExCalleeChannel
 * @see ExRemoteCallerChannel
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author                Yoichi Hamazaki
 */
final class ExRemoteCalleeChannel 
implements Runnable,ExCalleeChannel,ExSessionTerminal{
  /**
   * Class name string for debug use
   */
  private static String CN="ExRemoteCalleeChannel";

  /**
   * callerChannel is ExChannel(extends ExCallerChannel) of invoker.
   */
  ExChannel callerChannel;

  /**
   * process Id
   */
  String pid;

  /* for ExCalleeChannel */
  /**
   * OzProxy which has information of invocation (arguments and method selector)
   */
  OzProxy proxy;

  /**
   * array of arguments
   */
  Object calleeArguments[];

  /* for ExSessionTerminal */
  /**
   * ExSessionId which identify corresponding ExRemoteCallerChannel on
   * other executor and corresponding packets to be received.
   */
  ExSessionId sessionId;

  /**
   * GOL of callee
   */
  String calleeGol;

  /**
   * GOL of caller
   */
  String callerGol;

  /**
   * Communicatio address (IP + port No.) of executor where callee object exists. 
   */
  ExCommAddress calleeAddress;

  /**
   * Stream for sending data using packet
   */
  ExSendStream sendStream;

  /**
   * Stream for receiving data from received packets
   */
  ExReceiveStream receiveStream;

  /**
   * ObjectOutputStream which use ExClassLoader for serialization of object
   */
  ExObjectOutputStream ooStream;

  /**
   * ObjectInputStream which use ExClassLoader for desrialization of object
   */
  ExObjectInputStream  oiStream;

  /**
   * ObjectOutputStream with functions of negotiation of cipher types
   * and encryption of data
   */
  ExCalleeCipherOutputStream coStream;

  /**
   * ObjectInputStream with functions of negotiation of cipher types
   * and decryption of data
   */
  ExCalleeCipherInputStream  ciStream;


  /**
   * Success flag of remote invocation.
   */
  boolean success;

  /**
   * Flag which indicate failure of executor where callee object exists.<br>
   * This flag is set by ExSendPort which watchs condition of executors on
   other end of remote invocations.
   */
  boolean serverNotExists=false;

  /**
   * Timeout value for negotiation of cipher types.<br>
   * Currently 1000 milliseconds.
   */
  static int IntervalTimer=1000;

  /***
   * construct and create deamon thread.
   * @param processid process id
   * @param addr ExCommAddress of executor where callee object exists.
   * @param chan ExCallerChannel of caller.
   * @param prox proxy of global invocation.
   * @param caller GOL of caller object.
   *
   * @exception throws ExException<br>
   *  exceptions occured inside of executor.
   * @exception throws ExCellException<br>
   *  excaptions related Cell, ExCellNotFoundException or other.
   * @exception throws ExCommException<br>
   *  exceptions related communication, ExCipherException or ExCommException.
   */
  ExRemoteCalleeChannel(ExCommAddress addr,ExChannel chan,OzProxy calleeProxy,String caller)
    throws ExException,ExCellException,ExCommException
{
  int initialPacketType=ExCommBuffer.OzCallInitial;
  pid = chan.pid();
  calleeAddress=addr;
  proxy = calleeProxy;
  calleeGol=proxy.getName();
  callerGol=caller;
  callerChannel=chan;
  sessionId = new ExSessionId();
  Object o;

  if(sessionId.ipV6)
    initialPacketType |= ExCommBuffer.IPv6SessionId;

  try {
    sendStream = new ExSendStream(calleeAddress,this,ExCommBuffer.OzCallInitial);
  } catch (ExCommConnectionFailureException ex){
    Executor.debug(CN,"ExRemoteCalleeChannel","Can't create ExSendStream",ex);
    throw ex;
  }
    
  receiveStream=new ExReceiveStream();
  ExCommSessionManager.registerClientTerminal(sessionId,this);
    
  sendStream.packetType=ExCommBuffer.OzCall;
  try{
    ooStream= new ExObjectOutputStream(sendStream);
    coStream = new ExCalleeCipherOutputStream(ooStream, proxy, callerGol);
  } catch (IOException ex1){
    Executor.syslog(CN,"ExRemoteCalleeChannel","IOException occured while creating output streams",ex1);
    ExCommException ecex = new ExCommException("IOException while creating output streams for sending invocation data");
    cleanup();
    throw ecex;
  }

  try{
    ooStream.writeUTF(pid);
    ooStream.writeUTF(callerGol);
    ooStream.writeUTF(calleeGol);
    ooStream.writeInt(calleeAddress.cellNumber);
    Executor.debug("proxy encode. Selector ="+proxy.selector+proxy.toString());
    Executor.debug("process is green?"+proxy.runningIsGreen()+" proxy is green?"+ proxy.isGreen());
      
    /* negotiation of cipher type and then send proxy*/
    coStream.writeObject(proxy);
  } catch (SecurityException exs){
    /* case of red process trys to invoke with green proxy (security alert)*/
    Executor.syslog(CN,"ExRemoteCalleeChannel","security alert while encoding proxy ",exs);
    Executor.debug(CN,"ExRemoteCalleeChannel","security alert while encoding proxy ",exs);
    // SecurityException should be changed to ExSecurityException
      //      ExSecurityException esex=new ExSecurityException("");
    //      callerChannel.done(false,esex);
    cleanupInvocation();
    //      throw esex;
    throw exs;
  } catch (IOException ex1){
    Executor.syslog(CN,"ExRemoteCalleeChannel","IOException occured while sending",ex1);
    Executor.debug(CN,"ExRemoteCalleeChannel","IOException occured while sending",ex1);
    ExCommException ecex = new ExCommException("IOException while sending invocation data");
    cleanupInvocation();
    throw new ExException(ex1.getClass().getName());
  }  catch (ExCommException ecex){
    Executor.syslog(CN,"ExRemoteCalleeChannel","ExCommException (may be cipher related)occured while cipher output streams",ecex);
    Executor.debug(CN,"ExRemoteCalleeChannel","ExCommException (may be cipher related)occured while cipher output streams",ecex);
    cleanup();
    throw ecex;
  } catch (ExException exex){
    Executor.syslog(CN,"ExRemoteCalleeChannel","ExException (misc) occured while cipher output streams",exex);
    Executor.debug(CN,"ExRemoteCalleeChannel","ExException (misc) occured while cipher output streams",exex);
    cleanup();
    throw exex;
  } 

  try{
    //      sendStream.setEndOfStreamFlag();
    ooStream.flush();
  }catch (IOException ex){
    Executor.syslog(CN,"ExRemoteCalleeChannel","IOException occured while sending",ex);
    Executor.debug(CN,"ExRemoteCalleeChannel","IOException occured while sending",ex);
    ExCommException ecex = new ExCommException("IOException while flushing invocation data");
    cleanup();
    throw ecex;
  }
    
  /* Negotiation Start (receive result of execution) */
  Executor.debug(CN+"#run:Negotiation Start");

  negotiation();

  Executor.debug(CN+"#run:Negotiation End");
}

  /***
   * get terget object.
   * @return always returns null, because ExRemoteCalleeChannel does not
   * have target global object which located on another executor.
   *
   * @ see ExCalleeChannel
   */
  public final Object object()
    {
      return null;
    }

  /***
   * get arguments.
   *
   * @ see ExCalleeChannel
   */
  public final Object[] arguments()
    {
      return calleeArguments;
    }

  /***
   * exit
   *
   * @param status is true if method invocation finished successfully,
   * otherwise false(Exception or error occured).
   * @param result is result of method invocation or exception which raised
   while method invocation.
   *
   * @ see ExCalleeChannel
   */
  public final void exit(boolean status,Object result)
    {
      callerChannel.done(status,result);
    }

  /***
   * abort
   * send abort packet.
   *
   * @ see ExCalleeChannel
   */
  public final void abort()
    { 
      ExSendBuffer abortBuf;
      int ptype;

      ptype = ExCommBuffer.OzAbort | ((sessionId.ipV6)? ExCommBuffer.IPv6SessionId : 0);
      
      abortBuf = new ExSendBuffer();
      abortBuf.writeInt(ptype);
      abortBuf.writeInt(0);
      abortBuf.setPacketType(ptype);
      try{
	abortBuf.write(sessionId.getId());
      } catch(IOException ex) { // never occure!
			      }
      abortBuf.setDataSize();
      sendStream.port.putSendBuffer(abortBuf);
    }

  /***
   * program for deamon thread.
   */
  public final void      run(){
    Object o;
    
    /* receive result of execution (Object is superclass of Exception)*/
    try{
      if (serverNotExists == true) {
	o = new ExCommException("Unexpected Executor's Shutdown");
	success=false;
      }
      else if (ciStream.CipherType == ExCommCipher.NegotiationStop) {
	o =  new ExCommCipherNotFoundException();
	success=false;
      }
      else {
	Executor.debug("ExRemoteCalleeChannel:getResult Start");
	o = getResult();
	Executor.debug("ExRemoteCalleeChannel:getResult End");
      }
    } catch (Exception ex2){
      if(receiveStream.endOfIncompleteBlockFlag2)
	{			/* case of exception while serialization , try to receive another result which shuld be exception */

	  try{
	    oiStream.close();
	    oiStream = new ExObjectInputStream(receiveStream);
	  }catch(Exception ex3){
	    Executor.message("fail to create new ObjectInputStream");
	    callerChannel.done(false,ex2);
	    try{
	      receiveStream.close();
	    }catch(Exception ex4){
	    }
	    callerChannel=null;
	    ExCommSessionManager.removeClientTerminal(this);
	    return;
	  }
	  
	  try{
	    o = oiStream.readObject();
	    success=true;
	  } catch(Exception ex4){
	    o=ex4;
	    success=false;
	  }
	}
      else
	{
	  //Executor.message("not endOfIncompleBlock! "+receiveStream.endOfIncompleteBlockFlag+receiveStream.endOfIncompleteBlockFlag2+receiveStream.endOfStreamFlag);
	  o=ex2;
	  success=false;
	}
    }

    /* result type has been set at putReceiveBuffer */
    if(success)
      {
	callerChannel.done(true,o);
      }
    else
      {
	callerChannel.done(false,(Exception)o);
      }
    cleanup();
  }
  
  /***
   * cleanup. close streams and remove itself from terminals list.
   */
  private final void cleanup(){

    sendStream.close();
    receiveStream.close();
    callerChannel=null;
    ExCommSessionManager.removeClientTerminal(this);
    return;
  }

  /***
   * cleanup for interrupted invocation by exception.
   * Send EndOfIncompleteBlockPacket, 
   * close streams and remove itself from terminals list.
   */
  final void cleanupInvocation(){
    if(sendStream.packetTransmitted)
      sendStream.flushIncompleteData();

    sendStream.closeWithoutSend();
    receiveStream.close();

    callerChannel=null;
    ExCommSessionManager.removeClientTerminal(this);
    return;
  }

  /***
   * get proxy
   */
  final OzProxy   getProxy(){
    return proxy;
  }

  /***
   * notify error from ExSendPort
   */
  public final void notifyError(int errorCode){
    serverNotExists=true;

    Executor.debug("ExRemoteCalleeChannel:notifyError");

    callerChannel.done(false, new ExCommException("Unexpected Executor's Shutdown"));

    receiveStream.close();
  }

  /***
   * put recieced buffer from ExReceivePort
   */
  public final void putReceiveBuffer(ExReceiveBuffer rbuf){
    int kind;
    kind = rbuf.getPacketType() & ExCommBuffer.PacketKindMask;

    if(kind  == (ExCommBuffer.OzResult & ExCommBuffer.PacketKindMask))
      success=true;
    else if(kind == (ExCommBuffer.OzException & ExCommBuffer.PacketKindMask))
      success=false;
    else if(kind  == (ExCommBuffer.OzCipher & ExCommBuffer.PacketKindMask))
      success=true;
    else
      {
	Executor.syslog(CN,"putReceiveBuffer",
			"Unknow type packet arrived. packetType = "
			+ExCommMiscConvert.intToHexString(rbuf.getPacketType())
			,null);
	ExCommBuffer.freeExReceiveBuffer(rbuf);
	return;
      }
    receiveStream.putBuffer(rbuf);
    
    synchronized (this) {
      notifyAll();
      //      notify();
    }

    return;
  }

  /***
   * get session id.
   *
   * @see ExSessionTerminal 
   */
  public final ExSessionId getSessionId()
    {
      return sessionId;
    }

  /***
   * 暗号化方式をアウト側へ渡す
   */
  final void getCipher(){
    if (ciStream.CipherType != ExCommCipher.NegotiationOk) {
      coStream.CipherType = ciStream.CipherType;
      coStream.CipherName = ciStream.CipherName;
    }
  }

  /***
   * 交渉処理
   */
  private void negotiation() 
    throws ExException,ExCommException{
      Object o;
    
      try{
	while(!receiveStream.Signaled && !serverNotExists) {
	  Executor.debug(CN+"#serverNotExists = " + serverNotExists);
	  synchronized (this) {
	    wait(IntervalTimer);
	  }
	}
      } catch(InterruptedException ex){
	cleanup();
	throw new ExException("thread interrupted");
      }
      
      if (serverNotExists == true) {
	
	cleanup();
	throw new ExCommException("Unexpected Executor's Shutdown");
      }
      
      try{
	oiStream = new ExObjectInputStream(receiveStream);
	ciStream = new ExCalleeCipherInputStream(oiStream);
      } catch (IOException ex){
	/* clean up */
	cleanup();
	throw new ExCommException("Fail to receive result because of stream creation failure");
	
      }
      
      if (receiveStream.toDo == ExCommCipher.Error) {
      }
      else if (receiveStream.toDo == ExCommCipher.ReCipher) {
	
	receiveStream.Signaled = false;
	try{
	  o = ciStream.readObject();
	} catch (Exception ex){
	  // ignore
	}
	
	if (ciStream.CipherType == ExCommCipher.Result) {
	  coStream.CipherType = ciStream.CipherType;
	  coStream.CipherName = ciStream.CipherName;
	}
	sendStream.reset();
	getCipher();
	/* Mar. 2nd, 1998.  1 line replaced by Nishioka */
	if (ciStream.CipherType == ExCommCipher.NegotiationStop) {
	    Executor.debug(CN, "ExRemoteCalleeChannel",
			   "Negotiation stops, cleaning up.");
	    cleanup(); // is this correct?;
	    throw new SecurityException("Negotiation Failure");
	} else {
	// if (ciStream.CipherType != ExCommCipher.NegotiationStop) {
	  try{
	    coStream.writeObject(proxy);
	    ooStream.flush();
	  } catch (IOException ex1){
	    Executor.syslog(CN,"ExRemoteCalleeChannel","IOException occured while sending",ex1);
	    Executor.debug(CN,"ExRemoteCalleeChannel","IOException occured while sending",ex1);
	    ExCommException ecex = new ExCommException("IOException while sending invocation data");
	    cleanupInvocation();
	    throw ecex;
	  }  catch (ExCommException ecex){
	    Executor.syslog(CN,"ExRemoteCalleeChannel","ExCommException (may be cipher related)occured while cipher output streams",ecex);
	    Executor.debug(CN,"ExRemoteCalleeChannel","ExCommException (may be cipher related)occured while cipher output streams",ecex);
	    cleanup();
	    throw ecex;
	  } catch (ExException exex){
	    Executor.syslog(CN,"ExRemoteCalleeChannel","ExException (misc) occured while cipher output streams",exex);
	    Executor.debug(CN,"ExRemoteCalleeChannel","ExException (misc) occured while cipher output streams",exex);
	    cleanup();
	    throw exex;
	  } 
	  
	  receiveStream.nextBuffer();
	}
      }
    }

  final Object getResult() throws Exception {
    Object o;
    
    while(!receiveStream.Signaled) {
      Executor.debug(CN+"#serverNotExists = " + serverNotExists);
      synchronized (this) {
        wait(IntervalTimer);
      }
    }

    if (receiveStream.toDo == ExCommCipher.Exe) {
      ciStream.CipherName = coStream.CipherName;
      /* Feb. 16th, 1998. 1 line added by Nishioka */
      ciStream.cipher = coStream.cipher;
      o = ciStream.readObject();
      ExCommCipher.makeCache(callerGol, calleeGol, ciStream.CipherName);
    }
    else if (receiveStream.toDo == ExCommCipher.Error) {
      /* Feb. 16th, 1998. 1 line added by Nishioka */
      ciStream.cipher = coStream.cipher;
      o = oiStream.readObject();
    }
    else {
      o =  new Exception("ExRemoteCalleeChannel:Unknow data type arrived.");
      success=false;
    }
    
    return o;
  }
  
}

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

import java.net.*;
import java.util.*;
import java.io.*;

/***
 * ExCallerChannel for remote invocation.<br>
 * ExRemoteCallerChannel exists on the same executor of calee object and
 * works as if the remote caller object exists here.
 * Deamon thread is created when ExRemoteCallerChannel is created,and 
 * the deamon thread makes communication with ExRemoteCalleeChannel on
 * the executor where caller object exists.
 */
class ExRemoteCallerChannel 
implements Runnable, ExCallerChannel, ExSessionTerminal
{
  private String CN="ExRemoteCallerChannel";

  /* for terminal */
  ExSessionId sessionId;
  ExReceiveStream receiveStream;
  ExSendStream   sendStream;
  String calleeGol;
  ExCommAddress callerAddress;
  int objectNumber;

  /* for ExCaller */
  String pid;
  OzProxy proxy;
  ExCalleeChannel calleeChannel;
  String callerGol;

  Object result;
  Exception exception;

  boolean finished=false;
  boolean success=false;

  /* i/o Streams */
  ExObjectInputStream oiStream;
  ExObjectOutputStream ooStream=null;

  /* */
  boolean clientNotExists=false;

   /* i/o Cipher Streams */
   ExCallerCipherInputStream  ciStream;
   ExCallerCipherOutputStream coStream=null;

  /***
   * construct and create deamon thread.
   * @param buffer buffer which contains initialize packet.
   */
  ExRemoteCallerChannel(ExReceiveBuffer buffer){
    receiveStream=new ExReceiveStream();
    sessionId = buffer.getSessionId();
    receiveStream.putBuffer(buffer);
    //Executor.message("ExRemoteCallerChannel: sessionId is"+sessionId.toString());

  }

  /***
   * pid
   */
  public String pid()
    {
      return pid;
    }

  /***
   * fork
   */
  public synchronized void fork(OzProxy proxy)
	throws ExGOLFormatException, ExCellNotFoundException, ExException
    {
      ExCell cell = ExCellManager.get(proxy);
	  if(cell == null) {
	    ExCellNotFoundException e = new ExCellNotFoundException("GOL: "+proxy);
	    Executor.debug(CN,"fork(","proxy="+proxy+")",e);
	    throw e;
	  }
	  try {
	    calleeChannel = cell.fork((ExCallerChannel)this, proxy);
	  } catch (ClassNotFoundException e) {
	    Executor.debug(CN,"fork(","proxy="+proxy+")",e);
	    throw new ExException(e.getClass().getName());
	  }
	}
  
  /***
   * join
   */
  public synchronized Object join() throws Exception
    {
      while(!finished)
	wait();
      if(success)
	return result;
      else
	throw exception;
    }
  
  /***
   * done
   */
  public synchronized void done(boolean status, Object res) throws ExException
    {
      int ipV6flag;
      success=status;
      
      /* case of unexpected termination of Executor where callee object exists */
      if(clientNotExists)
	{ finished=true;
	  notify();
	  return;
	}
      
      ipV6flag = (sessionId.ipV6)? ExCommBuffer.IPv6SessionId : 0;

      if(success)
	{
	  result=res;
	  sendStream.setPacketType(ExCommBuffer.OzResult|ipV6flag);
	  
	  try{
	    //	    ooStream.writeObject(res);
            getCipher();
	    try {
	      coStream.writeObject(res);
	      ooStream.flush();
	    } catch (IOException e) {
	      Executor.error(CN,"done(","status="+status+",res="+res+")",e);
	      throw new ExCommException("Fail to send result because of IOException "+e.getClass().getName());
	    } catch (ExCommException ecex){
	      Executor.syslog(CN,"done","fail to send result because of communication error(including cipher error)",ecex);
	    }
	  }catch(SecurityException sex){
	    /* security exception! (red process try to encode green object)*/
	    treatSecurityException();
	    return;
	  }
	  sendStream.setPacketType(ExCommBuffer.OzResultTail|ipV6flag);
	  close();
	}
      else
	{
	  exception=(Exception)res;
	  sendStream.setPacketType(ExCommBuffer.OzException|ipV6flag);
	  try{
	    try {
	      ooStream.writeObject(res);
	    } catch (IOException e) {
	      Executor.error(CN,"done(","status="+status+",res="+res+")",e);
	      throw new ExCommException("Fail to send result because of IOException "+e.getClass().getName());
	    }
	  }catch(SecurityException sex){
	    /* security exception! (red process try to encode green object)*/
	    treatSecurityException();
	    return;
	  }
	  sendStream.setPacketType(ExCommBuffer.OzExceptionTail|ipV6flag);
	  close();
	}
      finished=true;
      notify();
    }

  /***
   * kill
   */
  public synchronized void kill() throws ExException
    {
      if(calleeChannel == null)
	{
	  success=false;
	  exception = new InterruptedException("killed@"+CN);
	  finished=true;
	  notify();
	}
      else
	calleeChannel.abort();
    }

  /***
   * run
   */
  public void run(){
    Object res;

    Executor.debug(CN+"#run daemon started");

    /* setup */
    try{
      oiStream = new ExObjectInputStream(receiveStream);
    } catch (IOException ex){
      Executor.message(CN+"#run:can't create ExObjectInputStream. Never happen!"
		       +ex.getMessage());
      ExCommSessionManager.removeServerTerminal(this);
      return;
    }
     
    try{
      pid = oiStream.readUTF();
      callerGol = oiStream.readUTF();
      calleeGol = oiStream.readUTF();
    } catch (Exception ex){
      Executor.message(CN+"#run:stream corrupted(caller is unknown). Give up!"
		       +ex.getMessage());
      ExCommSessionManager.removeServerTerminal(this);
      return;
    }

    try{
      ciStream = new ExCallerCipherInputStream(oiStream, calleeGol);
    } catch (Exception ex){
      Executor.message(CN+"#run:can't create ExObjectInputStream. Never happen!"
		       +ex.getMessage());
      ExCommSessionManager.removeServerTerminal(this);
      return;
    }

    ExGOL callerGol2=null;
    ExGOL calleeGol2=null;
    try{
      callerGol2 = new ExGOL(callerGol);
      calleeGol2 = new ExGOL(calleeGol);
    } catch (Exception ex){
      Executor.message(CN,"run","Illegal GOL(s) "+callerGol+","+calleeGol,ex);
      ExCommSessionManager.removeServerTerminal(this);
      return;      
    }

    try {
	callerAddress=ExAddressManager.resolve(new ExGOL(callerGol),null);
    } catch (Exception e) {
	callerAddress=null;
    }

    if(callerAddress==null)
      {
	Executor.message(CN+"#run:can't connect to caller side. Give up!");
	ExCommSessionManager.removeServerTerminal(this);
	return;
      }

    /* retry until no more resolve possible */
    for(sendStream=null;sendStream==null;)
      {
	try{
	  sendStream = new ExSendStream(callerAddress,this,
					ExCommBuffer.OzResult);
	} catch (ExCommConnectionFailureException ex){
	      try {
	    callerAddress = ExAddressManager.resolve(new ExGOL(callerGol),callerAddress);
	      } catch (ExException e) {
		    callerAddress = null;
	      }
	  if(callerAddress==null)
	    {
	      Executor.message(CN+"#run:can't connect to caller side. Give up!");
	      ExCommSessionManager.removeServerTerminal(this);
	      return;
	    }
	}
      }

    try{
      int ipV6flag;
      ipV6flag = (sessionId.ipV6)? ExCommBuffer.IPv6SessionId : 0;
      sendStream.setPacketType(ExCommBuffer.OzCipher|ipV6flag);

      ooStream = new ExObjectOutputStream(sendStream);
      coStream = new ExCallerCipherOutputStream(ooStream);
    }catch (IOException ex){
      Executor.message(CN+"#run:can't create ExObjectOutputStream. Never happen!"
			+ex.getMessage());
      ExCommSessionManager.removeServerTerminal(this);
      return;      
    }

    try{
      objectNumber = oiStream.readInt();
//      proxy  = (OzProxy)(oiStream.readObject());

      for(;;) {
        res = ciStream.readObject();
        if (res == null) {
          getCipher();
          coStream.writeObject(res);
          ooStream.flush();

	  /* Mar. 2nd, 1998.  4 lines added by Nishioka */
	  if (ciStream.CipherType == ExCommCipher.NegotiationStop) {
	      Executor.debug(CN, "run", "Negotiation Stop.  Closing.");
	      close(); // is this required?;
	      return;
	  }
          receiveStream.nextBuffer();
          receiveStream.waitBuffer();

        }
        else {                                  // 交渉の終了
          proxy = (OzProxy)res;
          break;
        }
      }
    } catch (Exception ex){
      /* incomplete invocation data. (maybe SecurityException occured)*/
      Executor.message(CN+"#run(incomplete invocation):"+ex.getClass().getName()
		       +"("+ex.getMessage()+")");
      ExCommSessionManager.removeServerTerminal(this);
      return;
    }

/*
    if(!calleeGol2.localGol)
      {
	calleeGol2.setLocal();
	proxy.gol=calleeGol2.gol;
      }
*/

    finished=false;
    success=false;

    try{
//      Executor.debug(CN+" fork pre");
      fork(proxy);
//      Executor.debug(CN+" fork post: join pre");
      res = join();
//      Executor.debug(CN+" join post");
    } catch (Exception ex){
      if(!clientNotExists)
	{
	  sendStream.setPacketType(ExCommBuffer.OzException);
	  try{
	    ooStream.writeObject(ex);
	  }catch(IOException ex2){
	  }
	  sendStream.setPacketType(ExCommBuffer.OzExceptionTail);
	}
      close();
      return;
    }
    return;
  }

  /***
   * routine to handle SecurityException while encoding result/exception
   */
  private void treatSecurityException(){
    SecurityException sex = new SecurityException("Security violation while encoding object as result\n");
    int ipV6flag = (sessionId.ipV6)? ExCommBuffer.IPv6SessionId : 0;

    if(sendStream.packetTransmitted)
      sendStream.flushIncompleteData();
    else
      sendStream.reset();

    sendStream.setPacketType(ExCommBuffer.OzException|ipV6flag);
    try{
      ooStream.writeObject(sex);
    }catch(Exception ex1){
    }
    sendStream.setPacketType(ExCommBuffer.OzExceptionTail|ipV6flag);
    close();  
  }
  
  /***
   * close streams.
   */
  private void close(){
    try{
      sendStream.close();
      receiveStream.close();
    } catch (Exception ex){
    }

    ExCommSessionManager.removeServerTerminal(this);
  }

  /***
   * get session id.
   */
  public ExSessionId getSessionId(){
    return sessionId;
  }

  /***
   * notify Error from ExSendPort.
   */
  public void notifyError(int errorCode){
    clientNotExists=true;
  }

  /***
   * put a received buffer from ExReceivePort.
   */
  public void putReceiveBuffer(ExReceiveBuffer buf){
    int packetType;

    packetType = buf.getPacketType();

    Executor.debug(CN+"#putReceiveBuffer: packetType = " + packetType);

    if(packetType == ExCommBuffer.OzAbort)
      {
	try{
	  kill();
	} catch(Exception ex){
	  /* what to do? */
	}

	ExCommBuffer.freeExReceiveBuffer(buf);
      }
    else
      receiveStream.putBuffer(buf);
  }

  /***
   * 暗号化方式をアウト側へ渡す
   */
  public void getCipher(){
    coStream.CipherType = ciStream.CipherType;
    coStream.CipherName = ciStream.CipherName;
    /* Feb. 16th, 1998.  1 line is added by Nishioka */
    coStream.cipher = ciStream.cipher;
  }

  /* Feb. 17th, 1998. getCallerOzHome() is added by Nishioka */
  /**
   * このチャネルを生成するグローバルメソッド起動を行った
   * セルのオーナの OZ ホーム ID を返す。
   */
  public String getCallerOzHome() throws OzCipherException {
    if (ciStream.cipher != null) {
      String caller = ciStream.cipher.getCaller();
      if (caller != null) {
	return caller;
      }
    }
    return OzCipher.Nobody;
  }
}

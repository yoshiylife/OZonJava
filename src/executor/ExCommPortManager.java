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
 * ExCommPortManager.java, v1.2 2-Feb-1997
 */
/* Update history */
/* 2-Feb-1997: Modify connection management */

package JP.go.ipa.oz.system;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * ExCommPortManager: Communication Port Manager<br>
 * manages ports(sockets and their controller) for communication.<br>
 * An executor holds an accept port for connection acception,
 * several send ports for data transmission and several receive
 * port for data reception <br>
 *
 * @see ExAcceptPort
 * @see ExSendPort
 * @see ExReceivePort
 */
final class ExCommPortManager{
  private static final String CN="ExCommPortManager";

  /***
   * port to accept
   */
  static ExAcceptPort acceptPort;
  static Thread acceptThread;

  /***
   * Table of ExSendPorts. ExSendPorts are stored with ExCommAddress as key.
   */
  static Dictionary sendPorts= new Hashtable(8,0.5f);

  /***
   * Table of ExReceivePorts. ExReceivePorts are stored with ExCommAddress as key.
   */
  static Dictionary receivePorts = new Hashtable(8,0.5f);

  /* Connection control */
  /**
   * Maximum number of connections kept for long. 
   */
  static int SendConnectionKeep=3;

  /**
    * Maximum number of connections to held at a time
    */ 
  static int SendConnectionMax=5;


  static int ReceiveConnectionKeep=3;
  static int ReceiveConnectionMax=6;

  /* connections is used only for synchronization purpose */
  static Hashtable connections = new Hashtable(16,0.5f);

  /**
    * Number of ExSendSockets which has connected socket.
    */
  static int connectedSendSockets=0;

  /**
    * Number of ExReceiveSockets which has connected socket.
    */
  static int connectedReceiveSockets=0;

  /**
    * Constructor of ExCommPortmanager.
    * @param ServerSocket which accept connections to the executor 
    */
  ExCommPortManager(ServerSocket s){
    acceptPort = new ExAcceptPort(s);
    
    /* startup thread(s) */
    acceptThread=new Thread(ExCommManager.communicationThreads,acceptPort);
    acceptThread.start();
  }


  /***
    * Add new reciver port to the table.<BR>
    * This method is used by class ExAcceptPort.<br>
    *
    * @param rp ExReceivePort to be added.
    * @return ExReceivePort given as parameter.
    *
    * @see ExAcceptPort
    * @see ExReceivePort
    * @see removeReceivePort
    */
  static synchronized ExReceivePort AddNewReceivePort(ExReceivePort rp){
      receivePorts.put(rp.source,rp);
      return rp;
  }

  /***
    * Add new send port to the table.<br>
    *
    * @param rp ExSendPort to be added.
    * @return ExSendPort given as parameter.
    *
    * @see ExSendPort class
    * @see findSendPort()
    * @see removeSendPort()
    */
  static final synchronized ExSendPort AddNewSendPort(ExSendPort rp){
      sendPorts.put(rp.destination,rp);
      return rp;
  }


  /***
   * search ExSendPort to desired address.<br>
   * Search ExSendPort from the table sendPorts and if found returns it,
   * otherwise it trys to create new ExSendPort to desired destination
   * and if successed, returns it otherwise returns null.<br>
   *
   * @param addr desired destination addrss of ExSendPort.
   * @param terminal ExSessionTerminal which uses the ExSendPort.
   * @return ExSendPort if found or created, otherwise null.
   *
   * @see ExSendPort
   * @see addNewSendPort()
   * @see removeSendPort()
   */
  static final synchronized ExSendPort findSendPort(ExCommAddress addr,ExSessionTerminal terminal){
    ExSendPort p;
    
    p = (ExSendPort)(sendPorts.get(addr));

    if(p!=null)
      { /* exist already */
	p.addTerminal(terminal);
	return(p);
      }
    else
      {
	p = new ExSendPort(addr);
	try{
	  p.connect();
	} catch (Exception ex) {
	  p = null;
	  return null;
	}
	p.addTerminal(terminal);
	new Thread(ExCommManager.communicationThreads,p).start();
	AddNewSendPort(p);
	Executor.debug("ExCommPortManager#findSendPort: new ExSendPort is created (to "+addr.toString()+")");
	return p;
      }
  }

  /***
   * remove ExRecievePort from the table receivePorts.<br>
   * This method is invoked when ExReceivePort is closed.
   * @param p ExReceivePort to be removed.
   *
   * @see ExReceivePort
   */
  static synchronized final void removeReceivePort(ExReceivePort p){

    receivePorts.remove(p.source);
    return;
  }

  /***
   * remove ExSendPort from the table sendPorts.<br>
   * This method is invoked when ExSendPort is closed.
   * @param p ExSendPort to be removed.
   *
   * @see ExSendPort
   */
  static final synchronized void removeSendPort(ExSendPort p){

    sendPorts.remove(p.destination);
    return;
  }

  /* connection management */
  /**
   * Incerement number of connected send socket.<br>
   * This method is used for connection management among ExSendPorts.
   *
   * @see ExSendPort
   */ 
  static final void incrementConnectedSendSockets()
    {
      synchronized(connections)
	{
	  connectedSendSockets++;
	}
    }

  /**
   * Decerement number of connected send socket.<br>
   * This method is used for connection management among ExSendPorts.
   *
   * @see ExSendPort
   */ 
  static final void decrementConnectedSendSockets()
    {
      synchronized(connections)
	{
	  connectedSendSockets--;
	}
    }
  
  /**
   * Incerement number of connected receive socket.<br>
   * This method is used for connection management among ExReceivePorts.
   *
   * @see ExReceivePort
   */ 
  static final void incrementConnectedReceiveSockets()
    {
      synchronized(connections)
	{
	  connectedSendSockets++;
	}
    }

  /**
   * Decerement number of connected receive socket.<br>
   * This method is used for connection management among ExReceivePorts.
   *
   * @see ExReceivePort
   */ 
  static final void decrementConnectedReceiveSockets()
    {
      synchronized(connections)
	{
	  connectedSendSockets--;
	}
    }

  /**
   * Shutdown ports. Close all connections and sockets!
   */
  static synchronized final void shutdown(){
    acceptThread.interrupt();
    acceptPort.shutdown();
    
    Enumeration enum;
    ExSendPort sp;
    ExReceivePort rp;

/*
    enum=sendPorts.elements();
    while(enum.hasMoreElements())
      {
	sp = (ExSendPort)enum.nextElement();
	sp.shutdown();
      }
*/

    enum=receivePorts.elements();
    while(enum.hasMoreElements())
      {
	rp = (ExReceivePort)enum.nextElement();
	rp.shutdown();
      }

    enum=sendPorts.elements();
    while(enum.hasMoreElements())
      {
	sp = (ExSendPort)enum.nextElement();
	sp.shutdown();
      }

    
    class ExCommWaiter{
      int timer;
      ExCommWaiter(int i)
	{ timer = i; }
      synchronized void sleep()
	{
	  try{
	    wait(timer);
	  }catch(Exception ex){
	  }
	}
    }

    ExCommWaiter w=new ExCommWaiter(1000);
    w.sleep();
  }

  static synchronized final void notifySendConnectionMayBeClosed()
    {
    Enumeration enum;
    ExSendPort sp;
      
    Executor.debug(CN,"notifySendConditionMayBeClosed"," Invoked");
    enum=sendPorts.elements();
    while(enum.hasMoreElements())
      {
	sp = (ExSendPort)enum.nextElement();
	sp.checkDisconnection();
      }
  }
}

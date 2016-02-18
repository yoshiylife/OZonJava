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
 * $Id: ExCommSessionManager.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 */

package JP.go.ipa.oz.system;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * ExCommSessionManager: Communication Session Manager<BR>
 * manages session terminals for communication.<BR>
 * Currently ExRemoteCallerChannel and ExRemoteCalleeChannel are
 * session terminals.
 *
 * @see ExSessionTerminal
 * @see ExRemoteCallerChannel
 * @see ExRemoteCalleeChannel
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yoichi Hamazaki
 */
final class ExCommSessionManager{
  private static final String CN="ExCommSessionManager";

  /**
   * Dictionary of server-side ExSessionTerminals.<br> 
   * In the case of method invocation,
   * ExRemoteCallerChannel is server-side ExSessionTerminal.<br>
   * ExSessionTerminals are stored with ExSessionId as key.
   * 
   * @see ExSessionId
   */ 
  static Dictionary serverTerminals = new Hashtable(16,0.5f);
  
  /***
   * Dictionary of client-side ExSessionTerminals. <BR>
   * In the case of method invocation,
   * ExRemoteCalleeChannel is client-side ExSessionTerminal.<br>
   * ExSessionTerminals are stored with ExSessionId as key.
   * 
   * @see ExSessionId
   */ 
  static Dictionary clientTerminals = new Hashtable(16,0.5f);

  /**
   * create server terminal according to the packet type.
   *
   * @param packetType packet type of initial packet.
   * @param firstBuffer ExReceiveBuffer of initial packet.
   * @exception throws ExUnknowInitialPacketException if packet type is not
   ExCommBuffer.OzCallRequest.
   */
  static void newServerTerminal(int packetType,
				       ExReceiveBuffer firstBuffer)
    throws ExCommIllegalPacketException{
      ExSessionId sessionId;

      sessionId = firstBuffer.getSessionId();

      switch(packetType){ /* packet type dependant operations */
	/* OzCallRequest */
      case 0x50000100:
      case 0x58000100:
	ExRemoteCallerChannel newCaller;
	newCaller = new ExRemoteCallerChannel(firstBuffer);
	new Thread(ExCommManager.communicationThreads,
		   newCaller).start();
	registerServerTerminal(sessionId,newCaller);
	break;
      default:
	throw new ExCommIllegalPacketException("Unknow packet :"+ExCommMiscConvert.intToHexString(packetType));
      }
    }

  /***
   * register server-side terminal to the hash table.
   * @param sessinoId ExSessionId of the terminal.
   * @param terminal ExSessionTerminal to be registerd
   */
  static void registerServerTerminal(ExSessionId sessionId,ExSessionTerminal terminal){
    synchronized(serverTerminals){ // add to terminals table
				     serverTerminals.put(sessionId,terminal);
				 }
  }

  /***
   * register client-side terminal to the hash table.
   * @param sessinoId ExSessionId of the terminal.
   * @param terminal ExSessionTerminal to be registerd
   */
  static void registerClientTerminal(ExSessionId sessionId,ExSessionTerminal terminal){
    synchronized(clientTerminals){ // add to terminals table
				     clientTerminals.put(sessionId,terminal);
				 }
  }


  /***
   * unregister server-side terminal from the hash table.
   * @param terminal ExSessionTerminal to be unregisterd
   */
  static void removeServerTerminal(ExSessionTerminal terminal){
    synchronized(serverTerminals){ // remove from terminals table
				     serverTerminals.remove(terminal.getSessionId());
				 }
  }

  /***
   * unregister client-side terminal from the hash table.
   * @param terminal ExSessionTerminal to be unregisterd
   */
  static void removeClientTerminal(ExSessionTerminal terminal){
    synchronized(clientTerminals){ // remove from terminals table
				     clientTerminals.remove(terminal.getSessionId());
				 }
  }


  /***
   * pass an ExReceiveBuffer to client-side terminal.
   * @param buffer ExReceiveBuffer to be passed to client-side terminal.
   */
  static void toClientTerminal(ExReceiveBuffer buffer)
    {
      ExSessionTerminal terminal;
      ExSessionId sessionId = buffer.getSessionId();
//Executor.message("get:"+clientTerminals.get(sessionId)+" containsKey:"+clientTerminals.containsKey(sessionId)+" size:"+clientTerminals.size());
      terminal = (ExSessionTerminal)(clientTerminals.get(sessionId));
      if(terminal != null)
	terminal.putReceiveBuffer(buffer);
      else{
	Executor.message("ExCommSystem#toClientTreminal:message arrived with unknown session id "
			   + sessionId
			   +" terminals: "+ clientTerminals.toString());
	ExCommBuffer.freeExReceiveBuffer(buffer);
      }
    }

  /***
   * pass an ExReceiveBuffer to server-side terminal.
   * @param buffer ExReceiveBuffer to be passed to client-side terminal.
   */
  public static void toServerTerminal(ExReceiveBuffer buffer)
    {
      ExSessionTerminal terminal;
      ExSessionId sessionId = buffer.getSessionId();

      terminal = (ExSessionTerminal)(serverTerminals.get(sessionId));
      if(terminal != null)
	terminal.putReceiveBuffer(buffer);
      else{
	Executor.message("ExCommSystem#toServerTerminal:message arrived with unknown session id "
			   + buffer.getSessionId()
			   + " terminals: "+serverTerminals.toString());
	ExCommBuffer.freeExReceiveBuffer(buffer);
      }
    }

}

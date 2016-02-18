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
 * $Id: ExReceivePort.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 */
package JP.go.ipa.oz.system;

import java.io.*;
import java.net.*;
import java.util.*;

/***
 * class ExReceivePort: Communication port for reception.
 * This class implement Runnable, and the thread receives 
 * a packet, makes an ExReceiveBuffer from it and passes the ExReceiveBuffer
 * to appropreate ExSessionTerminal, and repeat again and again.
 *
 * @see ExSendPort
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yoichi Hamazaki
 */
final class ExReceivePort implements Runnable{
  /**
   * Address of OzSendPort to which the ExReceivePort is connected 
   */
  public ExCommAddress source;

  
  /**
   * Socket for receiving packets
   */
  Socket socket;
  
  InputStream inStream;
  OutputStream outStream;

  Thread t;

  private static String CN="ExReceivePort";
  /***
   * Create a ExReceivePort which use the specified socket
   * @param s the specified socket
   */
  ExReceivePort(Socket s)
    {
      socket=s;
      source = new ExCommAddress(socket.getInetAddress(),socket.getPort(),0);
      Executor.debug(CN+" created with socket from "+source.toString());
      inStream=null;
      outStream=null;
    }
  
  /***
   * Receive packets and transfer them to the destination OzCommunicationTerminal.
   */
  public final void run(){
    int size,offset,i,datasize,packetType,headerSize;
    byte[] buffer;
    ExReceiveBuffer receiveBuffer;

    Executor.debug(CN+"#run: daemon started");
    t = Thread.currentThread();

    // initialize
      try{
	inStream = socket.getInputStream();
	outStream = socket.getOutputStream();
      }catch (IOException ex){
	Executor.debug(CN+"#run: stream close");
	close();
	return;
      }

      i=0;

      for(;;){
//	       buffer = new byte[ExCommBuffer.BufferSize];
buffer = ExCommBuffer.getReceiveBuffer();

	       /* receive packet type (first four byte)*/
	       for(size=4,offset=0;size>0;)
		 {
		   try{
		     i = inStream.read(buffer,offset,size);
		   }catch (IOException ex){
		     reportException(ex);
		       close();
		     // handle exception
		   }
		     
		   if(i<=0){
		     Executor.debug("ExReceivePort is closed!");
		     ExCommPortManager.notifySendConnectionMayBeClosed();
		     close();
		     return;
		   } else {
		     size -= i;
		     offset += i;
		   }
		 }
	       
	       packetType = ExCommMiscConvert.bytesToInt(buffer,0);
	       headerSize=(ExCommBuffer.IsIPv6SessionId(packetType))? 
		 ExCommBuffer.HeaderSizeV6 :
		   ExCommBuffer.HeaderSizeV4;

	       Executor.debug(CN+"#run: packet type is "+ExCommMiscConvert.intToHexString(packetType)+"init?"+ExCommBuffer.IsInitialPacket(packetType));

	       /* receive rest of header */
	       for(size=headerSize-4,offset=4;size>0;)
		 {
// Executor.debug("Receive header: size,offset = "+size+","+offset);
		   try{
		     i = inStream.read(buffer,offset,size);
		   }catch (IOException ex){
		     reportException(ex);
		     close();
		   }
		     
		   if(i<0){
		     reportUnexpectedEOS();
		     close();
		     return;
		   } else {
		     size -= i;
		     offset += i;
		   }
		 }
	       
// Executor.debug(CN+"#run header received");
	       if(ExCommBuffer.IsHeadOnly(packetType))
		 { /* treat header only packets */
		   if(packetType == ExCommBuffer.ExPing)
		     {
OzSystem.println("ping packet received");
		       ExCommBuffer.freeReceiveBuffer(buffer);
		       /* ignore ping packet (do nothing) */
		       // Executor.debug("ping received");
		     }
		 }
	       else
		 {
		   // receive body
		     for(size=ExCommMiscConvert.bytesToInt(buffer,ExCommBuffer.SizeOffset),
			 offset=headerSize;size>0;)
		       {
Executor.debug("Receive body, size,offset = "+size+","+offset);
			 try{
			   i = inStream.read(buffer,offset,size);
			 }catch (IOException ex){
			   reportException(ex);
			   close();
			 }
			 
			 if(i<0){
			   if(offset != 0)
			     reportUnexpectedEOS();
			   close();
			   return;
			 } else {
			   size -= i;
			   offset += i;
			 }
		       }
//Executor.debug(CN+"#run body received. Now a packet is in a buffer");
//ExCommMiscConvert.hexDump(buffer,0,offset);

		   receiveBuffer = new ExReceiveBuffer(buffer);

//	       Executor.debug(CN+"#run: packet type is "+ExCommMiscConvert.intToHexString(packetType)+"init?:"+ExCommBuffer.IsInitialPacket(packetType));

		   if(ExCommBuffer.IsInitialPacket(packetType))
		     { /* initial packet */
//Executor.debug("InitialPacketReceived!");
		       try {
			 ExCommSessionManager.newServerTerminal(packetType,receiveBuffer);
		       }catch(ExCommException ex){
			 Executor.debug("ExReceivePort: packet discarded"+ex.getMessage());
		       }
		     }
		   else if(ExCommBuffer.IsClientToServer(packetType))
		     { /* ClientToServer. pass packet to server terminal */
		       // Executor.debug(CN+"#run C->S packet");
		       ExCommSessionManager.toServerTerminal(receiveBuffer);
		     }
		   else
		     { // ServerToClient. pass packet to client terminal
			 // Executor.debug(CN+"#run S->C packet");
			 ExCommSessionManager.toClientTerminal(receiveBuffer);
		     }
		 }
	       
	     } // end of infinite daemon loop
	       
  }
  
  /***
   * close socket and removed.
   */
  final void close(){
      try{
	socket.close();
	inStream.close();
	outStream.close();
      }catch (Exception exx){
	// ignore exceptions
      }

    ExCommPortManager.removeReceivePort(this);
    return;
  }

  static byte[] closeRequest={0x45,0x6e,0x64};

  /**
   * inform closure of socket to sender side.
   */
  final void closeByReceiveSide(){
    try{
      outStream.write(closeRequest);
      outStream.flush();
    }catch (IOException ex){
      Executor.debug(CN,"closeByReceiveSide","exception ",ex);
    }
    t.interrupt();
  }

  final void shutdown(){
    closeByReceiveSide();
  }

  /***
   * report Unexpected end-of-stream.
   * shuld be changed to record to log.
   */
  final void reportUnexpectedEOS(){
    Executor.syslog(CN,"reportUnexpectedEOS","Unexpected end-of-stream detected",null);  
  }

  /***
   * report exception.
   * shuld be changed to record to log.
   */
  final void reportException(Exception ex){
    Executor.syslog(CN,"reportException","Exception occured at receive port",ex);  
  }

}

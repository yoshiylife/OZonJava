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
* OutputStream for ExSendTerminal.
*/
final class ExSendStream extends OutputStream {
  private String CN="ExSendStream";

  ExSendPort port;
  ExSendBuffer buf;
  ExCommAddress dest_address;
  ExSessionTerminal terminal;
  public int packetType;
  int headerSize;
  int initialCapacity;

  boolean packetTransmitted=false;

  
  /***
   * construct with destination and other parameters.
   * @param dest destination address.
   * @param term ExSessionTerminal which use this ExSendStream.
   * @param initailPacketType packet type of first packet.
   * @exception ExCommConnectionFailureException will be raised if connection to
   dest is failed.
   */
  ExSendStream(ExCommAddress dest,
	       ExSessionTerminal term,
	       int initialPacketType)
    throws ExCommConnectionFailureException
      {
	buf=null;
	if((port = ExCommPortManager.findSendPort(dest,term))==null)
	  {
	    throw new ExCommConnectionFailureException();
	  }
	dest_address = dest;
	terminal = term;
	packetType = initialPacketType;
	headerSize = (ExCommBuffer.IsIPv6SessionId(packetType))?
	  ExCommBuffer.HeaderSizeV6 : ExCommBuffer.HeaderSizeV4;
	initialCapacity = ExCommBuffer.BufferSize - headerSize;

	buf = allocSendBuffer();
      }
  
  /***
   * reset to initial state (discard old buffer, and allocate new one)
   */
  final void reset(){
    ExCommBuffer.freeExSendBuffer(buf);
    buf = allocSendBuffer();
  }

  /***
   * write a byte
   */
  public final void write(int c){
    buf.write(c);
    putToSendPortIfFull();
  }

  /***
   * write bytes
   */
  public final void write(byte b[]){
    write(b,0,b.length);
  }

  /***
   * write bytes with offset and size.
   */
  public final void write(byte b[],int offset, int size){
    int cap;

    for(;size>0;)
      {
	cap = buf.capacity();
	if(size < cap)
	  {
	    buf.write(b,offset,size);
	    size=0;
	  }
	else if(size == cap)
	  {
	    buf.write(b,offset,size);
	    putToSendPort();
	    size=0;
	  }
	else
	  {
	    buf.write(b,offset,cap);
	    putToSendPort();
	    size -= cap;
	    offset += cap;
	  }
      }
  }

  /***
   * flush buffer. Contents of buffer is sent if buffer is not empty.
   */
  public final void flush(){
    if(buf.capacity() < initialCapacity)
      { /* senf if data exist in buffer */
	putToSendPort();
      }
  }

  final void flushIncompleteData(){
Executor.message((buf==null)? "buf is null" : buf.toString());
    buf.setEndOfIncompleteBlockFlag();
    putToSendPort();
  }

  final void flushLast(){
    buf.setEndOfStreamFlag();
    putToSendPort();
  }

  final void setEndOfStreamFlag(){
    buf.setEndOfStreamFlag();
  }

  final void abort(){
    if(buf != null)
      ExCommBuffer.freeExSendBuffer(buf);

    buf=null;
    port.removeTerminal(terminal);
    port=null;
  }


  /***
   * close. Contents of buffer is sent if buffer is not empty.
   */
  public final void close(){

   if(buf==null)
      {
	Executor.message("ExSendStream#close may be called again (BUG!)"+this);
Thread.currentThread().dumpStack();
	return;
      }
   else
     {
       if(buf.capacity() < initialCapacity)
	 {
	   buf.setDataSize();
	   buf.setEndOfStreamFlag();
	   port.putSendBuffer(buf);
	 }
       else
	 {
	   ExCommBuffer.freeExSendBuffer(buf);
	 }
       buf=null;
     }
    port.removeTerminal(terminal);
    port=null;
  }

  /***
   * close. Contents of buffer is not sent.
   */
  public final void closeWithoutSend(){

   if(buf==null)
      {
	Executor.message("ExSendStream#closeWithoutSend may be called again (BUG!)"+this);
Thread.currentThread().dumpStack();
	return;
      }

    buf=null;
    port.removeTerminal(terminal);
    port=null;
  }

  /***
   * send buffer if buffer is full.
   */
  private final void putToSendPortIfFull(){
    if(buf.capacity() ==0)
      putToSendPort();
  }

  /***
   * send buffer.
   */
  private final void putToSendPort(){

	packetTransmitted=true;
	buf.setDataSize();
	port.putSendBuffer(buf);
	buf = allocSendBuffer();
  }

  /***
   * allocate new buffer.
   */
  private final ExSendBuffer allocSendBuffer(){
    ExSendBuffer newBuf;

    newBuf = ExCommBuffer.getExSendBuffer();
    newBuf.writeInt(packetType);
    newBuf.writeInt(0); /* place keeper for size */
    newBuf.setPacketType(packetType);
    try{
      newBuf.write(terminal.getSessionId().getId());
    } catch (IOException ex){
      /* exception never occured! */
      Executor.message(CN+"#allocSendBuffer: error occured at write"+ex.getMessage());
   }
    return newBuf;
  }

  /***
   * set packet type of buffer
   */
  final void setPacketType(int newPacketType){
    packetType = newPacketType;
    buf.setPacketType(newPacketType);
  }

}

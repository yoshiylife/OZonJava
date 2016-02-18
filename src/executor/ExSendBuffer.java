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
 * buffer for send
 */
class ExSendBuffer extends ByteArrayOutputStream {
  /**
    * link to next ExSendBuffer. (to make list of buffers)
    *
    */
  ExSendBuffer next=null;
  private int packetType;
  int headerSize;

  /***
   * construct buffer with default size ExCommBuffer.BufferSize.
   */
  ExSendBuffer()
    {
      super(ExCommBuffer.BufferSize);
    }

  ExSendBuffer(byte[] buffer,int size)
    {
      buf=buffer;
      count=size;
    }

  /**
   * Reset buffer for reuse.
   */
  public void reset()
    {
      next=null;
      super.reset();
    }

  /***
   * capacity to put more.
   */
  int capacity(){
    return buf.length - count;
  }

  /***
   * write integer
   */
  void writeInt(int i){
    write( (i >> 24)& 0x000000ff);
    write( (i >> 16)& 0x000000ff);
    write( (i >> 8)& 0x000000ff);
    write( i & 0x000000ff);
  }

  /***
   * write long integer
   */
  void writeLong(long l){
    write((int)( (l >> 56)& 0x000000ffL) );
    write((int)( (l >> 48)& 0x000000ffL) );
    write((int)( (l >> 40)& 0x000000ffL) );
    write((int)( (l >> 32)& 0x000000ffL) );
    write((int)( (l >> 24)& 0x000000ffL) );
    write((int)( (l >> 16)& 0x000000ffL) );
    write((int)( (l >> 8)& 0x000000ffL) );
    write((int)( l & 0x000000ffL) );
  }

  /***
   * set data size in the packet header.
   */
  void setDataSize(){
    int size = count - headerSize;

//Executor.message("ExSendBuffer#setDataSize size=count-headerSize ="+count+"-"+headerSize);
    buf[ExCommBuffer.SizeOffset] = (byte)((size >>24) & 0x000000ff);
    buf[ExCommBuffer.SizeOffset+1] = (byte)((size >>16) & 0x000000ff);
    buf[ExCommBuffer.SizeOffset+2] = (byte)((size >>8) & 0x000000ff);
    buf[ExCommBuffer.SizeOffset+3] = (byte)(size  & 0x000000ff);
  }

  /***
   * set packet type in the packet header.
   */
  void setPacketType(int type){
    packetType=type;
    headerSize = (ExCommBuffer.IsIPv6SessionId(packetType))?
      ExCommBuffer.HeaderSizeV6 :
	ExCommBuffer.HeaderSizeV4;
    buf[0] = (byte)((packetType >>24) & 0x000000ff);
    buf[1] = (byte)((packetType >>16) & 0x000000ff);
    buf[2] = (byte)((packetType >>8) & 0x000000ff);
    buf[3] = (byte)(packetType  & 0x000000ff);
  }

  /***
   * set EndOfStreamPacket bit in packet type
   */
  void setEndOfStreamFlag(){
    setPacketType(packetType | ExCommBuffer.EndOfStreamPacket);
  }

  /***
   * set EndOfIncompleteBlockPacket bit in packet type
   */
  void setEndOfIncompleteBlockFlag(){
    setPacketType(packetType | ExCommBuffer.EndOfIncompleteBlockPacket);
  }

  /***
   * dump contents of buffer for debug.
   */
  void dump(int size){
    ExCommMiscConvert.hexDump(buf,0,size);
  }
}

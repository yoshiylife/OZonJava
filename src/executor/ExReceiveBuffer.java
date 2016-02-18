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
 * buffer for reception
 */
class ExReceiveBuffer extends ByteArrayInputStream{

  /**
   * link to next ExReceiveBuffer. (to make list of buffers)
   *
   */
  ExReceiveBuffer next=null;

  int packetType;
  private boolean ipv6;

  /***
   * construct with contents of buffer.
   * @param contests contents of buffer.
   */
  ExReceiveBuffer(byte[] contents)
    {
      super(contents);
      next=null;
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
   * extract packet type from buffer.
   * @return packet type
   */
  int getPacketType(){
    return (packetType=ExCommMiscConvert.bytesToInt(buf,0));
  }

  /***
    * extract size of packet's body from buffer.
    * @return size of packet's body in bytes.
    */
  int getDataSize(){
    return (ExCommMiscConvert.bytesToInt(buf,ExCommBuffer.SizeOffset));
  }
  
  /***
    * extract session id from buffer.
    * @return session id of this packet.
    */
  ExSessionId getSessionId(){
    if(ExCommBuffer.IsIPv6SessionId(packetType))
      return new ExSessionId(buf,ExCommBuffer.SessionIdOffset,
			     ExCommBuffer.IPv6SessionIdSize,0);
    else
      return new ExSessionId(buf,ExCommBuffer.SessionIdOffset,
			     ExCommBuffer.IPv4SessionIdSize,0);
  }

  /***
   * skip header part of packet.
   */
  void skipHeader(){
    if(ExCommBuffer.IsIPv6SessionId(packetType))
      skip((long)ExCommBuffer.HeaderSizeV6);
    else
      skip((long)ExCommBuffer.HeaderSizeV4);
  }

  /* for debug */
  void dump(int size){ 
    Executor.message("ExReceiveBuffer#dump:count="+count+" pos="+pos);
    ExCommMiscConvert.hexDump(buf,0,size);
  }

  byte[] getBuf(){
    return buf;
  }

}

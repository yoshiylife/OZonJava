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

/**
* class of buffer used for communication.
* Buffer recycling and definitions of packet headers and macro-like finctions
* included.
*
* @author Yoichi Hamazaki
*/
final class ExCommBuffer{

  /**
   * Upper limit size of buffer.
   */
  static final int BufferSize = 1024;

  /**
   * Size of Header which consists PacketType(int),DataSize(int)and SessionId(8 bytes(IPv4) or 20 bytes(IPv6)).
   */
  static final int IPv4SessionIdSize=8;
  static final int IPv6SessionIdSize=20;
  static final int HeaderSizeV4 = IPv4SessionIdSize+8;
  static final int HeaderSizeV6 = IPv6SessionIdSize+8;

  /**
   * Offset of DataSize from top.
   */
  static final int SizeOffset = 4;

  /**
   * Offset of SessionId from top.
   */
  static final int SessionIdOffset = 8;

  /**
   * Bit for HeaderOnlyPacket flag. 
   * If this flag is set, the packet contains header only (no data body).<br>
   * IsAlive packet is an example of this type.
   */
  static final int HeaderOnlyPacket  = 0x80000000;

  /**
   * Bit for InitialPacket flag.
   * If this flag is set, the packet is the first packet of a communication session.
   */
  static final int InitialPacket   = 0x40000000;

  /** 
   * Bit for PacketTail flag. 
   * If this flag is set, the packet is the last packet of the communication session.
   */
  static final int EndOfSessionPacket = 0x20000000;

  /**
   * Bit for PacketDirection flag. 
   * If this flag is set, the direction of packet transfer is as same as the initial packet of the session.
   */
  static final int PacketDirection = 0x10000000;

  /**
   * Bit for EndOfStream flag. 
   * If this flag is set, the packet is the last packet of the stream.(Not necessarily end of session)
   */
  static final int EndOfStreamPacket = 0x08000000;

  /**
   * Bit for IPv6SessionId flag. 
   * If this flag is set, the session id in the header is represented in IPv6 format(20bytes), otherwise IPv4 format(8bytes).
   */
  static final int IPv6SessionId = 0x04000000;

  /**
   * Bit for EndOfIncompleteBlock flag.
   * If this flag is set, the packet is the last packet of data block which
   * terminated incompletely. Incomplete data block may be created if
   * error occured while data created.
   *  (SecurityException while object serialization is an typical example of the case.)
   */
  static final int EndOfIncompleteBlockPacket = 0x02000000;

  /**
   * Reserved for future use.
   */
  static final int Reserved_7 = 0x01000000;

  /**
   * Bitmask for packet kind.
   */
  static final int PacketKindMask  = 0x0000ffff;

  /**
   * Bitmask for packet flags.
   */
  static final int PacketFlagsMask  = 0xff000000;

  /**
   * Bitmask for encription flags.
   */
  static final int PacketCryptoFlagsMask = 0x00ff0000;

  /**
   * Check packet is HeaderOnly or not.
   * @return true if packet consists of header only.
   */
  static final boolean IsHeadOnly(int packetType){
    return ((packetType & HeaderOnlyPacket) != 0);
  }

  /**
   * Check packet is initial packet or not.<br>
   *
   * @return true if packet is initial packet.
   */
  static final boolean IsInitialPacket(int packetType){
    return ((packetType & InitialPacket) != 0);
  }

  /**
   * Check packet is end of session packet or not.<br>
   *
   * @return true if packet is end of session packet.
   */
  static final boolean IsEndOfSessionPacket(int packetType){
    return ((packetType & EndOfSessionPacket) != 0);
  }

  /**
   * Check packet transfer direction.<br>
   *
   * @return true if packet is send from client to server direction.
   */
  static final boolean IsClientToServer(int packetType){
    return ((packetType & PacketDirection) != 0);
  }

  /**
   * Check packet is end of stream packet or not.<br>
   *
   * @return true if packet is end of stream packet.
   */
  static final boolean IsEndOfStreamPacket(int packetType){
    return ((packetType & EndOfStreamPacket) != 0);
  }

  /**
   * Check packet is end of stream packet or not.<br>
   *
   * @return true if packet is end of incomplete block packet.
   */
  static final boolean IsEndOfIncompleteBlockPacket(int packetType){
    return ((packetType & EndOfIncompleteBlockPacket) != 0);
  }

  /**
   * Check packet header has IPv6 format session id or not.<br>
   *
   * @return true if packet header has IPv6 format session id(20bytes).
   */
  static final boolean IsIPv6SessionId(int packetType){
    return ((packetType & IPv6SessionId) != 0);
  }

  static final int OzCallInitial     = 0x50000100;
  static final int OzCallInitialLast = 0x58000100;
  static final int OzCall            = 0x10000100;
  static final int OzCallLast        = 0x18000100;
  static final int OzAbort           = 0x90000101;
  static final int OzResult          = 0x00000102;
  static final int OzResultTail      = 0x28000102;
  static final int OzException       = 0x00000103;
  static final int OzExceptionTail   = 0x28000103;
  static final int OzCipher          = 0x00000104;

  static final int ExPing        =  0xd8000000; /* head_only,initial,CtoS */
  static final int ExPingResponse = 0x80000000;

  /***
    * buffer pool
    */
  static final int maximumBufferKeep=64;
  static ExSendBuffer sendBufferPool=null;
  static byte[][] receiveArrayPool= new byte[maximumBufferKeep][];
  static int sendBufferPoolSize=0;
  static int receiveBufferPoolSize=0;


static int freeCountS=0;
static int getCountS=0;
  /* Buffer management */
  /**
   * get an ExSendBuffer from recycle pool of ExSendBuffer<br>
   * If pool is empty, newly constructed object is returned.
   */
  static final synchronized ExSendBuffer getExSendBuffer()
    { ExSendBuffer b;
      Executor.debug("getExSendBuffer "+sendBufferPoolSize+" "+getCountS++);
      if(sendBufferPoolSize>0){
	b=sendBufferPool;
	sendBufferPool=b.next;
	sendBufferPoolSize--;
	b.reset();
	return b;
      }
      else
	return new ExSendBuffer();
      }

  /**
   * put a used ExSendBuffer into recycle pool of ExSendBuffer<br>
   * If pool is full, object will be freed(may be GCed later).
   */
  static final synchronized void freeExSendBuffer(ExSendBuffer b)
    {
      Executor.debug("freeExSendBuffer "+sendBufferPoolSize+" "+freeCountS++);
      if(sendBufferPoolSize<maximumBufferKeep)
	{
	  b.next=sendBufferPool;
	  sendBufferPool=b;
	  sendBufferPoolSize++;
	}
      else
	b.next=null;
    }

  static int getCount=0;
  /**
   * put a used receive buffer (byte[BufferSize]) into recycle pool.
   */
  static final synchronized void freeReceiveBuffer(byte[] b)
    {
      Executor.debug("freeReceiveBuffer "+receiveBufferPoolSize+" "+getCount++);
      if(receiveBufferPoolSize<maximumBufferKeep)
	{
	  receiveArrayPool[receiveBufferPoolSize++]=b;
	}
    }

  /**
   * free an ExReceiveBuffer. It's buffer may be kept in recycle pool.
   */
  static final void freeExReceiveBuffer(ExReceiveBuffer buffer)
    {
      Executor.debug("freeExReceiveBuffer ");
      freeReceiveBuffer(buffer.getBuf());
      buffer.next=null;
    }

  static int freeCount=0;
  /**
   * get a receive buffer from recycle pool.
   * If pool is empty, newly constructed object will be returned.
   */
  static final synchronized byte[] getReceiveBuffer()
    {
      Executor.debug("getReceiveBuffer "+receiveBufferPoolSize+" "+freeCount++);
      if(receiveBufferPoolSize>0){
	return receiveArrayPool[--receiveBufferPoolSize];
      }
      else
	return new byte[BufferSize];
    }
}

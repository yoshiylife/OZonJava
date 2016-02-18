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
import java.lang.*;

/***
 * input stream for ExSessionTerminal.
 */
final class ExReceiveStream extends InputStream {
  private static String CN="ExReceiveStream";

  /**
   * Top of buffer queue.
   */
  ExReceiveBuffer buf;

  boolean endOfStreamFlag=false;
  boolean endOfIncompleteBlockFlag=false;
  boolean endOfIncompleteBlockFlag2=false;

  boolean Signaled = false;
  int     toDo;

  /**
   * Put ExReceiveBuffer as input of this stream.<br>
   * Threads which wait buffer will be notified by this method.
   */
  synchronized final void putBuffer(ExReceiveBuffer rbuf)
    {
      int type;

      rbuf.skipHeader();
      if(buf==null)
	buf=rbuf;
      else
	{
	  ExReceiveBuffer b,bb;
	  for(b=buf;b.next != null ;bb=b,b=bb.next)
	    ;
	  b.next = rbuf;
	}
      //rbuf.dump(166);

      type = buf.getPacketType();
      Signaled = true;
      toDo = ExCommCipher.what;
      if (type == ExCommBuffer.OzResult || type == ExCommBuffer.OzResultTail) {
        toDo = ExCommCipher.Exe;
      }
      else if (type == ExCommBuffer.OzCipher) {
        toDo = ExCommCipher.ReCipher;
      }
      else if (type == ExCommBuffer.OzException || type == ExCommBuffer.OzExceptionTail) {
        toDo = ExCommCipher.Error;
      }

      Executor.debug(CN+"#putBuffer:type = " + type);
      Executor.debug(CN+"#putBuffer:toDo = " + toDo);

      notifyAll();
    }

  synchronized final void senderDown(){
    endOfStreamFlag=true;
    notifyAll();
  }

  /***
   * wait until a buffer available
   */
  synchronized final void waitBuffer() throws InterruptedException{
    while((buf==null) && !endOfStreamFlag)
      {
	try{
	  wait();
	} catch (InterruptedException ex) {
	  throw ex;
	}
      }  
  }

  /***
   * exchange to next buffer and release the buffer already read.
   */
  synchronized final void nextBuffer(){
    ExReceiveBuffer b;

    if(ExCommBuffer.IsEndOfStreamPacket(buf.packetType))
      endOfStreamFlag=true;
    else if(ExCommBuffer.IsEndOfIncompleteBlockPacket(buf.packetType))
      { endOfIncompleteBlockFlag=true;
	endOfIncompleteBlockFlag2=true;
      }

    b = buf;
    buf = buf.next;
    ExCommBuffer.freeExReceiveBuffer(b);
  }
  
  /***
   * read a byte.
   */
  public final int read() throws IOException{
    int i;

    if(endOfStreamFlag)
      return -1;
    else if(endOfIncompleteBlockFlag)
      {
	endOfIncompleteBlockFlag=false;
	return -1;
      }

    if(buf==null)
      {
	try{
	  waitBuffer();
	} catch (InterruptedException ex) {
	  throw new IOException("Interrupted while read in "+CN);
	}
	return buf.read();
      }
    else
      {
	i = buf.read();
	if(buf.available() ==0)
	  {
	    nextBuffer();
	  }
	return i;
      }
  }

  /***
   * Read into an array of bytes. <br>
   * This method will block until
   * some input is available.
   */
  public final int read(byte[] b, int off, int len) throws IOException{
    int i;

    if(endOfStreamFlag)
      return -1;
    else if(endOfIncompleteBlockFlag)
      {
	endOfIncompleteBlockFlag=false;
	return -1;
      }

    if(buf==null)
      {
	try{
	  waitBuffer();
	} catch (InterruptedException ex) {
	  throw new IOException("Interrupted while read in "+CN);
	}
      }

    i =  buf.read(b,off,len);

    if(buf.available() ==0)
      {
	nextBuffer();
      }
    return i;
  }
  

  /***
   * Read into an array of bytes. <br>
   * This method will block until
   * some input is available.
   */
  public final int read(byte[] b) throws IOException{
    return read(b,0,b.length);
  }


  /***
   * mark and reset is not suported in this clsss.
   */
  public final boolean markSupported(){
    return false;
  }

  /***
   * mark and reset is not suported in this clsss.
   */
  public synchronized final void reset() throws IOException{
    throw new IOException(CN+" not support reset()");
  }

  /***
   * mark and reset is not suported in this clsss.
   */
  synchronized final void mark() throws IOException{
    throw new IOException(CN+" not support mark()");
  }

  /**
   * Close stream. If buffer(s) exists, free it(them).
   */
  public synchronized final void close() {
    ExReceiveBuffer b;

    while(buf!=null)
      {
	b = buf;
	buf = buf.next;
	ExCommBuffer.freeExReceiveBuffer(b);
      }
  }


}


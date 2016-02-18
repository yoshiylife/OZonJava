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
/***
 * Misc functions which used in Communication programs
 *
 * @version $Revions$,$Date: 1997/07/15 06:20:46 $
 * @author  Yoichi Hamazaki
 */
/* 
 * $Log: ExCommMiscConvert.java,v $
 * Revision 2.1.1.1  1997/07/15 06:20:46  yoshi
 * Re-newal Executor source
 *
 * Revision 1.1.1.1  1997/05/01 06:24:57  yoshi
 * Executor source for JDK 1.1.1
 *
 * Revision 1.1  1997/04/08 04:51:28  yoshi
 * Name of file for java class is same class name with JDK1.1.1.
 * So, ExCommMisc.java remove, and add ExCommMiscConvert.java.
 * Operated by Yasumitsu yoshida.
 *
 * Revision 1.1.1.1  1996/12/26 06:27:09  nito
 * Executor_1_0
 *
 */
final class ExCommMiscConvert{
  static private String[] hex = {"0","1","2","3","4","5","6","7",
				   "8","9","a","b","c","d","e","f"};
  
  static private byte[] hexByte = {0x30,0x31,0x32,0x33,0x34,0x35,0x36,0x37,
				     0x38,0x39,0x61,062,0x63,0x64,0x65,0x66};

  static String intToHexString(int i){
    int h,shift;
    String str;

    for(str="",shift=28;shift>=0;shift-=4)
      {
	h = (i>>shift) & 0xf;
	str += hex[h];
      }
    return str;
  }

  static String longToHexString(long l){
    int h,shift;
    String str;

    for(str="",shift=60;shift>=0;shift-=4)
      {
	h = (int)((l>>shift) & 0xfL);
	str += hex[h];
      }
    return str;
  }

  static byte[] intToHexBytes(int i){
    int h,shift,j;
    byte b[] = new byte[8];

    for(shift=28,j=0;shift>=0;shift-=4,j++)
      {
	h = (i>>shift) & 0xf;
	b[j]= hexByte[h];
      }
    return b;
  }

  static byte[] longToHexBytes(long l){
    int h,shift,j;
    byte b[] = new byte[16];

    for(shift=60,j=0;shift>=0;shift-=4,j++)
      {
	h = (int)((l>>shift) & 0xfL);
	b[j] = hexByte[h];
      }
    return b;
  }

  static byte[] bytesToHexBytes(byte[] bb){
    int h,h1,h2,j,l;
    byte b[];

    l = bb.length;
    b = new byte[l*2];
    for(j=0;j<l;j++)
      {
	h=bb[j];
	h1 = (h>>4)&0xf;
	h2 = h & 0xf;
	b[j*2]=hexByte[h1];
	b[j*2+1]=hexByte[h2];
      }
    return b;
  }

  static synchronized void hexDump(byte[] b, int offset, int count){
    int i,uh,lh,off,c,u;
    StringBuffer sb=new StringBuffer();

    for(c=count,off=offset,u=0;c>0;off++, c--,u++)
      {
	i = (int)(b[off]);
	uh = (i>>4) & 0x0f;
	lh = i & 0x0f;
	sb.append(hex[uh]+hex[lh]+",");

	if( (u%16)==15)
	  {
	    Executor.message(sb.toString());
	    sb=new StringBuffer();
	  }
      }
	  Executor.message(sb.toString());
  }


  static synchronized int bytesToInt(byte[] buf,int offset){
    return ((((int)(buf[offset+0])<<24) & 0xff000000) |
	    (((int)(buf[offset+1])<<16) & 0x00ff0000) |
	    (((int)(buf[offset+2])<<8) & 0x0000ff00) |
	    ((int)(buf[offset+3]) & 0x000000ff)) ;
  }

  static synchronized long bytesToLong(byte[] buf,int offset){
    return ((((long)(buf[offset])<<56) & 0xff00000000000000L) |
	    (((long)(buf[offset+1])<<48) & 0x00ff000000000000L) |
	    (((long)(buf[offset+2])<<40) & 0x0000ff0000000000L) |
	    (((long)(buf[offset+3])<<32) & 0x000000ff00000000L) |
	    (((long)(buf[offset+4])<<24) & 0x00000000ff000000L) |
	    (((long)(buf[offset+5])<<16) & 0x0000000000ff0000L) |
	    (((long)(buf[offset+6])<<8) & 0x000000000000ff00L) |
	    ((long)(buf[offset+7]) & 0x00000000000000ffL)) ;
  }

}


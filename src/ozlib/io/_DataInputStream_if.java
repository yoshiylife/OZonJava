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
 * $Id: _DataInputStream_if.java,v 1.4 1997/06/12 09:50:03 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public interface _DataInputStream_if
extends _DataInput_if, _FilterInputStream_if
{
    public int read(_ByteArray_if arg_a) throws Exception;
    public int read(_ByteArray_if arg_a, int arg_b, int arg_c) throws Exception;
    public void readFully(_ByteArray_if arg_a) throws Exception;
    public void readFully(_ByteArray_if arg_a, int arg_b, int arg_c) 
    	throws Exception; 
    public int skipBytes(int arg_a) throws Exception;
    public boolean readBoolean() throws Exception;
    public byte readByte() throws Exception;
    public int readUnsignedByte() throws Exception;
    public short readShort() throws Exception;
    public int readUnsignedShort() throws Exception;
    public char readChar() throws Exception;
    public int readInt() throws Exception;
    public long readLong() throws Exception;
    public float readFloat() throws Exception;
    public double readDouble() throws Exception;

// deprecated but keep
    public _String_if readLine() throws Exception;

    public _String_if readUTF() throws Exception;
    public _String_if readUTF(_DataInput_if arg_a) throws Exception;
    		 
}

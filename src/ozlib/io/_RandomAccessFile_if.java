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
 * $Id: _RandomAccessFile_if.java,v 1.3 1997/06/16 05:30:47 xsun Exp $
 */

package JP.go.ipa.oz.lib.standard;

public interface _RandomAccessFile_if
extends _DataOutput_if, _DataInput_if
{
  
    public _FileDescriptor_if getFD() throws Exception;
    public int read() throws Exception;
    public int read(_ByteArray_if arg_a, int arg_b, int arg_c) throws Exception;
    public int read(_ByteArray_if arg_a) throws Exception;
    public void readFully(_ByteArray_if arg_a) throws Exception;
    public void readFully(_ByteArray_if arg_a, int arg_b, int arg_c) throws Exception;
    public int skipBytes(int arg_a) throws Exception;
    public void write(int arg_a) throws Exception;
    public void write(_ByteArray_if arg_a) throws Exception;
    public void write(_ByteArray_if arg_a, int arg_b, int arg_c) throws Exception;
    public long getFilePointer() throws Exception;
    public void seek(long arg_a) throws Exception;
    public long length() throws Exception;
    public void close() throws Exception;
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
    public _String_if readLine() throws Exception;
    public _String_if readUTF() throws Exception;
    public void writeBoolean(boolean arg_a) throws Exception;
    public void writeByte(int arg_a) throws Exception;
    public void writeShort(int arg_a) throws Exception;
    public void writeChar(int arg_a) throws Exception;
    public void writeInt(int arg_a) throws Exception;
    public void writeLong(long arg_a) throws Exception;
    public void writeFloat(float arg_a) throws Exception;
    public void writeDouble(double arg_a) throws Exception;
    public void writeBytes(_String_if arg_a) throws Exception;
    public void writeChars(_String_if arg_a) throws Exception;
    public void writeUTF(_String_if arg_a) throws Exception;
}

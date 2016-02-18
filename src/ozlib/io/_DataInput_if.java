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
 * $Id: _DataInput_if.java,v 1.5 1997/06/12 09:50:03 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public interface _DataInput_if
extends JP.go.ipa.oz.lang._Root_if
{
    public java.lang.Object _java();
    public abstract void readFully(_ByteArray_if arg_a) 
    	throws Exception;
    public abstract void readFully(_ByteArray_if arg_a, int arg_b, int arg_c) 
    	throws Exception;
    public abstract int skipBytes(int arg_a) throws Exception;
    public abstract boolean readBoolean() throws Exception;
    public abstract byte readByte() throws Exception;
    public abstract int readUnsignedByte() throws Exception;
    public abstract short readShort() throws Exception;
    public abstract int readUnsignedShort() throws Exception;
    public abstract char readChar() throws Exception;
    public abstract int readInt() throws Exception;
    public abstract long readLong() throws Exception;
    public abstract float readFloat() throws Exception;
    public abstract double readDouble() throws Exception;
//readLine imprements deprecated, but keep
    public abstract _String_if readLine() throws Exception;
    public abstract _String_if readUTF() throws Exception;
}

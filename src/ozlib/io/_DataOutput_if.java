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
 * $Id: _DataOutput_if.java,v 1.4 1997/06/12 10:41:07 xsun Exp $
 */

package JP.go.ipa.oz.lib.standard;

public interface _DataOutput_if
extends JP.go.ipa.oz.lang._Root_if
{
    public abstract void write(int arg_a) throws Exception;
    public abstract void write(_ByteArray_if arg_a) throws Exception;
    public abstract void write(_ByteArray_if arg_a, int arg_b, int arg_c) throws Exception;
    public abstract void writeBoolean(boolean arg_a) throws Exception;
    public abstract void writeByte(int arg_a) throws Exception;
    public abstract void writeShort(int arg_a) throws Exception;
    public abstract void writeChar(int arg_a) throws Exception;
    public abstract void writeInt(int arg_a) throws Exception;
    public abstract void writeLong(long arg_a) throws Exception;
    public abstract void writeFloat(float arg_a) throws Exception;
    public abstract void writeDouble(double arg_a) throws Exception;
    public abstract void writeBytes(_String_if arg_a) throws Exception;
    public abstract void writeChars(_String_if arg_a) throws Exception;
    public abstract void writeUTF(_String_if arg_a) throws Exception;
}

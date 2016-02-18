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
 * $Id: _ObjectOutputStream_if.java,v 1.1 1997/07/25 05:00:47 hgoto Exp $
*/
package JP.go.ipa.oz.lib.standard;

public interface _ObjectOutputStream_if
extends _ObjectOutput_if, _OutputStream_if
{
    public void writeObject(JP.go.ipa.oz.lang._Root_if arg_a) throws Exception;
    public void defaultWriteObject() throws Exception;
    public void reset() throws Exception;
    public void write(int arg_a) throws Exception;
    public void write(_ByteArray_if arg_a) throws Exception;
    public void write(_ByteArray_if arg_a, int arg_b, int arg_c) throws Exception;
    public void flush() throws Exception;
    public void close() throws Exception;
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

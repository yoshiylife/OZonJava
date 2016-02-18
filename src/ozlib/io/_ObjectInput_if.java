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
 * $Id: _ObjectInput_if.java,v 1.1 1997/07/25 05:00:46 hgoto Exp $
*/
package JP.go.ipa.oz.lib.standard;

public interface _ObjectInput_if
extends _DataInput_if
{
    public abstract JP.go.ipa.oz.lang._Root_if readObject() throws Exception;
    public abstract int read() throws Exception;
    public abstract int read(_ByteArray_if arg_a) throws Exception;
    public abstract int read(_ByteArray_if arg_a, int arg_b, int arg_c) throws Exception;
    public abstract long skip(long arg_a) throws Exception;
    public abstract int available() throws Exception;
    public abstract void close() throws Exception;
}

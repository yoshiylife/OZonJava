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
 * $Id: _PushbackReader_if.java,v 1.3 1997/06/16 05:30:47 xsun Exp $
*/

package JP.go.ipa.oz.lib.standard;

public interface _PushbackReader_if
extends _FilterReader_if
{
 
    public int read() throws Exception;
    public int read(_CharArray_if arg_a, int arg_b, int arg_c) throws Exception;
    public void unread(int arg_a) throws Exception;
    public void unread(_CharArray_if arg_a, int arg_b, int arg_c) throws Exception;
    public void unread(_CharArray_if arg_a) throws Exception;
    public boolean ready() throws Exception;
    public boolean markSupported() throws Exception;
    public void close() throws Exception;
}

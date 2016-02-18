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
 * $Id: _BufferedWriter_if.java,v 1.4 1997/06/12 11:05:11 xsun Exp $
 */

package JP.go.ipa.oz.lib.standard;

public interface _BufferedWriter_if
extends _Writer_if
{
 
    public void write(int arg_a) throws Exception;
    public void write(_CharArray_if arg_a, int arg_b, int arg_c) throws Exception;
    public void write(_String_if arg_a, int arg_b, int arg_c) throws Exception;
    public void newLine() throws Exception;
    public void flush() throws Exception;
    public void close() throws Exception;
}

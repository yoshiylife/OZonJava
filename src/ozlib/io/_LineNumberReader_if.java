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
 *  $Id: _LineNumberReader_if.java,v 1.3 1997/06/16 05:30:47 xsun Exp $
*/

package JP.go.ipa.oz.lib.standard;

public interface _LineNumberReader_if
extends _BufferedReader_if
{
    
    public void setLineNumber(int arg_a) throws Exception;
    public int getLineNumber() throws Exception;
    public int read() throws Exception;
    public int read(_CharArray_if arg_a, int arg_b, int arg_c) throws Exception;
    public _String_if readLine() throws Exception;
    public long skip(long arg_a) throws Exception;
    public void mark(int arg_a) throws Exception;
    public void reset() throws Exception;
}

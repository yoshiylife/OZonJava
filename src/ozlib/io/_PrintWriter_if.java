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
 * $Id: _PrintWriter_if.java,v 1.4 1997/06/16 05:30:47 xsun Exp $
*/


package JP.go.ipa.oz.lib.standard;

public interface _PrintWriter_if
extends _Writer_if
{
 
    public void flush() throws Exception;
    public void close() throws Exception;
    public boolean checkError() throws Exception;
    public void write(int arg_a) throws Exception;
    public void write(_CharArray_if arg_a, int arg_b, int arg_c) throws Exception;
    public void write(_CharArray_if arg_a) throws Exception;
    public void write(_String_if arg_a, int arg_b, int arg_c) throws Exception;
    public void write(_String_if arg_a) throws Exception;
    public void print(boolean arg_a) throws Exception;
    public void print(char arg_a) throws Exception;
    public void print(int arg_a) throws Exception;
    public void print(long arg_a) throws Exception;
    public void print(float arg_a) throws Exception;
    public void print(double arg_a) throws Exception;
    public void print(_CharArray_if arg_a) throws Exception;
    public void print(_String_if arg_a) throws Exception;
    public void print(JP.go.ipa.oz.lang._Root_if arg_a) throws Exception;
    public void println() throws Exception;
    public void println(boolean arg_a) throws Exception;
    public void println(char arg_a) throws Exception;
    public void println(int arg_a) throws Exception;
    public void println(long arg_a) throws Exception;
    public void println(float arg_a) throws Exception;
    public void println(double arg_a) throws Exception;
    public void println(_CharArray_if arg_a) throws Exception;
    public void println(_String_if arg_a) throws Exception;
    public void println(JP.go.ipa.oz.lang._Root_if arg_a) throws Exception;
}

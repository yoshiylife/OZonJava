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
 * $Id: _StringBuffer_if.java,v 1.3 1997/06/25 12:16:59 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public interface _StringBuffer_if extends JP.go.ipa.oz.lang._Root_if {
    public int length();
    public int capacity();
    public void ensureCapacity(int arg_a);
    public void setLength(int arg_a); 
    public char charAt(int arg_a);
    public void getChars(int arg_a, int arg_b, _CharArray_if arg_c, int arg_d);
    public void setCharAt(int arg_a, char arg_b);
    public _StringBuffer_if append(JP.go.ipa.oz.lang._Root_if arg_a) throws Exception;
    public _StringBuffer_if append(_String_if arg_a);
    public _StringBuffer_if append(_CharArray_if arg_a);
    public _StringBuffer_if append(_CharArray_if arg_a, int arg_b, int arg_c);
    public _StringBuffer_if append(boolean arg_a);
    public _StringBuffer_if append(char arg_a);
    public _StringBuffer_if append(int arg_a);
    public _StringBuffer_if append(long arg_a);
    public _StringBuffer_if append(float arg_a);
    public _StringBuffer_if append(double arg_a);
    public _StringBuffer_if insert(int arg_a, JP.go.ipa.oz.lang._Root_if arg_b) throws Exception;
    public _StringBuffer_if insert(int arg_a, _String_if arg_b);
    public _StringBuffer_if insert(int arg_a, _CharArray_if arg_b);
    public _StringBuffer_if insert(int arg_a, boolean arg_b);
    public _StringBuffer_if insert(int arg_a, char arg_b);
    public _StringBuffer_if insert(int arg_a, int arg_b);
    public _StringBuffer_if insert(int arg_a, long arg_b);
    public _StringBuffer_if insert(int arg_a, float arg_b);
    public _StringBuffer_if insert(int arg_a, double arg_b);
    public _StringBuffer_if reverse();
    public _String_if asString();
}

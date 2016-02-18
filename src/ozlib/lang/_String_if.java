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
 * $Id: _String_if.java,v 1.6 1997/09/08 11:06:53 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public interface _String_if extends JP.go.ipa.oz.lang._Root_if {

    public int length();
    public char charAt(int arg_a);
    public void getChars(int arg_a, int arg_b, _CharArray_if arg_c, int arg_d);

// deprecated
//    public void getBytes(int, int, _ByteArray, int);

    public _ByteArray_if getBytes(_String_if arg_a) throws Exception;
    public _ByteArray_if getBytes();

    public boolean isequal(JP.go.ipa.oz.lang._Root_if arg_a);

    public boolean equalsIgnoreCase(_String_if arg_a);
    public int compareTo(_String_if arg_a);
    public boolean regionMatches(int arg_a, _String_if arg_b, int arg_c, int arg_d);
    public boolean regionMatches(boolean arg_a, int arg_b, _String_if arg_c, int arg_d, int arg_e);
    public boolean startsWith(_String_if arg_a, int arg_b);
    public boolean startsWith(_String_if arg_a);
    public boolean endsWith(_String_if arg_a);
//    public int hashCode();
    public int indexOf(int arg_a);
    public int indexOf(char arg_a);
    public int indexOf(int arg_a, int arg_b);
    public int indexOf(char arg_a, int arg_b);
    public int lastIndexOf(int arg_a);
    public int lastIndexOf(char arg_a);
    public int lastIndexOf(int arg_a, int arg_b);
    public int lastIndexOf(char arg_a, int arg_b);
    public int indexOf(_String_if arg_a);
    public int indexOf(_String_if arg_a, int arg_b);
    public int lastIndexOf(_String_if arg_a);
    public int lastIndexOf(_String_if arg_a, int arg_b);
    public _String_if substring(int arg_a);
    public _String_if substring(int arg_a, int arg_b);
    public _String_if concat(_String_if arg_a);
    public _String_if replace(char arg_a, char arg_b);
    public _String_if toLowerCase(_Locale_if arg_a);
    public _String_if toLowerCase();
    public _String_if toUpperCase(_Locale_if arg_a);
    public _String_if toUpperCase();
    public _String_if trim();
    public _String_if asString();
    public _CharArray_if toCharArray();
    public _String_if valueOf(JP.go.ipa.oz.lang._Root_if arg_a) throws Exception;
    public _String_if valueOf(_CharArray_if arg_a);
    public _String_if valueOf(_CharArray_if arg_a, int arg_b, int arg_c);
    public _String_if copyValueOf(_CharArray_if arg_a, int arg_b, int arg_c);
    public _String_if copyValueOf(_CharArray_if arg_a);
    public _String_if valueOf(boolean arg_a);
    public _String_if valueOf(char arg_a);
    public _String_if valueOf(int arg_a);
    public _String_if valueOf(long arg_a);
    public _String_if valueOf(float arg_a);
    public _String_if valueOf(double arg_a);

//    public native String intern();

    public boolean parseBoolean();
    public byte parseByte() throws Exception;
    public byte parseByte(int arg_a) throws Exception;
    public short parseShort() throws Exception;
    public short parseShort(int arg_a) throws Exception;
    public int parseInt() throws Exception;
    public int parseInt(int arg_a) throws Exception;
    public long parseLong() throws Exception;
    public long parseLong(int arg_a) throws Exception;
    public float parseFloat() throws Exception;
    public double parseDouble() throws Exception;

    public java.lang.String toString();
}

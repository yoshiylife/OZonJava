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
 * $Id: _String_cl.java,v 1.6 1997/09/08 11:06:53 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public final
class _String_cl extends JP.go.ipa.oz.lang._Root_cl implements _String_if {
    java.lang.String _body;

    public _String_cl() {
    }

    // public for _String_cl("ABC")
    public _String_cl(java.lang.String arg_a) {
	_body = arg_a;
    }

    public Object _new_breed() {
	_body = new java.lang.String();
	return this;
    }

    public Object _new_breed(_String_if arg_a) {
	_body = new java.lang.String((java.lang.String)((_String_cl)arg_a)._body);
	return this;
    }

    public Object _new_breed(_CharArray_if arg_a) {
	_body = new java.lang.String((char[])((_CharArray_cl)arg_a)._body);
	return this;
    }

    public Object _new_breed(_CharArray_if arg_a, int arg_b, int arg_c) {
	_body = new java.lang.String((char[])((_CharArray_cl)arg_a)._body,
			arg_b, arg_c);
	return this;
    }

// deprecated
//    public Object _new_breed(_ByteArray_if, int, int, int)

// deprecated
//    public Object _new_breed(_ByteArray_if, int)


    public Object _new_breed(_ByteArray_if arg_a, int arg_b, int arg_c, _String_if arg_d) 
	throws Exception {
	try {
	    _body = new java.lang.String((byte[])((_ByteArray_cl)arg_a)._body,
			arg_b, arg_c, (java.lang.String)((_String_cl)arg_d)._body);
	} catch (java.io.UnsupportedEncodingException ex_a) {
	    _UnsupportedEncodingException_if ex
		= (_UnsupportedEncodingException_cl)new _UnsupportedEncodingException_cl()._new_init(ex_a.getMessage());
	    throw new JP.go.ipa.oz.lang.OzException(ex);
	}
	return this;
    }

    public Object _new_breed(_ByteArray_if arg_a, _String_if arg_b)
	throws Exception {
	try {
	    _body = new java.lang.String((byte[])((_ByteArray_cl)arg_a)._body,
			(java.lang.String)((_String_cl)arg_b)._body);
	} catch (java.io.UnsupportedEncodingException ex_a) {
	    _UnsupportedEncodingException_if ex
		= (_UnsupportedEncodingException_cl)new _UnsupportedEncodingException_cl()._new_init(ex_a.getMessage());
	    throw new JP.go.ipa.oz.lang.OzException(ex);
	}
	return this;
    }

    public Object _new_breed(_ByteArray_if arg_a, int arg_b, int arg_c) {
	_body = new java.lang.String((byte[])((_ByteArray_cl)arg_a)._body,
			arg_b, arg_c);
	return this;
    }

    public Object _new_breed(_ByteArray_if arg_a) {
	_body = new java.lang.String((byte[])((_ByteArray_cl)arg_a)._body);
	return this;
    }

    public Object _new_breed(_StringBuffer_if arg_a) { 
	_body = new java.lang.String((java.lang.StringBuffer)((_StringBuffer_cl)arg_a)._body);
	return this;
    }
    
    public int length() {
	checkSecureInvocation();

	int ret;
	ret  = _body.length();
	return ret;
    }

    public char charAt(int arg_a) {
	checkSecureInvocation();

	char ret;
	ret = _body.charAt(arg_a);
	return ret;
    }

    public void getChars(int arg_a, int arg_b, _CharArray_if arg_c, int arg_d) {
	checkSecureInvocation();

	_body.getChars(arg_a, arg_b, (char[])((_CharArray_cl)arg_c)._body, arg_d);
    }

// deprecated
//    public void getBytes(int, int, _ByteArray_if, int)


    public _ByteArray_if getBytes(_String_if arg_a) throws Exception {
	checkSecureInvocation();

	byte	work[];
	_ByteArray_cl ret;
	try {
	    work = _body.getBytes((java.lang.String)((_String_cl)arg_a)._body);
	} catch (java.io.UnsupportedEncodingException ex_a) {
	    _UnsupportedEncodingException_if ex
		= (_UnsupportedEncodingException_cl)new _UnsupportedEncodingException_cl()._new_init(ex_a.getMessage());
	    throw new JP.go.ipa.oz.lang.OzException(ex);
	}
	ret = new _ByteArray_cl(work);
	return ret;
    }

    public _ByteArray_if getBytes() {
	checkSecureInvocation();

	byte	work[];
	_ByteArray_cl ret;
	work = _body.getBytes();
	ret = new _ByteArray_cl(work);
	return ret;
    }

    public boolean isequal(JP.go.ipa.oz.lang._Root_if arg_a) {
	checkSecureInvocation();

	if (arg_a instanceof _String_cl) {
		boolean ret;
		ret = _body.equals(((_String_cl)arg_a)._body);
		return ret;
	} else {
		return false;
	}
    }

    public boolean equalsIgnoreCase(_String_if arg_a) {
	checkSecureInvocation();
	boolean ret;
	ret = _body.equalsIgnoreCase((java.lang.String)((_String_cl)arg_a)._body);	
	return ret;
    }

    public int compareTo(_String_if arg_a) {
	checkSecureInvocation();

	int ret;
	ret = _body.compareTo((java.lang.String)((_String_cl)arg_a)._body);	
	return ret;
    }

    public boolean regionMatches(int arg_a, _String_if arg_b, int arg_c, int arg_d) {
	checkSecureInvocation();

	boolean ret;
	ret = _body.regionMatches(arg_a, (java.lang.String)((_String_cl)arg_b)._body, arg_c, arg_d);	
	return ret;
    }

    public boolean regionMatches(boolean arg_a, int arg_b, _String_if arg_c,
	int arg_d, int arg_e) {
	checkSecureInvocation();

	boolean ret;
	ret = _body.regionMatches(arg_a, arg_b, (java.lang.String)((_String_cl)arg_c)._body, arg_d, arg_e);	
	return ret;
    }

    public boolean startsWith(_String_if arg_a, int arg_b) {
	checkSecureInvocation();

	boolean ret;
	ret = _body.startsWith((java.lang.String)((_String_cl)arg_a)._body, arg_b);
	return ret;
    }

    public boolean startsWith(_String_if arg_a) {
	checkSecureInvocation();

	boolean ret;
	ret = _body.startsWith((java.lang.String)((_String_cl)arg_a)._body);
	return ret;
    }

    public boolean endsWith(_String_if arg_a) {
	checkSecureInvocation();

	boolean ret;
	ret = _body.endsWith((java.lang.String)((_String_cl)arg_a)._body);
	return ret;
    }
/*
    public int hashCode() {
	checkSecureInvocation();

	int ret;
	ret = _body.hashCode();
	return ret;
    }
*/
    public int indexOf(int arg_a) {
	checkSecureInvocation();

	int ret;
	ret = _body.indexOf(arg_a);
	return ret;
    }

    public int indexOf(char arg_a) {
	return indexOf((int)arg_a);
    }

    public int indexOf(int arg_a, int arg_b) {
	checkSecureInvocation();

	int ret;
	ret = _body.indexOf(arg_a, arg_b);
	return ret;
    }

    public int indexOf(char arg_a, int arg_b) {
	return indexOf((int)arg_a, arg_b);
    }

    public int lastIndexOf(int arg_a) {
	checkSecureInvocation();

	int ret;
	ret = _body.lastIndexOf(arg_a);
	return ret;
    }

    public int lastIndexOf(char arg_a) {
	return lastIndexOf((int)arg_a);
    }

    public int lastIndexOf(int arg_a, int arg_b) {
	checkSecureInvocation();

	int ret;
	ret = _body.lastIndexOf(arg_a, arg_b);
	return ret;
    }

    public int lastIndexOf(char arg_a, int arg_b) {
	return lastIndexOf((int)arg_a, arg_b);
    }

    public int indexOf(_String_if arg_a) {
	checkSecureInvocation();

	int ret;
	ret = _body.indexOf((java.lang.String)((_String_cl)arg_a)._body);
	return ret;
    }

    public int indexOf(_String_if arg_a, int arg_b) {
	checkSecureInvocation();

	int ret;
	ret = _body.indexOf((java.lang.String)((_String_cl)arg_a)._body, arg_b);
	return ret;
    }

    public int lastIndexOf(_String_if arg_a) {
	checkSecureInvocation();

	int ret;
	ret = _body.lastIndexOf((java.lang.String)((_String_cl)arg_a)._body);
	return ret;
    }

    public int lastIndexOf(_String_if arg_a, int arg_b) {
	checkSecureInvocation();

	int ret;
	ret = _body.lastIndexOf((java.lang.String)((_String_cl)arg_a)._body, arg_b);
	return ret;
    }

    public _String_if substring(int arg_a) {
	checkSecureInvocation();

	_String_cl ret;
	ret = new _String_cl(_body.substring(arg_a));
	return ret;
    }

    public _String_if substring(int arg_a, int arg_b) {
	checkSecureInvocation();

	_String_cl ret;
	ret = new _String_cl(_body.substring(arg_a, arg_b));
	return ret;
    }

    public _String_if concat(_String_if arg_a) {
	checkSecureInvocation();

	java.lang.String result =_body.concat((java.lang.String)((_String_cl)arg_a)._body);
	if (result == _body) {
	    return this;
	} else {
	    return (new _String_cl(result));
	}
    }

    public _String_if replace(char arg_a, char arg_b) {
	checkSecureInvocation();

	java.lang.String result =_body.replace(arg_a, arg_b);
	if (result == _body) {
	    return this;
	} else {
	    return (new _String_cl(result));
	}
    }

    public _String_if toLowerCase(_Locale_if arg_a) {
	checkSecureInvocation();

	_String_cl ret;
	ret = new _String_cl(_body.toLowerCase(((_Locale_cl)arg_a)._body));
        return ret;
    }

    public _String_if toLowerCase() {
	checkSecureInvocation();

	_String_cl ret;
	ret = new _String_cl(_body.toLowerCase());
        return ret;
    }

    public _String_if toUpperCase(_Locale_if arg_a) {
	checkSecureInvocation();

	_String_cl ret;
	ret = new _String_cl(_body.toUpperCase(((_Locale_cl)arg_a)._body));
        return ret;
    }
    public _String_if toUpperCase() {
	checkSecureInvocation();

	_String_cl ret;
	ret = new _String_cl(_body.toUpperCase());
        return ret;
    }

    public _String_if trim() {
	checkSecureInvocation();

	java.lang.String result = _body.trim();
	if (result == _body) {
	    return this;
	} else {
	    return (new _String_cl(result));
	}
    }

    public _String_if asString() {
	return this;
    }

    public _CharArray_if toCharArray() {
	checkSecureInvocation();

	_CharArray_cl ret = new _CharArray_cl(_body.toCharArray());
	return ret;	
    }

    public  _String_if valueOf(JP.go.ipa.oz.lang._Root_if arg_a) throws Exception {
	checkSecureInvocation();

	return _static_valueOf(arg_a);
    }
    protected static _String_if _static_valueOf(JP.go.ipa.oz.lang._Root_if arg_a) throws Exception {
	if (arg_a == null) {
		return new _String_cl("null");
	}
	return arg_a.asString();
    }

    public  _String_if valueOf(_CharArray_if arg_a) {
	checkSecureInvocation();

	return _static_valueOf(arg_a);
    }
    protected static _String_if _static_valueOf(_CharArray_if arg_a) {
	_String_cl ret;
	ret = new _String_cl(java.lang.String.valueOf((char[])((_CharArray_cl)arg_a)._body));
	return ret;
    }

    public  _String_if valueOf(_CharArray_if arg_a, int arg_b, int arg_c) {
	checkSecureInvocation();

	return _static_valueOf(arg_a, arg_b, arg_c);
    }
    protected static _String_if _static_valueOf(_CharArray_if arg_a, int arg_b, int arg_c) {
	_String_cl ret;
	ret = new _String_cl(java.lang.String.valueOf((char[])((_CharArray_cl)arg_a)._body, arg_b, arg_c));
	return ret;
    }
    
    public  _String_if copyValueOf(_CharArray_if arg_a, int arg_b, int arg_c) {
	checkSecureInvocation();

	return _static_copyValueOf(arg_a, arg_b, arg_c);
    }
    protected static _String_if _static_copyValueOf(_CharArray_if arg_a, int arg_b, int arg_c) {
	_String_cl ret;
	ret = new _String_cl(java.lang.String.copyValueOf((char[])((_CharArray_cl)arg_a)._body, arg_b, arg_c));
	return ret;
    }
    

    public  _String_if copyValueOf(_CharArray_if arg_a) {
	checkSecureInvocation();

	return _static_copyValueOf(arg_a);
    }
    protected static _String_if _static_copyValueOf(_CharArray_if arg_a) {
	_String_cl ret;
	ret = new _String_cl(java.lang.String.copyValueOf((char[])((_CharArray_cl)arg_a)._body));
	return ret;
    }

    public _String_if valueOf(boolean arg_a) {
	checkSecureInvocation();

	return _static_valueOf(arg_a);
    }
    protected static _String_if _static_valueOf(boolean arg_a) {
	_String_cl ret = new _String_cl(java.lang.String.valueOf(arg_a));
	return ret;
    }

    public _String_if valueOf(char arg_a) {
	checkSecureInvocation();

	return _static_valueOf(arg_a);
    }
    protected static _String_if _static_valueOf(char arg_a) {
	_String_cl ret = new _String_cl(java.lang.String.valueOf(arg_a));
	return ret;
    }

    public _String_if valueOf(int arg_a) {
	checkSecureInvocation();

	return _static_valueOf(arg_a);
    }
    protected static _String_if _static_valueOf(int arg_a) {
	_String_cl ret = new _String_cl(java.lang.String.valueOf(arg_a));
	return ret;
    }

    public _String_if valueOf(long arg_a) {
	checkSecureInvocation();

	return _static_valueOf(arg_a);
    }
    protected static _String_if _static_valueOf(long arg_a) {
	_String_cl ret = new _String_cl(java.lang.String.valueOf(arg_a));
	return ret;
    }

    public _String_if valueOf(float arg_a) {
	checkSecureInvocation();

	return _static_valueOf(arg_a);
    }
    protected static _String_if _static_valueOf(float arg_a) {
	_String_cl ret = new _String_cl(java.lang.String.valueOf(arg_a));
	return ret;
    }

    public _String_if valueOf(double arg_a) {
	checkSecureInvocation();

	return _static_valueOf(arg_a);
    }
    protected static _String_if _static_valueOf(double arg_a) {
	_String_cl ret = new _String_cl(java.lang.String.valueOf(arg_a));
	return ret;
    }

//    public native String intern();


    public boolean parseBoolean() {
	boolean var_a;
	checkSecureInvocation();
	return java.lang.Boolean.valueOf(_body).booleanValue();
    }

    public byte parseByte() throws Exception {
	byte var_a;
	checkSecureInvocation();
	try {
	    var_a = java.lang.Byte.parseByte(_body);
	} catch (java.lang.NumberFormatException ex_a) {
	    _NumberFormatException_if oz_number =
		(_NumberFormatException_cl)(new _NumberFormatException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_number);
	}
	return var_a;
    }

    public byte parseByte(int arg_a) throws Exception {
	byte var_a;
	checkSecureInvocation();
	try {
	    var_a = java.lang.Byte.parseByte(_body, arg_a);
	} catch (java.lang.NumberFormatException ex_a) {
	    _NumberFormatException_if oz_number =
		(_NumberFormatException_cl)(new _NumberFormatException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_number);
	}
	return var_a;
    }

    public short parseShort() throws Exception {
	short var_a;
	checkSecureInvocation();
	try {
	    var_a = java.lang.Short.parseShort(_body);
	} catch (java.lang.NumberFormatException ex_a) {
	    _NumberFormatException_if oz_number =
		(_NumberFormatException_cl)(new _NumberFormatException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_number);
	}
	return var_a;
    }

    public short parseShort(int arg_a) throws Exception {
	short var_a;
	checkSecureInvocation();
	try {
	    var_a = java.lang.Short.parseShort(_body, arg_a);
	} catch (java.lang.NumberFormatException ex_a) {
	    _NumberFormatException_if oz_number =
		(_NumberFormatException_cl)(new _NumberFormatException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_number);
	}
	return var_a;
    }

    public int parseInt() throws Exception {
	int var_a;
	checkSecureInvocation();
	try {
	    var_a = java.lang.Integer.parseInt(_body);
	} catch (java.lang.NumberFormatException ex_a) {
	    _NumberFormatException_if oz_number =
		(_NumberFormatException_cl)(new _NumberFormatException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_number);
	}
	return var_a;
    }

    public int parseInt(int arg_a) throws Exception {
	int var_a;
	checkSecureInvocation();
	try {
	    var_a = java.lang.Integer.parseInt(_body, arg_a);
	} catch (java.lang.NumberFormatException ex_a) {
	    _NumberFormatException_if oz_number =
		(_NumberFormatException_cl)(new _NumberFormatException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_number);
	}
	return var_a;
    }

    public long parseLong() throws Exception {
	long var_a;
	checkSecureInvocation();
	try {
	    var_a = java.lang.Long.parseLong(_body);
	} catch (java.lang.NumberFormatException ex_a) {
	    _NumberFormatException_if oz_number =
		(_NumberFormatException_cl)(new _NumberFormatException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_number);
	}
	return var_a;
    }

    public long parseLong(int arg_a) throws Exception {
	long var_a;
	checkSecureInvocation();
	try {
	    var_a = java.lang.Long.parseLong(_body, arg_a);
	} catch (java.lang.NumberFormatException ex_a) {
	    _NumberFormatException_if oz_number =
		(_NumberFormatException_cl)(new _NumberFormatException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_number);
	}
	return var_a;
    }
	
    public float parseFloat() throws Exception {
	float var_a;
	checkSecureInvocation();
	try {
	    var_a = java.lang.Float.valueOf(_body).floatValue();
	} catch (java.lang.NumberFormatException ex_a) {
	    _NumberFormatException_if oz_number =
		(_NumberFormatException_cl)(new _NumberFormatException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_number);
	}
	return var_a;
    }

    public double parseDouble() throws Exception {
	double var_a;
	checkSecureInvocation();
	try {
	    var_a = java.lang.Double.valueOf(_body).doubleValue();
	} catch (java.lang.NumberFormatException ex_a) {
	    _NumberFormatException_if oz_number =
		(_NumberFormatException_cl)(new _NumberFormatException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_number);
	}
	return var_a;
    }

    public final java.lang.String toString() {
//	checkSecureInvocation();
	java.lang.String	ret;
	ret = new java.lang.String(_body);
	return ret;
    }
}

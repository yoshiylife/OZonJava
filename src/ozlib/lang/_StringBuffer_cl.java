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
 * $Id: _StringBuffer_cl.java,v 1.3 1997/06/25 12:16:59 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public final
class _StringBuffer_cl extends JP.go.ipa.oz.lang._Root_cl implements _StringBuffer_if {
    java.lang.StringBuffer _body;

    public _StringBuffer_cl() {
    }

    _StringBuffer_cl(java.lang.StringBuffer arg_a) {
   	_body = arg_a; 
    }

    public Object _new_breed() {
	_body = new java.lang.StringBuffer();
	return this;
    }

    public Object _new_breed(int arg_a) {
	_body = new java.lang.StringBuffer(arg_a);
	return this;
    }

    public Object _new_breed(_String_if arg_a) {
	_body = new java.lang.StringBuffer((java.lang.String)((_String_cl)arg_a)._body);
	return this;
    }

    public int length() {
	checkSecureInvocation();

	int ret;
	ret  = _body.length();
	return ret;
    }

    public int capacity() {
	checkSecureInvocation();

	int ret;
	ret  = _body.capacity();
	return ret;
    }

    public void ensureCapacity(int arg_a) {
	checkSecureInvocation();

	_body.ensureCapacity(arg_a);
    }

    public void setLength(int arg_a) {
	checkSecureInvocation();

	_body.setLength(arg_a);
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

    public void setCharAt(int arg_a, char arg_b) {
	checkSecureInvocation();

	_body.setCharAt(arg_a, arg_b);
    }

    public _StringBuffer_if append(JP.go.ipa.oz.lang._Root_if arg_a) throws Exception {
	checkSecureInvocation();

	if (arg_a == null) {
		return append(new _String_cl("null"));
	}
	return append(arg_a.asString());
    }

    public _StringBuffer_if append(_String_if arg_a) {
	checkSecureInvocation();

	java.lang.StringBuffer result = _body.append((java.lang.String)((_String_cl)arg_a)._body);
	if (result == _body) {
	    return this;
	} else {
	    return (new _StringBuffer_cl(result));
	}
    }

    public _StringBuffer_if append(_CharArray_if arg_a) {
	checkSecureInvocation();

	java.lang.StringBuffer result = _body.append((char[])((_CharArray_cl)arg_a)._body);
	if (result == _body) {
	    return this;
	} else {
	    return (new _StringBuffer_cl(result));
	}
    }

    public _StringBuffer_if append(_CharArray_if arg_a, int arg_b, int arg_c) {
	checkSecureInvocation();

	java.lang.StringBuffer result = _body.append((char[])((_CharArray_cl)arg_a)._body, arg_b, arg_c);
	if (result == _body) {
	    return this;
	} else {
	    return (new _StringBuffer_cl(result));
	}
    }

    public _StringBuffer_if append(boolean arg_a) {
	checkSecureInvocation();

	java.lang.StringBuffer result = _body.append(arg_a);
	if (result == _body) {
	    return this;
	} else {
	    return (new _StringBuffer_cl(result));
	}
    }

    public _StringBuffer_if append(char arg_a) {
	checkSecureInvocation();

	java.lang.StringBuffer result = _body.append(arg_a);
	if (result == _body) {
	    return this;
	} else {
	    return (new _StringBuffer_cl(result));
	}
    }

    public _StringBuffer_if append(int arg_a) {
	checkSecureInvocation();

	java.lang.StringBuffer result = _body.append(arg_a);
	if (result == _body) {
	    return this;
	} else {
	    return (new _StringBuffer_cl(result));
	}
    }

    public _StringBuffer_if append(long arg_a) {
	checkSecureInvocation();

	java.lang.StringBuffer result = _body.append(arg_a);
	if (result == _body) {
	    return this;
	} else {
	    return (new _StringBuffer_cl(result));
	}
    }

    public _StringBuffer_if append(float arg_a) {
	checkSecureInvocation();

	java.lang.StringBuffer result = _body.append(arg_a);
	if (result == _body) {
	    return this;
	} else {
	    return (new _StringBuffer_cl(result));
	}
    }

    public _StringBuffer_if append(double arg_a) {
	checkSecureInvocation();

	java.lang.StringBuffer result = _body.append(arg_a);
	if (result == _body) {
	    return this;
	} else {
	    return (new _StringBuffer_cl(result));
	}
    }

    public _StringBuffer_if insert(int arg_a, JP.go.ipa.oz.lang._Root_if arg_b) throws Exception {
	checkSecureInvocation();

	if (arg_b == null) {
		return insert(arg_a, new _String_cl("null"));
	}
	return insert(arg_a, arg_b.asString());
    }

    public _StringBuffer_if insert(int arg_a, _String_if arg_b) {
	checkSecureInvocation();

	java.lang.StringBuffer result = _body.insert(arg_a, ((_String_cl)arg_b)._body);
	if (result == _body) {
	    return this;
	} else {
	    return (new _StringBuffer_cl(result));
	}
    }

    public _StringBuffer_if insert(int arg_a, _CharArray_if arg_b) {
	checkSecureInvocation();

	java.lang.StringBuffer result = _body.insert(arg_a, (char[])((_CharArray_cl)arg_b)._body);
	if (result == _body) {
	    return this;
	} else {
	    return (new _StringBuffer_cl(result));
	}
    }

    public _StringBuffer_if insert(int arg_a, boolean arg_b) {
	checkSecureInvocation();

	java.lang.StringBuffer result = _body.insert(arg_a, arg_b);
	if (result == _body) {
	    return this;
	} else {
	    return (new _StringBuffer_cl(result));
	}
    }

    public _StringBuffer_if insert(int arg_a, char arg_b) {
	checkSecureInvocation();

	java.lang.StringBuffer result = _body.insert(arg_a, arg_b);
	if (result == _body) {
	    return this;
	} else {
	    return (new _StringBuffer_cl(result));
	}
    }

    public _StringBuffer_if insert(int arg_a, int arg_b) {
	checkSecureInvocation();

	java.lang.StringBuffer result = _body.insert(arg_a, arg_b);
	if (result == _body) {
	    return this;
	} else {
	    return (new _StringBuffer_cl(result));
	}
    }

    public _StringBuffer_if insert(int arg_a, long arg_b) {
	checkSecureInvocation();

	java.lang.StringBuffer result = _body.insert(arg_a, arg_b);
	if (result == _body) {
	    return this;
	} else {
	    return (new _StringBuffer_cl(result));
	}
    }

    public _StringBuffer_if insert(int arg_a, float arg_b) {
	checkSecureInvocation();

	java.lang.StringBuffer result = _body.insert(arg_a, arg_b);
	if (result == _body) {
	    return this;
	} else {
	    return (new _StringBuffer_cl(result));
	}
    }

    public _StringBuffer_if insert(int arg_a, double arg_b) {
	checkSecureInvocation();

	java.lang.StringBuffer result = _body.insert(arg_a, arg_b);
	if (result == _body) {
	    return this;
	} else {
	    return (new _StringBuffer_cl(result));
	}
    }

    public _StringBuffer_if reverse() {
	checkSecureInvocation();

	java.lang.StringBuffer result = _body.reverse();
	if (result == _body) {
	    return this;
	} else {
	    return (new _StringBuffer_cl(result));
	}
    }

    public _String_if asString() {
	checkSecureInvocation();

	_String_cl ret;
	ret = new _String_cl(_body.toString());
	return ret;
    }

}

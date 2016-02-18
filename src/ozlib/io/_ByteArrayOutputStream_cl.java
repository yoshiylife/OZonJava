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
 * $Id: _ByteArrayOutputStream_cl.java,v 1.1 1997/08/08 07:43:46 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public class _ByteArrayOutputStream_cl
    extends _OutputStream_cl
    implements _ByteArrayOutputStream_if
{
    public Object _new_breed() throws Exception
    {
	_body = new java.io.ByteArrayOutputStream();
	return this;
    }

    public Object _new_breed(int arg_a) throws Exception
    {
	int var_a = arg_a;
	_body = new java.io.ByteArrayOutputStream(var_a);
	return this;
    }

    public void write(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	((java.io.ByteArrayOutputStream)_body).write(var_a);
    }

    public void write(_ByteArray_if arg_a, int arg_b, int arg_c) throws Exception
    {
	checkSecureInvocation();
	_ByteArray_cl var_a = (_ByteArray_cl)arg_a;
	int var_b = arg_b;
	int var_c = arg_c;
	((java.io.ByteArrayOutputStream)_body).write((byte[])(var_a._body), var_b, var_c);
    }

    public void writeTo(_OutputStream_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_OutputStream_cl var_a = (_OutputStream_cl)arg_a;
	try {
	    ((java.io.ByteArrayOutputStream)_body).writeTo((java.io.OutputStream)(var_a._body));
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io = 
		(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void reset() throws Exception
    {
	checkSecureInvocation();
	((java.io.ByteArrayOutputStream)_body).reset();
    }

    public _ByteArray_if toByteArray() throws Exception
    {
	checkSecureInvocation();
	byte[] work;
	_ByteArray_cl ret;
	work = ((java.io.ByteArrayOutputStream)_body).toByteArray();
	ret = new _ByteArray_cl(work);
	return ret;
    }

    public int size() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	work = ((java.io.ByteArrayOutputStream)_body).size();
	ret = work;
	return ret;
    }

    public _String_if asString() throws Exception
    {
	checkSecureInvocation();
	java.lang.String work;
	_String_cl ret;
	work = ((java.io.ByteArrayOutputStream)_body).toString();
	ret = new _String_cl(work);
	return ret;
    }

    public _String_if asString(_String_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_String_cl var_a = (_String_cl)arg_a;
	java.lang.String work;
	_String_cl ret;
	try {
	    work = ((java.io.ByteArrayOutputStream)_body).toString((java.lang.String)(var_a._body));
	} catch (java.io.UnsupportedEncodingException ex_a) {
	    _UnsupportedEncodingException_if oz_un = 
		(_UnsupportedEncodingException_cl)( new _UnsupportedEncodingException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_un);
	}
	ret = new _String_cl(work);
	return ret;
    }

    public _ByteArrayOutputStream_cl()
    {
    }

    _ByteArrayOutputStream_cl(java.io.ByteArrayOutputStream arg_a)
    {
	_body = arg_a;
    }

}

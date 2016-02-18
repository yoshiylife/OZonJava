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
 * $Id: _InputStreamReader_cl.java,v 1.5 1997/06/16 05:30:47 xsun Exp $
 */

package JP.go.ipa.oz.lib.standard;

public class _InputStreamReader_cl
    extends _Reader_cl
    implements _InputStreamReader_if
{
    public Object _new_breed(_InputStream_if arg_a) throws Exception
    {
	_InputStream_cl var_a = (_InputStream_cl)arg_a;
	_body = new java.io.InputStreamReader((java.io.InputStream)(var_a._body));
    return this;
    }

    public Object _new_breed(_InputStream_if arg_a, _String_if arg_b) throws Exception
    {
	_InputStream_cl var_a = (_InputStream_cl)arg_a;
	_String_cl var_b = (_String_cl)arg_b;
	try {
	    _body = new java.io.InputStreamReader((java.io.InputStream)(var_a._body), (java.lang.String)(var_b._body));
	} catch (java.io.UnsupportedEncodingException ex_a) {
		_UnsupportedEncodingException_if oz_un = 
			(_UnsupportedEncodingException_cl)( new _UnsupportedEncodingException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_un);
	}
	return this;
    }

    public _String_if getEncoding() throws Exception
    {
	checkSecureInvocation();
	java.lang.String work;
	_String_cl ret;
	work = ((java.io.InputStreamReader)_body).getEncoding();
	if (work == null) return null;
	ret = new _String_cl(work);
	return ret;
    }

    public int read() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	try {
	    work = ((java.io.InputStreamReader)_body).read();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public int read(_CharArray_if arg_a, int arg_b, int arg_c) throws Exception
    {
	checkSecureInvocation();
	_CharArray_cl var_a = (_CharArray_cl)arg_a;
	int var_b = arg_b;
	int var_c = arg_c;
	int work;
	int ret;
	try {
	    work = ((java.io.InputStreamReader)_body).read((char[])(var_a._body), var_b, var_c);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public boolean ready() throws Exception
    {
	checkSecureInvocation();
	boolean work;
	boolean ret;
	try {
	    work = ((java.io.InputStreamReader)_body).ready();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public void close() throws Exception
    {
	checkSecureInvocation();
	try {
	    ((java.io.InputStreamReader)_body).close();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public _InputStreamReader_cl()
    {
    }

    _InputStreamReader_cl(java.io.InputStreamReader arg_a)
    {
	_body = arg_a;
    }

}

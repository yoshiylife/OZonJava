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
 * $Id: _OutputStreamWriter_cl.java,v 1.3 1997/06/16 05:30:47 xsun Exp $
 */

package JP.go.ipa.oz.lib.standard;

public class _OutputStreamWriter_cl
    extends _Writer_cl
    implements _OutputStreamWriter_if
{
    public Object _new_breed(_OutputStream_if arg_a, _String_if arg_b) throws Exception
    {
	_OutputStream_cl var_a = (_OutputStream_cl)arg_a;
	_String_cl var_b = (_String_cl)arg_b;
	try {
	    _body = new java.io.OutputStreamWriter((java.io.OutputStream)(var_a._body), (java.lang.String)(var_b._body));
	} catch (java.io.UnsupportedEncodingException ex_a) {
		_UnsupportedEncodingException_if oz_un = 
			(_UnsupportedEncodingException_cl)( new _UnsupportedEncodingException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_un);
	}
	return this;
    }

    public Object _new_breed(_OutputStream_if arg_a) throws Exception
    {
	_OutputStream_cl var_a = (_OutputStream_cl)arg_a;
	_body = new java.io.OutputStreamWriter((java.io.OutputStream)(var_a._body));
    return this;
    }

    public _String_if getEncoding() throws Exception
    {
	checkSecureInvocation();
	java.lang.String work;
	_String_cl ret;
	work = ((java.io.OutputStreamWriter)_body).getEncoding();
	if (work == null) return null;
	ret = new _String_cl(work);
	return ret;
    }

    public void write(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	try {
	    ((java.io.OutputStreamWriter)_body).write(var_a);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void write(_CharArray_if arg_a, int arg_b, int arg_c) throws Exception
    {
	checkSecureInvocation();
	_CharArray_cl var_a = (_CharArray_cl)arg_a;
	int var_b = arg_b;
	int var_c = arg_c;
	try {
	    ((java.io.OutputStreamWriter)_body).write((char[])(var_a._body), var_b, var_c);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void write(_String_if arg_a, int arg_b, int arg_c) throws Exception
    {
	checkSecureInvocation();
	_String_cl var_a = (_String_cl)arg_a;
	int var_b = arg_b;
	int var_c = arg_c;
	try {
	    ((java.io.OutputStreamWriter)_body).write((java.lang.String)(var_a._body), var_b, var_c);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void flush() throws Exception
    {
	checkSecureInvocation();
	try {
	    ((java.io.OutputStreamWriter)_body).flush();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void close() throws Exception
    {
	checkSecureInvocation();
	try {
	    ((java.io.OutputStreamWriter)_body).close();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public _OutputStreamWriter_cl()
    {
    }

    _OutputStreamWriter_cl(java.io.OutputStreamWriter arg_a)
    {
	_body = arg_a;
    }

}

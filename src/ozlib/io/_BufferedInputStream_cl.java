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
 * $Id: _BufferedInputStream_cl.java,v 1.5 1997/07/07 08:43:37 xsun Exp $
 */
package JP.go.ipa.oz.lib.standard;

public class _BufferedInputStream_cl
    extends _FilterInputStream_cl
    implements _BufferedInputStream_if
{
    public Object _new_breed(_InputStream_if arg_a) throws Exception
    {
	_InputStream_cl var_a = (_InputStream_cl)arg_a;
	_body = new java.io.BufferedInputStream((java.io.InputStream)(var_a._body));
    return this;
    }

    public Object _new_breed(_InputStream_if arg_a, int arg_b) throws Exception 
    {
	_InputStream_cl var_a = (_InputStream_cl)arg_a;
	int var_b = arg_b;
	_body = new java.io.BufferedInputStream((java.io.InputStream)(var_a._body), var_b);
   	return this;
    }

    public int read() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	try {
	    work = ((java.io.BufferedInputStream)_body).read();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
	ret = work;
	return ret;
    }

    public int read(_ByteArray_if arg_a, int arg_b, int arg_c) throws Exception
    {
	checkSecureInvocation();
	_ByteArray_cl var_a = (_ByteArray_cl)arg_a;
	int var_b = arg_b;
	int var_c = arg_c;
	int work;
	int ret;
	try {
	    work = ((java.io.BufferedInputStream)_body).read((byte[])(var_a._body), var_b, var_c);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
	ret = work;
	return ret;
    }

    public long skip(long arg_a) throws Exception
    {
	checkSecureInvocation();
	long var_a = arg_a;
	long work;
	long ret;
	try {
	    work = ((java.io.BufferedInputStream)_body).skip(var_a);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
	ret = work;
	return ret;
    }

    public int available() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	try {
	    work = ((java.io.BufferedInputStream)_body).available();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
	ret = work;
	return ret;
    }

    public void mark(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	((java.io.BufferedInputStream)_body).mark(var_a);
    }

    public void reset() throws Exception
    {
	checkSecureInvocation();
	try {
	    ((java.io.BufferedInputStream)_body).reset();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
	}
	
    public boolean markSupported() throws Exception
    {
	checkSecureInvocation();
	boolean work;
	boolean ret;
	work = ((java.io.BufferedInputStream)_body).markSupported();
	ret = work;
	return ret;
    }

    public _BufferedInputStream_cl()
    {
    }

    _BufferedInputStream_cl(java.io.BufferedInputStream arg_a)
    {
	_body = arg_a;
    }

}

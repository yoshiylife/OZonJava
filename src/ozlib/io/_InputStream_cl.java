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
 * $Id: _InputStream_cl.java,v 1.6 1997/07/23 02:21:14 hgoto Exp $
*/

package JP.go.ipa.oz.lib.standard;

public class _InputStream_cl
    extends JP.go.ipa.oz.lang._Root_cl
    implements _InputStream_if
{
    java.io.InputStream _body;

    public Object _new_breed() throws Exception
    {
    return this;
    }

    public int read() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	try {
	    work = ((java.io.InputStream)_body).read();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
	ret = work;
	return ret;
    }

    public int read(_ByteArray_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_ByteArray_cl var_a = (_ByteArray_cl)arg_a;
	int work;
	int ret;
	try {
	    work = ((java.io.InputStream)_body).read((byte[])(var_a._body));
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
	    work = ((java.io.InputStream)_body).read((byte[])(var_a._body), var_b, var_c);
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
	    work = ((java.io.InputStream)_body).skip(var_a);
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
	    work = ((java.io.InputStream)_body).available();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
	ret = work;
	return ret;
    }

    public void close() throws Exception
    {
	checkSecureInvocation();
	try {
	    ((java.io.InputStream)_body).close();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
    }

    public void mark(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	((java.io.InputStream)_body).mark(var_a);
    }

    public void reset() throws Exception
    {
	checkSecureInvocation();
	try {
	    ((java.io.InputStream)_body).reset();
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
	work = ((java.io.InputStream)_body).markSupported();
	ret = work;
	return ret;
    }

    protected _InputStream_cl()
    {
    }

    _InputStream_cl(java.io.InputStream arg_a)
    {
	_body = arg_a;
    }
}

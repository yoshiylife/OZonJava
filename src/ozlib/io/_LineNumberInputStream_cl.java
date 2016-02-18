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
 * $Id: _LineNumberInputStream_cl.java,v 1.4 1997/06/14 02:52:17 xsun Exp $
*/

package JP.go.ipa.oz.lib.standard;

public class _LineNumberInputStream_cl
    extends _FilterInputStream_cl
    implements _LineNumberInputStream_if
{
    public Object _new_breed(_InputStream_if arg_a) throws Exception
    {
	_InputStream_cl var_a = (_InputStream_cl)arg_a;
	_body = new java.io.LineNumberInputStream((java.io.InputStream)(var_a._body));
    return this;
    }

    public int read() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	try {
	    work = ((java.io.LineNumberInputStream)_body).read();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
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
	    work = ((java.io.LineNumberInputStream)_body).read((byte[])(var_a._body), var_b, var_c);
	    work = ((java.io.LineNumberInputStream)_body).read();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public void setLineNumber(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	((java.io.LineNumberInputStream)_body).setLineNumber(var_a);
    }

    public int getLineNumber() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	work = ((java.io.LineNumberInputStream)_body).getLineNumber();
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
	    work = ((java.io.LineNumberInputStream)_body).skip(var_a);
	    work = ((java.io.LineNumberInputStream)_body).read();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
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
	    work = ((java.io.LineNumberInputStream)_body).available();
	    work = ((java.io.LineNumberInputStream)_body).read();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public void mark(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	((java.io.LineNumberInputStream)_body).mark(var_a);
    }

    public void reset() throws Exception
    {
	checkSecureInvocation();
	try {
	    ((java.io.LineNumberInputStream)_body).reset();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public _LineNumberInputStream_cl()
    {
    }

    _LineNumberInputStream_cl(java.io.LineNumberInputStream arg_a)
    {
	_body = arg_a;
    }

}

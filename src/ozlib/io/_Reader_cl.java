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
 *  $Id: _Reader_cl.java,v 1.5 1997/07/07 08:43:37 xsun Exp $
*/

package JP.go.ipa.oz.lib.standard;

public abstract class _Reader_cl
    extends JP.go.ipa.oz.lang._Root_cl
    implements _Reader_if
{
    java.io.Reader _body;

    protected Object _new_breed() throws Exception
    {
    return this;
    }

    protected Object _new_breed(JP.go.ipa.oz.lang._Root_if arg_a) throws Exception
    {
    return this;
    }

    public int read() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	try {
	    work = ((java.io.Reader)_body).read();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public int read(_CharArray_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_CharArray_cl var_a = (_CharArray_cl)arg_a;
	int work;
	int ret;
	try {
	    work = ((java.io.Reader)_body).read((char[])(var_a._body));
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public abstract int read(_CharArray_if arg_a, int arg_b, int arg_c) throws Exception;

    public long skip(long arg_a) throws Exception
    {
	checkSecureInvocation();
	long var_a = arg_a;
	long work;
	long ret;
	try {
	    work = ((java.io.Reader)_body).skip(var_a);
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
	    work = ((java.io.Reader)_body).ready();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public boolean markSupported() throws Exception
    {
	checkSecureInvocation();
	boolean work;
	boolean ret;
	work = ((java.io.Reader)_body).markSupported();
	ret = work;
	return ret;
    }

    public void mark(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	try {
	    ((java.io.Reader)_body).mark(var_a);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void reset() throws Exception
    {
	checkSecureInvocation();
	try {
	    ((java.io.Reader)_body).reset();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public abstract void close() throws Exception;

    protected _Reader_cl()
    {
    }

}

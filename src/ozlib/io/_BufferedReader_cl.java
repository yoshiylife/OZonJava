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
 * $Id: _BufferedReader_cl.java,v 1.3 1997/06/14 02:52:16 xsun Exp $
 */

package JP.go.ipa.oz.lib.standard;

public class _BufferedReader_cl
    extends _Reader_cl
    implements _BufferedReader_if
{
    public Object _new_breed(_Reader_if arg_a, int arg_b) throws Exception
    {
	_Reader_cl var_a = (_Reader_cl)arg_a;
	int var_b = arg_b;
	_body = new java.io.BufferedReader((java.io.Reader)(var_a._body), var_b);
    return this;
    }

    public Object _new_breed(_Reader_if arg_a) throws Exception
    {
	_Reader_cl var_a = (_Reader_cl)arg_a;
	_body = new java.io.BufferedReader((java.io.Reader)(var_a._body));
    return this;
    }

    public int read() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	try {
	    work = ((java.io.BufferedReader)_body).read();
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
	    work = ((java.io.BufferedReader)_body).read((char[])(var_a._body), var_b, var_c);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public _String_if readLine() throws Exception
    {
	checkSecureInvocation();
	java.lang.String work;
	_String_cl ret;
	try {
	    work = ((java.io.BufferedReader)_body).readLine();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	if (work == null) return null;
	ret = new _String_cl(work);
	return ret;
    }

    public long skip(long arg_a) throws Exception
    {
	checkSecureInvocation();
	long var_a = arg_a;
	long work;
	long ret;
	try {
	    work = ((java.io.BufferedReader)_body).skip(var_a);
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
	    work = ((java.io.BufferedReader)_body).ready();
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
	work = ((java.io.BufferedReader)_body).markSupported();
	ret = work;
	return ret;
    }

    public void mark(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	try {
	    ((java.io.BufferedReader)_body).mark(var_a);
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
	    ((java.io.BufferedReader)_body).reset();
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
	    ((java.io.BufferedReader)_body).close();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public _BufferedReader_cl()
    {
    }

    _BufferedReader_cl(java.io.BufferedReader arg_a)
    {
	_body = arg_a;
    }

}

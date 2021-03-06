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
 * $Id: _PipedInputStream_cl.java,v 1.2 1997/07/28 09:12:48 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public class _PipedInputStream_cl
    extends _InputStream_cl
    implements _PipedInputStream_if
{
    public Object _new_breed(_PipedOutputStream_if arg_a) throws Exception
    {
	_PipedOutputStream_cl var_a = (_PipedOutputStream_cl)arg_a;
	try {
	    _body = new java.io.PipedInputStream((java.io.PipedOutputStream)(var_a._body));
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io =
		(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	return this;
    }

    public Object _new_breed() throws Exception
    {
	_body = new java.io.PipedInputStream();
	return this;
    }

    public void connect(_PipedOutputStream_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_PipedOutputStream_cl var_a = (_PipedOutputStream_cl)arg_a;
	try {
	    ((java.io.PipedInputStream)_body).connect((java.io.PipedOutputStream)(var_a._body));
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io =
		(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public int read() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	try {
	    work = ((java.io.PipedInputStream)_body).read();
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
	    work = ((java.io.PipedInputStream)_body).read((byte[])(var_a._body), var_b, var_c);
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
	    work = ((java.io.PipedInputStream)_body).available();
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
	    ((java.io.PipedInputStream)_body).close();
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io =
		(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public _PipedInputStream_cl()
    {
    }

    _PipedInputStream_cl(java.io.PipedInputStream arg_a)
    {
	_body = arg_a;
    }

}

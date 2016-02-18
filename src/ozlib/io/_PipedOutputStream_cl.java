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
 * $Id: _PipedOutputStream_cl.java,v 1.2 1997/07/28 09:12:48 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public class _PipedOutputStream_cl
    extends _OutputStream_cl
    implements _PipedOutputStream_if
{
    public Object _new_breed(_PipedInputStream_if arg_a) throws Exception
    {
	_PipedInputStream_cl var_a = (_PipedInputStream_cl)arg_a;
	try {
	    _body = new java.io.PipedOutputStream((java.io.PipedInputStream)(var_a._body));
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io =
		(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	return this;
    }

    public Object _new_breed() throws Exception
    {
	_body = new java.io.PipedOutputStream();
	return this;
    }

    public void connect(_PipedInputStream_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_PipedInputStream_cl var_a = (_PipedInputStream_cl)arg_a;
	try {
	    ((java.io.PipedOutputStream)_body).connect((java.io.PipedInputStream)(var_a._body));
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io =
		(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void write(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	try {
	    ((java.io.PipedOutputStream)_body).write(var_a);
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io =
		(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void write(_ByteArray_if arg_a, int arg_b, int arg_c) throws Exception
    {
	checkSecureInvocation();
	_ByteArray_cl var_a = (_ByteArray_cl)arg_a;
	int var_b = arg_b;
	int var_c = arg_c;
	try {
	    ((java.io.PipedOutputStream)_body).write((byte[])(var_a._body), var_b, var_c);
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
	    ((java.io.PipedOutputStream)_body).flush();
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
	    ((java.io.PipedOutputStream)_body).close();
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io =
		(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public _PipedOutputStream_cl()
    {
    }

    _PipedOutputStream_cl(java.io.PipedOutputStream arg_a)
    {
	_body = arg_a;
    }

}

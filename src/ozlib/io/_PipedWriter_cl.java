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
 * $Id: _PipedWriter_cl.java,v 1.2 1997/07/28 09:12:49 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public class _PipedWriter_cl
    extends _Writer_cl
    implements _PipedWriter_if
{
    public Object _new_breed() throws Exception
    {
	_body = new java.io.PipedWriter();
	return this;
    }

    public Object _new_breed(_PipedReader_if arg_a) throws Exception
    {
	_PipedReader_cl var_a = (_PipedReader_cl)arg_a;
	try {
	    _body = new java.io.PipedWriter((java.io.PipedReader)(var_a._body));
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io =
		(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	return this;
    }

    public void connect(_PipedReader_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_PipedReader_cl var_a = (_PipedReader_cl)arg_a;
	try {
	    ((java.io.PipedWriter)_body).connect((java.io.PipedReader)(var_a._body));
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
	    ((java.io.PipedWriter)_body).write((char[])(var_a._body), var_b, var_c);
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
	    ((java.io.PipedWriter)_body).flush();
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
	    ((java.io.PipedWriter)_body).close();
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io =
		(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public _PipedWriter_cl()
    {
    }

    _PipedWriter_cl(java.io.PipedWriter arg_a)
    {
	_body = arg_a;
    }

}

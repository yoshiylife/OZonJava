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
 * $Id: _BufferedWriter_cl.java,v 1.4 1997/06/12 11:05:11 xsun Exp $
 */

package JP.go.ipa.oz.lib.standard;

public class _BufferedWriter_cl
    extends _Writer_cl
    implements _BufferedWriter_if
{
    public Object _new_breed(_Writer_if arg_a) throws Exception
    {
	_Writer_cl var_a = (_Writer_cl)arg_a;
	_body = new java.io.BufferedWriter((java.io.Writer)(var_a._body));
    return this;
    }

    public Object _new_breed(_Writer_if arg_a, int arg_b) throws Exception
    {
	_Writer_cl var_a = (_Writer_cl)arg_a;
	int var_b = arg_b;
	_body = new java.io.BufferedWriter((java.io.Writer)(var_a._body), var_b);
    return this;
    }

    public void write(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	try {
	    ((java.io.BufferedWriter)_body).write(var_a);
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
	    ((java.io.BufferedWriter)_body).write((char[])(var_a._body), var_b, var_c);
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
	    ((java.io.BufferedWriter)_body).write((java.lang.String)(var_a._body), var_b, var_c);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void newLine() throws Exception
    {
	checkSecureInvocation();
	try {
	    ((java.io.BufferedWriter)_body).newLine();
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
	    ((java.io.BufferedWriter)_body).flush();
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
	    ((java.io.BufferedWriter)_body).close();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public _BufferedWriter_cl()
    {
    }

    _BufferedWriter_cl(java.io.BufferedWriter arg_a)
    {
	_body = arg_a;
    }

}

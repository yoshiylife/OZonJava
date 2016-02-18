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
 * $Id: _Writer_cl.java,v 1.5 1997/07/07 08:43:37 xsun Exp $
*/

package JP.go.ipa.oz.lib.standard;

public abstract class _Writer_cl
    extends JP.go.ipa.oz.lang._Root_cl
    implements _Writer_if
{
    java.io.Writer _body;

    protected Object _new_breed() throws Exception
    {
    return this;
    }

    protected Object _new_breed(JP.go.ipa.oz.lang._Root_if arg_a) throws Exception
    {
    return this;
    }

    public void write(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	try {
	    ((java.io.Writer)_body).write(var_a);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void write(_CharArray_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_CharArray_cl var_a = (_CharArray_cl)arg_a;
	try {
	    ((java.io.Writer)_body).write((char[])(var_a._body));
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public abstract void write(_CharArray_if arg_a, int arg_b, int arg_c) throws Exception;

    public void write(_String_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_String_cl var_a = (_String_cl)arg_a;
	try {
	    ((java.io.Writer)_body).write((java.lang.String)(var_a._body));
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
	    ((java.io.Writer)_body).write((java.lang.String)(var_a._body), var_b, var_c);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public abstract void flush() throws Exception;

    public abstract void close() throws Exception;

    protected _Writer_cl()
    {
    }

}

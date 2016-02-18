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
 * $Id: _BufferedOutputStream_cl.java,v 1.4 1997/07/07 08:26:36 xsun Exp $
*/

package JP.go.ipa.oz.lib.standard;

public class _BufferedOutputStream_cl
    extends _FilterOutputStream_cl
    implements _BufferedOutputStream_if
{
    public Object _new_breed(_OutputStream_if arg_a) throws Exception
    {
	_OutputStream_cl var_a = (_OutputStream_cl)arg_a;
	_body = new java.io.BufferedOutputStream((java.io.OutputStream)(var_a._body));
    return this;
    }

    public Object _new_breed(_OutputStream_if arg_a, int arg_b) throws Exception
    {
	_OutputStream_cl var_a = (_OutputStream_cl)arg_a;
	int var_b = arg_b;
	_body = new java.io.BufferedOutputStream((java.io.OutputStream)(var_a._body), var_b);
    return this;
    }

    public void write(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	try {
	    ((java.io.BufferedOutputStream)_body).write(var_a);
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
	    ((java.io.BufferedOutputStream)_body).write((byte[])(var_a._body), var_b, var_c);
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
	    ((java.io.BufferedOutputStream)_body).flush();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public _BufferedOutputStream_cl()
    {
    }

    _BufferedOutputStream_cl(java.io.BufferedOutputStream arg_a)
    {
	_body = arg_a;
    }

}

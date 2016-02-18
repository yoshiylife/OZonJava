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
 * $Id: _FileWriter_cl.java,v 1.4 1997/06/16 05:30:46 xsun Exp $
 */

package JP.go.ipa.oz.lib.standard;

public class _FileWriter_cl
    extends _OutputStreamWriter_cl
    implements _FileWriter_if
{
    public Object _new_breed(_String_if arg_a) throws Exception
    {
	_String_cl var_a = (_String_cl)arg_a;
	try {
	    _body = new java.io.FileWriter((java.lang.String)(var_a._body));
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	return this;
    }

    public Object _new_breed(_String_if arg_a, boolean arg_b) throws Exception
    {
	_String_cl var_a = (_String_cl)arg_a;
	boolean var_b = arg_b;
	try {
	    _body = new java.io.FileWriter((java.lang.String)(var_a._body), var_b);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	return this;
    }

    public Object _new_breed(_File_if arg_a) throws Exception
    {
	_File_cl var_a = (_File_cl)arg_a;
	try {
	    _body = new java.io.FileWriter((java.io.File)(var_a._body));
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	return this;
    }

    public Object _new_breed(_FileDescriptor_if arg_a) throws Exception
    {
	_FileDescriptor_cl var_a = (_FileDescriptor_cl)arg_a;
	_body = new java.io.FileWriter((java.io.FileDescriptor)(var_a._body));
    return this;
    }

    public _FileWriter_cl()
    {
    }

    _FileWriter_cl(java.io.FileWriter arg_a)
    {
	_body = arg_a;
    }

}

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
 * $Id: _FileReader_cl.java,v 1.4 1997/06/16 05:30:46 xsun Exp $
 */

package JP.go.ipa.oz.lib.standard;

public class _FileReader_cl
    extends _InputStreamReader_cl
    implements _FileReader_if
{
    public Object _new_breed(_String_if arg_a) throws Exception
    {
	_String_cl var_a = (_String_cl)arg_a;
	try {
	    _body = new java.io.FileReader((java.lang.String)(var_a._body));
	} catch (java.io.FileNotFoundException ex_a) {
		_FileNotFoundException_if oz_file = 
			(_FileNotFoundException_cl)( new _FileNotFoundException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_file);
	}
	return this;
    }

    public Object _new_breed(_File_if arg_a) throws Exception
    {
	_File_cl var_a = (_File_cl)arg_a;
	try {
	    _body = new java.io.FileReader((java.io.File)(var_a._body));
	} catch (java.io.FileNotFoundException ex_a) {
		_FileNotFoundException_if oz_file = 
			(_FileNotFoundException_cl)( new _FileNotFoundException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_file);
	}
	return this;
    }

    public Object _new_breed(_FileDescriptor_if arg_a) throws Exception
    {
	_FileDescriptor_cl var_a = (_FileDescriptor_cl)arg_a;
	_body = new java.io.FileReader((java.io.FileDescriptor)(var_a._body));
    return this;
    }

    public _FileReader_cl()
    {
    }

    _FileReader_cl(java.io.FileReader arg_a)
    {
	_body = arg_a;
    }

}

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
 * $Id: _FileOutputStream_cl.java,v 1.4 1997/06/16 05:30:46 xsun Exp $
 */

package JP.go.ipa.oz.lib.standard;

public class _FileOutputStream_cl
    extends _OutputStream_cl
    implements _FileOutputStream_if
{
    public Object _new_breed(_String_if arg_a) throws Exception
    {
	_String_cl var_a = (_String_cl)arg_a;
	try {
	    _body = new java.io.FileOutputStream((java.lang.String)(var_a._body));
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
	    _body = new java.io.FileOutputStream((java.lang.String)(var_a._body), var_b);
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
	    _body = new java.io.FileOutputStream((java.io.File)(var_a._body));
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
	_body = new java.io.FileOutputStream((java.io.FileDescriptor)(var_a._body));
    return this;
    }

    public void write(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	try {
	    ((java.io.FileOutputStream)_body).write(var_a);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void write(_ByteArray_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_ByteArray_cl var_a = (_ByteArray_cl)arg_a;
	try {
	    ((java.io.FileOutputStream)_body).write((byte[])(var_a._body));
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
	    ((java.io.FileOutputStream)_body).write((byte[])(var_a._body), var_b, var_c);
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
	    ((java.io.FileOutputStream)_body).close();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public final _FileDescriptor_if getFD() throws Exception
    {
	checkSecureInvocation();
	java.io.FileDescriptor work;
	_FileDescriptor_cl ret;
	try {
	    work = ((java.io.FileOutputStream)_body).getFD();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = new _FileDescriptor_cl(work);
	return ret;
    }

    public _FileOutputStream_cl()
    {
    }

    _FileOutputStream_cl(java.io.FileOutputStream arg_a)
    {
	_body = arg_a;
    }

}

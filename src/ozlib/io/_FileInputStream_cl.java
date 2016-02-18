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
 * $Id: _FileInputStream_cl.java,v 1.4 1997/06/16 05:30:46 xsun Exp $
 */

package JP.go.ipa.oz.lib.standard;

public class _FileInputStream_cl
    extends _InputStream_cl
    implements _FileInputStream_if
{
    public Object _new_breed(_String_if arg_a) throws Exception
    {
	_String_cl var_a = (_String_cl)arg_a;
	try {
	    _body = new java.io.FileInputStream((java.lang.String)(var_a._body));
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
	    _body = new java.io.FileInputStream((java.io.File)(var_a._body));
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
	_body = new java.io.FileInputStream((java.io.FileDescriptor)(var_a._body));
    return this;
    }

    public int read() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	try {
	    work = ((java.io.FileInputStream)_body).read();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public int read(_ByteArray_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_ByteArray_cl var_a = (_ByteArray_cl)arg_a;
	int work;
	int ret;
	try {
	    work = ((java.io.FileInputStream)_body).read((byte[])(var_a._body));
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
	    work = ((java.io.FileInputStream)_body).read((byte[])(var_a._body), var_b, var_c);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public long skip(long arg_a) throws Exception
    {
	checkSecureInvocation();
	long var_a = arg_a;
	long work;
	long ret;
	try {
	    work = ((java.io.FileInputStream)_body).skip(var_a);
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
	    work = ((java.io.FileInputStream)_body).available();
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
	    ((java.io.FileInputStream)_body).close();
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
	    work = ((java.io.FileInputStream)_body).getFD();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = new _FileDescriptor_cl(work);
	return ret;
    }


    public _FileInputStream_cl()
    {
    }

    _FileInputStream_cl(java.io.FileInputStream arg_a)
    {
	_body = arg_a;
    }

}

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
 * $Id: _File_cl.java,v 1.9 1997/07/25 02:49:22 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public class _File_cl
    extends JP.go.ipa.oz.lang._Root_cl
    implements _File_if
{
    java.io.File _body;

    public Object _new_breed(_String_if arg_a) throws Exception
    {
	_String_cl var_a = (_String_cl)arg_a;
	_body = new java.io.File((java.lang.String)(var_a._body));
	return this;
    }

    public Object _new_breed(_String_if arg_a, _String_if arg_b) throws Exception
    {
	_String_cl var_a = (_String_cl)arg_a;
	_String_cl var_b = (_String_cl)arg_b;
	_body = new java.io.File((java.lang.String)(var_a._body), (java.lang.String)(var_b._body));
	return this;
    }

    public Object _new_breed(_File_if arg_a, _String_if arg_b) throws Exception
    {
	java.io.File	var_a_body;

	_File_cl var_a = (_File_cl)arg_a;
	_String_cl var_b = (_String_cl)arg_b;
	
	var_a_body = (arg_a != null) ? (java.io.File)(var_a._body) : null;

	_body = new java.io.File(var_a_body, (java.lang.String)(var_b._body));
	return this;
    }

    public _String_if getName() throws Exception
    {
	checkSecureInvocation();
	java.lang.String work;
	_String_cl ret;
	work = ((java.io.File)_body).getName();
	ret = new _String_cl(work);
	return ret;
    }

    public _String_if getPath() throws Exception
    {
	checkSecureInvocation();
	java.lang.String work;
	_String_cl ret;
	work = ((java.io.File)_body).getPath();
	ret = new _String_cl(work);
	return ret;
    }

    public _String_if getAbsolutePath() throws Exception
    {
	checkSecureInvocation();
	java.lang.String work;
	_String_cl ret;
	work = ((java.io.File)_body).getAbsolutePath();
	ret = new _String_cl(work);
	return ret;
    }

    public _String_if getCanonicalPath()  throws Exception
    {
	checkSecureInvocation();
	java.lang.String work;
	_String_cl ret;
	try {
	    work = ((java.io.File)_body).getCanonicalPath();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = new _String_cl(work);
	return ret;
    }

    public _String_if getParent() throws Exception
    {
	checkSecureInvocation();
	java.lang.String work;
	_String_cl ret;
	work = ((java.io.File)_body).getParent();
	if (work == null) return null;
	ret = new _String_cl(work);
	return ret;
    }

    public boolean exists() throws Exception
    {
	checkSecureInvocation();
	boolean work;
	boolean ret;
	work = ((java.io.File)_body).exists();
	ret = work;
	return ret;
    }

    public boolean canWrite() throws Exception
    {
	checkSecureInvocation();
	boolean work;
	boolean ret;
	work = ((java.io.File)_body).canWrite();
	ret = work;
	return ret;
    }

    public boolean canRead() throws Exception
    {
	checkSecureInvocation();
	boolean work;
	boolean ret;
	work = ((java.io.File)_body).canRead();
	ret = work;
	return ret;
    }

    public boolean isFile() throws Exception
    {
	checkSecureInvocation();
	boolean work;
	boolean ret;
	work = ((java.io.File)_body).isFile();
	ret = work;
	return ret;
    }

    public boolean isDirectory() throws Exception
    {
	checkSecureInvocation();
	boolean work;
	boolean ret;
	work = ((java.io.File)_body).isDirectory();
	ret = work;
	return ret;
    }

    public boolean isAbsolute() throws Exception
    {
	checkSecureInvocation();
	boolean work;
	boolean ret;
	work = ((java.io.File)_body).isAbsolute();
	ret = work;
	return ret;
    }

    public long lastModified() throws Exception
    {
	checkSecureInvocation();
	long work;
	long ret;
	work = ((java.io.File)_body).lastModified();
	ret = work;
	return ret;
    }

    public long length() throws Exception
    {
	checkSecureInvocation();
	long work;
	long ret;
	work = ((java.io.File)_body).length();
	ret = work;
	return ret;
    }

    public boolean mkdir() throws Exception
    {
	checkSecureInvocation();
	boolean work;
	boolean ret;
	work = ((java.io.File)_body).mkdir();
	ret = work;
	return ret;
    }

    public boolean renameTo(_File_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_File_cl var_a = (_File_cl)arg_a;
	boolean work;
	boolean ret;
	work = ((java.io.File)_body).renameTo((java.io.File)(var_a._body));
	ret = work;
	return ret;
    }

    public boolean mkdirs() throws Exception
    {
	checkSecureInvocation();
	boolean work;
	boolean ret;
	work = ((java.io.File)_body).mkdirs();
	ret = work;
	return ret;
    }

    public _Array_if list() throws Exception
    {
	checkSecureInvocation();
	java.lang.String[] jvarray;
	_String_cl[] ozarray;
	int size;
	_Array_if ret;
	_StringComparator_if comp;

	jvarray = ((java.io.File)_body).list();
	if (jvarray == null) return null;

	size = jvarray.length;
	ozarray = new _String_cl[size];
	for (int i = 0; i < size; i++) {
	    ozarray[i] = new _String_cl(jvarray[i]);
	}
	comp = new _StringComparator_cl();	
	ret = new _Array_cl(ozarray, comp);
	return ret;
    }

    public _Array_if list(_FilenameFilter_if arg_a) throws Exception
    {
	checkSecureInvocation();
	java.lang.String[] work;
	java.lang.String[] jvarray;
	_String_cl[] ozarray;
	int size;
	_Array_if ret;
	_StringComparator_if comp;

	work = ((java.io.File)_body).list();
	if (work == null) return null;

	if (arg_a == null) {
	    return this.list();
	}

	jvarray = new java.lang.String[work.length];
	size = 0;
	for (int i = 0; i < work.length; i++) {
	    if (arg_a.accept(this, new _String_cl(work[i]))) {
		jvarray[size++] = work[i];
	    }
	}
	ozarray = new _String_cl[size];
	for (int i = 0; i < size; i++) {
	    ozarray[i] = new _String_cl(jvarray[i]);
	}
	comp = new _StringComparator_cl();	
	ret = new _Array_cl(ozarray, comp);
	return ret;
    }

    public boolean delete() throws Exception
    {
	checkSecureInvocation();
	boolean work;
	boolean ret;
	work = ((java.io.File)_body).delete();
	ret = work;
	return ret;
    }

    public boolean isequal(JP.go.ipa.oz.lang._Root_if arg_a) throws Exception
    {
	checkSecureInvocation();

	if (arg_a instanceof _File_cl) {
	    boolean ret;
	    ret = ((java.io.File)_body).equals(((_File_cl)arg_a)._body);
	    return ret;
	} else {
	   return false;
	}
    }

    public _String_if asString() throws Exception
    {
	checkSecureInvocation();
	java.lang.String work;
	_String_cl ret;
	work = ((java.io.File)_body).toString();
	ret = new _String_cl(work);
	return ret;
    }

    public _File_cl()
    {
    }

    _File_cl(java.io.File arg_a)
    {
	_body = arg_a;
    }

    public _String_if getSeparator() throws Exception
    {
	return _static_getSeparator();
    }
    protected static _String_if _static_getSeparator() throws Exception {
	return(new _String_cl(java.io.File.separator));
    }

    public char getSeparatorChar() throws Exception
    {
	return _static_getSeparatorChar();
    }
    protected static char _static_getSeparatorChar() throws Exception {
	return(java.io.File.separatorChar);
    }

    public _String_if getPathSeparator() throws Exception
    {
	return _static_getPathSeparator();
    }
    protected static _String_if _static_getPathSeparator() throws Exception {
	return(new _String_cl(java.io.File.pathSeparator));
    }

    public char getPathSeparatorChar() throws Exception
    {
	return _static_getPathSeparatorChar();
    }
    protected static char _static_getPathSeparatorChar() throws Exception {
	return(java.io.File.pathSeparatorChar);
    }
}

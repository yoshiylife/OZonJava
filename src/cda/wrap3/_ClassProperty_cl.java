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

package JP.go.ipa.oz.lib.standard;

public
class _ClassProperty_cl extends JP.go.ipa.oz.lang._Root_cl implements _ClassProperty_if {

    transient private JP.go.ipa.oz.system.OzClassFile _body;
    private String _code;
    private String _name;

    public _ClassProperty_cl() {
    }

    public _ClassProperty_cl(JP.go.ipa.oz.system.OzClassFile arg_a) {
	_body = arg_a;
    }

    public Object _new_create(_String_if codePath, _String_if propertyName) throws Exception{
        _code = (java.lang.String)((_String_cl)codePath)._body;
        _name = (java.lang.String)((_String_cl)propertyName)._body;
        _body = null;
//        checkNowFile();

        _body = JP.go.ipa.oz.system.OzClassFile.search( _code, _name);
        if(_body == null){
	    _FileNotFoundException_if ex
		= (_FileNotFoundException_cl)new _FileNotFoundException_cl()._new_init();
	    throw new JP.go.ipa.oz.lang.OzException(ex);
        }

        return this;
    }

    private void checkNowFile() throws Exception{
        /* first local search */
        if(_body == null){
            _body = JP.go.ipa.oz.system.OzClassFile.search( _code, _name);
        }
        /* next global search */
        if(_body == null){
            try{ 
                JP.go.ipa.oz.system.OzClassLoader.loadClass(_code);
            } catch(JP.go.ipa.oz.system.ExClassNotFoundException ex_a){
	        _FileNotFoundException_if ex
		    = (_FileNotFoundException_cl)new _FileNotFoundException_cl()._new_init(ex_a.getMessage());
  	        throw new JP.go.ipa.oz.lang.OzException(ex);
            } catch(java.lang.SecurityException ex_a){
	        _FileNotFoundException_if ex
		    = (_FileNotFoundException_cl)new _FileNotFoundException_cl()._new_init(ex_a.getMessage());
  	        throw new JP.go.ipa.oz.lang.OzException(ex);
            }
            _body = JP.go.ipa.oz.system.OzClassFile.search( _code, _name);
        }
        if(_body == null){
	    _FileNotFoundException_if ex
		= (_FileNotFoundException_cl)new _FileNotFoundException_cl()._new_init();
  	    throw new JP.go.ipa.oz.lang.OzException(ex);
        }
    }

    public _String_if getClassName() throws Exception{
	checkSecureInvocation();
        checkNowFile();
        _String_cl ret;
        ret = new _String_cl(_body.getClassName());
        return ret;
    }

    public _String_if getCodePath() throws Exception{
	checkSecureInvocation();
        checkNowFile();
        _String_cl ret;
        ret = new _String_cl(_body.getCodePath());
        return ret;
    }

    public _InputStream_if getInputStream() throws Exception{
	checkSecureInvocation();
        checkNowFile();
        _InputStream_cl ret;
        try{
            ret = new _InputStream_cl(_body.getInputStream());
        } catch(java.io.IOException ex_a){
	    _IOException_if ex
		= (_IOException_cl)new _IOException_cl()._new_init(ex_a.getMessage());
	    throw new JP.go.ipa.oz.lang.OzException(ex);
        }
        return ret;
    }

    public _OutputStream_if getOutputStream() throws Exception{
	checkSecureInvocation();
        checkNowFile();
        _OutputStream_cl ret;
        try{
            ret = new _OutputStream_cl(_body.getOutputStream());
        } catch(java.io.IOException ex_a){
	    _IOException_if ex
		= (_IOException_cl)new _IOException_cl()._new_init(ex_a.getMessage());
	    throw new JP.go.ipa.oz.lang.OzException(ex);
        } catch(java.lang.SecurityException ex_a){
/*
	    _SecurityException_if ex
		= (_SecurityException_cl)new _SecurityException_cl()._new_init(ex_a.getMessage());
	    throw new JP.go.ipa.oz.lang.OzException(ex);
*/
	    throw ex_a;
        }
        return ret;
    }

    public boolean isReleasedUserClassFile() throws Exception{
	checkSecureInvocation();
        checkNowFile();
        return _body.isReleasedUserClassFile();
    }

    public boolean isUserClassFile() throws Exception{
	checkSecureInvocation();
        checkNowFile();
        return _body.isUserClassFile();
    }

    /* File methods */

    public _String_if getName() throws Exception
    {
	checkSecureInvocation();
        checkNowFile();
	java.lang.String work;
	_String_cl ret;
	work = _body.getName();
	ret = new _String_cl(work);
	return ret;
    }

    public _String_if getPath() throws Exception
    {
	checkSecureInvocation();
        checkNowFile();
	java.lang.String work;
	_String_cl ret;
	work = _body.getPath();
	ret = new _String_cl(work);
	return ret;
    }

    public _String_if getAbsolutePath() throws Exception
    {
	checkSecureInvocation();
        checkNowFile();
	java.lang.String work;
	_String_cl ret;
	work = _body.getAbsolutePath();
	ret = new _String_cl(work);
	return ret;
    }

    public _String_if getCanonicalPath()  throws Exception
    {
	checkSecureInvocation();
        checkNowFile();
	java.lang.String work;
	_String_cl ret;
	try {
	    work = _body.getCanonicalPath();
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
        checkNowFile();
	java.lang.String work;
	_String_cl ret;
	work = _body.getParent();
	if (work == null) return null;
	ret = new _String_cl(work);
	return ret;
    }

    public boolean exists() throws Exception
    {
	checkSecureInvocation();
        checkNowFile();
	boolean work;
	boolean ret;
	work = _body.exists();
	ret = work;
	return ret;
    }

    public boolean canWrite() throws Exception
    {
	checkSecureInvocation();
        checkNowFile();
	boolean work;
	boolean ret;
	work = _body.canWrite();
	ret = work;
	return ret;
    }

    public boolean canRead() throws Exception
    {
	checkSecureInvocation();
        checkNowFile();
	boolean work;
	boolean ret;
	work = _body.canRead();
	ret = work;
	return ret;
    }

    public boolean isFile() throws Exception
    {
	checkSecureInvocation();
        checkNowFile();
	boolean work;
	boolean ret;
	work = _body.isFile();
	ret = work;
	return ret;
    }

    public boolean isDirectory() throws Exception
    {
	checkSecureInvocation();
        checkNowFile();
	boolean work;
	boolean ret;
	work = _body.isDirectory();
	ret = work;
	return ret;
    }

    public boolean isAbsolute() throws Exception
    {
	checkSecureInvocation();
        checkNowFile();
	boolean work;
	boolean ret;
	work = _body.isAbsolute();
	ret = work;
	return ret;
    }

    public long lastModified() throws Exception
    {
	checkSecureInvocation();
        checkNowFile();
	long work;
	long ret;
	work = _body.lastModified();
	ret = work;
	return ret;
    }

    public long length() throws Exception
    {
	checkSecureInvocation();
        checkNowFile();
	long work;
	long ret;
	work = _body.length();
	ret = work;
	return ret;
    }

    public boolean mkdir() throws Exception
    {
	checkSecureInvocation();
        checkNowFile();
	boolean work;
	boolean ret;
	work = _body.mkdir();
	ret = work;
	return ret;
    }

    public boolean renameTo(_File_if arg_a) throws Exception
    {
	checkSecureInvocation();
        checkNowFile();
	_File_cl var_a = (_File_cl)arg_a;
	boolean work;
	boolean ret;
	work = _body.renameTo((java.io.File)(var_a._body));
	ret = work;
	return ret;
    }

    public boolean mkdirs() throws Exception
    {
	checkSecureInvocation();
        checkNowFile();
	boolean work;
	boolean ret;
	work = _body.mkdirs();
	ret = work;
	return ret;
    }

    public _Array_if list() throws Exception
    {
	checkSecureInvocation();
        checkNowFile();
	java.lang.String[] jvarray;
	_String_cl[] ozarray;
	int size;
	_Array_if ret;
	_StringComparator_if comp;

	jvarray = _body.list();
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
        checkNowFile();
	java.lang.String[] work;
	java.lang.String[] jvarray;
	_String_cl[] ozarray;
	int size;
	_Array_if ret;
	_StringComparator_if comp;

	work = _body.list();
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
        checkNowFile();
	boolean work;
	boolean ret;
	work = _body.delete();
	ret = work;
	return ret;
    }

    public boolean isequal(JP.go.ipa.oz.lang._Root_if arg_a) throws Exception
    {
	checkSecureInvocation();
        checkNowFile();
	if (arg_a instanceof _File_cl) {
	    boolean ret;
	    ret = _body.equals(((_File_cl)arg_a)._body);
	    return ret;
	} else {
	   return false;
	}
    }

    public _String_if asString() throws Exception
    {
	checkSecureInvocation();
        checkNowFile();
	java.lang.String work;
	_String_cl ret;
	work = _body.toString();
	ret = new _String_cl(work);
	return ret;
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

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
class _LocalRepositoryManager_cl extends JP.go.ipa.oz.lang._Root_cl implements _LocalRepositoryManager_if {

    public _LocalRepositoryManager_cl() { super ();}

    // OzLocalRepositoryManager has no public constructor.
    public Object _new_create() throws Exception{
        return this;
    }

    public void add(_File_if file, _String_if topPackageName) throws Exception{
        checkSecureInvocation();
        _static_add(file,topPackageName);
    }
    public static void _static_add(_File_if file, _String_if topPackageName) throws Exception{
        try{ 
            JP.go.ipa.oz.system.OzLocalRepositoryManager.add( (java.io.File)((_File_cl)file)._body, (java.lang.String)((_String_cl)topPackageName)._body);
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
    }

    public _File_if get(_String_if packageName) throws Exception{
        checkSecureInvocation();
        return _static_get(packageName);
    }
    public static _File_if _static_get(_String_if packageName) throws Exception{
        java.io.File work;
        _File_cl ret;
        try{
            work = JP.go.ipa.oz.system.OzLocalRepositoryManager.get( (java.lang.String)((_String_cl)packageName)._body );
        } catch(java.io.IOException ex_a){
	    _IOException_if ex
		= (_IOException_cl)new _IOException_cl()._new_init(ex_a.getMessage());
	    throw new JP.go.ipa.oz.lang.OzException(ex);
        }
        if(work==null){
          _ClassNotFoundException_if ex
		= (_ClassNotFoundException_cl)new _ClassNotFoundException_cl()._new_init();
	  throw new JP.go.ipa.oz.lang.OzException(ex);
        } else ret = new _File_cl(work);
        return ret;
    }

    public _String_if classPath(_Set_if packageNames) throws Exception{
        checkSecureInvocation();
        return _static_classPath(packageNames);
    }
    public static _String_if _static_classPath(_Set_if packageNames) throws Exception{
        int size = packageNames.size();
        java.lang.String pNs[] = new java.lang.String[size];
        int i;
        _String_if s;
        _Iterator_if ite = packageNames.iterator();
        for(i=0;i<size;i++){
            s = (_String_if) (ite.nextElement());
            pNs[i] = (java.lang.String)((_String_cl)s)._body;
        }
        String work;
        _String_cl ret;
        try{
            work = JP.go.ipa.oz.system.OzLocalRepositoryManager.classPath(pNs);
        } catch(java.io.IOException ex_a){
	    _IOException_if ex
		= (_IOException_cl)new _IOException_cl()._new_init(ex_a.getMessage());
	    throw new JP.go.ipa.oz.lang.OzException(ex);
        } catch(java.lang.ClassNotFoundException ex_a){
	    _ClassNotFoundException_if ex
		= (_ClassNotFoundException_cl)new _ClassNotFoundException_cl()._new_init(ex_a.getMessage());
	    throw new JP.go.ipa.oz.lang.OzException(ex);
        }
        ret = new _String_cl(work);
        return ret;
    }

    public void remove(_String_if topPackageName) throws Exception{
        checkSecureInvocation();
        _static_remove(topPackageName);
    }
    public static void _static_remove(_String_if topPackageName) throws Exception{
        try{ 
            JP.go.ipa.oz.system.OzLocalRepositoryManager.remove( (java.lang.String)((_String_cl)topPackageName)._body);
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
        } catch(java.lang.ClassNotFoundException ex_a){
            /* nothing */
        }
    }

}


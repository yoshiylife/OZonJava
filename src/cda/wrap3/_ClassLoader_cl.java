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
class _ClassLoader_cl extends JP.go.ipa.oz.lang._Root_cl implements _ClassLoader_if {

    public _ClassLoader_cl() { super ();}

    // OzLocalRepositoryManager has no public constructor.
    public Object _new_create() throws Exception{
        return this;
    }

    public void loadClass(_String_if className) throws Exception{
        checkSecureInvocation();
        _static_loadClass(className);
    }
    public static void _static_loadClass(_String_if className) throws Exception{
        try{ 
            JP.go.ipa.oz.system.OzClassLoader.loadClass((java.lang.String)((_String_cl)className)._body);
        } catch(JP.go.ipa.oz.system.ExClassNotFoundException ex_a){
	    _ClassNotFoundException_if ex
		= (_ClassNotFoundException_cl)new _ClassNotFoundException_cl()._new_init(ex_a.getMessage());
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

    public void loadPackage(_String_if packageName) throws Exception{
        checkSecureInvocation();
        _static_loadPackage(packageName);
    }
    public static void _static_loadPackage(_String_if packageName) throws Exception{
        try{ 
            JP.go.ipa.oz.system.OzClassLoader.loadPackage((java.lang.String)((_String_cl)packageName)._body);
        } catch(JP.go.ipa.oz.system.ExClassNotFoundException ex_a){
	    _ClassNotFoundException_if ex
		= (_ClassNotFoundException_cl)new _ClassNotFoundException_cl()._new_init(ex_a.getMessage());
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

}


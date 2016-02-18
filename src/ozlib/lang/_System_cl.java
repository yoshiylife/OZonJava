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

import JP.go.ipa.oz.system.OzSystem;
import JP.go.ipa.oz.system.OzClassLoader;
import JP.go.ipa.oz.lang._Root_if;
import JP.go.ipa.oz.lang._Root_cl;
import JP.go.ipa.oz.lang._Proxy_if;
import JP.go.ipa.oz.lang._Proxy_cl;

public class _System_cl extends _Root_cl implements _System_if
{
    public _System_cl() throws Exception
    {
	super();
    }

    public _Root_if _new_create() throws Exception
    {
	return this;
    }

    public final void println(_Root_if obj) throws Exception
    {
	checkSecureInvocation();
	String str = obj.asString().toString();
	OzSystem.getStdout().println(str);
    }

    public final void println(_String_if obj) throws Exception
    {
	checkSecureInvocation();
	String str = obj.toString();
	OzSystem.getStdout().println(str);
    }

    public final void systemPrintln(_Root_if obj) throws Exception
    {
	checkSecureInvocation();
	String str = obj.asString().toString();
	OzSystem.println(str);
    }

    public final void systemPrintln(_String_if obj) throws Exception
    {
	checkSecureInvocation();
	String str = obj.toString();
	OzSystem.println(str);
    }

    public final void debugPrintln(_Root_if obj) throws Exception
    {
	checkSecureInvocation();
	String str = obj.asString().toString();
	OzSystem.debugPrintln(str);
    }

    public final void debugPrintln(_String_if obj) throws Exception
    {
	checkSecureInvocation();
	String str = obj.toString();
	OzSystem.debugPrintln(str);
    }

    public final _InputStreamReader_if getStdin() throws Exception
    {
	checkSecureInvocation();
	return new _InputStreamReader_cl(
	    new java.io.InputStreamReader(OzSystem.getStdin()));
    }

    public final _PrintWriter_if getStdout() throws Exception
    {
	checkSecureInvocation();
	return new _PrintWriter_cl(
	    new java.io.PrintWriter(OzSystem.getStdout()));
    }

    public final _PrintWriter_if getStderr() throws Exception
    {
	checkSecureInvocation();
	return new _PrintWriter_cl(
	    new java.io.PrintWriter(OzSystem.getStderr()));
    }

    public final _Array_if getArguments() throws Exception
    {
	checkSecureInvocation();
	java.lang.String[] rv_tmp = OzSystem.getArguments();
	_Array_if rv = null;
	if (rv_tmp != null) {
	    rv = (_Array_if)new _Array_cl()._new_create(rv_tmp.length, new _StringComparator_cl());
	    for (int i = 0; i < rv_tmp.length; i++) {
		rv.putAt(i, new _String_cl(rv_tmp[i]));
	    }
	}
	return rv;
    }

    //public final void setUserSecurity(_UserSecurity_if us) throws Exception {}

    public final _String_if getOzHome() throws Exception
    {
	checkSecureInvocation();
	return new _String_cl(OzSystem.getOzHome());
    }

    public final _String_if getGOL(Object proxy) throws Exception
    {
	checkSecureInvocation();
	return new _String_cl(((_Proxy_cl)proxy).getName());
    }

    public final Object createCellForName(_String_if gol, _String_if cell) throws Exception
    {
	checkSecureInvocation();
	Object ret = null;
	String proxyclassname = cell.toString().concat("_pcl");
	Class args[] = new Class[2];
	try {
	    args[0] = OzClassLoader.loadClass("JP.go.ipa.oz.lib.standard._String_if");
	    args[1] = proxyclassname.getClass();
	    Object objects[] = new Object[2];
	    objects[0] = gol;
	    objects[1] = cell.toString().concat("_cl");
	    ret = OzClassLoader.loadClass(proxyclassname)
		.getConstructor(args).newInstance(objects);
	} catch (Exception ex) {
	    _UserException_if ex_oz
		= (_UserException_cl)(new _UserException_cl()._new_init(ex.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
	return ret;
    }

    public final void exec(_String_if command) throws Exception
    {
	checkSecureInvocation();
	String cmd = command.toString();
	try {
	    java.lang.Runtime.getRuntime().exec(cmd);
	} catch (SecurityException ex) {
	    _IOException_if ex_oz
		= (_IOException_cl)(new _IOException_cl()._new_init(ex.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
    }
}

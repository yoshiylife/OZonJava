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
 * $Id: _InetAddress_cl.java,v 1.8 1997/07/23 07:47:45 nito Exp $
 */

package JP.go.ipa.oz.lib.standard;

public final class _InetAddress_cl
    extends JP.go.ipa.oz.lang._Root_cl
    implements _InetAddress_if
{
    java.net.InetAddress _body;

    public _InetAddress_if _new_getByName(_String_if arg_a) throws Exception
    {
	_String_cl var_a = (_String_cl)arg_a;
	java.net.InetAddress work;
	_InetAddress_cl ret = null;
	try {
	    work = java.net.InetAddress.getByName((java.lang.String)(var_a._body));
	} catch (java.net.UnknownHostException ex) {
	    _UnknownHostException_if  ex_oz
		= (_UnknownHostException_cl)
		(new _UnknownHostException_cl()._new_init(ex.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
	if (work != null) {
	    ret = new _InetAddress_cl(work);
	}
	return ret;
    }

    public _InetAddress_if _new_getLocalHost() throws Exception
    {
	java.net.InetAddress work;
	_InetAddress_cl ret = null;
	try {
	    work = java.net.InetAddress.getLocalHost();
	} catch (java.net.UnknownHostException ex) {
	    _UnknownHostException_if  ex_oz
		= (_UnknownHostException_cl)
		(new _UnknownHostException_cl()._new_init(ex.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
	if (work != null) {
	    ret = new _InetAddress_cl(work);
	}
	return ret;
    }

    public boolean isMulticastAddress() throws Exception
    {
	checkSecureInvocation();
	boolean work;
	boolean ret;
	work = ((java.net.InetAddress)_body).isMulticastAddress();
	ret = work;
	return ret;
    }

    public _String_if getHostName() throws Exception
    {
	checkSecureInvocation();
	java.lang.String work;
	_String_cl ret = null;
	work = ((java.net.InetAddress)_body).getHostName();
	if (work != null) {
	    ret = new _String_cl(work);
	}
	return ret;
    }

    public _ByteArray_if getAddress() throws Exception
    {
	checkSecureInvocation();
	byte[] work;
	_ByteArray_cl ret = null;
	work = ((java.net.InetAddress)_body).getAddress();
	if (work != null) {
	    ret = new _ByteArray_cl(work);
	}
	return ret;
    }

    public _String_if getHostAddress() throws Exception
    {
	checkSecureInvocation();
	java.lang.String work;
	_String_cl ret = null;
	work = ((java.net.InetAddress)_body).getHostAddress();
	if (work != null) {
	    ret = new _String_cl(work);
	}
	return ret;
    }

    public boolean equalTo(JP.go.ipa.oz.lang._Root_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_InetAddress_cl var_a = (_InetAddress_cl)arg_a;
	boolean work;
	boolean ret;
	work = ((java.net.InetAddress)_body).equals(var_a._body);
	ret = work;
	return ret;
    }

    public _String_if asString() throws Exception
    {
	checkSecureInvocation();
	java.lang.String work;
	_String_cl ret = null;
	work = ((java.net.InetAddress)_body).toString();
	if (work != null) {
	    ret = new _String_cl(work);
	}
	return ret;
    }

    public _InetAddress_if getByName(_String_if arg_a) throws Exception
    {
	checkSecureInvocation();
	try {
	    return _static_getByName(arg_a);
	} catch (Exception ex_a) {
	    throw ex_a;
	}
    }

    static protected _InetAddress_if _static_getByName(_String_if arg_a) throws Exception
    {
	_String_cl var_a = (_String_cl)arg_a;
	java.net.InetAddress work;
	_InetAddress_cl ret = null;
	try {
	    work = java.net.InetAddress.getByName((java.lang.String)(var_a._body));
	} catch (java.net.UnknownHostException ex) {
	    _UnknownHostException_if  ex_oz
		= (_UnknownHostException_cl)
		(new _UnknownHostException_cl()._new_init(ex.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
	if (work != null) {
	    ret = new _InetAddress_cl(work);
	}
	return ret;
    }

    public _Collection_if getAllByName(_String_if arg_a) throws Exception
    {
	checkSecureInvocation();
	try {
	    return _static_getAllByName(arg_a);
	} catch (Exception ex_a) {
	    throw ex_a;
	}
    }

    static protected _Collection_if _static_getAllByName(_String_if arg_a) throws Exception
    {
	_String_cl var_a = (_String_cl)arg_a;
	java.net.InetAddress[] work;
	_Array_if ret = null;
	try {
	    work = java.net.InetAddress.getAllByName((java.lang.String)(var_a._body));
	} catch (java.net.UnknownHostException ex) {
	    _UnknownHostException_if  ex_oz
		= (_UnknownHostException_cl)
		(new _UnknownHostException_cl()._new_init(ex.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
	if (work != null) {
	    ret = (_Array_if)(new _Array_cl()._new_create(work.length, new _InetAddressComparator_cl()));
	    for (int i = 0; i < work.length; i++) {
		ret.putAt(i, new _InetAddress_cl(work[i]));
	    }
	}
	return ret;
    }

    public _InetAddress_if getLocalHost() throws Exception
    {
	checkSecureInvocation();
	try {
	    return _static_getLocalHost();
	} catch (Exception ex_a) {
	    throw ex_a;
	}
    }

    static protected _InetAddress_if _static_getLocalHost() throws Exception
    {
	java.net.InetAddress work;
	_InetAddress_cl ret = null;
	try {
	    work = java.net.InetAddress.getLocalHost();
	} catch (java.net.UnknownHostException ex) {
	    _UnknownHostException_if  ex_oz
		= (_UnknownHostException_cl)
		(new _UnknownHostException_cl()._new_init(ex.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
	if (work != null) {
	    ret = new _InetAddress_cl(work);
	}
	return ret;
    }

    public _InetAddress_cl()
    {
    }

    _InetAddress_cl(java.net.InetAddress arg_a)
    {
        _body = arg_a;
    }

}

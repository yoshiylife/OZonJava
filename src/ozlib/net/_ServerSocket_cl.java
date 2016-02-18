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
 * $Id: _ServerSocket_cl.java,v 1.9 1997/07/23 07:47:46 nito Exp $
 */

package JP.go.ipa.oz.lib.standard;

public class _ServerSocket_cl
    extends JP.go.ipa.oz.lang._Root_cl
    implements _ServerSocket_if
{
    java.net.ServerSocket _body;

    public java.lang.Object _new_breed(int arg_a) throws Exception
    {
	int var_a = arg_a;
	try {
	    _body = new java.net.ServerSocket(var_a);
	} catch (java.io.IOException ex_a) {
	    _IOException_if  ex_oz
		= (_IOException_cl)
		(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
	return this;
    }

    public java.lang.Object _new_breed(int arg_a, int arg_b) throws Exception
    {
	int var_a = arg_a;
	int var_b = arg_b;
	try {
	    _body = new java.net.ServerSocket(var_a, var_b);
	} catch (java.io.IOException ex_a) {
	    _IOException_if  ex_oz
		= (_IOException_cl)
		(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
	return this;
    }

    public java.lang.Object _new_breed(int arg_a, int arg_b, _InetAddress_if arg_c) throws Exception
    {
	int var_a = arg_a;
	int var_b = arg_b;
	_InetAddress_cl var_c = (_InetAddress_cl)arg_c;
	try {
	    _body = new java.net.ServerSocket(var_a, var_b, (java.net.InetAddress)(var_c._body));
	} catch (java.io.IOException ex_a) {
	    _IOException_if  ex_oz
		= (_IOException_cl)
		(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
	return this;
    }

    public _InetAddress_if getInetAddress() throws Exception
    {
	checkSecureInvocation();
	java.net.InetAddress work;
	_InetAddress_cl ret = null;
	work = ((java.net.ServerSocket)_body).getInetAddress();
	if (work != null) {
	    ret = new _InetAddress_cl(work);
	}
	return ret;
    }

    public int getLocalPort() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	work = ((java.net.ServerSocket)_body).getLocalPort();
	ret = work;
	return ret;
    }

    public _Socket_if accept() throws Exception
    {
	checkSecureInvocation();
	java.net.Socket work;
	_Socket_cl ret = null;
	try {
	    work = ((java.net.ServerSocket)_body).accept();
	} catch (java.io.IOException ex_a) {
	    _IOException_if  ex_oz
		= (_IOException_cl)
		(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
	if (work != null) {
	    ret = new _Socket_cl(work);
	}
	return ret;
    }

    protected final void implAccept(_Socket_if arg_a) throws Exception
    {
    }

    public void close() throws Exception
    {
	checkSecureInvocation();
	try {
	    ((java.net.ServerSocket)_body).close();
	} catch (java.io.IOException ex_a) {
	    _IOException_if  ex_oz
		= (_IOException_cl)
		(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
    }

    public void setSoTimeout(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	try {
	    ((java.net.ServerSocket)_body).setSoTimeout(var_a);
	} catch (java.net.SocketException ex_a) {
	    _SocketException_if  ex_oz
		= (_SocketException_cl)
		(new _SocketException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
    }

    public int getSoTimeout() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	try {
	    work = ((java.net.ServerSocket)_body).getSoTimeout();
	} catch (java.io.IOException ex_a) {
	    _IOException_if  ex_oz
		= (_IOException_cl)
		(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
	ret = work;
	return ret;
    }

    public _String_if asString() throws Exception
    {
	checkSecureInvocation();
	java.lang.String work;
	_String_cl ret = null;
	work = ((java.net.ServerSocket)_body).toString();
	if (work != null) {
	    ret = new _String_cl(work);
	}
	return ret;
    }

    public void setSocketFactory(_SocketImplFactory_if arg_a) throws Exception
    {
	checkSecureInvocation();
	try {
	    _static_setSocketFactory(arg_a);
	} catch (Exception ex_a) {
	    throw ex_a;
	}
    }

    static protected void _static_setSocketFactory(_SocketImplFactory_if arg_a) throws Exception
    {
	_SocketImpl_cl var_a = (_SocketImpl_cl)arg_a;
	try {
	    java.net.ServerSocket.setSocketFactory((java.net.SocketImplFactory)(var_a._body));
	} catch (java.io.IOException ex_a) {
	    _IOException_if  ex_oz
		= (_IOException_cl)
		(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
    }

    public _ServerSocket_cl()
    {
    }

    _ServerSocket_cl(java.net.ServerSocket arg_a)
    {
	_body = arg_a;
    }

}

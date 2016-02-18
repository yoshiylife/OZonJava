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
 * $Id: _Socket_cl.java,v 1.8 1997/07/23 07:47:46 nito Exp $
 */

package JP.go.ipa.oz.lib.standard;

public class _Socket_cl
    extends JP.go.ipa.oz.lang._Root_cl
    implements _Socket_if
{
    java.net.Socket _body;

    protected java.lang.Object _new_breed() throws Exception
    {
	return this;
    }

    protected java.lang.Object _new_breed(_SocketImpl_if arg_a) throws Exception
    {
	return this;
    }

    public java.lang.Object _new_breed(_String_if arg_a, int arg_b) throws Exception
    {
	_String_cl var_a = (_String_cl)arg_a;
	int var_b = arg_b;
	try {
	    _body = new java.net.Socket((java.lang.String)(var_a._body), var_b);
	} catch (java.io.IOException ex_a) {
	    _IOException_if  ex_oz
		= (_IOException_cl)
		(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
	return this;
    }

    public java.lang.Object _new_breed(_InetAddress_if arg_a, int arg_b) throws Exception
    {
	_InetAddress_cl var_a = (_InetAddress_cl)arg_a;
	int var_b = arg_b;
	try {
	    _body = new java.net.Socket((java.net.InetAddress)(var_a._body), var_b);
	} catch (java.io.IOException ex_a) {
	    _IOException_if  ex_oz
		= (_IOException_cl)
		(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
	return this;
    }

    public java.lang.Object _new_breed(_String_if arg_a, int arg_b, _InetAddress_if arg_c, int arg_d) throws Exception
    {
	_String_cl var_a = (_String_cl)arg_a;
	int var_b = arg_b;
	_InetAddress_cl var_c = (_InetAddress_cl)arg_c;
	int var_d = arg_d;
	try {
	    _body = new java.net.Socket((java.lang.String)(var_a._body), var_b, (java.net.InetAddress)(var_c._body), var_d);
	} catch (java.io.IOException ex_a) {
	    _IOException_if  ex_oz
		= (_IOException_cl)
		(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
	return this;
    }

    public java.lang.Object _new_breed(_InetAddress_if arg_a, int arg_b, _InetAddress_if arg_c, int arg_d) throws Exception
    {
	_InetAddress_cl var_a = (_InetAddress_cl)arg_a;
	int var_b = arg_b;
	_InetAddress_cl var_c = (_InetAddress_cl)arg_c;
	int var_d = arg_d;
	try {
	    _body = new java.net.Socket((java.net.InetAddress)(var_a._body), var_b, (java.net.InetAddress)(var_c._body), var_d);
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
	work = ((java.net.Socket)_body).getInetAddress();
	if (work != null) {
	    ret = new _InetAddress_cl(work);
	}
	return ret;
    }

    public _InetAddress_if getLocalAddress() throws Exception
    {
	checkSecureInvocation();
	java.net.InetAddress work;
	_InetAddress_cl ret = null;
	work = ((java.net.Socket)_body).getLocalAddress();
	if (work != null) {
	    ret = new _InetAddress_cl(work);
	}
	return ret;
    }

    public int getPort() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	work = ((java.net.Socket)_body).getPort();
	ret = work;
	return ret;
    }

    public int getLocalPort() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	work = ((java.net.Socket)_body).getLocalPort();
	ret = work;
	return ret;
    }

    public _InputStream_if getInputStream() throws Exception
    {
	checkSecureInvocation();
	java.io.InputStream work;
	//_FileInputStream_cl ret = null;
	_InputStream_cl ret = null;
	try {
	    work = ((java.net.Socket)_body).getInputStream();
	} catch (java.io.IOException ex_a) {
	    _IOException_if  ex_oz
		= (_IOException_cl)
		(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
	if (work != null) {
	    //ret = new _FileInputStream_cl((java.io.FileInputStream)work);
	    ret = new _InputStream_cl(work);
	}
	return ret;
    }

    public _OutputStream_if getOutputStream() throws Exception
    {
	checkSecureInvocation();
	java.io.OutputStream work;
	//_FileOutputStream_cl ret = null;
	_OutputStream_cl ret = null;
	try {
	    work = ((java.net.Socket)_body).getOutputStream();
	} catch (java.io.IOException ex_a) {
	    _IOException_if  ex_oz
		= (_IOException_cl)
		(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
	if (work != null) {
	    //ret = new _FileOutputStream_cl((java.io.FileOutputStream)work);
	    ret = new _OutputStream_cl(work);
	}
	return ret;
    }

    public void setTcpNoDelay(boolean arg_a) throws Exception
    {
	checkSecureInvocation();
	boolean var_a = arg_a;
	try {
	    ((java.net.Socket)_body).setTcpNoDelay(var_a);
	} catch (java.net.SocketException ex_a) {
	    _SocketException_if ex_oz
		= (_SocketException_cl)
		(new _SocketException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
    }

    public boolean getTcpNoDelay() throws Exception
    {
	checkSecureInvocation();
	boolean work;
	boolean ret;
	try {
	    work = ((java.net.Socket)_body).getTcpNoDelay();
	} catch (java.net.SocketException ex_a) {
	    _SocketException_if ex_oz
		= (_SocketException_cl)
		(new _SocketException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
	ret = work;
	return ret;
    }

    public void setSoLinger(boolean arg_a, int arg_b) throws Exception
    {
	checkSecureInvocation();
	boolean var_a = arg_a;
	int var_b = arg_b;
	try {
	    ((java.net.Socket)_body).setSoLinger(var_a, var_b);
	} catch (java.net.SocketException ex_a) {
	    _SocketException_if ex_oz
		= (_SocketException_cl)
		(new _SocketException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
    }

    public int getSoLinger() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	try {
	    work = ((java.net.Socket)_body).getSoLinger();
	} catch (java.net.SocketException ex_a) {
	    _SocketException_if ex_oz
		= (_SocketException_cl)
		(new _SocketException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
	ret = work;
	return ret;
    }

    public void setSoTimeout(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	try {
	    ((java.net.Socket)_body).setSoTimeout(var_a);
	} catch (java.net.SocketException ex_a) {
	    _SocketException_if ex_oz
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
	    work = ((java.net.Socket)_body).getSoTimeout();
	} catch (java.net.SocketException ex_a) {
	    _SocketException_if ex_oz
		= (_SocketException_cl)
		(new _SocketException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
	ret = work;
	return ret;
    }

    public void close() throws Exception
    {
	checkSecureInvocation();
	try {
	    ((java.net.Socket)_body).close();
	} catch (java.io.IOException ex_a) {
	    _IOException_if  ex_oz
		= (_IOException_cl)
		(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
    }

    public _String_if asString() throws Exception
    {
	checkSecureInvocation();
	java.lang.String work;
	_String_cl ret = null;
	work = ((java.net.Socket)_body).toString();
	if (work != null) {
	    ret = new _String_cl(work);
	}
	return ret;
    }

    public void setSocketImplFactory(_SocketImplFactory_if arg_a) throws Exception
    {
	checkSecureInvocation();
	try {
	    _static_setSocketImplFactory(arg_a);
	} catch (Exception ex_a) {
	    throw ex_a;
	}
    }

    static protected void _static_setSocketImplFactory(_SocketImplFactory_if arg_a) throws Exception
    {
	_SocketImpl_cl var_a = (_SocketImpl_cl)arg_a;
	try {
	    java.net.Socket.setSocketImplFactory((java.net.SocketImplFactory)(var_a._body));
	} catch (java.io.IOException ex_a) {
	    _IOException_if  ex_oz
		= (_IOException_cl)
		(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
    }

    public _Socket_cl()
    {
    }

    _Socket_cl(java.net.Socket arg_a)
    {
	_body = arg_a;
    }
}

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
 * $Id: _SocketImpl_cl.java,v 1.7 1997/07/23 07:47:46 nito Exp $
 */

package JP.go.ipa.oz.lib.standard;

public abstract class _SocketImpl_cl
    extends JP.go.ipa.oz.lang._Root_cl
    implements _SocketImpl_if
{
    java.net.SocketImpl _body;

    public java.lang.Object _new_breed() throws Exception
    {
	return this;
    }

    protected _FileDescriptor_if getFileDescriptor() throws Exception
    {
	return null;
    }

    protected _InetAddress_if getInetAddress() throws Exception
    {
	return null;
    }

    protected int getPort() throws Exception
    {
	return 0;
    }

    protected int getLocalPort() throws Exception
    {
	return 0;
    }

    public _String_if asString() throws Exception
    {
	checkSecureInvocation();
	java.lang.String work;
	_String_cl ret = null;
	work = ((java.net.SocketImpl)_body).toString();
	if (work != null) {
	    ret = new _String_cl(work);
	}
	return ret;
    }

    protected _SocketImpl_cl()
    {
    }

}

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
 * $Id: _FileDescriptor_cl.java,v 1.5 1997/07/25 02:49:22 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public final class _FileDescriptor_cl
    extends JP.go.ipa.oz.lang._Root_cl
    implements _FileDescriptor_if
{
    java.io.FileDescriptor _body;

    public Object _new_breed() throws Exception
    {
	_body = new java.io.FileDescriptor();
    return this;
    }

    public boolean valid() throws Exception
    {
	checkSecureInvocation();
	boolean work;
	boolean ret;
	work = ((java.io.FileDescriptor)_body).valid();
	ret = work;
	return ret;
    }

    public void sync() throws Exception
    {
	checkSecureInvocation();
	try {
	    ((java.io.FileDescriptor)_body).sync();
	} catch (java.io.SyncFailedException ex_a) {
		_SyncFailedException_if oz_sync = 
			(_SyncFailedException_cl)( new _SyncFailedException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_sync);
	}
    }

    public _FileDescriptor_cl()
    {
    }

    _FileDescriptor_cl(java.io.FileDescriptor arg_a)
    {
	_body = arg_a;
    }

    public _FileDescriptor_if getIn() throws Exception
    {
	return _static_getIn();
    }
    protected _FileDescriptor_if _static_getIn() throws Exception
    {
	return new _FileDescriptor_cl(java.io.FileDescriptor.in);
    }

    public _FileDescriptor_if getOut() throws Exception
    {
	return _static_getOut();
    }
    protected _FileDescriptor_if _static_getOut() throws Exception
    {
	return new _FileDescriptor_cl(java.io.FileDescriptor.out);
    }

    public _FileDescriptor_if getErr() throws Exception
    {
	return _static_getErr();
    }
    protected _FileDescriptor_if _static_getErr() throws Exception
    {
	return new _FileDescriptor_cl(java.io.FileDescriptor.err);
    }

}

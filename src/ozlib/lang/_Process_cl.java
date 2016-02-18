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
 * $Id: _Process_cl.java,v 1.1 1997/07/23 06:32:58 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public class _Process_cl
    extends JP.go.ipa.oz.lang._Root_cl
    implements _Process_if
{
    java.lang.Process _body;

    public _Process_cl()
    {
    }

    _Process_cl(java.lang.Process arg_a) {
	_body = arg_a;
    }

    public Object _new_create(_String_if arg_a) throws Exception
    {
	checkSecureInvocation();
	if (runningIsRed()) {
	    throw new SecurityException("Can't exec \""
		 + ((_String_cl)arg_a)._body + "\" from red process.");
	}
	
        try {
	    _body = java.lang.Runtime.getRuntime().exec(((_String_cl)arg_a)._body);
        } catch (java.io.IOException ex_a) {
	    _IOException_if oz_io = 
		(_IOException_cl)(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	return this;
    }

    public _OutputStream_if getOutputStream() throws Exception
    {
	checkSecureInvocation();
	java.io.OutputStream	in;	// process input == parent output
	in = _body.getOutputStream();
	return new _OutputStream_cl(in);
    }

    public _InputStream_if getInputStream() throws Exception
    {
	checkSecureInvocation();
	java.io.InputStream	out;	// process output == parent input
	out = _body.getInputStream();
	return new _InputStream_cl(out);
    }

    public _InputStream_if getErrorStream() throws Exception
    {
	checkSecureInvocation();
	java.io.InputStream	err;	// process err output == parent input
	err = _body.getErrorStream();
	return new _InputStream_cl(err);
    }

    public int waitFor() throws Exception
    {
	checkSecureInvocation();
	int ret;
	try {
	    ret = ((java.lang.Process)_body).waitFor();  	 
	} catch (java.lang.InterruptedException ex_a) {
	    _InterruptedException_if oz_interrupted = 
		(_InterruptedException_cl)( new _InterruptedException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_interrupted);
	}
	return ret;
    }

    public int exitValue() throws Exception
    {
	checkSecureInvocation();
	return ((java.lang.Process)_body).exitValue();  	 
    }	

    public void destroy() throws Exception
    {
	checkSecureInvocation();
	((java.lang.Process)_body).destroy();
    }
}

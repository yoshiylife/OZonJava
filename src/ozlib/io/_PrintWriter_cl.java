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
 * $Id: _PrintWriter_cl.java,v 1.7 1997/06/26 08:26:48 xsun Exp $
 */
package JP.go.ipa.oz.lib.standard;

public class _PrintWriter_cl
    extends _Writer_cl
    implements _PrintWriter_if
{
    
    public Object _new_breed(_Writer_if arg_a) throws Exception
    {
	_Writer_cl var_a = (_Writer_cl)arg_a;
	_body = new java.io.PrintWriter((java.io.Writer)(var_a._body));
    return this;
    }

    public Object _new_breed(_Writer_if arg_a, boolean arg_b) throws Exception
    {
	_Writer_cl var_a = (_Writer_cl)arg_a;
	boolean var_b = arg_b;
	_body = new java.io.PrintWriter((java.io.Writer)(var_a._body), var_b);
	return this;
    }

    public Object _new_breed(_OutputStream_if arg_a) throws Exception
    {
	_OutputStream_cl var_a = (_OutputStream_cl)arg_a;
	_body = new java.io.PrintWriter((java.io.OutputStream)(var_a._body));
    return this;
    }

    public Object _new_breed(_OutputStream_if arg_a, boolean arg_b) throws Exception
    {
	_OutputStream_cl var_a = (_OutputStream_cl)arg_a;
	boolean var_b = arg_b;
	_body = new java.io.PrintWriter((java.io.OutputStream)(var_a._body), var_b);
    return this;
    }

    public void flush() throws Exception
    {
	checkSecureInvocation();
	((java.io.PrintWriter)_body).flush();
    }

    public void close() throws Exception
    {
	checkSecureInvocation();
	((java.io.PrintWriter)_body).close();
    }

    public boolean checkError() throws Exception
    {
	checkSecureInvocation();
	boolean work;
	boolean ret;
	work = ((java.io.PrintWriter)_body).checkError();
	ret = work;
	return ret;
    }

    public void write(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	((java.io.PrintWriter)_body).write(var_a);
    }

    public void write(_CharArray_if arg_a, int arg_b, int arg_c) throws Exception
    {
	checkSecureInvocation();
	_CharArray_cl var_a = (_CharArray_cl)arg_a;
	int var_b = arg_b;
	int var_c = arg_c;
	((java.io.PrintWriter)_body).write((char[])(var_a._body), var_b, var_c);
    }

    public void write(_CharArray_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_CharArray_cl var_a = (_CharArray_cl)arg_a;
	((java.io.PrintWriter)_body).write((char[])(var_a._body));
    }

    public void write(_String_if arg_a, int arg_b, int arg_c) throws Exception
    {
	checkSecureInvocation();
	_String_cl var_a = (_String_cl)arg_a;
	int var_b = arg_b;
	int var_c = arg_c;
	((java.io.PrintWriter)_body).write((java.lang.String)(var_a._body), var_b, var_c);
    }

    public void write(_String_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_String_cl var_a = (_String_cl)arg_a;
	((java.io.PrintWriter)_body).write((java.lang.String)(var_a._body));
    }

    public void print(boolean arg_a) throws Exception
    {
	checkSecureInvocation();
	boolean var_a = arg_a;
	((java.io.PrintWriter)_body).print(var_a);
    }

    public void print(char arg_a) throws Exception
    {
	checkSecureInvocation();
	char var_a = arg_a;
	((java.io.PrintWriter)_body).print(var_a);
    }

    public void print(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	((java.io.PrintWriter)_body).print(var_a);
    }

    public void print(long arg_a) throws Exception
    {
	checkSecureInvocation();
	long var_a = arg_a;
	((java.io.PrintWriter)_body).print(var_a);
    }

    public void print(float arg_a) throws Exception
    {
	checkSecureInvocation();
	float var_a = arg_a;
	((java.io.PrintWriter)_body).print(var_a);
    }

    public void print(double arg_a) throws Exception
    {
	checkSecureInvocation();
	double var_a = arg_a;
	((java.io.PrintWriter)_body).print(var_a);
    }

    public void print(_CharArray_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_CharArray_cl var_a = (_CharArray_cl)arg_a;
	((java.io.PrintWriter)_body).print((char[])(var_a._body));
    }

    public void print(_String_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_String_cl var_a = (_String_cl)arg_a;
	((java.io.PrintWriter)_body).print((java.lang.String)(var_a._body));
    }

    public void print(JP.go.ipa.oz.lang._Root_if arg_a) throws Exception
	{
		checkSecureInvocation();
		JP.go.ipa.oz.lib.standard._String_if si = null;
		if( arg_a == null ) 
			si = new JP.go.ipa.oz.lib.standard._String_cl("null");
		else {
			si = arg_a.asString();
		}
		((java.io.PrintWriter)_body).print((java.lang.String)(((_String_cl)si)._body));
	}
	

    public void println() throws Exception
    {
	checkSecureInvocation();
	((java.io.PrintWriter)_body).println();
    }

    public void println(boolean arg_a) throws Exception
    {
	checkSecureInvocation();
	boolean var_a = arg_a;
	((java.io.PrintWriter)_body).println(var_a);
    }

    public void println(char arg_a) throws Exception
    {
	checkSecureInvocation();
	char var_a = arg_a;
	((java.io.PrintWriter)_body).println(var_a);
    }

    public void println(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	((java.io.PrintWriter)_body).println(var_a);
    }

    public void println(long arg_a) throws Exception
    {
	checkSecureInvocation();
	long var_a = arg_a;
	((java.io.PrintWriter)_body).println(var_a);
    }

    public void println(float arg_a) throws Exception
    {
	checkSecureInvocation();
	float var_a = arg_a;
	((java.io.PrintWriter)_body).println(var_a);
    }

    public void println(double arg_a) throws Exception
    {
	checkSecureInvocation();
	double var_a = arg_a;
	((java.io.PrintWriter)_body).println(var_a);
    }

    public void println(_CharArray_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_CharArray_cl var_a = (_CharArray_cl)arg_a;
	((java.io.PrintWriter)_body).println((char[])(var_a._body));
    }

    public void println(_String_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_String_cl var_a = (_String_cl)arg_a;
	((java.io.PrintWriter)_body).println((java.lang.String)(var_a._body));
    }
    
    public void println(JP.go.ipa.oz.lang._Root_if arg_a) throws Exception
	{
		checkSecureInvocation();
		JP.go.ipa.oz.lib.standard._String_if si = null;
		if( arg_a == null ) 
			si = new JP.go.ipa.oz.lib.standard._String_cl("null");
		else {
			si = arg_a.asString();
		}
		((java.io.PrintWriter)_body).println((java.lang.String)(((_String_cl)si)._body));
	}
	
    public _PrintWriter_cl()
    {
    }

    _PrintWriter_cl(java.io.PrintWriter arg_a)
    {
	_body = arg_a;
    }

}

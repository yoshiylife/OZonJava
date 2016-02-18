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

public class _StringWriter_cl
    extends _Writer_cl
    implements _StringWriter_if
{
    public Object _new_breed() throws Exception
    {
	_body = new java.io.StringWriter();
	return this;
    }

    public void write(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	((java.io.StringWriter)_body).write(var_a);
    }

    public void write(_CharArray_if arg_a, int arg_b, int arg_c) throws Exception
    {
	checkSecureInvocation();
	_CharArray_cl var_a = (_CharArray_cl)arg_a;
	int var_b = arg_b;
	int var_c = arg_c;
	((java.io.StringWriter)_body).write((char[])(var_a._body), var_b, var_c);
    }

    public void write(_String_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_String_cl var_a = (_String_cl)arg_a;
	((java.io.StringWriter)_body).write((java.lang.String)(var_a._body));
    }

    public void write(_String_if arg_a, int arg_b, int arg_c) throws Exception
    {
	checkSecureInvocation();
	_String_cl var_a = (_String_cl)arg_a;
	int var_b = arg_b;
	int var_c = arg_c;
	((java.io.StringWriter)_body).write((java.lang.String)(var_a._body), var_b, var_c);
    }

    public _String_if asString() throws Exception
    {
	checkSecureInvocation();
	java.lang.String work;
	_String_cl ret;
	work = ((java.io.StringWriter)_body).toString();
	ret = new _String_cl(work);
	return ret;
    }

    public _StringBuffer_if getBuffer() throws Exception
    {
	checkSecureInvocation();
	java.lang.StringBuffer work;
	_StringBuffer_cl ret;
	work = ((java.io.StringWriter)_body).getBuffer();
	ret = new _StringBuffer_cl(work);
	return ret;
    }

    public void flush() throws Exception
    {
	checkSecureInvocation();
	((java.io.StringWriter)_body).flush();
    }

    public void close() throws Exception
    {
	checkSecureInvocation();
	((java.io.StringWriter)_body).close();
    }

    public _StringWriter_cl()
    {
    }

    _StringWriter_cl(java.io.StringWriter arg_a)
    {
	_body = arg_a;
    }

}

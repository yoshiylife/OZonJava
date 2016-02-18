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
 * $Id: _ByteArrayInputStream_cl.java,v 1.1 1997/08/08 07:43:46 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public class _ByteArrayInputStream_cl
    extends _InputStream_cl
    implements _ByteArrayInputStream_if
{
    public Object _new_breed(_ByteArray_if arg_a) throws Exception
    {
	_ByteArray_cl var_a = (_ByteArray_cl)arg_a;
	_body = new java.io.ByteArrayInputStream((byte[])(var_a._body));
	return this;
    }

    public Object _new_breed(_ByteArray_if arg_a, int arg_b, int arg_c) throws Exception
    {
	_ByteArray_cl var_a = (_ByteArray_cl)arg_a;
	int var_b = arg_b;
	int var_c = arg_c;
	_body = new java.io.ByteArrayInputStream((byte[])(var_a._body), var_b, var_c);
	return this;
    }

    public int read() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	work = ((java.io.ByteArrayInputStream)_body).read();
	ret = work;
	return ret;
    }

    public int read(_ByteArray_if arg_a, int arg_b, int arg_c) throws Exception
    {
	checkSecureInvocation();
	_ByteArray_cl var_a = (_ByteArray_cl)arg_a;
	int var_b = arg_b;
	int var_c = arg_c;
	int work;
	int ret;
	work = ((java.io.ByteArrayInputStream)_body).read((byte[])(var_a._body), var_b, var_c);
	ret = work;
	return ret;
    }

    public long skip(long arg_a) throws Exception
    {
	checkSecureInvocation();
	long var_a = arg_a;
	long work;
	long ret;
	work = ((java.io.ByteArrayInputStream)_body).skip(var_a);
	ret = work;
	return ret;
    }

    public int available() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	work = ((java.io.ByteArrayInputStream)_body).available();
	ret = work;
	return ret;
    }

    public boolean markSupported() throws Exception
    {
	checkSecureInvocation();
	boolean work;
	boolean ret;
	work = ((java.io.ByteArrayInputStream)_body).markSupported();
	ret = work;
	return ret;
    }

    public void mark(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	((java.io.ByteArrayInputStream)_body).mark(var_a);
    }

    public void reset() throws Exception
    {
	checkSecureInvocation();
	((java.io.ByteArrayInputStream)_body).reset();
    }

    public _ByteArrayInputStream_cl()
    {
    }

    _ByteArrayInputStream_cl(java.io.ByteArrayInputStream arg_a)
    {
	_body = arg_a;
    }

}

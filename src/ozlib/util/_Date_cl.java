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
 * $Id: _Date_cl.java,v 1.1 1997/08/19 09:52:12 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public class _Date_cl
    extends JP.go.ipa.oz.lang._Root_cl
    implements _Date_if
{
    java.util.Date _body;

    public Object _new_breed() throws Exception
    {
	_body = new java.util.Date();
	return this;
    }

    public Object _new_breed(long arg_a) throws Exception
    {
	long var_a = arg_a;
	_body = new java.util.Date(var_a);
	return this;
    }


    public long getTime() throws Exception
    {
	checkSecureInvocation();
	long work;
	long ret;
	work = ((java.util.Date)_body).getTime();
	ret = work;
	return ret;
    }

    public void setTime(long arg_a) throws Exception
    {
	checkSecureInvocation();
	long var_a = arg_a;
	((java.util.Date)_body).setTime(var_a);
    }

    public boolean before(_Date_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_Date_cl var_a = (_Date_cl)arg_a;
	boolean work;
	boolean ret;
	work = ((java.util.Date)_body).before((java.util.Date)(var_a._body));
	ret = work;
	return ret;
    }

    public boolean after(_Date_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_Date_cl var_a = (_Date_cl)arg_a;
	boolean work;
	boolean ret;
	work = ((java.util.Date)_body).after((java.util.Date)(var_a._body));
	ret = work;
	return ret;
    }

    public boolean isEqualDate(_Date_if arg_a) throws Exception
    {
	checkSecureInvocation();
	boolean ret;
	ret = _body.equals(((_Date_cl)arg_a)._body);
	return ret;
    }

    public _String_if asString() throws Exception
    {
	checkSecureInvocation();
	java.lang.String work;
	_String_cl ret;
	work = ((java.util.Date)_body).toString();
	ret = new _String_cl(work);
	return ret;
    }

    public _Date_cl()
    {
    }

    _Date_cl(java.util.Date arg_a)
    {
	_body = arg_a;
    }

}

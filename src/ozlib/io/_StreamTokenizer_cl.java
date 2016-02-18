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
 * $Id: _StreamTokenizer_cl.java,v 1.5 1997/10/01 07:18:50 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public class _StreamTokenizer_cl
    extends JP.go.ipa.oz.lang._Root_cl
    implements _StreamTokenizer_if
{
    java.io.StreamTokenizer _body;

//deprecated
    public Object _new_breed(_InputStream_if arg_a) throws Exception
    {
	_InputStream_cl var_a = (_InputStream_cl)arg_a;
	_body = new java.io.StreamTokenizer((java.io.InputStream)(var_a._body));
    return this;
    }

    public Object _new_breed(_Reader_if arg_a) throws Exception
    {
	_Reader_cl var_a = (_Reader_cl)arg_a;
	_body = new java.io.StreamTokenizer((java.io.Reader)(var_a._body));
    return this;
    }

    public void resetSyntax() throws Exception
    {
	checkSecureInvocation();
	((java.io.StreamTokenizer)_body).resetSyntax();
    }

    public void wordChars(int arg_a, int arg_b) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	int var_b = arg_b;
	((java.io.StreamTokenizer)_body).wordChars(var_a, var_b);
    }

    public void whitespaceChars(int arg_a, int arg_b) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	int var_b = arg_b;
	((java.io.StreamTokenizer)_body).whitespaceChars(var_a, var_b);
    }

    public void ordinaryChars(int arg_a, int arg_b) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	int var_b = arg_b;
	((java.io.StreamTokenizer)_body).ordinaryChars(var_a, var_b);
    }

    public void ordinaryChar(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	((java.io.StreamTokenizer)_body).ordinaryChar(var_a);
    }

    public void commentChar(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	((java.io.StreamTokenizer)_body).commentChar(var_a);
    }

    public void quoteChar(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	((java.io.StreamTokenizer)_body).quoteChar(var_a);
    }

    public void parseNumbers() throws Exception
    {
	checkSecureInvocation();
	((java.io.StreamTokenizer)_body).parseNumbers();
    }

    public void eolIsSignificant(boolean arg_a) throws Exception
    {
	checkSecureInvocation();
	boolean var_a = arg_a;
	((java.io.StreamTokenizer)_body).eolIsSignificant(var_a);
    }

    public void slashStarComments(boolean arg_a) throws Exception
    {
	checkSecureInvocation();
	boolean var_a = arg_a;
	((java.io.StreamTokenizer)_body).slashStarComments(var_a);
    }

    public void slashSlashComments(boolean arg_a) throws Exception
    {
	checkSecureInvocation();
	boolean var_a = arg_a;
	((java.io.StreamTokenizer)_body).slashSlashComments(var_a);
    }

    public void lowerCaseMode(boolean arg_a) throws Exception
    {
	checkSecureInvocation();
	boolean var_a = arg_a;
	((java.io.StreamTokenizer)_body).lowerCaseMode(var_a);
    }

    public int nextToken() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	try {
	    work = ((java.io.StreamTokenizer)_body).nextToken();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public void pushBack() throws Exception
    {
	checkSecureInvocation();
	((java.io.StreamTokenizer)_body).pushBack();
    }

    public int lineno() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	work = ((java.io.StreamTokenizer)_body).lineno();
	ret = work;
	return ret;
    }

    public _String_if asString() throws Exception
    {
	checkSecureInvocation();
	java.lang.String work;
	_String_cl ret;
	work = ((java.io.StreamTokenizer)_body).toString();
	ret = new _String_cl(work);
	return ret;
    }

    public _StreamTokenizer_cl() throws Exception
    {
    }

    _StreamTokenizer_cl(java.io.StreamTokenizer arg_a)
    {
	_body = arg_a;
    }

    public int getttype() throws Exception
    {
	return _body.ttype;
    }

    public boolean ttypeisEOF() throws Exception
    {
	return _static_ttypeisEOF();
    }
    protected boolean _static_ttypeisEOF()
    {
	return(_body.ttype == java.io.StreamTokenizer.TT_EOF);
    }

    public boolean ttypeisEOL() throws Exception
    {
	return _static_ttypeisEOL();
    }
    protected boolean _static_ttypeisEOL()
    {
	return(_body.ttype == java.io.StreamTokenizer.TT_EOL);
	}

    public boolean ttypeisNUMBER() throws Exception
    {
	return _static_ttypeisNUMBER();
    }
    protected boolean _static_ttypeisNUMBER()
    {
	return (_body.ttype == java.io.StreamTokenizer.TT_NUMBER);
    }

    public boolean ttypeisWORD() throws Exception
    {
	return _static_ttypeisWORD();
    }
    protected boolean _static_ttypeisWORD()
    {
	return (_body.ttype == java.io.StreamTokenizer.TT_WORD);
    }

    public _String_if getsval() throws Exception
    {
	if (_body.sval == null) return null;
	_String_cl ret = new _String_cl(_body.sval);
	return ret;
    }

    public double getnval() throws Exception
    {
	return _body.nval;
    }


}

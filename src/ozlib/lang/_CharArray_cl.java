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
 * $Id: _CharArray_cl.java,v 1.3 1997/07/28 09:02:55 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public class _CharArray_cl extends JP.go.ipa.oz.lang._Root_cl implements _CharArray_if {
    char _body[];

    public _CharArray_cl() {
	_body = new char[1];
    }

    public _CharArray_cl(int max) {
	_body = new char[max];
    }

    public _CharArray_cl(char arg[]) {
	_body = arg;
    }

    public Object _new_create(int max) throws Exception {
	_body = new char[max];
	return this;
    }

    public int length() throws Exception {
	checkSecureInvocation();
	return _body.length;
    }

    public synchronized char at(int idx) throws Exception {
	checkSecureInvocation();
	return _body[idx];
    }

    public synchronized void putAt(int idx, int i) throws Exception {
	checkSecureInvocation();
	_body[idx] = (char)i;
    }

    public synchronized void putAt(int idx, char c) throws Exception {
	checkSecureInvocation();
	_body[idx] = c;
    }

    public synchronized void setAt(int idx, int i) throws Exception {
	putAt(idx, i);
    }

    public synchronized void setAt(int idx, char c) throws Exception {
	putAt(idx, c);
    }

    public _String_if asString() throws Exception {
	return new _String_cl(new java.lang.String(_body));
    }
}

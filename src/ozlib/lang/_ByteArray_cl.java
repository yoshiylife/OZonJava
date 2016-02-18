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
 * $Id: _ByteArray_cl.java,v 1.3 1997/07/28 09:02:54 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public class _ByteArray_cl extends JP.go.ipa.oz.lang._Root_cl implements _ByteArray_if {
    byte _body[];

    public _ByteArray_cl() {
	_body = new byte[1];
    }

    public _ByteArray_cl(int max) {
	_body = new byte[max];
    }

    public _ByteArray_cl(byte arg[]) {
	_body = arg;
    }

    public Object _new_create(int max) throws Exception {
	_body = new byte[max];
	return this;
    }

    public int length() throws Exception {
	checkSecureInvocation();
	return _body.length;
    }

    public synchronized byte at(int idx) throws Exception {
	checkSecureInvocation();
	return _body[idx];
    }

    public synchronized void putAt(int idx, int i) throws Exception {
	checkSecureInvocation();
	_body[idx] = (byte)i;
    }

    public synchronized void putAt(int idx, byte b) throws Exception {
	checkSecureInvocation();
	_body[idx] = b;
    }

    public synchronized void setAt(int idx, int i) throws Exception {
	putAt(idx, i);
    }

    public synchronized void setAt(int idx, byte b) throws Exception {
	putAt(idx, b);
    }

    public _String_if asString() throws Exception {
	return new _String_cl(new java.lang.String(_body));
    }
}

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

import JP.go.ipa.oz.lang._Root_cl;
import JP.go.ipa.oz.lang._Root_if;
import JP.go.ipa.oz.system.OzCipher;

public class _OzCipher_cl extends _Root_cl implements _OzCipher_if {
    OzCipher _body;

    protected _OzCipher_cl() {super();}
    protected _OzCipher_cl(OzCipher cipher) {
	super();
	_body = cipher;
    }

    public _String_if getCallerOzHome() throws Exception {
	checkSecureInvocation();
	return _static_getCallerOzHome();
    }

    public static _String_if _static_getCallerOzHome() throws Exception {
	String s = OzCipher.getCallerOzHome();
	if (s == null) {
	    return null;
	} else {
	    return new _String_cl(s);
	}
    }

    public _OzCipher_if getCipher(_String_if cipherName) throws Exception {
	checkSecureInvocation();
	return _static_getCipher(cipherName);
    }

    public static _OzCipher_if _static_getCipher(_String_if cipherName)
    throws Exception {
	_String_cl s = (_String_cl)cipherName;
	return new _OzCipher_cl(OzCipher.getCipher(s._body));
    }

    public _OzKey_if getKey(_String_if password) throws Exception {
	checkSecureInvocation();
	_String_cl s = (_String_cl)password;
	return new _OzKey_cl(_body.getKey(s._body));
    }

    public void encode(_InputStream_if in, _OzKey_if key, _OutputStream_if out)
    throws Exception {
	checkSecureInvocation();
	_InputStream_cl in_cl = (_InputStream_cl)in;
	_OzKey_cl key_cl = (_OzKey_cl)key;
	_OutputStream_cl out_cl = (_OutputStream_cl)out;
	_body.encode(in_cl._body, key_cl._body, out_cl._body);
    }

    public void decode(_InputStream_if in, _OzKey_if key, _OutputStream_if out)
    throws Exception {
	checkSecureInvocation();
	_InputStream_cl in_cl = (_InputStream_cl)in;
	_OzKey_cl key_cl = (_OzKey_cl)key;
	_OutputStream_cl out_cl = (_OutputStream_cl)out;
	_body.decode(in_cl._body, key_cl._body, out_cl._body);
    }
}

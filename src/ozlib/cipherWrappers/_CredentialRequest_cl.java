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

import java.util.Date;
import JP.go.ipa.oz.lang._Root_if;
import JP.go.ipa.oz.lang._Root_cl;
import JP.go.ipa.oz.system.OzCipher;
import JP.go.ipa.oz.system.OzKey;
import JP.go.ipa.oz.system.OzCipherException;
import JP.go.ipa.oz.crypt.DES.CredentialRequest;
import JP.go.ipa.oz.crypt.DES.OzDESKey;

public class _CredentialRequest_cl
extends _Root_cl
implements _CredentialRequest_if {
    CredentialRequest _body;

    public _CredentialRequest_cl() {super();}
    public _CredentialRequest_cl(CredentialRequest credentialRequest) {
	super();
	_body = credentialRequest;
    }

    public _CredentialRequest_if _new_breed(_String_if calleeOzHome,
					    long nonce) {
	String s = ((_String_cl)calleeOzHome)._body;
	_body = new CredentialRequest(s, nonce);
	return this;
    }

    public _String_if getCalleeOzHome() {
	checkSecureInvocation();
	return new _String_cl(_body.getCalleeOzHome());
    }

    public long getNonce() {
	checkSecureInvocation();
	return _body.getNonce();
    }

    public _ByteArray_if pack(_OzKey_if key) throws Exception {
	checkSecureInvocation();
	OzKey k = ((_OzKey_cl)key)._body;
	return new _ByteArray_cl(k.getCipher().encode(_body, k));
    }

    public _CredentialRequest_if unpack(_ByteArray_if ba, _OzKey_if key)
    throws Exception {
	checkSecureInvocation();
	return _static_unpack(ba, key);
    }

    public static _CredentialRequest_if _static_unpack(_ByteArray_if ba,
						       _OzKey_if key)
    throws Exception {
	byte[] b = ((_ByteArray_cl)ba)._body;
	OzKey k = ((_OzKey_cl)key)._body;
	CredentialRequest cr = (CredentialRequest)k.getCipher().decode(b, k);
	return new _CredentialRequest_cl(cr);
    }
}

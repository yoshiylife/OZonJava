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
import JP.go.ipa.oz.crypt.DES.CredentialPack;

public class _CredentialPack_cl
extends _Root_cl
implements _CredentialPack_if {
    CredentialPack _body;

    public _CredentialPack_cl() {super();}
    public _CredentialPack_cl(CredentialPack credentialPack) {
	super();
	_body = credentialPack;
    }

    public _CredentialPack_if _new_breed(_ByteArray_if credential, long nonce,
					 _OzKey_if sessionKey,
					 _Date_if expirationDate) {
	byte[] c = ((_ByteArray_cl)credential)._body;
	OzKey key = ((_OzKey_cl)sessionKey)._body;
	Date d = ((_Date_cl)expirationDate)._body;
	_body = new CredentialPack(c, nonce, key, d);
	return this;
    }

    public _ByteArray_if getCredential() {
	checkSecureInvocation();
	return new _ByteArray_cl(_body.getCredential());
    }

    public long getNonce() {
	checkSecureInvocation();
	return _body.getNonce();
    }

    public _OzKey_if getSessionKey() {
	checkSecureInvocation();
	return new _OzKey_cl(_body.getSessionKey());
    }

    public _Date_if getExpirationDate() {
	checkSecureInvocation();
	return new _Date_cl(_body.getExpirationDate());
    }

    public _ByteArray_if pack(_OzKey_if key) throws Exception {
	checkSecureInvocation();

	OzKey k = ((_OzKey_cl)key)._body;
	return new _ByteArray_cl(k.getCipher().encode(_body, k));
    }

    public _CredentialPack_if unpack(_ByteArray_if ba, _OzKey_if key)
    throws Exception {
	checkSecureInvocation();
	return _static_unpack(ba, key);
    }

    public static _CredentialPack_if _static_unpack(_ByteArray_if ba,
						    _OzKey_if key)
    throws Exception {
	byte[] b = ((_ByteArray_cl)ba)._body;
	OzKey k = ((_OzKey_cl)key)._body;
	CredentialPack cr = (CredentialPack)k.getCipher().decode(b, k);
	return new _CredentialPack_cl(cr);
    }
}

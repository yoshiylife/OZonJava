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
import JP.go.ipa.oz.crypt.DES.Ticket;
import JP.go.ipa.oz.crypt.DES.OzDESKey;

public class _Ticket_cl extends _Root_cl implements _Ticket_if {
    Ticket _body;

    public _Ticket_cl() {super();}
    public _Ticket_cl(Ticket Ticket) {
	super();
	_body = Ticket;
    }

    public _Ticket_if _new_breed(_String_if ozHome, _Date_if expirationDate) {
	String h = ((_String_cl)ozHome)._body;
	Date d = ((_Date_cl)expirationDate)._body;
	_body = new Ticket(h, d);
	return this;
    }

    public _String_if getOzHome() {
	checkSecureInvocation();
	return new _String_cl(_body.getOzHome());
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

    public _Ticket_if unpack(_ByteArray_if ba, _OzKey_if key)
    throws Exception {
	checkSecureInvocation();
	return _static_unpack(ba, key);
    }

    public static _Ticket_if _static_unpack(_ByteArray_if ba, _OzKey_if key)
    throws Exception {
	byte[] b = ((_ByteArray_cl)ba)._body;
	OzKey k = ((_OzKey_cl)key)._body;
	Ticket p = (Ticket)k.getCipher().decode(b, k);
	return new _Ticket_cl(p);
    }
}

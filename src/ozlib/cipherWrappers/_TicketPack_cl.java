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
import JP.go.ipa.oz.crypt.DES.TicketPack;
import JP.go.ipa.oz.crypt.DES.OzDESKey;

public class _TicketPack_cl extends _Root_cl implements _TicketPack_if {
    TicketPack _body;

    public _TicketPack_cl() {super();}
    public _TicketPack_cl(TicketPack ticketPack) {
	super();
	_body = ticketPack;
    }

    public _TicketPack_if _new_breed(_Date_if expirationDate,
				     _OzKey_if ticket) {
	Date d = ((_Date_cl)expirationDate)._body;
	OzKey key = ((_OzKey_cl)ticket)._body;
	_body = new TicketPack(d, key);
	return this;
    }

    public _Date_if getExpirationDate() {
	checkSecureInvocation();
	return new _Date_cl(_body.getExpirationDate());
    }

    public _OzKey_if getTicket() {
	checkSecureInvocation();
	return new _OzKey_cl(_body.getTicket());
    }

    public _ByteArray_if pack(_OzKey_if key) throws Exception {
	checkSecureInvocation();

	OzKey k = ((_OzKey_cl)key)._body;
	return new _ByteArray_cl(k.getCipher().encode(_body, k));
    }

    public _TicketPack_if unpack(_ByteArray_if ba, _OzKey_if key)
    throws Exception {
	checkSecureInvocation();
	return _static_unpack(ba, key);
    }

    public static _TicketPack_if _static_unpack(_ByteArray_if ba,
						_OzKey_if key)
    throws Exception {
	byte[] b = ((_ByteArray_cl)ba)._body;
	OzKey k = ((_OzKey_cl)key)._body;
	TicketPack p = (TicketPack)k.getCipher().decode(b, k);
	return new _TicketPack_cl(p);
    }
}

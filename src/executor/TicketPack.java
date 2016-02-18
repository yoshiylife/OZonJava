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
 * $Id$
 */

package JP.go.ipa.oz.crypt.DES;
import java.util.Date;
import java.io.Serializable;
import JP.go.ipa.oz.system.OzKey;

/**
 * TicketPack
 * A container class to pack data as reply of the login protocol.
 *
 * @version		$Revision$, $Date$
 * @author		Nishioka Toshihiro
 */

public class TicketPack implements Serializable {
    Date expirationDate;
    OzKey ticket;
    public TicketPack(Date expirationDate, OzKey ticket) {
	this.expirationDate = expirationDate;
	this.ticket = ticket;
    }
    public Date getExpirationDate() {return expirationDate;}
    public OzKey getTicket() {return ticket;}
}

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
 * Credential
 * A container class to pack data as reply of the credential request.
 *
 * @version		$Revision$, $Date$
 * @author		Nishioka Toshihiro
 */

public class Credential implements Serializable {
    String callerOzHome;
    OzKey sessionKey;
    Date expirationDate;
    public Credential(String callerOzHome, OzKey sessionKey,
		      Date expirationDate) {
	this.callerOzHome = callerOzHome;
	this.sessionKey = sessionKey;
	this.expirationDate = expirationDate;
    }
    public String getCallerOzHome() {return callerOzHome;}
    public OzKey getSessionKey() {return sessionKey;}
    public Date getExpirationDate() {return expirationDate;}
}

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

import java.io.Serializable;

/**
 * CredentialRequest
 * A container class to pack data of credential request.
 *
 * @version		$Revision$, $Date$
 * @author		Nishioka Toshihiro
 */

public class CredentialRequest implements Serializable {
    String calleeOzHome;
    long nonce;
    public CredentialRequest(String calleeOzHome, long nonce) {
	this.calleeOzHome = calleeOzHome;
	this.nonce = nonce;
    }
    public String getCalleeOzHome() {return calleeOzHome;}
    public long getNonce() {return nonce;}
}

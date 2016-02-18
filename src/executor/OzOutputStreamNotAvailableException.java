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
 * $Id: OzOutputStreamNotAvailableException.java,v 2.2 1997/11/07 05:10:58 yoshi Exp $
 */

package JP.go.ipa.oz.system;

import java.io.IOException;

/**
 * Signals that a class file is not modifiable.
 *
 * @see	OzClassFile
 * @see ExZipEntry
 * @version		$Revision: 2.2 $, $Date: 1997/11/07 05:10:58 $
 * @author		Toshihiro Nishioka
 * @author		Yasumitsu Yoshida(reviser)
 */
public class OzOutputStreamNotAvailableException extends IOException {

    /**
     * Constructs a OzOutputStreamNotAvailableException with no detail
     * message.
     */
    public OzOutputStreamNotAvailableException() {
	super();
    }

    /**
     * Constructs a FileNotFoundException with the specified detail message. 
     *
     * @param	message
     *		The detail message
     */
    public OzOutputStreamNotAvailableException(String message) {
	super(message);
    }
}

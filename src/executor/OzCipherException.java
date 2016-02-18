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


package JP.go.ipa.oz.system;

import java.lang.Exception;

/**
 * The class <code>OzCipherException</code> and its subclasses indicate that
 * error occur concerning with cryptosystem or cryptographic communication
 * of OZ system.
 *
 * @version		Date: 97/11/1
 * @author    		Sun Xiao
 *
 */
 
public
class OzCipherException extends ExCommException {

    /**
     * Constructs an <code>OzCipherException</code> with no specified detail
     * message.
     *
     */
    public OzCipherException() {
        super();
    }

    /**
     * Constructs an <code>OzCipherException</code> with the specified detail
     * message.
     *
     * @param   message   the detail message.
     */
    public OzCipherException(String message) {
        super(message);
    }
}


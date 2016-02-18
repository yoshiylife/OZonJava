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

/**
 * The class <code>ExCommCipherTimeoutException</code> indicates that 
 * time is out of requirement during cryptographic communication.
 *
 * @version		1.1, 11/1/97
 * @author    		Sun Xiao
 * @see			ExCommException
 */
 
public
class ExCommCipherTimeoutException extends ExCommCipherException {

    /**
     * Constructs an <code>ExCommCipherTimeoutException</code> with no 
     * specified detail message.
     *
     */
    public ExCommCipherTimeoutException() {
        super();
    }

    /**
     * Constructs an <code>ExCommCipherTimeoutException</code> with the
     * specified detail message.
     *
     * @param   message   the detail message.
     */
    public ExCommCipherTimeoutException(String message) {
        super(message);
    }
}


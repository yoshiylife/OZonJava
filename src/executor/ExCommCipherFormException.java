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
 * The class <code>ExCommCipherFormException</code> indicates that the
 * cryptosystem used not existent or a wrong cryptosystem was used in
 * cryptographic communication.
 *
 * @version		Date: 97/11/1
 * @author    		Sun Xiao
 * @see			ExCommException
 */
 
public
class ExCommCipherFormException extends ExCommCipherException {

    /**
     * Constructs an <code>ExCommCipherFormException</code> with no 
     * specified detail message.
     *
     */
    public ExCommCipherFormException() {
        super();
    }

    /**
     * Constructs an <code>ExCommCipherFormException</code> with the
     * specified detail message.
     *
     * @param   message   the detail message.
     */
    public ExCommCipherFormException(String message) {
        super(message);
    }
}


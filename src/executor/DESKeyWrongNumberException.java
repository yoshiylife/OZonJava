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
import JP.go.ipa.oz.system.OzCipherException;

/**
 * The class <code>DESKeyWrongNumberException</code> indicates the length DES 
 * key is not 64 bits.  
 *
 * @version             Date: 97/11/1
 * @author              Sun Xiao
 * @see 		<code>OzCipherException</code>
 */


public class DESKeyWrongNumberException extends OzCipherException{

    /**
     * Constructs an <code>DESKeyWrongNumberException</code> with no specified 
     * detail message.
     *
     */

    public DESKeyWrongNumberException(){
 	super();	
    }

    /**
     * Constructs an <code>DESKeyWrongNumberException</code> with the specified
     * detail message.
     *
     * @param   message   the detail message.
     */

    public DESKeyWrongNumberException(String message){
        super(message); 
    }
}

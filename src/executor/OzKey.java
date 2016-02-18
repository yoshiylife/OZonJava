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
 * $Id: OzKey.java,v 2.3 1998/01/08 04:40:03 xsun Exp $
 */

package JP.go.ipa.oz.system;

/**
 * Abstract class of encryption keys.
 *
 * @version		$Revision: 2.3 $, $Date: 1998/01/08 04:40:03 $
 * @author		Tadayuki Higuchi
 * @author		Sun Xiao
 * @author		Nishioka Toshihiro
 */
public abstract class OzKey implements java.io.Serializable {
    /**
     * Returns cipher object corresponding to this key.
     */
    public abstract OzCipher getCipher();

    /**
     * Checks encoding/decoding equality of the key
     */
    public boolean isEqualKey(OzKey key) {return this == key;}
}

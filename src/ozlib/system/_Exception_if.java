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
 * $Id: _Exception_if.java,v 1.2 1997/12/09 03:40:19 hgoto Exp $
 *
 */
package JP.go.ipa.oz.lang;

/**
 * An interface representing system exception class interface part
 * in OZ programming language. The implementation part is _Exception_cl
 * class.
 *
 * @see		_Exception_cl
 * @version	$Revision: 1.2 $, $Date: 1997/12/09 03:40:19 $
 */
public interface _Exception_if
{
    /*
     * Prints this exception and its backtrace to the standard error stream.
     */
    void printStackTrace();

    /*
     * Returns the detail message of this exception object. 
     * @return		the detail message of this Throwable;
     * 			null if this exception does not have a detail message.
     */
    JP.go.ipa.oz.lib.standard._String_if getMessage();
}
/* EOF */

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
 * $Id: _Exception_cl.java,v 1.2 1997/12/09 03:40:19 hgoto Exp $
 *
 */
package JP.go.ipa.oz.lang;

/**
 * An implementation representing system exception class implementation part
 * in OZ programming language. The interface part is _Exception_if
 * class.
 *
 * @see		_Exception_if
 * @version	$Revision: 1.2 $, $Date: 1997/12/09 03:40:19 $
 */
public class _Exception_cl
    extends JP.go.ipa.oz.system.OzSecure 
    implements _Exception_if 
{
    Throwable exception;

    public _Exception_cl (Throwable e) { 
	super (); 
	exception = e;
    }

    /*
     * Prints this exception and its backtrace to the standard error stream.
     */
    public void printStackTrace () {
	exception.printStackTrace();
    }

    /*
     * Returns the detail message of this exception object. 
     * @return		the detail message of this Throwable;
     * 			null if this exception does not have a detail message.
     */
    public JP.go.ipa.oz.lib.standard._String_if getMessage () {
	String	st = exception.getMessage();
	if (st == null) {
	    return null;
	}
	return new JP.go.ipa.oz.lib.standard._String_cl(st);
    }
}
/* EOF */

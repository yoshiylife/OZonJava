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
 * $Id: _Proxy_if.java,v 1.4 1997/06/27 08:53:28 nito Exp $
 *
 */
package JP.go.ipa.oz.lang;

/**
 * An interface representing proxy class interface part
 * in OZ programming language. The implementation part is _Proxy_cl
 * class.
 *
 * @see		_Proxy_cl
 * @version	$Revision: 1.4 $, $Date: 1997/06/27 08:53:28 $
 */
public interface _Proxy_if
{
    /**
     * Method for global accessing to initialize() method of cell.
     *
     * @exception	java.lang.Exception
     * @see		JP.go.ipa.oz.system.OzCell#initialize
     */
    //public void initialize() throws Exception;

    /**
     * Method for global accessing to go() method of cell.
     *
     * @exception	java.lang.Exception
     * @see		JP.go.ipa.oz.system.OzCell#go
     */
    //public void go() throws Exception;

    /**
     * Method for global accessing to quiet() method of cell.
     *
     * @exception	java.lang.Exception
     * @see		JP.go.ipa.oz.system.OzCell#quiet
     */
    //public void quiet() throws Exception;
}
/* EOF */

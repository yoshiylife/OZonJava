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
 * $Id: _Root_if.java,v 1.8 1998/03/23 04:19:15 hgoto Exp $
 *
 */
package		JP.go.ipa.oz.lang;

import		java.lang.*;

/**
 * An interface representing root class interface part in OZ programming
 * language. The implementation part is _Root_cl class.
 *
 * @see		_Root_cl
 * @version	$Revision: 1.8 $, $Date: 1998/03/23 04:19:15 $
 * @author	Norihiro Itoh
 */
public interface	_Root_if
{
    /**
     * Compares two _Root_if implemented objects for equality.
     * Returns a boolean that indicates whether this object is equivalent
     * to the specified object.
     * @param   obj     the Object to compare with
     * @return          true if these objects are equal; false otherwise.
     */
    public boolean equals(_Root_if obj);

    /*
     * Returns the class interface of self.
     * @see		_ClassInformation_if
     */
    //public _ClassInformation_if classInformation();

    /*
     * Returns the hash code.
     * @see		_Page_if
     */
    public int hashCode();

    /*
     * Returns a _String_if implemented object for OZ  that represents
     * the value of this object.
     */
    public JP.go.ipa.oz.lib.standard._String_if asString() throws Exception;

    /*
     * Returns the page, self within.
     * @see		_Page_if
     */
    //public JP.go.ipa.oz.lib.standard._String_if cell();

    /**
     * Determines whether the object color is RED(untrust).
     * @return		true if the object color is RED;
     *			false otherwise.
     */
    public boolean isRed();

    /**
     * Determines whether the object color is GREEN(trust).
     * @return		true if the object color is GREEN;
     *			false otherwise.
     */
    public boolean isGreen();

    public JP.go.ipa.oz.lib.standard._String_if getGOD();
    public JP.go.ipa.oz.lib.standard._String_if getGOL();
    public void toGreen() throws Exception;
    public void printStackTrace() throws Exception;
}

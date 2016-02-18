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
 * $Id: _Root_cl.java,v 1.10 1998/03/23 04:19:15 hgoto Exp $
 *
 */
package		JP.go.ipa.oz.lang;

import		JP.go.ipa.oz.system.*;
import		java.lang.*;

/**
 * An interface representing root class implementation part in OZ programming
 * language. The interface part is _Root_if class.
 *
 * @see		JP.go.ipa.oz.system.OzSecure
 * @see		_Root_if
 * @version	$Revision: 1.10 $, $Date: 1998/03/23 04:19:15 $
 * @author	Norihiro Itoh
 */
public class	_Root_cl extends OzSecure implements _Root_if
{
    /**
     * Compares two _Root_if implemented objects for equality.
     * Returns a boolean that indicates whether this object is equivalent 
     * to the specified object.
     * @param	obj	the Object to compare with
     * @return		true if these objects are equal; false otherwise.
     */
    public final boolean equals(_Root_if obj)
    {
	return ((_Root_cl)obj == (_Root_cl)this);
    }

    /**
     * Returns a hash code value for the object.
     * @return		a hash code value for this object.
     */
    public final int hashCode()
    {
	return super.hashCode();
    }

    /*
     * Returns the class interface of self.
     * @see		_ClassInformation_if
     */
    /*
    public final _ClassInformation_if classInformation()
    {
	return null;
    }
    */

    /**
     * Returns a _String_if implemented object for OZ  that represents
     * the value of this object.
     * @see		_String_if
     */
    public JP.go.ipa.oz.lib.standard._String_if asString() throws Exception
    {
	JP.go.ipa.oz.lib.standard._String_cl impl = new JP.go.ipa.oz.lib.standard._String_cl(toString());
	return impl;
    }

    /*
     * Returns the page, self within.
     * @see		_Page_if
     */
    /*
    public final JP.go.ipa.oz.lib.standard._String_if cell()
    {
	return null;
    }
    */

    /**
     * Change the color of the specified object to RED.
     */
    protected final void turnRed(_Root_if obj)
    {
	_Root_cl impl = (_Root_cl)obj;
	changeObjectToRed(impl);
    }

    /**
     * Change the color of the specified object to GREEN.
     */
    protected final void turnGreen(_Root_if obj)
    {
	_Root_cl impl = (_Root_cl)obj;
	changeObjectToGreen(impl);
    }

    /*
     * Waits with specified condition variable to be signed
     * by another thread of a change in this object. 
     * @param	c	condition variable
     * @see		OzMonitor
     */
    protected final void wait(OzCondition c) throws Exception
    {
	wait(c, 0L);
    }

    public final JP.go.ipa.oz.lib.standard._String_if getGOD()
    {
	return new JP.go.ipa.oz.lib.standard._String_cl(_getGOD());
    }
    public final JP.go.ipa.oz.lib.standard._String_if getGOL()
    {
	return new JP.go.ipa.oz.lib.standard._String_cl(_getGOL());
    }
    public void toGreen() throws Exception
    {
    }
    public void printStackTrace () throws Exception
    {
	Thread.dumpStack();
    }
}

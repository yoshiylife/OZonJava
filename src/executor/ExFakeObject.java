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
 * $Id: ExFakeObject.java,v 1.2 1997/12/04 04:55:19 yoshi Exp $
 */

package JP.go.ipa.oz.system;

/**
 *
 * @version		$Revision: 1.2 $, $Date: 1997/12/04 04:55:19 $
 * @author		Yasumitsu Yoshida
 *
 * @see	ExClassLoader#loadClass(java.lang.String,boolean)
 * @see	OzLocalRepositoryManager#load(java.lang.String,ExClassDelivery,boolean)
 * @see	ExAddressResolver#resolve(java.lang.String,ExCommAddress)
 */
class
ExFakeObject
{
    boolean waiting = true;
    boolean ready = false;
    Object real = null;

    synchronized
    boolean await()
    {
	try {
	    while (waiting) {
		wait();
	    }
	} catch (InterruptedException e) {
	    /* Nothing to do */
	}
	return ready;
    }

    synchronized
    boolean await(long timeout)
    {
	if (waiting) {
	    try {
		wait(timeout);
	    } catch (InterruptedException e) {
		/* Nothing to do */
	    }
	}
	return waiting ? false : ready;
    }

    synchronized
    void ready()
    {
	waiting = false;
	ready = true;
	notifyAll();
    }

    synchronized
    void ready(Object any)
    {
	real = any;
	waiting = false;
	ready = true;
	notifyAll();
    }

    synchronized
    Object get()
    {
	return real;
    }

    synchronized
    void abort()
    {
	waiting = false;
	ready = false;
	notifyAll();
    }

    synchronized
    void abort(Object any)
    {
	real = any;
	waiting = false;
	ready = false;
	notifyAll();
    }
}

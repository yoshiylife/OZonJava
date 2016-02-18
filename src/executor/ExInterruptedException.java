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
 * $Id: ExInterruptedException.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * $BCm0U(B: $B$3$N%U%!%$%k$O(B vi $B$G!"(Bhardtab=8, tabstop=4 $B$H$7$FJT=8$5$l$F$$$k(B
 */

package JP.go.ipa.oz.system;

/**
 * Exception when thread is signaled while the thread is waiting 
 * at a condition variable(OzCondition) or a monitor(OzMonitor)
 *
 * @see OzCondition
 * @see OzMonitor
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yoichi Hamazaki
 */
public
class ExInterruptedException
extends Exception
{
	ExInterruptedException()
	{
		super();
    }

	ExInterruptedException(String msg)
	{
		super(msg);
    }
}

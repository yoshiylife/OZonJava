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
 * $Id: OzRunnable.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 */

package JP.go.ipa.oz.system;

/***
 * OzRunnable is a class to be used to fork thread.<br>
 * It is necessary to create a subclass of this if 
 * program intend to fork OzThread.
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yoichi Hamazaki
 */

public abstract 
class OzRunnable
extends OzSecure
{

  /**
   * Method to be invoked at first by forked thread.
   *
   * @exception any exception may be raised, but executor will not
   * handle such exception.
   */
  public abstract 
    void run() throws Exception;
}

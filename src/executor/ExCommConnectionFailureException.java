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
 * $Id: ExCommConnectionFailureException.java,v 2.1.1.1 1997/07/15 06:20:45 yoshi Exp $
 */
package JP.go.ipa.oz.system;

/***
 * Executor is not active where the object expected.
 * This exception occures as the result of resolution which use out-of-date cached data.
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:45 $
 * @author		Yoichi Hamazaki
 */
  public class ExCommConnectionFailureException extends ExCommRecoverableException{
  public ExCommConnectionFailureException(){
  }

  public ExCommConnectionFailureException(String message){
    super(message);
  }
}


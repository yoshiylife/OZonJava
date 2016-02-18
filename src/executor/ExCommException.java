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
 * $Id: ExCommException.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 */

package JP.go.ipa.oz.system;

/***
 * Exception which related to communication system.
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yoichi Hamazaki
 */
public class ExCommException extends ExCellException{

  ExCommException(){
  }

  ExCommException(String message){
    super(message);
  }

}

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
 * $Id: OzException.java,v 1.1 1997/06/25 07:22:54 nito Exp $
 */
package JP.go.ipa.oz.lang;

public final class OzException extends Exception {
  private JP.go.ipa.oz.lang._Root_if oz_exception;
  
  public OzException(JP.go.ipa.oz.lang._Root_if e) {
    oz_exception = e;
  }
  
  public JP.go.ipa.oz.lang._Root_if getOzException() {
    return oz_exception;
  }
}

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
 * $Id: ThisExp.java,v 0.2 1997-06-04 16:49:44+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing expression of this
  *
  * @see Expression
  */

class ThisExp extends Expression {
  /**
    * create new one
    *
    * @param ct class 
    * @param ln line number
    */
  ThisExp (ClassType ct, int ln) { 
    super (ln);
    type = ct; 
  }

  /**
    * override
    */
  public String toString () {
    return "this";
  }
}

/* EOF */

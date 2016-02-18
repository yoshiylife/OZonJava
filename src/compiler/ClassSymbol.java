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
 * $Id: ClassSymbol.java,v 0.4 1997-07-10 15:46:09+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.01.17
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing primary expression of class.
  *
  * @see ClassType
  * @see ClassImplementation
  * @see Identifier
  */

class ClassSymbol extends Identifier {
  /** 
    * corresponidng class
    */
  ClassType base;

  /**
    * create a class symbol
    *
    * @param c class
    */
  ClassSymbol (ClassType c) {
    super (c.getName (), c, 0);
    base = c;
    state = ASSIGNED_GREEN;
  }

  /**
    * override
    */
  public String toString () {
    if (!Emitter.isEmitting ()) return name;

    return base.toString ();
  }
}

/* EOF */

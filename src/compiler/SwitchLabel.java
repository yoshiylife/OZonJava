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
 * $Id: SwitchLabel.java,v 0.9 1998-02-02 08:31:42+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.02.17
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing label of switch statement 
  *
  * @see Statement
  * @see SwitchSt
  */

class SwitchLabel extends Statement {
  /**
    * label expression
    */
  Expression label;

  /**
    * create new one
    *
    * @param l label
    * @param ln line number
    */
  SwitchLabel (Expression l, int ln) {
    super (ln);

    if (l == null) return;

    if (!l.checkConstant ()) {
      OzcError.caseLabelMustBeConstant (ln);
      return;
    }

    label = l;
  }

  /**
    * create default label
    *
    * @param ln line number
    */
  SwitchLabel (int ln) {
    this (null, ln);
  }
  
  /**
    * override
    *
    * @see Statement
    */
  void check (MethodType method) throws Unreachable {}

  /**
    * override
    *
    * @see Statement
    */
  void emit () {
    Emitter.indentPop ();
    Emitter.emitln ();
    if (label != null) {
      Emitter.emit ("case " + label + ":");
    } else {
      Emitter.emit ("default:");
    }
    Emitter.indentPush ();
  }
}

/* EOF */

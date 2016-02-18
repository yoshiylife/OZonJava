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
 * $Id: NullSt.java,v 0.4 1997-07-10 15:46:22+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing null statement.
  *
  * @see Statement
  */

class NullSt extends Statement {
  /**
    * create a node of abstract syntax tree
    *
    * @param ln line number
    */
  NullSt (int ln) { super (ln); }

  /**
    * override 
    *
    * @see Statement
    */
  void emit () {
    Emitter.emitln (line_no);
    Emitter.emit (";");
  }
}

/* EOF */

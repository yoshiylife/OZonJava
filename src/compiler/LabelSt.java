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
 * $Id: LabelSt.java,v 0.12 1998-02-02 08:31:32+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing label statement.
  *
  * @see Statement
  */

class LabelSt extends Statement {
  /**
    * label 
    */
  Identifier label;

  /**
    * labeld statement 
    */
  Statement st;
  
  /**
    * create a node of abstract syntax tree
    *
    * @param l label
    * @param s statement
    * @param ln line number
    */
  LabelSt (Identifier l, Statement s, int ln) {
    super (ln);
    
    st = s;
    st.label = label = l;
    label.st = this;
  }

  /**
    * override
    *
    * @see Statement
    */
  void check (MethodType method) throws Unreachable { 
    st.check (method); 
  }
  
  /**
    * override 
    * 
    * @see Statement
    */
  boolean hasBreak (Identifier lab) { return st.hasBreak (lab); }

  /**
    * override
    *
    * @see Statement
    */
  void emit () {
    if (Emitter.isEmitting () && !(st instanceof ForSt)) {
      Emitter.emitln (line_no);
      Emitter.emit (label + ":");
    }
    st.emit ();
  }
}
  
/* EOF */

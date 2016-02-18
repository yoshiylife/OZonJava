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
 * $Id: JumpSt.java,v 0.16 1998-02-02 09:14:18+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing jump statement (break, continue)
  *
  * @see Statement
  */

class JumpSt extends Statement {
  /**
    * label 
    */
  Identifier label;
  
  /**
    * kind (sym.BREAK or sym.CONTINUE) 
    */
  int kind;

  /**
    * loop depth
    */
  int loop_depth;

  /**
    * flag for wrapped emitting
    */
  boolean need_wrap;
  
  /**
    * create a node of abstract syntax tree
    *
    * @param l label
    * @param k kind 
    * @param cm method containing this statement
    * @param ln line number
    * @param lp loop depth
    */
  JumpSt (Identifier l, int k, MethodType cm, int ln, int lp) {
    super (ln);

    kind = k;
    loop_depth = lp;

    if (l != null) {
      label = l;
    }
  }

  /**
    * check if break statment 
    *
    * @return if so true, otherwise false
    */
  boolean isBreak () { return kind == sym.BREAK; }
  
  /**
    *check if continue statment 
    *
    * @return if so true, otherwise false
    */
  boolean isContinue () { return kind == sym.CONTINUE; }


  /**
    * override
    *
    * @see Statement 
    */

  void check (MethodType method) throws Unreachable {
    super.check (method);

    if (isContinue () && label != null && !(label.st.st instanceof LoopSt))
      OzcError.jumpCannotUsedHere ();

    Unreachable e = new Unreachable (); 
    e.jump_st = this;

    throw e;
  }
  
  /**
    * override 
    * 
    * @see Statement
    */
  boolean hasBreak (Identifier lab) { 
    if (!isBreak ()) return false;
    
    if (label == lab) 
      return true;

    return false;
  }

  /**
    * override
    *
    * @see Statement
    */
  void emit () {
    Identifier lb = label;

    Emitter.emitln (line_no);
    if (need_wrap) Emitter.emit ("if (true) ");
    if (isBreak ()) {
      Emitter.emit ("break");
    } else if (Emitter.isEmitting ()) {
      Emitter.emit ("break");
      if (label != null) 
	lb = ((LoopSt) label.st.st).loop_label;
      else 
	lb = new Identifier ("_loop_" + loop_depth);
    } else {
      Emitter.emit ("continue");
    }

    if (lb != null) {
      Emitter.emit (" ");
      Emitter.emit (lb);
    }
      
    Emitter.emit (";");
  }

  /**
    * set flag for wrapped emitting
    */
  void needWrap () {
    need_wrap = true;
  }
}

/* EOF */

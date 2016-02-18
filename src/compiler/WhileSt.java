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
 * $Id: WhileSt.java,v 0.10 1998-02-02 08:31:46+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing while statement
  *
  * @see LoopSt
  * @see Statement
  */

class WhileSt extends LoopSt {
  /**
    * create new one
    *
    * @param exp expression
    * @praram st statement 
    * @param ln line number
    * @param loop_depth loop depth
    */
  WhileSt (Expression exp, Statement st, int ln,
	   int loop_depth) { 
    super (exp, st, ln, loop_depth); 
  }
  
  /**
    * override
    *
    * @see Statement
    */
  void emit () {

    Emitter.emitln (line_no);
    if (Emitter.isEmitting ()) {
      Emitter.emit ("while (true) {");
      Emitter.indentPush ();
      exp.preEmitForMethodInvocation ();
      if (exp.isFalse ()) {
	Emitter.emitln ();
	Emitter.emitln ("break;");
      } else if (!exp.isTrue ()) {
	Emitter.emitln ();
	Emitter.emitln ("if (!(" + exp + ")) break;");
      }
    } else {
      Emitter.emit ("while (" + exp + ") {");
      Emitter.indentPush ();
    }
    emitBody ();

    Emitter.indentPop ();
    Emitter.emitln ();
    Emitter.emit ("}");
  }
}

/* EOF */

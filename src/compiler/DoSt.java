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
 * $Id: DoSt.java,v 0.7 1998-02-02 08:31:26+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing do statement.
  *
  * @see LoopSt
  * @see Statement
  */

class DoSt extends LoopSt {
  /**
    * create a node of syntax abstract tree 
    *
    * @param exp boolean expression 
    * @param st statement
    * @param ln line number
    * @param loop_depth loop depth
    */
  DoSt (Expression exp, Statement st, int ln,
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
    Emitter.emit ("do {");
    Emitter.indentPush ();
    Emitter.emitln ();

    emitBody ();

    Emitter.indentPop ();
    Emitter.emitln ();
    Emitter.emit ("} while (");
    Emitter.emit (exp);
    Emitter.emit (");");
  }
}

/* EOF */

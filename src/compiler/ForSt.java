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
 * $Id: ForSt.java,v 0.16 1998-02-02 08:31:28+09 otokawa Exp $
 */


/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing for statement.
  * 
  * @see LoopSt
  * @see Statement
  */

class ForSt extends LoopSt {
  /**
    * type of defined variable 
    */
  Type type;
  
  /** 
    * defined variables 
    */
  ExpressionList identifiers;
  
  /**
    * expression for iteration 
    */
  Expression iteration;

  /**
    * create a node of abstract syntax tree
    * 
    * @param i_st initialization statement
    * @param e1 boolean expression
    * @param e2 iteration expression
    * @param s body statement
    * @param ln line number
    * @param loop_depth loop depth
    */
  ForSt (Statement i_st, Expression e1, Expression e2, Statement s, int ln,
	 int loop_depth) {
    super (e1, s, ln, loop_depth);

    if (i_st instanceof DeclarationSt) {
      DeclarationSt st = (DeclarationSt) i_st;
      type = st.type;
      identifiers = st.identifiers;
    } else {
      ExpressionSt st = (ExpressionSt) i_st;
      type = null;
      if (st.exp != null) {
	identifiers = new ExpressionList ();
	identifiers.add (st.exp);
      }
    }
    iteration = e2;

  }

  /**
    * override
    *
    * @see Statement
    */
  void check (MethodType method) throws Unreachable {
    if (identifiers != null) 
      identifiers.check ();
    if (iteration != null)
      iteration.check ();
    super.check (method);
  }

  /** 
    * override
    *
    * @see Statement
    */
  void emit () {
    boolean emitting = Emitter.isEmitting ();

    Emitter.emitln (line_no);
    if (emitting) {
      Emitter.emit ("/* for loop starting here */ {");
      Emitter.indentPush ();
      Emitter.emitln ();
    } else
      Emitter.emit ("for (");

    /* emit initialization statement (first part) */
    if (identifiers != null) {
      if (emitting) {
	Emitter.emit ("/* initialization part */");
	for (int i = 0, size = identifiers.size (); i < size ; i++) {
	  Expression e = (Expression) identifiers.get (i);
	  e.preEmitForMethodInvocation ();
	  if (type != null) {
	    Emitter.emitln ();
	    Emitter.emit (type + " " + e);
	    Identifier id = (Identifier) e;
	    e = id.getExp ();
	    if (e != null) Emitter.emit (" = " + e);
	    Emitter.emit (";");
	  } else
	    ExpressionSt.emitExp (e);
	}
	Emitter.emitln ();
	Emitter.emitln ();
      } else {
	if (type != null) Emitter.emit (type + " ");
	if (identifiers != null) identifiers.emit ();
	Emitter.emit ("; ");
      }
    }

    if (emitting) {
      if (label != null) Emitter.emit (label + ": ");
      Emitter.emit ("for (;;) {");
      Emitter.indentPush ();
    }

    /* emit boolean expression (second part) */
    if (exp != null) {
      if (emitting) {
	Emitter.emitln ();
	Emitter.emit ("/* boolean expression part */");
	exp.preEmitForMethodInvocation ();
	if (exp.isFalse ()) {
	  Emitter.emitln ();
	  Emitter.emitln ("break;");
	} else if (!exp.isTrue ()) {
	  Emitter.emitln ();
	  Emitter.emitln ("if (!(" + exp + ")) break;");
	}
      } else
	Emitter.emit (exp);
    }

    /* emit iteration expression (third part) */
    if (emitting) {
      /* iteration is emit later as try-finally */
    } else {
      Emitter.emit ("; ");
      Emitter.emit (iteration);
      Emitter.emit (") {");
      Emitter.indentPush ();
    }

    /* emit body statement */
    emitBody (iteration);

    if (emitting) {
      Emitter.indentPop ();
      Emitter.emitln ();
      Emitter.emit ("}");
    }
    Emitter.indentPop ();
    Emitter.emitln ();
    Emitter.emit ("}");
  }
}

/* EOF */

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
 * $Id: IfSt.java,v 0.18 1998-02-02 08:31:30+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing if statement.
  *
  * @see Statement
  */

class IfSt extends Statement {
  /**
    * boolean expression 
    */
  Expression exp;
  
  /**
    * if and else part 
    */
  Statement if_part, else_part;
  
  /**
    * create a node of abstract syntax tree
    *
    * @param e expression
    * @param if_st if part statement
    * @param else_st else part statement
    * @param ln line number
    */
  IfSt (Expression e, Statement if_st, Statement else_st, int ln) {
    super (ln);

    exp = e;
    if_part = if_st;
    else_part = else_st;

    if (e.type == Type.ANY) return;

    if (e.type == null) {
      e.type = PrimitiveType.BOOL;
      e.is_conditional = true;
      return;
    }

    if (!e.type.isBool ()) {
      /* must be boolean expression */
      OzcError.mustBeBoolExpression ();
    }
  }

  /**
    * override 
    * 
    * @see Statement
    */
  void check (MethodType method) throws Unreachable { 
    if (exp != null)
      exp.check ();

    Unreachable unreach = null;
    try {
      if_part.check (method);
    } catch (Unreachable e) {
      /* true unreachable ? */
      if (e.getStatement () != null) throw e;

      /* not break ? */
      /*
      if (e.jump_st == null || 
	  e.jump_st.label == null || 
	  e.jump_st.label != label) 
	unreach = e;
	*/
    }

    if (else_part != null) {
      try {
	else_part.check (method);
      } catch (Unreachable e) {
	/* true unreachable ? */
	if (e.getStatement () != null) throw e;

	/* not break ? */
	/*
	if (unreach != null) {
	  if (e.jump_st == null || 
	      e.jump_st.label == null || 
	      e.jump_st.label != label) 
	    throw unreach;
	}
	*/
      }
    }
  }

  /**
    * override 
    * 
    * @see Statement
    */
  boolean hasBreak (Identifier lab) {
    if (if_part.hasBreak (lab)) 
      return true;

    if (else_part != null)
      return else_part.hasBreak (lab);

    return false;
  }
  
  /**
    * override
    *
    * @see Statement
    */
  void emit () {
    if (Emitter.isEmitting ()) exp.preEmitForMethodInvocation ();

    Emitter.emitln (line_no);
    Emitter.emit ("if (");
    Emitter.emit (exp);
    Emitter.emit (") {");
    Emitter.indentPush ();
    if_part.emit ();
    Emitter.indentPop ();
    Emitter.emitln ();
    Emitter.emit ("}");
    
    if (else_part == null) return;

    Emitter.emit (" else {");
    Emitter.indentPush ();
    else_part.emit ();
    Emitter.indentPop ();
    Emitter.emitln ();
    Emitter.emit ("}");
  }
}

/* EOF */

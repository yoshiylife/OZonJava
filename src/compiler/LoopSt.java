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
 * $Id: LoopSt.java,v 0.19 1998-02-02 09:14:21+09 otokawa Exp $
 */


/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.1.20
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing loop statement
  *
  * @see Statement
  */

abstract class LoopSt extends Statement {
  /**
    * boolean expression 
    */
  protected Expression exp;
  
  /**
    * statement 
    */
  protected Statement st;

  /**
    * label for jump statement
    */
  protected Identifier loop_label;
  
  /**
    * create a node of abstract syntax tree
    *
    * @param e booelan expression
    * @param s statement
    * @param ln line number
    * @param loop_depth loop depth
    */
  LoopSt (Expression e, Statement s, int ln, int loop_depth) { 
    super (ln); 

    exp = e;
    st = s; 

    loop_label = new Identifier ("_loop_" + loop_depth);

    if (e == null || e.type == Type.ANY) return;

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
    * emit body of loop statement (for, while and  do) 
    */
  protected void emitBody () { emitBody (null); }

  /**
    * emit body of loop statement with iterlation expression 
    * (for, while and  do) 
    *
    * @param iteration iteratio expression
    */
  protected void emitBody (Expression iteration) {
    if (!Emitter.isEmitting ()) {
      st.emit ();
      return;
    }

    Emitter.emitln ();
    Emitter.emit ("/* body */ ");

    Emitter.emit (loop_label);
    Emitter.emit (": ");
    st.emit ();

    if (iteration != null) {
      Emitter.emitln ();
      Emitter.emit ("/* iteration part */");
      ExpressionSt.emitExp (iteration);
    }
  }

  /**
    * override
    *
    * @see Statement
    */
  void check (MethodType method) throws Unreachable { 
    Unreachable unreachable = null;

    st.label = label;

    if (exp != null)
      exp.check ();

    /* in while or for statement, if condition exp. is constant false, 
     * unreachable body statements */
    if (!(st instanceof NullSt) && 
	!(this instanceof DoSt) &&
	exp != null && exp.isFalse ()) unreachable = new Unreachable (st);

    /* if condition exp. is constant true, have to contain break */
    if (exp == null || exp.isTrue ()) {
      if (!st.hasBreak (null) && (label == null || !st.hasBreak (label)))
	unreachable = new Unreachable ();
    }

    try {
      st.check (method);
    } catch (Unreachable e) {
      /* contains a true unreachable statement */
      if (e.getStatement () != null)
	throw e;

      if (e.jump_st != null /* && 
	  e.jump_st.isBreak () && e.jump_st.label == label */) {
	e.jump_st.needWrap ();
      }
    }

    if (unreachable != null) throw unreachable;
  }

  /**
    * override
    *
    * @see Statement
    */
  boolean hasBreak (Identifier lab) { 
    if (lab == null)
      return false;

    return st.hasBreak (lab); 
  }
}

/* EOF */

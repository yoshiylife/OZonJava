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
 * $Id: ExpressionSt.java,v 0.13 1998-02-02 08:31:27+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing expression statement.
  *
  * @see Statement
  * @see Expression
  */

class ExpressionSt extends Statement {
  /**
    * expression 
    */
  Expression exp;
  
  /**
    * create a node of abstact syntax tree
    *
    * @param e expression
    * @param ln line number
    */
  ExpressionSt (Expression e, int ln) { 
    super (ln);
    exp = e; 
  }
  
  /**
    * access for exp field
    *
    * @return expression
    */
  Expression getExpression () { return exp; }

  /**
    * overide 
    *
    * @see Statement
    */
  void check (MethodType method) throws Unreachable { 
    exp.check ();
    super.check (method);
  }

  /**
    * override
    *
    * @see Statement
    */
  public void emit () { emitExp (exp, line_no); }

  /**
    * emit expression
    *
    * @param e expression
    */
  static void emitExp (Expression e) {
    emitExp (e, e == null ? 0 : e.getLineNumber ());
  }

  /**
    * emit expression
    *
    * @param e expression
    * @param ln line number
    */
  static void emitExp (Expression e, int line_no) {
    if (e == null) return;

    if (Emitter.isEmitting ())
      e.preEmitForMethodInvocation ();

    if (!MethodInvocationExp.needEmit (e)) return;

    if (!(e instanceof StatementExpressionList))
      Emitter.emitln (line_no);
    Emitter.emit (e + ";");
  }
}

/* EOF */

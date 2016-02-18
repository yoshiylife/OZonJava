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
 * $Id: ParenthesisExp.java,v 0.8 1997-07-11 18:26:01+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/** 
  * A class representing parentheis expression.
  * 
  * @see Expression
  */

class ParenthesisExp extends Expression {
  /**
    * closed expression
    */
  Expression exp;

  /**
    * create a node of abstract syntax tree
    *
    * @param e expression
    */
  ParenthesisExp (Expression e) {
    super (e.line_no);
    exp = e;
    setType ();
  }

  /**
    * override
    *
    * @see Expression
    */
  protected void setType () {
    type = exp.type;
  }

  /**
    * override
    *
    * @see Expression
    */
  protected void check () {
    exp.check ();
  }

  /**
    * override
    *
    * @see Expression
    */
  boolean checkConstant () { return exp.checkConstant (); }

  /**
    * override
    *
    * @see Expression
    */
  void preEmitForMethodInvocation () { 
    exp.preEmitForMethodInvocation ();
  }

  /**
    * override
    */
  public String toString () {
    StringBuffer s = new StringBuffer ();
    s.append ("(");
    s.append (exp);
    s.append (")");
    return s.toString ();
  }
}

/* EOF */

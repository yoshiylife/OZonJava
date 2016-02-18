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
 * $Id: StatementExpressionList.java,v 0.2 1997-06-04 16:49:45+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing comma separated statement expressions
  *
  * @see Expressions
  * @see Statement
  */

class StatementExpressionList extends Expression {
  /**
    * operands 
    */
  Expression operand1, operand2;
  
  /**
    * create new one 
    *
    * @param o1 operand
    * @param o2 operand
    */
  StatementExpressionList (Expression o1, Expression o2) {
    super (o1.line_no);
    operand1 = o1;
    operand2 = o2;
    type = o2.type;
  }
  
  /**
    * override
    *
    * @see Statement
    */
  void preEmitForMethodInvocation () { 
    operand1.preEmitForMethodInvocation ();
    operand2.preEmitForMethodInvocation ();
  }
  
  /**
    * override
    */
  public String toString () {
    StringBuffer s = new StringBuffer ();
    if (Emitter.isEmitting ()) {
      ExpressionSt.emitExp (operand1);
      Emitter.emitln ();
    } else {
      s.append (operand1);
      s.append (",");
    }
    s.append (operand2);
    return s.toString ();
  }
}

/* EOF */

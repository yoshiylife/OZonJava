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
 * $Id: AssignNumericExp.java,v 0.8 1997-07-11 18:25:28+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.6
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing numerical assign operator expression.
  * 
  * @see BinaryExp
  * @see ParserAction
  * @see sym
  */

class AssignNumericExp extends BinaryExp {
  /**
    * create a node of abstrct syntax tree
    *
    * @param l left hand expression
    * @param r right hand expression
    * @param k kind of operator 
    */
  AssignNumericExp (Expression l, Expression r, int k) {
    super (l, r, k);
  }

  /**
    * override
    *
    * @see Expression
    */
  protected void setType () {
    Type t1 = operand1.type, t2 = operand2.type;
    if (type == null) 
      type = t1;

    if (type != null) {
      if (!PrimitiveType.isArithmetic (type))
	OzcError.notArithmetic (operand1);
    } 

    if (t1 == null || t2 == null) 
      return;

    if (!t1.isAssignable (operand2)) 
      OzcError.typeMismatch (t2, t1);
  }
  
  /**
    * override
    */
  public String toString () {
    StringBuffer s = new StringBuffer ();
    s.append (operand1);
    switch (kind) {
    case sym.PLUSEQUAL:
      s.append (" += ");
      break;
    case sym.MINUSEQUAL:
      s.append (" -= ");
      break;
    case sym.TIMESEQUAL:
      s.append (" *= ");
      break;
    case sym.DIVIDEEQUAL:
      s.append (" /= ");
      break;
    case sym.MODEQUAL:
      s.append (" %= ");
      break;
    }
    s.append (operand2);
    return s.toString ();
  }
}

/* EOF */

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
 * $Id: BinaryExp.java,v 0.15 1998-01-22 08:45:36+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing bainary operator expression.
  *
  * @see Expression
  * @see AssignExp
  * @see AssignNumericExp
  * @see BinaryBoolExp
  * @see ParserActionExp
  */

class BinaryExp extends Expression {
  /**
    * operands 
    */
  Expression operand1, operand2;
  
  /**
    * kind of operator 
    */
  int kind;
  
  /**
    * create a node of abstract syntax tree
    *
    * @param o1 left hand operand
    * @param o2 right hand operand
    * @param k kind of operator
    */
  BinaryExp (Expression o1, Expression o2, int k) {
    super (o1.line_no);

    operand1 = o1;
    operand2 = o2;
    kind = k;
      
    setType ();
  }
  
  /**
    * override
    * 
    * @see Expression
    */
  protected void check () {
    operand1.check ();
    operand2.check ();
  }

  /**
    * override
    *
    * @see Expression
    */
  protected void setType () {
    Type t1 = operand1.type, t2 = operand2.type;

    /* for equality expression */
    if (kind == sym.EQUALEQUAL || kind == sym.NOTEQUAL) {
      if (t1 == null || t2 == null) {
	type = null;
	return;
      }

      if (!t1.isSameKind (t2))
	OzcError.mustSameKindType ();

      type = PrimitiveType.BOOL;
      return;
    } 

    /* for comparison expression */
    if (!PrimitiveType.isArithmetic (t1))
      OzcError.notArithmetic (operand1);
    if (!PrimitiveType.isArithmetic (t2))
      OzcError.notArithmetic (operand2);

    if (kind == sym.LANGLE || kind == sym.RANGLE || 
	kind == sym.GTE || kind == sym.LTE) {
      type = PrimitiveType.BOOL;
      return;
    }

    if (t1 == null) {
      type = t2;
      return;
    }

    if (type != null) t2 = type;

    try {
      if (t1.compare (t2) >= 0) 
	type = t1;
      else
	type = t2;

      if (type == PrimitiveType.BYTE || type == PrimitiveType.SHORT) 
	type = PrimitiveType.INT;

      if (ozc.isTest ()) {
	if (type == PrimitiveType.INT) {
	  if (t1 == PrimitiveType.BYTE || t1== PrimitiveType.SHORT) 
	    ozc.debugln (line_no + ": " + t1 + " is promoted to int");

	  if (t2 == PrimitiveType.BYTE || t2== PrimitiveType.SHORT) 
	    ozc.debugln (line_no + ": " + t2 + " is promoted to int");
	} else if (t1 != t2) {
	  if (type == t1) {
	    ozc.debugln (line_no + ": " + t2 + " is promoted to " + type);
	  } else {
	    ozc.debugln (line_no + ": " + t1 + " is promoted to " + type);
	  }
	}
      }
    } catch (TypeMismatch ex) {
      type = PrimitiveType.INT;
      return;
    }
  }

  /**
    * override
    * 
    * @see Expression
    */
  boolean checkConstant () { 
    return (operand1.checkConstant () &&
	    operand2.checkConstant ());
  }
  
  /**
    * override
    *
    * @see Expression
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
    s.append (operand1);
    switch (kind) {
    case sym.TIMES:
      s.append (" * ");
      break;
    case sym.DIVIDE:
      s.append (" / ");
      break;
    case sym.MOD:
      s.append (" % ");
      break;
    case sym.PLUS:
      s.append (" + ");
      break;
    case sym.MINUS:
      s.append (" - ");
      break;
    case sym.LANGLE:
      s.append (" < ");
      break;
    case sym.RANGLE:
      s.append (" > ");
      break;
    case sym.LTE:
      s.append (" <= ");
      break;
    case sym.GTE:
      s.append (" >= ");
      break;
    case sym.EQUALEQUAL:
      s.append (" == ");
      break;
    case sym.NOTEQUAL:
      s.append (" != ");
      break;
    }
    s.append (operand2);
    return s.toString ();
  }
}

/* EOF */

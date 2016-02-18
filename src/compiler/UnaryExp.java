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
 * $Id: UnaryExp.java,v 0.14 1998-01-30 11:05:13+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

/**
  * A class representing unary expression
  *
  * @see Expression
  */

package JP.go.ipa.oz.compiler;

class UnaryExp extends Expression {
  /**
    * operand 
    */
  Expression operand;

  /**
    * kind of operator 
    */
  int kind;

  /**
    * create new one
    *
    * @param o operand
    * @param k kind of operator
    */
  UnaryExp (Expression o, int k) {
    super (o.line_no);

    operand = o;
    kind = k;

    setType ();
  }

  /** 
    * override
    *
    * @see Expression
    */
  void setType () {
    if (type == null) 
      type = operand.type;
    else if (!type.isAssignable (operand.type))
      OzcError.typeMismatch (operand.type, type);

    switch (kind) {
    case sym.PLUSPLUS:
    case sym.MINUSMINUS:
    case sym.POSTPLUSPLUS:
    case sym.POSTMINUSMINUS:
      if (!(operand instanceof Identifier) &&
	  !(operand instanceof AttributeAccessExp)) {
	OzcError.cannotUseAsIncrementOperand ();
	return;
      }
      
      /* operand is not-recognized expression */
      if (type == null) return;

      if (!PrimitiveType.isArithmetic (type)) {
	/* type must be numeric */
	OzcError.notNumeric (type);
      }
      break;
    case sym.PLUS:
    case sym.MINUS:
      /* operand is not-recognized expression */
      if (type == null) return;

      if (!PrimitiveType.isArithmetic (type)) {
	/* type must be arithmetic Char */
	OzcError.notArithmetic (operand);
      }

      if (type == PrimitiveType.BYTE || type == PrimitiveType.SHORT) {
	if (ozc.isTest ()) {
	  ozc.debugln (line_no + ": " + type + " is promoted to int");
	}
	type = PrimitiveType.INT;
      }
      break;
    case sym.EXCLAM:
      /* operand is not-recognized expression */
      if (type == null || type == Type.ANY)
	operand.type = PrimitiveType.BOOL;
      else if (!type.isBool ()) {
	/* type must be boolean */
	OzcError.notBoolean (type);
      }
      type = PrimitiveType.BOOL;
      break;
    }
  }


  /**
    * override 
    * 
    * @see Expression
    */
  void check () {
    operand.check ();
  }

  /**
    * override 
    * 
    * @see Expression
    */
  boolean checkConstant () { 
    return operand.checkConstant ();
  }
  
  /**
    * override 
    * 
    * @see Expression
    */
  void preEmitForMethodInvocation () { 
    operand.preEmitForMethodInvocation ();
  }
  
  /**
    * override 
    */
  public String toString () {
    StringBuffer s = new StringBuffer ();
    switch (kind) {
    case sym.PLUSPLUS:
      s.append ("++");
      s.append (operand);
      break;
    case sym.MINUSMINUS:
      s.append ("--");
      s.append (operand);
      break;
    case sym.POSTPLUSPLUS:
      s.append (operand);
      s.append ("++");
      break;
    case sym.POSTMINUSMINUS:
      s.append (operand);
      s.append ("--");
      break;
    case sym.PLUS:
      s.append ("+");
      s.append (operand);
      break;
    case sym.MINUS:
      s.append ("-");
      s.append (operand);
      break;
    case sym.EXCLAM:
      s.append ("!");
      s.append (operand);
      break;
    }

    return s.toString ();
  }
}

/* EOF */

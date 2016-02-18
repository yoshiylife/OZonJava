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
 * $Id: ConditionalExp.java,v 0.13 1997-10-09 18:38:26+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing conditional operator expression.
  *
  * @see Expression
  */

class ConditionalExp extends Expression {
  /**
    * operands 
    */
  Expression operand1, operand2, operand3;
  
  /**
    * counter for pre emitting 
    */
  private static int count;

  /**
    * pre-emitted result 
    */
  private String result;
  
  /**
    * create a node of abstract syntax tree
    *
    * @param o1 first operand
    * @param o2 second operand
    * @param o3 third operand
    */
  ConditionalExp (Expression o1, Expression o2, Expression o3) {
    super (o1.line_no);
    operand1 = o1;
    operand2 = o2;
    operand3 = o3;

    setType ();
  }
  
  /** 
    * override
    *
    * @see Expression
    */
  void check () {
    operand1.check ();
    operand2.check ();
    operand3.check ();
  }

  /** 
    * override
    *
    * @see Expression
    */
  void setType () {
    Type t1 = operand1.type, t2 = operand2.type, t3 = operand3.type;

    if (t1 == null) {
      operand1.type = PrimitiveType.BOOL;
    } else if (!t1.isBool ()) {
      /* must be boolean expression */
      OzcError.notBoolean (t1);
    }

    if (t2 == null) {
      if (operand3 instanceof Literal &&
	  ((Literal) operand3).getValue ().equals ("null")) 
	type = null;
      else
	type = t3;
      return;
    }

    if (t3 == null) {
      if (operand2 instanceof Literal &&
	  ((Literal) operand2).getValue ().equals ("null")) 
	type = null;
      else
	type = t2;
      return;
    }

    if (type != null) t3 = type;

    /* same type */
    if (t2 == t3) {
      type = t2;
      return;
    }

    try {
      if (operand2 instanceof Literal) {
	if (((Literal) operand2).getValue ().equals ("null")) {
	  if (t3 instanceof ClassType) 
	    type = t3;
	  else
	    throw new TypeMismatch ();
	} else if (t2 == PrimitiveType.INT){
	  if (t3.compare (operand2) >= 0)
	    type = t3;
	  else
	    type = t2;
	}
      } else if (operand3 instanceof Literal) {
	if (((Literal) operand3).getValue ().equals ("null")) {
	  if (t2 instanceof ClassType) 
	    type = t2;
	  else
	    throw new TypeMismatch ();
	} else if (t3 == PrimitiveType.INT) {
	  if (t2.compare (operand3) >= 0)
	    type = t2;
	  else
	    type = t3;
	}
      } else {
	if (t2.compare (t3) >= 0)
	  type = t2;
	else
	  type = t3;
      }
    } catch (TypeMismatch ex) {
      /* must be compatible types */
      type = t2;
      OzcError.typeMismatch (t2, t3);
    }
  }

  /** 
    * override
    *
    * @see Expression
    */
  boolean checkConstant () { 
    return (operand1.checkConstant () &&
	    operand2.checkConstant () &&
	    operand3.checkConstant ());
  }
  
  /** 
    * override
    *
    * @see Expression
    */
  void preEmitForMethodInvocation () { 
    if (result != null) return;

    operand1.preEmitForMethodInvocation ();

    if (!(operand2 instanceof MethodInvocationExp) &&
	!(operand3 instanceof MethodInvocationExp)) return;

    Emitter.emitln (line_no);
    String tmp = "_conditional_val_" + count++;
    Emitter.emitln (type + " " + tmp + ";");
    Emitter.emit ("if (" + operand1 + ") {");
    Emitter.indentPush ();
    operand2.preEmitForMethodInvocation ();
    Emitter.emitln ();
    Emitter.emit (tmp + " = " + operand2 + ";");
    Emitter.indentPop ();
    Emitter.emitln ();
    Emitter.emit ("} else {");
    Emitter.indentPush ();
    operand3.preEmitForMethodInvocation ();
    Emitter.emitln ();
    Emitter.emit (tmp + " = " + operand3 + ";");
    Emitter.indentPop ();
    Emitter.emitln ();
    Emitter.emit ("}");

    result = tmp;
  }
  
  /** 
    * override
    */
  public String toString () {
    if (result != null) return result;

    StringBuffer s = new StringBuffer ();
    s.append (operand1);
    s.append (" ? ");
    s.append (operand2);
    s.append (" : ");
    s.append (operand3);
    return s.toString ();
  }
}

/* EOF */

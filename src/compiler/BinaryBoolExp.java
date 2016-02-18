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
 * $Id: BinaryBoolExp.java,v 0.12 1998-01-30 11:04:41+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.6
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing bainary operator expression  of which type is bool.
  *
  * @see BinaryExp
  * @see AssignBoolExp
  * @see ParserActionExp
  */

class BinaryBoolExp extends BinaryExp {
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
    * @param o1 left hand of expression
    * @param o2 rigth hand of expression
    * @param k kind of operator
    */
  BinaryBoolExp (Expression o1, Expression o2, int k) {
    super (o1, o2, k);
  }
  
  /**
    * override 
    *
    * @see Expression
    */
  protected void setType() {
    type = PrimitiveType.BOOL;

    Type t1 = operand1.type, t2 = operand2.type;

    if (t1 == null || t2 == null) return;

    if (t1 != PrimitiveType.BOOL || !t1.isSame (t2))
      OzcError.typeMismatch (t1, t2);
  }
  
  /**
    * override 
    *
    * @see Expression
    */
  void preEmitForMethodInvocation () {
    /*
    if (!(operand1 instanceof MethodInvocationExp) &&
	!(operand2 instanceof MethodInvocationExp)) return;
    */

    Emitter.emitln ();
    result = "bool$val$" + count++;
    Emitter.emit ("boolean " + result);
    Emitter.emitln (";");

    operand1.preEmitForMethodInvocation ();
    Emitter.emitln ();
    Emitter.emit (result + " = " + operand1);

    Emitter.emitln (";");
    if (kind == sym.ANDAND) 
      Emitter.emit ("if (" + result + ") {");
    else
      Emitter.emit ("if (!" + result + ") {");
    Emitter.indentPush ();

    operand2.preEmitForMethodInvocation ();
    Emitter.emitln ();
    Emitter.emit (result + " = " + operand2 + ";");
    Emitter.indentPop ();
    Emitter.emitln ();
    Emitter.emit ("}");
  }
  
  /** 
    * override
    */
  public String toString () {
    if (result != null) return result;

    StringBuffer s = new StringBuffer ();
    s.append (operand1);
    switch (kind) {
    case sym.ANDAND:
      s.append (" && ");
      break;
    case sym.OROR:
      s.append (" || ");
      break;
    }
    s.append (operand2);
    return s.toString ();
  }
}

/* EOF */

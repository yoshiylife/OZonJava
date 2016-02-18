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
 * $Id: Expression.java,v 0.13 1998-03-19 14:22:14+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * Expression class, representing any expression for OZ language compiler 
  */

class Expression {
  /**
    * type of expression 
    */
  protected Type type;
  
  /**
    * wild card expression, for error processing 
    */
  static final Expression ANY = new Expression ();

  /**
    * line number 
    */
  int line_no;
  
  /**
    * is loop conditional expression
    */
  protected boolean is_conditional;
  
  /**
    * method in which implemented this expression
    */
  protected MethodType implemented_in;
  
  /**
    * flag need emitting with pre-checking for security checking
    */
  protected boolean need_pre_emitting;
  
  /**
    * create a node of abstract syntax tree
    */
  protected Expression () { type = Type.ANY; }

  /**
    * create a node of abstract syntax tree
    *
    * @param ln line number
    */
  protected Expression (int ln) { line_no = ln; }

  /**
    * additional emitting only for method invocaiton, other none 
    */
  void preEmitForMethodInvocation () {}

  /**
    * access for type field
    *
    * @return type
    */
  Type getType () { return type; }

  /**
    * check if constant expression 'false' 
    *
    * @return if so true, otherwise false
    */
  boolean isFalse () { return false; } 

  /**
    * check if constant expression 'true' 
    *
    * @return if so true, otherwise false
    */
  boolean isTrue () { return false; } 

  /**
    * check if attribute reference expression 
    *
    * @return if so true, otherwise false
    */
  boolean isAttributeReference () { return false; } 

  /**
    * check expression unrecognized in parsing 
    */
  void check () {}

  /**
    * set expression type
    */
  void setType () {}

  /**
    * check if expression is constant 
    *
    * @return if so true, otherwise false.
    */
  boolean checkConstant () { return false; }

  /**
    * set line number field 
    *
    * @param ln line number
    */
  void setLineNumber (int ln) { line_no = ln; }

  /**
    * access for line number field
    *
    * @return line number
    */
  int getLineNumber () { return line_no; }

  /**     
    * check if expresion is loop conditional expression
    *
    * @return if so true, otherwise false.
    */
  boolean isConditional () { return is_conditional; }

  /**
    * set flag to pre-emit
    */
  void setPreEmittingFlag () { /* nothing */ }

  /**
    * get represention as java Object
    */
  String toStringAsObject () {
    return toString ();
  }
}

/* EOF */

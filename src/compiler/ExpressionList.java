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
 * $Id: ExpressionList.java,v 0.6 1997-09-17 16:48:24+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing list of expressions.
  *
  * @see java.util.Vector
  * @see Expression
  */

class ExpressionList extends java.util.Vector {
  /**
    * add expression to list 
    *
    * @param exp expression
    */
  void add (Expression exp) {
    addElement (exp);
  }
  
  /**
    * get Expression 
    *
    * @param i index 
    * @return expression
    */
  Expression get (int i) { return (Expression) elementAt (i); }

  /**
    * create String instance containing only expression 
    *
    * @return String instance
    */
  String toStringWithoutType () {
    StringBuffer s = new StringBuffer ();
    for (int i = 0; i < elementCount; i++) {
      s.append (get (i));
      if (i + 1 < elementCount) s.append (", ");
    }
    return s.toString ();
  }

  /**
    * create String instance containing only type
    *
    * @param Stirng instance
    */
  String toStringOnlyType () {
    StringBuffer s = new StringBuffer ();
    for (int i = 0; i < elementCount; i++) {
      s.append (get (i).type);
      if (i + 1 < elementCount) s.append (", ");
    }
    return s.toString ();
  }

  /**
    * additional emitting only for method invocaiton 
    */
  void preEmitForMethodInvocation () {
    for (int i = 0; i < elementCount; i++) 
      get (i).preEmitForMethodInvocation ();
  }

  /**
    * emit expressions without type
    */
  void emit () {
    Emitter.emit (toStringWithoutType ());
  }

  /**
    * emit expressions with type (for subclass definition)
    *
    * @return String instance
    */
  String toStringWithType () { return null; }

  /**
    * check expression unrecognized in parsing 
    */
  void check () {
    for (int i = 0; i < elementCount; i++)
      get (i).check ();
  }

  /**
    * set flag to pre-emit
    */
  void setPreEmittingFlag () {
    for (int i = 0; i < elementCount; i++)
      get (i).setPreEmittingFlag ();
  }
}

/* EOF */



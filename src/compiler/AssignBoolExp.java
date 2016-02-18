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
 * $Id: AssignBoolExp.java,v 0.6 1997-07-02 16:35:34+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.6
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing boolean assign operator expression.
  * 
  * @see BinaryBoolExp
  * @see ParserAction
  * @see sym
  */

class AssignBoolExp extends BinaryBoolExp {
  /** 
    * create a node of abstract syntax tree
    *
    * @param l left hand expression 
    * @param r right hand expression 
    * @param k kind of operator
    */
  AssignBoolExp (Expression l, Expression r, int k) {
    super (l, r, k);
  }
  
  /** 
    * override
    */
  void preEmitForMethodInvocation () {
    operand2.preEmitForMethodInvocation ();
  }

  /** 
    * override
    */
  public String toString () {
    StringBuffer s = new StringBuffer ();
    s.append (operand1);
    switch (kind) {
    case sym.ANDANDEQUAL:
      if (Emitter.isEmitting ())
	s.append (" = " + operand1 + " && ");
      else
	s.append (" &&= ");
      break;
    case sym.OROREQUAL:
      if (Emitter.isEmitting ())
	s.append (" = " + operand1 + " || ");
      else
	s.append (" ||= ");
      break;
    }
    s.append (operand2);
    return s.toString ();
  }
}

/* EOF */

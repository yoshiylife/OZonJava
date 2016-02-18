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
 * $Id: AssignExp.java,v 0.17 1998-01-22 08:45:35+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing assign operator expression.
  *
  * @see ParserAction
  * @see BinaryExp
  * @see sym
  */

class AssignExp extends BinaryExp {
  /**
    * casted type of right operand 
    */
  Type casted;
  
  /** 
    * create a node of abstract tree 
    * 
    * @param l left hand expression
    * @param r right hand expression
    * @param k kind of operator
    */
  AssignExp (Expression l, Expression r, int k) { 
    super (l, r, k); 
  }
  
  /**
    * override
    * 
    * @see Expression
    */
  protected void check () {
    operand1.check ();
    operand2.check ();

    Type t1 = operand1.getType ();

    /* operand1 is class type */
    if (t1 == null || t1.isClass ()) {
      Variable lval = (Variable) operand1;
	
      operand1.line_no = line_no;
      Identifier.setState (lval, operand2);
    }
  }

  /**
    * override
    * 
    * @see Expression
    */
  protected void setType () {
    Type t1 = operand1.type, t2 = operand2.type;

    if (type == null) {
      if (kind == sym.EQUALBAR && (t1 == null || t2 == null)) return;

      type = t1;
    } else if (!type.isAssignable (operand1.type)) {
      /* for class type checking;
       * type was set previously, operand1.type is set newly.
       * operand1.type must be assignable to type */
      OzcError.typeMismatch (operand1.type, type);
    }

    if (t1 == null || t2 == null) return;

    if (!t1.isAssignable (operand2)) {
      if (kind != sym.EQUALBAR) 
	OzcError.typeMismatch (t2, t1);
      else {
	if (t2.isAssignable (t1)) {
	  if (ozc.isTest ()) {
	    ozc.debug (line_no + ": left type is " + t1);
	    ozc.debugln (", casted type is " + t2);
	  }
	  casted = t1;
	} else
	  OzcError.typeMismatch (t1, t2);
      }
    }
  }

  /**
    * override
    */
  public String toString () {
    StringBuffer s = new StringBuffer ();
    s.append (operand1);
    switch (kind) {
    case sym.EQUAL:
      s.append (" = ");
      s.append (operand2);
      break;
    case sym.EQUALBAR:
      if (Emitter.isEmitting ()) {
	s.append (" = ");
	if (casted != null) {
	  s.append ('(');
	  s.append (casted);
	  s.append (") (");
	  s.append (operand2);
	  s.append (")");
	  break;
	}
      } else 
	s.append (" =| ");
      s.append (operand2);
      break;
    }
    return s.toString ();
  }
}

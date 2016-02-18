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
 * $Id: Literal.java,v 0.11 1998-03-19 14:22:19+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.11.29
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing literal.
  *
  * @see Expression
  */

class Literal extends Expression {
  /**
    * value of literal 
    */
  private String value;

  /**
    * pre-emitted value
    */
  private String result;

  /**
    * counter for pre emitting 
    */
  private static int count;

  /**
    * create a node of abstract syntax tree
    *
    * @param v contents
    * @param t type
    * @param ln line number
    */
  Literal (String v, Type t, int ln) { 
    super (ln);
    value = v; 
    type = t; 
  }

  /**
    * create a node of abstract syntax tree
    *
    * @param v contents
    * @param ln line number
    */
  Literal (String v, int ln) { 
    super (ln);
    value = v;
    type = School.STRING.getInterface ();
  }
  
  /**
    * check if constant expression 'false' 
    * 
    * @return if so true, otherwise false
    */
  boolean isFalse () { return value.equals ("false"); }

  /**
    * check if expression is constant 
    * 
    * @return if so true, otherwise false
    */
  boolean checkConstant () { return true; }

  /**
    * check if constant expression 'true' 
    * 
    * @return if so true, otherwise false
    */
  boolean isTrue () { return value.equals ("true"); } 

  /**
    * acccess for value field
    *
    * @return value
    */
  String getValue () { return value; }

  /**
    * override
    */
  public String toString () { 
    if (result != null) return result;

    if (!Emitter.isEmitting ()) return value;

    if (type.isPrimitive ()) {
/*
      if (type == PrimitiveType.FLOAT)
	return value.substring (0, value.length () - 1); 

      if (type == PrimitiveType.DOUBLE) {
	StringBuffer s = new StringBuffer ();
	s.append (value);
	s.append ('D');
	return s.toString ();
      }
*/
      return value;
    } 

    if (value.equals ("null")) return value;
      
    /* string literal */
    StringBuffer s = new StringBuffer ();
    s.append ('(');
    s.append ("new ");
    s.append (School.STRING);
    s.append ('(');
    s.append (value);
    s.append ("))");
    return s.toString ();
  }

  /**
    * override
    *
    * @see Expression
    */
  void preEmitForMethodInvocation () { 
    if (result != null) return;

    if (!need_pre_emitting) return;

    String tmp = "string$" + count++;
    Emitter.emitln (line_no);
    Emitter.emitln (School.STRING.getInterface ().toString () + ' ' + tmp
		    + " = " + toString () + ";");
    result = tmp;
  }

  /**
    * set flag to pre-emit
    */
  void setPreEmittingFlag () {
    if (type == School.STRING.getInterface ())
      need_pre_emitting = true;
  }

  /**
    * get represention as java Object
    */
  String toStringAsObject () {
    if (type.isPrimitive ()) {
      StringBuffer s = new StringBuffer ();
      s.append ("new ");
      s.append (((PrimitiveType) type).toStringAsJavaClassName ());
      s.append (" (");
      s.append (toString ());
      s.append (')');
      return s.toString ();
    } else {
      return toString ();
    }
  }
}

/* EOF */



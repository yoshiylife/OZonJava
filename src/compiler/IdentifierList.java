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
 * $Id: IdentifierList.java,v 0.9 1997-07-11 18:25:48+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing list of identifiers.
  *
  * @see ExpressionList
  * @see Identifier
  */

class IdentifierList extends ExpressionList {
  /**
    * get a identifier
    * 
    * @param i index
    * @return identifier
    */
  Identifier geti (int i) { return (Identifier) elementAt (i); }
  
  /**
    * emit without each type 
    */
  void emit () {
    for (int i = 0; i < elementCount; i++) {
      Identifier id = geti (i);
      Expression exp = id.exp;
      if (Emitter.isEmitting ()) {
	if (exp != null) {
	  if (! (exp instanceof InstantiationExp)) {
	    Emitter.emit (id);
	    Emitter.emit (" = ");
	  }
	  Emitter.emit (exp);
	} else {
	  Emitter.emit (id);
	  Type t = id.getType ();
	  if (t.isClass ())
	    Emitter.emit (" = null");
	  else if (t.isBool ())
	    Emitter.emit (" = false");
	  else if (t.isChar ())
	    Emitter.emit (" = '\\0'");
	  else if (t.isCondition ())
	    Emitter.emit (" = new "+ OzcProperty.CONDITION + " (this)");
	  else
	    Emitter.emit (" = 0");
	}
      } else {
	if (exp != null) {
	  if (!(exp instanceof InstantiationExp)) {
	    Emitter.emit (id);
	    Emitter.emit (" = ");
	  } 
	  Emitter.emit (exp);
	} else 
	  Emitter.emit (id);
      }
      if (i + 1 < elementCount) Emitter.emit (", ");
    }
  }

  /**
    * create String instance with each type 
    *
    * @return String instance
    */
  String toStringWithType () {
    StringBuffer s = new StringBuffer ();
    for (int i = 0; i < elementCount; i++) {
      Identifier id = geti (i);
      s.append (id.type);
      if (id.name != null) {
	s.append (' ');
	s.append (id);
      }
      if (i + 1 < elementCount) s.append (", ");
    }
    return s.toString ();
  }

  /**
    * check expression unrecognized in parsing 
    */
  void check () {
    for (int i = 0; i < elementCount; i++) {
      Identifier id = geti (i);
      Expression exp = id.exp;
      
      if (exp != null) {
	exp.check ();
      
	if (id.getType ().isClass ()) {
	  id.line_no = exp.line_no;
	  Identifier.setState (id, exp);
	}
      }
    }
  }
}

/* EOF */

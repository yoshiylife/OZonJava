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
 * $Id: AttributeAccessExp.java,v 0.17 1998-03-19 14:22:10+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1997.1.21
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing expression of attribute accesssing.
  *
  * @see Expression
  * @see ParserAction
  * @see UnaryExp
  * @see Variable
  */

class AttributeAccessExp extends Expression implements Variable {
  /**
    * accessing object 
    */
  Expression operand;

  /**
    * accessing attribute 
    */
  Identifier attribute;

  /**
    * used class
    */
  ClassImplementation used_class;

  /**
    * string token for late searching for class symbol
    */
  OzStrToken token;

  /**
    * create a node of abstract syntax tree
    */
  AttributeAccessExp () {
  }

  /**
    * create a node of abstract syntax tree
    *
    * @param obj accessing object    
    * @param a accessing attribute
    * @param ln line number
    * @param nt string token
    */
  AttributeAccessExp (Expression obj, ClassMember a, 
		      ParserAction action, int ln, OzStrToken nt) {
    super (ln);

    operand = obj;
    attribute = a;
    type = a.getType ();
    implemented_in = action.getMethod ();
    used_class = action.getCls ();
    token = nt; 
  }

  /**
    * override
    *
    * @see Expression
    */
  boolean isAttributeReference () { return true; } 

  /**
    * access for attribute 
    *
    * @return accessing attribute
    */
  ClassMember getAttribute () { return (ClassMember) attribute; }

  /**
    * override 
    *
    * @see Expression
    */
  void preEmitForMethodInvocation () {
    if (operand == null ||
	operand instanceof InstantiationExp) return;

    operand.preEmitForMethodInvocation ();
  }
  
  /** 
    * override 
    */
  public String toString () {
    StringBuffer s = new StringBuffer ();
    if (operand != null) {
      if (Emitter.isEmitting ()) {
	Type t = operand.getType ();
	ClassImplementation c;
	if (t instanceof ClassInterface) 
	  c = ((ClassInterface) t).getImplementation ();
	else
	  c = (ClassImplementation) t;
	s.append ("((");
	s.append (c);
	s.append (')');
	s.append (operand);
	s.append (").");
      } else {
	s.append (operand);
	s.append ("->");
      }
    } 

    s.append (attribute);
    return s.toString ();
  }

  /* following static methods are for action of parser */

  /**
    * create a node of abstract syntax tree 
    * 
    * @param name accessing attribute name
    * @param ln line number 
    * @param action current ParserAction object
    * @return created node
    */
  static Expression create (String name, int ln, ParserAction action) {
    return create (null, name, ln, action, null);
  }

  /**
    * create a node of abstract syntax tree 
    * 
    * @param name accessing attribute name
    * @param ln line number 
    * @param action current ParserAction object
    * @param nt string token
    * @return created node
    */
  static Expression create (String name, int ln, ParserAction action, 
			    OzStrToken nt) { 
    return create (null, name, ln, action, nt);
  }

  /**
    * create a node of abstract syntax tree 
    * 
    * @param e accessing object 
    * @param name accessing attribute name
    * @param ln line number 
    * @param action current ParserAction object
    * @return created node
    */
  static Expression create (Expression e, String name, int ln, 
			    ParserAction action) {
    return create (e, name, ln, action, null);
  }
    
  /**
    * create a node of abstract syntax tree 
    * 
    * @param e accessing object 
    * @param name accessing attribute name
    * @param ln line number 
    * @param action current ParserAction object
    * @param nt string token
    * @return created node
    */
  static Expression create (Expression e, String name, int ln, 
			    ParserAction action, OzStrToken nt) {
    
    ClassImplementation cls = action.getCls ();

    if (action.isParsing ()) {
      ClassMember m = action.getMethodSymbol ();

      /* static method cannot access any attribute */
      if (m.isStatic ()) {
	/* maybe class symbol, because cannot found attribue */
	ClassSymbol cs = action.searchClassSymbol (nt);
	if (cs != null) {
	  cs.setLineNumber (nt.line_no);
	  return cs;
	}

	OzcError.cannotAccessAttribute (cls);
	return Expression.ANY;
      }
    }

    ClassImplementation c;
    if (e != null) {
      if (e instanceof ClassSymbol) {
	OzcError.cannotUseClassSymbol (e);
	return Expression.ANY;
      }

      if (e.type == null) return Expression.ANY;

      if (!e.type.isClass ()) {
	if (e.type != Type.ANY) {
	  /* expression is not any class type */
	  OzcError.notClass (e.type);
	}
	return Expression.ANY;
      }

      if (e.type instanceof ClassImplementation) 
	c = (ClassImplementation) e.type;
      else
	c = ((ClassInterface) e.type).getImplementation ();

      /* if this class or one in file, then can be access PRIVATE member */
      if (!action.isParsingIt (c)) {
	if (action.isParsing ()) 
	  action.addToNotFoundList (c);
	else {
	  OzcError.cannotAccessAttribute (c);
	  return Expression.ANY;
	}
      } else if (!c.isProtected () && !(e instanceof ThisExp)) {
	OzcError.cannotAccessAttribute (c);
	return Expression.ANY;
      }

      if (c.isGlobal ()) {
	/* cannot access any attribute of global object not this */
	OzcError.cannotAccessAttributeOfGlobalObject (c);
	return Expression.ANY;
      }
    } else
      c = cls;
      
    ClassMember id = c.searchAttribute (name);
    if (id == null) {
      if (action.isParsing ())
	return createDummy (e, name, c, ln, action, nt);

      if (nt != null) {
	/* maybe class symbol, because cannot found attribue */
	ClassSymbol cs = action.searchClassSymbol (nt);
	if (cs != null) {
	  cs.setLineNumber (nt.line_no);
	  return cs;
	}
      }
	
      /* not defined identifier as attribute */
      OzcError.notDefinedAttribute (name, c);
//      cls.registerAttribute (ClassMember.ANY, name);
//      return Expression.ANY;
      return null;

    } else if (id == ClassMember.ANY) 
      return createDummy (e, name, c, ln, action, nt);

    return new AttributeAccessExp (e, id, action, ln, nt);
  }

  /**
    * create a dummy node of abstract syntax tree.
    * a dummy node is resolved later.
    *
    * @param e accessing object
    * @param mane accessing attribute name
    * @param c a class defining accessign attribute
    * @param nt string token
    * @return created node
    */
  static Expression createDummy (Expression e, String name, 
				 ClassImplementation c, int ln, 
				 ParserAction action, OzStrToken nt) {
    if (!action.isParsing ()) return Expression.ANY;

    ClassMember id = new ClassMember (name);
    Expression exp = new AttributeAccessExp (e, id, action, ln, nt);
    id.setDefinedClass (c);
    action.addToNotCheckedList (exp);
    return exp;
  }
    
  /**
    * for attribute access expression, check method after parsing. 
    *
    * @param exp a node of abstract syntax tree
    * @param action ParserAction object
    */
  static void check (AttributeAccessExp exp, ParserAction action) { 
    Expression e;
    try {
      if (exp.operand == null) {
	ClassMember cm = (ClassMember) exp.attribute;
	action.setCls ((ClassImplementation) cm.getDefinedClass ());
      }
      
      action.setMethod (exp.implemented_in);
      e = create (exp.operand, exp.attribute.name, exp.line_no, action, 
		  exp.token);
    } finally {
      action.setCls (null);
    }
	
    if (e == null || e == Expression.ANY) return;

    action.checkExpressionType (e, exp);

    if (e instanceof ClassSymbol) 
      exp.attribute = (ClassSymbol) e;
    else
      exp.attribute = ((AttributeAccessExp) e).attribute;
    exp.type = e.type;
  }

  /**
    * change to NULL
    */
  public void changeNull () {
    if (ozc.isVerboseDeeply ())
      ozc.debugln (OzcError.getSource () + ":" + line_no + ": '" + this + 
		   "' change to null.");
    attribute.state = NULL;
  }

  /**
    * change to ASSIGNED_GREEN
    */
  public void changeGreen () {
    if (ozc.isVerboseDeeply ())
      ozc.debugln (OzcError.getSource () + ":" + line_no + ": '" + this + 
		   "' change to green.");
    attribute.state = ASSIGNED_GREEN;
  }

  /**
    * change to ASSIGNED_MAYBE_RED
    */
  public void changeMaybeRed () {
    if (ozc.isVerboseDeeply ())
      ozc.debugln (OzcError.getSource () + ":" + line_no + ": '" + this + 
		   "' change to red maybe.");
    attribute.state = ASSIGNED_MAYBE_RED;
  }

  /**
    * change to UNKNOWN
    */
  public void changeUnknown () {
    if (ozc.isVerboseDeeply ())
      ozc.debugln (OzcError.getSource () + ":" + line_no + ": '" + this + 
		   "' change to unknown.");
    attribute.state = UNKNOWN;
  }

  /**
    * check if state is NULL
    *
    * @return if so true, otherwise false
    */
  public boolean isNull () { return attribute.state == NULL; }

  /**
    * check if state is ASSIGNED_GREEN
    *
    * @return if so true, otherwise false
    */
  public boolean isGreen () { return attribute.state == ASSIGNED_GREEN; }

  /**
    * check if state is ASSIGNED_MAYBE_RED
    *
    * @return if so true, otherwise false
    */
  public boolean isMaybeRed () { 
    return attribute.state == ASSIGNED_MAYBE_RED; 
  }

  /**
    * check if state is UNKNOWN
    *
    * @return if so true, otherwise false
    */
  public boolean isUnknown () { return attribute.state == UNKNOWN; }

  /**
    * acceess for state 
    *
    * @return state value
    */
  public int getState () { return attribute.state; }

  /**
    * copy state
    *
    * @param id variable
    */
  public void copyState (Variable id) { 
    attribute.state = id.getState (); 
    if (ozc.isVerboseDeeply ()) {
      if (attribute.state == NULL) 
	ozc.debugln (OzcError.getSource () + ":" + line_no + ": '" + this + 
		     "' change to null.");
      else if (attribute.state == ASSIGNED_GREEN) 
	ozc.debugln (OzcError.getSource () + ":" + line_no + ": '" + this + 
		     "' change to green.");
      else if (attribute.state == ASSIGNED_MAYBE_RED) 
	ozc.debugln (OzcError.getSource () + ":" + line_no + ": '" + this + 
		     "' change to red maybe.");
      else if (attribute.state == UNKNOWN) 
	ozc.debugln (OzcError.getSource () + ":" + line_no + ": '" + this + 
		     "' change to unknown.");
    }
  }

  /**
    * check expression unrecognized in parsing 
    */
  void check () {
    if (operand != null)
      operand.check ();

    if (attribute instanceof ClassSymbol) return;

    /* set attribute state */
    attribute.line_no = line_no;

    ClassMember cm = implemented_in.getMethod ();
    ClassType ct = ((ClassMember) attribute).getDefinedClass ();
    if (ct == null) {
      attribute.changeUnknown ();
    } else if (!implemented_in.isAccessed ((ClassMember) attribute)) {
      if (!cm.isNew ()) {
	attribute.changeMaybeRed ();
      } else if (ct != used_class) {
	attribute.changeMaybeRed ();
      } else {
	/* must be implemented wisely */
	attribute.changeMaybeRed ();
      }
    }
  }
}

/* EOF */

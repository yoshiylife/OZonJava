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
 * $Id: Identifier.java,v 0.16 1998-03-19 14:22:18+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.11.29
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing identifier.
  *
  * @see Expression
  * @see Constants
  * @see Variable
  */

class Identifier extends Expression implements Constants, Variable {
  /**
    * name of identifier 
    */
  protected String name;

  /**
    * emitting name 
    */
  protected String emit_name;

  /**
    * expression for initialization 
    */
  protected Expression exp;

  /**
    * state of class or cell type identifier
    */
  protected int state;

  /**
    * for label
    */
  LabelSt st;

  /**
    * state value
    */
  static final int NULL = 0x00;
  static final int ASSIGNED_GREEN = 0x01;
  static final int ASSIGNED_MAYBE_RED = 0x02;

  /**
    * wild card object, for error status processing 
    */
  static final Identifier ANY = new Identifier ("oz$any", Type.ANY, 0);

  /**
    * create a node of abstract syntax tree 
    *
    * @param s name 
    * @param t type
    * @param e intilalization expression
    * @param ln line number
    */
  Identifier (String s, Type t, Expression e, int ln) {
    super (ln);
    name = s;
    type = t;
    exp = e;

/*     if (e != null) { */
/*       if (!type.isAssignable (exp))  */
/* 	OzcError.typeMismatch (exp.getType (), type); */
/*     } */
  }

  /**
    * create a node of abstract syntax tree 
    *
    * @param s name 
    * @param t type
    * @param ln line number
    */
  Identifier (String s, Type t, int ln) {
    this (s, t, null, ln);
  }

  /**
    * create a node of abstract syntax tree 
    *
    * @param s name 
    */
  Identifier (String s) {
    this (s, null, null, 0);
  }

  /**
    * create a node of abstract syntax tree 
    *
    * @param t type
    */
  Identifier (Type t) {
    this (null, t, null, 0);
  }

  /**
    * access for name field
    *
    * @return name
    */
  String getName () { return name; }

  /**
    * access for exp field
    * 
    * @return expression.
    */
  Expression getExp () { return exp; }

  /**
    * check if two identifiers (method) are exactly same 
    *
    * @return if so true, otherwise false
    */
  protected boolean isSame (Identifier m) {
    if (!type.isSame (m.type)) return false;
    return true;
  }

  /**
    * override
    *
    * @see Expression
    */
  void preEmitForMethodInvocation () { 
    if (exp != null) 
      exp.preEmitForMethodInvocation ();
  }

  /**
    * add postfix for reserved words of defined in previous block 
    *
    * @param s containing result
    */
  void addPostfix (StringBuffer s) {
    s.append (name);
    s.append ('$');
    s.append (Emitter.getPostfix ());
  }

  /**
    * add postfix for reserved words of defined in previous block 
    */
  void addPostfix () {
    StringBuffer s = new StringBuffer ();
    addPostfix (s);
    emit_name = s.toString ();
  }

  /**
    * override
    */
  public String toString () {
    if (!Emitter.isEmitting ()) return name;

    if (emit_name != null) return emit_name;
    return name;
  }
  
  /**
    * change to NULL
    */
  public void changeNull () {
    if (ozc.isVerboseDeeply ())
      ozc.debugln (OzcError.getSource () + ":" + line_no + ": '" + this + 
		   "' change to null.");
    state = NULL;
  }

  /**
    * change to ASSIGNED_GREEN
    */
  public void changeGreen () {
    if (ozc.isVerboseDeeply ())
      ozc.debugln (OzcError.getSource () + ":" + line_no + ": '" + this + 
		   "' change to green.");
    state = ASSIGNED_GREEN;
  }

  /**
    * change to ASSIGNED_MAYBE_RED
    */
  public void changeMaybeRed () {
    if (ozc.isVerboseDeeply ())
      ozc.debugln (OzcError.getSource () + ":" + line_no + ": '" + this + 
		   "' change to red maybe.");
    state = ASSIGNED_MAYBE_RED;
  }

  /**
    * change to UNKNOWN
    */
  public void changeUnknown () {
    if (ozc.isVerboseDeeply ())
      ozc.debugln (OzcError.getSource () + ":" + line_no + ": '" + this + 
		   "' change to unknown.");
    state = UNKNOWN;
  }

  /**
    * check if state is NULL
    *
    * @return if so true, otherwise false
    */
  public boolean isNull () { return state == NULL; }

  /**
    * check if state is ASSIGNED_GREEN
    *
    * @return if so true, otherwise false
    */
  public boolean isGreen () { return state == ASSIGNED_GREEN; }

  /**
    * check if state is ASSIGNED_MAYBE_RED
    *
    * @return if so true, otherwise false
    */
  public boolean isMaybeRed () { return state == ASSIGNED_MAYBE_RED; }

  /**
    * check if state is UNKNOWN
    *
    * @return if so true, otherwise false
    */
  public boolean isUnknown () { return state == UNKNOWN; }

  /**
    * acceess for state 
    *
    * @return state value
    */
  public int getState () { return state; }

  /**
    * copy state
    *
    * @param id variable
    */
  public void copyState (Variable id) { 
    state = id.getState (); 
    if (ozc.isVerboseDeeply ()) {
      if (state == NULL) 
	ozc.debugln (OzcError.getSource () + ":" + line_no + ": '" + this + 
		     "' change to null.");
      else if (state == ASSIGNED_GREEN) 
	ozc.debugln (OzcError.getSource () + ":" + line_no + ": '" + this + 
		     "' change to green.");
      else if (state == ASSIGNED_MAYBE_RED) 
	ozc.debugln (OzcError.getSource () + ":" + line_no + ": '" + this + 
		     "' change to red maybe.");
      else if (state == UNKNOWN) 
	ozc.debugln (OzcError.getSource () + ":" + line_no + ": '" + this + 
		     "' change to unknown.");
    }
  }

  /**
    * set state
    *
    * @param lval left variable
    * @param op operand
    */
  static void setState (Variable lval, Expression op) {
    if (op instanceof Variable) {
      lval.copyState ((Variable) op);
    } else if (op instanceof Literal) {
      if (op.getType () == School.ROOT.getInterface ())
	lval.changeNull ();
      else
	lval.changeGreen ();
    } else
      lval.changeMaybeRed ();
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

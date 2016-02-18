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
 * $Id: ClassMember.java,v 0.21 1997-10-22 17:00:09+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1997.2.16
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing class member.
  * 
  * @see ClassType
  * @see ClassImplementation
  * @see ClassInterface
  * @see Identifier
  */

class ClassMember extends Identifier {
  /**
    * additional modifier (static, final, locked, once, abstract, transient) 
    */
  protected int modifier;

  /**
    * access modifier (public, protected, private, new) 
    */
  protected int access;

  /**
    * class for attribute or method to be defined 
    */
  protected ClassType defined_class;

  /**
    * definition start offset in file;
    */
  protected int definition_start;

  /**
    * definition end offset in file;
    */
  protected int definition_end;

  /**
    * flag if overrided 
    */
  protected boolean is_overrided;

  /**
    * flag if superclass constrcutor was called
    */
  protected boolean called_super;

  /**
    * wild card object, for error status processing 
    */
  static final ClassMember ANY = new ClassMember ("oz$any", Type.ANY);

  /**
    * create a class member 
    *
    * @param s name 
    * @param t type
    * @param e initialization expression
    * @param mod modifier
    * @param accs acess modifer
    * @param c defined class
    */
  ClassMember (String s, Type t, Expression e, int mod, int accs, 
	       ClassType c) {
    super (s, t, e, 0);
    modifier = mod;
    access = accs;
    defined_class = c;
  }

  /**
    * create a class member 
    *
    * @param s name 
    * @param t type
    * @param mod modifier
    * @param accs acess modifer
    * @param c defined class
    * @param pos offset in file
    */
  ClassMember (String s, Type t, int mod, int accs, ClassType c, int pos) {
    this (s, t, null, mod, accs, c);
    definition_start = pos;
  }

  /**
    * create a class member 
    *
    * @param s name 
    * @param t type
    * @param mod modifier
    * @param accs acess modifer
    * @param c defined class
    */
  ClassMember (String s, Type t, int mod, int accs, ClassType c) {
    this (s, t, null, mod, accs, c);
  }

  /**
    * create a class member 
    *
    * @param s name 
    * @param t type
    * @param ln line number
    */
  ClassMember (String s, Type t, int ln) {
    this (s, t, null, 0, 0, null);
    line_no = ln;
  }

  /**
    * create a class member 
    *
    * @param s name 
    * @param t type
    */
  ClassMember (String s, Type t) {
    this (s, t, null, 0, 0, null);
  }

  /**
    * create a class member 
    *
    * @param s name 
    * @param accs acess modifer
    */
  ClassMember (String s) {
    this (s, null, null, 0, 0, null);
    state = ASSIGNED_MAYBE_RED;
  }

  /**
    * create a class member 
    *
    * @param s name 
    */
  ClassMember (String s, int accs) {
    this (s, null, null, 0, accs, null);
  }

  /**
    * set type, modifier, and acess modifier
    *
    * @param t type
    * @param mod modifier
    * @param accs access modifier
    * @param c defined class
    * @param pos offset in file
    */
  void setType (Type t, int mod, int accs, ClassType c, int spos, int epos) {
    type = t;
    modifier = mod;
    access = accs;
    defined_class = c;
    definition_start = spos;
    definition_end = epos;
  }

  /**
    * check if two member are exactly same.
    * 
    * @param m against class member 
    * @return if same true, otherwise false
    */
  protected boolean isSame (ClassMember m) {
    if (access != m.access || !type.isSame (m.type)) return false;
    return true;
  }

  /**
    * check if a member is abstract method 
    *
    * @return if so true, otherwise else.
    */
  boolean isAbstract () { return (modifier & ABSTRACT) != 0; }

  /**
    * check if a member is final method 
    *
    * @return if so true, otherwise else.
    */
  boolean isFinal () { return (modifier & FINAL) != 0; }

  /**
    * check if a member is final method of java meaning
    *
    * @return if so true, otherwise else.
  boolean isFinalOfJava () { return (modifier & JAVA_FINAL) != 0; } */

  /**
    * check if a member is locked method 
    *
    * @return if so true, otherwise else.
    */
  boolean isLocked () { return (modifier & LOCKED) != 0; }

  /**
    * check if member is once method.
    *
    * @return if so true, otherwise else.
    */
  boolean isOnce () { return (modifier & ONCE) != 0; }

  /**
    * check if member is static method 
    *
    * @return if so true, otherwise else.
    */
  boolean isStatic () { return (modifier & STATIC) != 0; }

  /**
    * access for access field
    *
    * @return access field value
    */
  int getAccess () { return access; }

  /**
    * access for modifier field
    *
    * @return modifier field value.
    */
  int getModifier () { return modifier; }

  /**
    * access for defined_class 
    *
    * @return defined_class field value.
    */
  ClassType getDefinedClass () { return defined_class; }

  /**
    * set defined_class field 
    *
    * @param c defined class
    */
  void setDefinedClass (ClassType c) { defined_class = c; }

  /**
    * check, if access is 'new' 
    * 
    * @return if so true, otherwise false.
    */
  boolean isNew () { return (access & NEW) != 0; }

  /**
    * check, if access is 'public' 
    *
    * @return if so true, otherwise false.
    */
  boolean isPublic () { return (access & PUBLIC) != 0; }
  
  /**
    * check, if access is 'protected' 
    *
    * @return if so true, otherwise false.
    */
  boolean isProtected () { return (access & PROTECTED) != 0; }

  /**
    * check, if access is none 
    *
    * @return if so true, otherwise false.
    */
  boolean isPrivate () { return (access & ACCESS_MASK )== 0; }

  /**
    * check, if this class is 'global' 
    *
    * @return if so true, otherwise false.
    */
  boolean isGlobal () { 
    if (!type.isClass ()) return false;

    return ((ClassType) type).isGlobal ();
  }

  /**
    * override 
    */
  public String toString () {
    String s = super.toString ();

    if (!Emitter.isEmitting () || emit_name != null) return s;

    if (!isNew () && !isFinal ()) return s;

    StringBuffer buf = new StringBuffer ();

    if (isNew ()) 
      buf.append (OzcProperty.NEW_PREFIX);
    else if (isFinal () && /* !isFinalOfJava () && */ 
	     !(type instanceof MethodType))
      buf.append (OzcProperty.FINAL_PREFIX);
    buf.append (s);
    emit_name = buf.toString ();
    return emit_name;
  }

  /**
    * make string of modifiers to emit
    *
    * @return string of modifiers
    */
  String modifiers () {
    StringBuffer s = new StringBuffer ();
    boolean emitting = Emitter.isEmitting ();

    /* emit access modifier */
    if (access == NEW && !emitting)
      s.append ("new ");
    else if (defined_class.isProtected ())
      s.append ("public ");
    else if (access == PUBLIC || access == NEW)
      s.append ("public ");
    else if (access == PROTECTED)
      s.append ("protected ");

    /* additional modifiers */
    if ((modifier & STATIC) > 0 && !emitting)
      s.append ("static ");
    if ((modifier & FINAL) > 0 && (type instanceof MethodType))
      s.append ("final ");
    if ((modifier & LOCKED) > 0 && !emitting) 
      s.append ("locked ");
    if ((modifier & ONCE) > 0 && !emitting) 
      s.append ("once ");
    if ((modifier & ABSTRACT) > 0) 
      s.append ("abstract ");
    if ((modifier & TRANSIENT) > 0) 
      s.append ("transient ");

    return s.toString ();
  }

  /**
    * emit static method interface
    *
    * @param method_number index of method
    */
  void emitAsStatic (int method_number) {
    MethodType mt = (MethodType) type;
    Emitter.emit (modifiers () + type + "{");
    Emitter.indentPush ();
    Emitter.emitln ();
    if (isPublic ()) {
      Emitter.emitln ("checkSecureInvocation ();");
    }
    if (!mt.getReturnType ().isVoid ()) Emitter.emit ("return ");
    Emitter.emit (OzcProperty.STATIC_PREFIX + 
		  this + " (" +
		  mt.getArguments ().toStringWithoutType () + ");");
    Emitter.indentPop ();
    Emitter.emitln ();
    Emitter.emitln ("}");
    Emitter.emitln ();
    Emitter.emit (modifiers () + "static " + mt.getReturnType () + " " +
		  OzcProperty.STATIC_PREFIX + this + " (" +
		  mt.getArguments ().toStringWithType () + 
		  ") throws Exception ");
    mt.emitBody (method_number);
  }

  /**
    * access for deinition_start
    *
    * @return definition_start value
    */
  int getStart () { return definition_start; }

  /**
    * access for deinition_end
    *
    * @return definition_end value
    */
  int getEnd () { return definition_end; }

  /**
    * set deinition_end
    *
    * @param pos definition_end value
    */
  void setEnd (int pos) { definition_end = pos; }

  /**
    * set overrided flag
    */
  void setOverride () { is_overrided = true; }

  /**
    * check if overrided
    *
    * @return if so true, otherwise false
    */
  boolean isOverride () { return is_overrided; }

  /**
    * check if superclass constructor was called
    *
    * @return if so true, otherwise false
    */
  boolean wasCalledSuper () { return called_super; }

  /**
    * superclass constructor was called
    *
    */
  void calledSuper () { called_super = true; }
}

/* EOF */

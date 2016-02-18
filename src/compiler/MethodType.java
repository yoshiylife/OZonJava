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
 * $Id: MethodType.java,v 0.29 1998-02-02 08:31:34+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.11.29
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing specification of method.
  *
  * @see Type
  * @see ClassMember
  */

class MethodType extends Type {
  /**
    * identifier of method  
    */
  private ClassMember method;

  /**
    * return type 
    */
  Type return_type;

  /**
    * argument lists 
    */
  private ExpressionList arguments;

  /**
    * method body 
    */
  CompoundSt body;

  /**
    * method number for once method 
    */
  private int number;

  /**
    * flag, if need aditional return statement 
    */
  private boolean need_return;

  /**
    * list of referencing classes
    */
  private ClassList referencing_classes;

  /**
    * list of instantiating classes
    */
  private ClassList instantiating_classes;

  /**
    * list of used classes
    */
  private java.util.Vector used_classes;

  /**
    * list of offsets of used class
    */
  private java.util.Vector used_class_offsets;

  /**
    * list of accessed attributes
    */
  private java.util.Vector accessed_attributes;

  /**
    * create a node of abstract syntax tree
    *
    * @param m name of method
    * @param r return type
    * @param args arguments
    */
  MethodType (String m, Type r, ExpressionList args) {
    name = m;
    return_type = r;
    arguments = args;
    body = null;
  }

  /**
    * create a node of abstract syntax tree
    *
    * @param m method
    * @param r return type
    * @param args arguments
    */
  MethodType (ClassMember m, Type r, ExpressionList args) {
    this (m.name, r, args);
    method = m;
  }

  /**
    * access for return_type field
    *
    * @return return type
    */
  Type getReturnType () { return return_type; }

  /**
    * access for arguments 
    *
    * @return arguemnets
    */
  ExpressionList getArguments () { return arguments; }

  /**
    * access for number field
    *
    * @return number
    */
  int getNumber () { return number; }

  /**
    * access for body field
    *
    * @return body
    */
  CompoundSt getBody () { return body; }

  /**
    * access for method field
    *
    * @return method
    */
  ClassMember getMethod () { return method; }

  /**
    * set for method field
    *
    * @param m method
    */
  void setMethod (ClassMember m) { method = m; }

  /** 
    * register body 
    *
    * @param b block
    */
  void registerBody (CompoundSt b) {
    body = b;

    if (method.isAbstract ()) {
      OzcError.abstractMethod (method);
    }
  }

  /**
    * check:
    *  constructor must call super constructor at first;
    *  contains unreachable statment;
    *  needs last return statement;
    */
  void check () {
    OzcError.setLineNumber (body.line_no);

  check_constructor:

    if (method.isNew () && !method.wasCalledSuper ()) {
      ClassType c = method.getDefinedClass ();
      ClassImplementation ci;
      if (c.isClassInterface ()) 
	ci = ((ClassInterface) c).getImplementation ();
      else 
	ci = (ClassImplementation) c;
      do {
	ci = ci.getSuperClass ();
	if (ci == null || School.isSystem (ci)) break check_constructor;
      } while (!ci.hasConstructor ());

      OzcError.constructorMustCallSuper (method);
    }

    /* need return statement as last statement */
    try {
      body.check (this);
    } catch (Unreachable e) {
      Statement st = e.getStatement ();
      if (st != null) 
	OzcError.unreachableSt (st);
      else if (method.isNew () && need_return)
	OzcError.unreachableLastSt (body.line_no);
    }
  }

  /**
    * override
    *
    * @see Type
    */
  int compare (Type type) throws TypeMismatch { 
    MethodType m_type;
    int total_diff = 0;
    
    try {
      m_type = (MethodType) type;
    } catch (ClassCastException ex) {
      throw new TypeMismatch ();
    }

    int diff;
    int size = arguments.size ();
    if (size != m_type.arguments.size ()) 
      throw new TypeMismatch ();

    for (int i = 0; i < size; i++) {
      Identifier this_arg = (Identifier) arguments.elementAt (i);
      Expression target_arg = (Expression) m_type.arguments.elementAt (i);

      diff = this_arg.type.compare (target_arg);
      if (diff < 0) 
	throw new TypeMismatch ();
      else if (diff > 0)
	total_diff = 1;
    }

    return total_diff;
  }
 
  /**
    * check this type is more specific, that is most applicable, than another
    *
    * @param type comparing signature
    * @return if so true, otherwise false
    */
  boolean isMoreSpecific (MethodType type) throws OverloadingAmbiguous {
    boolean status = false;

    try {
      for (int i = 0, size = arguments.size (); i < size; i++) {
	Identifier this_arg = (Identifier) arguments.elementAt (i);
	Identifier target_arg = (Identifier) type.arguments.elementAt (i);

	int type_diff = this_arg.type.compare (target_arg.type);
	if (type_diff == 0)
	  continue;
	else if (type_diff > 0) {
	  if (status == true) throw new OverloadingAmbiguous ();
	} else {
	  if (i != 0) throw new OverloadingAmbiguous ();
	  status = true;
	}
      }
    } catch (OverloadingAmbiguous ex) {
      throw ex;
    } catch (TypeMismatch ex) {
      throw new OverloadingAmbiguous ();
    }

    return status;
  }
    
  /**
    * override
    */
  public String toString () {
    StringBuffer s = new StringBuffer ();
  append:
    if (Emitter.isEmitting ()) {
      if (method.isNew ())
	s.append ("Object");
      else
	s.append (return_type);
      s.append(' ');
      s.append(method);
      s.append(" (");
      s.append(arguments.toStringWithType());
      s.append(')');

      /* tempolary implmentation for exception test */
      s.append (" throws Exception ");
    } else {
      if (Emitter.isEmittingForBrowser ()) {
	if (method.isNew ()) {
	  s.append ("c, ");
	  s.append (name);
	} else {
	  s.append ("m, ");
	  s.append (name);
	  s.append (", ");
	  s.append ("0x" + Integer.toHexString (method.getModifier () + 
						method.getAccess ()));
	  s.append (", ");
	  s.append (return_type);
	}
	s.append (", (");
	if (arguments.size () > 0) {
	  s.append (arguments.toStringOnlyType());
	}
	s.append (")");

	int start = method.getStart ();
	if (start == -1) break append;

	s.append (", (");
	if (referencing_classes != null) {
	  s.append (referencing_classes.toStringWithComma ());
	} 
	s.append ("), (");
	if (instantiating_classes != null) {
	  s.append (instantiating_classes.toStringWithComma ());
	}
	s.append ("), (");
	s.append (start + ", " + (method.getEnd () - start + 1));
	s.append (", (");
	emitUsed (s);
	s.append ("))");
      } else {
	s.append(name);
	s.append(" (");
	s.append(arguments.toStringOnlyType());
	s.append(')');
      }
    }
    return s.toString ();
  }

  /**
    * pre-emit once method 
    *
    * @param method_number method number
    */
  void emitOnceBefore (int method_number) {
    Emitter.emitln ();
    if (return_type.isVoid ())
      Emitter.emitln ("if (once_flag$" + method_number + ") return;");
    else
      Emitter.emitln ("if (once_flag$" + method_number 
		       + ") return once_result$" + method_number + ";");
    Emitter.emitln ();
    Emitter.emitln ("once_flag$" + method_number + " = true;");
  }
    
  /**
    * pre-emit method body
    *
    * @param method_number method number
    */
  void emitBody (int method_number) {
    if (body == null) {
      Emitter.emit (";");
      return;
    }

    number = method_number;
    
    Emitter.emit ("{");
    Emitter.indentPush ();

    if (!method.isNew () && !method.isStatic () && 
	(method.isPublic () || method.getDefinedClass ().isProtected ())) {
      Emitter.emitln ();
      Emitter.emit ("checkSecureInvocation ();");
    }

    if (method.isLocked () || method.isOnce ()) {
      Emitter.emitln ();
      Emitter.emitln ("enter ();");
      Emitter.emit ("try {");
      Emitter.indentPush ();
    }

    if (method.isOnce ()) 
      emitOnceBefore (method_number);

    body.emitNoBrace ();

    if (method.isNew () && need_return) {
      Emitter.emitln ();
      if (method.getDefinedClass ().isGlobal ())
	Emitter.emit ("return null;");	
      else
	Emitter.emit ("return this;");
    }

    if (method.isLocked () || method.isOnce ()) {
      Emitter.indentPop ();
      Emitter.emitln ();
      Emitter.emit ("} finally {");
      Emitter.indentPush ();
      Emitter.emitln ();
      Emitter.emit ("leave ();");
      Emitter.indentPop ();
      Emitter.emitln ();
      Emitter.emit ("}");
    }

    Emitter.indentPop ();
    Emitter.emitln ();
    Emitter.emit ("}");
    Emitter.emitln ();
  }

  /**
    * register class as referencing class to current method 
    *
    * @param c class
    */
  void registerReferencing (ClassType c) {
    if (referencing_classes == null) 
      referencing_classes = new ClassList ();
    else if (referencing_classes.contains (c)) 
      return;

    referencing_classes.add (c);
  }

  /**
    * register class as instantiating class to current method 
    *
    * @param c class
    */
  void registerInstantiating (ClassType c) {
    if (instantiating_classes == null) 
      instantiating_classes = new ClassList ();
    else if (instantiating_classes.contains (c)) 
      return;

    instantiating_classes.add (c);
  }

  /**
    * register as used class 
    *
    * @param c class
    * @param pos offset in file
    */
  void registerAsUsed (ClassType c, int pos) {
    if (used_classes == null) {
      used_classes = new java.util.Vector ();
      used_class_offsets = new java.util.Vector ();
    }
    used_classes.addElement (c);
    used_class_offsets.addElement (new Integer (pos));
  }

  /**
    * emit used classes for browser 
    *
    * @param s string buffer for result
    */
  void emitUsed (StringBuffer s) {
    if (used_classes == null) return;

    for (int i = 0, size = used_classes.size (); i < size; i++) {
      ClassType c = (ClassType) used_classes.elementAt (i);
      Integer pos = (Integer) used_class_offsets.elementAt (i);
      s.append ('(');
      s.append (pos.intValue ());
      s.append (", ");
      s.append (c.getName ().length ());
      s.append (", ");
      s.append (c.getFullyQualifiedClassID ());
      if (i + 1 < size)
	s.append ("), ");
      else
	s.append (')');
    }
  }

  /**
    * check if an attribute was accessed here 
    *
    * @param attr attribute
    * @return if so true, otherwise false
    */
  boolean isAccessed (ClassMember attr) {
    if (accessed_attributes == null) {
      accessed_attributes = new java.util.Vector ();
    } else if (accessed_attributes.contains (attr)) {
      return true;
    } 

    accessed_attributes.addElement (attr);
    return false;
  }

  /**
    * check if need return statement as last one
    *
    * @param ln line number
    */
  void checkReturnSt (int ln) {
    if (!return_type.isVoid ())
      OzcError.needReturnSt (ln);
    else 
      need_return = true;
  }
}

/* EOF */

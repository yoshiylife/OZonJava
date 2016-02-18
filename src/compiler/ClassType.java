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
 * $Id: ClassType.java,v 0.35 1998-03-19 14:22:12+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.11.29
 */

package JP.go.ipa.oz.compiler;

import java.io.*;

/**
  * A class representation class type.
  *
  * @see Type
  * @see ClassImplementation
  * @see ClassInterface
  */

abstract class ClassType extends Type implements Constants {
  /**
    * type of null literal
    */
  static ClassType NULL = new ClassInterface ();

  /**
    * id (class name of Java lang.) of class 
    */
  protected String class_id;

  /**
    * package name 
    */
  protected String package_name;

  /**
    * additional modifier for class 
    */
  protected int modifier;

  /**
    * table of defined methods 
    */
  protected MethodTable method_table;

  /**
    * status, whether this class file had been loaded or compiled 
    */
  protected int status;

  /** 
    * status value: created
    */
  protected static final int CLS_NONE = 0;	/* initialized value */

  /** 
    * status value: loaded
    */
  protected static final int CLS_LOADED = 1;

  /** 
    * status value: not loaded and could not compiled
    */
  protected static final int CLS_CANNOT_COMPILE = 2;

  /**
    * abstract method list, in compiling implementaion,
    * check whether all abstract methods implemented 
    */
  protected java.util.Vector abstract_methods;

  /**
    * symbol representaion, to use class method 
    */
  protected ClassSymbol symbol;

  /**
    * ParserAction instance to check class is defind in source 
    */
  protected ParserAction action_obj;

  /**
    * proxy class for global object 
  protected GlobalProxy proxy; */

  /**
    * line number of definition
    */
  protected int line_no;

  /**
    * flag if this has some final method
  protected boolean has_final_methods; */

  /**
    * create a class. for null literal
    */
  ClassType () { name = "null"; }

  /**
    * create a class. for subclass use.
    *
    * @param class_name name of class
    * @param cid class id
    */
  protected ClassType (String class_name, String cid) {
    name = class_name;

    symbol = new ClassSymbol (this);

    if (cid == null) return;

    /* extract package name */
    int dot = cid.lastIndexOf ('.');
    if (dot == -1) {
      package_name = ozc.getDomain () + OzcProperty.USER_PACKAGE_PREFIX;
      class_id = cid;
    } else {
      if (cid.charAt (0) == '.') {
	package_name = ozc.getDomain () + cid.substring (0, dot);
      } else {
	package_name = cid.substring (0, dot);
      }
      class_id = cid.substring (dot + 1);
    }

    if (isProxy ()) {
      int i = class_id.lastIndexOf ('_');
      class_id = class_id.substring (0, i) + OzcProperty.PROXY_PCL_POSTFIX;
    }

    encoded_name = "L" + getFullyQualifiedClassID ();

    java_class = "Class.forName (\"" + getFullyQualifiedClassID () + "\")";
  }

  /**
    * check if type is class.
    * 
    * @return if so true, otherwise false
    */
  final boolean isClass () { return true; }

  /**
    * check if this class is global 
    * 
    * @return if so true, otherwise false
    */
  final boolean isGlobal () { return (modifier & GLOBAL) != 0; }

  /**
    * check if this class is abstract 
    * 
    * @return if so true, otherwise false
    */
  final boolean isAbstract () { return (modifier & ABSTRACT) != 0; }

  /**
    * check if this class is final 
    * 
    * @return if so true, otherwise false
    */
  final boolean isFinal () { return (modifier & FINAL) != 0; }

  /**
    * check if this class has some final methods
    * 
    * @return if so true, otherwise false
  final boolean hasFinalMethods () { return has_final_methods; } */

  /**
    * check if this class is protected 
    * 
    * @return if so true, otherwise false
    */
  final boolean isProtected () { return (modifier & PROTECTED) != 0; }

  /**
    * check if this class is interface 
    * 
    * @return if so true, otherwise false
    */
  boolean isClassInterface () { return false; }

  /**
    * check if this class is loaded 
    * 
    * @return if so true, otherwise false
    */
  final boolean isLoaded () { return status == CLS_LOADED; }

  /**
    * check if this class is proxy for global object
    * 
    * @return if so true, otherwise false
    */
  boolean isProxy () { return false; }

  /**
    * access for package_name field.
    * 
    * @return package name.
    */
  String getPackage () { return package_name; }

  /**
    * access for symbol filed
    *
    * @return symbol
    */
  ClassSymbol getSymbol () { return symbol; }

  /**
    * access for class_id field.
    *
    * @return class_id
    */
  String getClassID () { return class_id; }

  /**
    * access for modifier field.
    *
    * @return modifier
    */
  int getModifier () { return modifier; }

  /**
    * get all super classes 
    *
    * @return super classes
    */
  abstract ClassList getSuperInterfaces();

  /**
    * access for method_table field.
    *
    * @return method_table
    */
  MethodTable getMethodTable () { return method_table; }

  /**
    * access for proxy field
    *
    * @return proxy.
  GlobalProxy getProxy () { return proxy; } */

  /**
    * set action_obj field.
    *
    * @param action action_obj value.
    */
  void setParserAction (ParserAction action) { action_obj = action; }

  /**
    * get fully qualified class id of class_id.
    *
    * @return fully qualified class id 
    */
  String getFullyQualifiedClassID () {
    if (package_name != null) {
      StringBuffer s = new StringBuffer ();
      s.append (package_name);
      s.append ('.');
      s.append (class_id);
      return s.toString ();
    } else
      return class_id;
  }

  /**
    * initialize for compilation
    *
    * @param mod modifier
    */
  void reset (int mod) {
    status = CLS_NONE;
    initialize (mod);
  }

  /**
    * initialize, preparing register methods and attributes:
    *  initalize some tables;
    *  set modifier;
    *
    * @param mod modifier
    */
  void initialize (int mod) {
    if (status == CLS_LOADED) return;

    status = CLS_LOADED;
    modifier = mod;

    abstract_methods = new java.util.Vector ();

    if (!isProxy ()) {
      method_table = new MethodTable ();

      if ((mod & ABSTRACT) != 0 && (mod & FINAL) != 0)
	OzcError.cannotAbstractAndFinalClass (this);

      /* for cell */
      if ((mod & GLOBAL) != 0 && (mod & ABSTRACT) != 0) 
	OzcError.cannotAbstractForCell (this);

      // if (isGlobal () && this != School.CELL) createProxy ();
    }
  }

  /**
    * initialize, preparing register methods and attributes:
    *  initalize some tables;
    *  set modifier as none;
    */
  void initialize () { initialize (0); }

  /**
    * create proxy for global object 
  void createProxy () {
    proxy = new GlobalProxy (this);
    proxy.copyToProxy (this);
  } */

  /**
    * load class file 
    *
    * @return if success true, otherwise false.
    */
  boolean load () {
    if (status == CLS_LOADED) return true;

    if (status == CLS_CANNOT_COMPILE) {
      return false;
    }

    boolean result;
    if (!School.isSystem (this) &&
	action_obj != null && action_obj.isParsing ()) {
      if (!action_obj.isParsingIt (this)) {
//	System.out.print (this + "#");
//	Thread.dumpStack ();

	action_obj.addToNotFoundList (this);
	return false;
      } else
	result = OzcClassLoader.load (this, action_obj);
      if (result) status = CLS_LOADED;
    } else {
      result = OzcClassLoader.load (this, action_obj);
      if (!result) 
	result = compile ();

      if (result) 
	status = CLS_LOADED;
      else 
	OzcError.cannotCompile (this);
    }

    return result;
  }

  /**
    * compile this class 
    *
    * @return if success true, otherwise false.
    */
  boolean compile () {
    return compile (OzcError.getSource ());
  }

  /**
    * compile this class 
    *
    * @param src refered source file
    * @return if success true, otherwise false.
    */
  boolean compile (String src) {
    if (status == CLS_LOADED) return true;

    if (status == CLS_CANNOT_COMPILE) return false;

    File file = new File (src);
    String p = file.getParent ();
    StringBuffer s = new StringBuffer ();
    if (p != null) {
      s.append (p);
      s.append (File.separator);
    }
    s.append (name);
    s.append (ozc.SOURCE_SUFFIX);
    src = s.toString ();
    
    boolean result;
    if (isClassInterface ())
      result = ozc.compileInterface (src);
    else
      result = ozc.compileImplementation (src);
    if (!result) {
      if (status == CLS_NONE)
	initialize ();
      status = CLS_CANNOT_COMPILE;
    }

    return result;
  }

  /**
    * collect all abstract methods from inheritance tree.
    *
    * @param abstract_methods collected methods.
    */
  void getAbstractMethods (java.util.Hashtable abstract_methods) {
    if (!load ()) return;

    for (int i = 0, size = this.abstract_methods.size (); i < size; i++) {
      ClassMember m = (ClassMember) this.abstract_methods.elementAt (i);
      abstract_methods.put (m.type.toString (), m);
    }
  }

  /**
    * override 
    *
    * @see Type
    */
  int compare (Type type) throws TypeMismatch {
    ClassType c;

    if (type == ANY || type == NULL || type == null || class_id == null)
      return 0;

    try {
      c = (ClassType) type;
    } catch (ClassCastException ex) {
      throw new TypeMismatch ();
    }

    if (class_id.equals (c.class_id)) return 0;

    if (!c.load ()) {
      /*
      if (ozc.getOzc ().isParsing ())
	return 0;
      else
      */
	throw new TypeMismatch ();
    }

    if (!c.isClassInterface ()) {
      ClassImplementation ci = (ClassImplementation) c;
      if (ci.getInterface () == this) return 1;
    }

    ClassList si = c.getSuperInterfaces ();
    if (si != null) {
      for (int i = 0, size = si.size (); i < size; i++) {
	try {
	  if (compare (si.get(i)) >= 0)
	    return 1;
	} catch (TypeMismatch e) {
	  /* ignore */
	}
      }
    }

    throw new TypeMismatch ();
  }

  /**
    * check:
    *  if this is global, super class must me global
    *  if super class must not final 
    *
    * @param c super class 
    */
  protected final void checkAsSuperClass (ClassType c) {
    if (isGlobal () && !c.isGlobal () && c != School.CELL)
      OzcError.mustBeGlobal (c);

    if (!isGlobal () && c.isGlobal ())
      OzcError.mustNotBeGlobal (c);

    if (c.isFinal ())
      OzcError.cannotInheritFinal (c);

    if (!isProtected () && c.isProtected ())
      OzcError.cannotInheritProtected (this, c);
  }

  /**
    * register method 
    *
    * @param m method
    */
  void registerMethod (ClassMember m) {
    try {
      method_table.register (m);
      /* if (m.isFinal ()) has_final_methods = true; */
    } catch (AlreadyDefined ex) {
      /* multiply defined */
      OzcError.alreadyDefined (m);
    }
  }

  /** re-search method definition in super class of super interfaces,
    * which are not found in parsing 
    */
  abstract void check ();

  /**
    * search method 
    *
    * @param name name of method 
    * @param type signature and return type of method
    * @param access access level
    * @param modifier_mask modifier of method
    * @return found method, if not found null.
    */
  ClassMember searchMethod (String name, MethodType type, int access,
			    int modifier_mask) {
    if (!load ()) return null;

    ClassMember m = method_table.search (name, type, access, modifier_mask);
    if (m != null) return m;

    if (ozc.getOzc ().isParsing ()) return null;

    if (access == PRIVATE) access = PROTECTED;
    return searchInheritedMethod (name, type, access, modifier_mask);
  }

  /**
    * search method
    *
    * @param name name of method
    * @param type signature and return type of method
    * @param access access level
    * @return found method, if not found null.
    */
  ClassMember searchMethod (String name, MethodType type, int access) {
    return searchMethod (name, type, access, 0);
  }

  /**
    * search inherited method super class or interfaces 
    *
    * @param name name of method 
    * @param type signature and return type of method
    * @param access access level
    * @param modifier_mask modifier of method
    * @return found method, if not found null.
    */
  abstract protected ClassMember searchInheritedMethod (String name,
							MethodType type,
							int access,
							int modifier_mask);

  /**
    * search definition of method from this interface or super class 
    *
    * @param method searching method
    * @return found method, if not found null.
    */
  protected ClassMember searchMethodDefinition (ClassMember method) {
    if (!load ()) return ClassMember.ANY;

    return method_table.search (method);
  }

  /** 
    * emit package definition 
    */
  protected void emitPackage () {
    if (Emitter.isEmitting ()) {
      Emitter.emitln ("package " + package_name + ";");
      Emitter.emitln ();
    }
  }

  /**
    * emit class modifier.
    */
  void emitModifier () {
    if ((modifier & FINAL) > 0)
      Emitter.emit ("final ");
    if ((modifier & ABSTRACT) > 0)
      Emitter.emit ("abstract ");

    if (Emitter.isEmitting ()) return;

    if ((modifier & PROTECTED) > 0)
      Emitter.emit ("protected ");
  }
  
  /**
    * emit class header 
    */
  abstract void emitHeader ();

  /**
    * emit class body contents 
    */
  abstract void emitBody ();

  /**
    * emit class or interface definition 
    */
  void emitDefinition () {
    emitPackage ();
    emitHeader ();

    Emitter.emit (" {");
    Emitter.indentPush ();

    if (!isProxy ()) {
      /* for class modifier */
      if (isGlobal ()) {
	Emitter.emitln ();
	Emitter.emit ("static final boolean " + OzcProperty.GLOBAL_MODIFIER + 
		      " = true;");
      }
      if (isFinal ()) {
	Emitter.emitln ();
	Emitter.emit ("static final boolean " + OzcProperty.FINAL_MODIFIER + 
		      " = true;");
      } 
    }

    Emitter.emitln ();

    emitBody ();

    Emitter.indentPop ();
    Emitter.emitln ();
    Emitter.emitln ("}");
  }

  /**
    * override 
    */
  public String toString () {
    if (Emitter.isEmitting ()) {
      if (status == CLS_CANNOT_COMPILE)
	Emitter.cannotJavaCompile ();

      if (isClassInterface () && status == CLS_NONE) {
	if (!OzcClassLoader.exists (this)) {
	  Emitter.addToNeedCompiles (this);
	}
      }

      return getFullyQualifiedClassID ();
    } else if (Emitter.isEmittingForBrowser ())
      return encoded_name;
    else
      return name;
  }

  /** 
    * emit class or interface definition for browser use 
    */
  abstract void emitDefinitionForBrowser ();

  /**
    * set line number of definition 
    *
    * @param ln line number
    */
  void setLineNumber (int ln) {
    line_no = ln;
  }
}

/* EOF */

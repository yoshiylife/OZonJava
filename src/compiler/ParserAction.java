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
 * $Id: ParserAction.java,v 0.38 1998-02-02 08:31:37+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1997.5.29
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing actions of parser.
  *
  * @see parser.java
  */

class ParserAction {
  /**
    * list of defined classes 
    */
  private ClassList class_list;

  /**
    * list of classes, which were not found class file in parsing 
    */
  private ClassList notfound_class_list;	       
    
  /**
    * list of expressions, which were not recognized in parsing 
    */
  private ExpressionList notchecked_expression_list;	       
    
  /**
    * current class processing definition 
    */
  private ClassImplementation cls;

  /**
    * interface of current class processing definition 
    */
  private ClassInterface cls_interface;

  /**
    * current method processing definition 
    */
  private MethodType method;

  /**
    * current compound statement processing definition 
    */
  private CompoundSt block;

  /**
    * symbol table for local variables 
    */
  private SymbolTable local_variables;

  /**
    * current type processing variable definition 
    */
  private Type type;

  /**
    * nested count of loop statement 
    */
  private int loop_depth;

  /**
    * nested count of switch statement 
    */
  private int switch_depth;

  /**
    * table of identifier (label) 
    */
  java.util.Hashtable labels;

  /**
    * mode of parser 
    */
  private int parser_mode;

  /**
    * nested level of instantiation expression
    */
  private int instantiate_exp_depth;

  /**
    * current processing catch statment.
    */
  private CatchSt current_catch;

  /**
    * protected classses for forward reference
  private java.util.Hashtable maybe_protected_class;
  */

  /* parser mode value */
  static final int PM_INTERFACE = 0x1; 
  static final int PM_IMPLEMENTATION = 0x2; 
  static final int PM_DONE = 0x4;
  static final int PM_DEBUG = 0x8;

  /**
    * create new one 
    *
    * @param mode mode of parser
    */
  ParserAction (int mode) {
    parser_mode = mode;
    class_list = new ClassList ();
    notfound_class_list = new ClassList ();
    notchecked_expression_list = new ExpressionList ();
    labels = new java.util.Hashtable ();
    /* maybe_protected_class = new java.util.Hashtable (); */
  }

  /**
    * register label of labeled statement 
    *
    * @param l label
    */
  void registerLabel (String l) {
    Identifier lb = (Identifier) labels.get (l);
    if (lb != null) {
      OzcError.alreadyDefinedLabel (l);
      return;
    }
    lb = new Identifier (l);
    try {
      labels.put (l, lb);
    } catch (NullPointerException e) {
      ozc.catchException (e);
    }
  }
    
  /**
    * search label of labeled statement 
    *
    * @param l label
    * @return label identifier
    */
  Identifier searchLabel (String l, int ln) {
    if (l.length () == 0) return null;

    Identifier lb = (Identifier) labels.get (l);
    if (lb == null) {
      OzcError.notDefinedLabel (l, ln);
      lb = Identifier.ANY;
    }

    return lb;
  }

  /**
    * un-register label of labeled statement 
    *
    * @param l label
    */
  void unregisterLabel (String l) { labels.remove (l); }
    
  /**
    * check if label defined
    *
    * @param l label
    * @return if so true, otherwise false
    */
  boolean containsLabel (String l) { return labels.containsKey (l); }
    
  /**
    * search an interface of class in school 
    *
    * @param nt class name token
    * @param pos offset in file
    * @return class
    */
  ClassInterface searchClassAsInterface (OzStrToken nt) {
    ClassImplementation c = searchClassNoCheck (nt);
    String name = nt.str_val;

    if (c == null) {
      /* not included in school */
      OzcError.notClassName (name);
      c = new ClassImplementation (name);
      ozc.getSchool ().register (c, name);
      return c.getInterface ();
    } 

    ClassInterface ci = c.getInterface ();
    ci.setParserAction (this);

    registerAsUsed (ci, nt.getOffset ());

    if (isParseInterface ()) return ci;

    if (isParsingIt (c)) return ci;

    addToNotFoundList (ci);
      
    return ci;
  }

  /**
    * search a class in school 
    *
    * @param nt class name token
    * @return class
    */
  ClassImplementation searchClass (OzStrToken nt) {
    ClassImplementation c = searchClassNoCheck (nt);
    String name = nt.str_val;

    if (c == null) {
      /* not included in school */
      OzcError.notClassName (name);
      c = new ClassImplementation (name);
      ozc.getSchool ().register (c, name);
      return c;
    } 

    registerAsUsed (c, nt.getOffset ());

    if (isParseInterface ()) return c;

    if (cls == null || isParsingIt (c)) return c;

    addToNotFoundList (c);
      
    return c;
  }

  /**
    * register used class
    *
    * @param c class
    * @param pos offset in file
    */
  private void registerAsUsed (ClassType c, int pos) {
    if (method == null || !isParseImplementation ()) return;

    method.registerAsUsed (c, pos);
  }
    
  /**
    * search a class in school without any check 
    *
    * @param nt class name token
    * @retrun class
    */
  ClassImplementation searchClassNoCheck (OzStrToken nt) {
    String name = nt.str_val;
    if (cls != null && cls.getName ().equals (name)) return cls;

    for (int i = 0, size = class_list.size (); i < size; i++) {
      ClassType ct = (ClassType) class_list.elementAt (i);

      if (!ct.getName ().equals (name)) continue;

      if (ct.isClassInterface ())
	return ((ClassInterface) ct).getImplementation ();
      else
	return (ClassImplementation) ct;
    }

    School s = ozc.getSchool ();
    ClassImplementation c =  (ClassImplementation) s.search (name);

    if (c == null) {
      /*
      if (isParsing ()) {
	c = (ClassImplementation) maybe_protected_class.get (name);
	if (c != null) return c;

	c = createProtectedClass (name);
	
	return c;
      }
      */
      return null;
    }

    if (!c.isLoaded ()) c.setParserAction (this); 
    return c;
  }

  /**
    * create protected class
    *
    * @param name class name
    * @return class 
    */
  ClassImplementation createProtectedClass (String name) {
    ClassImplementation c 
      = new ClassImplementation (name,
				 name + OzcProperty.PROTECTED_POSTFIX,
				 name + OzcProperty.PROTECTED_POSTFIX);
    /*
    try {
      maybe_protected_class.put (name, c);
    } catch (NullPointerException e) {
    }
    */

    return c;
  } 

  /**
    * search class symbol 
    *
    * @param nt class name token
    * @return class symbol
    */
  ClassSymbol searchClassSymbol (OzStrToken nt) {
    ClassImplementation c = searchClassNoCheck (nt);

    if (c == null) return null;

    registerAsUsed (c, nt.getOffset ());

    return c.getSymbol ();
  }

  /**
    * search variable 
    *
    * @param nt variable name token
    * @return variable or attribute
    */
  Expression searchIdentifier (OzStrToken nt) {
    String name = nt.str_val;
    int line_no = nt.line_no;

    /* search identifier in same declaration 
    if (type != null) return (Identifier) local_variables.get (name); */

    Expression e = local_variables.search (name);
    if (e != null) {
      e.setLineNumber (line_no);
      return e;
    }

    e = AttributeAccessExp.create (name, line_no, this, nt);
    if (e != null) return e;

    ClassSymbol cs = searchClassSymbol (nt);
    if (cs != null) {
      cs.setLineNumber (line_no);
      return cs;
    }
      
    /* not defined identifier as variable */
    OzcError.notDefinedIdentifier (name);
    local_variables.register (Identifier.ANY, name);
    return Identifier.ANY;
  }
    
  /**
    * search variable 
    *
    * @param name variable name
    * @param line_no line number
    * @return variable or attribute
    */
  Expression searchIdentifier (String name, int line_no) {
    /* search identifier in same declaration 
    if (type != null) return (Identifier) local_variables.get (name); */

    Expression e = local_variables.search (name);
    if (e != null) {
      e.setLineNumber (line_no);
      return e;
    }

    e = AttributeAccessExp.create (name, line_no, this);
    if (e != null) return e;

    /* not defined identifier as variable */
    OzcError.notDefinedIdentifier (name);
    local_variables.register (Identifier.ANY, name);
    return Identifier.ANY;
  }
    
  /**
    * type check for after parsing checking of expression 
    *
    * @param t1 type
    * @param t2 type
    */
  void checkExpressionType (Expression e1, Expression e2) {
    Type t1 = e1.getType (), t2 = e2.getType ();
    
    if (t1 == null || t2 == null) return;

    if (!t2.isAssignable (t1)) {
      if (e2.isConditional ())
	OzcError.mustBeBoolExpression ();
      else
	OzcError.typeMismatch (t1, t2);
    }
  }

  /**
    * search constructor 
    *
    * @param c current class
    * @param name name of constructor
    * @param callee callee of constructor
    * @param args arguements of constructor
    * @return constructor
    */
  ClassMember searchConstructor (ClassImplementation c, String name, 
				 Expression callee, 
				 ExpressionList args) {
    MethodType mt = new MethodType (name, null, args);
    ClassMember m;
    m = c.searchConstructor (name, mt);

    if (m != null || isParsing ()) return m;

    /* not defined constructor calling */
    OzcError.notDefinedConstructor (mt, c);
    return null;
  }

  /**
    * search method 
    *
    * @param c current class
    * @param name name of method
    * @param callee callee of method
    * @param args arguements of method
    * @param access access level
    * @return method
    */
  ClassMember searchMethod (ClassType c, String name, 
			    Expression callee, 
			    ExpressionList args, int access) {
    MethodType mt = new MethodType (name, null, args);
    ClassMember m;

    if ((callee == null && !method.getMethod ().isStatic ()) || 
	(callee != null && !(callee instanceof ClassSymbol))) {
      m = c.searchMethod (name, mt, access);

      if (m != null) return m;

      if (callee == null && method.getMethod ().isNew ()) {
	/* not defined method calling */
	ClassImplementation ci;
	if (c instanceof ClassInterface)
	  ci = ((ClassInterface) c).getImplementation ();
	else
	  ci = (ClassImplementation) c;
	
	m =  ci.searchConstructor (name,  mt);
	if (m != null)  {
	  method.getMethod ().calledSuper ();
	  return m;
	}
      }
      
      if (!isParsing ()) {
	/* not defined method calling */
	OzcError.notDefinedMethod (mt, c);
      }

      return null;
    }

    m = c.searchMethod (OzcProperty.STATIC_PREFIX + name, 
			mt, access, Constants.STATIC);
      
    if (m == null && !isParsing ()) {
      /* not defined static method calling */
      OzcError.notDefinedStaticMethod (name, c);
      return null;
    }

    return m;
  }

  /**
    * check if any argument not checked 
    *
    * @param args arguments
    * @return if so true, otherwise false
    */
  boolean isNotChecked (ExpressionList args) {
    for (int i = 0, size = args.size (); i < size; i++) {
      Expression exp = args.get (i);

      if (notchecked_expression_list.contains (exp)) return true;
    }

    return false;
  }

  /**
    * create type object 
    *
    * @param t type symbol
    * @return type 
    */
  Type createType (Object t) {
    if (t instanceof OzStrToken) {
      ClassType c = searchClassAsInterface ((OzStrToken) t);
      registerReferencing (c);
      return c;
    } else {
      return (PrimitiveType) t;
    }
  }

  /**
    * register class as referencing class to current method 
    *
    * @param c class
    */
  void registerReferencing (ClassType c) {
    if (method == null) return;

    method.registerReferencing (c);
  }

  /**
    * register class as instantiating class to current method 
    *
    * @param c class
    */
  void registerInstantiating (ClassType c) {
    if (method == null) return;

    method.registerInstantiating (c);
  }

  /**
    * create and set type 
    *
    * @param t type symbol
    */
  void setType (Object t) { type = createType (t); }

  /**
    * register super interface 
    *
    * @param nt class name token
    */
  void registerSuperInterface (OzStrToken nt) {
    registerSuperInterface (searchClassAsInterface (nt));
  }
    
  /**
    * register super interface 
    *
    * @param c class inteface
    */
  void registerSuperInterface (ClassInterface c) {
    if (c == cls_interface) {
      OzcError.cyclicInheritance ();
      return;
    }

    if (isParseInterface ()) {
/*       if (c.hasFinalMethods ()) { */
/* 	OzcError.cannotInheritSemiFinal (c); */
/* 	return; */
/*       } */
      cls_interface.registerSuperInterface (c);
    } else {
      if (!cls_interface.containsAsSuperInterface (c))
	OzcError.notDefinedAsSuperInterface (c);
    }
  }
    
  /**
    * register inherited class 
    *
    * @param nt class name token
    */
  void registerSuperClass (OzStrToken nt) {
    if (isParseInterface ()) {
      if (cls_interface.isGlobal ()) 
	registerSuperClass (searchClass (nt));
      registerSuperClass (searchClassAsInterface (nt));
    } else {
      registerSuperClass (searchClass (nt));
    }
  }
    
  /**
    * register inherited class 
    *
    * @param c class
    */
  private void registerSuperClass (ClassImplementation c) {
    if (c == cls) {
      OzcError.cyclicInheritance ();
      return;
    }

    if (isParseInterface ()) {
      if (cls_interface.isGlobal ()) {
	((ClassImplementation) cls_interface.getProxy ()).registerSuperClass (c);
      } 
    } else {
      cls.registerSuperClass (c);
      if (cls.isProtected ()) {
	cls_interface.registerSuperInterface (c.getInterface ());
      } else if (!cls.containsAsSuperClass (c))
	OzcError.notDefinedAsSuperClass (c);
    }
  }
    
  /**
    * register inherited class 
    *
    * @param ci class
    */
  void registerSuperClass (ClassInterface ci) {
    if (ci == cls_interface) {
      OzcError.cyclicInheritance ();
      return;
    }

    if (isParseInterface ()) {
      cls_interface.registerSuperInterface (ci);
    }
  }
    
  /**
    * check if illegal assignment to attribute is possible only in constructor 
    *
    * @param l expression
    * @return if so true, otherwise false
    */
  boolean isIllegalAttributeReference (Expression l) {
    if (l.isAttributeReference ()) {
      AttributeAccessExp ae = (AttributeAccessExp) l;

      if (ae.getAttribute ().isFinal () &
	  !method.getMethod ().isNew ()) {
	AttributeAccessExp a = (AttributeAccessExp) l;
	OzcError.cannotUseFinalAttribute (a.getAttribute ());
	return true;
      }
    }
    return false;
  }

  /**
    * add class to class list (compilation result) 
    */
  void addClassList () {
    if (isParseInterface ()) {
      class_list.add (cls_interface);
    } else {
      class_list.add (cls);
      if (cls.class_id != null) notfound_class_list.remove (cls.class_id);
    }

    if (cls_interface.class_id != null) 
      notfound_class_list.remove (cls_interface.class_id);
    else 
      OzcError.notClassName (cls.name);

    cls = null;
    cls_interface = null;
  }

  /**
    * check if class is in curent source file 
    *
    * @param c class
    * @return if so true, otherwise false
    */
  boolean isInFile (ClassType c) {
    return class_list.contains (c.name);
  }

  /**
    * check if class is in notfound_class_list 
    *
    * @param c class
    * @return if so true, otherwise false
    */
  final boolean isNotFound (ClassType c) {
    if (c == ClassType.NULL) return false;
 
    if (c.class_id == null) return true;

    return notfound_class_list.contains (c.class_id) ;
  }

  /**
    * add a class to notfound_class_list 
    *  call from ClassLoader.load () method 
    *
    * @param c class
    */
  final void addToNotFoundList (ClassType c) {
    if (!School.isSystem (c) && !isNotFound (c))
      notfound_class_list.add (c.class_id, c);
  }

  /**
    * check if now parsing 
    * 
    * @return if so true, otherwise false.
    */
  final boolean isParsing () { return parser_mode != PM_DONE; }

  /**
    * check if now parsing this class 
    *
    * @param c class
    * @return if so true, otherwise false.
    */
  final boolean isParsingIt (ClassType c) { 
    return cls == c || cls_interface == c || isInFile (c);  
  }

  /**
    * load all class in notfound_class_list 
    */
  void loadClasses () {
    for (int i = notfound_class_list.size (); i > 0;) {
      ClassType c = notfound_class_list.get (--i);
      try {
	c.load ();
	notfound_class_list.remove (c.class_id);
      } catch (Exception e) {
	/* ignore */
      }
    }
  }

  /**
    * add an expression to notchecked_expression_list 
    *
    * @param e expression
    */
  void addToNotCheckedList (Expression e) {
    notchecked_expression_list.add (e);
  }

  /**
    * check operands of expression, and if need register unchecked list
    *
    * @param exp expression
    */
  void checkExpression (Expression exp) { 
    if (exp.type == null) addToNotCheckedList (exp);
  }

  
  /**
    * check operands of expression, and if need register unchecked list
    *
    * @param exp expression
    * @param op1 operand expression
    * @param op2 operand expression
    */
  void checkExpression (Expression exp, 
			Expression op1, Expression op2) {
    if (exp.type == null)
      addToNotCheckedList (exp);

    else if (op1.type == null) 
      op1.type = exp.type;
    else if (op2.type == null)
      op2.type = exp.type;
    else if (op2.type == op1.type)
      return;

    else if (op1.type.isClass () && isNotFound ((ClassType) op1.type))
      addToNotCheckedList (exp);
    else if (op2.type.isClass () && isNotFound ((ClassType) op2.type))
      addToNotCheckedList (exp);
  }

  /**
    * re-check all expression in notchecked_expression_list 
    */
  void checkExpressions () {
    for (int i = 0, size = notchecked_expression_list.size ();
	 i < size; i++) {
      Expression exp = notchecked_expression_list.get (i);
      notchecked_expression_list.setElementAt (null, i);

      /* adjust line number for error message */
      OzcError.setLineNumber (exp.line_no);

      if (exp instanceof MethodInvocationExp) 
	MethodInvocationExp.check ((MethodInvocationExp) exp, this);
      else if (exp instanceof InstantiationExp) 
	InstantiationExp.check ((InstantiationExp) exp, this);
      else if (exp instanceof AttributeAccessExp) {
	AttributeAccessExp.check ((AttributeAccessExp) exp, this);
      } else 
	exp.setType ();
    }
  }

  /**
    * re-search method definition in super class of super interfaces,
    * which are not found in parsing 
    */
  void checkClasses () {
    for (int i = 0, size = class_list.size (); i < size; i++) {
      ClassType c = class_list.get (i);

      OzcError.setLineNumber (c.line_no);
      c.check ();

/*       if (!c.isClassInterface () && !c.isGlobal ())  */
/* 	class_list.add (((ClassImplementation) c).getThrowable ()); */

      if (c.isClassInterface () && c.isGlobal ()) {
	GlobalProxy proxy = ((ClassInterface) c).getProxy ();
	class_list.add (proxy);
	proxy.check ();
      }
    }
  }

  /**
    * processing after parsing 
    *
    * @return list of class
    */
  final ClassList after () {
    parser_mode = PM_DONE;
    ozc.getOzc ().endParsing ();
    loadClasses ();
    checkExpressions ();
    checkClasses ();

    return class_list;
  }

  /**
    * manage local variables 
    */
  void createLocalVariables () {
    local_variables = new SymbolTable ();
  }

  /**
    * register argument to local variables
    *
    * @param args arguments
    */
  void registerLocalVariables (IdentifierList args) {
    local_variables.register (args);
  }

  /**
    * register local variable 
    *
    * @param id variable
    */
  void registerLocalVariable (Identifier id) { local_variables.register (id); }

  void removeLocalVariable (String name) { local_variables.remove (name); }

  /**
    * exit previous block 
    */
  void exitBlock () {
    block = block.upper;
    local_variables = local_variables.upper;
  }

  /**
    * enter new block 
    *
    * @param ln line number
    */
  void enterBlock (int ln) {
    block = new CompoundSt (block, ln);
    local_variables = new SymbolTable (local_variables);
  }

  /**
    * access for cls field
    *
    * @return class
    */
  ClassImplementation getCls () { return cls; }

  /**
    * set for cls field
    *
    * @param c class
    */
  void setCls (ClassImplementation c) { cls = c; }

  /**
    * access for cls_interface field
    *
    * @return class
    */
  ClassInterface getClsInterface () { return cls_interface; }

  /**
    * set for cls_interface field
    *
    * @param c class
    */
  void setClsInterface (ClassInterface c) { cls_interface = c; }

  /**
    * get curernt method symbol 
    *
    * @return method
    */
  ClassMember getMethodSymbol () { return method.getMethod (); }

  /**
    * set curernt method
    *
    * @param m method
    */
  void setMethod (MethodType m) { method = m; }

  /**
    * access curernt method
    *
    * @return method
    */
  MethodType getMethod () { return method; }

  /**
    * check if jump statement is legal
    *
    * @return if so true, otherwise false
    */
  boolean canJump (int kind) { 
    if (kind == sym.BREAK)
      return switch_depth > 0 || loop_depth > 0; 
    else
      return loop_depth > 0; 
  }

  /**
    * check if debug 
    *
    * @return if so true, otherwise false
    */
  boolean isDebug () { return (parser_mode & PM_DEBUG) > 0; }

  /**
    * check if parsing interface 
    *
    * @return if so true, otherwise false
    */
  boolean isParseInterface () { return (parser_mode & PM_INTERFACE) > 0; }

  /**
    * check if parsing implementation 
    *
    * @return if so true, otherwise false
    */
  boolean isParseImplementation () { return (parser_mode & PM_IMPLEMENTATION) > 0; }
  
  /*
   * following is actualiy actions of parser (CUP source) 
   * each method coresponding to non-terminal symbol of CUP source (parser.cup)
   */

  void classDeclarations () {
    if (isDebug ()) return;

    addClassList ();
  }

  void classDeclaration (int mod, int class_kind, OzStrToken nt) 
    throws StopCompilation {
    String name = nt.str_val;
//    if ((mod & Constants.PROTECTED) != 0) {
      /*
      cls = (ClassImplementation) maybe_protected_class.get (name);
      if (cls == null) 
      */
//      cls = createProtectedClass (name);
//    } else {
      cls = searchClass (nt);
//    }

    cls_interface = cls.getInterface ();
    cls_interface.setParserAction (this);

    if (class_kind == sym.CELL) {
      mod |= Constants.GLOBAL;
    }

    ClassType c;

    if (isParseInterface ()) 
      c = cls_interface;
    else
      c = cls;

    c.reset (mod);
    c.setLineNumber (nt.line_no);

    if (ozc.isVerbose ())
      ozc.debugln (cls + ": compiling.");

    if (!isParseInterface ()) {
      if ((mod & Constants.PROTECTED) == 0) {
	if (!cls_interface.load ())
	  if (!ozc.compileInterface (OzcError.getSource ()))
	    throw new StopCompilation ();
	cls_interface.prepareForCheckIntegrity ();
	int mask = (Constants.STATIC | Constants.FINAL | Constants.GLOBAL);
//	System.out.println ((cls_interface.getModifier () & mask));
//	System.out.println (mod & mask);
	if ((cls_interface.getModifier () & mask) != (mod & mask))
	  OzcError.classModifierChanged (cls);
      } else {
	cls_interface.initialize (mod, 
				  cls.getClassID ());
      }
    }
  }

  void superClasses () {
    if (isDebug ()) return;

    if (School.isSystem (cls)) return;

    if (!isParseInterface ()) {
      if (cls.isGlobal ())
	registerSuperClass (School.CELL);
      else
	registerSuperClass (School.ROOT);
    } else {
      if (cls_interface.isGlobal ()) 
	registerSuperClass (School.PROXY);
      else
	cls_interface.registerSuperInterface (School.ROOT.getInterface ());
    }
  }

  void superClassList () {
    if (School.isSystem (cls)) return;

    if (!isParseInterface ()) {
      if (cls.isGlobal ()) 
	cls.registerSuperClass (School.CELL);
      else 
	cls.registerSuperClass (School.ROOT);
    } else if (cls_interface.isGlobal ())
	((ClassImplementation) cls_interface.getProxy ()).registerSuperClass (School.PROXY);
  }

  void superClassList (OzStrToken name) {
    registerSuperClass (name);
  }

  void superInterfaceList (OzStrToken name) {
    registerSuperInterface (name);
  }

  void attributeDeclaration (int access_mod, int mod, Object t, 
			     IdentifierList il, int start, int end) {
    if (!isParseImplementation ()) return;

    Type tp = createType (t);
    cls.registerAttributes (il, tp, mod, access_mod, start, end);
  }

  void methodDeclaration (int amod, int mod, Object type, 
			  String name, ExpressionList args, int pos) {
    if (isParseInterface () && amod != Constants.PUBLIC)
      return;
      
    if ((mod & Constants.ABSTRACT) != 0 &&
	(mod & Constants.FINAL) != 0) {
      OzcError.cannotAbstractAndFinalMethod (name);
      return;
    }
      
    if ((mod & Constants.ABSTRACT) != 0 && cls.isGlobal ()) {
      OzcError.cannotDefineAbstractMethodInCell (name);
      return;
    }

    if ((amod & Constants.NEW) != 0 && cls.isGlobal ()) {
      OzcError.cannotDefineConstructorInCell (name);
      return;
    }
      
    Type tp = createType (type);
    ClassType c;
    if (amod == Constants.PUBLIC)
      c = cls_interface;
    else 
      c = cls;
    if (isParseInterface ()) 
      pos = -1;
    else {
      if ((mod & Constants.STATIC) != 0 && 
	  !name.startsWith (OzcProperty.STATIC_PREFIX)) {
	methodDeclaration (amod, mod, type, 
			   OzcProperty.STATIC_PREFIX + name, args, pos);
      }
    } 
    method = new MethodType (name, tp, args);
    ClassMember mi = new ClassMember (name, method, mod, amod, c, pos);
    method.setMethod (mi);

    if (!isParseInterface ()) 
      c = cls;
      
    if (amod == Constants.NEW)
      ((ClassImplementation) c).registerConstructor (mi);
    else {
      c.registerMethod (mi);
      if (amod == Constants.PUBLIC && isParseImplementation () && 
	  c.isProtected ())
	cls_interface.registerMethod (mi);
    }

    if (isParseInterface ()) return;

    /* register referencing classes appeared in signature */
    for (int i = 0, size = args.size (); i < size; i++) {
      Type t = args.get (i).getType ();
      if (t instanceof ClassType) {
	registerReferencing ((ClassType) t);
      }
    }
  }

  void constructorDeclaration (int amod, int mod, Object type, 
			       String name, ExpressionList args, int pos) {
    methodDeclaration (amod, mod, type, name, args, pos);
  }

  void emptyMethodBody (int pos) {
    if (method == null) return;

    ClassMember m = method.getMethod ();
    if (!m.isAbstract ())
      OzcError.needMethodBody (m);

    m.setEnd (pos);

    method = null;
  }

  void nonEmptyMethodBodyBefore (int ln) {
    if (!isParseImplementation ()) {
      if (isDebug () && isParseInterface ()) Emitter.emit ("skip method body");
      return;
    }
			   
    IdentifierList args = (IdentifierList) method.getArguments ();
    if (args.size () != 0) {
      createLocalVariables ();
      registerLocalVariables (args);
    }
    enterBlock (ln);
    method.registerBody (block);
  }

  void nonEmptyMethodBodyAfter (int pos) {
    if (method == null) return;

    method.getMethod ().setEnd (pos);
    method = null;
    local_variables = null;
  }

  void argumentDeclarations (ListSym result) {
    result.list = new IdentifierList ();
  }

  void argumentDeclarations (ListSym result, 
			     IdentifierList il, Object t, 
			     OzStrToken s) {
    String name = s.str_val;
    Type tp = createType (t);
    Identifier id = new Identifier (name, tp, s.line_no);
    id.changeMaybeRed ();

    if (!isParseImplementation ()) {
      for (int i = 0, size = il.size (); i < size; i++) {
	if (il.geti (i).getName ().equals (name)) {
	  OzcError.alreadyDefined (id);
	}
      }
    }

    il.add (id);
    result.list = il;
  }

  void argumentDeclarations (ListSym result, Object t, OzStrToken s) {
    argumentDeclarations (result, new IdentifierList (), t, s);
  }

  void identifierList (ListSym result, 
		       IdentifierList il, String name, int ln) {
    if (!isParseImplementation ()) return;

    ClassMember id = new ClassMember (name, type, ln);
    il.add (id);
    result.list = il;
  }

  void identifierList (ListSym result, String name, int ln) {
    if (!isParseImplementation ()) return;

    identifierList (result, new IdentifierList (), name, ln);
  }

  void identifierOnlyOrWithInitializerList (ListSym result, IdentifierList il, 
					   Identifier id) {
    if (!isParseImplementation ()) return;

    il.add (id);
    result.list = il;
  }

  void identifierOnlyOrWithInitializerList (ListSym result, Identifier id) {
    if (!isParseImplementation ()) return;
    
    identifierOnlyOrWithInitializerList (result, new IdentifierList (), id);
  }

  void identifierOnlyOrWithInitializer (IdentifierSym result, OzStrToken s) {
    if (!isParseImplementation ()) return;

    String name = s.str_val;
				
    Identifier id = new Identifier (name, type, s.line_no);
    registerLocalVariable (id);
    result.id = id;
  }

  void identifierWithInitializer (IdentifierSym result, Expression exp) {
    if (!isParseImplementation ()) return;
			   
    if (exp == Expression.ANY)
      result.id = Identifier.ANY;
    else {
      try {
	Identifier id = (Identifier) ((InstantiationExp) exp).instance;
	id.exp = exp;
	result.id = id;
      } catch (ClassCastException e) {
	result.id = Identifier.ANY;
      }
    }
  }

  void identifierWithInitializer (IdentifierSym result, 
				  OzStrToken s, Expression exp) {
    if (!isParseImplementation ()) return;

    result.id = new Identifier (s.str_val, type, exp, s.line_no);

    registerLocalVariable (result.id);
    
    Expression e = new AssignExp (result.id, exp, sym.EQUAL);
    checkExpression (e, result.id, exp);
  }

  void identifierOrEmpty (OzStrToken result, String name) {
    if (!isParseImplementation ()) return;

//    if (!containsLabel (name)) {
//      /* not defined label */
//      OzcError.notDefinedLabel (name);
//    }

    result.str_val = name;
  }

  void stmt (StatementSym st_sym, String str, Statement st) {
    st_sym.st = st;
    st_sym.str_val = str;
  }

  void stmt (StatementSym st_sym, int ln) {
    st_sym.st = new NullSt (ln);
  }

  void stmtList (Statement st) {
    if (!isParseImplementation ()) return;

    block.add (st);
  }
  
  void labelStmtFirst (String name) {
    if (!isParseImplementation ()) return;

    registerLabel (name);
  }

  void labelStmtSecond (StatementSym result, 
			String name, Statement st, int ln) {
    if (!isParseImplementation ()) return;

    Identifier label = searchLabel (name, ln);
    unregisterLabel (name);
    result.st = new LabelSt (label, st, ln);
  }

  void expStmt (StatementSym result, Expression exp) {
    if (!isParseImplementation ()) return;

    result.st = new ExpressionSt (exp, exp.getLineNumber ());
  }

  void compoundStmtFirst (int ln) {
    if (!isParseImplementation ()) return;

    enterBlock (ln);
  }

  void compoundStmtSecond (StatementSym result) {
    if (!isParseImplementation ()) return;

    CompoundSt st = block;
    exitBlock ();

    result.st = st;
  }

  void declarationStmtFirst (Object t) {
    setType (t);
  }

  void declarationStmtSecond (StatementSym result, IdentifierList il, int ln) {
    if (!isParseImplementation ()) return;

    try {
      result.st = new DeclarationSt (type, il, ln);
    } finally {
      type = null;
    }
  }

  void ifStmt (StatementSym result, 
	       Expression exp, Statement if_st, Statement else_st, int ln) {
    if (!isParseImplementation ()) return;

    result.st = new IfSt (exp, if_st, else_st, ln);
  }

  void ifBody (IfBodySym if_body, Statement st) {
    if (!isParseImplementation ()) return;
    
    if_body.if_st = st;
  }

  void ifBody (IfBodySym if_body, Statement st1, Statement st2) {
    if (!isParseImplementation ()) return;
    
    if_body.if_st = st1;
    if_body.else_st = st2;
  }

  void switchStmtFirst () {
    if (!isParseImplementation ()) return;

    switch_depth++;
  }

  void switchStmtSecond (StatementSym result, 
			 Expression exp, CompoundSt st, int ln) {
    if (!isParseImplementation ()) return;

    switch_depth--;

    result.st = new SwitchSt (exp, st, ln);
  }

  void switchLabel (StatementSym result, Expression exp, int ln) {
    if (!isParseImplementation ()) return;

    result.st = new SwitchLabel (exp, ln);
  }

  void switchLabel (StatementSym result, int ln) {
    if (!isParseImplementation ()) return;

    result.st = new SwitchLabel (ln);
  }

  void loopStmtBefore () {
    if (!isParseImplementation ()) return;

    loop_depth++;
  }

  void whileStmt (StatementSym result, Expression exp, Statement st, int ln) {
    if (!isParseImplementation ()) return;

    WhileSt wst = new WhileSt (exp, st, ln, loop_depth);
    loop_depth--;

    result.st = wst;
  }

  void doStmt (StatementSym result, Expression exp, Statement st, int ln) {
    if (!isParseImplementation ()) return;

    DoSt dst = new DoSt (exp, st, ln, loop_depth);
    loop_depth--;

    result.st = dst;
  }

  void forStmt (StatementSym result,
		Statement i_st, Expression exp1, Expression exp2, 
		Statement st, int ln) {
    if (!isParseImplementation ()) return;

    ForSt fst = new ForSt (i_st, exp1, exp2, st, ln, loop_depth);

    if (i_st instanceof DeclarationSt) {
      DeclarationSt dst = (DeclarationSt) i_st;
      for (java.util.Enumeration enum = dst.identifiers.elements (); 
	   enum.hasMoreElements (); ) {
	Identifier id = (Identifier) enum.nextElement ();
	removeLocalVariable (id.getName ());
      }
    }
    loop_depth--;
    exitBlock ();

    result.st = fst;
  }

  void forInitializeStmt (StatementSym result, IdentifierList il, int ln) {
    if (!isParseImplementation ()) return;

    try {
      result.st = new DeclarationSt (type, il, ln);
    } finally {
      type = null;
    }
  }

  void forInitializeStmt (StatementSym result, Expression exp, int ln) {
    if (!isParseImplementation ()) return;

    int line_no = exp != null ? exp.getLineNumber () : ln;
    result.st = new ExpressionSt (exp, line_no);
  }

  void jumpStmt (StatementSym result, String name, int which, int ln) {
    if (!isParseImplementation ()) return;

    Identifier lb = searchLabel (name, ln);
    if (lb == null && !canJump (which))
      OzcError.jumpCannotUsedHere ();
    result.st = new JumpSt (lb, which, method, ln, loop_depth);
  }

  void jumpStmt (StatementSym result, Expression exp, int ln) {
    if (!isParseImplementation ()) return;

    result.st = new ReturnSt (exp, method, ln);
  }

  void throwStmt (StatementSym result, Expression exp, int ln) {
    if (!isParseImplementation ()) return;

    result.st = new ThrowSt (exp, ln, current_catch);
  }

  void tryStmt (StatementSym result, 
		Statement st, CatchStList catch_list, Statement fst, int ln) {
    if (!isParseImplementation ()) return;
    
    result.st = new TrySt (st, catch_list, fst, ln);
  }

  void tryBody (TryBodySym tbody, CatchStList c_list) {
    if (!isParseImplementation ()) return;

    tbody.catch_list = c_list;
  }

  void tryBody (TryBodySym tbody, CatchStList c_list, Statement fst) {
    if (!isParseImplementation ()) return;

    tbody.catch_list = c_list;
    tbody.finally_st = fst;
  }

  void catchList (ListSym result) {
    if (!isParseImplementation ()) return;

    result.list = new CatchStList ();
  }

  void catchListFirst (CatchStList c_list, Object t, OzStrToken s, int ln) {
    if (!isParseImplementation ()) return;

    String name = s.str_val;

    Type tp = createType (t);
    Identifier id = new Identifier (name, tp, s.line_no);
    enterBlock (ln);
    registerLocalVariable (id);
    enterBlock (ln);

    current_catch = new CatchSt (id, block, ln);
    c_list.add (current_catch);
  }

  void catchListSecond (ListSym result, CatchStList c_list, String name) {
    if (!isParseImplementation ()) return;

    exitBlock ();
    removeLocalVariable (name);
    exitBlock ();

    current_catch = null;

    result.list = c_list;
  }

  void expOrEmpty (ExpressionSym exp, String str, Expression e) {
    exp.str_val = str;
    exp.exp = e;
    if (e != null) exp.line_no = e.getLineNumber ();
  }

  void primary (ExpressionSym result, int ln) {
    if (!isParseImplementation ()) return;

    ClassMember m = method.getMethod ();
    if (m.isStatic ()) {
      OzcError.cannotAccessThis (m);
      result.exp = Expression.ANY;
    }

    result.exp = new ThisExp (cls, ln);
  }

  void primary (ExpressionSym result, Expression exp) {
    if (!isParseImplementation ()) return;

    ParenthesisExp e = new ParenthesisExp (exp);
    checkExpression (e);
    result.exp = e;
  }

  void literal (ExpressionSym result, String str, Type t, int ln) {
    if (!isParseImplementation ()) return;

    result.exp = new Literal (str, t, ln);
  }

  void literal (ExpressionSym result, String str, int ln) {
    if (!isParseImplementation ()) return;

    result.exp = new Literal (str, ln);
  }

  void name (ExpressionSym result, OzStrToken n) {
    if (!isParseImplementation ()) return;

    result.exp = searchIdentifier (n);
  }

  void attributeAccess (ExpressionSym result, Expression exp, String name) {
    if (!isParseImplementation ()) return;
			   
    result.exp = AttributeAccessExp.create (exp, name, 
					    exp.getLineNumber (), this);
  }

  void methodInvokeExp (ExpressionSym result, String name, Expression exp, 
			ExpressionList args) {
    if (!isParseImplementation ()) return;

    result.exp =  MethodInvocationExp.create (name, exp, args, 
					      exp.getLineNumber (),
					      this);
  }

  void methodInvokeExp (ExpressionSym result, 
			String name, ExpressionList args, int ln) {
    if (!isParseImplementation ()) return;

    result.exp = MethodInvocationExp.create (cls, name, args, ln, this);
  }

  void superMethodInvokeExp (ExpressionSym result,
			     String name, ExpressionList args, int ln) {
    if (!isParseImplementation ()) return;

    ClassImplementation c = cls.getSuperClass ();
    if (c != null) 
      result.exp = MethodInvocationExp.createForSuper (c, name, 
						       args, ln, this);
    else {
      OzcError.cannotUseSuper (cls);
      result.exp = Expression.ANY;
    }
  }

  void instantiateExpFirst (String name, int ln) {
    if (!isParseImplementation ()) return;

    if (instantiate_exp_depth++ == 0 && type != null) {
      registerLocalVariable (new Identifier (name, type, ln));
    } 
  }

  void instantiateExpSecond (ExpressionSym result, 
			     String name, String c_name, ExpressionList args,
			     int ln) {
    if (!isParseImplementation ()) return;

    Expression v;
    /*
    if (instantiate_exp_depth++ == 0 && type != null) {
      v = new Identifier (name, type, ln);
    } else
    */
    v = searchIdentifier (name, ln);
    
    /* check identifier whose name is same as declared identifer.
     * it's refered previously declared identifer 
     */
    for (int i = 0, size = args.size (); i < size; i++) {
      Expression arg = args.get (i);
      if (arg == v) {
	Expression e = local_variables.upper.search (name);
	if (e == null) 
	  e = AttributeAccessExp.create (name, arg.line_no, this);

	if (e != null) {
	  e.setLineNumber (arg.line_no); 
	  args.setElementAt (e, i);
	} else {
	  OzcError.notDefinedIdentifier (name);
	}
      }
    }

    result.exp = InstantiationExp.create (c_name, v, args, ln, this);

    instantiate_exp_depth--;
  }

  void instantiateExp (ExpressionSym result, String name, Expression exp, 
		       ExpressionList args) {
    if (!isParseImplementation ()) return;
							       
    result.exp = InstantiationExp.create (name, exp, args, 
					  exp.getLineNumber (), 
					  this);
  }

  void instantiateExp (ExpressionSym result, 
		       String name, ExpressionList args, int ln) {
    if (!isParseImplementation ()) return;

    if (!method.getMethod ().isNew ()) {
      /* must use in constructor */
      OzcError.mustUseInConstructor ();
      result.exp = Expression.ANY;
    }
    result.exp = InstantiationExp.create (name, args, ln, this);
  }

  void argumentList (ListSym result) {
    if (!isParseImplementation ()) return;

    result.list = new ExpressionList ();
  }

  void argumentList (ListSym result, ExpressionList a_list, Expression exp) {
    if (!isParseImplementation ()) return;			     

    a_list.add (exp);
    result.list = a_list;
  }

  void argumentList (ListSym result, Expression exp) {
    if (!isParseImplementation ()) return;			     
    
    argumentList (result, new ExpressionList (), exp);
  }

  void unaryExp (ExpressionSym result, Expression exp, int op) {
    if (!isParseImplementation ()) return;

    UnaryExp e = new UnaryExp (exp, op);
    checkExpression (e);

    result.exp = e;
  }

  void postfixExp (ExpressionSym result, Expression exp) {
    if (!isParseImplementation ()) return;

    if (exp instanceof ClassSymbol) {
      OzcError.cannotUseClassSymbol (exp);
      result.exp = Expression.ANY;
    } else 
      result.exp = exp;
  }

  void binaryExp (ExpressionSym exp, Expression e1, Expression e2, int op) {
    if (!isParseImplementation ()) return;

    exp.exp = new BinaryExp (e1, e2, op);
    
    if (op != sym.LANGLE && op != sym.RANGLE && op != sym.GTE && op != sym.LTE)
      checkExpression (exp.exp, e1, e2);
    else if (e1.type == null || e2.type == null)
      addToNotCheckedList (exp.exp);
  }

  void binaryBoolExp (ExpressionSym exp, Expression e1, Expression e2, 
		      int op) {
    if (!isParseImplementation ()) return;

    exp.exp = new BinaryBoolExp (e1, e2, op);
    checkExpression (exp.exp, e1, e2);
  }

  void conditionalExp (ExpressionSym exp, Expression e1, Expression e2, 
		       Expression e3) {
    if (!isParseImplementation ()) return;

    exp.exp = new ConditionalExp (e1, e2, e3);
    checkExpression (exp.exp, e2, e3);
  }

  void assignExp (ExpressionSym exp, Expression e1, Expression e2, 
		  int op) {

    if (!isParseImplementation ()) return;

    if (isIllegalAttributeReference (e1))
      exp.exp = Expression.ANY;
    else {
      exp.exp = new AssignExp (e1, e2, op);
      checkExpression (exp.exp, e1, e2);
    }
  }

  void assignNumericExp (ExpressionSym exp, Expression e1, Expression e2, 
			 int op) {

    if (!isParseImplementation ()) return;

    if (isIllegalAttributeReference (e1))
      exp.exp = Expression.ANY;
    else {
      exp.exp = new AssignNumericExp (e1, e2, op);
      checkExpression (exp.exp, e1, e2);
    }
  }

  void assignBoolExp (ExpressionSym exp, Expression e1, Expression e2, 
		      int op) {

    if (!isParseImplementation ()) return;

    if (isIllegalAttributeReference (e1))
      exp.exp = Expression.ANY;
    else {
      exp.exp = new AssignBoolExp (e1, e2, op);
      checkExpression (exp.exp, e1, e2);
    }
  }

  void stmtExpList (ExpressionSym exp, Expression e1, Expression e2) {
    if (!isParseImplementation ()) return;

    exp.exp = new StatementExpressionList (e1, e2);
  }
}

/* EOF */


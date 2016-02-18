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
 * $Id: OzcError.java,v 0.18 1998-03-19 14:22:26+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1997.01.10
 */

package JP.go.ipa.oz.compiler;

/**
  * A class to output error message strings
  */

final class OzcError {
  /**
    * name of parsing file 
    */
  String src_file;

  /**
    * line number 
    */
 int line_no;

  /**
    * nunbmer or occured errors 
    */
  int no_errors;

  /**
    * storage for source file name and line nubmer value 
    */
  static OzcError error_obj;

  /**
    * previous storage
    */
  OzcError previous_error_obj;

  /**
    * arguments of print 
    */
  static java.util.Vector arguments = new java.util.Vector ();

  /**
    * initlialize 
    *
    * @param name source file name
    */
  static void initialize (String name) { 
    OzcError prev = error_obj; 
    error_obj = new OzcError ();
    error_obj.previous_error_obj = prev;
    error_obj.src_file = name;
  }

  /**
    * finalize 
    */
  static void finish () {
    error_obj = error_obj.previous_error_obj;
  }

  /**
    * set line number 
    *
    * @param ln line number
    */
  static void setLineNumber (int ln) {
    if (error_obj != null) error_obj.line_no = ln; 
  }

  /**
    * access for src_file field
    *
    * @return source file name
    */
  static String getSource () { return error_obj.src_file; }

  /**
    * access for no_errors field
    *
    * @return the number of errors
    */
  static int getNoErrors () { return error_obj.no_errors; }

  /**
    * print error message 
    *
    * @param key key of error message in property
    */
  static void print (String key) {
    if (error_obj != null)
      print (key, error_obj.line_no);
    else
      print (key, 0);
  }

  /**
    * print error message with line number 
    *
    * @param key key of error message in property
    */
  static void print (String key, int ln) {
    String msg = OzcProperty.getErrorMessage (key);

    /* replace \[0-9]* with argument */
    StringBuffer s = new StringBuffer ();
    int bslash = 0, prev;

    while (true) {
      prev = bslash;
      bslash = msg.indexOf ("\\", bslash);
      /* no more exists */
      if (bslash < 0) break;

      bslash++;

      /* not argument */
      if (!Character.isDigit (msg.charAt (bslash++))) continue;

      int end = bslash;
      while (Character.isDigit (msg.charAt (end))) end++;
      int index = Integer.parseInt (msg.substring (bslash - 1, end));

      s.append (msg.substring (prev, bslash - 2));
      s.append (arguments.elementAt (index));
    }

    s.append (msg.substring (prev));

    arguments.removeAllElements ();

    if (error_obj != null) {
      if (ln > 0)
	ozc.debugln (error_obj.src_file + ":" + ln + ": " + s);
      else
	ozc.debugln (error_obj.src_file + ": " + s);
      error_obj.no_errors++;
    } else
      ozc.debugln (s.toString ());
  }

  /**
    * print methods (of java.util.Vector format) 
    *
    * @param v methods
    */
  static final void printMethods (java.util.Enumeration v) {
    while (v.hasMoreElements ()) {
      ClassMember m = (ClassMember) v.nextElement ();
      ozc.debugln ("\t" + m.getDefinedClass () + ": '" 
			  + m.modifiers () + m.type + "'");
    }
  }

  /* 
   * followings are to output error message
   * each method name coreespond to name of property
   * see also 'ozc.property' file
   */

  static void noSourceFile () {
    print ("noSourceFile");
  }

  static void typeMismatch (Type t0, Type t1) {
    if (t0 instanceof ClassType && t1 instanceof ClassType) {
      ClassType c0 = (ClassType) t0;
      ClassType c1 = (ClassType) t1;

      if (c0.status == ClassType.CLS_NONE || c1.status == ClassType.CLS_NONE)
	return;

//      if (ozc.getOzc ().isParsing ()) return;
    }
    arguments.addElement (t0);
    arguments.addElement (t1);
    print ("typeMismatch");
  }

  static void notBoolean (Type t) {
    arguments.addElement (t);
    print ("notBoolean");
  }

  static void notClass (Type t) {
    arguments.addElement (t);
    print ("notClass");
  }

  static void notNumeric (Type t) {
    arguments.addElement (t);
    print ("notNumeric");
  }

  static void notArithmetic (Expression e) {
    arguments.addElement (e);
    print ("notArithmetic");
  }

  static void alreadyDefined (Identifier id) {
    arguments.addElement (id);
    print ("alreadyDefined", id.line_no);
  }

  static void alreadyDefinedAsProtected (Identifier id) {
    arguments.addElement (id);
    print ("alreadyDefinedAsProtected");
  }

  static void illegalOverride (Identifier id) {
    arguments.addElement (id);
    print ("illegalOverride");
  }

  static void illegalOverridePublicity (Identifier id) {
    arguments.addElement (id);
    print ("illegalOverridePublicity");
  }

  static void cannotOverride (Identifier id) {
    arguments.addElement (id);
    print ("cannotOverride");
  }

  static void overloadingAmbiguous (Identifier id) {
    arguments.addElement (id);
    print ("overloadingAmbiguous");
  }

  static void notClassName (String s) {
    arguments.addElement (s);
    print ("notClassName");
  }

  static void notDefinedMethod (MethodType mt, ClassType c) {
    arguments.addElement (mt);
    arguments.addElement (c);
    print ("notDefinedMethod");
  }

  static void notDefinedStaticMethod (String s, ClassType c) {
    arguments.addElement (s);
    arguments.addElement (c);
    print ("notDefinedStaticMethod");
  }

  static void notDefinedConstructor (MethodType mt, ClassType c) {
    arguments.addElement (mt);
    arguments.addElement (c);
    print ("notDefinedConstructor");
  }

  static void notDefinedIdentifier (String s) {
    arguments.addElement (s);
    print ("notDefinedIdentifier");
  }

  static void notDefinedAttribute (String s, ClassType c) {
    arguments.addElement (s);
    arguments.addElement (c);
    print ("notDefinedAttribute");
  }

  static void multiplyDefined (ClassType c) {
    arguments.addElement (c);
    print ("multiplyDefined", c.line_no);
  }

  static void multiplySuperClass (ClassType c, ClassType s) {
    arguments.addElement (c);
    arguments.addElement (s);
    print ("multiplySuperClass");
  }

  static void jumpCannotUsedHere () {
    Thread.dumpStack ();
    print ("jumpCannotUsedHere");
  }

  static void needIdentifier (Identifier i) {
    arguments.addElement (i);
    print ("needIdentifier");
  }

  static void notDefinedLabel (String l, int ln) {
    arguments.addElement (l);
    print ("notDefinedLabel", ln);
  }

  static void alreadyDefinedLabel (String l) {
    arguments.addElement (l);
    print ("alreadyDefinedLabel");
  }

  static void returnTypeMismatch (Type t0, Type t1) {
    arguments.addElement (t0);
    arguments.addElement (t1);
    print ("returnTypeMismatch");
  }

  static void needReturnExp () {
    print ("needReturnExp");
  }

  static void needReturnSt (int ln) {
    print ("needReturnSt", ln);
  }

  static void caseLabelMustBeAssignable (int ln) {
    print ("caseLabelMustBeAssignable", ln);
  }

  static void caseLabelMustBeConstant (int ln) {
    print ("caseLabelMustBeConstant", ln);
  }

  static void switchExpMustBeInt () {
    print ("switchExpMustBeInt");
  }

  static void mustBeBoolExpression () {
    print ("mustBeBoolExpression");
  }

  static void classModifierChanged (ClassType c) {
    arguments.addElement (c);
    print ("classModifierChanged");
  }

  static void notDefinedAsInterface (Identifier m) {
    arguments.addElement (m);
    print ("notDefinedAsInterface");
  }

  static void notDefinedAsSuperInterface (ClassType c) {
    arguments.addElement (c);
    print ("notDefinedAsSuperInterface");
  }

  static void notDefinedAsSuperClass (ClassType c) {
    arguments.addElement (c);
    print ("notDefinedAsSuperClass");
  }

  static void someSuperInterfaceDeleted (ClassType c, java.util.Vector v) {
    arguments.addElement (c);
    print ("someSuperInterfaceDeleted");
    for (int i = 0, size = v.size (); i < size; i++) {
      ozc.debug ("'" + v.elementAt (i) + "'");
      if (i + 1 < size) print (", ");
    }
    ozc.debugln ("");
  }

  static void someSuperClassDeleted (ClassType c, ClassType s) {
    arguments.addElement (c);
    arguments.addElement (s);
    print ("someSuperClassDeleted");
  }
  static void someMethodsDeleted (ClassType c, java.util.Enumeration v) {
    arguments.addElement (c);
    print ("someMethodsDeleted");
    printMethods (v);
  }

  static void someAbstractMethodsNotImplemented (java.util.Enumeration v) {
    print ("someAbstractMethodsNotImplemented");
    printMethods (v);
  }

  static void cannotLoadFile (ClassType c) {
    arguments.addElement (c);
    print ("cannotLoadFile");
  }

  static void cannotUseClassSymbol (Expression e) {
    ClassSymbol c = (ClassSymbol) e;
    arguments.addElement (c);
    print ("cannotUseClassSymbol");
  }

  static void cannotUseFinalAttribute (Identifier a) {
    arguments.addElement (a);
    print ("cannotUseFinalAttribute");
  }

  static void cannotAccess (ClassType c) {
    arguments.addElement (c);
    print ("cannotAccess");
  }

  static void cannotAccessPrivateAttribute (ClassType c) {
    arguments.addElement (c);
    print("cannotAccessPrivateAttribute");
  }

  static void abstractMethod (Identifier m) {
    arguments.addElement (m);
    print ("abstractMethod");
  }

  static void needMethodBody (Identifier m) {
    arguments.addElement (m);
    print ("needMethodBody");
  }

  static void mustBeGlobal (ClassType c) {
    arguments.addElement (c);
    print ("mustBeGlobal");
  }

  static void mustNotBeGlobal (ClassType c) {
    arguments.addElement (c);
    print ("mustNotBeGlobal");
  }

  static void cannotInstanceOfAbstractClass (ClassType c) {
    arguments.addElement (c);
    print ("cannotInstanceOfAbstractClass");
  }

  static void cannotInheritFinal (ClassType c) {
    arguments.addElement (c);
    print ("cannotInheritFinal");
  }

/*   static void cannotInheritSemiFinal (ClassType c) { */
/*     arguments.addElement (c); */
/*     print ("cannotInheritSemiFinal"); */
/*   } */

  static void cannotOverrideFinal (Identifier m) {
    arguments.addElement (m);
    print ("cannotOverrideFinal");
  }

  static void publicAttribute () {
    print ("publicAttribute");
  }

  static void illegalModifierAttribute () {
    print ("illegalModifierAttribute");
  }

  static void constructorMustCallSuper (Identifier m) {
    arguments.addElement (m);
    print ("constructorMustCallSuper");
  }

  static void unreachableSt (Statement st) {
    print ("unreachableSt", st.getLineNumber ());
  }

  static void unreachableLastSt (int ln) {
    print ("unreachableLastSt", ln);
  }

  static void cannotOpenFile (String f) {
    arguments.addElement (f);
    print ("cannotOpenFile");
  }

  static void cannotAccessAttribute (Identifier m) {
    arguments.addElement (m);
    print ("cannotAccessAttributeInStatic");
  }

  static void cannotCallMethod (Identifier m) {
    arguments.addElement (m);
    print ("cannotCallMethod");
  }

  static void cannotAccessAttribute (ClassImplementation c) {
    arguments.addElement (c);
    print ("cannotAccessAttribute");
  }

  static void cannotAccessAttributeOfGlobalObject (ClassImplementation c) {
    arguments.addElement (c);
    print ("cannotAccessAttributeOfGlobalObject");
  }

  static void cannotAccessThis (Identifier m) {
    arguments.addElement (m);
    print ("cannotAccessThis");
  }

  static void mustSpecifyImplementationClass (ClassType c) {
    arguments.addElement (c);
    print ("mustSpecifyImplementationClass");
  }

  static void mustCompatibleImplementationClass (ClassType c) {
    arguments.addElement (c);
    print ("mustCompatibleImplementationClass");
  }

  static void cannotAbstractAndFinalClass (ClassType c) {
    arguments.addElement (c);
    print ("cannotAbstractAndFinalClass");
  }

  static void cannotAbstractAndFinalMethod (String m) {
    arguments.addElement (m);
    print ("cannotAbstractAndFinalMethod");
  }

  static void cannotUseSuper (ClassType c) {
    arguments.addElement (c);
    print ("cannotUseSuper");
  }

  static void cannotPrivateAbstract (Identifier m) {
    arguments.addElement (m);
    print ("cannotPrivateAbstract");
  }

  static void cannotCreateJavaFile (ClassType c) {
    arguments.addElement (c);
    print ("cannotCreateJavaFile");
  }

  static void mustUseInConstructor () {
    print ("mustUseInConstructor");
  }

  static void cannotUseAsIncrementOperand () {
    print ("cannotUseAsIncrementOperand");
  }

  static void cannotThrowNonClassObject () {
    print ("cannotThrowNonClassObject");
  }

  static void illegalCharacterLiteral (String c) {
    arguments.addElement (c);
    print ("illegalCharacterLiteral");
  }

  static void mustSameKindType () {
    print ("mustSameKindType");
  }

  static void notName () {
    print ("notName");
  }

  static void cannotInheritProtected (ClassType c, ClassType sc) {
    arguments.addElement (c);
    arguments.addElement (sc);
    print ("cannotInheritProtected");
  }

  static void cannotAbstractForCell (ClassType c) {
    arguments.addElement (c);
    print ("cannotAbstractForCell");
  }

  static void cannotDefineAbstractMethodInCell (String name) {
    arguments.addElement (name);
    print ("cannotDefineAbstractMethodInCell");
  }

  static void cannotDefineConstructorInCell (String name) {
    arguments.addElement (name);
    print ("cannotDefineConstructorInCell");
  }

  static void cannotOpenLog (String file) {
    arguments.addElement (file);
    print ("cannotOpenLog");
  }

  static void cannotLoadSchool (String file) {
    arguments.addElement (file);
    print ("cannotLoadSchool");
  }

  static void cannotCompile (ClassType cl) {
    /* if (error_obj != null) error_obj.no_errors++; */
    arguments.addElement (cl);
    print ("cannotCompile");
  }

  static void cyclicInheritance () {
    print ("cyclicInheritance");
  }

  static void cannotCompileInterface (String file) {
    arguments.addElement (file);
    print ("cannotCompileInterface", 0);
  }

  static void thisVariableIsNull (Expression e) {
    arguments.addElement (e);
    print ("thisVariableIsNull");
  }

  static void syntaxError () {
    print ("syntaxError");
  }

  static void alreadyCatched (String e, Statement st) {
    arguments.addElement (e);
    print ("alreadyCatched", st.getLineNumber ());
  }

  static void cannotHide (ClassMember m) {
    arguments.addElement (m.name);
    print ("cannotHide", m.getLineNumber ());
  }

  static void throwAnything () {
    print ("throwAnything");
  }

  static void illegalCharacter (String c) {
    arguments.addElement (c);
    print ("illegalCharacter");
  }

}

/* EOF */

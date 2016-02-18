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
 * $Id: GlobalProxy.java,v 0.16 1997-10-30 15:03:35+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1997.01.24
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing proxy for global class
  * 
  * @see ClassImplementation
  * @see ClassType
  */

class GlobalProxy extends ClassImplementation {
  /**
    * base global class 
    */
  private ClassType global_class;

  /**
    * method number, for emit argument
    */
  private int method_number;

  /**
    * part number, inheritance depth
    */
  private int part_no;

  /**
    * create a proxy 
    * 
    * @param c corresponding global class (cell)
    */
  GlobalProxy (ClassType c) {
    /* this is tricky code.
     *  In school, implemeation id for cell specify one for 
     *  proxy implementaion (ends with '_pcc') */
    super (OzcProperty.PROXY_PREFIX + c.getName (), 
	   c.isClassInterface () ? c.getFullyQualifiedClassID () : 
	   ((ClassImplementation) c).getInterface ().getFullyQualifiedClassID (),
	   /*
	   c.isClassInterface () ? 
	   c.getFullyQualifiedClassID () + OzcProperty.PROXY_PCL_POSTFIX : c.getFullyQualifiedClassID () + OzcProperty.PROXY_PCC_POSTFIX
	   */
	   c.getFullyQualifiedClassID ());

    global_class = c;
  }

  /**
    * set part number 
    *
    * @param ci class interface
    * @param p previous part number
    * @return result
    */
  int setPartNumber (ClassInterface ci, int p) {
    ClassList si = ci.getSuperInterfaces ();
    int result = p, buf;

    for (int i = 0; i < si.size (); i++) {
      buf = setPartNumber ((ClassInterface) si.get (i), p + 1);
      if (buf > result) 
	result = buf;
    }

    return result;
  }

  /**
    * copy atttribute of class, for proxy of global class
    *	copied attributes:
    *		package, super interfaces, method table
    *	modified modifier (to non-global)
    *
    * @param c originally class
    */
  void copyToProxy (ClassType c) {
    package_name = c.getPackage ();
    initialize (c.getModifier () ^ GLOBAL);
    if (c.isClassInterface ())
      method_table = c.getMethodTable ();
  }

  /**
    * override 
    *
    * @see ClassType
    */
  boolean isProxy () { return true; }

  /**
    * overrides 
    * 
    * @see ClassType
    */
  void emitBody () {
    /* setup part number */
    part_no = setPartNumber ((ClassInterface) global_class, 1);

    /* 
     * if method_table != null, then
     *   interface compilation, in which emitted proxy implemenation first,
     * otherwise 
     *   implementation compilation, in which emitted aditional proxy 
     *   implementation.
     */
    if (method_table != null) {
      if (part_no == 1) /* patch ! */
	emitSelector ();
      emitInvoke ();

      method_number = 0;
      
      super.emitBody ();
    } else {
      Emitter.emitln ("protected String _getClassName () { return \"" + 
		      global_class + "\"; }");
    }

    emitConstructor (); 
  }

  /**
    * emit constructor definition 
    */
  private void emitSelector () {
    Emitter.emitln ("protected int part;");
    Emitter.emitln ();
    Emitter.emitln ("protected int selector;");
    Emitter.emitln ();
  }

  /**
    * emit constructor definition 
    */
  private void emitConstructor () {
    Emitter.emitln ();
    Emitter.emitln ();
    Emitter.emitln ("public " + class_id + 
		    " (" + School.STRING.getInterface () + 
		    " g, String c) throws Exception { super (g, c); }");
    Emitter.emitln ();
    Emitter.emitln ("public " + class_id + 
		    " (" + School.STRING.getInterface () + 
		    " g) throws Exception { super (g); }");
    Emitter.emitln ();
    Emitter.emitln ("public " + class_id + 
		    " () throws Exception { super (); }");
    Emitter.emitln ();
  }

  /**
    * emit invoke method, inherited JP.go.ipa.oz.system.OzObject, definition 
    */
  private void emitInvoke () {
    Emitter.emit ("protected Object invoke (" + School.CELL + " o) ");
    Emitter.emit ("throws Exception {");
    Emitter.indentPush ();
    Emitter.emitln ();
    Emitter.emitln ("if (part != " + part_no + ") return super.invoke (o);");
    Emitter.emitln ();

    String global_class_id = global_class.getFullyQualifiedClassID ();
    Emitter.emitln (global_class_id + " g = (" + global_class_id + ") o;");
    Emitter.emitln ("Object result;");
    Emitter.emitln ();
    Emitter.emit ("switch (selector) {");

    /* each public method */
    int i = 0;
    MethodTable mtable = method_table;

    for (java.util.Enumeration ms = mtable.elements ();
	 ms.hasMoreElements (); i++) {
      ClassMember m = (ClassMember) ms.nextElement ();
      if (!m.isPublic () && !m.isNew ()) continue;
	
      Emitter.emitln ();
      Emitter.emit ("case " + i + ":");
      Emitter.indentPush ();
      Emitter.emitln ();
	
      MethodType mt = (MethodType) m.getType ();
      Type rt = mt.getReturnType ();
	
      if (rt.isClass ())
	Emitter.emit ("return ");
      else if (!rt.isVoid ()) 
	Emitter.emit (rt + " rval$" + i + " = ");
      Emitter.emit ("g." + m + "(");
	
      /* emit arguements */
      ExpressionList args = mt.getArguments ();
      for (int j = 0, arg_size = args.size (); j < arg_size; j++) {
	Identifier a = (Identifier) args.get (j);
	emitArg (i, j, a);
	if (j + 1 < arg_size)
	  Emitter.emit (", ");
      }
	
      Emitter.emitln (");");
      if (!rt.isClass () && !rt.isVoid ()) {
	Emitter.emit ("return new ");
	emitType (rt);
	Emitter.emit ("(rval$" + i +");");
      } else if (rt.isVoid ())
	Emitter.emit ("return null;");
      Emitter.indentPop ();
    }

    Emitter.emitln ();
    Emitter.emit ("default:");
    Emitter.indentPush ();
    Emitter.emitln ();
    Emitter.emit ("throw new Exception (\"" + class_id 
		   + ": invalid selector = \" + selector);");
    Emitter.indentPop ();
    Emitter.emitln ();
    Emitter.emit ("}");
    Emitter.indentPop ();
    Emitter.emitln ();
    Emitter.emitln ("}");
  }

  /**
    * emit each method defintion 
    *
    * @param m method
    */
  void emitMethod (ClassMember m) {
    Emitter.emitln ();
	
    MethodType mt = (MethodType) m.getType ();
    ExpressionList args = mt.getArguments ();
	
    /* emit variable for arguments */
      
    for (int j = 0, arg_size = args.size (); j < arg_size; j++) {
      Identifier a = (Identifier) args.get (j);
      Emitter.emit (a.getType () + " ");
      emitArg (method_number, j, a);
      Emitter.emitln (";");
    }
    Emitter.emitln ();
    
    /* emit methods */
    Emitter.emit (m.modifiers ());
    Emitter.emit (mt);
    
    /* emit method body */
    Emitter.emit ("{");
    Emitter.indentPush ();
    
    Emitter.emitln ();
    Emitter.emitln ("enter ();");

    Emitter.emit ("try {");
    Emitter.indentPush ();
    
    if (m.isOnce ()) 
      mt.emitOnceBefore (method_number);

    Emitter.emitln ();
    Emitter.emitln ("part = " + part_no + ";");
    Emitter.emitln ("selector = " + method_number + ";");
    
    /* emit arguments copy */
    for (int j = 0, arg_size = args.size (); j < arg_size; j++) {
      Identifier a = (Identifier) args.get (j);
      emitArg (method_number, j, a);
      Emitter.emitln (" = " + a + ";");
    }
    
    Emitter.emit ("fork ();");
    Emitter.indentPop ();
    Emitter.emitln ();
    Emitter.emit ("} catch (Exception e) {");
    Emitter.indentPush ();
    Emitter.emitln ();
    /* Emitter.emitln ("JP.go.ipa.oz.system.OzSystem.debug (\"" + class_id
		     + "\", \"" + m + "\", e);"); */
    Emitter.emit ("throw e;");
    Emitter.indentPop ();
    Emitter.emitln ();
    Emitter.emit ("} finally {");
    Emitter.indentPush ();
    Emitter.emitln ();
/*     Emitter.emitln ("arguments = null;"); */
    
    /* emit argument clear */
    for (int j = 0, arg_size = args.size (); j < arg_size; j++) {
      Identifier a = (Identifier) args.get (j);
      emitArg (method_number, j, a);

      if (a.type.isClass ())
	Emitter.emitln (" = null;");
      else if (a.type.isBool ())
	Emitter.emitln (" = false;");
      else
	Emitter.emitln (" = 0;");
    }
    method_number++;
    
    Emitter.emit ("leave ();");
    Emitter.indentPop ();
    Emitter.emitln ();
    Emitter.emit ("}");
    
    Emitter.emitln ();
    Type rt = mt.getReturnType ();
    if (rt.isClass ()) 
      Emitter.emit ("return (" + rt + ") join ();");
    else if (rt.isVoid ()) {
      Emitter.emit ("join ();");
      if (m.isNew ()) {
	Emitter.emitln ();
	Emitter.emit ("return this;");
      }
    } else {
      emitType (rt);
      Emitter.emit (" result = (");
      emitType (rt);
      Emitter.emitln (") join ();");
      Emitter.emit ("return result." + rt + "Value ();");
    }
    
    Emitter.indentPop ();
    Emitter.emitln ();
    Emitter.emit ("}");
  }

  /**
    * emit type, if type is primitive type, emit its class replesentaion 
    * 
    * @param t type
    */
  private void emitType (Type t) {
    if (t == PrimitiveType.BYTE || t == PrimitiveType.CHAR ||
	t == PrimitiveType.SHORT || t == PrimitiveType.INT) 
      Emitter.emit ("Integer");
    else if (t == PrimitiveType.LONG) 
      Emitter.emit ("Long");
    else if (t == PrimitiveType.FLOAT) 
      Emitter.emit ("Float");
    else if (t == PrimitiveType.DOUBLE) 
      Emitter.emit ("Double");
    else if (t == PrimitiveType.BOOL) 
      Emitter.emit ("Boolean");
  }

  /**
    * emit mangled argument 
    *
    * @param i sequence number
    * @param j sequence number
    * @param m identifier 
    */
  private void emitArg (int i, int j, Identifier m) {
    Emitter.emit ("arg$" + j + "of" + i + "$" + m);
  }
}

/* EOF */

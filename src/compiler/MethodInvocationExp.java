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
 * $Id: MethodInvocationExp.java,v 0.30 1998-03-20 08:43:49+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing expression of method invocation.
  *
  * @see Expression
  */

class MethodInvocationExp extends Expression {
  /**
    * calee 
    */
  Expression operand;
  
  /**
    * method 
    */
  ClassMember method;
  
  /**
    * arguments 
    */
  ExpressionList arguments;

  /**
    * counter for pre emitting 
    */
  private static int count;

  /**
    * pre-emitted result 
    */
  private String result;
  
  /**
    * flag if this is super call
    */
  private boolean for_super;

  /**
    * flag need emitting with security checking
    */
  private boolean need_security_emitting;

  /**
    * flag if in static method
    */
  private boolean in_static_method;
  
  /**
    * create a node of abstract syntax tree
    *
    * @param m method
    * @param e calee
    * @param args arguments
    * @param impl method implemented this expression
    * @param ln line number
    * @param fs flag if this is super call
    */
  MethodInvocationExp (ClassMember m, Expression e, ExpressionList args, 
		       MethodType impl, int ln, boolean fs) {
    super (ln);
    operand = e;
    method = m;
    arguments = args;
    implemented_in = impl;
    for_super = fs;

    if (e instanceof MethodInvocationExp) {
      Type t = e.getType ();
      if (t instanceof ClassType)
	implemented_in.registerReferencing ((ClassType) t);
    }

    if (m.type != null)
      type = ((MethodType) m.type).getReturnType ();

    if (impl.getMethod ().isStatic ())
      in_static_method = true;
  }

  /**
    * access for method field
    *
    * @return method
    */
  final ClassMember getMethod () { return method; }
  
  /**
    * access for operand field
    *
    * @return field
    */
  final Expression getOperand () { return operand; }

  /**
    * override
    *
    * @see Expression
    */
  void preEmitForMethodInvocation () {
    if (result != null) return;

    if (operand != null) operand.preEmitForMethodInvocation ();
    arguments.preEmitForMethodInvocation ();

    if (!need_security_emitting && !need_pre_emitting) return;

    String tmp;

    Emitter.emitln (line_no);
    MethodType mt = (MethodType) method.type;
    Type rt = mt.getReturnType ();
    if (!rt.isVoid ()) {
      tmp = method + "$val$" + count++;
      Emitter.emitln (rt + " " + tmp + ";");
    } else 
      tmp = "";

    if (in_static_method) {
      emitInStaticMethod (tmp, rt);
      result = tmp;
      return;
    }

    if (need_security_emitting) {
      Emitter.emit ("if (changeThreadRedIfNecessary ("
		    + "(" + OzcProperty.COMMON_ROOT + ") ");
      Emitter.emit (operand);
      Emitter.emit (")) {");
      Emitter.indentPush ();
      Emitter.emitln ();
      Emitter.emit ("try {");
      Emitter.indentPush ();
      Emitter.emitln ();
      if (tmp.length () > 0) Emitter.emit (tmp + " = "); 
      Emitter.emit (toStringOnlyExpression () + ";");
      Emitter.indentPop ();
      Emitter.emitln ();
      Emitter.emit ("} finally {");
      Emitter.indentPush ();
      Emitter.emitln ();
      Emitter.emit ("changeRunningToGreen ();");
      Emitter.indentPop ();
      Emitter.emitln ();
      Emitter.emit ("}");
      Emitter.indentPop ();
      Emitter.emitln ();
      Emitter.emit ("} else {");
      Emitter.indentPush ();
      Emitter.emitln ();
      if (tmp.length () > 0) Emitter.emit (tmp + " = "); 
      Emitter.emit (toStringOnlyExpression () + ";");
      Emitter.indentPop ();
      Emitter.emitln ();
      Emitter.emit ("}");
    } else if (need_pre_emitting) {
      if (tmp.length () > 0) Emitter.emit (tmp + " = "); 
      Emitter.emit (toStringOnlyExpression () + ";");
    }

    result = tmp;
  }

  /**
    * emit this expression
    *
    * @return String instance
    */
  final String toStringOnlyExpression () {
    StringBuffer s = new StringBuffer ();
    if (operand != null) {
      if (operand instanceof InstantiationExp) {
	s.append ('(');
	s.append (operand);
	s.append (')');
      } else 
	s.append (operand);
      s.append ('.');
    } else if (for_super) {
	s.append ("super.");
    }
    s.append (method);
    s.append (" (");
    s.append (arguments.toStringWithoutType ());
    s.append (")");
    return s.toString ();
  }

  /**
    * emit this expression in static method
    *
    * @param var result value variable
    */
  final void emitInStaticMethod (String var, Type rt) {
    String types, args;

    if (!rt.isVoid ()) {
      /* emit arg types */
      types = var + "$types";
      emitArgumentTypes (types);

      /* emit args */
      args = var + "$args";
      emitArguments (args);

      Emitter.emit (var);
      Emitter.emit (" = ");

      if (rt.isPrimitive ()) {
	PrimitiveType pt = (PrimitiveType) rt;
	Emitter.emit ("((");
	Emitter.emit (pt.toStringAsJavaClassName ());
	Emitter.emit (") ");
      } else {
	Emitter.emit ("(");
	Emitter.emit (rt);
	Emitter.emit (") ");
      }
    } else {
      /* emit arg types */
      types = "types$" + count;
      emitArgumentTypes (types);

      /* emit args */
      args = "args$" + count++;
      emitArguments (args);
    }


    Emitter.emit (OzcProperty.COMMON_ROOT);
    Emitter.emit (".delegate ((");
    Emitter.emit (OzcProperty.COMMON_ROOT);
    Emitter.emit (") ");
    Emitter.emit (operand);
    Emitter.emit (", ");
    Emitter.emit (OzcProperty.UTILITY);
    Emitter.emit (".searchMethod (\"");
    Emitter.emit (operand.getType ());
    Emitter.emit ("\", \"");
    Emitter.emit (method);
    Emitter.emit ("\", ");
    Emitter.emit (types);
    Emitter.emit ("), ");
    Emitter.emit (args);
    Emitter.emit (")");

    if (!rt.isVoid () && rt.isPrimitive ()) {
      Emitter.emit (").");
      Emitter.emit ((PrimitiveType) rt);
      Emitter.emit ("Value () ");
    }

    Emitter.emit (";");
  }

  /**
    * emit expression to get argument types
    *
    * @param types temporal variable
    */
  final void emitArgumentTypes (String types) {
    Emitter.emit ("Class[] ");
    Emitter.emit (types);
    Emitter.emit (" = ");

    int size = arguments.size ();
    if (size == 0) {
      Emitter.emit ("null;");
      Emitter.emitln ();
      return;
    }
    
    Emitter.emit ("new Class[");
    Emitter.emit (String.valueOf(size));
    Emitter.emit ("];");
    Emitter.emitln ();
    for (int i = 0 ;i < size; i++) {
      Emitter.emit (types);
      Emitter.emit ("[");
      Emitter.emit (String.valueOf(i));
      Emitter.emit ("] = ");
      Emitter.emit (arguments.get (i).getType ().toStringAsClass ());
      Emitter.emit (";");
      Emitter.emitln ();
    }
  }

  /**
    * emit expression to get arguments
    *
    * @param types temporal variable
    */
  final void emitArguments (String args) {
    Emitter.emit ("Object[] ");
    Emitter.emit (args);
    Emitter.emit (" = ");

    int size = arguments.size ();
    if (size == 0) {
      Emitter.emit ("null;");
      Emitter.emitln ();
      return;
    }

    Emitter.emit ("new Object[");
    Emitter.emit (String.valueOf (size));
    Emitter.emit ("];");
    Emitter.emitln ();
    for (int i = 0 ;i < size; i++) {
      Emitter.emit (args);
      Emitter.emit ("[");
      Emitter.emit (String.valueOf (i));
      Emitter.emit ("] = ");
      Emitter.emit (arguments.get (i).toStringAsObject ());
      Emitter.emit (";");
      Emitter.emitln ();
    }
  }

  /**
    * override
    */
  public String toString () {
    if (result != null) return result;

    return toStringOnlyExpression ();
  }

  /**
    * check if need emitting expression.
    * if expression is method invocation, it may be pre-emitted.
    *
    * @return if so true, otherwise false.
    */
  static boolean needEmit (Expression e) {
    if (!(e instanceof MethodInvocationExp)) return true;

    MethodInvocationExp m = (MethodInvocationExp) e;

    return !m.need_security_emitting && !m.need_pre_emitting;
  }

  /* following static methods for actions of parser */

  /**
    * create method invoke expression 
    *
    * @param c class defined method
    * @param name name of method 
    * @param args arguments of method
    * @param ln line number
    * @param action ParserAction instance
    */
  static Expression create (ClassType c, String name,
			    ExpressionList args, 
			    int ln, ParserAction action) {
    return create (c, name, null, args, ln, action, false);
  }

  /**
    * create method invoke expression (super)
    *
    * @param c class defined method
    * @param name name of method 
    * @param args arguments of method
    * @param ln line number
    * @param action ParserAction instance
    */
  static Expression createForSuper (ClassType c, String name,
				    ExpressionList args, 
				    int ln, ParserAction action) {
    return create (c, name, null, args, ln, action, true);
  }

  /**
    * create method invoke expression 
    *
    * @param name name of method 
    * @param callee callee of method invocation
    * @param args arguments of method
    * @param ln line number
    * @param action ParserAction instance
    */
  static Expression create (String name,
			    Expression callee, 
			    ExpressionList args,
			    int ln, ParserAction action) {
    return create (null, name, callee, args, ln, action, false);
  }

  /**
    * create method invoke expression 
    *
    * @param c class defined method
    * @param name name of method 
    * @param callee callee of method invocation
    * @param args arguments of method
    * @param ln line number
    * @param action ParserAction instance
    */
  static Expression create (ClassType c, 
			    String name,
			    Expression callee, 
			    ExpressionList args,
			    int ln, ParserAction action,
			    boolean for_super) {
    ClassImplementation cls = action.getCls ();
    ClassInterface cls_interface = action.getClsInterface ();
    ClassType method_class = c;

    if (callee != null) {
      /* callee is not recognized in parsing */
      if (callee.type == null)
	return createDummy (name, callee, args, 
			    (c == null ? cls : c),
			    ln, action, for_super);

      if (callee.type.isClass ()) {
	method_class = (ClassType) callee.type;
      } else {
	if (callee.type != Type.ANY) {
	  /* expression is not any class type */
	  OzcError.notClass (callee.type);
	}
	return Expression.ANY;
      }
    }

    if (action.isNotChecked (args)) 
      return createDummy (name, callee, args, 
			  (c == null ? cls : c), 
			  ln, action, for_super);

    if (method_class.isProtected () && 
	method_class instanceof ClassInterface) {
      method_class = ((ClassInterface) method_class).getImplementation ();
    }

    int access;
    /* if this class or one in file, then can be access PRIVATE member */
    if (action.isParsingIt (method_class) && 
	(method_class.isProtected () || method_class == cls || 
	 method_class == cls_interface))
      access = Constants.PRIVATE;
    else if (callee == null) /* super->foo () pattern */
      access = Constants.PROTECTED;
    else 
      access = Constants.PUBLIC;

    ClassMember m = action.searchMethod (method_class, name, callee, 
					 args, access);
    if (m == null)
      return createDummy (name, callee, args, 
			  (c == null ? cls : c), 
			  ln, action, for_super);
    else if (m == ClassMember.ANY)
      return Expression.ANY;

    return new MethodInvocationExp (m, callee, args, action.getMethod (), ln,
				    for_super);
  }

  /**
    * create and register not recognzized method invocation expression 
    *
    * @param name name of method 
    * @param callee callee of method invocation
    * @param args arguments of method
    * @param c class defined method
    * @param ln line number
    * @param action ParserAction instance
    */
  static Expression createDummy (String name, 
				 Expression callee,
				 ExpressionList args, 
				 ClassType c, int ln, ParserAction action,
				 boolean for_super) {
    if (!action.isParsing ()) return Expression.ANY;

    ClassMember m = new ClassMember (name);
    m.setDefinedClass (c);
    Expression exp = new MethodInvocationExp (m, callee, args, 
					      action.getMethod (), ln, 
					      for_super);
    action.addToNotCheckedList (exp);
    return exp;
  }

  /**
    * for method invocation expression, check method after parsing 
    *
    * @param exp method invocation expression
    * @param action ParserAction instance
    */
  static void check (MethodInvocationExp exp, ParserAction action) {
    ClassType c;
    c = exp.method.getDefinedClass ();
    if (c instanceof ClassInterface)
      action.setClsInterface ((ClassInterface) c);
    else
      action.setCls ((ClassImplementation) c);
    action.setMethod (exp.implemented_in);

    if (exp.operand instanceof AttributeAccessExp &&
	((AttributeAccessExp) exp.operand).attribute instanceof ClassSymbol) {
      exp.operand = ((AttributeAccessExp) exp.operand).attribute;
    }

    Expression e = create (c,
			   exp.method.name, 
			   exp.operand, 
			   exp.arguments,
			   exp.line_no, action, exp.for_super);
    if (e == null || e == Expression.ANY) return;

    action.checkExpressionType (e, exp);
    exp.method = ((MethodInvocationExp) e).method;
    exp.type = e.type;
  }

  /**
    * check expression unrecognized in parsing 
    */
  void check () {
    if (operand != null) operand.check ();
    arguments.check ();

    /*
    if (operand instanceof Variable && ((Variable) operand).isNull ()) {
      OzcError.setLineNumber (line_no);
      OzcError.thisVariableIsNull (operand);
      return;
    }
    */

    if (operand == null ||
	operand instanceof ThisExp ||
	operand instanceof ClassSymbol ||
	operand instanceof InstantiationExp ||
	(operand instanceof Variable &&
	 ((Variable) operand).isGreen ())) 
      need_security_emitting = false;
    else {
      need_security_emitting = true;

      setPreEmittingFlag ();
    }
  }

  /**
    * set flag to pre-emit
    */
  void setPreEmittingFlag () { 
    if (!need_security_emitting) 
      need_pre_emitting = true;

    if (operand != null) operand.setPreEmittingFlag ();
    arguments.setPreEmittingFlag ();
  }
}

/* EOF */

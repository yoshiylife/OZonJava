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
 * $Id: InstantiationExp.java,v 0.21 1998-01-30 11:04:55+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/** 
  * A class representing expression of object instantiation.
  *
  * @see Expression
  */

class InstantiationExp extends Expression {
  /**
    * object 
    */
  Expression instance;
  
  /**
    * constructor symbol 
    */
  ClassMember constructor;
  
  /**
    * pre-emitted value
    */
  private String result;

  /**
    * counter for pre emitting 
    */
  private static int count;

  /**
    * arguments 
    */
  ExpressionList arguments;
  
  /**
    * create a node of abstract syntax tree
    *
    * @param c constructor
    * @param i instance
    * @param args arguments of construcotr
    * @param ln line number
    */
  InstantiationExp (ClassMember c, Expression i, ExpressionList args, 
		    MethodType impl, int ln) {
    super (ln);
    constructor = c;
    instance = i;
    arguments = args;
    implemented_in = impl;

    if (i != null)
      type = i.type;
    else
      type = PrimitiveType.VOID;
  }
  
  /** access for constructor field
    * 
    * @return constructor
    */
  ClassMember getConstructor () { return constructor; }

  /**
    * override
    *
    * @see Expression
    */
  void preEmitForMethodInvocation () { 
    if (result != null) return;

    arguments.preEmitForMethodInvocation ();

    if (!need_pre_emitting) return;

    Emitter.emitln (line_no);
    Emitter.emitln (toString () + ";");
    result = instance.toString ();
  }

  /**
    * override
    */
  public String toString () {
    if (result != null) return result;

    StringBuffer s = new StringBuffer ();
    if (Emitter.isEmitting ()) {
      ClassInterface c = null;
      if (instance != null) {
	c = (ClassInterface) type;
	ClassImplementation cl = c.getImplementation ();
	s.append (instance);
	s.append (" = ");
	if (c != null && c.isGlobal ()) {
	  s.append ("new ");
	  s.append (c.getProxy ());
	  s.append (" (");
	  s.append (arguments.toStringWithoutType ());
	  if (constructor.getName ().equals (OzcProperty.CREATE_CELL)) {
	    s.append (", ");
	    s.append ('"' + cl.toString () + '"');
	  }
	  s.append (")");
	} else {
	  s.append ("(");
	  s.append (cl);
	  s.append (") (new ");
	  s.append (cl);
	  s.append (" ()).");
	}
      } else {
	s.append ("super.");
      }
      if (!(c != null && c.isGlobal ())) { 
	s.append (constructor);
	s.append (" (");
	s.append (arguments.toStringWithoutType ());
	s.append (')');
      }
    } else {
      if (instance != null) 
	s.append (instance);
      else
	s.append ("super");
      s.append ("=>");
      s.append (constructor);
      s.append (" (");
      s.append (arguments.toStringWithoutType ());
      s.append (')');
    }
    return s.toString ();
  }

  /* following static methods for actions of parser */

  /**
    * create an instantiation expression
    *
    * @param name name of constructor
    * @param args arguements of constructor
    * @param ln line number
    * @param action ParserAction instance
    */
  static Expression create (String name,
			    ExpressionList args,
			    int ln, ParserAction action) {
    return create (null, name, null, args, ln, action);
  }

  /**
    * create an instantiation expression
    *
    * @param name name of constructor
    * @param object instance
    * @param args arguements of constructor
    * @param ln line number
    * @param action ParserAction instance
    */
  static Expression create (String name,
			    Expression object,
			    ExpressionList args,
			    int ln, ParserAction action) {
    return create (null, name, object, args, ln, action);
  }

  /**
    * create an instantiation expression
    *
    * @param c class defined constructor
    * @param name name of constructor
    * @param object instance
    * @param args arguements of constructor
    * @param ln line number
    * @param action ParserAction instance
    */
  static Expression create (ClassType c,
			    String name,
			    Expression object,
			    ExpressionList args,
			    int ln, ParserAction action) {
    ClassImplementation cls = action.getCls ();

    if (object == null) {
      action.getMethod ().getMethod ().calledSuper ();
      if (c == null) c = cls.getSuperClass ();
    } else {
      if (action.isIllegalAttributeReference (object))
	return Expression.ANY;
	
      Type t = object.type;
	
      /* object is not-recognized attribute access expression */
      if (t == null) 
	return createDummy (name, object, args, ln, action);
	
      if (!t.isClass ()) {
	/* expression is not any class type */
	if (t != Type.ANY) 
	  OzcError.notClass (t);

	return Expression.ANY;
      }
      c = (ClassType) t;

      if (action.isNotFound (c))
	return createDummy (c, name, object, args, ln, action);
    }

    ClassImplementation ci;
    if (!c.isClassInterface ())
      ci = (ClassImplementation) c;
    else {
      ClassInterface cit = (ClassInterface) c;
      if (c.isGlobal ())
	ci = cit.getProxy ();
      else
	ci = cit.getImplementation ();

      /* some error check */
      if (ci.class_id == null) {
	/* not specified in school */
	OzcError.mustSpecifyImplementationClass (ci);
	return Expression.ANY;

      } else {
	if (!action.isInFile (ci) && !OzcClassLoader.exists (ci)) {
	  /* need executable code */
	  action.addToNotFoundList (ci);

	} else if (ci.isAbstract ()) {
	  /* cannot instatiate for abstract class */
	  OzcError.cannotInstanceOfAbstractClass (ci);
	  return Expression.ANY;
	    
	} else if (!c.isAssignable (ci)) {
	  /* imcompatible implementation with interface */
	  OzcError.mustCompatibleImplementationClass (ci);
	  return Expression.ANY;
	}
      }
    }

    if (action.isNotChecked (args)) 
      return createDummy (ci, name, object, args, ln, action);

    ClassMember m = action.searchConstructor (ci, name, null, args);

    if (m == null)
      return createDummy (ci, name, object, args, ln, action);
    else if (m == ClassMember.ANY)
      return Expression.ANY;

    action.registerInstantiating (ci);

    return new InstantiationExp (m, object, args, action.getMethod (), ln);
  }
      
  /**
    * create and register not recognzized instantiation expression 
    *
    * @param name name of constructor
    * @param object instance
    * @param args argumentso of constructor
    * @param ln line number
    * @param action ParserAction instance
    */
  static Expression createDummy (String name, 
				 Expression object,
				 ExpressionList args,
				 int ln, ParserAction action) {
    return createDummy (null, name, object, args, ln, action);
  }

  /**
    * create and register not recognzized instantiation expression 
    *
    * @param c class defined constructor
    * @param name name of constructor
    * @param object instance
    * @param args argumentso of constructor
    * @param ln line number
    * @param action ParserAction instance
    */
  static Expression createDummy (ClassType c,
				 String name, 
				 Expression object,
				 ExpressionList args,
				 int ln, ParserAction action) {
    if (!action.isParsing ()) return Expression.ANY;

    ClassMember m = new ClassMember (name);
    if (c != null) {
      /* call constructor of super class */
      m.setDefinedClass (c);
    }
    Expression exp = new InstantiationExp (m, object, args, 
					   action.getMethod (), ln);
    action.addToNotCheckedList (exp);
    return exp;
  }

  /**
    * for method invocation expression, check method after parsing 
    *
    * @param exp instantiation expression
    * @param action ParserAction instance
    */
  static void check (InstantiationExp exp, ParserAction action) {
    ClassType c;
    /* call constructor of super class */
    if (exp.instance == null) 
      c = exp.constructor.getDefinedClass ();
    else
      c = null;

    action.setMethod (exp.implemented_in);
    Expression e = create (c,
			   exp.constructor.name, 
			   exp.instance,
			   exp.arguments,
			   exp.line_no, action);

    if (e == null || e == Expression.ANY) return;

    action.checkExpressionType (e, exp);
    exp.constructor = ((InstantiationExp) e).constructor;
    exp.type = e.type;
  }

  /**
    * check expression unrecognized in parsing 
    */
  void check () {
    arguments.check ();
    if (instance != null)
      ((Variable) instance).changeGreen ();
  }

  /**
    * set flag to pre-emit
    */
  void setPreEmittingFlag () {
    need_pre_emitting = true;

    arguments.setPreEmittingFlag ();
  }
}

/* EOF */

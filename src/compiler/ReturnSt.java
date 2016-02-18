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
 * $Id: ReturnSt.java,v 0.14 1998-02-02 08:31:39+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing return statement
  *
  * @see Statement
  * @see Constants
  */

class ReturnSt extends Statement implements Constants {
  /**
    * expression or null 
    */
  Expression exp;
  
  /**
    * identifier of method 
    */
  ClassMember method;
  
  /**
    * create a node of abstract syntax tree
    *
    * @param e expression
    * @param m method signature
    * @param ln line number
    */
  ReturnSt (Expression e, MethodType m, int ln) {
    super (ln);
    exp = e;
    method = m.getMethod ();

    if (e != null) {
      if (e.type == null) {
	e.type = m.getReturnType ();
	return;
      }

      /*
      if (!m.getReturnType ().isAssignable (e)) {
	OzcError.returnTypeMismatch (e.type, m);
      }
      */
    } else {
      if (!m.getReturnType ().isVoid ()) {
	/* need expression or type must be void */
	OzcError.needReturnExp ();
      } 
    }
  }
  
  /**
    * override
    *
    * @see Statement 
    */

  void check (MethodType meth) throws Unreachable {
    if (exp != null) {
      MethodType m = (MethodType) method.getType ();
      
      if (!m.getReturnType ().isAssignable (exp)) {
	/* type mismatch */
	OzcError.returnTypeMismatch (exp.type, m);
      }
      exp.check ();
    }

    throw new Unreachable ();
  }
  
  /**
    * override
    *
    * @see Statement 
    */
  void emit () {
    if (Emitter.isEmitting () && exp != null) 
      exp.preEmitForMethodInvocation ();

    Emitter.emitln (line_no);
    Emitter.emit ("return");
      
    if (exp != null) {
      Emitter.emit (" ");

      if (!Emitter.isEmitting ()) 
	Emitter.emit (exp);
      else {
	if (method.isOnce ()) {
	  MethodType mt = (MethodType) method.getType ();
	  Emitter.emit ("(once_result$" + mt.getNumber () 
			 + " = " + exp + ")");
	} else
	  Emitter.emit (exp);
      }
    } else if (Emitter.isEmitting () && method.access == NEW) {
      Emitter.emit (" this");
    }
      
    Emitter.emit (";");
  }
}

/* EOF */

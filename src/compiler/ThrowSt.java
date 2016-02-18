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
 * $Id: ThrowSt.java,v 0.21 1998-02-02 08:31:43+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing throw statement.
  *
  * @see Statement
  */

class ThrowSt extends Statement {
  /**
    * expression or null 
    */
  Expression exp;

  /**
    * catch stmt. including this stmt.
    */
  CatchSt catch_st;
  
  /**
    * create new one
    *
    * @param e expression
    * @param ln line number
    * @param current current processing catch statement
    */
  ThrowSt (Expression e, int ln, CatchSt current) {
    super (ln);
    exp = e;

    catch_st = current;

    if (e == null) {
      if (current == null)
	OzcError.throwAnything ();
      return;
    }

    if (e.type != null && !e.type.isClass () && e.type != Type.ANY)
      OzcError.cannotThrowNonClassObject ();
  }
  
  /**
    * override
    *
    * @see Statement
    */
  void check (MethodType method) throws Unreachable {
    if (exp != null)
      exp.check ();

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
    Emitter.emit ("throw");
      
    if (Emitter.isEmitting ()) {
      Expression e = exp != null ? exp : catch_st.exception;

      Emitter.emit (" ");
      if ((e instanceof Variable) &&
	  catch_st != null &&
	  e == catch_st.exception && 
	  OzcProperty.search (e.getType ().getName ()) != null)
	Emitter.emit ("_exception_" + e);
      else
	Emitter.emit ("new " + OzcProperty.OZ_EXCEPTION + " (" + e + ")");
    } else if (exp != null)
      Emitter.emit (exp);
      
    Emitter.emit (";");
  }
}

/* EOF */

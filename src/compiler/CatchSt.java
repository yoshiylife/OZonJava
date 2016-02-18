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
 * $Id: CatchSt.java,v 0.21 1998-02-02 08:31:21+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing catch statement.
  *
  * @see Statement 
  * @see CatchStList
  * @see ParserAction
  * @see TrySt
  */

class CatchSt extends Statement {
  /**
    * identifier of caught exception 
    */
  Identifier exception;
  
  /**
    * statement 
    */
  Statement st;
  
  /**
    * create a node of abstract syntax tree 
    *
    * @param ex catching exception identifier
    * @param s body block statement
    * @param ln line number
    */
  CatchSt (Identifier ex, CompoundSt s, int ln) {
    super (ln);
    exception = ex;
    st = s;
  }
  
  /**
    * overide 
    *
    * @see Statement
    */
  void check (MethodType method) throws Unreachable {
    exception.changeMaybeRed ();
    st.check (method); 
  }

  /**
    * override
    *
    * @see Statement
    */
 boolean hasBreak (Identifier lab) { return st.hasBreak (lab); }

  /**
    * override
    *
    * @see Statement
    */
  void emit () { emit (null); }
 
  /**
    * emit statement
    *
    * @param ex exception identifier
    * @see Statement
    */
  void emit (String ex) {
    if (Emitter.isEmitting ()) {
      if (ex == null)
	ex = "_exception_" + exception;

      Type t = exception.getType ();
      String java_throwable = OzcProperty.search (t.getName ());
      if (java_throwable != null) {
	if (ozc.isTest ()) {
	  ozc.debugln (line_no + ": " + ((ClassType) t).name + 
		       " is converted to " + 
		       OzcProperty.EXCEPTION_IF);
	}

	Emitter.emitln ();
	Emitter.emit ("catch (");
	Emitter.emit (java_throwable);
	Emitter.emit (" " + ex + ") {");
	Emitter.indentPush ();
	Emitter.emitln ();
      }

      if (java_throwable != null)
	Emitter.emitln (OzcProperty.EXCEPTION_IF + 
			" " + exception + " = new " 
			+ OzcProperty.EXCEPTION_CL + 
			" (" + ex + ");");
      else {
	if (ozc.isTest ()) {
	  ozc.debugln (line_no + ": " + ((ClassType) t).name + 
		       " is converted to " + 
		       OzcProperty.OZ_EXCEPTION);
	}

	Emitter.emit ("if (_oz" + ex + " instanceof " + t 
			+ ") {");
	Emitter.indentPush ();
	Emitter.emitln ();
	Emitter.emit (t + " " + exception + " = (" + t + ") _oz" + ex + ";");
      }

      ((CompoundSt) st).emitNoBrace ();
      Emitter.indentPop ();
      Emitter.emitln ();
      Emitter.emit ("}");
    } else {
      Emitter.emit ("catch (");
      Emitter.emit (exception.getType ());
      Emitter.emit (" " + exception + " {");
      Emitter.indentPush ();
      Emitter.emitln ();
      ((CompoundSt) st).emitNoBrace ();
      Emitter.indentPop ();
      Emitter.emitln ();
      Emitter.emit ("}");
    }
  }
}

/* EOF */

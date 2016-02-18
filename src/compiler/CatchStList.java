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
 * $Id: CatchStList.java,v 0.13 1998-02-02 08:31:22+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing list of catch statement.
  * 
  * @see CatchSt
  * @see ParserAction
  * @see TryBodySym
  * @see TrySt
  */

class CatchStList extends java.util.Vector {
  /**
    * system exceptions
    */
  java.util.Vector system_exceptions;

  /**
    * user exceptions
    */
  java.util.Vector user_exceptions;

  /**
    * create list
    */
  CatchStList () {
    user_exceptions = new java.util.Vector ();
    system_exceptions = new java.util.Vector ();
  }

  
  /**
    * add catch statement to list 
    *
    * @param st a catch block of try statement
    */
  void add (CatchSt st) {
    String ename = st.exception.getType ().getName ();
    java.util.Vector list;
    if (OzcProperty.search (ename) != null) 
      list = system_exceptions;
    else
      list = user_exceptions;
     
    for (int i = 0, size = list.size (); i < size; i++) {
      String e = 
	((CatchSt) list.elementAt (i)).exception.getType ().getName ();
      if (e.equals (ename)) {
	OzcError.alreadyCatched (ename, st);
	return;
      }
    }
    list.addElement (st);
  }
  
  /**
    * return the number of catch blocks
    *
    * @return size
    */
  int sizeOf () {
    return system_exceptions.size () + user_exceptions.size ();
  }
  
  /**
    * get a CatchSt 
    *
    * @param i index of catch statement in list
    * @return a catch block
  CatchSt get (int i) { return (CatchSt) elementAt (i); } */
  
  /**
    * check reachability and if last statement is return statement, 
    * for each catch statement
    *
    * @param method method type
    */
  void check (MethodType method) throws Unreachable { 
    for (int i = 0, size = system_exceptions.size (); i < size; i++) {
      CatchSt cst = (CatchSt) system_exceptions.elementAt (i);

      /* RuntimeException is superclass of other system execeptions */
      if (cst.exception.getType ().getName ().equals ("RuntimeException") &&
	  i + 1 < size)
	throw new Unreachable ((CatchSt) system_exceptions.elementAt (i + 1));
    }

    for (int i = 0; i < user_exceptions.size (); i++) 
      ((CatchSt) user_exceptions.elementAt (i)).check (method);
    for (int i = 0, size = system_exceptions.size (); i < size; i++) 
      ((CatchSt) system_exceptions.elementAt (i)).check (method);
  }

  /**
    * override
    *
    * @see Statement
    */
  boolean hasBreak (Identifier lab) {
    for (int i = 0; i < user_exceptions.size (); i++) 
      if (((CatchSt) user_exceptions.elementAt (i)).hasBreak (lab))
	return true;
    for (int i = 0, size = system_exceptions.size (); i < size; i++) 
      if (((CatchSt) system_exceptions.elementAt (i)).hasBreak (lab))
	return true;

    return false;
  }

  /**
    * emit each catch statment
    */
  public void emit () {
    if (user_exceptions.size () != 0) {
      if (Emitter.isEmitting ()) {
	String exception = "_exception_" + Emitter.getPostfix ();
	Emitter.emitln ();
	Emitter.emit ("catch (");

	Emitter.emit (OzcProperty.OZ_EXCEPTION);
	Emitter.emit (" " + exception + ") {");
	Emitter.indentPush ();
	Emitter.emitln ();

	Emitter.emitln (School.ROOT.getInterface () 
			+ " _oz" + exception + " = " + exception + "."
			+ OzcProperty.GET_EXCEPTION + ";");

	for (int i = 0; i < user_exceptions.size (); i++) {
	  if (i != 0) Emitter.emit (" else ");
	  ((CatchSt) user_exceptions.elementAt (i)).emit (exception);
	}

	Emitter.emit (" else throw " + exception+ ";");
	
	Emitter.indentPop ();
	Emitter.emitln ();
	Emitter.emit ("}");
      } else {
	for (int i = 0; i < user_exceptions.size (); i++) 
	  ((CatchSt) user_exceptions.elementAt (i)).emit ();
      }
    }

    for (int i = 0; i < system_exceptions.size (); i++) 
      ((CatchSt) system_exceptions.elementAt (i)).emit ();
  }
}

/* EOF */

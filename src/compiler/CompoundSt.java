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
 * $Id: CompoundSt.java,v 0.12 1998-02-02 08:31:24+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing compound (block) statement.
  *
  * @see Statement
  */

class CompoundSt extends Statement {
  /**
    * contents of block
    */
  java.util.Vector statements;

  /**
    * upper level block
    */
  CompoundSt upper;

  /**
    * create a node of abstract syntax tree.
    *
    * @param up upper level block
    * @param ln line number
    */
  CompoundSt (CompoundSt up, int ln) {
    super (ln);
    upper = up;
    statements = new java.util.Vector ();
  }

  /**
    * create a node of abstract syntax tree.
    * for method body block 
    *
    * @param ln line number
    */
  CompoundSt (int ln) { this (null, ln); }

  /**
    * get the number of statements 
    *
    * @return the number of statements.
    */
  int size () { return statements.size (); }

  /**
    * get a statement 
    * 
    * @param i index of statement
    * @return statement
    */
  Statement get (int i) { return (Statement) statements.elementAt (i); }

  /**
    * add one statement 
    * 
    * @param st statement
    */
  void add (Statement st) { statements.addElement (st); }

  /**
    * override 
    *
    * @param method method type
    * @see Statement
    */
  void check (MethodType method) throws Unreachable {
    int size = statements.size ();

    if (size == 0) {
      if (method != null) method.checkReturnSt (line_no);
      return;
    }

    for (int i = 0; i < size - 1; i++) {
      Statement st = get (i);

      try {
	st.check (null);
      } catch (Unreachable e) {
	if (e.getStatement () == null)
	  e.setStatement (get (i + 1));
	throw e;
      }
    }

    get (size - 1).check (method);
  }

  /**
    * override
    *
    * @see Statement 
    */
  boolean hasBreak (Identifier lab) {
    for (int i = 0, size = statements.size (); i < size; i++)
      if (get (i).hasBreak (lab))
	return true;

    return false;
  }

  /**
    * override
    *
    * @see Statement
    */
  void emit () {
    Emitter.emit ("{");
    Emitter.indentPush ();
    emitNoBrace ();
    Emitter.indentPop ();
    Emitter.emitln ();
    Emitter.emit ("}");
  }

  /**
    * emit only contents
    */
  void emitNoBrace () {
    for (int i = 0, size = statements.size (); i < size; i++) get (i).emit ();
  }
}

/* EOF */

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
 * $Id: Statement.java,v 0.9 1998-02-02 08:31:40+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing any statement.
  */

abstract class Statement {
  /**
    * line number 
    */
  protected int line_no;

  /**  
    * create a node of abstract syntax tree
    *
    * @param ln line number
    */
  protected Statement (int ln) { line_no = ln; }

  /**
    * label
    */
  protected Identifier label;

  /**
    * emit statement 
    */
  abstract void emit ();

  /**
    * check reachability and if last statement is return statement 
    *
    * @param method method type
    */
  void check (MethodType method) throws Unreachable { 
    if (method != null) 
      method.checkReturnSt (line_no);
  }

  /**
    * check if conttains break statement
    *
    * @param lab searched label
    * @return if so true, otherwise false
    */
  boolean hasBreak (Identifier lab) { return false; }

  /**
    * check if break statment 
    *
    * @return if so true, otherwise false.
    */
  boolean isBreak () { return false; }
  
  /**
    * check if continue statment 
    *
    * @return if so true, otherwise false.
    */
  boolean isContinue () { return false; }

  /** 
    * access for line_no field
    * 
    * @return line nubmer
    */
  int getLineNumber () { return line_no; }
}

/* EOF */

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
 * $Id: TrySt.java,v 0.15 1998-02-02 08:31:44+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing try statement
  *
  * @see Statement
  */

class TrySt extends Statement {
  /**
    * statement for try 
    */
  Statement try_part;
  
  /**
    * list of catch statement 
    */
  CatchStList catch_part;
  
  /**
    * statment for finally 
    */
  Statement finally_part;

  /**
    * create new one
    * 
    * @param t_st try part
    * @param c_list catch statements
    * @param f_part finally part
    * @param ln line number
    */
  TrySt (Statement t_st, CatchStList c_list, Statement f_part, int ln) { 
    super (ln); 

    try_part = t_st;
    catch_part = c_list;
    finally_part = f_part;

    if (c_list.sizeOf () == 0 && f_part == null) {
      OzcError.syntaxError ();
    }
  }
  
  /**
    * override
    *
    * @param method method type
    * @see Statement
    */
  void check (MethodType method) throws Unreachable { 
    Unreachable unreach = null;
    
    try {
      try_part.check (method);
    } catch (Unreachable e) {
      /* true unreachable ? */
      if (e.getStatement () != null) throw e;

      unreach = e;
    }

    try {
      catch_part.check (method);
      
      unreach = null;
    } catch (Unreachable e) {
      /* true unreachable ? */
      if (e.getStatement () != null) throw e;
    }

    if (finally_part != null) {
      try {
	finally_part.check (method);

	unreach = null;
      } catch (Unreachable e) {
	/* true unreachable ? */
	if (e.getStatement () != null) throw e;

	unreach = e;
      }
    }

    if (unreach != null) throw unreach;
  }

  /**
    * override
    *
    * @see Statement
    */
  boolean hasBreak (Identifier lab) {
    if (try_part.hasBreak (lab) || catch_part.hasBreak (lab))
      return true;

    if (finally_part != null && finally_part.hasBreak (lab))
      return true;

    return false;
  }

  /**
    * override
    *
    * @see Statement
    */
  void emit () {
    Emitter.emitln (line_no);
    Emitter.emit ("try ");
    try_part.emit ();
      
    if (catch_part != null) catch_part.emit ();
      
    if (finally_part != null) {
      Emitter.emit (" finally ");
      finally_part.emit ();
    }
  }
}

/* EOF */

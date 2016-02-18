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
 * $Id: Unreachable.java,v 0.5 1997-08-19 13:50:33+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.1.20
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing exception of unreachable statement 
  *
  * @see Exception
  */

class Unreachable extends Exception {
  /**
    * unreachable statement
    */
  Statement st;

  /**
    * break statement;
    */
  JumpSt jump_st;

  /**
    * create new one
    *
    * @param s statement
    */
  Unreachable (Statement s) { 
    super (); 
    st = s;
  }

  /**
    * create new one
    */
  Unreachable () { super (); }

  /** 
    * access for st field 
    *
    * @return statement
    */
  Statement getStatement () { return st; }

  /**
    * set for st field 
    * 
    * @param s statement
    */
  void setStatement (Statement s) { st = s; }
}

/* EOF */

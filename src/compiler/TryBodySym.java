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
 * $Id: TryBodySym.java,v 0.4 1997-06-04 16:49:50+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.5
 */

package JP.go.ipa.oz.compiler;

/**
  * Aclass representing symbol of try body 
  *
  * @see OzStrToken
  */

class TryBodySym extends OzStrToken {
  /**
    * list of catch 
    */
  CatchStList catch_list;
  
  /**
    * finally part
    */
  Statement finally_st;

  /**
    * create new one 
    * 
    * @param sym kind of symbol
    */
  TryBodySym (int sym) { super (sym); }
}

/* EOF */

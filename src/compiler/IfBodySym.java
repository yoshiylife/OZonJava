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
 * $Id: IfBodySym.java,v 0.4 1997-06-04 16:49:26+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.5
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing symbol of if statement body in parser.
  *
  * @see OzStrToken
  */

class IfBodySym extends OzStrToken {
  /**
    * statement of true part 
    */
  Statement if_st;

  /**
    * statement of false (else) part 
    */
  Statement else_st;

  /**
    * create a symbol 
    * 
    * @param sym kind of symbol
    */
  IfBodySym (int sym) { super (sym); }
}

/* EOF */

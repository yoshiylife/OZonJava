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
 * $Id: NeedReturn.java,v 0.3 1997-07-30 15:54:38+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.1.20
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing exception of no return statement
  *
  * @see Exception
  */

class NeedReturn extends Exception {
  /**
    * line nubmer 
    */
  int line_no;

  /** 
    * @param ln line number
    */
  NeedReturn (int ln) { 
    super (); line_no = ln; 
  }

  NeedReturn () { super (); }
}

/* EOF */

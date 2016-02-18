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
 * $Id: OzToken.java,v 0.6 1997-07-04 11:15:30+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1997.1.31
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representation token with line number.
  * 
  * @see java_cup.runtime.token
  */

class OzToken extends java_cup.runtime.token {
  /* clonable token */

  static OzToken DO = new OzToken (JP.go.ipa.oz.compiler.sym.DO);
  static OzToken FOR = new OzToken (JP.go.ipa.oz.compiler.sym.FOR);
  static OzToken IF = new OzToken (JP.go.ipa.oz.compiler.sym.IF);
  static OzToken SWITCH = new OzToken (JP.go.ipa.oz.compiler.sym.SWITCH);
  static OzToken TRY = new OzToken (JP.go.ipa.oz.compiler.sym.TRY);
  static OzToken WHILE = new OzToken (JP.go.ipa.oz.compiler.sym.WHILE);
  static OzToken JAVA = new OzToken (JP.go.ipa.oz.compiler.sym.JAVA);

  /**
    * line number 
    */
  int line_no;

  /**
    * integer value
    */
  int int_val;

  /**
    * position in file
    */
  int offset;

  /**
    * create new one
    *
    * @param sym kind of symbol
    */
  OzToken (int sym) { 
    super (sym); 
  }

  /**
    * create new one
    *
    * @param sym kind of symbol
    * @param ln line number
    * @param pos position in file
    */
  OzToken (int sym, int ln, int pos) { 
    super (sym); 
    offset = pos;
    setLineNumber (ln);
  }

  /**
    * set line number
    *
    * @param ln line number
    */
  final void setLineNumber (int ln) {
    line_no = ln;
    OzcError.setLineNumber (ln);
  }

  /**
    * get offset
    *
    * @return offset value
    */
  final int getOffset () {
    return offset;
  }
}

/* EOF */

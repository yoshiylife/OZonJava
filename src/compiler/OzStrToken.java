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
 * $Id: OzStrToken.java,v 0.4 1997-06-17 17:56:30+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1997.1.31
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representation string token with line number.
  * 
  * @see OzToken
  */

class OzStrToken extends OzToken {
  /**
    * string value 
    */
  String str_val;

  /**
    * string buffer
    */
  StringBuffer str_buf;
  
  /**
    * create new one 
    *
    * @param sym kind of symbol
    * @param val string value 
    * @param ln line number
    */
  OzStrToken (int sym, String val, int ln, int pos) { 
    super (sym, ln, pos);
    str_val = val;
  }

  /**
    * create new one 
    *
    * @param sym kind of symbol
    * @param val string value 
    */
  OzStrToken (int sym, String val) { 
    super (sym); 
    str_val = val;
  }

  /**
    * create new one 
    *
    * @param sym kind of symbol
    */
  OzStrToken (int sym) { 
    super (sym); 
    str_val = "";
  }

  /**
    * append string to buffer
    *
    * @param str string value
    */
  void append (String str) {
    if (str == null || str == "") return;

    if (str_buf == null) 
      str_buf = new StringBuffer ();

    str_buf.append (str);
    str_val = str_buf.toString ();
  }

  /**
    * append new line
    */
  void appendLineBreak () {
    append ("\n");
    append (Emitter.getIndent ());
  }

  /**
    * check if string representing block
    */
  void checkBlock (String str) {
    if (str.startsWith ("{"))
      append (str);
    else {
      append ("\n");
      append ("  ");
      append (str.substring (1));
    }
  }
}

/* EOF */

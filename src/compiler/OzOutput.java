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
 * $Id: OzOutput.java,v 0.5 1997-07-09 09:47:17+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1997.5.28
 */

package JP.go.ipa.oz.compiler;

import JP.go.ipa.oz.lib.standard.*;

/**
  * A class representign logger of compiler
  *
  * @see Output
  */

class OzOutput extends Output {
  /**
    * output (for OZ, wrapper class of java.io.Writer)
    */
  _Writer_if output;

  /**
    * create new one
    *
    * @param out output 
    */
  OzOutput (_Writer_if out) { 
    super (null);
    output = out; 
  }

  /*
   * output
   *
   * @param s string value
   */
  void print (String s) { 
    try {
      output.write (new _String_cl (s)); 
      output.flush ();
    } catch (Exception e) {
      ozc.catchException (e);
    }
  }

  /*
   * output
   *
   * @param o output object
   */
  void print (Object o) {
    print (o.toString ()); 
  }

  /*
   * output with new line
   *
   * @param s string value
   */
  void println (String s) {
    print (s + '\n'); 
  }

  /*
   * output with new line
   */
  void println () {
    print ("\n"); 
  }

  /*
   * close output
   */
  public void close () {
    try {
      super.close ();
      output.close ();
    } catch (Exception e) {
      ozc.catchException (e);
    }
  }
}

/* EOF */

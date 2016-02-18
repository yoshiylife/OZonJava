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
 * $Id: Output.java,v 0.4 1997-07-09 09:47:03+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1997.5.28
 */

package JP.go.ipa.oz.compiler;

import java.io.*;

/**
  * A class representing logger of compiler
  *
  * @see ozc
  */

class Output extends OutputStream {
  /**
    * output destination
    */
  Writer output;

  /**
    * create new one
    *
    * @param out output 
    */
  Output (Writer out) { 
    super ();
    output = out; 
  }

  /**
    * output
    *
    * @param s output string
    */
  void print (String s) { 
    try {
      output.write (s); 
      output.flush ();
    } catch (IOException e) {
      ozc.catchException (e);
    }
  }

  /**
    * output
    *
    * @param o output object
    */
  void print (Object o) {
    print (o.toString ()); 
  }

  /**
    * output with new line
    *
    * @param s output string
    */
  void println (String s) {
    print (s + '\n'); 
  }

  /**
    * output with new line
    */
  void println () {
    print ("\n"); 
  }

  /**
    * close output
    */
  public void close () {
    try {
      super.close ();
      output.close ();
    } catch (IOException e) {
      ozc.catchException (e);
    }
  }

  /** 
    * override 
    */
  public void write (int b) {
    try {
      output.write (b); 
      output.flush ();
    } catch (IOException e) {
      ozc.catchException (e);
    }
  }
}

/* EOF */

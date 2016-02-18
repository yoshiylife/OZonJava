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

class Ozc {
  /* oz compiler (Java) */
  OzOzc ozc;

  new create () {
    ozc=>create ();
    ozc->setDomain ("JP.go.ipa.oz");
  }

  /* invoke compilation */
  public boolean compile (String source, School sc) {
    return ozc->compile (source, sc);
  }
  
  public boolean compile (String source, School sc, String dir) {
    return ozc->compile (source, sc, dir);
  }
  
  public boolean compile (String source, School sc, Writer output) {
    return ozc->compile (source, sc, output);
  }
  
  public boolean compile (String source, School sc, Writer output, String dir) {
    return ozc->compile (source, sc, output, dir);
  }
  
  public boolean compileInterface (String source, School sc) {
    return ozc->compileInterface (source, sc);
  }
  
  public boolean compileInterface (String source, School sc, String dir) {
    return ozc->compileInterface (source, sc, dir);
  }
  
  public boolean compileInterface (String source, School sc, Writer output) {
    return ozc->compileInterface (source, sc, output);
  }

  public boolean compileInterface (String source, School sc, Writer output, String dir) {
    return ozc->compileInterface (source, sc, output, dir);
  }

  /* display usage */
  public String displayUsage () {
    return ozc->displayUsage ();
  }
}

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

package JP.go.ipa.oz.user.cda;

public class _Test_pcl extends JP.go.ipa.oz.lang._Proxy_cl implements JP.go.ipa.oz.user.cda._Test_if {
  int selector;
  
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    
    JP.go.ipa.oz.user.cda._Test_if g = (JP.go.ipa.oz.user.cda._Test_if) o;
    Object result;
    
    switch (selector) {
    default:
      throw new Exception ("_Test_pcl: invalid selector = " + selector);
    }
  }
  
  
  public _Test_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public _Test_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public _Test_pcl () throws Exception { super (); }
  
  
}


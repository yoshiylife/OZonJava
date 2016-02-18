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

public class _Test_cl extends JP.go.ipa.oz.system.OzCell implements JP.go.ipa.oz.user.cda._Test_if {
  static final boolean _global_ = true;
  
  protected void initiallize () throws Exception  {
  }
  
  protected void go () throws Exception  {
// 21
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 22
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.println ((new JP.go.ipa.oz.lib.standard._String_cl("CDATestClass creation")));
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.println ((new JP.go.ipa.oz.lib.standard._String_cl("CDATestClass creation")));
    }
// 23
    JP.go.ipa.oz.user.released.test_cda.testclass._CDATestClass_if tc = (JP.go.ipa.oz.user.released.test_cda.testclass._CDATestClass_cl) (new JP.go.ipa.oz.user.released.test_cda.testclass._CDATestClass_cl ())._new_create ();
// 24
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.println ((new JP.go.ipa.oz.lib.standard._String_cl("CDATestClass created")));
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.println ((new JP.go.ipa.oz.lib.standard._String_cl("CDATestClass created")));
    }
  }
  
  protected void quiet () throws Exception  {
// 18
    flushCell ();
  }
  
  public _Test_cl () { super ("JP.go.ipa.oz.user.cda._Test_pcl"); }
  
  public _Test_cl (String proxy_id) { super (proxy_id); }
  
}


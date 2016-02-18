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

public class _AtoI_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.cda._AtoI_if {
  
  public int atoi (JP.go.ipa.oz.lib.standard._String_if s) throws Exception {
    checkSecureInvocation ();
    return _static_atoi (s);
  }
  
  public static int _static_atoi (JP.go.ipa.oz.lib.standard._String_if s) throws Exception {
    java.lang.String javas = s.toString();
    Integer I = new Integer(javas);
    return I.intValue();
  }
  
  
  public _AtoI_cl () throws Exception { super (); }
  
}


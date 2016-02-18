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

public class _CDAProperty_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.cda._CDAProperty_if {

  public JP.go.ipa.oz.lib.standard._String_if getProp (JP.go.ipa.oz.lib.standard._String_if s) throws Exception {
    checkSecureInvocation ();
    return _static_getProp (s);
  }

  public static JP.go.ipa.oz.lib.standard._String_if _static_getProp (JP.go.ipa.oz.lib.standard._String_if s) throws Exception {
    String propName = new String("oz.cda.");
    propName = propName.concat(s.toString());
    String propVal = System.getProperty(propName);
    if(propVal == null) return null;
    return (JP.go.ipa.oz.lib.standard._String_if)(new JP.go.ipa.oz.lib.standard._String_cl(propVal));
  }

  public JP.go.ipa.oz.lib.standard._String_if getHost () throws Exception {
    checkSecureInvocation ();
    return _static_getHost ();
  }
  
  public static JP.go.ipa.oz.lib.standard._String_if _static_getHost () throws Exception {
    String url = System.getProperty("oz.classloader.deliveryAgent.url");
    if(url == null) return null;
    int colonInd = url.lastIndexOf("ozclass:");
    if(colonInd < 0) return null;
    colonInd = url.lastIndexOf(":");
    if(colonInd <= 10) return null;
    String host = url.substring(10,colonInd);
    return (JP.go.ipa.oz.lib.standard._String_if)(new JP.go.ipa.oz.lib.standard._String_cl(host));
  }

  public int getPort () throws Exception {
    checkSecureInvocation ();
    return _static_getPort ();
  }
  
  public static int _static_getPort () throws Exception {
    String url = System.getProperty("oz.classloader.deliveryAgent.url");
    if(url == null) return -1;
    int colonInd = url.lastIndexOf("ozclass:");
    if(colonInd < 0) return -1;
    colonInd = url.lastIndexOf(":");
    int suraInd = url.lastIndexOf("/");
    if(colonInd >= suraInd) return -1;
    String portS = url.substring(colonInd+1,suraInd);
    Integer port;
    try{
      port = new Integer(portS);
    }catch(NumberFormatException e){
      return -1;
    }
    return port.intValue();
  }
  
  public _CDAProperty_cl () throws Exception { super (); }
  
}


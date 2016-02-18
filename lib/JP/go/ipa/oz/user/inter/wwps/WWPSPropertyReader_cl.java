package JP.go.ipa.oz.user.inter.wwps;

public class WWPSPropertyReader_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.inter.wwps.WWPSPropertyReader_if {
  JP.go.ipa.oz.lib.standard._String_if ozcgi_god;
  
  public Object _new_create () throws Exception  {
    return this;
  }
  
  public void eval (JP.go.ipa.oz.lib.standard._String_if label, JP.go.ipa.oz.lib.standard._String_if value) throws Exception  {
    checkSecureInvocation ();
// 112
    JP.go.ipa.oz.lib.standard._String_if string$84 = (new JP.go.ipa.oz.lib.standard._String_cl("ozcgi.god"));
    
// 112
    boolean isequal$val$138;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) label)) {
      try {
        isequal$val$138 = label.isequal (string$84);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$138 = label.isequal (string$84);
    }
// 112
    if (isequal$val$138) {{
// 113
        ozcgi_god = value;
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getOzCGI () throws Exception  {
    checkSecureInvocation ();
// 106
    return ozcgi_god;
  }
  
  public void read () throws Exception  {
    checkSecureInvocation ();
// 97
    JP.go.ipa.oz.user.inter.cgi.FileProperty_if fp = (JP.go.ipa.oz.user.inter.cgi.FileProperty_cl) (new JP.go.ipa.oz.user.inter.cgi.FileProperty_cl ())._new_create ();
// 98
    JP.go.ipa.oz.lib.standard._String_if string$85 = (new JP.go.ipa.oz.lib.standard._String_cl("wwps.properties"));
    
// 98
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fp)) {
      try {
        fp.read (string$85, this);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      fp.read (string$85, this);
    }
  }
  
  public WWPSPropertyReader_cl () throws Exception { super (); }
  
}


package JP.go.ipa.oz.user.inter.cgi;

public class OzCGIPropertyReader_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.inter.cgi.OzCGIPropertyReader_if {
  int port;
  
  public Object _new_create () throws Exception  {
    return this;
  }
  
  public int getPort () throws Exception  {
    checkSecureInvocation ();
// 781
    return port;
  }
  
  public void eval (JP.go.ipa.oz.lib.standard._String_if label, JP.go.ipa.oz.lib.standard._String_if value) throws Exception  {
    checkSecureInvocation ();
// 787
    JP.go.ipa.oz.lib.standard._String_if string$59 = (new JP.go.ipa.oz.lib.standard._String_cl("port"));
    
// 787
    boolean isequal$val$175;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) label)) {
      try {
        isequal$val$175 = label.isequal (string$59);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$175 = label.isequal (string$59);
    }
// 787
    if (isequal$val$175) {{
// 788
        try {
// 789
          int parseInt$val$176;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) value)) {
            try {
              parseInt$val$176 = value.parseInt ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            parseInt$val$176 = value.parseInt ();
          }
// 789
          port = parseInt$val$176;
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_6) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_6 = _exception_6.getOzException ();
          if (_oz_exception_6 instanceof JP.go.ipa.oz.lib.standard._NumberFormatException_if) {
            JP.go.ipa.oz.lib.standard._NumberFormatException_if e = (JP.go.ipa.oz.lib.standard._NumberFormatException_if) _oz_exception_6;
// 791
            port = 0;
          } else throw _exception_6;
        }
      }
    }
  }
  
  public void read () throws Exception  {
    checkSecureInvocation ();
// 772
    JP.go.ipa.oz.user.inter.cgi.FileProperty_if fp = (JP.go.ipa.oz.user.inter.cgi.FileProperty_cl) (new JP.go.ipa.oz.user.inter.cgi.FileProperty_cl ())._new_create ();
// 773
    JP.go.ipa.oz.lib.standard._String_if string$60 = (new JP.go.ipa.oz.lib.standard._String_cl("ozcgi.properties"));
    
// 773
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fp)) {
      try {
        fp.read (string$60, this);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      fp.read (string$60, this);
    }
  }
  
  public OzCGIPropertyReader_cl () throws Exception { super (); }
  
}


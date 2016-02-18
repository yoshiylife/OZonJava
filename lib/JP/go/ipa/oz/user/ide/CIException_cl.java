package JP.go.ipa.oz.user.ide;

final public class CIException_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.CIException_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.lib.standard._String_if message;
  JP.go.ipa.oz.lib.standard._String_if cid;
  
  public Object _new_newCIException (JP.go.ipa.oz.lib.standard._String_if msg, JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
// 29
    ((JP.go.ipa.oz.user.ide.CIException_cl)this).message = msg;
// 30
    ((JP.go.ipa.oz.user.ide.CIException_cl)this).cid = cid;
    return this;
  }
  
  public Object _new_newCIException (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception  {
// 22
    ((JP.go.ipa.oz.user.ide.CIException_cl)this).message = msg;
// 23
    ((JP.go.ipa.oz.user.ide.CIException_cl)this).cid = (new JP.go.ipa.oz.lib.standard._String_cl("unknown"));
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if asString () throws Exception  {
    checkSecureInvocation ();
// 38
    JP.go.ipa.oz.lib.standard._StringBuffer_if str = null;
// 40
    str = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (message);
// 41
    if (cid != null) {{
// 42
        JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl(" (CID="));
        
// 42
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$0;
        append$val$0 = str.append (string$0);
// 42
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$1;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$0)) {
          try {
            append$val$1 = append$val$0.append (cid);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$1 = append$val$0.append (cid);
        }
// 42
        JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl(")"));
        
// 42
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$2;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$1)) {
          try {
            append$val$2 = append$val$1.append (string$1);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$2 = append$val$1.append (string$1);
        }
      }
    }
// 45
    return str.asString ();
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getCID () throws Exception  {
    checkSecureInvocation ();
// 55
    return cid;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getMessage () throws Exception  {
    checkSecureInvocation ();
// 50
    return message;
  }
  
  public void setCID (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
    checkSecureInvocation ();
// 60
    ((JP.go.ipa.oz.user.ide.CIException_cl)this).cid = cid;
  }
  
  public CIException_cl () throws Exception { super (); }
  
}


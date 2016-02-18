package JP.go.ipa.oz.user.ide;

final public class CIClassType_cl extends JP.go.ipa.oz.user.ide.CIType_cl implements JP.go.ipa.oz.user.ide.CIClassType_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.lib.standard._String_if cid;
  
  public Object _new_newCIClassType (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
// 23
    initParams (cid);
    return this;
  }
  
  public boolean isPrimitive () throws Exception  {
    checkSecureInvocation ();
// 39
    return false;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if asString () throws Exception  {
    checkSecureInvocation ();
// 32
    return cid;
  }
  
  void initParams (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
// 74
    typeCode = 'L';
// 75
    ((JP.go.ipa.oz.user.ide.CIClassType_cl)this).cid = cid;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getCID () throws Exception  {
    checkSecureInvocation ();
// 65
    return cid;
  }
  
  public boolean isOzInternalClass () throws Exception  {
    checkSecureInvocation ();
    boolean bool$val$10;
    
// 53
    JP.go.ipa.oz.lib.standard._String_if string$10 = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.system."));
    
// 53
    boolean startsWith$val$115;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
      try {
        startsWith$val$115 = cid.startsWith (string$10);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$115 = cid.startsWith (string$10);
    }
    bool$val$10 = startsWith$val$115;
    if (!bool$val$10) {
// 54
      JP.go.ipa.oz.lib.standard._String_if string$11 = (new JP.go.ipa.oz.lib.standard._String_cl("java."));
      
// 54
      boolean startsWith$val$116;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
        try {
          startsWith$val$116 = cid.startsWith (string$11);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        startsWith$val$116 = cid.startsWith (string$11);
      }
      bool$val$10 = startsWith$val$116;
    }
// 53
    if (bool$val$10) {{
// 55
        return true;
      }
    } else {{
// 57
        return false;
      }
    }
  }
  
  public boolean isClass () throws Exception  {
    checkSecureInvocation ();
// 46
    return true;
  }
  
  public CIClassType_cl () throws Exception { super (); }
  
}


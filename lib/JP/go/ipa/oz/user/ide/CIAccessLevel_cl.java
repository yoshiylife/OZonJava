package JP.go.ipa.oz.user.ide;

final public class CIAccessLevel_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.CIAccessLevel_if {
  static final boolean _final_ = true;
  boolean iAmProtected;
  boolean iAmPublic;
  int UPPER;
  
  public Object _new_newCIAccessLevel (int mods) throws Exception  {
// 24
    initParams (mods);
    return this;
  }
  
  public boolean isPublic () throws Exception  {
    checkSecureInvocation ();
// 46
    return iAmPublic;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if asString () throws Exception  {
    checkSecureInvocation ();
// 33
    if (iAmPublic) {{
// 34
        return (new JP.go.ipa.oz.lib.standard._String_cl("public"));
      }
    } else {
// 35
      if (iAmProtected) {{
// 36
          return (new JP.go.ipa.oz.lib.standard._String_cl("protected"));
        }
      } else {{
// 38
          return (new JP.go.ipa.oz.lib.standard._String_cl(""));
        }
      }
    }
  }
  
  void initParams (int mods) throws Exception  {
// 62
    int quot = 0, remain = 0;
// 64
    UPPER = 0x4000;
// 65
    quot = mods % UPPER;
// 67
    remain = quot % 2;
// 68
    if (remain == 1) {{
// 68
        iAmPublic = true;
      }
    }
// 69
    quot = quot / 2;
// 70
    quot = quot / 2;
// 71
    remain = quot % 2;
// 72
    if (remain == 1) {{
// 72
        iAmProtected = true;
      }
    }
  }
  
  public boolean isProtected () throws Exception  {
    checkSecureInvocation ();
// 53
    return iAmProtected;
  }
  
  public CIAccessLevel_cl () throws Exception { super (); }
  
}


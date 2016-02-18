package JP.go.ipa.oz.user.secu;

public class Authenticator_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.secu.Authenticator_if {
  JP.go.ipa.oz.lib.standard._String_if myOzHome;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if myHome) throws Exception  {
// 5
    myOzHome = myHome;
    return this;
  }
  
  public void authenticate () throws Exception  {
    checkSecureInvocation ();
// 14
    JP.go.ipa.oz.lib.standard._String_if _static_getCallerOzHome$val$0;
    _static_getCallerOzHome$val$0 = JP.go.ipa.oz.lib.standard._OzCipher_cl._static_getCallerOzHome ();
// 14
    boolean isequal$val$1;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) myOzHome)) {
      try {
        isequal$val$1 = myOzHome.isequal (_static_getCallerOzHome$val$0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$1 = myOzHome.isequal (_static_getCallerOzHome$val$0);
    }
// 14
    if (!isequal$val$1) {{
// 15
        JP.go.ipa.oz.user.secu.UnknownUserException_if e = (JP.go.ipa.oz.user.secu.UnknownUserException_cl) (new JP.go.ipa.oz.user.secu.UnknownUserException_cl ())._new_init ();
// 15
        throw new JP.go.ipa.oz.lang.OzException (e);
      }
    }
  }
  
  public void authorize (JP.go.ipa.oz.lang._Root_if obj) throws Exception  {
    checkSecureInvocation ();
    boolean bool$val$0;
    
    bool$val$0 = obj != null;
    if (bool$val$0) {
// 8
      boolean isRed$val$2;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
        try {
          isRed$val$2 = obj.isRed ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isRed$val$2 = obj.isRed ();
      }
      bool$val$0 = isRed$val$2;
    }
// 8
    if (bool$val$0) {{
// 9
        turnGreen (obj);
// 10
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
          try {
            obj.toGreen ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          obj.toGreen ();
        }
      }
    }
  }
  
  public Authenticator_cl () throws Exception { super (); }
  
}


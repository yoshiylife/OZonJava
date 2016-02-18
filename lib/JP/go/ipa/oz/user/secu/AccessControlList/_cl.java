package JP.go.ipa.oz.user.secu.AccessControlList;

public class _cl extends JP.go.ipa.oz.lib.standard._Set_cl implements JP.go.ipa.oz.user.secu.AccessControlList_if {
  JP.go.ipa.oz.lib.standard._String_if asGOL;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
// 22
    asGOL = gol;
// 23
    JP.go.ipa.oz.user.secu.AuthComparator_if ac = (JP.go.ipa.oz.user.secu.AuthComparator_cl) (new JP.go.ipa.oz.user.secu.AuthComparator_cl ())._new_create ();
// 24
    super._new_create (ac);
    return this;
  }
  
  public Object _new_create () throws Exception  {
// 18
    JP.go.ipa.oz.user.secu.AuthComparator_if ac = (JP.go.ipa.oz.user.secu.AuthComparator_cl) (new JP.go.ipa.oz.user.secu.AuthComparator_cl ())._new_create ();
// 19
    super._new_create (ac);
    return this;
  }
  
  public Object _new_ownerOnly () throws Exception  {
// 29
    super._new_create ();
// 30
    JP.go.ipa.oz.lib.standard._System_if s = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 31
    JP.go.ipa.oz.lib.standard._String_if getOzHome$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
      try {
        getOzHome$val$0 = s.getOzHome ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzHome$val$0 = s.getOzHome ();
    }
// 31
    this.add (getOzHome$val$0);
    return this;
  }
  
  public void remove (JP.go.ipa.oz.user.secu.User_if u) throws Exception  {
    checkSecureInvocation ();
// 34
    super.remove (u);
  }
  
  public void authenticateSameGroup () throws Exception  {
    checkSecureInvocation ();
// 55
    authenticate ();
// 55
    JP.go.ipa.oz.lib.standard._System_if s = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 56
    JP.go.ipa.oz.user.secu.OzAuthenticationServer_if as = new JP.go.ipa.oz.user.secu.OzAuthenticationServer_pcl (asGOL);
// 57
    JP.go.ipa.oz.lib.standard._String_if getOzHome$val$1;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
      try {
        getOzHome$val$1 = s.getOzHome ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzHome$val$1 = s.getOzHome ();
    }
// 57
    JP.go.ipa.oz.lib.standard._String_if _static_getCallerOzHome$val$2;
    _static_getCallerOzHome$val$2 = JP.go.ipa.oz.lib.standard._OzCipher_cl._static_getCallerOzHome ();
// 57
    boolean isSameGroup$val$3;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
      try {
        isSameGroup$val$3 = as.isSameGroup (getOzHome$val$1, _static_getCallerOzHome$val$2);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isSameGroup$val$3 = as.isSameGroup (getOzHome$val$1, _static_getCallerOzHome$val$2);
    }
// 57
    if (isSameGroup$val$3) {{
// 58
        JP.go.ipa.oz.user.secu.UnknownUserException_if e = (JP.go.ipa.oz.user.secu.UnknownUserException_cl) (new JP.go.ipa.oz.user.secu.UnknownUserException_cl ())._new_init ();
// 58
        throw new JP.go.ipa.oz.lang.OzException (e);
      }
    }
  }
  
  public void add (JP.go.ipa.oz.user.secu.User_if u) throws Exception  {
    checkSecureInvocation ();
// 33
    super.add (u);
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if asSet () throws Exception  {
    checkSecureInvocation ();
// 35
    return this;
  }
  
  public void authenticate (JP.go.ipa.oz.lib.standard._String_if groupName) throws Exception  {
    checkSecureInvocation ();
// 47
    authenticate ();
// 48
    JP.go.ipa.oz.user.secu.OzAuthenticationServer_if as = new JP.go.ipa.oz.user.secu.OzAuthenticationServer_pcl (asGOL);
// 49
    JP.go.ipa.oz.lib.standard._String_if _static_getCallerOzHome$val$4;
    _static_getCallerOzHome$val$4 = JP.go.ipa.oz.lib.standard._OzCipher_cl._static_getCallerOzHome ();
// 49
    boolean isInGroupMembers$val$5;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
      try {
        isInGroupMembers$val$5 = as.isInGroupMembers (groupName, _static_getCallerOzHome$val$4);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isInGroupMembers$val$5 = as.isInGroupMembers (groupName, _static_getCallerOzHome$val$4);
    }
// 49
    if (!isInGroupMembers$val$5) {{
// 50
        JP.go.ipa.oz.user.secu.UnknownUserException_if e = (JP.go.ipa.oz.user.secu.UnknownUserException_cl) (new JP.go.ipa.oz.user.secu.UnknownUserException_cl ())._new_init ();
// 50
        throw new JP.go.ipa.oz.lang.OzException (e);
      }
    }
  }
  
  public void authenticate () throws Exception  {
    checkSecureInvocation ();
// 42
    if (!contains (JP.go.ipa.oz.lib.standard._OzCipher_cl._static_getCallerOzHome ())) {{
// 43
        JP.go.ipa.oz.user.secu.UnknownUserException_if e = (JP.go.ipa.oz.user.secu.UnknownUserException_cl) (new JP.go.ipa.oz.user.secu.UnknownUserException_cl ())._new_init ();
// 43
        throw new JP.go.ipa.oz.lang.OzException (e);
      }
    }
  }
  
  public _cl () throws Exception { super (); }
  
}


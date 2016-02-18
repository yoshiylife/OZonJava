package JP.go.ipa.oz.user.apl.fed;

public class FedRoot_cl extends JP.go.ipa.oz.system.OzCell implements JP.go.ipa.oz.user.apl.fed.FedRoot_if {
  static final boolean _global_ = true;
  protected JP.go.ipa.oz.lib.standard._String_if className;
  protected boolean debug;
  protected JP.go.ipa.oz.lib.standard._System_if system;
  protected JP.go.ipa.oz.user.apl.fed.Authenticator_if auth;
  
  public final JP.go.ipa.oz.lib.standard._String_if god () throws Exception  {
    checkSecureInvocation ();
// 54
    if (debug) {
// 54
      JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl("FedRoot#god() enter & leave"));
      
// 54
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$0);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$0);
      }
    }
// 55
    JP.go.ipa.oz.lib.standard._String_if getGOD$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) className)) {
      try {
        getGOD$val$0 = className.getGOD ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getGOD$val$0 = className.getGOD ();
    }
// 55
    return getGOD$val$0;
  }
  
  public void debug (boolean flag) throws Exception  {
    checkSecureInvocation ();
// 69
    debug = flag;
  }
  
  public void init () throws Exception  {
    checkSecureInvocation ();
// 23
    className = (new JP.go.ipa.oz.lib.standard._String_cl("FedRoot"));
// 24
    auth = (JP.go.ipa.oz.user.apl.fed.Authenticator_cl) (new JP.go.ipa.oz.user.apl.fed.Authenticator_cl ())._new_create ();
// 25
    debugInit ();
  }
  
  public final void setClassName (JP.go.ipa.oz.lib.standard._String_if s) throws Exception  {
    checkSecureInvocation ();
// 34
    boolean isRed$val$1;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
      try {
        isRed$val$1 = s.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$1 = s.isRed ();
    }
// 34
    if (isRed$val$1) {
// 34
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (s);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (s);
      }
    }
// 35
    if (debug) {
// 35
      JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl("FedRoot#setClassName() enter with "));
      
// 35
      JP.go.ipa.oz.lib.standard._String_if concat$val$2;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$1)) {
        try {
          concat$val$2 = string$1.concat (s);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        concat$val$2 = string$1.concat (s);
      }
// 35
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (concat$val$2);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (concat$val$2);
      }
    }
// 36
    className = s;
// 37
    if (debug) {
// 37
      JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl("FedRoot#setClassName() leave"));
      
// 37
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$2);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$2);
      }
    }
  }
  
  public final JP.go.ipa.oz.lib.standard._String_if gol () throws Exception  {
    checkSecureInvocation ();
// 48
    if (debug) {
// 48
      JP.go.ipa.oz.lib.standard._String_if string$3 = (new JP.go.ipa.oz.lib.standard._String_cl("FedRoot#gol() enter & leave"));
      
// 48
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$3);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$3);
      }
    }
// 49
    JP.go.ipa.oz.lib.standard._String_if getGOL$val$3;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) className)) {
      try {
        getGOL$val$3 = className.getGOL ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getGOL$val$3 = className.getGOL ();
    }
// 49
    return getGOL$val$3;
  }
  
  public void debugInit () throws Exception  {
    checkSecureInvocation ();
// 63
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 64
    debug = false;
  }
  
  public final JP.go.ipa.oz.lib.standard._String_if getClassName () throws Exception  {
    checkSecureInvocation ();
// 42
    if (debug) {
// 42
      JP.go.ipa.oz.lib.standard._String_if string$4 = (new JP.go.ipa.oz.lib.standard._String_cl("FedRoot#getClassName() enter & leave"));
      
// 42
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$4);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$4);
      }
    }
// 43
    return className;
  }
  
  public void quiet () throws Exception  {
    checkSecureInvocation ();
// 29
    flushCell ();
  }
  
  public void initialize () throws Exception  {
    checkSecureInvocation ();
// 18
    init ();
  }
  
  public FedRoot_cl () { super ("JP.go.ipa.oz.user.apl.fed.FedRoot_pcl"); }
  
  public FedRoot_cl (String proxy_id) { super (proxy_id); }
  
}


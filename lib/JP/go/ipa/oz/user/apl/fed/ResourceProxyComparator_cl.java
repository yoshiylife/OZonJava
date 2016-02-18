package JP.go.ipa.oz.user.apl.fed;

public class ResourceProxyComparator_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.apl.fed.ResourceProxyComparator_if {
  JP.go.ipa.oz.lib.standard._System_if system;
  
  public Object _new_create () throws Exception  {
// 8
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._Comparator_if duplicate () throws Exception  {
    checkSecureInvocation ();
// 48
    JP.go.ipa.oz.user.apl.fed.ResourceProxyComparator_if comp = (JP.go.ipa.oz.user.apl.fed.ResourceProxyComparator_cl) (new JP.go.ipa.oz.user.apl.fed.ResourceProxyComparator_cl ())._new_create ();
// 49
    return comp;
  }
  
  public boolean compare (JP.go.ipa.oz.lang._Root_if obja, JP.go.ipa.oz.lang._Root_if objb) throws Exception  {
    checkSecureInvocation ();
    boolean bool$val$0;
    
    bool$val$0 = (obja == null);
    if (!bool$val$0) {
      bool$val$0 = (objb == null);
    }
// 13
    if (bool$val$0) {{
// 15
        return false;
      }
    }
// 18
    JP.go.ipa.oz.user.apl.fed.ResourceProxy_if proxya = null;
// 18
    proxya = (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if) (obja);
// 19
    JP.go.ipa.oz.user.apl.fed.ResourceProxy_if proxyb = null;
// 19
    proxyb = (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if) (objb);
    boolean bool$val$1;
    
    boolean bool$val$2;
    
// 26
    JP.go.ipa.oz.lib.standard._String_if getAutonomyType$val$8;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxya)) {
      try {
        getAutonomyType$val$8 = proxya.getAutonomyType ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getAutonomyType$val$8 = proxya.getAutonomyType ();
    }
// 26
    JP.go.ipa.oz.lib.standard._String_if getAutonomyType$val$9;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxyb)) {
      try {
        getAutonomyType$val$9 = proxyb.getAutonomyType ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getAutonomyType$val$9 = proxyb.getAutonomyType ();
    }
// 26
    boolean isequal$val$10;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) (getAutonomyType$val$8))) {
      try {
        isequal$val$10 = (getAutonomyType$val$8).isequal (getAutonomyType$val$9);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$10 = (getAutonomyType$val$8).isequal (getAutonomyType$val$9);
    }
    bool$val$2 = (isequal$val$10);
    if (bool$val$2) {
// 27
      JP.go.ipa.oz.lib.standard._String_if getResourceType$val$11;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxya)) {
        try {
          getResourceType$val$11 = proxya.getResourceType ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getResourceType$val$11 = proxya.getResourceType ();
      }
// 27
      JP.go.ipa.oz.lib.standard._String_if getResourceType$val$12;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxyb)) {
        try {
          getResourceType$val$12 = proxyb.getResourceType ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getResourceType$val$12 = proxyb.getResourceType ();
      }
// 27
      boolean isequal$val$13;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) (getResourceType$val$11))) {
        try {
          isequal$val$13 = (getResourceType$val$11).isequal (getResourceType$val$12);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$13 = (getResourceType$val$11).isequal (getResourceType$val$12);
      }
      bool$val$2 = (isequal$val$13);
    }
    bool$val$1 = bool$val$2;
    if (bool$val$1) {
// 28
      JP.go.ipa.oz.lib.standard._String_if getResource$val$14;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxya)) {
        try {
          getResource$val$14 = proxya.getResource ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getResource$val$14 = proxya.getResource ();
      }
// 28
      JP.go.ipa.oz.lib.standard._String_if getResource$val$15;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxyb)) {
        try {
          getResource$val$15 = proxyb.getResource ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getResource$val$15 = proxyb.getResource ();
      }
// 28
      boolean isequal$val$16;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) (getResource$val$14))) {
        try {
          isequal$val$16 = (getResource$val$14).isequal (getResource$val$15);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$16 = (getResource$val$14).isequal (getResource$val$15);
      }
      bool$val$1 = (isequal$val$16);
    }
// 26
    if (bool$val$1) {
// 30
      return true;
    }
// 30
    return false;
  }
  
  public int hash (JP.go.ipa.oz.lang._Root_if obj) throws Exception  {
    checkSecureInvocation ();
// 35
    JP.go.ipa.oz.lib.standard._StringComparator_if stc = null;
// 36
    JP.go.ipa.oz.user.apl.fed.ResourceProxy_if rp = null;
// 37
    JP.go.ipa.oz.lib.standard._String_if str = null;
// 39
    rp = (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if) (obj);
// 40
    stc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 42
    JP.go.ipa.oz.lib.standard._String_if asString$val$17;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rp)) {
      try {
        asString$val$17 = rp.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$17 = rp.asString ();
    }
// 42
    str = asString$val$17;
// 43
    return stc.hash (str);
  }
  
  public ResourceProxyComparator_cl () throws Exception { super (); }
  
}


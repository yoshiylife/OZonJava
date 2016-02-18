package JP.go.ipa.oz.user.secu;

public class isInUser_cl extends JP.go.ipa.oz.system.OzCell implements JP.go.ipa.oz.user.secu.isInUser_if {
  static final boolean _global_ = true;
  
  protected void initialize () throws Exception  {
  }
  
  protected final void quiet () throws Exception  {
// 10
    flushCell ();
  }
  
  protected void go () throws Exception  {
// 4
    JP.go.ipa.oz.lib.standard._System_if s = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 5
    JP.go.ipa.oz.user.secu.OzAuthenticationServer_if as = new JP.go.ipa.oz.user.secu.OzAuthenticationServer_pcl ((new JP.go.ipa.oz.lib.standard._String_cl("as")));
// 6
    JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl("bound"));
    
// 6
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
      try {
        s.println (string$0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      s.println (string$0);
    }
// 7
    JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl("testUser"));
    
// 7
    JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl("mypasswd"));
    
// 7
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
      try {
        as.addUser (string$1, string$2);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      as.addUser (string$1, string$2);
    }
// 8
    JP.go.ipa.oz.lib.standard._String_if string$3 = (new JP.go.ipa.oz.lib.standard._String_cl("testUser"));
    
// 8
    boolean isInUsers$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
      try {
        isInUsers$val$0 = as.isInUsers (string$3);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isInUsers$val$0 = as.isInUsers (string$3);
    }
// 8
    if (isInUsers$val$0) {
// 8
      JP.go.ipa.oz.lib.standard._String_if string$4 = (new JP.go.ipa.oz.lib.standard._String_cl("found"));
      
// 8
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
        try {
          s.println (string$4);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        s.println (string$4);
      }
    }
  }
  
  public isInUser_cl () { super ("JP.go.ipa.oz.user.secu.isInUser_pcl"); }
  
  public isInUser_cl (String proxy_id) { super (proxy_id); }
  
}


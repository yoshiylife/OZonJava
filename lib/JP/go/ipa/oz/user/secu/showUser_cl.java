package JP.go.ipa.oz.user.secu;

public class showUser_cl extends JP.go.ipa.oz.system.OzCell implements JP.go.ipa.oz.user.secu.showUser_if {
  static final boolean _global_ = true;
  
  protected void initialize () throws Exception  {
  }
  
  protected final void quiet () throws Exception  {
// 8
    flushCell ();
  }
  
  protected void go () throws Exception  {
// 4
    JP.go.ipa.oz.lib.standard._System_if s = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 5
    JP.go.ipa.oz.user.secu.OzAuthenticationServer_if as = new JP.go.ipa.oz.user.secu.OzAuthenticationServer_pcl ((new JP.go.ipa.oz.lib.standard._String_cl("as")));
// 5
    JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl("bound"));
    
// 5
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
      try {
        s.println (string$0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      s.println (string$0);
    }
// 6
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
      try {
        as.showUser ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      as.showUser ();
    }
  }
  
  public showUser_cl () { super ("JP.go.ipa.oz.user.secu.showUser_pcl"); }
  
  public showUser_cl (String proxy_id) { super (proxy_id); }
  
}


package JP.go.ipa.oz.user.secu;

public class stopAS_cl extends JP.go.ipa.oz.system.OzCell implements JP.go.ipa.oz.user.secu.stopAS_if {
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
        as.stop ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      as.stop ();
    }
  }
  
  public stopAS_cl () { super ("JP.go.ipa.oz.user.secu.stopAS_pcl"); }
  
  public stopAS_cl (String proxy_id) { super (proxy_id); }
  
}


package JP.go.ipa.oz.user.cda;

public class _stopCDA_cl extends JP.go.ipa.oz.system.OzCell implements JP.go.ipa.oz.user.cda._stopCDA_if {
  static final boolean _global_ = true;
  
  protected void initiallize () throws Exception  {
  }
  
  protected void go () throws Exception  {
// 18
    JP.go.ipa.oz.user.cda._CDAdebug_if debug = (JP.go.ipa.oz.user.cda._CDAdebug_cl) (new JP.go.ipa.oz.user.cda._CDAdebug_cl ())._new_create ();
// 19
    JP.go.ipa.oz.lib.standard._String_if string$21 = (new JP.go.ipa.oz.lib.standard._String_cl("stopCDA go begin"));
    
// 19
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.println (string$21);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.println (string$21);
    }
// 20
    JP.go.ipa.oz.user.cda._ClassDeliveryAgent_if CDA = new JP.go.ipa.oz.user.cda._ClassDeliveryAgent_pcl ((new JP.go.ipa.oz.lib.standard._String_cl("cda")));
// 21
    JP.go.ipa.oz.lib.standard._String_if string$22 = (new JP.go.ipa.oz.lib.standard._String_cl("stopCDA binded"));
    
// 21
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.println (string$22);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.println (string$22);
    }
// 22
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) CDA)) {
      try {
        CDA.stop ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      CDA.stop ();
    }
// 23
    JP.go.ipa.oz.lib.standard._String_if string$23 = (new JP.go.ipa.oz.lib.standard._String_cl("stopCDA stopped"));
    
// 23
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.println (string$23);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.println (string$23);
    }
// 24
    stopCell ();
  }
  
  protected void quiet () throws Exception  {
// 16
    flushCell ();
  }
  
  public _stopCDA_cl () { super ("JP.go.ipa.oz.user.cda._stopCDA_pcl"); }
  
  public _stopCDA_cl (String proxy_id) { super (proxy_id); }
  
}


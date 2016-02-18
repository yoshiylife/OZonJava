package JP.go.ipa.oz.user.lib_dist.replica;

public class OtherCopyManeger_cl extends JP.go.ipa.oz.user.lib_dist.tran._Transaction_cl implements JP.go.ipa.oz.user.lib_dist.replica.OtherCopyManeger_if {
  static final boolean _global_ = true;
  
  protected void initialize () throws Exception  {
// 687
    d = (JP.go.ipa.oz.user.lib_dist.tran._Debug_cl) (new JP.go.ipa.oz.user.lib_dist.tran._Debug_cl ())._new_create ();
// 687
    x = 0;
// 687
    JP.go.ipa.oz.lib.standard._String_if string$20 = (new JP.go.ipa.oz.lib.standard._String_cl(" T:"));
    
// 687
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.setP (string$20);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.setP (string$20);
    }
// 688
    JP.go.ipa.oz.lib.standard._String_if gol = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("")));
// 689
    JP.go.ipa.oz.lib.standard._String_if getGOL$val$59;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gol)) {
      try {
        getGOL$val$59 = gol.getGOL ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getGOL$val$59 = gol.getGOL ();
    }
// 689
    gol = getGOL$val$59;
// 690
    super.initialize (gol);
  }
  
  protected void quiet () throws Exception  {
// 693
    flushCell ();
// 693
    stopCell ();
  }
  
  protected void go () throws Exception  {
// 692
    ;
  }
  
  public OtherCopyManeger_cl () { super ("JP.go.ipa.oz.user.lib_dist.replica.OtherCopyManeger_pcl"); }
  
  public OtherCopyManeger_cl (String proxy_id) { super (proxy_id); }
  
}


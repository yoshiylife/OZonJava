package JP.go.ipa.oz.user.misc.cell;

public class CellStopper_cl extends JP.go.ipa.oz.system.OzCell implements JP.go.ipa.oz.user.misc.cell.CellStopper_if {
  static final boolean _global_ = true;
  JP.go.ipa.oz.user.misc.cell.CellStopperCore_if core;
  
  public void initialize () throws Exception  {
    checkSecureInvocation ();
// 22
    core = (JP.go.ipa.oz.user.misc.cell.CellStopperCore_cl) (new JP.go.ipa.oz.user.misc.cell.CellStopperCore_cl ())._new_create ();
// 23
    stopCell ();
  }
  
  public void quiet () throws Exception  {
    checkSecureInvocation ();
// 37
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) core)) {
      try {
        core.quit ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      core.quit ();
    }
// 38
    flushCell ();
  }
  
  public void go () throws Exception  {
    checkSecureInvocation ();
// 30
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) core)) {
      try {
        core.launch ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      core.launch ();
    }
  }
  
  public CellStopper_cl () { super ("JP.go.ipa.oz.user.misc.cell.CellStopper_pcl"); }
  
  public CellStopper_cl (String proxy_id) { super (proxy_id); }
  
}


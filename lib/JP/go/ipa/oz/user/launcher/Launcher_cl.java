package JP.go.ipa.oz.user.launcher;

public class Launcher_cl extends JP.go.ipa.oz.system.OzCell implements JP.go.ipa.oz.user.launcher.Launcher_if {
  static final boolean _global_ = true;
  JP.go.ipa.oz.user.launcher.LauncherCore_if core;
  
  public void initialize () throws Exception  {
    checkSecureInvocation ();
// 22
    core = (JP.go.ipa.oz.user.launcher.LauncherCore_cl) (new JP.go.ipa.oz.user.launcher.LauncherCore_cl ())._new_create ();
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
  
  public Launcher_cl () { super ("JP.go.ipa.oz.user.launcher.Launcher_pcl"); }
  
  public Launcher_cl (String proxy_id) { super (proxy_id); }
  
}


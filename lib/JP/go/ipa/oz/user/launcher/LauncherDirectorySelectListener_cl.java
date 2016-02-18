package JP.go.ipa.oz.user.launcher;

public class LauncherDirectorySelectListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.launcher.LauncherDirectorySelectListener_if {
  JP.go.ipa.oz.user.launcher.LauncherCore_if lCore;
  
  public Object _new_create (JP.go.ipa.oz.user.launcher.LauncherCore_if lchr, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq) throws Exception  {
// 23
    super._new_newActionListener (eq);
// 24
    lCore = lchr;
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if evt) throws Exception  {
    checkSecureInvocation ();
// 33
    JP.go.ipa.oz.lib.standard._String_if dirName = null;
// 35
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$141;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) evt)) {
      try {
        getActionCommand$val$141 = evt.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$141 = evt.getActionCommand ();
    }
// 35
    dirName = getActionCommand$val$141;
// 36
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lCore)) {
      try {
        lCore.changeDirectory (dirName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lCore.changeDirectory (dirName);
    }
  }
  
  public LauncherDirectorySelectListener_cl () throws Exception { super (); }
  
}


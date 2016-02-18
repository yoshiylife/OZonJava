package JP.go.ipa.oz.user.launcher;

public class LauncherCellSelectListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.launcher.LauncherCellSelectListener_if {
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dialogQue;
  JP.go.ipa.oz.user.launcher.LauncherCore_if lCore;
  JP.go.ipa.oz.user.launcher.GODOperator_if godOp;
  
  public Object _new_create (JP.go.ipa.oz.user.launcher.LauncherCore_if lchr, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq) throws Exception  {
// 25
    super._new_newActionListener (eq);
// 26
    lCore = lchr;
// 28
    godOp = (JP.go.ipa.oz.user.launcher.GODOperator_cl) (new JP.go.ipa.oz.user.launcher.GODOperator_cl ())._new_create ();
// 29
    dialogQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if evt) throws Exception  {
    checkSecureInvocation ();
// 38
    JP.go.ipa.oz.lib.standard._String_if name = null;
// 39
    JP.go.ipa.oz.lib.standard._String_if god = null;
// 40
    JP.go.ipa.oz.user.launcher.LauncherGUI_if lGUI = null;
// 42
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$137;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) evt)) {
      try {
        getActionCommand$val$137 = evt.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$137 = evt.getActionCommand ();
    }
// 42
    name = getActionCommand$val$137;
// 44
    JP.go.ipa.oz.lib.standard._Frame_if getGUI$val$138;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lCore)) {
      try {
        getGUI$val$138 = lCore.getGUI ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getGUI$val$138 = lCore.getGUI ();
    }
// 44
    lGUI = (JP.go.ipa.oz.user.launcher.LauncherGUI_if) (getGUI$val$138);
// 45
    JP.go.ipa.oz.lib.standard._String_if getPath$val$139;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lGUI)) {
      try {
        getPath$val$139 = lGUI.getPath ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getPath$val$139 = lGUI.getPath ();
    }
// 45
    JP.go.ipa.oz.lib.standard._String_if toGOD$val$140;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) godOp)) {
      try {
        toGOD$val$140 = godOp.toGOD (getPath$val$139, name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      toGOD$val$140 = godOp.toGOD (getPath$val$139, name);
    }
// 45
    god = toGOD$val$140;
// 46
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lCore)) {
      try {
        lCore.startCell (god);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lCore.startCell (god);
    }
  }
  
  public LauncherCellSelectListener_cl () throws Exception { super (); }
  
}


package JP.go.ipa.oz.user.launcher;

final public class LauncherQuitListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.launcher.LauncherQuitListener_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.user.launcher.LauncherCore_if lCore;
  JP.go.ipa.oz.user.launcher.AnswerDialog_if answerDialog;
  
  public Object _new_create (JP.go.ipa.oz.user.launcher.LauncherCore_if lc, JP.go.ipa.oz.user.launcher.AnswerDialog_if dialog, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq) throws Exception  {
// 24
    super._new_newActionListener (eq);
// 25
    lCore = lc;
// 26
    answerDialog = dialog;
// 27
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) answerDialog)) {
      try {
        answerDialog.addActionListener (this);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      answerDialog.addActionListener (this);
    }
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if evt) throws Exception  {
    checkSecureInvocation ();
// 37
    JP.go.ipa.oz.lib.standard._String_if cmd = null;
// 39
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$24;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) evt)) {
      try {
        getActionCommand$val$24 = evt.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$24 = evt.getActionCommand ();
    }
// 39
    cmd = getActionCommand$val$24;
// 41
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) answerDialog)) {
      try {
        answerDialog.dispose ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      answerDialog.dispose ();
    }
// 42
    JP.go.ipa.oz.lib.standard._String_if string$3 = (new JP.go.ipa.oz.lib.standard._String_cl("OK"));
    
// 42
    boolean isequal$val$25;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
      try {
        isequal$val$25 = cmd.isequal (string$3);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$25 = cmd.isequal (string$3);
    }
// 42
    if (isequal$val$25) {{
// 43
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lCore)) {
          try {
            lCore.stop ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          lCore.stop ();
        }
      }
    }
  }
  
  public LauncherQuitListener_cl () throws Exception { super (); }
  
}


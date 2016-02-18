package JP.go.ipa.oz.user.launcher;

final public class LauncherMenuListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.launcher.LauncherMenuListener_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dialogQue;
  JP.go.ipa.oz.user.launcher.LauncherCore_if lCore;
  JP.go.ipa.oz.user.launcher.GODOperator_if godOp;
  
  public Object _new_create (JP.go.ipa.oz.user.launcher.LauncherCore_if lc, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq) throws Exception  {
// 26
    super._new_newActionListener (eq);
// 27
    lCore = lc;
// 28
    dialogQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 29
    godOp = (JP.go.ipa.oz.user.launcher.GODOperator_cl) (new JP.go.ipa.oz.user.launcher.GODOperator_cl ())._new_create ();
    return this;
  }
  
  void newCell () throws Exception  {
// 84
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lCore)) {
      try {
        lCore.createCell ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lCore.createCell ();
    }
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if evt) throws Exception  {
    checkSecureInvocation ();
// 39
    JP.go.ipa.oz.lib.standard._String_if cmd = null;
// 41
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$26;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) evt)) {
      try {
        getActionCommand$val$26 = evt.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$26 = evt.getActionCommand ();
    }
// 41
    cmd = getActionCommand$val$26;
// 43
    JP.go.ipa.oz.lib.standard._String_if string$4 = (new JP.go.ipa.oz.lib.standard._String_cl("quit"));
    
// 43
    boolean isequal$val$27;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
      try {
        isequal$val$27 = cmd.isequal (string$4);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$27 = cmd.isequal (string$4);
    }
// 43
    if (isequal$val$27) {{
// 44
        quit ();
      }
    } else {
// 45
      JP.go.ipa.oz.lib.standard._String_if string$5 = (new JP.go.ipa.oz.lib.standard._String_cl("refresh"));
      
// 45
      boolean isequal$val$28;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
        try {
          isequal$val$28 = cmd.isequal (string$5);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$28 = cmd.isequal (string$5);
      }
// 45
      if (isequal$val$28) {{
// 46
          refresh ();
        }
      } else {
// 47
        JP.go.ipa.oz.lib.standard._String_if string$6 = (new JP.go.ipa.oz.lib.standard._String_cl("start cell"));
        
// 47
        boolean isequal$val$29;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
          try {
            isequal$val$29 = cmd.isequal (string$6);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$29 = cmd.isequal (string$6);
        }
// 47
        if (isequal$val$29) {{
// 48
            startCell ();
          }
        } else {
// 49
          JP.go.ipa.oz.lib.standard._String_if string$7 = (new JP.go.ipa.oz.lib.standard._String_cl("new cell"));
          
// 49
          boolean isequal$val$30;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
            try {
              isequal$val$30 = cmd.isequal (string$7);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            isequal$val$30 = cmd.isequal (string$7);
          }
// 49
          if (isequal$val$30) {{
// 50
              newCell ();
            }
          }
        }
      }
    }
  }
  
  void refresh () throws Exception  {
// 91
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lCore)) {
      try {
        lCore.sync ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lCore.sync ();
    }
  }
  
  void handleException (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception  {
// 75
    JP.go.ipa.oz.user.misc.gui.ExceptionDialog_if exDialog = null;
// 76
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq = null;
  }
  
  void quit () throws Exception  {
// 60
    JP.go.ipa.oz.user.launcher.AnswerDialog_if dialog = null;
// 61
    JP.go.ipa.oz.user.launcher.LauncherQuitListener_if listener = null;
// 62
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq = null;
// 64
    eq = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 65
    JP.go.ipa.oz.lib.standard._Frame_if getGUI$val$31;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lCore)) {
      try {
        getGUI$val$31 = lCore.getGUI ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getGUI$val$31 = lCore.getGUI ();
    }
// 65
    dialog = (JP.go.ipa.oz.user.launcher.AnswerDialog_cl) (new JP.go.ipa.oz.user.launcher.AnswerDialog_cl ())._new_create (getGUI$val$31, (new JP.go.ipa.oz.lib.standard._String_cl("Launcher Quit Dialog")), (new JP.go.ipa.oz.lib.standard._String_cl("Do you really want to quit OZ Launcher ?")));
// 67
    listener = (JP.go.ipa.oz.user.launcher.LauncherQuitListener_cl) (new JP.go.ipa.oz.user.launcher.LauncherQuitListener_cl ())._new_create (lCore, dialog, eq);
// 68
    dialog.show ();
  }
  
  void startCell () throws Exception  {
// 98
    JP.go.ipa.oz.lib.standard._String_if name = null;
// 99
    JP.go.ipa.oz.lib.standard._String_if god = null;
// 100
    JP.go.ipa.oz.user.launcher.LauncherGUI_if lGUI = null;
// 102
    JP.go.ipa.oz.lib.standard._Frame_if getGUI$val$32;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lCore)) {
      try {
        getGUI$val$32 = lCore.getGUI ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getGUI$val$32 = lCore.getGUI ();
    }
// 102
    lGUI = (JP.go.ipa.oz.user.launcher.LauncherGUI_if) (getGUI$val$32);
// 103
    JP.go.ipa.oz.lib.standard._String_if getSelectedCell$val$33;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lGUI)) {
      try {
        getSelectedCell$val$33 = lGUI.getSelectedCell ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedCell$val$33 = lGUI.getSelectedCell ();
    }
// 103
    name = getSelectedCell$val$33;
// 104
    if (name != null) {{
// 105
        JP.go.ipa.oz.lib.standard._String_if getPath$val$34;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lGUI)) {
          try {
            getPath$val$34 = lGUI.getPath ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getPath$val$34 = lGUI.getPath ();
        }
// 105
        JP.go.ipa.oz.lib.standard._String_if toGOD$val$35;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) godOp)) {
          try {
            toGOD$val$35 = godOp.toGOD (getPath$val$34, name);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          toGOD$val$35 = godOp.toGOD (getPath$val$34, name);
        }
// 105
        god = toGOD$val$35;
// 106
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
    }
  }
  
  public LauncherMenuListener_cl () throws Exception { super (); }
  
}


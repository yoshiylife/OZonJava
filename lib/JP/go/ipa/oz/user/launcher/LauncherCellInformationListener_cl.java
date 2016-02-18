package JP.go.ipa.oz.user.launcher;

public class LauncherCellInformationListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.launcher.LauncherCellInformationListener_if {
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dialogQue;
  JP.go.ipa.oz.user.launcher.LauncherCore_if lCore;
  JP.go.ipa.oz.user.launcher.LauncherCellInformationDialog_if cellDialog;
  
  public Object _new_create (JP.go.ipa.oz.user.launcher.LauncherCore_if lchr, JP.go.ipa.oz.user.launcher.LauncherCellInformationDialog_if dialog, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq) throws Exception  {
// 27
    super._new_newActionListener (eq);
// 29
    lCore = lchr;
// 30
    cellDialog = dialog;
// 31
    dialogQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if evt) throws Exception  {
    checkSecureInvocation ();
// 40
    JP.go.ipa.oz.lib.standard._String_if cmd = null;
// 41
    JP.go.ipa.oz.lib.standard._String_if god = null, cid = null;
// 42
    boolean needToDispose = true;
// 44
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$130;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) evt)) {
      try {
        getActionCommand$val$130 = evt.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$130 = evt.getActionCommand ();
    }
// 44
    cmd = getActionCommand$val$130;
// 46
    JP.go.ipa.oz.lib.standard._String_if string$28 = (new JP.go.ipa.oz.lib.standard._String_cl("OK"));
    
// 46
    boolean isequal$val$131;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
      try {
        isequal$val$131 = cmd.isequal (string$28);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$131 = cmd.isequal (string$28);
    }
// 46
    if (isequal$val$131) {{
// 47
        JP.go.ipa.oz.lib.standard._String_if getInputGOD$val$132;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cellDialog)) {
          try {
            getInputGOD$val$132 = cellDialog.getInputGOD ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getInputGOD$val$132 = cellDialog.getInputGOD ();
        }
// 47
        god = getInputGOD$val$132;
// 48
        JP.go.ipa.oz.lib.standard._String_if getInputCID$val$133;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cellDialog)) {
          try {
            getInputCID$val$133 = cellDialog.getInputCID ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getInputCID$val$133 = cellDialog.getInputCID ();
        }
// 48
        cid = getInputCID$val$133;
        boolean bool$val$6;
        
// 50
        int length$val$134;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) god)) {
          try {
            length$val$134 = god.length ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          length$val$134 = god.length ();
        }
        bool$val$6 = length$val$134 > 0;
        if (bool$val$6) {
// 50
          int length$val$135;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
            try {
              length$val$135 = cid.length ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            length$val$135 = cid.length ();
          }
          bool$val$6 = length$val$135 > 0;
        }
// 50
        if (bool$val$6) {{
// 51
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cellDialog)) {
              try {
                cellDialog.setVisible (false);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              cellDialog.setVisible (false);
            }
// 52
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lCore)) {
              try {
                lCore.createCell (god, cid);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              lCore.createCell (god, cid);
            }
          }
        } else {{
// 55
            needToDispose = false;
// 56
            handleException ();
          }
        }
      }
    }
// 60
    if (needToDispose) {{
// 61
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cellDialog)) {
          try {
            cellDialog.dispose ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          cellDialog.dispose ();
        }
      }
    }
  }
  
  void handleException () throws Exception  {
// 69
    JP.go.ipa.oz.user.misc.gui.ExceptionDialog_if exDialog = null;
// 71
    JP.go.ipa.oz.lib.standard._Frame_if getGUI$val$136;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lCore)) {
      try {
        getGUI$val$136 = lCore.getGUI ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getGUI$val$136 = lCore.getGUI ();
    }
// 71
    exDialog = (JP.go.ipa.oz.user.misc.gui.ExceptionDialog_cl) (new JP.go.ipa.oz.user.misc.gui.ExceptionDialog_cl ())._new_create (getGUI$val$136, (new JP.go.ipa.oz.lib.standard._String_cl("Invalid GOD or class ID")), dialogQue);
  }
  
  public LauncherCellInformationListener_cl () throws Exception { super (); }
  
}


package JP.go.ipa.oz.user.ide;

public class GOLInputListenerForSubject_cl extends JP.go.ipa.oz.user.misc.gui.StringInputListener_cl implements JP.go.ipa.oz.user.ide.GOLInputListenerForSubject_if {
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dialogQue;
  JP.go.ipa.oz.user.ide.SubjectGarageBrowser_if sgBrowser;
  JP.go.ipa.oz.lib.standard._Frame_if parentFrame;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.SubjectGarageBrowser_if sgb, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq) throws Exception  {
// 39
    super._new_create (eq);
// 40
    sgBrowser = sgb;
// 41
    JP.go.ipa.oz.lib.standard._Frame_if getGUI$val$1157;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sgBrowser)) {
      try {
        getGUI$val$1157 = sgBrowser.getGUI ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getGUI$val$1157 = sgBrowser.getGUI ();
    }
// 41
    parentFrame = getGUI$val$1157;
// 43
    dialogQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if evt) throws Exception  {
    checkSecureInvocation ();
// 53
    JP.go.ipa.oz.user.misc.gui.StringInputDialog_if dialog = null;
// 54
    JP.go.ipa.oz.lib.standard._String_if cmd = null;
// 55
    JP.go.ipa.oz.lib.standard._String_if gol = null;
// 56
    boolean needToClose = true;
// 58
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$1158;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) evt)) {
      try {
        getActionCommand$val$1158 = evt.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$1158 = evt.getActionCommand ();
    }
// 58
    cmd = getActionCommand$val$1158;
// 60
    dialog = getDialog ();
// 61
    JP.go.ipa.oz.lib.standard._String_if string$228 = (new JP.go.ipa.oz.lib.standard._String_cl("OK"));
    
// 61
    boolean isequal$val$1159;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
      try {
        isequal$val$1159 = cmd.isequal (string$228);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$1159 = cmd.isequal (string$228);
    }
// 61
    if (isequal$val$1159) {{
// 62
        JP.go.ipa.oz.lib.standard._String_if getInputString$val$1160;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dialog)) {
          try {
            getInputString$val$1160 = dialog.getInputString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getInputString$val$1160 = dialog.getInputString ();
        }
// 62
        gol = getInputString$val$1160;
// 63
        int length$val$1161;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gol)) {
          try {
            length$val$1161 = gol.length ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          length$val$1161 = gol.length ();
        }
// 63
        if (length$val$1161 > 0) {{
// 64
            try {
// 65
              if (sgBrowser != null) {{
// 66
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sgBrowser)) {
                    try {
                      sgBrowser.bindServer (gol);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    sgBrowser.bindServer (gol);
                  }
                }
              }
            }
            catch (JP.go.ipa.oz.lang.OzException _exception_1) {
              JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
              if (_oz_exception_1 instanceof JP.go.ipa.oz.user.garage.GarageException_if) {
                JP.go.ipa.oz.user.garage.GarageException_if ex = (JP.go.ipa.oz.user.garage.GarageException_if) _oz_exception_1;
// 69
                needToClose = false;
// 70
                handleException ();
              } else if (_oz_exception_1 instanceof JP.go.ipa.oz.lang._Root_if) {
                JP.go.ipa.oz.lang._Root_if o = (JP.go.ipa.oz.lang._Root_if) _oz_exception_1;
// 75
                needToClose = false;
// 77
                handleException ();
              } else throw _exception_1;
            }
            catch (JP.go.ipa.oz.system.ExCellNotFoundException _exception_ex) {
              JP.go.ipa.oz.lang._Exception_if ex = new JP.go.ipa.oz.lang._Exception_cl (_exception_ex);
              
// 72
              needToClose = false;
// 73
              handleException ();
            }
          }
        } else {{
// 81
            needToClose = false;
// 82
            handleException ();
          }
        }
      }
    }
// 86
    if (needToClose) {{
// 87
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dialog)) {
          try {
            dialog.dispose ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          dialog.dispose ();
        }
      }
    }
  }
  
  void handleException () throws Exception  {
// 95
    JP.go.ipa.oz.user.misc.gui.ExceptionDialog_if exDialog = null;
// 97
    exDialog = (JP.go.ipa.oz.user.misc.gui.ExceptionDialog_cl) (new JP.go.ipa.oz.user.misc.gui.ExceptionDialog_cl ())._new_create (parentFrame, (new JP.go.ipa.oz.lib.standard._String_cl("Invalid GOL")), dialogQue);
  }
  
  public GOLInputListenerForSubject_cl () throws Exception { super (); }
  
}


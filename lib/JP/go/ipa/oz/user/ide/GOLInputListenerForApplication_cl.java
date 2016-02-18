package JP.go.ipa.oz.user.ide;

public class GOLInputListenerForApplication_cl extends JP.go.ipa.oz.user.misc.gui.StringInputListener_cl implements JP.go.ipa.oz.user.ide.GOLInputListenerForApplication_if {
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dialogQue;
  JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_if agBrowser;
  JP.go.ipa.oz.lib.standard._Frame_if parentFrame;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_if agb, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq) throws Exception  {
// 39
    super._new_create (eq);
// 40
    agBrowser = agb;
// 41
    JP.go.ipa.oz.lib.standard._Frame_if getGUI$val$1239;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) agBrowser)) {
      try {
        getGUI$val$1239 = agBrowser.getGUI ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getGUI$val$1239 = agBrowser.getGUI ();
    }
// 41
    parentFrame = getGUI$val$1239;
// 43
    dialogQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if evt) throws Exception  {
    checkSecureInvocation ();
// 52
    JP.go.ipa.oz.user.misc.gui.StringInputDialog_if dialog = null;
// 53
    JP.go.ipa.oz.lib.standard._String_if cmd = null;
// 54
    JP.go.ipa.oz.lib.standard._String_if gol = null;
// 55
    boolean needToClose = true;
// 57
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$1240;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) evt)) {
      try {
        getActionCommand$val$1240 = evt.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$1240 = evt.getActionCommand ();
    }
// 57
    cmd = getActionCommand$val$1240;
// 59
    dialog = getDialog ();
// 60
    JP.go.ipa.oz.lib.standard._String_if string$243 = (new JP.go.ipa.oz.lib.standard._String_cl("OK"));
    
// 60
    boolean isequal$val$1241;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
      try {
        isequal$val$1241 = cmd.isequal (string$243);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$1241 = cmd.isequal (string$243);
    }
// 60
    if (isequal$val$1241) {{
// 61
        JP.go.ipa.oz.lib.standard._String_if getInputString$val$1242;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dialog)) {
          try {
            getInputString$val$1242 = dialog.getInputString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getInputString$val$1242 = dialog.getInputString ();
        }
// 61
        gol = getInputString$val$1242;
// 62
        int length$val$1243;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gol)) {
          try {
            length$val$1243 = gol.length ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          length$val$1243 = gol.length ();
        }
// 62
        if (length$val$1243 > 0) {{
// 63
            try {
// 64
              if (agBrowser != null) {{
// 65
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) agBrowser)) {
                    try {
                      agBrowser.bindServer (gol);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    agBrowser.bindServer (gol);
                  }
                }
              }
            }
            catch (JP.go.ipa.oz.lang.OzException _exception_1) {
              JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
              if (_oz_exception_1 instanceof JP.go.ipa.oz.user.garage.GarageException_if) {
                JP.go.ipa.oz.user.garage.GarageException_if ex = (JP.go.ipa.oz.user.garage.GarageException_if) _oz_exception_1;
// 68
                needToClose = false;
// 69
                handleException ();
              } else if (_oz_exception_1 instanceof JP.go.ipa.oz.lang._Root_if) {
                JP.go.ipa.oz.lang._Root_if o = (JP.go.ipa.oz.lang._Root_if) _oz_exception_1;
// 74
                needToClose = false;
// 76
                handleException ();
              } else throw _exception_1;
            }
            catch (JP.go.ipa.oz.system.ExCellNotFoundException _exception_ex) {
              JP.go.ipa.oz.lang._Exception_if ex = new JP.go.ipa.oz.lang._Exception_cl (_exception_ex);
              
// 71
              needToClose = false;
// 72
              handleException ();
            }
          }
        } else {{
// 80
            needToClose = false;
// 81
            handleException ();
          }
        }
      }
    }
// 85
    if (needToClose) {{
// 86
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
// 94
    JP.go.ipa.oz.user.misc.gui.ExceptionDialog_if exDialog = null;
// 96
    exDialog = (JP.go.ipa.oz.user.misc.gui.ExceptionDialog_cl) (new JP.go.ipa.oz.user.misc.gui.ExceptionDialog_cl ())._new_create (parentFrame, (new JP.go.ipa.oz.lib.standard._String_cl("Invalid GOL")), dialogQue);
  }
  
  public GOLInputListenerForApplication_cl () throws Exception { super (); }
  
}


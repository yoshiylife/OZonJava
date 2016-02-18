package JP.go.ipa.oz.user.ide;

final public class CBCIDInputDialogListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.CBCIDInputDialogListener_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dialogQue;
  JP.go.ipa.oz.user.ide.CBCIDInputDialog_if targetDialog;
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.user.ide.CBPartView_if partView;
  
  public Object _new_newCBCIDInputDialogListener (JP.go.ipa.oz.user.ide.CBPartView_if pv, JP.go.ipa.oz.user.ide.CBCIDInputDialog_if dl, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dlgQue) throws Exception  {
// 28
    super._new_newActionListener (dlgQue);
// 30
    partView = pv;
// 31
    targetDialog = dl;
// 32
    dialogQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 34
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 35
    if (isGreen ()) {{
// 36
        JP.go.ipa.oz.lib.standard._String_if string$29 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCBCIDInputDialogListener#new: green"));
        
// 36
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (string$29);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (string$29);
        }
      }
    } else {{
// 38
        JP.go.ipa.oz.lib.standard._String_if string$30 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCBCIDInputDialogListener#new: red"));
        
// 38
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (string$30);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (string$30);
        }
      }
    }
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if evt) throws Exception  {
    checkSecureInvocation ();
// 48
    JP.go.ipa.oz.lib.standard._String_if cmd = null;
// 49
    JP.go.ipa.oz.lib.standard._String_if cid = null;
// 50
    JP.go.ipa.oz.lib.standard._StringBuffer_if msg = null;
// 51
    JP.go.ipa.oz.user.ide.CBExceptionDialog_if exDialog = null;
// 53
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$207;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) evt)) {
      try {
        getActionCommand$val$207 = evt.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$207 = evt.getActionCommand ();
    }
// 53
    cmd = getActionCommand$val$207;
// 55
    JP.go.ipa.oz.lib.standard._String_if string$31 = (new JP.go.ipa.oz.lib.standard._String_cl("OK"));
    
// 55
    boolean isequal$val$208;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
      try {
        isequal$val$208 = cmd.isequal (string$31);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$208 = cmd.isequal (string$31);
    }
// 55
    if (isequal$val$208) {{
// 56
        JP.go.ipa.oz.lib.standard._String_if getCID$val$209;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetDialog)) {
          try {
            getCID$val$209 = targetDialog.getCID ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getCID$val$209 = targetDialog.getCID ();
        }
// 56
        cid = getCID$val$209;
// 57
        int length$val$210;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
          try {
            length$val$210 = cid.length ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          length$val$210 = cid.length ();
        }
// 57
        if (length$val$210 > 0) {{
// 58
            try {
// 59
              JP.go.ipa.oz.user.ide.ClassBrowser_if getClassBrowser$val$211;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) partView)) {
                try {
                  getClassBrowser$val$211 = partView.getClassBrowser ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getClassBrowser$val$211 = partView.getClassBrowser ();
              }
// 59
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getClassBrowser$val$211)) {
                try {
                  getClassBrowser$val$211.show (cid);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getClassBrowser$val$211.show (cid);
              }
            }
            catch (JP.go.ipa.oz.lang.OzException _exception_1) {
              JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
              if (_oz_exception_1 instanceof JP.go.ipa.oz.user.ide.CIException_if) {
                JP.go.ipa.oz.user.ide.CIException_if ex = (JP.go.ipa.oz.user.ide.CIException_if) _oz_exception_1;
// 61
                JP.go.ipa.oz.lib.standard._String_if asString$val$212;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ex)) {
                  try {
                    asString$val$212 = ex.asString ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  asString$val$212 = ex.asString ();
                }
// 61
                exDialog = (JP.go.ipa.oz.user.ide.CBExceptionDialog_cl) (new JP.go.ipa.oz.user.ide.CBExceptionDialog_cl ())._new_newCBExceptionDialog (partView, asString$val$212, dialogQue);
              } else throw _exception_1;
            }
          }
        }
      }
    }
// 73
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetDialog)) {
      try {
        targetDialog.dispose ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      targetDialog.dispose ();
    }
  }
  
  public CBCIDInputDialogListener_cl () throws Exception { super (); }
  
}


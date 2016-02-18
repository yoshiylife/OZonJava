package JP.go.ipa.oz.user.ide;

final public class CBClassSelectListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.CBClassSelectListener_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dialogQue;
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.user.ide.CBPartView_if partView;
  JP.go.ipa.oz.lib.standard._List_if classList;
  
  public Object _new_newCBClassSelectListener (JP.go.ipa.oz.user.ide.CBPartView_if pv, JP.go.ipa.oz.lib.standard._List_if list, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if evtQue) throws Exception  {
// 28
    super._new_newActionListener (evtQue);
// 30
    classList = list;
// 31
    partView = pv;
// 32
    dialogQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 34
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 35
    if (isGreen ()) {{
// 36
        JP.go.ipa.oz.lib.standard._String_if string$41 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCBClassSelectListener#new: green"));
        
// 36
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (string$41);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (string$41);
        }
      }
    } else {{
// 38
        JP.go.ipa.oz.lib.standard._String_if string$42 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCBClassSelectListener#new: red"));
        
// 38
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (string$42);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (string$42);
        }
      }
    }
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if evt) throws Exception  {
    checkSecureInvocation ();
// 48
    int index = 0;
// 49
    JP.go.ipa.oz.lib.standard._String_if cid = null;
// 50
    JP.go.ipa.oz.user.ide.CBExceptionDialog_if exDialog = null;
// 52
    int getSelectedIndex$val$224;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classList)) {
      try {
        getSelectedIndex$val$224 = classList.getSelectedIndex ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedIndex$val$224 = classList.getSelectedIndex ();
    }
// 52
    index = getSelectedIndex$val$224;
// 53
    if (index != -1) {{
// 54
        JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$225;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) evt)) {
          try {
            getActionCommand$val$225 = evt.getActionCommand ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getActionCommand$val$225 = evt.getActionCommand ();
        }
// 54
        cid = getActionCommand$val$225;
// 55
        JP.go.ipa.oz.lib.standard._String_if string$43 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCBClassSelectListener#actionPerformed: "));
        
// 55
        JP.go.ipa.oz.lib.standard._String_if concat$val$226;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$43)) {
          try {
            concat$val$226 = string$43.concat (cid);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$226 = string$43.concat (cid);
        }
// 55
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (concat$val$226);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (concat$val$226);
        }
// 56
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classList)) {
          try {
            classList.deselect (index);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          classList.deselect (index);
        }
// 57
        try {
// 58
          JP.go.ipa.oz.user.ide.ClassBrowser_if getClassBrowser$val$227;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) partView)) {
            try {
              getClassBrowser$val$227 = partView.getClassBrowser ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getClassBrowser$val$227 = partView.getClassBrowser ();
          }
// 58
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getClassBrowser$val$227)) {
            try {
              getClassBrowser$val$227.show (cid);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getClassBrowser$val$227.show (cid);
          }
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_1) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
          if (_oz_exception_1 instanceof JP.go.ipa.oz.user.ide.CIException_if) {
            JP.go.ipa.oz.user.ide.CIException_if ex = (JP.go.ipa.oz.user.ide.CIException_if) _oz_exception_1;
// 60
            JP.go.ipa.oz.lib.standard._String_if asString$val$228;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ex)) {
              try {
                asString$val$228 = ex.asString ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              asString$val$228 = ex.asString ();
            }
// 60
            exDialog = (JP.go.ipa.oz.user.ide.CBExceptionDialog_cl) (new JP.go.ipa.oz.user.ide.CBExceptionDialog_cl ())._new_newCBExceptionDialog (partView, asString$val$228, dialogQue);
          } else throw _exception_1;
        }
      }
    }
  }
  
  public CBClassSelectListener_cl () throws Exception { super (); }
  
}


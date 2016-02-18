package JP.go.ipa.oz.user.ide;

final public class CBSystemMenuListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.CBSystemMenuListener_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dialogQue;
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.lib.standard._String_if cid;
  JP.go.ipa.oz.user.ide.CBPartView_if partView;
  
  public Object _new_newCBSystemMenuListener (JP.go.ipa.oz.user.ide.CBPartView_if pv, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if evtQue) throws Exception  {
// 27
    super._new_newActionListener (evtQue);
// 28
    partView = pv;
// 29
    JP.go.ipa.oz.lib.standard._String_if getCID$val$214;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pv)) {
      try {
        getCID$val$214 = pv.getCID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getCID$val$214 = pv.getCID ();
    }
// 29
    ((JP.go.ipa.oz.user.ide.CBSystemMenuListener_cl)this).cid = getCID$val$214;
// 30
    dialogQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 32
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 33
    if (isGreen ()) {{
// 34
        JP.go.ipa.oz.lib.standard._String_if string$32 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCBSystemMenuListener#new: green"));
        
// 34
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (string$32);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (string$32);
        }
      }
    } else {{
// 36
        JP.go.ipa.oz.lib.standard._String_if string$33 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCBSystemMenuListener#new: red"));
        
// 36
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (string$33);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (string$33);
        }
      }
    }
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if evt) throws Exception  {
    checkSecureInvocation ();
// 46
    JP.go.ipa.oz.lib.standard._String_if cmd = null;
// 47
    JP.go.ipa.oz.user.ide.CIPart_if part = null;
// 48
    JP.go.ipa.oz.user.ide.ClassBrowser_if cb = null;
// 50
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$215;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) evt)) {
      try {
        getActionCommand$val$215 = evt.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$215 = evt.getActionCommand ();
    }
// 50
    cmd = getActionCommand$val$215;
// 51
    JP.go.ipa.oz.lib.standard._String_if string$34 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCBSystemMenuListener#actionPerformed: "));
    
// 51
    JP.go.ipa.oz.lib.standard._String_if concat$val$216;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$34)) {
      try {
        concat$val$216 = string$34.concat (cmd);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$216 = string$34.concat (cmd);
    }
// 51
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.debugPrintln (concat$val$216);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.debugPrintln (concat$val$216);
    }
// 53
    JP.go.ipa.oz.lib.standard._String_if string$35 = (new JP.go.ipa.oz.lib.standard._String_cl("open"));
    
// 53
    boolean isequal$val$217;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
      try {
        isequal$val$217 = cmd.isequal (string$35);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$217 = cmd.isequal (string$35);
    }
// 53
    if (isequal$val$217) {{
// 54
        JP.go.ipa.oz.user.ide.CBCIDInputDialog_if dialog = null;
// 55
        dialog = (JP.go.ipa.oz.user.ide.CBCIDInputDialog_cl) (new JP.go.ipa.oz.user.ide.CBCIDInputDialog_cl ())._new_newCBCIDInputDialog (partView, dialogQue);
      }
    } else {
// 57
      JP.go.ipa.oz.lib.standard._String_if string$36 = (new JP.go.ipa.oz.lib.standard._String_cl("close"));
      
// 57
      boolean isequal$val$218;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
        try {
          isequal$val$218 = cmd.isequal (string$36);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$218 = cmd.isequal (string$36);
      }
// 57
      if (isequal$val$218) {{
// 58
          JP.go.ipa.oz.user.ide.ClassBrowser_if getClassBrowser$val$219;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) partView)) {
            try {
              getClassBrowser$val$219 = partView.getClassBrowser ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getClassBrowser$val$219 = partView.getClassBrowser ();
          }
// 58
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getClassBrowser$val$219)) {
            try {
              getClassBrowser$val$219.dispose (cid);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getClassBrowser$val$219.dispose (cid);
          }
        }
      } else {
// 60
        JP.go.ipa.oz.lib.standard._String_if string$37 = (new JP.go.ipa.oz.lib.standard._String_cl("close all"));
        
// 60
        boolean isequal$val$220;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
          try {
            isequal$val$220 = cmd.isequal (string$37);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$220 = cmd.isequal (string$37);
        }
// 60
        if (isequal$val$220) {{
// 61
            JP.go.ipa.oz.user.ide.ClassBrowser_if getClassBrowser$val$221;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) partView)) {
              try {
                getClassBrowser$val$221 = partView.getClassBrowser ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getClassBrowser$val$221 = partView.getClassBrowser ();
            }
// 61
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getClassBrowser$val$221)) {
              try {
                getClassBrowser$val$221.disposeAll ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getClassBrowser$val$221.disposeAll ();
            }
          }
        }
      }
    }
  }
  
  public CBSystemMenuListener_cl () throws Exception { super (); }
  
}


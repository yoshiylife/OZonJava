package JP.go.ipa.oz.user.ide;

final public class CBHierarchyMenuListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.CBHierarchyMenuListener_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dialogQue;
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.user.ide.CBPartView_if partView;
  
  public Object _new_newCBHierarchyMenuListener (JP.go.ipa.oz.user.ide.CBPartView_if pv, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if evtQue) throws Exception  {
// 26
    super._new_newActionListener (evtQue);
// 27
    partView = pv;
// 28
    dialogQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 30
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 31
    if (isGreen ()) {{
// 32
        JP.go.ipa.oz.lib.standard._String_if string$38 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCBhierarchyMenuListener#new: green"));
        
// 32
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (string$38);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (string$38);
        }
      }
    } else {{
// 34
        JP.go.ipa.oz.lib.standard._String_if string$39 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCBHierarchyMenuListener#new: red"));
        
// 34
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (string$39);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (string$39);
        }
      }
    }
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if evt) throws Exception  {
    checkSecureInvocation ();
// 44
    JP.go.ipa.oz.lib.standard._String_if cmd = null;
// 45
    JP.go.ipa.oz.user.ide.ClassBrowser_if cb = null;
// 47
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$222;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) evt)) {
      try {
        getActionCommand$val$222 = evt.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$222 = evt.getActionCommand ();
    }
// 47
    cmd = getActionCommand$val$222;
// 49
    JP.go.ipa.oz.lib.standard._String_if string$40 = (new JP.go.ipa.oz.lib.standard._String_cl("ancestors"));
    
// 49
    boolean isequal$val$223;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
      try {
        isequal$val$223 = cmd.isequal (string$40);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$223 = cmd.isequal (string$40);
    }
// 49
    if (isequal$val$223) {{
// 50
        try {
// 51
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) partView)) {
            try {
              partView.showLocalHierarchy ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            partView.showLocalHierarchy ();
          }
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_1) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
          if (_oz_exception_1 instanceof JP.go.ipa.oz.user.ide.CIException_if) {
            JP.go.ipa.oz.user.ide.CIException_if ex = (JP.go.ipa.oz.user.ide.CIException_if) _oz_exception_1;
          } else throw _exception_1;
        }
      }
    }
  }
  
  public CBHierarchyMenuListener_cl () throws Exception { super (); }
  
}


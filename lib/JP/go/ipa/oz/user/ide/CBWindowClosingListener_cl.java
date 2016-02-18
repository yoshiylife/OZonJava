package JP.go.ipa.oz.user.ide;

final public class CBWindowClosingListener_cl extends JP.go.ipa.oz.lib.standard._WindowListener_cl implements JP.go.ipa.oz.user.ide.CBWindowClosingListener_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.lib.standard._Window_if targetWindow;
  
  public Object _new_newCBWindowClosingListener (JP.go.ipa.oz.lib.standard._Window_if win, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if evtQue) throws Exception  {
// 25
    super._new_newWindowListener (evtQue);
// 26
    targetWindow = win;
// 27
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
    return this;
  }
  
  public void windowClosing (JP.go.ipa.oz.lib.standard._WindowEvent_if evt) throws Exception  {
    checkSecureInvocation ();
// 36
    JP.go.ipa.oz.lib.standard._String_if string$24 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCBWindowClosingListener#windowClosing"));
    
// 36
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.debugPrintln (string$24);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.debugPrintln (string$24);
    }
// 38
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetWindow)) {
      try {
        targetWindow.dispose ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      targetWindow.dispose ();
    }
  }
  
  public CBWindowClosingListener_cl () throws Exception { super (); }
  
}


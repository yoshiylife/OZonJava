package JP.go.ipa.oz.user.ide;

final public class CBExceptionDialogListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.CBExceptionDialogListener_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dialogQue;
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.lib.standard._Dialog_if dialog;
  
  public Object _new_newCBExceptionDialogListener (JP.go.ipa.oz.lib.standard._Dialog_if dl, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dlgQue) throws Exception  {
// 24
    super._new_newActionListener (dlgQue);
// 25
    ((JP.go.ipa.oz.user.ide.CBExceptionDialogListener_cl)this).dialog = dl;
// 26
    ((JP.go.ipa.oz.user.ide.CBExceptionDialogListener_cl)this).dialogQue = dlgQue;
// 27
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 28
    if (isGreen ()) {{
// 29
        JP.go.ipa.oz.lib.standard._String_if string$27 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCBExceptionDialogListener#new: green"));
        
// 29
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (string$27);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (string$27);
        }
      }
    } else {{
// 31
        JP.go.ipa.oz.lib.standard._String_if string$28 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCBExceptionDialogListener#new: red"));
        
// 31
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (string$28);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (string$28);
        }
      }
    }
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if evt) throws Exception  {
    checkSecureInvocation ();
// 39
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
  
  public CBExceptionDialogListener_cl () throws Exception { super (); }
  
}


package JP.go.ipa.oz.user.misc.gui;

public class ExceptionDialogListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.misc.gui.ExceptionDialogListener_if {
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dialogQue;
  JP.go.ipa.oz.lib.standard._Dialog_if targetDialog;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Dialog_if dg, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq) throws Exception  {
// 25
    super._new_newActionListener (eq);
// 26
    targetDialog = dg;
// 27
    ((JP.go.ipa.oz.user.misc.gui.ExceptionDialogListener_cl)this).dialogQue = eq;
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if evt) throws Exception  {
    checkSecureInvocation ();
// 36
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
  
  public ExceptionDialogListener_cl () throws Exception { super (); }
  
}


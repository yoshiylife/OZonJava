package JP.go.ipa.oz.user.misc.gui;

public class StringInputListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.misc.gui.StringInputListener_if {
  JP.go.ipa.oz.user.misc.gui.StringInputDialog_if inputDialog;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq) throws Exception  {
// 23
    super._new_newActionListener (eq);
    return this;
  }
  
  public JP.go.ipa.oz.user.misc.gui.StringInputDialog_if getDialog () throws Exception  {
    checkSecureInvocation ();
// 32
    return inputDialog;
  }
  
  public void setDialog (JP.go.ipa.oz.user.misc.gui.StringInputDialog_if dialog) throws Exception  {
    checkSecureInvocation ();
// 39
    inputDialog = dialog;
  }
  
  public StringInputListener_cl () throws Exception { super (); }
  
}


package JP.go.ipa.oz.user.ide;

final public class CBExceptionDialog_cl extends JP.go.ipa.oz.user.ide.CBDialog_cl implements JP.go.ipa.oz.user.ide.CBExceptionDialog_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dialogQue;
  
  public Object _new_newCBExceptionDialog (JP.go.ipa.oz.lib.standard._Frame_if pv, JP.go.ipa.oz.lib.standard._String_if message, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dlgQue) throws Exception  {
// 22
    super._new_newCBDialog (pv, (new JP.go.ipa.oz.lib.standard._String_cl("ClassBrowser Exception")), true);
// 23
    ((JP.go.ipa.oz.user.ide.CBExceptionDialog_cl)this).dialogQue = dlgQue;
// 24
    initGUI (message);
    return this;
  }
  
  void initGUI (JP.go.ipa.oz.lib.standard._String_if message) throws Exception  {
// 35
    JP.go.ipa.oz.lib.standard._Label_if messageLabel = null;
// 36
    JP.go.ipa.oz.lib.standard._Button_if okButton = null;
// 37
    JP.go.ipa.oz.lib.standard._Font_if font = null;
// 38
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 39
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 40
    JP.go.ipa.oz.lib.standard._Insets_if insets = null;
// 41
    JP.go.ipa.oz.user.ide.CBExceptionDialogListener_if listener = null;
// 43
    font = (JP.go.ipa.oz.lib.standard._Font_cl) (new JP.go.ipa.oz.lib.standard._Font_cl ())._new_newFont ((new JP.go.ipa.oz.lib.standard._String_cl("SansSerif")), 14);
// 45
    messageLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel (message);
// 46
    messageLabel.setFont (font);
// 47
    okButton = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("OK")));
// 49
    listener = (JP.go.ipa.oz.user.ide.CBExceptionDialogListener_cl) (new JP.go.ipa.oz.user.ide.CBExceptionDialogListener_cl ())._new_newCBExceptionDialogListener (this, dialogQue);
// 50
    okButton.addActionListener (listener);
// 52
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 53
    setLayout (layout);
// 54
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 55
    constraints.setGridwidth (constraints.getREMAINDER ());
// 56
    insets = (JP.go.ipa.oz.lib.standard._Insets_cl) (new JP.go.ipa.oz.lib.standard._Insets_cl ())._new_newInsets (20, 20, 10, 20);
// 57
    constraints.setInsets (insets);
// 58
    layout.setConstraints (okButton, constraints);
// 59
    layout.setConstraints (messageLabel, constraints);
// 61
    add (messageLabel);
// 62
    add (okButton);
// 63
    pack ();
// 64
    show ();
  }
  
  public CBExceptionDialog_cl () throws Exception { super (); }
  
}


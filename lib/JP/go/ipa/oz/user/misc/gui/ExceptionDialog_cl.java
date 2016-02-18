package JP.go.ipa.oz.user.misc.gui;

public class ExceptionDialog_cl extends JP.go.ipa.oz.user.misc.gui.CenteredDialog_cl implements JP.go.ipa.oz.user.misc.gui.ExceptionDialog_if {
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dialogQue;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Frame_if parent, JP.go.ipa.oz.lib.standard._String_if message, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq) throws Exception  {
// 22
    super._new_create (parent, (new JP.go.ipa.oz.lib.standard._String_cl("Exception Dialog")), true);
// 23
    ((JP.go.ipa.oz.user.misc.gui.ExceptionDialog_cl)this).dialogQue = eq;
// 24
    initGUI (message);
// 25
    show ();
    return this;
  }
  
  void initGUI (JP.go.ipa.oz.lib.standard._String_if message) throws Exception  {
// 36
    JP.go.ipa.oz.lib.standard._Label_if messageLabel = null;
// 37
    JP.go.ipa.oz.lib.standard._Button_if okButton = null;
// 38
    JP.go.ipa.oz.lib.standard._Font_if font = null;
// 39
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 40
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 41
    JP.go.ipa.oz.lib.standard._Insets_if insets = null;
// 42
    JP.go.ipa.oz.user.misc.gui.ExceptionDialogListener_if listener = null;
// 44
    if (message == null) {{
// 45
        messageLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("Exception caught.")));
      }
    } else {{
// 47
        messageLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel (message);
      }
    }
// 49
    try {
// 50
      font = (JP.go.ipa.oz.lib.standard._Font_cl) (new JP.go.ipa.oz.lib.standard._Font_cl ())._new_newFont ((new JP.go.ipa.oz.lib.standard._String_cl("SansSerif")), 14);
// 51
      messageLabel.setFont (font);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_1) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
      if (_oz_exception_1 instanceof JP.go.ipa.oz.lang._Root_if) {
        JP.go.ipa.oz.lang._Root_if ex = (JP.go.ipa.oz.lang._Root_if) _oz_exception_1;
      } else throw _exception_1;
    }
// 56
    listener = (JP.go.ipa.oz.user.misc.gui.ExceptionDialogListener_cl) (new JP.go.ipa.oz.user.misc.gui.ExceptionDialogListener_cl ())._new_create (this, dialogQue);
// 57
    okButton = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("OK")));
// 58
    okButton.addActionListener (listener);
// 60
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 61
    setLayout (layout);
// 62
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 63
    constraints.setGridwidth (constraints.getREMAINDER ());
// 64
    insets = (JP.go.ipa.oz.lib.standard._Insets_cl) (new JP.go.ipa.oz.lib.standard._Insets_cl ())._new_newInsets (20, 20, 10, 20);
// 65
    constraints.setInsets (insets);
// 66
    layout.setConstraints (messageLabel, constraints);
// 67
    layout.setConstraints (okButton, constraints);
// 69
    add (messageLabel);
// 70
    add (okButton);
// 71
    pack ();
  }
  
  public ExceptionDialog_cl () throws Exception { super (); }
  
}


package JP.go.ipa.oz.user.ide;

final public class CBCIDInputDialog_cl extends JP.go.ipa.oz.user.ide.CBDialog_cl implements JP.go.ipa.oz.user.ide.CBCIDInputDialog_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dialogQue;
  JP.go.ipa.oz.lib.standard._TextField_if CIDView;
  JP.go.ipa.oz.user.ide.CBPartView_if partView;
  
  public Object _new_newCBCIDInputDialog (JP.go.ipa.oz.user.ide.CBPartView_if parent, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dlgQue) throws Exception  {
// 23
    super._new_newCBDialog (parent, (new JP.go.ipa.oz.lib.standard._String_cl("ClassBrowser: CID Input Dialog")), true);
// 24
    ((JP.go.ipa.oz.user.ide.CBCIDInputDialog_cl)this).partView = parent;
// 25
    ((JP.go.ipa.oz.user.ide.CBCIDInputDialog_cl)this).dialogQue = dlgQue;
// 26
    initGUI ();
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getCID () throws Exception  {
    checkSecureInvocation ();
// 35
    JP.go.ipa.oz.lib.standard._String_if cid = null;
// 37
    JP.go.ipa.oz.lib.standard._String_if getText$val$213;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) CIDView)) {
      try {
        getText$val$213 = CIDView.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$213 = CIDView.getText ();
    }
// 37
    cid = getText$val$213;
// 39
    return cid;
  }
  
  JP.go.ipa.oz.lib.standard._Panel_if mkButtonPanel () throws Exception  {
// 106
    JP.go.ipa.oz.lib.standard._Panel_if buttonPanel = null;
// 107
    JP.go.ipa.oz.lib.standard._Button_if okButton = null, cancelButton = null;
// 108
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 109
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 110
    JP.go.ipa.oz.lib.standard._Insets_if insets = null;
// 111
    JP.go.ipa.oz.user.ide.CBCIDInputDialogListener_if listener = null;
// 113
    okButton = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("OK")));
// 114
    cancelButton = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("Cancel")));
// 116
    listener = (JP.go.ipa.oz.user.ide.CBCIDInputDialogListener_cl) (new JP.go.ipa.oz.user.ide.CBCIDInputDialogListener_cl ())._new_newCBCIDInputDialogListener (partView, this, dialogQue);
// 117
    okButton.addActionListener (listener);
// 118
    cancelButton.addActionListener (listener);
// 120
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 121
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 122
    constraints.setFill (constraints.getBOTH ());
// 123
    insets = (JP.go.ipa.oz.lib.standard._Insets_cl) (new JP.go.ipa.oz.lib.standard._Insets_cl ())._new_newInsets (10, 20, 10, 20);
// 124
    constraints.setInsets (insets);
// 126
    buttonPanel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout);
// 127
    layout.setConstraints (okButton, constraints);
// 128
    layout.setConstraints (cancelButton, constraints);
// 129
    buttonPanel.add (okButton);
// 130
    buttonPanel.add (cancelButton);
// 132
    return buttonPanel;
  }
  
  void initGUI () throws Exception  {
// 48
    JP.go.ipa.oz.lib.standard._Panel_if CIDPanel = null, buttonPanel = null;
// 49
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 50
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 52
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 53
    setLayout (layout);
// 54
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 55
    constraints.setFill (constraints.getBOTH ());
// 57
    CIDPanel = mkCIDPanel ();
// 58
    buttonPanel = mkButtonPanel ();
// 60
    constraints.setGridwidth (constraints.getREMAINDER ());
// 61
    constraints.setWeightx (1.0);
// 62
    layout.setConstraints (CIDPanel, constraints);
// 63
    layout.setConstraints (buttonPanel, constraints);
// 65
    add (CIDPanel);
// 66
    add (buttonPanel);
// 67
    pack ();
// 68
    show ();
  }
  
  JP.go.ipa.oz.lib.standard._Panel_if mkCIDPanel () throws Exception  {
// 75
    JP.go.ipa.oz.lib.standard._Panel_if CIDPanel = null;
// 76
    JP.go.ipa.oz.lib.standard._Label_if CIDLabel = null;
// 77
    JP.go.ipa.oz.lib.standard._Insets_if insets = null;
// 78
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 79
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 81
    CIDLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("class ID")));
// 82
    CIDView = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField (30);
// 84
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 85
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 86
    constraints.setFill (constraints.getBOTH ());
// 88
    CIDPanel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout);
// 89
    insets = (JP.go.ipa.oz.lib.standard._Insets_cl) (new JP.go.ipa.oz.lib.standard._Insets_cl ())._new_newInsets (10, 10, 0, 2);
// 90
    constraints.setInsets (insets);
// 91
    layout.setConstraints (CIDLabel, constraints);
// 92
    constraints.setGridwidth (constraints.getREMAINDER ());
// 93
    constraints.setWeightx (1.0);
// 94
    insets.set (10, 2, 0, 10);
// 95
    layout.setConstraints (CIDView, constraints);
// 96
    CIDPanel.add (CIDLabel);
// 97
    CIDPanel.add (CIDView);
// 99
    return CIDPanel;
  }
  
  public CBCIDInputDialog_cl () throws Exception { super (); }
  
}


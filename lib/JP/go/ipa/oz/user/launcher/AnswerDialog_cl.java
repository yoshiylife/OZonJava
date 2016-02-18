package JP.go.ipa.oz.user.launcher;

public class AnswerDialog_cl extends JP.go.ipa.oz.user.misc.gui.CenteredDialog_cl implements JP.go.ipa.oz.user.launcher.AnswerDialog_if {
  protected JP.go.ipa.oz.lib.standard._Button_if okButton;
  protected JP.go.ipa.oz.lib.standard._Button_if cancelButton;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Frame_if parent, JP.go.ipa.oz.lib.standard._String_if title, JP.go.ipa.oz.lib.standard._String_if message) throws Exception  {
// 22
    super._new_create (parent, title, true);
// 23
    initGUI (message);
    return this;
  }
  
  JP.go.ipa.oz.lib.standard._Panel_if mkMessagePanel (JP.go.ipa.oz.lib.standard._String_if message) throws Exception  {
// 67
    JP.go.ipa.oz.lib.standard._Panel_if panel = null;
// 68
    JP.go.ipa.oz.lib.standard._Label_if msgLabel = null;
// 69
    JP.go.ipa.oz.lib.standard._Insets_if insets = null;
// 70
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 71
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 74
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 77
    panel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout);
// 78
    msgLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel (message);
// 81
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 82
    constraints.setFill (constraints.getBOTH ());
// 83
    constraints.setGridwidth (constraints.getREMAINDER ());
// 84
    constraints.setWeightx (1.0);
// 85
    insets = (JP.go.ipa.oz.lib.standard._Insets_cl) (new JP.go.ipa.oz.lib.standard._Insets_cl ())._new_newInsets (10, 10, 10, 10);
// 86
    constraints.setInsets (insets);
// 87
    layout.setConstraints (msgLabel, constraints);
// 89
    panel.add (msgLabel);
// 91
    return panel;
  }
  
  JP.go.ipa.oz.lib.standard._Panel_if mkControlPanel () throws Exception  {
// 98
    JP.go.ipa.oz.lib.standard._Panel_if panel = null;
// 99
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 100
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 101
    JP.go.ipa.oz.lib.standard._Insets_if insets = null;
// 104
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 105
    panel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout);
// 106
    okButton = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("OK")));
// 107
    cancelButton = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("Cancel")));
// 110
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 111
    constraints.setFill (constraints.getBOTH ());
// 112
    insets = (JP.go.ipa.oz.lib.standard._Insets_cl) (new JP.go.ipa.oz.lib.standard._Insets_cl ())._new_newInsets (10, 20, 10, 20);
// 113
    constraints.setInsets (insets);
// 115
    layout.setConstraints (okButton, constraints);
// 116
    layout.setConstraints (cancelButton, constraints);
// 117
    panel.add (okButton);
// 118
    panel.add (cancelButton);
// 120
    return panel;
  }
  
  void initGUI (JP.go.ipa.oz.lib.standard._String_if message) throws Exception  {
// 42
    JP.go.ipa.oz.lib.standard._Panel_if msgPanel = null, controlPanel = null;
// 43
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 44
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 46
    msgPanel = mkMessagePanel (message);
// 47
    controlPanel = mkControlPanel ();
// 49
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 50
    setLayout (layout);
// 51
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 52
    constraints.setFill (constraints.getBOTH ());
// 53
    constraints.setGridwidth (constraints.getREMAINDER ());
// 54
    constraints.setWeightx (1.0);
// 55
    layout.setConstraints (msgPanel, constraints);
// 56
    layout.setConstraints (controlPanel, constraints);
// 58
    add (msgPanel);
// 59
    add (controlPanel);
// 60
    pack ();
  }
  
  public void addActionListener (JP.go.ipa.oz.lib.standard._ActionListener_if al) throws Exception  {
    checkSecureInvocation ();
// 32
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) okButton)) {
      try {
        okButton.addActionListener (al);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      okButton.addActionListener (al);
    }
// 33
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cancelButton)) {
      try {
        cancelButton.addActionListener (al);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      cancelButton.addActionListener (al);
    }
  }
  
  public AnswerDialog_cl () throws Exception { super (); }
  
}


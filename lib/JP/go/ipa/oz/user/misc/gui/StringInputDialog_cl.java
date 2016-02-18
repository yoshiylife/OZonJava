package JP.go.ipa.oz.user.misc.gui;

public class StringInputDialog_cl extends JP.go.ipa.oz.user.misc.gui.CenteredDialog_cl implements JP.go.ipa.oz.user.misc.gui.StringInputDialog_if {
  JP.go.ipa.oz.lib.standard._Button_if okButton;
  JP.go.ipa.oz.lib.standard._Button_if cancelButton;
  JP.go.ipa.oz.lib.standard._TextField_if textInputView;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Frame_if parent, JP.go.ipa.oz.lib.standard._String_if title, JP.go.ipa.oz.lib.standard._String_if message, JP.go.ipa.oz.lib.standard._String_if label, int width, boolean modal) throws Exception  {
// 33
    super._new_create (parent, title, modal);
// 34
    initGUI (message, label, width);
    return this;
  }
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Frame_if parent, JP.go.ipa.oz.lib.standard._String_if title, JP.go.ipa.oz.lib.standard._String_if label, int width, boolean modal) throws Exception  {
// 24
    super._new_create (parent, title, modal);
// 25
    initGUI (null, label, width);
    return this;
  }
  
  JP.go.ipa.oz.lib.standard._Panel_if mkControlPanel () throws Exception  {
// 155
    JP.go.ipa.oz.lib.standard._Panel_if controlPanel = null;
// 156
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 157
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 158
    JP.go.ipa.oz.lib.standard._Insets_if insets = null;
// 160
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 161
    controlPanel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout);
// 162
    okButton = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("OK")));
// 163
    cancelButton = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("Cancel")));
// 165
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 166
    constraints.setFill (constraints.getBOTH ());
// 167
    insets = (JP.go.ipa.oz.lib.standard._Insets_cl) (new JP.go.ipa.oz.lib.standard._Insets_cl ())._new_newInsets (10, 20, 10, 20);
// 168
    constraints.setInsets (insets);
// 170
    layout.setConstraints (okButton, constraints);
// 171
    layout.setConstraints (cancelButton, constraints);
// 172
    controlPanel.add (okButton);
// 173
    controlPanel.add (cancelButton);
// 175
    return controlPanel;
  }
  
  public void setString (JP.go.ipa.oz.lib.standard._String_if str) throws Exception  {
    checkSecureInvocation ();
// 70
    clear ();
// 71
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) textInputView)) {
      try {
        textInputView.setText (str);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      textInputView.setText (str);
    }
  }
  
  public void clear () throws Exception  {
    checkSecureInvocation ();
// 52
    JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    
// 52
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) textInputView)) {
      try {
        textInputView.setText (string$0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      textInputView.setText (string$0);
    }
  }
  
  public void addStringInputListener (JP.go.ipa.oz.user.misc.gui.StringInputListener_if listener) throws Exception  {
    checkSecureInvocation ();
// 43
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) listener)) {
      try {
        listener.setDialog (this);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      listener.setDialog (this);
    }
// 44
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) okButton)) {
      try {
        okButton.addActionListener (listener);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      okButton.addActionListener (listener);
    }
// 45
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cancelButton)) {
      try {
        cancelButton.addActionListener (listener);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      cancelButton.addActionListener (listener);
    }
  }
  
  void initGUI (JP.go.ipa.oz.lib.standard._String_if msg, JP.go.ipa.oz.lib.standard._String_if label, int width) throws Exception  {
// 80
    JP.go.ipa.oz.lib.standard._Panel_if msgPanel = null, inputPanel = null, controlPanel = null;
// 81
    JP.go.ipa.oz.lib.standard._Label_if msgLabel = null;
// 82
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 83
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 85
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 86
    setLayout (layout);
// 87
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 88
    constraints.setFill (constraints.getBOTH ());
// 90
    inputPanel = mkInputPanel (msg, label, width);
// 91
    controlPanel = mkControlPanel ();
// 93
    constraints.setGridwidth (constraints.getREMAINDER ());
// 94
    constraints.setWeightx (1.0);
// 95
    layout.setConstraints (inputPanel, constraints);
// 96
    layout.setConstraints (controlPanel, constraints);
// 98
    add (inputPanel);
// 99
    add (controlPanel);
// 100
    pack ();
// 101
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) textInputView)) {
      try {
        textInputView.requestFocus ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      textInputView.requestFocus ();
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getInputString () throws Exception  {
    checkSecureInvocation ();
// 59
    JP.go.ipa.oz.lib.standard._String_if str = null;
// 61
    JP.go.ipa.oz.lib.standard._String_if getText$val$8;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) textInputView)) {
      try {
        getText$val$8 = textInputView.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$8 = textInputView.getText ();
    }
// 61
    str = getText$val$8;
// 63
    return str;
  }
  
  JP.go.ipa.oz.lib.standard._Panel_if mkInputPanel (JP.go.ipa.oz.lib.standard._String_if msg, JP.go.ipa.oz.lib.standard._String_if label, int width) throws Exception  {
// 108
    JP.go.ipa.oz.lib.standard._Panel_if inputPanel = null;
// 109
    JP.go.ipa.oz.lib.standard._Label_if inputLabel = null, msgLabel = null;
// 110
    JP.go.ipa.oz.lib.standard._Insets_if insets = null;
// 111
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 112
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 114
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 115
    inputPanel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout);
// 116
    if (label == null) {{
// 117
        inputLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("")));
      }
    } else {{
// 119
        inputLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel (label);
      }
    }
// 121
    textInputView = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField (width);
// 123
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 124
    constraints.setFill (constraints.getBOTH ());
// 126
    insets = (JP.go.ipa.oz.lib.standard._Insets_cl) (new JP.go.ipa.oz.lib.standard._Insets_cl ())._new_newInsets (10, 10, 5, 10);
// 127
    constraints.setInsets (insets);
// 128
    if (msg != null) {{
// 129
        msgLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel (msg);
// 130
        constraints.setWeightx (1.0);
// 131
        constraints.setGridwidth (constraints.getREMAINDER ());
// 132
        layout.setConstraints (msgLabel, constraints);
// 133
        inputPanel.add (msgLabel);
// 135
        constraints.setWeightx (0.0);
// 136
        constraints.setGridwidth (constraints.getRELATIVE ());
      }
    }
// 139
    insets.set (10, 10, 0, 2);
// 140
    layout.setConstraints (inputLabel, constraints);
// 141
    constraints.setGridwidth (constraints.getREMAINDER ());
// 142
    constraints.setWeightx (1.0);
// 143
    insets.set (10, 2, 0, 10);
// 144
    layout.setConstraints (textInputView, constraints);
// 145
    inputPanel.add (inputLabel);
// 146
    inputPanel.add (textInputView);
// 148
    return inputPanel;
  }
  
  public StringInputDialog_cl () throws Exception { super (); }
  
}


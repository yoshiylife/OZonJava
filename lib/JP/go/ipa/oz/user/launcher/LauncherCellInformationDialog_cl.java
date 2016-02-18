package JP.go.ipa.oz.user.launcher;

public class LauncherCellInformationDialog_cl extends JP.go.ipa.oz.user.misc.gui.CenteredDialog_cl implements JP.go.ipa.oz.user.launcher.LauncherCellInformationDialog_if {
  JP.go.ipa.oz.lib.standard._TextField_if cellCIDView;
  JP.go.ipa.oz.lib.standard._TextField_if cellGODView;
  JP.go.ipa.oz.user.launcher.LauncherCore_if lCore;
  JP.go.ipa.oz.lib.standard._Button_if okButton;
  JP.go.ipa.oz.lib.standard._Button_if importButton;
  JP.go.ipa.oz.user.launcher.GODOperator_if godOp;
  JP.go.ipa.oz.lib.standard._Button_if cancelButton;
  
  public Object _new_create (JP.go.ipa.oz.user.launcher.LauncherCore_if lchr, JP.go.ipa.oz.lib.standard._String_if godPrefix) throws Exception  {
// 28
    JP.go.ipa.oz.lib.standard._Frame_if parent = null;
// 30
    lCore = lchr;
// 31
    JP.go.ipa.oz.lib.standard._Frame_if getGUI$val$20;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lCore)) {
      try {
        getGUI$val$20 = lCore.getGUI ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getGUI$val$20 = lCore.getGUI ();
    }
// 31
    parent = getGUI$val$20;
// 32
    super._new_create (parent, (new JP.go.ipa.oz.lib.standard._String_cl("Cell Information Dialog")), true);
// 33
    initGUI ();
// 35
    if (godPrefix != null) {{
// 36
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cellGODView)) {
          try {
            cellGODView.setText (godPrefix);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          cellGODView.setText (godPrefix);
        }
// 37
        int length$val$21;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) godPrefix)) {
          try {
            length$val$21 = godPrefix.length ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          length$val$21 = godPrefix.length ();
        }
// 37
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cellGODView)) {
          try {
            cellGODView.setCaretPosition (length$val$21);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          cellGODView.setCaretPosition (length$val$21);
        }
      }
    }
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getInputCID () throws Exception  {
    checkSecureInvocation ();
// 47
    JP.go.ipa.oz.lib.standard._String_if getText$val$22;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cellCIDView)) {
      try {
        getText$val$22 = cellCIDView.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$22 = cellCIDView.getText ();
    }
// 47
    return getText$val$22;
  }
  
  void initGUI () throws Exception  {
// 88
    JP.go.ipa.oz.lib.standard._Panel_if inputPanel = null, controlPanel = null;
// 89
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 90
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 92
    inputPanel = mkInputPanel ();
// 93
    controlPanel = mkControlPanel ();
// 95
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 96
    setLayout (layout);
// 97
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 98
    constraints.setFill (constraints.getBOTH ());
// 100
    constraints.setGridwidth (constraints.getREMAINDER ());
// 101
    constraints.setWeightx (1.0);
// 102
    layout.setConstraints (inputPanel, constraints);
// 103
    layout.setConstraints (controlPanel, constraints);
// 105
    add (inputPanel);
// 106
    add (controlPanel);
// 107
    pack ();
  }
  
  public void setCID (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
    checkSecureInvocation ();
// 77
    if (cid != null) {{
// 78
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cellCIDView)) {
          try {
            cellCIDView.setText (cid);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          cellCIDView.setText (cid);
        }
      }
    }
  }
  
  public void setCatalogGOL (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
    checkSecureInvocation ();
// 61
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lCore)) {
      try {
        lCore.setCatalogGOL (gol);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lCore.setCatalogGOL (gol);
    }
  }
  
  JP.go.ipa.oz.lib.standard._Panel_if mkInputPanel () throws Exception  {
// 114
    JP.go.ipa.oz.lib.standard._Panel_if panel = null;
// 115
    JP.go.ipa.oz.lib.standard._Label_if labelGOD = null, labelCID = null;
// 116
    int width = 50;
// 117
    JP.go.ipa.oz.lib.standard._Insets_if insets = null;
// 118
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 119
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 120
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if importEq = null;
// 121
    JP.go.ipa.oz.user.launcher.LauncherImportListener_if importListener = null;
// 124
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 127
    panel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout);
// 128
    labelGOD = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("GOD:")));
// 129
    cellGODView = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField (50);
// 130
    labelCID = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("class ID:")));
// 131
    cellCIDView = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField (50);
// 133
    importEq = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 134
    importListener = (JP.go.ipa.oz.user.launcher.LauncherImportListener_cl) (new JP.go.ipa.oz.user.launcher.LauncherImportListener_cl ())._new_create (lCore, this, importEq);
// 135
    importButton = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("import")));
// 136
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) importButton)) {
      try {
        importButton.addActionListener (importListener);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      importButton.addActionListener (importListener);
    }
// 139
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 140
    constraints.setFill (constraints.getBOTH ());
// 142
    insets = (JP.go.ipa.oz.lib.standard._Insets_cl) (new JP.go.ipa.oz.lib.standard._Insets_cl ())._new_newInsets (5, 10, 0, 2);
// 143
    constraints.setInsets (insets);
// 144
    layout.setConstraints (labelGOD, constraints);
// 145
    layout.setConstraints (labelCID, constraints);
// 147
    constraints.setWeightx (1.0);
// 148
    insets.set (5, 2, 0, 10);
// 149
    constraints.setInsets (insets);
// 150
    layout.setConstraints (cellCIDView, constraints);
// 152
    constraints.setGridwidth (constraints.getREMAINDER ());
// 153
    layout.setConstraints (cellGODView, constraints);
// 155
    constraints.setWeightx (0.0);
// 156
    layout.setConstraints (importButton, constraints);
// 158
    panel.add (labelGOD);
// 159
    panel.add (cellGODView);
// 160
    panel.add (labelCID);
// 161
    panel.add (cellCIDView);
// 162
    panel.add (importButton);
// 164
    return panel;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getInputGOD () throws Exception  {
    checkSecureInvocation ();
// 54
    JP.go.ipa.oz.lib.standard._String_if getText$val$23;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cellGODView)) {
      try {
        getText$val$23 = cellGODView.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$23 = cellGODView.getText ();
    }
// 54
    return getText$val$23;
  }
  
  JP.go.ipa.oz.lib.standard._Panel_if mkControlPanel () throws Exception  {
// 171
    JP.go.ipa.oz.lib.standard._Panel_if panel = null;
// 172
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 173
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 174
    JP.go.ipa.oz.lib.standard._Insets_if insets = null;
// 175
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq = null;
// 176
    JP.go.ipa.oz.user.launcher.LauncherCellInformationListener_if listener = null;
// 179
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 180
    panel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout);
// 181
    okButton = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("OK")));
// 182
    cancelButton = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("Cancel")));
// 183
    eq = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 184
    listener = (JP.go.ipa.oz.user.launcher.LauncherCellInformationListener_cl) (new JP.go.ipa.oz.user.launcher.LauncherCellInformationListener_cl ())._new_create (lCore, this, eq);
// 185
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) okButton)) {
      try {
        okButton.addActionListener (listener);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      okButton.addActionListener (listener);
    }
// 186
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cancelButton)) {
      try {
        cancelButton.addActionListener (listener);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      cancelButton.addActionListener (listener);
    }
// 189
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 190
    constraints.setFill (constraints.getBOTH ());
// 191
    insets = (JP.go.ipa.oz.lib.standard._Insets_cl) (new JP.go.ipa.oz.lib.standard._Insets_cl ())._new_newInsets (10, 20, 10, 20);
// 192
    constraints.setInsets (insets);
// 194
    layout.setConstraints (okButton, constraints);
// 195
    layout.setConstraints (cancelButton, constraints);
// 196
    panel.add (okButton);
// 197
    panel.add (cancelButton);
// 199
    return panel;
  }
  
  public void setGOD (JP.go.ipa.oz.lib.standard._String_if god) throws Exception  {
    checkSecureInvocation ();
// 68
    if (god != null) {{
// 69
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cellGODView)) {
          try {
            cellGODView.setText (god);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          cellGODView.setText (god);
        }
      }
    }
  }
  
  public LauncherCellInformationDialog_cl () throws Exception { super (); }
  
}


package JP.go.ipa.oz.user.ide;

public class SubjectSummaryBrowser_cl extends JP.go.ipa.oz.lib.standard._Frame_cl implements JP.go.ipa.oz.user.ide.SubjectSummaryBrowser_if {
  JP.go.ipa.oz.user.ide.Subject_if targetSubject;
  JP.go.ipa.oz.lib.standard._String_if editTitlePrefix;
  JP.go.ipa.oz.lib.standard._TextField_if nameView;
  JP.go.ipa.oz.user.ide.SubjectGarageBrowser_if sgBrowser;
  JP.go.ipa.oz.lib.standard._String_if browseTitlePrefix;
  JP.go.ipa.oz.user.ide.SubjectSummary_if targetSummary;
  JP.go.ipa.oz.lib.standard._TextArea_if descView;
  boolean asEditor;
  JP.go.ipa.oz.user.ide.SubjectSummaryBrowserMenuBar_if menubar;
  
  public Object _new_createEditor (JP.go.ipa.oz.user.ide.Subject_if sbj, JP.go.ipa.oz.user.ide.SubjectGarageBrowser_if sgb) throws Exception  {
// 57
    super._new_newFrame ((new JP.go.ipa.oz.lib.standard._String_cl("Subject Summary Editor")));
// 58
    sgBrowser = sgb;
// 59
    targetSubject = sbj;
// 60
    asEditor = true;
// 62
    initGUI ();
// 63
    initMenubar ();
// 64
    setVisible (true);
    return this;
  }
  
  public Object _new_create (JP.go.ipa.oz.user.ide.SubjectSummary_if ss, JP.go.ipa.oz.user.ide.SubjectGarageBrowser_if sgb) throws Exception  {
// 43
    super._new_newFrame ((new JP.go.ipa.oz.lib.standard._String_cl("Subject Summary Browser")));
// 44
    sgBrowser = sgb;
// 45
    asEditor = false;
// 46
    initGUI ();
// 47
    initMenubar ();
// 49
    show (ss);
// 50
    setVisible (true);
    return this;
  }
  
  void initGUI () throws Exception  {
// 125
    JP.go.ipa.oz.lib.standard._Panel_if namePanel = null, descPanel = null;
// 126
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 127
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 128
    JP.go.ipa.oz.lib.standard._Insets_if insets = null;
// 130
    browseTitlePrefix = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("Subject Summary Browser - ")));
// 131
    editTitlePrefix = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("Subject Summary Editor")));
// 132
    if (asEditor) {{
// 133
        setTitle (editTitlePrefix);
      }
    } else {{
// 135
        setTitle (browseTitlePrefix);
      }
    }
// 138
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 139
    setLayout (layout);
// 141
    namePanel = mkNamePanel ();
// 142
    descPanel = mkDescPanel ();
// 144
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 145
    insets = (JP.go.ipa.oz.lib.standard._Insets_cl) (new JP.go.ipa.oz.lib.standard._Insets_cl ())._new_newInsets (15, 5, 5, 5);
// 146
    constraints.setInsets (insets);
// 147
    constraints.setFill (constraints.getBOTH ());
// 148
    constraints.setGridwidth (constraints.getREMAINDER ());
// 149
    constraints.setWeightx (1.0);
// 150
    layout.setConstraints (namePanel, constraints);
// 151
    insets.set (5, 5, 15, 5);
// 152
    layout.setConstraints (descPanel, constraints);
// 154
    add (namePanel);
// 155
    add (descPanel);
// 156
    pack ();
  }
  
  public JP.go.ipa.oz.user.garage.Key_if getKey () throws Exception  {
    checkSecureInvocation ();
// 85
    if (targetSummary != null) {{
// 86
        JP.go.ipa.oz.user.garage.Key_if getKey$val$1148;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetSummary)) {
          try {
            getKey$val$1148 = targetSummary.getKey ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getKey$val$1148 = targetSummary.getKey ();
        }
// 86
        return getKey$val$1148;
      }
    } else {{
// 88
        return null;
      }
    }
  }
  
  void initMenubar () throws Exception  {
// 163
    if (asEditor) {{
// 164
        menubar = (JP.go.ipa.oz.user.ide.SubjectSummaryBrowserMenuBar_cl) (new JP.go.ipa.oz.user.ide.SubjectSummaryBrowserMenuBar_cl ())._new_createExportMenu (sgBrowser, this);
      }
    } else {{
// 166
        menubar = (JP.go.ipa.oz.user.ide.SubjectSummaryBrowserMenuBar_cl) (new JP.go.ipa.oz.user.ide.SubjectSummaryBrowserMenuBar_cl ())._new_createBrowseMenu (sgBrowser, this);
      }
    }
// 168
    setMenuBar (menubar);
  }
  
  public JP.go.ipa.oz.user.ide.SubjectSummary_if getSummary () throws Exception  {
    checkSecureInvocation ();
// 96
    return targetSummary;
  }
  
  public void show (JP.go.ipa.oz.user.ide.SubjectSummary_if ss) throws Exception  {
    checkSecureInvocation ();
// 103
    JP.go.ipa.oz.lib.standard._String_if name = null, desc = null;
// 105
    if (ss != null) {{
// 106
        JP.go.ipa.oz.lib.standard._String_if getName$val$1149;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ss)) {
          try {
            getName$val$1149 = ss.getName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getName$val$1149 = ss.getName ();
        }
// 106
        name = getName$val$1149;
// 107
        JP.go.ipa.oz.lib.standard._String_if getDescription$val$1150;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ss)) {
          try {
            getDescription$val$1150 = ss.getDescription ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getDescription$val$1150 = ss.getDescription ();
        }
// 107
        desc = getDescription$val$1150;
        boolean bool$val$31;
        
        bool$val$31 = name != null;
        if (bool$val$31) {
          bool$val$31 = desc != null;
        }
// 108
        if (bool$val$31) {{
// 109
            targetSummary = ss;
// 110
            if (!asEditor) {{
// 111
                JP.go.ipa.oz.lib.standard._String_if concat$val$1151;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) browseTitlePrefix)) {
                  try {
                    concat$val$1151 = browseTitlePrefix.concat (name);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  concat$val$1151 = browseTitlePrefix.concat (name);
                }
// 111
                setTitle (concat$val$1151);
              }
            }
// 113
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nameView)) {
              try {
                nameView.setText (name);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nameView.setText (name);
            }
// 114
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) descView)) {
              try {
                descView.setText (desc);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              descView.setText (desc);
            }
          }
        }
      }
    }
  }
  
  JP.go.ipa.oz.lib.standard._Panel_if mkDescPanel () throws Exception  {
// 202
    JP.go.ipa.oz.lib.standard._Panel_if panel = null;
// 203
    JP.go.ipa.oz.lib.standard._Label_if label = null;
// 204
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 205
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 207
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 209
    panel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout);
// 210
    label = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("description:")));
// 211
    descView = (JP.go.ipa.oz.lib.standard._TextArea_cl) (new JP.go.ipa.oz.lib.standard._TextArea_cl ())._new_newTextArea ();
// 213
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 214
    constraints.setFill (constraints.getBOTH ());
// 215
    constraints.setGridwidth (constraints.getREMAINDER ());
// 216
    constraints.setWeightx (1.0);
// 217
    layout.setConstraints (label, constraints);
// 218
    layout.setConstraints (descView, constraints);
// 219
    panel.add (label);
// 220
    panel.add (descView);
// 222
    return panel;
  }
  
  public JP.go.ipa.oz.user.ide.SubjectSummary_if getInputSummary () throws Exception  {
    checkSecureInvocation ();
// 74
    JP.go.ipa.oz.user.ide.SubjectSummary_if ss = null;
// 76
    JP.go.ipa.oz.lib.standard._String_if getText$val$1152;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nameView)) {
      try {
        getText$val$1152 = nameView.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$1152 = nameView.getText ();
    }
// 76
    JP.go.ipa.oz.lib.standard._String_if getText$val$1153;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) descView)) {
      try {
        getText$val$1153 = descView.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$1153 = descView.getText ();
    }
// 76
    ss = (JP.go.ipa.oz.user.ide.SubjectSummary_cl) (new JP.go.ipa.oz.user.ide.SubjectSummary_cl ())._new_create (getText$val$1152, getText$val$1153);
// 78
    return ss;
  }
  
  JP.go.ipa.oz.lib.standard._Panel_if mkNamePanel () throws Exception  {
// 175
    JP.go.ipa.oz.lib.standard._Panel_if panel = null;
// 176
    JP.go.ipa.oz.lib.standard._Label_if label = null;
// 177
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 178
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 180
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 182
    panel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout);
// 183
    label = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("name:")));
// 184
    nameView = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField ();
// 186
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 187
    constraints.setFill (constraints.getBOTH ());
// 188
    constraints.setGridwidth (constraints.getREMAINDER ());
// 189
    constraints.setWeightx (1.0);
// 190
    layout.setConstraints (label, constraints);
// 191
    layout.setConstraints (nameView, constraints);
// 192
    panel.add (label);
// 193
    panel.add (nameView);
// 195
    return panel;
  }
  
  public SubjectSummaryBrowser_cl () throws Exception { super (); }
  
}


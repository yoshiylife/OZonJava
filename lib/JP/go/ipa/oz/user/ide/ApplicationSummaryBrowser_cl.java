package JP.go.ipa.oz.user.ide;

public class ApplicationSummaryBrowser_cl extends JP.go.ipa.oz.lib.standard._Frame_cl implements JP.go.ipa.oz.user.ide.ApplicationSummaryBrowser_if {
  JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_if gBrowser;
  JP.go.ipa.oz.lib.standard._TextField_if nameView;
  JP.go.ipa.oz.user.ide.Application_if targetComponent;
  JP.go.ipa.oz.user.ide.ApplicationSummary_if targetSummary;
  JP.go.ipa.oz.lib.standard._String_if titlePrefix;
  JP.go.ipa.oz.lib.standard._TextArea_if descView;
  boolean asEditor;
  JP.go.ipa.oz.user.ide.ApplicationSummaryBrowserMenuBar_if menubar;
  
  public Object _new_createEditor (JP.go.ipa.oz.user.ide.Application_if app, JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_if gb) throws Exception  {
// 58
    super._new_newFrame ((new JP.go.ipa.oz.lib.standard._String_cl("Application Summary Editor")));
// 59
    gBrowser = gb;
// 60
    targetComponent = app;
// 61
    asEditor = true;
// 63
    initGUI ();
// 64
    initMenubar ();
// 65
    setVisible (true);
    return this;
  }
  
  public Object _new_create (JP.go.ipa.oz.user.ide.ApplicationSummary_if summary, JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_if gb) throws Exception  {
// 44
    super._new_newFrame ((new JP.go.ipa.oz.lib.standard._String_cl("Application Summary Browser")));
// 45
    gBrowser = gb;
// 46
    asEditor = false;
// 47
    initGUI ();
// 48
    initMenubar ();
// 50
    show (summary);
// 51
    setVisible (true);
    return this;
  }
  
  void initGUI () throws Exception  {
// 126
    JP.go.ipa.oz.lib.standard._Panel_if namePanel = null, descPanel = null;
// 127
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 128
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 129
    JP.go.ipa.oz.lib.standard._Insets_if insets = null;
// 131
    if (asEditor) {{
// 132
        titlePrefix = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("Application Summary Editor")));
      }
    } else {{
// 134
        titlePrefix = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("Application Summary Browser - ")));
      }
    }
// 136
    setTitle (titlePrefix);
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
// 86
    if (targetSummary != null) {{
// 87
        JP.go.ipa.oz.user.garage.Key_if getKey$val$1230;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetSummary)) {
          try {
            getKey$val$1230 = targetSummary.getKey ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getKey$val$1230 = targetSummary.getKey ();
        }
// 87
        return getKey$val$1230;
      }
    } else {{
// 89
        return null;
      }
    }
  }
  
  void initMenubar () throws Exception  {
// 163
    if (asEditor) {{
// 164
        menubar = (JP.go.ipa.oz.user.ide.ApplicationSummaryBrowserMenuBar_cl) (new JP.go.ipa.oz.user.ide.ApplicationSummaryBrowserMenuBar_cl ())._new_createExportMenu (gBrowser, this);
      }
    } else {{
// 166
        menubar = (JP.go.ipa.oz.user.ide.ApplicationSummaryBrowserMenuBar_cl) (new JP.go.ipa.oz.user.ide.ApplicationSummaryBrowserMenuBar_cl ())._new_createBrowseMenu (gBrowser, this);
      }
    }
// 168
    setMenuBar (menubar);
  }
  
  public JP.go.ipa.oz.user.ide.ApplicationSummary_if getSummary () throws Exception  {
    checkSecureInvocation ();
// 97
    return targetSummary;
  }
  
  public void show (JP.go.ipa.oz.user.ide.ApplicationSummary_if summary) throws Exception  {
    checkSecureInvocation ();
// 104
    JP.go.ipa.oz.lib.standard._String_if name = null, desc = null;
// 106
    if (summary != null) {{
// 107
        JP.go.ipa.oz.lib.standard._String_if getName$val$1231;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summary)) {
          try {
            getName$val$1231 = summary.getName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getName$val$1231 = summary.getName ();
        }
// 107
        name = getName$val$1231;
// 108
        JP.go.ipa.oz.lib.standard._String_if getDescription$val$1232;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summary)) {
          try {
            getDescription$val$1232 = summary.getDescription ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getDescription$val$1232 = summary.getDescription ();
        }
// 108
        desc = getDescription$val$1232;
        boolean bool$val$38;
        
        bool$val$38 = name != null;
        if (bool$val$38) {
          bool$val$38 = desc != null;
        }
// 109
        if (bool$val$38) {{
// 110
            targetSummary = summary;
// 111
            if (!asEditor) {{
// 112
                JP.go.ipa.oz.lib.standard._String_if concat$val$1233;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) titlePrefix)) {
                  try {
                    concat$val$1233 = titlePrefix.concat (name);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  concat$val$1233 = titlePrefix.concat (name);
                }
// 112
                setTitle (concat$val$1233);
              }
            }
// 114
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nameView)) {
              try {
                nameView.setText (name);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nameView.setText (name);
            }
// 115
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
// 203
    JP.go.ipa.oz.lib.standard._Panel_if panel = null;
// 204
    JP.go.ipa.oz.lib.standard._Label_if label = null;
// 205
    JP.go.ipa.oz.lib.standard._Insets_if insets = null;
// 206
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 207
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 209
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 211
    panel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout);
// 212
    label = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("description:")));
// 213
    descView = (JP.go.ipa.oz.lib.standard._TextArea_cl) (new JP.go.ipa.oz.lib.standard._TextArea_cl ())._new_newTextArea ();
// 215
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 216
    constraints.setFill (constraints.getBOTH ());
// 217
    constraints.setGridwidth (constraints.getREMAINDER ());
// 218
    constraints.setWeightx (1.0);
// 219
    layout.setConstraints (label, constraints);
// 220
    layout.setConstraints (descView, constraints);
// 221
    panel.add (label);
// 222
    panel.add (descView);
// 224
    return panel;
  }
  
  public JP.go.ipa.oz.user.ide.ApplicationSummary_if getInputSummary () throws Exception  {
    checkSecureInvocation ();
// 75
    JP.go.ipa.oz.user.ide.ApplicationSummary_if app = null;
// 77
    JP.go.ipa.oz.lib.standard._String_if getText$val$1234;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nameView)) {
      try {
        getText$val$1234 = nameView.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$1234 = nameView.getText ();
    }
// 77
    JP.go.ipa.oz.lib.standard._String_if getText$val$1235;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) descView)) {
      try {
        getText$val$1235 = descView.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$1235 = descView.getText ();
    }
// 77
    app = (JP.go.ipa.oz.user.ide.ApplicationSummary_cl) (new JP.go.ipa.oz.user.ide.ApplicationSummary_cl ())._new_create (getText$val$1234, getText$val$1235);
// 79
    return app;
  }
  
  JP.go.ipa.oz.lib.standard._Panel_if mkNamePanel () throws Exception  {
// 175
    JP.go.ipa.oz.lib.standard._Panel_if panel = null;
// 176
    JP.go.ipa.oz.lib.standard._Label_if label = null;
// 177
    JP.go.ipa.oz.lib.standard._Insets_if insets = null;
// 178
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 179
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 181
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 183
    panel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout);
// 184
    label = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("name:")));
// 185
    nameView = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField ();
// 187
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 188
    constraints.setFill (constraints.getBOTH ());
// 189
    constraints.setGridwidth (constraints.getREMAINDER ());
// 190
    constraints.setWeightx (1.0);
// 191
    layout.setConstraints (label, constraints);
// 192
    layout.setConstraints (nameView, constraints);
// 193
    panel.add (label);
// 194
    panel.add (nameView);
// 196
    return panel;
  }
  
  public ApplicationSummaryBrowser_cl () throws Exception { super (); }
  
}


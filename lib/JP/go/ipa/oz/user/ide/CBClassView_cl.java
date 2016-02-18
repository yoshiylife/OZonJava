package JP.go.ipa.oz.user.ide;

final public class CBClassView_cl extends JP.go.ipa.oz.lib.standard._Panel_cl implements JP.go.ipa.oz.user.ide.CBClassView_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.user.ide.CBPartView_if partView;
  JP.go.ipa.oz.lib.standard._TextField_if CIDView;
  JP.go.ipa.oz.lib.standard._List_if ifCIDView;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eventQue;
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.user.ide.CIPart_if targetPart;
  JP.go.ipa.oz.lib.standard._List_if superCIDView;
  JP.go.ipa.oz.user.ide.CIImplementationPart_if targetImplPart;
  JP.go.ipa.oz.user.ide.CIInterfacePart_if targetIfPart;
  boolean isImpl;
  
  public Object _new_newCBClassView (JP.go.ipa.oz.user.ide.CIPart_if part, JP.go.ipa.oz.user.ide.CBPartView_if pv) throws Exception  {
// 36
    super._new_newPanel ();
// 37
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 38
    initParams (part, pv);
// 39
    initGUI ();
    return this;
  }
  
  JP.go.ipa.oz.lib.standard._Panel_if mkModifierPanel () throws Exception  {
// 217
    JP.go.ipa.oz.lib.standard._Panel_if panel = null;
// 218
    JP.go.ipa.oz.lib.standard._Checkbox_if protectedCB = null, cellCB = null, abstractCB = null, finalCB = null;
// 219
    JP.go.ipa.oz.lib.standard._Label_if protectedLabel = null, cellLabel = null, abstractLabel = null, finalLabel = null;
// 220
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 221
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 223
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 224
    panel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout);
// 225
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 226
    constraints.setFill (constraints.getBOTH ());
// 228
    if (isImpl) {{
// 229
        boolean isProtected$val$229;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetImplPart)) {
          try {
            isProtected$val$229 = targetImplPart.isProtected ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isProtected$val$229 = targetImplPart.isProtected ();
        }
// 229
        protectedCB = (JP.go.ipa.oz.lib.standard._Checkbox_cl) (new JP.go.ipa.oz.lib.standard._Checkbox_cl ())._new_newCheckbox ((new JP.go.ipa.oz.lib.standard._String_cl("")), isProtected$val$229);
// 230
        protectedCB.setEnabled (false);
// 231
        protectedLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("protected")));
      }
    }
// 234
    boolean isCell$val$230;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetPart)) {
      try {
        isCell$val$230 = targetPart.isCell ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isCell$val$230 = targetPart.isCell ();
    }
// 234
    cellCB = (JP.go.ipa.oz.lib.standard._Checkbox_cl) (new JP.go.ipa.oz.lib.standard._Checkbox_cl ())._new_newCheckbox ((new JP.go.ipa.oz.lib.standard._String_cl("")), isCell$val$230);
// 235
    cellCB.setEnabled (false);
// 236
    cellLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("cell")));
// 237
    boolean isAbstract$val$231;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetPart)) {
      try {
        isAbstract$val$231 = targetPart.isAbstract ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isAbstract$val$231 = targetPart.isAbstract ();
    }
// 237
    abstractCB = (JP.go.ipa.oz.lib.standard._Checkbox_cl) (new JP.go.ipa.oz.lib.standard._Checkbox_cl ())._new_newCheckbox ((new JP.go.ipa.oz.lib.standard._String_cl("")), isAbstract$val$231);
// 238
    abstractCB.setEnabled (false);
// 239
    abstractLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("abstract")));
// 240
    boolean isFinal$val$232;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetPart)) {
      try {
        isFinal$val$232 = targetPart.isFinal ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isFinal$val$232 = targetPart.isFinal ();
    }
// 240
    finalCB = (JP.go.ipa.oz.lib.standard._Checkbox_cl) (new JP.go.ipa.oz.lib.standard._Checkbox_cl ())._new_newCheckbox ((new JP.go.ipa.oz.lib.standard._String_cl("")), isFinal$val$232);
// 241
    finalCB.setEnabled (false);
// 242
    finalLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("final")));
// 244
    if (isImpl) {{
// 245
        layout.setConstraints (protectedCB, constraints);
      }
    }
// 247
    layout.setConstraints (cellCB, constraints);
// 248
    layout.setConstraints (abstractCB, constraints);
// 249
    layout.setConstraints (finalCB, constraints);
// 251
    constraints.setGridwidth (constraints.getREMAINDER ());
// 252
    if (isImpl) {{
// 253
        layout.setConstraints (protectedLabel, constraints);
      }
    }
// 255
    layout.setConstraints (cellLabel, constraints);
// 256
    layout.setConstraints (abstractLabel, constraints);
// 257
    layout.setConstraints (finalLabel, constraints);
// 259
    if (isImpl) {{
// 260
        panel.add (protectedCB);
// 261
        panel.add (protectedLabel);
      }
    }
// 263
    panel.add (cellCB);
// 264
    panel.add (cellLabel);
// 265
    panel.add (abstractCB);
// 266
    panel.add (abstractLabel);
// 267
    panel.add (finalCB);
// 268
    panel.add (finalLabel);
// 270
    return panel;
  }
  
  void initParams (JP.go.ipa.oz.user.ide.CIPart_if part, JP.go.ipa.oz.user.ide.CBPartView_if pv) throws Exception  {
// 73
    targetPart = part;
// 74
    partView = pv;
// 75
    boolean isInterface$val$233;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetPart)) {
      try {
        isInterface$val$233 = targetPart.isInterface ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isInterface$val$233 = targetPart.isInterface ();
    }
// 75
    isImpl = !(isInterface$val$233);
// 76
    if (isImpl) {{
// 77
        targetImplPart = (JP.go.ipa.oz.user.ide.CIImplementationPart_if) (part);
      }
    } else {{
// 79
        targetIfPart = (JP.go.ipa.oz.user.ide.CIInterfacePart_if) (part);
      }
    }
// 81
    eventQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
  }
  
  JP.go.ipa.oz.lib.standard._Panel_if mkCIDsPanel () throws Exception  {
// 88
    JP.go.ipa.oz.lib.standard._Panel_if panel = null;
// 89
    JP.go.ipa.oz.lib.standard._Label_if CIDLabel = null, ifCIDLabel = null, superCIDLabel = null;
// 90
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 91
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 93
    CIDLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("class ID")));
// 94
    CIDView = mkCIDView ();
// 96
    if (isImpl) {{
// 97
        ifCIDLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("interface class")));
// 98
        ifCIDView = mkIfCIDView ();
// 99
        superCIDLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("super class (cl)")));
      }
    } else {{
// 101
        superCIDLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("super classes (if)")));
      }
    }
// 103
    superCIDView = mkSuperCIDView ();
// 106
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 107
    panel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout);
// 108
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 109
    constraints.setFill (constraints.getBOTH ());
// 112
    layout.setConstraints (CIDLabel, constraints);
// 113
    if (isImpl) {{
// 114
        layout.setConstraints (ifCIDLabel, constraints);
      }
    }
// 116
    layout.setConstraints (superCIDLabel, constraints);
// 119
    constraints.setGridwidth (constraints.getREMAINDER ());
// 120
    constraints.setWeightx (1.0);
// 121
    layout.setConstraints (CIDView, constraints);
// 122
    if (isImpl) {{
// 123
        layout.setConstraints (ifCIDView, constraints);
      }
    }
// 125
    layout.setConstraints (superCIDView, constraints);
// 127
    panel.add (CIDLabel);
// 128
    panel.add (CIDView);
// 129
    if (isImpl) {{
// 130
        panel.add (ifCIDLabel);
// 131
        panel.add (ifCIDView);
      }
    }
// 133
    panel.add (superCIDLabel);
// 134
    panel.add (superCIDView);
// 136
    return panel;
  }
  
  JP.go.ipa.oz.lib.standard._List_if mkSuperCIDView () throws Exception  {
// 183
    JP.go.ipa.oz.lib.standard._List_if view = null;
// 184
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 185
    JP.go.ipa.oz.lib.standard._String_if superCID = null;
// 186
    JP.go.ipa.oz.user.ide.CBClassSelectListener_if listener = null;
// 188
    if (isImpl) {{
// 189
        view = (JP.go.ipa.oz.lib.standard._List_cl) (new JP.go.ipa.oz.lib.standard._List_cl ())._new_newList (1);
// 190
        boolean isRoot$val$234;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetPart)) {
          try {
            isRoot$val$234 = targetPart.isRoot ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isRoot$val$234 = targetPart.isRoot ();
        }
// 190
        if (!(isRoot$val$234)) {{
// 191
            JP.go.ipa.oz.lib.standard._String_if getSuperImplementationCID$val$235;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetImplPart)) {
              try {
                getSuperImplementationCID$val$235 = targetImplPart.getSuperImplementationCID ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getSuperImplementationCID$val$235 = targetImplPart.getSuperImplementationCID ();
            }
// 191
            view.add (getSuperImplementationCID$val$235);
          }
        }
      }
    } else {{
// 195
        view = (JP.go.ipa.oz.lib.standard._List_cl) (new JP.go.ipa.oz.lib.standard._List_cl ())._new_newList (2);
// 196
        boolean isRoot$val$236;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetPart)) {
          try {
            isRoot$val$236 = targetPart.isRoot ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isRoot$val$236 = targetPart.isRoot ();
        }
// 196
        if (!(isRoot$val$236)) {{
// 197
            JP.go.ipa.oz.lib.standard._Iterator_if superInterfaceCIDs$val$237;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetIfPart)) {
              try {
                superInterfaceCIDs$val$237 = targetIfPart.superInterfaceCIDs ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              superInterfaceCIDs$val$237 = targetIfPart.superInterfaceCIDs ();
            }
// 197
            itr = superInterfaceCIDs$val$237;
// 198
            while (true) {
// 198
              boolean hasMoreElements$val$238;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
                try {
                  hasMoreElements$val$238 = itr.hasMoreElements ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                hasMoreElements$val$238 = itr.hasMoreElements ();
              }
              if (!(hasMoreElements$val$238)) break;
              
              /* body */ _loop_1: {
// 199
                JP.go.ipa.oz.lang._Root_if nextElement$val$239;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
                  try {
                    nextElement$val$239 = itr.nextElement ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  nextElement$val$239 = itr.nextElement ();
                }
// 199
                superCID = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$239);
// 200
                view.add (superCID);
              }
            }
          }
        }
      }
    }
// 205
    boolean isRoot$val$240;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetPart)) {
      try {
        isRoot$val$240 = targetPart.isRoot ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRoot$val$240 = targetPart.isRoot ();
    }
// 205
    if (!(isRoot$val$240)) {{
// 206
        listener = (JP.go.ipa.oz.user.ide.CBClassSelectListener_cl) (new JP.go.ipa.oz.user.ide.CBClassSelectListener_cl ())._new_newCBClassSelectListener (partView, view, eventQue);
// 207
        view.addActionListener (listener);
      }
    }
// 210
    return view;
  }
  
  JP.go.ipa.oz.lib.standard._List_if mkIfCIDView () throws Exception  {
// 167
    JP.go.ipa.oz.lib.standard._List_if view = null;
// 168
    JP.go.ipa.oz.user.ide.CBClassSelectListener_if listener = null;
// 170
    view = (JP.go.ipa.oz.lib.standard._List_cl) (new JP.go.ipa.oz.lib.standard._List_cl ())._new_newList (1);
// 171
    JP.go.ipa.oz.lib.standard._String_if getInterfaceCID$val$241;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetImplPart)) {
      try {
        getInterfaceCID$val$241 = targetImplPart.getInterfaceCID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getInterfaceCID$val$241 = targetImplPart.getInterfaceCID ();
    }
// 171
    view.add (getInterfaceCID$val$241);
// 173
    listener = (JP.go.ipa.oz.user.ide.CBClassSelectListener_cl) (new JP.go.ipa.oz.user.ide.CBClassSelectListener_cl ())._new_newCBClassSelectListener (partView, view, eventQue);
// 174
    view.addActionListener (listener);
// 176
    return view;
  }
  
  void initGUI () throws Exception  {
// 48
    JP.go.ipa.oz.lib.standard._Panel_if CIDsPanel = null, modifierPanel = null;
// 49
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 50
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 52
    CIDsPanel = mkCIDsPanel ();
// 53
    modifierPanel = mkModifierPanel ();
// 55
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 56
    setLayout (layout);
// 57
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 58
    constraints.setFill (constraints.getBOTH ());
// 60
    constraints.setWeightx (0.8);
// 61
    layout.setConstraints (CIDsPanel, constraints);
// 62
    constraints.setWeightx (0.2);
// 63
    layout.setConstraints (modifierPanel, constraints);
// 65
    add (CIDsPanel);
// 66
    add (modifierPanel);
  }
  
  JP.go.ipa.oz.lib.standard._TextField_if mkCIDView () throws Exception  {
// 143
    JP.go.ipa.oz.lib.standard._TextField_if view = null;
// 144
    JP.go.ipa.oz.lib.standard._Color_if fg = null, bg = null;
// 145
    JP.go.ipa.oz.lib.standard._Font_if font = null;
// 147
    JP.go.ipa.oz.lib.standard._String_if getCID$val$242;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetPart)) {
      try {
        getCID$val$242 = targetPart.getCID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getCID$val$242 = targetPart.getCID ();
    }
// 147
    view = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField (getCID$val$242);
// 148
    view.setEditable (false);
// 149
    fg = (JP.go.ipa.oz.lib.standard._Color_cl) (new JP.go.ipa.oz.lib.standard._Color_cl ())._new_newColorAsBlue ();
// 150
    bg = (JP.go.ipa.oz.lib.standard._Color_cl) (new JP.go.ipa.oz.lib.standard._Color_cl ())._new_newColorAsWhite ();
// 151
    view.setForeground (fg);
// 152
    view.setBackground (bg);
// 153
    try {
// 154
      font = (JP.go.ipa.oz.lib.standard._Font_cl) (new JP.go.ipa.oz.lib.standard._Font_cl ())._new_newFont ((new JP.go.ipa.oz.lib.standard._String_cl("Helvetica")), 14);
// 155
      view.setFont (font);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_1) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
      if (_oz_exception_1 instanceof JP.go.ipa.oz.lang._Root_if) {
        JP.go.ipa.oz.lang._Root_if ex = (JP.go.ipa.oz.lang._Root_if) _oz_exception_1;
// 157
        ;
      } else throw _exception_1;
    }
// 160
    return view;
  }
  
  public CBClassView_cl () throws Exception { super (); }
  
}


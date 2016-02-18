package JP.go.ipa.oz.user.ide;

final public class CBMemberView_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.CBMemberView_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.user.ide.CBMemberLabel_if modifierView;
  JP.go.ipa.oz.lib.standard._Color_if attributeColor;
  JP.go.ipa.oz.user.ide.CBMemberLabel_if typeView;
  JP.go.ipa.oz.user.ide.School_if targetSchool;
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.lib.standard._Color_if methodColor;
  boolean isSelected;
  JP.go.ipa.oz.user.ide.CIMember_if targetMember;
  JP.go.ipa.oz.user.ide.CBMemberLabel_if argumentTypeView;
  JP.go.ipa.oz.lib.standard._Color_if constructorColor;
  JP.go.ipa.oz.user.ide.CBMemberLabel_if declaringClassView;
  JP.go.ipa.oz.lib.standard._Color_if deselectedFgColor;
  JP.go.ipa.oz.lib.standard._Color_if deselectedBgColor;
  JP.go.ipa.oz.user.ide.CBMemberLabel_if nameView;
  boolean isInherited;
  JP.go.ipa.oz.lib.standard._Color_if selectedFgColor;
  JP.go.ipa.oz.user.ide.CBMemberLabel_if accessLevelView;
  JP.go.ipa.oz.lib.standard._Color_if selectedBgColor;
  
  public Object _new_newCBMemberView (JP.go.ipa.oz.user.ide.CIMember_if m, boolean isInherited, JP.go.ipa.oz.user.ide.School_if s) throws Exception  {
// 57
    initParams (m, isInherited, s);
// 58
    initGUI ();
    return this;
  }
  
  public Object _new_newCBMemberView (JP.go.ipa.oz.user.ide.CIMember_if m, boolean isInherited) throws Exception  {
// 49
    initParams (m, isInherited, null);
// 50
    initGUI ();
    return this;
  }
  
  public Object _new_newCBMemberView (JP.go.ipa.oz.user.ide.CIMember_if m, JP.go.ipa.oz.user.ide.School_if s) throws Exception  {
// 41
    initParams (m, false, s);
// 42
    initGUI ();
    return this;
  }
  
  public Object _new_newCBMemberView (JP.go.ipa.oz.user.ide.CIMember_if m) throws Exception  {
// 33
    initParams (m, false, null);
// 34
    initGUI ();
    return this;
  }
  
  void initParams (JP.go.ipa.oz.user.ide.CIMember_if m, boolean isInherited, JP.go.ipa.oz.user.ide.School_if s) throws Exception  {
// 224
    targetMember = m;
// 225
    targetSchool = s;
// 226
    ((JP.go.ipa.oz.user.ide.CBMemberView_cl)this).isInherited = isInherited;
// 227
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 229
    attributeColor = (JP.go.ipa.oz.lib.standard._Color_cl) (new JP.go.ipa.oz.lib.standard._Color_cl ())._new_newColorAsRed ();
// 230
    constructorColor = (JP.go.ipa.oz.lib.standard._Color_cl) (new JP.go.ipa.oz.lib.standard._Color_cl ())._new_newColorAsMagenta ();
// 231
    methodColor = (JP.go.ipa.oz.lib.standard._Color_cl) (new JP.go.ipa.oz.lib.standard._Color_cl ())._new_newColorAsBlue ();
// 232
    selectedBgColor = (JP.go.ipa.oz.lib.standard._Color_cl) (new JP.go.ipa.oz.lib.standard._Color_cl ())._new_newColor (0, 0, 128);
// 233
    selectedFgColor = (JP.go.ipa.oz.lib.standard._Color_cl) (new JP.go.ipa.oz.lib.standard._Color_cl ())._new_newColorAsWhite ();
// 234
    deselectedBgColor = (JP.go.ipa.oz.lib.standard._Color_cl) (new JP.go.ipa.oz.lib.standard._Color_cl ())._new_newColorAsWhite ();
// 235
    deselectedFgColor = (JP.go.ipa.oz.lib.standard._Color_cl) (new JP.go.ipa.oz.lib.standard._Color_cl ())._new_newColorAsBlack ();
  }
  
  void mkComponents () throws Exception  {
// 162
    JP.go.ipa.oz.lib.standard._String_if strType = null, decPartCID = null, decPartLabel = null;
// 163
    JP.go.ipa.oz.user.ide.CIPart_if decPart = null;
// 164
    JP.go.ipa.oz.lib.standard._StringBuffer_if strArg = null;
// 165
    JP.go.ipa.oz.lib.standard._Color_if fg = null;
// 166
    JP.go.ipa.oz.lib.standard._Font_if font = null;
// 168
    JP.go.ipa.oz.lib.standard._String_if getAccessLevelAsString$val$270;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetMember)) {
      try {
        getAccessLevelAsString$val$270 = targetMember.getAccessLevelAsString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getAccessLevelAsString$val$270 = targetMember.getAccessLevelAsString ();
    }
// 168
    accessLevelView = (JP.go.ipa.oz.user.ide.CBMemberLabel_cl) (new JP.go.ipa.oz.user.ide.CBMemberLabel_cl ())._new_newCBMemberLabel (getAccessLevelAsString$val$270);
// 169
    JP.go.ipa.oz.lib.standard._String_if getModifierAsString$val$271;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetMember)) {
      try {
        getModifierAsString$val$271 = targetMember.getModifierAsString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getModifierAsString$val$271 = targetMember.getModifierAsString ();
    }
// 169
    modifierView = (JP.go.ipa.oz.user.ide.CBMemberLabel_cl) (new JP.go.ipa.oz.user.ide.CBMemberLabel_cl ())._new_newCBMemberLabel (getModifierAsString$val$271);
// 170
    JP.go.ipa.oz.lib.standard._String_if getName$val$272;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetMember)) {
      try {
        getName$val$272 = targetMember.getName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getName$val$272 = targetMember.getName ();
    }
// 170
    nameView = (JP.go.ipa.oz.user.ide.CBMemberLabel_cl) (new JP.go.ipa.oz.user.ide.CBMemberLabel_cl ())._new_newCBMemberLabel (getName$val$272);
// 172
    boolean isAttribute$val$273;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetMember)) {
      try {
        isAttribute$val$273 = targetMember.isAttribute ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isAttribute$val$273 = targetMember.isAttribute ();
    }
// 172
    if (isAttribute$val$273) {{
// 173
        JP.go.ipa.oz.user.ide.CIAttribute_if att = null;
// 174
        att = (JP.go.ipa.oz.user.ide.CIAttribute_if) (targetMember);
// 175
        JP.go.ipa.oz.lib.standard._String_if getTypeAsString$val$274;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) att)) {
          try {
            getTypeAsString$val$274 = att.getTypeAsString (targetSchool);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getTypeAsString$val$274 = att.getTypeAsString (targetSchool);
        }
// 175
        strType = getTypeAsString$val$274;
// 176
        argumentTypeView = (JP.go.ipa.oz.user.ide.CBMemberLabel_cl) (new JP.go.ipa.oz.user.ide.CBMemberLabel_cl ())._new_newCBMemberLabel ((new JP.go.ipa.oz.lib.standard._String_cl("")));
      }
    } else {{
// 178
        JP.go.ipa.oz.user.ide.CIMethod_if method = null;
// 179
        method = (JP.go.ipa.oz.user.ide.CIMethod_if) (targetMember);
// 180
        JP.go.ipa.oz.lib.standard._String_if getReturnTypeAsString$val$275;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) method)) {
          try {
            getReturnTypeAsString$val$275 = method.getReturnTypeAsString (targetSchool);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getReturnTypeAsString$val$275 = method.getReturnTypeAsString (targetSchool);
        }
// 180
        strType = getReturnTypeAsString$val$275;
// 181
        strArg = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 182
        JP.go.ipa.oz.lib.standard._String_if string$50 = (new JP.go.ipa.oz.lib.standard._String_cl("("));
        
// 182
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$276;
        append$val$276 = strArg.append (string$50);
// 183
        JP.go.ipa.oz.lib.standard._String_if getArgumentTypeAsString$val$277;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) method)) {
          try {
            getArgumentTypeAsString$val$277 = method.getArgumentTypeAsString (targetSchool);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getArgumentTypeAsString$val$277 = method.getArgumentTypeAsString (targetSchool);
        }
// 182
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$278;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$276)) {
          try {
            append$val$278 = append$val$276.append (getArgumentTypeAsString$val$277);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$278 = append$val$276.append (getArgumentTypeAsString$val$277);
        }
// 183
        JP.go.ipa.oz.lib.standard._String_if string$51 = (new JP.go.ipa.oz.lib.standard._String_cl(")"));
        
// 182
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$279;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$278)) {
          try {
            append$val$279 = append$val$278.append (string$51);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$279 = append$val$278.append (string$51);
        }
// 184
        argumentTypeView = (JP.go.ipa.oz.user.ide.CBMemberLabel_cl) (new JP.go.ipa.oz.user.ide.CBMemberLabel_cl ())._new_newCBMemberLabel (strArg.asString ());
      }
    }
// 186
    typeView = (JP.go.ipa.oz.user.ide.CBMemberLabel_cl) (new JP.go.ipa.oz.user.ide.CBMemberLabel_cl ())._new_newCBMemberLabel (strType);
// 188
    if (isInherited) {{
// 189
        JP.go.ipa.oz.user.ide.CIPart_if getDeclaringPart$val$280;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetMember)) {
          try {
            getDeclaringPart$val$280 = targetMember.getDeclaringPart ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getDeclaringPart$val$280 = targetMember.getDeclaringPart ();
        }
// 189
        decPart = getDeclaringPart$val$280;
// 190
        JP.go.ipa.oz.lib.standard._String_if getCID$val$281;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) decPart)) {
          try {
            getCID$val$281 = decPart.getCID ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getCID$val$281 = decPart.getCID ();
        }
// 190
        decPartCID = getCID$val$281;
// 191
        if (targetSchool != null) {{
// 192
            boolean isInterface$val$282;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) decPart)) {
              try {
                isInterface$val$282 = decPart.isInterface ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              isInterface$val$282 = decPart.isInterface ();
            }
// 192
            if (isInterface$val$282) {{
// 193
                JP.go.ipa.oz.lib.standard._String_if getNameOfInterface$val$283;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetSchool)) {
                  try {
                    getNameOfInterface$val$283 = targetSchool.getNameOfInterface (decPartCID);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  getNameOfInterface$val$283 = targetSchool.getNameOfInterface (decPartCID);
                }
// 193
                decPartLabel = getNameOfInterface$val$283;
              }
            } else {{
// 195
                JP.go.ipa.oz.lib.standard._String_if getNameOfImplementation$val$284;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetSchool)) {
                  try {
                    getNameOfImplementation$val$284 = targetSchool.getNameOfImplementation (decPartCID);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  getNameOfImplementation$val$284 = targetSchool.getNameOfImplementation (decPartCID);
                }
// 195
                decPartLabel = getNameOfImplementation$val$284;
              }
            }
          }
        } else {{
// 198
            decPartLabel = decPartCID;
          }
        }
// 200
        declaringClassView = (JP.go.ipa.oz.user.ide.CBMemberLabel_cl) (new JP.go.ipa.oz.user.ide.CBMemberLabel_cl ())._new_newCBMemberLabel (decPartLabel);
      }
    } else {{
// 202
        declaringClassView = (JP.go.ipa.oz.user.ide.CBMemberLabel_cl) (new JP.go.ipa.oz.user.ide.CBMemberLabel_cl ())._new_newCBMemberLabel ((new JP.go.ipa.oz.lib.standard._String_cl("*")));
      }
    }
// 205
    if (!isInherited) {{
// 206
        font = (JP.go.ipa.oz.lib.standard._Font_cl) (new JP.go.ipa.oz.lib.standard._Font_cl ())._new_newFontAsBold ((new JP.go.ipa.oz.lib.standard._String_cl("sansserif")), 12);
// 207
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nameView)) {
          try {
            nameView.setFont (font);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nameView.setFont (font);
        }
      }
    }
// 210
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) accessLevelView)) {
      try {
        accessLevelView.setMember (targetMember);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      accessLevelView.setMember (targetMember);
    }
// 211
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) modifierView)) {
      try {
        modifierView.setMember (targetMember);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      modifierView.setMember (targetMember);
    }
// 212
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) typeView)) {
      try {
        typeView.setMember (targetMember);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      typeView.setMember (targetMember);
    }
// 213
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nameView)) {
      try {
        nameView.setMember (targetMember);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nameView.setMember (targetMember);
    }
// 214
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) argumentTypeView)) {
      try {
        argumentTypeView.setMember (targetMember);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      argumentTypeView.setMember (targetMember);
    }
// 215
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) declaringClassView)) {
      try {
        declaringClassView.setMember (targetMember);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      declaringClassView.setMember (targetMember);
    }
// 217
    deselect ();
  }
  
  void initGUI () throws Exception  {
// 155
    mkComponents ();
  }
  
  public void select () throws Exception  {
    checkSecureInvocation ();
// 128
    if (isSelected) {{
// 129
        deselect ();
      }
    } else {{
// 131
        isSelected = true;
// 133
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) accessLevelView)) {
          try {
            accessLevelView.setBackground (selectedBgColor);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          accessLevelView.setBackground (selectedBgColor);
        }
// 134
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) modifierView)) {
          try {
            modifierView.setBackground (selectedBgColor);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          modifierView.setBackground (selectedBgColor);
        }
// 135
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) typeView)) {
          try {
            typeView.setBackground (selectedBgColor);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          typeView.setBackground (selectedBgColor);
        }
// 136
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nameView)) {
          try {
            nameView.setBackground (selectedBgColor);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nameView.setBackground (selectedBgColor);
        }
// 137
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) argumentTypeView)) {
          try {
            argumentTypeView.setBackground (selectedBgColor);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          argumentTypeView.setBackground (selectedBgColor);
        }
// 138
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) declaringClassView)) {
          try {
            declaringClassView.setBackground (selectedBgColor);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          declaringClassView.setBackground (selectedBgColor);
        }
// 140
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) accessLevelView)) {
          try {
            accessLevelView.setForeground (selectedFgColor);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          accessLevelView.setForeground (selectedFgColor);
        }
// 141
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) modifierView)) {
          try {
            modifierView.setForeground (selectedFgColor);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          modifierView.setForeground (selectedFgColor);
        }
// 142
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) typeView)) {
          try {
            typeView.setForeground (selectedFgColor);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          typeView.setForeground (selectedFgColor);
        }
// 143
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nameView)) {
          try {
            nameView.setForeground (selectedFgColor);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nameView.setForeground (selectedFgColor);
        }
// 144
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) argumentTypeView)) {
          try {
            argumentTypeView.setForeground (selectedFgColor);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          argumentTypeView.setForeground (selectedFgColor);
        }
// 145
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) declaringClassView)) {
          try {
            declaringClassView.setForeground (selectedFgColor);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          declaringClassView.setForeground (selectedFgColor);
        }
      }
    }
  }
  
  public JP.go.ipa.oz.user.ide.CIMember_if getMember () throws Exception  {
    checkSecureInvocation ();
// 108
    return targetMember;
  }
  
  public void layoutComponents (JP.go.ipa.oz.lib.standard._Panel_if accPanel, JP.go.ipa.oz.lib.standard._Panel_if modPanel, JP.go.ipa.oz.lib.standard._Panel_if typePanel, JP.go.ipa.oz.lib.standard._Panel_if namePanel, JP.go.ipa.oz.lib.standard._Panel_if argPanel, JP.go.ipa.oz.lib.standard._Panel_if decPanel) throws Exception  {
    checkSecureInvocation ();
// 116
    JP.go.ipa.oz.lib.standard._Component_if add$val$285;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) accPanel)) {
      try {
        add$val$285 = accPanel.add (accessLevelView);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$285 = accPanel.add (accessLevelView);
    }
// 117
    JP.go.ipa.oz.lib.standard._Component_if add$val$286;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) modPanel)) {
      try {
        add$val$286 = modPanel.add (modifierView);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$286 = modPanel.add (modifierView);
    }
// 118
    JP.go.ipa.oz.lib.standard._Component_if add$val$287;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) typePanel)) {
      try {
        add$val$287 = typePanel.add (typeView);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$287 = typePanel.add (typeView);
    }
// 119
    JP.go.ipa.oz.lib.standard._Component_if add$val$288;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) namePanel)) {
      try {
        add$val$288 = namePanel.add (nameView);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$288 = namePanel.add (nameView);
    }
// 120
    JP.go.ipa.oz.lib.standard._Component_if add$val$289;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) argPanel)) {
      try {
        add$val$289 = argPanel.add (argumentTypeView);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$289 = argPanel.add (argumentTypeView);
    }
// 121
    JP.go.ipa.oz.lib.standard._Component_if add$val$290;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) decPanel)) {
      try {
        add$val$290 = decPanel.add (declaringClassView);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$290 = decPanel.add (declaringClassView);
    }
  }
  
  public void addMemberListener (JP.go.ipa.oz.user.ide.CBMemberListener_if listener) throws Exception  {
    checkSecureInvocation ();
// 68
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) accessLevelView)) {
      try {
        accessLevelView.addMouseListener (listener);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      accessLevelView.addMouseListener (listener);
    }
// 69
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) modifierView)) {
      try {
        modifierView.addMouseListener (listener);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      modifierView.addMouseListener (listener);
    }
// 70
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) typeView)) {
      try {
        typeView.addMouseListener (listener);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      typeView.addMouseListener (listener);
    }
// 71
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nameView)) {
      try {
        nameView.addMouseListener (listener);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nameView.addMouseListener (listener);
    }
// 72
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) argumentTypeView)) {
      try {
        argumentTypeView.addMouseListener (listener);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      argumentTypeView.addMouseListener (listener);
    }
// 73
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) declaringClassView)) {
      try {
        declaringClassView.addMouseListener (listener);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      declaringClassView.addMouseListener (listener);
    }
  }
  
  public void deselect () throws Exception  {
    checkSecureInvocation ();
// 80
    isSelected = false;
// 82
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) accessLevelView)) {
      try {
        accessLevelView.setBackground (deselectedBgColor);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      accessLevelView.setBackground (deselectedBgColor);
    }
// 83
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) modifierView)) {
      try {
        modifierView.setBackground (deselectedBgColor);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      modifierView.setBackground (deselectedBgColor);
    }
// 84
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) typeView)) {
      try {
        typeView.setBackground (deselectedBgColor);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      typeView.setBackground (deselectedBgColor);
    }
// 85
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nameView)) {
      try {
        nameView.setBackground (deselectedBgColor);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nameView.setBackground (deselectedBgColor);
    }
// 86
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) argumentTypeView)) {
      try {
        argumentTypeView.setBackground (deselectedBgColor);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      argumentTypeView.setBackground (deselectedBgColor);
    }
// 87
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) declaringClassView)) {
      try {
        declaringClassView.setBackground (deselectedBgColor);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      declaringClassView.setBackground (deselectedBgColor);
    }
// 89
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) accessLevelView)) {
      try {
        accessLevelView.setForeground (deselectedFgColor);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      accessLevelView.setForeground (deselectedFgColor);
    }
// 90
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) modifierView)) {
      try {
        modifierView.setForeground (deselectedFgColor);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      modifierView.setForeground (deselectedFgColor);
    }
// 91
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) typeView)) {
      try {
        typeView.setForeground (deselectedFgColor);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      typeView.setForeground (deselectedFgColor);
    }
// 92
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) argumentTypeView)) {
      try {
        argumentTypeView.setForeground (deselectedFgColor);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      argumentTypeView.setForeground (deselectedFgColor);
    }
// 93
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) declaringClassView)) {
      try {
        declaringClassView.setForeground (deselectedFgColor);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      declaringClassView.setForeground (deselectedFgColor);
    }
// 95
    boolean isAttribute$val$291;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetMember)) {
      try {
        isAttribute$val$291 = targetMember.isAttribute ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isAttribute$val$291 = targetMember.isAttribute ();
    }
// 95
    if (isAttribute$val$291) {{
// 96
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nameView)) {
          try {
            nameView.setForeground (attributeColor);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nameView.setForeground (attributeColor);
        }
      }
    } else {
// 97
      boolean isConstructor$val$292;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetMember)) {
        try {
          isConstructor$val$292 = targetMember.isConstructor ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isConstructor$val$292 = targetMember.isConstructor ();
      }
// 97
      if (isConstructor$val$292) {{
// 98
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nameView)) {
            try {
              nameView.setForeground (constructorColor);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nameView.setForeground (constructorColor);
          }
        }
      } else {{
// 100
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nameView)) {
            try {
              nameView.setForeground (methodColor);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nameView.setForeground (methodColor);
          }
        }
      }
    }
  }
  
  public CBMemberView_cl () throws Exception { super (); }
  
}


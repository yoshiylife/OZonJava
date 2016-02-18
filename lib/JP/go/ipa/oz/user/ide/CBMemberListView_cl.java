package JP.go.ipa.oz.user.ide;

final public class CBMemberListView_cl extends JP.go.ipa.oz.lib.standard._Panel_cl implements JP.go.ipa.oz.user.ide.CBMemberListView_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.user.ide.School_if targetSchool;
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dialogQue;
  JP.go.ipa.oz.lib.standard._Panel_if argumentTypePanel;
  JP.go.ipa.oz.user.ide.CBMethodView_if methodView;
  JP.go.ipa.oz.user.ide.CBPartView_if partView;
  JP.go.ipa.oz.lib.standard._Panel_if accessLevelPanel;
  JP.go.ipa.oz.user.ide.CIImplementationPart_if targetImplPart;
  JP.go.ipa.oz.lib.standard._Panel_if declaringClassPanel;
  JP.go.ipa.oz.lib.standard._Panel_if modifierPanel;
  JP.go.ipa.oz.user.ide.CIInterfacePart_if targetIfPart;
  JP.go.ipa.oz.lib.standard._Label_if titleLabel;
  JP.go.ipa.oz.user.ide.CBMemberView_if selectedView;
  JP.go.ipa.oz.user.ide.CIPart_if targetPart;
  JP.go.ipa.oz.lib.standard._Panel_if namePanel;
  JP.go.ipa.oz.lib.standard._Dictionary_if memberList;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eventQue;
  JP.go.ipa.oz.lib.standard._ScrollPane_if scrollPane;
  JP.go.ipa.oz.lib.standard._Panel_if typePanel;
  JP.go.ipa.oz.user.ide.CBMemberListener_if memberListener;
  boolean isImpl;
  
  public Object _new_newCBIfMemberListView (JP.go.ipa.oz.user.ide.CIPart_if part, JP.go.ipa.oz.lib.standard._Collection_if ancestorPartList, JP.go.ipa.oz.user.ide.CBPartView_if pv) throws Exception  {
// 44
    super._new_newPanel ();
// 45
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 46
    JP.go.ipa.oz.lib.standard._String_if string$52 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCBPartMemberListView#new (if)"));
    
// 46
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.debugPrintln (string$52);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.debugPrintln (string$52);
    }
// 48
    initParams (part, pv);
// 49
    initGUI (ancestorPartList);
    return this;
  }
  
  public Object _new_newCBImplMemberListView (JP.go.ipa.oz.user.ide.CIPart_if part, JP.go.ipa.oz.lib.standard._Collection_if ancestorPartList, JP.go.ipa.oz.user.ide.CBMethodView_if methodView, JP.go.ipa.oz.user.ide.CBPartView_if pv) throws Exception  {
// 57
    super._new_newPanel ();
// 58
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 59
    JP.go.ipa.oz.lib.standard._String_if string$53 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCBPartMemberListView#new (impl)"));
    
// 59
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.debugPrintln (string$53);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.debugPrintln (string$53);
    }
// 61
    initParams (part, pv);
// 62
    ((JP.go.ipa.oz.user.ide.CBMemberListView_cl)this).methodView = methodView;
// 63
    initGUI (ancestorPartList);
    return this;
  }
  
  void initGUI (JP.go.ipa.oz.lib.standard._Collection_if ancestorPartList) throws Exception  {
// 180
    mkMemberComponents ();
// 181
    layoutComponents ();
// 182
    setMembers (ancestorPartList);
  }
  
  void initParams (JP.go.ipa.oz.user.ide.CIPart_if part, JP.go.ipa.oz.user.ide.CBPartView_if pv) throws Exception  {
// 189
    partView = pv;
// 190
    targetPart = part;
// 191
    boolean isInterface$val$293;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
      try {
        isInterface$val$293 = part.isInterface ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isInterface$val$293 = part.isInterface ();
    }
// 191
    isImpl = !(isInterface$val$293);
// 192
    if (isImpl) {{
// 193
        targetImplPart = (JP.go.ipa.oz.user.ide.CIImplementationPart_if) (part);
      }
    } else {{
// 195
        targetIfPart = (JP.go.ipa.oz.user.ide.CIInterfacePart_if) (part);
      }
    }
// 197
    JP.go.ipa.oz.user.ide.ClassBrowser_if getClassBrowser$val$294;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) partView)) {
      try {
        getClassBrowser$val$294 = partView.getClassBrowser ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getClassBrowser$val$294 = partView.getClassBrowser ();
    }
// 197
    JP.go.ipa.oz.user.ide.School_if getSchool$val$295;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getClassBrowser$val$294)) {
      try {
        getSchool$val$295 = getClassBrowser$val$294.getSchool ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchool$val$295 = getClassBrowser$val$294.getSchool ();
    }
// 197
    targetSchool = getSchool$val$295;
// 198
    memberList = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create ();
// 199
    eventQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 200
    dialogQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 201
    memberListener = (JP.go.ipa.oz.user.ide.CBMemberListener_cl) (new JP.go.ipa.oz.user.ide.CBMemberListener_cl ())._new_newCBMemberListener (this, eventQue);
  }
  
  void setMembers (JP.go.ipa.oz.lib.standard._Collection_if ancestorPartList) throws Exception  {
// 343
    JP.go.ipa.oz.lib.standard._Iterator_if partItr = null;
// 344
    JP.go.ipa.oz.user.ide.CIPart_if part = null;
// 346
    setMembersOf (targetPart);
// 348
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$296;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ancestorPartList)) {
      try {
        iterator$val$296 = ancestorPartList.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$296 = ancestorPartList.iterator ();
    }
// 348
    partItr = iterator$val$296;
// 349
    while (true) {
// 349
      boolean hasMoreElements$val$297;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) partItr)) {
        try {
          hasMoreElements$val$297 = partItr.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$297 = partItr.hasMoreElements ();
      }
      if (!(hasMoreElements$val$297)) break;
      
      /* body */ _loop_1: {
// 350
        JP.go.ipa.oz.lang._Root_if nextElement$val$298;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) partItr)) {
          try {
            nextElement$val$298 = partItr.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$298 = partItr.nextElement ();
        }
// 350
        part = (JP.go.ipa.oz.user.ide.CIPart_if) (nextElement$val$298);
// 351
        setMembersOf (part);
      }
    }
  }
  
  public void select (JP.go.ipa.oz.user.ide.CIMember_if member) throws Exception  {
    checkSecureInvocation ();
// 72
    JP.go.ipa.oz.user.ide.CBMemberView_if view = null;
// 73
    JP.go.ipa.oz.user.ide.CIPart_if decPart = null;
// 74
    JP.go.ipa.oz.user.ide.CIType_if type = null;
// 76
    if (member == null) {{
// 77
        JP.go.ipa.oz.lib.standard._String_if string$54 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCBMemberListView#select: null argument"));
        
// 77
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.println (string$54);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.println (string$54);
        }
// 78
        return;
      }
    }
// 81
    JP.go.ipa.oz.lang._Root_if get$val$299;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) memberList)) {
      try {
        get$val$299 = memberList.get (member);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$299 = memberList.get (member);
    }
// 81
    view = (JP.go.ipa.oz.user.ide.CBMemberView_if) (get$val$299);
// 82
    if (view != null) {{
// 83
        if (view == selectedView) {{
// 84
            JP.go.ipa.oz.user.ide.CIPart_if getDeclaringPart$val$300;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) member)) {
              try {
                getDeclaringPart$val$300 = member.getDeclaringPart ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getDeclaringPart$val$300 = member.getDeclaringPart ();
            }
// 84
            decPart = getDeclaringPart$val$300;
// 86
            if (decPart == targetPart) {{
// 87
                boolean isAttribute$val$301;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) member)) {
                  try {
                    isAttribute$val$301 = member.isAttribute ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  isAttribute$val$301 = member.isAttribute ();
                }
// 87
                if (isAttribute$val$301) {{
// 88
                    JP.go.ipa.oz.user.ide.CIAttribute_if att = null;
// 89
                    att = (JP.go.ipa.oz.user.ide.CIAttribute_if) (member);
// 90
                    JP.go.ipa.oz.user.ide.CIType_if getType$val$302;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) att)) {
                      try {
                        getType$val$302 = att.getType ();
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      getType$val$302 = att.getType ();
                    }
// 90
                    type = getType$val$302;
// 92
                    boolean isPrimitive$val$303;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) type)) {
                      try {
                        isPrimitive$val$303 = type.isPrimitive ();
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      isPrimitive$val$303 = type.isPrimitive ();
                    }
// 92
                    if (!(isPrimitive$val$303)) {{
// 93
                        JP.go.ipa.oz.user.ide.CIClassType_if classType = null;
// 94
                        classType = (JP.go.ipa.oz.user.ide.CIClassType_if) (type);
// 95
                        JP.go.ipa.oz.lib.standard._String_if getCID$val$304;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classType)) {
                          try {
                            getCID$val$304 = classType.getCID ();
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          getCID$val$304 = classType.getCID ();
                        }
// 95
                        showPart (getCID$val$304);
                      }
                    }
                  }
                } else {{
// 100
                    if (isImpl) {{
// 101
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) methodView)) {
                          try {
                            methodView.show (member);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          methodView.show (member);
                        }
                      }
                    }
                  }
                }
              }
            } else {{
// 107
                JP.go.ipa.oz.lib.standard._String_if getCID$val$305;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) decPart)) {
                  try {
                    getCID$val$305 = decPart.getCID ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  getCID$val$305 = decPart.getCID ();
                }
// 107
                showPart (getCID$val$305);
              }
            }
          }
        } else {{
// 112
            selectView (view);
          }
        }
      }
    }
  }
  
  void setAttributeListOf (JP.go.ipa.oz.user.ide.CIPart_if part) throws Exception  {
// 295
    JP.go.ipa.oz.user.ide.CIImplementationPart_if implPart = null;
// 296
    JP.go.ipa.oz.user.ide.CIAttribute_if att = null;
// 297
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 298
    JP.go.ipa.oz.user.ide.CBMemberView_if view = null;
// 299
    boolean isInherited = false;
// 301
    boolean isInterface$val$306;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
      try {
        isInterface$val$306 = part.isInterface ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isInterface$val$306 = part.isInterface ();
    }
// 301
    if (!(isInterface$val$306)) {{
// 302
        implPart = (JP.go.ipa.oz.user.ide.CIImplementationPart_if) (part);
// 303
        isInherited = !(part == targetPart);
// 304
        JP.go.ipa.oz.lib.standard._Iterator_if attributes$val$307;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implPart)) {
          try {
            attributes$val$307 = implPart.attributes ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          attributes$val$307 = implPart.attributes ();
        }
// 304
        itr = attributes$val$307;
// 305
        while (true) {
// 305
          boolean hasMoreElements$val$308;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
            try {
              hasMoreElements$val$308 = itr.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$308 = itr.hasMoreElements ();
          }
          if (!(hasMoreElements$val$308)) break;
          
          /* body */ _loop_1: {
// 306
            JP.go.ipa.oz.lang._Root_if nextElement$val$309;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
              try {
                nextElement$val$309 = itr.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$309 = itr.nextElement ();
            }
// 306
            att = (JP.go.ipa.oz.user.ide.CIAttribute_if) (nextElement$val$309);
// 307
            view = (JP.go.ipa.oz.user.ide.CBMemberView_cl) (new JP.go.ipa.oz.user.ide.CBMemberView_cl ())._new_newCBMemberView (att, isInherited, targetSchool);
// 308
            view.layoutComponents (accessLevelPanel, modifierPanel, typePanel, namePanel, argumentTypePanel, declaringClassPanel);
// 311
            view.addMemberListener (memberListener);
// 312
            JP.go.ipa.oz.lib.standard._Dictionary_if put$val$310;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) memberList)) {
              try {
                put$val$310 = memberList.put (att, view);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              put$val$310 = memberList.put (att, view);
            }
          }
        }
      }
    }
  }
  
  void showPart (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
// 430
    JP.go.ipa.oz.user.ide.CBExceptionDialog_if exDialog = null;
// 432
    try {
// 433
      JP.go.ipa.oz.user.ide.ClassBrowser_if getClassBrowser$val$311;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) partView)) {
        try {
          getClassBrowser$val$311 = partView.getClassBrowser ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getClassBrowser$val$311 = partView.getClassBrowser ();
      }
// 433
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getClassBrowser$val$311)) {
        try {
          getClassBrowser$val$311.show (cid);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getClassBrowser$val$311.show (cid);
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_1) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
      if (_oz_exception_1 instanceof JP.go.ipa.oz.user.ide.CIException_if) {
        JP.go.ipa.oz.user.ide.CIException_if ex = (JP.go.ipa.oz.user.ide.CIException_if) _oz_exception_1;
// 435
        JP.go.ipa.oz.lib.standard._String_if asString$val$312;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ex)) {
          try {
            asString$val$312 = ex.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$312 = ex.asString ();
        }
// 435
        exDialog = (JP.go.ipa.oz.user.ide.CBExceptionDialog_cl) (new JP.go.ipa.oz.user.ide.CBExceptionDialog_cl ())._new_newCBExceptionDialog (partView, asString$val$312, dialogQue);
      } else throw _exception_1;
    }
  }
  
  void layoutComponents () throws Exception  {
// 208
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 209
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 211
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 212
    setLayout (layout);
// 213
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 214
    constraints.setFill (constraints.getBOTH ());
// 215
    constraints.setGridwidth (constraints.getREMAINDER ());
// 217
    constraints.setWeightx (1.0);
// 218
    layout.setConstraints (titleLabel, constraints);
// 219
    constraints.setWeighty (1.0);
// 220
    layout.setConstraints (scrollPane, constraints);
// 222
    add (titleLabel);
// 223
    add (scrollPane);
  }
  
  void setMembersOf (JP.go.ipa.oz.user.ide.CIPart_if part) throws Exception  {
// 359
    boolean isInterface$val$313;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
      try {
        isInterface$val$313 = part.isInterface ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isInterface$val$313 = part.isInterface ();
    }
// 359
    if (!(isInterface$val$313)) {{
// 360
        setAttributeListOf (part);
// 361
        setConstructorListOf (part);
      }
    }
// 363
    setMethodListOf (part);
  }
  
  void setConstructorListOf (JP.go.ipa.oz.user.ide.CIPart_if part) throws Exception  {
// 321
    JP.go.ipa.oz.user.ide.CIMethod_if method = null;
// 322
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 323
    JP.go.ipa.oz.user.ide.CBMemberView_if view = null;
    boolean bool$val$11;
    
    bool$val$11 = part == targetPart;
    if (bool$val$11) {
// 325
      boolean isInterface$val$314;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
        try {
          isInterface$val$314 = part.isInterface ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isInterface$val$314 = part.isInterface ();
      }
      bool$val$11 = !(isInterface$val$314);
    }
// 325
    if (bool$val$11) {{
// 326
        JP.go.ipa.oz.lib.standard._Iterator_if constructors$val$315;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetImplPart)) {
          try {
            constructors$val$315 = targetImplPart.constructors ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          constructors$val$315 = targetImplPart.constructors ();
        }
// 326
        itr = constructors$val$315;
// 327
        while (true) {
// 327
          boolean hasMoreElements$val$316;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
            try {
              hasMoreElements$val$316 = itr.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$316 = itr.hasMoreElements ();
          }
          if (!(hasMoreElements$val$316)) break;
          
          /* body */ _loop_1: {
// 328
            JP.go.ipa.oz.lang._Root_if nextElement$val$317;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
              try {
                nextElement$val$317 = itr.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$317 = itr.nextElement ();
            }
// 328
            method = (JP.go.ipa.oz.user.ide.CIMethod_if) (nextElement$val$317);
// 329
            view = (JP.go.ipa.oz.user.ide.CBMemberView_cl) (new JP.go.ipa.oz.user.ide.CBMemberView_cl ())._new_newCBMemberView (method, false, targetSchool);
// 330
            view.layoutComponents (accessLevelPanel, modifierPanel, typePanel, namePanel, argumentTypePanel, declaringClassPanel);
// 333
            view.addMemberListener (memberListener);
// 334
            JP.go.ipa.oz.lib.standard._Dictionary_if put$val$318;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) memberList)) {
              try {
                put$val$318 = memberList.put (method, view);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              put$val$318 = memberList.put (method, view);
            }
          }
        }
      }
    }
  }
  
  void selectView (JP.go.ipa.oz.user.ide.CBMemberView_if view) throws Exception  {
// 284
    if (selectedView != null) {{
// 285
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) selectedView)) {
          try {
            selectedView.deselect ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          selectedView.deselect ();
        }
      }
    }
// 287
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) view)) {
      try {
        view.select ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      view.select ();
    }
// 288
    selectedView = view;
  }
  
  void setMethodListOf (JP.go.ipa.oz.user.ide.CIPart_if part) throws Exception  {
// 370
    JP.go.ipa.oz.user.ide.CIImplementationPart_if implPart = null;
// 371
    JP.go.ipa.oz.user.ide.CIMethod_if method = null;
// 372
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 373
    JP.go.ipa.oz.user.ide.CBMemberView_if view = null;
// 374
    boolean isInherited = false;
// 376
    isInherited = !(part == targetPart);
// 377
    boolean isInterface$val$319;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
      try {
        isInterface$val$319 = part.isInterface ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isInterface$val$319 = part.isInterface ();
    }
// 377
    if (!(isInterface$val$319)) {{
// 378
        implPart = (JP.go.ipa.oz.user.ide.CIImplementationPart_if) (part);
// 379
        JP.go.ipa.oz.lib.standard._Iterator_if publicMethods$val$320;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implPart)) {
          try {
            publicMethods$val$320 = implPart.publicMethods ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          publicMethods$val$320 = implPart.publicMethods ();
        }
// 379
        itr = publicMethods$val$320;
// 380
        while (true) {
// 380
          boolean hasMoreElements$val$321;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
            try {
              hasMoreElements$val$321 = itr.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$321 = itr.hasMoreElements ();
          }
          if (!(hasMoreElements$val$321)) break;
          
          /* body */ _loop_1: {
// 381
            JP.go.ipa.oz.lang._Root_if nextElement$val$322;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
              try {
                nextElement$val$322 = itr.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$322 = itr.nextElement ();
            }
// 381
            method = (JP.go.ipa.oz.user.ide.CIMethod_if) (nextElement$val$322);
// 382
            view = (JP.go.ipa.oz.user.ide.CBMemberView_cl) (new JP.go.ipa.oz.user.ide.CBMemberView_cl ())._new_newCBMemberView (method, isInherited, targetSchool);
// 383
            view.layoutComponents (accessLevelPanel, modifierPanel, typePanel, namePanel, argumentTypePanel, declaringClassPanel);
// 386
            view.addMemberListener (memberListener);
// 387
            JP.go.ipa.oz.lib.standard._Dictionary_if put$val$323;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) memberList)) {
              try {
                put$val$323 = memberList.put (method, view);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              put$val$323 = memberList.put (method, view);
            }
          }
        }
// 390
        JP.go.ipa.oz.lib.standard._Iterator_if protectedMethods$val$324;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implPart)) {
          try {
            protectedMethods$val$324 = implPart.protectedMethods ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          protectedMethods$val$324 = implPart.protectedMethods ();
        }
// 390
        itr = protectedMethods$val$324;
// 391
        while (true) {
// 391
          boolean hasMoreElements$val$325;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
            try {
              hasMoreElements$val$325 = itr.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$325 = itr.hasMoreElements ();
          }
          if (!(hasMoreElements$val$325)) break;
          
          /* body */ _loop_1: {
// 392
            JP.go.ipa.oz.lang._Root_if nextElement$val$326;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
              try {
                nextElement$val$326 = itr.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$326 = itr.nextElement ();
            }
// 392
            method = (JP.go.ipa.oz.user.ide.CIMethod_if) (nextElement$val$326);
// 393
            view = (JP.go.ipa.oz.user.ide.CBMemberView_cl) (new JP.go.ipa.oz.user.ide.CBMemberView_cl ())._new_newCBMemberView (method, isInherited, targetSchool);
// 394
            view.layoutComponents (accessLevelPanel, modifierPanel, typePanel, namePanel, argumentTypePanel, declaringClassPanel);
// 397
            view.addMemberListener (memberListener);
// 398
            JP.go.ipa.oz.lib.standard._Dictionary_if put$val$327;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) memberList)) {
              try {
                put$val$327 = memberList.put (method, view);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              put$val$327 = memberList.put (method, view);
            }
          }
        }
// 401
        JP.go.ipa.oz.lib.standard._Iterator_if privateMethods$val$328;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implPart)) {
          try {
            privateMethods$val$328 = implPart.privateMethods ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          privateMethods$val$328 = implPart.privateMethods ();
        }
// 401
        itr = privateMethods$val$328;
// 402
        while (true) {
// 402
          boolean hasMoreElements$val$329;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
            try {
              hasMoreElements$val$329 = itr.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$329 = itr.hasMoreElements ();
          }
          if (!(hasMoreElements$val$329)) break;
          
          /* body */ _loop_1: {
// 403
            JP.go.ipa.oz.lang._Root_if nextElement$val$330;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
              try {
                nextElement$val$330 = itr.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$330 = itr.nextElement ();
            }
// 403
            method = (JP.go.ipa.oz.user.ide.CIMethod_if) (nextElement$val$330);
// 404
            view = (JP.go.ipa.oz.user.ide.CBMemberView_cl) (new JP.go.ipa.oz.user.ide.CBMemberView_cl ())._new_newCBMemberView (method, isInherited, targetSchool);
// 405
            view.layoutComponents (accessLevelPanel, modifierPanel, typePanel, namePanel, argumentTypePanel, declaringClassPanel);
// 408
            view.addMemberListener (memberListener);
// 409
            JP.go.ipa.oz.lib.standard._Dictionary_if put$val$331;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) memberList)) {
              try {
                put$val$331 = memberList.put (method, view);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              put$val$331 = memberList.put (method, view);
            }
          }
        }
      }
    } else {{
// 413
        JP.go.ipa.oz.lib.standard._Iterator_if methods$val$332;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
          try {
            methods$val$332 = part.methods ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          methods$val$332 = part.methods ();
        }
// 413
        itr = methods$val$332;
// 414
        while (true) {
// 414
          boolean hasMoreElements$val$333;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
            try {
              hasMoreElements$val$333 = itr.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$333 = itr.hasMoreElements ();
          }
          if (!(hasMoreElements$val$333)) break;
          
          /* body */ _loop_1: {
// 415
            JP.go.ipa.oz.lang._Root_if nextElement$val$334;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
              try {
                nextElement$val$334 = itr.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$334 = itr.nextElement ();
            }
// 415
            method = (JP.go.ipa.oz.user.ide.CIMethod_if) (nextElement$val$334);
// 416
            view = (JP.go.ipa.oz.user.ide.CBMemberView_cl) (new JP.go.ipa.oz.user.ide.CBMemberView_cl ())._new_newCBMemberView (method, isInherited, targetSchool);
// 417
            view.layoutComponents (accessLevelPanel, modifierPanel, typePanel, namePanel, argumentTypePanel, declaringClassPanel);
// 420
            view.addMemberListener (memberListener);
// 421
            JP.go.ipa.oz.lib.standard._Dictionary_if put$val$335;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) memberList)) {
              try {
                put$val$335 = memberList.put (method, view);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              put$val$335 = memberList.put (method, view);
            }
          }
        }
      }
    }
  }
  
  void mkMemberComponents () throws Exception  {
// 230
    JP.go.ipa.oz.lib.standard._Panel_if panel = null;
// 231
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout1 = null;
// 232
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 233
    JP.go.ipa.oz.lib.standard._GridLayout_if layout2 = null;
// 234
    JP.go.ipa.oz.lib.standard._Color_if bg = null;
// 236
    titleLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("members")));
// 237
    scrollPane = (JP.go.ipa.oz.lib.standard._ScrollPane_cl) (new JP.go.ipa.oz.lib.standard._ScrollPane_cl ())._new_newScrollPane ();
// 239
    bg = (JP.go.ipa.oz.lib.standard._Color_cl) (new JP.go.ipa.oz.lib.standard._Color_cl ())._new_newColorAsWhite ();
// 241
    layout2 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (0, 1);
// 242
    accessLevelPanel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout2);
// 243
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) accessLevelPanel)) {
      try {
        accessLevelPanel.setBackground (bg);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      accessLevelPanel.setBackground (bg);
    }
// 244
    modifierPanel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout2);
// 245
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) modifierPanel)) {
      try {
        modifierPanel.setBackground (bg);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      modifierPanel.setBackground (bg);
    }
// 246
    typePanel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout2);
// 247
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) typePanel)) {
      try {
        typePanel.setBackground (bg);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      typePanel.setBackground (bg);
    }
// 248
    namePanel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout2);
// 249
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) namePanel)) {
      try {
        namePanel.setBackground (bg);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      namePanel.setBackground (bg);
    }
// 250
    argumentTypePanel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout2);
// 251
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) argumentTypePanel)) {
      try {
        argumentTypePanel.setBackground (bg);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      argumentTypePanel.setBackground (bg);
    }
// 252
    declaringClassPanel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout2);
// 253
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) declaringClassPanel)) {
      try {
        declaringClassPanel.setBackground (bg);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      declaringClassPanel.setBackground (bg);
    }
// 255
    layout1 = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 256
    panel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout1);
// 257
    panel.setBackground (bg);
// 258
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 259
    constraints.setFill (constraints.getBOTH ());
// 261
    layout1.setConstraints (accessLevelPanel, constraints);
// 262
    layout1.setConstraints (modifierPanel, constraints);
// 263
    layout1.setConstraints (typePanel, constraints);
// 264
    layout1.setConstraints (namePanel, constraints);
// 265
    layout1.setConstraints (argumentTypePanel, constraints);
// 266
    constraints.setWeightx (1.0);
// 267
    layout1.setConstraints (declaringClassPanel, constraints);
// 269
    panel.add (accessLevelPanel);
// 270
    panel.add (modifierPanel);
// 271
    panel.add (typePanel);
// 272
    panel.add (namePanel);
// 273
    panel.add (argumentTypePanel);
// 274
    panel.add (declaringClassPanel);
// 276
    JP.go.ipa.oz.lib.standard._Component_if add$val$336;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) scrollPane)) {
      try {
        add$val$336 = scrollPane.add (panel);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$336 = scrollPane.add (panel);
    }
  }
  
  public CBMemberListView_cl () throws Exception { super (); }
  
}


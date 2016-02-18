package JP.go.ipa.oz.user.ide;

final public class CBPartView_cl extends JP.go.ipa.oz.lib.standard._Frame_cl implements JP.go.ipa.oz.user.ide.CBPartView_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.user.ide.CBLocalHierarchyFrame_if hierarchyFrame;
  JP.go.ipa.oz.user.ide.CBMemberListView_if memberListView;
  JP.go.ipa.oz.lib.standard._String_if targetCID;
  JP.go.ipa.oz.lib.standard._Collection_if ancestorPartList;
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.user.ide.CIPart_if targetPart;
  JP.go.ipa.oz.user.ide.CBClassView_if classView;
  JP.go.ipa.oz.user.ide.CIImplementationPart_if targetImplPart;
  JP.go.ipa.oz.user.ide.CBPartViewMenuBar_if menubar;
  JP.go.ipa.oz.user.ide.CIInterfacePart_if targetIfPart;
  JP.go.ipa.oz.user.ide.ClassBrowser_if classBrowser;
  JP.go.ipa.oz.user.ide.CBMethodView_if methodView;
  boolean isImpl;
  JP.go.ipa.oz.lib.standard._Color_if panelColor;
  
  public Object _new_newCBPartView (JP.go.ipa.oz.user.ide.CIPart_if part, JP.go.ipa.oz.lib.standard._Collection_if ancestorPartList, JP.go.ipa.oz.user.ide.ClassBrowser_if cb) throws Exception  {
// 42
    JP.go.ipa.oz.user.ide.School_if school = null;
// 43
    JP.go.ipa.oz.lib.standard._String_if titleStr = null;
// 45
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 46
    initParams (part, ancestorPartList, cb);
// 48
    JP.go.ipa.oz.user.ide.School_if getSchool$val$365;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cb)) {
      try {
        getSchool$val$365 = cb.getSchool ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchool$val$365 = cb.getSchool ();
    }
// 48
    school = getSchool$val$365;
// 49
    if (isImpl) {{
// 50
        JP.go.ipa.oz.lib.standard._String_if getNameOfImplementation$val$366;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
          try {
            getNameOfImplementation$val$366 = school.getNameOfImplementation (targetCID);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getNameOfImplementation$val$366 = school.getNameOfImplementation (targetCID);
        }
// 50
        titleStr = getNameOfImplementation$val$366;
      }
    } else {{
// 52
        JP.go.ipa.oz.lib.standard._String_if getNameOfInterface$val$367;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
          try {
            getNameOfInterface$val$367 = school.getNameOfInterface (targetCID);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getNameOfInterface$val$367 = school.getNameOfInterface (targetCID);
        }
// 52
        titleStr = getNameOfInterface$val$367;
      }
    }
// 54
    if (titleStr == null) {{
// 55
        JP.go.ipa.oz.lib.standard._String_if getCID$val$368;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
          try {
            getCID$val$368 = part.getCID ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getCID$val$368 = part.getCID ();
        }
// 55
        titleStr = getCID$val$368;
      }
    }
// 57
    JP.go.ipa.oz.lib.standard._String_if string$56 = (new JP.go.ipa.oz.lib.standard._String_cl("Class Browser - "));
    
// 57
    JP.go.ipa.oz.lib.standard._String_if concat$val$369;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$56)) {
      try {
        concat$val$369 = string$56.concat (titleStr);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$369 = string$56.concat (titleStr);
    }
// 57
    super._new_newFrame (concat$val$369);
// 59
    initGUI ();
    return this;
  }
  
  void initParams (JP.go.ipa.oz.user.ide.CIPart_if part, JP.go.ipa.oz.lib.standard._Collection_if ancestorPartList, JP.go.ipa.oz.user.ide.ClassBrowser_if cb) throws Exception  {
// 153
    ((JP.go.ipa.oz.user.ide.CBPartView_cl)this).targetPart = part;
// 154
    ((JP.go.ipa.oz.user.ide.CBPartView_cl)this).ancestorPartList = ancestorPartList;
// 155
    ((JP.go.ipa.oz.user.ide.CBPartView_cl)this).classBrowser = cb;
// 156
    JP.go.ipa.oz.lib.standard._String_if getCID$val$370;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
      try {
        getCID$val$370 = part.getCID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getCID$val$370 = part.getCID ();
    }
// 156
    ((JP.go.ipa.oz.user.ide.CBPartView_cl)this).targetCID = getCID$val$370;
// 158
    boolean isInterface$val$371;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
      try {
        isInterface$val$371 = part.isInterface ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isInterface$val$371 = part.isInterface ();
    }
// 158
    ((JP.go.ipa.oz.user.ide.CBPartView_cl)this).isImpl = !(isInterface$val$371);
// 159
    if (isImpl) {{
// 160
        ((JP.go.ipa.oz.user.ide.CBPartView_cl)this).targetImplPart = (JP.go.ipa.oz.user.ide.CIImplementationPart_if) (part);
      }
    } else {{
// 162
        ((JP.go.ipa.oz.user.ide.CBPartView_cl)this).targetIfPart = (JP.go.ipa.oz.user.ide.CIInterfacePart_if) (part);
      }
    }
// 165
    panelColor = (JP.go.ipa.oz.lib.standard._Color_cl) (new JP.go.ipa.oz.lib.standard._Color_cl ())._new_newColor (192, 192, 192);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getCID () throws Exception  {
    checkSecureInvocation ();
// 68
    return targetCID;
  }
  
  void initGUI () throws Exception  {
// 97
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 98
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 99
    JP.go.ipa.oz.lib.standard._Insets_if insets = null;
// 102
    menubar = (JP.go.ipa.oz.user.ide.CBPartViewMenuBar_cl) (new JP.go.ipa.oz.user.ide.CBPartViewMenuBar_cl ())._new_newCBPartFrameMenuBar (this);
// 103
    setMenuBar (menubar);
// 106
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 107
    setLayout (layout);
// 108
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 109
    constraints.setFill (constraints.getBOTH ());
// 110
    constraints.setGridwidth (constraints.getREMAINDER ());
// 111
    constraints.setWeightx (1.0);
// 112
    insets = (JP.go.ipa.oz.lib.standard._Insets_cl) (new JP.go.ipa.oz.lib.standard._Insets_cl ())._new_newInsets (4, 4, 4, 4);
// 113
    constraints.setInsets (insets);
// 116
    classView = (JP.go.ipa.oz.user.ide.CBClassView_cl) (new JP.go.ipa.oz.user.ide.CBClassView_cl ())._new_newCBClassView (targetPart, this);
// 117
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classView)) {
      try {
        classView.setBackground (panelColor);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      classView.setBackground (panelColor);
    }
// 118
    layout.setConstraints (classView, constraints);
// 122
    if (isImpl) {{
// 123
        methodView = (JP.go.ipa.oz.user.ide.CBMethodView_cl) (new JP.go.ipa.oz.user.ide.CBMethodView_cl ())._new_newCBMethodView (targetPart, this);
// 124
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) methodView)) {
          try {
            methodView.setBackground (panelColor);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          methodView.setBackground (panelColor);
        }
// 125
        constraints.setWeighty (0.2);
// 126
        layout.setConstraints (methodView, constraints);
// 127
        memberListView = (JP.go.ipa.oz.user.ide.CBMemberListView_cl) (new JP.go.ipa.oz.user.ide.CBMemberListView_cl ())._new_newCBImplMemberListView (targetPart, ancestorPartList, methodView, this);
// 129
        constraints.setWeighty (0.8);
      }
    } else {{
// 131
        memberListView = (JP.go.ipa.oz.user.ide.CBMemberListView_cl) (new JP.go.ipa.oz.user.ide.CBMemberListView_cl ())._new_newCBIfMemberListView (targetPart, ancestorPartList, this);
// 133
        constraints.setWeighty (1.0);
      }
    }
// 135
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) memberListView)) {
      try {
        memberListView.setBackground (panelColor);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      memberListView.setBackground (panelColor);
    }
// 136
    layout.setConstraints (memberListView, constraints);
// 139
    add (classView);
// 140
    add (memberListView);
// 141
    if (isImpl) {{
// 142
        add (methodView);
      }
    }
// 144
    pack ();
// 145
    show ();
  }
  
  public void showLocalHierarchy () throws Exception  {
    checkSecureInvocation ();
// 82
    JP.go.ipa.oz.user.ide.CBIGraph_if g = null;
// 84
    if (hierarchyFrame == null) {{
// 85
        g = mkLocalHierarchyGraph ();
// 86
        hierarchyFrame = (JP.go.ipa.oz.user.ide.CBLocalHierarchyFrame_cl) (new JP.go.ipa.oz.user.ide.CBLocalHierarchyFrame_cl ())._new_newCBLocalHierarchyFrame (this, g);
      }
    }
// 88
    hierarchyFrame.setVisible (true);
  }
  
  JP.go.ipa.oz.user.ide.CBIGraph_if mkLocalHierarchyGraph () throws Exception  {
// 172
    JP.go.ipa.oz.user.ide.CBIGraph_if graph = null;
// 173
    JP.go.ipa.oz.user.ide.CIPart_if part = null;
// 174
    JP.go.ipa.oz.lib.standard._Set_if baseParts = null, nextBaseParts = null;
// 175
    JP.go.ipa.oz.lib.standard._Collection_if superPartList = null;
// 176
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 178
    graph = (JP.go.ipa.oz.user.ide.CBIGraph_cl) (new JP.go.ipa.oz.user.ide.CBIGraph_cl ())._new_newCBIGraph (targetPart);
// 179
    baseParts = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create ();
// 180
    baseParts.add (targetPart);
// 181
    while (true) {
      if (!(!(baseParts.isEmpty ()))) break;
      
      /* body */ _loop_1: {
// 182
        nextBaseParts = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create ();
// 183
        itr = baseParts.iterator ();
// 184
        while (true) {
// 184
          boolean hasMoreElements$val$372;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
            try {
              hasMoreElements$val$372 = itr.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$372 = itr.hasMoreElements ();
          }
          if (!(hasMoreElements$val$372)) break;
          
          /* body */ _loop_2: {
// 185
            JP.go.ipa.oz.lang._Root_if nextElement$val$373;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
              try {
                nextElement$val$373 = itr.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$373 = itr.nextElement ();
            }
// 185
            part = (JP.go.ipa.oz.user.ide.CIPart_if) (nextElement$val$373);
// 186
            JP.go.ipa.oz.lib.standard._Collection_if getSuperPartsOf$val$374;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classBrowser)) {
              try {
                getSuperPartsOf$val$374 = classBrowser.getSuperPartsOf (part);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getSuperPartsOf$val$374 = classBrowser.getSuperPartsOf (part);
            }
// 186
            superPartList = getSuperPartsOf$val$374;
// 187
            graph.addPart (part, superPartList);
// 188
            nextBaseParts = nextBaseParts.union (superPartList);
          }
        }
// 190
        baseParts = nextBaseParts;
      }
    }
// 193
    return graph;
  }
  
  public JP.go.ipa.oz.user.ide.ClassBrowser_if getClassBrowser () throws Exception  {
    checkSecureInvocation ();
// 75
    return classBrowser;
  }
  
  public CBPartView_cl () throws Exception { super (); }
  
}


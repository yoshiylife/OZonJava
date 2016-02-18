package JP.go.ipa.oz.user.ide;

final public class CBMethodView_cl extends JP.go.ipa.oz.lib.standard._Panel_cl implements JP.go.ipa.oz.user.ide.CBMethodView_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.lib.standard._List_if signatureView;
  JP.go.ipa.oz.lib.standard._Label_if instantiatingClassLabel;
  JP.go.ipa.oz.lib.standard._Label_if titleLabel;
  JP.go.ipa.oz.user.ide.CBPartView_if partView;
  JP.go.ipa.oz.user.ide.School_if targetSchool;
  JP.go.ipa.oz.lib.standard._TextArea_if codeView;
  JP.go.ipa.oz.lib.standard._Label_if signatureLabel;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eventQue;
  JP.go.ipa.oz.user.ide.CBClassList_if instantiatingClassView;
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.user.ide.CIImplementationPart_if targetPart;
  JP.go.ipa.oz.lib.standard._Label_if referingClassLabel;
  JP.go.ipa.oz.lib.standard._Label_if codeLabel;
  JP.go.ipa.oz.user.ide.CBClassList_if referingClassView;
  
  public Object _new_newCBMethodView (JP.go.ipa.oz.user.ide.CIPart_if part, JP.go.ipa.oz.user.ide.CBPartView_if pv) throws Exception  {
// 36
    super._new_newPanel ();
// 38
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 39
    partView = pv;
// 40
    targetPart = (JP.go.ipa.oz.user.ide.CIImplementationPart_if) (part);
// 41
    JP.go.ipa.oz.user.ide.ClassBrowser_if getClassBrowser$val$254;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) partView)) {
      try {
        getClassBrowser$val$254 = partView.getClassBrowser ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getClassBrowser$val$254 = partView.getClassBrowser ();
    }
// 41
    JP.go.ipa.oz.user.ide.School_if getSchool$val$255;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getClassBrowser$val$254)) {
      try {
        getSchool$val$255 = getClassBrowser$val$254.getSchool ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchool$val$255 = getClassBrowser$val$254.getSchool ();
    }
// 41
    targetSchool = getSchool$val$255;
// 42
    eventQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 43
    initGUI ();
    return this;
  }
  
  void layoutComponents () throws Exception  {
// 111
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null, sigLayout = null;
// 112
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null, sigConstraints = null;
// 113
    JP.go.ipa.oz.lib.standard._Panel_if sigPanel = null;
// 114
    int remainder = 0;
// 117
    sigLayout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 118
    sigPanel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (sigLayout);
// 119
    sigConstraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 120
    sigConstraints.setFill (sigConstraints.getBOTH ());
// 121
    sigLayout.setConstraints (signatureLabel, sigConstraints);
// 122
    remainder = sigConstraints.getREMAINDER ();
// 123
    sigConstraints.setGridwidth (remainder);
// 124
    sigConstraints.setWeightx (1.0);
// 125
    sigLayout.setConstraints (signatureView, sigConstraints);
// 126
    sigPanel.add (signatureLabel);
// 127
    sigPanel.add (signatureView);
// 130
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 131
    setLayout (layout);
// 132
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 133
    constraints.setFill (constraints.getBOTH ());
// 136
    constraints.setWeightx (0.5);
// 137
    layout.setConstraints (referingClassLabel, constraints);
// 139
    layout.setConstraints (referingClassView, constraints);
// 143
    constraints.setGridwidth (constraints.getREMAINDER ());
// 144
    layout.setConstraints (instantiatingClassLabel, constraints);
// 146
    layout.setConstraints (instantiatingClassView, constraints);
// 149
    constraints.setWeightx (1.0);
// 150
    layout.setConstraints (sigPanel, constraints);
// 151
    layout.setConstraints (titleLabel, constraints);
// 152
    layout.setConstraints (codeLabel, constraints);
// 154
    constraints.setWeighty (1.0);
// 155
    layout.setConstraints (codeView, constraints);
// 157
    add (titleLabel);
// 158
    add (sigPanel);
// 159
    add (referingClassLabel);
// 160
    add (instantiatingClassLabel);
// 161
    add (referingClassView);
// 162
    add (instantiatingClassView);
// 163
    add (codeLabel);
// 164
    add (codeView);
  }
  
  public void show (JP.go.ipa.oz.user.ide.CIMember_if member) throws Exception  {
    checkSecureInvocation ();
// 52
    JP.go.ipa.oz.user.ide.CIMethodImplementation_if method = null;
// 54
    boolean isAttribute$val$256;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) member)) {
      try {
        isAttribute$val$256 = member.isAttribute ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isAttribute$val$256 = member.isAttribute ();
    }
// 54
    if (!(isAttribute$val$256)) {{
// 55
        clear ();
// 56
        method = (JP.go.ipa.oz.user.ide.CIMethodImplementation_if) (member);
// 57
        showMethodImplementation (method);
      }
    }
  }
  
  void clear () throws Exception  {
// 67
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) signatureView)) {
      try {
        signatureView.removeAll ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      signatureView.removeAll ();
    }
// 71
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) referingClassView)) {
      try {
        referingClassView.removeAll ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      referingClassView.removeAll ();
    }
// 72
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) instantiatingClassView)) {
      try {
        instantiatingClassView.removeAll ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      instantiatingClassView.removeAll ();
    }
// 73
    JP.go.ipa.oz.lib.standard._String_if string$45 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    
// 73
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) codeView)) {
      try {
        codeView.setText (string$45);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      codeView.setText (string$45);
    }
  }
  
  void initGUI () throws Exception  {
// 80
    JP.go.ipa.oz.user.ide.CIMethodImplementation_if method = null;
// 81
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 82
    JP.go.ipa.oz.user.ide.CBClassSelectListener_if refListener = null, insListener = null;
// 83
    JP.go.ipa.oz.lib.standard._Color_if bg = null;
// 85
    titleLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("method/constructor details")));
// 86
    signatureLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("signature")));
// 87
    referingClassLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("referring classes")));
// 88
    instantiatingClassLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("instantiating classes")));
// 89
    codeLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("pseudo code")));
// 91
    signatureView = (JP.go.ipa.oz.lib.standard._List_cl) (new JP.go.ipa.oz.lib.standard._List_cl ())._new_newList (1);
// 96
    codeView = (JP.go.ipa.oz.lib.standard._TextArea_cl) (new JP.go.ipa.oz.lib.standard._TextArea_cl ())._new_newTextArea ();
// 97
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) codeView)) {
      try {
        codeView.setEditable (false);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      codeView.setEditable (false);
    }
// 98
    bg = (JP.go.ipa.oz.lib.standard._Color_cl) (new JP.go.ipa.oz.lib.standard._Color_cl ())._new_newColorAsWhite ();
// 99
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) codeView)) {
      try {
        codeView.setBackground (bg);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      codeView.setBackground (bg);
    }
// 101
    referingClassView = (JP.go.ipa.oz.user.ide.CBClassList_cl) (new JP.go.ipa.oz.user.ide.CBClassList_cl ())._new_newCBClassList (4, partView);
// 102
    instantiatingClassView = (JP.go.ipa.oz.user.ide.CBClassList_cl) (new JP.go.ipa.oz.user.ide.CBClassList_cl ())._new_newCBClassList (4, partView);
// 104
    layoutComponents ();
  }
  
  void showMethodImplementation (JP.go.ipa.oz.user.ide.CIMethodImplementation_if method) throws Exception  {
// 171
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 172
    JP.go.ipa.oz.lib.standard._String_if cid = null;
// 173
    JP.go.ipa.oz.lib.standard._Array_if cidList = null;
// 174
    int size = 0, i = 0;
// 177
    boolean isConstructor$val$257;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) method)) {
      try {
        isConstructor$val$257 = method.isConstructor ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isConstructor$val$257 = method.isConstructor ();
    }
// 177
    if (isConstructor$val$257) {{
// 178
        JP.go.ipa.oz.lib.standard._String_if string$46 = (new JP.go.ipa.oz.lib.standard._String_cl("constructor details"));
        
// 178
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) titleLabel)) {
          try {
            titleLabel.setText (string$46);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          titleLabel.setText (string$46);
        }
      }
    } else {{
// 180
        JP.go.ipa.oz.lib.standard._String_if string$47 = (new JP.go.ipa.oz.lib.standard._String_cl("method details"));
        
// 180
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) titleLabel)) {
          try {
            titleLabel.setText (string$47);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          titleLabel.setText (string$47);
        }
      }
    }
// 182
    JP.go.ipa.oz.lib.standard._String_if asString$val$258;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) method)) {
      try {
        asString$val$258 = method.asString (targetSchool);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$258 = method.asString (targetSchool);
    }
// 182
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) signatureView)) {
      try {
        signatureView.add (asString$val$258);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      signatureView.add (asString$val$258);
    }
// 188
    int getReferingCIDCount$val$259;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) method)) {
      try {
        getReferingCIDCount$val$259 = method.getReferingCIDCount ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getReferingCIDCount$val$259 = method.getReferingCIDCount ();
    }
// 188
    size = getReferingCIDCount$val$259;
// 189
    cidList = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (size);
// 190
    JP.go.ipa.oz.lib.standard._Iterator_if referingCIDs$val$260;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) method)) {
      try {
        referingCIDs$val$260 = method.referingCIDs ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      referingCIDs$val$260 = method.referingCIDs ();
    }
// 190
    itr = referingCIDs$val$260;
// 191
    /* for loop starting here */ {
      /* initialization part */
// 191
      i = 0;
      
      for (;;) {
        /* boolean expression part */
// 191
        boolean hasMoreElements$val$261;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
          try {
            hasMoreElements$val$261 = itr.hasMoreElements ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          hasMoreElements$val$261 = itr.hasMoreElements ();
        }
        if (!(hasMoreElements$val$261)) break;
        
        /* body */ _loop_1: {
// 192
          JP.go.ipa.oz.lang._Root_if nextElement$val$262;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
            try {
              nextElement$val$262 = itr.nextElement ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nextElement$val$262 = itr.nextElement ();
          }
// 192
          cid = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$262);
// 193
          cidList.putAt (i, cid);
        }
        /* iteration part */
// 191
        i++;
      }
    }
// 195
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) referingClassView)) {
      try {
        referingClassView.setInterfaceList (cidList, targetSchool);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      referingClassView.setInterfaceList (cidList, targetSchool);
    }
// 198
    int getInstantiatingCIDCount$val$263;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) method)) {
      try {
        getInstantiatingCIDCount$val$263 = method.getInstantiatingCIDCount ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getInstantiatingCIDCount$val$263 = method.getInstantiatingCIDCount ();
    }
// 198
    size = getInstantiatingCIDCount$val$263;
// 199
    cidList = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (size);
// 200
    JP.go.ipa.oz.lib.standard._Iterator_if instantiatingCIDs$val$264;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) method)) {
      try {
        instantiatingCIDs$val$264 = method.instantiatingCIDs ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      instantiatingCIDs$val$264 = method.instantiatingCIDs ();
    }
// 200
    itr = instantiatingCIDs$val$264;
// 201
    /* for loop starting here */ {
      /* initialization part */
// 201
      i = 0;
      
      for (;;) {
        /* boolean expression part */
// 201
        boolean hasMoreElements$val$265;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
          try {
            hasMoreElements$val$265 = itr.hasMoreElements ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          hasMoreElements$val$265 = itr.hasMoreElements ();
        }
        if (!(hasMoreElements$val$265)) break;
        
        /* body */ _loop_1: {
// 202
          JP.go.ipa.oz.lang._Root_if nextElement$val$266;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
            try {
              nextElement$val$266 = itr.nextElement ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nextElement$val$266 = itr.nextElement ();
          }
// 202
          cid = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$266);
// 203
          cidList.putAt (i, cid);
        }
        /* iteration part */
// 201
        i++;
      }
    }
// 205
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) instantiatingClassView)) {
      try {
        instantiatingClassView.setImplementationList (cidList, targetSchool);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      instantiatingClassView.setImplementationList (cidList, targetSchool);
    }
// 208
    JP.go.ipa.oz.lib.standard._String_if getCode$val$267;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) method)) {
      try {
        getCode$val$267 = method.getCode ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getCode$val$267 = method.getCode ();
    }
// 208
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) codeView)) {
      try {
        codeView.setText (getCode$val$267);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      codeView.setText (getCode$val$267);
    }
  }
  
  public CBMethodView_cl () throws Exception { super (); }
  
}


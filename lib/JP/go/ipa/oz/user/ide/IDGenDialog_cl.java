package JP.go.ipa.oz.user.ide;

public class IDGenDialog_cl extends JP.go.ipa.oz.lib.standard._Dialog_cl implements JP.go.ipa.oz.user.ide.IDGenDialog_if {
  JP.go.ipa.oz.lib.standard._CheckboxGroup_if group;
  JP.go.ipa.oz.lib.standard._Checkbox_if rbtnSelected;
  JP.go.ipa.oz.user.ide.IDGenActionListener_if genAL;
  JP.go.ipa.oz.lib.standard._Button_if btnOK;
  JP.go.ipa.oz.lib.standard._Label_if lblComment;
  JP.go.ipa.oz.user.ide.IDGenItemListener_if genIL;
  JP.go.ipa.oz.lib.standard._TextField_if txtIfHead;
  JP.go.ipa.oz.lib.standard._Choice_if choSubject;
  JP.go.ipa.oz.lib.standard._Label_if lblHead;
  JP.go.ipa.oz.user.ide.School_if school;
  JP.go.ipa.oz.lib.standard._Label_if lblImplID;
  JP.go.ipa.oz.lib.standard._TextField_if txtImpleHead;
  JP.go.ipa.oz.user.ide.OzLabel_if label;
  JP.go.ipa.oz.user.ide.SchoolBrowser_if schoolBrowser;
  JP.go.ipa.oz.user.ide.ClassIDGenerator_if idGen;
  JP.go.ipa.oz.lib.standard._Checkbox_if rbtnSubject;
  JP.go.ipa.oz.lib.standard._Button_if btnCancel;
  JP.go.ipa.oz.lib.standard._Array_if ruleOfImplementationID;
  JP.go.ipa.oz.lib.standard._Array_if ruleOfInterfaceID;
  JP.go.ipa.oz.lib.standard._Label_if lblIfID;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Frame_if parent, boolean modal, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if queue) throws Exception  {
// 46
    super._new_newDialog (parent, modal);
// 48
    schoolBrowser = (JP.go.ipa.oz.user.ide.SchoolBrowser_if) (parent);
// 49
    JP.go.ipa.oz.user.ide.School_if getSchool$val$848;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
      try {
        getSchool$val$848 = schoolBrowser.getSchool ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchool$val$848 = schoolBrowser.getSchool ();
    }
// 49
    school = getSchool$val$848;
// 50
    idGen = (JP.go.ipa.oz.user.ide.ClassIDGenerator_cl) (new JP.go.ipa.oz.user.ide.ClassIDGenerator_cl ())._new_create ();
// 50
    ;
// 51
    JP.go.ipa.oz.lib.standard._List_if getLstLabel$val$849;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
      try {
        getLstLabel$val$849 = schoolBrowser.getLstLabel ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getLstLabel$val$849 = schoolBrowser.getLstLabel ();
    }
// 51
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$850;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getLstLabel$val$849)) {
      try {
        getSelectedItem$val$850 = getLstLabel$val$849.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$850 = getLstLabel$val$849.getSelectedItem ();
    }
// 51
    if (getSelectedItem$val$850 != null) {
// 52
      JP.go.ipa.oz.lib.standard._List_if getLstLabel$val$851;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
        try {
          getLstLabel$val$851 = schoolBrowser.getLstLabel ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getLstLabel$val$851 = schoolBrowser.getLstLabel ();
      }
// 52
      JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$852;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getLstLabel$val$851)) {
        try {
          getSelectedItem$val$852 = getLstLabel$val$851.getSelectedItem ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getSelectedItem$val$852 = getLstLabel$val$851.getSelectedItem ();
      }
// 52
      JP.go.ipa.oz.user.ide.OzLabel_if getOzLabel$val$853;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
        try {
          getOzLabel$val$853 = school.getOzLabel (getSelectedItem$val$852);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getOzLabel$val$853 = school.getOzLabel (getSelectedItem$val$852);
      }
// 52
      label = getOzLabel$val$853;
    } else {
// 54
      label = null;
    }
// 55
    ruleOfInterfaceID = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (2);
// 56
    ruleOfImplementationID = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (2);
// 59
    JP.go.ipa.oz.lib.standard._GridLayout_if grid1 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (8, 1);
// 60
    setLayout (grid1);
// 61
    addNotify ();
// 62
    setSize (400, 250);
// 63
    JP.go.ipa.oz.lib.standard._Font_if font = (JP.go.ipa.oz.lib.standard._Font_cl) (new JP.go.ipa.oz.lib.standard._Font_cl ())._new_newFont ((new JP.go.ipa.oz.lib.standard._String_cl("TimesRoman")), 12);
// 64
    group = (JP.go.ipa.oz.lib.standard._CheckboxGroup_cl) (new JP.go.ipa.oz.lib.standard._CheckboxGroup_cl ())._new_newCheckboxGroup ();
// 65
    rbtnSelected = (JP.go.ipa.oz.lib.standard._Checkbox_cl) (new JP.go.ipa.oz.lib.standard._Checkbox_cl ())._new_newCheckbox ((new JP.go.ipa.oz.lib.standard._String_cl("generate the ID for selected Labels.")), group, true);
// 66
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rbtnSelected)) {
      try {
        rbtnSelected.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      rbtnSelected.setFont (font);
    }
// 67
    add (rbtnSelected);
// 68
    rbtnSubject = (JP.go.ipa.oz.lib.standard._Checkbox_cl) (new JP.go.ipa.oz.lib.standard._Checkbox_cl ())._new_newCheckbox ((new JP.go.ipa.oz.lib.standard._String_cl("generate the ID for Labaels belonging to the same Subject.")), group, false);
// 69
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rbtnSubject)) {
      try {
        rbtnSubject.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      rbtnSubject.setFont (font);
    }
// 70
    add (rbtnSubject);
// 71
    choSubject = (JP.go.ipa.oz.lib.standard._Choice_cl) (new JP.go.ipa.oz.lib.standard._Choice_cl ())._new_newChoice ();
// 72
    JP.go.ipa.oz.lib.standard._Iterator_if lblIterator = null;
// 73
    JP.go.ipa.oz.lib.standard._Dictionary_if getSubjects$val$854;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        getSubjects$val$854 = school.getSubjects ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSubjects$val$854 = school.getSubjects ();
    }
// 73
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$855;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSubjects$val$854)) {
      try {
        iterator$val$855 = getSubjects$val$854.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$855 = getSubjects$val$854.iterator ();
    }
// 73
    lblIterator = iterator$val$855;
// 74
    JP.go.ipa.oz.user.ide.Subject_if subject = (JP.go.ipa.oz.user.ide.Subject_cl) (new JP.go.ipa.oz.user.ide.Subject_cl ())._new_create ();
// 75
    while (true) {
// 75
      boolean hasMoreElements$val$856;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
        try {
          hasMoreElements$val$856 = lblIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$856 = lblIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$856)) break;
      
      /* body */ _loop_1: {
// 76
        JP.go.ipa.oz.lang._Root_if nextElement$val$857;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
          try {
            nextElement$val$857 = lblIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$857 = lblIterator.nextElement ();
        }
// 76
        subject = (JP.go.ipa.oz.user.ide.Subject_if) (nextElement$val$857);
// 77
        JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$858;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
          try {
            getSubjectName$val$858 = subject.getSubjectName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSubjectName$val$858 = subject.getSubjectName ();
        }
// 77
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
          try {
            choSubject.addItem (getSubjectName$val$858);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          choSubject.addItem (getSubjectName$val$858);
        }
      }
    }
// 79
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
      try {
        choSubject.setEnabled (false);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choSubject.setEnabled (false);
    }
// 80
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
      try {
        choSubject.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choSubject.setFont (font);
    }
// 81
    add (choSubject);
// 82
    lblComment = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("  Rule of generation : ")));
// 83
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblComment)) {
      try {
        lblComment.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lblComment.setFont (font);
    }
// 84
    add (lblComment);
// 86
    JP.go.ipa.oz.lib.standard._GridLayout_if grid2 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (1, 2);
// 87
    JP.go.ipa.oz.lib.standard._Panel_if panel1 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (grid2);
// 88
    add (panel1);
// 89
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        panel1.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel1.addNotify ();
    }
// 90
    JP.go.ipa.oz.lib.standard._Label_if lblDummy = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("")));
// 91
    JP.go.ipa.oz.lib.standard._Component_if add$val$859;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        add$val$859 = panel1.add (lblDummy);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$859 = panel1.add (lblDummy);
    }
// 92
    lblHead = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("PREFIX")));
// 93
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblHead)) {
      try {
        lblHead.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lblHead.setFont (font);
    }
// 94
    JP.go.ipa.oz.lib.standard._Component_if add$val$860;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        add$val$860 = panel1.add (lblHead);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$860 = panel1.add (lblHead);
    }
// 96
    JP.go.ipa.oz.lib.standard._Array_if getRuleOfInterfaceID$val$861;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) idGen)) {
      try {
        getRuleOfInterfaceID$val$861 = idGen.getRuleOfInterfaceID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getRuleOfInterfaceID$val$861 = idGen.getRuleOfInterfaceID ();
    }
// 96
    ruleOfInterfaceID = getRuleOfInterfaceID$val$861;
// 97
    JP.go.ipa.oz.lib.standard._Array_if getRuleOfImplementationID$val$862;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) idGen)) {
      try {
        getRuleOfImplementationID$val$862 = idGen.getRuleOfImplementationID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getRuleOfImplementationID$val$862 = idGen.getRuleOfImplementationID ();
    }
// 97
    ruleOfImplementationID = getRuleOfImplementationID$val$862;
// 98
    JP.go.ipa.oz.lib.standard._String_if tmp = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ();
// 100
    JP.go.ipa.oz.lib.standard._GridLayout_if grid3 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (1, 2);
// 101
    JP.go.ipa.oz.lib.standard._Panel_if panel2 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (grid3);
// 102
    add (panel2);
// 103
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        panel2.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel2.addNotify ();
    }
// 104
    lblIfID = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("  InterfaceID")));
// 105
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIfID)) {
      try {
        lblIfID.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lblIfID.setFont (font);
    }
// 106
    JP.go.ipa.oz.lib.standard._Component_if add$val$863;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$863 = panel2.add (lblIfID);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$863 = panel2.add (lblIfID);
    }
// 107
    JP.go.ipa.oz.lang._Root_if at$val$864;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ruleOfInterfaceID)) {
      try {
        at$val$864 = ruleOfInterfaceID.at (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$864 = ruleOfInterfaceID.at (0);
    }
// 107
    tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$864);
// 108
    txtIfHead = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField (tmp);
// 109
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtIfHead)) {
      try {
        txtIfHead.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      txtIfHead.setFont (font);
    }
// 110
    JP.go.ipa.oz.lib.standard._Component_if add$val$865;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$865 = panel2.add (txtIfHead);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$865 = panel2.add (txtIfHead);
    }
// 112
    JP.go.ipa.oz.lib.standard._GridLayout_if grid4 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (1, 2);
// 113
    JP.go.ipa.oz.lib.standard._Panel_if panel3 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (grid4);
// 114
    add (panel3);
// 115
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel3)) {
      try {
        panel3.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel3.addNotify ();
    }
// 116
    lblImplID = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("  ImplementaionID")));
// 117
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblImplID)) {
      try {
        lblImplID.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lblImplID.setFont (font);
    }
// 118
    JP.go.ipa.oz.lib.standard._Component_if add$val$866;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel3)) {
      try {
        add$val$866 = panel3.add (lblImplID);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$866 = panel3.add (lblImplID);
    }
// 119
    JP.go.ipa.oz.lang._Root_if at$val$867;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ruleOfImplementationID)) {
      try {
        at$val$867 = ruleOfImplementationID.at (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$867 = ruleOfImplementationID.at (0);
    }
// 119
    tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$867);
// 120
    txtImpleHead = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField (tmp);
// 121
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtImpleHead)) {
      try {
        txtImpleHead.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      txtImpleHead.setFont (font);
    }
// 122
    JP.go.ipa.oz.lib.standard._Component_if add$val$868;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel3)) {
      try {
        add$val$868 = panel3.add (txtImpleHead);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$868 = panel3.add (txtImpleHead);
    }
// 124
    JP.go.ipa.oz.lib.standard._FlowLayout_if flow1 = (JP.go.ipa.oz.lib.standard._FlowLayout_cl) (new JP.go.ipa.oz.lib.standard._FlowLayout_cl ())._new_newFlowLayout (1, 20, 3);
// 125
    JP.go.ipa.oz.lib.standard._Panel_if panel4 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (flow1);
// 126
    add (panel4);
// 127
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel4)) {
      try {
        panel4.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel4.addNotify ();
    }
// 128
    btnOK = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("OK")));
// 129
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.setFont (font);
    }
// 130
    JP.go.ipa.oz.lib.standard._Component_if add$val$869;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel4)) {
      try {
        add$val$869 = panel4.add (btnOK);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$869 = panel4.add (btnOK);
    }
// 131
    btnCancel = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("Cancel")));
// 132
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnCancel)) {
      try {
        btnCancel.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnCancel.setFont (font);
    }
// 133
    JP.go.ipa.oz.lib.standard._Component_if add$val$870;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel4)) {
      try {
        add$val$870 = panel4.add (btnCancel);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$870 = panel4.add (btnCancel);
    }
// 134
    setTitle ((new JP.go.ipa.oz.lib.standard._String_cl("Generate Interface and Implementation ID")));
// 137
    genAL = (JP.go.ipa.oz.user.ide.IDGenActionListener_cl) (new JP.go.ipa.oz.user.ide.IDGenActionListener_cl ())._new_create (this, queue);
// 138
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.addActionListener (genAL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.addActionListener (genAL);
    }
// 139
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnCancel)) {
      try {
        btnCancel.addActionListener (genAL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnCancel.addActionListener (genAL);
    }
// 140
    genIL = (JP.go.ipa.oz.user.ide.IDGenItemListener_cl) (new JP.go.ipa.oz.user.ide.IDGenItemListener_cl ())._new_create (this, queue);
// 141
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rbtnSelected)) {
      try {
        rbtnSelected.addItemListener (genIL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      rbtnSelected.addItemListener (genIL);
    }
// 142
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rbtnSubject)) {
      try {
        rbtnSubject.addItemListener (genIL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      rbtnSubject.addItemListener (genIL);
    }
    return this;
  }
  
  public JP.go.ipa.oz.user.ide.School_if getSchool () throws Exception  {
    checkSecureInvocation ();
// 262
    return school;
  }
  
  public JP.go.ipa.oz.lib.standard._Button_if getBtnCancel () throws Exception  {
    checkSecureInvocation ();
// 253
    return btnCancel;
  }
  
  public void generateID (JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception  {
    checkSecureInvocation ();
// 190
    JP.go.ipa.oz.user.ide.OzLabel_if tmpLabel = null;
// 191
    JP.go.ipa.oz.lib.standard._Dictionary_if getOzLabels$val$871;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        getOzLabels$val$871 = school.getOzLabels (subjectName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabels$val$871 = school.getOzLabels (subjectName);
    }
// 191
    JP.go.ipa.oz.lib.standard._Dictionary_if labels = getOzLabels$val$871;
// 192
    JP.go.ipa.oz.lib.standard._Iterator_if lblIterator = null;
// 193
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$872;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labels)) {
      try {
        iterator$val$872 = labels.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$872 = labels.iterator ();
    }
// 193
    lblIterator = iterator$val$872;
// 196
    JP.go.ipa.oz.lib.standard._String_if getText$val$873;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtIfHead)) {
      try {
        getText$val$873 = txtIfHead.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$873 = txtIfHead.getText ();
    }
// 196
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$874;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ruleOfInterfaceID)) {
      try {
        putAt$val$874 = ruleOfInterfaceID.putAt (0, getText$val$873);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$874 = ruleOfInterfaceID.putAt (0, getText$val$873);
    }
// 197
    JP.go.ipa.oz.lib.standard._String_if string$150 = (new JP.go.ipa.oz.lib.standard._String_cl("_if"));
    
// 197
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$875;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ruleOfInterfaceID)) {
      try {
        putAt$val$875 = ruleOfInterfaceID.putAt (1, string$150);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$875 = ruleOfInterfaceID.putAt (1, string$150);
    }
// 198
    JP.go.ipa.oz.lib.standard._String_if getText$val$876;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtImpleHead)) {
      try {
        getText$val$876 = txtImpleHead.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$876 = txtImpleHead.getText ();
    }
// 198
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$877;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ruleOfImplementationID)) {
      try {
        putAt$val$877 = ruleOfImplementationID.putAt (0, getText$val$876);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$877 = ruleOfImplementationID.putAt (0, getText$val$876);
    }
// 199
    JP.go.ipa.oz.lib.standard._String_if string$151 = (new JP.go.ipa.oz.lib.standard._String_cl("_cl"));
    
// 199
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$878;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ruleOfImplementationID)) {
      try {
        putAt$val$878 = ruleOfImplementationID.putAt (1, string$151);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$878 = ruleOfImplementationID.putAt (1, string$151);
    }
// 200
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) idGen)) {
      try {
        idGen.setRuleOfInterfaceID (ruleOfInterfaceID);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      idGen.setRuleOfInterfaceID (ruleOfInterfaceID);
    }
// 201
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) idGen)) {
      try {
        idGen.setRuleOfImplementationID (ruleOfImplementationID);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      idGen.setRuleOfImplementationID (ruleOfImplementationID);
    }
// 203
    while (true) {
// 203
      boolean hasMoreElements$val$879;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
        try {
          hasMoreElements$val$879 = lblIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$879 = lblIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$879)) break;
      
      /* body */ _loop_1: {
// 204
        JP.go.ipa.oz.lang._Root_if nextElement$val$880;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
          try {
            nextElement$val$880 = lblIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$880 = lblIterator.nextElement ();
        }
// 204
        tmpLabel = (JP.go.ipa.oz.user.ide.OzLabel_if) (nextElement$val$880);
// 205
        JP.go.ipa.oz.lib.standard._String_if getOzLabelName$val$881;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpLabel)) {
          try {
            getOzLabelName$val$881 = tmpLabel.getOzLabelName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getOzLabelName$val$881 = tmpLabel.getOzLabelName ();
        }
// 205
        JP.go.ipa.oz.lib.standard._String_if generateInterfaceID$val$882;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) idGen)) {
          try {
            generateInterfaceID$val$882 = idGen.generateInterfaceID (getOzLabelName$val$881);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          generateInterfaceID$val$882 = idGen.generateInterfaceID (getOzLabelName$val$881);
        }
// 205
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpLabel)) {
          try {
            tmpLabel.setInterfaceID (generateInterfaceID$val$882);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          tmpLabel.setInterfaceID (generateInterfaceID$val$882);
        }
// 206
        JP.go.ipa.oz.lib.standard._String_if getOzLabelName$val$883;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpLabel)) {
          try {
            getOzLabelName$val$883 = tmpLabel.getOzLabelName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getOzLabelName$val$883 = tmpLabel.getOzLabelName ();
        }
// 206
        JP.go.ipa.oz.lib.standard._String_if generateImplementationID$val$884;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) idGen)) {
          try {
            generateImplementationID$val$884 = idGen.generateImplementationID (getOzLabelName$val$883);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          generateImplementationID$val$884 = idGen.generateImplementationID (getOzLabelName$val$883);
        }
// 206
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpLabel)) {
          try {
            tmpLabel.setImplementationID (generateImplementationID$val$884);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          tmpLabel.setImplementationID (generateImplementationID$val$884);
        }
      }
    }
  }
  
  public void generateID (JP.go.ipa.oz.user.ide.OzLabel_if label) throws Exception  {
    checkSecureInvocation ();
// 173
    JP.go.ipa.oz.lib.standard._String_if getText$val$885;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtIfHead)) {
      try {
        getText$val$885 = txtIfHead.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$885 = txtIfHead.getText ();
    }
// 173
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$886;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ruleOfInterfaceID)) {
      try {
        putAt$val$886 = ruleOfInterfaceID.putAt (0, getText$val$885);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$886 = ruleOfInterfaceID.putAt (0, getText$val$885);
    }
// 174
    JP.go.ipa.oz.lib.standard._String_if string$152 = (new JP.go.ipa.oz.lib.standard._String_cl("_if"));
    
// 174
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$887;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ruleOfInterfaceID)) {
      try {
        putAt$val$887 = ruleOfInterfaceID.putAt (1, string$152);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$887 = ruleOfInterfaceID.putAt (1, string$152);
    }
// 175
    JP.go.ipa.oz.lib.standard._String_if getText$val$888;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtImpleHead)) {
      try {
        getText$val$888 = txtImpleHead.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$888 = txtImpleHead.getText ();
    }
// 175
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$889;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ruleOfImplementationID)) {
      try {
        putAt$val$889 = ruleOfImplementationID.putAt (0, getText$val$888);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$889 = ruleOfImplementationID.putAt (0, getText$val$888);
    }
// 176
    JP.go.ipa.oz.lib.standard._String_if string$153 = (new JP.go.ipa.oz.lib.standard._String_cl("_cl"));
    
// 176
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$890;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ruleOfImplementationID)) {
      try {
        putAt$val$890 = ruleOfImplementationID.putAt (1, string$153);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$890 = ruleOfImplementationID.putAt (1, string$153);
    }
// 177
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) idGen)) {
      try {
        idGen.setRuleOfInterfaceID (ruleOfInterfaceID);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      idGen.setRuleOfInterfaceID (ruleOfInterfaceID);
    }
// 178
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) idGen)) {
      try {
        idGen.setRuleOfImplementationID (ruleOfImplementationID);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      idGen.setRuleOfImplementationID (ruleOfImplementationID);
    }
// 180
    JP.go.ipa.oz.lib.standard._String_if getOzLabelName$val$891;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) label)) {
      try {
        getOzLabelName$val$891 = label.getOzLabelName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabelName$val$891 = label.getOzLabelName ();
    }
// 180
    JP.go.ipa.oz.lib.standard._String_if generateInterfaceID$val$892;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) idGen)) {
      try {
        generateInterfaceID$val$892 = idGen.generateInterfaceID (getOzLabelName$val$891);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      generateInterfaceID$val$892 = idGen.generateInterfaceID (getOzLabelName$val$891);
    }
// 180
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) label)) {
      try {
        label.setInterfaceID (generateInterfaceID$val$892);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      label.setInterfaceID (generateInterfaceID$val$892);
    }
// 181
    JP.go.ipa.oz.lib.standard._String_if getOzLabelName$val$893;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) label)) {
      try {
        getOzLabelName$val$893 = label.getOzLabelName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabelName$val$893 = label.getOzLabelName ();
    }
// 181
    JP.go.ipa.oz.lib.standard._String_if generateImplementationID$val$894;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) idGen)) {
      try {
        generateImplementationID$val$894 = idGen.generateImplementationID (getOzLabelName$val$893);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      generateImplementationID$val$894 = idGen.generateImplementationID (getOzLabelName$val$893);
    }
// 181
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) label)) {
      try {
        label.setImplementationID (generateImplementationID$val$894);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      label.setImplementationID (generateImplementationID$val$894);
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Choice_if getChoSubject () throws Exception  {
    checkSecureInvocation ();
// 217
    return choSubject;
  }
  
  public JP.go.ipa.oz.lib.standard._Checkbox_if getRbtnSubject () throws Exception  {
    checkSecureInvocation ();
// 235
    return rbtnSubject;
  }
  
  public JP.go.ipa.oz.lib.standard._Button_if getBtnOK () throws Exception  {
    checkSecureInvocation ();
// 244
    return btnOK;
  }
  
  public JP.go.ipa.oz.lib.standard._Checkbox_if getRbtnSelected () throws Exception  {
    checkSecureInvocation ();
// 226
    return rbtnSelected;
  }
  
  public JP.go.ipa.oz.user.ide.OzLabel_if getLabel () throws Exception  {
    checkSecureInvocation ();
// 289
    return label;
  }
  
  public JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser () throws Exception  {
    checkSecureInvocation ();
// 271
    return schoolBrowser;
  }
  
  public void setVisible (boolean b) throws Exception  {
    checkSecureInvocation ();
// 154
    JP.go.ipa.oz.lib.standard._Container_if getParent$val$895;
    getParent$val$895 = getParent ();
// 154
    JP.go.ipa.oz.lib.standard._Rectangle_if getBounds$val$896;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getParent$val$895)) {
      try {
        getBounds$val$896 = getParent$val$895.getBounds ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBounds$val$896 = getParent$val$895.getBounds ();
    }
// 154
    JP.go.ipa.oz.lib.standard._Rectangle_if bounds = getBounds$val$896;
// 155
    int getX$val$897;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getX$val$897 = bounds.getX ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getX$val$897 = bounds.getX ();
    }
// 155
    int getY$val$898;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getY$val$898 = bounds.getY ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getY$val$898 = bounds.getY ();
    }
// 155
    setLocation (getX$val$897 + 50, getY$val$898 + 50);
// 156
    super.setVisible (b);
  }
  
  public JP.go.ipa.oz.user.ide.ClassIDGenerator_if getIdGen () throws Exception  {
    checkSecureInvocation ();
// 280
    return idGen;
  }
  
  public IDGenDialog_cl () throws Exception { super (); }
  
}


package JP.go.ipa.oz.user.ide;

public class LabelEditDialog_cl extends JP.go.ipa.oz.lib.standard._Dialog_cl implements JP.go.ipa.oz.user.ide.LabelEditDialog_if {
  JP.go.ipa.oz.lib.standard._Button_if btnOK;
  JP.go.ipa.oz.user.ide.School_if school;
  JP.go.ipa.oz.lib.standard._Label_if lblLabel;
  JP.go.ipa.oz.user.ide.OzLabel_if label;
  JP.go.ipa.oz.lib.standard._Label_if lblSubject;
  JP.go.ipa.oz.lib.standard._Label_if lblImplID;
  JP.go.ipa.oz.user.ide.LabelEditActionListener_if editAL;
  JP.go.ipa.oz.lib.standard._TextField_if txtImplID;
  JP.go.ipa.oz.lib.standard._Label_if lblIfID;
  JP.go.ipa.oz.lib.standard._Button_if btnCancel;
  JP.go.ipa.oz.user.ide.SchoolBrowser_if schoolBrowser;
  JP.go.ipa.oz.lib.standard._TextField_if txtLabel;
  JP.go.ipa.oz.lib.standard._TextField_if txtIfID;
  JP.go.ipa.oz.lib.standard._Choice_if choSubject;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Frame_if parent, boolean modal, JP.go.ipa.oz.lib.standard._String_if labelName, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if queue) throws Exception  {
// 40
    super._new_newDialog (parent, modal);
// 42
    schoolBrowser = (JP.go.ipa.oz.user.ide.SchoolBrowser_if) (parent);
// 43
    JP.go.ipa.oz.user.ide.School_if getSchool$val$699;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
      try {
        getSchool$val$699 = schoolBrowser.getSchool ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchool$val$699 = schoolBrowser.getSchool ();
    }
// 43
    school = getSchool$val$699;
// 44
    JP.go.ipa.oz.user.ide.OzLabel_if getOzLabel$val$700;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        getOzLabel$val$700 = school.getOzLabel (labelName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabel$val$700 = school.getOzLabel (labelName);
    }
// 44
    label = getOzLabel$val$700;
// 47
    JP.go.ipa.oz.lib.standard._GridLayout_if grid1 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (5, 1, 10, 10);
// 48
    setLayout (grid1);
// 49
    addNotify ();
// 50
    setSize (330, 200);
// 51
    JP.go.ipa.oz.lib.standard._Font_if font = (JP.go.ipa.oz.lib.standard._Font_cl) (new JP.go.ipa.oz.lib.standard._Font_cl ())._new_newFont ((new JP.go.ipa.oz.lib.standard._String_cl("TimesRoman")), 12);
// 53
    JP.go.ipa.oz.lib.standard._GridLayout_if grid2 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (1, 2);
// 54
    JP.go.ipa.oz.lib.standard._Panel_if panel1 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (grid2);
// 55
    add (panel1);
// 56
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        panel1.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel1.addNotify ();
    }
// 57
    lblSubject = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("   Subject :")));
// 58
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblSubject)) {
      try {
        lblSubject.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lblSubject.setFont (font);
    }
// 59
    JP.go.ipa.oz.lib.standard._Component_if add$val$701;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        add$val$701 = panel1.add (lblSubject);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$701 = panel1.add (lblSubject);
    }
// 60
    choSubject = (JP.go.ipa.oz.lib.standard._Choice_cl) (new JP.go.ipa.oz.lib.standard._Choice_cl ())._new_newChoice ();
// 61
    JP.go.ipa.oz.lib.standard._Iterator_if lblIterator = null;
// 62
    JP.go.ipa.oz.lib.standard._Dictionary_if getSubjects$val$702;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        getSubjects$val$702 = school.getSubjects ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSubjects$val$702 = school.getSubjects ();
    }
// 62
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$703;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSubjects$val$702)) {
      try {
        iterator$val$703 = getSubjects$val$702.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$703 = getSubjects$val$702.iterator ();
    }
// 62
    lblIterator = iterator$val$703;
// 63
    JP.go.ipa.oz.user.ide.Subject_if subject = null;
// 64
    while (true) {
// 64
      boolean hasMoreElements$val$704;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
        try {
          hasMoreElements$val$704 = lblIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$704 = lblIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$704)) break;
      
      /* body */ _loop_1: {
// 65
        JP.go.ipa.oz.lang._Root_if nextElement$val$705;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
          try {
            nextElement$val$705 = lblIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$705 = lblIterator.nextElement ();
        }
// 65
        subject = (JP.go.ipa.oz.user.ide.Subject_if) (nextElement$val$705);
// 66
        JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$706;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
          try {
            getSubjectName$val$706 = subject.getSubjectName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSubjectName$val$706 = subject.getSubjectName ();
        }
// 66
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
          try {
            choSubject.addItem (getSubjectName$val$706);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          choSubject.addItem (getSubjectName$val$706);
        }
      }
    }
// 68
    JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$707;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) label)) {
      try {
        getSubjectName$val$707 = label.getSubjectName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSubjectName$val$707 = label.getSubjectName ();
    }
// 68
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
      try {
        choSubject.select (getSubjectName$val$707);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choSubject.select (getSubjectName$val$707);
    }
// 69
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
      try {
        choSubject.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choSubject.setFont (font);
    }
// 70
    JP.go.ipa.oz.lib.standard._Component_if add$val$708;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        add$val$708 = panel1.add (choSubject);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$708 = panel1.add (choSubject);
    }
// 72
    JP.go.ipa.oz.lib.standard._GridLayout_if grid3 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (1, 2);
// 73
    JP.go.ipa.oz.lib.standard._Panel_if panel2 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (grid3);
// 74
    add (panel2);
// 75
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        panel2.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel2.addNotify ();
    }
// 76
    lblLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("   Class Name : ")));
// 77
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblLabel)) {
      try {
        lblLabel.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lblLabel.setFont (font);
    }
// 78
    JP.go.ipa.oz.lib.standard._Component_if add$val$709;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$709 = panel2.add (lblLabel);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$709 = panel2.add (lblLabel);
    }
// 79
    JP.go.ipa.oz.lib.standard._String_if getOzLabelName$val$710;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) label)) {
      try {
        getOzLabelName$val$710 = label.getOzLabelName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabelName$val$710 = label.getOzLabelName ();
    }
// 79
    txtLabel = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField (getOzLabelName$val$710);
// 80
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtLabel)) {
      try {
        txtLabel.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      txtLabel.setFont (font);
    }
// 81
    JP.go.ipa.oz.lib.standard._Component_if add$val$711;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$711 = panel2.add (txtLabel);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$711 = panel2.add (txtLabel);
    }
// 83
    JP.go.ipa.oz.lib.standard._GridLayout_if grid4 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (1, 2);
// 84
    JP.go.ipa.oz.lib.standard._Panel_if panel3 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (grid4);
// 85
    add (panel3);
// 86
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel3)) {
      try {
        panel3.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel3.addNotify ();
    }
// 87
    lblIfID = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("   Interface ID :")));
// 88
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIfID)) {
      try {
        lblIfID.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lblIfID.setFont (font);
    }
// 89
    JP.go.ipa.oz.lib.standard._Component_if add$val$712;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel3)) {
      try {
        add$val$712 = panel3.add (lblIfID);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$712 = panel3.add (lblIfID);
    }
// 90
    JP.go.ipa.oz.lib.standard._String_if getInterfaceID$val$713;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) label)) {
      try {
        getInterfaceID$val$713 = label.getInterfaceID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getInterfaceID$val$713 = label.getInterfaceID ();
    }
// 90
    txtIfID = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField (getInterfaceID$val$713);
// 91
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtIfID)) {
      try {
        txtIfID.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      txtIfID.setFont (font);
    }
// 92
    JP.go.ipa.oz.lib.standard._Component_if add$val$714;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel3)) {
      try {
        add$val$714 = panel3.add (txtIfID);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$714 = panel3.add (txtIfID);
    }
// 94
    JP.go.ipa.oz.lib.standard._GridLayout_if grid5 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (1, 2);
// 95
    JP.go.ipa.oz.lib.standard._Panel_if panel4 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (grid5);
// 96
    add (panel4);
// 97
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel4)) {
      try {
        panel4.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel4.addNotify ();
    }
// 98
    lblImplID = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("   Implementaion ID :")));
// 99
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblImplID)) {
      try {
        lblImplID.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lblImplID.setFont (font);
    }
// 100
    JP.go.ipa.oz.lib.standard._Component_if add$val$715;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel4)) {
      try {
        add$val$715 = panel4.add (lblImplID);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$715 = panel4.add (lblImplID);
    }
// 101
    JP.go.ipa.oz.lib.standard._String_if getImplementationID$val$716;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) label)) {
      try {
        getImplementationID$val$716 = label.getImplementationID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getImplementationID$val$716 = label.getImplementationID ();
    }
// 101
    txtImplID = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField (getImplementationID$val$716);
// 102
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtImplID)) {
      try {
        txtImplID.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      txtImplID.setFont (font);
    }
// 103
    JP.go.ipa.oz.lib.standard._Component_if add$val$717;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel4)) {
      try {
        add$val$717 = panel4.add (txtImplID);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$717 = panel4.add (txtImplID);
    }
// 105
    JP.go.ipa.oz.lib.standard._FlowLayout_if flow = (JP.go.ipa.oz.lib.standard._FlowLayout_cl) (new JP.go.ipa.oz.lib.standard._FlowLayout_cl ())._new_newFlowLayout (1, 40, 3);
// 106
    JP.go.ipa.oz.lib.standard._Panel_if panel5 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (flow);
// 107
    add (panel5);
// 108
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel5)) {
      try {
        panel5.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel5.addNotify ();
    }
// 109
    btnOK = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("OK")));
// 110
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.setFont (font);
    }
// 111
    JP.go.ipa.oz.lib.standard._Component_if add$val$718;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel5)) {
      try {
        add$val$718 = panel5.add (btnOK);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$718 = panel5.add (btnOK);
    }
// 112
    btnCancel = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("Cancel")));
// 113
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnCancel)) {
      try {
        btnCancel.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnCancel.setFont (font);
    }
// 114
    JP.go.ipa.oz.lib.standard._Component_if add$val$719;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel5)) {
      try {
        add$val$719 = panel5.add (btnCancel);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$719 = panel5.add (btnCancel);
    }
// 116
    setTitle ((new JP.go.ipa.oz.lib.standard._String_cl("EDIT LABEL DIALOG")));
// 121
    editAL = (JP.go.ipa.oz.user.ide.LabelEditActionListener_cl) (new JP.go.ipa.oz.user.ide.LabelEditActionListener_cl ())._new_create (this, queue);
// 122
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.addActionListener (editAL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.addActionListener (editAL);
    }
// 123
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnCancel)) {
      try {
        btnCancel.addActionListener (editAL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnCancel.addActionListener (editAL);
    }
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._Choice_if getChoSubject () throws Exception  {
    checkSecureInvocation ();
// 198
    return choSubject;
  }
  
  public void modifyLabel () throws Exception  {
    checkSecureInvocation ();
// 164
    JP.go.ipa.oz.lib.standard._String_if getText$val$720;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtLabel)) {
      try {
        getText$val$720 = txtLabel.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$720 = txtLabel.getText ();
    }
// 164
    JP.go.ipa.oz.lib.standard._String_if string$139 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    
// 164
    int compareTo$val$721;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getText$val$720)) {
      try {
        compareTo$val$721 = getText$val$720.compareTo (string$139);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compareTo$val$721 = getText$val$720.compareTo (string$139);
    }
// 164
    if (compareTo$val$721 == 0) {
// 164
      return;
    }
// 165
    JP.go.ipa.oz.lib.standard._String_if getOzLabelName$val$722;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) label)) {
      try {
        getOzLabelName$val$722 = label.getOzLabelName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabelName$val$722 = label.getOzLabelName ();
    }
// 165
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$723;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
      try {
        getSelectedItem$val$723 = choSubject.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$723 = choSubject.getSelectedItem ();
    }
// 165
    JP.go.ipa.oz.user.ide.School_if removeOzLabel$val$724;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        removeOzLabel$val$724 = school.removeOzLabel (getOzLabelName$val$722, getSelectedItem$val$723);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      removeOzLabel$val$724 = school.removeOzLabel (getOzLabelName$val$722, getSelectedItem$val$723);
    }
// 166
    JP.go.ipa.oz.user.ide.OzLabel_if newOzLabel = (JP.go.ipa.oz.user.ide.OzLabel_cl) (new JP.go.ipa.oz.user.ide.OzLabel_cl ())._new_create ();
// 167
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$725;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
      try {
        getSelectedItem$val$725 = choSubject.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$725 = choSubject.getSelectedItem ();
    }
// 167
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) newOzLabel)) {
      try {
        newOzLabel.setSubjectName (getSelectedItem$val$725);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      newOzLabel.setSubjectName (getSelectedItem$val$725);
    }
// 168
    JP.go.ipa.oz.lib.standard._String_if getText$val$726;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtLabel)) {
      try {
        getText$val$726 = txtLabel.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$726 = txtLabel.getText ();
    }
// 168
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) newOzLabel)) {
      try {
        newOzLabel.setOzLabelName (getText$val$726);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      newOzLabel.setOzLabelName (getText$val$726);
    }
// 169
    JP.go.ipa.oz.lib.standard._String_if getText$val$727;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtIfID)) {
      try {
        getText$val$727 = txtIfID.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$727 = txtIfID.getText ();
    }
// 169
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) newOzLabel)) {
      try {
        newOzLabel.setInterfaceID (getText$val$727);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      newOzLabel.setInterfaceID (getText$val$727);
    }
// 170
    JP.go.ipa.oz.lib.standard._String_if getText$val$728;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtImplID)) {
      try {
        getText$val$728 = txtImplID.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$728 = txtImplID.getText ();
    }
// 170
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) newOzLabel)) {
      try {
        newOzLabel.setImplementationID (getText$val$728);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      newOzLabel.setImplementationID (getText$val$728);
    }
// 171
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$729;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
      try {
        getSelectedItem$val$729 = choSubject.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$729 = choSubject.getSelectedItem ();
    }
// 171
    JP.go.ipa.oz.user.ide.School_if putOzLabel$val$730;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        putOzLabel$val$730 = school.putOzLabel (newOzLabel, getSelectedItem$val$729);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putOzLabel$val$730 = school.putOzLabel (newOzLabel, getSelectedItem$val$729);
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Button_if getBtnOK () throws Exception  {
    checkSecureInvocation ();
// 189
    return btnOK;
  }
  
  public JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser () throws Exception  {
    checkSecureInvocation ();
// 180
    return schoolBrowser;
  }
  
  public void setVisible (boolean b) throws Exception  {
    checkSecureInvocation ();
// 135
    JP.go.ipa.oz.lib.standard._Container_if getParent$val$731;
    getParent$val$731 = getParent ();
// 135
    JP.go.ipa.oz.lib.standard._Rectangle_if getBounds$val$732;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getParent$val$731)) {
      try {
        getBounds$val$732 = getParent$val$731.getBounds ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBounds$val$732 = getParent$val$731.getBounds ();
    }
// 135
    JP.go.ipa.oz.lib.standard._Rectangle_if bounds = getBounds$val$732;
// 136
    JP.go.ipa.oz.lib.standard._Rectangle_if abounds = getBounds ();
// 137
    int getX$val$733;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getX$val$733 = bounds.getX ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getX$val$733 = bounds.getX ();
    }
// 137
    int getWidth$val$734;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getWidth$val$734 = bounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$734 = bounds.getWidth ();
    }
// 137
    int getWidth$val$735;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getWidth$val$735 = abounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$735 = abounds.getWidth ();
    }
// 138
    int getY$val$736;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getY$val$736 = bounds.getY ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getY$val$736 = bounds.getY ();
    }
// 138
    int getHeight$val$737;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getHeight$val$737 = bounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$737 = bounds.getHeight ();
    }
// 138
    int getHeight$val$738;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getHeight$val$738 = abounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$738 = abounds.getHeight ();
    }
// 137
    setLocation (getX$val$733 + (getWidth$val$734 - getWidth$val$735) / 2, getY$val$736 + (getHeight$val$737 - getHeight$val$738) / 2);
// 140
    super.setVisible (b);
  }
  
  public LabelEditDialog_cl () throws Exception { super (); }
  
}


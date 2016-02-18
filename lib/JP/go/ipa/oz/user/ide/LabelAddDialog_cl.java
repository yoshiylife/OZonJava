package JP.go.ipa.oz.user.ide;

public class LabelAddDialog_cl extends JP.go.ipa.oz.lib.standard._Dialog_cl implements JP.go.ipa.oz.user.ide.LabelAddDialog_if {
  JP.go.ipa.oz.lib.standard._Button_if btnOK;
  JP.go.ipa.oz.user.ide.School_if school;
  JP.go.ipa.oz.user.ide.LabelAddActionListener_if addAL;
  JP.go.ipa.oz.lib.standard._Label_if lblLabel;
  JP.go.ipa.oz.lib.standard._Label_if lblSubject;
  JP.go.ipa.oz.lib.standard._Label_if lblImplID;
  JP.go.ipa.oz.lib.standard._TextField_if txtImplID;
  JP.go.ipa.oz.lib.standard._Label_if lblIfID;
  JP.go.ipa.oz.lib.standard._Button_if btnCancel;
  JP.go.ipa.oz.user.ide.SchoolBrowser_if schoolBrowser;
  JP.go.ipa.oz.lib.standard._TextField_if txtLabel;
  JP.go.ipa.oz.lib.standard._TextField_if txtIfID;
  JP.go.ipa.oz.lib.standard._Choice_if choSubject;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Frame_if parent, boolean modal, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if queue) throws Exception  {
// 39
    super._new_newDialog (parent, modal);
// 41
    schoolBrowser = (JP.go.ipa.oz.user.ide.SchoolBrowser_if) (parent);
// 42
    JP.go.ipa.oz.user.ide.School_if getSchool$val$615;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
      try {
        getSchool$val$615 = schoolBrowser.getSchool ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchool$val$615 = schoolBrowser.getSchool ();
    }
// 42
    school = getSchool$val$615;
// 45
    JP.go.ipa.oz.lib.standard._GridLayout_if grid1 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (5, 1, 10, 10);
// 46
    setLayout (grid1);
// 47
    addNotify ();
// 48
    setSize (330, 200);
// 49
    JP.go.ipa.oz.lib.standard._Font_if font = (JP.go.ipa.oz.lib.standard._Font_cl) (new JP.go.ipa.oz.lib.standard._Font_cl ())._new_newFont ((new JP.go.ipa.oz.lib.standard._String_cl("TimesRoman")), 12);
// 51
    JP.go.ipa.oz.lib.standard._GridLayout_if grid2 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (1, 2);
// 52
    JP.go.ipa.oz.lib.standard._Panel_if panel1 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (grid2);
// 53
    add (panel1);
// 54
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        panel1.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel1.addNotify ();
    }
// 55
    lblSubject = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("   Subject :")));
// 56
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblSubject)) {
      try {
        lblSubject.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lblSubject.setFont (font);
    }
// 57
    JP.go.ipa.oz.lib.standard._Component_if add$val$616;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        add$val$616 = panel1.add (lblSubject);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$616 = panel1.add (lblSubject);
    }
// 58
    choSubject = (JP.go.ipa.oz.lib.standard._Choice_cl) (new JP.go.ipa.oz.lib.standard._Choice_cl ())._new_newChoice ();
// 59
    JP.go.ipa.oz.lib.standard._Iterator_if lblIterator = null;
// 60
    JP.go.ipa.oz.lib.standard._Dictionary_if getSubjects$val$617;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        getSubjects$val$617 = school.getSubjects ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSubjects$val$617 = school.getSubjects ();
    }
// 60
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$618;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSubjects$val$617)) {
      try {
        iterator$val$618 = getSubjects$val$617.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$618 = getSubjects$val$617.iterator ();
    }
// 60
    lblIterator = iterator$val$618;
// 61
    JP.go.ipa.oz.user.ide.Subject_if subject = null;
// 62
    while (true) {
// 62
      boolean hasMoreElements$val$619;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
        try {
          hasMoreElements$val$619 = lblIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$619 = lblIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$619)) break;
      
      /* body */ _loop_1: {
// 63
        JP.go.ipa.oz.lang._Root_if nextElement$val$620;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
          try {
            nextElement$val$620 = lblIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$620 = lblIterator.nextElement ();
        }
// 63
        subject = (JP.go.ipa.oz.user.ide.Subject_if) (nextElement$val$620);
// 64
        JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$621;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
          try {
            getSubjectName$val$621 = subject.getSubjectName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSubjectName$val$621 = subject.getSubjectName ();
        }
// 64
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
          try {
            choSubject.addItem (getSubjectName$val$621);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          choSubject.addItem (getSubjectName$val$621);
        }
      }
    }
// 66
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
      try {
        choSubject.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choSubject.setFont (font);
    }
// 67
    JP.go.ipa.oz.lib.standard._Component_if add$val$622;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        add$val$622 = panel1.add (choSubject);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$622 = panel1.add (choSubject);
    }
// 69
    JP.go.ipa.oz.lib.standard._GridLayout_if grid3 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (1, 2);
// 70
    JP.go.ipa.oz.lib.standard._Panel_if panel2 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (grid3);
// 71
    add (panel2);
// 72
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        panel2.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel2.addNotify ();
    }
// 73
    lblLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("   Class Name : ")));
// 74
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblLabel)) {
      try {
        lblLabel.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lblLabel.setFont (font);
    }
// 75
    JP.go.ipa.oz.lib.standard._Component_if add$val$623;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$623 = panel2.add (lblLabel);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$623 = panel2.add (lblLabel);
    }
// 76
    txtLabel = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField ();
// 77
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtLabel)) {
      try {
        txtLabel.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      txtLabel.setFont (font);
    }
// 78
    JP.go.ipa.oz.lib.standard._Component_if add$val$624;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$624 = panel2.add (txtLabel);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$624 = panel2.add (txtLabel);
    }
// 80
    JP.go.ipa.oz.lib.standard._GridLayout_if grid4 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (1, 2);
// 81
    JP.go.ipa.oz.lib.standard._Panel_if panel3 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (grid4);
// 82
    add (panel3);
// 83
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel3)) {
      try {
        panel3.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel3.addNotify ();
    }
// 84
    lblIfID = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("   Interface ID :")));
// 85
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIfID)) {
      try {
        lblIfID.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lblIfID.setFont (font);
    }
// 86
    JP.go.ipa.oz.lib.standard._Component_if add$val$625;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel3)) {
      try {
        add$val$625 = panel3.add (lblIfID);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$625 = panel3.add (lblIfID);
    }
// 87
    txtIfID = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField ();
// 88
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtIfID)) {
      try {
        txtIfID.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      txtIfID.setFont (font);
    }
// 89
    JP.go.ipa.oz.lib.standard._Component_if add$val$626;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel3)) {
      try {
        add$val$626 = panel3.add (txtIfID);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$626 = panel3.add (txtIfID);
    }
// 91
    JP.go.ipa.oz.lib.standard._GridLayout_if grid5 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (1, 2);
// 92
    JP.go.ipa.oz.lib.standard._Panel_if panel4 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (grid5);
// 93
    add (panel4);
// 94
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel4)) {
      try {
        panel4.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel4.addNotify ();
    }
// 95
    lblImplID = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("   Implementaion ID :")));
// 96
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblImplID)) {
      try {
        lblImplID.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lblImplID.setFont (font);
    }
// 97
    JP.go.ipa.oz.lib.standard._Component_if add$val$627;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel4)) {
      try {
        add$val$627 = panel4.add (lblImplID);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$627 = panel4.add (lblImplID);
    }
// 98
    txtImplID = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField ();
// 99
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtImplID)) {
      try {
        txtImplID.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      txtImplID.setFont (font);
    }
// 100
    JP.go.ipa.oz.lib.standard._Component_if add$val$628;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel4)) {
      try {
        add$val$628 = panel4.add (txtImplID);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$628 = panel4.add (txtImplID);
    }
// 102
    JP.go.ipa.oz.lib.standard._FlowLayout_if flow = (JP.go.ipa.oz.lib.standard._FlowLayout_cl) (new JP.go.ipa.oz.lib.standard._FlowLayout_cl ())._new_newFlowLayout (1, 40, 3);
// 103
    JP.go.ipa.oz.lib.standard._Panel_if panel5 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (flow);
// 104
    add (panel5);
// 105
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel5)) {
      try {
        panel5.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel5.addNotify ();
    }
// 106
    btnOK = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("OK")));
// 107
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.setFont (font);
    }
// 108
    JP.go.ipa.oz.lib.standard._Component_if add$val$629;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel5)) {
      try {
        add$val$629 = panel5.add (btnOK);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$629 = panel5.add (btnOK);
    }
// 109
    btnCancel = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("Cancel")));
// 110
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnCancel)) {
      try {
        btnCancel.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnCancel.setFont (font);
    }
// 111
    JP.go.ipa.oz.lib.standard._Component_if add$val$630;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel5)) {
      try {
        add$val$630 = panel5.add (btnCancel);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$630 = panel5.add (btnCancel);
    }
// 113
    setTitle ((new JP.go.ipa.oz.lib.standard._String_cl("ADD LABEL DIALOG")));
// 116
    addAL = (JP.go.ipa.oz.user.ide.LabelAddActionListener_cl) (new JP.go.ipa.oz.user.ide.LabelAddActionListener_cl ())._new_create (this, queue);
// 117
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.addActionListener (addAL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.addActionListener (addAL);
    }
// 118
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnCancel)) {
      try {
        btnCancel.addActionListener (addAL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnCancel.addActionListener (addAL);
    }
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._Choice_if getChoSubject () throws Exception  {
    checkSecureInvocation ();
// 177
    return choSubject;
  }
  
  public JP.go.ipa.oz.lib.standard._Button_if getBtnOK () throws Exception  {
    checkSecureInvocation ();
// 168
    return btnOK;
  }
  
  public JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser () throws Exception  {
    checkSecureInvocation ();
// 159
    return schoolBrowser;
  }
  
  public void putLabel () throws Exception  {
    checkSecureInvocation ();
// 144
    JP.go.ipa.oz.lib.standard._String_if getText$val$631;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtLabel)) {
      try {
        getText$val$631 = txtLabel.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$631 = txtLabel.getText ();
    }
// 144
    JP.go.ipa.oz.lib.standard._String_if string$136 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    
// 144
    int compareTo$val$632;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getText$val$631)) {
      try {
        compareTo$val$632 = getText$val$631.compareTo (string$136);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compareTo$val$632 = getText$val$631.compareTo (string$136);
    }
// 144
    if (compareTo$val$632 == 0) {
// 144
      return;
    }
// 145
    JP.go.ipa.oz.user.ide.OzLabel_if label = (JP.go.ipa.oz.user.ide.OzLabel_cl) (new JP.go.ipa.oz.user.ide.OzLabel_cl ())._new_create ();
// 146
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$633;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
      try {
        getSelectedItem$val$633 = choSubject.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$633 = choSubject.getSelectedItem ();
    }
// 146
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) label)) {
      try {
        label.setSubjectName (getSelectedItem$val$633);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      label.setSubjectName (getSelectedItem$val$633);
    }
// 147
    JP.go.ipa.oz.lib.standard._String_if getText$val$634;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtLabel)) {
      try {
        getText$val$634 = txtLabel.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$634 = txtLabel.getText ();
    }
// 147
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) label)) {
      try {
        label.setOzLabelName (getText$val$634);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      label.setOzLabelName (getText$val$634);
    }
// 148
    JP.go.ipa.oz.lib.standard._String_if getText$val$635;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtIfID)) {
      try {
        getText$val$635 = txtIfID.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$635 = txtIfID.getText ();
    }
// 148
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) label)) {
      try {
        label.setInterfaceID (getText$val$635);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      label.setInterfaceID (getText$val$635);
    }
// 149
    JP.go.ipa.oz.lib.standard._String_if getText$val$636;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtImplID)) {
      try {
        getText$val$636 = txtImplID.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$636 = txtImplID.getText ();
    }
// 149
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) label)) {
      try {
        label.setImplementationID (getText$val$636);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      label.setImplementationID (getText$val$636);
    }
// 150
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$637;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
      try {
        getSelectedItem$val$637 = choSubject.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$637 = choSubject.getSelectedItem ();
    }
// 150
    JP.go.ipa.oz.user.ide.School_if putOzLabel$val$638;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        putOzLabel$val$638 = school.putOzLabel (label, getSelectedItem$val$637);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putOzLabel$val$638 = school.putOzLabel (label, getSelectedItem$val$637);
    }
  }
  
  public void setVisible (boolean b) throws Exception  {
    checkSecureInvocation ();
// 130
    JP.go.ipa.oz.lib.standard._Container_if getParent$val$639;
    getParent$val$639 = getParent ();
// 130
    JP.go.ipa.oz.lib.standard._Rectangle_if getBounds$val$640;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getParent$val$639)) {
      try {
        getBounds$val$640 = getParent$val$639.getBounds ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBounds$val$640 = getParent$val$639.getBounds ();
    }
// 130
    JP.go.ipa.oz.lib.standard._Rectangle_if bounds = getBounds$val$640;
// 131
    JP.go.ipa.oz.lib.standard._Rectangle_if abounds = getBounds ();
// 132
    int getX$val$641;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getX$val$641 = bounds.getX ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getX$val$641 = bounds.getX ();
    }
// 132
    int getWidth$val$642;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getWidth$val$642 = bounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$642 = bounds.getWidth ();
    }
// 132
    int getWidth$val$643;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getWidth$val$643 = abounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$643 = abounds.getWidth ();
    }
// 133
    int getY$val$644;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getY$val$644 = bounds.getY ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getY$val$644 = bounds.getY ();
    }
// 133
    int getHeight$val$645;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getHeight$val$645 = bounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$645 = bounds.getHeight ();
    }
// 133
    int getHeight$val$646;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getHeight$val$646 = abounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$646 = abounds.getHeight ();
    }
// 132
    setLocation (getX$val$641 + (getWidth$val$642 - getWidth$val$643) / 2, getY$val$644 + (getHeight$val$645 - getHeight$val$646) / 2);
// 135
    super.setVisible (b);
  }
  
  public LabelAddDialog_cl () throws Exception { super (); }
  
}


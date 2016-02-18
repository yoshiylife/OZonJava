package JP.go.ipa.oz.user.ide;

public class LabelDeleteDialog_cl extends JP.go.ipa.oz.lib.standard._Dialog_cl implements JP.go.ipa.oz.user.ide.LabelDeleteDialog_if {
  JP.go.ipa.oz.lib.standard._Button_if btnOK;
  JP.go.ipa.oz.user.ide.School_if school;
  JP.go.ipa.oz.lib.standard._Checkbox_if rbtnSelected;
  JP.go.ipa.oz.user.ide.LabelDeleteActionListener_if deleteAL;
  JP.go.ipa.oz.lib.standard._CheckboxGroup_if group;
  JP.go.ipa.oz.lib.standard._String_if labelName;
  JP.go.ipa.oz.lib.standard._Button_if btnCancel;
  JP.go.ipa.oz.user.ide.SchoolBrowser_if schoolBrowser;
  JP.go.ipa.oz.user.ide.LabelSelectItemListener_if selectIL;
  JP.go.ipa.oz.lib.standard._Choice_if choSubject;
  JP.go.ipa.oz.lib.standard._Checkbox_if rbtnSubject;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Frame_if parent, boolean modal, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if queue) throws Exception  {
// 37
    super._new_newDialog (parent, modal);
// 39
    schoolBrowser = (JP.go.ipa.oz.user.ide.SchoolBrowser_if) (parent);
// 40
    JP.go.ipa.oz.user.ide.School_if getSchool$val$674;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
      try {
        getSchool$val$674 = schoolBrowser.getSchool ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchool$val$674 = schoolBrowser.getSchool ();
    }
// 40
    school = getSchool$val$674;
// 43
    JP.go.ipa.oz.lib.standard._GridLayout_if grid1 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (4, 1, 10, 10);
// 44
    setLayout (grid1);
// 45
    addNotify ();
// 46
    setSize (300, 170);
// 47
    JP.go.ipa.oz.lib.standard._Font_if font = (JP.go.ipa.oz.lib.standard._Font_cl) (new JP.go.ipa.oz.lib.standard._Font_cl ())._new_newFont ((new JP.go.ipa.oz.lib.standard._String_cl("TimesRoman")), 12);
// 49
    group = (JP.go.ipa.oz.lib.standard._CheckboxGroup_cl) (new JP.go.ipa.oz.lib.standard._CheckboxGroup_cl ())._new_newCheckboxGroup ();
// 50
    rbtnSelected = (JP.go.ipa.oz.lib.standard._Checkbox_cl) (new JP.go.ipa.oz.lib.standard._Checkbox_cl ())._new_newCheckbox ((new JP.go.ipa.oz.lib.standard._String_cl("delete selected Labels.")), group, true);
// 51
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rbtnSelected)) {
      try {
        rbtnSelected.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      rbtnSelected.setFont (font);
    }
// 52
    add (rbtnSelected);
// 53
    rbtnSubject = (JP.go.ipa.oz.lib.standard._Checkbox_cl) (new JP.go.ipa.oz.lib.standard._Checkbox_cl ())._new_newCheckbox ((new JP.go.ipa.oz.lib.standard._String_cl("delete Labels belonging to the same Subject.")), group, false);
// 54
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rbtnSubject)) {
      try {
        rbtnSubject.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      rbtnSubject.setFont (font);
    }
// 55
    add (rbtnSubject);
// 56
    choSubject = (JP.go.ipa.oz.lib.standard._Choice_cl) (new JP.go.ipa.oz.lib.standard._Choice_cl ())._new_newChoice ();
// 57
    JP.go.ipa.oz.lib.standard._Iterator_if lblIterator = null;
// 58
    JP.go.ipa.oz.lib.standard._Dictionary_if getSubjects$val$675;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        getSubjects$val$675 = school.getSubjects ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSubjects$val$675 = school.getSubjects ();
    }
// 58
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$676;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSubjects$val$675)) {
      try {
        iterator$val$676 = getSubjects$val$675.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$676 = getSubjects$val$675.iterator ();
    }
// 58
    lblIterator = iterator$val$676;
// 59
    JP.go.ipa.oz.user.ide.Subject_if subject = null;
// 60
    while (true) {
// 60
      boolean hasMoreElements$val$677;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
        try {
          hasMoreElements$val$677 = lblIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$677 = lblIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$677)) break;
      
      /* body */ _loop_1: {
// 61
        JP.go.ipa.oz.lang._Root_if nextElement$val$678;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
          try {
            nextElement$val$678 = lblIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$678 = lblIterator.nextElement ();
        }
// 61
        subject = (JP.go.ipa.oz.user.ide.Subject_if) (nextElement$val$678);
// 62
        JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$679;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
          try {
            getSubjectName$val$679 = subject.getSubjectName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSubjectName$val$679 = subject.getSubjectName ();
        }
// 62
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
          try {
            choSubject.addItem (getSubjectName$val$679);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          choSubject.addItem (getSubjectName$val$679);
        }
      }
    }
// 64
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
      try {
        choSubject.setEnabled (false);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choSubject.setEnabled (false);
    }
// 65
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
      try {
        choSubject.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choSubject.setFont (font);
    }
// 66
    add (choSubject);
// 68
    JP.go.ipa.oz.lib.standard._FlowLayout_if flow = (JP.go.ipa.oz.lib.standard._FlowLayout_cl) (new JP.go.ipa.oz.lib.standard._FlowLayout_cl ())._new_newFlowLayout (1, 40, 3);
// 69
    JP.go.ipa.oz.lib.standard._Panel_if panel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (flow);
// 70
    add (panel);
// 71
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel)) {
      try {
        panel.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel.addNotify ();
    }
// 72
    btnOK = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("OK")));
// 73
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.setFont (font);
    }
// 74
    JP.go.ipa.oz.lib.standard._Component_if add$val$680;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel)) {
      try {
        add$val$680 = panel.add (btnOK);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$680 = panel.add (btnOK);
    }
// 75
    btnCancel = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("Cancel")));
// 76
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnCancel)) {
      try {
        btnCancel.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnCancel.setFont (font);
    }
// 77
    JP.go.ipa.oz.lib.standard._Component_if add$val$681;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel)) {
      try {
        add$val$681 = panel.add (btnCancel);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$681 = panel.add (btnCancel);
    }
// 79
    setTitle ((new JP.go.ipa.oz.lib.standard._String_cl("DELETE LABEL DIALOG")));
// 80
    JP.go.ipa.oz.lib.standard._List_if getLstLabel$val$682;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
      try {
        getLstLabel$val$682 = schoolBrowser.getLstLabel ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getLstLabel$val$682 = schoolBrowser.getLstLabel ();
    }
// 80
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$683;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getLstLabel$val$682)) {
      try {
        getSelectedItem$val$683 = getLstLabel$val$682.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$683 = getLstLabel$val$682.getSelectedItem ();
    }
// 80
    labelName = getSelectedItem$val$683;
// 85
    deleteAL = (JP.go.ipa.oz.user.ide.LabelDeleteActionListener_cl) (new JP.go.ipa.oz.user.ide.LabelDeleteActionListener_cl ())._new_create (this, queue);
// 86
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.addActionListener (deleteAL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.addActionListener (deleteAL);
    }
// 87
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnCancel)) {
      try {
        btnCancel.addActionListener (deleteAL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnCancel.addActionListener (deleteAL);
    }
// 88
    selectIL = (JP.go.ipa.oz.user.ide.LabelSelectItemListener_cl) (new JP.go.ipa.oz.user.ide.LabelSelectItemListener_cl ())._new_create (this, queue);
// 89
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rbtnSelected)) {
      try {
        rbtnSelected.addItemListener (selectIL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      rbtnSelected.addItemListener (selectIL);
    }
// 90
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rbtnSubject)) {
      try {
        rbtnSubject.addItemListener (selectIL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      rbtnSubject.addItemListener (selectIL);
    }
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getLabelName () throws Exception  {
    checkSecureInvocation ();
// 132
    return labelName;
  }
  
  public JP.go.ipa.oz.lib.standard._Choice_if getChoSubject () throws Exception  {
    checkSecureInvocation ();
// 150
    return choSubject;
  }
  
  public JP.go.ipa.oz.user.ide.School_if getSchool () throws Exception  {
    checkSecureInvocation ();
// 159
    return school;
  }
  
  public JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser () throws Exception  {
    checkSecureInvocation ();
// 168
    return schoolBrowser;
  }
  
  public JP.go.ipa.oz.lib.standard._Checkbox_if getRbtnSubject () throws Exception  {
    checkSecureInvocation ();
// 141
    return rbtnSubject;
  }
  
  public void setVisible (boolean b) throws Exception  {
    checkSecureInvocation ();
// 102
    JP.go.ipa.oz.lib.standard._Container_if getParent$val$684;
    getParent$val$684 = getParent ();
// 102
    JP.go.ipa.oz.lib.standard._Rectangle_if getBounds$val$685;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getParent$val$684)) {
      try {
        getBounds$val$685 = getParent$val$684.getBounds ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBounds$val$685 = getParent$val$684.getBounds ();
    }
// 102
    JP.go.ipa.oz.lib.standard._Rectangle_if bounds = getBounds$val$685;
// 103
    JP.go.ipa.oz.lib.standard._Rectangle_if abounds = getBounds ();
// 104
    int getX$val$686;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getX$val$686 = bounds.getX ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getX$val$686 = bounds.getX ();
    }
// 104
    int getWidth$val$687;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getWidth$val$687 = bounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$687 = bounds.getWidth ();
    }
// 104
    int getWidth$val$688;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getWidth$val$688 = abounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$688 = abounds.getWidth ();
    }
// 105
    int getY$val$689;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getY$val$689 = bounds.getY ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getY$val$689 = bounds.getY ();
    }
// 105
    int getHeight$val$690;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getHeight$val$690 = bounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$690 = bounds.getHeight ();
    }
// 105
    int getHeight$val$691;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getHeight$val$691 = abounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$691 = abounds.getHeight ();
    }
// 104
    setLocation (getX$val$686 + (getWidth$val$687 - getWidth$val$688) / 2, getY$val$689 + (getHeight$val$690 - getHeight$val$691) / 2);
// 107
    super.setVisible (b);
  }
  
  public LabelDeleteDialog_cl () throws Exception { super (); }
  
}


package JP.go.ipa.oz.user.ide;

public class SubjectDeleteDialog_cl extends JP.go.ipa.oz.lib.standard._Dialog_cl implements JP.go.ipa.oz.user.ide.SubjectDeleteDialog_if {
  JP.go.ipa.oz.user.ide.School_if school;
  JP.go.ipa.oz.user.ide.SchoolBrowser_if schoolBrowser;
  JP.go.ipa.oz.lib.standard._Button_if btnOK;
  JP.go.ipa.oz.lib.standard._Label_if lblSubject;
  JP.go.ipa.oz.user.ide.SubjectDeleteActionListener_if deleteAL;
  JP.go.ipa.oz.lib.standard._Button_if btnCancel;
  JP.go.ipa.oz.lib.standard._Choice_if choSubject;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Frame_if parent, boolean modal, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if queue) throws Exception  {
// 33
    super._new_newDialog (parent, modal);
// 35
    schoolBrowser = (JP.go.ipa.oz.user.ide.SchoolBrowser_if) (parent);
// 36
    JP.go.ipa.oz.user.ide.School_if getSchool$val$760;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
      try {
        getSchool$val$760 = schoolBrowser.getSchool ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchool$val$760 = schoolBrowser.getSchool ();
    }
// 36
    school = getSchool$val$760;
// 39
    JP.go.ipa.oz.lib.standard._GridLayout_if grid1 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (3, 1, 10, 10);
// 40
    setLayout (grid1);
// 41
    addNotify ();
// 42
    setSize (300, 130);
// 43
    JP.go.ipa.oz.lib.standard._Font_if font = (JP.go.ipa.oz.lib.standard._Font_cl) (new JP.go.ipa.oz.lib.standard._Font_cl ())._new_newFont ((new JP.go.ipa.oz.lib.standard._String_cl("TimesRoman")), 12);
// 44
    lblSubject = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("   You can remove the Subject, if it doesn't include labels.")));
// 45
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblSubject)) {
      try {
        lblSubject.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lblSubject.setFont (font);
    }
// 46
    add (lblSubject);
// 47
    choSubject = (JP.go.ipa.oz.lib.standard._Choice_cl) (new JP.go.ipa.oz.lib.standard._Choice_cl ())._new_newChoice ();
// 48
    JP.go.ipa.oz.lib.standard._Iterator_if lblIterator = null;
// 49
    JP.go.ipa.oz.lib.standard._Dictionary_if getSubjects$val$761;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        getSubjects$val$761 = school.getSubjects ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSubjects$val$761 = school.getSubjects ();
    }
// 49
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$762;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSubjects$val$761)) {
      try {
        iterator$val$762 = getSubjects$val$761.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$762 = getSubjects$val$761.iterator ();
    }
// 49
    lblIterator = iterator$val$762;
// 50
    JP.go.ipa.oz.user.ide.Subject_if subject = null;
// 51
    while (true) {
// 51
      boolean hasMoreElements$val$763;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
        try {
          hasMoreElements$val$763 = lblIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$763 = lblIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$763)) break;
      
      /* body */ _loop_1: {
// 52
        JP.go.ipa.oz.lang._Root_if nextElement$val$764;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
          try {
            nextElement$val$764 = lblIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$764 = lblIterator.nextElement ();
        }
// 52
        subject = (JP.go.ipa.oz.user.ide.Subject_if) (nextElement$val$764);
// 53
        JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$765;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
          try {
            getSubjectName$val$765 = subject.getSubjectName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSubjectName$val$765 = subject.getSubjectName ();
        }
// 53
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
          try {
            choSubject.addItem (getSubjectName$val$765);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          choSubject.addItem (getSubjectName$val$765);
        }
      }
    }
// 55
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
      try {
        choSubject.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choSubject.setFont (font);
    }
// 56
    add (choSubject);
// 58
    JP.go.ipa.oz.lib.standard._FlowLayout_if flow = (JP.go.ipa.oz.lib.standard._FlowLayout_cl) (new JP.go.ipa.oz.lib.standard._FlowLayout_cl ())._new_newFlowLayout (1, 40, 3);
// 59
    JP.go.ipa.oz.lib.standard._Panel_if panel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (flow);
// 60
    add (panel);
// 61
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel)) {
      try {
        panel.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel.addNotify ();
    }
// 62
    btnOK = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("OK")));
// 63
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.setFont (font);
    }
// 64
    JP.go.ipa.oz.lib.standard._Component_if add$val$766;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel)) {
      try {
        add$val$766 = panel.add (btnOK);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$766 = panel.add (btnOK);
    }
// 65
    btnCancel = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("Cancel")));
// 66
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnCancel)) {
      try {
        btnCancel.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnCancel.setFont (font);
    }
// 67
    JP.go.ipa.oz.lib.standard._Component_if add$val$767;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel)) {
      try {
        add$val$767 = panel.add (btnCancel);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$767 = panel.add (btnCancel);
    }
// 69
    setTitle ((new JP.go.ipa.oz.lib.standard._String_cl("SUBJECT DELETE DIALOG")));
// 72
    deleteAL = (JP.go.ipa.oz.user.ide.SubjectDeleteActionListener_cl) (new JP.go.ipa.oz.user.ide.SubjectDeleteActionListener_cl ())._new_create (this, queue);
// 73
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.addActionListener (deleteAL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.addActionListener (deleteAL);
    }
// 74
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnCancel)) {
      try {
        btnCancel.addActionListener (deleteAL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnCancel.addActionListener (deleteAL);
    }
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._Button_if getBtnOK () throws Exception  {
    checkSecureInvocation ();
// 110
    return btnOK;
  }
  
  public void removeSubject () throws Exception  {
    checkSecureInvocation ();
// 100
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$768;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
      try {
        getSelectedItem$val$768 = choSubject.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$768 = choSubject.getSelectedItem ();
    }
// 100
    JP.go.ipa.oz.lib.standard._String_if subjectName = getSelectedItem$val$768;
// 101
    JP.go.ipa.oz.user.ide.School_if removeSubject$val$769;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        removeSubject$val$769 = school.removeSubject (subjectName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      removeSubject$val$769 = school.removeSubject (subjectName);
    }
// 102
    JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$770;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
      try {
        getChoSubject$val$770 = schoolBrowser.getChoSubject ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getChoSubject$val$770 = schoolBrowser.getChoSubject ();
    }
// 102
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$770)) {
      try {
        getChoSubject$val$770.remove (subjectName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getChoSubject$val$770.remove (subjectName);
    }
  }
  
  public void setVisible (boolean b) throws Exception  {
    checkSecureInvocation ();
// 86
    JP.go.ipa.oz.lib.standard._Container_if getParent$val$771;
    getParent$val$771 = getParent ();
// 86
    JP.go.ipa.oz.lib.standard._Rectangle_if getBounds$val$772;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getParent$val$771)) {
      try {
        getBounds$val$772 = getParent$val$771.getBounds ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBounds$val$772 = getParent$val$771.getBounds ();
    }
// 86
    JP.go.ipa.oz.lib.standard._Rectangle_if bounds = getBounds$val$772;
// 87
    JP.go.ipa.oz.lib.standard._Rectangle_if abounds = getBounds ();
// 88
    int getX$val$773;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getX$val$773 = bounds.getX ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getX$val$773 = bounds.getX ();
    }
// 88
    int getWidth$val$774;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getWidth$val$774 = bounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$774 = bounds.getWidth ();
    }
// 88
    int getWidth$val$775;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getWidth$val$775 = abounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$775 = abounds.getWidth ();
    }
// 89
    int getY$val$776;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getY$val$776 = bounds.getY ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getY$val$776 = bounds.getY ();
    }
// 89
    int getHeight$val$777;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getHeight$val$777 = bounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$777 = bounds.getHeight ();
    }
// 89
    int getHeight$val$778;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getHeight$val$778 = abounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$778 = abounds.getHeight ();
    }
// 88
    setLocation (getX$val$773 + (getWidth$val$774 - getWidth$val$775) / 2, getY$val$776 + (getHeight$val$777 - getHeight$val$778) / 2);
// 91
    super.setVisible (b);
  }
  
  public SubjectDeleteDialog_cl () throws Exception { super (); }
  
}


package JP.go.ipa.oz.user.ide;

public class SubjectEditDialog_cl extends JP.go.ipa.oz.lib.standard._Dialog_cl implements JP.go.ipa.oz.user.ide.SubjectEditDialog_if {
  JP.go.ipa.oz.lib.standard._Button_if btnOK;
  JP.go.ipa.oz.user.ide.School_if school;
  JP.go.ipa.oz.lib.standard._Label_if lblSubject;
  JP.go.ipa.oz.lib.standard._TextField_if txtSubject;
  JP.go.ipa.oz.user.ide.SubjectEditActionListener_if editAL;
  JP.go.ipa.oz.lib.standard._Button_if btnCancel;
  JP.go.ipa.oz.user.ide.SchoolBrowser_if schoolBrowser;
  JP.go.ipa.oz.lib.standard._Choice_if choSubject;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Frame_if parent, boolean modal, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if queue) throws Exception  {
// 34
    super._new_newDialog (parent, modal);
// 36
    schoolBrowser = (JP.go.ipa.oz.user.ide.SchoolBrowser_if) (parent);
// 37
    JP.go.ipa.oz.user.ide.School_if getSchool$val$781;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
      try {
        getSchool$val$781 = schoolBrowser.getSchool ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchool$val$781 = schoolBrowser.getSchool ();
    }
// 37
    school = getSchool$val$781;
// 40
    JP.go.ipa.oz.lib.standard._GridLayout_if grid1 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (4, 1, 10, 10);
// 41
    setLayout (grid1);
// 42
    addNotify ();
// 43
    setSize (280, 170);
// 44
    JP.go.ipa.oz.lib.standard._Font_if font = (JP.go.ipa.oz.lib.standard._Font_cl) (new JP.go.ipa.oz.lib.standard._Font_cl ())._new_newFont ((new JP.go.ipa.oz.lib.standard._String_cl("TimesRoman")), 12);
// 45
    lblSubject = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("   Subject")));
// 46
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblSubject)) {
      try {
        lblSubject.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lblSubject.setFont (font);
    }
// 47
    add (lblSubject);
// 48
    txtSubject = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField ();
// 49
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtSubject)) {
      try {
        txtSubject.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      txtSubject.setFont (font);
    }
// 50
    add (txtSubject);
// 51
    choSubject = (JP.go.ipa.oz.lib.standard._Choice_cl) (new JP.go.ipa.oz.lib.standard._Choice_cl ())._new_newChoice ();
// 52
    JP.go.ipa.oz.lib.standard._Iterator_if lblIterator = null;
// 53
    JP.go.ipa.oz.lib.standard._Dictionary_if getSubjects$val$782;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        getSubjects$val$782 = school.getSubjects ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSubjects$val$782 = school.getSubjects ();
    }
// 53
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$783;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSubjects$val$782)) {
      try {
        iterator$val$783 = getSubjects$val$782.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$783 = getSubjects$val$782.iterator ();
    }
// 53
    lblIterator = iterator$val$783;
// 54
    JP.go.ipa.oz.user.ide.Subject_if subject = null;
// 55
    while (true) {
// 55
      boolean hasMoreElements$val$784;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
        try {
          hasMoreElements$val$784 = lblIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$784 = lblIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$784)) break;
      
      /* body */ _loop_1: {
// 56
        JP.go.ipa.oz.lang._Root_if nextElement$val$785;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
          try {
            nextElement$val$785 = lblIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$785 = lblIterator.nextElement ();
        }
// 56
        subject = (JP.go.ipa.oz.user.ide.Subject_if) (nextElement$val$785);
// 57
        JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$786;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
          try {
            getSubjectName$val$786 = subject.getSubjectName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSubjectName$val$786 = subject.getSubjectName ();
        }
// 57
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
          try {
            choSubject.addItem (getSubjectName$val$786);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          choSubject.addItem (getSubjectName$val$786);
        }
      }
    }
// 59
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
      try {
        choSubject.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choSubject.setFont (font);
    }
// 60
    add (choSubject);
// 62
    JP.go.ipa.oz.lib.standard._FlowLayout_if flow = (JP.go.ipa.oz.lib.standard._FlowLayout_cl) (new JP.go.ipa.oz.lib.standard._FlowLayout_cl ())._new_newFlowLayout (1, 40, 3);
// 63
    JP.go.ipa.oz.lib.standard._Panel_if panel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (flow);
// 64
    add (panel);
// 65
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel)) {
      try {
        panel.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel.addNotify ();
    }
// 66
    btnOK = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("OK")));
// 67
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.setFont (font);
    }
// 68
    JP.go.ipa.oz.lib.standard._Component_if add$val$787;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel)) {
      try {
        add$val$787 = panel.add (btnOK);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$787 = panel.add (btnOK);
    }
// 69
    btnCancel = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("Cancel")));
// 70
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnCancel)) {
      try {
        btnCancel.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnCancel.setFont (font);
    }
// 71
    JP.go.ipa.oz.lib.standard._Component_if add$val$788;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel)) {
      try {
        add$val$788 = panel.add (btnCancel);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$788 = panel.add (btnCancel);
    }
// 73
    setTitle ((new JP.go.ipa.oz.lib.standard._String_cl("SUBJECT MODIFY DIALOG")));
// 76
    editAL = (JP.go.ipa.oz.user.ide.SubjectEditActionListener_cl) (new JP.go.ipa.oz.user.ide.SubjectEditActionListener_cl ())._new_create (this, queue);
// 77
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.addActionListener (editAL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.addActionListener (editAL);
    }
// 78
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
  
  public JP.go.ipa.oz.lib.standard._Button_if getBtnOK () throws Exception  {
    checkSecureInvocation ();
// 121
    return btnOK;
  }
  
  public void removeSubject () throws Exception  {
    checkSecureInvocation ();
// 104
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$789;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
      try {
        getSelectedItem$val$789 = choSubject.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$789 = choSubject.getSelectedItem ();
    }
// 104
    JP.go.ipa.oz.lib.standard._String_if subjectNameOld = getSelectedItem$val$789;
// 105
    JP.go.ipa.oz.lib.standard._String_if getText$val$790;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtSubject)) {
      try {
        getText$val$790 = txtSubject.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$790 = txtSubject.getText ();
    }
// 105
    JP.go.ipa.oz.lib.standard._String_if subjectNameNew = getText$val$790;
    boolean bool$val$22;
    
// 106
    int compareTo$val$791;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjectNameOld)) {
      try {
        compareTo$val$791 = subjectNameOld.compareTo (subjectNameNew);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compareTo$val$791 = subjectNameOld.compareTo (subjectNameNew);
    }
    bool$val$22 = compareTo$val$791 != 0;
    if (bool$val$22) {
// 106
      JP.go.ipa.oz.lib.standard._String_if string$144 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
      
// 106
      int compareTo$val$792;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjectNameNew)) {
        try {
          compareTo$val$792 = subjectNameNew.compareTo (string$144);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        compareTo$val$792 = subjectNameNew.compareTo (string$144);
      }
      bool$val$22 = compareTo$val$792 != 0;
    }
// 106
    if (bool$val$22) {{
// 107
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
          try {
            school.renameSubject (subjectNameOld, subjectNameNew);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          school.renameSubject (subjectNameOld, subjectNameNew);
        }
// 108
        JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$793;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
          try {
            getChoSubject$val$793 = schoolBrowser.getChoSubject ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$793 = schoolBrowser.getChoSubject ();
        }
// 108
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$793)) {
          try {
            getChoSubject$val$793.remove (subjectNameOld);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$793.remove (subjectNameOld);
        }
// 109
        JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$794;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
          try {
            getChoSubject$val$794 = schoolBrowser.getChoSubject ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$794 = schoolBrowser.getChoSubject ();
        }
// 109
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$794)) {
          try {
            getChoSubject$val$794.addItem (subjectNameNew);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$794.addItem (subjectNameNew);
        }
// 110
        JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$795;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
          try {
            getChoSubject$val$795 = schoolBrowser.getChoSubject ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$795 = schoolBrowser.getChoSubject ();
        }
// 110
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$795)) {
          try {
            getChoSubject$val$795.select (subjectNameNew);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$795.select (subjectNameNew);
        }
// 111
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
          try {
            schoolBrowser.setSchoolList (subjectNameNew);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          schoolBrowser.setSchoolList (subjectNameNew);
        }
      }
    }
  }
  
  public void setVisible (boolean b) throws Exception  {
    checkSecureInvocation ();
// 90
    JP.go.ipa.oz.lib.standard._Container_if getParent$val$796;
    getParent$val$796 = getParent ();
// 90
    JP.go.ipa.oz.lib.standard._Rectangle_if getBounds$val$797;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getParent$val$796)) {
      try {
        getBounds$val$797 = getParent$val$796.getBounds ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBounds$val$797 = getParent$val$796.getBounds ();
    }
// 90
    JP.go.ipa.oz.lib.standard._Rectangle_if bounds = getBounds$val$797;
// 91
    JP.go.ipa.oz.lib.standard._Rectangle_if abounds = getBounds ();
// 92
    int getX$val$798;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getX$val$798 = bounds.getX ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getX$val$798 = bounds.getX ();
    }
// 92
    int getWidth$val$799;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getWidth$val$799 = bounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$799 = bounds.getWidth ();
    }
// 92
    int getWidth$val$800;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getWidth$val$800 = abounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$800 = abounds.getWidth ();
    }
// 93
    int getY$val$801;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getY$val$801 = bounds.getY ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getY$val$801 = bounds.getY ();
    }
// 93
    int getHeight$val$802;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getHeight$val$802 = bounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$802 = bounds.getHeight ();
    }
// 93
    int getHeight$val$803;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getHeight$val$803 = abounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$803 = abounds.getHeight ();
    }
// 92
    setLocation (getX$val$798 + (getWidth$val$799 - getWidth$val$800) / 2, getY$val$801 + (getHeight$val$802 - getHeight$val$803) / 2);
// 95
    super.setVisible (b);
  }
  
  public SubjectEditDialog_cl () throws Exception { super (); }
  
}


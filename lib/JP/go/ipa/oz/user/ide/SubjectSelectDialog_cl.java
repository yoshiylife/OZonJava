package JP.go.ipa.oz.user.ide;

public class SubjectSelectDialog_cl extends JP.go.ipa.oz.lib.standard._Dialog_cl implements JP.go.ipa.oz.user.ide.SubjectSelectDialog_if {
  JP.go.ipa.oz.user.ide.SubjectSelectActionListener_if selectAL;
  JP.go.ipa.oz.user.ide.School_if school;
  JP.go.ipa.oz.lib.standard._List_if lstSubject;
  JP.go.ipa.oz.user.ide.SchoolBrowser_if schoolBrowser;
  JP.go.ipa.oz.lib.standard._Button_if btnOK;
  JP.go.ipa.oz.lib.standard._Label_if lblSubject;
  JP.go.ipa.oz.lib.standard._Button_if btnCancel;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Frame_if parent, boolean modal, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if queue) throws Exception  {
// 33
    super._new_newDialog (parent, modal);
// 35
    schoolBrowser = (JP.go.ipa.oz.user.ide.SchoolBrowser_if) (parent);
// 36
    JP.go.ipa.oz.user.ide.School_if getSchool$val$901;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
      try {
        getSchool$val$901 = schoolBrowser.getSchool ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchool$val$901 = schoolBrowser.getSchool ();
    }
// 36
    school = getSchool$val$901;
// 39
    JP.go.ipa.oz.lib.standard._BorderLayout_if border = (JP.go.ipa.oz.lib.standard._BorderLayout_cl) (new JP.go.ipa.oz.lib.standard._BorderLayout_cl ())._new_newBorderLayout ();
// 40
    setLayout (border);
// 41
    addNotify ();
// 42
    setSize (300, 350);
// 43
    JP.go.ipa.oz.lib.standard._Font_if font = (JP.go.ipa.oz.lib.standard._Font_cl) (new JP.go.ipa.oz.lib.standard._Font_cl ())._new_newFont ((new JP.go.ipa.oz.lib.standard._String_cl("TimesRoman")), 12);
// 44
    lblSubject = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("   Select the subject you want to use.")));
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
    add ((new JP.go.ipa.oz.lib.standard._String_cl("North")), lblSubject);
// 48
    lstSubject = (JP.go.ipa.oz.lib.standard._List_cl) (new JP.go.ipa.oz.lib.standard._List_cl ())._new_newList (20, true);
// 49
    JP.go.ipa.oz.lib.standard._Iterator_if lblIterator = null;
// 50
    JP.go.ipa.oz.lib.standard._Dictionary_if getSubjects$val$902;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        getSubjects$val$902 = school.getSubjects ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSubjects$val$902 = school.getSubjects ();
    }
// 50
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$903;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSubjects$val$902)) {
      try {
        iterator$val$903 = getSubjects$val$902.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$903 = getSubjects$val$902.iterator ();
    }
// 50
    lblIterator = iterator$val$903;
// 51
    JP.go.ipa.oz.user.ide.Subject_if subject = null;
// 52
    while (true) {
// 52
      boolean hasMoreElements$val$904;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
        try {
          hasMoreElements$val$904 = lblIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$904 = lblIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$904)) break;
      
      /* body */ _loop_1: {
// 53
        JP.go.ipa.oz.lang._Root_if nextElement$val$905;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
          try {
            nextElement$val$905 = lblIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$905 = lblIterator.nextElement ();
        }
// 53
        subject = (JP.go.ipa.oz.user.ide.Subject_if) (nextElement$val$905);
// 54
        JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$906;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
          try {
            getSubjectName$val$906 = subject.getSubjectName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSubjectName$val$906 = subject.getSubjectName ();
        }
// 54
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstSubject)) {
          try {
            lstSubject.addItem (getSubjectName$val$906);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          lstSubject.addItem (getSubjectName$val$906);
        }
      }
    }
// 56
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstSubject)) {
      try {
        lstSubject.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lstSubject.setFont (font);
    }
// 57
    add ((new JP.go.ipa.oz.lib.standard._String_cl("Center")), lstSubject);
// 59
    JP.go.ipa.oz.lib.standard._FlowLayout_if flow = (JP.go.ipa.oz.lib.standard._FlowLayout_cl) (new JP.go.ipa.oz.lib.standard._FlowLayout_cl ())._new_newFlowLayout (1, 40, 3);
// 60
    JP.go.ipa.oz.lib.standard._Panel_if panel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (flow);
// 61
    add ((new JP.go.ipa.oz.lib.standard._String_cl("South")), panel);
// 62
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel)) {
      try {
        panel.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel.addNotify ();
    }
// 63
    btnOK = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("OK")));
// 64
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.setFont (font);
    }
// 65
    JP.go.ipa.oz.lib.standard._Component_if add$val$907;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel)) {
      try {
        add$val$907 = panel.add (btnOK);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$907 = panel.add (btnOK);
    }
// 66
    btnCancel = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("Cancel")));
// 67
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnCancel)) {
      try {
        btnCancel.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnCancel.setFont (font);
    }
// 68
    JP.go.ipa.oz.lib.standard._Component_if add$val$908;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel)) {
      try {
        add$val$908 = panel.add (btnCancel);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$908 = panel.add (btnCancel);
    }
// 70
    setTitle ((new JP.go.ipa.oz.lib.standard._String_cl("SUBJECT SELECT DIALOG")));
// 73
    selectAL = (JP.go.ipa.oz.user.ide.SubjectSelectActionListener_cl) (new JP.go.ipa.oz.user.ide.SubjectSelectActionListener_cl ())._new_create (this, queue);
// 74
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.addActionListener (selectAL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.addActionListener (selectAL);
    }
// 75
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnCancel)) {
      try {
        btnCancel.addActionListener (selectAL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnCancel.addActionListener (selectAL);
    }
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._Button_if getBtnOK () throws Exception  {
    checkSecureInvocation ();
// 125
    return btnOK;
  }
  
  public void selectSubjects () throws Exception  {
    checkSecureInvocation ();
// 96
    JP.go.ipa.oz.lib.standard._Array_if subjectNames = null;
// 97
    JP.go.ipa.oz.lib.standard._Collection_if getSelectedItems$val$909;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstSubject)) {
      try {
        getSelectedItems$val$909 = lstSubject.getSelectedItems ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItems$val$909 = lstSubject.getSelectedItems ();
    }
// 97
    subjectNames = (JP.go.ipa.oz.lib.standard._Array_if) (getSelectedItems$val$909);
// 98
    JP.go.ipa.oz.lib.standard._String_if subjectName = null;
// 99
    int size$val$910;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjectNames)) {
      try {
        size$val$910 = subjectNames.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$910 = subjectNames.size ();
    }
// 99
    int max = size$val$910;
// 100
    if (max == 0) {
// 100
      return;
    }
// 103
    JP.go.ipa.oz.lib.standard._Dictionary_if getSubjects$val$911;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        getSubjects$val$911 = school.getSubjects ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSubjects$val$911 = school.getSubjects ();
    }
// 103
    JP.go.ipa.oz.lib.standard._Dictionary_if subjects = getSubjects$val$911;
// 104
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$912;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjects)) {
      try {
        iterator$val$912 = subjects.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$912 = subjects.iterator ();
    }
// 104
    JP.go.ipa.oz.lib.standard._Iterator_if sbjIterator = iterator$val$912;
// 105
    JP.go.ipa.oz.user.ide.Subject_if subject = null;
// 106
    while (true) {
// 106
      boolean hasMoreElements$val$913;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbjIterator)) {
        try {
          hasMoreElements$val$913 = sbjIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$913 = sbjIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$913)) break;
      
      /* body */ _loop_1: {
// 107
        JP.go.ipa.oz.lang._Root_if nextElement$val$914;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbjIterator)) {
          try {
            nextElement$val$914 = sbjIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$914 = sbjIterator.nextElement ();
        }
// 107
        subject = (JP.go.ipa.oz.user.ide.Subject_if) (nextElement$val$914);
// 108
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
          try {
            subject.setUsing (false);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          subject.setUsing (false);
        }
      }
    }
// 110
    JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$915;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
      try {
        getChoSubject$val$915 = schoolBrowser.getChoSubject ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getChoSubject$val$915 = schoolBrowser.getChoSubject ();
    }
// 110
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$915)) {
      try {
        getChoSubject$val$915.removeAll ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getChoSubject$val$915.removeAll ();
    }
// 113
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < max)) break;
        
        /* body */ _loop_1: {
// 114
          JP.go.ipa.oz.lang._Root_if at$val$916;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjectNames)) {
            try {
              at$val$916 = subjectNames.at (i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            at$val$916 = subjectNames.at (i);
          }
// 114
          subjectName = (JP.go.ipa.oz.lib.standard._String_if) (at$val$916);
// 115
          JP.go.ipa.oz.user.ide.Subject_if getSubject$val$917;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
            try {
              getSubject$val$917 = school.getSubject (subjectName);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getSubject$val$917 = school.getSubject (subjectName);
          }
// 115
          subject = getSubject$val$917;
// 116
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
            try {
              subject.setUsing (true);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            subject.setUsing (true);
          }
// 117
          JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$918;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
            try {
              getChoSubject$val$918 = schoolBrowser.getChoSubject ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getChoSubject$val$918 = schoolBrowser.getChoSubject ();
          }
// 117
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$918)) {
            try {
              getChoSubject$val$918.addItem (subjectName);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getChoSubject$val$918.addItem (subjectName);
          }
        }
        /* iteration part */
// 113
        i++;
      }
    }
// 119
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
      try {
        schoolBrowser.setSchoolList (subjectName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      schoolBrowser.setSchoolList (subjectName);
    }
  }
  
  public void setVisible (boolean b) throws Exception  {
    checkSecureInvocation ();
// 84
    JP.go.ipa.oz.lib.standard._Container_if getParent$val$919;
    getParent$val$919 = getParent ();
// 84
    JP.go.ipa.oz.lib.standard._Rectangle_if getBounds$val$920;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getParent$val$919)) {
      try {
        getBounds$val$920 = getParent$val$919.getBounds ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBounds$val$920 = getParent$val$919.getBounds ();
    }
// 84
    JP.go.ipa.oz.lib.standard._Rectangle_if bounds = getBounds$val$920;
// 85
    JP.go.ipa.oz.lib.standard._Rectangle_if abounds = getBounds ();
// 86
    int getX$val$921;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getX$val$921 = bounds.getX ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getX$val$921 = bounds.getX ();
    }
// 86
    int getWidth$val$922;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getWidth$val$922 = bounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$922 = bounds.getWidth ();
    }
// 86
    int getWidth$val$923;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getWidth$val$923 = abounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$923 = abounds.getWidth ();
    }
// 87
    int getY$val$924;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getY$val$924 = bounds.getY ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getY$val$924 = bounds.getY ();
    }
// 87
    int getHeight$val$925;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getHeight$val$925 = bounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$925 = bounds.getHeight ();
    }
// 87
    int getHeight$val$926;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getHeight$val$926 = abounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$926 = abounds.getHeight ();
    }
// 86
    setLocation (getX$val$921 + (getWidth$val$922 - getWidth$val$923) / 2, getY$val$924 + (getHeight$val$925 - getHeight$val$926) / 2);
// 89
    super.setVisible (b);
  }
  
  public SubjectSelectDialog_cl () throws Exception { super (); }
  
}


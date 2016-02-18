package JP.go.ipa.oz.user.ide;

public class SubjectAddDialog_cl extends JP.go.ipa.oz.lib.standard._Dialog_cl implements JP.go.ipa.oz.user.ide.SubjectAddDialog_if {
  JP.go.ipa.oz.user.ide.SubjectAddActionListener_if addAL;
  JP.go.ipa.oz.user.ide.School_if school;
  JP.go.ipa.oz.user.ide.SchoolBrowser_if schoolBrowser;
  JP.go.ipa.oz.lib.standard._Button_if btnOK;
  JP.go.ipa.oz.lib.standard._Label_if lblSubject;
  JP.go.ipa.oz.lib.standard._Button_if btnCancel;
  JP.go.ipa.oz.lib.standard._TextField_if txtSubject;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Frame_if parent, boolean modal, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if queue) throws Exception  {
// 33
    super._new_newDialog (parent, modal);
// 35
    schoolBrowser = (JP.go.ipa.oz.user.ide.SchoolBrowser_if) (parent);
// 36
    JP.go.ipa.oz.user.ide.School_if getSchool$val$741;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
      try {
        getSchool$val$741 = schoolBrowser.getSchool ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchool$val$741 = schoolBrowser.getSchool ();
    }
// 36
    school = getSchool$val$741;
// 39
    JP.go.ipa.oz.lib.standard._GridLayout_if grid1 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (3, 1, 10, 10);
// 40
    setLayout (grid1);
// 41
    addNotify ();
// 42
    setSize (280, 130);
// 43
    JP.go.ipa.oz.lib.standard._Font_if font = (JP.go.ipa.oz.lib.standard._Font_cl) (new JP.go.ipa.oz.lib.standard._Font_cl ())._new_newFont ((new JP.go.ipa.oz.lib.standard._String_cl("TimesRoman")), 12);
// 44
    lblSubject = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("   Subject")));
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
// 48
    JP.go.ipa.oz.lib.standard._FlowLayout_if flow1 = (JP.go.ipa.oz.lib.standard._FlowLayout_cl) (new JP.go.ipa.oz.lib.standard._FlowLayout_cl ())._new_newFlowLayout (1, 40, 3);
// 49
    JP.go.ipa.oz.lib.standard._Panel_if panel1 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (flow1);
// 50
    add (panel1);
// 51
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        panel1.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel1.addNotify ();
    }
// 52
    txtSubject = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField (30);
// 53
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtSubject)) {
      try {
        txtSubject.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      txtSubject.setFont (font);
    }
// 54
    JP.go.ipa.oz.lib.standard._Component_if add$val$742;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        add$val$742 = panel1.add (txtSubject);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$742 = panel1.add (txtSubject);
    }
// 56
    JP.go.ipa.oz.lib.standard._FlowLayout_if flow2 = (JP.go.ipa.oz.lib.standard._FlowLayout_cl) (new JP.go.ipa.oz.lib.standard._FlowLayout_cl ())._new_newFlowLayout (1, 40, 3);
// 57
    JP.go.ipa.oz.lib.standard._Panel_if panel2 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (flow2);
// 58
    add (panel2);
// 59
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        panel2.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel2.addNotify ();
    }
// 60
    btnOK = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("OK")));
// 61
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.setFont (font);
    }
// 62
    JP.go.ipa.oz.lib.standard._Component_if add$val$743;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$743 = panel2.add (btnOK);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$743 = panel2.add (btnOK);
    }
// 63
    btnCancel = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("Cancel")));
// 64
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnCancel)) {
      try {
        btnCancel.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnCancel.setFont (font);
    }
// 65
    JP.go.ipa.oz.lib.standard._Component_if add$val$744;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$744 = panel2.add (btnCancel);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$744 = panel2.add (btnCancel);
    }
// 67
    setTitle ((new JP.go.ipa.oz.lib.standard._String_cl("ADD SUBJECT DIALOG")));
// 70
    addAL = (JP.go.ipa.oz.user.ide.SubjectAddActionListener_cl) (new JP.go.ipa.oz.user.ide.SubjectAddActionListener_cl ())._new_create (this, queue);
// 71
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.addActionListener (addAL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.addActionListener (addAL);
    }
// 72
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
  
  public JP.go.ipa.oz.lib.standard._Button_if getBtnOK () throws Exception  {
    checkSecureInvocation ();
// 112
    return btnOK;
  }
  
  public void addSubject () throws Exception  {
    checkSecureInvocation ();
// 98
    JP.go.ipa.oz.lib.standard._String_if getText$val$745;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtSubject)) {
      try {
        getText$val$745 = txtSubject.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$745 = txtSubject.getText ();
    }
// 98
    JP.go.ipa.oz.lib.standard._String_if subjectName = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (getText$val$745);
// 99
    JP.go.ipa.oz.lib.standard._String_if string$141 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    
// 99
    int compareTo$val$746;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjectName)) {
      try {
        compareTo$val$746 = subjectName.compareTo (string$141);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compareTo$val$746 = subjectName.compareTo (string$141);
    }
// 99
    if (compareTo$val$746 != 0) {{
// 100
        JP.go.ipa.oz.lib.standard._String_if getText$val$747;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtSubject)) {
          try {
            getText$val$747 = txtSubject.getText ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getText$val$747 = txtSubject.getText ();
        }
// 100
        JP.go.ipa.oz.user.ide.Subject_if subject = (JP.go.ipa.oz.user.ide.Subject_cl) (new JP.go.ipa.oz.user.ide.Subject_cl ())._new_create (getText$val$747);
// 101
        JP.go.ipa.oz.user.ide.School_if putSubject$val$748;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
          try {
            putSubject$val$748 = school.putSubject (subject);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          putSubject$val$748 = school.putSubject (subject);
        }
// 102
        JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$749;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
          try {
            getChoSubject$val$749 = schoolBrowser.getChoSubject ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$749 = schoolBrowser.getChoSubject ();
        }
// 102
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$749)) {
          try {
            getChoSubject$val$749.addItem (subjectName);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$749.addItem (subjectName);
        }
      }
    }
  }
  
  public void setVisible (boolean b) throws Exception  {
    checkSecureInvocation ();
// 84
    JP.go.ipa.oz.lib.standard._Container_if getParent$val$750;
    getParent$val$750 = getParent ();
// 84
    JP.go.ipa.oz.lib.standard._Rectangle_if getBounds$val$751;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getParent$val$750)) {
      try {
        getBounds$val$751 = getParent$val$750.getBounds ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBounds$val$751 = getParent$val$750.getBounds ();
    }
// 84
    JP.go.ipa.oz.lib.standard._Rectangle_if bounds = getBounds$val$751;
// 85
    JP.go.ipa.oz.lib.standard._Rectangle_if abounds = getBounds ();
// 86
    int getX$val$752;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getX$val$752 = bounds.getX ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getX$val$752 = bounds.getX ();
    }
// 86
    int getWidth$val$753;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getWidth$val$753 = bounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$753 = bounds.getWidth ();
    }
// 86
    int getWidth$val$754;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getWidth$val$754 = abounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$754 = abounds.getWidth ();
    }
// 87
    int getY$val$755;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getY$val$755 = bounds.getY ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getY$val$755 = bounds.getY ();
    }
// 87
    int getHeight$val$756;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getHeight$val$756 = bounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$756 = bounds.getHeight ();
    }
// 87
    int getHeight$val$757;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getHeight$val$757 = abounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$757 = abounds.getHeight ();
    }
// 86
    setLocation (getX$val$752 + (getWidth$val$753 - getWidth$val$754) / 2, getY$val$755 + (getHeight$val$756 - getHeight$val$757) / 2);
// 89
    super.setVisible (b);
  }
  
  public SubjectAddDialog_cl () throws Exception { super (); }
  
}


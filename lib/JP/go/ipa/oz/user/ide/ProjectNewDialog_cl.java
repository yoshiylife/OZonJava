package JP.go.ipa.oz.user.ide;

public class ProjectNewDialog_cl extends JP.go.ipa.oz.lib.standard._Dialog_cl implements JP.go.ipa.oz.user.ide.ProjectNewDialog_if {
  JP.go.ipa.oz.user.ide.ProjectManager_if projectManager;
  JP.go.ipa.oz.user.ide.ProjectNewActionListener_if addAL;
  JP.go.ipa.oz.lib.standard._Button_if btnOK;
  JP.go.ipa.oz.lib.standard._Label_if lblProject;
  JP.go.ipa.oz.lib.standard._Button_if btnCancel;
  JP.go.ipa.oz.lib.standard._TextField_if txtProjectName;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Frame_if parent, boolean modal, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if queue) throws Exception  {
// 32
    super._new_newDialog (parent, modal);
// 34
    projectManager = (JP.go.ipa.oz.user.ide.ProjectManager_if) (parent);
// 37
    JP.go.ipa.oz.lib.standard._GridLayout_if grid1 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (3, 1, 10, 10);
// 38
    setLayout (grid1);
// 39
    addNotify ();
// 40
    setSize (280, 130);
// 41
    JP.go.ipa.oz.lib.standard._Font_if font = (JP.go.ipa.oz.lib.standard._Font_cl) (new JP.go.ipa.oz.lib.standard._Font_cl ())._new_newFont ((new JP.go.ipa.oz.lib.standard._String_cl("TimesRoman")), 12);
// 42
    lblProject = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("   Project Name")));
// 43
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblProject)) {
      try {
        lblProject.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lblProject.setFont (font);
    }
// 44
    add (lblProject);
// 46
    JP.go.ipa.oz.lib.standard._FlowLayout_if flow1 = (JP.go.ipa.oz.lib.standard._FlowLayout_cl) (new JP.go.ipa.oz.lib.standard._FlowLayout_cl ())._new_newFlowLayout (1, 40, 3);
// 47
    JP.go.ipa.oz.lib.standard._Panel_if panel1 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (flow1);
// 48
    add (panel1);
// 49
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        panel1.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel1.addNotify ();
    }
// 50
    txtProjectName = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField (30);
// 51
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtProjectName)) {
      try {
        txtProjectName.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      txtProjectName.setFont (font);
    }
// 52
    JP.go.ipa.oz.lib.standard._Component_if add$val$319;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        add$val$319 = panel1.add (txtProjectName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$319 = panel1.add (txtProjectName);
    }
// 54
    JP.go.ipa.oz.lib.standard._FlowLayout_if flow2 = (JP.go.ipa.oz.lib.standard._FlowLayout_cl) (new JP.go.ipa.oz.lib.standard._FlowLayout_cl ())._new_newFlowLayout (1, 40, 3);
// 55
    JP.go.ipa.oz.lib.standard._Panel_if panel2 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (flow2);
// 56
    add (panel2);
// 57
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        panel2.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel2.addNotify ();
    }
// 58
    btnOK = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("OK")));
// 59
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.setFont (font);
    }
// 60
    JP.go.ipa.oz.lib.standard._Component_if add$val$320;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$320 = panel2.add (btnOK);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$320 = panel2.add (btnOK);
    }
// 61
    btnCancel = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("Cancel")));
// 62
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnCancel)) {
      try {
        btnCancel.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnCancel.setFont (font);
    }
// 63
    JP.go.ipa.oz.lib.standard._Component_if add$val$321;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$321 = panel2.add (btnCancel);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$321 = panel2.add (btnCancel);
    }
// 65
    setTitle ((new JP.go.ipa.oz.lib.standard._String_cl("NEW PROJECT DIALOG")));
// 68
    addAL = (JP.go.ipa.oz.user.ide.ProjectNewActionListener_cl) (new JP.go.ipa.oz.user.ide.ProjectNewActionListener_cl ())._new_create (this, queue);
// 69
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.addActionListener (addAL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.addActionListener (addAL);
    }
// 70
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
  
  public JP.go.ipa.oz.lib.standard._String_if getProjectName () throws Exception  {
    checkSecureInvocation ();
// 96
    JP.go.ipa.oz.lib.standard._String_if getText$val$322;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtProjectName)) {
      try {
        getText$val$322 = txtProjectName.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$322 = txtProjectName.getText ();
    }
// 96
    return getText$val$322;
  }
  
  public void addProject () throws Exception  {
    checkSecureInvocation ();
// 106
    JP.go.ipa.oz.lib.standard._Dictionary_if getProjects$val$323;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectManager)) {
      try {
        getProjects$val$323 = projectManager.getProjects ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getProjects$val$323 = projectManager.getProjects ();
    }
// 106
    JP.go.ipa.oz.lib.standard._Dictionary_if dict = getProjects$val$323;
// 107
    JP.go.ipa.oz.lib.standard._String_if projectName = null;
// 108
    JP.go.ipa.oz.lib.standard._String_if getText$val$324;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtProjectName)) {
      try {
        getText$val$324 = txtProjectName.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$324 = txtProjectName.getText ();
    }
// 108
    projectName = getText$val$324;
// 109
    JP.go.ipa.oz.lib.standard._String_if string$89 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    
// 109
    int compareTo$val$325;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectName)) {
      try {
        compareTo$val$325 = projectName.compareTo (string$89);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compareTo$val$325 = projectName.compareTo (string$89);
    }
// 109
    if (compareTo$val$325 != 0) {{
// 110
        JP.go.ipa.oz.user.ide.Project_if prj = (JP.go.ipa.oz.user.ide.Project_cl) (new JP.go.ipa.oz.user.ide.Project_cl ())._new_create (projectName);
// 111
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectManager)) {
          try {
            projectManager.setProjectName (projectName);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          projectManager.setProjectName (projectName);
        }
// 112
        JP.go.ipa.oz.lib.standard._Dictionary_if put$val$326;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dict)) {
          try {
            put$val$326 = dict.put (projectName, prj);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          put$val$326 = dict.put (projectName, prj);
        }
// 115
        JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("OZ Project Manager [")));
// 116
        JP.go.ipa.oz.lib.standard._List_if getSrcList$val$327;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectManager)) {
          try {
            getSrcList$val$327 = projectManager.getSrcList ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSrcList$val$327 = projectManager.getSrcList ();
        }
// 116
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSrcList$val$327)) {
          try {
            getSrcList$val$327.removeAll ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSrcList$val$327.removeAll ();
        }
// 117
        JP.go.ipa.oz.lib.standard._String_if getProjectName$val$328;
        getProjectName$val$328 = getProjectName ();
// 117
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$329;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$329 = buf.append (getProjectName$val$328);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$329 = buf.append (getProjectName$val$328);
        }
// 118
        JP.go.ipa.oz.lib.standard._String_if string$90 = (new JP.go.ipa.oz.lib.standard._String_cl("]"));
        
// 118
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$330;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$330 = buf.append (string$90);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$330 = buf.append (string$90);
        }
// 119
        JP.go.ipa.oz.lib.standard._String_if asString$val$331;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            asString$val$331 = buf.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$331 = buf.asString ();
        }
// 119
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectManager)) {
          try {
            projectManager.setTitle (asString$val$331);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          projectManager.setTitle (asString$val$331);
        }
      }
    }
  }
  
  public void setVisible (boolean b) throws Exception  {
    checkSecureInvocation ();
// 82
    JP.go.ipa.oz.lib.standard._Container_if getParent$val$332;
    getParent$val$332 = getParent ();
// 82
    JP.go.ipa.oz.lib.standard._Rectangle_if getBounds$val$333;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getParent$val$332)) {
      try {
        getBounds$val$333 = getParent$val$332.getBounds ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBounds$val$333 = getParent$val$332.getBounds ();
    }
// 82
    JP.go.ipa.oz.lib.standard._Rectangle_if bounds = getBounds$val$333;
// 83
    JP.go.ipa.oz.lib.standard._Rectangle_if abounds = getBounds ();
// 84
    int getX$val$334;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getX$val$334 = bounds.getX ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getX$val$334 = bounds.getX ();
    }
// 84
    int getWidth$val$335;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getWidth$val$335 = bounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$335 = bounds.getWidth ();
    }
// 84
    int getWidth$val$336;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getWidth$val$336 = abounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$336 = abounds.getWidth ();
    }
// 85
    int getY$val$337;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getY$val$337 = bounds.getY ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getY$val$337 = bounds.getY ();
    }
// 85
    int getHeight$val$338;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getHeight$val$338 = bounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$338 = bounds.getHeight ();
    }
// 85
    int getHeight$val$339;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getHeight$val$339 = abounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$339 = abounds.getHeight ();
    }
// 84
    setLocation (getX$val$334 + (getWidth$val$335 - getWidth$val$336) / 2, getY$val$337 + (getHeight$val$338 - getHeight$val$339) / 2);
// 87
    super.setVisible (b);
  }
  
  public ProjectNewDialog_cl () throws Exception { super (); }
  
}


package JP.go.ipa.oz.user.ide;

public class ProjectRemoveDialog_cl extends JP.go.ipa.oz.lib.standard._Dialog_cl implements JP.go.ipa.oz.user.ide.ProjectRemoveDialog_if {
  JP.go.ipa.oz.user.ide.ProjectManager_if projectManager;
  JP.go.ipa.oz.user.ide.ProjectRemoveActionListener_if addAL;
  JP.go.ipa.oz.lib.standard._Button_if btnOK;
  JP.go.ipa.oz.lib.standard._List_if lstProjectName;
  JP.go.ipa.oz.lib.standard._Label_if lblProject;
  JP.go.ipa.oz.lib.standard._Button_if btnCancel;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Frame_if parent, boolean modal, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if queue) throws Exception  {
// 32
    super._new_newDialog (parent, modal);
// 34
    projectManager = (JP.go.ipa.oz.user.ide.ProjectManager_if) (parent);
// 37
    JP.go.ipa.oz.lib.standard._BorderLayout_if border = (JP.go.ipa.oz.lib.standard._BorderLayout_cl) (new JP.go.ipa.oz.lib.standard._BorderLayout_cl ())._new_newBorderLayout ();
// 38
    setLayout (border);
// 39
    addNotify ();
// 40
    setSize (300, 250);
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
    add ((new JP.go.ipa.oz.lib.standard._String_cl("North")), lblProject);
// 46
    lstProjectName = (JP.go.ipa.oz.lib.standard._List_cl) (new JP.go.ipa.oz.lib.standard._List_cl ())._new_newList (20, false);
// 47
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstProjectName)) {
      try {
        lstProjectName.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lstProjectName.setFont (font);
    }
// 48
    add ((new JP.go.ipa.oz.lib.standard._String_cl("Center")), lstProjectName);
// 50
    JP.go.ipa.oz.lib.standard._FlowLayout_if flow = (JP.go.ipa.oz.lib.standard._FlowLayout_cl) (new JP.go.ipa.oz.lib.standard._FlowLayout_cl ())._new_newFlowLayout (1, 40, 3);
// 51
    JP.go.ipa.oz.lib.standard._Panel_if panel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (flow);
// 52
    add ((new JP.go.ipa.oz.lib.standard._String_cl("South")), panel);
// 53
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel)) {
      try {
        panel.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel.addNotify ();
    }
// 54
    btnOK = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("OK")));
// 55
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.setFont (font);
    }
// 56
    JP.go.ipa.oz.lib.standard._Component_if add$val$403;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel)) {
      try {
        add$val$403 = panel.add (btnOK);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$403 = panel.add (btnOK);
    }
// 57
    btnCancel = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("Cancel")));
// 58
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnCancel)) {
      try {
        btnCancel.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnCancel.setFont (font);
    }
// 59
    JP.go.ipa.oz.lib.standard._Component_if add$val$404;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel)) {
      try {
        add$val$404 = panel.add (btnCancel);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$404 = panel.add (btnCancel);
    }
// 61
    setTitle ((new JP.go.ipa.oz.lib.standard._String_cl("REMOVE PROJECT DIALOG")));
// 64
    JP.go.ipa.oz.lib.standard._Dictionary_if getProjects$val$405;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectManager)) {
      try {
        getProjects$val$405 = projectManager.getProjects ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getProjects$val$405 = projectManager.getProjects ();
    }
// 64
    JP.go.ipa.oz.lib.standard._Dictionary_if dict = getProjects$val$405;
// 65
    JP.go.ipa.oz.lib.standard._Iterator_if lblIterator = null;
// 66
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$406;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dict)) {
      try {
        iterator$val$406 = dict.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$406 = dict.iterator ();
    }
// 66
    lblIterator = iterator$val$406;
// 67
    JP.go.ipa.oz.user.ide.Project_if prj = null;
// 68
    while (true) {
// 68
      boolean hasMoreElements$val$407;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
        try {
          hasMoreElements$val$407 = lblIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$407 = lblIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$407)) break;
      
      /* body */ _loop_1: {
// 69
        JP.go.ipa.oz.lang._Root_if nextElement$val$408;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
          try {
            nextElement$val$408 = lblIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$408 = lblIterator.nextElement ();
        }
// 69
        prj = (JP.go.ipa.oz.user.ide.Project_if) (nextElement$val$408);
// 70
        JP.go.ipa.oz.lib.standard._String_if getProjectName$val$409;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
          try {
            getProjectName$val$409 = prj.getProjectName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getProjectName$val$409 = prj.getProjectName ();
        }
// 70
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstProjectName)) {
          try {
            lstProjectName.addItem (getProjectName$val$409);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          lstProjectName.addItem (getProjectName$val$409);
        }
      }
    }
// 76
    addAL = (JP.go.ipa.oz.user.ide.ProjectRemoveActionListener_cl) (new JP.go.ipa.oz.user.ide.ProjectRemoveActionListener_cl ())._new_create (this, queue);
// 77
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.addActionListener (addAL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.addActionListener (addAL);
    }
// 78
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
// 120
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$410;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstProjectName)) {
      try {
        getSelectedItem$val$410 = lstProjectName.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$410 = lstProjectName.getSelectedItem ();
    }
// 120
    return getSelectedItem$val$410;
  }
  
  public void removeProject () throws Exception  {
    checkSecureInvocation ();
// 130
    JP.go.ipa.oz.lib.standard._String_if projectName = null;
// 131
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$411;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstProjectName)) {
      try {
        getSelectedItem$val$411 = lstProjectName.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$411 = lstProjectName.getSelectedItem ();
    }
// 131
    projectName = getSelectedItem$val$411;
// 132
    if (projectName == null) {
// 132
      return;
    }
// 133
    JP.go.ipa.oz.lib.standard._String_if getProjectName$val$412;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectManager)) {
      try {
        getProjectName$val$412 = projectManager.getProjectName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getProjectName$val$412 = projectManager.getProjectName ();
    }
// 133
    int compareTo$val$413;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getProjectName$val$412)) {
      try {
        compareTo$val$413 = getProjectName$val$412.compareTo (projectName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compareTo$val$413 = getProjectName$val$412.compareTo (projectName);
    }
// 133
    if (compareTo$val$413 == 0) {
// 133
      return;
    }
// 136
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstProjectName)) {
      try {
        lstProjectName.remove (projectName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lstProjectName.remove (projectName);
    }
// 138
    JP.go.ipa.oz.lib.standard._Dictionary_if getProjects$val$414;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectManager)) {
      try {
        getProjects$val$414 = projectManager.getProjects ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getProjects$val$414 = projectManager.getProjects ();
    }
// 138
    JP.go.ipa.oz.lib.standard._Dictionary_if dict = getProjects$val$414;
// 139
    JP.go.ipa.oz.lib.standard._Dictionary_if remove$val$415;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dict)) {
      try {
        remove$val$415 = dict.remove (projectName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      remove$val$415 = dict.remove (projectName);
    }
  }
  
  public void setVisible (boolean b) throws Exception  {
    checkSecureInvocation ();
// 90
    JP.go.ipa.oz.lib.standard._Container_if getParent$val$416;
    getParent$val$416 = getParent ();
// 90
    JP.go.ipa.oz.lib.standard._Rectangle_if getBounds$val$417;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getParent$val$416)) {
      try {
        getBounds$val$417 = getParent$val$416.getBounds ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBounds$val$417 = getParent$val$416.getBounds ();
    }
// 90
    JP.go.ipa.oz.lib.standard._Rectangle_if bounds = getBounds$val$417;
// 91
    JP.go.ipa.oz.lib.standard._Rectangle_if abounds = getBounds ();
// 92
    int getX$val$418;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getX$val$418 = bounds.getX ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getX$val$418 = bounds.getX ();
    }
// 92
    int getWidth$val$419;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getWidth$val$419 = bounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$419 = bounds.getWidth ();
    }
// 92
    int getWidth$val$420;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getWidth$val$420 = abounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$420 = abounds.getWidth ();
    }
// 93
    int getY$val$421;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getY$val$421 = bounds.getY ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getY$val$421 = bounds.getY ();
    }
// 93
    int getHeight$val$422;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getHeight$val$422 = bounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$422 = bounds.getHeight ();
    }
// 93
    int getHeight$val$423;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getHeight$val$423 = abounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$423 = abounds.getHeight ();
    }
// 92
    setLocation (getX$val$418 + (getWidth$val$419 - getWidth$val$420) / 2, getY$val$421 + (getHeight$val$422 - getHeight$val$423) / 2);
// 95
    super.setVisible (b);
  }
  
  public ProjectRemoveDialog_cl () throws Exception { super (); }
  
}


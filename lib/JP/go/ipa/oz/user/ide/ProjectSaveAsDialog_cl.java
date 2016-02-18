package JP.go.ipa.oz.user.ide;

public class ProjectSaveAsDialog_cl extends JP.go.ipa.oz.lib.standard._Dialog_cl implements JP.go.ipa.oz.user.ide.ProjectSaveAsDialog_if {
  JP.go.ipa.oz.user.ide.ProjectManager_if projectManager;
  JP.go.ipa.oz.user.ide.ProjectSaveAsActionListener_if addAL;
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
    JP.go.ipa.oz.lib.standard._Component_if add$val$376;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        add$val$376 = panel1.add (txtProjectName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$376 = panel1.add (txtProjectName);
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
    JP.go.ipa.oz.lib.standard._Component_if add$val$377;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$377 = panel2.add (btnOK);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$377 = panel2.add (btnOK);
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
    JP.go.ipa.oz.lib.standard._Component_if add$val$378;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$378 = panel2.add (btnCancel);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$378 = panel2.add (btnCancel);
    }
// 65
    setTitle ((new JP.go.ipa.oz.lib.standard._String_cl("SAVE AS PROJECT DIALOG")));
// 67
    JP.go.ipa.oz.lib.standard._String_if getProjectName$val$379;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectManager)) {
      try {
        getProjectName$val$379 = projectManager.getProjectName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getProjectName$val$379 = projectManager.getProjectName ();
    }
// 67
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtProjectName)) {
      try {
        txtProjectName.setText (getProjectName$val$379);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      txtProjectName.setText (getProjectName$val$379);
    }
// 72
    addAL = (JP.go.ipa.oz.user.ide.ProjectSaveAsActionListener_cl) (new JP.go.ipa.oz.user.ide.ProjectSaveAsActionListener_cl ())._new_create (this, queue);
// 73
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.addActionListener (addAL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.addActionListener (addAL);
    }
// 74
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
  
  public void saveAsProject () throws Exception  {
    checkSecureInvocation ();
// 126
    JP.go.ipa.oz.lib.standard._String_if projectName = null;
// 127
    JP.go.ipa.oz.lib.standard._String_if getText$val$380;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtProjectName)) {
      try {
        getText$val$380 = txtProjectName.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$380 = txtProjectName.getText ();
    }
// 127
    projectName = getText$val$380;
// 128
    JP.go.ipa.oz.lib.standard._String_if string$94 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    
// 128
    int compareTo$val$381;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectName)) {
      try {
        compareTo$val$381 = projectName.compareTo (string$94);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compareTo$val$381 = projectName.compareTo (string$94);
    }
// 128
    if (compareTo$val$381 != 0) {{
// 129
        int size = 0;
// 130
        JP.go.ipa.oz.lib.standard._List_if getSrcList$val$382;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectManager)) {
          try {
            getSrcList$val$382 = projectManager.getSrcList ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSrcList$val$382 = projectManager.getSrcList ();
        }
// 130
        int getItemCount$val$383;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSrcList$val$382)) {
          try {
            getItemCount$val$383 = getSrcList$val$382.getItemCount ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getItemCount$val$383 = getSrcList$val$382.getItemCount ();
        }
// 130
        size = getItemCount$val$383;
// 132
        JP.go.ipa.oz.lib.standard._Dictionary_if getProjects$val$384;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectManager)) {
          try {
            getProjects$val$384 = projectManager.getProjects ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getProjects$val$384 = projectManager.getProjects ();
        }
// 132
        JP.go.ipa.oz.lib.standard._Dictionary_if dict = getProjects$val$384;
// 133
        JP.go.ipa.oz.user.ide.Project_if prj = (JP.go.ipa.oz.user.ide.Project_cl) (new JP.go.ipa.oz.user.ide.Project_cl ())._new_create (projectName);
// 134
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectManager)) {
          try {
            projectManager.setProjectName (projectName);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          projectManager.setProjectName (projectName);
        }
// 135
        JP.go.ipa.oz.lib.standard._Dictionary_if put$val$385;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dict)) {
          try {
            put$val$385 = dict.put (projectName, prj);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          put$val$385 = dict.put (projectName, prj);
        }
// 137
        /* for loop starting here */ {
          /* initialization part */
          int i = 0;
          
          for (;;) {
            /* boolean expression part */
            if (!(i < size)) break;
            
            /* body */ _loop_1: {
// 138
              JP.go.ipa.oz.lib.standard._List_if getSrcList$val$386;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectManager)) {
                try {
                  getSrcList$val$386 = projectManager.getSrcList ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getSrcList$val$386 = projectManager.getSrcList ();
              }
// 138
              JP.go.ipa.oz.lib.standard._String_if getItem$val$387;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSrcList$val$386)) {
                try {
                  getItem$val$387 = getSrcList$val$386.getItem (i);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getItem$val$387 = getSrcList$val$386.getItem (i);
              }
// 138
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
                try {
                  prj.addFile (getItem$val$387);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                prj.addFile (getItem$val$387);
              }
            }
            /* iteration part */
// 137
            i++;
          }
        }
// 142
        JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("OZ Project Manager [")));
// 143
        JP.go.ipa.oz.lib.standard._String_if getProjectName$val$388;
        getProjectName$val$388 = getProjectName ();
// 143
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$389;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$389 = buf.append (getProjectName$val$388);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$389 = buf.append (getProjectName$val$388);
        }
// 144
        JP.go.ipa.oz.lib.standard._String_if string$95 = (new JP.go.ipa.oz.lib.standard._String_cl("]"));
        
// 144
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$390;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$390 = buf.append (string$95);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$390 = buf.append (string$95);
        }
// 145
        JP.go.ipa.oz.lib.standard._String_if asString$val$391;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            asString$val$391 = buf.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$391 = buf.asString ();
        }
// 145
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectManager)) {
          try {
            projectManager.setTitle (asString$val$391);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          projectManager.setTitle (asString$val$391);
        }
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getProjectName () throws Exception  {
    checkSecureInvocation ();
// 116
    JP.go.ipa.oz.lib.standard._String_if getText$val$392;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtProjectName)) {
      try {
        getText$val$392 = txtProjectName.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$392 = txtProjectName.getText ();
    }
// 116
    return getText$val$392;
  }
  
  public void setVisible (boolean b) throws Exception  {
    checkSecureInvocation ();
// 86
    JP.go.ipa.oz.lib.standard._Container_if getParent$val$393;
    getParent$val$393 = getParent ();
// 86
    JP.go.ipa.oz.lib.standard._Rectangle_if getBounds$val$394;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getParent$val$393)) {
      try {
        getBounds$val$394 = getParent$val$393.getBounds ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBounds$val$394 = getParent$val$393.getBounds ();
    }
// 86
    JP.go.ipa.oz.lib.standard._Rectangle_if bounds = getBounds$val$394;
// 87
    JP.go.ipa.oz.lib.standard._Rectangle_if abounds = getBounds ();
// 88
    int getX$val$395;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getX$val$395 = bounds.getX ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getX$val$395 = bounds.getX ();
    }
// 88
    int getWidth$val$396;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getWidth$val$396 = bounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$396 = bounds.getWidth ();
    }
// 88
    int getWidth$val$397;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getWidth$val$397 = abounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$397 = abounds.getWidth ();
    }
// 89
    int getY$val$398;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getY$val$398 = bounds.getY ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getY$val$398 = bounds.getY ();
    }
// 89
    int getHeight$val$399;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getHeight$val$399 = bounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$399 = bounds.getHeight ();
    }
// 89
    int getHeight$val$400;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getHeight$val$400 = abounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$400 = abounds.getHeight ();
    }
// 88
    setLocation (getX$val$395 + (getWidth$val$396 - getWidth$val$397) / 2, getY$val$398 + (getHeight$val$399 - getHeight$val$400) / 2);
// 91
    super.setVisible (b);
  }
  
  public ProjectSaveAsDialog_cl () throws Exception { super (); }
  
}


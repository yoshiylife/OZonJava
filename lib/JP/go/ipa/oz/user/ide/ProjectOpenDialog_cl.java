package JP.go.ipa.oz.user.ide;

public class ProjectOpenDialog_cl extends JP.go.ipa.oz.lib.standard._Dialog_cl implements JP.go.ipa.oz.user.ide.ProjectOpenDialog_if {
  JP.go.ipa.oz.user.ide.ProjectManager_if projectManager;
  JP.go.ipa.oz.user.ide.ProjectOpenActionListener_if addAL;
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
    JP.go.ipa.oz.lib.standard._Component_if add$val$342;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel)) {
      try {
        add$val$342 = panel.add (btnOK);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$342 = panel.add (btnOK);
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
    JP.go.ipa.oz.lib.standard._Component_if add$val$343;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel)) {
      try {
        add$val$343 = panel.add (btnCancel);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$343 = panel.add (btnCancel);
    }
// 61
    setTitle ((new JP.go.ipa.oz.lib.standard._String_cl("OPEN PROJECT DIALOG")));
// 64
    JP.go.ipa.oz.lib.standard._Dictionary_if getProjects$val$344;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectManager)) {
      try {
        getProjects$val$344 = projectManager.getProjects ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getProjects$val$344 = projectManager.getProjects ();
    }
// 64
    JP.go.ipa.oz.lib.standard._Dictionary_if dict = getProjects$val$344;
// 65
    JP.go.ipa.oz.lib.standard._Iterator_if lblIterator = null;
// 66
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$345;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dict)) {
      try {
        iterator$val$345 = dict.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$345 = dict.iterator ();
    }
// 66
    lblIterator = iterator$val$345;
// 67
    JP.go.ipa.oz.user.ide.Project_if prj = null;
// 68
    while (true) {
// 68
      boolean hasMoreElements$val$346;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
        try {
          hasMoreElements$val$346 = lblIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$346 = lblIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$346)) break;
      
      /* body */ _loop_1: {
// 69
        JP.go.ipa.oz.lang._Root_if nextElement$val$347;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
          try {
            nextElement$val$347 = lblIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$347 = lblIterator.nextElement ();
        }
// 69
        prj = (JP.go.ipa.oz.user.ide.Project_if) (nextElement$val$347);
// 70
        JP.go.ipa.oz.lib.standard._String_if getProjectName$val$348;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
          try {
            getProjectName$val$348 = prj.getProjectName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getProjectName$val$348 = prj.getProjectName ();
        }
// 70
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstProjectName)) {
          try {
            lstProjectName.addItem (getProjectName$val$348);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          lstProjectName.addItem (getProjectName$val$348);
        }
      }
    }
// 76
    addAL = (JP.go.ipa.oz.user.ide.ProjectOpenActionListener_cl) (new JP.go.ipa.oz.user.ide.ProjectOpenActionListener_cl ())._new_create (this, queue);
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
  
  public void openProject () throws Exception  {
    checkSecureInvocation ();
// 130
    JP.go.ipa.oz.lib.standard._String_if projectName = null;
// 131
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$349;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstProjectName)) {
      try {
        getSelectedItem$val$349 = lstProjectName.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$349 = lstProjectName.getSelectedItem ();
    }
// 131
    projectName = getSelectedItem$val$349;
// 132
    if (projectName != null) {{
// 133
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectManager)) {
          try {
            projectManager.setProjectName (projectName);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          projectManager.setProjectName (projectName);
        }
// 136
        JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("OZ Project Manager [")));
// 137
        JP.go.ipa.oz.lib.standard._List_if getSrcList$val$350;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectManager)) {
          try {
            getSrcList$val$350 = projectManager.getSrcList ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSrcList$val$350 = projectManager.getSrcList ();
        }
// 137
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSrcList$val$350)) {
          try {
            getSrcList$val$350.removeAll ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSrcList$val$350.removeAll ();
        }
// 138
        JP.go.ipa.oz.lib.standard._String_if getProjectName$val$351;
        getProjectName$val$351 = getProjectName ();
// 138
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$352;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$352 = buf.append (getProjectName$val$351);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$352 = buf.append (getProjectName$val$351);
        }
// 139
        JP.go.ipa.oz.lib.standard._String_if string$92 = (new JP.go.ipa.oz.lib.standard._String_cl("]"));
        
// 139
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$353;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$353 = buf.append (string$92);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$353 = buf.append (string$92);
        }
// 140
        JP.go.ipa.oz.lib.standard._String_if asString$val$354;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            asString$val$354 = buf.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$354 = buf.asString ();
        }
// 140
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectManager)) {
          try {
            projectManager.setTitle (asString$val$354);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          projectManager.setTitle (asString$val$354);
        }
// 142
        JP.go.ipa.oz.lib.standard._Dictionary_if getProjects$val$355;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectManager)) {
          try {
            getProjects$val$355 = projectManager.getProjects ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getProjects$val$355 = projectManager.getProjects ();
        }
// 142
        JP.go.ipa.oz.lib.standard._Dictionary_if dict = getProjects$val$355;
// 143
        JP.go.ipa.oz.lib.standard._Iterator_if lblIterator = null;
// 144
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$356;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dict)) {
          try {
            iterator$val$356 = dict.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$356 = dict.iterator ();
        }
// 144
        lblIterator = iterator$val$356;
// 145
        JP.go.ipa.oz.user.ide.Project_if prj = null;
// 146
        while (true) {
// 146
          boolean hasMoreElements$val$357;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
            try {
              hasMoreElements$val$357 = lblIterator.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$357 = lblIterator.hasMoreElements ();
          }
          if (!(hasMoreElements$val$357)) break;
          
          /* body */ _loop_1: {
// 147
            JP.go.ipa.oz.lang._Root_if nextElement$val$358;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
              try {
                nextElement$val$358 = lblIterator.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$358 = lblIterator.nextElement ();
            }
// 147
            prj = (JP.go.ipa.oz.user.ide.Project_if) (nextElement$val$358);
// 148
            JP.go.ipa.oz.lib.standard._String_if getProjectName$val$359;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
              try {
                getProjectName$val$359 = prj.getProjectName ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getProjectName$val$359 = prj.getProjectName ();
            }
// 148
            int compareTo$val$360;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getProjectName$val$359)) {
              try {
                compareTo$val$360 = getProjectName$val$359.compareTo (projectName);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              compareTo$val$360 = getProjectName$val$359.compareTo (projectName);
            }
// 148
            if (compareTo$val$360 == 0) {
// 148
              break;
            }
          }
        }
// 151
        int size = 0;
// 152
        int getNumOfFiles$val$361;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
          try {
            getNumOfFiles$val$361 = prj.getNumOfFiles ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getNumOfFiles$val$361 = prj.getNumOfFiles ();
        }
// 152
        size = getNumOfFiles$val$361;
// 153
        JP.go.ipa.oz.lib.standard._Array_if files = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (size);
// 154
        JP.go.ipa.oz.lib.standard._Array_if getFiles$val$362;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
          try {
            getFiles$val$362 = prj.getFiles ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getFiles$val$362 = prj.getFiles ();
        }
// 154
        files = getFiles$val$362;
// 155
        JP.go.ipa.oz.lib.standard._String_if fileName = null;
// 156
        /* for loop starting here */ {
          /* initialization part */
          int i = 1;
          
          for (;;) {
            /* boolean expression part */
            if (!(i < size)) break;
            
            /* body */ _loop_1: {
// 157
              JP.go.ipa.oz.lang._Root_if at$val$363;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) files)) {
                try {
                  at$val$363 = files.at (i);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                at$val$363 = files.at (i);
              }
// 157
              fileName = (JP.go.ipa.oz.lib.standard._String_if) (at$val$363);
// 158
              JP.go.ipa.oz.lib.standard._List_if getSrcList$val$364;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectManager)) {
                try {
                  getSrcList$val$364 = projectManager.getSrcList ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getSrcList$val$364 = projectManager.getSrcList ();
              }
// 158
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSrcList$val$364)) {
                try {
                  getSrcList$val$364.addItem (fileName);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getSrcList$val$364.addItem (fileName);
              }
            }
            /* iteration part */
// 156
            i++;
          }
        }
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getProjectName () throws Exception  {
    checkSecureInvocation ();
// 120
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$365;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstProjectName)) {
      try {
        getSelectedItem$val$365 = lstProjectName.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$365 = lstProjectName.getSelectedItem ();
    }
// 120
    return getSelectedItem$val$365;
  }
  
  public void setVisible (boolean b) throws Exception  {
    checkSecureInvocation ();
// 90
    JP.go.ipa.oz.lib.standard._Container_if getParent$val$366;
    getParent$val$366 = getParent ();
// 90
    JP.go.ipa.oz.lib.standard._Rectangle_if getBounds$val$367;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getParent$val$366)) {
      try {
        getBounds$val$367 = getParent$val$366.getBounds ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBounds$val$367 = getParent$val$366.getBounds ();
    }
// 90
    JP.go.ipa.oz.lib.standard._Rectangle_if bounds = getBounds$val$367;
// 91
    JP.go.ipa.oz.lib.standard._Rectangle_if abounds = getBounds ();
// 92
    int getX$val$368;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getX$val$368 = bounds.getX ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getX$val$368 = bounds.getX ();
    }
// 92
    int getWidth$val$369;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getWidth$val$369 = bounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$369 = bounds.getWidth ();
    }
// 92
    int getWidth$val$370;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getWidth$val$370 = abounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$370 = abounds.getWidth ();
    }
// 93
    int getY$val$371;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getY$val$371 = bounds.getY ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getY$val$371 = bounds.getY ();
    }
// 93
    int getHeight$val$372;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getHeight$val$372 = bounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$372 = bounds.getHeight ();
    }
// 93
    int getHeight$val$373;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getHeight$val$373 = abounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$373 = abounds.getHeight ();
    }
// 92
    setLocation (getX$val$368 + (getWidth$val$369 - getWidth$val$370) / 2, getY$val$371 + (getHeight$val$372 - getHeight$val$373) / 2);
// 95
    super.setVisible (b);
  }
  
  public ProjectOpenDialog_cl () throws Exception { super (); }
  
}


package JP.go.ipa.oz.user.ide;

public class PMController_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.PMController_if {
  JP.go.ipa.oz.user.ide.ProjectManager_if prj;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dlgQueue;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.ProjectManager_if p, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception  {
// 28
    super._new_newActionListener (q);
// 30
    prj = p;
    return this;
  }
  
  public void compileAutoEvent () throws Exception  {
    checkSecureInvocation ();
// 174
    JP.go.ipa.oz.user.ide.CompilerAgent_if ozc = null;
// 175
    JP.go.ipa.oz.user.ide.School_if school = null;
// 176
    JP.go.ipa.oz.user.ide.ClassBrowser_if cb = null;
// 178
    JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser$val$466;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        getSchoolBrowser$val$466 = prj.getSchoolBrowser ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchoolBrowser$val$466 = prj.getSchoolBrowser ();
    }
// 178
    JP.go.ipa.oz.user.ide.School_if getSchool$val$467;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchoolBrowser$val$466)) {
      try {
        getSchool$val$467 = getSchoolBrowser$val$466.getSchool ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchool$val$467 = getSchoolBrowser$val$466.getSchool ();
    }
// 178
    school = getSchool$val$467;
// 179
    JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser$val$468;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        getSchoolBrowser$val$468 = prj.getSchoolBrowser ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchoolBrowser$val$468 = prj.getSchoolBrowser ();
    }
// 179
    JP.go.ipa.oz.user.ide.ClassBrowser_if getClassBrowser$val$469;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchoolBrowser$val$468)) {
      try {
        getClassBrowser$val$469 = getSchoolBrowser$val$468.getClassBrowser ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getClassBrowser$val$469 = getSchoolBrowser$val$468.getClassBrowser ();
    }
// 179
    cb = getClassBrowser$val$469;
// 180
    JP.go.ipa.oz.user.ide.CompilerUtility_if cu = (JP.go.ipa.oz.user.ide.CompilerUtility_cl) (new JP.go.ipa.oz.user.ide.CompilerUtility_cl ())._new_create (school, cb);
// 181
    ozc = (JP.go.ipa.oz.user.ide.CompilerAgent_cl) (new JP.go.ipa.oz.user.ide.CompilerAgent_cl ())._new_create (school, cu);
// 182
    JP.go.ipa.oz.user.ide.CompileInfoDialog_if comInfoDlg = (JP.go.ipa.oz.user.ide.CompileInfoDialog_cl) (new JP.go.ipa.oz.user.ide.CompileInfoDialog_cl ())._new_create (prj, false, dlgQueue);
// 183
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) comInfoDlg)) {
      try {
        comInfoDlg.setVisible (true);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      comInfoDlg.setVisible (true);
    }
// 184
    JP.go.ipa.oz.lib.standard._StringWriter_if out = (JP.go.ipa.oz.lib.standard._StringWriter_cl) (new JP.go.ipa.oz.lib.standard._StringWriter_cl ())._new_breed ();
// 185
    JP.go.ipa.oz.user.ide.CompileLog_if cl = (JP.go.ipa.oz.user.ide.CompileLog_cl) (new JP.go.ipa.oz.user.ide.CompileLog_cl ())._new_create (out, comInfoDlg);
// 186
    JP.go.ipa.oz.lib.standard._String_if getProjectDir$val$470;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        getProjectDir$val$470 = prj.getProjectDir ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getProjectDir$val$470 = prj.getProjectDir ();
    }
// 186
    ozc.compileAuto (getProjectDir$val$470, cl);
// 187
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) comInfoDlg)) {
      try {
        comInfoDlg.setButtonEnabled (true);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      comInfoDlg.setButtonEnabled (true);
    }
  }
  
  public void compileSubjectEvent () throws Exception  {
    checkSecureInvocation ();
// 148
    JP.go.ipa.oz.user.ide.CompilerAgent_if ozc = null;
// 149
    JP.go.ipa.oz.user.ide.School_if school = null;
// 150
    JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser$val$471;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        getSchoolBrowser$val$471 = prj.getSchoolBrowser ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchoolBrowser$val$471 = prj.getSchoolBrowser ();
    }
// 150
    JP.go.ipa.oz.user.ide.School_if getSchool$val$472;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchoolBrowser$val$471)) {
      try {
        getSchool$val$472 = getSchoolBrowser$val$471.getSchool ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchool$val$472 = getSchoolBrowser$val$471.getSchool ();
    }
// 150
    school = getSchool$val$472;
// 151
    ozc = (JP.go.ipa.oz.user.ide.CompilerAgent_cl) (new JP.go.ipa.oz.user.ide.CompilerAgent_cl ())._new_create (school);
// 152
    JP.go.ipa.oz.user.ide.CompileInfoDialog_if comInfoDlg = (JP.go.ipa.oz.user.ide.CompileInfoDialog_cl) (new JP.go.ipa.oz.user.ide.CompileInfoDialog_cl ())._new_create (prj, false, dlgQueue);
// 153
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) comInfoDlg)) {
      try {
        comInfoDlg.setVisible (true);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      comInfoDlg.setVisible (true);
    }
// 154
    JP.go.ipa.oz.lib.standard._StringWriter_if out = (JP.go.ipa.oz.lib.standard._StringWriter_cl) (new JP.go.ipa.oz.lib.standard._StringWriter_cl ())._new_breed ();
// 155
    JP.go.ipa.oz.user.ide.CompileLog_if cl = (JP.go.ipa.oz.user.ide.CompileLog_cl) (new JP.go.ipa.oz.user.ide.CompileLog_cl ())._new_create (out, comInfoDlg);
// 156
    JP.go.ipa.oz.lib.standard._String_if getProjectDir$val$473;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        getProjectDir$val$473 = prj.getProjectDir ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getProjectDir$val$473 = prj.getProjectDir ();
    }
// 156
    ozc.compileSubject (getProjectDir$val$473, cl);
// 157
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) comInfoDlg)) {
      try {
        comInfoDlg.setButtonEnabled (true);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      comInfoDlg.setButtonEnabled (true);
    }
  }
  
  public JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if getDlgQueue () throws Exception  {
    checkSecureInvocation ();
// 278
    return dlgQueue;
  }
  
  public boolean checkSubjectState () throws Exception  {
    checkSecureInvocation ();
// 304
    JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser$val$474;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        getSchoolBrowser$val$474 = prj.getSchoolBrowser ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchoolBrowser$val$474 = prj.getSchoolBrowser ();
    }
// 304
    JP.go.ipa.oz.user.ide.School_if getSchool$val$475;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchoolBrowser$val$474)) {
      try {
        getSchool$val$475 = getSchoolBrowser$val$474.getSchool ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchool$val$475 = getSchoolBrowser$val$474.getSchool ();
    }
// 304
    JP.go.ipa.oz.user.ide.School_if school = getSchool$val$475;
// 305
    JP.go.ipa.oz.lib.standard._Dictionary_if getProjects$val$476;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        getProjects$val$476 = prj.getProjects ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getProjects$val$476 = prj.getProjects ();
    }
// 305
    JP.go.ipa.oz.lib.standard._Dictionary_if dict = getProjects$val$476;
// 306
    JP.go.ipa.oz.lib.standard._String_if getProjectName$val$477;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        getProjectName$val$477 = prj.getProjectName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getProjectName$val$477 = prj.getProjectName ();
    }
// 306
    JP.go.ipa.oz.lib.standard._String_if projectName = getProjectName$val$477;
// 307
    JP.go.ipa.oz.user.ide.Project_if project = null;
// 308
    JP.go.ipa.oz.lang._Root_if get$val$478;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dict)) {
      try {
        get$val$478 = dict.get (projectName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$478 = dict.get (projectName);
    }
// 308
    project = (JP.go.ipa.oz.user.ide.Project_if) (get$val$478);
// 309
    JP.go.ipa.oz.lib.standard._Array_if getFiles$val$479;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) project)) {
      try {
        getFiles$val$479 = project.getFiles ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getFiles$val$479 = project.getFiles ();
    }
// 309
    JP.go.ipa.oz.lib.standard._Array_if lblNames = getFiles$val$479;
// 310
    JP.go.ipa.oz.lib.standard._String_if lblName = null;
// 311
    JP.go.ipa.oz.lang._Root_if at$val$480;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblNames)) {
      try {
        at$val$480 = lblNames.at (1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$480 = lblNames.at (1);
    }
// 311
    lblName = (JP.go.ipa.oz.lib.standard._String_if) (at$val$480);
// 312
    JP.go.ipa.oz.lib.standard._String_if string$101 = (new JP.go.ipa.oz.lib.standard._String_cl("."));
    
// 312
    int lastIndexOf$val$481;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblName)) {
      try {
        lastIndexOf$val$481 = lblName.lastIndexOf (string$101);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$481 = lblName.lastIndexOf (string$101);
    }
// 312
    JP.go.ipa.oz.lib.standard._String_if substring$val$482;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblName)) {
      try {
        substring$val$482 = lblName.substring (0, lastIndexOf$val$481);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$482 = lblName.substring (0, lastIndexOf$val$481);
    }
// 312
    JP.go.ipa.oz.user.ide.OzLabel_if getOzLabel$val$483;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        getOzLabel$val$483 = school.getOzLabel (substring$val$482);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabel$val$483 = school.getOzLabel (substring$val$482);
    }
// 312
    JP.go.ipa.oz.user.ide.OzLabel_if label = getOzLabel$val$483;
// 313
    JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$484;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) label)) {
      try {
        getSubjectName$val$484 = label.getSubjectName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSubjectName$val$484 = label.getSubjectName ();
    }
// 313
    JP.go.ipa.oz.lib.standard._String_if sbjName = getSubjectName$val$484;
// 314
    JP.go.ipa.oz.user.ide.Subject_if getSubject$val$485;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        getSubject$val$485 = school.getSubject (sbjName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSubject$val$485 = school.getSubject (sbjName);
    }
// 314
    JP.go.ipa.oz.user.ide.Subject_if subject = getSubject$val$485;
// 315
    boolean isReleased$val$486;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
      try {
        isReleased$val$486 = subject.isReleased ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isReleased$val$486 = subject.isReleased ();
    }
// 315
    return isReleased$val$486;
  }
  
  public void setDlgQueue (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception  {
    checkSecureInvocation ();
// 287
    dlgQueue = q;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if event) throws Exception  {
    checkSecureInvocation ();
// 200
    JP.go.ipa.oz.lib.standard._Frame_if frame = prj;
// 201
    JP.go.ipa.oz.lib.standard._String_if menuItem = null;
// 202
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$487;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) event)) {
      try {
        getActionCommand$val$487 = event.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$487 = event.getActionCommand ();
    }
// 202
    menuItem = getActionCommand$val$487;
// 204
    JP.go.ipa.oz.lib.standard._String_if string$102 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    
// 204
    int compareTo$val$488;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
      try {
        compareTo$val$488 = menuItem.compareTo (string$102);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compareTo$val$488 = menuItem.compareTo (string$102);
    }
// 204
    if (compareTo$val$488 == 0) {{
      }
    } else {
// 206
      JP.go.ipa.oz.lib.standard._String_if string$103 = (new JP.go.ipa.oz.lib.standard._String_cl("new"));
      
// 206
      int compareTo$val$489;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
        try {
          compareTo$val$489 = menuItem.compareTo (string$103);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        compareTo$val$489 = menuItem.compareTo (string$103);
      }
// 206
      if (compareTo$val$489 == 0) {{
// 207
          JP.go.ipa.oz.lib.standard._String_if string$104 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
          
// 207
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
            try {
              prj.setProjectDir (string$104);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            prj.setProjectDir (string$104);
          }
// 208
          JP.go.ipa.oz.lib.standard._List_if getSrcList$val$490;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
            try {
              getSrcList$val$490 = prj.getSrcList ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getSrcList$val$490 = prj.getSrcList ();
          }
// 208
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSrcList$val$490)) {
            try {
              getSrcList$val$490.removeAll ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getSrcList$val$490.removeAll ();
          }
// 209
          JP.go.ipa.oz.user.ide.ProjectNewDialog_if newDlg = (JP.go.ipa.oz.user.ide.ProjectNewDialog_cl) (new JP.go.ipa.oz.user.ide.ProjectNewDialog_cl ())._new_create (prj, true, dlgQueue);
// 210
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) newDlg)) {
            try {
              newDlg.setVisible (true);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            newDlg.setVisible (true);
          }
        }
      } else {
// 212
        JP.go.ipa.oz.lib.standard._String_if string$105 = (new JP.go.ipa.oz.lib.standard._String_cl("open..."));
        
// 212
        int compareTo$val$491;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
          try {
            compareTo$val$491 = menuItem.compareTo (string$105);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          compareTo$val$491 = menuItem.compareTo (string$105);
        }
// 212
        if (compareTo$val$491 == 0) {{
// 213
            JP.go.ipa.oz.user.ide.ProjectOpenDialog_if openDlg = (JP.go.ipa.oz.user.ide.ProjectOpenDialog_cl) (new JP.go.ipa.oz.user.ide.ProjectOpenDialog_cl ())._new_create (prj, true, dlgQueue);
// 214
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) openDlg)) {
              try {
                openDlg.setVisible (true);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              openDlg.setVisible (true);
            }
          }
        } else {
// 216
          JP.go.ipa.oz.lib.standard._String_if string$106 = (new JP.go.ipa.oz.lib.standard._String_cl("save"));
          
// 216
          int compareTo$val$492;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
            try {
              compareTo$val$492 = menuItem.compareTo (string$106);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            compareTo$val$492 = menuItem.compareTo (string$106);
          }
// 216
          if (compareTo$val$492 == 0) {{
// 217
              saveEvent ();
            }
          } else {
// 219
            JP.go.ipa.oz.lib.standard._String_if string$107 = (new JP.go.ipa.oz.lib.standard._String_cl("save as..."));
            
// 219
            int compareTo$val$493;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
              try {
                compareTo$val$493 = menuItem.compareTo (string$107);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              compareTo$val$493 = menuItem.compareTo (string$107);
            }
// 219
            if (compareTo$val$493 == 0) {{
// 220
                JP.go.ipa.oz.user.ide.ProjectSaveAsDialog_if saveAsDlg = (JP.go.ipa.oz.user.ide.ProjectSaveAsDialog_cl) (new JP.go.ipa.oz.user.ide.ProjectSaveAsDialog_cl ())._new_create (prj, true, dlgQueue);
// 221
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) saveAsDlg)) {
                  try {
                    saveAsDlg.setVisible (true);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  saveAsDlg.setVisible (true);
                }
              }
            } else {
// 223
              JP.go.ipa.oz.lib.standard._String_if string$108 = (new JP.go.ipa.oz.lib.standard._String_cl("remove..."));
              
// 223
              int compareTo$val$494;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                try {
                  compareTo$val$494 = menuItem.compareTo (string$108);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                compareTo$val$494 = menuItem.compareTo (string$108);
              }
// 223
              if (compareTo$val$494 == 0) {{
// 224
                  JP.go.ipa.oz.user.ide.ProjectRemoveDialog_if openDlg = (JP.go.ipa.oz.user.ide.ProjectRemoveDialog_cl) (new JP.go.ipa.oz.user.ide.ProjectRemoveDialog_cl ())._new_create (prj, true, dlgQueue);
// 225
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) openDlg)) {
                    try {
                      openDlg.setVisible (true);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    openDlg.setVisible (true);
                  }
                }
              } else {
// 227
                JP.go.ipa.oz.lib.standard._String_if string$109 = (new JP.go.ipa.oz.lib.standard._String_cl("end"));
                
// 227
                int compareTo$val$495;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                  try {
                    compareTo$val$495 = menuItem.compareTo (string$109);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  compareTo$val$495 = menuItem.compareTo (string$109);
                }
// 227
                if (compareTo$val$495 == 0) {{
// 228
                    JP.go.ipa.oz.user.ide.QuitDialog_if quitDlg = (JP.go.ipa.oz.user.ide.QuitDialog_cl) (new JP.go.ipa.oz.user.ide.QuitDialog_cl ())._new_create (frame, true, dlgQueue);
// 229
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) quitDlg)) {
                      try {
                        quitDlg.setVisible (true);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      quitDlg.setVisible (true);
                    }
                  }
                } else {
                  boolean bool$val$18;
                  
// 231
                  JP.go.ipa.oz.lib.standard._String_if string$110 = (new JP.go.ipa.oz.lib.standard._String_cl("refresh"));
                  
// 231
                  int compareTo$val$496;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                    try {
                      compareTo$val$496 = menuItem.compareTo (string$110);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    compareTo$val$496 = menuItem.compareTo (string$110);
                  }
                  bool$val$18 = compareTo$val$496 == 0;
                  if (bool$val$18) {
// 231
                    JP.go.ipa.oz.lib.standard._List_if getSrcList$val$497;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
                      try {
                        getSrcList$val$497 = prj.getSrcList ();
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      getSrcList$val$497 = prj.getSrcList ();
                    }
// 231
                    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$498;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSrcList$val$497)) {
                      try {
                        getSelectedItem$val$498 = getSrcList$val$497.getSelectedItem ();
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      getSelectedItem$val$498 = getSrcList$val$497.getSelectedItem ();
                    }
                    bool$val$18 = getSelectedItem$val$498 != null;
                  }
// 231
                  if (bool$val$18) {{
// 232
                      refreshEvent ();
                    }
                  } else {
// 234
                    JP.go.ipa.oz.lib.standard._String_if string$111 = (new JP.go.ipa.oz.lib.standard._String_cl("set directory..."));
                    
// 234
                    int compareTo$val$499;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                      try {
                        compareTo$val$499 = menuItem.compareTo (string$111);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      compareTo$val$499 = menuItem.compareTo (string$111);
                    }
// 234
                    if (compareTo$val$499 == 0) {{
// 235
                        setDirEvent ();
                      }
                    } else {
// 237
                      JP.go.ipa.oz.lib.standard._String_if string$112 = (new JP.go.ipa.oz.lib.standard._String_cl("edit file"));
                      
// 237
                      int compareTo$val$500;
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                        try {
                          compareTo$val$500 = menuItem.compareTo (string$112);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        compareTo$val$500 = menuItem.compareTo (string$112);
                      }
// 237
                      if (compareTo$val$500 == 0) {{
// 238
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
                            try {
                              prj.openEditor ();
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            prj.openEditor ();
                          }
                        }
                      } else {
// 240
                        JP.go.ipa.oz.lib.standard._String_if string$113 = (new JP.go.ipa.oz.lib.standard._String_cl("set editor..."));
                        
// 240
                        int compareTo$val$501;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                          try {
                            compareTo$val$501 = menuItem.compareTo (string$113);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          compareTo$val$501 = menuItem.compareTo (string$113);
                        }
// 240
                        if (compareTo$val$501 == 0) {{
// 241
                            JP.go.ipa.oz.user.ide.SetEditorDialog_if setEditDlg = (JP.go.ipa.oz.user.ide.SetEditorDialog_cl) (new JP.go.ipa.oz.user.ide.SetEditorDialog_cl ())._new_create (prj, true, dlgQueue);
// 242
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) setEditDlg)) {
                              try {
                                setEditDlg.setVisible (true);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              setEditDlg.setVisible (true);
                            }
                          }
                        } else {
// 244
                          JP.go.ipa.oz.lib.standard._String_if string$114 = (new JP.go.ipa.oz.lib.standard._String_cl("compile"));
                          
// 244
                          int compareTo$val$502;
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                            try {
                              compareTo$val$502 = menuItem.compareTo (string$114);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            compareTo$val$502 = menuItem.compareTo (string$114);
                          }
// 244
                          if (compareTo$val$502 == 0) {{
// 245
                              JP.go.ipa.oz.lib.standard._List_if getSrcList$val$503;
                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
                                try {
                                  getSrcList$val$503 = prj.getSrcList ();
                                } finally {
                                  changeRunningToGreen ();
                                }
                              } else {
                                getSrcList$val$503 = prj.getSrcList ();
                              }
// 245
                              JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$504;
                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSrcList$val$503)) {
                                try {
                                  getSelectedItem$val$504 = getSrcList$val$503.getSelectedItem ();
                                } finally {
                                  changeRunningToGreen ();
                                }
                              } else {
                                getSelectedItem$val$504 = getSrcList$val$503.getSelectedItem ();
                              }
// 245
                              if (getSelectedItem$val$504 == null) {
// 245
                                return;
                              }
// 246
                              compileEvent (1);
                            }
                          } else {
// 248
                            JP.go.ipa.oz.lib.standard._String_if string$115 = (new JP.go.ipa.oz.lib.standard._String_cl("compile interface"));
                            
// 248
                            int compareTo$val$505;
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                              try {
                                compareTo$val$505 = menuItem.compareTo (string$115);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              compareTo$val$505 = menuItem.compareTo (string$115);
                            }
// 248
                            if (compareTo$val$505 == 0) {{
// 249
                                JP.go.ipa.oz.lib.standard._List_if getSrcList$val$506;
                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
                                  try {
                                    getSrcList$val$506 = prj.getSrcList ();
                                  } finally {
                                    changeRunningToGreen ();
                                  }
                                } else {
                                  getSrcList$val$506 = prj.getSrcList ();
                                }
// 249
                                JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$507;
                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSrcList$val$506)) {
                                  try {
                                    getSelectedItem$val$507 = getSrcList$val$506.getSelectedItem ();
                                  } finally {
                                    changeRunningToGreen ();
                                  }
                                } else {
                                  getSelectedItem$val$507 = getSrcList$val$506.getSelectedItem ();
                                }
// 249
                                if (getSelectedItem$val$507 == null) {
// 249
                                  return;
                                }
// 250
                                compileEvent (2);
                              }
                            } else {
// 252
                              JP.go.ipa.oz.lib.standard._String_if string$116 = (new JP.go.ipa.oz.lib.standard._String_cl("compile subject"));
                              
// 252
                              int compareTo$val$508;
                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                                try {
                                  compareTo$val$508 = menuItem.compareTo (string$116);
                                } finally {
                                  changeRunningToGreen ();
                                }
                              } else {
                                compareTo$val$508 = menuItem.compareTo (string$116);
                              }
// 252
                              if (compareTo$val$508 == 0) {{
// 253
                                  compileSubjectEvent ();
                                }
                              } else {
// 255
                                JP.go.ipa.oz.lib.standard._String_if string$117 = (new JP.go.ipa.oz.lib.standard._String_cl("compile for release"));
                                
// 255
                                int compareTo$val$509;
                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                                  try {
                                    compareTo$val$509 = menuItem.compareTo (string$117);
                                  } finally {
                                    changeRunningToGreen ();
                                  }
                                } else {
                                  compareTo$val$509 = menuItem.compareTo (string$117);
                                }
// 255
                                if (compareTo$val$509 == 0) {{
// 256
                                    if (checkSubjectState ()) {
// 257
                                      compileReleaseEvent ();
                                    } else {{
// 259
                                        JP.go.ipa.oz.user.ide.AboutDialog_if aboutDlg = (JP.go.ipa.oz.user.ide.AboutDialog_cl) (new JP.go.ipa.oz.user.ide.AboutDialog_cl ())._new_create (frame, true, dlgQueue, (new JP.go.ipa.oz.lib.standard._String_cl("Subject is not a Release mode!")), (new JP.go.ipa.oz.lib.standard._String_cl("Can not compile")));
// 260
                                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aboutDlg)) {
                                          try {
                                            aboutDlg.setVisible (true);
                                          } finally {
                                            changeRunningToGreen ();
                                          }
                                        } else {
                                          aboutDlg.setVisible (true);
                                        }
                                      }
                                    }
                                  }
                                } else {
// 263
                                  JP.go.ipa.oz.lib.standard._String_if string$118 = (new JP.go.ipa.oz.lib.standard._String_cl("compile auto"));
                                  
// 263
                                  int compareTo$val$510;
                                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                                    try {
                                      compareTo$val$510 = menuItem.compareTo (string$118);
                                    } finally {
                                      changeRunningToGreen ();
                                    }
                                  } else {
                                    compareTo$val$510 = menuItem.compareTo (string$118);
                                  }
// 263
                                  if (compareTo$val$510 == 0) {{
// 264
                                      compileAutoEvent ();
                                    }
                                  } else {
// 266
                                    JP.go.ipa.oz.lib.standard._String_if string$119 = (new JP.go.ipa.oz.lib.standard._String_cl("version..."));
                                    
// 266
                                    int compareTo$val$511;
                                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                                      try {
                                        compareTo$val$511 = menuItem.compareTo (string$119);
                                      } finally {
                                        changeRunningToGreen ();
                                      }
                                    } else {
                                      compareTo$val$511 = menuItem.compareTo (string$119);
                                    }
// 266
                                    if (compareTo$val$511 == 0) {{
// 267
                                        JP.go.ipa.oz.user.ide.AboutDialog_if aboutDlg = (JP.go.ipa.oz.user.ide.AboutDialog_cl) (new JP.go.ipa.oz.user.ide.AboutDialog_cl ())._new_create (frame, true, dlgQueue);
// 268
                                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aboutDlg)) {
                                          try {
                                            aboutDlg.setVisible (true);
                                          } finally {
                                            changeRunningToGreen ();
                                          }
                                        } else {
                                          aboutDlg.setVisible (true);
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void saveEvent () throws Exception  {
    checkSecureInvocation ();
// 41
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        prj.deleteListeners ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      prj.deleteListeners ();
    }
// 42
    JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser$val$512;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        getSchoolBrowser$val$512 = prj.getSchoolBrowser ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchoolBrowser$val$512 = prj.getSchoolBrowser ();
    }
// 42
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchoolBrowser$val$512)) {
      try {
        getSchoolBrowser$val$512.deleteListeners ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchoolBrowser$val$512.deleteListeners ();
    }
// 43
    flushCell ();
// 44
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if pmQueue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 45
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        prj.activateListeners (pmQueue);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      prj.activateListeners (pmQueue);
    }
// 46
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if sbQueue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 47
    JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser$val$513;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        getSchoolBrowser$val$513 = prj.getSchoolBrowser ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchoolBrowser$val$513 = prj.getSchoolBrowser ();
    }
// 47
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchoolBrowser$val$513)) {
      try {
        getSchoolBrowser$val$513.activateListeners (sbQueue);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchoolBrowser$val$513.activateListeners (sbQueue);
    }
  }
  
  public void compileEvent (int flag) throws Exception  {
    checkSecureInvocation ();
// 115
    JP.go.ipa.oz.user.ide.CompilerAgent_if ozc = null;
// 116
    JP.go.ipa.oz.user.ide.School_if school = null;
// 117
    JP.go.ipa.oz.lib.standard._StringBuffer_if fileName = null;
// 118
    JP.go.ipa.oz.lib.standard._String_if ozHome = null, separator = null;
// 119
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 120
    JP.go.ipa.oz.lib.standard._String_if getOzHome$val$514;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getOzHome$val$514 = system.getOzHome ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzHome$val$514 = system.getOzHome ();
    }
// 120
    ozHome = getOzHome$val$514;
// 121
    JP.go.ipa.oz.lib.standard._String_if string$120 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    
// 121
    boolean startsWith$val$515;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
      try {
        startsWith$val$515 = ozHome.startsWith (string$120);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$515 = ozHome.startsWith (string$120);
    }
// 121
    if (startsWith$val$515) {
// 122
      separator = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    } else {
// 124
      separator = (new JP.go.ipa.oz.lib.standard._String_cl("\\"));
    }
// 125
    JP.go.ipa.oz.lib.standard._String_if getProjectDir$val$516;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        getProjectDir$val$516 = prj.getProjectDir ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getProjectDir$val$516 = prj.getProjectDir ();
    }
// 125
    fileName = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (getProjectDir$val$516);
// 126
    fileName.append (separator);
// 127
    JP.go.ipa.oz.lib.standard._List_if getSrcList$val$517;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        getSrcList$val$517 = prj.getSrcList ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSrcList$val$517 = prj.getSrcList ();
    }
// 127
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$518;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSrcList$val$517)) {
      try {
        getSelectedItem$val$518 = getSrcList$val$517.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$518 = getSrcList$val$517.getSelectedItem ();
    }
// 127
    fileName.append (getSelectedItem$val$518);
// 129
    JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser$val$519;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        getSchoolBrowser$val$519 = prj.getSchoolBrowser ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchoolBrowser$val$519 = prj.getSchoolBrowser ();
    }
// 129
    JP.go.ipa.oz.user.ide.School_if getSchool$val$520;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchoolBrowser$val$519)) {
      try {
        getSchool$val$520 = getSchoolBrowser$val$519.getSchool ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchool$val$520 = getSchoolBrowser$val$519.getSchool ();
    }
// 129
    school = getSchool$val$520;
// 130
    ozc = (JP.go.ipa.oz.user.ide.CompilerAgent_cl) (new JP.go.ipa.oz.user.ide.CompilerAgent_cl ())._new_create (school);
// 131
    JP.go.ipa.oz.user.ide.CompileInfoDialog_if comInfoDlg = (JP.go.ipa.oz.user.ide.CompileInfoDialog_cl) (new JP.go.ipa.oz.user.ide.CompileInfoDialog_cl ())._new_create (prj, false, dlgQueue);
// 132
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) comInfoDlg)) {
      try {
        comInfoDlg.setVisible (true);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      comInfoDlg.setVisible (true);
    }
// 133
    JP.go.ipa.oz.lib.standard._StringWriter_if out = (JP.go.ipa.oz.lib.standard._StringWriter_cl) (new JP.go.ipa.oz.lib.standard._StringWriter_cl ())._new_breed ();
// 134
    JP.go.ipa.oz.user.ide.CompileLog_if cl = (JP.go.ipa.oz.user.ide.CompileLog_cl) (new JP.go.ipa.oz.user.ide.CompileLog_cl ())._new_create (out, comInfoDlg);
// 135
    if (flag == 1) {{
// 136
        if (!(ozc.compile (fileName.asString (), cl))) {{
// 137
            JP.go.ipa.oz.lib.standard._String_if string$121 = (new JP.go.ipa.oz.lib.standard._String_cl("Compile failed!!!"));
            
// 137
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) comInfoDlg)) {
              try {
                comInfoDlg.appendText (string$121);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              comInfoDlg.appendText (string$121);
            }
          }
        }
      }
    } else {
// 139
      if (flag == 2) {{
// 140
          if (!(ozc.compileInterface (fileName.asString (), cl))) {{
// 141
              JP.go.ipa.oz.lib.standard._String_if string$122 = (new JP.go.ipa.oz.lib.standard._String_cl("Compile failed!!!"));
              
// 141
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) comInfoDlg)) {
                try {
                  comInfoDlg.appendText (string$122);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                comInfoDlg.appendText (string$122);
              }
            }
          }
        }
      }
    }
// 144
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) comInfoDlg)) {
      try {
        comInfoDlg.setButtonEnabled (true);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      comInfoDlg.setButtonEnabled (true);
    }
  }
  
  public void setDirEvent () throws Exception  {
    checkSecureInvocation ();
// 79
    JP.go.ipa.oz.user.ide.AddFileDialog_if addDialog = (JP.go.ipa.oz.user.ide.AddFileDialog_cl) (new JP.go.ipa.oz.user.ide.AddFileDialog_cl ())._new_create (prj, true, dlgQueue);
// 80
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) addDialog)) {
      try {
        addDialog.setVisible (true);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      addDialog.setVisible (true);
    }
// 81
    JP.go.ipa.oz.lib.standard._Array_if files = null;
// 82
    JP.go.ipa.oz.lib.standard._Array_if getFiles$val$521;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) addDialog)) {
      try {
        getFiles$val$521 = addDialog.getFiles ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getFiles$val$521 = addDialog.getFiles ();
    }
// 82
    files = getFiles$val$521;
// 83
    if (files == null) {
// 83
      return;
    }
// 84
    JP.go.ipa.oz.lib.standard._Dictionary_if getProjects$val$522;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        getProjects$val$522 = prj.getProjects ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getProjects$val$522 = prj.getProjects ();
    }
// 84
    JP.go.ipa.oz.lib.standard._Dictionary_if dict = getProjects$val$522;
// 85
    JP.go.ipa.oz.lib.standard._String_if getProjectName$val$523;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        getProjectName$val$523 = prj.getProjectName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getProjectName$val$523 = prj.getProjectName ();
    }
// 85
    JP.go.ipa.oz.lib.standard._String_if projectName = getProjectName$val$523;
// 86
    JP.go.ipa.oz.user.ide.Project_if project = null;
// 87
    JP.go.ipa.oz.lang._Root_if get$val$524;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dict)) {
      try {
        get$val$524 = dict.get (projectName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$524 = dict.get (projectName);
    }
// 87
    project = (JP.go.ipa.oz.user.ide.Project_if) (get$val$524);
// 88
    JP.go.ipa.oz.lib.standard._String_if tmp = null;
// 89
    int max = 0;
// 90
    int size$val$525;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) files)) {
      try {
        size$val$525 = files.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$525 = files.size ();
    }
// 90
    max = size$val$525;
// 91
    if (max == 0) {
// 91
      return;
    }
// 94
    int point = 0;
// 95
    JP.go.ipa.oz.lang._Root_if at$val$526;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) files)) {
      try {
        at$val$526 = files.at (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$526 = files.at (0);
    }
// 95
    tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$526);
// 96
    JP.go.ipa.oz.lib.standard._String_if string$123 = (new JP.go.ipa.oz.lib.standard._String_cl("\\"));
    
// 96
    int lastIndexOf$val$527;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
      try {
        lastIndexOf$val$527 = tmp.lastIndexOf (string$123);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$527 = tmp.lastIndexOf (string$123);
    }
// 96
    if (lastIndexOf$val$527 != -1) {
// 96
      JP.go.ipa.oz.lib.standard._String_if string$124 = (new JP.go.ipa.oz.lib.standard._String_cl("\\"));
      
// 96
      int lastIndexOf$val$528;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
        try {
          lastIndexOf$val$528 = tmp.lastIndexOf (string$124);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        lastIndexOf$val$528 = tmp.lastIndexOf (string$124);
      }
// 96
      point = lastIndexOf$val$528;
    }
// 97
    JP.go.ipa.oz.lib.standard._String_if string$125 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    
// 97
    int lastIndexOf$val$529;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
      try {
        lastIndexOf$val$529 = tmp.lastIndexOf (string$125);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$529 = tmp.lastIndexOf (string$125);
    }
// 97
    if (lastIndexOf$val$529 != -1) {
// 97
      JP.go.ipa.oz.lib.standard._String_if string$126 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
      
// 97
      int lastIndexOf$val$530;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
        try {
          lastIndexOf$val$530 = tmp.lastIndexOf (string$126);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        lastIndexOf$val$530 = tmp.lastIndexOf (string$126);
      }
// 97
      point = lastIndexOf$val$530;
    }
// 98
    JP.go.ipa.oz.lib.standard._String_if substring$val$531;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
      try {
        substring$val$531 = tmp.substring (0, point);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$531 = tmp.substring (0, point);
    }
// 98
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) project)) {
      try {
        project.setProjectDir (substring$val$531);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      project.setProjectDir (substring$val$531);
    }
// 99
    JP.go.ipa.oz.lib.standard._String_if substring$val$532;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
      try {
        substring$val$532 = tmp.substring (0, point);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$532 = tmp.substring (0, point);
    }
// 99
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        prj.setProjectDir (substring$val$532);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      prj.setProjectDir (substring$val$532);
    }
// 100
    JP.go.ipa.oz.lib.standard._File_if tmpFile = null;
// 102
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < max)) break;
        
        /* body */ _loop_1: {
// 103
          JP.go.ipa.oz.lang._Root_if at$val$533;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) files)) {
            try {
              at$val$533 = files.at (i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            at$val$533 = files.at (i);
          }
// 103
          tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$533);
// 104
          JP.go.ipa.oz.lib.standard._String_if string$127 = (new JP.go.ipa.oz.lib.standard._String_cl("_cl.oz"));
          
// 104
          boolean endsWith$val$534;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
            try {
              endsWith$val$534 = tmp.endsWith (string$127);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            endsWith$val$534 = tmp.endsWith (string$127);
          }
// 104
          if (!(endsWith$val$534)) {{
// 105
              tmpFile = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (tmp);
// 106
              JP.go.ipa.oz.lib.standard._List_if getSrcList$val$535;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
                try {
                  getSrcList$val$535 = prj.getSrcList ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getSrcList$val$535 = prj.getSrcList ();
              }
// 106
              JP.go.ipa.oz.lib.standard._String_if getName$val$536;
              getName$val$536 = tmpFile.getName ();
// 106
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSrcList$val$535)) {
                try {
                  getSrcList$val$535.addItem (getName$val$536);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getSrcList$val$535.addItem (getName$val$536);
              }
// 107
              JP.go.ipa.oz.lib.standard._String_if getName$val$537;
              getName$val$537 = tmpFile.getName ();
// 107
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) project)) {
                try {
                  project.addFile (getName$val$537);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                project.addFile (getName$val$537);
              }
            }
          }
        }
        /* iteration part */
// 102
        i++;
      }
    }
// 110
    JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser$val$538;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        getSchoolBrowser$val$538 = prj.getSchoolBrowser ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchoolBrowser$val$538 = prj.getSchoolBrowser ();
    }
// 110
    JP.go.ipa.oz.lib.standard._String_if getProjectDir$val$539;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        getProjectDir$val$539 = prj.getProjectDir ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getProjectDir$val$539 = prj.getProjectDir ();
    }
// 110
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchoolBrowser$val$538)) {
      try {
        getSchoolBrowser$val$538.setProjectDir (getProjectDir$val$539);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchoolBrowser$val$538.setProjectDir (getProjectDir$val$539);
    }
// 111
    refreshEvent ();
  }
  
  public void destroyDlgQueue () throws Exception  {
    checkSecureInvocation ();
// 296
    boolean isDestroyed$val$540;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlgQueue)) {
      try {
        isDestroyed$val$540 = dlgQueue.isDestroyed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isDestroyed$val$540 = dlgQueue.isDestroyed ();
    }
// 296
    if (!isDestroyed$val$540) {
// 296
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlgQueue)) {
        try {
          dlgQueue.destroy ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        dlgQueue.destroy ();
      }
    }
  }
  
  public void refreshEvent () throws Exception  {
    checkSecureInvocation ();
    boolean bool$val$19;
    
// 51
    JP.go.ipa.oz.lib.standard._String_if getProjectDir$val$541;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        getProjectDir$val$541 = prj.getProjectDir ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getProjectDir$val$541 = prj.getProjectDir ();
    }
    bool$val$19 = getProjectDir$val$541 == null;
    if (!bool$val$19) {
// 51
      JP.go.ipa.oz.lib.standard._String_if getProjectDir$val$542;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
        try {
          getProjectDir$val$542 = prj.getProjectDir ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getProjectDir$val$542 = prj.getProjectDir ();
      }
// 51
      JP.go.ipa.oz.lib.standard._String_if string$128 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
      
// 51
      int compareTo$val$543;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getProjectDir$val$542)) {
        try {
          compareTo$val$543 = getProjectDir$val$542.compareTo (string$128);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        compareTo$val$543 = getProjectDir$val$542.compareTo (string$128);
      }
      bool$val$19 = compareTo$val$543 == 0;
    }
// 51
    if (bool$val$19) {
// 51
      return;
    }
// 53
    JP.go.ipa.oz.lib.standard._List_if getSrcList$val$544;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        getSrcList$val$544 = prj.getSrcList ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSrcList$val$544 = prj.getSrcList ();
    }
// 53
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSrcList$val$544)) {
      try {
        getSrcList$val$544.removeAll ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSrcList$val$544.removeAll ();
    }
// 54
    JP.go.ipa.oz.lib.standard._Dictionary_if getProjects$val$545;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        getProjects$val$545 = prj.getProjects ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getProjects$val$545 = prj.getProjects ();
    }
// 54
    JP.go.ipa.oz.lib.standard._Dictionary_if dict = getProjects$val$545;
// 55
    JP.go.ipa.oz.lib.standard._String_if projectName = null;
// 56
    JP.go.ipa.oz.lib.standard._String_if getProjectName$val$546;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        getProjectName$val$546 = prj.getProjectName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getProjectName$val$546 = prj.getProjectName ();
    }
// 56
    projectName = getProjectName$val$546;
// 57
    JP.go.ipa.oz.user.ide.Project_if project = null;
// 58
    JP.go.ipa.oz.lang._Root_if get$val$547;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dict)) {
      try {
        get$val$547 = dict.get (projectName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$547 = dict.get (projectName);
    }
// 58
    project = (JP.go.ipa.oz.user.ide.Project_if) (get$val$547);
// 59
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) project)) {
      try {
        project.removeAllFiles ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      project.removeAllFiles ();
    }
// 61
    JP.go.ipa.oz.lib.standard._Array_if fileList = null;
// 62
    JP.go.ipa.oz.lib.standard._String_if getProjectDir$val$548;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) project)) {
      try {
        getProjectDir$val$548 = project.getProjectDir ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getProjectDir$val$548 = project.getProjectDir ();
    }
// 62
    JP.go.ipa.oz.lib.standard._File_if file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (getProjectDir$val$548);
// 63
    JP.go.ipa.oz.user.ide.ExtensionFilter_if filter = (JP.go.ipa.oz.user.ide.ExtensionFilter_cl) (new JP.go.ipa.oz.user.ide.ExtensionFilter_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl(".oz")));
// 64
    JP.go.ipa.oz.lib.standard._Array_if list$val$549;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        list$val$549 = file.list (filter);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      list$val$549 = file.list (filter);
    }
// 64
    fileList = list$val$549;
// 65
    if (fileList == null) {
// 65
      return;
    }
// 66
    JP.go.ipa.oz.lib.standard._String_if tmp = null;
// 67
    int max = 0;
// 68
    int size$val$550;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
      try {
        size$val$550 = fileList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$550 = fileList.size ();
    }
// 68
    max = size$val$550;
// 69
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < max)) break;
        
        /* body */ _loop_1: {
// 70
          JP.go.ipa.oz.lang._Root_if at$val$551;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
            try {
              at$val$551 = fileList.at (i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            at$val$551 = fileList.at (i);
          }
// 70
          tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$551);
// 71
          JP.go.ipa.oz.lib.standard._String_if string$129 = (new JP.go.ipa.oz.lib.standard._String_cl("_cl.oz"));
          
// 71
          boolean endsWith$val$552;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
            try {
              endsWith$val$552 = tmp.endsWith (string$129);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            endsWith$val$552 = tmp.endsWith (string$129);
          }
// 71
          if (!(endsWith$val$552)) {{
// 72
              JP.go.ipa.oz.lib.standard._List_if getSrcList$val$553;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
                try {
                  getSrcList$val$553 = prj.getSrcList ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getSrcList$val$553 = prj.getSrcList ();
              }
// 72
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSrcList$val$553)) {
                try {
                  getSrcList$val$553.addItem (tmp);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getSrcList$val$553.addItem (tmp);
              }
// 73
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) project)) {
                try {
                  project.addFile (tmp);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                project.addFile (tmp);
              }
            }
          }
        }
        /* iteration part */
// 69
        i++;
      }
    }
  }
  
  public void compileReleaseEvent () throws Exception  {
    checkSecureInvocation ();
// 161
    JP.go.ipa.oz.user.ide.CompilerAgent_if ozc = null;
// 162
    JP.go.ipa.oz.user.ide.School_if school = null;
// 163
    JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser$val$554;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        getSchoolBrowser$val$554 = prj.getSchoolBrowser ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchoolBrowser$val$554 = prj.getSchoolBrowser ();
    }
// 163
    JP.go.ipa.oz.user.ide.School_if getSchool$val$555;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchoolBrowser$val$554)) {
      try {
        getSchool$val$555 = getSchoolBrowser$val$554.getSchool ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchool$val$555 = getSchoolBrowser$val$554.getSchool ();
    }
// 163
    school = getSchool$val$555;
// 164
    ozc = (JP.go.ipa.oz.user.ide.CompilerAgent_cl) (new JP.go.ipa.oz.user.ide.CompilerAgent_cl ())._new_create (school);
// 165
    JP.go.ipa.oz.user.ide.CompileInfoDialog_if comInfoDlg = (JP.go.ipa.oz.user.ide.CompileInfoDialog_cl) (new JP.go.ipa.oz.user.ide.CompileInfoDialog_cl ())._new_create (prj, false, dlgQueue);
// 166
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) comInfoDlg)) {
      try {
        comInfoDlg.setVisible (true);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      comInfoDlg.setVisible (true);
    }
// 167
    JP.go.ipa.oz.lib.standard._StringWriter_if out = (JP.go.ipa.oz.lib.standard._StringWriter_cl) (new JP.go.ipa.oz.lib.standard._StringWriter_cl ())._new_breed ();
// 168
    JP.go.ipa.oz.user.ide.CompileLog_if cl = (JP.go.ipa.oz.user.ide.CompileLog_cl) (new JP.go.ipa.oz.user.ide.CompileLog_cl ())._new_create (out, comInfoDlg);
// 169
    JP.go.ipa.oz.lib.standard._String_if getProjectDir$val$556;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
      try {
        getProjectDir$val$556 = prj.getProjectDir ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getProjectDir$val$556 = prj.getProjectDir ();
    }
// 169
    ozc.compileSubjectForRelease (getProjectDir$val$556, cl);
// 170
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) comInfoDlg)) {
      try {
        comInfoDlg.setButtonEnabled (true);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      comInfoDlg.setButtonEnabled (true);
    }
  }
  
  public PMController_cl () throws Exception { super (); }
  
}


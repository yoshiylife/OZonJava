package JP.go.ipa.oz.user.ide;

public class SchoolBrowser_cl extends JP.go.ipa.oz.lib.standard._Frame_cl implements JP.go.ipa.oz.user.ide.SchoolBrowser_if {
  JP.go.ipa.oz.lib.standard._CheckboxGroup_if group;
  JP.go.ipa.oz.user.ide.SubjectGarageBrowser_if subjectGarageBrowser;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if queue;
  JP.go.ipa.oz.lib.standard._Label_if lblLabel;
  JP.go.ipa.oz.user.ide.ListLabelController_if listLabelCtrl;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemOpenCBif;
  JP.go.ipa.oz.lib.standard._Checkbox_if rbtnRelease;
  JP.go.ipa.oz.lib.standard._Label_if lblImplID;
  JP.go.ipa.oz.lib.standard._Label_if lblSubject;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemOpenCBcl;
  JP.go.ipa.oz.user.ide.SubjectStateController_if subjectStateCtrl;
  JP.go.ipa.oz.lib.standard._FileDialog_if openFileDialog;
  JP.go.ipa.oz.user.ide.ChoiceSubjectController_if choiceSubjectCtrl;
  JP.go.ipa.oz.user.ide.SBController_if sbCtrl;
  JP.go.ipa.oz.lib.standard._TextField_if txtIfID;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemVersion;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemSubjectImport;
  JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_if applGarageBrowser;
  JP.go.ipa.oz.lib.standard._TextField_if txtImplID;
  JP.go.ipa.oz.user.ide.School_if aSchool;
  JP.go.ipa.oz.lib.standard._Choice_if choSubject;
  JP.go.ipa.oz.lib.standard._Checkbox_if rbtnDevelopment;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemEnd;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemSelectSubjecs;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemAddSubject;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemIDGen;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemSubjectExportCL;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemAdd;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemSubjectExportIF;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemRenameSubject;
  JP.go.ipa.oz.lib.standard._String_if projectDir;
  JP.go.ipa.oz.user.ide.ClassBrowser_if classBrowser;
  JP.go.ipa.oz.lib.standard._List_if lstLabel;
  JP.go.ipa.oz.lib.standard._Label_if lblIfID;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemRun;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemRename;
  JP.go.ipa.oz.lib.standard._Menu_if menu8;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemImport;
  JP.go.ipa.oz.lib.standard._Menu_if menu7;
  JP.go.ipa.oz.lib.standard._Menu_if menu6;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemRemoveSubject;
  JP.go.ipa.oz.lib.standard._MenuBar_if mainMenuBar;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemExport;
  JP.go.ipa.oz.lib.standard._Menu_if menu5;
  JP.go.ipa.oz.lib.standard._FileDialog_if saveFileDialog;
  JP.go.ipa.oz.lib.standard._Menu_if menu4;
  JP.go.ipa.oz.lib.standard._Menu_if menu3;
  JP.go.ipa.oz.lib.standard._Menu_if menu2;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemRemove;
  JP.go.ipa.oz.lib.standard._Menu_if menu1;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemAppResister;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if queue) throws Exception  {
// 69
    super._new_newFrame ();
// 71
    initGUI ();
// 72
    initMenu ();
// 74
    openFileDialog = (JP.go.ipa.oz.lib.standard._FileDialog_cl) (new JP.go.ipa.oz.lib.standard._FileDialog_cl ())._new_newFileLoadDialog (this, (new JP.go.ipa.oz.lib.standard._String_cl("IMPORT")));
// 75
    saveFileDialog = (JP.go.ipa.oz.lib.standard._FileDialog_cl) (new JP.go.ipa.oz.lib.standard._FileDialog_cl ())._new_newFileSaveDialog (this, (new JP.go.ipa.oz.lib.standard._String_cl("EXPORT")));
// 77
    aSchool = (JP.go.ipa.oz.user.ide.School_cl) (new JP.go.ipa.oz.user.ide.School_cl ())._new_create ();
// 78
    JP.go.ipa.oz.lib.standard._Dictionary_if subjects = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create ();
// 79
    JP.go.ipa.oz.lib.standard._Dictionary_if getSubjects$val$1318;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aSchool)) {
      try {
        getSubjects$val$1318 = aSchool.getSubjects ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSubjects$val$1318 = aSchool.getSubjects ();
    }
// 79
    subjects = getSubjects$val$1318;
// 80
    JP.go.ipa.oz.user.ide.Subject_if subject1 = (JP.go.ipa.oz.user.ide.Subject_cl) (new JP.go.ipa.oz.user.ide.Subject_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl("lib")));
// 81
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject1)) {
      try {
        subject1.setImported (true);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      subject1.setImported (true);
    }
// 82
    JP.go.ipa.oz.lib.standard._String_if string$252 = (new JP.go.ipa.oz.lib.standard._String_cl("lib"));
    
// 82
    JP.go.ipa.oz.lib.standard._Dictionary_if put$val$1319;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjects)) {
      try {
        put$val$1319 = subjects.put (string$252, subject1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$1319 = subjects.put (string$252, subject1);
    }
// 83
    JP.go.ipa.oz.lib.standard._String_if string$253 = (new JP.go.ipa.oz.lib.standard._String_cl("lib"));
    
// 83
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
      try {
        choSubject.addItem (string$253);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choSubject.addItem (string$253);
    }
// 84
    JP.go.ipa.oz.user.ide.Subject_if subject2 = (JP.go.ipa.oz.user.ide.Subject_cl) (new JP.go.ipa.oz.user.ide.Subject_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl("ide")));
// 85
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject2)) {
      try {
        subject2.setImported (true);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      subject2.setImported (true);
    }
// 86
    JP.go.ipa.oz.lib.standard._String_if string$254 = (new JP.go.ipa.oz.lib.standard._String_cl("ide"));
    
// 86
    JP.go.ipa.oz.lib.standard._Dictionary_if put$val$1320;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjects)) {
      try {
        put$val$1320 = subjects.put (string$254, subject2);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$1320 = subjects.put (string$254, subject2);
    }
// 87
    JP.go.ipa.oz.lib.standard._String_if string$255 = (new JP.go.ipa.oz.lib.standard._String_cl("ide"));
    
// 87
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
      try {
        choSubject.addItem (string$255);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choSubject.addItem (string$255);
    }
// 88
    JP.go.ipa.oz.user.ide.Subject_if subject3 = (JP.go.ipa.oz.user.ide.Subject_cl) (new JP.go.ipa.oz.user.ide.Subject_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl("sample")));
// 89
    JP.go.ipa.oz.lib.standard._String_if string$256 = (new JP.go.ipa.oz.lib.standard._String_cl("sample"));
    
// 89
    JP.go.ipa.oz.lib.standard._Dictionary_if put$val$1321;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjects)) {
      try {
        put$val$1321 = subjects.put (string$256, subject3);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$1321 = subjects.put (string$256, subject3);
    }
// 90
    JP.go.ipa.oz.lib.standard._String_if string$257 = (new JP.go.ipa.oz.lib.standard._String_cl("sample"));
    
// 90
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
      try {
        choSubject.addItem (string$257);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choSubject.addItem (string$257);
    }
// 93
    activateListeners (queue);
    return this;
  }
  
  public void setSchoolList (JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception  {
    checkSecureInvocation ();
// 325
    JP.go.ipa.oz.lib.standard._Dictionary_if getOzLabels$val$1322;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aSchool)) {
      try {
        getOzLabels$val$1322 = aSchool.getOzLabels (subjectName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabels$val$1322 = aSchool.getOzLabels (subjectName);
    }
// 325
    JP.go.ipa.oz.lib.standard._Dictionary_if labels = getOzLabels$val$1322;
// 326
    JP.go.ipa.oz.lib.standard._Iterator_if lblIterator = null;
// 328
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$1323;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labels)) {
      try {
        iterator$val$1323 = labels.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$1323 = labels.iterator ();
    }
// 328
    lblIterator = iterator$val$1323;
// 329
    JP.go.ipa.oz.lib.standard._String_if sbjName = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ();
// 330
    JP.go.ipa.oz.user.ide.OzLabel_if lbl = (JP.go.ipa.oz.user.ide.OzLabel_cl) (new JP.go.ipa.oz.user.ide.OzLabel_cl ())._new_create ();
// 331
    JP.go.ipa.oz.user.ide.Subject_if subject = null;
// 332
    JP.go.ipa.oz.user.ide.Subject_if getSubject$val$1324;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aSchool)) {
      try {
        getSubject$val$1324 = aSchool.getSubject (subjectName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSubject$val$1324 = aSchool.getSubject (subjectName);
    }
// 332
    subject = getSubject$val$1324;
// 334
    boolean isImported$val$1325;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
      try {
        isImported$val$1325 = subject.isImported ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isImported$val$1325 = subject.isImported ();
    }
// 334
    if (isImported$val$1325) {{
// 335
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rbtnDevelopment)) {
          try {
            rbtnDevelopment.setVisible (false);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          rbtnDevelopment.setVisible (false);
        }
// 336
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rbtnRelease)) {
          try {
            rbtnRelease.setVisible (false);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          rbtnRelease.setVisible (false);
        }
      }
    } else {{
// 338
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rbtnDevelopment)) {
          try {
            rbtnDevelopment.setVisible (true);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          rbtnDevelopment.setVisible (true);
        }
// 339
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rbtnRelease)) {
          try {
            rbtnRelease.setVisible (true);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          rbtnRelease.setVisible (true);
        }
// 340
        boolean isReleased$val$1326;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
          try {
            isReleased$val$1326 = subject.isReleased ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isReleased$val$1326 = subject.isReleased ();
        }
// 340
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rbtnDevelopment)) {
          try {
            rbtnDevelopment.setState (!(isReleased$val$1326));
          } finally {
            changeRunningToGreen ();
          }
        } else {
          rbtnDevelopment.setState (!(isReleased$val$1326));
        }
// 341
        boolean isReleased$val$1327;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
          try {
            isReleased$val$1327 = subject.isReleased ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isReleased$val$1327 = subject.isReleased ();
        }
// 341
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rbtnRelease)) {
          try {
            rbtnRelease.setState (isReleased$val$1327);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          rbtnRelease.setState (isReleased$val$1327);
        }
      }
    }
// 344
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstLabel)) {
      try {
        lstLabel.removeAll ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lstLabel.removeAll ();
    }
// 345
    JP.go.ipa.oz.lib.standard._String_if string$258 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    
// 345
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtIfID)) {
      try {
        txtIfID.setText (string$258);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      txtIfID.setText (string$258);
    }
// 346
    JP.go.ipa.oz.lib.standard._String_if string$259 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    
// 346
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtImplID)) {
      try {
        txtImplID.setText (string$259);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      txtImplID.setText (string$259);
    }
// 347
    while (true) {
// 347
      boolean hasMoreElements$val$1328;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
        try {
          hasMoreElements$val$1328 = lblIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$1328 = lblIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$1328)) break;
      
      /* body */ _loop_1: {
// 348
        JP.go.ipa.oz.lang._Root_if nextElement$val$1329;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
          try {
            nextElement$val$1329 = lblIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$1329 = lblIterator.nextElement ();
        }
// 348
        lbl = (JP.go.ipa.oz.user.ide.OzLabel_if) (nextElement$val$1329);
// 349
        JP.go.ipa.oz.lib.standard._String_if getOzLabelName$val$1330;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lbl)) {
          try {
            getOzLabelName$val$1330 = lbl.getOzLabelName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getOzLabelName$val$1330 = lbl.getOzLabelName ();
        }
// 349
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstLabel)) {
          try {
            lstLabel.addItem (getOzLabelName$val$1330);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          lstLabel.addItem (getOzLabelName$val$1330);
        }
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._MenuItem_if getMenuItemSubjectExportCL () throws Exception  {
    checkSecureInvocation ();
// 422
    return menuItemSubjectExportCL;
  }
  
  public JP.go.ipa.oz.lib.standard._List_if getLstLabel () throws Exception  {
    checkSecureInvocation ();
// 384
    return lstLabel;
  }
  
  public void initMenu () throws Exception  {
    checkSecureInvocation ();
// 154
    mainMenuBar = (JP.go.ipa.oz.lib.standard._MenuBar_cl) (new JP.go.ipa.oz.lib.standard._MenuBar_cl ())._new_newMenuBar ();
// 156
    menu1 = (JP.go.ipa.oz.lib.standard._Menu_cl) (new JP.go.ipa.oz.lib.standard._Menu_cl ())._new_newMenu ((new JP.go.ipa.oz.lib.standard._String_cl("File")));
// 157
    menuItemImport = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("import...")));
// 158
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$1331;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu1)) {
      try {
        add$val$1331 = menu1.add (menuItemImport);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1331 = menu1.add (menuItemImport);
    }
// 159
    menuItemExport = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("export...")));
// 160
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$1332;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu1)) {
      try {
        add$val$1332 = menu1.add (menuItemExport);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1332 = menu1.add (menuItemExport);
    }
// 161
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu1)) {
      try {
        menu1.addSeparator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menu1.addSeparator ();
    }
// 162
    menuItemEnd = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("end")));
// 163
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$1333;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu1)) {
      try {
        add$val$1333 = menu1.add (menuItemEnd);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1333 = menu1.add (menuItemEnd);
    }
// 164
    JP.go.ipa.oz.lib.standard._Menu_if add$val$1334;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mainMenuBar)) {
      try {
        add$val$1334 = mainMenuBar.add (menu1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1334 = mainMenuBar.add (menu1);
    }
// 166
    menu2 = (JP.go.ipa.oz.lib.standard._Menu_cl) (new JP.go.ipa.oz.lib.standard._Menu_cl ())._new_newMenu ((new JP.go.ipa.oz.lib.standard._String_cl("School")));
// 167
    menuItemAdd = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("add class...")));
// 168
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$1335;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu2)) {
      try {
        add$val$1335 = menu2.add (menuItemAdd);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1335 = menu2.add (menuItemAdd);
    }
// 169
    menuItemRemove = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("remove class...")));
// 170
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$1336;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu2)) {
      try {
        add$val$1336 = menu2.add (menuItemRemove);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1336 = menu2.add (menuItemRemove);
    }
// 171
    menuItemRename = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("rename class...")));
// 172
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$1337;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu2)) {
      try {
        add$val$1337 = menu2.add (menuItemRename);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1337 = menu2.add (menuItemRename);
    }
// 173
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu2)) {
      try {
        menu2.addSeparator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menu2.addSeparator ();
    }
// 174
    menuItemAddSubject = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("add subject...")));
// 175
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$1338;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu2)) {
      try {
        add$val$1338 = menu2.add (menuItemAddSubject);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1338 = menu2.add (menuItemAddSubject);
    }
// 176
    menuItemRemoveSubject = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("remove subject...")));
// 177
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$1339;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu2)) {
      try {
        add$val$1339 = menu2.add (menuItemRemoveSubject);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1339 = menu2.add (menuItemRemoveSubject);
    }
// 178
    menuItemRenameSubject = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("rename subject...")));
// 179
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$1340;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu2)) {
      try {
        add$val$1340 = menu2.add (menuItemRenameSubject);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1340 = menu2.add (menuItemRenameSubject);
    }
// 180
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu2)) {
      try {
        menu2.addSeparator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menu2.addSeparator ();
    }
// 181
    menuItemIDGen = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("class ID Generate...")));
// 182
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$1341;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu2)) {
      try {
        add$val$1341 = menu2.add (menuItemIDGen);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1341 = menu2.add (menuItemIDGen);
    }
// 183
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu2)) {
      try {
        menu2.addSeparator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menu2.addSeparator ();
    }
// 184
    menuItemSelectSubjecs = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("select subjects...")));
// 185
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$1342;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu2)) {
      try {
        add$val$1342 = menu2.add (menuItemSelectSubjecs);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1342 = menu2.add (menuItemSelectSubjecs);
    }
// 186
    JP.go.ipa.oz.lib.standard._Menu_if add$val$1343;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mainMenuBar)) {
      try {
        add$val$1343 = mainMenuBar.add (menu2);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1343 = mainMenuBar.add (menu2);
    }
// 188
    menu3 = (JP.go.ipa.oz.lib.standard._Menu_cl) (new JP.go.ipa.oz.lib.standard._Menu_cl ())._new_newMenu ((new JP.go.ipa.oz.lib.standard._String_cl("Run")));
// 189
    menuItemRun = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("run...")));
// 190
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$1344;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu3)) {
      try {
        add$val$1344 = menu3.add (menuItemRun);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1344 = menu3.add (menuItemRun);
    }
// 191
    JP.go.ipa.oz.lib.standard._Menu_if add$val$1345;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mainMenuBar)) {
      try {
        add$val$1345 = mainMenuBar.add (menu3);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1345 = mainMenuBar.add (menu3);
    }
// 193
    menu4 = (JP.go.ipa.oz.lib.standard._Menu_cl) (new JP.go.ipa.oz.lib.standard._Menu_cl ())._new_newMenu ((new JP.go.ipa.oz.lib.standard._String_cl("ClassBrowser")));
// 194
    menu6 = (JP.go.ipa.oz.lib.standard._Menu_cl) (new JP.go.ipa.oz.lib.standard._Menu_cl ())._new_newMenu ((new JP.go.ipa.oz.lib.standard._String_cl("open (selected label)")));
// 195
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$1346;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu4)) {
      try {
        add$val$1346 = menu4.add (menu6);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1346 = menu4.add (menu6);
    }
// 196
    menuItemOpenCBif = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("interface part..")));
// 197
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$1347;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu6)) {
      try {
        add$val$1347 = menu6.add (menuItemOpenCBif);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1347 = menu6.add (menuItemOpenCBif);
    }
// 198
    menuItemOpenCBcl = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("implementaion part..")));
// 199
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$1348;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu6)) {
      try {
        add$val$1348 = menu6.add (menuItemOpenCBcl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1348 = menu6.add (menuItemOpenCBcl);
    }
// 200
    JP.go.ipa.oz.lib.standard._Menu_if add$val$1349;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mainMenuBar)) {
      try {
        add$val$1349 = mainMenuBar.add (menu4);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1349 = mainMenuBar.add (menu4);
    }
// 202
    menu7 = (JP.go.ipa.oz.lib.standard._Menu_cl) (new JP.go.ipa.oz.lib.standard._Menu_cl ())._new_newMenu ((new JP.go.ipa.oz.lib.standard._String_cl("Catalog")));
// 203
    menuItemSubjectImport = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("import subject...")));
// 204
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$1350;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu7)) {
      try {
        add$val$1350 = menu7.add (menuItemSubjectImport);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1350 = menu7.add (menuItemSubjectImport);
    }
// 205
    menu8 = (JP.go.ipa.oz.lib.standard._Menu_cl) (new JP.go.ipa.oz.lib.standard._Menu_cl ())._new_newMenu ((new JP.go.ipa.oz.lib.standard._String_cl("export subject")));
// 206
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$1351;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu7)) {
      try {
        add$val$1351 = menu7.add (menu8);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1351 = menu7.add (menu8);
    }
// 207
    menuItemSubjectExportIF = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("interface part...")));
// 208
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$1352;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu8)) {
      try {
        add$val$1352 = menu8.add (menuItemSubjectExportIF);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1352 = menu8.add (menuItemSubjectExportIF);
    }
// 209
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemSubjectExportIF)) {
      try {
        menuItemSubjectExportIF.setEnabled (false);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemSubjectExportIF.setEnabled (false);
    }
// 210
    menuItemSubjectExportCL = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("implementation part...")));
// 211
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$1353;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu8)) {
      try {
        add$val$1353 = menu8.add (menuItemSubjectExportCL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1353 = menu8.add (menuItemSubjectExportCL);
    }
// 212
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemSubjectExportCL)) {
      try {
        menuItemSubjectExportCL.setEnabled (false);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemSubjectExportCL.setEnabled (false);
    }
// 213
    menuItemAppResister = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("resister application...")));
// 214
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$1354;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu7)) {
      try {
        add$val$1354 = menu7.add (menuItemAppResister);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1354 = menu7.add (menuItemAppResister);
    }
// 215
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemAppResister)) {
      try {
        menuItemAppResister.setEnabled (false);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemAppResister.setEnabled (false);
    }
// 216
    JP.go.ipa.oz.lib.standard._Menu_if add$val$1355;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mainMenuBar)) {
      try {
        add$val$1355 = mainMenuBar.add (menu7);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1355 = mainMenuBar.add (menu7);
    }
// 218
    menu5 = (JP.go.ipa.oz.lib.standard._Menu_cl) (new JP.go.ipa.oz.lib.standard._Menu_cl ())._new_newMenu ((new JP.go.ipa.oz.lib.standard._String_cl("Help")));
// 219
    menuItemVersion = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("version...")));
// 220
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$1356;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu5)) {
      try {
        add$val$1356 = menu5.add (menuItemVersion);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1356 = menu5.add (menuItemVersion);
    }
// 221
    JP.go.ipa.oz.lib.standard._Menu_if add$val$1357;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mainMenuBar)) {
      try {
        add$val$1357 = mainMenuBar.add (menu5);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1357 = mainMenuBar.add (menu5);
    }
// 223
    setMenuBar (mainMenuBar);
  }
  
  public JP.go.ipa.oz.lib.standard._MenuItem_if getMenuItemAppResister () throws Exception  {
    checkSecureInvocation ();
// 429
    return menuItemAppResister;
  }
  
  public JP.go.ipa.oz.user.ide.School_if getSchool () throws Exception  {
    checkSecureInvocation ();
// 376
    return aSchool;
  }
  
  public void setProjectDir (JP.go.ipa.oz.lib.standard._String_if dir) throws Exception  {
    checkSecureInvocation ();
// 502
    projectDir = dir;
  }
  
  public void initGUI () throws Exception  {
    checkSecureInvocation ();
// 98
    JP.go.ipa.oz.lib.standard._GridLayout_if grid1 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (1, 2, 10, 10);
// 99
    setLayout (grid1);
// 100
    addNotify ();
// 101
    setSize (500, 410);
// 103
    JP.go.ipa.oz.lib.standard._BorderLayout_if border1 = (JP.go.ipa.oz.lib.standard._BorderLayout_cl) (new JP.go.ipa.oz.lib.standard._BorderLayout_cl ())._new_newBorderLayout ();
// 104
    JP.go.ipa.oz.lib.standard._GridLayout_if grid2 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (12, 1, 10, 10);
// 106
    JP.go.ipa.oz.lib.standard._Panel_if panel1 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (border1);
// 107
    JP.go.ipa.oz.lib.standard._Panel_if panel2 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (grid2);
// 108
    add (panel1);
// 109
    add (panel2);
// 110
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        panel1.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel1.addNotify ();
    }
// 111
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        panel2.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel2.addNotify ();
    }
// 113
    JP.go.ipa.oz.lib.standard._GridLayout_if grid3 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (1, 2, 10, 10);
// 114
    JP.go.ipa.oz.lib.standard._Panel_if panel3 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (grid3);
// 115
    JP.go.ipa.oz.lib.standard._String_if string$260 = (new JP.go.ipa.oz.lib.standard._String_cl("North"));
    
// 115
    JP.go.ipa.oz.lib.standard._Component_if add$val$1358;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        add$val$1358 = panel1.add (string$260, panel3);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1358 = panel1.add (string$260, panel3);
    }
// 116
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel3)) {
      try {
        panel3.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel3.addNotify ();
    }
// 117
    lblSubject = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("  Subject :")));
// 118
    JP.go.ipa.oz.lib.standard._Component_if add$val$1359;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel3)) {
      try {
        add$val$1359 = panel3.add (lblSubject);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1359 = panel3.add (lblSubject);
    }
// 119
    choSubject = (JP.go.ipa.oz.lib.standard._Choice_cl) (new JP.go.ipa.oz.lib.standard._Choice_cl ())._new_newChoice ();
// 120
    JP.go.ipa.oz.lib.standard._Component_if add$val$1360;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel3)) {
      try {
        add$val$1360 = panel3.add (choSubject);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1360 = panel3.add (choSubject);
    }
// 122
    lblLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("  Label :")));
// 123
    JP.go.ipa.oz.lib.standard._String_if string$261 = (new JP.go.ipa.oz.lib.standard._String_cl("Center"));
    
// 123
    JP.go.ipa.oz.lib.standard._Component_if add$val$1361;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        add$val$1361 = panel1.add (string$261, lblLabel);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1361 = panel1.add (string$261, lblLabel);
    }
// 125
    lstLabel = (JP.go.ipa.oz.lib.standard._List_cl) (new JP.go.ipa.oz.lib.standard._List_cl ())._new_newList (20, false);
// 126
    JP.go.ipa.oz.lib.standard._String_if string$262 = (new JP.go.ipa.oz.lib.standard._String_cl("South"));
    
// 126
    JP.go.ipa.oz.lib.standard._Component_if add$val$1362;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        add$val$1362 = panel1.add (string$262, lstLabel);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1362 = panel1.add (string$262, lstLabel);
    }
// 128
    group = (JP.go.ipa.oz.lib.standard._CheckboxGroup_cl) (new JP.go.ipa.oz.lib.standard._CheckboxGroup_cl ())._new_newCheckboxGroup ();
// 129
    rbtnDevelopment = (JP.go.ipa.oz.lib.standard._Checkbox_cl) (new JP.go.ipa.oz.lib.standard._Checkbox_cl ())._new_newCheckbox ((new JP.go.ipa.oz.lib.standard._String_cl("for Development")), group, true);
// 130
    JP.go.ipa.oz.lib.standard._Component_if add$val$1363;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$1363 = panel2.add (rbtnDevelopment);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1363 = panel2.add (rbtnDevelopment);
    }
// 131
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rbtnDevelopment)) {
      try {
        rbtnDevelopment.setVisible (false);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      rbtnDevelopment.setVisible (false);
    }
// 132
    rbtnRelease = (JP.go.ipa.oz.lib.standard._Checkbox_cl) (new JP.go.ipa.oz.lib.standard._Checkbox_cl ())._new_newCheckbox ((new JP.go.ipa.oz.lib.standard._String_cl("for Release")), group, false);
// 133
    JP.go.ipa.oz.lib.standard._Component_if add$val$1364;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$1364 = panel2.add (rbtnRelease);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1364 = panel2.add (rbtnRelease);
    }
// 134
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rbtnRelease)) {
      try {
        rbtnRelease.setVisible (false);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      rbtnRelease.setVisible (false);
    }
// 135
    lblIfID = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("Interface ID : ")));
// 136
    JP.go.ipa.oz.lib.standard._Component_if add$val$1365;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$1365 = panel2.add (lblIfID);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1365 = panel2.add (lblIfID);
    }
// 137
    txtIfID = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField ((new JP.go.ipa.oz.lib.standard._String_cl("")), 30);
// 138
    JP.go.ipa.oz.lib.standard._Component_if add$val$1366;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$1366 = panel2.add (txtIfID);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1366 = panel2.add (txtIfID);
    }
// 139
    JP.go.ipa.oz.lib.standard._Label_if lblTmp3 = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ();
// 140
    JP.go.ipa.oz.lib.standard._Component_if add$val$1367;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$1367 = panel2.add (lblTmp3);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1367 = panel2.add (lblTmp3);
    }
// 141
    lblImplID = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("Implementation ID : ")));
// 142
    JP.go.ipa.oz.lib.standard._Component_if add$val$1368;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$1368 = panel2.add (lblImplID);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1368 = panel2.add (lblImplID);
    }
// 143
    txtImplID = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField ((new JP.go.ipa.oz.lib.standard._String_cl("")), 30);
// 144
    JP.go.ipa.oz.lib.standard._Component_if add$val$1369;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$1369 = panel2.add (txtImplID);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1369 = panel2.add (txtImplID);
    }
// 145
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtIfID)) {
      try {
        txtIfID.setEditable (false);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      txtIfID.setEditable (false);
    }
// 146
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtImplID)) {
      try {
        txtImplID.setEditable (false);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      txtImplID.setEditable (false);
    }
// 148
    setTitle ((new JP.go.ipa.oz.lib.standard._String_cl("School Browser")));
  }
  
  public void setVisible (boolean b) throws Exception  {
    checkSecureInvocation ();
// 315
    setLocation (10, 410);
// 316
    super.setVisible (b);
  }
  
  public void mergeSubject (JP.go.ipa.oz.user.ide.Subject_if subject) throws Exception  {
    checkSecureInvocation ();
// 356
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aSchool)) {
      try {
        aSchool.mergeSubject (subject);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      aSchool.mergeSubject (subject);
    }
// 358
    JP.go.ipa.oz.lib.standard._Dictionary_if getSubjects$val$1370;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aSchool)) {
      try {
        getSubjects$val$1370 = aSchool.getSubjects ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSubjects$val$1370 = aSchool.getSubjects ();
    }
// 358
    JP.go.ipa.oz.lib.standard._Dictionary_if subjects = getSubjects$val$1370;
// 359
    JP.go.ipa.oz.user.ide.Subject_if subject$1 = null;
// 360
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$1371;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjects)) {
      try {
        iterator$val$1371 = subjects.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$1371 = subjects.iterator ();
    }
// 360
    JP.go.ipa.oz.lib.standard._Iterator_if sbjIterator = iterator$val$1371;
// 361
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
      try {
        choSubject.removeAll ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choSubject.removeAll ();
    }
// 362
    while (true) {
// 362
      boolean hasMoreElements$val$1372;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbjIterator)) {
        try {
          hasMoreElements$val$1372 = sbjIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$1372 = sbjIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$1372)) break;
      
      /* body */ _loop_1: {
// 363
        JP.go.ipa.oz.lang._Root_if nextElement$val$1373;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbjIterator)) {
          try {
            nextElement$val$1373 = sbjIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$1373 = sbjIterator.nextElement ();
        }
// 363
        subject$1 = (JP.go.ipa.oz.user.ide.Subject_if) (nextElement$val$1373);
// 364
        JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$1374;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject$1)) {
          try {
            getSubjectName$val$1374 = subject$1.getSubjectName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSubjectName$val$1374 = subject$1.getSubjectName ();
        }
// 364
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
          try {
            choSubject.addItem (getSubjectName$val$1374);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          choSubject.addItem (getSubjectName$val$1374);
        }
      }
    }
// 366
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$1375;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
      try {
        getSelectedItem$val$1375 = choSubject.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$1375 = choSubject.getSelectedItem ();
    }
// 366
    setSchoolList (getSelectedItem$val$1375);
// 367
    JP.go.ipa.oz.user.ide.DuplicateMessageDialog_if dlg = (JP.go.ipa.oz.user.ide.DuplicateMessageDialog_cl) (new JP.go.ipa.oz.user.ide.DuplicateMessageDialog_cl ())._new_create (this, true, queue);
// 368
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
      try {
        dlg.setVisible (true);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      dlg.setVisible (true);
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Choice_if getChoSubject () throws Exception  {
    checkSecureInvocation ();
// 408
    return choSubject;
  }
  
  public JP.go.ipa.oz.lib.standard._TextField_if getTxtImplID () throws Exception  {
    checkSecureInvocation ();
// 400
    return txtImplID;
  }
  
  public JP.go.ipa.oz.user.ide.ClassBrowser_if getClassBrowser () throws Exception  {
    checkSecureInvocation ();
// 454
    return classBrowser;
  }
  
  public void activateListeners (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception  {
    checkSecureInvocation ();
// 270
    queue = q;
// 271
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dlgQueue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 273
    sbCtrl = (JP.go.ipa.oz.user.ide.SBController_cl) (new JP.go.ipa.oz.user.ide.SBController_cl ())._new_create (this, queue);
// 274
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbCtrl)) {
      try {
        sbCtrl.setDlgQueue (dlgQueue);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sbCtrl.setDlgQueue (dlgQueue);
    }
// 275
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemImport)) {
      try {
        menuItemImport.addActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemImport.addActionListener (sbCtrl);
    }
// 276
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemExport)) {
      try {
        menuItemExport.addActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemExport.addActionListener (sbCtrl);
    }
// 277
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemEnd)) {
      try {
        menuItemEnd.addActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemEnd.addActionListener (sbCtrl);
    }
// 278
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemAdd)) {
      try {
        menuItemAdd.addActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemAdd.addActionListener (sbCtrl);
    }
// 279
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemRemove)) {
      try {
        menuItemRemove.addActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemRemove.addActionListener (sbCtrl);
    }
// 280
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemRename)) {
      try {
        menuItemRename.addActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemRename.addActionListener (sbCtrl);
    }
// 281
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemIDGen)) {
      try {
        menuItemIDGen.addActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemIDGen.addActionListener (sbCtrl);
    }
// 282
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemSelectSubjecs)) {
      try {
        menuItemSelectSubjecs.addActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemSelectSubjecs.addActionListener (sbCtrl);
    }
// 283
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemAddSubject)) {
      try {
        menuItemAddSubject.addActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemAddSubject.addActionListener (sbCtrl);
    }
// 284
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemRemoveSubject)) {
      try {
        menuItemRemoveSubject.addActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemRemoveSubject.addActionListener (sbCtrl);
    }
// 285
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemRenameSubject)) {
      try {
        menuItemRenameSubject.addActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemRenameSubject.addActionListener (sbCtrl);
    }
// 286
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemRun)) {
      try {
        menuItemRun.addActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemRun.addActionListener (sbCtrl);
    }
// 287
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemOpenCBif)) {
      try {
        menuItemOpenCBif.addActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemOpenCBif.addActionListener (sbCtrl);
    }
// 288
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemOpenCBcl)) {
      try {
        menuItemOpenCBcl.addActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemOpenCBcl.addActionListener (sbCtrl);
    }
// 289
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemSubjectExportIF)) {
      try {
        menuItemSubjectExportIF.addActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemSubjectExportIF.addActionListener (sbCtrl);
    }
// 290
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemSubjectExportCL)) {
      try {
        menuItemSubjectExportCL.addActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemSubjectExportCL.addActionListener (sbCtrl);
    }
// 291
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemSubjectImport)) {
      try {
        menuItemSubjectImport.addActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemSubjectImport.addActionListener (sbCtrl);
    }
// 292
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemAppResister)) {
      try {
        menuItemAppResister.addActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemAppResister.addActionListener (sbCtrl);
    }
// 293
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemVersion)) {
      try {
        menuItemVersion.addActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemVersion.addActionListener (sbCtrl);
    }
// 294
    listLabelCtrl = (JP.go.ipa.oz.user.ide.ListLabelController_cl) (new JP.go.ipa.oz.user.ide.ListLabelController_cl ())._new_create (this, queue);
// 295
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstLabel)) {
      try {
        lstLabel.addItemListener (listLabelCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lstLabel.addItemListener (listLabelCtrl);
    }
// 296
    choiceSubjectCtrl = (JP.go.ipa.oz.user.ide.ChoiceSubjectController_cl) (new JP.go.ipa.oz.user.ide.ChoiceSubjectController_cl ())._new_create (this, queue);
// 297
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
      try {
        choSubject.addItemListener (choiceSubjectCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choSubject.addItemListener (choiceSubjectCtrl);
    }
// 298
    subjectStateCtrl = (JP.go.ipa.oz.user.ide.SubjectStateController_cl) (new JP.go.ipa.oz.user.ide.SubjectStateController_cl ())._new_create (this, queue);
// 299
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rbtnDevelopment)) {
      try {
        rbtnDevelopment.addItemListener (subjectStateCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      rbtnDevelopment.addItemListener (subjectStateCtrl);
    }
// 300
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rbtnRelease)) {
      try {
        rbtnRelease.addItemListener (subjectStateCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      rbtnRelease.addItemListener (subjectStateCtrl);
    }
// 302
    classBrowser = (JP.go.ipa.oz.user.ide.ClassBrowser_cl) (new JP.go.ipa.oz.user.ide.ClassBrowser_cl ())._new_newClassBrowser (aSchool);
// 304
    subjectGarageBrowser = (JP.go.ipa.oz.user.ide.SubjectGarageBrowser_cl) (new JP.go.ipa.oz.user.ide.SubjectGarageBrowser_cl ())._new_create (this);
// 306
    applGarageBrowser = (JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_cl) (new JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_cl ())._new_create (this);
  }
  
  public JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_if getApplicationGarageBrowser () throws Exception  {
    checkSecureInvocation ();
// 472
    return applGarageBrowser;
  }
  
  public JP.go.ipa.oz.lib.standard._Checkbox_if getRbtnRelease () throws Exception  {
    checkSecureInvocation ();
// 490
    return rbtnRelease;
  }
  
  public JP.go.ipa.oz.lib.standard._Checkbox_if getRbtnDevelopment () throws Exception  {
    checkSecureInvocation ();
// 481
    return rbtnDevelopment;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getProjectDir () throws Exception  {
    checkSecureInvocation ();
// 496
    return projectDir;
  }
  
  public JP.go.ipa.oz.lib.standard._TextField_if getTxtIfID () throws Exception  {
    checkSecureInvocation ();
// 392
    return txtIfID;
  }
  
  public JP.go.ipa.oz.lib.standard._FileDialog_if getSaveFileDialog () throws Exception  {
    checkSecureInvocation ();
// 445
    return saveFileDialog;
  }
  
  public void deleteListeners () throws Exception  {
    checkSecureInvocation ();
// 232
    boolean isDestroyed$val$1376;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) queue)) {
      try {
        isDestroyed$val$1376 = queue.isDestroyed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isDestroyed$val$1376 = queue.isDestroyed ();
    }
// 232
    if (!isDestroyed$val$1376) {
// 232
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) queue)) {
        try {
          queue.destroy ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        queue.destroy ();
      }
    }
// 233
    queue = null;
// 234
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbCtrl)) {
      try {
        sbCtrl.destroyDlgQueue ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sbCtrl.destroyDlgQueue ();
    }
// 235
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbCtrl)) {
      try {
        sbCtrl.setDlgQueue (null);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sbCtrl.setDlgQueue (null);
    }
// 237
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemImport)) {
      try {
        menuItemImport.removeActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemImport.removeActionListener (sbCtrl);
    }
// 238
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemExport)) {
      try {
        menuItemExport.removeActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemExport.removeActionListener (sbCtrl);
    }
// 239
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemEnd)) {
      try {
        menuItemEnd.removeActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemEnd.removeActionListener (sbCtrl);
    }
// 240
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemAdd)) {
      try {
        menuItemAdd.removeActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemAdd.removeActionListener (sbCtrl);
    }
// 241
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemRemove)) {
      try {
        menuItemRemove.removeActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemRemove.removeActionListener (sbCtrl);
    }
// 242
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemRename)) {
      try {
        menuItemRename.removeActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemRename.removeActionListener (sbCtrl);
    }
// 243
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemIDGen)) {
      try {
        menuItemIDGen.removeActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemIDGen.removeActionListener (sbCtrl);
    }
// 244
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemSelectSubjecs)) {
      try {
        menuItemSelectSubjecs.removeActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemSelectSubjecs.removeActionListener (sbCtrl);
    }
// 245
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemAddSubject)) {
      try {
        menuItemAddSubject.removeActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemAddSubject.removeActionListener (sbCtrl);
    }
// 246
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemRemoveSubject)) {
      try {
        menuItemRemoveSubject.removeActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemRemoveSubject.removeActionListener (sbCtrl);
    }
// 247
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemRenameSubject)) {
      try {
        menuItemRenameSubject.removeActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemRenameSubject.removeActionListener (sbCtrl);
    }
// 248
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemRun)) {
      try {
        menuItemRun.removeActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemRun.removeActionListener (sbCtrl);
    }
// 249
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemOpenCBif)) {
      try {
        menuItemOpenCBif.removeActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemOpenCBif.removeActionListener (sbCtrl);
    }
// 250
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemOpenCBcl)) {
      try {
        menuItemOpenCBcl.removeActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemOpenCBcl.removeActionListener (sbCtrl);
    }
// 251
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemSubjectExportIF)) {
      try {
        menuItemSubjectExportIF.removeActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemSubjectExportIF.removeActionListener (sbCtrl);
    }
// 252
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemSubjectExportCL)) {
      try {
        menuItemSubjectExportCL.removeActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemSubjectExportCL.removeActionListener (sbCtrl);
    }
// 253
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemSubjectImport)) {
      try {
        menuItemSubjectImport.removeActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemSubjectImport.removeActionListener (sbCtrl);
    }
// 254
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemAppResister)) {
      try {
        menuItemAppResister.removeActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemAppResister.removeActionListener (sbCtrl);
    }
// 255
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemVersion)) {
      try {
        menuItemVersion.removeActionListener (sbCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemVersion.removeActionListener (sbCtrl);
    }
// 256
    sbCtrl = null;
// 257
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstLabel)) {
      try {
        lstLabel.removeItemListener (listLabelCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lstLabel.removeItemListener (listLabelCtrl);
    }
// 258
    listLabelCtrl = null;
// 259
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choSubject)) {
      try {
        choSubject.removeItemListener (choiceSubjectCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choSubject.removeItemListener (choiceSubjectCtrl);
    }
// 260
    choiceSubjectCtrl = null;
// 261
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rbtnDevelopment)) {
      try {
        rbtnDevelopment.removeItemListener (subjectStateCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      rbtnDevelopment.removeItemListener (subjectStateCtrl);
    }
// 262
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rbtnRelease)) {
      try {
        rbtnRelease.removeItemListener (subjectStateCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      rbtnRelease.removeItemListener (subjectStateCtrl);
    }
// 263
    subjectStateCtrl = null;
// 264
    classBrowser = null;
// 265
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjectGarageBrowser)) {
      try {
        subjectGarageBrowser.quit ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      subjectGarageBrowser.quit ();
    }
// 266
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) applGarageBrowser)) {
      try {
        applGarageBrowser.quit ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      applGarageBrowser.quit ();
    }
  }
  
  public JP.go.ipa.oz.lib.standard._FileDialog_if getOpenFileDialog () throws Exception  {
    checkSecureInvocation ();
// 437
    return openFileDialog;
  }
  
  public JP.go.ipa.oz.user.ide.SubjectGarageBrowser_if getSubjectGarageBrowser () throws Exception  {
    checkSecureInvocation ();
// 463
    return subjectGarageBrowser;
  }
  
  public JP.go.ipa.oz.lib.standard._MenuItem_if getMenuItemSubjectExportIF () throws Exception  {
    checkSecureInvocation ();
// 415
    return menuItemSubjectExportIF;
  }
  
  public SchoolBrowser_cl () throws Exception { super (); }
  
}


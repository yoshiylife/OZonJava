package JP.go.ipa.oz.user.ide;

public class ProjectManager_cl extends JP.go.ipa.oz.lib.standard._Frame_cl implements JP.go.ipa.oz.user.ide.ProjectManager_if {
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemSave;
  JP.go.ipa.oz.user.ide.SchoolBrowser_if schoolBrowser;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemSaveAs;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemRefresh;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if queue;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemEdit;
  JP.go.ipa.oz.lib.standard._String_if projectName;
  JP.go.ipa.oz.lib.standard._Dictionary_if projects;
  JP.go.ipa.oz.lib.standard._List_if srcList;
  JP.go.ipa.oz.user.ide.PMController_if pmCtrl;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemSetDir;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemNew;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemCompileAuto;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemEnd;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemCompileIf;
  JP.go.ipa.oz.lib.standard._Label_if lblProjectDir;
  JP.go.ipa.oz.user.ide.RefreshController_if refreshCtrl;
  JP.go.ipa.oz.lib.standard._TextField_if txtProjectDir;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemHelp;
  JP.go.ipa.oz.user.ide.ListController_if listCtrl;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemCompileRelease;
  JP.go.ipa.oz.lib.standard._String_if editor;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemCompile;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemSetEditor;
  JP.go.ipa.oz.lib.standard._MenuBar_if mainMenuBar;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemProjectRemove;
  JP.go.ipa.oz.lib.standard._String_if fName;
  JP.go.ipa.oz.lib.standard._Menu_if menu4;
  JP.go.ipa.oz.lib.standard._Button_if btnRefresh;
  JP.go.ipa.oz.lib.standard._Menu_if menu3;
  JP.go.ipa.oz.lib.standard._Menu_if menu2;
  JP.go.ipa.oz.lib.standard._Menu_if menu1;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemCompileSubject;
  JP.go.ipa.oz.lib.standard._MenuItem_if menuItemOpen;
  JP.go.ipa.oz.lib.standard._Label_if lblProjectFiles;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if queue) throws Exception  {
// 57
    super._new_newFrame ();
// 60
    JP.go.ipa.oz.lib.standard._StringComparator_if sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 61
    projects = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (sc);
// 62
    projectName = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ();
// 63
    fName = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ();
// 64
    JP.go.ipa.oz.lib.standard._String_if projectName = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("Project1")));
// 65
    JP.go.ipa.oz.user.ide.Project_if prj = (JP.go.ipa.oz.user.ide.Project_cl) (new JP.go.ipa.oz.user.ide.Project_cl ())._new_create (projectName);
// 66
    setProjectName (projectName);
// 67
    JP.go.ipa.oz.lib.standard._Dictionary_if put$val$572;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projects)) {
      try {
        put$val$572 = projects.put (projectName, prj);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$572 = projects.put (projectName, prj);
    }
// 68
    setTitle ((new JP.go.ipa.oz.lib.standard._String_cl("OZ Project Manager [Project1]")));
// 70
    initGUI ();
// 71
    initMenu ();
// 74
    activateListeners (queue);
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getProjectName () throws Exception  {
    checkSecureInvocation ();
// 319
    return projectName;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getEditor () throws Exception  {
    checkSecureInvocation ();
// 373
    return editor;
  }
  
  public void setSchoolBrowser (JP.go.ipa.oz.user.ide.SchoolBrowser_if sb) throws Exception  {
    checkSecureInvocation ();
// 283
    schoolBrowser = sb;
  }
  
  public JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser () throws Exception  {
    checkSecureInvocation ();
// 292
    return schoolBrowser;
  }
  
  public JP.go.ipa.oz.lib.standard._Dictionary_if getProjects () throws Exception  {
    checkSecureInvocation ();
// 301
    return projects;
  }
  
  public JP.go.ipa.oz.lib.standard._List_if getSrcList () throws Exception  {
    checkSecureInvocation ();
// 355
    return srcList;
  }
  
  public void initMenu () throws Exception  {
    checkSecureInvocation ();
// 120
    mainMenuBar = (JP.go.ipa.oz.lib.standard._MenuBar_cl) (new JP.go.ipa.oz.lib.standard._MenuBar_cl ())._new_newMenuBar ();
// 122
    menu1 = (JP.go.ipa.oz.lib.standard._Menu_cl) (new JP.go.ipa.oz.lib.standard._Menu_cl ())._new_newMenu ((new JP.go.ipa.oz.lib.standard._String_cl("Project")));
// 123
    menuItemNew = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("new")));
// 124
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$573;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu1)) {
      try {
        add$val$573 = menu1.add (menuItemNew);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$573 = menu1.add (menuItemNew);
    }
// 125
    menuItemOpen = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("open...")));
// 126
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$574;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu1)) {
      try {
        add$val$574 = menu1.add (menuItemOpen);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$574 = menu1.add (menuItemOpen);
    }
// 127
    menuItemSave = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("save")));
// 128
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$575;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu1)) {
      try {
        add$val$575 = menu1.add (menuItemSave);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$575 = menu1.add (menuItemSave);
    }
// 129
    menuItemSaveAs = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("save as...")));
// 130
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$576;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu1)) {
      try {
        add$val$576 = menu1.add (menuItemSaveAs);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$576 = menu1.add (menuItemSaveAs);
    }
// 131
    menuItemProjectRemove = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("remove...")));
// 132
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$577;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu1)) {
      try {
        add$val$577 = menu1.add (menuItemProjectRemove);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$577 = menu1.add (menuItemProjectRemove);
    }
// 133
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu1)) {
      try {
        menu1.addSeparator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menu1.addSeparator ();
    }
// 134
    menuItemEnd = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("end")));
// 135
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$578;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu1)) {
      try {
        add$val$578 = menu1.add (menuItemEnd);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$578 = menu1.add (menuItemEnd);
    }
// 136
    JP.go.ipa.oz.lib.standard._Menu_if add$val$579;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mainMenuBar)) {
      try {
        add$val$579 = mainMenuBar.add (menu1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$579 = mainMenuBar.add (menu1);
    }
// 138
    menu2 = (JP.go.ipa.oz.lib.standard._Menu_cl) (new JP.go.ipa.oz.lib.standard._Menu_cl ())._new_newMenu ((new JP.go.ipa.oz.lib.standard._String_cl("Edit")));
// 139
    menuItemRefresh = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("refresh")));
// 140
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$580;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu2)) {
      try {
        add$val$580 = menu2.add (menuItemRefresh);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$580 = menu2.add (menuItemRefresh);
    }
// 141
    menuItemSetDir = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("set directory...")));
// 142
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$581;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu2)) {
      try {
        add$val$581 = menu2.add (menuItemSetDir);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$581 = menu2.add (menuItemSetDir);
    }
// 143
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu2)) {
      try {
        menu2.addSeparator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menu2.addSeparator ();
    }
// 144
    menuItemEdit = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("edit file")));
// 145
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$582;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu2)) {
      try {
        add$val$582 = menu2.add (menuItemEdit);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$582 = menu2.add (menuItemEdit);
    }
// 146
    menuItemSetEditor = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("set editor...")));
// 147
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$583;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu2)) {
      try {
        add$val$583 = menu2.add (menuItemSetEditor);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$583 = menu2.add (menuItemSetEditor);
    }
// 148
    JP.go.ipa.oz.lib.standard._Menu_if add$val$584;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mainMenuBar)) {
      try {
        add$val$584 = mainMenuBar.add (menu2);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$584 = mainMenuBar.add (menu2);
    }
// 150
    menu3 = (JP.go.ipa.oz.lib.standard._Menu_cl) (new JP.go.ipa.oz.lib.standard._Menu_cl ())._new_newMenu ((new JP.go.ipa.oz.lib.standard._String_cl("Compile")));
// 151
    menuItemCompile = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("compile")));
// 152
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$585;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu3)) {
      try {
        add$val$585 = menu3.add (menuItemCompile);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$585 = menu3.add (menuItemCompile);
    }
// 153
    menuItemCompileIf = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("compile interface")));
// 154
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$586;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu3)) {
      try {
        add$val$586 = menu3.add (menuItemCompileIf);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$586 = menu3.add (menuItemCompileIf);
    }
// 155
    menuItemCompileSubject = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("compile subject")));
// 156
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$587;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu3)) {
      try {
        add$val$587 = menu3.add (menuItemCompileSubject);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$587 = menu3.add (menuItemCompileSubject);
    }
// 157
    menuItemCompileRelease = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("compile for release")));
// 158
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$588;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu3)) {
      try {
        add$val$588 = menu3.add (menuItemCompileRelease);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$588 = menu3.add (menuItemCompileRelease);
    }
// 159
    menuItemCompileAuto = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("compile auto")));
// 160
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$589;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu3)) {
      try {
        add$val$589 = menu3.add (menuItemCompileAuto);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$589 = menu3.add (menuItemCompileAuto);
    }
// 161
    JP.go.ipa.oz.lib.standard._Menu_if add$val$590;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mainMenuBar)) {
      try {
        add$val$590 = mainMenuBar.add (menu3);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$590 = mainMenuBar.add (menu3);
    }
// 163
    menu4 = (JP.go.ipa.oz.lib.standard._Menu_cl) (new JP.go.ipa.oz.lib.standard._Menu_cl ())._new_newMenu ((new JP.go.ipa.oz.lib.standard._String_cl("Help")));
// 164
    menuItemHelp = (JP.go.ipa.oz.lib.standard._MenuItem_cl) (new JP.go.ipa.oz.lib.standard._MenuItem_cl ())._new_newMenuItem ((new JP.go.ipa.oz.lib.standard._String_cl("version...")));
// 165
    JP.go.ipa.oz.lib.standard._MenuItem_if add$val$591;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menu4)) {
      try {
        add$val$591 = menu4.add (menuItemHelp);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$591 = menu4.add (menuItemHelp);
    }
// 166
    JP.go.ipa.oz.lib.standard._Menu_if add$val$592;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mainMenuBar)) {
      try {
        add$val$592 = mainMenuBar.add (menu4);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$592 = mainMenuBar.add (menu4);
    }
// 167
    setMenuBar (mainMenuBar);
  }
  
  public void setProjects (JP.go.ipa.oz.lib.standard._Dictionary_if prj) throws Exception  {
    checkSecureInvocation ();
// 310
    projects = prj;
  }
  
  public void setProjectDir (JP.go.ipa.oz.lib.standard._String_if projectDir) throws Exception  {
    checkSecureInvocation ();
// 382
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtProjectDir)) {
      try {
        txtProjectDir.setText (projectDir);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      txtProjectDir.setText (projectDir);
    }
  }
  
  public void initGUI () throws Exception  {
    checkSecureInvocation ();
// 80
    JP.go.ipa.oz.lib.standard._BorderLayout_if border1 = (JP.go.ipa.oz.lib.standard._BorderLayout_cl) (new JP.go.ipa.oz.lib.standard._BorderLayout_cl ())._new_newBorderLayout ();
// 81
    setLayout (border1);
// 82
    addNotify ();
// 83
    setSize (400, 400);
// 85
    JP.go.ipa.oz.lib.standard._GridLayout_if grid1 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (3, 1);
// 86
    JP.go.ipa.oz.lib.standard._Panel_if panel1 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (grid1);
// 87
    add ((new JP.go.ipa.oz.lib.standard._String_cl("North")), panel1);
// 88
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        panel1.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel1.addNotify ();
    }
// 90
    JP.go.ipa.oz.lib.standard._FlowLayout_if flow1 = (JP.go.ipa.oz.lib.standard._FlowLayout_cl) (new JP.go.ipa.oz.lib.standard._FlowLayout_cl ())._new_newFlowLayout (0, 10, 10);
// 91
    JP.go.ipa.oz.lib.standard._Panel_if panel2 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (flow1);
// 92
    JP.go.ipa.oz.lib.standard._Component_if add$val$593;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        add$val$593 = panel1.add (panel2);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$593 = panel1.add (panel2);
    }
// 93
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        panel2.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel2.addNotify ();
    }
// 94
    lblProjectDir = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("Project Directory :")));
// 95
    JP.go.ipa.oz.lib.standard._Component_if add$val$594;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$594 = panel2.add (lblProjectDir);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$594 = panel2.add (lblProjectDir);
    }
// 97
    JP.go.ipa.oz.lib.standard._FlowLayout_if flow2 = (JP.go.ipa.oz.lib.standard._FlowLayout_cl) (new JP.go.ipa.oz.lib.standard._FlowLayout_cl ())._new_newFlowLayout (0, 10, 10);
// 98
    JP.go.ipa.oz.lib.standard._Panel_if panel3 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (flow2);
// 99
    JP.go.ipa.oz.lib.standard._Component_if add$val$595;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        add$val$595 = panel1.add (panel3);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$595 = panel1.add (panel3);
    }
// 100
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel3)) {
      try {
        panel3.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel3.addNotify ();
    }
// 101
    txtProjectDir = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField (50);
// 102
    JP.go.ipa.oz.lib.standard._Component_if add$val$596;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel3)) {
      try {
        add$val$596 = panel3.add (txtProjectDir);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$596 = panel3.add (txtProjectDir);
    }
// 103
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtProjectDir)) {
      try {
        txtProjectDir.setEditable (false);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      txtProjectDir.setEditable (false);
    }
// 105
    JP.go.ipa.oz.lib.standard._FlowLayout_if flow3 = (JP.go.ipa.oz.lib.standard._FlowLayout_cl) (new JP.go.ipa.oz.lib.standard._FlowLayout_cl ())._new_newFlowLayout (0, 10, 10);
// 106
    JP.go.ipa.oz.lib.standard._Panel_if panel4 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (flow3);
// 107
    JP.go.ipa.oz.lib.standard._Component_if add$val$597;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        add$val$597 = panel1.add (panel4);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$597 = panel1.add (panel4);
    }
// 108
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel4)) {
      try {
        panel4.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel4.addNotify ();
    }
// 109
    lblProjectFiles = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("Project Files :")));
// 110
    JP.go.ipa.oz.lib.standard._Component_if add$val$598;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel4)) {
      try {
        add$val$598 = panel4.add (lblProjectFiles);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$598 = panel4.add (lblProjectFiles);
    }
// 111
    btnRefresh = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("Refresh")));
// 112
    JP.go.ipa.oz.lib.standard._Component_if add$val$599;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel4)) {
      try {
        add$val$599 = panel4.add (btnRefresh);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$599 = panel4.add (btnRefresh);
    }
// 114
    srcList = (JP.go.ipa.oz.lib.standard._List_cl) (new JP.go.ipa.oz.lib.standard._List_cl ())._new_newList (20, false);
// 115
    add ((new JP.go.ipa.oz.lib.standard._String_cl("Center")), srcList);
  }
  
  public void setVisible (boolean b) throws Exception  {
    checkSecureInvocation ();
// 238
    setLocation (10, 10);
// 239
    super.setVisible (b);
  }
  
  public void setFName (JP.go.ipa.oz.lib.standard._String_if fileName) throws Exception  {
    checkSecureInvocation ();
// 346
    fName = fileName;
  }
  
  public void setProjectName (JP.go.ipa.oz.lib.standard._String_if prjName) throws Exception  {
    checkSecureInvocation ();
// 328
    projectName = prjName;
  }
  
  public void activateListeners (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception  {
    checkSecureInvocation ();
// 205
    queue = q;
// 206
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dlgQueue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 208
    pmCtrl = (JP.go.ipa.oz.user.ide.PMController_cl) (new JP.go.ipa.oz.user.ide.PMController_cl ())._new_create (this, queue);
// 209
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pmCtrl)) {
      try {
        pmCtrl.setDlgQueue (dlgQueue);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pmCtrl.setDlgQueue (dlgQueue);
    }
// 210
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemNew)) {
      try {
        menuItemNew.addActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemNew.addActionListener (pmCtrl);
    }
// 211
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemOpen)) {
      try {
        menuItemOpen.addActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemOpen.addActionListener (pmCtrl);
    }
// 212
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemSave)) {
      try {
        menuItemSave.addActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemSave.addActionListener (pmCtrl);
    }
// 213
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemSaveAs)) {
      try {
        menuItemSaveAs.addActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemSaveAs.addActionListener (pmCtrl);
    }
// 214
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemProjectRemove)) {
      try {
        menuItemProjectRemove.addActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemProjectRemove.addActionListener (pmCtrl);
    }
// 215
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemEnd)) {
      try {
        menuItemEnd.addActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemEnd.addActionListener (pmCtrl);
    }
// 216
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemRefresh)) {
      try {
        menuItemRefresh.addActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemRefresh.addActionListener (pmCtrl);
    }
// 217
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemSetDir)) {
      try {
        menuItemSetDir.addActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemSetDir.addActionListener (pmCtrl);
    }
// 218
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemEdit)) {
      try {
        menuItemEdit.addActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemEdit.addActionListener (pmCtrl);
    }
// 219
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemSetEditor)) {
      try {
        menuItemSetEditor.addActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemSetEditor.addActionListener (pmCtrl);
    }
// 220
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemCompile)) {
      try {
        menuItemCompile.addActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemCompile.addActionListener (pmCtrl);
    }
// 221
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemCompileIf)) {
      try {
        menuItemCompileIf.addActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemCompileIf.addActionListener (pmCtrl);
    }
// 222
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemCompileSubject)) {
      try {
        menuItemCompileSubject.addActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemCompileSubject.addActionListener (pmCtrl);
    }
// 223
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemCompileRelease)) {
      try {
        menuItemCompileRelease.addActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemCompileRelease.addActionListener (pmCtrl);
    }
// 224
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemCompileAuto)) {
      try {
        menuItemCompileAuto.addActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemCompileAuto.addActionListener (pmCtrl);
    }
// 225
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemHelp)) {
      try {
        menuItemHelp.addActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemHelp.addActionListener (pmCtrl);
    }
// 226
    listCtrl = (JP.go.ipa.oz.user.ide.ListController_cl) (new JP.go.ipa.oz.user.ide.ListController_cl ())._new_create (this, queue);
// 227
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) srcList)) {
      try {
        srcList.addActionListener (listCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      srcList.addActionListener (listCtrl);
    }
// 228
    refreshCtrl = (JP.go.ipa.oz.user.ide.RefreshController_cl) (new JP.go.ipa.oz.user.ide.RefreshController_cl ())._new_create (this, queue);
// 229
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnRefresh)) {
      try {
        btnRefresh.addActionListener (refreshCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnRefresh.addActionListener (refreshCtrl);
    }
  }
  
  public void setEditor (JP.go.ipa.oz.lib.standard._String_if ed) throws Exception  {
    checkSecureInvocation ();
// 364
    editor = ed;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getProjectDir () throws Exception  {
    checkSecureInvocation ();
// 391
    JP.go.ipa.oz.lib.standard._String_if getText$val$600;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtProjectDir)) {
      try {
        getText$val$600 = txtProjectDir.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$600 = txtProjectDir.getText ();
    }
// 391
    return getText$val$600;
  }
  
  public void deleteListeners () throws Exception  {
    checkSecureInvocation ();
// 176
    boolean isDestroyed$val$601;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) queue)) {
      try {
        isDestroyed$val$601 = queue.isDestroyed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isDestroyed$val$601 = queue.isDestroyed ();
    }
// 176
    if (!isDestroyed$val$601) {
// 176
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
// 177
    queue = null;
// 178
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pmCtrl)) {
      try {
        pmCtrl.destroyDlgQueue ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pmCtrl.destroyDlgQueue ();
    }
// 179
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pmCtrl)) {
      try {
        pmCtrl.setDlgQueue (null);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pmCtrl.setDlgQueue (null);
    }
// 181
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemNew)) {
      try {
        menuItemNew.removeActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemNew.removeActionListener (pmCtrl);
    }
// 182
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemOpen)) {
      try {
        menuItemOpen.removeActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemOpen.removeActionListener (pmCtrl);
    }
// 183
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemSave)) {
      try {
        menuItemSave.removeActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemSave.removeActionListener (pmCtrl);
    }
// 184
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemSaveAs)) {
      try {
        menuItemSaveAs.removeActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemSaveAs.removeActionListener (pmCtrl);
    }
// 185
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemProjectRemove)) {
      try {
        menuItemProjectRemove.removeActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemProjectRemove.removeActionListener (pmCtrl);
    }
// 186
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemEnd)) {
      try {
        menuItemEnd.removeActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemEnd.removeActionListener (pmCtrl);
    }
// 187
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemRefresh)) {
      try {
        menuItemRefresh.removeActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemRefresh.removeActionListener (pmCtrl);
    }
// 188
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemSetDir)) {
      try {
        menuItemSetDir.removeActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemSetDir.removeActionListener (pmCtrl);
    }
// 189
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemEdit)) {
      try {
        menuItemEdit.removeActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemEdit.removeActionListener (pmCtrl);
    }
// 190
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemSetEditor)) {
      try {
        menuItemSetEditor.removeActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemSetEditor.removeActionListener (pmCtrl);
    }
// 191
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemCompile)) {
      try {
        menuItemCompile.removeActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemCompile.removeActionListener (pmCtrl);
    }
// 192
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemCompileIf)) {
      try {
        menuItemCompileIf.removeActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemCompileIf.removeActionListener (pmCtrl);
    }
// 193
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemCompileSubject)) {
      try {
        menuItemCompileSubject.removeActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemCompileSubject.removeActionListener (pmCtrl);
    }
// 194
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemCompileRelease)) {
      try {
        menuItemCompileRelease.removeActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemCompileRelease.removeActionListener (pmCtrl);
    }
// 195
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemCompileAuto)) {
      try {
        menuItemCompileAuto.removeActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemCompileAuto.removeActionListener (pmCtrl);
    }
// 196
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItemHelp)) {
      try {
        menuItemHelp.removeActionListener (pmCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      menuItemHelp.removeActionListener (pmCtrl);
    }
// 197
    pmCtrl = null;
// 198
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) srcList)) {
      try {
        srcList.removeActionListener (listCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      srcList.removeActionListener (listCtrl);
    }
// 199
    listCtrl = null;
// 200
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnRefresh)) {
      try {
        btnRefresh.removeActionListener (refreshCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnRefresh.removeActionListener (refreshCtrl);
    }
// 201
    refreshCtrl = null;
  }
  
  public void openEditor () throws Exception  {
    checkSecureInvocation ();
// 248
    JP.go.ipa.oz.lib.standard._StringBuffer_if edit = null;
// 249
    JP.go.ipa.oz.lib.standard._Process_if process = null;
    boolean bool$val$21;
    
    bool$val$21 = editor == null;
    if (!bool$val$21) {
// 251
      JP.go.ipa.oz.lib.standard._String_if string$133 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
      
// 251
      int compareTo$val$602;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) editor)) {
        try {
          compareTo$val$602 = editor.compareTo (string$133);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        compareTo$val$602 = editor.compareTo (string$133);
      }
      bool$val$21 = compareTo$val$602 == 0;
    }
// 251
    if (bool$val$21) {
// 251
      return;
    }
// 253
    JP.go.ipa.oz.lib.standard._String_if ozHome = null, separator = null;
// 254
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 255
    JP.go.ipa.oz.lib.standard._String_if getOzHome$val$603;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getOzHome$val$603 = system.getOzHome ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzHome$val$603 = system.getOzHome ();
    }
// 255
    ozHome = getOzHome$val$603;
// 256
    JP.go.ipa.oz.lib.standard._String_if string$134 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    
// 256
    boolean startsWith$val$604;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
      try {
        startsWith$val$604 = ozHome.startsWith (string$134);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$604 = ozHome.startsWith (string$134);
    }
// 256
    if (startsWith$val$604) {
// 257
      separator = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    } else {
// 259
      separator = (new JP.go.ipa.oz.lib.standard._String_cl("\\"));
    }
// 261
    try {
// 262
      JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$605;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) srcList)) {
        try {
          getSelectedItem$val$605 = srcList.getSelectedItem ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getSelectedItem$val$605 = srcList.getSelectedItem ();
      }
// 262
      if (getSelectedItem$val$605 != null) {{
// 263
          edit = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (editor);
// 264
          edit.append ((new JP.go.ipa.oz.lib.standard._String_cl(" ")));
// 265
          JP.go.ipa.oz.lib.standard._String_if getText$val$606;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtProjectDir)) {
            try {
              getText$val$606 = txtProjectDir.getText ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getText$val$606 = txtProjectDir.getText ();
          }
// 265
          edit.append (getText$val$606);
// 266
          edit.append (separator);
// 267
          JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$607;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) srcList)) {
            try {
              getSelectedItem$val$607 = srcList.getSelectedItem ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getSelectedItem$val$607 = srcList.getSelectedItem ();
          }
// 267
          edit.append (getSelectedItem$val$607);
// 268
          process = (JP.go.ipa.oz.lib.standard._Process_cl) (new JP.go.ipa.oz.lib.standard._Process_cl ())._new_create (edit.asString ());
        }
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_1) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
      if (_oz_exception_1 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
        JP.go.ipa.oz.lib.standard._IOException_if e = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_1;
// 271
        ;
      } else throw _exception_1;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 273
      ;
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getFName () throws Exception  {
    checkSecureInvocation ();
// 337
    return fName;
  }
  
  public ProjectManager_cl () throws Exception { super (); }
  
}


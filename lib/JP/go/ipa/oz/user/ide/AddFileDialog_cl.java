package JP.go.ipa.oz.user.ide;

public class AddFileDialog_cl extends JP.go.ipa.oz.lib.standard._Dialog_cl implements JP.go.ipa.oz.user.ide.AddFileDialog_if {
  int ozEnv;
  JP.go.ipa.oz.user.ide.AddFileItemListener_if addIL;
  JP.go.ipa.oz.lib.standard._List_if lstFileName;
  JP.go.ipa.oz.user.ide.ProjectManager_if projectManager;
  JP.go.ipa.oz.user.ide.AddFileActionListener_if addAL;
  JP.go.ipa.oz.lib.standard._List_if lstDirName;
  JP.go.ipa.oz.lib.standard._Array_if files;
  JP.go.ipa.oz.lib.standard._Label_if lblFileName;
  JP.go.ipa.oz.lib.standard._Choice_if choDrive;
  JP.go.ipa.oz.lib.standard._Label_if lblDirName;
  JP.go.ipa.oz.lib.standard._Button_if btnCancel;
  JP.go.ipa.oz.lib.standard._String_if ozHome;
  JP.go.ipa.oz.lib.standard._Button_if btnAddDir;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Frame_if parent, boolean modal, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if queue) throws Exception  {
// 39
    super._new_newDialog (parent, modal);
// 41
    projectManager = (JP.go.ipa.oz.user.ide.ProjectManager_if) (parent);
// 44
    initGUI ();
// 46
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 47
    JP.go.ipa.oz.lib.standard._String_if getOzHome$val$19;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getOzHome$val$19 = system.getOzHome ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzHome$val$19 = system.getOzHome ();
    }
// 47
    ozHome = getOzHome$val$19;
// 48
    JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    
// 48
    boolean startsWith$val$20;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
      try {
        startsWith$val$20 = ozHome.startsWith (string$2);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$20 = ozHome.startsWith (string$2);
    }
// 48
    if (startsWith$val$20) {{
// 49
        ozEnv = 1;
// 50
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
          try {
            choDrive.setVisible (false);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          choDrive.setVisible (false);
        }
      }
    } else {{
// 52
        ozEnv = 0;
// 53
        JP.go.ipa.oz.lib.standard._String_if substring$val$21;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
          try {
            substring$val$21 = ozHome.substring (0, 2);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          substring$val$21 = ozHome.substring (0, 2);
        }
// 53
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
          try {
            choDrive.select (substring$val$21);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          choDrive.select (substring$val$21);
        }
      }
    }
// 56
    setDirectory (ozHome);
// 59
    addAL = (JP.go.ipa.oz.user.ide.AddFileActionListener_cl) (new JP.go.ipa.oz.user.ide.AddFileActionListener_cl ())._new_create (this, queue);
// 60
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnAddDir)) {
      try {
        btnAddDir.addActionListener (addAL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnAddDir.addActionListener (addAL);
    }
// 61
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnCancel)) {
      try {
        btnCancel.addActionListener (addAL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnCancel.addActionListener (addAL);
    }
// 62
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstDirName)) {
      try {
        lstDirName.addActionListener (addAL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lstDirName.addActionListener (addAL);
    }
// 63
    addIL = (JP.go.ipa.oz.user.ide.AddFileItemListener_cl) (new JP.go.ipa.oz.user.ide.AddFileItemListener_cl ())._new_create (this, queue);
// 64
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItemListener (addIL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItemListener (addIL);
    }
    return this;
  }
  
  public void initGUI () throws Exception  {
    checkSecureInvocation ();
// 77
    JP.go.ipa.oz.lib.standard._BorderLayout_if border = (JP.go.ipa.oz.lib.standard._BorderLayout_cl) (new JP.go.ipa.oz.lib.standard._BorderLayout_cl ())._new_newBorderLayout ();
// 78
    setLayout (border);
// 79
    addNotify ();
// 81
    setSize (500, 400);
// 82
    JP.go.ipa.oz.lib.standard._GridLayout_if grid1 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (1, 2, 20, 20);
// 83
    JP.go.ipa.oz.lib.standard._GridLayout_if grid2 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (1, 2, 20, 20);
// 84
    JP.go.ipa.oz.lib.standard._GridLayout_if grid3 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (1, 3, 40, 40);
// 85
    JP.go.ipa.oz.lib.standard._Panel_if panel1 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (grid1);
// 86
    JP.go.ipa.oz.lib.standard._Panel_if panel2 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (grid2);
// 87
    JP.go.ipa.oz.lib.standard._Panel_if panel3 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (grid3);
// 88
    add ((new JP.go.ipa.oz.lib.standard._String_cl("North")), panel1);
// 89
    add ((new JP.go.ipa.oz.lib.standard._String_cl("Center")), panel2);
// 90
    add ((new JP.go.ipa.oz.lib.standard._String_cl("South")), panel3);
// 91
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        panel1.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel1.addNotify ();
    }
// 92
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        panel2.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel2.addNotify ();
    }
// 93
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel3)) {
      try {
        panel3.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel3.addNotify ();
    }
// 95
    lblDirName = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("Directory")));
// 96
    JP.go.ipa.oz.lib.standard._Component_if add$val$22;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        add$val$22 = panel1.add (lblDirName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$22 = panel1.add (lblDirName);
    }
// 97
    lblFileName = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("File")));
// 98
    JP.go.ipa.oz.lib.standard._Component_if add$val$23;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        add$val$23 = panel1.add (lblFileName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$23 = panel1.add (lblFileName);
    }
// 100
    lstDirName = (JP.go.ipa.oz.lib.standard._List_cl) (new JP.go.ipa.oz.lib.standard._List_cl ())._new_newList (10, false);
// 101
    JP.go.ipa.oz.lib.standard._Component_if add$val$24;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$24 = panel2.add (lstDirName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$24 = panel2.add (lstDirName);
    }
// 102
    lstFileName = (JP.go.ipa.oz.lib.standard._List_cl) (new JP.go.ipa.oz.lib.standard._List_cl ())._new_newList (10, true);
// 103
    JP.go.ipa.oz.lib.standard._Component_if add$val$25;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$25 = panel2.add (lstFileName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$25 = panel2.add (lstFileName);
    }
// 105
    choDrive = (JP.go.ipa.oz.lib.standard._Choice_cl) (new JP.go.ipa.oz.lib.standard._Choice_cl ())._new_newChoice ();
// 106
    setItem ();
// 107
    JP.go.ipa.oz.lib.standard._Component_if add$val$26;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel3)) {
      try {
        add$val$26 = panel3.add (choDrive);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$26 = panel3.add (choDrive);
    }
// 108
    btnAddDir = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("set dir")));
// 109
    JP.go.ipa.oz.lib.standard._Component_if add$val$27;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel3)) {
      try {
        add$val$27 = panel3.add (btnAddDir);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$27 = panel3.add (btnAddDir);
    }
// 110
    btnCancel = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("Cancel")));
// 111
    JP.go.ipa.oz.lib.standard._Component_if add$val$28;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel3)) {
      try {
        add$val$28 = panel3.add (btnCancel);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$28 = panel3.add (btnCancel);
    }
  }
  
  public void setNextDirectory () throws Exception  {
    checkSecureInvocation ();
// 202
    JP.go.ipa.oz.lib.standard._String_if selectedDirName = null;
// 203
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$29;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstDirName)) {
      try {
        getSelectedItem$val$29 = lstDirName.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$29 = lstDirName.getSelectedItem ();
    }
// 203
    selectedDirName = getSelectedItem$val$29;
// 205
    JP.go.ipa.oz.lib.standard._String_if string$3 = (new JP.go.ipa.oz.lib.standard._String_cl(".."));
    
// 205
    int compareTo$val$30;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) selectedDirName)) {
      try {
        compareTo$val$30 = selectedDirName.compareTo (string$3);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compareTo$val$30 = selectedDirName.compareTo (string$3);
    }
// 205
    if (compareTo$val$30 != 0) {{
// 206
        JP.go.ipa.oz.lib.standard._StringBuffer_if dirName = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 207
        JP.go.ipa.oz.lib.standard._String_if getTitle$val$31;
        getTitle$val$31 = getTitle ();
// 207
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$32;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dirName)) {
          try {
            append$val$32 = dirName.append (getTitle$val$31);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$32 = dirName.append (getTitle$val$31);
        }
        boolean bool$val$0;
        
// 208
        JP.go.ipa.oz.lib.standard._String_if getTitle$val$33;
        getTitle$val$33 = getTitle ();
// 208
        JP.go.ipa.oz.lib.standard._String_if string$4 = (new JP.go.ipa.oz.lib.standard._String_cl("\\"));
        
// 208
        boolean endsWith$val$34;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getTitle$val$33)) {
          try {
            endsWith$val$34 = getTitle$val$33.endsWith (string$4);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          endsWith$val$34 = getTitle$val$33.endsWith (string$4);
        }
        bool$val$0 = !(endsWith$val$34);
        if (bool$val$0) {
// 208
          JP.go.ipa.oz.lib.standard._String_if getTitle$val$35;
          getTitle$val$35 = getTitle ();
// 208
          JP.go.ipa.oz.lib.standard._String_if string$5 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
          
// 208
          boolean endsWith$val$36;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getTitle$val$35)) {
            try {
              endsWith$val$36 = getTitle$val$35.endsWith (string$5);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            endsWith$val$36 = getTitle$val$35.endsWith (string$5);
          }
          bool$val$0 = !(endsWith$val$36);
        }
// 208
        if (bool$val$0) {{
// 209
            if (ozEnv == 0) {
// 210
              JP.go.ipa.oz.lib.standard._String_if string$6 = (new JP.go.ipa.oz.lib.standard._String_cl("\\"));
              
// 210
              JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$37;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dirName)) {
                try {
                  append$val$37 = dirName.append (string$6);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                append$val$37 = dirName.append (string$6);
              }
            } else {
// 212
              JP.go.ipa.oz.lib.standard._String_if string$7 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
              
// 212
              JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$38;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dirName)) {
                try {
                  append$val$38 = dirName.append (string$7);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                append$val$38 = dirName.append (string$7);
              }
            }
          }
        }
// 214
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$39;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dirName)) {
          try {
            append$val$39 = dirName.append (selectedDirName);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$39 = dirName.append (selectedDirName);
        }
// 215
        JP.go.ipa.oz.lib.standard._String_if asString$val$40;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dirName)) {
          try {
            asString$val$40 = dirName.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$40 = dirName.asString ();
        }
// 215
        setDirectory (asString$val$40);
      }
    } else {{
// 217
        JP.go.ipa.oz.lib.standard._File_if file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (getTitle ());
// 218
        JP.go.ipa.oz.lib.standard._String_if upperDirName = null;
// 219
        JP.go.ipa.oz.lib.standard._String_if getParent$val$41;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
          try {
            getParent$val$41 = file.getParent ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getParent$val$41 = file.getParent ();
        }
// 219
        upperDirName = getParent$val$41;
// 220
        if (upperDirName == null) {
// 220
          return;
        }
// 221
        setDirectory (upperDirName);
      }
    }
  }
  
  public void setFiles (JP.go.ipa.oz.lib.standard._Array_if selectedFiles) throws Exception  {
    checkSecureInvocation ();
// 168
    files = selectedFiles;
  }
  
  public void setDirectory (JP.go.ipa.oz.lib.standard._String_if dirName) throws Exception  {
    checkSecureInvocation ();
// 177
    JP.go.ipa.oz.lib.standard._Array_if dirList = null;
// 178
    JP.go.ipa.oz.lib.standard._File_if file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (dirName);
// 179
    JP.go.ipa.oz.user.ide.DirectoryFilter_if filter = (JP.go.ipa.oz.user.ide.DirectoryFilter_cl) (new JP.go.ipa.oz.user.ide.DirectoryFilter_cl ())._new_create ();
// 180
    JP.go.ipa.oz.lib.standard._Array_if list$val$42;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        list$val$42 = file.list (filter);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      list$val$42 = file.list (filter);
    }
// 180
    dirList = list$val$42;
// 181
    int max = 0;
// 182
    JP.go.ipa.oz.lib.standard._String_if tmp = null;
// 183
    if (dirList == null) {
// 183
      return;
    }
// 184
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstDirName)) {
      try {
        lstDirName.removeAll ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lstDirName.removeAll ();
    }
// 185
    JP.go.ipa.oz.lib.standard._String_if getParent$val$43;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        getParent$val$43 = file.getParent ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getParent$val$43 = file.getParent ();
    }
// 185
    if (getParent$val$43 != null) {
// 186
      JP.go.ipa.oz.lib.standard._String_if string$8 = (new JP.go.ipa.oz.lib.standard._String_cl(".."));
      
// 186
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstDirName)) {
        try {
          lstDirName.addItem (string$8);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        lstDirName.addItem (string$8);
      }
    }
// 187
    int size$val$44;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dirList)) {
      try {
        size$val$44 = dirList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$44 = dirList.size ();
    }
// 187
    max = size$val$44;
// 188
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < max)) break;
        
        /* body */ _loop_1: {
// 189
          JP.go.ipa.oz.lang._Root_if at$val$45;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dirList)) {
            try {
              at$val$45 = dirList.at (i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            at$val$45 = dirList.at (i);
          }
// 189
          tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$45);
// 190
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstDirName)) {
            try {
              lstDirName.addItem (tmp);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            lstDirName.addItem (tmp);
          }
        }
        /* iteration part */
// 188
        i++;
      }
    }
// 192
    setTitle (dirName);
// 193
    setFile (dirName);
  }
  
  public void changeDrive () throws Exception  {
    checkSecureInvocation ();
// 252
    JP.go.ipa.oz.lib.standard._String_if newDrive = null;
// 253
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$46;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        getSelectedItem$val$46 = choDrive.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$46 = choDrive.getSelectedItem ();
    }
// 253
    newDrive = getSelectedItem$val$46;
// 254
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (newDrive);
// 255
    JP.go.ipa.oz.lib.standard._String_if string$9 = (new JP.go.ipa.oz.lib.standard._String_cl("\\"));
    
// 255
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$47;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$47 = buf.append (string$9);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$47 = buf.append (string$9);
    }
// 256
    JP.go.ipa.oz.lib.standard._String_if asString$val$48;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        asString$val$48 = buf.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$48 = buf.asString ();
    }
// 256
    JP.go.ipa.oz.lib.standard._File_if file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (asString$val$48);
// 257
    boolean isDirectory$val$49;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        isDirectory$val$49 = file.isDirectory ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isDirectory$val$49 = file.isDirectory ();
    }
// 257
    if (isDirectory$val$49) {
// 258
      JP.go.ipa.oz.lib.standard._String_if asString$val$50;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
        try {
          asString$val$50 = buf.asString ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        asString$val$50 = buf.asString ();
      }
// 258
      setDirectory (asString$val$50);
    } else {
// 260
      JP.go.ipa.oz.lib.standard._String_if getTitle$val$51;
      getTitle$val$51 = getTitle ();
// 260
      JP.go.ipa.oz.lib.standard._String_if substring$val$52;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getTitle$val$51)) {
        try {
          substring$val$52 = getTitle$val$51.substring (0, 2);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        substring$val$52 = getTitle$val$51.substring (0, 2);
      }
// 260
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
        try {
          choDrive.select (substring$val$52);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        choDrive.select (substring$val$52);
      }
    }
  }
  
  public void setItem () throws Exception  {
    checkSecureInvocation ();
// 115
    JP.go.ipa.oz.lib.standard._String_if string$10 = (new JP.go.ipa.oz.lib.standard._String_cl("a:"));
    
// 115
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$10);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$10);
    }
// 116
    JP.go.ipa.oz.lib.standard._String_if string$11 = (new JP.go.ipa.oz.lib.standard._String_cl("b:"));
    
// 116
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$11);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$11);
    }
// 117
    JP.go.ipa.oz.lib.standard._String_if string$12 = (new JP.go.ipa.oz.lib.standard._String_cl("c:"));
    
// 117
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$12);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$12);
    }
// 118
    JP.go.ipa.oz.lib.standard._String_if string$13 = (new JP.go.ipa.oz.lib.standard._String_cl("d:"));
    
// 118
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$13);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$13);
    }
// 119
    JP.go.ipa.oz.lib.standard._String_if string$14 = (new JP.go.ipa.oz.lib.standard._String_cl("e:"));
    
// 119
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$14);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$14);
    }
// 120
    JP.go.ipa.oz.lib.standard._String_if string$15 = (new JP.go.ipa.oz.lib.standard._String_cl("f:"));
    
// 120
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$15);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$15);
    }
// 121
    JP.go.ipa.oz.lib.standard._String_if string$16 = (new JP.go.ipa.oz.lib.standard._String_cl("g:"));
    
// 121
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$16);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$16);
    }
// 122
    JP.go.ipa.oz.lib.standard._String_if string$17 = (new JP.go.ipa.oz.lib.standard._String_cl("h:"));
    
// 122
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$17);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$17);
    }
// 123
    JP.go.ipa.oz.lib.standard._String_if string$18 = (new JP.go.ipa.oz.lib.standard._String_cl("i:"));
    
// 123
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$18);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$18);
    }
// 124
    JP.go.ipa.oz.lib.standard._String_if string$19 = (new JP.go.ipa.oz.lib.standard._String_cl("j:"));
    
// 124
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$19);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$19);
    }
// 125
    JP.go.ipa.oz.lib.standard._String_if string$20 = (new JP.go.ipa.oz.lib.standard._String_cl("k:"));
    
// 125
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$20);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$20);
    }
// 126
    JP.go.ipa.oz.lib.standard._String_if string$21 = (new JP.go.ipa.oz.lib.standard._String_cl("l:"));
    
// 126
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$21);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$21);
    }
// 127
    JP.go.ipa.oz.lib.standard._String_if string$22 = (new JP.go.ipa.oz.lib.standard._String_cl("m:"));
    
// 127
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$22);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$22);
    }
// 128
    JP.go.ipa.oz.lib.standard._String_if string$23 = (new JP.go.ipa.oz.lib.standard._String_cl("n:"));
    
// 128
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$23);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$23);
    }
// 129
    JP.go.ipa.oz.lib.standard._String_if string$24 = (new JP.go.ipa.oz.lib.standard._String_cl("o:"));
    
// 129
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$24);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$24);
    }
// 130
    JP.go.ipa.oz.lib.standard._String_if string$25 = (new JP.go.ipa.oz.lib.standard._String_cl("p:"));
    
// 130
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$25);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$25);
    }
// 131
    JP.go.ipa.oz.lib.standard._String_if string$26 = (new JP.go.ipa.oz.lib.standard._String_cl("q:"));
    
// 131
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$26);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$26);
    }
// 132
    JP.go.ipa.oz.lib.standard._String_if string$27 = (new JP.go.ipa.oz.lib.standard._String_cl("r:"));
    
// 132
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$27);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$27);
    }
// 133
    JP.go.ipa.oz.lib.standard._String_if string$28 = (new JP.go.ipa.oz.lib.standard._String_cl("s:"));
    
// 133
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$28);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$28);
    }
// 134
    JP.go.ipa.oz.lib.standard._String_if string$29 = (new JP.go.ipa.oz.lib.standard._String_cl("t:"));
    
// 134
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$29);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$29);
    }
// 135
    JP.go.ipa.oz.lib.standard._String_if string$30 = (new JP.go.ipa.oz.lib.standard._String_cl("u:"));
    
// 135
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$30);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$30);
    }
// 136
    JP.go.ipa.oz.lib.standard._String_if string$31 = (new JP.go.ipa.oz.lib.standard._String_cl("v:"));
    
// 136
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$31);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$31);
    }
// 137
    JP.go.ipa.oz.lib.standard._String_if string$32 = (new JP.go.ipa.oz.lib.standard._String_cl("w:"));
    
// 137
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$32);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$32);
    }
// 138
    JP.go.ipa.oz.lib.standard._String_if string$33 = (new JP.go.ipa.oz.lib.standard._String_cl("x:"));
    
// 138
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$33);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$33);
    }
// 139
    JP.go.ipa.oz.lib.standard._String_if string$34 = (new JP.go.ipa.oz.lib.standard._String_cl("y:"));
    
// 139
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$34);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$34);
    }
// 140
    JP.go.ipa.oz.lib.standard._String_if string$35 = (new JP.go.ipa.oz.lib.standard._String_cl("z:"));
    
// 140
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) choDrive)) {
      try {
        choDrive.addItem (string$35);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      choDrive.addItem (string$35);
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Array_if getFiles () throws Exception  {
    checkSecureInvocation ();
// 159
    return files;
  }
  
  public JP.go.ipa.oz.lib.standard._Array_if getSelectedFiles () throws Exception  {
    checkSecureInvocation ();
// 269
    JP.go.ipa.oz.lib.standard._Array_if fileList = null;
// 270
    JP.go.ipa.oz.lib.standard._Collection_if getSelectedItems$val$53;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstFileName)) {
      try {
        getSelectedItems$val$53 = lstFileName.getSelectedItems ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItems$val$53 = lstFileName.getSelectedItems ();
    }
// 270
    fileList = (JP.go.ipa.oz.lib.standard._Array_if) (getSelectedItems$val$53);
// 271
    int size$val$54;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
      try {
        size$val$54 = fileList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$54 = fileList.size ();
    }
// 271
    if (size$val$54 == 0) {
// 271
      return null;
    }
// 273
    JP.go.ipa.oz.lib.standard._StringBuffer_if dirName = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 274
    JP.go.ipa.oz.lib.standard._String_if getTitle$val$55;
    getTitle$val$55 = getTitle ();
// 274
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$56;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dirName)) {
      try {
        append$val$56 = dirName.append (getTitle$val$55);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$56 = dirName.append (getTitle$val$55);
    }
// 275
    if (ozEnv == 0) {
// 276
      JP.go.ipa.oz.lib.standard._String_if string$36 = (new JP.go.ipa.oz.lib.standard._String_cl("\\"));
      
// 276
      JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$57;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dirName)) {
        try {
          append$val$57 = dirName.append (string$36);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        append$val$57 = dirName.append (string$36);
      }
    } else {
// 278
      JP.go.ipa.oz.lib.standard._String_if string$37 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
      
// 278
      JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$58;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dirName)) {
        try {
          append$val$58 = dirName.append (string$37);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        append$val$58 = dirName.append (string$37);
      }
    }
// 279
    JP.go.ipa.oz.lib.standard._String_if path = null;
// 280
    JP.go.ipa.oz.lib.standard._String_if asString$val$59;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dirName)) {
      try {
        asString$val$59 = dirName.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$59 = dirName.asString ();
    }
// 280
    path = asString$val$59;
// 282
    JP.go.ipa.oz.lib.standard._String_if tmp = null;
// 283
    int max = 0;
// 284
    int size$val$60;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
      try {
        size$val$60 = fileList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$60 = fileList.size ();
    }
// 284
    max = size$val$60;
// 285
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < max)) break;
        
        /* body */ _loop_1: {
// 286
          dirName = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (path);
// 287
          JP.go.ipa.oz.lang._Root_if at$val$61;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
            try {
              at$val$61 = fileList.at (i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            at$val$61 = fileList.at (i);
          }
// 287
          tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$61);
// 288
          dirName.append (tmp);
// 289
          JP.go.ipa.oz.lib.standard._String_if asString$val$62;
          asString$val$62 = dirName.asString ();
// 289
          JP.go.ipa.oz.lib.standard._Array_if putAt$val$63;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
            try {
              putAt$val$63 = fileList.putAt (i, asString$val$62);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            putAt$val$63 = fileList.putAt (i, asString$val$62);
          }
        }
        /* iteration part */
// 285
        i++;
      }
    }
// 291
    return fileList;
  }
  
  public void setFile (JP.go.ipa.oz.lib.standard._String_if fileName) throws Exception  {
    checkSecureInvocation ();
// 231
    JP.go.ipa.oz.lib.standard._Array_if fileList = null;
// 232
    JP.go.ipa.oz.lib.standard._File_if file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (fileName);
// 233
    JP.go.ipa.oz.user.ide.ExtensionFilter_if filter = (JP.go.ipa.oz.user.ide.ExtensionFilter_cl) (new JP.go.ipa.oz.user.ide.ExtensionFilter_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl(".oz")));
// 234
    JP.go.ipa.oz.lib.standard._Array_if list$val$64;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        list$val$64 = file.list (filter);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      list$val$64 = file.list (filter);
    }
// 234
    fileList = list$val$64;
// 235
    int max = 0;
// 236
    JP.go.ipa.oz.lib.standard._String_if tmp = null;
// 237
    if (fileList == null) {
// 237
      return;
    }
// 238
    int size$val$65;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
      try {
        size$val$65 = fileList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$65 = fileList.size ();
    }
// 238
    max = size$val$65;
// 239
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstFileName)) {
      try {
        lstFileName.removeAll ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lstFileName.removeAll ();
    }
// 240
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < max)) break;
        
        /* body */ _loop_1: {
// 241
          JP.go.ipa.oz.lang._Root_if at$val$66;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
            try {
              at$val$66 = fileList.at (i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            at$val$66 = fileList.at (i);
          }
// 241
          tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$66);
// 242
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstFileName)) {
            try {
              lstFileName.addItem (tmp);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            lstFileName.addItem (tmp);
          }
        }
        /* iteration part */
// 240
        i++;
      }
    }
  }
  
  public void setVisible (boolean b) throws Exception  {
    checkSecureInvocation ();
// 149
    setLocation (50, 50);
// 150
    super.setVisible (b);
  }
  
  public JP.go.ipa.oz.lib.standard._Array_if getFilesInDirectory () throws Exception  {
    checkSecureInvocation ();
// 300
    JP.go.ipa.oz.lib.standard._StringBuffer_if dirName = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 301
    JP.go.ipa.oz.lib.standard._String_if getTitle$val$67;
    getTitle$val$67 = getTitle ();
// 301
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$68;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dirName)) {
      try {
        append$val$68 = dirName.append (getTitle$val$67);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$68 = dirName.append (getTitle$val$67);
    }
// 302
    if (ozEnv == 0) {
// 303
      JP.go.ipa.oz.lib.standard._String_if string$38 = (new JP.go.ipa.oz.lib.standard._String_cl("\\"));
      
// 303
      JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$69;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dirName)) {
        try {
          append$val$69 = dirName.append (string$38);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        append$val$69 = dirName.append (string$38);
      }
    } else {
// 305
      JP.go.ipa.oz.lib.standard._String_if string$39 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
      
// 305
      JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$70;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dirName)) {
        try {
          append$val$70 = dirName.append (string$39);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        append$val$70 = dirName.append (string$39);
      }
    }
// 306
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$71;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstDirName)) {
      try {
        getSelectedItem$val$71 = lstDirName.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$71 = lstDirName.getSelectedItem ();
    }
// 306
    if (getSelectedItem$val$71 == null) {
// 306
      return null;
    }
// 307
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$72;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstDirName)) {
      try {
        getSelectedItem$val$72 = lstDirName.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$72 = lstDirName.getSelectedItem ();
    }
// 307
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$73;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dirName)) {
      try {
        append$val$73 = dirName.append (getSelectedItem$val$72);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$73 = dirName.append (getSelectedItem$val$72);
    }
// 308
    if (ozEnv == 0) {
// 309
      JP.go.ipa.oz.lib.standard._String_if string$40 = (new JP.go.ipa.oz.lib.standard._String_cl("\\"));
      
// 309
      JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$74;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dirName)) {
        try {
          append$val$74 = dirName.append (string$40);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        append$val$74 = dirName.append (string$40);
      }
    } else {
// 311
      JP.go.ipa.oz.lib.standard._String_if string$41 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
      
// 311
      JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$75;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dirName)) {
        try {
          append$val$75 = dirName.append (string$41);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        append$val$75 = dirName.append (string$41);
      }
    }
// 312
    JP.go.ipa.oz.lib.standard._String_if path = null;
// 313
    JP.go.ipa.oz.lib.standard._String_if asString$val$76;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dirName)) {
      try {
        asString$val$76 = dirName.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$76 = dirName.asString ();
    }
// 313
    path = asString$val$76;
// 315
    JP.go.ipa.oz.lib.standard._Array_if fileList = null;
// 316
    JP.go.ipa.oz.lib.standard._File_if file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (path);
// 317
    JP.go.ipa.oz.user.ide.ExtensionFilter_if filter = (JP.go.ipa.oz.user.ide.ExtensionFilter_cl) (new JP.go.ipa.oz.user.ide.ExtensionFilter_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl(".oz")));
// 318
    JP.go.ipa.oz.lib.standard._Array_if list$val$77;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        list$val$77 = file.list (filter);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      list$val$77 = file.list (filter);
    }
// 318
    fileList = list$val$77;
// 319
    if (fileList == null) {
// 319
      return null;
    }
// 321
    JP.go.ipa.oz.lib.standard._String_if tmp = null;
// 322
    int max = 0;
// 323
    int size$val$78;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
      try {
        size$val$78 = fileList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$78 = fileList.size ();
    }
// 323
    max = size$val$78;
// 324
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < max)) break;
        
        /* body */ _loop_1: {
// 325
          dirName = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (path);
// 326
          JP.go.ipa.oz.lang._Root_if at$val$79;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
            try {
              at$val$79 = fileList.at (i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            at$val$79 = fileList.at (i);
          }
// 326
          tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$79);
// 327
          dirName.append (tmp);
// 328
          JP.go.ipa.oz.lib.standard._String_if asString$val$80;
          asString$val$80 = dirName.asString ();
// 328
          JP.go.ipa.oz.lib.standard._Array_if putAt$val$81;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
            try {
              putAt$val$81 = fileList.putAt (i, asString$val$80);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            putAt$val$81 = fileList.putAt (i, asString$val$80);
          }
        }
        /* iteration part */
// 324
        i++;
      }
    }
// 330
    return fileList;
  }
  
  public AddFileDialog_cl () throws Exception { super (); }
  
}


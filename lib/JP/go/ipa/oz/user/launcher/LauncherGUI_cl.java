package JP.go.ipa.oz.user.launcher;

public class LauncherGUI_cl extends JP.go.ipa.oz.lib.standard._Frame_cl implements JP.go.ipa.oz.user.launcher.LauncherGUI_if {
  JP.go.ipa.oz.lib.standard._List_if directoryListView;
  JP.go.ipa.oz.lib.standard._File_if currentDir;
  JP.go.ipa.oz.lib.standard._List_if activeCellListView;
  JP.go.ipa.oz.lib.standard._Choice_if directoryChoiceView;
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.lib.standard._List_if inactiveCellListView;
  JP.go.ipa.oz.user.launcher.GODOperator_if godOp;
  JP.go.ipa.oz.user.launcher.LauncherCore_if lCore;
  JP.go.ipa.oz.lib.standard._String_if fileSeparator;
  JP.go.ipa.oz.lib.standard._String_if titlePrefix;
  JP.go.ipa.oz.user.launcher.LauncherMenuBar_if menubar;
  JP.go.ipa.oz.lib.standard._String_if topPath;
  
  public Object _new_create (JP.go.ipa.oz.user.launcher.LauncherCore_if lc) throws Exception  {
// 37
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 38
    super._new_newFrame ((new JP.go.ipa.oz.lib.standard._String_cl("OZ Launcher")));
// 39
    init (lc);
// 40
    sync ();
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getSelectedCell () throws Exception  {
    checkSecureInvocation ();
// 107
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$36;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) inactiveCellListView)) {
      try {
        getSelectedItem$val$36 = inactiveCellListView.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$36 = inactiveCellListView.getSelectedItem ();
    }
// 107
    return getSelectedItem$val$36;
  }
  
  public void setPath (JP.go.ipa.oz.lib.standard._String_if path) throws Exception  {
    checkSecureInvocation ();
  }
  
  void setDirectoryChoice (JP.go.ipa.oz.lib.standard._File_if dir) throws Exception  {
// 389
    JP.go.ipa.oz.lib.standard._String_if path = null, dirName = null;
// 390
    int sepIndex = 0;
// 392
    if (checkDirectory (dir)) {{
// 393
        JP.go.ipa.oz.lib.standard._String_if getPath$val$37;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dir)) {
          try {
            getPath$val$37 = dir.getPath ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getPath$val$37 = dir.getPath ();
        }
// 393
        path = getPath$val$37;
// 396
        boolean startsWith$val$38;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
          try {
            startsWith$val$38 = path.startsWith (topPath);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          startsWith$val$38 = path.startsWith (topPath);
        }
// 396
        if (startsWith$val$38) {{
// 398
            while (true) {
// 398
              int getItemCount$val$39;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) directoryChoiceView)) {
                try {
                  getItemCount$val$39 = directoryChoiceView.getItemCount ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getItemCount$val$39 = directoryChoiceView.getItemCount ();
              }
              if (!(getItemCount$val$39 > 0)) break;
              
              /* body */ _loop_1: {
// 399
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) directoryChoiceView)) {
                  try {
                    directoryChoiceView.remove (0);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  directoryChoiceView.remove (0);
                }
              }
            }
// 402
            JP.go.ipa.oz.lib.standard._String_if string$8 = (new JP.go.ipa.oz.lib.standard._String_cl(": (top)"));
            
// 402
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) directoryChoiceView)) {
              try {
                directoryChoiceView.add (string$8);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              directoryChoiceView.add (string$8);
            }
// 403
            int length$val$40;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) topPath)) {
              try {
                length$val$40 = topPath.length ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              length$val$40 = topPath.length ();
            }
// 403
            JP.go.ipa.oz.lib.standard._String_if substring$val$41;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
              try {
                substring$val$41 = path.substring (length$val$40);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              substring$val$41 = path.substring (length$val$40);
            }
// 403
            path = substring$val$41;
// 406
            while (true) {
// 406
              int length$val$42;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
                try {
                  length$val$42 = path.length ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                length$val$42 = path.length ();
              }
              if (!(length$val$42 > 0)) break;
              
              /* body */ _loop_1: {
// 408
                boolean startsWith$val$43;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
                  try {
                    startsWith$val$43 = path.startsWith (fileSeparator);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  startsWith$val$43 = path.startsWith (fileSeparator);
                }
// 408
                if (startsWith$val$43) {{
// 409
                    int length$val$44;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileSeparator)) {
                      try {
                        length$val$44 = fileSeparator.length ();
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      length$val$44 = fileSeparator.length ();
                    }
// 409
                    JP.go.ipa.oz.lib.standard._String_if substring$val$45;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
                      try {
                        substring$val$45 = path.substring (length$val$44);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      substring$val$45 = path.substring (length$val$44);
                    }
// 409
                    path = substring$val$45;
                  }
                }
// 411
                int indexOf$val$46;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
                  try {
                    indexOf$val$46 = path.indexOf (fileSeparator);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  indexOf$val$46 = path.indexOf (fileSeparator);
                }
// 411
                sepIndex = indexOf$val$46;
// 412
                if (sepIndex == -1) {{
// 413
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) directoryChoiceView)) {
                      try {
                        directoryChoiceView.add (dirName);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      directoryChoiceView.add (dirName);
                    }
// 415
                    break;
                  }
                } else {{
// 417
                    JP.go.ipa.oz.lib.standard._String_if substring$val$47;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
                      try {
                        substring$val$47 = path.substring (0, sepIndex);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      substring$val$47 = path.substring (0, sepIndex);
                    }
// 417
                    dirName = substring$val$47;
// 418
                    JP.go.ipa.oz.lib.standard._String_if substring$val$48;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
                      try {
                        substring$val$48 = path.substring (sepIndex);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      substring$val$48 = path.substring (sepIndex);
                    }
// 418
                    path = substring$val$48;
// 419
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) directoryChoiceView)) {
                      try {
                        directoryChoiceView.add (dirName);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      directoryChoiceView.add (dirName);
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
  
  void init (JP.go.ipa.oz.user.launcher.LauncherCore_if lc) throws Exception  {
// 207
    JP.go.ipa.oz.lib.standard._String_if ozhomePath = null, currentPath = null;
// 208
    JP.go.ipa.oz.lib.standard._File_if ozhomeDir = null, dir = null;
// 210
    lCore = lc;
// 212
    JP.go.ipa.oz.lib.standard._String_if getOzHome$val$49;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getOzHome$val$49 = system.getOzHome ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzHome$val$49 = system.getOzHome ();
    }
// 212
    ozhomePath = getOzHome$val$49;
// 213
    ozhomeDir = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (ozhomePath);
// 214
    fileSeparator = ozhomeDir.getSeparator ();
// 215
    JP.go.ipa.oz.lib.standard._String_if concat$val$50;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozhomePath)) {
      try {
        concat$val$50 = ozhomePath.concat (fileSeparator);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$50 = ozhomePath.concat (fileSeparator);
    }
// 215
    JP.go.ipa.oz.lib.standard._String_if string$9 = (new JP.go.ipa.oz.lib.standard._String_cl("objects"));
    
// 215
    JP.go.ipa.oz.lib.standard._String_if concat$val$51;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$50)) {
      try {
        concat$val$51 = concat$val$50.concat (string$9);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$51 = concat$val$50.concat (string$9);
    }
// 215
    topPath = concat$val$51;
// 217
    JP.go.ipa.oz.lib.standard._String_if getPath$val$52;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lCore)) {
      try {
        getPath$val$52 = lCore.getPath ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getPath$val$52 = lCore.getPath ();
    }
// 217
    currentPath = getPath$val$52;
// 218
    if (currentPath == null) {{
// 219
        currentDir = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (topPath);
      }
    } else {{
// 221
        currentDir = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (currentPath);
// 222
        if (!checkDirectory (currentDir)) {{
// 224
            currentDir = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (topPath);
          }
        }
      }
    }
// 228
    godOp = (JP.go.ipa.oz.user.launcher.GODOperator_cl) (new JP.go.ipa.oz.user.launcher.GODOperator_cl ())._new_create ();
// 230
    titlePrefix = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("OZ Launcher - ")));
// 231
    initGUI ();
  }
  
  boolean checkDirectory (JP.go.ipa.oz.lib.standard._File_if dir) throws Exception  {
    boolean bool$val$3;
    
    boolean bool$val$4;
    
    bool$val$4 = dir != null;
    if (bool$val$4) {
// 141
      boolean exists$val$53;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dir)) {
        try {
          exists$val$53 = dir.exists ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        exists$val$53 = dir.exists ();
      }
      bool$val$4 = exists$val$53;
    }
    bool$val$3 = bool$val$4;
    if (bool$val$3) {
// 141
      boolean isDirectory$val$54;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dir)) {
        try {
          isDirectory$val$54 = dir.isDirectory ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isDirectory$val$54 = dir.isDirectory ();
      }
      bool$val$3 = isDirectory$val$54;
    }
// 141
    if (bool$val$3) {{
// 142
        return true;
      }
    } else {{
// 144
        return false;
      }
    }
  }
  
  boolean isActiveGOD (JP.go.ipa.oz.lib.standard._File_if file) throws Exception  {
// 311
    return checkGODActivity (file, (new JP.go.ipa.oz.lib.standard._String_cl(".location")));
  }
  
  boolean hasSubDirectory (JP.go.ipa.oz.lib.standard._File_if dir) throws Exception  {
// 183
    JP.go.ipa.oz.lib.standard._Array_if fileList = null;
// 184
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 185
    JP.go.ipa.oz.lib.standard._File_if subFile = null;
// 186
    JP.go.ipa.oz.lib.standard._String_if fileName = null;
// 188
    boolean isDirectory$val$55;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dir)) {
      try {
        isDirectory$val$55 = dir.isDirectory ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isDirectory$val$55 = dir.isDirectory ();
    }
// 188
    if (isDirectory$val$55) {{
// 189
        JP.go.ipa.oz.lib.standard._Array_if list$val$56;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dir)) {
          try {
            list$val$56 = dir.list ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          list$val$56 = dir.list ();
        }
// 189
        fileList = list$val$56;
// 190
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$57;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
          try {
            iterator$val$57 = fileList.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$57 = fileList.iterator ();
        }
// 190
        itr = iterator$val$57;
// 191
        while (true) {
// 191
          boolean hasMoreElements$val$58;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
            try {
              hasMoreElements$val$58 = itr.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$58 = itr.hasMoreElements ();
          }
          if (!(hasMoreElements$val$58)) break;
          
          /* body */ _loop_1: {
// 192
            JP.go.ipa.oz.lang._Root_if nextElement$val$59;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
              try {
                nextElement$val$59 = itr.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$59 = itr.nextElement ();
            }
// 192
            fileName = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$59);
// 193
            subFile = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (dir, fileName);
// 194
            if (subFile.isDirectory ()) {{
// 195
                return true;
              }
            }
          }
        }
      }
    }
// 200
    return false;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getSelectedDirectory () throws Exception  {
    checkSecureInvocation ();
// 114
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$60;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) directoryListView)) {
      try {
        getSelectedItem$val$60 = directoryListView.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$60 = directoryListView.getSelectedItem ();
    }
// 114
    return getSelectedItem$val$60;
  }
  
  void resetTitle () throws Exception  {
// 378
    JP.go.ipa.oz.lib.standard._String_if path = null, god = null;
// 380
    JP.go.ipa.oz.lib.standard._String_if getPath$val$61;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentDir)) {
      try {
        getPath$val$61 = currentDir.getPath ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getPath$val$61 = currentDir.getPath ();
    }
// 380
    path = getPath$val$61;
// 381
    JP.go.ipa.oz.lib.standard._String_if toGOD$val$62;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) godOp)) {
      try {
        toGOD$val$62 = godOp.toGOD (path);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      toGOD$val$62 = godOp.toGOD (path);
    }
// 381
    god = toGOD$val$62;
// 382
    JP.go.ipa.oz.lib.standard._String_if concat$val$63;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) titlePrefix)) {
      try {
        concat$val$63 = titlePrefix.concat (god);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$63 = titlePrefix.concat (god);
    }
// 382
    setTitle (concat$val$63);
  }
  
  public void sync () throws Exception  {
    checkSecureInvocation ();
// 127
    JP.go.ipa.oz.lib.standard._String_if path = null;
// 129
    if (checkDirectory (currentDir)) {{
// 130
        list (currentDir);
      }
    }
  }
  
  void initGUI () throws Exception  {
// 238
    JP.go.ipa.oz.lib.standard._Label_if dirLabel = null, activeLabel = null, inactiveLabel = null;
// 239
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 240
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 241
    JP.go.ipa.oz.lib.standard._Insets_if insets = null;
// 242
    JP.go.ipa.oz.user.launcher.LauncherDirectorySelectListener_if dirListener = null;
// 243
    JP.go.ipa.oz.user.launcher.LauncherCellSelectListener_if cellListener = null;
// 244
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq = null;
// 247
    dirLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl(" directories:")));
// 249
    directoryListView = (JP.go.ipa.oz.lib.standard._List_cl) (new JP.go.ipa.oz.lib.standard._List_cl ())._new_newList ();
// 250
    eq = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 251
    dirListener = (JP.go.ipa.oz.user.launcher.LauncherDirectorySelectListener_cl) (new JP.go.ipa.oz.user.launcher.LauncherDirectorySelectListener_cl ())._new_create (lCore, eq);
// 252
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) directoryListView)) {
      try {
        directoryListView.addActionListener (dirListener);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      directoryListView.addActionListener (dirListener);
    }
// 253
    inactiveLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl(" inactive cells:")));
// 254
    inactiveCellListView = (JP.go.ipa.oz.lib.standard._List_cl) (new JP.go.ipa.oz.lib.standard._List_cl ())._new_newList ();
// 255
    eq = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 256
    cellListener = (JP.go.ipa.oz.user.launcher.LauncherCellSelectListener_cl) (new JP.go.ipa.oz.user.launcher.LauncherCellSelectListener_cl ())._new_create (lCore, eq);
// 257
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) inactiveCellListView)) {
      try {
        inactiveCellListView.addActionListener (cellListener);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      inactiveCellListView.addActionListener (cellListener);
    }
// 258
    activeLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl(" active cells:")));
// 259
    activeCellListView = (JP.go.ipa.oz.lib.standard._List_cl) (new JP.go.ipa.oz.lib.standard._List_cl ())._new_newList ();
// 260
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) activeCellListView)) {
      try {
        activeCellListView.setEnabled (false);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      activeCellListView.setEnabled (false);
    }
// 263
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 264
    setLayout (layout);
// 265
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 266
    constraints.setFill (constraints.getBOTH ());
// 267
    insets = (JP.go.ipa.oz.lib.standard._Insets_cl) (new JP.go.ipa.oz.lib.standard._Insets_cl ())._new_newInsets (0, 2, 2, 2);
// 268
    constraints.setInsets (insets);
// 271
    constraints.setWeightx (0.2);
// 272
    constraints.setWeighty (0.0);
// 274
    layout.setConstraints (dirLabel, constraints);
// 275
    constraints.setWeighty (1.0);
// 276
    layout.setConstraints (directoryListView, constraints);
// 279
    constraints.setWeightx (0.4);
// 280
    constraints.setWeighty (0.0);
// 281
    layout.setConstraints (inactiveLabel, constraints);
// 282
    constraints.setWeighty (1.0);
// 283
    layout.setConstraints (inactiveCellListView, constraints);
// 286
    constraints.setGridwidth (constraints.getREMAINDER ());
// 287
    constraints.setWeightx (0.4);
// 288
    constraints.setWeighty (0.0);
// 289
    layout.setConstraints (activeLabel, constraints);
// 290
    constraints.setWeighty (1.0);
// 291
    layout.setConstraints (activeCellListView, constraints);
// 294
    add (dirLabel);
// 295
    add (inactiveLabel);
// 296
    add (activeLabel);
// 297
    add (directoryListView);
// 298
    add (inactiveCellListView);
// 299
    add (activeCellListView);
// 300
    pack ();
// 303
    menubar = (JP.go.ipa.oz.user.launcher.LauncherMenuBar_cl) (new JP.go.ipa.oz.user.launcher.LauncherMenuBar_cl ())._new_create (lCore);
// 304
    setMenuBar (menubar);
  }
  
  public void changeDirectory (JP.go.ipa.oz.lib.standard._String_if dirName) throws Exception  {
    checkSecureInvocation ();
// 49
    JP.go.ipa.oz.lib.standard._File_if dir = null;
// 50
    JP.go.ipa.oz.lib.standard._String_if path = null, newPath = null;
// 52
    if (currentDir != null) {{
// 53
        JP.go.ipa.oz.lib.standard._String_if string$10 = (new JP.go.ipa.oz.lib.standard._String_cl("[up]"));
        
// 53
        boolean isequal$val$64;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dirName)) {
          try {
            isequal$val$64 = dirName.isequal (string$10);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$64 = dirName.isequal (string$10);
        }
// 53
        if (isequal$val$64) {{
// 55
            JP.go.ipa.oz.lib.standard._String_if getPath$val$65;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentDir)) {
              try {
                getPath$val$65 = currentDir.getPath ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getPath$val$65 = currentDir.getPath ();
            }
// 55
            path = getPath$val$65;
// 56
            int lastIndexOf$val$66;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
              try {
                lastIndexOf$val$66 = path.lastIndexOf (fileSeparator);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              lastIndexOf$val$66 = path.lastIndexOf (fileSeparator);
            }
// 56
            JP.go.ipa.oz.lib.standard._String_if substring$val$67;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
              try {
                substring$val$67 = path.substring (0, lastIndexOf$val$66);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              substring$val$67 = path.substring (0, lastIndexOf$val$66);
            }
// 56
            newPath = substring$val$67;
// 57
            dir = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (newPath);
          }
        } else {{
// 59
            dir = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (currentDir, dirName);
          }
        }
// 62
        if (checkDirectory (dir)) {{
// 63
            currentDir = dir;
// 64
            resetTitle ();
// 65
            sync ();
          }
        }
      }
    }
  }
  
  public void createCell () throws Exception  {
    checkSecureInvocation ();
// 74
    JP.go.ipa.oz.user.launcher.LauncherCellInformationDialog_if cellDialog = null;
// 75
    JP.go.ipa.oz.lib.standard._String_if path = null, god = null;
// 77
    JP.go.ipa.oz.lib.standard._String_if getPath$val$68;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentDir)) {
      try {
        getPath$val$68 = currentDir.getPath ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getPath$val$68 = currentDir.getPath ();
    }
// 77
    path = getPath$val$68;
// 78
    JP.go.ipa.oz.lib.standard._String_if toGOD$val$69;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) godOp)) {
      try {
        toGOD$val$69 = godOp.toGOD (path);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      toGOD$val$69 = godOp.toGOD (path);
    }
// 78
    god = toGOD$val$69;
// 79
    cellDialog = (JP.go.ipa.oz.user.launcher.LauncherCellInformationDialog_cl) (new JP.go.ipa.oz.user.launcher.LauncherCellInformationDialog_cl ())._new_create (lCore, god);
// 80
    cellDialog.show ();
  }
  
  boolean isInactiveGOD (JP.go.ipa.oz.lib.standard._File_if file) throws Exception  {
// 318
    return checkGODActivity (file, (new JP.go.ipa.oz.lib.standard._String_cl(".inactive")));
  }
  
  void clearList () throws Exception  {
// 174
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) directoryListView)) {
      try {
        directoryListView.removeAll ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      directoryListView.removeAll ();
    }
// 175
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) activeCellListView)) {
      try {
        activeCellListView.removeAll ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      activeCellListView.removeAll ();
    }
// 176
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) inactiveCellListView)) {
      try {
        inactiveCellListView.removeAll ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      inactiveCellListView.removeAll ();
    }
  }
  
  boolean checkGODActivity (JP.go.ipa.oz.lib.standard._File_if file, JP.go.ipa.oz.lib.standard._String_if name1) throws Exception  {
// 152
    JP.go.ipa.oz.lib.standard._Collection_if ls = null;
// 153
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 154
    JP.go.ipa.oz.lib.standard._String_if name2 = null;
// 156
    boolean isDirectory$val$70;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        isDirectory$val$70 = file.isDirectory ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isDirectory$val$70 = file.isDirectory ();
    }
// 156
    if (isDirectory$val$70) {{
// 157
        JP.go.ipa.oz.lib.standard._Array_if list$val$71;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
          try {
            list$val$71 = file.list ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          list$val$71 = file.list ();
        }
// 157
        ls = list$val$71;
// 158
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$72;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ls)) {
          try {
            iterator$val$72 = ls.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$72 = ls.iterator ();
        }
// 158
        itr = iterator$val$72;
// 159
        while (true) {
// 159
          boolean hasMoreElements$val$73;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
            try {
              hasMoreElements$val$73 = itr.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$73 = itr.hasMoreElements ();
          }
          if (!(hasMoreElements$val$73)) break;
          
          /* body */ _loop_1: {
// 160
            JP.go.ipa.oz.lang._Root_if nextElement$val$74;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
              try {
                nextElement$val$74 = itr.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$74 = itr.nextElement ();
            }
// 160
            name2 = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$74);
// 161
            boolean isequal$val$75;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) name2)) {
              try {
                isequal$val$75 = name2.isequal (name1);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              isequal$val$75 = name2.isequal (name1);
            }
// 161
            if (isequal$val$75) {{
// 162
                return true;
              }
            }
          }
        }
      }
    }
// 167
    return false;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getPath () throws Exception  {
    checkSecureInvocation ();
// 87
    JP.go.ipa.oz.lib.standard._String_if currentPath = null, path = null;
// 89
    path = null;
// 90
    if (currentDir != null) {{
// 91
        JP.go.ipa.oz.lib.standard._String_if getPath$val$76;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentDir)) {
          try {
            getPath$val$76 = currentDir.getPath ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getPath$val$76 = currentDir.getPath ();
        }
// 91
        currentPath = getPath$val$76;
// 92
        boolean startsWith$val$77;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentPath)) {
          try {
            startsWith$val$77 = currentPath.startsWith (topPath);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          startsWith$val$77 = currentPath.startsWith (topPath);
        }
// 92
        if (startsWith$val$77) {{
// 93
            int length$val$78;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) topPath)) {
              try {
                length$val$78 = topPath.length ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              length$val$78 = topPath.length ();
            }
// 93
            JP.go.ipa.oz.lib.standard._String_if substring$val$79;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentPath)) {
              try {
                substring$val$79 = currentPath.substring (length$val$78);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              substring$val$79 = currentPath.substring (length$val$78);
            }
// 93
            path = substring$val$79;
// 94
            boolean startsWith$val$80;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
              try {
                startsWith$val$80 = path.startsWith (fileSeparator);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              startsWith$val$80 = path.startsWith (fileSeparator);
            }
// 94
            if (startsWith$val$80) {{
// 95
                int length$val$81;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileSeparator)) {
                  try {
                    length$val$81 = fileSeparator.length ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  length$val$81 = fileSeparator.length ();
                }
// 95
                JP.go.ipa.oz.lib.standard._String_if substring$val$82;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
                  try {
                    substring$val$82 = path.substring (length$val$81);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  substring$val$82 = path.substring (length$val$81);
                }
// 95
                path = substring$val$82;
              }
            }
          }
        }
      }
    }
// 100
    return path;
  }
  
  void list (JP.go.ipa.oz.lib.standard._File_if dir) throws Exception  {
// 325
    JP.go.ipa.oz.lib.standard._File_if subFile = null;
// 326
    JP.go.ipa.oz.lib.standard._Array_if fileList = null;
// 327
    JP.go.ipa.oz.lib.standard._String_if fileName = null, path = null;
// 328
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 330
    if (checkDirectory (dir)) {{
// 331
        clearList ();
// 334
        JP.go.ipa.oz.lib.standard._String_if getPath$val$83;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dir)) {
          try {
            getPath$val$83 = dir.getPath ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getPath$val$83 = dir.getPath ();
        }
// 334
        path = getPath$val$83;
// 335
        boolean isequal$val$84;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) topPath)) {
          try {
            isequal$val$84 = topPath.isequal (path);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$84 = topPath.isequal (path);
        }
// 335
        if (!(isequal$val$84)) {{
// 336
            JP.go.ipa.oz.lib.standard._String_if string$11 = (new JP.go.ipa.oz.lib.standard._String_cl("[up]"));
            
// 336
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) directoryListView)) {
              try {
                directoryListView.add (string$11);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              directoryListView.add (string$11);
            }
          }
        }
// 339
        JP.go.ipa.oz.lib.standard._Array_if list$val$85;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dir)) {
          try {
            list$val$85 = dir.list ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          list$val$85 = dir.list ();
        }
// 339
        fileList = list$val$85;
// 340
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$86;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
          try {
            iterator$val$86 = fileList.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$86 = fileList.iterator ();
        }
// 340
        itr = iterator$val$86;
// 341
        while (true) {
// 341
          boolean hasMoreElements$val$87;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
            try {
              hasMoreElements$val$87 = itr.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$87 = itr.hasMoreElements ();
          }
          if (!(hasMoreElements$val$87)) break;
          
          /* body */ _loop_1: {
// 342
            JP.go.ipa.oz.lang._Root_if nextElement$val$88;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
              try {
                nextElement$val$88 = itr.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$88 = itr.nextElement ();
            }
// 342
            fileName = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$88);
// 343
            subFile = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (dir, fileName);
// 344
            if (subFile.isDirectory ()) {{
// 345
                if (isInactiveGOD (subFile)) {{
// 346
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) inactiveCellListView)) {
                      try {
                        inactiveCellListView.add (fileName);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      inactiveCellListView.add (fileName);
                    }
// 347
                    if (hasSubDirectory (subFile)) {{
// 348
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) directoryListView)) {
                          try {
                            directoryListView.add (fileName);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          directoryListView.add (fileName);
                        }
                      }
                    }
                  }
                } else {
// 350
                  if (isActiveGOD (subFile)) {{
// 351
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) activeCellListView)) {
                        try {
                          activeCellListView.add (fileName);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        activeCellListView.add (fileName);
                      }
// 352
                      if (hasSubDirectory (subFile)) {{
// 353
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) directoryListView)) {
                            try {
                              directoryListView.add (fileName);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            directoryListView.add (fileName);
                          }
                        }
                      }
                    }
                  } else {{
// 356
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) directoryListView)) {
                        try {
                          directoryListView.add (fileName);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        directoryListView.add (fileName);
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
  
  public LauncherGUI_cl () throws Exception { super (); }
  
}


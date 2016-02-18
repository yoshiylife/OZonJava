package JP.go.ipa.oz.user.launcher;

public class LauncherCore_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.launcher.LauncherCore_if {
  JP.go.ipa.oz.lib.standard._String_if currentPath;
  JP.go.ipa.oz.lib.standard._String_if GODPathName;
  JP.go.ipa.oz.lib.standard._String_if ozHomePathName;
  JP.go.ipa.oz.lib.standard._String_if startScriptName;
  JP.go.ipa.oz.user.launcher.LauncherGUI_if gui;
  JP.go.ipa.oz.lib.standard._String_if createScriptName;
  char fileSepChar;
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.lib.standard._String_if startScriptPathName;
  JP.go.ipa.oz.user.launcher.GODOperator_if godOp;
  JP.go.ipa.oz.lib.standard._String_if createScriptPathName;
  JP.go.ipa.oz.lib.standard._String_if catalogGOL;
  
  public Object _new_create () throws Exception  {
// 32
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 33
    init ();
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._Frame_if getGUI () throws Exception  {
    checkSecureInvocation ();
// 107
    return gui;
  }
  
  public void setPath (JP.go.ipa.oz.lib.standard._String_if path) throws Exception  {
    checkSecureInvocation ();
// 156
    if (path != null) {{
// 157
        currentPath = path;
      }
    }
  }
  
  void init () throws Exception  {
// 257
    godOp = (JP.go.ipa.oz.user.launcher.GODOperator_cl) (new JP.go.ipa.oz.user.launcher.GODOperator_cl ())._new_create ();
// 258
    startScriptName = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("startrc")));
// 259
    createScriptName = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("createrc")));
// 260
    resetPath ();
// 261
    mkScriptFiles ();
  }
  
  public void setCatalogGOL (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
    checkSecureInvocation ();
// 149
    catalogGOL = gol;
  }
  
  public void sync () throws Exception  {
    checkSecureInvocation ();
// 219
    if (gui != null) {{
// 220
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
          try {
            gui.sync ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          gui.sync ();
        }
      }
    }
  }
  
  public void startCell (JP.go.ipa.oz.lib.standard._String_if god) throws Exception  {
    checkSecureInvocation ();
// 179
    JP.go.ipa.oz.lib.standard._Process_if oz = null;
// 180
    JP.go.ipa.oz.lib.standard._StringBuffer_if cmd = null;
// 181
    JP.go.ipa.oz.lib.standard._String_if dirPath = null;
// 182
    JP.go.ipa.oz.user.launcher.LauncherException_if lEx = null;
// 184
    if (god != null) {{
// 185
        JP.go.ipa.oz.lib.standard._String_if string$12 = (new JP.go.ipa.oz.lib.standard._String_cl("\tLauncherCore#startCell: GOD="));
        
// 185
        JP.go.ipa.oz.lib.standard._String_if concat$val$89;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$12)) {
          try {
            concat$val$89 = string$12.concat (god);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$89 = string$12.concat (god);
        }
// 185
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (concat$val$89);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (concat$val$89);
        }
// 186
        dirPath = GOD2PathName (god);
// 187
        if (fileSepChar == '/') {{
// 188
            cmd = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("oz -f ")));
          }
        } else {{
// 190
            cmd = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("oz.bat -f ")));
          }
        }
// 192
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$90;
        append$val$90 = cmd.append (startScriptPathName);
// 192
        JP.go.ipa.oz.lib.standard._String_if string$13 = (new JP.go.ipa.oz.lib.standard._String_cl(" "));
        
// 192
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$91;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$90)) {
          try {
            append$val$91 = append$val$90.append (string$13);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$91 = append$val$90.append (string$13);
        }
// 192
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$92;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$91)) {
          try {
            append$val$92 = append$val$91.append (god);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$92 = append$val$91.append (god);
        }
// 193
        JP.go.ipa.oz.lib.standard._String_if string$14 = (new JP.go.ipa.oz.lib.standard._String_cl("\tLauncherCore#activateCell: cmd="));
        
// 193
        JP.go.ipa.oz.lib.standard._String_if asString$val$93;
        asString$val$93 = cmd.asString ();
// 193
        JP.go.ipa.oz.lib.standard._String_if concat$val$94;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$14)) {
          try {
            concat$val$94 = string$14.concat (asString$val$93);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$94 = string$14.concat (asString$val$93);
        }
// 193
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (concat$val$94);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (concat$val$94);
        }
// 194
        oz = (JP.go.ipa.oz.lib.standard._Process_cl) (new JP.go.ipa.oz.lib.standard._Process_cl ())._new_create (cmd.asString ());
// 195
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
          try {
            gui.sync ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          gui.sync ();
        }
      }
    } else {{
// 198
        JP.go.ipa.oz.lib.standard._String_if string$15 = (new JP.go.ipa.oz.lib.standard._String_cl("\tLauncherCore#startCell: null GOD"));
        
// 198
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (string$15);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (string$15);
        }
      }
    }
  }
  
  public void startCell () throws Exception  {
    checkSecureInvocation ();
// 165
    JP.go.ipa.oz.lib.standard._String_if name = null, path = null, god = null;
// 167
    JP.go.ipa.oz.lib.standard._String_if getSelectedCell$val$95;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
      try {
        getSelectedCell$val$95 = gui.getSelectedCell ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedCell$val$95 = gui.getSelectedCell ();
    }
// 167
    name = getSelectedCell$val$95;
// 168
    if (name != null) {{
// 169
        JP.go.ipa.oz.lib.standard._String_if getPath$val$96;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
          try {
            getPath$val$96 = gui.getPath ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getPath$val$96 = gui.getPath ();
        }
// 169
        path = getPath$val$96;
// 170
        JP.go.ipa.oz.lib.standard._String_if toGOD$val$97;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) godOp)) {
          try {
            toGOD$val$97 = godOp.toGOD (path, name);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          toGOD$val$97 = godOp.toGOD (path, name);
        }
// 170
        god = toGOD$val$97;
// 171
        startCell (god);
      }
    }
  }
  
  public void changeDirectory (JP.go.ipa.oz.lib.standard._String_if dirName) throws Exception  {
    checkSecureInvocation ();
// 42
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
      try {
        gui.changeDirectory (dirName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      gui.changeDirectory (dirName);
    }
  }
  
  public void createCell (JP.go.ipa.oz.lib.standard._String_if god, JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
    checkSecureInvocation ();
// 64
    JP.go.ipa.oz.lib.standard._Process_if oz = null;
// 65
    JP.go.ipa.oz.lib.standard._StringBuffer_if cmd = null;
// 66
    JP.go.ipa.oz.lib.standard._String_if godPath = null;
// 67
    JP.go.ipa.oz.lib.standard._File_if scriptFile = null;
// 68
    JP.go.ipa.oz.user.launcher.LauncherException_if lEx = null;
    boolean bool$val$5;
    
    bool$val$5 = god != null;
    if (bool$val$5) {
      bool$val$5 = cid != null;
    }
// 70
    if (bool$val$5) {{
// 71
        JP.go.ipa.oz.lib.standard._String_if string$16 = (new JP.go.ipa.oz.lib.standard._String_cl("\tLauncherCore#createCell: GOD="));
        
// 71
        JP.go.ipa.oz.lib.standard._String_if concat$val$98;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$16)) {
          try {
            concat$val$98 = string$16.concat (god);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$98 = string$16.concat (god);
        }
// 71
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (concat$val$98);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (concat$val$98);
        }
// 72
        JP.go.ipa.oz.lib.standard._String_if string$17 = (new JP.go.ipa.oz.lib.standard._String_cl("\tLauncherCore#createCell: CID="));
        
// 72
        JP.go.ipa.oz.lib.standard._String_if concat$val$99;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$17)) {
          try {
            concat$val$99 = string$17.concat (cid);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$99 = string$17.concat (cid);
        }
// 72
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (concat$val$99);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (concat$val$99);
        }
// 74
        godPath = GOD2PathName (god);
// 75
        JP.go.ipa.oz.lib.standard._String_if string$18 = (new JP.go.ipa.oz.lib.standard._String_cl("\tLauncherCore#createCell: dir="));
        
// 75
        JP.go.ipa.oz.lib.standard._String_if concat$val$100;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$18)) {
          try {
            concat$val$100 = string$18.concat (godPath);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$100 = string$18.concat (godPath);
        }
// 75
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (concat$val$100);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (concat$val$100);
        }
// 77
        if (fileSepChar == '/') {{
// 79
            cmd = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("oz -f ")));
          }
        } else {{
// 82
            cmd = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("oz.bat -f ")));
          }
        }
// 84
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$101;
        append$val$101 = cmd.append (createScriptPathName);
// 84
        JP.go.ipa.oz.lib.standard._String_if string$19 = (new JP.go.ipa.oz.lib.standard._String_cl(" "));
        
// 84
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$102;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$101)) {
          try {
            append$val$102 = append$val$101.append (string$19);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$102 = append$val$101.append (string$19);
        }
// 84
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$103;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$102)) {
          try {
            append$val$103 = append$val$102.append (god);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$103 = append$val$102.append (god);
        }
// 85
        JP.go.ipa.oz.lib.standard._String_if string$20 = (new JP.go.ipa.oz.lib.standard._String_cl(" "));
        
// 84
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$104;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$103)) {
          try {
            append$val$104 = append$val$103.append (string$20);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$104 = append$val$103.append (string$20);
        }
// 84
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$105;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$104)) {
          try {
            append$val$105 = append$val$104.append (cid);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$105 = append$val$104.append (cid);
        }
// 86
        JP.go.ipa.oz.lib.standard._String_if string$21 = (new JP.go.ipa.oz.lib.standard._String_cl("\tLauncherCore#createCell: cmd="));
        
// 86
        JP.go.ipa.oz.lib.standard._String_if asString$val$106;
        asString$val$106 = cmd.asString ();
// 86
        JP.go.ipa.oz.lib.standard._String_if concat$val$107;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$21)) {
          try {
            concat$val$107 = string$21.concat (asString$val$106);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$107 = string$21.concat (asString$val$106);
        }
// 86
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (concat$val$107);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (concat$val$107);
        }
// 87
        oz = (JP.go.ipa.oz.lib.standard._Process_cl) (new JP.go.ipa.oz.lib.standard._Process_cl ())._new_create (cmd.asString ());
// 88
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
          try {
            gui.sync ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          gui.sync ();
        }
      }
    } else {{
// 91
        JP.go.ipa.oz.lib.standard._String_if string$22 = (new JP.go.ipa.oz.lib.standard._String_cl("\tLauncherCore#createCell: null GOD or CID"));
        
// 91
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (string$22);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (string$22);
        }
      }
    }
  }
  
  public void createCell (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
    checkSecureInvocation ();
  }
  
  public void createCell () throws Exception  {
    checkSecureInvocation ();
// 49
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
      try {
        gui.createCell ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      gui.createCell ();
    }
  }
  
  public void stop () throws Exception  {
    checkSecureInvocation ();
// 209
    JP.go.ipa.oz.lib.standard._String_if getPath$val$108;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
      try {
        getPath$val$108 = gui.getPath ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getPath$val$108 = gui.getPath ();
    }
// 209
    currentPath = getPath$val$108;
// 210
    stopCell ();
  }
  
  public void launch () throws Exception  {
    checkSecureInvocation ();
// 128
    resetPath ();
// 129
    if (gui == null) {{
// 130
        gui = (JP.go.ipa.oz.user.launcher.LauncherGUI_cl) (new JP.go.ipa.oz.user.launcher.LauncherGUI_cl ())._new_create (this);
      }
    }
// 132
    gui.show ();
  }
  
  void mkScriptFiles () throws Exception  {
// 300
    JP.go.ipa.oz.lib.standard._StringBuffer_if scriptDirPath = null;
// 301
    JP.go.ipa.oz.lib.standard._String_if scriptFilePath = null;
// 302
    JP.go.ipa.oz.lib.standard._StringBuffer_if script = null;
// 304
    scriptDirPath = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (GODPathName);
// 305
    scriptDirPath.append (fileSepChar);
// 308
    JP.go.ipa.oz.lib.standard._String_if concat$val$109;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) (scriptDirPath.asString ()))) {
      try {
        concat$val$109 = (scriptDirPath.asString ()).concat (createScriptName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$109 = (scriptDirPath.asString ()).concat (createScriptName);
    }
// 308
    scriptFilePath = concat$val$109;
// 309
    script = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("create $1 $2;\n")));
// 310
    script.append ((new JP.go.ipa.oz.lib.standard._String_cl("watch $1;\n")));
// 311
    script.append ((new JP.go.ipa.oz.lib.standard._String_cl("shutdown;\n")));
// 312
    installFile (scriptFilePath, script.asString ());
// 315
    JP.go.ipa.oz.lib.standard._String_if concat$val$110;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) (scriptDirPath.asString ()))) {
      try {
        concat$val$110 = (scriptDirPath.asString ()).concat (startScriptName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$110 = (scriptDirPath.asString ()).concat (startScriptName);
    }
// 315
    scriptFilePath = concat$val$110;
// 316
    script = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("go $1;\n")));
// 317
    script.append ((new JP.go.ipa.oz.lib.standard._String_cl("watch $1;\n")));
// 318
    installFile (scriptFilePath, script.asString ());
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getCatalogGOL () throws Exception  {
    checkSecureInvocation ();
// 100
    return catalogGOL;
  }
  
  public void quit () throws Exception  {
    checkSecureInvocation ();
// 139
    if (gui != null) {{
// 140
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
          try {
            gui.dispose ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          gui.dispose ();
        }
// 141
        gui = null;
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getPath () throws Exception  {
    checkSecureInvocation ();
// 114
    return currentPath;
  }
  
  void installFile (JP.go.ipa.oz.lib.standard._String_if pathname, JP.go.ipa.oz.lib.standard._String_if content) throws Exception  {
// 270
    JP.go.ipa.oz.lib.standard._File_if file = null;
// 271
    JP.go.ipa.oz.lib.standard._FileOutputStream_if fout = null;
// 272
    JP.go.ipa.oz.lib.standard._OutputStreamWriter_if osw = null;
// 273
    JP.go.ipa.oz.lib.standard._BufferedWriter_if bw = null;
// 274
    JP.go.ipa.oz.lib.standard._StringBuffer_if filePath = null;
// 276
    file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (pathname);
// 277
    if (file.exists ()) {{
// 278
        file.delete ();
      }
    }
// 280
    try {
// 281
      fout = (JP.go.ipa.oz.lib.standard._FileOutputStream_cl) (new JP.go.ipa.oz.lib.standard._FileOutputStream_cl ())._new_breed (file);
// 282
      osw = (JP.go.ipa.oz.lib.standard._OutputStreamWriter_cl) (new JP.go.ipa.oz.lib.standard._OutputStreamWriter_cl ())._new_breed (fout);
// 283
      bw = (JP.go.ipa.oz.lib.standard._BufferedWriter_cl) (new JP.go.ipa.oz.lib.standard._BufferedWriter_cl ())._new_breed (osw);
// 284
      int length$val$111;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) content)) {
        try {
          length$val$111 = content.length ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        length$val$111 = content.length ();
      }
// 284
      bw.write (content, 0, length$val$111);
// 285
      bw.close ();
// 286
      osw.close ();
// 287
      fout.close ();
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_1) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
      if (_oz_exception_1 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
        JP.go.ipa.oz.lib.standard._IOException_if ex = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_1;
// 289
        JP.go.ipa.oz.lib.standard._String_if string$23 = (new JP.go.ipa.oz.lib.standard._String_cl("\tLauncherCore#installFile: IOException"));
        
// 289
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (string$23);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (string$23);
        }
// 290
        throw new JP.go.ipa.oz.lang.OzException (ex);
      } else throw _exception_1;
    }
  }
  
  void resetPath () throws Exception  {
// 329
    JP.go.ipa.oz.lib.standard._String_if god = null, godAsPath = null;
// 330
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = null;
// 332
    JP.go.ipa.oz.lib.standard._String_if getOzHome$val$112;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getOzHome$val$112 = system.getOzHome ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzHome$val$112 = system.getOzHome ();
    }
// 332
    ozHomePathName = getOzHome$val$112;
// 333
    JP.go.ipa.oz.lib.standard._String_if string$24 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    
// 333
    boolean startsWith$val$113;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHomePathName)) {
      try {
        startsWith$val$113 = ozHomePathName.startsWith (string$24);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$113 = ozHomePathName.startsWith (string$24);
    }
// 333
    if (startsWith$val$113) {{
// 334
        fileSepChar = '/';
      }
    } else {{
// 336
        fileSepChar = '\\';
      }
    }
// 338
    god = getGOD ();
// 339
    JP.go.ipa.oz.lib.standard._String_if replace$val$114;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) god)) {
      try {
        replace$val$114 = god.replace ('.', fileSepChar);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      replace$val$114 = god.replace ('.', fileSepChar);
    }
// 339
    godAsPath = replace$val$114;
// 341
    buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (ozHomePathName);
// 342
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$115;
    append$val$115 = buf.append (fileSepChar);
// 342
    JP.go.ipa.oz.lib.standard._String_if string$25 = (new JP.go.ipa.oz.lib.standard._String_cl("objects"));
    
// 342
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$116;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$115)) {
      try {
        append$val$116 = append$val$115.append (string$25);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$116 = append$val$115.append (string$25);
    }
// 342
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$117;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$116)) {
      try {
        append$val$117 = append$val$116.append (fileSepChar);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$117 = append$val$116.append (fileSepChar);
    }
// 342
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$118;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$117)) {
      try {
        append$val$118 = append$val$117.append (godAsPath);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$118 = append$val$117.append (godAsPath);
    }
// 344
    GODPathName = buf.asString ();
// 347
    buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (GODPathName);
// 348
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$119;
    append$val$119 = buf.append (fileSepChar);
// 348
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$120;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$119)) {
      try {
        append$val$120 = append$val$119.append (createScriptName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$120 = append$val$119.append (createScriptName);
    }
// 349
    createScriptPathName = buf.asString ();
// 350
    buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (GODPathName);
// 351
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$121;
    append$val$121 = buf.append (fileSepChar);
// 351
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$122;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$121)) {
      try {
        append$val$122 = append$val$121.append (startScriptName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$122 = append$val$121.append (startScriptName);
    }
// 352
    startScriptPathName = buf.asString ();
  }
  
  public void installScriptFiles () throws Exception  {
    checkSecureInvocation ();
// 121
    mkScriptFiles ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if GOD2PathName (JP.go.ipa.oz.lib.standard._String_if god) throws Exception  {
// 232
    JP.go.ipa.oz.lib.standard._StringBuffer_if path = null;
// 233
    JP.go.ipa.oz.lib.standard._String_if godAsPath = null;
// 235
    if (god != null) {{
// 236
        JP.go.ipa.oz.lib.standard._String_if replace$val$123;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) god)) {
          try {
            replace$val$123 = god.replace ('.', fileSepChar);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          replace$val$123 = god.replace ('.', fileSepChar);
        }
// 236
        godAsPath = replace$val$123;
// 237
        path = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (ozHomePathName);
// 238
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$124;
        append$val$124 = path.append (fileSepChar);
// 238
        JP.go.ipa.oz.lib.standard._String_if string$26 = (new JP.go.ipa.oz.lib.standard._String_cl("objects"));
        
// 238
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$125;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$124)) {
          try {
            append$val$125 = append$val$124.append (string$26);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$125 = append$val$124.append (string$26);
        }
// 238
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$126;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$125)) {
          try {
            append$val$126 = append$val$125.append (fileSepChar);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$126 = append$val$125.append (fileSepChar);
        }
// 238
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$127;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$126)) {
          try {
            append$val$127 = append$val$126.append (godAsPath);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$127 = append$val$126.append (godAsPath);
        }
// 241
        JP.go.ipa.oz.lib.standard._String_if string$27 = (new JP.go.ipa.oz.lib.standard._String_cl("\tLauncherCore#GOD2PathName: path="));
        
// 241
        JP.go.ipa.oz.lib.standard._String_if asString$val$128;
        asString$val$128 = path.asString ();
// 241
        JP.go.ipa.oz.lib.standard._String_if concat$val$129;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$27)) {
          try {
            concat$val$129 = string$27.concat (asString$val$128);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$129 = string$27.concat (asString$val$128);
        }
// 241
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (concat$val$129);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (concat$val$129);
        }
// 243
        return path.asString ();
      }
    } else {{
// 246
        return null;
      }
    }
  }
  
  public LauncherCore_cl () throws Exception { super (); }
  
}


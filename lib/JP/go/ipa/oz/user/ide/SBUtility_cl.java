package JP.go.ipa.oz.user.ide;

public class SBUtility_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.SBUtility_if {
  JP.go.ipa.oz.user.ide.SchoolBrowser_if sbr;
  JP.go.ipa.oz.lib.standard._String_if ozHome;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if ClassID, JP.go.ipa.oz.lib.standard._String_if GOL, JP.go.ipa.oz.lib.standard._String_if param) throws Exception  {
// 45
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 46
    JP.go.ipa.oz.lib.standard._String_if getOzHome$val$927;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getOzHome$val$927 = system.getOzHome ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzHome$val$927 = system.getOzHome ();
    }
// 46
    ozHome = getOzHome$val$927;
// 47
    makeTmpDir ();
// 48
    JP.go.ipa.oz.lib.standard._StringBuffer_if command = null;
// 49
    JP.go.ipa.oz.lib.standard._Process_if process = null;
// 50
    JP.go.ipa.oz.lib.standard._String_if string$155 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    
// 50
    boolean startsWith$val$928;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
      try {
        startsWith$val$928 = ozHome.startsWith (string$155);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$928 = ozHome.startsWith (string$155);
    }
// 50
    if (startsWith$val$928) {{
// 51
        command = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("oz -f ")));
      }
    } else {{
// 53
        command = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("oz.bat -f ")));
      }
    }
// 55
    command.append (getScriptPath ());
// 56
    makeScript (ClassID, GOL, param);
// 57
    process = (JP.go.ipa.oz.lib.standard._Process_cl) (new JP.go.ipa.oz.lib.standard._Process_cl ())._new_create (command.asString ());
    return this;
  }
  
  public Object _new_create (JP.go.ipa.oz.user.ide.SchoolBrowser_if s) throws Exception  {
// 27
    sbr = s;
// 28
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 29
    JP.go.ipa.oz.lib.standard._String_if getOzHome$val$929;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getOzHome$val$929 = system.getOzHome ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzHome$val$929 = system.getOzHome ();
    }
// 29
    ozHome = getOzHome$val$929;
// 30
    makeTmpDir ();
// 31
    JP.go.ipa.oz.lib.standard._StringBuffer_if command = null;
// 32
    JP.go.ipa.oz.lib.standard._Process_if process = null;
// 33
    if (getPath () == null) {
// 33
      return this;
    }
// 34
    JP.go.ipa.oz.lib.standard._String_if string$156 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    
// 34
    boolean startsWith$val$930;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
      try {
        startsWith$val$930 = ozHome.startsWith (string$156);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$930 = ozHome.startsWith (string$156);
    }
// 34
    if (startsWith$val$930) {{
// 35
        command = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("oz -f ")));
      }
    } else {{
// 37
        command = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("oz.bat -f ")));
      }
    }
// 39
    command.append (getScriptPath ());
// 40
    makeScript ();
// 41
    process = (JP.go.ipa.oz.lib.standard._Process_cl) (new JP.go.ipa.oz.lib.standard._Process_cl ())._new_create (command.asString ());
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getScriptPath () throws Exception  {
    checkSecureInvocation ();
// 117
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (ozHome);
// 118
    JP.go.ipa.oz.lib.standard._String_if scriptPath = null;
// 119
    JP.go.ipa.oz.lib.standard._String_if string$157 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    
// 119
    boolean startsWith$val$931;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
      try {
        startsWith$val$931 = ozHome.startsWith (string$157);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$931 = ozHome.startsWith (string$157);
    }
// 119
    if (startsWith$val$931) {{
// 120
        JP.go.ipa.oz.lib.standard._String_if string$158 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
        
// 120
        boolean endsWith$val$932;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
          try {
            endsWith$val$932 = ozHome.endsWith (string$158);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          endsWith$val$932 = ozHome.endsWith (string$158);
        }
// 120
        if (endsWith$val$932) {
// 121
          JP.go.ipa.oz.lib.standard._String_if string$159 = (new JP.go.ipa.oz.lib.standard._String_cl("objects/ide/tmp/tmpTest"));
          
// 121
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$933;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$933 = buf.append (string$159);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$933 = buf.append (string$159);
          }
        } else {
// 123
          JP.go.ipa.oz.lib.standard._String_if string$160 = (new JP.go.ipa.oz.lib.standard._String_cl("/objects/ide/tmp/tmpTest"));
          
// 123
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$934;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$934 = buf.append (string$160);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$934 = buf.append (string$160);
          }
        }
      }
    } else {{
// 125
        JP.go.ipa.oz.lib.standard._String_if string$161 = (new JP.go.ipa.oz.lib.standard._String_cl("\\"));
        
// 125
        boolean endsWith$val$935;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
          try {
            endsWith$val$935 = ozHome.endsWith (string$161);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          endsWith$val$935 = ozHome.endsWith (string$161);
        }
// 125
        if (endsWith$val$935) {
// 126
          JP.go.ipa.oz.lib.standard._String_if string$162 = (new JP.go.ipa.oz.lib.standard._String_cl("objects\\ide\\tmp\\tmpTest"));
          
// 126
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$936;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$936 = buf.append (string$162);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$936 = buf.append (string$162);
          }
        } else {
// 128
          JP.go.ipa.oz.lib.standard._String_if string$163 = (new JP.go.ipa.oz.lib.standard._String_cl("\\objects\\ide\\tmp\\tmpTest"));
          
// 128
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$937;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$937 = buf.append (string$163);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$937 = buf.append (string$163);
          }
        }
      }
    }
// 130
    JP.go.ipa.oz.lib.standard._String_if asString$val$938;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        asString$val$938 = buf.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$938 = buf.asString ();
    }
// 130
    scriptPath = asString$val$938;
// 132
    JP.go.ipa.oz.lib.standard._File_if file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (scriptPath);
// 133
    if (file != null) {
// 133
      boolean delete$val$939;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
        try {
          delete$val$939 = file.delete ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        delete$val$939 = file.delete ();
      }
    }
// 135
    return scriptPath;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getTmpDir () throws Exception  {
    checkSecureInvocation ();
// 193
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (ozHome);
// 194
    JP.go.ipa.oz.lib.standard._String_if string$164 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    
// 194
    boolean startsWith$val$940;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
      try {
        startsWith$val$940 = ozHome.startsWith (string$164);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$940 = ozHome.startsWith (string$164);
    }
// 194
    if (startsWith$val$940) {{
// 195
        JP.go.ipa.oz.lib.standard._String_if string$165 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
        
// 195
        boolean endsWith$val$941;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
          try {
            endsWith$val$941 = ozHome.endsWith (string$165);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          endsWith$val$941 = ozHome.endsWith (string$165);
        }
// 195
        if (endsWith$val$941) {
// 196
          JP.go.ipa.oz.lib.standard._String_if string$166 = (new JP.go.ipa.oz.lib.standard._String_cl("objects/ide/tmp/"));
          
// 196
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$942;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$942 = buf.append (string$166);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$942 = buf.append (string$166);
          }
        } else {
// 198
          JP.go.ipa.oz.lib.standard._String_if string$167 = (new JP.go.ipa.oz.lib.standard._String_cl("/objects/ide/tmp/"));
          
// 198
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$943;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$943 = buf.append (string$167);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$943 = buf.append (string$167);
          }
        }
      }
    } else {{
// 200
        JP.go.ipa.oz.lib.standard._String_if string$168 = (new JP.go.ipa.oz.lib.standard._String_cl("\\"));
        
// 200
        boolean endsWith$val$944;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
          try {
            endsWith$val$944 = ozHome.endsWith (string$168);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          endsWith$val$944 = ozHome.endsWith (string$168);
        }
// 200
        if (endsWith$val$944) {
// 201
          JP.go.ipa.oz.lib.standard._String_if string$169 = (new JP.go.ipa.oz.lib.standard._String_cl("objects\\ide\\tmp\\"));
          
// 201
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$945;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$945 = buf.append (string$169);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$945 = buf.append (string$169);
          }
        } else {
// 203
          JP.go.ipa.oz.lib.standard._String_if string$170 = (new JP.go.ipa.oz.lib.standard._String_cl("\\objects\\ide\\tmp\\"));
          
// 203
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$946;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$946 = buf.append (string$170);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$946 = buf.append (string$170);
          }
        }
      }
    }
// 205
    JP.go.ipa.oz.lib.standard._String_if asString$val$947;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        asString$val$947 = buf.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$947 = buf.asString ();
    }
// 205
    return asString$val$947;
  }
  
  public JP.go.ipa.oz.lib.standard._StringBuffer_if constructScript (JP.go.ipa.oz.lib.standard._String_if ClassID, JP.go.ipa.oz.lib.standard._String_if GOL, JP.go.ipa.oz.lib.standard._String_if param) throws Exception  {
    checkSecureInvocation ();
// 93
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 95
    buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("create ")));
    boolean bool$val$23;
    
    bool$val$23 = GOL == null;
    if (!bool$val$23) {
// 96
      JP.go.ipa.oz.lib.standard._String_if string$171 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
      
// 96
      int compareTo$val$948;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) GOL)) {
        try {
          compareTo$val$948 = GOL.compareTo (string$171);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        compareTo$val$948 = GOL.compareTo (string$171);
      }
      bool$val$23 = compareTo$val$948 != 0;
    }
// 96
    if (bool$val$23) {
// 97
      buf.append (makeGOD ());
    } else {
// 99
      buf.append (GOL);
    }
// 100
    buf.append ((new JP.go.ipa.oz.lib.standard._String_cl(" ")));
// 101
    buf.append (ClassID);
    boolean bool$val$24;
    
    bool$val$24 = param != null;
    if (bool$val$24) {
// 102
      JP.go.ipa.oz.lib.standard._String_if string$172 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
      
// 102
      int compareTo$val$949;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) param)) {
        try {
          compareTo$val$949 = param.compareTo (string$172);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        compareTo$val$949 = param.compareTo (string$172);
      }
      bool$val$24 = compareTo$val$949 != 0;
    }
// 102
    if (bool$val$24) {{
// 103
        buf.append ((new JP.go.ipa.oz.lib.standard._String_cl(" ")));
// 104
        buf.append (param);
      }
    }
// 106
    buf.append ((new JP.go.ipa.oz.lib.standard._String_cl("\n")));
// 107
    buf.append ((new JP.go.ipa.oz.lib.standard._String_cl("watch ")));
    boolean bool$val$25;
    
    bool$val$25 = GOL == null;
    if (!bool$val$25) {
// 108
      JP.go.ipa.oz.lib.standard._String_if string$173 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
      
// 108
      int compareTo$val$950;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) GOL)) {
        try {
          compareTo$val$950 = GOL.compareTo (string$173);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        compareTo$val$950 = GOL.compareTo (string$173);
      }
      bool$val$25 = compareTo$val$950 == 0;
    }
// 108
    if (bool$val$25) {
// 109
      buf.append (makeGOD ());
    } else {
// 111
      buf.append (GOL);
    }
// 112
    buf.append ((new JP.go.ipa.oz.lib.standard._String_cl("\n")));
// 113
    return buf;
  }
  
  public JP.go.ipa.oz.lib.standard._StringBuffer_if constructScript () throws Exception  {
    checkSecureInvocation ();
// 72
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 74
    buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("create ")));
// 75
    buf.append (makeGOD ());
// 76
    buf.append ((new JP.go.ipa.oz.lib.standard._String_cl(" ")));
// 77
    JP.go.ipa.oz.user.ide.School_if getSchool$val$951;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
      try {
        getSchool$val$951 = sbr.getSchool ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchool$val$951 = sbr.getSchool ();
    }
// 77
    JP.go.ipa.oz.lib.standard._List_if getLstLabel$val$952;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
      try {
        getLstLabel$val$952 = sbr.getLstLabel ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getLstLabel$val$952 = sbr.getLstLabel ();
    }
// 77
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$953;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getLstLabel$val$952)) {
      try {
        getSelectedItem$val$953 = getLstLabel$val$952.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$953 = getLstLabel$val$952.getSelectedItem ();
    }
// 77
    JP.go.ipa.oz.lib.standard._String_if getImplementationID$val$954;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchool$val$951)) {
      try {
        getImplementationID$val$954 = getSchool$val$951.getImplementationID (getSelectedItem$val$953);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getImplementationID$val$954 = getSchool$val$951.getImplementationID (getSelectedItem$val$953);
    }
// 77
    JP.go.ipa.oz.lib.standard._String_if classID = getImplementationID$val$954;
// 78
    buf.append (classID);
// 79
    buf.append ((new JP.go.ipa.oz.lib.standard._String_cl("\n")));
// 80
    buf.append ((new JP.go.ipa.oz.lib.standard._String_cl("watch ")));
// 81
    buf.append (makeGOD ());
// 82
    buf.append ((new JP.go.ipa.oz.lib.standard._String_cl("\n")));
// 83
    return buf;
  }
  
  public void makeTmpDir () throws Exception  {
    checkSecureInvocation ();
// 187
    JP.go.ipa.oz.lib.standard._File_if file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (getTmpDir ());
// 188
    boolean exists$val$955;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        exists$val$955 = file.exists ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      exists$val$955 = file.exists ();
    }
// 188
    if (!exists$val$955) {
// 189
      boolean mkdir$val$956;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
        try {
          mkdir$val$956 = file.mkdir ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        mkdir$val$956 = file.mkdir ();
      }
    }
  }
  
  public void makeScriptFile (JP.go.ipa.oz.lib.standard._String_if scriptPath, JP.go.ipa.oz.lib.standard._StringBuffer_if script) throws Exception  {
    checkSecureInvocation ();
// 140
    try {
// 141
      JP.go.ipa.oz.lib.standard._FileOutputStream_if fout = (JP.go.ipa.oz.lib.standard._FileOutputStream_cl) (new JP.go.ipa.oz.lib.standard._FileOutputStream_cl ())._new_breed (scriptPath);
// 142
      JP.go.ipa.oz.lib.standard._OutputStreamWriter_if osw = (JP.go.ipa.oz.lib.standard._OutputStreamWriter_cl) (new JP.go.ipa.oz.lib.standard._OutputStreamWriter_cl ())._new_breed (fout);
// 143
      JP.go.ipa.oz.lib.standard._BufferedWriter_if bw = (JP.go.ipa.oz.lib.standard._BufferedWriter_cl) (new JP.go.ipa.oz.lib.standard._BufferedWriter_cl ())._new_breed (osw);
// 144
      int length$val$957;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) script)) {
        try {
          length$val$957 = script.length ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        length$val$957 = script.length ();
      }
// 144
      int len = length$val$957;
// 145
      JP.go.ipa.oz.lib.standard._String_if asString$val$958;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) script)) {
        try {
          asString$val$958 = script.asString ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        asString$val$958 = script.asString ();
      }
// 145
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bw)) {
        try {
          bw.write (asString$val$958, 0, len);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        bw.write (asString$val$958, 0, len);
      }
// 146
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bw)) {
        try {
          bw.close ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        bw.close ();
      }
// 147
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fout)) {
        try {
          fout.close ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        fout.close ();
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_1) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
      if (_oz_exception_1 instanceof JP.go.ipa.oz.lib.standard._FileNotFoundException_if) {
        JP.go.ipa.oz.lib.standard._FileNotFoundException_if e = (JP.go.ipa.oz.lib.standard._FileNotFoundException_if) _oz_exception_1;
      } else if (_oz_exception_1 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
        JP.go.ipa.oz.lib.standard._IOException_if e = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_1;
      } else throw _exception_1;
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if makeGOD () throws Exception  {
    checkSecureInvocation ();
// 209
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (getTmpDir ());
// 210
    JP.go.ipa.oz.lib.standard._String_if string$174 = (new JP.go.ipa.oz.lib.standard._String_cl("testExec"));
    
// 210
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$959;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$959 = buf.append (string$174);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$959 = buf.append (string$174);
    }
// 211
    JP.go.ipa.oz.lib.standard._String_if asString$val$960;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        asString$val$960 = buf.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$960 = buf.asString ();
    }
// 211
    JP.go.ipa.oz.lib.standard._File_if file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (asString$val$960);
// 212
    buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("ide.tmp.testExec.")));
// 213
    buf.append ((new JP.go.ipa.oz.lib.standard._String_cl("0 ")));
// 214
    boolean isDirectory$val$961;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        isDirectory$val$961 = file.isDirectory ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isDirectory$val$961 = file.isDirectory ();
    }
// 214
    if (!(isDirectory$val$961)) {
// 214
      return buf.asString ();
    }
// 216
    JP.go.ipa.oz.lib.standard._Array_if list$val$962;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        list$val$962 = file.list ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      list$val$962 = file.list ();
    }
// 216
    JP.go.ipa.oz.lib.standard._Array_if sourceList = list$val$962;
// 217
    int size$val$963;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sourceList)) {
      try {
        size$val$963 = sourceList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$963 = sourceList.size ();
    }
// 217
    JP.go.ipa.oz.lib.standard._Integer_if intObj = (JP.go.ipa.oz.lib.standard._Integer_cl) (new JP.go.ipa.oz.lib.standard._Integer_cl ())._new_breed (size$val$963);
// 218
    buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("ide.tmp.testExec.")));
// 219
    JP.go.ipa.oz.lib.standard._String_if asString$val$964;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) intObj)) {
      try {
        asString$val$964 = intObj.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$964 = intObj.asString ();
    }
// 219
    buf.append (asString$val$964);
// 220
    return buf.asString ();
  }
  
  public void makeScript (JP.go.ipa.oz.lib.standard._String_if ClassID, JP.go.ipa.oz.lib.standard._String_if GOL, JP.go.ipa.oz.lib.standard._String_if param) throws Exception  {
    checkSecureInvocation ();
// 87
    JP.go.ipa.oz.lib.standard._String_if scriptPath = getScriptPath ();
// 88
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = constructScript (ClassID, GOL, param);
// 89
    makeScriptFile (scriptPath, buf);
  }
  
  public void makeScript () throws Exception  {
    checkSecureInvocation ();
// 66
    JP.go.ipa.oz.lib.standard._String_if scriptPath = getScriptPath ();
// 67
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = constructScript ();
// 68
    makeScriptFile (scriptPath, buf);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getPath () throws Exception  {
    checkSecureInvocation ();
// 156
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 157
    JP.go.ipa.oz.lib.standard._String_if classID = null, fullPath = null;
// 159
    JP.go.ipa.oz.user.ide.School_if getSchool$val$965;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
      try {
        getSchool$val$965 = sbr.getSchool ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchool$val$965 = sbr.getSchool ();
    }
// 159
    JP.go.ipa.oz.lib.standard._List_if getLstLabel$val$966;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
      try {
        getLstLabel$val$966 = sbr.getLstLabel ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getLstLabel$val$966 = sbr.getLstLabel ();
    }
// 159
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$967;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getLstLabel$val$966)) {
      try {
        getSelectedItem$val$967 = getLstLabel$val$966.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$967 = getLstLabel$val$966.getSelectedItem ();
    }
// 159
    JP.go.ipa.oz.lib.standard._String_if getImplementationID$val$968;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchool$val$965)) {
      try {
        getImplementationID$val$968 = getSchool$val$965.getImplementationID (getSelectedItem$val$967);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getImplementationID$val$968 = getSchool$val$965.getImplementationID (getSelectedItem$val$967);
    }
// 159
    classID = getImplementationID$val$968;
// 160
    JP.go.ipa.oz.lib.standard._String_if string$175 = (new JP.go.ipa.oz.lib.standard._String_cl("_"));
    
// 160
    int lastIndexOf$val$969;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classID)) {
      try {
        lastIndexOf$val$969 = classID.lastIndexOf (string$175);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$969 = classID.lastIndexOf (string$175);
    }
// 160
    JP.go.ipa.oz.lib.standard._String_if substring$val$970;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classID)) {
      try {
        substring$val$970 = classID.substring (0, lastIndexOf$val$969);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$970 = classID.substring (0, lastIndexOf$val$969);
    }
// 160
    classID = substring$val$970;
// 162
    JP.go.ipa.oz.lib.standard._String_if string$176 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    
// 162
    boolean startsWith$val$971;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
      try {
        startsWith$val$971 = ozHome.startsWith (string$176);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$971 = ozHome.startsWith (string$176);
    }
// 162
    if (startsWith$val$971) {{
// 163
        JP.go.ipa.oz.lib.standard._String_if replace$val$972;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classID)) {
          try {
            replace$val$972 = classID.replace ('.', '/');
          } finally {
            changeRunningToGreen ();
          }
        } else {
          replace$val$972 = classID.replace ('.', '/');
        }
// 163
        classID = replace$val$972;
// 164
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$973;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$973 = buf.append (ozHome);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$973 = buf.append (ozHome);
        }
// 165
        JP.go.ipa.oz.lib.standard._String_if string$177 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
        
// 165
        boolean endsWith$val$974;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
          try {
            endsWith$val$974 = ozHome.endsWith (string$177);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          endsWith$val$974 = ozHome.endsWith (string$177);
        }
// 165
        if (endsWith$val$974) {
// 166
          JP.go.ipa.oz.lib.standard._String_if string$178 = (new JP.go.ipa.oz.lib.standard._String_cl("lib/"));
          
// 166
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$975;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$975 = buf.append (string$178);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$975 = buf.append (string$178);
          }
        } else {
// 168
          JP.go.ipa.oz.lib.standard._String_if string$179 = (new JP.go.ipa.oz.lib.standard._String_cl("/lib/"));
          
// 168
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$976;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$976 = buf.append (string$179);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$976 = buf.append (string$179);
          }
        }
// 169
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$977;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$977 = buf.append (classID);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$977 = buf.append (classID);
        }
      }
    } else {{
// 171
        JP.go.ipa.oz.lib.standard._String_if replace$val$978;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classID)) {
          try {
            replace$val$978 = classID.replace ('.', '\\');
          } finally {
            changeRunningToGreen ();
          }
        } else {
          replace$val$978 = classID.replace ('.', '\\');
        }
// 171
        classID = replace$val$978;
// 172
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$979;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$979 = buf.append (ozHome);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$979 = buf.append (ozHome);
        }
// 173
        JP.go.ipa.oz.lib.standard._String_if string$180 = (new JP.go.ipa.oz.lib.standard._String_cl("\\"));
        
// 173
        boolean endsWith$val$980;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
          try {
            endsWith$val$980 = ozHome.endsWith (string$180);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          endsWith$val$980 = ozHome.endsWith (string$180);
        }
// 173
        if (endsWith$val$980) {
// 174
          JP.go.ipa.oz.lib.standard._String_if string$181 = (new JP.go.ipa.oz.lib.standard._String_cl("lib\\"));
          
// 174
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$981;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$981 = buf.append (string$181);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$981 = buf.append (string$181);
          }
        } else {
// 176
          JP.go.ipa.oz.lib.standard._String_if string$182 = (new JP.go.ipa.oz.lib.standard._String_cl("\\lib\\"));
          
// 176
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$982;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$982 = buf.append (string$182);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$982 = buf.append (string$182);
          }
        }
// 177
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$983;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$983 = buf.append (classID);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$983 = buf.append (classID);
        }
      }
    }
// 179
    JP.go.ipa.oz.lib.standard._String_if string$183 = (new JP.go.ipa.oz.lib.standard._String_cl("_pcl.class"));
    
// 179
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$984;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$984 = buf.append (string$183);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$984 = buf.append (string$183);
    }
// 180
    JP.go.ipa.oz.lib.standard._String_if asString$val$985;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        asString$val$985 = buf.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$985 = buf.asString ();
    }
// 180
    fullPath = asString$val$985;
// 181
    JP.go.ipa.oz.lib.standard._File_if file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (fullPath);
// 182
    boolean exists$val$986;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        exists$val$986 = file.exists ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      exists$val$986 = file.exists ();
    }
// 182
    if (exists$val$986) {
// 182
      return fullPath;
    } else {
// 183
      return null;
    }
  }
  
  public SBUtility_cl () throws Exception { super (); }
  
}


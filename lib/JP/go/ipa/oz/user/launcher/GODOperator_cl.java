package JP.go.ipa.oz.user.launcher;

public class GODOperator_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.launcher.GODOperator_if {
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.lib.standard._String_if topPath;
  char fileSepChar;
  
  public Object _new_create () throws Exception  {
// 24
    init ();
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if toGOD (JP.go.ipa.oz.lib.standard._String_if path, JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 92
    JP.go.ipa.oz.lib.standard._String_if god = null, pre = null;
// 93
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = null;
// 95
    if (path == null) {{
// 96
        return name;
      }
    } else {{
// 99
        pre = toGOD (path);
        boolean bool$val$0;
        
        bool$val$0 = pre == null;
        if (!bool$val$0) {
// 100
          int length$val$0;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pre)) {
            try {
              length$val$0 = pre.length ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            length$val$0 = pre.length ();
          }
          bool$val$0 = length$val$0 == 0;
        }
// 100
        if (bool$val$0) {{
// 101
            god = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (name);
          }
        } else {{
// 103
            buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (pre);
// 104
            JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl("."));
            
// 104
            JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$1;
            append$val$1 = buf.append (string$0);
// 104
            JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$2;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$1)) {
              try {
                append$val$2 = append$val$1.append (name);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              append$val$2 = append$val$1.append (name);
            }
// 105
            god = buf.asString ();
          }
        }
// 108
        return god;
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if toGOD (JP.go.ipa.oz.lib.standard._String_if path) throws Exception  {
    checkSecureInvocation ();
// 66
    JP.go.ipa.oz.lib.standard._String_if absPath = null;
// 67
    JP.go.ipa.oz.lib.standard._String_if god = null;
    boolean bool$val$1;
    
    bool$val$1 = path == null;
    if (!bool$val$1) {
// 69
      int length$val$3;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          length$val$3 = path.length ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        length$val$3 = path.length ();
      }
      bool$val$1 = length$val$3 == 0;
    }
// 69
    if (bool$val$1) {{
// 70
        god = null;
      }
    } else {{
// 72
        boolean startsWith$val$4;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
          try {
            startsWith$val$4 = path.startsWith (topPath);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          startsWith$val$4 = path.startsWith (topPath);
        }
// 72
        if (startsWith$val$4) {{
// 74
            int length$val$5;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) topPath)) {
              try {
                length$val$5 = topPath.length ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              length$val$5 = topPath.length ();
            }
// 74
            JP.go.ipa.oz.lib.standard._String_if substring$val$6;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
              try {
                substring$val$6 = path.substring (length$val$5);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              substring$val$6 = path.substring (length$val$5);
            }
// 74
            absPath = substring$val$6;
            boolean bool$val$2;
            
// 75
            int length$val$7;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) absPath)) {
              try {
                length$val$7 = absPath.length ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              length$val$7 = absPath.length ();
            }
            bool$val$2 = length$val$7 > 0;
            if (bool$val$2) {
// 75
              char charAt$val$8;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) absPath)) {
                try {
                  charAt$val$8 = absPath.charAt (0);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                charAt$val$8 = absPath.charAt (0);
              }
              bool$val$2 = charAt$val$8 == fileSepChar;
            }
// 75
            if (bool$val$2) {{
// 77
                JP.go.ipa.oz.lib.standard._String_if substring$val$9;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) absPath)) {
                  try {
                    substring$val$9 = absPath.substring (1);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  substring$val$9 = absPath.substring (1);
                }
// 77
                absPath = substring$val$9;
              }
            }
          }
        } else {{
// 80
            absPath = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (path);
          }
        }
// 82
        god = absPath.replace (fileSepChar, '.');
      }
    }
// 85
    return god;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if toPath (JP.go.ipa.oz.lib.standard._String_if god) throws Exception  {
    checkSecureInvocation ();
// 33
    JP.go.ipa.oz.lib.standard._String_if path = null;
// 35
    if (god == null) {{
// 36
        path = null;
      }
    } else {{
// 38
        JP.go.ipa.oz.lib.standard._String_if replace$val$10;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) god)) {
          try {
            replace$val$10 = god.replace ('.', fileSepChar);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          replace$val$10 = god.replace ('.', fileSepChar);
        }
// 38
        path = replace$val$10;
      }
    }
// 41
    return path;
  }
  
  void init () throws Exception  {
// 118
    JP.go.ipa.oz.lib.standard._String_if ozhome = null;
// 119
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = null;
// 121
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 122
    JP.go.ipa.oz.lib.standard._String_if getOzHome$val$11;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getOzHome$val$11 = system.getOzHome ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzHome$val$11 = system.getOzHome ();
    }
// 122
    ozhome = getOzHome$val$11;
// 123
    JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    
// 123
    boolean startsWith$val$12;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozhome)) {
      try {
        startsWith$val$12 = ozhome.startsWith (string$1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$12 = ozhome.startsWith (string$1);
    }
// 123
    if (startsWith$val$12) {{
// 124
        fileSepChar = '/';
      }
    } else {{
// 126
        fileSepChar = '\\';
      }
    }
// 129
    buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (ozhome);
// 130
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$13;
    append$val$13 = buf.append (fileSepChar);
// 130
    JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl("objects"));
    
// 130
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$14;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$13)) {
      try {
        append$val$14 = append$val$13.append (string$2);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$14 = append$val$13.append (string$2);
    }
// 131
    topPath = buf.asString ();
  }
  
  public JP.go.ipa.oz.lib.standard._String_if toFullPath (JP.go.ipa.oz.lib.standard._String_if god) throws Exception  {
    checkSecureInvocation ();
// 48
    JP.go.ipa.oz.lib.standard._String_if path = null;
// 49
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = null;
// 51
    if (god == null) {{
// 52
        path = null;
      }
    } else {{
// 54
        buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (topPath);
// 55
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$15;
        append$val$15 = buf.append (fileSepChar);
// 55
        JP.go.ipa.oz.lib.standard._String_if toPath$val$16;
        toPath$val$16 = toPath (god);
// 55
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$17;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$15)) {
          try {
            append$val$17 = append$val$15.append (toPath$val$16);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$17 = append$val$15.append (toPath$val$16);
        }
// 56
        path = buf.asString ();
      }
    }
// 59
    return path;
  }
  
  public GODOperator_cl () throws Exception { super (); }
  
}


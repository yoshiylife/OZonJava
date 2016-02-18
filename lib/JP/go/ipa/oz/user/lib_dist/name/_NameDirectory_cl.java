package JP.go.ipa.oz.user.lib_dist.name;

public class _NameDirectory_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if {
  protected JP.go.ipa.oz.lib.standard._Dictionary_if Entries;
  protected boolean branch;
  protected JP.go.ipa.oz.lib.standard._Dictionary_if SubDirs;
  
  public Object _new_create () throws Exception  {
// 13
    JP.go.ipa.oz.lib.standard._StringComparator_if sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 14
    Entries = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (sc);
// 15
    SubDirs = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (sc);
// 16
    branch = false;
    return this;
  }
  
  public Object _new_createBranch () throws Exception  {
// 20
    branch = true;
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if DirectoryNameSet () throws Exception  {
    checkSecureInvocation ();
// 148
    JP.go.ipa.oz.lib.standard._Set_if keys$val$93;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) SubDirs)) {
      try {
        keys$val$93 = SubDirs.keys ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      keys$val$93 = SubDirs.keys ();
    }
// 148
    return (keys$val$93);
  }
  
  public int EntrySize () throws Exception  {
    checkSecureInvocation ();
// 95
    int size$val$94;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) Entries)) {
      try {
        size$val$94 = Entries.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$94 = Entries.size ();
    }
// 95
    return (size$val$94);
  }
  
  public void BranchInOtherCell (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 179
    JP.go.ipa.oz.lang._Root_if get$val$95;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) SubDirs)) {
      try {
        get$val$95 = SubDirs.get (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$95 = SubDirs.get (name);
    }
// 179
    if ((get$val$95) != null) {{
// 180
        JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if b = (JP.go.ipa.oz.user.lib_dist.name._NameDirectory_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameDirectory_cl ())._new_createBranch ();
// 181
        JP.go.ipa.oz.lib.standard._Dictionary_if put$val$96;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) SubDirs)) {
          try {
            put$val$96 = SubDirs.put (name, b);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          put$val$96 = SubDirs.put (name, b);
        }
// 181
        SubDirs = put$val$96;
      }
    }
  }
  
  public JP.go.ipa.oz.lang._Root_if getEntry (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 79
    JP.go.ipa.oz.lang._Root_if get$val$97;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) Entries)) {
      try {
        get$val$97 = Entries.get (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$97 = Entries.get (name);
    }
// 79
    return (get$val$97);
  }
  
  public JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if removeDirectory (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 140
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if subdir = null;
// 140
    JP.go.ipa.oz.lang._Root_if get$val$98;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) SubDirs)) {
      try {
        get$val$98 = SubDirs.get (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$98 = SubDirs.get (name);
    }
// 140
    subdir = (JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if) (get$val$98);
// 141
    JP.go.ipa.oz.lib.standard._Dictionary_if remove$val$99;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) SubDirs)) {
      try {
        remove$val$99 = SubDirs.remove (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      remove$val$99 = SubDirs.remove (name);
    }
// 141
    SubDirs = remove$val$99;
// 142
    return subdir;
  }
  
  public boolean containDirectory (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 132
    boolean containsKey$val$100;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) SubDirs)) {
      try {
        containsKey$val$100 = SubDirs.containsKey (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      containsKey$val$100 = SubDirs.containsKey (name);
    }
// 132
    return (containsKey$val$100);
  }
  
  public boolean debugPrint (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 24
    try {
// 25
      JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 26
      JP.go.ipa.oz.lib.standard._PrintWriter_if getStdout$val$101;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          getStdout$val$101 = system.getStdout ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getStdout$val$101 = system.getStdout ();
      }
// 26
      JP.go.ipa.oz.lib.standard._PrintWriter_if pw = getStdout$val$101;
// 27
      JP.go.ipa.oz.lib.standard._String_if string$99 = (new JP.go.ipa.oz.lib.standard._String_cl("namedirectory---"));
      
// 27
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
        try {
          pw.print (string$99);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        pw.print (string$99);
      }
// 27
      JP.go.ipa.oz.lib.standard._String_if asString$val$102;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          asString$val$102 = path.asString ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        asString$val$102 = path.asString ();
      }
// 27
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
        try {
          pw.println (asString$val$102);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        pw.println (asString$val$102);
      }
// 28
      if (branch) {
// 28
        JP.go.ipa.oz.lib.standard._String_if string$100 = (new JP.go.ipa.oz.lib.standard._String_cl("branch in other nameserver cell"));
        
// 28
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
          try {
            pw.println (string$100);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          pw.println (string$100);
        }
      } else {{
// 30
          JP.go.ipa.oz.lib.standard._Iterator_if keyIterator$val$103;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) SubDirs)) {
            try {
              keyIterator$val$103 = SubDirs.keyIterator ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            keyIterator$val$103 = SubDirs.keyIterator ();
          }
// 30
          JP.go.ipa.oz.lib.standard._Iterator_if it = keyIterator$val$103;
// 31
          JP.go.ipa.oz.lib.standard._String_if string$101 = (new JP.go.ipa.oz.lib.standard._String_cl("  subdir"));
          
// 31
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
            try {
              pw.println (string$101);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            pw.println (string$101);
          }
// 32
          while (true) {
// 32
            boolean atEnd$val$104;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
              try {
                atEnd$val$104 = it.atEnd ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              atEnd$val$104 = it.atEnd ();
            }
            if (!(!(atEnd$val$104))) break;
            
            /* body */ _loop_1: {
// 33
              JP.go.ipa.oz.lib.standard._String_if subdirname = null;
// 34
              JP.go.ipa.oz.lang._Root_if nextElement$val$105;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
                try {
                  nextElement$val$105 = it.nextElement ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                nextElement$val$105 = it.nextElement ();
              }
// 34
              subdirname = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$105);
// 35
              JP.go.ipa.oz.lib.standard._String_if string$102 = (new JP.go.ipa.oz.lib.standard._String_cl("    "));
              
// 35
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
                try {
                  pw.print (string$102);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                pw.print (string$102);
              }
// 35
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
                try {
                  pw.println (subdirname);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                pw.println (subdirname);
              }
            }
          }
// 37
          JP.go.ipa.oz.lib.standard._Iterator_if keyIterator$val$106;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) Entries)) {
            try {
              keyIterator$val$106 = Entries.keyIterator ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            keyIterator$val$106 = Entries.keyIterator ();
          }
// 37
          it = keyIterator$val$106;
// 38
          JP.go.ipa.oz.lib.standard._String_if string$103 = (new JP.go.ipa.oz.lib.standard._String_cl("  entry"));
          
// 38
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
            try {
              pw.println (string$103);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            pw.println (string$103);
          }
// 39
          while (true) {
// 39
            boolean atEnd$val$107;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
              try {
                atEnd$val$107 = it.atEnd ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              atEnd$val$107 = it.atEnd ();
            }
            if (!(!(atEnd$val$107))) break;
            
            /* body */ _loop_1: {
// 40
              JP.go.ipa.oz.lib.standard._String_if entryname = null;
// 41
              JP.go.ipa.oz.lang._Root_if nextElement$val$108;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
                try {
                  nextElement$val$108 = it.nextElement ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                nextElement$val$108 = it.nextElement ();
              }
// 41
              entryname = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$108);
// 42
              JP.go.ipa.oz.lib.standard._String_if string$104 = (new JP.go.ipa.oz.lib.standard._String_cl("    "));
              
// 42
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
                try {
                  pw.print (string$104);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                pw.print (string$104);
              }
// 42
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
                try {
                  pw.println (entryname);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                pw.println (entryname);
              }
            }
          }
        }
      }
// 45
      JP.go.ipa.oz.lib.standard._String_if string$105 = (new JP.go.ipa.oz.lib.standard._String_cl("------"));
      
// 45
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
        try {
          pw.println (string$105);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        pw.println (string$105);
      }
// 46
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
        try {
          pw.flush ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        pw.flush ();
      }
// 47
      return true;
    }
    catch (java.lang.SecurityException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 49
      return false;
    }
  }
  
  public boolean isBranch () throws Exception  {
    checkSecureInvocation ();
// 186
    return branch;
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if DirectorySet () throws Exception  {
    checkSecureInvocation ();
// 154
    JP.go.ipa.oz.lib.standard._Set_if values$val$109;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) SubDirs)) {
      try {
        values$val$109 = SubDirs.values ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      values$val$109 = SubDirs.values ();
    }
// 154
    return (values$val$109);
  }
  
  public JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if getDirectory (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 168
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd = null;
// 168
    JP.go.ipa.oz.lang._Root_if get$val$110;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) SubDirs)) {
      try {
        get$val$110 = SubDirs.get (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$110 = SubDirs.get (name);
    }
// 168
    nd = (JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if) (get$val$110);
// 169
    return nd;
  }
  
  public void overputDirectory (JP.go.ipa.oz.lib.standard._String_if name, JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if dir) throws Exception  {
    checkSecureInvocation ();
// 125
    JP.go.ipa.oz.lib.standard._Dictionary_if put$val$111;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) SubDirs)) {
      try {
        put$val$111 = SubDirs.put (name, dir);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$111 = SubDirs.put (name, dir);
    }
// 125
    SubDirs = put$val$111;
  }
  
  public JP.go.ipa.oz.lang._Root_if removeEntry (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 87
    JP.go.ipa.oz.lang._Root_if get$val$112;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) Entries)) {
      try {
        get$val$112 = Entries.get (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$112 = Entries.get (name);
    }
// 87
    JP.go.ipa.oz.lang._Root_if entry = get$val$112;
// 88
    JP.go.ipa.oz.lib.standard._Dictionary_if remove$val$113;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) Entries)) {
      try {
        remove$val$113 = Entries.remove (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      remove$val$113 = Entries.remove (name);
    }
// 88
    Entries = remove$val$113;
// 89
    return entry;
  }
  
  public int DirectorySize () throws Exception  {
    checkSecureInvocation ();
// 160
    int size$val$114;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) SubDirs)) {
      try {
        size$val$114 = SubDirs.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$114 = SubDirs.size ();
    }
// 160
    return (size$val$114);
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if EntryNameSet () throws Exception  {
    checkSecureInvocation ();
// 101
    JP.go.ipa.oz.lib.standard._Set_if keys$val$115;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) Entries)) {
      try {
        keys$val$115 = Entries.keys ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      keys$val$115 = Entries.keys ();
    }
// 101
    return (keys$val$115);
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if EntrySet () throws Exception  {
    checkSecureInvocation ();
// 107
    JP.go.ipa.oz.lib.standard._Set_if values$val$116;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) Entries)) {
      try {
        values$val$116 = Entries.values ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      values$val$116 = Entries.values ();
    }
// 107
    return (values$val$116);
  }
  
  public void putDirectory (JP.go.ipa.oz.lib.standard._String_if name, JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if dir) throws Exception  {
    checkSecureInvocation ();
// 115
    boolean containsKey$val$117;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) SubDirs)) {
      try {
        containsKey$val$117 = SubDirs.containsKey (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      containsKey$val$117 = SubDirs.containsKey (name);
    }
// 115
    if (containsKey$val$117) {{
// 116
        JP.go.ipa.oz.user.lib_dist.name._NameDirectoryDuplicateNameException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameDirectoryDuplicateNameException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameDirectoryDuplicateNameException_cl ())._new_init ();
// 116
        throw new JP.go.ipa.oz.lang.OzException (e);
      }
    } else {{
// 118
        JP.go.ipa.oz.lib.standard._Dictionary_if put$val$118;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) SubDirs)) {
          try {
            put$val$118 = SubDirs.put (name, dir);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          put$val$118 = SubDirs.put (name, dir);
        }
// 118
        SubDirs = put$val$118;
      }
    }
  }
  
  public void putEntry (JP.go.ipa.oz.lib.standard._String_if name, JP.go.ipa.oz.lang._Root_if ent) throws Exception  {
    checkSecureInvocation ();
// 60
    boolean containsKey$val$119;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) Entries)) {
      try {
        containsKey$val$119 = Entries.containsKey (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      containsKey$val$119 = Entries.containsKey (name);
    }
// 60
    if (containsKey$val$119) {{
// 61
        JP.go.ipa.oz.user.lib_dist.name._NameDirectoryDuplicateNameException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameDirectoryDuplicateNameException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameDirectoryDuplicateNameException_cl ())._new_init ();
// 61
        throw new JP.go.ipa.oz.lang.OzException (e);
      }
    } else {{
// 63
        JP.go.ipa.oz.lib.standard._Dictionary_if put$val$120;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) Entries)) {
          try {
            put$val$120 = Entries.put (name, ent);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          put$val$120 = Entries.put (name, ent);
        }
// 63
        Entries = put$val$120;
      }
    }
  }
  
  public boolean containEntry (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 71
    boolean containsKey$val$121;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) Entries)) {
      try {
        containsKey$val$121 = Entries.containsKey (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      containsKey$val$121 = Entries.containsKey (name);
    }
// 71
    return (containsKey$val$121);
  }
  
  public _NameDirectory_cl () throws Exception { super (); }
  
}


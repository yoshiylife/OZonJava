package JP.go.ipa.oz.user.cda;

public class _MaintenunceTool_cl extends JP.go.ipa.oz.system.OzCell implements JP.go.ipa.oz.user.cda._MaintenunceTool_if {
  static final boolean _global_ = true;
  JP.go.ipa.oz.lib.standard._String_if urPath;
  char separatorChar;
  JP.go.ipa.oz.user.cda._ClassDeliveryAgent_if CDA;
  JP.go.ipa.oz.lib.standard._String_if separatorString;
  
  protected void initialize () throws Exception  {
// 22
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 24
    JP.go.ipa.oz.lib.standard._String_if getOzHome$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getOzHome$val$0 = system.getOzHome ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzHome$val$0 = system.getOzHome ();
    }
// 24
    JP.go.ipa.oz.lib.standard._String_if ozhomeS = getOzHome$val$0;
// 25
    JP.go.ipa.oz.lib.standard._String_if urS = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl(".lib.JP.go.ipa.oz.user.released")));
// 26
    JP.go.ipa.oz.lib.standard._File_if f = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (ozhomeS);
// 27
    char getSeparatorChar$val$1;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
      try {
        getSeparatorChar$val$1 = f.getSeparatorChar ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSeparatorChar$val$1 = f.getSeparatorChar ();
    }
// 27
    separatorChar = getSeparatorChar$val$1;
// 28
    JP.go.ipa.oz.lib.standard._String_if getSeparator$val$2;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
      try {
        getSeparator$val$2 = f.getSeparator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSeparator$val$2 = f.getSeparator ();
    }
// 28
    separatorString = getSeparator$val$2;
// 29
    JP.go.ipa.oz.lib.standard._String_if replace$val$3;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) urS)) {
      try {
        replace$val$3 = urS.replace ('.', separatorChar);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      replace$val$3 = urS.replace ('.', separatorChar);
    }
// 29
    urS = replace$val$3;
// 30
    JP.go.ipa.oz.lib.standard._String_if concat$val$4;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozhomeS)) {
      try {
        concat$val$4 = ozhomeS.concat (urS);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$4 = ozhomeS.concat (urS);
    }
// 30
    urPath = concat$val$4;
  }
  
  protected void quiet () throws Exception  {
// 175
    flushCell ();
  }
  
  protected void go () throws Exception  {
// 58
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 59
    JP.go.ipa.oz.user.cda._CDAdebug_if debug = (JP.go.ipa.oz.user.cda._CDAdebug_cl) (new JP.go.ipa.oz.user.cda._CDAdebug_cl ())._new_create ();
// 60
    JP.go.ipa.oz.lib.standard._Array_if args = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (16);
// 60
    JP.go.ipa.oz.lib.standard._Array_if getArguments$val$5;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getArguments$val$5 = system.getArguments ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getArguments$val$5 = system.getArguments ();
    }
// 60
    args = getArguments$val$5;
// 61
    JP.go.ipa.oz.lib.standard._String_if command = null;
// 61
    JP.go.ipa.oz.lang._Root_if at$val$6;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
      try {
        at$val$6 = args.at (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$6 = args.at (0);
    }
// 61
    command = (JP.go.ipa.oz.lib.standard._String_if) (at$val$6);
// 63
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.println (command);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.println (command);
    }
// 64
    JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl("setCDAGOL"));
    
// 64
    boolean isequal$val$7;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
      try {
        isequal$val$7 = command.isequal (string$0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$7 = command.isequal (string$0);
    }
// 64
    if (isequal$val$7) {{
// 65
        JP.go.ipa.oz.lib.standard._String_if CDAGOL = null;
// 65
        JP.go.ipa.oz.lang._Root_if at$val$8;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
          try {
            at$val$8 = args.at (1);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          at$val$8 = args.at (1);
        }
// 65
        CDAGOL = (JP.go.ipa.oz.lib.standard._String_if) (at$val$8);
// 66
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
          try {
            debug.println (CDAGOL);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          debug.println (CDAGOL);
        }
// 67
        CDA = new JP.go.ipa.oz.user.cda._ClassDeliveryAgent_pcl (CDAGOL);
      }
    } else {
// 68
      JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl("wait"));
      
// 68
      boolean isequal$val$9;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
        try {
          isequal$val$9 = command.isequal (string$1);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$9 = command.isequal (string$1);
      }
// 68
      if (isequal$val$9) {{
// 69
          JP.go.ipa.oz.lib.standard._String_if s = null;
// 69
          JP.go.ipa.oz.lang._Root_if at$val$10;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
            try {
              at$val$10 = args.at (1);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            at$val$10 = args.at (1);
          }
// 69
          s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$10);
// 69
          int i = JP.go.ipa.oz.user.cda._AtoI_cl._static_atoi (s);
// 70
          sleepThread (i);
        }
      } else {
// 71
        JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl("LocalRepository"));
        
// 71
        boolean isequal$val$11;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
          try {
            isequal$val$11 = command.isequal (string$2);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$11 = command.isequal (string$2);
        }
// 71
        if (isequal$val$11) {{
// 72
            JP.go.ipa.oz.lib.standard._String_if subcommand = null;
// 72
            JP.go.ipa.oz.lang._Root_if at$val$12;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
              try {
                at$val$12 = args.at (1);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              at$val$12 = args.at (1);
            }
// 72
            subcommand = (JP.go.ipa.oz.lib.standard._String_if) (at$val$12);
// 73
            JP.go.ipa.oz.lib.standard._String_if string$3 = (new JP.go.ipa.oz.lib.standard._String_cl("zips"));
            
// 73
            boolean isequal$val$13;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subcommand)) {
              try {
                isequal$val$13 = subcommand.isequal (string$3);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              isequal$val$13 = subcommand.isequal (string$3);
            }
// 73
            if (isequal$val$13) {{
// 74
                recursiveDir (urPath, system);
              }
            } else {
// 75
              JP.go.ipa.oz.lib.standard._String_if string$4 = (new JP.go.ipa.oz.lib.standard._String_cl("zipentry"));
              
// 75
              boolean isequal$val$14;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subcommand)) {
                try {
                  isequal$val$14 = subcommand.isequal (string$4);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                isequal$val$14 = subcommand.isequal (string$4);
              }
// 75
              if (isequal$val$14) {{
// 76
                  JP.go.ipa.oz.lib.standard._String_if zipFileDirPath = null;
// 76
                  JP.go.ipa.oz.lang._Root_if at$val$15;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                    try {
                      at$val$15 = args.at (2);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    at$val$15 = args.at (2);
                  }
// 76
                  zipFileDirPath = (JP.go.ipa.oz.lib.standard._String_if) (at$val$15);
// 77
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
                    try {
                      debug.println (zipFileDirPath);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    debug.println (zipFileDirPath);
                  }
// 78
                  JP.go.ipa.oz.lib.standard._String_if concat$val$16;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) separatorString)) {
                    try {
                      concat$val$16 = separatorString.concat (zipFileDirPath);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    concat$val$16 = separatorString.concat (zipFileDirPath);
                  }
// 78
                  zipFileDirPath = concat$val$16;
// 79
                  JP.go.ipa.oz.lib.standard._String_if concat$val$17;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) urPath)) {
                    try {
                      concat$val$17 = urPath.concat (zipFileDirPath);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    concat$val$17 = urPath.concat (zipFileDirPath);
                  }
// 79
                  zipFileDirPath = concat$val$17;
// 80
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
                    try {
                      debug.println (zipFileDirPath);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    debug.println (zipFileDirPath);
                  }
// 81
                  JP.go.ipa.oz.user.cda._CDAZipFile_if zf = (JP.go.ipa.oz.user.cda._CDAZipFile_cl) (new JP.go.ipa.oz.user.cda._CDAZipFile_cl ())._new_breed (zipFileDirPath);
// 83
                  JP.go.ipa.oz.lib.standard._Array_if list$val$18;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) zf)) {
                    try {
                      list$val$18 = zf.list ();
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    list$val$18 = zf.list ();
                  }
// 83
                  JP.go.ipa.oz.lib.standard._Array_if entries = list$val$18;
// 85
                  int size$val$19;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) entries)) {
                    try {
                      size$val$19 = entries.size ();
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    size$val$19 = entries.size ();
                  }
// 85
                  int size = size$val$19;
// 86
                  /* for loop starting here */ {
                    /* initialization part */
                    int i = 0;
                    
                    for (;;) {
                      /* boolean expression part */
                      if (!(i < size)) break;
                      
                      /* body */ _loop_1: {
// 87
                        JP.go.ipa.oz.lib.standard._String_if entryName = null;
// 87
                        JP.go.ipa.oz.lang._Root_if at$val$20;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) entries)) {
                          try {
                            at$val$20 = entries.at (i);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          at$val$20 = entries.at (i);
                        }
// 87
                        entryName = (JP.go.ipa.oz.lib.standard._String_if) (at$val$20);
// 88
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                          try {
                            system.println (entryName);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          system.println (entryName);
                        }
                      }
                      /* iteration part */
// 86
                      i++;
                    }
                  }
                }
              } else {
// 90
                JP.go.ipa.oz.lib.standard._String_if string$5 = (new JP.go.ipa.oz.lib.standard._String_cl("get"));
                
// 90
                boolean isequal$val$21;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subcommand)) {
                  try {
                    isequal$val$21 = subcommand.isequal (string$5);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  isequal$val$21 = subcommand.isequal (string$5);
                }
// 90
                if (isequal$val$21) {{
// 91
                    JP.go.ipa.oz.lib.standard._String_if packageName = null;
// 91
                    JP.go.ipa.oz.lang._Root_if at$val$22;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                      try {
                        at$val$22 = args.at (2);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      at$val$22 = args.at (2);
                    }
// 91
                    packageName = (JP.go.ipa.oz.lib.standard._String_if) (at$val$22);
// 92
                    JP.go.ipa.oz.lib.standard._File_if f = null;
// 93
                    try {
// 94
                      f = JP.go.ipa.oz.lib.standard._LocalRepositoryManager_cl._static_get (packageName);
// 95
                      JP.go.ipa.oz.lib.standard._String_if getPath$val$23;
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
                        try {
                          getPath$val$23 = f.getPath ();
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        getPath$val$23 = f.getPath ();
                      }
// 95
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                        try {
                          system.println (getPath$val$23);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        system.println (getPath$val$23);
                      }
                    }
                    catch (JP.go.ipa.oz.lang.OzException _exception_1) {
                      JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
                      if (_oz_exception_1 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
                        JP.go.ipa.oz.lib.standard._IOException_if e = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_1;
// 97
                        JP.go.ipa.oz.lib.standard._String_if string$6 = (new JP.go.ipa.oz.lib.standard._String_cl("get IOException"));
                        
// 97
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                          try {
                            system.println (string$6);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          system.println (string$6);
                        }
                      } else throw _exception_1;
                    }
                    catch (JP.go.ipa.oz.system.ExClassNotFoundException _exception_e) {
                      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
                      
// 99
                      JP.go.ipa.oz.lib.standard._String_if string$7 = (new JP.go.ipa.oz.lib.standard._String_cl("get ClassNotFoundException"));
                      
// 99
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                        try {
                          system.println (string$7);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        system.println (string$7);
                      }
                    }
// 101
                    if (f != null) {{
// 102
                        JP.go.ipa.oz.lib.standard._String_if getName$val$24;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
                          try {
                            getName$val$24 = f.getName ();
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          getName$val$24 = f.getName ();
                        }
// 102
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                          try {
                            system.println (getName$val$24);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          system.println (getName$val$24);
                        }
                      }
                    }
                  }
                } else {
// 104
                  JP.go.ipa.oz.lib.standard._String_if string$8 = (new JP.go.ipa.oz.lib.standard._String_cl("remove"));
                  
// 104
                  boolean isequal$val$25;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subcommand)) {
                    try {
                      isequal$val$25 = subcommand.isequal (string$8);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    isequal$val$25 = subcommand.isequal (string$8);
                  }
// 104
                  if (isequal$val$25) {{
// 105
                      JP.go.ipa.oz.lib.standard._String_if topPackageName = null;
// 105
                      JP.go.ipa.oz.lang._Root_if at$val$26;
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                        try {
                          at$val$26 = args.at (2);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        at$val$26 = args.at (2);
                      }
// 105
                      topPackageName = (JP.go.ipa.oz.lib.standard._String_if) (at$val$26);
// 106
                      try {
// 107
                        JP.go.ipa.oz.lib.standard._LocalRepositoryManager_cl._static_remove (topPackageName);
                      }
                      catch (JP.go.ipa.oz.lang.OzException _exception_2) {
                        JP.go.ipa.oz.lang._Root_if _oz_exception_2 = _exception_2.getOzException ();
                        if (_oz_exception_2 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
                          JP.go.ipa.oz.lib.standard._IOException_if e = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_2;
// 109
                          JP.go.ipa.oz.lib.standard._String_if string$9 = (new JP.go.ipa.oz.lib.standard._String_cl("IOException"));
                          
// 109
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                            try {
                              system.println (string$9);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            system.println (string$9);
                          }
                        } else throw _exception_2;
                      }
                      catch (java.lang.SecurityException _exception_e) {
                        JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
                        
// 111
                        JP.go.ipa.oz.lib.standard._String_if string$10 = (new JP.go.ipa.oz.lib.standard._String_cl("SecurityException"));
                        
// 111
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                          try {
                            system.println (string$10);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          system.println (string$10);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        } else {
// 114
          JP.go.ipa.oz.lib.standard._String_if string$11 = (new JP.go.ipa.oz.lib.standard._String_cl("SearchPolicy"));
          
// 114
          boolean isequal$val$27;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
            try {
              isequal$val$27 = command.isequal (string$11);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            isequal$val$27 = command.isequal (string$11);
          }
// 114
          if (isequal$val$27) {{
// 115
              JP.go.ipa.oz.lib.standard._String_if subcommand = null;
// 115
              JP.go.ipa.oz.lang._Root_if at$val$28;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                try {
                  at$val$28 = args.at (1);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                at$val$28 = args.at (1);
              }
// 115
              subcommand = (JP.go.ipa.oz.lib.standard._String_if) (at$val$28);
// 116
              JP.go.ipa.oz.lib.standard._String_if string$12 = (new JP.go.ipa.oz.lib.standard._String_cl("getLeaveTo"));
              
// 116
              boolean isequal$val$29;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subcommand)) {
                try {
                  isequal$val$29 = subcommand.isequal (string$12);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                isequal$val$29 = subcommand.isequal (string$12);
              }
// 116
              if (isequal$val$29) {{
// 117
                  JP.go.ipa.oz.lib.standard._String_if targetsLeaveToWhom$val$30;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) CDA)) {
                    try {
                      targetsLeaveToWhom$val$30 = CDA.targetsLeaveToWhom ();
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    targetsLeaveToWhom$val$30 = CDA.targetsLeaveToWhom ();
                  }
// 117
                  JP.go.ipa.oz.lib.standard._String_if s = targetsLeaveToWhom$val$30;
// 118
                  if (s == null) {
// 118
                    s = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("null")));
                  }
// 119
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                    try {
                      system.println (s);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    system.println (s);
                  }
                }
              } else {
// 120
                JP.go.ipa.oz.lib.standard._String_if string$13 = (new JP.go.ipa.oz.lib.standard._String_cl("setLeaveTo"));
                
// 120
                boolean isequal$val$31;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subcommand)) {
                  try {
                    isequal$val$31 = subcommand.isequal (string$13);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  isequal$val$31 = subcommand.isequal (string$13);
                }
// 120
                if (isequal$val$31) {{
// 121
                    JP.go.ipa.oz.lib.standard._String_if s = null;
// 121
                    JP.go.ipa.oz.lang._Root_if at$val$32;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                      try {
                        at$val$32 = args.at (2);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      at$val$32 = args.at (2);
                    }
// 121
                    s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$32);
// 122
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) CDA)) {
                      try {
                        CDA.targetsSetLeaveTo (s);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      CDA.targetsSetLeaveTo (s);
                    }
                  }
                } else {
// 123
                  JP.go.ipa.oz.lib.standard._String_if string$14 = (new JP.go.ipa.oz.lib.standard._String_cl("getTargets"));
                  
// 123
                  boolean isequal$val$33;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subcommand)) {
                    try {
                      isequal$val$33 = subcommand.isequal (string$14);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    isequal$val$33 = subcommand.isequal (string$14);
                  }
// 123
                  if (isequal$val$33) {{
// 124
                      JP.go.ipa.oz.lib.standard._Array_if targetsTargets$val$34;
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) CDA)) {
                        try {
                          targetsTargets$val$34 = CDA.targetsTargets ();
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        targetsTargets$val$34 = CDA.targetsTargets ();
                      }
// 124
                      JP.go.ipa.oz.lib.standard._Array_if a = targetsTargets$val$34;
// 125
                      JP.go.ipa.oz.lib.standard._String_if asString$val$35;
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) a)) {
                        try {
                          asString$val$35 = a.asString ();
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        asString$val$35 = a.asString ();
                      }
// 125
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                        try {
                          system.println (asString$val$35);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        system.println (asString$val$35);
                      }
                    }
                  } else {
// 126
                    JP.go.ipa.oz.lib.standard._String_if string$15 = (new JP.go.ipa.oz.lib.standard._String_cl("removeTarget"));
                    
// 126
                    boolean isequal$val$36;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subcommand)) {
                      try {
                        isequal$val$36 = subcommand.isequal (string$15);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      isequal$val$36 = subcommand.isequal (string$15);
                    }
// 126
                    if (isequal$val$36) {{
// 127
                        JP.go.ipa.oz.lib.standard._String_if s = null;
// 127
                        JP.go.ipa.oz.lang._Root_if at$val$37;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                          try {
                            at$val$37 = args.at (2);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          at$val$37 = args.at (2);
                        }
// 127
                        s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$37);
// 128
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) CDA)) {
                          try {
                            CDA.targetsRemove (s);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          CDA.targetsRemove (s);
                        }
                      }
                    } else {
// 129
                      JP.go.ipa.oz.lib.standard._String_if string$16 = (new JP.go.ipa.oz.lib.standard._String_cl("setTarget"));
                      
// 129
                      boolean isequal$val$38;
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subcommand)) {
                        try {
                          isequal$val$38 = subcommand.isequal (string$16);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        isequal$val$38 = subcommand.isequal (string$16);
                      }
// 129
                      if (isequal$val$38) {{
// 130
                          JP.go.ipa.oz.lib.standard._String_if s = null;
// 130
                          JP.go.ipa.oz.lang._Root_if at$val$39;
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                            try {
                              at$val$39 = args.at (2);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            at$val$39 = args.at (2);
                          }
// 130
                          s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$39);
// 131
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
                            try {
                              debug.println (s);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            debug.println (s);
                          }
// 132
                          int targetsPut$val$40;
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) CDA)) {
                            try {
                              targetsPut$val$40 = CDA.targetsPut (s);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            targetsPut$val$40 = CDA.targetsPut (s);
                          }
// 132
                          int i = targetsPut$val$40;
// 133
                          JP.go.ipa.oz.lib.standard._Integer_if I = (JP.go.ipa.oz.lib.standard._Integer_cl) (new JP.go.ipa.oz.lib.standard._Integer_cl ())._new_breed (i);
// 133
                          JP.go.ipa.oz.lib.standard._String_if asString$val$41;
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) I)) {
                            try {
                              asString$val$41 = I.asString ();
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            asString$val$41 = I.asString ();
                          }
// 133
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
                            try {
                              debug.println (asString$val$41);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            debug.println (asString$val$41);
                          }
                        }
                      } else {
// 134
                        JP.go.ipa.oz.lib.standard._String_if string$17 = (new JP.go.ipa.oz.lib.standard._String_cl("setTargetAt"));
                        
// 134
                        boolean isequal$val$42;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subcommand)) {
                          try {
                            isequal$val$42 = subcommand.isequal (string$17);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          isequal$val$42 = subcommand.isequal (string$17);
                        }
// 134
                        if (isequal$val$42) {{
// 135
                            JP.go.ipa.oz.lib.standard._String_if s = null;
// 135
                            JP.go.ipa.oz.lang._Root_if at$val$43;
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                              try {
                                at$val$43 = args.at (2);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              at$val$43 = args.at (2);
                            }
// 135
                            s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$43);
// 136
                            JP.go.ipa.oz.lib.standard._String_if at = null;
// 136
                            JP.go.ipa.oz.lang._Root_if at$val$44;
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                              try {
                                at$val$44 = args.at (3);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              at$val$44 = args.at (3);
                            }
// 136
                            at = (JP.go.ipa.oz.lib.standard._String_if) (at$val$44);
// 136
                            int i = JP.go.ipa.oz.user.cda._AtoI_cl._static_atoi (at);
// 137
                            int targetsPutAt$val$45;
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) CDA)) {
                              try {
                                targetsPutAt$val$45 = CDA.targetsPutAt (i, s);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              targetsPutAt$val$45 = CDA.targetsPutAt (i, s);
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          } else {
// 139
            JP.go.ipa.oz.lib.standard._String_if string$18 = (new JP.go.ipa.oz.lib.standard._String_cl("Milloring"));
            
// 139
            boolean isequal$val$46;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
              try {
                isequal$val$46 = command.isequal (string$18);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              isequal$val$46 = command.isequal (string$18);
            }
// 139
            if (isequal$val$46) {{
// 140
                JP.go.ipa.oz.lib.standard._String_if subcommand = null;
// 140
                JP.go.ipa.oz.lang._Root_if at$val$47;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                  try {
                    at$val$47 = args.at (1);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  at$val$47 = args.at (1);
                }
// 140
                subcommand = (JP.go.ipa.oz.lib.standard._String_if) (at$val$47);
// 141
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
                  try {
                    debug.println (subcommand);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  debug.println (subcommand);
                }
// 142
                JP.go.ipa.oz.lib.standard._String_if string$19 = (new JP.go.ipa.oz.lib.standard._String_cl("setMillorServer"));
                
// 142
                boolean isequal$val$48;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subcommand)) {
                  try {
                    isequal$val$48 = subcommand.isequal (string$19);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  isequal$val$48 = subcommand.isequal (string$19);
                }
// 142
                if (isequal$val$48) {{
// 143
                    JP.go.ipa.oz.lib.standard._String_if s = null;
// 143
                    JP.go.ipa.oz.lang._Root_if at$val$49;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                      try {
                        at$val$49 = args.at (2);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      at$val$49 = args.at (2);
                    }
// 143
                    s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$49);
// 144
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) CDA)) {
                      try {
                        CDA.millorsAdd (s);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      CDA.millorsAdd (s);
                    }
                  }
                } else {
// 145
                  JP.go.ipa.oz.lib.standard._String_if string$20 = (new JP.go.ipa.oz.lib.standard._String_cl("setMillorClient"));
                  
// 145
                  boolean isequal$val$50;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subcommand)) {
                    try {
                      isequal$val$50 = subcommand.isequal (string$20);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    isequal$val$50 = subcommand.isequal (string$20);
                  }
// 145
                  if (isequal$val$50) {{
// 146
                      JP.go.ipa.oz.lib.standard._String_if s = null;
// 146
                      JP.go.ipa.oz.lang._Root_if at$val$51;
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                        try {
                          at$val$51 = args.at (2);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        at$val$51 = args.at (2);
                      }
// 146
                      s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$51);
// 147
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) CDA)) {
                        try {
                          CDA.millorsAdd (s);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        CDA.millorsAdd (s);
                      }
                    }
                  } else {
// 148
                    JP.go.ipa.oz.lib.standard._String_if string$21 = (new JP.go.ipa.oz.lib.standard._String_cl("setMillorPackage"));
                    
// 148
                    boolean isequal$val$52;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subcommand)) {
                      try {
                        isequal$val$52 = subcommand.isequal (string$21);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      isequal$val$52 = subcommand.isequal (string$21);
                    }
// 148
                    if (isequal$val$52) {{
// 149
                        JP.go.ipa.oz.lib.standard._String_if s = null;
// 149
                        JP.go.ipa.oz.lang._Root_if at$val$53;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                          try {
                            at$val$53 = args.at (2);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          at$val$53 = args.at (2);
                        }
// 149
                        s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$53);
// 150
                        JP.go.ipa.oz.lib.standard._String_if name = null;
// 150
                        JP.go.ipa.oz.lang._Root_if at$val$54;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                          try {
                            at$val$54 = args.at (3);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          at$val$54 = args.at (3);
                        }
// 150
                        name = (JP.go.ipa.oz.lib.standard._String_if) (at$val$54);
// 151
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) CDA)) {
                          try {
                            CDA.millorsAddTopPackageName (s, name);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          CDA.millorsAddTopPackageName (s, name);
                        }
                      }
                    } else {
// 152
                      JP.go.ipa.oz.lib.standard._String_if string$22 = (new JP.go.ipa.oz.lib.standard._String_cl("removeMillorPackage"));
                      
// 152
                      boolean isequal$val$55;
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subcommand)) {
                        try {
                          isequal$val$55 = subcommand.isequal (string$22);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        isequal$val$55 = subcommand.isequal (string$22);
                      }
// 152
                      if (isequal$val$55) {{
// 153
                          JP.go.ipa.oz.lib.standard._String_if s = null;
// 153
                          JP.go.ipa.oz.lang._Root_if at$val$56;
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                            try {
                              at$val$56 = args.at (2);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            at$val$56 = args.at (2);
                          }
// 153
                          s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$56);
// 154
                          JP.go.ipa.oz.lib.standard._String_if name = null;
// 154
                          JP.go.ipa.oz.lang._Root_if at$val$57;
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                            try {
                              at$val$57 = args.at (3);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            at$val$57 = args.at (3);
                          }
// 154
                          name = (JP.go.ipa.oz.lib.standard._String_if) (at$val$57);
// 155
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) CDA)) {
                            try {
                              CDA.millorsRemoveTopPackageName (s, name);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            CDA.millorsRemoveTopPackageName (s, name);
                          }
                        }
                      } else {
// 156
                        JP.go.ipa.oz.lib.standard._String_if string$23 = (new JP.go.ipa.oz.lib.standard._String_cl("getMillorPackage"));
                        
// 156
                        boolean isequal$val$58;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subcommand)) {
                          try {
                            isequal$val$58 = subcommand.isequal (string$23);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          isequal$val$58 = subcommand.isequal (string$23);
                        }
// 156
                        if (isequal$val$58) {{
// 157
                            JP.go.ipa.oz.lib.standard._String_if s = null;
// 157
                            JP.go.ipa.oz.lang._Root_if at$val$59;
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                              try {
                                at$val$59 = args.at (2);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              at$val$59 = args.at (2);
                            }
// 157
                            s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$59);
// 158
                            JP.go.ipa.oz.lib.standard._Dictionary_if millorsGet$val$60;
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) CDA)) {
                              try {
                                millorsGet$val$60 = CDA.millorsGet (s);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              millorsGet$val$60 = CDA.millorsGet (s);
                            }
// 158
                            JP.go.ipa.oz.lib.standard._Dictionary_if times = millorsGet$val$60;
// 159
                            JP.go.ipa.oz.lib.standard._String_if asString$val$61;
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) times)) {
                              try {
                                asString$val$61 = times.asString ();
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              asString$val$61 = times.asString ();
                            }
// 159
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                              try {
                                system.println (asString$val$61);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              system.println (asString$val$61);
                            }
                          }
                        } else {
// 160
                          JP.go.ipa.oz.lib.standard._String_if string$24 = (new JP.go.ipa.oz.lib.standard._String_cl("pollingStart"));
                          
// 160
                          boolean isequal$val$62;
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subcommand)) {
                            try {
                              isequal$val$62 = subcommand.isequal (string$24);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            isequal$val$62 = subcommand.isequal (string$24);
                          }
// 160
                          if (isequal$val$62) {{
// 161
                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) CDA)) {
                                try {
                                  CDA.millorsPollingStart ();
                                } finally {
                                  changeRunningToGreen ();
                                }
                              } else {
                                CDA.millorsPollingStart ();
                              }
                            }
                          } else {
// 162
                            JP.go.ipa.oz.lib.standard._String_if string$25 = (new JP.go.ipa.oz.lib.standard._String_cl("writingStart"));
                            
// 162
                            boolean isequal$val$63;
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subcommand)) {
                              try {
                                isequal$val$63 = subcommand.isequal (string$25);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              isequal$val$63 = subcommand.isequal (string$25);
                            }
// 162
                            if (isequal$val$63) {{
// 163
                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) CDA)) {
                                  try {
                                    CDA.millorsWriteStart ();
                                  } finally {
                                    changeRunningToGreen ();
                                  }
                                } else {
                                  CDA.millorsWriteStart ();
                                }
                              }
                            } else {
// 164
                              JP.go.ipa.oz.lib.standard._String_if string$26 = (new JP.go.ipa.oz.lib.standard._String_cl("WriteInValid"));
                              
// 164
                              boolean isequal$val$64;
                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subcommand)) {
                                try {
                                  isequal$val$64 = subcommand.isequal (string$26);
                                } finally {
                                  changeRunningToGreen ();
                                }
                              } else {
                                isequal$val$64 = subcommand.isequal (string$26);
                              }
// 164
                              if (isequal$val$64) {{
// 165
                                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) CDA)) {
                                    try {
                                      CDA.modeWriteInValid ();
                                    } finally {
                                      changeRunningToGreen ();
                                    }
                                  } else {
                                    CDA.modeWriteInValid ();
                                  }
                                }
                              } else {
// 166
                                JP.go.ipa.oz.lib.standard._String_if string$27 = (new JP.go.ipa.oz.lib.standard._String_cl("CopyOnWrite"));
                                
// 166
                                boolean isequal$val$65;
                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subcommand)) {
                                  try {
                                    isequal$val$65 = subcommand.isequal (string$27);
                                  } finally {
                                    changeRunningToGreen ();
                                  }
                                } else {
                                  isequal$val$65 = subcommand.isequal (string$27);
                                }
// 166
                                if (isequal$val$65) {{
// 167
                                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) CDA)) {
                                      try {
                                        CDA.modeCopyOnWrite ();
                                      } finally {
                                        changeRunningToGreen ();
                                      }
                                    } else {
                                      CDA.modeCopyOnWrite ();
                                    }
                                  }
                                } else {
// 168
                                  JP.go.ipa.oz.lib.standard._String_if string$28 = (new JP.go.ipa.oz.lib.standard._String_cl("setInterval"));
                                  
// 168
                                  boolean isequal$val$66;
                                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subcommand)) {
                                    try {
                                      isequal$val$66 = subcommand.isequal (string$28);
                                    } finally {
                                      changeRunningToGreen ();
                                    }
                                  } else {
                                    isequal$val$66 = subcommand.isequal (string$28);
                                  }
// 168
                                  if (isequal$val$66) {{
// 169
                                      JP.go.ipa.oz.lib.standard._String_if s = null;
// 169
                                      JP.go.ipa.oz.lang._Root_if at$val$67;
                                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                                        try {
                                          at$val$67 = args.at (2);
                                        } finally {
                                          changeRunningToGreen ();
                                        }
                                      } else {
                                        at$val$67 = args.at (2);
                                      }
// 169
                                      s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$67);
// 170
                                      int i = JP.go.ipa.oz.user.cda._AtoI_cl._static_atoi (s);
// 171
                                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) CDA)) {
                                        try {
                                          CDA.setInterval (i);
                                        } finally {
                                          changeRunningToGreen ();
                                        }
                                      } else {
                                        CDA.setInterval (i);
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
  
  protected void recursiveDir (JP.go.ipa.oz.lib.standard._String_if nowDirPath, JP.go.ipa.oz.lib.standard._System_if system) throws Exception  {
// 37
    JP.go.ipa.oz.lib.standard._File_if nowDir = null;
// 38
    nowDir = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (nowDirPath);
// 39
    JP.go.ipa.oz.lib.standard._Array_if nowNames = null;
// 40
    nowNames = nowDir.list ();
// 42
    int size$val$68;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nowNames)) {
      try {
        size$val$68 = nowNames.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$68 = nowNames.size ();
    }
// 42
    int size = size$val$68;
// 43
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < size)) break;
        
        /* body */ _loop_1: {
// 44
          JP.go.ipa.oz.lib.standard._String_if fileName = null, subPath = null;
// 44
          JP.go.ipa.oz.lib.standard._File_if subFile = null;
// 45
          JP.go.ipa.oz.lang._Root_if at$val$69;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nowNames)) {
            try {
              at$val$69 = nowNames.at (i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            at$val$69 = nowNames.at (i);
          }
// 45
          fileName = (JP.go.ipa.oz.lib.standard._String_if) (at$val$69);
// 46
          JP.go.ipa.oz.lib.standard._String_if concat$val$70;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nowDirPath)) {
            try {
              concat$val$70 = nowDirPath.concat (separatorString);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            concat$val$70 = nowDirPath.concat (separatorString);
          }
// 46
          subPath = concat$val$70;
// 47
          JP.go.ipa.oz.lib.standard._String_if concat$val$71;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subPath)) {
            try {
              concat$val$71 = subPath.concat (fileName);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            concat$val$71 = subPath.concat (fileName);
          }
// 47
          subPath = concat$val$71;
// 48
          subFile = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (subPath);
// 49
          if (subFile.isDirectory ()) {{
// 50
              recursiveDir (subPath, system);
            }
          } else {
// 51
            JP.go.ipa.oz.lib.standard._String_if string$29 = (new JP.go.ipa.oz.lib.standard._String_cl(".zip"));
            
// 51
            int lastIndexOf$val$72;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subPath)) {
              try {
                lastIndexOf$val$72 = subPath.lastIndexOf (string$29);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              lastIndexOf$val$72 = subPath.lastIndexOf (string$29);
            }
// 51
            if (lastIndexOf$val$72 > -1) {{
// 52
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                  try {
                    system.println (subPath);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  system.println (subPath);
                }
              }
            }
          }
        }
        /* iteration part */
// 43
        i++;
      }
    }
  }
  
  public _MaintenunceTool_cl () { super ("JP.go.ipa.oz.user.cda._MaintenunceTool_pcl"); }
  
  public _MaintenunceTool_cl (String proxy_id) { super (proxy_id); }
  
}


package JP.go.ipa.oz.user.lib_dist.name;

public class _MaintenunceTool_cl extends JP.go.ipa.oz.system.OzCell implements JP.go.ipa.oz.user.lib_dist.name._MaintenunceTool_if {
  static final boolean _global_ = true;
  JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_if singleNSTR;
  JP.go.ipa.oz.lib.standard._String_if singleNSTRGOL;
  JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_if currentNST;
  JP.go.ipa.oz.lib.standard._String_if delimitor;
  JP.go.ipa.oz.lib.standard._String_if currentNSTGOL;
  JP.go.ipa.oz.user.lib_dist.name._Path_if currentPath;
  boolean single;
  
  protected void initialize () throws Exception  {
// 18
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 18
    JP.go.ipa.oz.lib.standard._Array_if args = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (16);
// 19
    JP.go.ipa.oz.lib.standard._Array_if getArguments$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getArguments$val$0 = system.getArguments ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getArguments$val$0 = system.getArguments ();
    }
// 19
    args = getArguments$val$0;
// 20
    JP.go.ipa.oz.lib.standard._String_if s = null;
// 20
    JP.go.ipa.oz.lang._Root_if at$val$1;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
      try {
        at$val$1 = args.at (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$1 = args.at (0);
    }
// 20
    s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$1);
// 21
    JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl("single"));
    
// 21
    boolean isequal$val$2;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
      try {
        isequal$val$2 = s.isequal (string$0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$2 = s.isequal (string$0);
    }
// 21
    if (isequal$val$2) {{
// 22
        JP.go.ipa.oz.lang._Root_if at$val$3;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
          try {
            at$val$3 = args.at (1);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          at$val$3 = args.at (1);
        }
// 22
        singleNSTRGOL = (JP.go.ipa.oz.lib.standard._String_if) (at$val$3);
// 23
        singleNSTR = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_pcl (singleNSTRGOL);
// 24
        single = true;
      }
    } else {{
// 26
        JP.go.ipa.oz.lang._Root_if at$val$4;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
          try {
            at$val$4 = args.at (1);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          at$val$4 = args.at (1);
        }
// 26
        currentNSTGOL = (JP.go.ipa.oz.lib.standard._String_if) (at$val$4);
// 27
        currentNST = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_pcl (currentNSTGOL);
// 28
        single = false;
      }
    }
// 30
    currentPath = (JP.go.ipa.oz.user.lib_dist.name._Path_cl) (new JP.go.ipa.oz.user.lib_dist.name._Path_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl(":")));
// 32
    JP.go.ipa.oz.lang._Root_if at$val$5;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
      try {
        at$val$5 = args.at (2);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$5 = args.at (2);
    }
// 32
    delimitor = (JP.go.ipa.oz.lib.standard._String_if) (at$val$5);
  }
  
  protected void quiet () throws Exception  {
// 535
    flushCell ();
  }
  
  protected void go () throws Exception  {
// 36
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 36
    JP.go.ipa.oz.lib.standard._System_if debug = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 37
    JP.go.ipa.oz.lib.standard._Array_if args = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (16);
// 37
    JP.go.ipa.oz.lib.standard._Array_if getArguments$val$6;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getArguments$val$6 = system.getArguments ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getArguments$val$6 = system.getArguments ();
    }
// 37
    args = getArguments$val$6;
// 38
    JP.go.ipa.oz.lib.standard._String_if command = null;
// 38
    JP.go.ipa.oz.lang._Root_if at$val$7;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
      try {
        at$val$7 = args.at (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$7 = args.at (0);
    }
// 38
    command = (JP.go.ipa.oz.lib.standard._String_if) (at$val$7);
// 39
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.println (command);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.println (command);
    }
// 45
    JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl("currentNameServer"));
    
// 45
    boolean isequal$val$8;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
      try {
        isequal$val$8 = command.isequal (string$1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$8 = command.isequal (string$1);
    }
// 45
    if (isequal$val$8) {{
// 46
        if (single) {{
// 47
            JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl("MaintenunceTool Error. now single name server mode"));
            
// 47
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
              try {
                system.println (string$2);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              system.println (string$2);
            }
          }
        } else {{
// 49
            JP.go.ipa.oz.lang._Root_if at$val$9;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
              try {
                at$val$9 = args.at (1);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              at$val$9 = args.at (1);
            }
// 49
            currentNSTGOL = (JP.go.ipa.oz.lib.standard._String_if) (at$val$9);
// 50
            currentNST = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_pcl (currentNSTGOL);
// 51
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
              try {
                system.println (currentNSTGOL);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              system.println (currentNSTGOL);
            }
          }
        }
      }
    } else {
// 57
      JP.go.ipa.oz.lib.standard._String_if string$3 = (new JP.go.ipa.oz.lib.standard._String_cl("currentPath"));
      
// 57
      boolean isequal$val$10;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
        try {
          isequal$val$10 = command.isequal (string$3);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$10 = command.isequal (string$3);
      }
// 57
      if (isequal$val$10) {{
// 58
          JP.go.ipa.oz.lib.standard._String_if s = null;
// 58
          JP.go.ipa.oz.lang._Root_if at$val$11;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
            try {
              at$val$11 = args.at (1);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            at$val$11 = args.at (1);
          }
// 58
          s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$11);
// 59
          JP.go.ipa.oz.lib.standard._String_if substring$val$12;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
            try {
              substring$val$12 = s.substring (0, 1);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            substring$val$12 = s.substring (0, 1);
          }
// 59
          JP.go.ipa.oz.lib.standard._String_if top = substring$val$12;
// 60
          boolean isequal$val$13;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) top)) {
            try {
              isequal$val$13 = top.isequal (delimitor);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            isequal$val$13 = top.isequal (delimitor);
          }
// 60
          if (isequal$val$13) {
// 60
            currentPath = (JP.go.ipa.oz.user.lib_dist.name._Path_cl) (new JP.go.ipa.oz.user.lib_dist.name._Path_cl ())._new_breed (s);
          } else {
// 61
            JP.go.ipa.oz.user.lib_dist.name._Path_if makeLowerPath$val$14;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentPath)) {
              try {
                makeLowerPath$val$14 = currentPath.makeLowerPath (delimitor, s);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              makeLowerPath$val$14 = currentPath.makeLowerPath (delimitor, s);
            }
// 61
            currentPath = makeLowerPath$val$14;
          }
// 62
          JP.go.ipa.oz.lib.standard._String_if asString$val$15;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentPath)) {
            try {
              asString$val$15 = currentPath.asString ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            asString$val$15 = currentPath.asString ();
          }
// 62
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (asString$val$15);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (asString$val$15);
          }
        }
      } else {
// 69
        JP.go.ipa.oz.lib.standard._String_if string$4 = (new JP.go.ipa.oz.lib.standard._String_cl("debugPrint"));
        
// 69
        boolean isequal$val$16;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
          try {
            isequal$val$16 = command.isequal (string$4);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$16 = command.isequal (string$4);
        }
// 69
        if (isequal$val$16) {{
// 70
            if (single) {{
// 71
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) singleNSTR)) {
                  try {
                    singleNSTR.debugPrint ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  singleNSTR.debugPrint ();
                }
              }
            } else {{
// 73
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentNST)) {
                  try {
                    currentNST.debugPrint ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  currentNST.debugPrint ();
                }
              }
            }
          }
        } else {
// 77
          JP.go.ipa.oz.lib.standard._String_if string$5 = (new JP.go.ipa.oz.lib.standard._String_cl("debugPrintND"));
          
// 77
          boolean isequal$val$17;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
            try {
              isequal$val$17 = command.isequal (string$5);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            isequal$val$17 = command.isequal (string$5);
          }
// 77
          if (isequal$val$17) {{
// 78
              JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd = null;
// 79
              if (single) {{
// 80
                  JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if getDirectory$val$18;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) singleNSTR)) {
                    try {
                      getDirectory$val$18 = singleNSTR.getDirectory (currentPath);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    getDirectory$val$18 = singleNSTR.getDirectory (currentPath);
                  }
// 80
                  nd = getDirectory$val$18;
                }
              } else {{
// 82
                  try {
// 83
                    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if getDirectory$val$19;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentNST)) {
                      try {
                        getDirectory$val$19 = currentNST.getDirectory (currentPath);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      getDirectory$val$19 = currentNST.getDirectory (currentPath);
                    }
// 83
                    nd = getDirectory$val$19;
                  }
                  catch (JP.go.ipa.oz.system.ExException _exception_e) {
                    JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
                    
// 85
                    JP.go.ipa.oz.lib.standard._String_if string$6 = (new JP.go.ipa.oz.lib.standard._String_cl("here"));
                    
// 85
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
                      try {
                        debug.println (string$6);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      debug.println (string$6);
                    }
                  }
                }
              }
// 88
              boolean debugPrint$val$20;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nd)) {
                try {
                  debugPrint$val$20 = nd.debugPrint (currentPath);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                debugPrint$val$20 = nd.debugPrint (currentPath);
              }
// 88
              boolean tf = debugPrint$val$20;
// 89
              if (tf == false) {{
// 90
                  JP.go.ipa.oz.lib.standard._String_if string$7 = (new JP.go.ipa.oz.lib.standard._String_cl("debugPrintND Security Exception."));
                  
// 90
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
              }
            }
          } else {
// 96
            JP.go.ipa.oz.lib.standard._String_if string$8 = (new JP.go.ipa.oz.lib.standard._String_cl("debugPrintSM"));
            
// 96
            boolean isequal$val$21;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
              try {
                isequal$val$21 = command.isequal (string$8);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              isequal$val$21 = command.isequal (string$8);
            }
// 96
            if (isequal$val$21) {{
// 97
                JP.go.ipa.oz.user.lib_dist.name._SystemMapTransactionResource_if smtr = new JP.go.ipa.oz.user.lib_dist.name._SystemMapTransactionResource_pcl ((new JP.go.ipa.oz.lib.standard._String_cl("smtr")));
// 98
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
                  try {
                    smtr.debugPrint ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  smtr.debugPrint ();
                }
              }
            } else {
// 102
              JP.go.ipa.oz.lib.standard._String_if string$9 = (new JP.go.ipa.oz.lib.standard._String_cl("troubleControlStart"));
              
// 102
              boolean isequal$val$22;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
                try {
                  isequal$val$22 = command.isequal (string$9);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                isequal$val$22 = command.isequal (string$9);
              }
// 102
              if (isequal$val$22) {{
// 103
                  JP.go.ipa.oz.user.lib_dist.name._SystemMapTransactionResource_if smtr = new JP.go.ipa.oz.user.lib_dist.name._SystemMapTransactionResource_pcl ((new JP.go.ipa.oz.lib.standard._String_cl("smtr")));
// 104
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
                    try {
                      smtr.troubleControlPollingStart ();
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    smtr.troubleControlPollingStart ();
                  }
                }
              } else {
// 114
                JP.go.ipa.oz.lib.standard._String_if string$10 = (new JP.go.ipa.oz.lib.standard._String_cl("moveBranch"));
                
// 114
                boolean isequal$val$23;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
                  try {
                    isequal$val$23 = command.isequal (string$10);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  isequal$val$23 = command.isequal (string$10);
                }
// 114
                if (isequal$val$23) {{
// 115
                    if (single) {{
// 116
                        JP.go.ipa.oz.lib.standard._String_if string$11 = (new JP.go.ipa.oz.lib.standard._String_cl("MaintenunceTool Error. now single name server mode"));
                        
// 116
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                          try {
                            system.println (string$11);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          system.println (string$11);
                        }
                      }
                    } else {{
// 118
                        JP.go.ipa.oz.lib.standard._String_if s = null;
// 118
                        JP.go.ipa.oz.lang._Root_if at$val$24;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                          try {
                            at$val$24 = args.at (1);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          at$val$24 = args.at (1);
                        }
// 118
                        s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$24);
// 118
                        JP.go.ipa.oz.user.lib_dist.name._Path_if p = (JP.go.ipa.oz.user.lib_dist.name._Path_cl) (new JP.go.ipa.oz.user.lib_dist.name._Path_cl ())._new_breed (s);
// 119
                        JP.go.ipa.oz.lib.standard._String_if toGOL = null;
// 119
                        JP.go.ipa.oz.lang._Root_if at$val$25;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                          try {
                            at$val$25 = args.at (2);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          at$val$25 = args.at (2);
                        }
// 119
                        toGOL = (JP.go.ipa.oz.lib.standard._String_if) (at$val$25);
// 120
                        try {
// 121
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentNST)) {
                            try {
                              currentNST.moveBranch (p, toGOL);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            currentNST.moveBranch (p, toGOL);
                          }
                        }
                        catch (JP.go.ipa.oz.lang.OzException _exception_3) {
                          JP.go.ipa.oz.lang._Root_if _oz_exception_3 = _exception_3.getOzException ();
                          if (_oz_exception_3 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
                            JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_3;
// 125
                            JP.go.ipa.oz.lib.standard._String_if string$12 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! out of name space."));
                            
// 125
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                              try {
                                system.println (string$12);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              system.println (string$12);
                            }
                          } else if (_oz_exception_3 instanceof JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) {
                            JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) _oz_exception_3;
// 127
                            JP.go.ipa.oz.lib.standard._String_if string$13 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! path String wrong."));
                            
// 127
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                              try {
                                system.println (string$13);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              system.println (string$13);
                            }
                          } else throw _exception_3;
                        }
                      }
                    }
                  }
                } else {
// 137
                  JP.go.ipa.oz.lib.standard._String_if string$14 = (new JP.go.ipa.oz.lib.standard._String_cl("putDirectoryAsRoot"));
                  
// 137
                  boolean isequal$val$26;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
                    try {
                      isequal$val$26 = command.isequal (string$14);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    isequal$val$26 = command.isequal (string$14);
                  }
// 137
                  if (isequal$val$26) {{
// 138
                      JP.go.ipa.oz.lib.standard._String_if s = null;
// 138
                      JP.go.ipa.oz.lang._Root_if at$val$27;
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                        try {
                          at$val$27 = args.at (1);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        at$val$27 = args.at (1);
                      }
// 138
                      s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$27);
// 139
                      JP.go.ipa.oz.lib.standard._String_if concat$val$28;
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) delimitor)) {
                        try {
                          concat$val$28 = delimitor.concat (s);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        concat$val$28 = delimitor.concat (s);
                      }
// 139
                      s = concat$val$28;
// 139
                      JP.go.ipa.oz.user.lib_dist.name._Path_if p = (JP.go.ipa.oz.user.lib_dist.name._Path_cl) (new JP.go.ipa.oz.user.lib_dist.name._Path_cl ())._new_breed (s);
// 140
                      if (single) {{
// 142
                          try {
// 143
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) singleNSTR)) {
                              try {
                                singleNSTR.putDirectoryAsBranch (p);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              singleNSTR.putDirectoryAsBranch (p);
                            }
                          }
                          catch (JP.go.ipa.oz.lang.OzException _exception_4) {
                            JP.go.ipa.oz.lang._Root_if _oz_exception_4 = _exception_4.getOzException ();
                            if (_oz_exception_4 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
                              JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_4;
// 145
                              JP.go.ipa.oz.lib.standard._String_if string$15 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! not root path."));
                              
// 145
                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                try {
                                  system.println (string$15);
                                } finally {
                                  changeRunningToGreen ();
                                }
                              } else {
                                system.println (string$15);
                              }
                            } else if (_oz_exception_4 instanceof JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) {
                              JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) _oz_exception_4;
// 147
                              JP.go.ipa.oz.lib.standard._String_if string$16 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! path String wrong."));
                              
// 147
                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                try {
                                  system.println (string$16);
                                } finally {
                                  changeRunningToGreen ();
                                }
                              } else {
                                system.println (string$16);
                              }
                            } else throw _exception_4;
                          }
                        }
                      } else {{
// 150
                          try {
// 151
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentNST)) {
                              try {
                                currentNST.putDirectoryAsBranch (p);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              currentNST.putDirectoryAsBranch (p);
                            }
                          }
                          catch (JP.go.ipa.oz.lang.OzException _exception_5) {
                            JP.go.ipa.oz.lang._Root_if _oz_exception_5 = _exception_5.getOzException ();
                            if (_oz_exception_5 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
                              JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_5;
// 153
                              JP.go.ipa.oz.lib.standard._String_if string$17 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! not root path."));
                              
// 153
                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                try {
                                  system.println (string$17);
                                } finally {
                                  changeRunningToGreen ();
                                }
                              } else {
                                system.println (string$17);
                              }
                            } else if (_oz_exception_5 instanceof JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) {
                              JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) _oz_exception_5;
// 155
                              JP.go.ipa.oz.lib.standard._String_if string$18 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! path String wrong."));
                              
// 155
                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                try {
                                  system.println (string$18);
                                } finally {
                                  changeRunningToGreen ();
                                }
                              } else {
                                system.println (string$18);
                              }
                            } else throw _exception_5;
                          }
                        }
                      }
                    }
                  } else {
// 163
                    JP.go.ipa.oz.lib.standard._String_if string$19 = (new JP.go.ipa.oz.lib.standard._String_cl("unBranched"));
                    
// 163
                    boolean isequal$val$29;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
                      try {
                        isequal$val$29 = command.isequal (string$19);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      isequal$val$29 = command.isequal (string$19);
                    }
// 163
                    if (isequal$val$29) {{
// 164
                        JP.go.ipa.oz.lib.standard._String_if s = null;
// 164
                        JP.go.ipa.oz.lang._Root_if at$val$30;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                          try {
                            at$val$30 = args.at (1);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          at$val$30 = args.at (1);
                        }
// 164
                        s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$30);
// 164
                        JP.go.ipa.oz.user.lib_dist.name._Path_if p = (JP.go.ipa.oz.user.lib_dist.name._Path_cl) (new JP.go.ipa.oz.user.lib_dist.name._Path_cl ())._new_breed (s);
// 165
                        if (single) {{
// 166
                            JP.go.ipa.oz.lib.standard._String_if string$20 = (new JP.go.ipa.oz.lib.standard._String_cl("MaintenunceTool Error. now single name server mode"));
                            
// 166
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                              try {
                                system.println (string$20);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              system.println (string$20);
                            }
                          }
                        } else {{
// 168
                            try {
// 169
                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentNST)) {
                                try {
                                  currentNST.unBranched (p);
                                } finally {
                                  changeRunningToGreen ();
                                }
                              } else {
                                currentNST.unBranched (p);
                              }
                            }
                            catch (JP.go.ipa.oz.lang.OzException _exception_6) {
                              JP.go.ipa.oz.lang._Root_if _oz_exception_6 = _exception_6.getOzException ();
                              if (_oz_exception_6 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
                                JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_6;
// 171
                                JP.go.ipa.oz.lib.standard._String_if string$21 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! can not unbranched."));
                                
// 171
                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                  try {
                                    system.println (string$21);
                                  } finally {
                                    changeRunningToGreen ();
                                  }
                                } else {
                                  system.println (string$21);
                                }
                              } else throw _exception_6;
                            }
                          }
                        }
                      }
                    } else {
// 182
                      JP.go.ipa.oz.lib.standard._String_if string$22 = (new JP.go.ipa.oz.lib.standard._String_cl("putDirectoryAsMapping"));
                      
// 182
                      boolean isequal$val$31;
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
                        try {
                          isequal$val$31 = command.isequal (string$22);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        isequal$val$31 = command.isequal (string$22);
                      }
// 182
                      if (isequal$val$31) {{
// 183
                          JP.go.ipa.oz.lib.standard._String_if s = null;
// 183
                          JP.go.ipa.oz.lang._Root_if at$val$32;
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                            try {
                              at$val$32 = args.at (1);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            at$val$32 = args.at (1);
                          }
// 183
                          s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$32);
// 183
                          JP.go.ipa.oz.user.lib_dist.name._Path_if path = (JP.go.ipa.oz.user.lib_dist.name._Path_cl) (new JP.go.ipa.oz.user.lib_dist.name._Path_cl ())._new_breed (s);
// 184
                          JP.go.ipa.oz.lang._Root_if at$val$33;
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                            try {
                              at$val$33 = args.at (2);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            at$val$33 = args.at (2);
                          }
// 184
                          s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$33);
// 184
                          JP.go.ipa.oz.user.lib_dist.name._Path_if to = (JP.go.ipa.oz.user.lib_dist.name._Path_cl) (new JP.go.ipa.oz.user.lib_dist.name._Path_cl ())._new_breed (s);
// 185
                          JP.go.ipa.oz.lib.standard._String_if serverGOL = null;
// 185
                          JP.go.ipa.oz.lang._Root_if at$val$34;
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                            try {
                              at$val$34 = args.at (3);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            at$val$34 = args.at (3);
                          }
// 185
                          serverGOL = (JP.go.ipa.oz.lib.standard._String_if) (at$val$34);
// 186
                          if (single) {{
// 187
                              JP.go.ipa.oz.lib.standard._String_if string$23 = (new JP.go.ipa.oz.lib.standard._String_cl("MaintenunceTool Error. now single name server mode"));
                              
// 187
                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                try {
                                  system.println (string$23);
                                } finally {
                                  changeRunningToGreen ();
                                }
                              } else {
                                system.println (string$23);
                              }
                            }
                          } else {{
// 189
                              try {
// 190
                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentNST)) {
                                  try {
                                    currentNST.putDirectoryAsMapping (path, to, serverGOL);
                                  } finally {
                                    changeRunningToGreen ();
                                  }
                                } else {
                                  currentNST.putDirectoryAsMapping (path, to, serverGOL);
                                }
                              }
                              catch (JP.go.ipa.oz.lang.OzException _exception_7) {
                                JP.go.ipa.oz.lang._Root_if _oz_exception_7 = _exception_7.getOzException ();
                                if (_oz_exception_7 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
                                  JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_7;
// 192
                                  JP.go.ipa.oz.lib.standard._String_if string$24 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! mapping fail."));
                                  
// 192
                                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                    try {
                                      system.println (string$24);
                                    } finally {
                                      changeRunningToGreen ();
                                    }
                                  } else {
                                    system.println (string$24);
                                  }
                                } else throw _exception_7;
                              }
                            }
                          }
                        }
                      } else {
// 201
                        JP.go.ipa.oz.lib.standard._String_if string$25 = (new JP.go.ipa.oz.lib.standard._String_cl("addNameServer"));
                        
// 201
                        boolean isequal$val$35;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
                          try {
                            isequal$val$35 = command.isequal (string$25);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          isequal$val$35 = command.isequal (string$25);
                        }
// 201
                        if (isequal$val$35) {{
// 202
                            if (single) {{
// 203
                                JP.go.ipa.oz.lib.standard._String_if string$26 = (new JP.go.ipa.oz.lib.standard._String_cl("MaintenunceTool Error. now single name server mode"));
                                
// 203
                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                  try {
                                    system.println (string$26);
                                  } finally {
                                    changeRunningToGreen ();
                                  }
                                } else {
                                  system.println (string$26);
                                }
                              }
                            } else {{
// 205
                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentNST)) {
                                  try {
                                    currentNST.addNameServer ();
                                  } finally {
                                    changeRunningToGreen ();
                                  }
                                } else {
                                  currentNST.addNameServer ();
                                }
                              }
                            }
                          }
                        } else {
// 211
                          JP.go.ipa.oz.lib.standard._String_if string$27 = (new JP.go.ipa.oz.lib.standard._String_cl("removeNameServer"));
                          
// 211
                          boolean isequal$val$36;
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
                            try {
                              isequal$val$36 = command.isequal (string$27);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            isequal$val$36 = command.isequal (string$27);
                          }
// 211
                          if (isequal$val$36) {{
// 212
                              if (single) {{
// 213
                                  JP.go.ipa.oz.lib.standard._String_if string$28 = (new JP.go.ipa.oz.lib.standard._String_cl("MaintenunceTool Error. now single name server mode"));
                                  
// 213
                                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                    try {
                                      system.println (string$28);
                                    } finally {
                                      changeRunningToGreen ();
                                    }
                                  } else {
                                    system.println (string$28);
                                  }
                                }
                              } else {{
// 215
                                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentNST)) {
                                    try {
                                      currentNST.removeNameServer ();
                                    } finally {
                                      changeRunningToGreen ();
                                    }
                                  } else {
                                    currentNST.removeNameServer ();
                                  }
                                }
                              }
                            }
                          } else {
// 224
                            JP.go.ipa.oz.lib.standard._String_if string$29 = (new JP.go.ipa.oz.lib.standard._String_cl("putEntry"));
                            
// 224
                            boolean isequal$val$37;
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
                              try {
                                isequal$val$37 = command.isequal (string$29);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              isequal$val$37 = command.isequal (string$29);
                            }
// 224
                            if (isequal$val$37) {{
// 225
                                JP.go.ipa.oz.lib.standard._String_if s = null;
// 225
                                JP.go.ipa.oz.lang._Root_if at$val$38;
                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                                  try {
                                    at$val$38 = args.at (1);
                                  } finally {
                                    changeRunningToGreen ();
                                  }
                                } else {
                                  at$val$38 = args.at (1);
                                }
// 225
                                s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$38);
// 226
                                JP.go.ipa.oz.user.lib_dist.name._Path_if makeLowerPath$val$39;
                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentPath)) {
                                  try {
                                    makeLowerPath$val$39 = currentPath.makeLowerPath (delimitor, s);
                                  } finally {
                                    changeRunningToGreen ();
                                  }
                                } else {
                                  makeLowerPath$val$39 = currentPath.makeLowerPath (delimitor, s);
                                }
// 226
                                JP.go.ipa.oz.user.lib_dist.name._Path_if p = makeLowerPath$val$39;
// 228
                                JP.go.ipa.oz.lang._Root_if at$val$40;
                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                                  try {
                                    at$val$40 = args.at (2);
                                  } finally {
                                    changeRunningToGreen ();
                                  }
                                } else {
                                  at$val$40 = args.at (2);
                                }
// 228
                                s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$40);
// 229
                                if (single) {{
// 230
                                    try {
// 231
                                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) singleNSTR)) {
                                        try {
                                          singleNSTR.putEntry (p, s);
                                        } finally {
                                          changeRunningToGreen ();
                                        }
                                      } else {
                                        singleNSTR.putEntry (p, s);
                                      }
                                    }
                                    catch (JP.go.ipa.oz.lang.OzException _exception_8) {
                                      JP.go.ipa.oz.lang._Root_if _oz_exception_8 = _exception_8.getOzException ();
                                      if (_oz_exception_8 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
                                        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_8;
// 233
                                        JP.go.ipa.oz.lib.standard._String_if string$30 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! out of name space."));
                                        
// 233
                                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                          try {
                                            system.println (string$30);
                                          } finally {
                                            changeRunningToGreen ();
                                          }
                                        } else {
                                          system.println (string$30);
                                        }
                                      } else if (_oz_exception_8 instanceof JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) {
                                        JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) _oz_exception_8;
// 235
                                        JP.go.ipa.oz.lib.standard._String_if string$31 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! path String wrong."));
                                        
// 235
                                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                          try {
                                            system.println (string$31);
                                          } finally {
                                            changeRunningToGreen ();
                                          }
                                        } else {
                                          system.println (string$31);
                                        }
                                      } else throw _exception_8;
                                    }
                                  }
                                } else {{
// 238
                                    try {
// 239
                                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentNST)) {
                                        try {
                                          currentNST.putEntry (p, s);
                                        } finally {
                                          changeRunningToGreen ();
                                        }
                                      } else {
                                        currentNST.putEntry (p, s);
                                      }
                                    }
                                    catch (JP.go.ipa.oz.lang.OzException _exception_9) {
                                      JP.go.ipa.oz.lang._Root_if _oz_exception_9 = _exception_9.getOzException ();
                                      if (_oz_exception_9 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
                                        JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_9;
// 241
                                        JP.go.ipa.oz.lib.standard._String_if string$32 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! out of name space."));
                                        
// 241
                                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                          try {
                                            system.println (string$32);
                                          } finally {
                                            changeRunningToGreen ();
                                          }
                                        } else {
                                          system.println (string$32);
                                        }
                                      } else if (_oz_exception_9 instanceof JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) {
                                        JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) _oz_exception_9;
// 243
                                        JP.go.ipa.oz.lib.standard._String_if string$33 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! path String wrong."));
                                        
// 243
                                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                          try {
                                            system.println (string$33);
                                          } finally {
                                            changeRunningToGreen ();
                                          }
                                        } else {
                                          system.println (string$33);
                                        }
                                      } else throw _exception_9;
                                    }
                                  }
                                }
                              }
                            } else {
// 251
                              JP.go.ipa.oz.lib.standard._String_if string$34 = (new JP.go.ipa.oz.lib.standard._String_cl("containEntry"));
                              
// 251
                              boolean isequal$val$41;
                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
                                try {
                                  isequal$val$41 = command.isequal (string$34);
                                } finally {
                                  changeRunningToGreen ();
                                }
                              } else {
                                isequal$val$41 = command.isequal (string$34);
                              }
// 251
                              if (isequal$val$41) {{
// 252
                                  JP.go.ipa.oz.lib.standard._String_if s = null;
// 252
                                  JP.go.ipa.oz.lang._Root_if at$val$42;
                                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                                    try {
                                      at$val$42 = args.at (1);
                                    } finally {
                                      changeRunningToGreen ();
                                    }
                                  } else {
                                    at$val$42 = args.at (1);
                                  }
// 252
                                  s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$42);
// 253
                                  JP.go.ipa.oz.user.lib_dist.name._Path_if makeLowerPath$val$43;
                                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentPath)) {
                                    try {
                                      makeLowerPath$val$43 = currentPath.makeLowerPath (delimitor, s);
                                    } finally {
                                      changeRunningToGreen ();
                                    }
                                  } else {
                                    makeLowerPath$val$43 = currentPath.makeLowerPath (delimitor, s);
                                  }
// 253
                                  JP.go.ipa.oz.user.lib_dist.name._Path_if p = makeLowerPath$val$43;
// 254
                                  if (single) {{
// 255
                                      try {
// 256
                                        boolean containEntry$val$44;
                                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) singleNSTR)) {
                                          try {
                                            containEntry$val$44 = singleNSTR.containEntry (p);
                                          } finally {
                                            changeRunningToGreen ();
                                          }
                                        } else {
                                          containEntry$val$44 = singleNSTR.containEntry (p);
                                        }
// 256
                                        boolean tf = containEntry$val$44;
// 257
                                        if (tf) {
// 257
                                          JP.go.ipa.oz.lib.standard._String_if string$35 = (new JP.go.ipa.oz.lib.standard._String_cl("  true"));
                                          
// 257
                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                            try {
                                              system.println (string$35);
                                            } finally {
                                              changeRunningToGreen ();
                                            }
                                          } else {
                                            system.println (string$35);
                                          }
                                        } else {
// 258
                                          JP.go.ipa.oz.lib.standard._String_if string$36 = (new JP.go.ipa.oz.lib.standard._String_cl("  false"));
                                          
// 258
                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                            try {
                                              system.println (string$36);
                                            } finally {
                                              changeRunningToGreen ();
                                            }
                                          } else {
                                            system.println (string$36);
                                          }
                                        }
                                      }
                                      catch (JP.go.ipa.oz.lang.OzException _exception_10) {
                                        JP.go.ipa.oz.lang._Root_if _oz_exception_10 = _exception_10.getOzException ();
                                        if (_oz_exception_10 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
                                          JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_10;
// 260
                                          JP.go.ipa.oz.lib.standard._String_if string$37 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! out of name space."));
                                          
// 260
                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                            try {
                                              system.println (string$37);
                                            } finally {
                                              changeRunningToGreen ();
                                            }
                                          } else {
                                            system.println (string$37);
                                          }
                                        } else if (_oz_exception_10 instanceof JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) {
                                          JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) _oz_exception_10;
// 262
                                          JP.go.ipa.oz.lib.standard._String_if string$38 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! path String wrong."));
                                          
// 262
                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                            try {
                                              system.println (string$38);
                                            } finally {
                                              changeRunningToGreen ();
                                            }
                                          } else {
                                            system.println (string$38);
                                          }
                                        } else throw _exception_10;
                                      }
                                    }
                                  } else {{
// 265
                                      try {
// 266
                                        boolean containEntry$val$45;
                                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentNST)) {
                                          try {
                                            containEntry$val$45 = currentNST.containEntry (p);
                                          } finally {
                                            changeRunningToGreen ();
                                          }
                                        } else {
                                          containEntry$val$45 = currentNST.containEntry (p);
                                        }
// 266
                                        boolean tf = containEntry$val$45;
// 267
                                        if (tf) {
// 267
                                          JP.go.ipa.oz.lib.standard._String_if string$39 = (new JP.go.ipa.oz.lib.standard._String_cl("  true"));
                                          
// 267
                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                            try {
                                              system.println (string$39);
                                            } finally {
                                              changeRunningToGreen ();
                                            }
                                          } else {
                                            system.println (string$39);
                                          }
                                        } else {
// 268
                                          JP.go.ipa.oz.lib.standard._String_if string$40 = (new JP.go.ipa.oz.lib.standard._String_cl("  false"));
                                          
// 268
                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                            try {
                                              system.println (string$40);
                                            } finally {
                                              changeRunningToGreen ();
                                            }
                                          } else {
                                            system.println (string$40);
                                          }
                                        }
                                      }
                                      catch (JP.go.ipa.oz.lang.OzException _exception_11) {
                                        JP.go.ipa.oz.lang._Root_if _oz_exception_11 = _exception_11.getOzException ();
                                        if (_oz_exception_11 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
                                          JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_11;
// 270
                                          JP.go.ipa.oz.lib.standard._String_if string$41 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! out of name space."));
                                          
// 270
                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                            try {
                                              system.println (string$41);
                                            } finally {
                                              changeRunningToGreen ();
                                            }
                                          } else {
                                            system.println (string$41);
                                          }
                                        } else if (_oz_exception_11 instanceof JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) {
                                          JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) _oz_exception_11;
// 272
                                          JP.go.ipa.oz.lib.standard._String_if string$42 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! path String wrong."));
                                          
// 272
                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                            try {
                                              system.println (string$42);
                                            } finally {
                                              changeRunningToGreen ();
                                            }
                                          } else {
                                            system.println (string$42);
                                          }
                                        } else throw _exception_11;
                                      }
                                    }
                                  }
                                }
                              } else {
// 279
                                JP.go.ipa.oz.lib.standard._String_if string$43 = (new JP.go.ipa.oz.lib.standard._String_cl("getEntry"));
                                
// 279
                                boolean isequal$val$46;
                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
                                  try {
                                    isequal$val$46 = command.isequal (string$43);
                                  } finally {
                                    changeRunningToGreen ();
                                  }
                                } else {
                                  isequal$val$46 = command.isequal (string$43);
                                }
// 279
                                if (isequal$val$46) {{
// 280
                                    JP.go.ipa.oz.lib.standard._String_if s = null;
// 280
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
// 280
                                    s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$47);
// 281
                                    JP.go.ipa.oz.user.lib_dist.name._Path_if makeLowerPath$val$48;
                                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentPath)) {
                                      try {
                                        makeLowerPath$val$48 = currentPath.makeLowerPath (delimitor, s);
                                      } finally {
                                        changeRunningToGreen ();
                                      }
                                    } else {
                                      makeLowerPath$val$48 = currentPath.makeLowerPath (delimitor, s);
                                    }
// 281
                                    JP.go.ipa.oz.user.lib_dist.name._Path_if p = makeLowerPath$val$48;
// 282
                                    if (single) {{
// 283
                                        try {
// 284
                                          JP.go.ipa.oz.lang._Root_if getEntry$val$49;
                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) singleNSTR)) {
                                            try {
                                              getEntry$val$49 = singleNSTR.getEntry (p);
                                            } finally {
                                              changeRunningToGreen ();
                                            }
                                          } else {
                                            getEntry$val$49 = singleNSTR.getEntry (p);
                                          }
// 284
                                          JP.go.ipa.oz.lang._Root_if r = getEntry$val$49;
// 285
                                          JP.go.ipa.oz.lib.standard._String_if s$1 = null;
// 285
                                          s$1 = (JP.go.ipa.oz.lib.standard._String_if) (r);
// 285
                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                            try {
                                              system.println (s$1);
                                            } finally {
                                              changeRunningToGreen ();
                                            }
                                          } else {
                                            system.println (s$1);
                                          }
                                        }
                                        catch (JP.go.ipa.oz.lang.OzException _exception_12) {
                                          JP.go.ipa.oz.lang._Root_if _oz_exception_12 = _exception_12.getOzException ();
                                          if (_oz_exception_12 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
                                            JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_12;
// 287
                                            JP.go.ipa.oz.lib.standard._String_if string$44 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! out of name space."));
                                            
// 287
                                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                              try {
                                                system.println (string$44);
                                              } finally {
                                                changeRunningToGreen ();
                                              }
                                            } else {
                                              system.println (string$44);
                                            }
                                          } else if (_oz_exception_12 instanceof JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) {
                                            JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) _oz_exception_12;
// 289
                                            JP.go.ipa.oz.lib.standard._String_if string$45 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! path String wrong."));
                                            
// 289
                                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                              try {
                                                system.println (string$45);
                                              } finally {
                                                changeRunningToGreen ();
                                              }
                                            } else {
                                              system.println (string$45);
                                            }
                                          } else throw _exception_12;
                                        }
                                      }
                                    } else {{
// 292
                                        try {
// 293
                                          JP.go.ipa.oz.lang._Root_if getEntry$val$50;
                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentNST)) {
                                            try {
                                              getEntry$val$50 = currentNST.getEntry (p);
                                            } finally {
                                              changeRunningToGreen ();
                                            }
                                          } else {
                                            getEntry$val$50 = currentNST.getEntry (p);
                                          }
// 293
                                          JP.go.ipa.oz.lang._Root_if r = getEntry$val$50;
// 294
                                          JP.go.ipa.oz.lib.standard._String_if s$2 = null;
// 294
                                          s$2 = (JP.go.ipa.oz.lib.standard._String_if) (r);
// 294
                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                            try {
                                              system.println (s$2);
                                            } finally {
                                              changeRunningToGreen ();
                                            }
                                          } else {
                                            system.println (s$2);
                                          }
                                        }
                                        catch (JP.go.ipa.oz.lang.OzException _exception_13) {
                                          JP.go.ipa.oz.lang._Root_if _oz_exception_13 = _exception_13.getOzException ();
                                          if (_oz_exception_13 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
                                            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_13;
// 296
                                            JP.go.ipa.oz.lib.standard._String_if string$46 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! out of name space."));
                                            
// 296
                                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                              try {
                                                system.println (string$46);
                                              } finally {
                                                changeRunningToGreen ();
                                              }
                                            } else {
                                              system.println (string$46);
                                            }
                                          } else if (_oz_exception_13 instanceof JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) {
                                            JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) _oz_exception_13;
// 298
                                            JP.go.ipa.oz.lib.standard._String_if string$47 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! path String wrong."));
                                            
// 298
                                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                              try {
                                                system.println (string$47);
                                              } finally {
                                                changeRunningToGreen ();
                                              }
                                            } else {
                                              system.println (string$47);
                                            }
                                          } else throw _exception_13;
                                        }
                                      }
                                    }
                                  }
                                } else {
// 305
                                  JP.go.ipa.oz.lib.standard._String_if string$48 = (new JP.go.ipa.oz.lib.standard._String_cl("removeEntry"));
                                  
// 305
                                  boolean isequal$val$51;
                                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
                                    try {
                                      isequal$val$51 = command.isequal (string$48);
                                    } finally {
                                      changeRunningToGreen ();
                                    }
                                  } else {
                                    isequal$val$51 = command.isequal (string$48);
                                  }
// 305
                                  if (isequal$val$51) {{
// 306
                                      JP.go.ipa.oz.lib.standard._String_if s = null;
// 306
                                      JP.go.ipa.oz.lang._Root_if at$val$52;
                                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                                        try {
                                          at$val$52 = args.at (1);
                                        } finally {
                                          changeRunningToGreen ();
                                        }
                                      } else {
                                        at$val$52 = args.at (1);
                                      }
// 306
                                      s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$52);
// 307
                                      JP.go.ipa.oz.user.lib_dist.name._Path_if makeLowerPath$val$53;
                                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentPath)) {
                                        try {
                                          makeLowerPath$val$53 = currentPath.makeLowerPath (delimitor, s);
                                        } finally {
                                          changeRunningToGreen ();
                                        }
                                      } else {
                                        makeLowerPath$val$53 = currentPath.makeLowerPath (delimitor, s);
                                      }
// 307
                                      JP.go.ipa.oz.user.lib_dist.name._Path_if p = makeLowerPath$val$53;
// 308
                                      if (single) {{
// 309
                                          try {
// 310
                                            JP.go.ipa.oz.lang._Root_if removeEntry$val$54;
                                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) singleNSTR)) {
                                              try {
                                                removeEntry$val$54 = singleNSTR.removeEntry (p);
                                              } finally {
                                                changeRunningToGreen ();
                                              }
                                            } else {
                                              removeEntry$val$54 = singleNSTR.removeEntry (p);
                                            }
// 310
                                            JP.go.ipa.oz.lang._Root_if r = removeEntry$val$54;
                                          }
                                          catch (JP.go.ipa.oz.lang.OzException _exception_14) {
                                            JP.go.ipa.oz.lang._Root_if _oz_exception_14 = _exception_14.getOzException ();
                                            if (_oz_exception_14 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
                                              JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_14;
// 312
                                              JP.go.ipa.oz.lib.standard._String_if string$49 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! out of name space."));
                                              
// 312
                                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                try {
                                                  system.println (string$49);
                                                } finally {
                                                  changeRunningToGreen ();
                                                }
                                              } else {
                                                system.println (string$49);
                                              }
                                            } else if (_oz_exception_14 instanceof JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) {
                                              JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) _oz_exception_14;
// 314
                                              JP.go.ipa.oz.lib.standard._String_if string$50 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! path String wrong."));
                                              
// 314
                                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                try {
                                                  system.println (string$50);
                                                } finally {
                                                  changeRunningToGreen ();
                                                }
                                              } else {
                                                system.println (string$50);
                                              }
                                            } else throw _exception_14;
                                          }
                                        }
                                      } else {{
// 317
                                          try {
// 318
                                            JP.go.ipa.oz.lang._Root_if removeEntry$val$55;
                                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentNST)) {
                                              try {
                                                removeEntry$val$55 = currentNST.removeEntry (p);
                                              } finally {
                                                changeRunningToGreen ();
                                              }
                                            } else {
                                              removeEntry$val$55 = currentNST.removeEntry (p);
                                            }
// 318
                                            JP.go.ipa.oz.lang._Root_if r = removeEntry$val$55;
                                          }
                                          catch (JP.go.ipa.oz.lang.OzException _exception_15) {
                                            JP.go.ipa.oz.lang._Root_if _oz_exception_15 = _exception_15.getOzException ();
                                            if (_oz_exception_15 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
                                              JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_15;
// 320
                                              JP.go.ipa.oz.lib.standard._String_if string$51 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! out of name space."));
                                              
// 320
                                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                try {
                                                  system.println (string$51);
                                                } finally {
                                                  changeRunningToGreen ();
                                                }
                                              } else {
                                                system.println (string$51);
                                              }
                                            } else if (_oz_exception_15 instanceof JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) {
                                              JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) _oz_exception_15;
// 322
                                              JP.go.ipa.oz.lib.standard._String_if string$52 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! path String wrong."));
                                              
// 322
                                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                try {
                                                  system.println (string$52);
                                                } finally {
                                                  changeRunningToGreen ();
                                                }
                                              } else {
                                                system.println (string$52);
                                              }
                                            } else throw _exception_15;
                                          }
                                        }
                                      }
                                    }
                                  } else {
// 331
                                    JP.go.ipa.oz.lib.standard._String_if string$53 = (new JP.go.ipa.oz.lib.standard._String_cl("renameEntry"));
                                    
// 331
                                    boolean isequal$val$56;
                                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
                                      try {
                                        isequal$val$56 = command.isequal (string$53);
                                      } finally {
                                        changeRunningToGreen ();
                                      }
                                    } else {
                                      isequal$val$56 = command.isequal (string$53);
                                    }
// 331
                                    if (isequal$val$56) {{
// 332
                                        JP.go.ipa.oz.lib.standard._String_if s = null;
// 332
                                        JP.go.ipa.oz.lang._Root_if at$val$57;
                                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                                          try {
                                            at$val$57 = args.at (1);
                                          } finally {
                                            changeRunningToGreen ();
                                          }
                                        } else {
                                          at$val$57 = args.at (1);
                                        }
// 332
                                        s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$57);
// 333
                                        JP.go.ipa.oz.user.lib_dist.name._Path_if makeLowerPath$val$58;
                                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentPath)) {
                                          try {
                                            makeLowerPath$val$58 = currentPath.makeLowerPath (delimitor, s);
                                          } finally {
                                            changeRunningToGreen ();
                                          }
                                        } else {
                                          makeLowerPath$val$58 = currentPath.makeLowerPath (delimitor, s);
                                        }
// 333
                                        JP.go.ipa.oz.user.lib_dist.name._Path_if source = makeLowerPath$val$58;
// 334
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
// 334
                                        s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$59);
// 335
                                        JP.go.ipa.oz.user.lib_dist.name._Path_if makeLowerPath$val$60;
                                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentPath)) {
                                          try {
                                            makeLowerPath$val$60 = currentPath.makeLowerPath (delimitor, s);
                                          } finally {
                                            changeRunningToGreen ();
                                          }
                                        } else {
                                          makeLowerPath$val$60 = currentPath.makeLowerPath (delimitor, s);
                                        }
// 335
                                        JP.go.ipa.oz.user.lib_dist.name._Path_if target = makeLowerPath$val$60;
// 336
                                        if (single) {{
// 337
                                            try {
// 338
                                              JP.go.ipa.oz.lang._Root_if renameEntry$val$61;
                                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) singleNSTR)) {
                                                try {
                                                  renameEntry$val$61 = singleNSTR.renameEntry (source, target);
                                                } finally {
                                                  changeRunningToGreen ();
                                                }
                                              } else {
                                                renameEntry$val$61 = singleNSTR.renameEntry (source, target);
                                              }
// 338
                                              JP.go.ipa.oz.lang._Root_if r = renameEntry$val$61;
                                            }
                                            catch (JP.go.ipa.oz.lang.OzException _exception_16) {
                                              JP.go.ipa.oz.lang._Root_if _oz_exception_16 = _exception_16.getOzException ();
                                              if (_oz_exception_16 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
                                                JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_16;
// 340
                                                JP.go.ipa.oz.lib.standard._String_if string$54 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! out of name space."));
                                                
// 340
                                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                  try {
                                                    system.println (string$54);
                                                  } finally {
                                                    changeRunningToGreen ();
                                                  }
                                                } else {
                                                  system.println (string$54);
                                                }
                                              } else if (_oz_exception_16 instanceof JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) {
                                                JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) _oz_exception_16;
// 342
                                                JP.go.ipa.oz.lib.standard._String_if string$55 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! path String wrong."));
                                                
// 342
                                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                  try {
                                                    system.println (string$55);
                                                  } finally {
                                                    changeRunningToGreen ();
                                                  }
                                                } else {
                                                  system.println (string$55);
                                                }
                                              } else throw _exception_16;
                                            }
                                          }
                                        } else {{
// 345
                                            try {
// 346
                                              JP.go.ipa.oz.lang._Root_if renameEntry$val$62;
                                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentNST)) {
                                                try {
                                                  renameEntry$val$62 = currentNST.renameEntry (source, target);
                                                } finally {
                                                  changeRunningToGreen ();
                                                }
                                              } else {
                                                renameEntry$val$62 = currentNST.renameEntry (source, target);
                                              }
// 346
                                              JP.go.ipa.oz.lang._Root_if r = renameEntry$val$62;
                                            }
                                            catch (JP.go.ipa.oz.lang.OzException _exception_17) {
                                              JP.go.ipa.oz.lang._Root_if _oz_exception_17 = _exception_17.getOzException ();
                                              if (_oz_exception_17 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
                                                JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_17;
// 348
                                                JP.go.ipa.oz.lib.standard._String_if string$56 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! out of name space."));
                                                
// 348
                                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                  try {
                                                    system.println (string$56);
                                                  } finally {
                                                    changeRunningToGreen ();
                                                  }
                                                } else {
                                                  system.println (string$56);
                                                }
                                              } else if (_oz_exception_17 instanceof JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) {
                                                JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) _oz_exception_17;
// 350
                                                JP.go.ipa.oz.lib.standard._String_if string$57 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! path String wrong."));
                                                
// 350
                                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                  try {
                                                    system.println (string$57);
                                                  } finally {
                                                    changeRunningToGreen ();
                                                  }
                                                } else {
                                                  system.println (string$57);
                                                }
                                              } else throw _exception_17;
                                            }
                                          }
                                        }
                                      }
                                    } else {
// 357
                                      JP.go.ipa.oz.lib.standard._String_if string$58 = (new JP.go.ipa.oz.lib.standard._String_cl("EntrySize"));
                                      
// 357
                                      boolean isequal$val$63;
                                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
                                        try {
                                          isequal$val$63 = command.isequal (string$58);
                                        } finally {
                                          changeRunningToGreen ();
                                        }
                                      } else {
                                        isequal$val$63 = command.isequal (string$58);
                                      }
// 357
                                      if (isequal$val$63) {{
// 358
                                          if (single) {{
// 359
                                              try {
// 360
                                                int EntrySize$val$64;
                                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) singleNSTR)) {
                                                  try {
                                                    EntrySize$val$64 = singleNSTR.EntrySize (currentPath);
                                                  } finally {
                                                    changeRunningToGreen ();
                                                  }
                                                } else {
                                                  EntrySize$val$64 = singleNSTR.EntrySize (currentPath);
                                                }
// 360
                                                int i = EntrySize$val$64;
// 361
                                                JP.go.ipa.oz.lib.standard._Integer_if I = (JP.go.ipa.oz.lib.standard._Integer_cl) (new JP.go.ipa.oz.lib.standard._Integer_cl ())._new_breed (i);
// 361
                                                JP.go.ipa.oz.lib.standard._String_if asString$val$65;
                                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) I)) {
                                                  try {
                                                    asString$val$65 = I.asString ();
                                                  } finally {
                                                    changeRunningToGreen ();
                                                  }
                                                } else {
                                                  asString$val$65 = I.asString ();
                                                }
// 361
                                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                  try {
                                                    system.println (asString$val$65);
                                                  } finally {
                                                    changeRunningToGreen ();
                                                  }
                                                } else {
                                                  system.println (asString$val$65);
                                                }
                                              }
                                              catch (JP.go.ipa.oz.lang.OzException _exception_18) {
                                                JP.go.ipa.oz.lang._Root_if _oz_exception_18 = _exception_18.getOzException ();
                                                if (_oz_exception_18 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
                                                  JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_18;
// 363
                                                  JP.go.ipa.oz.lib.standard._String_if string$59 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! out of name space."));
                                                  
// 363
                                                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                    try {
                                                      system.println (string$59);
                                                    } finally {
                                                      changeRunningToGreen ();
                                                    }
                                                  } else {
                                                    system.println (string$59);
                                                  }
                                                } else if (_oz_exception_18 instanceof JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) {
                                                  JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) _oz_exception_18;
// 365
                                                  JP.go.ipa.oz.lib.standard._String_if string$60 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! path String wrong."));
                                                  
// 365
                                                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                    try {
                                                      system.println (string$60);
                                                    } finally {
                                                      changeRunningToGreen ();
                                                    }
                                                  } else {
                                                    system.println (string$60);
                                                  }
                                                } else throw _exception_18;
                                              }
                                            }
                                          } else {{
// 368
                                              try {
// 369
                                                int EntrySize$val$66;
                                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentNST)) {
                                                  try {
                                                    EntrySize$val$66 = currentNST.EntrySize (currentPath);
                                                  } finally {
                                                    changeRunningToGreen ();
                                                  }
                                                } else {
                                                  EntrySize$val$66 = currentNST.EntrySize (currentPath);
                                                }
// 369
                                                int i = EntrySize$val$66;
// 370
                                                JP.go.ipa.oz.lib.standard._Integer_if I = (JP.go.ipa.oz.lib.standard._Integer_cl) (new JP.go.ipa.oz.lib.standard._Integer_cl ())._new_breed (i);
// 370
                                                JP.go.ipa.oz.lib.standard._String_if asString$val$67;
                                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) I)) {
                                                  try {
                                                    asString$val$67 = I.asString ();
                                                  } finally {
                                                    changeRunningToGreen ();
                                                  }
                                                } else {
                                                  asString$val$67 = I.asString ();
                                                }
// 370
                                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                  try {
                                                    system.println (asString$val$67);
                                                  } finally {
                                                    changeRunningToGreen ();
                                                  }
                                                } else {
                                                  system.println (asString$val$67);
                                                }
                                              }
                                              catch (JP.go.ipa.oz.lang.OzException _exception_19) {
                                                JP.go.ipa.oz.lang._Root_if _oz_exception_19 = _exception_19.getOzException ();
                                                if (_oz_exception_19 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
                                                  JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_19;
// 372
                                                  JP.go.ipa.oz.lib.standard._String_if string$61 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! out of name space."));
                                                  
// 372
                                                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                    try {
                                                      system.println (string$61);
                                                    } finally {
                                                      changeRunningToGreen ();
                                                    }
                                                  } else {
                                                    system.println (string$61);
                                                  }
                                                } else if (_oz_exception_19 instanceof JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) {
                                                  JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) _oz_exception_19;
// 374
                                                  JP.go.ipa.oz.lib.standard._String_if string$62 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! path String wrong."));
                                                  
// 374
                                                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                    try {
                                                      system.println (string$62);
                                                    } finally {
                                                      changeRunningToGreen ();
                                                    }
                                                  } else {
                                                    system.println (string$62);
                                                  }
                                                } else throw _exception_19;
                                              }
                                            }
                                          }
                                        }
                                      } else {
// 388
                                        JP.go.ipa.oz.lib.standard._String_if string$63 = (new JP.go.ipa.oz.lib.standard._String_cl("putDirectory"));
                                        
// 388
                                        boolean isequal$val$68;
                                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
                                          try {
                                            isequal$val$68 = command.isequal (string$63);
                                          } finally {
                                            changeRunningToGreen ();
                                          }
                                        } else {
                                          isequal$val$68 = command.isequal (string$63);
                                        }
// 388
                                        if (isequal$val$68) {{
// 389
                                            JP.go.ipa.oz.lib.standard._String_if s = null;
// 389
                                            JP.go.ipa.oz.lang._Root_if at$val$69;
                                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                                              try {
                                                at$val$69 = args.at (1);
                                              } finally {
                                                changeRunningToGreen ();
                                              }
                                            } else {
                                              at$val$69 = args.at (1);
                                            }
// 389
                                            s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$69);
// 390
                                            JP.go.ipa.oz.user.lib_dist.name._Path_if makeLowerPath$val$70;
                                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentPath)) {
                                              try {
                                                makeLowerPath$val$70 = currentPath.makeLowerPath (delimitor, s);
                                              } finally {
                                                changeRunningToGreen ();
                                              }
                                            } else {
                                              makeLowerPath$val$70 = currentPath.makeLowerPath (delimitor, s);
                                            }
// 390
                                            JP.go.ipa.oz.user.lib_dist.name._Path_if p = makeLowerPath$val$70;
// 391
                                            if (single) {{
// 392
                                                try {
// 393
                                                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) singleNSTR)) {
                                                    try {
                                                      singleNSTR.putDirectory (p);
                                                    } finally {
                                                      changeRunningToGreen ();
                                                    }
                                                  } else {
                                                    singleNSTR.putDirectory (p);
                                                  }
                                                }
                                                catch (JP.go.ipa.oz.lang.OzException _exception_20) {
                                                  JP.go.ipa.oz.lang._Root_if _oz_exception_20 = _exception_20.getOzException ();
                                                  if (_oz_exception_20 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
                                                    JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_20;
// 395
                                                    JP.go.ipa.oz.lib.standard._String_if string$64 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! out of name space."));
                                                    
// 395
                                                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                      try {
                                                        system.println (string$64);
                                                      } finally {
                                                        changeRunningToGreen ();
                                                      }
                                                    } else {
                                                      system.println (string$64);
                                                    }
                                                  } else if (_oz_exception_20 instanceof JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) {
                                                    JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) _oz_exception_20;
// 397
                                                    JP.go.ipa.oz.lib.standard._String_if string$65 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! path String wrong."));
                                                    
// 397
                                                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                      try {
                                                        system.println (string$65);
                                                      } finally {
                                                        changeRunningToGreen ();
                                                      }
                                                    } else {
                                                      system.println (string$65);
                                                    }
                                                  } else throw _exception_20;
                                                }
                                              }
                                            } else {{
// 400
                                                try {
// 401
                                                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentNST)) {
                                                    try {
                                                      currentNST.putDirectory (p);
                                                    } finally {
                                                      changeRunningToGreen ();
                                                    }
                                                  } else {
                                                    currentNST.putDirectory (p);
                                                  }
                                                }
                                                catch (JP.go.ipa.oz.lang.OzException _exception_21) {
                                                  JP.go.ipa.oz.lang._Root_if _oz_exception_21 = _exception_21.getOzException ();
                                                  if (_oz_exception_21 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
                                                    JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_21;
// 403
                                                    JP.go.ipa.oz.lib.standard._String_if string$66 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! out of name space."));
                                                    
// 403
                                                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                      try {
                                                        system.println (string$66);
                                                      } finally {
                                                        changeRunningToGreen ();
                                                      }
                                                    } else {
                                                      system.println (string$66);
                                                    }
                                                  } else if (_oz_exception_21 instanceof JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) {
                                                    JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) _oz_exception_21;
// 405
                                                    JP.go.ipa.oz.lib.standard._String_if string$67 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! path String wrong."));
                                                    
// 405
                                                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                      try {
                                                        system.println (string$67);
                                                      } finally {
                                                        changeRunningToGreen ();
                                                      }
                                                    } else {
                                                      system.println (string$67);
                                                    }
                                                  } else throw _exception_21;
                                                }
                                              }
                                            }
                                          }
                                        } else {
// 413
                                          JP.go.ipa.oz.lib.standard._String_if string$68 = (new JP.go.ipa.oz.lib.standard._String_cl("containDirectory"));
                                          
// 413
                                          boolean isequal$val$71;
                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
                                            try {
                                              isequal$val$71 = command.isequal (string$68);
                                            } finally {
                                              changeRunningToGreen ();
                                            }
                                          } else {
                                            isequal$val$71 = command.isequal (string$68);
                                          }
// 413
                                          if (isequal$val$71) {{
// 414
                                              JP.go.ipa.oz.lib.standard._String_if s = null;
// 414
                                              JP.go.ipa.oz.lang._Root_if at$val$72;
                                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                                                try {
                                                  at$val$72 = args.at (1);
                                                } finally {
                                                  changeRunningToGreen ();
                                                }
                                              } else {
                                                at$val$72 = args.at (1);
                                              }
// 414
                                              s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$72);
// 415
                                              JP.go.ipa.oz.user.lib_dist.name._Path_if makeLowerPath$val$73;
                                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentPath)) {
                                                try {
                                                  makeLowerPath$val$73 = currentPath.makeLowerPath (delimitor, s);
                                                } finally {
                                                  changeRunningToGreen ();
                                                }
                                              } else {
                                                makeLowerPath$val$73 = currentPath.makeLowerPath (delimitor, s);
                                              }
// 415
                                              JP.go.ipa.oz.user.lib_dist.name._Path_if p = makeLowerPath$val$73;
// 416
                                              if (single) {{
// 417
                                                  try {
// 418
                                                    boolean containDirectory$val$74;
                                                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) singleNSTR)) {
                                                      try {
                                                        containDirectory$val$74 = singleNSTR.containDirectory (p);
                                                      } finally {
                                                        changeRunningToGreen ();
                                                      }
                                                    } else {
                                                      containDirectory$val$74 = singleNSTR.containDirectory (p);
                                                    }
// 418
                                                    boolean tf = containDirectory$val$74;
// 419
                                                    if (tf) {
// 419
                                                      JP.go.ipa.oz.lib.standard._String_if string$69 = (new JP.go.ipa.oz.lib.standard._String_cl("  true"));
                                                      
// 419
                                                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                        try {
                                                          system.println (string$69);
                                                        } finally {
                                                          changeRunningToGreen ();
                                                        }
                                                      } else {
                                                        system.println (string$69);
                                                      }
                                                    } else {
// 420
                                                      JP.go.ipa.oz.lib.standard._String_if string$70 = (new JP.go.ipa.oz.lib.standard._String_cl("  false"));
                                                      
// 420
                                                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                        try {
                                                          system.println (string$70);
                                                        } finally {
                                                          changeRunningToGreen ();
                                                        }
                                                      } else {
                                                        system.println (string$70);
                                                      }
                                                    }
                                                  }
                                                  catch (JP.go.ipa.oz.lang.OzException _exception_22) {
                                                    JP.go.ipa.oz.lang._Root_if _oz_exception_22 = _exception_22.getOzException ();
                                                    if (_oz_exception_22 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
                                                      JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_22;
// 422
                                                      JP.go.ipa.oz.lib.standard._String_if string$71 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! out of name space."));
                                                      
// 422
                                                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                        try {
                                                          system.println (string$71);
                                                        } finally {
                                                          changeRunningToGreen ();
                                                        }
                                                      } else {
                                                        system.println (string$71);
                                                      }
                                                    } else if (_oz_exception_22 instanceof JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) {
                                                      JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) _oz_exception_22;
// 424
                                                      JP.go.ipa.oz.lib.standard._String_if string$72 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! path String wrong."));
                                                      
// 424
                                                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                        try {
                                                          system.println (string$72);
                                                        } finally {
                                                          changeRunningToGreen ();
                                                        }
                                                      } else {
                                                        system.println (string$72);
                                                      }
                                                    } else throw _exception_22;
                                                  }
                                                }
                                              } else {{
// 427
                                                  try {
// 428
                                                    boolean containDirectory$val$75;
                                                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentNST)) {
                                                      try {
                                                        containDirectory$val$75 = currentNST.containDirectory (p);
                                                      } finally {
                                                        changeRunningToGreen ();
                                                      }
                                                    } else {
                                                      containDirectory$val$75 = currentNST.containDirectory (p);
                                                    }
// 428
                                                    boolean tf = containDirectory$val$75;
// 429
                                                    if (tf) {
// 429
                                                      JP.go.ipa.oz.lib.standard._String_if string$73 = (new JP.go.ipa.oz.lib.standard._String_cl("  true"));
                                                      
// 429
                                                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                        try {
                                                          system.println (string$73);
                                                        } finally {
                                                          changeRunningToGreen ();
                                                        }
                                                      } else {
                                                        system.println (string$73);
                                                      }
                                                    } else {
// 430
                                                      JP.go.ipa.oz.lib.standard._String_if string$74 = (new JP.go.ipa.oz.lib.standard._String_cl("  false"));
                                                      
// 430
                                                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                        try {
                                                          system.println (string$74);
                                                        } finally {
                                                          changeRunningToGreen ();
                                                        }
                                                      } else {
                                                        system.println (string$74);
                                                      }
                                                    }
                                                  }
                                                  catch (JP.go.ipa.oz.lang.OzException _exception_23) {
                                                    JP.go.ipa.oz.lang._Root_if _oz_exception_23 = _exception_23.getOzException ();
                                                    if (_oz_exception_23 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
                                                      JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_23;
// 432
                                                      JP.go.ipa.oz.lib.standard._String_if string$75 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! out of name space."));
                                                      
// 432
                                                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                        try {
                                                          system.println (string$75);
                                                        } finally {
                                                          changeRunningToGreen ();
                                                        }
                                                      } else {
                                                        system.println (string$75);
                                                      }
                                                    } else if (_oz_exception_23 instanceof JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) {
                                                      JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) _oz_exception_23;
// 434
                                                      JP.go.ipa.oz.lib.standard._String_if string$76 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! path String wrong."));
                                                      
// 434
                                                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                        try {
                                                          system.println (string$76);
                                                        } finally {
                                                          changeRunningToGreen ();
                                                        }
                                                      } else {
                                                        system.println (string$76);
                                                      }
                                                    } else throw _exception_23;
                                                  }
                                                }
                                              }
                                            }
                                          } else {
// 443
                                            JP.go.ipa.oz.lib.standard._String_if string$77 = (new JP.go.ipa.oz.lib.standard._String_cl("removeDirectory"));
                                            
// 443
                                            boolean isequal$val$76;
                                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
                                              try {
                                                isequal$val$76 = command.isequal (string$77);
                                              } finally {
                                                changeRunningToGreen ();
                                              }
                                            } else {
                                              isequal$val$76 = command.isequal (string$77);
                                            }
// 443
                                            if (isequal$val$76) {{
// 444
                                                JP.go.ipa.oz.lib.standard._String_if s = null;
// 444
                                                JP.go.ipa.oz.lang._Root_if at$val$77;
                                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                                                  try {
                                                    at$val$77 = args.at (1);
                                                  } finally {
                                                    changeRunningToGreen ();
                                                  }
                                                } else {
                                                  at$val$77 = args.at (1);
                                                }
// 444
                                                s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$77);
// 445
                                                JP.go.ipa.oz.user.lib_dist.name._Path_if makeLowerPath$val$78;
                                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentPath)) {
                                                  try {
                                                    makeLowerPath$val$78 = currentPath.makeLowerPath (delimitor, s);
                                                  } finally {
                                                    changeRunningToGreen ();
                                                  }
                                                } else {
                                                  makeLowerPath$val$78 = currentPath.makeLowerPath (delimitor, s);
                                                }
// 445
                                                JP.go.ipa.oz.user.lib_dist.name._Path_if p = makeLowerPath$val$78;
// 446
                                                if (single) {{
// 447
                                                    try {
// 448
                                                      JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if removeDirectory$val$79;
                                                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) singleNSTR)) {
                                                        try {
                                                          removeDirectory$val$79 = singleNSTR.removeDirectory (p);
                                                        } finally {
                                                          changeRunningToGreen ();
                                                        }
                                                      } else {
                                                        removeDirectory$val$79 = singleNSTR.removeDirectory (p);
                                                      }
                                                    }
                                                    catch (JP.go.ipa.oz.lang.OzException _exception_24) {
                                                      JP.go.ipa.oz.lang._Root_if _oz_exception_24 = _exception_24.getOzException ();
                                                      if (_oz_exception_24 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
                                                        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_24;
// 450
                                                        JP.go.ipa.oz.lib.standard._String_if string$78 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! out of name space."));
                                                        
// 450
                                                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                          try {
                                                            system.println (string$78);
                                                          } finally {
                                                            changeRunningToGreen ();
                                                          }
                                                        } else {
                                                          system.println (string$78);
                                                        }
                                                      } else if (_oz_exception_24 instanceof JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) {
                                                        JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) _oz_exception_24;
// 452
                                                        JP.go.ipa.oz.lib.standard._String_if string$79 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! path String wrong."));
                                                        
// 452
                                                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                          try {
                                                            system.println (string$79);
                                                          } finally {
                                                            changeRunningToGreen ();
                                                          }
                                                        } else {
                                                          system.println (string$79);
                                                        }
                                                      } else if (_oz_exception_24 instanceof JP.go.ipa.oz.user.lib_dist.name._NameDirectoryNotEmptyException_if) {
                                                        JP.go.ipa.oz.user.lib_dist.name._NameDirectoryNotEmptyException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameDirectoryNotEmptyException_if) _oz_exception_24;
// 454
                                                        JP.go.ipa.oz.lib.standard._String_if string$80 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! directory not empty."));
                                                        
// 454
                                                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                          try {
                                                            system.println (string$80);
                                                          } finally {
                                                            changeRunningToGreen ();
                                                          }
                                                        } else {
                                                          system.println (string$80);
                                                        }
                                                      } else if (_oz_exception_24 instanceof JP.go.ipa.oz.user.lib_dist.name._NameDirectoryBranchException_if) {
                                                        JP.go.ipa.oz.user.lib_dist.name._NameDirectoryBranchException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameDirectoryBranchException_if) _oz_exception_24;
// 456
                                                        JP.go.ipa.oz.lib.standard._String_if string$81 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! directory is branch."));
                                                        
// 456
                                                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                          try {
                                                            system.println (string$81);
                                                          } finally {
                                                            changeRunningToGreen ();
                                                          }
                                                        } else {
                                                          system.println (string$81);
                                                        }
                                                      } else throw _exception_24;
                                                    }
                                                  }
                                                } else {{
// 459
                                                    try {
// 460
                                                      JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if removeDirectory$val$80;
                                                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentNST)) {
                                                        try {
                                                          removeDirectory$val$80 = currentNST.removeDirectory (p);
                                                        } finally {
                                                          changeRunningToGreen ();
                                                        }
                                                      } else {
                                                        removeDirectory$val$80 = currentNST.removeDirectory (p);
                                                      }
                                                    }
                                                    catch (JP.go.ipa.oz.lang.OzException _exception_25) {
                                                      JP.go.ipa.oz.lang._Root_if _oz_exception_25 = _exception_25.getOzException ();
                                                      if (_oz_exception_25 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
                                                        JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_25;
// 462
                                                        JP.go.ipa.oz.lib.standard._String_if string$82 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! out of name space."));
                                                        
// 462
                                                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                          try {
                                                            system.println (string$82);
                                                          } finally {
                                                            changeRunningToGreen ();
                                                          }
                                                        } else {
                                                          system.println (string$82);
                                                        }
                                                      } else if (_oz_exception_25 instanceof JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) {
                                                        JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) _oz_exception_25;
// 464
                                                        JP.go.ipa.oz.lib.standard._String_if string$83 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! path String wrong."));
                                                        
// 464
                                                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                          try {
                                                            system.println (string$83);
                                                          } finally {
                                                            changeRunningToGreen ();
                                                          }
                                                        } else {
                                                          system.println (string$83);
                                                        }
                                                      } else if (_oz_exception_25 instanceof JP.go.ipa.oz.user.lib_dist.name._NameDirectoryNotEmptyException_if) {
                                                        JP.go.ipa.oz.user.lib_dist.name._NameDirectoryNotEmptyException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameDirectoryNotEmptyException_if) _oz_exception_25;
// 466
                                                        JP.go.ipa.oz.lib.standard._String_if string$84 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! directory not empty."));
                                                        
// 466
                                                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                          try {
                                                            system.println (string$84);
                                                          } finally {
                                                            changeRunningToGreen ();
                                                          }
                                                        } else {
                                                          system.println (string$84);
                                                        }
                                                      } else if (_oz_exception_25 instanceof JP.go.ipa.oz.user.lib_dist.name._NameDirectoryBranchException_if) {
                                                        JP.go.ipa.oz.user.lib_dist.name._NameDirectoryBranchException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameDirectoryBranchException_if) _oz_exception_25;
// 468
                                                        JP.go.ipa.oz.lib.standard._String_if string$85 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! directory is branch."));
                                                        
// 468
                                                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                          try {
                                                            system.println (string$85);
                                                          } finally {
                                                            changeRunningToGreen ();
                                                          }
                                                        } else {
                                                          system.println (string$85);
                                                        }
                                                      } else throw _exception_25;
                                                    }
                                                  }
                                                }
                                              }
                                            } else {
// 476
                                              JP.go.ipa.oz.lib.standard._String_if string$86 = (new JP.go.ipa.oz.lib.standard._String_cl("renameDirectory"));
                                              
// 476
                                              boolean isequal$val$81;
                                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
                                                try {
                                                  isequal$val$81 = command.isequal (string$86);
                                                } finally {
                                                  changeRunningToGreen ();
                                                }
                                              } else {
                                                isequal$val$81 = command.isequal (string$86);
                                              }
// 476
                                              if (isequal$val$81) {{
// 477
                                                  JP.go.ipa.oz.lib.standard._String_if s = null;
// 477
                                                  JP.go.ipa.oz.lang._Root_if at$val$82;
                                                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                                                    try {
                                                      at$val$82 = args.at (1);
                                                    } finally {
                                                      changeRunningToGreen ();
                                                    }
                                                  } else {
                                                    at$val$82 = args.at (1);
                                                  }
// 477
                                                  s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$82);
// 478
                                                  JP.go.ipa.oz.user.lib_dist.name._Path_if makeLowerPath$val$83;
                                                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentPath)) {
                                                    try {
                                                      makeLowerPath$val$83 = currentPath.makeLowerPath (delimitor, s);
                                                    } finally {
                                                      changeRunningToGreen ();
                                                    }
                                                  } else {
                                                    makeLowerPath$val$83 = currentPath.makeLowerPath (delimitor, s);
                                                  }
// 478
                                                  JP.go.ipa.oz.user.lib_dist.name._Path_if source = makeLowerPath$val$83;
// 480
                                                  JP.go.ipa.oz.lang._Root_if at$val$84;
                                                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
                                                    try {
                                                      at$val$84 = args.at (2);
                                                    } finally {
                                                      changeRunningToGreen ();
                                                    }
                                                  } else {
                                                    at$val$84 = args.at (2);
                                                  }
// 480
                                                  s = (JP.go.ipa.oz.lib.standard._String_if) (at$val$84);
// 481
                                                  JP.go.ipa.oz.user.lib_dist.name._Path_if makeLowerPath$val$85;
                                                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentPath)) {
                                                    try {
                                                      makeLowerPath$val$85 = currentPath.makeLowerPath (delimitor, s);
                                                    } finally {
                                                      changeRunningToGreen ();
                                                    }
                                                  } else {
                                                    makeLowerPath$val$85 = currentPath.makeLowerPath (delimitor, s);
                                                  }
// 481
                                                  JP.go.ipa.oz.user.lib_dist.name._Path_if target = makeLowerPath$val$85;
// 483
                                                  if (single) {{
// 484
                                                      try {
// 485
                                                        JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if renameDirectory$val$86;
                                                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) singleNSTR)) {
                                                          try {
                                                            renameDirectory$val$86 = singleNSTR.renameDirectory (source, target);
                                                          } finally {
                                                            changeRunningToGreen ();
                                                          }
                                                        } else {
                                                          renameDirectory$val$86 = singleNSTR.renameDirectory (source, target);
                                                        }
                                                      }
                                                      catch (JP.go.ipa.oz.lang.OzException _exception_26) {
                                                        JP.go.ipa.oz.lang._Root_if _oz_exception_26 = _exception_26.getOzException ();
                                                        if (_oz_exception_26 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
                                                          JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_26;
// 487
                                                          JP.go.ipa.oz.lib.standard._String_if string$87 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! out of name space."));
                                                          
// 487
                                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                            try {
                                                              system.println (string$87);
                                                            } finally {
                                                              changeRunningToGreen ();
                                                            }
                                                          } else {
                                                            system.println (string$87);
                                                          }
                                                        } else if (_oz_exception_26 instanceof JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) {
                                                          JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) _oz_exception_26;
// 489
                                                          JP.go.ipa.oz.lib.standard._String_if string$88 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! path String wrong."));
                                                          
// 489
                                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                            try {
                                                              system.println (string$88);
                                                            } finally {
                                                              changeRunningToGreen ();
                                                            }
                                                          } else {
                                                            system.println (string$88);
                                                          }
                                                        } else if (_oz_exception_26 instanceof JP.go.ipa.oz.user.lib_dist.name._NameDirectoryNotEmptyException_if) {
                                                          JP.go.ipa.oz.user.lib_dist.name._NameDirectoryNotEmptyException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameDirectoryNotEmptyException_if) _oz_exception_26;
// 491
                                                          JP.go.ipa.oz.lib.standard._String_if string$89 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! directory not empty."));
                                                          
// 491
                                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                            try {
                                                              system.println (string$89);
                                                            } finally {
                                                              changeRunningToGreen ();
                                                            }
                                                          } else {
                                                            system.println (string$89);
                                                          }
                                                        } else if (_oz_exception_26 instanceof JP.go.ipa.oz.user.lib_dist.name._NameDirectoryBranchException_if) {
                                                          JP.go.ipa.oz.user.lib_dist.name._NameDirectoryBranchException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameDirectoryBranchException_if) _oz_exception_26;
// 493
                                                          JP.go.ipa.oz.lib.standard._String_if string$90 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! directory is branch."));
                                                          
// 493
                                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                            try {
                                                              system.println (string$90);
                                                            } finally {
                                                              changeRunningToGreen ();
                                                            }
                                                          } else {
                                                            system.println (string$90);
                                                          }
                                                        } else throw _exception_26;
                                                      }
                                                    }
                                                  } else {{
// 496
                                                      try {
// 497
                                                        JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if renameDirectory$val$87;
                                                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentNST)) {
                                                          try {
                                                            renameDirectory$val$87 = currentNST.renameDirectory (source, target);
                                                          } finally {
                                                            changeRunningToGreen ();
                                                          }
                                                        } else {
                                                          renameDirectory$val$87 = currentNST.renameDirectory (source, target);
                                                        }
                                                      }
                                                      catch (JP.go.ipa.oz.lang.OzException _exception_27) {
                                                        JP.go.ipa.oz.lang._Root_if _oz_exception_27 = _exception_27.getOzException ();
                                                        if (_oz_exception_27 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
                                                          JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_27;
// 499
                                                          JP.go.ipa.oz.lib.standard._String_if string$91 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! out of name space."));
                                                          
// 499
                                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                            try {
                                                              system.println (string$91);
                                                            } finally {
                                                              changeRunningToGreen ();
                                                            }
                                                          } else {
                                                            system.println (string$91);
                                                          }
                                                        } else if (_oz_exception_27 instanceof JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) {
                                                          JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if) _oz_exception_27;
// 501
                                                          JP.go.ipa.oz.lib.standard._String_if string$92 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! path String wrong."));
                                                          
// 501
                                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                            try {
                                                              system.println (string$92);
                                                            } finally {
                                                              changeRunningToGreen ();
                                                            }
                                                          } else {
                                                            system.println (string$92);
                                                          }
                                                        } else if (_oz_exception_27 instanceof JP.go.ipa.oz.user.lib_dist.name._NameDirectoryNotEmptyException_if) {
                                                          JP.go.ipa.oz.user.lib_dist.name._NameDirectoryNotEmptyException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameDirectoryNotEmptyException_if) _oz_exception_27;
// 503
                                                          JP.go.ipa.oz.lib.standard._String_if string$93 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! directory not empty."));
                                                          
// 503
                                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                            try {
                                                              system.println (string$93);
                                                            } finally {
                                                              changeRunningToGreen ();
                                                            }
                                                          } else {
                                                            system.println (string$93);
                                                          }
                                                        } else if (_oz_exception_27 instanceof JP.go.ipa.oz.user.lib_dist.name._NameDirectoryBranchException_if) {
                                                          JP.go.ipa.oz.user.lib_dist.name._NameDirectoryBranchException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameDirectoryBranchException_if) _oz_exception_27;
// 505
                                                          JP.go.ipa.oz.lib.standard._String_if string$94 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! directory is branch."));
                                                          
// 505
                                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                            try {
                                                              system.println (string$94);
                                                            } finally {
                                                              changeRunningToGreen ();
                                                            }
                                                          } else {
                                                            system.println (string$94);
                                                          }
                                                        } else throw _exception_27;
                                                      }
                                                    }
                                                  }
                                                }
                                              } else {
// 512
                                                JP.go.ipa.oz.lib.standard._String_if string$95 = (new JP.go.ipa.oz.lib.standard._String_cl("DirectorySize"));
                                                
// 512
                                                boolean isequal$val$88;
                                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
                                                  try {
                                                    isequal$val$88 = command.isequal (string$95);
                                                  } finally {
                                                    changeRunningToGreen ();
                                                  }
                                                } else {
                                                  isequal$val$88 = command.isequal (string$95);
                                                }
// 512
                                                if (isequal$val$88) {{
// 513
                                                    if (single) {{
// 514
                                                        try {
// 515
                                                          int DirectorySize$val$89;
                                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) singleNSTR)) {
                                                            try {
                                                              DirectorySize$val$89 = singleNSTR.DirectorySize (currentPath);
                                                            } finally {
                                                              changeRunningToGreen ();
                                                            }
                                                          } else {
                                                            DirectorySize$val$89 = singleNSTR.DirectorySize (currentPath);
                                                          }
// 515
                                                          int i = DirectorySize$val$89;
// 516
                                                          JP.go.ipa.oz.lib.standard._Integer_if I = (JP.go.ipa.oz.lib.standard._Integer_cl) (new JP.go.ipa.oz.lib.standard._Integer_cl ())._new_breed (i);
// 516
                                                          JP.go.ipa.oz.lib.standard._String_if asString$val$90;
                                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) I)) {
                                                            try {
                                                              asString$val$90 = I.asString ();
                                                            } finally {
                                                              changeRunningToGreen ();
                                                            }
                                                          } else {
                                                            asString$val$90 = I.asString ();
                                                          }
// 516
                                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                            try {
                                                              system.println (asString$val$90);
                                                            } finally {
                                                              changeRunningToGreen ();
                                                            }
                                                          } else {
                                                            system.println (asString$val$90);
                                                          }
                                                        }
                                                        catch (JP.go.ipa.oz.lang.OzException _exception_28) {
                                                          JP.go.ipa.oz.lang._Root_if _oz_exception_28 = _exception_28.getOzException ();
                                                          if (_oz_exception_28 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
                                                            JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_28;
// 518
                                                            JP.go.ipa.oz.lib.standard._String_if string$96 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! out of name space."));
                                                            
// 518
                                                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                              try {
                                                                system.println (string$96);
                                                              } finally {
                                                                changeRunningToGreen ();
                                                              }
                                                            } else {
                                                              system.println (string$96);
                                                            }
                                                          } else throw _exception_28;
                                                        }
                                                      }
                                                    } else {{
// 521
                                                        try {
// 522
                                                          int DirectorySize$val$91;
                                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) currentNST)) {
                                                            try {
                                                              DirectorySize$val$91 = currentNST.DirectorySize (currentPath);
                                                            } finally {
                                                              changeRunningToGreen ();
                                                            }
                                                          } else {
                                                            DirectorySize$val$91 = currentNST.DirectorySize (currentPath);
                                                          }
// 522
                                                          int i = DirectorySize$val$91;
// 523
                                                          JP.go.ipa.oz.lib.standard._Integer_if I = (JP.go.ipa.oz.lib.standard._Integer_cl) (new JP.go.ipa.oz.lib.standard._Integer_cl ())._new_breed (i);
// 523
                                                          JP.go.ipa.oz.lib.standard._String_if asString$val$92;
                                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) I)) {
                                                            try {
                                                              asString$val$92 = I.asString ();
                                                            } finally {
                                                              changeRunningToGreen ();
                                                            }
                                                          } else {
                                                            asString$val$92 = I.asString ();
                                                          }
// 523
                                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                            try {
                                                              system.println (asString$val$92);
                                                            } finally {
                                                              changeRunningToGreen ();
                                                            }
                                                          } else {
                                                            system.println (asString$val$92);
                                                          }
                                                        }
                                                        catch (JP.go.ipa.oz.lang.OzException _exception_29) {
                                                          JP.go.ipa.oz.lang._Root_if _oz_exception_29 = _exception_29.getOzException ();
                                                          if (_oz_exception_29 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
                                                            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_29;
// 525
                                                            JP.go.ipa.oz.lib.standard._String_if string$97 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! out of name space."));
                                                            
// 525
                                                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                              try {
                                                                system.println (string$97);
                                                              } finally {
                                                                changeRunningToGreen ();
                                                              }
                                                            } else {
                                                              system.println (string$97);
                                                            }
                                                          } else throw _exception_29;
                                                        }
                                                      }
                                                    }
                                                  }
                                                } else {
// 530
                                                  JP.go.ipa.oz.lib.standard._String_if string$98 = (new JP.go.ipa.oz.lib.standard._String_cl("  ERROR! maintenunce tool not defined command"));
                                                  
// 530
                                                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                                                    try {
                                                      system.println (string$98);
                                                    } finally {
                                                      changeRunningToGreen ();
                                                    }
                                                  } else {
                                                    system.println (string$98);
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
          }
        }
      }
    }
  }
  
  public _MaintenunceTool_cl () { super ("JP.go.ipa.oz.user.lib_dist.name._MaintenunceTool_pcl"); }
  
  public _MaintenunceTool_cl (String proxy_id) { super (proxy_id); }
  
}


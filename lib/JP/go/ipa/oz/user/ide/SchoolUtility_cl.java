package JP.go.ipa.oz.user.ide;

public class SchoolUtility_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.SchoolUtility_if {
  JP.go.ipa.oz.lib.standard._Dictionary_if subjects;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Dictionary_if sbj) throws Exception  {
// 27
    subjects = sbj;
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if makeInterfaceID (JP.go.ipa.oz.lib.standard._String_if interfaceID) throws Exception  {
    checkSecureInvocation ();
// 137
    JP.go.ipa.oz.lib.standard._StringBuffer_if tmpBuf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 138
    JP.go.ipa.oz.lib.standard._String_if string$59 = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.user.released."));
    
// 138
    boolean startsWith$val$467;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) interfaceID)) {
      try {
        startsWith$val$467 = interfaceID.startsWith (string$59);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$467 = interfaceID.startsWith (string$59);
    }
// 138
    if (startsWith$val$467) {
// 139
      JP.go.ipa.oz.lib.standard._String_if substring$val$468;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) interfaceID)) {
        try {
          substring$val$468 = interfaceID.substring (27);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        substring$val$468 = interfaceID.substring (27);
      }
// 139
      interfaceID = substring$val$468;
    } else {
// 140
      JP.go.ipa.oz.lib.standard._String_if string$60 = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.user."));
      
// 140
      boolean startsWith$val$469;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) interfaceID)) {
        try {
          startsWith$val$469 = interfaceID.startsWith (string$60);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        startsWith$val$469 = interfaceID.startsWith (string$60);
      }
// 140
      if (startsWith$val$469) {
// 141
        JP.go.ipa.oz.lib.standard._String_if substring$val$470;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) interfaceID)) {
          try {
            substring$val$470 = interfaceID.substring (18);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          substring$val$470 = interfaceID.substring (18);
        }
// 141
        interfaceID = substring$val$470;
      } else {
        boolean bool$val$14;
        
// 142
        JP.go.ipa.oz.lib.standard._String_if string$61 = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.lib."));
        
// 142
        boolean startsWith$val$471;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) interfaceID)) {
          try {
            startsWith$val$471 = interfaceID.startsWith (string$61);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          startsWith$val$471 = interfaceID.startsWith (string$61);
        }
        bool$val$14 = startsWith$val$471;
        if (!bool$val$14) {
// 142
          JP.go.ipa.oz.lib.standard._String_if string$62 = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.lang."));
          
// 142
          boolean startsWith$val$472;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) interfaceID)) {
            try {
              startsWith$val$472 = interfaceID.startsWith (string$62);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            startsWith$val$472 = interfaceID.startsWith (string$62);
          }
          bool$val$14 = startsWith$val$472;
        }
// 142
        if (bool$val$14) {
// 143
          JP.go.ipa.oz.lib.standard._String_if substring$val$473;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) interfaceID)) {
            try {
              substring$val$473 = interfaceID.substring (12);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            substring$val$473 = interfaceID.substring (12);
          }
// 143
          interfaceID = substring$val$473;
        } else {
// 144
          JP.go.ipa.oz.lib.standard._String_if string$63 = (new JP.go.ipa.oz.lib.standard._String_cl(".user.released."));
          
// 144
          boolean startsWith$val$474;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) interfaceID)) {
            try {
              startsWith$val$474 = interfaceID.startsWith (string$63);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            startsWith$val$474 = interfaceID.startsWith (string$63);
          }
// 144
          if (startsWith$val$474) {
// 145
            JP.go.ipa.oz.lib.standard._String_if substring$val$475;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) interfaceID)) {
              try {
                substring$val$475 = interfaceID.substring (15);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              substring$val$475 = interfaceID.substring (15);
            }
// 145
            interfaceID = substring$val$475;
          } else {
// 146
            JP.go.ipa.oz.lib.standard._String_if string$64 = (new JP.go.ipa.oz.lib.standard._String_cl(".user."));
            
// 146
            boolean startsWith$val$476;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) interfaceID)) {
              try {
                startsWith$val$476 = interfaceID.startsWith (string$64);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              startsWith$val$476 = interfaceID.startsWith (string$64);
            }
// 146
            if (startsWith$val$476) {
// 147
              JP.go.ipa.oz.lib.standard._String_if substring$val$477;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) interfaceID)) {
                try {
                  substring$val$477 = interfaceID.substring (6);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                substring$val$477 = interfaceID.substring (6);
              }
// 147
              interfaceID = substring$val$477;
            }
          }
        }
      }
    }
// 148
    JP.go.ipa.oz.lib.standard._String_if string$65 = (new JP.go.ipa.oz.lib.standard._String_cl("_if"));
    
// 148
    boolean endsWith$val$478;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) interfaceID)) {
      try {
        endsWith$val$478 = interfaceID.endsWith (string$65);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      endsWith$val$478 = interfaceID.endsWith (string$65);
    }
// 148
    if (!(endsWith$val$478)) {{
// 149
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$479;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpBuf)) {
          try {
            append$val$479 = tmpBuf.append (interfaceID);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$479 = tmpBuf.append (interfaceID);
        }
// 150
        JP.go.ipa.oz.lib.standard._String_if string$66 = (new JP.go.ipa.oz.lib.standard._String_cl("_if"));
        
// 150
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$480;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpBuf)) {
          try {
            append$val$480 = tmpBuf.append (string$66);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$480 = tmpBuf.append (string$66);
        }
// 151
        JP.go.ipa.oz.lib.standard._String_if asString$val$481;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpBuf)) {
          try {
            asString$val$481 = tmpBuf.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$481 = tmpBuf.asString ();
        }
// 151
        interfaceID = asString$val$481;
// 152
        tmpBuf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
      }
    }
// 154
    return interfaceID;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if makeImplementationID (JP.go.ipa.oz.lib.standard._String_if implementationID) throws Exception  {
    checkSecureInvocation ();
// 158
    JP.go.ipa.oz.lib.standard._StringBuffer_if tmpBuf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 159
    JP.go.ipa.oz.lib.standard._String_if string$67 = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.user.released."));
    
// 159
    boolean startsWith$val$482;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implementationID)) {
      try {
        startsWith$val$482 = implementationID.startsWith (string$67);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$482 = implementationID.startsWith (string$67);
    }
// 159
    if (startsWith$val$482) {
// 160
      JP.go.ipa.oz.lib.standard._String_if substring$val$483;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implementationID)) {
        try {
          substring$val$483 = implementationID.substring (27);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        substring$val$483 = implementationID.substring (27);
      }
// 160
      implementationID = substring$val$483;
    } else {
// 161
      JP.go.ipa.oz.lib.standard._String_if string$68 = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.user."));
      
// 161
      boolean startsWith$val$484;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implementationID)) {
        try {
          startsWith$val$484 = implementationID.startsWith (string$68);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        startsWith$val$484 = implementationID.startsWith (string$68);
      }
// 161
      if (startsWith$val$484) {
// 162
        JP.go.ipa.oz.lib.standard._String_if substring$val$485;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implementationID)) {
          try {
            substring$val$485 = implementationID.substring (18);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          substring$val$485 = implementationID.substring (18);
        }
// 162
        implementationID = substring$val$485;
      } else {
        boolean bool$val$15;
        
// 163
        JP.go.ipa.oz.lib.standard._String_if string$69 = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.lib."));
        
// 163
        boolean startsWith$val$486;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implementationID)) {
          try {
            startsWith$val$486 = implementationID.startsWith (string$69);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          startsWith$val$486 = implementationID.startsWith (string$69);
        }
        bool$val$15 = startsWith$val$486;
        if (!bool$val$15) {
// 163
          JP.go.ipa.oz.lib.standard._String_if string$70 = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.lang."));
          
// 163
          boolean startsWith$val$487;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implementationID)) {
            try {
              startsWith$val$487 = implementationID.startsWith (string$70);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            startsWith$val$487 = implementationID.startsWith (string$70);
          }
          bool$val$15 = startsWith$val$487;
        }
// 163
        if (bool$val$15) {
// 164
          JP.go.ipa.oz.lib.standard._String_if substring$val$488;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implementationID)) {
            try {
              substring$val$488 = implementationID.substring (12);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            substring$val$488 = implementationID.substring (12);
          }
// 164
          implementationID = substring$val$488;
        } else {
// 165
          JP.go.ipa.oz.lib.standard._String_if string$71 = (new JP.go.ipa.oz.lib.standard._String_cl(".user.released."));
          
// 165
          boolean startsWith$val$489;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implementationID)) {
            try {
              startsWith$val$489 = implementationID.startsWith (string$71);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            startsWith$val$489 = implementationID.startsWith (string$71);
          }
// 165
          if (startsWith$val$489) {
// 166
            JP.go.ipa.oz.lib.standard._String_if substring$val$490;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implementationID)) {
              try {
                substring$val$490 = implementationID.substring (15);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              substring$val$490 = implementationID.substring (15);
            }
// 166
            implementationID = substring$val$490;
          } else {
// 167
            JP.go.ipa.oz.lib.standard._String_if string$72 = (new JP.go.ipa.oz.lib.standard._String_cl(".user."));
            
// 167
            boolean startsWith$val$491;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implementationID)) {
              try {
                startsWith$val$491 = implementationID.startsWith (string$72);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              startsWith$val$491 = implementationID.startsWith (string$72);
            }
// 167
            if (startsWith$val$491) {
// 168
              JP.go.ipa.oz.lib.standard._String_if substring$val$492;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implementationID)) {
                try {
                  substring$val$492 = implementationID.substring (6);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                substring$val$492 = implementationID.substring (6);
              }
// 168
              implementationID = substring$val$492;
            }
          }
        }
      }
    }
// 169
    JP.go.ipa.oz.lib.standard._String_if string$73 = (new JP.go.ipa.oz.lib.standard._String_cl("_cl"));
    
// 169
    boolean endsWith$val$493;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implementationID)) {
      try {
        endsWith$val$493 = implementationID.endsWith (string$73);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      endsWith$val$493 = implementationID.endsWith (string$73);
    }
// 169
    if (!(endsWith$val$493)) {{
// 170
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$494;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpBuf)) {
          try {
            append$val$494 = tmpBuf.append (implementationID);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$494 = tmpBuf.append (implementationID);
        }
// 171
        JP.go.ipa.oz.lib.standard._String_if string$74 = (new JP.go.ipa.oz.lib.standard._String_cl("_cl"));
        
// 171
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$495;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpBuf)) {
          try {
            append$val$495 = tmpBuf.append (string$74);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$495 = tmpBuf.append (string$74);
        }
// 172
        JP.go.ipa.oz.lib.standard._String_if asString$val$496;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpBuf)) {
          try {
            asString$val$496 = tmpBuf.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$496 = tmpBuf.asString ();
        }
// 172
        implementationID = asString$val$496;
// 173
        tmpBuf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
      }
    }
// 175
    return implementationID;
  }
  
  public void loadFromFile (JP.go.ipa.oz.lib.standard._String_if fileName, JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception  {
    checkSecureInvocation ();
// 82
    JP.go.ipa.oz.lib.standard._String_if labelName = null, interfaceID = null, implementationID = null, buf = null;
// 83
    int counter = 0, startPoint = 0;
// 84
    JP.go.ipa.oz.user.ide.Subject_if subject = null;
// 85
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$497;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjects)) {
      try {
        iterator$val$497 = subjects.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$497 = subjects.iterator ();
    }
// 85
    JP.go.ipa.oz.lib.standard._Iterator_if sbjIterator = iterator$val$497;
// 86
    while (true) {
// 86
      boolean hasMoreElements$val$498;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbjIterator)) {
        try {
          hasMoreElements$val$498 = sbjIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$498 = sbjIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$498)) break;
      
      /* body */ _loop_1: {
// 87
        JP.go.ipa.oz.lang._Root_if nextElement$val$499;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbjIterator)) {
          try {
            nextElement$val$499 = sbjIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$499 = sbjIterator.nextElement ();
        }
// 87
        subject = (JP.go.ipa.oz.user.ide.Subject_if) (nextElement$val$499);
// 88
        JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$500;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
          try {
            getSubjectName$val$500 = subject.getSubjectName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSubjectName$val$500 = subject.getSubjectName ();
        }
// 88
        int compareTo$val$501;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSubjectName$val$500)) {
          try {
            compareTo$val$501 = getSubjectName$val$500.compareTo (subjectName);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          compareTo$val$501 = getSubjectName$val$500.compareTo (subjectName);
        }
// 88
        if (compareTo$val$501 == 0) {{
// 89
            break;
          }
        }
      }
    }
// 93
    try {
// 94
      JP.go.ipa.oz.lib.standard._FileInputStream_if fin = (JP.go.ipa.oz.lib.standard._FileInputStream_cl) (new JP.go.ipa.oz.lib.standard._FileInputStream_cl ())._new_breed (fileName);
// 95
      JP.go.ipa.oz.lib.standard._InputStreamReader_if isr = (JP.go.ipa.oz.lib.standard._InputStreamReader_cl) (new JP.go.ipa.oz.lib.standard._InputStreamReader_cl ())._new_breed (fin);
// 96
      JP.go.ipa.oz.lib.standard._BufferedReader_if br = (JP.go.ipa.oz.lib.standard._BufferedReader_cl) (new JP.go.ipa.oz.lib.standard._BufferedReader_cl ())._new_breed (isr);
// 98
      while (true) {
// 98
        JP.go.ipa.oz.lib.standard._String_if readLine$val$502;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) br)) {
          try {
            readLine$val$502 = br.readLine ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          readLine$val$502 = br.readLine ();
        }
        if (!((buf = readLine$val$502) != null)) break;
        
        /* body */ _loop_1: {
// 99
          counter = 0;
// 100
          /* for loop starting here */ {
            /* initialization part */
            int i = 0;
            
            for (;;) {
              /* boolean expression part */
// 100
              int length$val$503;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
                try {
                  length$val$503 = buf.length ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                length$val$503 = buf.length ();
              }
              if (!(i < length$val$503)) break;
              
              /* body */ _loop_2: {
                boolean bool$val$16;
                
// 101
                char charAt$val$504;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
                  try {
                    charAt$val$504 = buf.charAt (i);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  charAt$val$504 = buf.charAt (i);
                }
                bool$val$16 = charAt$val$504 == '"';
                if (bool$val$16) {
                  bool$val$16 = counter == 0;
                }
// 101
                if (bool$val$16) {{
// 102
                    startPoint = i;
// 103
                    counter = 1;
                  }
                } else {
                  boolean bool$val$17;
                  
// 105
                  char charAt$val$505;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
                    try {
                      charAt$val$505 = buf.charAt (i);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    charAt$val$505 = buf.charAt (i);
                  }
                  bool$val$17 = charAt$val$505 == '"';
                  if (bool$val$17) {
                    bool$val$17 = counter == 1;
                  }
// 105
                  if (bool$val$17) {{
// 106
                      JP.go.ipa.oz.lib.standard._String_if substring$val$506;
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
                        try {
                          substring$val$506 = buf.substring (startPoint + 1, i);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        substring$val$506 = buf.substring (startPoint + 1, i);
                      }
// 106
                      labelName = substring$val$506;
// 107
                      counter = 2;
                    }
                  } else {
                    boolean bool$val$18;
                    
// 109
                    char charAt$val$507;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
                      try {
                        charAt$val$507 = buf.charAt (i);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      charAt$val$507 = buf.charAt (i);
                    }
                    bool$val$18 = charAt$val$507 == '"';
                    if (bool$val$18) {
                      bool$val$18 = counter == 2;
                    }
// 109
                    if (bool$val$18) {{
// 110
                        startPoint = i;
// 111
                        counter = 3;
                      }
                    } else {
                      boolean bool$val$19;
                      
// 113
                      char charAt$val$508;
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
                        try {
                          charAt$val$508 = buf.charAt (i);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        charAt$val$508 = buf.charAt (i);
                      }
                      bool$val$19 = charAt$val$508 == '"';
                      if (bool$val$19) {
                        bool$val$19 = counter == 3;
                      }
// 113
                      if (bool$val$19) {{
// 114
                          JP.go.ipa.oz.lib.standard._String_if substring$val$509;
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
                            try {
                              substring$val$509 = buf.substring (startPoint + 1, i);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            substring$val$509 = buf.substring (startPoint + 1, i);
                          }
// 114
                          interfaceID = substring$val$509;
// 115
                          counter = 4;
                        }
                      } else {
                        boolean bool$val$20;
                        
// 117
                        char charAt$val$510;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
                          try {
                            charAt$val$510 = buf.charAt (i);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          charAt$val$510 = buf.charAt (i);
                        }
                        bool$val$20 = charAt$val$510 == '"';
                        if (bool$val$20) {
                          bool$val$20 = counter == 4;
                        }
// 117
                        if (bool$val$20) {{
// 118
                            startPoint = i;
// 119
                            counter = 5;
                          }
                        } else {
                          boolean bool$val$21;
                          
// 121
                          char charAt$val$511;
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
                            try {
                              charAt$val$511 = buf.charAt (i);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            charAt$val$511 = buf.charAt (i);
                          }
                          bool$val$21 = charAt$val$511 == '"';
                          if (bool$val$21) {
                            bool$val$21 = counter == 5;
                          }
// 121
                          if (bool$val$21) {{
// 122
                              JP.go.ipa.oz.lib.standard._String_if substring$val$512;
                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
                                try {
                                  substring$val$512 = buf.substring (startPoint + 1, i);
                                } finally {
                                  changeRunningToGreen ();
                                }
                              } else {
                                substring$val$512 = buf.substring (startPoint + 1, i);
                              }
// 122
                              implementationID = substring$val$512;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
              /* iteration part */
// 100
              i++;
            }
          }
// 125
          JP.go.ipa.oz.user.ide.OzLabel_if tmpOzLabel = (JP.go.ipa.oz.user.ide.OzLabel_cl) (new JP.go.ipa.oz.user.ide.OzLabel_cl ())._new_create (subjectName, labelName, makeInterfaceID (interfaceID), makeImplementationID (implementationID));
// 126
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
            try {
              subject.putOzLabel (tmpOzLabel);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            subject.putOzLabel (tmpOzLabel);
          }
        }
      }
// 128
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) br)) {
        try {
          br.close ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        br.close ();
      }
// 129
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) isr)) {
        try {
          isr.close ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isr.close ();
      }
// 130
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fin)) {
        try {
          fin.close ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        fin.close ();
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
  
  public void saveToFile (JP.go.ipa.oz.lib.standard._String_if fileName, JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception  {
    checkSecureInvocation ();
// 38
    JP.go.ipa.oz.user.ide.OzLabel_if tmpOzLabel = null;
// 39
    JP.go.ipa.oz.lib.standard._String_if labelName = null, ifID = null, implID = null;
// 40
    JP.go.ipa.oz.user.ide.Subject_if subject = null;
// 41
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$513;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjects)) {
      try {
        iterator$val$513 = subjects.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$513 = subjects.iterator ();
    }
// 41
    JP.go.ipa.oz.lib.standard._Iterator_if sbjIterator = iterator$val$513;
// 42
    while (true) {
// 42
      boolean hasMoreElements$val$514;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbjIterator)) {
        try {
          hasMoreElements$val$514 = sbjIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$514 = sbjIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$514)) break;
      
      /* body */ _loop_1: {
// 43
        JP.go.ipa.oz.lang._Root_if nextElement$val$515;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbjIterator)) {
          try {
            nextElement$val$515 = sbjIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$515 = sbjIterator.nextElement ();
        }
// 43
        subject = (JP.go.ipa.oz.user.ide.Subject_if) (nextElement$val$515);
// 44
        JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$516;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
          try {
            getSubjectName$val$516 = subject.getSubjectName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSubjectName$val$516 = subject.getSubjectName ();
        }
// 44
        int compareTo$val$517;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSubjectName$val$516)) {
          try {
            compareTo$val$517 = getSubjectName$val$516.compareTo (subjectName);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          compareTo$val$517 = getSubjectName$val$516.compareTo (subjectName);
        }
// 44
        if (compareTo$val$517 == 0) {{
// 45
            break;
          }
        }
      }
    }
// 48
    JP.go.ipa.oz.lib.standard._Dictionary_if getOzLabels$val$518;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
      try {
        getOzLabels$val$518 = subject.getOzLabels ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabels$val$518 = subject.getOzLabels ();
    }
// 48
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$519;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getOzLabels$val$518)) {
      try {
        iterator$val$519 = getOzLabels$val$518.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$519 = getOzLabels$val$518.iterator ();
    }
// 48
    JP.go.ipa.oz.lib.standard._Iterator_if lblIterator = iterator$val$519;
// 49
    try {
// 50
      JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 51
      JP.go.ipa.oz.lib.standard._FileOutputStream_if fout = (JP.go.ipa.oz.lib.standard._FileOutputStream_cl) (new JP.go.ipa.oz.lib.standard._FileOutputStream_cl ())._new_breed (fileName);
// 52
      JP.go.ipa.oz.lib.standard._OutputStreamWriter_if osw = (JP.go.ipa.oz.lib.standard._OutputStreamWriter_cl) (new JP.go.ipa.oz.lib.standard._OutputStreamWriter_cl ())._new_breed (fout);
// 53
      JP.go.ipa.oz.lib.standard._BufferedWriter_if bw = (JP.go.ipa.oz.lib.standard._BufferedWriter_cl) (new JP.go.ipa.oz.lib.standard._BufferedWriter_cl ())._new_breed (osw);
// 55
      while (true) {
// 55
        boolean hasMoreElements$val$520;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
          try {
            hasMoreElements$val$520 = lblIterator.hasMoreElements ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          hasMoreElements$val$520 = lblIterator.hasMoreElements ();
        }
        if (!(hasMoreElements$val$520)) break;
        
        /* body */ _loop_1: {
// 56
          JP.go.ipa.oz.lang._Root_if nextElement$val$521;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblIterator)) {
            try {
              nextElement$val$521 = lblIterator.nextElement ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nextElement$val$521 = lblIterator.nextElement ();
          }
// 56
          tmpOzLabel = (JP.go.ipa.oz.user.ide.OzLabel_if) (nextElement$val$521);
// 57
          JP.go.ipa.oz.lib.standard._String_if getOzLabelName$val$522;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpOzLabel)) {
            try {
              getOzLabelName$val$522 = tmpOzLabel.getOzLabelName ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getOzLabelName$val$522 = tmpOzLabel.getOzLabelName ();
          }
// 57
          labelName = getOzLabelName$val$522;
// 58
          JP.go.ipa.oz.lib.standard._String_if getInterfaceID$val$523;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpOzLabel)) {
            try {
              getInterfaceID$val$523 = tmpOzLabel.getInterfaceID ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getInterfaceID$val$523 = tmpOzLabel.getInterfaceID ();
          }
// 58
          ifID = getInterfaceID$val$523;
// 59
          JP.go.ipa.oz.lib.standard._String_if getImplementationID$val$524;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpOzLabel)) {
            try {
              getImplementationID$val$524 = tmpOzLabel.getImplementationID ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getImplementationID$val$524 = tmpOzLabel.getImplementationID ();
          }
// 59
          implID = getImplementationID$val$524;
// 60
          JP.go.ipa.oz.lib.standard._String_if string$75 = (new JP.go.ipa.oz.lib.standard._String_cl("\""));
          
// 60
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$525;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$525 = buf.append (string$75);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$525 = buf.append (string$75);
          }
// 61
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$526;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$526 = buf.append (labelName);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$526 = buf.append (labelName);
          }
// 62
          JP.go.ipa.oz.lib.standard._String_if string$76 = (new JP.go.ipa.oz.lib.standard._String_cl("\",\""));
          
// 62
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$527;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$527 = buf.append (string$76);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$527 = buf.append (string$76);
          }
// 63
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$528;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$528 = buf.append (ifID);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$528 = buf.append (ifID);
          }
// 64
          JP.go.ipa.oz.lib.standard._String_if string$77 = (new JP.go.ipa.oz.lib.standard._String_cl("\",\""));
          
// 64
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$529;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$529 = buf.append (string$77);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$529 = buf.append (string$77);
          }
// 65
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$530;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$530 = buf.append (implID);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$530 = buf.append (implID);
          }
// 66
          JP.go.ipa.oz.lib.standard._String_if string$78 = (new JP.go.ipa.oz.lib.standard._String_cl("\"\n"));
          
// 66
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$531;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$531 = buf.append (string$78);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$531 = buf.append (string$78);
          }
        }
      }
// 69
      JP.go.ipa.oz.lib.standard._String_if asString$val$532;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
        try {
          asString$val$532 = buf.asString ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        asString$val$532 = buf.asString ();
      }
// 69
      int length$val$533;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
        try {
          length$val$533 = buf.length ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        length$val$533 = buf.length ();
      }
// 69
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bw)) {
        try {
          bw.write (asString$val$532, 0, length$val$533);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        bw.write (asString$val$532, 0, length$val$533);
      }
// 70
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bw)) {
        try {
          bw.close ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        bw.close ();
      }
// 71
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
    catch (JP.go.ipa.oz.lang.OzException _exception_2) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_2 = _exception_2.getOzException ();
      if (_oz_exception_2 instanceof JP.go.ipa.oz.lib.standard._FileNotFoundException_if) {
        JP.go.ipa.oz.lib.standard._FileNotFoundException_if e = (JP.go.ipa.oz.lib.standard._FileNotFoundException_if) _oz_exception_2;
      } else if (_oz_exception_2 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
        JP.go.ipa.oz.lib.standard._IOException_if e = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_2;
      } else throw _exception_2;
    }
  }
  
  public SchoolUtility_cl () throws Exception { super (); }
  
}


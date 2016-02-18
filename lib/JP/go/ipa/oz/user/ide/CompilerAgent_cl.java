package JP.go.ipa.oz.user.ide;

public class CompilerAgent_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.CompilerAgent_if {
  JP.go.ipa.oz.user.ide.School_if school;
  JP.go.ipa.oz.user.ide.Ozc_if aCompiler;
  JP.go.ipa.oz.user.ide.CompilerUtility_if compilerUtility;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.School_if sc, JP.go.ipa.oz.user.ide.CompilerUtility_if cu) throws Exception  {
// 52
    aCompiler = (JP.go.ipa.oz.user.ide.Ozc_cl) (new JP.go.ipa.oz.user.ide.Ozc_cl ())._new_create ();
// 53
    school = sc;
// 54
    compilerUtility = cu;
    return this;
  }
  
  public Object _new_create (JP.go.ipa.oz.user.ide.School_if sc) throws Exception  {
// 45
    aCompiler = (JP.go.ipa.oz.user.ide.Ozc_cl) (new JP.go.ipa.oz.user.ide.Ozc_cl ())._new_create ();
// 46
    school = sc;
// 47
    compilerUtility = null;
    return this;
  }
  
  public boolean compileOzFIlesForRelease (JP.go.ipa.oz.lib.standard._Array_if fileList, JP.go.ipa.oz.lib.standard._StringBuffer_if fullPath, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception  {
    checkSecureInvocation ();
// 261
    JP.go.ipa.oz.lib.standard._String_if tmp = null, classPath = null;
// 262
    JP.go.ipa.oz.lib.standard._StringBuffer_if filename = null, message = null;
// 263
    int size$val$91;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
      try {
        size$val$91 = fileList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$91 = fileList.size ();
    }
// 263
    int max = size$val$91;
// 264
    classPath = getReleaseDir ();
// 265
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < max)) break;
        
        /* body */ _loop_1: {
// 266
          JP.go.ipa.oz.lang._Root_if at$val$92;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
            try {
              at$val$92 = fileList.at (i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            at$val$92 = fileList.at (i);
          }
// 266
          tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$92);
// 267
          JP.go.ipa.oz.lib.standard._String_if asString$val$93;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fullPath)) {
            try {
              asString$val$93 = fullPath.asString ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            asString$val$93 = fullPath.asString ();
          }
// 267
          filename = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (asString$val$93);
// 268
          filename.append (tmp);
// 269
          JP.go.ipa.oz.lib.standard._String_if asString$val$94;
          asString$val$94 = filename.asString ();
// 269
          JP.go.ipa.oz.lib.standard._String_if string$43 = (new JP.go.ipa.oz.lib.standard._String_cl("_cl.oz"));
          
// 269
          boolean endsWith$val$95;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) asString$val$94)) {
            try {
              endsWith$val$95 = asString$val$94.endsWith (string$43);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            endsWith$val$95 = asString$val$94.endsWith (string$43);
          }
// 269
          if (!(endsWith$val$95)) {{
// 270
              if (!existClassFileForRelease (filename.asString ())) {{
// 271
                  JP.go.ipa.oz.lib.standard._String_if asString$val$96;
                  asString$val$96 = filename.asString ();
// 271
                  boolean compile$val$97;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aCompiler)) {
                    try {
                      compile$val$97 = aCompiler.compile (asString$val$96, school, classPath);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    compile$val$97 = aCompiler.compile (asString$val$96, school, classPath);
                  }
// 271
                  if (compile$val$97) {{
// 272
                      message = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (tmp);
// 273
                      message.append ((new JP.go.ipa.oz.lib.standard._String_cl(" compiled successfully.")));
// 274
                      JP.go.ipa.oz.lib.standard._String_if asString$val$98;
                      asString$val$98 = message.asString ();
// 274
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
                        try {
                          output.write (asString$val$98);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        output.write (asString$val$98);
                      }
                    }
                  } else {{
// 276
                      message = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (tmp);
// 277
                      message.append ((new JP.go.ipa.oz.lib.standard._String_cl(" compiled failed.")));
// 278
                      JP.go.ipa.oz.lib.standard._String_if asString$val$99;
                      asString$val$99 = message.asString ();
// 278
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
                        try {
                          output.write (asString$val$99);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        output.write (asString$val$99);
                      }
                    }
                  }
                }
              } else {{
// 281
                  message = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (tmp);
// 282
                  message.append ((new JP.go.ipa.oz.lib.standard._String_cl(" compiled successfully.")));
// 283
                  JP.go.ipa.oz.lib.standard._String_if asString$val$100;
                  asString$val$100 = message.asString ();
// 283
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
                    try {
                      output.write (asString$val$100);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    output.write (asString$val$100);
                  }
                }
              }
            }
          }
        }
        /* iteration part */
// 265
        i++;
      }
    }
// 287
    return true;
  }
  
  public void zipForRelease (JP.go.ipa.oz.lib.standard._String_if dirName, int flag, JP.go.ipa.oz.lib.standard._String_if zipFName) throws Exception  {
    checkSecureInvocation ();
// 426
    JP.go.ipa.oz.lib.standard._String_if tmp = null, classPath = null;
// 427
    JP.go.ipa.oz.lib.standard._StringBuffer_if filename = null, message = null;
// 428
    JP.go.ipa.oz.lib.standard._Array_if classFileList = null, zipFileList = null;
// 429
    int max = 0;
// 430
    classPath = getReleaseDir ();
// 432
    JP.go.ipa.oz.lib.standard._File_if classFile = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (classPath);
// 433
    int count = 0;
// 434
    JP.go.ipa.oz.lib.standard._Array_if list$val$101;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classFile)) {
      try {
        list$val$101 = classFile.list ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      list$val$101 = classFile.list ();
    }
// 434
    classFileList = list$val$101;
// 435
    if (classFileList != null) {{
// 436
        int size$val$102;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classFileList)) {
          try {
            size$val$102 = classFileList.size ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          size$val$102 = classFileList.size ();
        }
// 436
        max = size$val$102;
// 437
        zipFileList = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (max);
// 438
        /* for loop starting here */ {
          /* initialization part */
          int i = 0;
          
          for (;;) {
            /* boolean expression part */
            if (!(i < max)) break;
            
            /* body */ _loop_1: {
// 439
              JP.go.ipa.oz.lang._Root_if at$val$103;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classFileList)) {
                try {
                  at$val$103 = classFileList.at (i);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                at$val$103 = classFileList.at (i);
              }
// 439
              tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$103);
              boolean bool$val$1;
              
              bool$val$1 = flag == 1;
              if (bool$val$1) {
                boolean bool$val$2;
                
// 440
                JP.go.ipa.oz.lib.standard._String_if string$44 = (new JP.go.ipa.oz.lib.standard._String_cl("_if.class"));
                
// 440
                boolean endsWith$val$104;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                  try {
                    endsWith$val$104 = tmp.endsWith (string$44);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  endsWith$val$104 = tmp.endsWith (string$44);
                }
                bool$val$2 = endsWith$val$104;
                if (!bool$val$2) {
// 440
                  JP.go.ipa.oz.lib.standard._String_if string$45 = (new JP.go.ipa.oz.lib.standard._String_cl("_if.ci"));
                  
// 440
                  boolean endsWith$val$105;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                    try {
                      endsWith$val$105 = tmp.endsWith (string$45);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    endsWith$val$105 = tmp.endsWith (string$45);
                  }
                  bool$val$2 = endsWith$val$105;
                }
                bool$val$1 = (bool$val$2);
              }
// 440
              if (bool$val$1) {{
// 441
                  zipFileList.putAt (count, tmp);
// 442
                  count++;
                }
              } else {
                boolean bool$val$3;
                
                bool$val$3 = flag == 2;
                if (bool$val$3) {
                  boolean bool$val$4;
                  
                  boolean bool$val$5;
                  
// 444
                  JP.go.ipa.oz.lib.standard._String_if string$46 = (new JP.go.ipa.oz.lib.standard._String_cl("_cl.class"));
                  
// 444
                  boolean endsWith$val$106;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                    try {
                      endsWith$val$106 = tmp.endsWith (string$46);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    endsWith$val$106 = tmp.endsWith (string$46);
                  }
                  bool$val$5 = endsWith$val$106;
                  if (!bool$val$5) {
// 444
                    JP.go.ipa.oz.lib.standard._String_if string$47 = (new JP.go.ipa.oz.lib.standard._String_cl("_cl.ci"));
                    
// 444
                    boolean endsWith$val$107;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                      try {
                        endsWith$val$107 = tmp.endsWith (string$47);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      endsWith$val$107 = tmp.endsWith (string$47);
                    }
                    bool$val$5 = endsWith$val$107;
                  }
                  bool$val$4 = bool$val$5;
                  if (!bool$val$4) {
// 444
                    JP.go.ipa.oz.lib.standard._String_if string$48 = (new JP.go.ipa.oz.lib.standard._String_cl(".oz"));
                    
// 444
                    boolean endsWith$val$108;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                      try {
                        endsWith$val$108 = tmp.endsWith (string$48);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      endsWith$val$108 = tmp.endsWith (string$48);
                    }
                    bool$val$4 = endsWith$val$108;
                  }
                  bool$val$3 = (bool$val$4);
                }
// 444
                if (bool$val$3) {{
// 445
                    zipFileList.putAt (count, tmp);
// 446
                    count++;
                  }
                } else {
                  boolean bool$val$6;
                  
                  bool$val$6 = flag == 2;
                  if (bool$val$6) {
                    boolean bool$val$7;
                    
// 448
                    JP.go.ipa.oz.lib.standard._String_if string$49 = (new JP.go.ipa.oz.lib.standard._String_cl("_pcl.class"));
                    
// 448
                    boolean endsWith$val$109;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                      try {
                        endsWith$val$109 = tmp.endsWith (string$49);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      endsWith$val$109 = tmp.endsWith (string$49);
                    }
                    bool$val$7 = endsWith$val$109;
                    if (!bool$val$7) {
// 448
                      JP.go.ipa.oz.lib.standard._String_if string$50 = (new JP.go.ipa.oz.lib.standard._String_cl("_pcl.ci"));
                      
// 448
                      boolean endsWith$val$110;
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                        try {
                          endsWith$val$110 = tmp.endsWith (string$50);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        endsWith$val$110 = tmp.endsWith (string$50);
                      }
                      bool$val$7 = endsWith$val$110;
                    }
                    bool$val$6 = (bool$val$7);
                  }
// 448
                  if (bool$val$6) {{
// 449
                      zipFileList.putAt (count, tmp);
// 450
                      count++;
                    }
                  } else {
                    boolean bool$val$8;
                    
                    bool$val$8 = flag == 3;
                    if (bool$val$8) {
                      boolean bool$val$9;
                      
                      boolean bool$val$10;
                      
                      boolean bool$val$11;
                      
                      boolean bool$val$12;
                      
                      boolean bool$val$13;
                      
                      boolean bool$val$14;
                      
// 452
                      JP.go.ipa.oz.lib.standard._String_if string$51 = (new JP.go.ipa.oz.lib.standard._String_cl("_if.class"));
                      
// 452
                      boolean endsWith$val$111;
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                        try {
                          endsWith$val$111 = tmp.endsWith (string$51);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        endsWith$val$111 = tmp.endsWith (string$51);
                      }
                      bool$val$14 = endsWith$val$111;
                      if (!bool$val$14) {
// 452
                        JP.go.ipa.oz.lib.standard._String_if string$52 = (new JP.go.ipa.oz.lib.standard._String_cl("_if.ci"));
                        
// 452
                        boolean endsWith$val$112;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                          try {
                            endsWith$val$112 = tmp.endsWith (string$52);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          endsWith$val$112 = tmp.endsWith (string$52);
                        }
                        bool$val$14 = endsWith$val$112;
                      }
                      bool$val$13 = bool$val$14;
                      if (!bool$val$13) {
// 453
                        JP.go.ipa.oz.lib.standard._String_if string$53 = (new JP.go.ipa.oz.lib.standard._String_cl("_cl.class"));
                        
// 453
                        boolean endsWith$val$113;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                          try {
                            endsWith$val$113 = tmp.endsWith (string$53);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          endsWith$val$113 = tmp.endsWith (string$53);
                        }
                        bool$val$13 = endsWith$val$113;
                      }
                      bool$val$12 = bool$val$13;
                      if (!bool$val$12) {
// 453
                        JP.go.ipa.oz.lib.standard._String_if string$54 = (new JP.go.ipa.oz.lib.standard._String_cl("_cl.ci"));
                        
// 453
                        boolean endsWith$val$114;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                          try {
                            endsWith$val$114 = tmp.endsWith (string$54);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          endsWith$val$114 = tmp.endsWith (string$54);
                        }
                        bool$val$12 = endsWith$val$114;
                      }
                      bool$val$11 = bool$val$12;
                      if (!bool$val$11) {
// 453
                        JP.go.ipa.oz.lib.standard._String_if string$55 = (new JP.go.ipa.oz.lib.standard._String_cl(".oz"));
                        
// 453
                        boolean endsWith$val$115;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                          try {
                            endsWith$val$115 = tmp.endsWith (string$55);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          endsWith$val$115 = tmp.endsWith (string$55);
                        }
                        bool$val$11 = endsWith$val$115;
                      }
                      bool$val$10 = bool$val$11;
                      if (!bool$val$10) {
// 454
                        JP.go.ipa.oz.lib.standard._String_if string$56 = (new JP.go.ipa.oz.lib.standard._String_cl("_pcl.class"));
                        
// 454
                        boolean endsWith$val$116;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                          try {
                            endsWith$val$116 = tmp.endsWith (string$56);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          endsWith$val$116 = tmp.endsWith (string$56);
                        }
                        bool$val$10 = endsWith$val$116;
                      }
                      bool$val$9 = bool$val$10;
                      if (!bool$val$9) {
// 454
                        JP.go.ipa.oz.lib.standard._String_if string$57 = (new JP.go.ipa.oz.lib.standard._String_cl("_pcl.ci"));
                        
// 454
                        boolean endsWith$val$117;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                          try {
                            endsWith$val$117 = tmp.endsWith (string$57);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          endsWith$val$117 = tmp.endsWith (string$57);
                        }
                        bool$val$9 = endsWith$val$117;
                      }
                      bool$val$8 = (bool$val$9);
                    }
// 452
                    if (bool$val$8) {{
// 455
                        zipFileList.putAt (count, tmp);
// 456
                        count++;
                      }
                    }
                  }
                }
              }
            }
            /* iteration part */
// 438
            i++;
          }
        }
// 459
        zipFileList.resize (count);
      }
    }
// 461
    JP.go.ipa.oz.lib.standard._StringBuffer_if fName = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (classPath);
// 462
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$118;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fName)) {
      try {
        append$val$118 = fName.append (zipFName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$118 = fName.append (zipFName);
    }
// 463
    JP.go.ipa.oz.lib.standard._String_if string$58 = (new JP.go.ipa.oz.lib.standard._String_cl(".zip"));
    
// 463
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$119;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fName)) {
      try {
        append$val$119 = fName.append (string$58);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$119 = fName.append (string$58);
    }
// 464
    JP.go.ipa.oz.lib.standard._String_if asString$val$120;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fName)) {
      try {
        asString$val$120 = fName.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$120 = fName.asString ();
    }
// 464
    JP.go.ipa.oz.lib.standard._ZipArchive_if zip = (JP.go.ipa.oz.lib.standard._ZipArchive_cl) (new JP.go.ipa.oz.lib.standard._ZipArchive_cl ())._new_create (asString$val$120);
// 465
    JP.go.ipa.oz.lib.standard._String_if getClassDir2$val$121;
    getClassDir2$val$121 = getClassDir2 (dirName);
// 465
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) zip)) {
      try {
        zip.store (classPath, getClassDir2$val$121, zipFileList);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      zip.store (classPath, getClassDir2$val$121, zipFileList);
    }
  }
  
  public boolean compileOzFIles (JP.go.ipa.oz.lib.standard._Array_if fileList, JP.go.ipa.oz.lib.standard._StringBuffer_if fullPath, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception  {
    checkSecureInvocation ();
// 166
    JP.go.ipa.oz.lib.standard._String_if tmp = null;
// 167
    JP.go.ipa.oz.lib.standard._StringBuffer_if filename = null, message = null;
// 168
    int size$val$122;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
      try {
        size$val$122 = fileList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$122 = fileList.size ();
    }
// 168
    int max = size$val$122;
// 169
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < max)) break;
        
        /* body */ _loop_1: {
// 170
          JP.go.ipa.oz.lang._Root_if at$val$123;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
            try {
              at$val$123 = fileList.at (i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            at$val$123 = fileList.at (i);
          }
// 170
          tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$123);
// 171
          JP.go.ipa.oz.lib.standard._String_if asString$val$124;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fullPath)) {
            try {
              asString$val$124 = fullPath.asString ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            asString$val$124 = fullPath.asString ();
          }
// 171
          filename = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (asString$val$124);
// 172
          filename.append (tmp);
// 173
          JP.go.ipa.oz.lib.standard._String_if asString$val$125;
          asString$val$125 = filename.asString ();
// 173
          JP.go.ipa.oz.lib.standard._String_if string$59 = (new JP.go.ipa.oz.lib.standard._String_cl("_cl.oz"));
          
// 173
          boolean endsWith$val$126;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) asString$val$125)) {
            try {
              endsWith$val$126 = asString$val$125.endsWith (string$59);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            endsWith$val$126 = asString$val$125.endsWith (string$59);
          }
// 173
          if (!(endsWith$val$126)) {{
// 174
              if (!existClassFile (filename.asString ())) {{
// 175
                  JP.go.ipa.oz.lib.standard._String_if asString$val$127;
                  asString$val$127 = filename.asString ();
// 175
                  boolean compile$val$128;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aCompiler)) {
                    try {
                      compile$val$128 = aCompiler.compile (asString$val$127, school);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    compile$val$128 = aCompiler.compile (asString$val$127, school);
                  }
// 175
                  if (compile$val$128) {{
// 176
                      message = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (tmp);
// 177
                      message.append ((new JP.go.ipa.oz.lib.standard._String_cl(" compiled successfully.")));
// 178
                      JP.go.ipa.oz.lib.standard._String_if asString$val$129;
                      asString$val$129 = message.asString ();
// 178
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
                        try {
                          output.write (asString$val$129);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        output.write (asString$val$129);
                      }
                    }
                  } else {{
// 180
                      message = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (tmp);
// 181
                      message.append ((new JP.go.ipa.oz.lib.standard._String_cl(" compiled failed.")));
// 182
                      JP.go.ipa.oz.lib.standard._String_if asString$val$130;
                      asString$val$130 = message.asString ();
// 182
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
                        try {
                          output.write (asString$val$130);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        output.write (asString$val$130);
                      }
                    }
                  }
                }
              } else {{
// 185
                  message = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (tmp);
// 186
                  message.append ((new JP.go.ipa.oz.lib.standard._String_cl(" compiled successfully.")));
// 187
                  JP.go.ipa.oz.lib.standard._String_if asString$val$131;
                  asString$val$131 = message.asString ();
// 187
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
                    try {
                      output.write (asString$val$131);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    output.write (asString$val$131);
                  }
                }
              }
            }
          }
        }
        /* iteration part */
// 169
        i++;
      }
    }
// 191
    return true;
  }
  
  public boolean deleteAllFiles () throws Exception  {
    checkSecureInvocation ();
// 238
    JP.go.ipa.oz.lib.standard._StringBuffer_if filename = null;
// 239
    JP.go.ipa.oz.lib.standard._String_if tmp = null, classPath = null;
// 240
    int max = 0;
// 241
    classPath = getReleaseDir ();
// 242
    JP.go.ipa.oz.lib.standard._Array_if classFileList = null;
// 243
    JP.go.ipa.oz.lib.standard._File_if classFile = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (classPath);
// 244
    JP.go.ipa.oz.lib.standard._File_if delFile = null;
// 245
    JP.go.ipa.oz.lib.standard._Array_if list$val$132;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classFile)) {
      try {
        list$val$132 = classFile.list ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      list$val$132 = classFile.list ();
    }
// 245
    classFileList = list$val$132;
// 246
    if (classFileList != null) {{
// 247
        int size$val$133;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classFileList)) {
          try {
            size$val$133 = classFileList.size ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          size$val$133 = classFileList.size ();
        }
// 247
        max = size$val$133;
// 248
        /* for loop starting here */ {
          /* initialization part */
          int i = 0;
          
          for (;;) {
            /* boolean expression part */
            if (!(i < max)) break;
            
            /* body */ _loop_1: {
// 249
              JP.go.ipa.oz.lang._Root_if at$val$134;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classFileList)) {
                try {
                  at$val$134 = classFileList.at (i);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                at$val$134 = classFileList.at (i);
              }
// 249
              tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$134);
// 250
              filename = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (classPath);
// 251
              filename.append (tmp);
// 252
              delFile = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (filename.asString ());
// 253
              if (delFile.isFile ()) {
// 254
                delFile.delete ();
              }
            }
            /* iteration part */
// 248
            i++;
          }
        }
      }
    }
// 257
    return true;
  }
  
  public boolean compileModifiedLabels (JP.go.ipa.oz.lib.standard._Set_if labels) throws Exception  {
    checkSecureInvocation ();
// 404
    return true;
  }
  
  public JP.go.ipa.oz.user.ide.School_if getSchool () throws Exception  {
    checkSecureInvocation ();
// 81
    return school;
  }
  
  public boolean compileSubject (JP.go.ipa.oz.lib.standard._String_if dirName, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception  {
    checkSecureInvocation ();
// 121
    JP.go.ipa.oz.lib.standard._StringBuffer_if fullPath = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (dirName);
// 123
    JP.go.ipa.oz.lib.standard._String_if getKugiri$val$135;
    getKugiri$val$135 = getKugiri ();
// 123
    boolean endsWith$val$136;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dirName)) {
      try {
        endsWith$val$136 = dirName.endsWith (getKugiri$val$135);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      endsWith$val$136 = dirName.endsWith (getKugiri$val$135);
    }
// 123
    if (!(endsWith$val$136)) {
// 124
      JP.go.ipa.oz.lib.standard._String_if getKugiri$val$137;
      getKugiri$val$137 = getKugiri ();
// 124
      JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$138;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fullPath)) {
        try {
          append$val$138 = fullPath.append (getKugiri$val$137);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        append$val$138 = fullPath.append (getKugiri$val$137);
      }
    }
// 127
    JP.go.ipa.oz.lib.standard._Array_if fileList = null;
// 128
    JP.go.ipa.oz.lib.standard._File_if file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (dirName);
// 129
    JP.go.ipa.oz.user.ide.ExtensionFilter_if filter = (JP.go.ipa.oz.user.ide.ExtensionFilter_cl) (new JP.go.ipa.oz.user.ide.ExtensionFilter_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl(".oz")));
// 130
    JP.go.ipa.oz.lib.standard._Array_if list$val$139;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        list$val$139 = file.list (filter);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      list$val$139 = file.list (filter);
    }
// 130
    fileList = list$val$139;
// 131
    if (fileList == null) {
// 131
      return false;
    }
// 132
    deleteClassFiles (fileList);
// 133
    compileOzFIles (fileList, fullPath, output);
// 135
    return true;
  }
  
  public boolean compile (JP.go.ipa.oz.lib.standard._String_if source, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception  {
    checkSecureInvocation ();
// 101
    boolean compile$val$140;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aCompiler)) {
      try {
        compile$val$140 = aCompiler.compile (source, school, output);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compile$val$140 = aCompiler.compile (source, school, output);
    }
// 101
    return compile$val$140;
  }
  
  public boolean compile (JP.go.ipa.oz.lib.standard._String_if source) throws Exception  {
    checkSecureInvocation ();
// 95
    boolean compile$val$141;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aCompiler)) {
      try {
        compile$val$141 = aCompiler.compile (source, school);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compile$val$141 = aCompiler.compile (source, school);
    }
// 95
    return compile$val$141;
  }
  
  public void deleteLabels (JP.go.ipa.oz.lib.standard._Set_if labels) throws Exception  {
    checkSecureInvocation ();
// 367
    JP.go.ipa.oz.lib.standard._String_if tmp = null, kugiri = null;
// 368
    kugiri = getKugiri ();
// 369
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 370
    JP.go.ipa.oz.lib.standard._String_if getOzHome$val$142;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getOzHome$val$142 = system.getOzHome ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzHome$val$142 = system.getOzHome ();
    }
// 370
    JP.go.ipa.oz.lib.standard._String_if ozHome = getOzHome$val$142;
// 371
    JP.go.ipa.oz.lib.standard._StringBuffer_if filePath = null;
// 372
    JP.go.ipa.oz.lib.standard._File_if delFile = null;
// 373
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 374
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$143;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labels)) {
      try {
        iterator$val$143 = labels.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$143 = labels.iterator ();
    }
// 374
    itr = iterator$val$143;
// 375
    while (true) {
// 375
      boolean hasMoreElements$val$144;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
        try {
          hasMoreElements$val$144 = itr.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$144 = itr.hasMoreElements ();
      }
      if (!(hasMoreElements$val$144)) break;
      
      /* body */ _loop_1: {
// 376
        JP.go.ipa.oz.lang._Root_if nextElement$val$145;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
          try {
            nextElement$val$145 = itr.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$145 = itr.nextElement ();
        }
// 376
        tmp = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$145);
// 377
        filePath = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (ozHome);
// 378
        boolean endsWith$val$146;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
          try {
            endsWith$val$146 = ozHome.endsWith (kugiri);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          endsWith$val$146 = ozHome.endsWith (kugiri);
        }
// 378
        if (!(endsWith$val$146)) {
// 379
          filePath.append (kugiri);
        }
// 380
        filePath.append ((new JP.go.ipa.oz.lib.standard._String_cl("lib")));
// 381
        filePath.append (kugiri);
// 382
        if (kugiri == (new JP.go.ipa.oz.lib.standard._String_cl("/"))) {
// 383
          JP.go.ipa.oz.lib.standard._String_if replace$val$147;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
            try {
              replace$val$147 = tmp.replace ('.', '/');
            } finally {
              changeRunningToGreen ();
            }
          } else {
            replace$val$147 = tmp.replace ('.', '/');
          }
// 383
          tmp = replace$val$147;
        } else {
// 385
          JP.go.ipa.oz.lib.standard._String_if replace$val$148;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
            try {
              replace$val$148 = tmp.replace ('.', '\\');
            } finally {
              changeRunningToGreen ();
            }
          } else {
            replace$val$148 = tmp.replace ('.', '\\');
          }
// 385
          tmp = replace$val$148;
        }
// 386
        filePath.append (tmp);
// 387
        filePath.append ((new JP.go.ipa.oz.lib.standard._String_cl(".class")));
// 388
        tmp = filePath.asString ();
// 389
        delFile = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (tmp);
// 390
        if (delFile.exists ()) {{
// 391
            delFile.delete ();
// 392
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
              try {
                system.println (tmp);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              system.println (tmp);
            }
          }
        }
// 394
        tmp = replace (tmp, (new JP.go.ipa.oz.lib.standard._String_cl("_cl")), (new JP.go.ipa.oz.lib.standard._String_cl("_if")));
// 395
        delFile = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (tmp);
// 396
        if (delFile.exists ()) {{
// 397
            delFile.delete ();
// 398
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
              try {
                system.println (tmp);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              system.println (tmp);
            }
          }
        }
      }
    }
  }
  
  public boolean existClassFileForRelease (JP.go.ipa.oz.lib.standard._String_if filename) throws Exception  {
    checkSecureInvocation ();
// 291
    JP.go.ipa.oz.lib.standard._String_if labelName = null;
// 292
    JP.go.ipa.oz.lib.standard._StringBuffer_if classPath = null;
// 293
    JP.go.ipa.oz.lib.standard._String_if getKugiri$val$149;
    getKugiri$val$149 = getKugiri ();
// 293
    int lastIndexOf$val$150;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) filename)) {
      try {
        lastIndexOf$val$150 = filename.lastIndexOf (getKugiri$val$149);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$150 = filename.lastIndexOf (getKugiri$val$149);
    }
// 293
    JP.go.ipa.oz.lib.standard._String_if string$60 = (new JP.go.ipa.oz.lib.standard._String_cl("."));
    
// 293
    int lastIndexOf$val$151;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) filename)) {
      try {
        lastIndexOf$val$151 = filename.lastIndexOf (string$60);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$151 = filename.lastIndexOf (string$60);
    }
// 293
    JP.go.ipa.oz.lib.standard._String_if substring$val$152;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) filename)) {
      try {
        substring$val$152 = filename.substring (lastIndexOf$val$150 + 1, lastIndexOf$val$151);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$152 = filename.substring (lastIndexOf$val$150 + 1, lastIndexOf$val$151);
    }
// 293
    labelName = substring$val$152;
// 294
    classPath = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (getReleaseDir ());
// 295
    classPath.append (labelName);
// 296
    classPath.append ((new JP.go.ipa.oz.lib.standard._String_cl("_cl.class")));
// 297
    JP.go.ipa.oz.lib.standard._File_if classFile = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (classPath.asString ());
// 298
    boolean isFile$val$153;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classFile)) {
      try {
        isFile$val$153 = classFile.isFile ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isFile$val$153 = classFile.isFile ();
    }
// 298
    if (isFile$val$153) {{
// 299
        return true;
      }
    }
// 301
    return false;
  }
  
  public boolean compileSubjectForRelease (JP.go.ipa.oz.lib.standard._String_if dirName, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception  {
    checkSecureInvocation ();
// 213
    JP.go.ipa.oz.lib.standard._StringBuffer_if fullPath = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (dirName);
// 215
    JP.go.ipa.oz.lib.standard._String_if getKugiri$val$154;
    getKugiri$val$154 = getKugiri ();
// 215
    boolean endsWith$val$155;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dirName)) {
      try {
        endsWith$val$155 = dirName.endsWith (getKugiri$val$154);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      endsWith$val$155 = dirName.endsWith (getKugiri$val$154);
    }
// 215
    if (!(endsWith$val$155)) {
// 216
      JP.go.ipa.oz.lib.standard._String_if getKugiri$val$156;
      getKugiri$val$156 = getKugiri ();
// 216
      JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$157;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fullPath)) {
        try {
          append$val$157 = fullPath.append (getKugiri$val$156);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        append$val$157 = fullPath.append (getKugiri$val$156);
      }
    }
// 219
    JP.go.ipa.oz.lib.standard._Array_if fileList = null;
// 220
    JP.go.ipa.oz.lib.standard._File_if file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (dirName);
// 221
    JP.go.ipa.oz.user.ide.ExtensionFilter_if filter = (JP.go.ipa.oz.user.ide.ExtensionFilter_cl) (new JP.go.ipa.oz.user.ide.ExtensionFilter_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl(".oz")));
// 222
    JP.go.ipa.oz.lib.standard._Array_if list$val$158;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        list$val$158 = file.list (filter);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      list$val$158 = file.list (filter);
    }
// 222
    fileList = list$val$158;
// 223
    if (fileList == null) {
// 223
      return false;
    }
// 225
    JP.go.ipa.oz.lib.standard._File_if releaseDir = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (getReleaseDir ());
// 226
    boolean isDirectory$val$159;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) releaseDir)) {
      try {
        isDirectory$val$159 = releaseDir.isDirectory ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isDirectory$val$159 = releaseDir.isDirectory ();
    }
// 226
    if (!(isDirectory$val$159)) {{
// 227
        boolean mkdir$val$160;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) releaseDir)) {
          try {
            mkdir$val$160 = releaseDir.mkdir ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          mkdir$val$160 = releaseDir.mkdir ();
        }
      }
    }
// 229
    deleteAllFiles ();
// 230
    deleteClassFiles (fileList);
// 231
    compileOzFIlesForRelease (fileList, fullPath, output);
// 233
    return true;
  }
  
  public boolean release (JP.go.ipa.oz.lib.standard._String_if dirName, int flag, JP.go.ipa.oz.lib.standard._String_if zipFName) throws Exception  {
    checkSecureInvocation ();
// 412
    JP.go.ipa.oz.lib.standard._Array_if fileList = null;
// 413
    JP.go.ipa.oz.lib.standard._File_if file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (dirName);
// 414
    JP.go.ipa.oz.user.ide.ExtensionFilter_if filter = (JP.go.ipa.oz.user.ide.ExtensionFilter_cl) (new JP.go.ipa.oz.user.ide.ExtensionFilter_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl(".oz")));
// 415
    JP.go.ipa.oz.lib.standard._Array_if list$val$161;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        list$val$161 = file.list (filter);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      list$val$161 = file.list (filter);
    }
// 415
    fileList = list$val$161;
// 416
    if (fileList == null) {
// 416
      return false;
    }
// 418
    zipForRelease (dirName, flag, zipFName);
// 420
    return true;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getKugiri () throws Exception  {
    checkSecureInvocation ();
// 598
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 599
    JP.go.ipa.oz.lib.standard._String_if getOzHome$val$162;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getOzHome$val$162 = system.getOzHome ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzHome$val$162 = system.getOzHome ();
    }
// 599
    JP.go.ipa.oz.lib.standard._String_if ozHome = getOzHome$val$162;
// 600
    JP.go.ipa.oz.lib.standard._String_if string$61 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    
// 600
    boolean startsWith$val$163;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
      try {
        startsWith$val$163 = ozHome.startsWith (string$61);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$163 = ozHome.startsWith (string$61);
    }
// 600
    if (startsWith$val$163) {
// 601
      return (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    } else {
// 603
      return (new JP.go.ipa.oz.lib.standard._String_cl("\\"));
    }
  }
  
  public boolean compileAuto (JP.go.ipa.oz.lib.standard._String_if dirName, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception  {
    checkSecureInvocation ();
// 308
    JP.go.ipa.oz.lib.standard._Set_if modifiedLabels = null;
// 310
    modifiedLabels = relatedLabels (dirName);
// 312
    deleteLabels (modifiedLabels);
// 314
    JP.go.ipa.oz.lib.standard._String_if kugiri = getKugiri ();
// 315
    JP.go.ipa.oz.lib.standard._StringBuffer_if fullPath = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (dirName);
// 316
    boolean endsWith$val$164;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dirName)) {
      try {
        endsWith$val$164 = dirName.endsWith (kugiri);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      endsWith$val$164 = dirName.endsWith (kugiri);
    }
// 316
    if (!(endsWith$val$164)) {
// 317
      JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$165;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fullPath)) {
        try {
          append$val$165 = fullPath.append (kugiri);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        append$val$165 = fullPath.append (kugiri);
      }
    }
// 319
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 320
    int size$val$166;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) modifiedLabels)) {
      try {
        size$val$166 = modifiedLabels.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$166 = modifiedLabels.size ();
    }
// 320
    int max = size$val$166;
// 321
    if (max == 0) {
// 321
      JP.go.ipa.oz.lib.standard._String_if string$62 = (new JP.go.ipa.oz.lib.standard._String_cl("files were not changed."));
      
// 321
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
        try {
          output.write (string$62);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        output.write (string$62);
      }
    }
// 322
    int count = 0;
// 323
    JP.go.ipa.oz.lib.standard._Array_if fileList = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (max);
// 324
    JP.go.ipa.oz.lib.standard._String_if tmp = null;
// 325
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = null;
// 326
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 327
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$167;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) modifiedLabels)) {
      try {
        iterator$val$167 = modifiedLabels.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$167 = modifiedLabels.iterator ();
    }
// 327
    itr = iterator$val$167;
// 328
    while (true) {
// 328
      boolean hasMoreElements$val$168;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
        try {
          hasMoreElements$val$168 = itr.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$168 = itr.hasMoreElements ();
      }
      if (!(hasMoreElements$val$168)) break;
      
      /* body */ _loop_1: {
// 329
        JP.go.ipa.oz.lang._Root_if nextElement$val$169;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
          try {
            nextElement$val$169 = itr.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$169 = itr.nextElement ();
        }
// 329
        tmp = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$169);
// 330
        JP.go.ipa.oz.lib.standard._String_if string$63 = (new JP.go.ipa.oz.lib.standard._String_cl("."));
        
// 330
        int lastIndexOf$val$170;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
          try {
            lastIndexOf$val$170 = tmp.lastIndexOf (string$63);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          lastIndexOf$val$170 = tmp.lastIndexOf (string$63);
        }
// 330
        JP.go.ipa.oz.lib.standard._String_if string$64 = (new JP.go.ipa.oz.lib.standard._String_cl("_"));
        
// 330
        int lastIndexOf$val$171;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
          try {
            lastIndexOf$val$171 = tmp.lastIndexOf (string$64);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          lastIndexOf$val$171 = tmp.lastIndexOf (string$64);
        }
// 330
        JP.go.ipa.oz.lib.standard._String_if substring$val$172;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
          try {
            substring$val$172 = tmp.substring (lastIndexOf$val$170 + 1, lastIndexOf$val$171);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          substring$val$172 = tmp.substring (lastIndexOf$val$170 + 1, lastIndexOf$val$171);
        }
// 330
        tmp = substring$val$172;
// 331
        buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (tmp);
// 332
        buf.append ((new JP.go.ipa.oz.lib.standard._String_cl(".oz")));
// 333
        tmp = buf.asString ();
// 334
        JP.go.ipa.oz.lib.standard._Array_if putAt$val$173;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
          try {
            putAt$val$173 = fileList.putAt (count, tmp);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          putAt$val$173 = fileList.putAt (count, tmp);
        }
// 335
        count++;
// 336
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.println (tmp);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.println (tmp);
        }
      }
    }
// 338
    return compileOzFIles (fileList, fullPath, output);
  }
  
  public boolean existClassFile (JP.go.ipa.oz.lib.standard._String_if filename) throws Exception  {
    checkSecureInvocation ();
// 195
    JP.go.ipa.oz.lib.standard._String_if labelName = null;
// 196
    JP.go.ipa.oz.lib.standard._StringBuffer_if classPath = null;
// 197
    JP.go.ipa.oz.lib.standard._String_if getKugiri$val$174;
    getKugiri$val$174 = getKugiri ();
// 197
    int lastIndexOf$val$175;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) filename)) {
      try {
        lastIndexOf$val$175 = filename.lastIndexOf (getKugiri$val$174);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$175 = filename.lastIndexOf (getKugiri$val$174);
    }
// 197
    JP.go.ipa.oz.lib.standard._String_if string$65 = (new JP.go.ipa.oz.lib.standard._String_cl("."));
    
// 197
    int lastIndexOf$val$176;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) filename)) {
      try {
        lastIndexOf$val$176 = filename.lastIndexOf (string$65);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$176 = filename.lastIndexOf (string$65);
    }
// 197
    JP.go.ipa.oz.lib.standard._String_if substring$val$177;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) filename)) {
      try {
        substring$val$177 = filename.substring (lastIndexOf$val$175 + 1, lastIndexOf$val$176);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$177 = filename.substring (lastIndexOf$val$175 + 1, lastIndexOf$val$176);
    }
// 197
    labelName = substring$val$177;
// 198
    JP.go.ipa.oz.lib.standard._String_if getLabelPath$val$178;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        getLabelPath$val$178 = school.getLabelPath (labelName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getLabelPath$val$178 = school.getLabelPath (labelName);
    }
// 198
    classPath = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (getLabelPath$val$178);
// 199
    classPath.append (labelName);
// 200
    classPath.append ((new JP.go.ipa.oz.lib.standard._String_cl("_cl.class")));
// 201
    JP.go.ipa.oz.lib.standard._File_if classFile = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (classPath.asString ());
// 202
    boolean isFile$val$179;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classFile)) {
      try {
        isFile$val$179 = classFile.isFile ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isFile$val$179 = classFile.isFile ();
    }
// 202
    if (isFile$val$179) {{
// 203
        return true;
      }
    }
// 205
    return false;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getClassDir2 (JP.go.ipa.oz.lib.standard._String_if dirName) throws Exception  {
    checkSecureInvocation ();
// 498
    JP.go.ipa.oz.lib.standard._Array_if fileList = null;
// 499
    JP.go.ipa.oz.lib.standard._File_if file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (dirName);
// 500
    JP.go.ipa.oz.user.ide.ExtensionFilter_if filter = (JP.go.ipa.oz.user.ide.ExtensionFilter_cl) (new JP.go.ipa.oz.user.ide.ExtensionFilter_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl(".oz")));
// 501
    JP.go.ipa.oz.lib.standard._Array_if list$val$180;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        list$val$180 = file.list (filter);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      list$val$180 = file.list (filter);
    }
// 501
    fileList = list$val$180;
// 502
    if (fileList == null) {
// 502
      return (new JP.go.ipa.oz.lib.standard._String_cl(""));
    }
// 504
    JP.go.ipa.oz.lib.standard._String_if classPath = null;
// 505
    JP.go.ipa.oz.lib.standard._StringBuffer_if filename = null, message = null;
// 506
    JP.go.ipa.oz.lib.standard._Array_if classFileList = null, zipFileList = null;
// 507
    int size$val$181;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
      try {
        size$val$181 = fileList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$181 = fileList.size ();
    }
// 507
    int max = size$val$181;
// 509
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < max)) break;
        
        /* body */ _loop_1: {
// 510
          JP.go.ipa.oz.lang._Root_if at$val$182;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
            try {
              at$val$182 = fileList.at (i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            at$val$182 = fileList.at (i);
          }
// 510
          classPath = (JP.go.ipa.oz.lib.standard._String_if) (at$val$182);
// 511
          JP.go.ipa.oz.lib.standard._String_if string$66 = (new JP.go.ipa.oz.lib.standard._String_cl("_cl.oz"));
          
// 511
          boolean endsWith$val$183;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classPath)) {
            try {
              endsWith$val$183 = classPath.endsWith (string$66);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            endsWith$val$183 = classPath.endsWith (string$66);
          }
// 511
          if (!(endsWith$val$183)) {
// 511
            break;
          }
        }
        /* iteration part */
// 509
        i++;
      }
    }
// 513
    JP.go.ipa.oz.lib.standard._String_if string$67 = (new JP.go.ipa.oz.lib.standard._String_cl("."));
    
// 513
    int lastIndexOf$val$184;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classPath)) {
      try {
        lastIndexOf$val$184 = classPath.lastIndexOf (string$67);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$184 = classPath.lastIndexOf (string$67);
    }
// 513
    JP.go.ipa.oz.lib.standard._String_if substring$val$185;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classPath)) {
      try {
        substring$val$185 = classPath.substring (0, lastIndexOf$val$184);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$185 = classPath.substring (0, lastIndexOf$val$184);
    }
// 513
    classPath = substring$val$185;
// 517
    JP.go.ipa.oz.user.ide.OzLabel_if getOzLabel$val$186;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        getOzLabel$val$186 = school.getOzLabel (classPath);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabel$val$186 = school.getOzLabel (classPath);
    }
// 517
    JP.go.ipa.oz.user.ide.OzLabel_if tmpLabel = getOzLabel$val$186;
// 518
    JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$187;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpLabel)) {
      try {
        getSubjectName$val$187 = tmpLabel.getSubjectName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSubjectName$val$187 = tmpLabel.getSubjectName ();
    }
// 518
    JP.go.ipa.oz.user.ide.Subject_if getSubject$val$188;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        getSubject$val$188 = school.getSubject (getSubjectName$val$187);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSubject$val$188 = school.getSubject (getSubjectName$val$187);
    }
// 518
    JP.go.ipa.oz.user.ide.Subject_if subject = getSubject$val$188;
// 519
    JP.go.ipa.oz.lib.standard._String_if getPackageName$val$189;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
      try {
        getPackageName$val$189 = subject.getPackageName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getPackageName$val$189 = subject.getPackageName ();
    }
// 519
    classPath = getPackageName$val$189;
// 520
    JP.go.ipa.oz.lib.standard._String_if replace$val$190;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classPath)) {
      try {
        replace$val$190 = classPath.replace ('.', '/');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      replace$val$190 = classPath.replace ('.', '/');
    }
// 520
    JP.go.ipa.oz.lib.standard._StringBuffer_if tmp = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (replace$val$190);
// 521
    JP.go.ipa.oz.lib.standard._String_if string$68 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    
// 521
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$191;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
      try {
        append$val$191 = tmp.append (string$68);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$191 = tmp.append (string$68);
    }
// 522
    JP.go.ipa.oz.lib.standard._String_if asString$val$192;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
      try {
        asString$val$192 = tmp.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$192 = tmp.asString ();
    }
// 522
    return asString$val$192;
  }
  
  public JP.go.ipa.oz.lib.standard._Array_if getModFiles (JP.go.ipa.oz.lib.standard._String_if sourceDir, JP.go.ipa.oz.lib.standard._String_if classDir) throws Exception  {
    checkSecureInvocation ();
// 528
    JP.go.ipa.oz.lib.standard._StringBuffer_if dir1 = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (sourceDir);
    boolean bool$val$15;
    
// 529
    JP.go.ipa.oz.lib.standard._String_if string$69 = (new JP.go.ipa.oz.lib.standard._String_cl("\\"));
    
// 529
    boolean endsWith$val$193;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sourceDir)) {
      try {
        endsWith$val$193 = sourceDir.endsWith (string$69);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      endsWith$val$193 = sourceDir.endsWith (string$69);
    }
    bool$val$15 = endsWith$val$193;
    if (!bool$val$15) {
// 529
      JP.go.ipa.oz.lib.standard._String_if string$70 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
      
// 529
      boolean endsWith$val$194;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sourceDir)) {
        try {
          endsWith$val$194 = sourceDir.endsWith (string$70);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        endsWith$val$194 = sourceDir.endsWith (string$70);
      }
      bool$val$15 = endsWith$val$194;
    }
// 529
    if (!(bool$val$15)) {
// 530
      JP.go.ipa.oz.lib.standard._String_if getKugiri$val$195;
      getKugiri$val$195 = getKugiri ();
// 530
      JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$196;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dir1)) {
        try {
          append$val$196 = dir1.append (getKugiri$val$195);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        append$val$196 = dir1.append (getKugiri$val$195);
      }
    }
// 531
    JP.go.ipa.oz.lib.standard._String_if asString$val$197;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dir1)) {
      try {
        asString$val$197 = dir1.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$197 = dir1.asString ();
    }
// 531
    sourceDir = asString$val$197;
// 532
    JP.go.ipa.oz.lib.standard._StringBuffer_if dir2 = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (classDir);
    boolean bool$val$16;
    
// 533
    JP.go.ipa.oz.lib.standard._String_if string$71 = (new JP.go.ipa.oz.lib.standard._String_cl("\\"));
    
// 533
    boolean endsWith$val$198;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classDir)) {
      try {
        endsWith$val$198 = classDir.endsWith (string$71);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      endsWith$val$198 = classDir.endsWith (string$71);
    }
    bool$val$16 = endsWith$val$198;
    if (!bool$val$16) {
// 533
      JP.go.ipa.oz.lib.standard._String_if string$72 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
      
// 533
      boolean endsWith$val$199;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classDir)) {
        try {
          endsWith$val$199 = classDir.endsWith (string$72);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        endsWith$val$199 = classDir.endsWith (string$72);
      }
      bool$val$16 = endsWith$val$199;
    }
// 533
    if (!(bool$val$16)) {
// 534
      JP.go.ipa.oz.lib.standard._String_if getKugiri$val$200;
      getKugiri$val$200 = getKugiri ();
// 534
      JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$201;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dir2)) {
        try {
          append$val$201 = dir2.append (getKugiri$val$200);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        append$val$201 = dir2.append (getKugiri$val$200);
      }
    }
// 535
    JP.go.ipa.oz.lib.standard._String_if asString$val$202;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dir2)) {
      try {
        asString$val$202 = dir2.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$202 = dir2.asString ();
    }
// 535
    classDir = asString$val$202;
// 537
    JP.go.ipa.oz.lib.standard._Array_if sourceList = null, modFileList = null;
// 538
    JP.go.ipa.oz.lib.standard._File_if file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (sourceDir);
// 539
    JP.go.ipa.oz.user.ide.ExtensionFilter_if filter = (JP.go.ipa.oz.user.ide.ExtensionFilter_cl) (new JP.go.ipa.oz.user.ide.ExtensionFilter_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl(".oz")));
// 540
    JP.go.ipa.oz.lib.standard._Array_if list$val$203;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        list$val$203 = file.list (filter);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      list$val$203 = file.list (filter);
    }
// 540
    sourceList = list$val$203;
// 541
    if (sourceList == null) {
// 541
      return null;
    }
// 543
    int size$val$204;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sourceList)) {
      try {
        size$val$204 = sourceList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$204 = sourceList.size ();
    }
// 543
    int max = size$val$204;
// 544
    int count = 0;
// 545
    JP.go.ipa.oz.lib.standard._String_if tmp = null;
// 546
    JP.go.ipa.oz.lib.standard._Array_if tmpList = sourceList;
// 547
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < max)) break;
        
        /* body */ _loop_1: {
// 548
          JP.go.ipa.oz.lang._Root_if at$val$205;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpList)) {
            try {
              at$val$205 = tmpList.at (i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            at$val$205 = tmpList.at (i);
          }
// 548
          tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$205);
// 549
          JP.go.ipa.oz.lib.standard._String_if string$73 = (new JP.go.ipa.oz.lib.standard._String_cl("_cl.oz"));
          
// 549
          boolean endsWith$val$206;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
            try {
              endsWith$val$206 = tmp.endsWith (string$73);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            endsWith$val$206 = tmp.endsWith (string$73);
          }
// 549
          if (!(endsWith$val$206)) {{
// 550
              JP.go.ipa.oz.lib.standard._Array_if putAt$val$207;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sourceList)) {
                try {
                  putAt$val$207 = sourceList.putAt (count, tmp);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                putAt$val$207 = sourceList.putAt (count, tmp);
              }
// 551
              count++;
            }
          }
        }
        /* iteration part */
// 547
        i++;
      }
    }
// 554
    JP.go.ipa.oz.lib.standard._Array_if resize$val$208;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sourceList)) {
      try {
        resize$val$208 = sourceList.resize (count);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      resize$val$208 = sourceList.resize (count);
    }
// 555
    max = count;
// 556
    count = 0;
// 557
    JP.go.ipa.oz.lib.standard._File_if file1 = null, file2 = null;
// 558
    modFileList = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (max);
// 559
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < max)) break;
        
        /* body */ _loop_1: {
// 560
          JP.go.ipa.oz.lang._Root_if at$val$209;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sourceList)) {
            try {
              at$val$209 = sourceList.at (i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            at$val$209 = sourceList.at (i);
          }
// 560
          tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$209);
// 561
          dir1 = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (sourceDir);
// 562
          dir1.append (tmp);
// 563
          file1 = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (dir1.asString ());
// 564
          dir2 = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (classDir);
// 565
          dir2.append (replace (tmp, (new JP.go.ipa.oz.lib.standard._String_cl(".oz")), (new JP.go.ipa.oz.lib.standard._String_cl("_cl.class"))));
// 566
          file2 = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (dir2.asString ());
// 567
          if (file1.lastModified () > file2.lastModified ()) {{
// 568
              tmp = replace (tmp, (new JP.go.ipa.oz.lib.standard._String_cl(".oz")), (new JP.go.ipa.oz.lib.standard._String_cl("")));
// 569
              modFileList.putAt (count, tmp);
// 570
              count++;
            }
          }
        }
        /* iteration part */
// 559
        i++;
      }
    }
// 573
    modFileList.resize (count);
// 574
    return modFileList;
  }
  
  public JP.go.ipa.oz.user.ide.Ozc_if getCompiler () throws Exception  {
    checkSecureInvocation ();
// 65
    return aCompiler;
  }
  
  public boolean compileInterface (JP.go.ipa.oz.lib.standard._String_if source, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception  {
    checkSecureInvocation ();
// 113
    boolean compileInterface$val$210;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aCompiler)) {
      try {
        compileInterface$val$210 = aCompiler.compileInterface (source, school, output);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compileInterface$val$210 = aCompiler.compileInterface (source, school, output);
    }
// 113
    return compileInterface$val$210;
  }
  
  public boolean compileInterface (JP.go.ipa.oz.lib.standard._String_if source) throws Exception  {
    checkSecureInvocation ();
// 107
    boolean compileInterface$val$211;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aCompiler)) {
      try {
        compileInterface$val$211 = aCompiler.compileInterface (source, school);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compileInterface$val$211 = aCompiler.compileInterface (source, school);
    }
// 107
    return compileInterface$val$211;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if replace (JP.go.ipa.oz.lib.standard._String_if target, JP.go.ipa.oz.lib.standard._String_if oldString, JP.go.ipa.oz.lib.standard._String_if newString) throws Exception  {
    checkSecureInvocation ();
// 580
    int length$val$212;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) target)) {
      try {
        length$val$212 = target.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$212 = target.length ();
    }
// 580
    int lenTarget = length$val$212;
// 581
    int length$val$213;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) oldString)) {
      try {
        length$val$213 = oldString.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$213 = oldString.length ();
    }
// 581
    int lenOld = length$val$213;
// 582
    JP.go.ipa.oz.lib.standard._StringBuffer_if tmpString = null;
// 583
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < lenTarget - lenOld + 1)) break;
        
        /* body */ _loop_1: {
// 584
          JP.go.ipa.oz.lib.standard._String_if substring$val$214;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) target)) {
            try {
              substring$val$214 = target.substring (i, i + lenOld);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            substring$val$214 = target.substring (i, i + lenOld);
          }
// 584
          int compareTo$val$215;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) (substring$val$214))) {
            try {
              compareTo$val$215 = (substring$val$214).compareTo (oldString);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            compareTo$val$215 = (substring$val$214).compareTo (oldString);
          }
// 584
          if (compareTo$val$215 == 0) {{
// 585
              JP.go.ipa.oz.lib.standard._String_if substring$val$216;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) target)) {
                try {
                  substring$val$216 = target.substring (0, i);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                substring$val$216 = target.substring (0, i);
              }
// 585
              tmpString = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (substring$val$216);
// 586
              tmpString.append (newString);
// 587
              if (lenTarget >= i + lenOld) {
// 588
                JP.go.ipa.oz.lib.standard._String_if substring$val$217;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) target)) {
                  try {
                    substring$val$217 = target.substring (i + lenOld);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  substring$val$217 = target.substring (i + lenOld);
                }
// 588
                tmpString.append (substring$val$217);
              }
// 589
              return tmpString.asString ();
            }
          }
        }
        /* iteration part */
// 583
        i++;
      }
    }
// 592
    return target;
  }
  
  public boolean deleteClassFiles (JP.go.ipa.oz.lib.standard._Array_if fileList) throws Exception  {
    checkSecureInvocation ();
// 140
    JP.go.ipa.oz.lib.standard._String_if tmp = null, classPath = null;
// 141
    JP.go.ipa.oz.lib.standard._StringBuffer_if filename = null, message = null;
// 142
    int max = 0;
// 143
    JP.go.ipa.oz.lang._Root_if at$val$218;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
      try {
        at$val$218 = fileList.at (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$218 = fileList.at (0);
    }
// 143
    classPath = (JP.go.ipa.oz.lib.standard._String_if) (at$val$218);
// 144
    JP.go.ipa.oz.lib.standard._String_if string$74 = (new JP.go.ipa.oz.lib.standard._String_cl("."));
    
// 144
    int lastIndexOf$val$219;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classPath)) {
      try {
        lastIndexOf$val$219 = classPath.lastIndexOf (string$74);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$219 = classPath.lastIndexOf (string$74);
    }
// 144
    JP.go.ipa.oz.lib.standard._String_if substring$val$220;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classPath)) {
      try {
        substring$val$220 = classPath.substring (0, lastIndexOf$val$219);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$220 = classPath.substring (0, lastIndexOf$val$219);
    }
// 144
    classPath = substring$val$220;
// 145
    JP.go.ipa.oz.lib.standard._String_if getLabelPath$val$221;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        getLabelPath$val$221 = school.getLabelPath (classPath);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getLabelPath$val$221 = school.getLabelPath (classPath);
    }
// 145
    classPath = getLabelPath$val$221;
// 146
    JP.go.ipa.oz.lib.standard._Array_if classFileList = null;
// 147
    JP.go.ipa.oz.lib.standard._File_if classFile = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (classPath);
// 148
    JP.go.ipa.oz.lib.standard._File_if delFile = null;
// 149
    JP.go.ipa.oz.user.ide.ExtensionFilter_if classFilter = (JP.go.ipa.oz.user.ide.ExtensionFilter_cl) (new JP.go.ipa.oz.user.ide.ExtensionFilter_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl(".class")));
// 150
    JP.go.ipa.oz.lib.standard._Array_if list$val$222;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classFile)) {
      try {
        list$val$222 = classFile.list (classFilter);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      list$val$222 = classFile.list (classFilter);
    }
// 150
    classFileList = list$val$222;
// 151
    if (classFileList != null) {{
// 152
        int size$val$223;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classFileList)) {
          try {
            size$val$223 = classFileList.size ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          size$val$223 = classFileList.size ();
        }
// 152
        max = size$val$223;
// 153
        /* for loop starting here */ {
          /* initialization part */
          int i = 0;
          
          for (;;) {
            /* boolean expression part */
            if (!(i < max)) break;
            
            /* body */ _loop_1: {
// 154
              JP.go.ipa.oz.lang._Root_if at$val$224;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classFileList)) {
                try {
                  at$val$224 = classFileList.at (i);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                at$val$224 = classFileList.at (i);
              }
// 154
              tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$224);
// 155
              filename = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (classPath);
// 156
              filename.append (tmp);
// 157
              delFile = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (filename.asString ());
// 158
              if (delFile.isFile ()) {
// 159
                delFile.delete ();
              }
            }
            /* iteration part */
// 153
            i++;
          }
        }
      }
    }
// 162
    return true;
  }
  
  public void setCompiler (JP.go.ipa.oz.user.ide.Ozc_if ozc) throws Exception  {
    checkSecureInvocation ();
// 73
    aCompiler = ozc;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getReleaseDir () throws Exception  {
    checkSecureInvocation ();
// 610
    JP.go.ipa.oz.lib.standard._StringBuffer_if classPath = null;
// 611
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 612
    JP.go.ipa.oz.lib.standard._String_if getOzHome$val$225;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getOzHome$val$225 = system.getOzHome ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzHome$val$225 = system.getOzHome ();
    }
// 612
    JP.go.ipa.oz.lib.standard._String_if ozHome = getOzHome$val$225;
// 614
    classPath = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (ozHome);
// 615
    JP.go.ipa.oz.lib.standard._String_if getKugiri$val$226;
    getKugiri$val$226 = getKugiri ();
// 615
    boolean endsWith$val$227;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
      try {
        endsWith$val$227 = ozHome.endsWith (getKugiri$val$226);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      endsWith$val$227 = ozHome.endsWith (getKugiri$val$226);
    }
// 615
    if (!(endsWith$val$227)) {
// 616
      classPath.append (getKugiri ());
    }
// 617
    classPath.append ((new JP.go.ipa.oz.lib.standard._String_cl("objects")));
// 618
    classPath.append (getKugiri ());
// 619
    classPath.append ((new JP.go.ipa.oz.lib.standard._String_cl("ide")));
// 620
    classPath.append (getKugiri ());
// 621
    classPath.append ((new JP.go.ipa.oz.lib.standard._String_cl("tmp")));
// 622
    classPath.append (getKugiri ());
// 623
    return classPath.asString ();
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if relatedLabels (JP.go.ipa.oz.lib.standard._String_if dirName) throws Exception  {
    checkSecureInvocation ();
// 344
    JP.go.ipa.oz.lib.standard._Array_if modifiedLabels = null;
// 345
    modifiedLabels = getModFiles (dirName, getClassDir (dirName));
// 346
    int size$val$228;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) modifiedLabels)) {
      try {
        size$val$228 = modifiedLabels.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$228 = modifiedLabels.size ();
    }
// 346
    int max = size$val$228;
// 347
    JP.go.ipa.oz.lib.standard._String_if tmp = null;
// 348
    JP.go.ipa.oz.lib.standard._Set_if tmpSet = null, resultSet = null;
// 349
    JP.go.ipa.oz.lib.standard._StringComparator_if sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 350
    resultSet = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (sc);
// 351
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < max)) break;
        
        /* body */ _loop_1: {
// 352
          JP.go.ipa.oz.lang._Root_if at$val$229;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) modifiedLabels)) {
            try {
              at$val$229 = modifiedLabels.at (i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            at$val$229 = modifiedLabels.at (i);
          }
// 352
          tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$229);
// 353
          JP.go.ipa.oz.lib.standard._String_if getImplementationID$val$230;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
            try {
              getImplementationID$val$230 = school.getImplementationID (tmp);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getImplementationID$val$230 = school.getImplementationID (tmp);
          }
// 353
          resultSet.add (getImplementationID$val$230);
// 354
          JP.go.ipa.oz.lib.standard._String_if getImplementationID$val$231;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
            try {
              getImplementationID$val$231 = school.getImplementationID (tmp);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getImplementationID$val$231 = school.getImplementationID (tmp);
          }
// 354
          JP.go.ipa.oz.lib.standard._Set_if getReferedCID$val$232;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) compilerUtility)) {
            try {
              getReferedCID$val$232 = compilerUtility.getReferedCID (getImplementationID$val$231);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getReferedCID$val$232 = compilerUtility.getReferedCID (getImplementationID$val$231);
          }
// 354
          tmpSet = getReferedCID$val$232;
// 355
          resultSet = resultSet.union (tmpSet);
// 356
          JP.go.ipa.oz.lib.standard._String_if getImplementationID$val$233;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
            try {
              getImplementationID$val$233 = school.getImplementationID (tmp);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getImplementationID$val$233 = school.getImplementationID (tmp);
          }
// 356
          JP.go.ipa.oz.lib.standard._Set_if getInstanciatedCID$val$234;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) compilerUtility)) {
            try {
              getInstanciatedCID$val$234 = compilerUtility.getInstanciatedCID (getImplementationID$val$233);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getInstanciatedCID$val$234 = compilerUtility.getInstanciatedCID (getImplementationID$val$233);
          }
// 356
          tmpSet = getInstanciatedCID$val$234;
// 357
          JP.go.ipa.oz.lib.standard._Set_if union$val$235;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) resultSet)) {
            try {
              union$val$235 = resultSet.union (tmpSet);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            union$val$235 = resultSet.union (tmpSet);
          }
// 357
          resultSet = union$val$235;
        }
        /* iteration part */
// 351
        i++;
      }
    }
// 361
    return resultSet;
  }
  
  public void setSchool (JP.go.ipa.oz.user.ide.School_if sc) throws Exception  {
    checkSecureInvocation ();
// 89
    school = sc;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getClassDir (JP.go.ipa.oz.lib.standard._String_if dirName) throws Exception  {
    checkSecureInvocation ();
// 473
    JP.go.ipa.oz.lib.standard._Array_if fileList = null;
// 474
    JP.go.ipa.oz.lib.standard._File_if file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (dirName);
// 475
    JP.go.ipa.oz.user.ide.ExtensionFilter_if filter = (JP.go.ipa.oz.user.ide.ExtensionFilter_cl) (new JP.go.ipa.oz.user.ide.ExtensionFilter_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl(".oz")));
// 476
    JP.go.ipa.oz.lib.standard._Array_if list$val$236;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        list$val$236 = file.list (filter);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      list$val$236 = file.list (filter);
    }
// 476
    fileList = list$val$236;
// 477
    if (fileList == null) {
// 477
      return (new JP.go.ipa.oz.lib.standard._String_cl(""));
    }
// 479
    JP.go.ipa.oz.lib.standard._String_if classPath = null;
// 480
    JP.go.ipa.oz.lib.standard._StringBuffer_if filename = null, message = null;
// 481
    JP.go.ipa.oz.lib.standard._Array_if classFileList = null, zipFileList = null;
// 482
    int size$val$237;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
      try {
        size$val$237 = fileList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$237 = fileList.size ();
    }
// 482
    int max = size$val$237;
// 484
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < max)) break;
        
        /* body */ _loop_1: {
// 485
          JP.go.ipa.oz.lang._Root_if at$val$238;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
            try {
              at$val$238 = fileList.at (i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            at$val$238 = fileList.at (i);
          }
// 485
          classPath = (JP.go.ipa.oz.lib.standard._String_if) (at$val$238);
// 486
          JP.go.ipa.oz.lib.standard._String_if string$75 = (new JP.go.ipa.oz.lib.standard._String_cl("_cl.oz"));
          
// 486
          boolean endsWith$val$239;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classPath)) {
            try {
              endsWith$val$239 = classPath.endsWith (string$75);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            endsWith$val$239 = classPath.endsWith (string$75);
          }
// 486
          if (!(endsWith$val$239)) {
// 486
            break;
          }
        }
        /* iteration part */
// 484
        i++;
      }
    }
// 488
    JP.go.ipa.oz.lib.standard._String_if string$76 = (new JP.go.ipa.oz.lib.standard._String_cl("."));
    
// 488
    int lastIndexOf$val$240;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classPath)) {
      try {
        lastIndexOf$val$240 = classPath.lastIndexOf (string$76);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$240 = classPath.lastIndexOf (string$76);
    }
// 488
    JP.go.ipa.oz.lib.standard._String_if substring$val$241;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classPath)) {
      try {
        substring$val$241 = classPath.substring (0, lastIndexOf$val$240);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$241 = classPath.substring (0, lastIndexOf$val$240);
    }
// 488
    classPath = substring$val$241;
// 489
    JP.go.ipa.oz.lib.standard._String_if getLabelPath$val$242;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        getLabelPath$val$242 = school.getLabelPath (classPath);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getLabelPath$val$242 = school.getLabelPath (classPath);
    }
// 489
    classPath = getLabelPath$val$242;
// 490
    return classPath;
  }
  
  public CompilerAgent_cl () throws Exception { super (); }
  
}


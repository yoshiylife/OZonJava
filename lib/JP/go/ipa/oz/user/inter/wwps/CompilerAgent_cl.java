package JP.go.ipa.oz.user.inter.wwps;

public class CompilerAgent_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.inter.wwps.CompilerAgent_if {
  JP.go.ipa.oz.user.ide.School_if school;
  JP.go.ipa.oz.user.ide.Ozc_if aCompiler;
  JP.go.ipa.oz.lib.standard._String_if release_directory;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.School_if sc) throws Exception  {
// 53
    aCompiler = (JP.go.ipa.oz.user.ide.Ozc_cl) (new JP.go.ipa.oz.user.ide.Ozc_cl ())._new_create ();
// 54
    school = sc;
    return this;
  }
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if dir) throws Exception  {
// 41
    release_directory = dir;
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getReleaseDir () throws Exception  {
    checkSecureInvocation ();
// 367
    return release_directory;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getKugiri () throws Exception  {
    checkSecureInvocation ();
// 354
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 355
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
// 355
    JP.go.ipa.oz.lib.standard._String_if ozHome = getOzHome$val$0;
// 356
    JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    
// 356
    boolean startsWith$val$1;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
      try {
        startsWith$val$1 = ozHome.startsWith (string$0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$1 = ozHome.startsWith (string$0);
    }
// 356
    if (startsWith$val$1) {
// 357
      return (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    } else {
// 359
      return (new JP.go.ipa.oz.lib.standard._String_cl("\\"));
    }
  }
  
  public boolean deleteAllFiles () throws Exception  {
    checkSecureInvocation ();
// 165
    JP.go.ipa.oz.lib.standard._StringBuffer_if filename = null;
// 166
    JP.go.ipa.oz.lib.standard._String_if tmp = null, classPath = null;
// 167
    int max = 0;
// 168
    classPath = getReleaseDir ();
// 169
    JP.go.ipa.oz.lib.standard._Array_if classFileList = null;
// 170
    JP.go.ipa.oz.lib.standard._File_if classFile = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (classPath);
// 171
    JP.go.ipa.oz.lib.standard._File_if delFile = null;
// 172
    JP.go.ipa.oz.lib.standard._Array_if list$val$2;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classFile)) {
      try {
        list$val$2 = classFile.list ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      list$val$2 = classFile.list ();
    }
// 172
    classFileList = list$val$2;
// 173
    if (classFileList != null) {{
// 174
        int size$val$3;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classFileList)) {
          try {
            size$val$3 = classFileList.size ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          size$val$3 = classFileList.size ();
        }
// 174
        max = size$val$3;
// 175
        /* for loop starting here */ {
          /* initialization part */
          int i = 0;
          
          for (;;) {
            /* boolean expression part */
            if (!(i < max)) break;
            
            /* body */ _loop_1: {
// 176
              JP.go.ipa.oz.lang._Root_if at$val$4;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classFileList)) {
                try {
                  at$val$4 = classFileList.at (i);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                at$val$4 = classFileList.at (i);
              }
// 176
              tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$4);
// 177
              filename = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (classPath);
// 178
              filename.append (tmp);
// 179
              delFile = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (filename.asString ());
// 180
              if (delFile.isFile ()) {
// 181
                delFile.delete ();
              }
            }
            /* iteration part */
// 175
            i++;
          }
        }
      }
    }
// 184
    return true;
  }
  
  public JP.go.ipa.oz.user.ide.School_if getSchool () throws Exception  {
    checkSecureInvocation ();
// 67
    return school;
  }
  
  public boolean compile (JP.go.ipa.oz.lib.standard._String_if source, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception  {
    checkSecureInvocation ();
// 90
    boolean compile$val$5;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aCompiler)) {
      try {
        compile$val$5 = aCompiler.compile (source, school, output);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compile$val$5 = aCompiler.compile (source, school, output);
    }
// 90
    return compile$val$5;
  }
  
  public boolean compile (JP.go.ipa.oz.lib.standard._String_if source) throws Exception  {
    checkSecureInvocation ();
// 83
    boolean compile$val$6;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aCompiler)) {
      try {
        compile$val$6 = aCompiler.compile (source, school);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compile$val$6 = aCompiler.compile (source, school);
    }
// 83
    return compile$val$6;
  }
  
  public void setSchool (JP.go.ipa.oz.user.ide.School_if sc) throws Exception  {
    checkSecureInvocation ();
// 76
    school = sc;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getClassDir2 (JP.go.ipa.oz.lib.standard._String_if dirName) throws Exception  {
    checkSecureInvocation ();
// 329
    JP.go.ipa.oz.lib.standard._Array_if fileList = null;
// 330
    JP.go.ipa.oz.lib.standard._File_if file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (dirName);
// 331
    JP.go.ipa.oz.user.ide.ExtensionFilter_if filter = (JP.go.ipa.oz.user.ide.ExtensionFilter_cl) (new JP.go.ipa.oz.user.ide.ExtensionFilter_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl(".oz")));
// 332
    JP.go.ipa.oz.lib.standard._Array_if list$val$7;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        list$val$7 = file.list (filter);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      list$val$7 = file.list (filter);
    }
// 332
    fileList = list$val$7;
// 333
    if (fileList == null) {
// 333
      return (new JP.go.ipa.oz.lib.standard._String_cl(""));
    }
// 335
    JP.go.ipa.oz.lib.standard._String_if classPath = null;
// 336
    JP.go.ipa.oz.lib.standard._StringBuffer_if filename = null, message = null;
// 337
    JP.go.ipa.oz.lib.standard._Array_if classFileList = null, zipFileList = null;
// 338
    int size$val$8;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
      try {
        size$val$8 = fileList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$8 = fileList.size ();
    }
// 338
    int max = size$val$8;
// 340
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < max)) break;
        
        /* body */ _loop_1: {
// 341
          JP.go.ipa.oz.lang._Root_if at$val$9;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
            try {
              at$val$9 = fileList.at (i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            at$val$9 = fileList.at (i);
          }
// 341
          classPath = (JP.go.ipa.oz.lib.standard._String_if) (at$val$9);
// 342
          JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl("_cl.oz"));
          
// 342
          boolean endsWith$val$10;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classPath)) {
            try {
              endsWith$val$10 = classPath.endsWith (string$1);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            endsWith$val$10 = classPath.endsWith (string$1);
          }
// 342
          if (!(endsWith$val$10)) {
// 342
            break;
          }
        }
        /* iteration part */
// 340
        i++;
      }
    }
// 344
    JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl("."));
    
// 344
    int lastIndexOf$val$11;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classPath)) {
      try {
        lastIndexOf$val$11 = classPath.lastIndexOf (string$2);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$11 = classPath.lastIndexOf (string$2);
    }
// 344
    JP.go.ipa.oz.lib.standard._String_if substring$val$12;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classPath)) {
      try {
        substring$val$12 = classPath.substring (0, lastIndexOf$val$11);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$12 = classPath.substring (0, lastIndexOf$val$11);
    }
// 344
    classPath = substring$val$12;
// 345
    JP.go.ipa.oz.lib.standard._String_if getLabelPath2$val$13;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        getLabelPath2$val$13 = school.getLabelPath2 (classPath);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getLabelPath2$val$13 = school.getLabelPath2 (classPath);
    }
// 345
    classPath = getLabelPath2$val$13;
// 347
    JP.go.ipa.oz.lib.standard._String_if replace$val$14;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classPath)) {
      try {
        replace$val$14 = classPath.replace ('\\', '/');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      replace$val$14 = classPath.replace ('\\', '/');
    }
// 347
    return replace$val$14;
  }
  
  public boolean compileOzFIlesForRelease (JP.go.ipa.oz.lib.standard._Array_if fileList, JP.go.ipa.oz.lib.standard._StringBuffer_if fullPath, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception  {
    checkSecureInvocation ();
// 188
    JP.go.ipa.oz.lib.standard._String_if tmp = null, classPath = null;
// 189
    JP.go.ipa.oz.lib.standard._StringBuffer_if filename = null, message = null;
// 190
    int size$val$15;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
      try {
        size$val$15 = fileList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$15 = fileList.size ();
    }
// 190
    int max = size$val$15;
// 191
    classPath = getReleaseDir ();
// 192
    boolean result = true;
// 193
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < max)) break;
        
        /* body */ _loop_1: {
// 194
          JP.go.ipa.oz.lang._Root_if at$val$16;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
            try {
              at$val$16 = fileList.at (i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            at$val$16 = fileList.at (i);
          }
// 194
          tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$16);
// 195
          JP.go.ipa.oz.lib.standard._String_if asString$val$17;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fullPath)) {
            try {
              asString$val$17 = fullPath.asString ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            asString$val$17 = fullPath.asString ();
          }
// 195
          filename = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (asString$val$17);
// 196
          filename.append (tmp);
// 197
          JP.go.ipa.oz.lib.standard._String_if asString$val$18;
          asString$val$18 = filename.asString ();
// 197
          JP.go.ipa.oz.lib.standard._String_if string$3 = (new JP.go.ipa.oz.lib.standard._String_cl("_cl.oz"));
          
// 197
          boolean endsWith$val$19;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) asString$val$18)) {
            try {
              endsWith$val$19 = asString$val$18.endsWith (string$3);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            endsWith$val$19 = asString$val$18.endsWith (string$3);
          }
// 197
          if (!(endsWith$val$19)) {{
// 198
              if (!existClassFileForRelease (filename.asString ())) {{
// 199
                  JP.go.ipa.oz.lib.standard._String_if asString$val$20;
                  asString$val$20 = filename.asString ();
// 199
                  boolean compile$val$21;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aCompiler)) {
                    try {
                      compile$val$21 = aCompiler.compile (asString$val$20, school, classPath);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    compile$val$21 = aCompiler.compile (asString$val$20, school, classPath);
                  }
// 199
                  if (compile$val$21) {{
// 200
                      message = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (tmp);
// 201
                      message.append ((new JP.go.ipa.oz.lib.standard._String_cl(" compiled successfully.")));
// 202
                      JP.go.ipa.oz.lib.standard._String_if asString$val$22;
                      asString$val$22 = message.asString ();
// 202
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
                        try {
                          output.write (asString$val$22);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        output.write (asString$val$22);
                      }
                    }
                  } else {{
// 204
                      message = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (tmp);
// 205
                      message.append ((new JP.go.ipa.oz.lib.standard._String_cl(" compiled failed.")));
// 206
                      JP.go.ipa.oz.lib.standard._String_if asString$val$23;
                      asString$val$23 = message.asString ();
// 206
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
                        try {
                          output.write (asString$val$23);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        output.write (asString$val$23);
                      }
// 207
                      result = false;
                    }
                  }
                }
              } else {{
// 210
                  message = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (tmp);
// 211
                  message.append ((new JP.go.ipa.oz.lib.standard._String_cl(" compiled successfully.")));
// 212
                  JP.go.ipa.oz.lib.standard._String_if asString$val$24;
                  asString$val$24 = message.asString ();
// 212
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) output)) {
                    try {
                      output.write (asString$val$24);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    output.write (asString$val$24);
                  }
                }
              }
            }
          }
        }
        /* iteration part */
// 193
        i++;
      }
    }
// 216
    return result;
  }
  
  public boolean deleteClassFiles (JP.go.ipa.oz.lib.standard._Array_if fileList) throws Exception  {
    checkSecureInvocation ();
// 108
    JP.go.ipa.oz.lib.standard._String_if tmp = null, classPath = null;
// 109
    JP.go.ipa.oz.lib.standard._StringBuffer_if filename = null, message = null;
// 110
    int max = 0;
// 112
    JP.go.ipa.oz.lang._Root_if at$val$25;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
      try {
        at$val$25 = fileList.at (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$25 = fileList.at (0);
    }
// 112
    classPath = (JP.go.ipa.oz.lib.standard._String_if) (at$val$25);
// 113
    JP.go.ipa.oz.lib.standard._String_if string$4 = (new JP.go.ipa.oz.lib.standard._String_cl("."));
    
// 113
    int lastIndexOf$val$26;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classPath)) {
      try {
        lastIndexOf$val$26 = classPath.lastIndexOf (string$4);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$26 = classPath.lastIndexOf (string$4);
    }
// 113
    JP.go.ipa.oz.lib.standard._String_if substring$val$27;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classPath)) {
      try {
        substring$val$27 = classPath.substring (0, lastIndexOf$val$26);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$27 = classPath.substring (0, lastIndexOf$val$26);
    }
// 113
    classPath = substring$val$27;
// 114
    JP.go.ipa.oz.lib.standard._String_if getLabelPath$val$28;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        getLabelPath$val$28 = school.getLabelPath (classPath);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getLabelPath$val$28 = school.getLabelPath (classPath);
    }
// 114
    classPath = getLabelPath$val$28;
// 115
    JP.go.ipa.oz.lib.standard._Array_if classFileList = null;
// 116
    JP.go.ipa.oz.lib.standard._File_if classFile = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (classPath);
// 117
    JP.go.ipa.oz.lib.standard._File_if delFile = null;
// 118
    JP.go.ipa.oz.user.ide.ExtensionFilter_if classFilter = (JP.go.ipa.oz.user.ide.ExtensionFilter_cl) (new JP.go.ipa.oz.user.ide.ExtensionFilter_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl(".class")));
// 119
    JP.go.ipa.oz.lib.standard._Array_if list$val$29;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classFile)) {
      try {
        list$val$29 = classFile.list (classFilter);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      list$val$29 = classFile.list (classFilter);
    }
// 119
    classFileList = list$val$29;
// 120
    if (classFileList != null) {{
// 121
        int size$val$30;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classFileList)) {
          try {
            size$val$30 = classFileList.size ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          size$val$30 = classFileList.size ();
        }
// 121
        max = size$val$30;
// 122
        /* for loop starting here */ {
          /* initialization part */
          int i = 0;
          
          for (;;) {
            /* boolean expression part */
            if (!(i < max)) break;
            
            /* body */ _loop_1: {
// 123
              JP.go.ipa.oz.lang._Root_if at$val$31;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classFileList)) {
                try {
                  at$val$31 = classFileList.at (i);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                at$val$31 = classFileList.at (i);
              }
// 123
              tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$31);
// 124
              filename = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (classPath);
// 125
              filename.append (tmp);
// 126
              delFile = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (filename.asString ());
// 127
              if (delFile.isFile ()) {
// 128
                delFile.delete ();
              }
            }
            /* iteration part */
// 122
            i++;
          }
        }
      }
    }
// 131
    return true;
  }
  
  public boolean release (JP.go.ipa.oz.lib.standard._String_if dirName, int flag, JP.go.ipa.oz.lib.standard._String_if zipFName) throws Exception  {
    checkSecureInvocation ();
// 240
    JP.go.ipa.oz.lib.standard._Array_if fileList = null;
// 241
    JP.go.ipa.oz.lib.standard._File_if file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (dirName);
// 242
    JP.go.ipa.oz.user.ide.ExtensionFilter_if filter = (JP.go.ipa.oz.user.ide.ExtensionFilter_cl) (new JP.go.ipa.oz.user.ide.ExtensionFilter_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl(".oz")));
// 243
    JP.go.ipa.oz.lib.standard._Array_if list$val$32;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        list$val$32 = file.list (filter);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      list$val$32 = file.list (filter);
    }
// 243
    fileList = list$val$32;
// 244
    if (fileList == null) {
// 244
      return false;
    }
// 246
    zipForRelease (dirName, flag, zipFName);
// 248
    return true;
  }
  
  public boolean existClassFileForRelease (JP.go.ipa.oz.lib.standard._String_if filename) throws Exception  {
    checkSecureInvocation ();
// 223
    JP.go.ipa.oz.lib.standard._String_if labelName = null;
// 224
    JP.go.ipa.oz.lib.standard._StringBuffer_if classPath = null;
// 225
    JP.go.ipa.oz.lib.standard._String_if getKugiri$val$33;
    getKugiri$val$33 = getKugiri ();
// 225
    int lastIndexOf$val$34;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) filename)) {
      try {
        lastIndexOf$val$34 = filename.lastIndexOf (getKugiri$val$33);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$34 = filename.lastIndexOf (getKugiri$val$33);
    }
// 225
    JP.go.ipa.oz.lib.standard._String_if string$5 = (new JP.go.ipa.oz.lib.standard._String_cl("."));
    
// 225
    int lastIndexOf$val$35;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) filename)) {
      try {
        lastIndexOf$val$35 = filename.lastIndexOf (string$5);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$35 = filename.lastIndexOf (string$5);
    }
// 225
    JP.go.ipa.oz.lib.standard._String_if substring$val$36;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) filename)) {
      try {
        substring$val$36 = filename.substring (lastIndexOf$val$34 + 1, lastIndexOf$val$35);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$36 = filename.substring (lastIndexOf$val$34 + 1, lastIndexOf$val$35);
    }
// 225
    labelName = substring$val$36;
// 226
    classPath = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (getReleaseDir ());
// 227
    classPath.append (labelName);
// 228
    classPath.append ((new JP.go.ipa.oz.lib.standard._String_cl("_cl.class")));
// 229
    JP.go.ipa.oz.lib.standard._File_if classFile = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (classPath.asString ());
// 230
    boolean isFile$val$37;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classFile)) {
      try {
        isFile$val$37 = classFile.isFile ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isFile$val$37 = classFile.isFile ();
    }
// 230
    if (isFile$val$37) {{
// 231
        return true;
      }
    }
// 233
    return false;
  }
  
  public boolean compileInterface (JP.go.ipa.oz.lib.standard._String_if source, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception  {
    checkSecureInvocation ();
// 104
    boolean compileInterface$val$38;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aCompiler)) {
      try {
        compileInterface$val$38 = aCompiler.compileInterface (source, school, output);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compileInterface$val$38 = aCompiler.compileInterface (source, school, output);
    }
// 104
    return compileInterface$val$38;
  }
  
  public boolean compileInterface (JP.go.ipa.oz.lib.standard._String_if source) throws Exception  {
    checkSecureInvocation ();
// 97
    boolean compileInterface$val$39;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aCompiler)) {
      try {
        compileInterface$val$39 = aCompiler.compileInterface (source, school);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compileInterface$val$39 = aCompiler.compileInterface (source, school);
    }
// 97
    return compileInterface$val$39;
  }
  
  public void zipForRelease (JP.go.ipa.oz.lib.standard._String_if dirName, int flag, JP.go.ipa.oz.lib.standard._String_if zipFName) throws Exception  {
    checkSecureInvocation ();
// 255
    JP.go.ipa.oz.lib.standard._String_if tmp = null, classPath = null;
// 256
    JP.go.ipa.oz.lib.standard._StringBuffer_if filename = null, message = null;
// 257
    JP.go.ipa.oz.lib.standard._Array_if classFileList = null, zipFileList = null;
// 258
    int max = 0;
// 259
    classPath = getReleaseDir ();
// 261
    JP.go.ipa.oz.lib.standard._File_if classFile = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (classPath);
// 262
    int count = 0;
// 263
    JP.go.ipa.oz.lib.standard._Array_if list$val$40;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classFile)) {
      try {
        list$val$40 = classFile.list ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      list$val$40 = classFile.list ();
    }
// 263
    classFileList = list$val$40;
// 264
    if (classFileList != null) {{
// 265
        int size$val$41;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classFileList)) {
          try {
            size$val$41 = classFileList.size ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          size$val$41 = classFileList.size ();
        }
// 265
        max = size$val$41;
// 266
        zipFileList = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (max);
// 267
        /* for loop starting here */ {
          /* initialization part */
          int i = 0;
          
          for (;;) {
            /* boolean expression part */
            if (!(i < max)) break;
            
            /* body */ _loop_1: {
// 268
              JP.go.ipa.oz.lang._Root_if at$val$42;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classFileList)) {
                try {
                  at$val$42 = classFileList.at (i);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                at$val$42 = classFileList.at (i);
              }
// 268
              tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$42);
              boolean bool$val$0;
              
              bool$val$0 = flag == 1;
              if (bool$val$0) {
                boolean bool$val$1;
                
// 269
                JP.go.ipa.oz.lib.standard._String_if string$6 = (new JP.go.ipa.oz.lib.standard._String_cl("_if.class"));
                
// 269
                boolean endsWith$val$43;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                  try {
                    endsWith$val$43 = tmp.endsWith (string$6);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  endsWith$val$43 = tmp.endsWith (string$6);
                }
                bool$val$1 = endsWith$val$43;
                if (!bool$val$1) {
// 269
                  JP.go.ipa.oz.lib.standard._String_if string$7 = (new JP.go.ipa.oz.lib.standard._String_cl("_if.ci"));
                  
// 269
                  boolean endsWith$val$44;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                    try {
                      endsWith$val$44 = tmp.endsWith (string$7);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    endsWith$val$44 = tmp.endsWith (string$7);
                  }
                  bool$val$1 = endsWith$val$44;
                }
                bool$val$0 = (bool$val$1);
              }
// 269
              if (bool$val$0) {{
// 270
                  zipFileList.putAt (count, tmp);
// 271
                  count++;
                }
              } else {
                boolean bool$val$2;
                
                bool$val$2 = flag == 2;
                if (bool$val$2) {
                  boolean bool$val$3;
                  
                  boolean bool$val$4;
                  
// 273
                  JP.go.ipa.oz.lib.standard._String_if string$8 = (new JP.go.ipa.oz.lib.standard._String_cl("_cl.class"));
                  
// 273
                  boolean endsWith$val$45;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                    try {
                      endsWith$val$45 = tmp.endsWith (string$8);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    endsWith$val$45 = tmp.endsWith (string$8);
                  }
                  bool$val$4 = endsWith$val$45;
                  if (!bool$val$4) {
// 273
                    JP.go.ipa.oz.lib.standard._String_if string$9 = (new JP.go.ipa.oz.lib.standard._String_cl("_cl.ci"));
                    
// 273
                    boolean endsWith$val$46;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                      try {
                        endsWith$val$46 = tmp.endsWith (string$9);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      endsWith$val$46 = tmp.endsWith (string$9);
                    }
                    bool$val$4 = endsWith$val$46;
                  }
                  bool$val$3 = bool$val$4;
                  if (!bool$val$3) {
// 273
                    JP.go.ipa.oz.lib.standard._String_if string$10 = (new JP.go.ipa.oz.lib.standard._String_cl(".oz"));
                    
// 273
                    boolean endsWith$val$47;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                      try {
                        endsWith$val$47 = tmp.endsWith (string$10);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      endsWith$val$47 = tmp.endsWith (string$10);
                    }
                    bool$val$3 = endsWith$val$47;
                  }
                  bool$val$2 = (bool$val$3);
                }
// 273
                if (bool$val$2) {{
// 274
                    zipFileList.putAt (count, tmp);
// 275
                    count++;
                  }
                } else {
                  boolean bool$val$5;
                  
                  bool$val$5 = flag == 2;
                  if (bool$val$5) {
                    boolean bool$val$6;
                    
// 277
                    JP.go.ipa.oz.lib.standard._String_if string$11 = (new JP.go.ipa.oz.lib.standard._String_cl("_pcl.class"));
                    
// 277
                    boolean endsWith$val$48;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                      try {
                        endsWith$val$48 = tmp.endsWith (string$11);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      endsWith$val$48 = tmp.endsWith (string$11);
                    }
                    bool$val$6 = endsWith$val$48;
                    if (!bool$val$6) {
// 277
                      JP.go.ipa.oz.lib.standard._String_if string$12 = (new JP.go.ipa.oz.lib.standard._String_cl("_pcl.ci"));
                      
// 277
                      boolean endsWith$val$49;
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                        try {
                          endsWith$val$49 = tmp.endsWith (string$12);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        endsWith$val$49 = tmp.endsWith (string$12);
                      }
                      bool$val$6 = endsWith$val$49;
                    }
                    bool$val$5 = (bool$val$6);
                  }
// 277
                  if (bool$val$5) {{
// 278
                      zipFileList.putAt (count, tmp);
// 279
                      count++;
                    }
                  } else {
                    boolean bool$val$7;
                    
                    bool$val$7 = flag == 3;
                    if (bool$val$7) {
                      boolean bool$val$8;
                      
                      boolean bool$val$9;
                      
                      boolean bool$val$10;
                      
                      boolean bool$val$11;
                      
                      boolean bool$val$12;
                      
                      boolean bool$val$13;
                      
// 281
                      JP.go.ipa.oz.lib.standard._String_if string$13 = (new JP.go.ipa.oz.lib.standard._String_cl("_if.class"));
                      
// 281
                      boolean endsWith$val$50;
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                        try {
                          endsWith$val$50 = tmp.endsWith (string$13);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        endsWith$val$50 = tmp.endsWith (string$13);
                      }
                      bool$val$13 = endsWith$val$50;
                      if (!bool$val$13) {
// 281
                        JP.go.ipa.oz.lib.standard._String_if string$14 = (new JP.go.ipa.oz.lib.standard._String_cl("_if.ci"));
                        
// 281
                        boolean endsWith$val$51;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                          try {
                            endsWith$val$51 = tmp.endsWith (string$14);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          endsWith$val$51 = tmp.endsWith (string$14);
                        }
                        bool$val$13 = endsWith$val$51;
                      }
                      bool$val$12 = bool$val$13;
                      if (!bool$val$12) {
// 282
                        JP.go.ipa.oz.lib.standard._String_if string$15 = (new JP.go.ipa.oz.lib.standard._String_cl("_cl.class"));
                        
// 282
                        boolean endsWith$val$52;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                          try {
                            endsWith$val$52 = tmp.endsWith (string$15);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          endsWith$val$52 = tmp.endsWith (string$15);
                        }
                        bool$val$12 = endsWith$val$52;
                      }
                      bool$val$11 = bool$val$12;
                      if (!bool$val$11) {
// 282
                        JP.go.ipa.oz.lib.standard._String_if string$16 = (new JP.go.ipa.oz.lib.standard._String_cl("_cl.ci"));
                        
// 282
                        boolean endsWith$val$53;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                          try {
                            endsWith$val$53 = tmp.endsWith (string$16);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          endsWith$val$53 = tmp.endsWith (string$16);
                        }
                        bool$val$11 = endsWith$val$53;
                      }
                      bool$val$10 = bool$val$11;
                      if (!bool$val$10) {
// 282
                        JP.go.ipa.oz.lib.standard._String_if string$17 = (new JP.go.ipa.oz.lib.standard._String_cl(".oz"));
                        
// 282
                        boolean endsWith$val$54;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                          try {
                            endsWith$val$54 = tmp.endsWith (string$17);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          endsWith$val$54 = tmp.endsWith (string$17);
                        }
                        bool$val$10 = endsWith$val$54;
                      }
                      bool$val$9 = bool$val$10;
                      if (!bool$val$9) {
// 283
                        JP.go.ipa.oz.lib.standard._String_if string$18 = (new JP.go.ipa.oz.lib.standard._String_cl("_pcl.class"));
                        
// 283
                        boolean endsWith$val$55;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                          try {
                            endsWith$val$55 = tmp.endsWith (string$18);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          endsWith$val$55 = tmp.endsWith (string$18);
                        }
                        bool$val$9 = endsWith$val$55;
                      }
                      bool$val$8 = bool$val$9;
                      if (!bool$val$8) {
// 283
                        JP.go.ipa.oz.lib.standard._String_if string$19 = (new JP.go.ipa.oz.lib.standard._String_cl("_pcl.ci"));
                        
// 283
                        boolean endsWith$val$56;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                          try {
                            endsWith$val$56 = tmp.endsWith (string$19);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          endsWith$val$56 = tmp.endsWith (string$19);
                        }
                        bool$val$8 = endsWith$val$56;
                      }
                      bool$val$7 = (bool$val$8);
                    }
// 281
                    if (bool$val$7) {{
// 284
                        zipFileList.putAt (count, tmp);
// 285
                        count++;
                      }
                    }
                  }
                }
              }
            }
            /* iteration part */
// 267
            i++;
          }
        }
// 288
        zipFileList.resize (count);
      }
    }
// 290
    JP.go.ipa.oz.lib.standard._StringBuffer_if fName = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (classPath);
// 291
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$57;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fName)) {
      try {
        append$val$57 = fName.append (zipFName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$57 = fName.append (zipFName);
    }
// 292
    JP.go.ipa.oz.lib.standard._String_if string$20 = (new JP.go.ipa.oz.lib.standard._String_cl(".zip"));
    
// 292
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$58;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fName)) {
      try {
        append$val$58 = fName.append (string$20);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$58 = fName.append (string$20);
    }
// 294
    JP.go.ipa.oz.lib.standard._String_if asString$val$59;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fName)) {
      try {
        asString$val$59 = fName.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$59 = fName.asString ();
    }
// 294
    JP.go.ipa.oz.lib.standard._ZipArchive_if zip = (JP.go.ipa.oz.lib.standard._ZipArchive_cl) (new JP.go.ipa.oz.lib.standard._ZipArchive_cl ())._new_create (asString$val$59);
// 296
    JP.go.ipa.oz.lib.standard._String_if getClassDir2$val$60;
    getClassDir2$val$60 = getClassDir2 (dirName);
// 296
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) zip)) {
      try {
        zip.store (classPath, getClassDir2$val$60, zipFileList);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      zip.store (classPath, getClassDir2$val$60, zipFileList);
    }
  }
  
  public boolean compileSubjectForRelease (JP.go.ipa.oz.lib.standard._String_if dirName, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception  {
    checkSecureInvocation ();
// 138
    release_directory = dirName;
// 139
    JP.go.ipa.oz.lib.standard._StringBuffer_if fullPath = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (dirName);
// 141
    JP.go.ipa.oz.lib.standard._String_if getKugiri$val$61;
    getKugiri$val$61 = getKugiri ();
// 141
    boolean endsWith$val$62;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dirName)) {
      try {
        endsWith$val$62 = dirName.endsWith (getKugiri$val$61);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      endsWith$val$62 = dirName.endsWith (getKugiri$val$61);
    }
// 141
    if (!(endsWith$val$62)) {
// 142
      JP.go.ipa.oz.lib.standard._String_if getKugiri$val$63;
      getKugiri$val$63 = getKugiri ();
// 142
      JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$64;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fullPath)) {
        try {
          append$val$64 = fullPath.append (getKugiri$val$63);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        append$val$64 = fullPath.append (getKugiri$val$63);
      }
    }
// 145
    JP.go.ipa.oz.lib.standard._Array_if fileList = null;
// 146
    JP.go.ipa.oz.lib.standard._File_if file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (dirName);
// 147
    JP.go.ipa.oz.user.ide.ExtensionFilter_if filter = (JP.go.ipa.oz.user.ide.ExtensionFilter_cl) (new JP.go.ipa.oz.user.ide.ExtensionFilter_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl(".oz")));
// 148
    JP.go.ipa.oz.lib.standard._Array_if list$val$65;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        list$val$65 = file.list (filter);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      list$val$65 = file.list (filter);
    }
// 148
    fileList = list$val$65;
// 149
    if (fileList == null) {
// 149
      return false;
    }
// 151
    JP.go.ipa.oz.lib.standard._File_if releaseDir = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (getReleaseDir ());
// 152
    boolean isDirectory$val$66;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) releaseDir)) {
      try {
        isDirectory$val$66 = releaseDir.isDirectory ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isDirectory$val$66 = releaseDir.isDirectory ();
    }
// 152
    if (!(isDirectory$val$66)) {{
// 153
        boolean mkdir$val$67;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) releaseDir)) {
          try {
            mkdir$val$67 = releaseDir.mkdir ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          mkdir$val$67 = releaseDir.mkdir ();
        }
      }
    }
// 157
    deleteClassFiles (fileList);
// 158
    return compileOzFIlesForRelease (fileList, fullPath, output);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getClassDir (JP.go.ipa.oz.lib.standard._String_if dirName) throws Exception  {
    checkSecureInvocation ();
// 304
    JP.go.ipa.oz.lib.standard._Array_if fileList = null;
// 305
    JP.go.ipa.oz.lib.standard._File_if file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (dirName);
// 306
    JP.go.ipa.oz.user.ide.ExtensionFilter_if filter = (JP.go.ipa.oz.user.ide.ExtensionFilter_cl) (new JP.go.ipa.oz.user.ide.ExtensionFilter_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl(".oz")));
// 307
    JP.go.ipa.oz.lib.standard._Array_if list$val$68;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        list$val$68 = file.list (filter);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      list$val$68 = file.list (filter);
    }
// 307
    fileList = list$val$68;
// 308
    if (fileList == null) {
// 308
      return (new JP.go.ipa.oz.lib.standard._String_cl(""));
    }
// 310
    JP.go.ipa.oz.lib.standard._String_if classPath = null;
// 311
    JP.go.ipa.oz.lib.standard._StringBuffer_if filename = null, message = null;
// 312
    JP.go.ipa.oz.lib.standard._Array_if classFileList = null, zipFileList = null;
// 313
    int size$val$69;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
      try {
        size$val$69 = fileList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$69 = fileList.size ();
    }
// 313
    int max = size$val$69;
// 315
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < max)) break;
        
        /* body */ _loop_1: {
// 316
          JP.go.ipa.oz.lang._Root_if at$val$70;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
            try {
              at$val$70 = fileList.at (i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            at$val$70 = fileList.at (i);
          }
// 316
          classPath = (JP.go.ipa.oz.lib.standard._String_if) (at$val$70);
// 317
          JP.go.ipa.oz.lib.standard._String_if string$21 = (new JP.go.ipa.oz.lib.standard._String_cl("_cl.oz"));
          
// 317
          boolean endsWith$val$71;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classPath)) {
            try {
              endsWith$val$71 = classPath.endsWith (string$21);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            endsWith$val$71 = classPath.endsWith (string$21);
          }
// 317
          if (!(endsWith$val$71)) {
// 317
            break;
          }
        }
        /* iteration part */
// 315
        i++;
      }
    }
// 319
    JP.go.ipa.oz.lib.standard._String_if string$22 = (new JP.go.ipa.oz.lib.standard._String_cl("."));
    
// 319
    int lastIndexOf$val$72;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classPath)) {
      try {
        lastIndexOf$val$72 = classPath.lastIndexOf (string$22);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$72 = classPath.lastIndexOf (string$22);
    }
// 319
    JP.go.ipa.oz.lib.standard._String_if substring$val$73;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classPath)) {
      try {
        substring$val$73 = classPath.substring (0, lastIndexOf$val$72);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$73 = classPath.substring (0, lastIndexOf$val$72);
    }
// 319
    classPath = substring$val$73;
// 320
    JP.go.ipa.oz.lib.standard._String_if getLabelPath$val$74;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        getLabelPath$val$74 = school.getLabelPath (classPath);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getLabelPath$val$74 = school.getLabelPath (classPath);
    }
// 320
    classPath = getLabelPath$val$74;
// 321
    return classPath;
  }
  
  public CompilerAgent_cl () throws Exception { super (); }
  
}


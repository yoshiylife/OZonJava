package JP.go.ipa.oz.user.cda;

public class _CopyOnRightRunnable_cl extends JP.go.ipa.oz.lang._Runnable_cl implements JP.go.ipa.oz.user.cda._CopyOnRightRunnable_if {
  boolean isWriteInValid;
  protected JP.go.ipa.oz.system.OzCondition cond = new JP.go.ipa.oz.system.OzCondition (this);
  JP.go.ipa.oz.user.cda._DeliveryFileCache_if dfCache;
  JP.go.ipa.oz.user.cda._MillorTarget_if millors;
  int interval;
  
  public Object _new_create (JP.go.ipa.oz.user.cda._MillorTarget_if mil, JP.go.ipa.oz.user.cda._DeliveryFileCache_if cache, boolean isWIV) throws Exception  {
// 236
    JP.go.ipa.oz.user.cda._CDAdebug_if debug = (JP.go.ipa.oz.user.cda._CDAdebug_cl) (new JP.go.ipa.oz.user.cda._CDAdebug_cl ())._new_create ();
// 237
    JP.go.ipa.oz.lib.standard._String_if string$17 = (new JP.go.ipa.oz.lib.standard._String_cl("CopyOnRightRunnable create"));
    
// 237
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.println (string$17);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.println (string$17);
    }
// 238
    interval = 60000;
// 239
    millors = mil;
// 240
    dfCache = cache;
// 241
    isWriteInValid = isWIV;
// 242
    JP.go.ipa.oz.lib.standard._String_if string$18 = (new JP.go.ipa.oz.lib.standard._String_cl("CopyOnRightRunnable created"));
    
// 242
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.println (string$18);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.println (string$18);
    }
    return this;
  }
  
  public void modeWIV () throws Exception  {
    checkSecureInvocation ();
// 249
    isWriteInValid = true;
  }
  
  public void modeCOW () throws Exception  {
    checkSecureInvocation ();
// 250
    isWriteInValid = false;
  }
  
  public void copyStart () throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 255
      signal (cond);
    } finally {
      leave ();
    }
  }
  
  protected void beforeCopy () throws Exception  {
    enter ();
    try {
// 252
      wait (cond);
    } finally {
      leave ();
    }
  }
  
  protected boolean isMillorOK (JP.go.ipa.oz.lib.standard._String_if topPackageName) throws Exception  {
// 335
    return true;
  }
  
  protected boolean isSecurityOKasMillorClient () throws Exception  {
// 334
    return true;
  }
  
  public void setInterval (int i) throws Exception  {
    checkSecureInvocation ();
// 246
    interval = i;
  }
  
  public void run () throws Exception  {
    checkSecureInvocation ();
// 259
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 261
    beforeCopy ();
// 262
    try {
// 263
      JP.go.ipa.oz.lib.standard._Set_if targetGOLs = null;
// 263
      JP.go.ipa.oz.lib.standard._Iterator_if targetIte = null;
// 263
      int targetnum = 0;
// 263
      boolean b = true;
// 264
      while (true) {
        if (!(b)) break;
        
        /* body */ _loop_1: {
// 266
          sleepThread (interval);
// 268
          JP.go.ipa.oz.lib.standard._Set_if getTargetGOLs$val$25;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) millors)) {
            try {
              getTargetGOLs$val$25 = millors.getTargetGOLs ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getTargetGOLs$val$25 = millors.getTargetGOLs ();
          }
// 268
          targetGOLs = getTargetGOLs$val$25;
// 269
          JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$26;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetGOLs)) {
            try {
              iterator$val$26 = targetGOLs.iterator ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            iterator$val$26 = targetGOLs.iterator ();
          }
// 269
          targetIte = iterator$val$26;
// 270
          int size$val$27;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetGOLs)) {
            try {
              size$val$27 = targetGOLs.size ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            size$val$27 = targetGOLs.size ();
          }
// 270
          targetnum = size$val$27;
// 272
          JP.go.ipa.oz.lib.standard._String_if millorClientCDAGOL = null;
// 273
          JP.go.ipa.oz.lib.standard._Dictionary_if times = null;
// 273
          JP.go.ipa.oz.lib.standard._Iterator_if ite = null;
// 273
          int size = 0;
// 274
          JP.go.ipa.oz.user.cda._ClassDeliveryAgent_if millorClientCDA = null;
// 275
          /* for loop starting here */ {
            /* initialization part */
            int j = 0;
            
            for (;;) {
              /* boolean expression part */
              if (!(j < targetnum)) break;
              
              /* body */ _loop_2: {
// 276
                JP.go.ipa.oz.lang._Root_if nextElement$val$28;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetIte)) {
                  try {
                    nextElement$val$28 = targetIte.nextElement ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  nextElement$val$28 = targetIte.nextElement ();
                }
// 276
                millorClientCDAGOL = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$28);
// 277
                JP.go.ipa.oz.lib.standard._Dictionary_if get$val$29;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) millors)) {
                  try {
                    get$val$29 = millors.get (millorClientCDAGOL);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  get$val$29 = millors.get (millorClientCDAGOL);
                }
// 277
                times = get$val$29;
// 280
                JP.go.ipa.oz.lib.standard._Iterator_if keyIterator$val$30;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) times)) {
                  try {
                    keyIterator$val$30 = times.keyIterator ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  keyIterator$val$30 = times.keyIterator ();
                }
// 280
                ite = keyIterator$val$30;
// 281
                int size$val$31;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) times)) {
                  try {
                    size$val$31 = times.size ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  size$val$31 = times.size ();
                }
// 281
                size = size$val$31;
// 283
                millorClientCDA = new JP.go.ipa.oz.user.cda._ClassDeliveryAgent_pcl (millorClientCDAGOL);
// 284
                if (millorClientCDA != null) {{
// 285
                    JP.go.ipa.oz.lib.standard._String_if topPackageName = null;
// 286
                    long time = 0;
// 287
                    JP.go.ipa.oz.user.cda._DeliveryFile_if df = null;
// 288
                    JP.go.ipa.oz.lib.standard._File_if f = null;
// 289
                    /* for loop starting here */ {
                      /* initialization part */
                      int i = 0;
                      
                      for (;;) {
                        /* boolean expression part */
                        if (!(i < size)) break;
                        
                        /* body */ _loop_3: {
// 290
                          JP.go.ipa.oz.lang._Root_if nextElement$val$32;
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ite)) {
                            try {
                              nextElement$val$32 = ite.nextElement ();
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            nextElement$val$32 = ite.nextElement ();
                          }
// 290
                          topPackageName = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$32);
// 292
                          JP.go.ipa.oz.lib.standard._Long_if L = null;
// 292
                          JP.go.ipa.oz.lang._Root_if get$val$33;
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) times)) {
                            try {
                              get$val$33 = times.get (topPackageName);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            get$val$33 = times.get (topPackageName);
                          }
// 292
                          L = (JP.go.ipa.oz.lib.standard._Long_if) (get$val$33);
// 293
                          long longValue$val$34;
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) L)) {
                            try {
                              longValue$val$34 = L.longValue ();
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            longValue$val$34 = L.longValue ();
                          }
// 293
                          time = longValue$val$34;
// 295
                          f = JP.go.ipa.oz.lib.standard._LocalRepositoryManager_cl._static_get (topPackageName);
                          boolean bool$val$0;
                          
                          boolean bool$val$1;
                          
                          bool$val$1 = (f != null);
                          if (bool$val$1) {
                            bool$val$1 = (isSecurityOKasMillorClient ());
                          }
                          bool$val$0 = bool$val$1;
                          if (bool$val$0) {
                            bool$val$0 = (isMillorOK (topPackageName));
                          }
// 296
                          if (bool$val$0) {{
// 298
                              long lastModified$val$35;
                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
                                try {
                                  lastModified$val$35 = f.lastModified ();
                                } finally {
                                  changeRunningToGreen ();
                                }
                              } else {
                                lastModified$val$35 = f.lastModified ();
                              }
// 298
                              long lastTime = lastModified$val$35;
// 299
                              if (lastTime != time) {{
// 300
                                  if (!isWriteInValid) {{
// 301
                                      int length = 0;
// 301
                                      long length$val$36;
                                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
                                        try {
                                          length$val$36 = f.length ();
                                        } finally {
                                          changeRunningToGreen ();
                                        }
                                      } else {
                                        length$val$36 = f.length ();
                                      }
// 301
                                      length = (int) (length$val$36);
// 302
                                      JP.go.ipa.oz.lib.standard._FileInputStream_if fis = (JP.go.ipa.oz.lib.standard._FileInputStream_cl) (new JP.go.ipa.oz.lib.standard._FileInputStream_cl ())._new_breed (f);
// 303
                                      JP.go.ipa.oz.lib.standard._ByteArray_if buffer = (JP.go.ipa.oz.lib.standard._ByteArray_cl) (new JP.go.ipa.oz.lib.standard._ByteArray_cl ())._new_create (length);
// 304
                                      int read$val$37;
                                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fis)) {
                                        try {
                                          read$val$37 = fis.read (buffer);
                                        } finally {
                                          changeRunningToGreen ();
                                        }
                                      } else {
                                        read$val$37 = fis.read (buffer);
                                      }
// 304
                                      if (read$val$37 == length) {{
// 305
                                          JP.go.ipa.oz.lib.standard._String_if getName$val$38;
                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
                                            try {
                                              getName$val$38 = f.getName ();
                                            } finally {
                                              changeRunningToGreen ();
                                            }
                                          } else {
                                            getName$val$38 = f.getName ();
                                          }
// 305
                                          JP.go.ipa.oz.lib.standard._String_if fileName = getName$val$38;
// 306
                                          df = (JP.go.ipa.oz.user.cda._DeliveryFile_cl) (new JP.go.ipa.oz.user.cda._DeliveryFile_cl ())._new_create (topPackageName, topPackageName, length, buffer);
// 307
                                          if (df != null) {{
// 308
                                              df.timeStamp (lastTime);
// 309
                                              boolean isCopied = millorClientCDA.thisCopyOnRight (df);
// 310
                                              if (isCopied) {{
// 311
                                                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) millors)) {
                                                    try {
                                                      millors.setTime (millorClientCDAGOL, topPackageName, lastTime);
                                                    } finally {
                                                      changeRunningToGreen ();
                                                    }
                                                  } else {
                                                    millors.setTime (millorClientCDAGOL, topPackageName, lastTime);
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  } else {{
// 316
                                      boolean isCopied = millorClientCDA.thisWriteInValid (df);
// 317
                                      if (isCopied) {{
// 318
                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) millors)) {
                                            try {
                                              millors.setTime (millorClientCDAGOL, topPackageName, lastTime);
                                            } finally {
                                              changeRunningToGreen ();
                                            }
                                          } else {
                                            millors.setTime (millorClientCDAGOL, topPackageName, lastTime);
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
                        /* iteration part */
// 289
                        i++;
                      }
                    }
                  }
                }
              }
              /* iteration part */
// 275
              j++;
            }
          }
        }
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_5) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_5 = _exception_5.getOzException ();
      if (_oz_exception_5 instanceof JP.go.ipa.oz.lib.standard._UserException_if) {
        JP.go.ipa.oz.lib.standard._UserException_if e = (JP.go.ipa.oz.lib.standard._UserException_if) _oz_exception_5;
// 330
        JP.go.ipa.oz.lib.standard._String_if string$19 = (new JP.go.ipa.oz.lib.standard._String_cl("polling fail"));
        
// 330
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.println (string$19);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.println (string$19);
        }
      } else throw _exception_5;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 328
      JP.go.ipa.oz.lib.standard._String_if string$20 = (new JP.go.ipa.oz.lib.standard._String_cl("polling fail"));
      
// 328
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
  }
  
  public _CopyOnRightRunnable_cl () throws Exception { super (); }
  
}


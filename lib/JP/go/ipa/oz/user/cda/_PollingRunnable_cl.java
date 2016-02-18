package JP.go.ipa.oz.user.cda;

public class _PollingRunnable_cl extends JP.go.ipa.oz.lang._Runnable_cl implements JP.go.ipa.oz.user.cda._PollingRunnable_if {
  protected JP.go.ipa.oz.system.OzCondition cond = new JP.go.ipa.oz.system.OzCondition (this);
  JP.go.ipa.oz.user.cda._DeliveryFileCache_if dfCache;
  JP.go.ipa.oz.user.cda._MillorTarget_if millors;
  int interval;
  
  public Object _new_create (JP.go.ipa.oz.user.cda._MillorTarget_if mil, JP.go.ipa.oz.user.cda._DeliveryFileCache_if cache) throws Exception  {
// 149
    interval = 60000;
// 150
    millors = mil;
// 151
    dfCache = cache;
    return this;
  }
  
  public void run () throws Exception  {
    checkSecureInvocation ();
// 160
    beforePolling ();
// 161
    try {
// 162
      JP.go.ipa.oz.lib.standard._Set_if targetGOLs = null;
// 162
      JP.go.ipa.oz.lib.standard._Iterator_if targetIte = null;
// 162
      int targetnum = 0;
// 162
      boolean b = true;
// 163
      while (true) {
        if (!(b)) break;
        
        /* body */ _loop_1: {
// 164
          sleepThread (interval);
// 165
          JP.go.ipa.oz.user.cda._CDAdebug_if debug = (JP.go.ipa.oz.user.cda._CDAdebug_cl) (new JP.go.ipa.oz.user.cda._CDAdebug_cl ())._new_create ();
// 167
          JP.go.ipa.oz.lib.standard._Set_if getTargetGOLs$val$14;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) millors)) {
            try {
              getTargetGOLs$val$14 = millors.getTargetGOLs ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getTargetGOLs$val$14 = millors.getTargetGOLs ();
          }
// 167
          targetGOLs = getTargetGOLs$val$14;
// 168
          JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$15;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetGOLs)) {
            try {
              iterator$val$15 = targetGOLs.iterator ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            iterator$val$15 = targetGOLs.iterator ();
          }
// 168
          targetIte = iterator$val$15;
// 169
          int size$val$16;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetGOLs)) {
            try {
              size$val$16 = targetGOLs.size ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            size$val$16 = targetGOLs.size ();
          }
// 169
          targetnum = size$val$16;
// 171
          JP.go.ipa.oz.lib.standard._String_if millorServerCDAGOL = null;
// 172
          JP.go.ipa.oz.lib.standard._Dictionary_if times = null;
// 172
          JP.go.ipa.oz.lib.standard._Iterator_if ite = null;
// 172
          int size = 0;
// 173
          JP.go.ipa.oz.user.cda._ClassDeliveryAgent_if millorServerCDA = null;
// 174
          /* for loop starting here */ {
            /* initialization part */
            int j = 0;
            
            for (;;) {
              /* boolean expression part */
              if (!(j < targetnum)) break;
              
              /* body */ _loop_2: {
// 175
                JP.go.ipa.oz.lang._Root_if nextElement$val$17;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targetIte)) {
                  try {
                    nextElement$val$17 = targetIte.nextElement ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  nextElement$val$17 = targetIte.nextElement ();
                }
// 175
                millorServerCDAGOL = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$17);
// 176
                JP.go.ipa.oz.lib.standard._Dictionary_if get$val$18;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) millors)) {
                  try {
                    get$val$18 = millors.get (millorServerCDAGOL);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  get$val$18 = millors.get (millorServerCDAGOL);
                }
// 176
                times = get$val$18;
// 178
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
                  try {
                    debug.println (millorServerCDAGOL);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  debug.println (millorServerCDAGOL);
                }
// 179
                JP.go.ipa.oz.lib.standard._Iterator_if keyIterator$val$19;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) times)) {
                  try {
                    keyIterator$val$19 = times.keyIterator ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  keyIterator$val$19 = times.keyIterator ();
                }
// 179
                ite = keyIterator$val$19;
// 180
                int size$val$20;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) times)) {
                  try {
                    size$val$20 = times.size ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  size$val$20 = times.size ();
                }
// 180
                size = size$val$20;
// 182
                millorServerCDA = new JP.go.ipa.oz.user.cda._ClassDeliveryAgent_pcl (millorServerCDAGOL);
// 183
                if (millorServerCDA != null) {{
// 184
                    JP.go.ipa.oz.lib.standard._String_if topPackageName = null;
// 185
                    long time = 0;
// 186
                    JP.go.ipa.oz.user.cda._DeliveryFile_if df = null;
// 187
                    /* for loop starting here */ {
                      /* initialization part */
                      int i = 0;
                      
                      for (;;) {
                        /* boolean expression part */
                        if (!(i < size)) break;
                        
                        /* body */ _loop_3: {
// 188
                          JP.go.ipa.oz.lang._Root_if nextElement$val$21;
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ite)) {
                            try {
                              nextElement$val$21 = ite.nextElement ();
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            nextElement$val$21 = ite.nextElement ();
                          }
// 188
                          topPackageName = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$21);
// 190
                          JP.go.ipa.oz.lib.standard._Long_if L = null;
// 190
                          JP.go.ipa.oz.lang._Root_if get$val$22;
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) times)) {
                            try {
                              get$val$22 = times.get (topPackageName);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            get$val$22 = times.get (topPackageName);
                          }
// 190
                          L = (JP.go.ipa.oz.lib.standard._Long_if) (get$val$22);
// 191
                          long longValue$val$23;
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) L)) {
                            try {
                              longValue$val$23 = L.longValue ();
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            longValue$val$23 = L.longValue ();
                          }
// 191
                          time = longValue$val$23;
// 193
                          df = millorServerCDA.millor (topPackageName, time);
// 194
                          if (df != null) {{
// 195
                              try {
// 196
                                JP.go.ipa.oz.lib.standard._LocalRepositoryManager_cl._static_remove (topPackageName);
                              }
                              catch (JP.go.ipa.oz.lang.OzException _exception_3) {
                                JP.go.ipa.oz.lang._Root_if _oz_exception_3 = _exception_3.getOzException ();
                                if (_oz_exception_3 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
                                  JP.go.ipa.oz.lib.standard._IOException_if e = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_3;
                                } else throw _exception_3;
                              }
                              catch (java.lang.SecurityException _exception_e) {
                                JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
                                
                              }
// 202
                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dfCache)) {
                                try {
                                  dfCache.put (topPackageName, df);
                                } finally {
                                  changeRunningToGreen ();
                                }
                              } else {
                                dfCache.put (topPackageName, df);
                              }
// 203
                              long time$val$24;
                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) df)) {
                                try {
                                  time$val$24 = df.time ();
                                } finally {
                                  changeRunningToGreen ();
                                }
                              } else {
                                time$val$24 = df.time ();
                              }
// 203
                              time = time$val$24;
// 204
                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) millors)) {
                                try {
                                  millors.versionupTopPackage (millorServerCDAGOL, topPackageName, time);
                                } finally {
                                  changeRunningToGreen ();
                                }
                              } else {
                                millors.versionupTopPackage (millorServerCDAGOL, topPackageName, time);
                              }
                            }
                          } else {{
                            }
                          }
                        }
                        /* iteration part */
// 187
                        i++;
                      }
                    }
                  }
                }
              }
              /* iteration part */
// 174
              j++;
            }
          }
        }
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_4) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_4 = _exception_4.getOzException ();
      if (_oz_exception_4 instanceof JP.go.ipa.oz.lib.standard._UserException_if) {
        JP.go.ipa.oz.lib.standard._UserException_if e = (JP.go.ipa.oz.lib.standard._UserException_if) _oz_exception_4;
// 216
        JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 216
        JP.go.ipa.oz.lib.standard._String_if string$16 = (new JP.go.ipa.oz.lib.standard._String_cl("polling fail"));
        
// 216
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
  
  protected void beforePolling () throws Exception  {
    enter ();
    try {
// 220
      wait (cond);
    } finally {
      leave ();
    }
  }
  
  public void pollingStart () throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 223
      signal (cond);
    } finally {
      leave ();
    }
  }
  
  public void setInterval (int i) throws Exception  {
    checkSecureInvocation ();
// 155
    interval = i;
  }
  
  public _PollingRunnable_cl () throws Exception { super (); }
  
}


package JP.go.ipa.oz.user.lib_dist.name;

public class _PollingRunnable_cl extends JP.go.ipa.oz.lang._Runnable_cl implements JP.go.ipa.oz.user.lib_dist.name._PollingRunnable_if {
  JP.go.ipa.oz.user.lib_dist.name._TroubleNameServers_if troubleList;
  protected JP.go.ipa.oz.system.OzCondition cond = new JP.go.ipa.oz.system.OzCondition (this);
  int maxPollingNum;
  int interval;
  
  public Object _new_create (JP.go.ipa.oz.user.lib_dist.name._TroubleNameServers_if t) throws Exception  {
// 325
    interval = 60000;
// 326
    troubleList = t;
// 327
    maxPollingNum = 60;
    return this;
  }
  
  public void run () throws Exception  {
    checkSecureInvocation ();
// 336
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 337
    JP.go.ipa.oz.lib.standard._System_if debug = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 338
    beforePolling ();
// 339
    JP.go.ipa.oz.lib.standard._String_if string$123 = (new JP.go.ipa.oz.lib.standard._String_cl("trouble control polling start."));
    
// 339
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.println (string$123);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.println (string$123);
    }
// 340
    try {
// 341
      boolean b = true;
// 342
      while (true) {
        if (!(b)) break;
        
        /* body */ _loop_1: {
// 344
          JP.go.ipa.oz.lib.standard._Dictionary_if nowList = null;
// 344
          JP.go.ipa.oz.lib.standard._Iterator_if ite = null;
// 344
          int size = 0;
// 345
          sleepThread (interval);
// 346
          JP.go.ipa.oz.lib.standard._Dictionary_if get$val$514;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) troubleList)) {
            try {
              get$val$514 = troubleList.get ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            get$val$514 = troubleList.get ();
          }
// 346
          nowList = get$val$514;
// 347
          JP.go.ipa.oz.lib.standard._Iterator_if keyIterator$val$515;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nowList)) {
            try {
              keyIterator$val$515 = nowList.keyIterator ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            keyIterator$val$515 = nowList.keyIterator ();
          }
// 347
          ite = keyIterator$val$515;
// 348
          int size$val$516;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nowList)) {
            try {
              size$val$516 = nowList.size ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            size$val$516 = nowList.size ();
          }
// 348
          size = size$val$516;
// 349
          /* for loop starting here */ {
            /* initialization part */
            int i = 0;
            
            for (;;) {
              /* boolean expression part */
              if (!(i < size)) break;
              
              /* body */ _loop_2: {
// 350
                JP.go.ipa.oz.lib.standard._String_if troubleNSTRGOL = null;
// 350
                JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_if troubleNSTR = null;
// 351
                boolean tf = false;
// 352
                JP.go.ipa.oz.lang._Root_if nextElement$val$517;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ite)) {
                  try {
                    nextElement$val$517 = ite.nextElement ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  nextElement$val$517 = ite.nextElement ();
                }
// 352
                troubleNSTRGOL = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$517);
// 353
                troubleNSTR = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_pcl (troubleNSTRGOL);
// 354
                tf = false;
// 354
                tf = troubleNSTR.ping ();
// 355
                if (tf) {
// 355
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) troubleList)) {
                    try {
                      troubleList.remove (troubleNSTRGOL);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    troubleList.remove (troubleNSTRGOL);
                  }
                } else {{
// 357
                    JP.go.ipa.oz.lib.standard._Integer_if pollingNum = null;
// 358
                    JP.go.ipa.oz.lang._Root_if get$val$518;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nowList)) {
                      try {
                        get$val$518 = nowList.get (troubleNSTRGOL);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      get$val$518 = nowList.get (troubleNSTRGOL);
                    }
// 358
                    pollingNum = (JP.go.ipa.oz.lib.standard._Integer_if) (get$val$518);
// 359
                    int intValue$val$519;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pollingNum)) {
                      try {
                        intValue$val$519 = pollingNum.intValue ();
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      intValue$val$519 = pollingNum.intValue ();
                    }
// 359
                    int pn = intValue$val$519;
// 360
                    if (pn > maxPollingNum) {
// 361
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) troubleList)) {
                        try {
                          troubleList.remove (troubleNSTRGOL);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        troubleList.remove (troubleNSTRGOL);
                      }
                    } else {{
// 363
                        pollingNum = (JP.go.ipa.oz.lib.standard._Integer_cl) (new JP.go.ipa.oz.lib.standard._Integer_cl ())._new_breed (pn + 1);
// 364
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) troubleList)) {
                          try {
                            troubleList.replace (troubleNSTRGOL, pollingNum);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          troubleList.replace (troubleNSTRGOL, pollingNum);
                        }
                      }
                    }
                  }
                }
              }
              /* iteration part */
// 349
              i++;
            }
          }
        }
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_1) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
      if (_oz_exception_1 instanceof JP.go.ipa.oz.lib.standard._UserException_if) {
        JP.go.ipa.oz.lib.standard._UserException_if e = (JP.go.ipa.oz.lib.standard._UserException_if) _oz_exception_1;
// 372
        JP.go.ipa.oz.lib.standard._String_if string$124 = (new JP.go.ipa.oz.lib.standard._String_cl("polling fail"));
        
// 372
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.println (string$124);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.println (string$124);
        }
      } else throw _exception_1;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 370
      JP.go.ipa.oz.lib.standard._String_if string$125 = (new JP.go.ipa.oz.lib.standard._String_cl("polling fail"));
      
// 370
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$125);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$125);
      }
    }
  }
  
  protected void beforePolling () throws Exception  {
    enter ();
    try {
// 330
      wait (cond);
    } finally {
      leave ();
    }
  }
  
  public void pollingStart () throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 332
      signal (cond);
    } finally {
      leave ();
    }
  }
  
  public _PollingRunnable_cl () throws Exception { super (); }
  
}


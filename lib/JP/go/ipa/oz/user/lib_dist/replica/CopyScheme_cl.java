package JP.go.ipa.oz.user.lib_dist.replica;

public class CopyScheme_cl extends JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_cl implements JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if {
  static final boolean _global_ = true;
  JP.go.ipa.oz.user.lib_dist.tran._TID_if tid;
  protected JP.go.ipa.oz.user.lib_dist.replica.OtherCopyManeger_if cpManeger;
  protected JP.go.ipa.oz.user.lib_dist.tran._Debug_if debug;
  protected boolean mgrFlag;
  protected JP.go.ipa.oz.lib.standard._Set_if crushedCopies;
  int timeOut;
  protected JP.go.ipa.oz.lib.standard._Set_if otherCopies;
  protected JP.go.ipa.oz.lib.standard._String_if cpmGol;
  protected boolean status;
  protected int MAX_ID;
  protected JP.go.ipa.oz.lib.standard._String_if ownGOL;
  protected int debugFlag;
  protected int idnum;
  
  public final int getTimeOut () throws Exception  {
    checkSecureInvocation ();
// 124
    return timeOut;
  }
  
  protected final void printCrushedCopy (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
// 526
    JP.go.ipa.oz.lib.standard._String_if tmp = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("Crushed copy is ")));
// 527
    JP.go.ipa.oz.lib.standard._String_if concat$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
      try {
        concat$val$0 = tmp.concat (gol);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$0 = tmp.concat (gol);
    }
// 527
    tmp = concat$val$0;
// 528
    println (tmp);
  }
  
  public boolean commitAll () throws Exception  {
    checkSecureInvocation ();
// 401
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cpManeger)) {
      try {
        cpManeger.commit ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      cpManeger.commit ();
    }
// 402
    return true;
  }
  
  protected void initialize () throws Exception  {
// 30
    d = (JP.go.ipa.oz.user.lib_dist.tran._Debug_cl) (new JP.go.ipa.oz.user.lib_dist.tran._Debug_cl ())._new_create ();
// 30
    x = 0;
// 30
    JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl(" p:"));
    
// 30
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.setP (string$0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.setP (string$0);
    }
// 31
    ownGOL = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("")));
// 32
    JP.go.ipa.oz.lib.standard._String_if getGOL$val$1;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ownGOL)) {
      try {
        getGOL$val$1 = ownGOL.getGOL ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getGOL$val$1 = ownGOL.getGOL ();
    }
// 32
    ownGOL = getGOL$val$1;
// 33
    super.initialize ((new JP.go.ipa.oz.lib.standard._String_cl("tmp0")), (new JP.go.ipa.oz.lib.standard._String_cl("tmp1")), (new JP.go.ipa.oz.lib.standard._String_cl("tmp2")), ownGOL);
// 36
    idnum = 1;
// 37
    tid = (JP.go.ipa.oz.user.lib_dist.tran._TID_cl) (new JP.go.ipa.oz.user.lib_dist.tran._TID_cl ())._new_create ();
// 38
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tid)) {
      try {
        tid.set (idnum, ownGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      tid.set (idnum, ownGOL);
    }
// 41
    JP.go.ipa.oz.user.lib_dist.replica.CopyRes_Comparator_if pc = (JP.go.ipa.oz.user.lib_dist.replica.CopyRes_Comparator_cl) (new JP.go.ipa.oz.user.lib_dist.replica.CopyRes_Comparator_cl ())._new_create ();
// 42
    otherCopies = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (pc);
// 43
    crushedCopies = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create ();
// 44
    cpmGol = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("")));
// 45
    mgrFlag = false;
// 46
    status = true;
// 47
    timeOut = 10000;
// 48
    MAX_ID = 10000;
  }
  
  public final void setCpmGol (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
    checkSecureInvocation ();
// 61
    cpmGol = gol;
  }
  
  public final boolean commit () throws Exception  {
    checkSecureInvocation ();
// 377
    boolean rc = true;
// 380
    try {
// 381
      if (isReadyToCommit (tid) == true) {
// 382
        super.commit (tid);
      }
// 383
      super.unlock (tid);
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 386
      JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl("Error in commit()"));
      
// 386
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
        try {
          debug.write (debugFlag, string$1);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        debug.write (debugFlag, string$1);
      }
// 387
      rc = false;
    }
// 389
    return rc;
  }
  
  public final JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if getClientStubCP () throws Exception  {
    checkSecureInvocation ();
// 419
    long cTime = 0, minTime = 0;
// 420
    JP.go.ipa.oz.lib.standard._Long_if lTime = null;
// 421
    JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if copy = null, minCopy = null;
// 422
    JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if cpResource = null;
// 423
    JP.go.ipa.oz.lib.standard._Iterator_if iterator = null;
// 424
    JP.go.ipa.oz.lib.standard._String_if stime = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("")));
// 426
    JP.go.ipa.oz.user.lib_dist.sync.timer._Timer_if t = (JP.go.ipa.oz.user.lib_dist.sync.timer._Timer_cl) (new JP.go.ipa.oz.user.lib_dist.sync.timer._Timer_cl ())._new_create ();
// 427
    JP.go.ipa.oz.user.lib_dist.replica.CopyFoo_if obj = (JP.go.ipa.oz.user.lib_dist.replica.CopyFoo_cl) (new JP.go.ipa.oz.user.lib_dist.replica.CopyFoo_cl ())._new_create ();
// 428
    JP.go.ipa.oz.user.lib_dist.replica.CopyMethodRunnable_if mmr = (JP.go.ipa.oz.user.lib_dist.replica.CopyMethodRunnable_cl) (new JP.go.ipa.oz.user.lib_dist.replica.CopyMethodRunnable_cl ())._new_create (t);
// 429
    minTime = timeOut;
// 432
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$2;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) otherCopies)) {
      try {
        iterator$val$2 = otherCopies.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$2 = otherCopies.iterator ();
    }
// 432
    iterator = iterator$val$2;
// 433
    while (true) {
// 433
      boolean hasMoreElements$val$3;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iterator)) {
        try {
          hasMoreElements$val$3 = iterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$3 = iterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$3)) break;
      
      /* body */ _loop_1: {
// 434
        JP.go.ipa.oz.lang._Root_if nextElement$val$4;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iterator)) {
          try {
            nextElement$val$4 = iterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$4 = iterator.nextElement ();
        }
// 434
        cpResource = (JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if) (nextElement$val$4);
// 435
        JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if getCopy$val$5;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cpResource)) {
          try {
            getCopy$val$5 = cpResource.getCopy ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getCopy$val$5 = cpResource.getCopy ();
        }
// 435
        copy = getCopy$val$5;
// 436
        JP.go.ipa.oz.lib.standard._String_if getGol$val$6;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cpResource)) {
          try {
            getGol$val$6 = cpResource.getGol ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getGol$val$6 = cpResource.getGol ();
        }
// 436
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
          try {
            debug.write (debugFlag, getGol$val$6);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          debug.write (debugFlag, getGol$val$6);
        }
// 439
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mmr)) {
          try {
            mmr.set (obj, copy, 7, null);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          mmr.set (obj, copy, 7, null);
        }
// 440
        try {
// 441
          JP.go.ipa.oz.lang._Root_if invoke$val$7;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
            try {
              invoke$val$7 = t.invoke (mmr, timeOut);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            invoke$val$7 = t.invoke (mmr, timeOut);
          }
// 441
          lTime = (JP.go.ipa.oz.lib.standard._Long_if) (invoke$val$7);
// 442
          long longValue$val$8;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lTime)) {
            try {
              longValue$val$8 = lTime.longValue ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            longValue$val$8 = lTime.longValue ();
          }
// 442
          cTime = longValue$val$8;
// 443
          JP.go.ipa.oz.lib.standard._String_if asString$val$9;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lTime)) {
            try {
              asString$val$9 = lTime.asString ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            asString$val$9 = lTime.asString ();
          }
// 443
          stime = asString$val$9;
// 444
          JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl("isLive() time is "));
          
// 444
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
            try {
              debug.write (debugFlag, string$2, stime);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            debug.write (debugFlag, string$2, stime);
          }
// 446
          if (cTime < minTime) {{
// 447
              minTime = cTime;
// 448
              minCopy = copy;
            }
          }
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_1) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
          if (_oz_exception_1 instanceof JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) {
            JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) _oz_exception_1;
// 452
            JP.go.ipa.oz.lib.standard._String_if string$3 = (new JP.go.ipa.oz.lib.standard._String_cl("isLive() Time Out!"));
            
// 452
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
              try {
                debug.write (debugFlag, string$3);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              debug.write (debugFlag, string$3);
            }
          } else throw _exception_1;
        }
        catch (JP.go.ipa.oz.system.ExException _exception_e) {
          JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
          
        }
      }
    }
// 458
    lTime = (JP.go.ipa.oz.lib.standard._Long_cl) (new JP.go.ipa.oz.lib.standard._Long_cl ())._new_breed (minTime);
// 459
    stime = lTime.asString ();
// 460
    JP.go.ipa.oz.lib.standard._String_if string$4 = (new JP.go.ipa.oz.lib.standard._String_cl("minimam time is "));
    
// 460
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.write (debugFlag, string$4, stime);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.write (debugFlag, string$4, stime);
    }
// 461
    return minCopy;
  }
  
  public final void printCrushList () throws Exception  {
    checkSecureInvocation ();
// 481
    JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if cpResource = null;
// 482
    JP.go.ipa.oz.lib.standard._Iterator_if iterator = null;
// 484
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$10;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) crushedCopies)) {
      try {
        iterator$val$10 = crushedCopies.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$10 = crushedCopies.iterator ();
    }
// 484
    iterator = iterator$val$10;
// 485
    while (true) {
// 485
      boolean hasMoreElements$val$11;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iterator)) {
        try {
          hasMoreElements$val$11 = iterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$11 = iterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$11)) break;
      
      /* body */ _loop_1: {
// 486
        JP.go.ipa.oz.lang._Root_if nextElement$val$12;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iterator)) {
          try {
            nextElement$val$12 = iterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$12 = iterator.nextElement ();
        }
// 486
        cpResource = (JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if) (nextElement$val$12);
// 487
        JP.go.ipa.oz.lib.standard._String_if getGol$val$13;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cpResource)) {
          try {
            getGol$val$13 = cpResource.getGol ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getGol$val$13 = cpResource.getGol ();
        }
// 487
        println (getGol$val$13);
      }
    }
  }
  
  public final void setResourceTimeLimit (int time) throws Exception  {
    checkSecureInvocation ();
// 134
    super.setLockingTimeLimit (time);
  }
  
  public boolean propagateAllCP (int type) throws Exception  {
    checkSecureInvocation ();
// 228
    JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if cpResource = null;
// 229
    JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if copy = null;
// 230
    JP.go.ipa.oz.lib.standard._Iterator_if iterator = null;
// 231
    boolean errFlag = false, crushFlag = false;
// 232
    boolean rc = true;
// 234
    errFlag = false;
// 235
    JP.go.ipa.oz.user.lib_dist.sync.timer._Timer_if t = (JP.go.ipa.oz.user.lib_dist.sync.timer._Timer_cl) (new JP.go.ipa.oz.user.lib_dist.sync.timer._Timer_cl ())._new_create ();
// 236
    JP.go.ipa.oz.user.lib_dist.replica.CopyFoo_if obj = (JP.go.ipa.oz.user.lib_dist.replica.CopyFoo_cl) (new JP.go.ipa.oz.user.lib_dist.replica.CopyFoo_cl ())._new_create ();
// 237
    JP.go.ipa.oz.user.lib_dist.replica.CopyMethodRunnable_if mmr = (JP.go.ipa.oz.user.lib_dist.replica.CopyMethodRunnable_cl) (new JP.go.ipa.oz.user.lib_dist.replica.CopyMethodRunnable_cl ())._new_create (t);
// 238
    try {
// 240
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mmr)) {
        try {
          mmr.set (obj, this, 2, null);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        mmr.set (obj, this, 2, null);
      }
// 241
      JP.go.ipa.oz.lang._Root_if invoke$val$14;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
        try {
          invoke$val$14 = t.invoke (mmr, timeOut);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        invoke$val$14 = t.invoke (mmr, timeOut);
      }
// 242
      JP.go.ipa.oz.lib.standard._String_if string$5 = (new JP.go.ipa.oz.lib.standard._String_cl("lockAll() O.K."));
      
// 242
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
        try {
          debug.write (debugFlag, string$5);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        debug.write (debugFlag, string$5);
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_2) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_2 = _exception_2.getOzException ();
      if (_oz_exception_2 instanceof JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) {
        JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) _oz_exception_2;
// 245
        JP.go.ipa.oz.lib.standard._String_if string$6 = (new JP.go.ipa.oz.lib.standard._String_cl("lockAll() Time Out!"));
        
// 245
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
          try {
            debug.write (debugFlag, string$6);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          debug.write (debugFlag, string$6);
        }
// 246
        errFlag = true;
// 247
        status = false;
      } else throw _exception_2;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 250
      errFlag = true;
// 251
      status = false;
    }
// 254
    if (errFlag == false) {{
// 255
        try {
// 256
          JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$15;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) otherCopies)) {
            try {
              iterator$val$15 = otherCopies.iterator ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            iterator$val$15 = otherCopies.iterator ();
          }
// 256
          iterator = iterator$val$15;
// 257
          while (true) {
// 257
            boolean hasMoreElements$val$16;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iterator)) {
              try {
                hasMoreElements$val$16 = iterator.hasMoreElements ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              hasMoreElements$val$16 = iterator.hasMoreElements ();
            }
            if (!(hasMoreElements$val$16)) break;
            
            /* body */ _loop_1: {
// 258
              JP.go.ipa.oz.lang._Root_if nextElement$val$17;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iterator)) {
                try {
                  nextElement$val$17 = iterator.nextElement ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                nextElement$val$17 = iterator.nextElement ();
              }
// 258
              cpResource = (JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if) (nextElement$val$17);
// 259
              JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if getCopy$val$18;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cpResource)) {
                try {
                  getCopy$val$18 = cpResource.getCopy ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getCopy$val$18 = cpResource.getCopy ();
              }
// 259
              copy = getCopy$val$18;
// 261
              if (type == 3) {
// 262
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mmr)) {
                  try {
                    mmr.set (obj, copy, 3, ownGOL);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  mmr.set (obj, copy, 3, ownGOL);
                }
              } else {
// 264
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mmr)) {
                  try {
                    mmr.set (obj, copy, 4, null);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  mmr.set (obj, copy, 4, null);
                }
              }
// 265
              JP.go.ipa.oz.lang._Root_if invoke$val$19;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
                try {
                  invoke$val$19 = t.invoke (mmr, timeOut);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                invoke$val$19 = t.invoke (mmr, timeOut);
              }
// 266
              JP.go.ipa.oz.lib.standard._String_if string$7 = (new JP.go.ipa.oz.lib.standard._String_cl("update() O.K."));
              
// 266
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
                try {
                  debug.write (debugFlag, string$7);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                debug.write (debugFlag, string$7);
              }
            }
          }
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_3) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_3 = _exception_3.getOzException ();
          if (_oz_exception_3 instanceof JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) {
            JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) _oz_exception_3;
// 270
            JP.go.ipa.oz.lib.standard._String_if string$8 = (new JP.go.ipa.oz.lib.standard._String_cl("update() Time Out!"));
            
// 270
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
              try {
                debug.write (debugFlag, string$8);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              debug.write (debugFlag, string$8);
            }
// 271
            errFlag = true;
// 272
            status = false;
          } else throw _exception_3;
        }
        catch (JP.go.ipa.oz.system.ExException _exception_e) {
          JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
          
// 275
          errFlag = true;
// 276
          status = false;
        }
      }
    }
// 280
    try {
// 282
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mmr)) {
        try {
          mmr.set (obj, this, 6, null);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        mmr.set (obj, this, 6, null);
      }
// 283
      JP.go.ipa.oz.lang._Root_if invoke$val$20;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
        try {
          invoke$val$20 = t.invoke (mmr, timeOut);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        invoke$val$20 = t.invoke (mmr, timeOut);
      }
// 284
      JP.go.ipa.oz.lib.standard._String_if string$9 = (new JP.go.ipa.oz.lib.standard._String_cl("commitAll() O.K."));
      
// 284
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
        try {
          debug.write (debugFlag, string$9);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        debug.write (debugFlag, string$9);
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_4) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_4 = _exception_4.getOzException ();
      if (_oz_exception_4 instanceof JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) {
        JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) _oz_exception_4;
// 287
        JP.go.ipa.oz.lib.standard._String_if string$10 = (new JP.go.ipa.oz.lib.standard._String_cl("commitAll() Time Out!"));
        
// 287
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
          try {
            debug.write (debugFlag, string$10);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          debug.write (debugFlag, string$10);
        }
      } else throw _exception_4;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
    }
// 292
    if (errFlag) {{
// 294
        crushFlag = false;
// 295
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$21;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) otherCopies)) {
          try {
            iterator$val$21 = otherCopies.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$21 = otherCopies.iterator ();
        }
// 295
        iterator = iterator$val$21;
// 296
        while (true) {
// 296
          boolean hasMoreElements$val$22;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iterator)) {
            try {
              hasMoreElements$val$22 = iterator.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$22 = iterator.hasMoreElements ();
          }
          if (!(hasMoreElements$val$22)) break;
          
          /* body */ _loop_1: {
// 297
            JP.go.ipa.oz.lang._Root_if nextElement$val$23;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iterator)) {
              try {
                nextElement$val$23 = iterator.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$23 = iterator.nextElement ();
            }
// 297
            cpResource = (JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if) (nextElement$val$23);
// 298
            JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if getCopy$val$24;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cpResource)) {
              try {
                getCopy$val$24 = cpResource.getCopy ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getCopy$val$24 = cpResource.getCopy ();
            }
// 298
            copy = getCopy$val$24;
// 299
            rc = true;
// 300
            try {
// 302
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mmr)) {
                try {
                  mmr.set (obj, copy, 1, null);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                mmr.set (obj, copy, 1, null);
              }
// 303
              JP.go.ipa.oz.lang._Root_if invoke$val$25;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
                try {
                  invoke$val$25 = t.invoke (mmr, timeOut);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                invoke$val$25 = t.invoke (mmr, timeOut);
              }
// 304
              JP.go.ipa.oz.lib.standard._String_if string$11 = (new JP.go.ipa.oz.lib.standard._String_cl("lock() O.K."));
              
// 304
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
                try {
                  debug.write (debugFlag, string$11);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                debug.write (debugFlag, string$11);
              }
            }
            catch (JP.go.ipa.oz.lang.OzException _exception_5) {
              JP.go.ipa.oz.lang._Root_if _oz_exception_5 = _exception_5.getOzException ();
              if (_oz_exception_5 instanceof JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) {
                JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) _oz_exception_5;
// 307
                rc = false;
// 308
                JP.go.ipa.oz.lib.standard._String_if string$12 = (new JP.go.ipa.oz.lib.standard._String_cl("lock() Time Out!"));
                
// 308
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
                  try {
                    debug.write (debugFlag, string$12);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  debug.write (debugFlag, string$12);
                }
              } else throw _exception_5;
            }
            catch (JP.go.ipa.oz.system.ExException _exception_e) {
              JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
              
// 311
              rc = false;
            }
// 313
            if (rc == true) {{
// 314
                try {
// 316
                  if (type == 3) {
// 317
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mmr)) {
                      try {
                        mmr.set (obj, copy, 3, ownGOL);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      mmr.set (obj, copy, 3, ownGOL);
                    }
                  } else {
// 319
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mmr)) {
                      try {
                        mmr.set (obj, copy, 4, null);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      mmr.set (obj, copy, 4, null);
                    }
                  }
// 320
                  JP.go.ipa.oz.lang._Root_if invoke$val$26;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
                    try {
                      invoke$val$26 = t.invoke (mmr, timeOut);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    invoke$val$26 = t.invoke (mmr, timeOut);
                  }
// 321
                  JP.go.ipa.oz.lib.standard._String_if string$13 = (new JP.go.ipa.oz.lib.standard._String_cl("update() O.K."));
                  
// 321
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
                    try {
                      debug.write (debugFlag, string$13);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    debug.write (debugFlag, string$13);
                  }
                }
                catch (JP.go.ipa.oz.lang.OzException _exception_6) {
                  JP.go.ipa.oz.lang._Root_if _oz_exception_6 = _exception_6.getOzException ();
                  if (_oz_exception_6 instanceof JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) {
                    JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) _oz_exception_6;
// 324
                    rc = false;
// 325
                    JP.go.ipa.oz.lib.standard._String_if string$14 = (new JP.go.ipa.oz.lib.standard._String_cl("update() Time Out!"));
                    
// 325
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
                      try {
                        debug.write (debugFlag, string$14);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      debug.write (debugFlag, string$14);
                    }
                  } else throw _exception_6;
                }
                catch (JP.go.ipa.oz.system.ExException _exception_e) {
                  JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
                  
// 328
                  rc = false;
                }
              }
            }
// 331
            if (rc == true) {{
// 332
                try {
// 334
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mmr)) {
                    try {
                      mmr.set (obj, copy, 5, null);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    mmr.set (obj, copy, 5, null);
                  }
// 335
                  JP.go.ipa.oz.lang._Root_if invoke$val$27;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
                    try {
                      invoke$val$27 = t.invoke (mmr, timeOut);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    invoke$val$27 = t.invoke (mmr, timeOut);
                  }
// 336
                  JP.go.ipa.oz.lib.standard._String_if string$15 = (new JP.go.ipa.oz.lib.standard._String_cl("commit() O.K."));
                  
// 336
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
                    try {
                      debug.write (debugFlag, string$15);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    debug.write (debugFlag, string$15);
                  }
                }
                catch (JP.go.ipa.oz.lang.OzException _exception_7) {
                  JP.go.ipa.oz.lang._Root_if _oz_exception_7 = _exception_7.getOzException ();
                  if (_oz_exception_7 instanceof JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) {
                    JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) _oz_exception_7;
// 339
                    JP.go.ipa.oz.lib.standard._String_if string$16 = (new JP.go.ipa.oz.lib.standard._String_cl("commit() Time Out!"));
                    
// 339
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
                      try {
                        debug.write (debugFlag, string$16);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      debug.write (debugFlag, string$16);
                    }
// 340
                    rc = false;
                  } else throw _exception_7;
                }
                catch (JP.go.ipa.oz.system.ExException _exception_e) {
                  JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
                  
// 343
                  rc = false;
                }
              }
            }
// 346
            if (rc == false) {{
// 348
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cpResource)) {
                  try {
                    cpResource.setDate ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  cpResource.setDate ();
                }
// 350
                JP.go.ipa.oz.lib.standard._Set_if add$val$28;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) crushedCopies)) {
                  try {
                    add$val$28 = crushedCopies.add (cpResource);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  add$val$28 = crushedCopies.add (cpResource);
                }
// 351
                crushFlag = true;
// 353
                JP.go.ipa.oz.lib.standard._String_if getGol$val$29;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cpResource)) {
                  try {
                    getGol$val$29 = cpResource.getGol ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  getGol$val$29 = cpResource.getGol ();
                }
// 353
                printCrushedCopy (getGol$val$29);
              }
            }
          }
        }
// 357
        if (crushFlag) {{
// 358
            JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$30;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) crushedCopies)) {
              try {
                iterator$val$30 = crushedCopies.iterator ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              iterator$val$30 = crushedCopies.iterator ();
            }
// 358
            iterator = iterator$val$30;
// 359
            while (true) {
// 359
              boolean hasMoreElements$val$31;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iterator)) {
                try {
                  hasMoreElements$val$31 = iterator.hasMoreElements ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                hasMoreElements$val$31 = iterator.hasMoreElements ();
              }
              if (!(hasMoreElements$val$31)) break;
              
              /* body */ _loop_1: {
// 360
                JP.go.ipa.oz.lang._Root_if nextElement$val$32;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iterator)) {
                  try {
                    nextElement$val$32 = iterator.nextElement ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  nextElement$val$32 = iterator.nextElement ();
                }
// 360
                cpResource = (JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if) (nextElement$val$32);
// 361
                JP.go.ipa.oz.lib.standard._Collection_if remove$val$33;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) otherCopies)) {
                  try {
                    remove$val$33 = otherCopies.remove (cpResource);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  remove$val$33 = otherCopies.remove (cpResource);
                }
// 361
                otherCopies = (JP.go.ipa.oz.lib.standard._Set_if) (remove$val$33);
              }
            }
          }
        }
      }
    }
// 366
    return rc;
  }
  
  public final boolean isLive () throws Exception  {
    checkSecureInvocation ();
// 471
    return true;
  }
  
  public final void setTid (int id) throws Exception  {
    checkSecureInvocation ();
// 516
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tid)) {
      try {
        tid.setID (id);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      tid.setID (id);
    }
  }
  
  protected void quiet () throws Exception  {
// 52
    flushCell ();
  }
  
  public final void printCopyList () throws Exception  {
    checkSecureInvocation ();
// 499
    JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if cpResource = null;
// 500
    JP.go.ipa.oz.lib.standard._Iterator_if iterator = null;
// 502
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$34;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) otherCopies)) {
      try {
        iterator$val$34 = otherCopies.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$34 = otherCopies.iterator ();
    }
// 502
    iterator = iterator$val$34;
// 503
    while (true) {
// 503
      boolean hasMoreElements$val$35;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iterator)) {
        try {
          hasMoreElements$val$35 = iterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$35 = iterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$35)) break;
      
      /* body */ _loop_1: {
// 504
        JP.go.ipa.oz.lang._Root_if nextElement$val$36;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iterator)) {
          try {
            nextElement$val$36 = iterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$36 = iterator.nextElement ();
        }
// 504
        cpResource = (JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if) (nextElement$val$36);
// 505
        JP.go.ipa.oz.lib.standard._String_if getGol$val$37;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cpResource)) {
          try {
            getGol$val$37 = cpResource.getGol ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getGol$val$37 = cpResource.getGol ();
        }
// 505
        println (getGol$val$37);
      }
    }
  }
  
  public final boolean propagate () throws Exception  {
    checkSecureInvocation ();
// 201
    boolean rc = true;
// 203
    try {
// 204
      super.lock (tid);
// 205
      update (ownGOL);
// 206
      if (isReadyToCommit (tid) == true) {{
// 207
          super.commit (tid);
        }
      }
// 209
      super.unlock (tid);
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 212
      JP.go.ipa.oz.lib.standard._String_if string$17 = (new JP.go.ipa.oz.lib.standard._String_cl("Error in propagete()"));
      
// 212
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
        try {
          debug.write (debugFlag, string$17);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        debug.write (debugFlag, string$17);
      }
// 213
      rc = false;
    }
// 215
    return rc;
  }
  
  protected void println (int i) throws Exception  {
// 549
    JP.go.ipa.oz.lib.standard._Integer_if st = (JP.go.ipa.oz.lib.standard._Integer_cl) (new JP.go.ipa.oz.lib.standard._Integer_cl ())._new_breed (i);
// 550
    JP.go.ipa.oz.lib.standard._System_if s = null;
// 550
    s = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 551
    JP.go.ipa.oz.lib.standard._PrintWriter_if o = s.getStdout ();
// 552
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
      try {
        o.println (st);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      o.println (st);
    }
// 552
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
      try {
        o.flush ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      o.flush ();
    }
  }
  
  protected void println (JP.go.ipa.oz.lib.standard._String_if str) throws Exception  {
// 538
    JP.go.ipa.oz.lib.standard._System_if s = null;
// 538
    s = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 539
    JP.go.ipa.oz.lib.standard._PrintWriter_if o = s.getStdout ();
// 540
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
      try {
        o.println (str);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      o.println (str);
    }
// 540
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
      try {
        o.flush ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      o.flush ();
    }
  }
  
  public final void setTimeOut (int time) throws Exception  {
    checkSecureInvocation ();
// 111
    timeOut = time;
// 114
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cpManeger)) {
      try {
        cpManeger.setResourceTimeOut (timeOut);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      cpManeger.setResourceTimeOut (timeOut);
    }
  }
  
  public final boolean removeCopyOf (JP.go.ipa.oz.lib.standard._String_if delGol) throws Exception  {
    checkSecureInvocation ();
// 87
    JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if cpResource = null;
// 88
    JP.go.ipa.oz.lib.standard._String_if gol = null;
// 89
    boolean rc = false;
// 91
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$38;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) otherCopies)) {
      try {
        iterator$val$38 = otherCopies.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$38 = otherCopies.iterator ();
    }
// 91
    JP.go.ipa.oz.lib.standard._Iterator_if iterator = iterator$val$38;
// 92
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
      
      for (;;) {
        /* boolean expression part */
// 92
        boolean hasMoreElements$val$39;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iterator)) {
          try {
            hasMoreElements$val$39 = iterator.hasMoreElements ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          hasMoreElements$val$39 = iterator.hasMoreElements ();
        }
        if (!(hasMoreElements$val$39)) break;
        
        /* body */ _loop_1: {
// 93
          JP.go.ipa.oz.lang._Root_if nextElement$val$40;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iterator)) {
            try {
              nextElement$val$40 = iterator.nextElement ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nextElement$val$40 = iterator.nextElement ();
          }
// 93
          cpResource = (JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if) (nextElement$val$40);
// 94
          JP.go.ipa.oz.lib.standard._String_if getGol$val$41;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cpResource)) {
            try {
              getGol$val$41 = cpResource.getGol ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getGol$val$41 = cpResource.getGol ();
          }
// 94
          gol = getGol$val$41;
// 95
          int compareTo$val$42;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) delGol)) {
            try {
              compareTo$val$42 = delGol.compareTo (gol);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            compareTo$val$42 = delGol.compareTo (gol);
          }
// 95
          if (compareTo$val$42 == 0) {{
// 96
              JP.go.ipa.oz.lib.standard._Collection_if remove$val$43;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) otherCopies)) {
                try {
                  remove$val$43 = otherCopies.remove (cpResource);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                remove$val$43 = otherCopies.remove (cpResource);
              }
// 96
              otherCopies = (JP.go.ipa.oz.lib.standard._Set_if) (remove$val$43);
// 97
              rc = true;
// 98
              break;
            }
          }
        }
        /* iteration part */
// 92
        i++;
      }
    }
// 101
    return rc;
  }
  
  public boolean lockAll () throws Exception  {
    checkSecureInvocation ();
// 166
    JP.go.ipa.oz.lib.standard._Array_if golArray = null;
// 167
    JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if cpResource = null;
// 168
    JP.go.ipa.oz.lib.standard._String_if gol = null;
// 169
    JP.go.ipa.oz.lib.standard._Iterator_if iterator = null;
// 170
    int i = 0;
// 171
    boolean rc = true;
// 174
    int size$val$44;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) otherCopies)) {
      try {
        size$val$44 = otherCopies.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$44 = otherCopies.size ();
    }
// 174
    golArray = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (size$val$44);
// 175
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$45;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) otherCopies)) {
      try {
        iterator$val$45 = otherCopies.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$45 = otherCopies.iterator ();
    }
// 175
    iterator = iterator$val$45;
// 176
    /* for loop starting here */ {
      /* initialization part */
// 176
      i = 0;
      
      for (;;) {
        /* boolean expression part */
// 176
        boolean hasMoreElements$val$46;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iterator)) {
          try {
            hasMoreElements$val$46 = iterator.hasMoreElements ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          hasMoreElements$val$46 = iterator.hasMoreElements ();
        }
        if (!(hasMoreElements$val$46)) break;
        
        /* body */ _loop_1: {
// 177
          JP.go.ipa.oz.lang._Root_if nextElement$val$47;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iterator)) {
            try {
              nextElement$val$47 = iterator.nextElement ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nextElement$val$47 = iterator.nextElement ();
          }
// 177
          cpResource = (JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if) (nextElement$val$47);
// 178
          JP.go.ipa.oz.lib.standard._String_if getGol$val$48;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cpResource)) {
            try {
              getGol$val$48 = cpResource.getGol ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getGol$val$48 = cpResource.getGol ();
          }
// 178
          gol = getGol$val$48;
// 179
          golArray.putAt (i, gol);
        }
        /* iteration part */
// 176
        i++;
      }
    }
// 182
    try {
// 184
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cpManeger)) {
        try {
          cpManeger.lock (golArray);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        cpManeger.lock (golArray);
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 187
      JP.go.ipa.oz.lib.standard._String_if string$18 = (new JP.go.ipa.oz.lib.standard._String_cl("Error in lockAll()"));
      
// 187
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
        try {
          debug.write (debugFlag, string$18);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        debug.write (debugFlag, string$18);
      }
// 188
      rc = false;
    }
// 190
    return rc;
  }
  
  protected void go () throws Exception  {
// 51
    ;
  }
  
  public void update (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
    checkSecureInvocation ();
  }
  
  public void update () throws Exception  {
    checkSecureInvocation ();
  }
  
  public final boolean lock () throws Exception  {
    checkSecureInvocation ();
// 145
    boolean rc = true;
// 148
    try {
// 149
      super.lock (tid);
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 152
      JP.go.ipa.oz.lib.standard._String_if string$19 = (new JP.go.ipa.oz.lib.standard._String_cl("Error in lock()"));
      
// 152
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
        try {
          debug.write (debugFlag, string$19);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        debug.write (debugFlag, string$19);
      }
// 153
      rc = false;
    }
// 155
    return rc;
  }
  
  public final void setCpManeger () throws Exception  {
    checkSecureInvocation ();
// 71
    mgrFlag = true;
// 72
    cpManeger = new JP.go.ipa.oz.user.lib_dist.replica.OtherCopyManeger_pcl (cpmGol, "JP.go.ipa.oz.user.lib_dist.replica.OtherCopyManeger_cl");
// 73
    cpManeger = new JP.go.ipa.oz.user.lib_dist.replica.OtherCopyManeger_pcl (cpmGol);
// 74
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cpManeger)) {
      try {
        cpManeger.setResourceTimeOut (timeOut);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      cpManeger.setResourceTimeOut (timeOut);
    }
  }
  
  public CopyScheme_cl () { super ("JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_pcl"); }
  
  public CopyScheme_cl (String proxy_id) { super (proxy_id); }
  
}


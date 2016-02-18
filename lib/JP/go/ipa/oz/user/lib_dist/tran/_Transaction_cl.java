package JP.go.ipa.oz.user.lib_dist.tran;

public class _Transaction_cl extends JP.go.ipa.oz.system.OzCell implements JP.go.ipa.oz.user.lib_dist.tran._Transaction_if {
  static final boolean _global_ = true;
  int maxBlockingResource;
  JP.go.ipa.oz.user.lib_dist.tran._TID_if tid;
  int maxLockRetry;
  protected JP.go.ipa.oz.user.lib_dist.tran._Debug_if d;
  protected int x;
  JP.go.ipa.oz.lib.standard._Array_if lockingResources;
  int timeOut;
  int maxID;
  int bx;
  int size;
  JP.go.ipa.oz.lib.standard._Array_if blockingResources;
  int ScanTime;
  int maxLockingResource;
  int lx;
  
  protected final boolean checkDeadLock () throws Exception  {
// 185
    JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl("checkDeadLock:"));
    
// 185
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (1, string$0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (1, string$0);
    }
// 192
    JP.go.ipa.oz.lib.standard._String_if rg = null;
// 193
    JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if r = null;
// 194
    try {
// 195
      JP.go.ipa.oz.user.lib_dist.tran._TIDComparator_if tc = null;
// 195
      tc = (JP.go.ipa.oz.user.lib_dist.tran._TIDComparator_cl) (new JP.go.ipa.oz.user.lib_dist.tran._TIDComparator_cl ())._new_create ();
// 195
      JP.go.ipa.oz.lib.standard._SList_if lt = null;
// 195
      lt = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create (tc);
// 196
      JP.go.ipa.oz.user.lib_dist.tran._TID_if lt1 = null;
// 196
      JP.go.ipa.oz.user.lib_dist.tran._Transaction_if t = null;
// 196
      int max = 0, i = 0;
// 198
      i = bx - 1;
// 198
      JP.go.ipa.oz.lang._Root_if at$val$0;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) blockingResources)) {
        try {
          at$val$0 = blockingResources.at (i);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        at$val$0 = blockingResources.at (i);
      }
// 198
      rg = (JP.go.ipa.oz.lib.standard._String_if) (at$val$0);
// 199
      JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl(" blocking:"));
      
// 199
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$1, rg);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$1, rg);
      }
// 200
      r = getResource (rg, timeOut);
// 202
      JP.go.ipa.oz.lib.standard._SList_if getLockingTransaction$val$1;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
        try {
          getLockingTransaction$val$1 = r.getLockingTransaction ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getLockingTransaction$val$1 = r.getLockingTransaction ();
      }
// 202
      lt = getLockingTransaction$val$1;
// 203
      JP.go.ipa.oz.lang._Root_if first$val$2;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lt)) {
        try {
          first$val$2 = lt.first ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        first$val$2 = lt.first ();
      }
// 203
      lt1 = (JP.go.ipa.oz.user.lib_dist.tran._TID_if) (first$val$2);
// 203
      JP.go.ipa.oz.lib.standard._String_if getTidGOL$val$3;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lt1)) {
        try {
          getTidGOL$val$3 = lt1.getTidGOL ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getTidGOL$val$3 = lt1.getTidGOL ();
      }
// 203
      rg = getTidGOL$val$3;
// 204
      JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl(" that resource's locking by:"));
      
// 204
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$2, rg);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$2, rg);
      }
// 205
      t = new JP.go.ipa.oz.user.lib_dist.tran._Transaction_pcl (rg);
// 207
      max = t.getMaxBlockingResource ();
// 208
      JP.go.ipa.oz.lib.standard._Array_if a = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (max);
// 209
      a = t.getBlockingResources ();
// 209
      JP.go.ipa.oz.lang._Root_if at$val$4;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) a)) {
        try {
          at$val$4 = a.at (0);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        at$val$4 = a.at (0);
      }
// 209
      rg = (JP.go.ipa.oz.lib.standard._String_if) (at$val$4);
// 210
      JP.go.ipa.oz.lib.standard._String_if string$3 = (new JP.go.ipa.oz.lib.standard._String_cl(" that transaction's blocking:"));
      
// 210
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$3, rg);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$3, rg);
      }
// 211
      r = getResource (rg, timeOut);
// 213
      JP.go.ipa.oz.lib.standard._SList_if getLockingTransaction$val$5;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
        try {
          getLockingTransaction$val$5 = r.getLockingTransaction ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getLockingTransaction$val$5 = r.getLockingTransaction ();
      }
// 213
      lt = getLockingTransaction$val$5;
// 213
      JP.go.ipa.oz.lang._Root_if first$val$6;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lt)) {
        try {
          first$val$6 = lt.first ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        first$val$6 = lt.first ();
      }
// 213
      lt1 = (JP.go.ipa.oz.user.lib_dist.tran._TID_if) (first$val$6);
// 214
      JP.go.ipa.oz.lib.standard._String_if string$4 = (new JP.go.ipa.oz.lib.standard._String_cl(" finally,that resource's locking by:"));
      
// 214
      JP.go.ipa.oz.lib.standard._String_if getTidGOL$val$7;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lt1)) {
        try {
          getTidGOL$val$7 = lt1.getTidGOL ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getTidGOL$val$7 = lt1.getTidGOL ();
      }
// 214
      int getID$val$8;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lt1)) {
        try {
          getID$val$8 = lt1.getID ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getID$val$8 = lt1.getID ();
      }
// 214
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$4, getTidGOL$val$7, getID$val$8);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$4, getTidGOL$val$7, getID$val$8);
      }
// 215
      boolean equal$val$9;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tid)) {
        try {
          equal$val$9 = tid.equal (lt1);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        equal$val$9 = tid.equal (lt1);
      }
// 215
      if (equal$val$9) {
// 215
        return true;
      } else {
// 215
        return false;
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 216
      JP.go.ipa.oz.lib.standard._String_if string$5 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 216
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$5);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$5);
      }
// 216
      return false;
    }
  }
  
  protected final void setMaxLockRetry (int n) throws Exception  {
// 52
    maxLockRetry = n;
  }
  
  final void unlock () throws Exception  {
// 226
    JP.go.ipa.oz.lib.standard._String_if string$6 = (new JP.go.ipa.oz.lib.standard._String_cl("unlock"));
    
// 226
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (x, string$6);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (x, string$6);
    }
// 227
    try {
// 228
      JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_cl) (new JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_cl ())._new_init ();
// 229
      JP.go.ipa.oz.lib.standard._String_if rg = null;
// 230
      /* for loop starting here */ {
        /* initialization part */
        int i = 0;
        
        for (;;) {
          /* boolean expression part */
          if (!(i < lx)) break;
          
          /* body */ _loop_1: {
// 231
            JP.go.ipa.oz.lang._Root_if at$val$10;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lockingResources)) {
              try {
                at$val$10 = lockingResources.at (i);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              at$val$10 = lockingResources.at (i);
            }
// 231
            rg = (JP.go.ipa.oz.lib.standard._String_if) (at$val$10);
// 232
            JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if r = getResource (rg, timeOut);
// 233
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
              try {
                r.unlock (tid);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              r.unlock (tid);
            }
          }
          /* iteration part */
// 230
          i++;
        }
      }
// 235
      lx = 0;
// 236
      JP.go.ipa.oz.lib.standard._String_if string$7 = (new JP.go.ipa.oz.lib.standard._String_cl("unlocked"));
      
// 236
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, string$7);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, string$7);
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_1) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
      if (_oz_exception_1 instanceof JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) {
        JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) _oz_exception_1;
// 238
        JP.go.ipa.oz.lib.standard._String_if string$8 = (new JP.go.ipa.oz.lib.standard._String_cl("unlock time out"));
        
// 238
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (x, string$8);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (x, string$8);
        }
      } else throw _exception_1;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 240
      JP.go.ipa.oz.lib.standard._String_if string$9 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 240
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$9);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$9);
      }
    }
  }
  
  public final void commit () throws Exception  {
    checkSecureInvocation ();
// 278
    try {
// 279
      commitBody ();
// 280
      unlock ();
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_2) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_2 = _exception_2.getOzException ();
      if (_oz_exception_2 instanceof JP.go.ipa.oz.user.lib_dist.tran._TransactionAbortException_if) {
        JP.go.ipa.oz.user.lib_dist.tran._TransactionAbortException_if e = (JP.go.ipa.oz.user.lib_dist.tran._TransactionAbortException_if) _oz_exception_2;
// 281
        JP.go.ipa.oz.lib.standard._String_if string$10 = (new JP.go.ipa.oz.lib.standard._String_cl("transaction aborted"));
        
// 281
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (x, string$10);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (x, string$10);
        }
      } else throw _exception_2;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 282
      JP.go.ipa.oz.lib.standard._String_if string$11 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 282
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$11);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$11);
      }
    }
  }
  
  protected void initialize (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
// 31
    lx = 0;
// 31
    bx = 0;
// 32
    tid = (JP.go.ipa.oz.user.lib_dist.tran._TID_cl) (new JP.go.ipa.oz.user.lib_dist.tran._TID_cl ())._new_create ();
// 32
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tid)) {
      try {
        tid.set (0, gol);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      tid.set (0, gol);
    }
// 33
    ScanTime = 100;
// 34
    timeOut = 5000;
// 35
    maxID = 1000;
// 36
    maxLockingResource = 100;
// 37
    maxBlockingResource = 100;
// 38
    lockingResources = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (maxLockingResource);
// 39
    blockingResources = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (maxBlockingResource);
  }
  
  final void commitBody () throws Exception  {
// 285
    JP.go.ipa.oz.lib.standard._String_if string$12 = (new JP.go.ipa.oz.lib.standard._String_cl("commitBody"));
    
// 285
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (x, string$12);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (x, string$12);
    }
// 286
    try {
// 287
      JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if r = null;
// 288
      JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_cl) (new JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_cl ())._new_init ();
// 289
      JP.go.ipa.oz.lib.standard._String_if string$13 = (new JP.go.ipa.oz.lib.standard._String_cl("preCommit"));
      
// 289
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, string$13);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, string$13);
      }
// 290
      JP.go.ipa.oz.lib.standard._String_if rg = null;
// 292
      /* for loop starting here */ {
        /* initialization part */
        int i = 0;
        
        for (;;) {
          /* boolean expression part */
          if (!(i < lx)) break;
          
          /* body */ _loop_1: {
// 293
            JP.go.ipa.oz.lang._Root_if at$val$11;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lockingResources)) {
              try {
                at$val$11 = lockingResources.at (i);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              at$val$11 = lockingResources.at (i);
            }
// 293
            rg = (JP.go.ipa.oz.lib.standard._String_if) (at$val$11);
// 294
            r = getResource (rg, timeOut);
// 295
            boolean isReadyToCommit$val$12;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
              try {
                isReadyToCommit$val$12 = r.isReadyToCommit (tid);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              isReadyToCommit$val$12 = r.isReadyToCommit (tid);
            }
// 295
            if (!isReadyToCommit$val$12) {
// 295
              return;
            }
          }
          /* iteration part */
// 292
          i++;
        }
      }
// 298
      JP.go.ipa.oz.lib.standard._String_if string$14 = (new JP.go.ipa.oz.lib.standard._String_cl("commit"));
      
// 298
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, string$14);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, string$14);
      }
// 299
      /* for loop starting here */ {
        /* initialization part */
        int i = 0;
        
        for (;;) {
          /* boolean expression part */
          if (!(i < lx)) break;
          
          /* body */ _loop_1: {
// 300
            JP.go.ipa.oz.lang._Root_if at$val$13;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lockingResources)) {
              try {
                at$val$13 = lockingResources.at (i);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              at$val$13 = lockingResources.at (i);
            }
// 300
            rg = (JP.go.ipa.oz.lib.standard._String_if) (at$val$13);
// 301
            r = getResource (rg, timeOut);
// 302
            boolean commit$val$14;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
              try {
                commit$val$14 = r.commit (tid);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              commit$val$14 = r.commit (tid);
            }
// 302
            if (!commit$val$14) {
// 302
              return;
            }
          }
          /* iteration part */
// 299
          i++;
        }
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_3) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_3 = _exception_3.getOzException ();
      if (_oz_exception_3 instanceof JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) {
        JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) _oz_exception_3;
// 305
        JP.go.ipa.oz.lib.standard._String_if string$15 = (new JP.go.ipa.oz.lib.standard._String_cl("Commit fault"));
        
// 305
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (1, string$15);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (1, string$15);
        }
// 306
        abortTran ();
      } else throw _exception_3;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 308
      JP.go.ipa.oz.lib.standard._String_if string$16 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 308
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$16);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$16);
      }
// 308
      abortTran ();
    }
  }
  
  protected final void sharedLock (JP.go.ipa.oz.lib.standard._Array_if res, int time) throws Exception  {
// 107
    lockHead (res, 1, time);
  }
  
  protected final void sharedLock (JP.go.ipa.oz.lib.standard._Array_if res) throws Exception  {
// 104
    lockHead (res, 1, timeOut);
  }
  
  public final void lockHead (JP.go.ipa.oz.lib.standard._Array_if res, int lockMode, int time) throws Exception  {
    checkSecureInvocation ();
// 111
    int lockRetryTimes = 0;
// 112
    try {
// 113
      lockBody (res, lockMode, time);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_4) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_4 = _exception_4.getOzException ();
      if (_oz_exception_4 instanceof JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) {
        JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) _oz_exception_4;
// 115
        JP.go.ipa.oz.lib.standard._String_if string$17 = (new JP.go.ipa.oz.lib.standard._String_cl("lockBody:timeOut"));
        
// 115
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (x, string$17);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (x, string$17);
        }
// 116
        if (checkDeadLock ()) {{
// 117
            JP.go.ipa.oz.lib.standard._String_if string$18 = (new JP.go.ipa.oz.lib.standard._String_cl("CheckDeadLock:DeadLock found,transation aborted"));
            
// 117
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
              try {
                d.write (x, string$18);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              d.write (x, string$18);
            }
// 118
            abortTran ();
          }
        } else {
// 119
          lockRetry (lockRetryTimes, res, lockMode, time);
        }
      } else if (_oz_exception_4 instanceof JP.go.ipa.oz.user.lib_dist.tran._TransactionAbortException_if) {
        JP.go.ipa.oz.user.lib_dist.tran._TransactionAbortException_if e = (JP.go.ipa.oz.user.lib_dist.tran._TransactionAbortException_if) _oz_exception_4;
// 122
        JP.go.ipa.oz.lib.standard._String_if string$19 = (new JP.go.ipa.oz.lib.standard._String_cl("transaction aborted"));
        
// 122
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (x, string$19);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (x, string$19);
        }
// 122
        abortTran ();
      } else throw _exception_4;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 123
      JP.go.ipa.oz.lib.standard._String_if string$20 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 123
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$20);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$20);
      }
    }
  }
  
  final void abortTran () throws Exception  {
// 255
    JP.go.ipa.oz.lib.standard._String_if string$21 = (new JP.go.ipa.oz.lib.standard._String_cl("abort"));
    
// 255
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (x, string$21);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (x, string$21);
    }
// 256
    try {
// 257
      JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if r = null;
// 259
      JP.go.ipa.oz.lib.standard._String_if rg = null;
// 260
      /* for loop starting here */ {
        /* initialization part */
        int i = 0;
        
        for (;;) {
          /* boolean expression part */
          if (!(i < lx)) break;
          
          /* body */ _loop_1: {
// 261
            JP.go.ipa.oz.lang._Root_if at$val$15;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lockingResources)) {
              try {
                at$val$15 = lockingResources.at (i);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              at$val$15 = lockingResources.at (i);
            }
// 261
            rg = (JP.go.ipa.oz.lib.standard._String_if) (at$val$15);
// 262
            r = getResource (rg, timeOut);
// 263
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
              try {
                r.rollback (tid);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              r.rollback (tid);
            }
          }
          /* iteration part */
// 260
          i++;
        }
      }
// 265
      /* for loop starting here */ {
        /* initialization part */
        int i = 0;
        
        for (;;) {
          /* boolean expression part */
          if (!(i < lx)) break;
          
          /* body */ _loop_1: {
// 266
            JP.go.ipa.oz.lang._Root_if at$val$16;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lockingResources)) {
              try {
                at$val$16 = lockingResources.at (i);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              at$val$16 = lockingResources.at (i);
            }
// 266
            rg = (JP.go.ipa.oz.lib.standard._String_if) (at$val$16);
// 267
            r = getResource (rg, timeOut);
// 268
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
              try {
                r.unlock (tid);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              r.unlock (tid);
            }
          }
          /* iteration part */
// 265
          i++;
        }
      }
// 270
      JP.go.ipa.oz.lib.standard._String_if string$22 = (new JP.go.ipa.oz.lib.standard._String_cl("Transaction Aborted"));
      
// 270
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, string$22);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, string$22);
      }
// 271
      JP.go.ipa.oz.user.lib_dist.tran._TransactionAbortException_if e = (JP.go.ipa.oz.user.lib_dist.tran._TransactionAbortException_cl) (new JP.go.ipa.oz.user.lib_dist.tran._TransactionAbortException_cl ())._new_init ();
// 271
      throw new JP.go.ipa.oz.lang.OzException (e);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_5) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_5 = _exception_5.getOzException ();
      if (_oz_exception_5 instanceof JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) {
        JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) _oz_exception_5;
// 273
        JP.go.ipa.oz.lib.standard._String_if string$23 = (new JP.go.ipa.oz.lib.standard._String_cl("TimeOut befor abort"));
        
// 273
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (x, string$23);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (x, string$23);
        }
      } else throw _exception_5;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 275
      JP.go.ipa.oz.lib.standard._String_if string$24 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 275
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$24);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$24);
      }
    }
  }
  
  public final void abortTran (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
    checkSecureInvocation ();
// 245
    JP.go.ipa.oz.lib.standard._String_if string$25 = (new JP.go.ipa.oz.lib.standard._String_cl(" abort by resource:"));
    
// 245
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (x, string$25);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (x, string$25);
    }
// 246
    try {
// 247
      int i = 0;
// 247
      int indexOf$val$17;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lockingResources)) {
        try {
          indexOf$val$17 = lockingResources.indexOf (gol);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        indexOf$val$17 = lockingResources.indexOf (gol);
      }
// 247
      i = indexOf$val$17;
// 248
      if (i == -1) {{
// 249
          JP.go.ipa.oz.lib.standard._String_if string$26 = (new JP.go.ipa.oz.lib.standard._String_cl("Transaction Aborted"));
          
// 249
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (x, string$26);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (x, string$26);
          }
// 250
          JP.go.ipa.oz.user.lib_dist.tran._TransactionAbortException_if e = (JP.go.ipa.oz.user.lib_dist.tran._TransactionAbortException_cl) (new JP.go.ipa.oz.user.lib_dist.tran._TransactionAbortException_cl ())._new_init ();
// 250
          throw new JP.go.ipa.oz.lang.OzException (e);
        }
      } else {
// 251
        JP.go.ipa.oz.lib.standard._String_if string$27 = (new JP.go.ipa.oz.lib.standard._String_cl("Ignore invalid abort from resource."));
        
// 251
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (x, string$27);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (x, string$27);
        }
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 252
      JP.go.ipa.oz.lib.standard._String_if string$28 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 252
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$28);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$28);
      }
    }
  }
  
  public final void setLockingResource (JP.go.ipa.oz.lib.standard._String_if rg) throws Exception  {
    checkSecureInvocation ();
// 161
    try {
// 162
      JP.go.ipa.oz.lib.standard._String_if string$29 = (new JP.go.ipa.oz.lib.standard._String_cl("setLockingTransaction: called by "));
      
// 162
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, string$29, rg);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, string$29, rg);
      }
// 163
      JP.go.ipa.oz.lib.standard._Array_if putAt$val$18;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lockingResources)) {
        try {
          putAt$val$18 = lockingResources.putAt (lx++, rg);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        putAt$val$18 = lockingResources.putAt (lx++, rg);
      }
// 164
      JP.go.ipa.oz.lib.standard._Collection_if remove$val$19;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) blockingResources)) {
        try {
          remove$val$19 = blockingResources.remove (rg);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        remove$val$19 = blockingResources.remove (rg);
      }
// 164
      blockingResources = (JP.go.ipa.oz.lib.standard._Array_if) (remove$val$19);
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 165
      JP.go.ipa.oz.lib.standard._String_if string$30 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 165
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$30);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$30);
      }
    }
  }
  
  public final JP.go.ipa.oz.lib.standard._Array_if getBlockingResources () throws Exception  {
    checkSecureInvocation ();
// 58
    return blockingResources;
  }
  
  public final void setResourceTimeOut (int time) throws Exception  {
    checkSecureInvocation ();
// 48
    timeOut = time;
  }
  
  final void lockRetry (int lockRetryTimes, JP.go.ipa.oz.lib.standard._Array_if res, int lockMode, int time) throws Exception  {
// 169
    try {
// 170
      JP.go.ipa.oz.user.lib_dist.tran._LockRetryOverTimesException_if e = (JP.go.ipa.oz.user.lib_dist.tran._LockRetryOverTimesException_cl) (new JP.go.ipa.oz.user.lib_dist.tran._LockRetryOverTimesException_cl ())._new_init ();
// 171
      if (lockRetryTimes++ < maxLockRetry) {
// 172
        lockBody (res, lockMode, time);
      } else {{
// 174
          JP.go.ipa.oz.lib.standard._String_if string$31 = (new JP.go.ipa.oz.lib.standard._String_cl("LockRetryOverTimesException"));
          
// 174
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (x, string$31);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (x, string$31);
          }
// 175
          abortTran ();
        }
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_6) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_6 = _exception_6.getOzException ();
      if (_oz_exception_6 instanceof JP.go.ipa.oz.user.lib_dist.tran._LockRetryOverTimesException_if) {
        JP.go.ipa.oz.user.lib_dist.tran._LockRetryOverTimesException_if e = (JP.go.ipa.oz.user.lib_dist.tran._LockRetryOverTimesException_if) _oz_exception_6;
// 178
        JP.go.ipa.oz.lib.standard._String_if string$32 = (new JP.go.ipa.oz.lib.standard._String_cl("LockRetryOverTimesException"));
        
// 178
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (x, string$32);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (x, string$32);
        }
// 179
        abortTran ();
      } else throw _exception_6;
    }
  }
  
  protected void quiet () throws Exception  {
// 43
    flushCell ();
  }
  
  protected final void begin (int time) throws Exception  {
// 68
    timeOut = time;
// 68
    createID ();
  }
  
  protected final void begin () throws Exception  {
// 67
    createID ();
  }
  
  protected final int getMaxLockRetry () throws Exception  {
// 55
    return maxLockRetry;
  }
  
  public final boolean isLock () throws Exception  {
    checkSecureInvocation ();
// 158
    if (size == lx) {
// 158
      return true;
    } else {
// 158
      return false;
    }
  }
  
  protected final int getResourceTimeOut () throws Exception  {
// 50
    return timeOut;
  }
  
  final void lockBody (JP.go.ipa.oz.lib.standard._Array_if res, int lockMode, int time) throws Exception  {
// 127
    JP.go.ipa.oz.lib.standard._String_if string$33 = (new JP.go.ipa.oz.lib.standard._String_cl("lockBody lx="));
    
// 127
    int size$val$20;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        size$val$20 = res.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$20 = res.size ();
    }
// 127
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (x, string$33, lx, size$val$20);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (x, string$33, lx, size$val$20);
    }
// 128
    try {
// 129
      JP.go.ipa.oz.lib.standard._String_if rg = null;
// 130
      JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if r = null;
// 131
      int j = 0;
// 131
      int size$val$21;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
        try {
          size$val$21 = res.size ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        size$val$21 = res.size ();
      }
// 131
      size = size$val$21;
// 132
      /* for loop starting here */ {
        /* initialization part */
        int i = 0;
        
        for (;;) {
          /* boolean expression part */
          if (!(i < size)) break;
          
          /* body */ _loop_1: {
// 133
            JP.go.ipa.oz.lang._Root_if at$val$22;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
              try {
                at$val$22 = res.at (i);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              at$val$22 = res.at (i);
            }
// 133
            rg = (JP.go.ipa.oz.lib.standard._String_if) (at$val$22);
// 134
            JP.go.ipa.oz.lib.standard._String_if string$34 = (new JP.go.ipa.oz.lib.standard._String_cl("lock bind:"));
            
// 134
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
              try {
                d.write (x, string$34, rg);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              d.write (x, string$34, rg);
            }
// 135
            r = getResource (rg, time);
// 136
            JP.go.ipa.oz.lib.standard._String_if string$35 = (new JP.go.ipa.oz.lib.standard._String_cl("lockMode="));
            
// 136
            int getLockMode$val$23;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
              try {
                getLockMode$val$23 = r.getLockMode ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getLockMode$val$23 = r.getLockMode ();
            }
// 136
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
              try {
                d.write (x, string$35, getLockMode$val$23);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              d.write (x, string$35, getLockMode$val$23);
            }
// 137
            if (lockMode == 2) {
// 138
              int lock$val$24;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
                try {
                  lock$val$24 = r.lock (tid);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                lock$val$24 = r.lock (tid);
              }
// 138
              j = lock$val$24;
            } else {
// 140
              int sharedLock$val$25;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
                try {
                  sharedLock$val$25 = r.sharedLock (tid);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                sharedLock$val$25 = r.sharedLock (tid);
              }
// 140
              j = sharedLock$val$25;
            }
// 141
            JP.go.ipa.oz.lib.standard._String_if string$36 = (new JP.go.ipa.oz.lib.standard._String_cl("(shared)locked="));
            
// 141
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
              try {
                d.write (x, string$36, j);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              d.write (x, string$36, j);
            }
// 142
            if (j == 1) {{
// 143
                JP.go.ipa.oz.lib.standard._Array_if putAt$val$26;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lockingResources)) {
                  try {
                    putAt$val$26 = lockingResources.putAt (lx++, rg);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  putAt$val$26 = lockingResources.putAt (lx++, rg);
                }
              }
            } else {
// 144
              if (j == 2) {{
// 145
                  JP.go.ipa.oz.lib.standard._Array_if putAt$val$27;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) blockingResources)) {
                    try {
                      putAt$val$27 = blockingResources.putAt (bx++, rg);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    putAt$val$27 = blockingResources.putAt (bx++, rg);
                  }
                }
              }
            }
          }
          /* iteration part */
// 132
          i++;
        }
      }
// 154
      JP.go.ipa.oz.lib.standard._String_if string$37 = (new JP.go.ipa.oz.lib.standard._String_cl("lx2="));
      
// 154
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, string$37, lx);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, string$37, lx);
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 155
      JP.go.ipa.oz.lib.standard._String_if string$38 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 155
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, string$38);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, string$38);
      }
    }
  }
  
  public final int getLx () throws Exception  {
    checkSecureInvocation ();
// 46
    return lx;
  }
  
  protected final JP.go.ipa.oz.user.lib_dist.tran._TID_if getTID () throws Exception  {
// 61
    return tid;
  }
  
  public final int getMaxBlockingResource () throws Exception  {
    checkSecureInvocation ();
// 64
    return maxBlockingResource;
  }
  
  public JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if getResource (JP.go.ipa.oz.lib.standard._String_if rg) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 85
      JP.go.ipa.oz.system.OzCondition c = new JP.go.ipa.oz.system.OzCondition (this);
// 85
      wait (c, 1000);
// 86
      try {
// 87
        JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if r = new JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_pcl (rg);
// 87
        JP.go.ipa.oz.lib.standard._String_if string$39 = (new JP.go.ipa.oz.lib.standard._String_cl("bound"));
        
// 87
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (x, string$39);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (x, string$39);
        }
// 88
        return r;
      }
      catch (JP.go.ipa.oz.system.ExException _exception_e) {
        JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
        
// 89
        JP.go.ipa.oz.lib.standard._String_if string$40 = (new JP.go.ipa.oz.lib.standard._String_cl("exception"));
        
// 89
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (x, string$40);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (x, string$40);
        }
// 89
        return null;
      }
    } finally {
      leave ();
    }
  }
  
  public JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if getResource (JP.go.ipa.oz.lib.standard._String_if rg, int time) throws Exception  {
    checkSecureInvocation ();
// 79
    JP.go.ipa.oz.lib.standard._String_if string$41 = (new JP.go.ipa.oz.lib.standard._String_cl("time="));
    
// 79
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (x, string$41, time);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (x, string$41, time);
    }
// 80
    JP.go.ipa.oz.user.lib_dist.tran._TranTimer_if t = (JP.go.ipa.oz.user.lib_dist.tran._TranTimer_cl) (new JP.go.ipa.oz.user.lib_dist.tran._TranTimer_cl ())._new_create ();
// 80
    JP.go.ipa.oz.user.lib_dist.tran._TranRun_if l = (JP.go.ipa.oz.user.lib_dist.tran._TranRun_cl) (new JP.go.ipa.oz.user.lib_dist.tran._TranRun_cl ())._new_create (t);
// 81
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) l)) {
      try {
        l.set (this, rg);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      l.set (this, rg);
    }
// 82
    JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if invoke$val$28;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
      try {
        invoke$val$28 = t.invoke (l, time);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      invoke$val$28 = t.invoke (l, time);
    }
// 82
    return invoke$val$28;
  }
  
  protected void go () throws Exception  {
  }
  
  protected final void lock (JP.go.ipa.oz.lib.standard._Array_if res, int time) throws Exception  {
// 97
    lockHead (res, 2, time);
  }
  
  public final void lock (JP.go.ipa.oz.lib.standard._Array_if res) throws Exception  {
    checkSecureInvocation ();
// 94
    lockHead (res, 2, timeOut);
  }
  
  final void createID () throws Exception  {
// 70
    try {
// 71
      int i = 0;
// 71
      int getID$val$29;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tid)) {
        try {
          getID$val$29 = tid.getID ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getID$val$29 = tid.getID ();
      }
// 71
      i = getID$val$29;
// 72
      if (i > maxID) {
// 72
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tid)) {
          try {
            tid.setID (1);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          tid.setID (1);
        }
      } else {{
// 73
          i = i + 1;
// 73
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tid)) {
            try {
              tid.setID (i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            tid.setID (i);
          }
        }
      }
// 74
      JP.go.ipa.oz.lib.standard._String_if string$42 = (new JP.go.ipa.oz.lib.standard._String_cl("Begin:"));
      
// 74
      JP.go.ipa.oz.lib.standard._String_if getTidGOL$val$30;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tid)) {
        try {
          getTidGOL$val$30 = tid.getTidGOL ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getTidGOL$val$30 = tid.getTidGOL ();
      }
// 74
      int getID$val$31;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tid)) {
        try {
          getID$val$31 = tid.getID ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getID$val$31 = tid.getID ();
      }
// 74
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, string$42, getTidGOL$val$30, getID$val$31);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, string$42, getTidGOL$val$30, getID$val$31);
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 75
      JP.go.ipa.oz.lib.standard._String_if string$43 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 75
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$43);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$43);
      }
    }
  }
  
  public _Transaction_cl () { super ("JP.go.ipa.oz.user.lib_dist.tran._Transaction_pcl"); }
  
  public _Transaction_cl (String proxy_id) { super (proxy_id); }
  
}


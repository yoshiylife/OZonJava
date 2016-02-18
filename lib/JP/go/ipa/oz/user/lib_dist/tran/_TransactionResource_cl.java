package JP.go.ipa.oz.user.lib_dist.tran;

public class _TransactionResource_cl extends JP.go.ipa.oz.system.OzCell implements JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if {
  static final boolean _global_ = true;
  protected JP.go.ipa.oz.user.lib_dist.tran._Debug_if d;
  protected int x;
  JP.go.ipa.oz.lib.standard._String_if rf;
  int MaxLockingTransaction;
  JP.go.ipa.oz.lib.standard._String_if r2f;
  int init;
  JP.go.ipa.oz.lib.standard._String_if sf;
  protected JP.go.ipa.oz.user.lib_dist.tran._Resource_if r;
  JP.go.ipa.oz.lib.standard._String_if gol;
  protected JP.go.ipa.oz.user.lib_dist.tran._Resource_if r2;
  int MaxBlockingTransaction;
  int ScanTime;
  protected JP.go.ipa.oz.user.lib_dist.tran._Status_if st;
  int j;
  
  protected void userRecover (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception  {
// 375
    rollbackForRecover (t);
// 375
    JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl("self rollbacked"));
    
// 375
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (1, string$0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (1, string$0);
    }
// 377
    try {
// 378
      JP.go.ipa.oz.user.lib_dist.tran._OverTimeException_if e = (JP.go.ipa.oz.user.lib_dist.tran._OverTimeException_cl) (new JP.go.ipa.oz.user.lib_dist.tran._OverTimeException_cl ())._new_init ();
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_1) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
      if (_oz_exception_1 instanceof JP.go.ipa.oz.user.lib_dist.tran._OverTimeException_if) {
        JP.go.ipa.oz.user.lib_dist.tran._OverTimeException_if e = (JP.go.ipa.oz.user.lib_dist.tran._OverTimeException_if) _oz_exception_1;
// 382
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
          try {
            st.init ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          st.init ();
        }
      } else throw _exception_1;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 384
      JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 384
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$1);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$1);
      }
    }
  }
  
  public final void unlock (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception  {
    checkSecureInvocation ();
// 252
    JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl("unlock:"));
    
// 252
    JP.go.ipa.oz.lib.standard._String_if getTidGOL$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
      try {
        getTidGOL$val$0 = t.getTidGOL ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getTidGOL$val$0 = t.getTidGOL ();
    }
// 252
    int getID$val$1;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
      try {
        getID$val$1 = t.getID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getID$val$1 = t.getID ();
    }
// 252
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (x, string$2, getTidGOL$val$0, getID$val$1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (x, string$2, getTidGOL$val$0, getID$val$1);
    }
// 253
    try {
// 254
      boolean isInLockingTransaction$val$2;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
        try {
          isInLockingTransaction$val$2 = st.isInLockingTransaction (t);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isInLockingTransaction$val$2 = st.isInLockingTransaction (t);
      }
// 254
      if (isInLockingTransaction$val$2) {{
// 255
          JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_cl) (new JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_cl ())._new_init ();
// 256
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
            try {
              st.unlock (t);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            st.unlock (t);
          }
// 257
          saveStatus (st, sf);
        }
      } else {
// 260
        JP.go.ipa.oz.lib.standard._String_if string$3 = (new JP.go.ipa.oz.lib.standard._String_cl("Invalid transaction,cannot unlock."));
        
// 260
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (1, string$3);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (1, string$3);
        }
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_2) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_2 = _exception_2.getOzException ();
      if (_oz_exception_2 instanceof JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) {
        JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) _oz_exception_2;
// 262
        JP.go.ipa.oz.lib.standard._String_if string$4 = (new JP.go.ipa.oz.lib.standard._String_cl("unlock fault"));
        
// 262
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (1, string$4);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (1, string$4);
        }
      } else throw _exception_2;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 264
      JP.go.ipa.oz.lib.standard._String_if string$5 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 264
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$5);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$5);
      }
    }
  }
  
  protected void createResource (JP.go.ipa.oz.lang._Root_if userResource) throws Exception  {
// 68
    r = (JP.go.ipa.oz.user.lib_dist.tran._Resource_cl) (new JP.go.ipa.oz.user.lib_dist.tran._Resource_cl ())._new_create (userResource);
  }
  
  public final boolean commit (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception  {
    checkSecureInvocation ();
// 293
    JP.go.ipa.oz.lib.standard._String_if string$6 = (new JP.go.ipa.oz.lib.standard._String_cl("commit:"));
    
// 293
    JP.go.ipa.oz.lib.standard._String_if getTidGOL$val$3;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
      try {
        getTidGOL$val$3 = t.getTidGOL ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getTidGOL$val$3 = t.getTidGOL ();
    }
// 293
    int getID$val$4;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
      try {
        getID$val$4 = t.getID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getID$val$4 = t.getID ();
    }
// 293
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (x, string$6, getTidGOL$val$3, getID$val$4);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (x, string$6, getTidGOL$val$3, getID$val$4);
    }
// 294
    try {
// 295
      JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_cl) (new JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_cl ())._new_init ();
// 296
      JP.go.ipa.oz.user.lib_dist.tran._CommitUnlockedResourceException_if e1 = (JP.go.ipa.oz.user.lib_dist.tran._CommitUnlockedResourceException_cl) (new JP.go.ipa.oz.user.lib_dist.tran._CommitUnlockedResourceException_cl ())._new_init ();
// 297
      JP.go.ipa.oz.user.lib_dist.tran._CommitBeforePreCommitException_if e2 = (JP.go.ipa.oz.user.lib_dist.tran._CommitBeforePreCommitException_cl) (new JP.go.ipa.oz.user.lib_dist.tran._CommitBeforePreCommitException_cl ())._new_init ();
// 298
      int getLockMode$val$5;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
        try {
          getLockMode$val$5 = st.getLockMode ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getLockMode$val$5 = st.getLockMode ();
      }
// 298
      if (getLockMode$val$5 == 0) {{
// 299
          JP.go.ipa.oz.lib.standard._String_if string$7 = (new JP.go.ipa.oz.lib.standard._String_cl("cannot commit unlocked resource."));
          
// 299
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (1, string$7);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (1, string$7);
          }
// 300
          return false;
        }
      } else {
// 302
        int getCommit$val$6;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
          try {
            getCommit$val$6 = st.getCommit ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getCommit$val$6 = st.getCommit ();
        }
// 302
        if (getCommit$val$6 != 1) {{
// 303
            JP.go.ipa.oz.lib.standard._String_if string$8 = (new JP.go.ipa.oz.lib.standard._String_cl("cannot commit before pre-commit."));
            
// 303
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
              try {
                d.write (1, string$8);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              d.write (1, string$8);
            }
// 304
            return false;
          }
        } else {{
// 307
            boolean isInLockingTransaction$val$7;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
              try {
                isInLockingTransaction$val$7 = st.isInLockingTransaction (t);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              isInLockingTransaction$val$7 = st.isInLockingTransaction (t);
            }
// 307
            if (isInLockingTransaction$val$7) {{
// 308
                JP.go.ipa.oz.lib.standard._String_if string$9 = (new JP.go.ipa.oz.lib.standard._String_cl("commited"));
                
// 308
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                  try {
                    d.write (x, string$9);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  d.write (x, string$9);
                }
// 309
                saveStatus (st, sf);
// 310
                return true;
              }
            } else {{
// 313
                JP.go.ipa.oz.lib.standard._String_if string$10 = (new JP.go.ipa.oz.lib.standard._String_cl("cannot commit unlocked resource."));
                
// 313
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                  try {
                    d.write (1, string$10);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  d.write (1, string$10);
                }
// 314
                return false;
              }
            }
          }
        }
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_3) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_3 = _exception_3.getOzException ();
      if (_oz_exception_3 instanceof JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) {
        JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) _oz_exception_3;
// 318
        userRecover (t);
// 319
        return false;
      } else if (_oz_exception_3 instanceof JP.go.ipa.oz.user.lib_dist.tran._CommitUnlockedResourceException_if) {
        JP.go.ipa.oz.user.lib_dist.tran._CommitUnlockedResourceException_if e1 = (JP.go.ipa.oz.user.lib_dist.tran._CommitUnlockedResourceException_if) _oz_exception_3;
// 322
        d.write (1, (new JP.go.ipa.oz.lib.standard._String_cl("cannot commit unlocked resource.")));
// 323
        return false;
      } else if (_oz_exception_3 instanceof JP.go.ipa.oz.user.lib_dist.tran._CommitBeforePreCommitException_if) {
        JP.go.ipa.oz.user.lib_dist.tran._CommitBeforePreCommitException_if e2 = (JP.go.ipa.oz.user.lib_dist.tran._CommitBeforePreCommitException_if) _oz_exception_3;
// 326
        d.write (1, (new JP.go.ipa.oz.lib.standard._String_cl("cannot commit before pre-commit.")));
// 327
        return false;
      } else throw _exception_3;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 329
      d.write (1, (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured")));
// 329
      return false;
    }
  }
  
  final void recover () throws Exception  {
// 33
    JP.go.ipa.oz.lib.standard._String_if string$11 = (new JP.go.ipa.oz.lib.standard._String_cl("check status file:"));
    
// 33
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (x, string$11, sf);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (x, string$11, sf);
    }
// 34
    try {
// 35
      st = loadStatus (sf);
// 36
      JP.go.ipa.oz.lib.standard._String_if string$12 = (new JP.go.ipa.oz.lib.standard._String_cl("status loaded"));
      
// 36
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, string$12);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, string$12);
      }
// 37
      if (st == null) {{
// 38
          init ();
        }
      } else {{
// 41
          r = loadResource (rf);
// 41
          if (r == null) {
// 41
            init ();
          }
// 42
          int i = 0;
// 42
          int getLockMode$val$8;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
            try {
              getLockMode$val$8 = st.getLockMode ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getLockMode$val$8 = st.getLockMode ();
          }
// 42
          i = getLockMode$val$8;
// 43
          JP.go.ipa.oz.lib.standard._String_if string$13 = (new JP.go.ipa.oz.lib.standard._String_cl("Resource loaded,LockMode="));
          
// 43
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (x, string$13, i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (x, string$13, i);
          }
// 44
          if (i > 0) {{
// 47
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
                try {
                  st.setWaitUnlock (1);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                st.setWaitUnlock (1);
              }
// 47
              rollbackFromFile ();
// 48
              JP.go.ipa.oz.lib.standard._String_if string$14 = (new JP.go.ipa.oz.lib.standard._String_cl("Transaction didn't complete,self-rollbacked."));
              
// 48
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                try {
                  d.write (1, string$14);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                d.write (1, string$14);
              }
            }
          } else {
// 51
            JP.go.ipa.oz.lib.standard._String_if string$15 = (new JP.go.ipa.oz.lib.standard._String_cl("Resource file is valid,needless to recover."));
            
// 51
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
              try {
                d.write (1, string$15);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              d.write (1, string$15);
            }
          }
        }
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 53
      JP.go.ipa.oz.lib.standard._String_if string$16 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 53
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$16);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$16);
      }
    }
  }
  
  protected final void initialize (JP.go.ipa.oz.lib.standard._String_if f0, JP.go.ipa.oz.lib.standard._String_if f1, JP.go.ipa.oz.lib.standard._String_if f2, JP.go.ipa.oz.lib.standard._String_if g) throws Exception  {
// 30
    gol = g;
// 30
    sf = f0;
// 30
    rf = f1;
// 30
    r2f = f2;
// 30
    recover ();
  }
  
  public final int sharedLock (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception  {
    checkSecureInvocation ();
// 216
    JP.go.ipa.oz.lib.standard._String_if string$17 = (new JP.go.ipa.oz.lib.standard._String_cl("sharedLock:"));
    
// 216
    JP.go.ipa.oz.lib.standard._String_if getTidGOL$val$9;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
      try {
        getTidGOL$val$9 = t.getTidGOL ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getTidGOL$val$9 = t.getTidGOL ();
    }
// 216
    int getID$val$10;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
      try {
        getID$val$10 = t.getID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getID$val$10 = t.getID ();
    }
// 216
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (x, string$17, getTidGOL$val$9, getID$val$10);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (x, string$17, getTidGOL$val$9, getID$val$10);
    }
// 217
    try {
// 218
      JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_cl) (new JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_cl ())._new_init ();
// 218
      checkLockingTime ();
// 219
      int getLockMode$val$11;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
        try {
          getLockMode$val$11 = st.getLockMode ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getLockMode$val$11 = st.getLockMode ();
      }
// 219
      if (getLockMode$val$11 == 0) {{
// 220
          r2 = r;
// 221
          int lockBody$val$12;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
            try {
              lockBody$val$12 = st.lockBody (t, 1);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            lockBody$val$12 = st.lockBody (t, 1);
          }
// 221
          return lockBody$val$12;
        }
      }
// 223
      boolean isInLockingTransaction$val$13;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
        try {
          isInLockingTransaction$val$13 = st.isInLockingTransaction (t);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isInLockingTransaction$val$13 = st.isInLockingTransaction (t);
      }
// 223
      if (isInLockingTransaction$val$13) {{
// 224
          saveStatus (st, sf);
// 225
          return 1;
        }
      } else {
// 226
        return block (t, 1);
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_4) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_4 = _exception_4.getOzException ();
      if (_oz_exception_4 instanceof JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) {
        JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) _oz_exception_4;
// 229
        JP.go.ipa.oz.lib.standard._String_if string$18 = (new JP.go.ipa.oz.lib.standard._String_cl("sharedLock timeout."));
        
// 229
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (1, string$18);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (1, string$18);
        }
// 230
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
          try {
            st.init ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          st.init ();
        }
// 231
        return 0;
      } else throw _exception_4;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 233
      d.write (1, (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured")));
// 233
      return 0;
    }
  }
  
  public final int block (JP.go.ipa.oz.user.lib_dist.tran._TID_if t, int lockMode) throws Exception  {
    checkSecureInvocation ();
// 236
    JP.go.ipa.oz.lib.standard._String_if string$19 = (new JP.go.ipa.oz.lib.standard._String_cl("block:"));
    
// 236
    JP.go.ipa.oz.lib.standard._String_if getTidGOL$val$14;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
      try {
        getTidGOL$val$14 = t.getTidGOL ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getTidGOL$val$14 = t.getTidGOL ();
    }
// 236
    int getID$val$15;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
      try {
        getID$val$15 = t.getID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getID$val$15 = t.getID ();
    }
// 236
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (x, string$19, getTidGOL$val$14, getID$val$15);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (x, string$19, getTidGOL$val$14, getID$val$15);
    }
// 237
    try {
// 238
      JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_cl) (new JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_cl ())._new_init ();
// 239
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
        try {
          t.setLockMode (lockMode);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        t.setLockMode (lockMode);
      }
// 240
      boolean setBlockingTransaction$val$16;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
        try {
          setBlockingTransaction$val$16 = st.setBlockingTransaction (t);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        setBlockingTransaction$val$16 = st.setBlockingTransaction (t);
      }
// 240
      if (setBlockingTransaction$val$16) {
// 241
        return 2;
      } else {{
// 243
          JP.go.ipa.oz.lib.standard._String_if string$20 = (new JP.go.ipa.oz.lib.standard._String_cl("cannot block:block over limit"));
          
// 243
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (1, string$20);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (1, string$20);
          }
// 244
          return 0;
        }
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_5) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_5 = _exception_5.getOzException ();
      if (_oz_exception_5 instanceof JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) {
        JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) _oz_exception_5;
// 248
        JP.go.ipa.oz.lib.standard._String_if string$21 = (new JP.go.ipa.oz.lib.standard._String_cl("block:time out"));
        
// 248
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (1, string$21);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (1, string$21);
        }
// 248
        return 0;
      } else throw _exception_5;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 249
      d.write (1, (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured")));
// 249
      return 0;
    }
  }
  
  public final void checkLockingTimeBody () throws Exception  {
    checkSecureInvocation ();
// 158
    try {
// 159
      JP.go.ipa.oz.system.OzCondition c = new JP.go.ipa.oz.system.OzCondition (this);
// 159
      int i = 0;
// 159
      int getLockMode$val$17;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
        try {
          getLockMode$val$17 = st.getLockMode ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getLockMode$val$17 = st.getLockMode ();
      }
// 159
      i = getLockMode$val$17;
// 160
      while (true) {
        if (!(i > 0)) break;
        
        /* body */ _loop_1: {
// 160
          wait (c, ScanTime);
// 160
          int getLockMode$val$18;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
            try {
              getLockMode$val$18 = st.getLockMode ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getLockMode$val$18 = st.getLockMode ();
          }
// 160
          i = getLockMode$val$18;
// 161
          JP.go.ipa.oz.lib.standard._String_if string$22 = (new JP.go.ipa.oz.lib.standard._String_cl("checkLockMode="));
          
// 161
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (x, string$22, i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (x, string$22, i);
          }
        }
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 163
      JP.go.ipa.oz.lib.standard._String_if string$23 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 163
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$23);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$23);
      }
    }
  }
  
  final void saveStatus (JP.go.ipa.oz.user.lib_dist.tran._Status_if res, JP.go.ipa.oz.lib.standard._String_if fileName) throws Exception  {
// 124
    try {
// 125
      JP.go.ipa.oz.lib.standard._FileOutputStream_if fs = null;
// 125
      fs = (JP.go.ipa.oz.lib.standard._FileOutputStream_cl) (new JP.go.ipa.oz.lib.standard._FileOutputStream_cl ())._new_breed (fileName);
// 126
      JP.go.ipa.oz.lib.standard._ObjectOutputStream_if os = null;
// 126
      os = (JP.go.ipa.oz.lib.standard._ObjectOutputStream_cl) (new JP.go.ipa.oz.lib.standard._ObjectOutputStream_cl ())._new_breed (fs);
// 127
      os.writeObject (res);
// 128
      os.flush ();
// 129
      fs.close ();
// 130
      JP.go.ipa.oz.lib.standard._String_if string$24 = (new JP.go.ipa.oz.lib.standard._String_cl("status saved to "));
      
// 130
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, string$24, fileName);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, string$24, fileName);
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 131
      JP.go.ipa.oz.lib.standard._String_if string$25 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 131
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$25);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$25);
      }
    }
  }
  
  protected final void setMaxBlockingTransaction (int n) throws Exception  {
// 77
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
      try {
        st.setMaxBlockingTransaction (n);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      st.setMaxBlockingTransaction (n);
    }
  }
  
  final void abortTran () throws Exception  {
// 358
    JP.go.ipa.oz.lib.standard._String_if string$26 = (new JP.go.ipa.oz.lib.standard._String_cl("abort:"));
    
// 358
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (x, string$26);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (x, string$26);
    }
// 359
    try {
// 360
      JP.go.ipa.oz.lib.standard._SList_if lt = null;
// 360
      JP.go.ipa.oz.user.lib_dist.tran._TID_if tid = null;
// 360
      JP.go.ipa.oz.lib.standard._String_if s = null;
// 360
      JP.go.ipa.oz.user.lib_dist.tran._Transaction_if t = null;
// 360
      int size = 0;
// 361
      while (true) {
        /* body */ _loop_1: {
// 362
          JP.go.ipa.oz.lib.standard._SList_if getLockingTransaction$val$19;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
            try {
              getLockingTransaction$val$19 = st.getLockingTransaction ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getLockingTransaction$val$19 = st.getLockingTransaction ();
          }
// 362
          lt = getLockingTransaction$val$19;
// 363
          int size$val$20;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lt)) {
            try {
              size$val$20 = lt.size ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            size$val$20 = lt.size ();
          }
// 363
          size = size$val$20;
// 363
          JP.go.ipa.oz.lib.standard._String_if string$27 = (new JP.go.ipa.oz.lib.standard._String_cl("size="));
          
// 363
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (x, string$27, size);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (x, string$27, size);
          }
// 364
          JP.go.ipa.oz.lang._Root_if first$val$21;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lt)) {
            try {
              first$val$21 = lt.first ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            first$val$21 = lt.first ();
          }
// 364
          tid = (JP.go.ipa.oz.user.lib_dist.tran._TID_if) (first$val$21);
// 365
          JP.go.ipa.oz.lib.standard._String_if getTidGOL$val$22;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tid)) {
            try {
              getTidGOL$val$22 = tid.getTidGOL ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getTidGOL$val$22 = tid.getTidGOL ();
          }
// 365
          s = getTidGOL$val$22;
// 365
          t = new JP.go.ipa.oz.user.lib_dist.tran._Transaction_pcl (s);
// 365
          JP.go.ipa.oz.lib.standard._String_if string$28 = (new JP.go.ipa.oz.lib.standard._String_cl("bind to "));
          
// 365
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (x, string$28, s);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (x, string$28, s);
          }
// 366
          t.abortTran (gol);
// 366
          JP.go.ipa.oz.lib.standard._String_if string$29 = (new JP.go.ipa.oz.lib.standard._String_cl("bind by "));
          
// 366
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (x, string$29, gol);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (x, string$29, gol);
          }
// 367
          JP.go.ipa.oz.lib.standard._SList_if popFront$val$23;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lt)) {
            try {
              popFront$val$23 = lt.popFront ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            popFront$val$23 = lt.popFront ();
          }
// 367
          lt = popFront$val$23;
// 368
          if (size == 0) {
// 368
            break;
          }
        }
      }
// 370
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
        try {
          st.init ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        st.init ();
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 371
      JP.go.ipa.oz.lib.standard._String_if string$30 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 371
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
  
  protected final int getMaxBlockingTransaction () throws Exception  {
// 80
    int getMaxBlockingTransaction$val$24;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
      try {
        getMaxBlockingTransaction$val$24 = st.getMaxBlockingTransaction ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getMaxBlockingTransaction$val$24 = st.getMaxBlockingTransaction ();
    }
// 80
    return getMaxBlockingTransaction$val$24;
  }
  
  final void rollbackFromFile () throws Exception  {
// 345
    try {
// 346
      int i = 0;
// 346
      int getCommit$val$25;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
        try {
          getCommit$val$25 = st.getCommit ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getCommit$val$25 = st.getCommit ();
      }
// 346
      i = getCommit$val$25;
// 347
      if (i > 0) {
// 347
        r = loadResource (r2f);
      } else {
// 348
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
          try {
            st.init0 ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          st.init0 ();
        }
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 350
      JP.go.ipa.oz.lib.standard._String_if string$31 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 350
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$31);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$31);
      }
    }
  }
  
  final void init () throws Exception  {
// 56
    try {
// 57
      MaxLockingTransaction = 5;
// 58
      MaxBlockingTransaction = 5;
// 59
      st = (JP.go.ipa.oz.user.lib_dist.tran._Status_cl) (new JP.go.ipa.oz.user.lib_dist.tran._Status_cl ())._new_create (MaxLockingTransaction, MaxBlockingTransaction, gol, x);
// 61
      ScanTime = 10;
// 61
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
        try {
          st.setLockingTimeLimit (100);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        st.setLockingTimeLimit (100);
      }
// 62
      saveStatus (st, sf);
// 63
      saveResource (r, rf);
// 64
      JP.go.ipa.oz.lib.standard._String_if string$32 = (new JP.go.ipa.oz.lib.standard._String_cl("There's no resource file to load,new resource created."));
      
// 64
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$32);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$32);
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 65
      JP.go.ipa.oz.lib.standard._String_if string$33 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 65
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$33);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$33);
      }
    }
  }
  
  protected JP.go.ipa.oz.user.lib_dist.tran._Resource_if loadResource (JP.go.ipa.oz.lib.standard._String_if fileName) throws Exception  {
// 108
    try {
// 109
      JP.go.ipa.oz.lib.standard._File_if f = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (fileName);
// 110
      boolean exists$val$26;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
        try {
          exists$val$26 = f.exists ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        exists$val$26 = f.exists ();
      }
// 110
      if (!exists$val$26) {{
// 110
          return null;
        }
      }
// 111
      JP.go.ipa.oz.lib.standard._FileInputStream_if fs = null;
// 111
      fs = (JP.go.ipa.oz.lib.standard._FileInputStream_cl) (new JP.go.ipa.oz.lib.standard._FileInputStream_cl ())._new_breed (fileName);
// 112
      JP.go.ipa.oz.lib.standard._ObjectInputStream_if os = null;
// 112
      os = (JP.go.ipa.oz.lib.standard._ObjectInputStream_cl) (new JP.go.ipa.oz.lib.standard._ObjectInputStream_cl ())._new_breed (fs);
// 113
      JP.go.ipa.oz.user.lib_dist.tran._Resource_if res = null;
// 114
      res = (JP.go.ipa.oz.user.lib_dist.tran._Resource_if) (os.readObject ());
// 115
      return res;
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_6) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_6 = _exception_6.getOzException ();
      if (_oz_exception_6 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
        JP.go.ipa.oz.lib.standard._IOException_if e = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_6;
// 116
        JP.go.ipa.oz.lib.standard._String_if string$34 = (new JP.go.ipa.oz.lib.standard._String_cl("IOException. cannot load."));
        
// 116
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (1, string$34);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (1, string$34);
        }
// 116
        return null;
      } else throw _exception_6;
    }
    catch (JP.go.ipa.oz.system.ExClassNotFoundException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 118
      d.write (1, (new JP.go.ipa.oz.lib.standard._String_cl("ClassNotFoundException. cannot load")));
// 119
      return null;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 121
      d.write (1, (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured")));
// 121
      return null;
    }
  }
  
  public final JP.go.ipa.oz.lib.standard._SList_if getLockingTransaction () throws Exception  {
    checkSecureInvocation ();
// 92
    JP.go.ipa.oz.lib.standard._SList_if getLockingTransaction$val$27;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
      try {
        getLockingTransaction$val$27 = st.getLockingTransaction ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getLockingTransaction$val$27 = st.getLockingTransaction ();
    }
// 92
    return getLockingTransaction$val$27;
  }
  
  protected final void setLockingTimeLimit (int time) throws Exception  {
// 83
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
      try {
        st.setLockingTimeLimit (time);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      st.setLockingTimeLimit (time);
    }
  }
  
  protected void quiet () throws Exception  {
// 73
    flushCell ();
  }
  
  public final int getLockMode () throws Exception  {
    checkSecureInvocation ();
// 88
    int getLockMode$val$28;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
      try {
        getLockMode$val$28 = st.getLockMode ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getLockMode$val$28 = st.getLockMode ();
    }
// 88
    return getLockMode$val$28;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if test () throws Exception  {
    checkSecureInvocation ();
// 94
    return (new JP.go.ipa.oz.lib.standard._String_cl("RESOURCE"));
  }
  
  protected void saveResource (JP.go.ipa.oz.user.lib_dist.tran._Resource_if res, JP.go.ipa.oz.lib.standard._String_if fileName) throws Exception  {
// 98
    try {
// 99
      JP.go.ipa.oz.lib.standard._FileOutputStream_if fs = null;
// 99
      fs = (JP.go.ipa.oz.lib.standard._FileOutputStream_cl) (new JP.go.ipa.oz.lib.standard._FileOutputStream_cl ())._new_breed (fileName);
// 100
      JP.go.ipa.oz.lib.standard._ObjectOutputStream_if os = null;
// 100
      os = (JP.go.ipa.oz.lib.standard._ObjectOutputStream_cl) (new JP.go.ipa.oz.lib.standard._ObjectOutputStream_cl ())._new_breed (fs);
// 101
      os.writeObject (res);
// 102
      os.flush ();
// 103
      fs.close ();
// 104
      JP.go.ipa.oz.lib.standard._String_if string$35 = (new JP.go.ipa.oz.lib.standard._String_cl("resource saved to "));
      
// 104
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, string$35, fileName);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, string$35, fileName);
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 105
      JP.go.ipa.oz.lib.standard._String_if string$36 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 105
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$36);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$36);
      }
    }
  }
  
  protected final void rollbackForRecover (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception  {
// 354
    rollback (t);
  }
  
  final JP.go.ipa.oz.user.lib_dist.tran._Status_if loadStatus (JP.go.ipa.oz.lib.standard._String_if fileName) throws Exception  {
// 134
    try {
// 135
      JP.go.ipa.oz.lib.standard._File_if f = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (fileName);
// 136
      boolean exists$val$29;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
        try {
          exists$val$29 = f.exists ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        exists$val$29 = f.exists ();
      }
// 136
      if (!exists$val$29) {{
// 136
          return null;
        }
      }
// 137
      JP.go.ipa.oz.lib.standard._FileInputStream_if fs = null;
// 137
      fs = (JP.go.ipa.oz.lib.standard._FileInputStream_cl) (new JP.go.ipa.oz.lib.standard._FileInputStream_cl ())._new_breed (fileName);
// 138
      JP.go.ipa.oz.lib.standard._ObjectInputStream_if os = null;
// 138
      os = (JP.go.ipa.oz.lib.standard._ObjectInputStream_cl) (new JP.go.ipa.oz.lib.standard._ObjectInputStream_cl ())._new_breed (fs);
// 139
      JP.go.ipa.oz.user.lib_dist.tran._Status_if res = null;
// 140
      res = (JP.go.ipa.oz.user.lib_dist.tran._Status_if) (os.readObject ());
// 141
      return res;
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_7) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_7 = _exception_7.getOzException ();
      if (_oz_exception_7 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
        JP.go.ipa.oz.lib.standard._IOException_if e = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_7;
// 142
        JP.go.ipa.oz.lib.standard._String_if string$37 = (new JP.go.ipa.oz.lib.standard._String_cl("IOException. cannot load."));
        
// 142
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (1, string$37);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (1, string$37);
        }
// 142
        return null;
      } else throw _exception_7;
    }
    catch (JP.go.ipa.oz.system.ExClassNotFoundException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 144
      d.write (1, (new JP.go.ipa.oz.lib.standard._String_cl("ClassNotFoundException. cannot load")));
// 145
      return null;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 147
      d.write (1, (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured")));
// 147
      return null;
    }
  }
  
  public final boolean isReadyToCommit (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception  {
    checkSecureInvocation ();
// 269
    JP.go.ipa.oz.lib.standard._String_if string$38 = (new JP.go.ipa.oz.lib.standard._String_cl("preCommit:"));
    
// 269
    JP.go.ipa.oz.lib.standard._String_if getTidGOL$val$30;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
      try {
        getTidGOL$val$30 = t.getTidGOL ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getTidGOL$val$30 = t.getTidGOL ();
    }
// 269
    int getID$val$31;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
      try {
        getID$val$31 = t.getID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getID$val$31 = t.getID ();
    }
// 269
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (x, string$38, getTidGOL$val$30, getID$val$31);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (x, string$38, getTidGOL$val$30, getID$val$31);
    }
// 270
    try {
// 271
      boolean isInLockingTransaction$val$32;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
        try {
          isInLockingTransaction$val$32 = st.isInLockingTransaction (t);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isInLockingTransaction$val$32 = st.isInLockingTransaction (t);
      }
// 271
      if (isInLockingTransaction$val$32) {{
// 272
          JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_cl) (new JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_cl ())._new_init ();
// 273
          int getLockMode$val$33;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
            try {
              getLockMode$val$33 = st.getLockMode ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getLockMode$val$33 = st.getLockMode ();
          }
// 273
          if (getLockMode$val$33 == 2) {{
// 274
              saveResource (r, rf);
// 275
              saveResource (r2, r2f);
            }
          }
// 277
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
            try {
              st.setCommit (1);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            st.setCommit (1);
          }
// 278
          saveStatus (st, sf);
// 279
          return true;
        }
      } else {{
// 281
          JP.go.ipa.oz.lib.standard._String_if string$39 = (new JP.go.ipa.oz.lib.standard._String_cl("cannot preCommit unlocked transaction."));
          
// 281
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (1, string$39);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (1, string$39);
          }
// 282
          return false;
        }
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_8) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_8 = _exception_8.getOzException ();
      if (_oz_exception_8 instanceof JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) {
        JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) _oz_exception_8;
// 285
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
          try {
            st.init ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          st.init ();
        }
// 286
        JP.go.ipa.oz.lib.standard._String_if string$40 = (new JP.go.ipa.oz.lib.standard._String_cl("preCommit fault.init."));
        
// 286
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (1, string$40);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (1, string$40);
        }
// 287
        return false;
      } else throw _exception_8;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 289
      d.write (1, (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured")));
// 289
      return false;
    }
  }
  
  protected final int getLockingTimeLimit () throws Exception  {
// 86
    int getLockingTimeLimit$val$34;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
      try {
        getLockingTimeLimit$val$34 = st.getLockingTimeLimit ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getLockingTimeLimit$val$34 = st.getLockingTimeLimit ();
    }
// 86
    return getLockingTimeLimit$val$34;
  }
  
  protected void go () throws Exception  {
  }
  
  public final void rollback (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception  {
    checkSecureInvocation ();
// 334
    try {
// 335
      boolean isInLockingTransaction$val$35;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
        try {
          isInLockingTransaction$val$35 = st.isInLockingTransaction (t);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isInLockingTransaction$val$35 = st.isInLockingTransaction (t);
      }
// 335
      if (isInLockingTransaction$val$35) {{
// 336
          int getCommit$val$36;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
            try {
              getCommit$val$36 = st.getCommit ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getCommit$val$36 = st.getCommit ();
          }
// 336
          if ((getCommit$val$36) > 0) {{
// 337
              int getLockMode$val$37;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
                try {
                  getLockMode$val$37 = st.getLockMode ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getLockMode$val$37 = st.getLockMode ();
              }
// 337
              if (getLockMode$val$37 == 2) {
// 338
                r = r2;
              }
// 339
              JP.go.ipa.oz.lib.standard._String_if string$41 = (new JP.go.ipa.oz.lib.standard._String_cl("rollbacked"));
              
// 339
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                try {
                  d.write (x, string$41);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                d.write (x, string$41);
              }
            }
          } else {{
// 340
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
                try {
                  st.init ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                st.init ();
              }
// 340
              JP.go.ipa.oz.lib.standard._String_if string$42 = (new JP.go.ipa.oz.lib.standard._String_cl("rollbacked(init)"));
              
// 340
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                try {
                  d.write (x, string$42);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                d.write (x, string$42);
              }
            }
          }
        }
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 342
      JP.go.ipa.oz.lib.standard._String_if string$43 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 342
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
  
  final void checkLockingTime () throws Exception  {
// 166
    JP.go.ipa.oz.lib.standard._String_if string$44 = (new JP.go.ipa.oz.lib.standard._String_cl("checkLockingTime:"));
    
// 166
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (x, string$44);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (x, string$44);
    }
// 167
    JP.go.ipa.oz.user.lib_dist.sync.timer._Timer_if t = (JP.go.ipa.oz.user.lib_dist.sync.timer._Timer_cl) (new JP.go.ipa.oz.user.lib_dist.sync.timer._Timer_cl ())._new_create ();
// 167
    JP.go.ipa.oz.user.lib_dist.tran._CheckLockingTime_if mmr = (JP.go.ipa.oz.user.lib_dist.tran._CheckLockingTime_cl) (new JP.go.ipa.oz.user.lib_dist.tran._CheckLockingTime_cl ())._new_create (t);
// 167
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mmr)) {
      try {
        mmr.set (this);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      mmr.set (this);
    }
// 168
    int i = 0;
// 168
    int getLockingTimeLimit$val$38;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
      try {
        getLockingTimeLimit$val$38 = st.getLockingTimeLimit ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getLockingTimeLimit$val$38 = st.getLockingTimeLimit ();
    }
// 168
    i = getLockingTimeLimit$val$38;
// 168
    JP.go.ipa.oz.lib.standard._String_if string$45 = (new JP.go.ipa.oz.lib.standard._String_cl("lockingTimeLimit="));
    
// 168
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (x, string$45, i);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (x, string$45, i);
    }
// 169
    try {
// 170
      JP.go.ipa.oz.lang._Root_if invoke$val$39;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
        try {
          invoke$val$39 = t.invoke (mmr, i);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        invoke$val$39 = t.invoke (mmr, i);
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_9) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_9 = _exception_9.getOzException ();
      if (_oz_exception_9 instanceof JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) {
        JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) _oz_exception_9;
// 172
        JP.go.ipa.oz.lib.standard._String_if string$46 = (new JP.go.ipa.oz.lib.standard._String_cl("Resource locking timed out."));
        
// 172
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (x, string$46);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (x, string$46);
        }
// 172
        abortTran ();
      } else throw _exception_9;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 173
      JP.go.ipa.oz.lib.standard._String_if string$47 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 173
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$47);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$47);
      }
    }
  }
  
  public final int lock (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception  {
    checkSecureInvocation ();
// 177
    JP.go.ipa.oz.lib.standard._String_if string$48 = (new JP.go.ipa.oz.lib.standard._String_cl("lock:"));
    
// 177
    JP.go.ipa.oz.lib.standard._String_if getTidGOL$val$40;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
      try {
        getTidGOL$val$40 = t.getTidGOL ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getTidGOL$val$40 = t.getTidGOL ();
    }
// 177
    int getID$val$41;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
      try {
        getID$val$41 = t.getID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getID$val$41 = t.getID ();
    }
// 177
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (x, string$48, getTidGOL$val$40, getID$val$41);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (x, string$48, getTidGOL$val$40, getID$val$41);
    }
// 178
    int ret = 0;
// 179
    try {
// 181
      int getLockMode$val$42;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
        try {
          getLockMode$val$42 = st.getLockMode ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getLockMode$val$42 = st.getLockMode ();
      }
// 181
      if (getLockMode$val$42 == 0) {
// 182
        int lockBody$val$43;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
          try {
            lockBody$val$43 = st.lockBody (t, 2);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          lockBody$val$43 = st.lockBody (t, 2);
        }
// 182
        ret = lockBody$val$43;
      } else {
        boolean bool$val$0;
        
        boolean bool$val$1;
        
// 184
        boolean isInLockingTransaction$val$44;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
          try {
            isInLockingTransaction$val$44 = st.isInLockingTransaction (t);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isInLockingTransaction$val$44 = st.isInLockingTransaction (t);
        }
        bool$val$1 = isInLockingTransaction$val$44;
        if (bool$val$1) {
// 184
          int getLockMode$val$45;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
            try {
              getLockMode$val$45 = st.getLockMode ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getLockMode$val$45 = st.getLockMode ();
          }
          bool$val$1 = getLockMode$val$45 == 1;
        }
        bool$val$0 = bool$val$1;
        if (bool$val$0) {
// 184
          int getLockingTransactionSize$val$46;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
            try {
              getLockingTransactionSize$val$46 = st.getLockingTransactionSize ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getLockingTransactionSize$val$46 = st.getLockingTransactionSize ();
          }
          bool$val$0 = getLockingTransactionSize$val$46 == 1;
        }
// 184
        if (bool$val$0) {{
// 185
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
              try {
                st.setLockMode (2);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              st.setLockMode (2);
            }
// 186
            JP.go.ipa.oz.lib.standard._String_if string$49 = (new JP.go.ipa.oz.lib.standard._String_cl("lockMode=2"));
            
// 186
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
              try {
                d.write (x, string$49);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              d.write (x, string$49);
            }
// 187
            ret = 1;
          }
        } else {
          boolean bool$val$2;
          
// 190
          boolean isInLockingTransaction$val$47;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
            try {
              isInLockingTransaction$val$47 = st.isInLockingTransaction (t);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            isInLockingTransaction$val$47 = st.isInLockingTransaction (t);
          }
          bool$val$2 = isInLockingTransaction$val$47;
          if (bool$val$2) {
// 190
            int getLockMode$val$48;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) st)) {
              try {
                getLockMode$val$48 = st.getLockMode ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getLockMode$val$48 = st.getLockMode ();
            }
            bool$val$2 = getLockMode$val$48 == 2;
          }
// 190
          if (bool$val$2) {
// 191
            ret = 1;
          } else {
// 193
            return block (t, 2);
          }
        }
      }
// 194
      if (ret == 1) {{
// 196
          saveStatus (st, sf);
// 197
          r2 = r;
// 198
          return 1;
        }
      } else {
// 200
        return 0;
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_10) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_10 = _exception_10.getOzException ();
      if (_oz_exception_10 instanceof JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) {
        JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if) _oz_exception_10;
// 203
        JP.go.ipa.oz.lib.standard._String_if string$50 = (new JP.go.ipa.oz.lib.standard._String_cl("Lock timed out."));
        
// 203
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (1, string$50);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (1, string$50);
        }
// 205
        return 0;
      } else throw _exception_10;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 207
      d.write (1, (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured")));
// 207
      return 0;
    }
  }
  
  public _TransactionResource_cl () { super ("JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_pcl"); }
  
  public _TransactionResource_cl (String proxy_id) { super (proxy_id); }
  
}


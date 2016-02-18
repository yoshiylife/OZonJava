package JP.go.ipa.oz.user.lib_dist.tran;

public class _Status_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.lib_dist.tran._Status_if {
  JP.go.ipa.oz.user.lib_dist.tran._Debug_if d;
  int x;
  int lockingTimeLimit;
  int MaxLockingTransaction;
  int commit;
  int waitUnlock;
  JP.go.ipa.oz.lib.standard._SList_if blockingTransaction;
  JP.go.ipa.oz.lib.standard._String_if gol;
  JP.go.ipa.oz.lib.standard._SList_if lockingTransaction;
  int MaxBlockingTransaction;
  int lockMode;
  
  public Object _new_create (int ml, int mb, JP.go.ipa.oz.lib.standard._String_if g, int i) throws Exception  {
// 27
    d = (JP.go.ipa.oz.user.lib_dist.tran._Debug_cl) (new JP.go.ipa.oz.user.lib_dist.tran._Debug_cl ())._new_create ();
// 27
    init (ml, mb);
// 27
    x = i;
// 27
    gol = g;
    return this;
  }
  
  public final void blockToLock () throws Exception  {
    checkSecureInvocation ();
// 86
    try {
// 87
      int i = 0;
// 87
      int size$val$0;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) blockingTransaction)) {
        try {
          size$val$0 = blockingTransaction.size ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        size$val$0 = blockingTransaction.size ();
      }
// 87
      i = size$val$0;
// 88
      if (i > 0) {{
// 89
          JP.go.ipa.oz.user.lib_dist.tran._TID_if tid = null;
// 89
          JP.go.ipa.oz.lang._Root_if first$val$1;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) blockingTransaction)) {
            try {
              first$val$1 = blockingTransaction.first ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            first$val$1 = blockingTransaction.first ();
          }
// 89
          tid = (JP.go.ipa.oz.user.lib_dist.tran._TID_if) (first$val$1);
// 90
          JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl(" blockToLock:next transaction="));
          
// 90
          JP.go.ipa.oz.lib.standard._String_if getTidGOL$val$2;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tid)) {
            try {
              getTidGOL$val$2 = tid.getTidGOL ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getTidGOL$val$2 = tid.getTidGOL ();
          }
// 90
          int getID$val$3;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tid)) {
            try {
              getID$val$3 = tid.getID ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getID$val$3 = tid.getID ();
          }
// 90
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (x, string$0, getTidGOL$val$2, getID$val$3);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (x, string$0, getTidGOL$val$2, getID$val$3);
          }
// 91
          if (tid != null) {
// 91
            JP.go.ipa.oz.lib.standard._SList_if popFront$val$4;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) blockingTransaction)) {
              try {
                popFront$val$4 = blockingTransaction.popFront ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              popFront$val$4 = blockingTransaction.popFront ();
            }
// 91
            blockingTransaction = popFront$val$4;
          }
// 92
          int getLockMode$val$5;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tid)) {
            try {
              getLockMode$val$5 = tid.getLockMode ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getLockMode$val$5 = tid.getLockMode ();
          }
// 92
          i = lockBody (tid, getLockMode$val$5);
// 93
          JP.go.ipa.oz.lib.standard._String_if s = null;
// 93
          JP.go.ipa.oz.lib.standard._String_if getTidGOL$val$6;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tid)) {
            try {
              getTidGOL$val$6 = tid.getTidGOL ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getTidGOL$val$6 = tid.getTidGOL ();
          }
// 93
          s = getTidGOL$val$6;
// 93
          JP.go.ipa.oz.user.lib_dist.tran._Transaction_if t = null;
// 93
          t = new JP.go.ipa.oz.user.lib_dist.tran._Transaction_pcl (s);
// 94
          JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl(" bind to "));
          
// 94
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (x, string$1, s);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (x, string$1, s);
          }
// 95
          t.setLockingResource (gol);
        }
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 97
      JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 97
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$2);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$2);
      }
    }
  }
  
  public final void unlock (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception  {
    checkSecureInvocation ();
// 74
    try {
// 75
      JP.go.ipa.oz.lib.standard._Collection_if remove$val$7;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lockingTransaction)) {
        try {
          remove$val$7 = lockingTransaction.remove (t);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        remove$val$7 = lockingTransaction.remove (t);
      }
// 75
      lockingTransaction = (JP.go.ipa.oz.lib.standard._SList_if) (remove$val$7);
// 76
      int i = 0;
// 76
      int size$val$8;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lockingTransaction)) {
        try {
          size$val$8 = lockingTransaction.size ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        size$val$8 = lockingTransaction.size ();
      }
// 76
      i = size$val$8;
// 77
      JP.go.ipa.oz.lib.standard._String_if string$3 = (new JP.go.ipa.oz.lib.standard._String_cl(" after unlocked,lockingTranSize="));
      
// 77
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (x, string$3, i);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (x, string$3, i);
      }
// 78
      if (i == 0) {{
// 78
          init ();
// 79
          JP.go.ipa.oz.lib.standard._String_if string$4 = (new JP.go.ipa.oz.lib.standard._String_cl(" inited.lockMode="));
          
// 79
          int getLockMode$val$9;
          getLockMode$val$9 = getLockMode ();
// 79
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (x, string$4, getLockMode$val$9);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (x, string$4, getLockMode$val$9);
          }
// 80
          blockToLock ();
        }
      } else {
// 82
        JP.go.ipa.oz.lib.standard._String_if string$5 = (new JP.go.ipa.oz.lib.standard._String_cl(" unlocked,but not inited.lockMode="));
        
// 82
        int getLockMode$val$10;
        getLockMode$val$10 = getLockMode ();
// 82
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (x, string$5, getLockMode$val$10);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (x, string$5, getLockMode$val$10);
        }
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 83
      JP.go.ipa.oz.lib.standard._String_if string$6 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 83
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$6);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$6);
      }
    }
  }
  
  public final void init0 () throws Exception  {
    checkSecureInvocation ();
// 35
    JP.go.ipa.oz.user.lib_dist.tran._TIDComparator_if tc = null;
// 35
    tc = (JP.go.ipa.oz.user.lib_dist.tran._TIDComparator_cl) (new JP.go.ipa.oz.user.lib_dist.tran._TIDComparator_cl ())._new_create ();
// 36
    lockingTransaction = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create (tc);
// 37
    blockingTransaction = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create (tc);
// 38
    init ();
  }
  
  public final int getWaitUnlock () throws Exception  {
    checkSecureInvocation ();
// 60
    return waitUnlock;
  }
  
  public final boolean isInLockingTransaction (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception  {
    checkSecureInvocation ();
// 117
    try {
// 118
      int i = 0;
// 118
      int indexOf$val$11;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lockingTransaction)) {
        try {
          indexOf$val$11 = lockingTransaction.indexOf (t);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        indexOf$val$11 = lockingTransaction.indexOf (t);
      }
// 118
      i = indexOf$val$11;
// 121
      if (i == -1) {
// 121
        return false;
      } else {
// 122
        return true;
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 123
      JP.go.ipa.oz.lib.standard._String_if string$7 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 123
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$7);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$7);
      }
// 123
      return false;
    }
  }
  
  public final void setMaxBlockingTransaction (int i) throws Exception  {
    checkSecureInvocation ();
// 65
    MaxBlockingTransaction = i;
  }
  
  public final int getMaxBlockingTransaction () throws Exception  {
    checkSecureInvocation ();
// 66
    return MaxBlockingTransaction;
  }
  
  public final void init () throws Exception  {
    checkSecureInvocation ();
// 41
    lockMode = 0;
// 42
    commit = 0;
// 43
    waitUnlock = 0;
  }
  
  public final void init (int ml, int mb) throws Exception  {
    checkSecureInvocation ();
// 31
    MaxLockingTransaction = ml;
// 31
    MaxBlockingTransaction = mb;
// 32
    init0 ();
  }
  
  public final JP.go.ipa.oz.lib.standard._SList_if getLockingTransaction () throws Exception  {
    checkSecureInvocation ();
// 69
    return lockingTransaction;
  }
  
  public final void setLockingTimeLimit (int i) throws Exception  {
    checkSecureInvocation ();
// 61
    lockingTimeLimit = i;
  }
  
  public final boolean setBlockingTransaction (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception  {
    checkSecureInvocation ();
// 52
    int i = 0;
// 52
    int size$val$12;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) blockingTransaction)) {
      try {
        size$val$12 = blockingTransaction.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$12 = blockingTransaction.size ();
    }
// 52
    i = size$val$12;
// 53
    if (i == MaxBlockingTransaction) {
// 53
      return false;
    } else {
// 55
      JP.go.ipa.oz.lib.standard._SList_if pushBack$val$13;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) blockingTransaction)) {
        try {
          pushBack$val$13 = blockingTransaction.pushBack (t);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        pushBack$val$13 = blockingTransaction.pushBack (t);
      }
    }
// 55
    return true;
  }
  
  public final int getLockMode () throws Exception  {
    checkSecureInvocation ();
// 68
    return lockMode;
  }
  
  public final void setCommit (int i) throws Exception  {
    checkSecureInvocation ();
// 57
    commit = i;
  }
  
  public final void setLockMode (int i) throws Exception  {
    checkSecureInvocation ();
// 67
    lockMode = i;
  }
  
  public final int lockBody (JP.go.ipa.oz.user.lib_dist.tran._TID_if t, int i) throws Exception  {
    checkSecureInvocation ();
// 100
    JP.go.ipa.oz.lib.standard._String_if string$8 = (new JP.go.ipa.oz.lib.standard._String_cl(" lockBody:"));
    
// 100
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
// 100
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
// 100
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.write (x, string$8, getTidGOL$val$14, getID$val$15);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.write (x, string$8, getTidGOL$val$14, getID$val$15);
    }
// 101
    try {
      boolean bool$val$0;
      
      bool$val$0 = lockMode == 0;
      if (!bool$val$0) {
        boolean bool$val$1;
        
        bool$val$1 = i == 1;
        if (bool$val$1) {
          bool$val$1 = lockMode == 1;
        }
        bool$val$0 = (bool$val$1);
      }
// 102
      if (bool$val$0) {
// 103
        lockMode = i;
      }
// 104
      if (lockMode > 0) {{
// 105
          JP.go.ipa.oz.lib.standard._String_if string$9 = (new JP.go.ipa.oz.lib.standard._String_cl(" lockMode="));
          
// 105
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (x, string$9, i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (x, string$9, i);
          }
// 106
          int j = 0;
// 106
          int size$val$16;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lockingTransaction)) {
            try {
              size$val$16 = lockingTransaction.size ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            size$val$16 = lockingTransaction.size ();
          }
// 106
          j = size$val$16;
// 107
          if (j < MaxLockingTransaction) {{
// 108
              JP.go.ipa.oz.lib.standard._SList_if pushBack$val$17;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lockingTransaction)) {
                try {
                  pushBack$val$17 = lockingTransaction.pushBack (t);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                pushBack$val$17 = lockingTransaction.pushBack (t);
              }
// 109
              return 1;
            }
          } else {{
// 111
              JP.go.ipa.oz.lib.standard._String_if string$10 = (new JP.go.ipa.oz.lib.standard._String_cl("LockingTransaction queue is over limit."));
              
// 111
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
                try {
                  d.write (x, string$10);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                d.write (x, string$10);
              }
// 111
              return 0;
            }
          }
        }
      } else {
// 113
        return 0;
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 114
      JP.go.ipa.oz.lib.standard._String_if string$11 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception occured"));
      
// 114
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$11);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$11);
      }
// 114
      return 0;
    }
  }
  
  public final JP.go.ipa.oz.lib.standard._SList_if getBlockingTransaction () throws Exception  {
    checkSecureInvocation ();
// 70
    return blockingTransaction;
  }
  
  public final int getLockingTransactionSize () throws Exception  {
    checkSecureInvocation ();
// 49
    int size$val$18;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lockingTransaction)) {
      try {
        size$val$18 = lockingTransaction.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$18 = lockingTransaction.size ();
    }
// 49
    return size$val$18;
  }
  
  public final int getLockingTimeLimit () throws Exception  {
    checkSecureInvocation ();
// 62
    return lockingTimeLimit;
  }
  
  public final void setMaxLockingTransaction (int i) throws Exception  {
    checkSecureInvocation ();
// 63
    MaxLockingTransaction = i;
  }
  
  public final int getMaxLockingTransaction () throws Exception  {
    checkSecureInvocation ();
// 64
    return MaxLockingTransaction;
  }
  
  public final void setWaitUnlock (int i) throws Exception  {
    checkSecureInvocation ();
// 59
    waitUnlock = i;
  }
  
  public final int getCommit () throws Exception  {
    checkSecureInvocation ();
// 58
    return commit;
  }
  
  public _Status_cl () throws Exception { super (); }
  
}


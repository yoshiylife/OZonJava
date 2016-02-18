package JP.go.ipa.oz.user.lib_dist.tran;

public class _TransactionWaitLock_cl extends JP.go.ipa.oz.lang._Runnable_cl implements JP.go.ipa.oz.user.lib_dist.tran._TransactionWaitLock_if {
  JP.go.ipa.oz.user.lib_dist.tran._Transaction_if t;
  int i;
  JP.go.ipa.oz.user.lib_dist.tran._Debug_if d;
  
  public Object _new_create (JP.go.ipa.oz.user.lib_dist.tran._Transaction_if tran) throws Exception  {
// 47
    d = (JP.go.ipa.oz.user.lib_dist.tran._Debug_cl) (new JP.go.ipa.oz.user.lib_dist.tran._Debug_cl ())._new_create ();
// 47
    t = tran;
    return this;
  }
  
  public final void set (int j) throws Exception  {
    checkSecureInvocation ();
// 48
    i = j;
  }
  
  public final void run () throws Exception  {
    checkSecureInvocation ();
// 50
    JP.go.ipa.oz.system.OzCondition dummy = new JP.go.ipa.oz.system.OzCondition (this);
// 51
    while (true) {
// 51
      boolean isLock$val$2;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
        try {
          isLock$val$2 = t.isLock ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isLock$val$2 = t.isLock ();
      }
      if (!(!isLock$val$2)) break;
      
      /* body */ _loop_1: {
// 52
        JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl("waiting"));
        
// 52
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
          try {
            d.write (string$0);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          d.write (string$0);
        }
// 53
        wait (dummy, 10);
      }
    }
// 55
    boolean isLock$val$3;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
      try {
        isLock$val$3 = t.isLock ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isLock$val$3 = t.isLock ();
    }
// 55
    if (isLock$val$3) {
// 55
      JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl(" waiting for lock end"));
      
// 55
      int getLx$val$4;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
        try {
          getLx$val$4 = t.getLx ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getLx$val$4 = t.getLx ();
      }
// 55
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$1, getLx$val$4);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$1, getLx$val$4);
      }
    } else {
// 56
      JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl(" waiting for lock not end"));
      
// 56
      int getLx$val$5;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
        try {
          getLx$val$5 = t.getLx ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getLx$val$5 = t.getLx ();
      }
// 56
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
        try {
          d.write (1, string$2, getLx$val$5);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        d.write (1, string$2, getLx$val$5);
      }
    }
  }
  
  public _TransactionWaitLock_cl () throws Exception { super (); }
  
}


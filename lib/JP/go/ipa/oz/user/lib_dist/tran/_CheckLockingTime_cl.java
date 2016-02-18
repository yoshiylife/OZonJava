package JP.go.ipa.oz.user.lib_dist.tran;

public class _CheckLockingTime_cl extends JP.go.ipa.oz.user.lib_dist.sync.timer._MethodRunnable_cl implements JP.go.ipa.oz.user.lib_dist.tran._CheckLockingTime_if {
  JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if tr;
  
  public Object _new_create (JP.go.ipa.oz.user.lib_dist.sync.timer._Timer_if t) throws Exception  {
// 391
    super._new_create (t);
    return this;
  }
  
  public void set (JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if atr) throws Exception  {
    checkSecureInvocation ();
// 392
    tr = atr;
  }
  
  protected JP.go.ipa.oz.lang._Root_if MyMethod () throws Exception  {
// 394
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tr)) {
      try {
        tr.checkLockingTimeBody ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      tr.checkLockingTimeBody ();
    }
// 394
    return null;
  }
  
  public _CheckLockingTime_cl () throws Exception { super (); }
  
}


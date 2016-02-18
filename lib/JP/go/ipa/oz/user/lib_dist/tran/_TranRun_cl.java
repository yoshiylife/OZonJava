package JP.go.ipa.oz.user.lib_dist.tran;

public class _TranRun_cl extends JP.go.ipa.oz.lang._Runnable_cl implements JP.go.ipa.oz.user.lib_dist.tran._TranRun_if {
  JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if result;
  JP.go.ipa.oz.user.lib_dist.tran._Transaction_if tran;
  JP.go.ipa.oz.user.lib_dist.tran._TranTimer_if timer;
  JP.go.ipa.oz.lib.standard._String_if rg;
  
  public Object _new_create (JP.go.ipa.oz.user.lib_dist.tran._TranTimer_if t) throws Exception  {
// 34
    timer = t;
    return this;
  }
  
  public final void set (JP.go.ipa.oz.user.lib_dist.tran._Transaction_if tran1, JP.go.ipa.oz.lib.standard._String_if rg1) throws Exception  {
    checkSecureInvocation ();
// 40
    tran = tran1;
// 40
    rg = rg1;
  }
  
  public void run () throws Exception  {
    checkSecureInvocation ();
// 37
    JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if getResource$val$1;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tran)) {
      try {
        getResource$val$1 = tran.getResource (rg);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getResource$val$1 = tran.getResource (rg);
    }
// 37
    result = getResource$val$1;
// 38
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) timer)) {
      try {
        timer.MethodDone ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      timer.MethodDone ();
    }
  }
  
  public JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if getResult () throws Exception  {
    checkSecureInvocation ();
// 35
    return result;
  }
  
  public _TranRun_cl () throws Exception { super (); }
  
}


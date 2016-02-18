package JP.go.ipa.oz.user.lib_dist.tran;

public class _TranTimer_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.lib_dist.tran._TranTimer_if {
  protected JP.go.ipa.oz.system.OzCondition end = new JP.go.ipa.oz.system.OzCondition (this);
  protected boolean isDone;
  
  public Object _new_create () throws Exception  {
    return this;
  }
  
  public void MethodDone () throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 21
      isDone = true;
// 21
      signal (end);
    } finally {
      leave ();
    }
  }
  
  public JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if invoke (JP.go.ipa.oz.user.lib_dist.tran._TranRun_if mr, int time) throws Exception  {
    checkSecureInvocation ();
// 23
    isDone = false;
// 24
    JP.go.ipa.oz.lang._Thread_if t = (JP.go.ipa.oz.lang._Thread_cl) (new JP.go.ipa.oz.lang._Thread_cl ())._new_create (mr);
// 25
    endWait (time);
// 26
    if (isDone) {
// 26
      JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if getResult$val$0;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mr)) {
        try {
          getResult$val$0 = mr.getResult ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getResult$val$0 = mr.getResult ();
      }
// 26
      return (getResult$val$0);
    } else {{
// 27
        JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_cl) (new JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_cl ())._new_init ();
// 27
        throw new JP.go.ipa.oz.lang.OzException (e);
      }
    }
  }
  
  protected void endWait (int time) throws Exception  {
    enter ();
    try {
// 20
      if (!isDone) {
// 20
        wait (end, time);
      }
    } finally {
      leave ();
    }
  }
  
  public _TranTimer_cl () throws Exception { super (); }
  
}


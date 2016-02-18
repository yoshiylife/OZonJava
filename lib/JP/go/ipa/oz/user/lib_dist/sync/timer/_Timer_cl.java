package JP.go.ipa.oz.user.lib_dist.sync.timer;

public class _Timer_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.lib_dist.sync.timer._Timer_if {
  protected JP.go.ipa.oz.system.OzCondition end = new JP.go.ipa.oz.system.OzCondition (this);
  protected boolean isDone;
  
  public Object _new_create () throws Exception  {
    return this;
  }
  
  public void MethodDone () throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 19
      isDone = true;
// 19
      signal (end);
    } finally {
      leave ();
    }
  }
  
  public JP.go.ipa.oz.lang._Root_if invoke (JP.go.ipa.oz.user.lib_dist.sync.timer._MethodRunnable_if mr, int time) throws Exception  {
    checkSecureInvocation ();
// 21
    isDone = false;
// 22
    JP.go.ipa.oz.lang._Thread_if t = (JP.go.ipa.oz.lang._Thread_cl) (new JP.go.ipa.oz.lang._Thread_cl ())._new_create (mr);
// 23
    endWait (time);
// 24
    if (isDone) {
// 24
      JP.go.ipa.oz.lang._Root_if getResult$val$0;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mr)) {
        try {
          getResult$val$0 = mr.getResult ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getResult$val$0 = mr.getResult ();
      }
// 24
      return (getResult$val$0);
    } else {{
// 25
        JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_cl) (new JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_cl ())._new_init ();
// 25
        throw new JP.go.ipa.oz.lang.OzException (e);
      }
    }
  }
  
  protected void endWait (int time) throws Exception  {
    enter ();
    try {
// 18
      if (!isDone) {
// 18
        wait (end, time);
      }
    } finally {
      leave ();
    }
  }
  
  public _Timer_cl () throws Exception { super (); }
  
}


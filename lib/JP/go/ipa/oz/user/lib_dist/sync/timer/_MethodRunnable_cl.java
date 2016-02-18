package JP.go.ipa.oz.user.lib_dist.sync.timer;

abstract public class _MethodRunnable_cl extends JP.go.ipa.oz.lang._Runnable_cl implements JP.go.ipa.oz.user.lib_dist.sync.timer._MethodRunnable_if {
  JP.go.ipa.oz.lang._Root_if result;
  JP.go.ipa.oz.user.lib_dist.sync.timer._Timer_if timer;
  
  public Object _new_create (JP.go.ipa.oz.user.lib_dist.sync.timer._Timer_if t) throws Exception  {
// 17
    timer = t;
    return this;
  }
  
  public void run () throws Exception  {
    checkSecureInvocation ();
// 22
    result = MyMethod ();
// 23
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
  
  public JP.go.ipa.oz.lang._Root_if getResult () throws Exception  {
    checkSecureInvocation ();
// 19
    return (result);
  }
  
  protected abstract JP.go.ipa.oz.lang._Root_if MyMethod () throws Exception  ;
  public _MethodRunnable_cl () throws Exception { super (); }
  
}


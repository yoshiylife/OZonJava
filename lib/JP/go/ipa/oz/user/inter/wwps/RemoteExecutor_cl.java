package JP.go.ipa.oz.user.inter.wwps;

public class RemoteExecutor_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.inter.wwps.RemoteExecutor_if {
  
  public Object _new_create () throws Exception  {
    return this;
  }
  
  public void startForTest (JP.go.ipa.oz.user.inter.cgi.OzCGI_if c) throws Exception  {
    checkSecureInvocation ();
// 26
    JP.go.ipa.oz.user.inter.wwps.RemoteReceiver_if rr = (JP.go.ipa.oz.user.inter.wwps.RemoteReceiver_cl) (new JP.go.ipa.oz.user.inter.wwps.RemoteReceiver_cl ())._new_createForTest (c, (new JP.go.ipa.oz.lib.standard._String_cl("WWPS_EXECUTE")));
// 27
    JP.go.ipa.oz.lang._Thread_if th = (JP.go.ipa.oz.lang._Thread_cl) (new JP.go.ipa.oz.lang._Thread_cl ())._new_create (rr);
// 29
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) th)) {
      try {
        th.join ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      th.join ();
    }
  }
  
  public void start (JP.go.ipa.oz.user.inter.cgi.OzCGI_if c) throws Exception  {
    checkSecureInvocation ();
// 16
    JP.go.ipa.oz.user.inter.wwps.RemoteReceiver_if rr = (JP.go.ipa.oz.user.inter.wwps.RemoteReceiver_cl) (new JP.go.ipa.oz.user.inter.wwps.RemoteReceiver_cl ())._new_create (c, (new JP.go.ipa.oz.lib.standard._String_cl("WWPS_EXECUTE")));
// 17
    JP.go.ipa.oz.lang._Thread_if th = (JP.go.ipa.oz.lang._Thread_cl) (new JP.go.ipa.oz.lang._Thread_cl ())._new_create (rr);
  }
  
  public RemoteExecutor_cl () throws Exception { super (); }
  
}


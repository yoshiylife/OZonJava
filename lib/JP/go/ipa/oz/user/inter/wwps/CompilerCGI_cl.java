package JP.go.ipa.oz.user.inter.wwps;

public class CompilerCGI_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.inter.wwps.CompilerCGI_if {
  
  public Object _new_create () throws Exception  {
    return this;
  }
  
  public void startForTest (JP.go.ipa.oz.user.inter.cgi.OzCGI_if c) throws Exception  {
    checkSecureInvocation ();
// 25
    JP.go.ipa.oz.user.inter.wwps.CompileReceiver_if cr = (JP.go.ipa.oz.user.inter.wwps.CompileReceiver_cl) (new JP.go.ipa.oz.user.inter.wwps.CompileReceiver_cl ())._new_createForTest (c, (new JP.go.ipa.oz.lib.standard._String_cl("WWPS_COMPILE")));
// 26
    JP.go.ipa.oz.lang._Thread_if th = (JP.go.ipa.oz.lang._Thread_cl) (new JP.go.ipa.oz.lang._Thread_cl ())._new_create (cr);
// 27
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
// 15
    JP.go.ipa.oz.user.inter.wwps.CompileReceiver_if cr = (JP.go.ipa.oz.user.inter.wwps.CompileReceiver_cl) (new JP.go.ipa.oz.user.inter.wwps.CompileReceiver_cl ())._new_create (c, (new JP.go.ipa.oz.lib.standard._String_cl("WWPS_COMPILE")));
// 16
    JP.go.ipa.oz.lang._Thread_if th = (JP.go.ipa.oz.lang._Thread_cl) (new JP.go.ipa.oz.lang._Thread_cl ())._new_create (cr);
  }
  
  public CompilerCGI_cl () throws Exception { super (); }
  
}


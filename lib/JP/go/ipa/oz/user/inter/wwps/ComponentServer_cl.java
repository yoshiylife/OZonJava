package JP.go.ipa.oz.user.inter.wwps;

public class ComponentServer_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.inter.wwps.ComponentServer_if {
  
  public Object _new_create () throws Exception  {
    return this;
  }
  
  public void startForTest (JP.go.ipa.oz.user.inter.cgi.OzCGI_if c, int count) throws Exception  {
    checkSecureInvocation ();
// 38
    JP.go.ipa.oz.user.inter.wwps.ComponentReceiver_if cr = (JP.go.ipa.oz.user.inter.wwps.ComponentReceiver_cl) (new JP.go.ipa.oz.user.inter.wwps.ComponentReceiver_cl ())._new_createForTest (c, (new JP.go.ipa.oz.lib.standard._String_cl("WWPS_COMPONENT")), count);
// 39
    JP.go.ipa.oz.lang._Thread_if th = (JP.go.ipa.oz.lang._Thread_cl) (new JP.go.ipa.oz.lang._Thread_cl ())._new_create (cr);
// 40
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
  
  public void startForTest (JP.go.ipa.oz.user.inter.cgi.OzCGI_if c) throws Exception  {
    checkSecureInvocation ();
// 26
    JP.go.ipa.oz.user.inter.wwps.ComponentReceiver_if cr = (JP.go.ipa.oz.user.inter.wwps.ComponentReceiver_cl) (new JP.go.ipa.oz.user.inter.wwps.ComponentReceiver_cl ())._new_createForTest (c, (new JP.go.ipa.oz.lib.standard._String_cl("WWPS_COMPONENT")), 1);
// 27
    JP.go.ipa.oz.lang._Thread_if th = (JP.go.ipa.oz.lang._Thread_cl) (new JP.go.ipa.oz.lang._Thread_cl ())._new_create (cr);
// 28
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
    JP.go.ipa.oz.user.inter.wwps.ComponentReceiver_if cr = (JP.go.ipa.oz.user.inter.wwps.ComponentReceiver_cl) (new JP.go.ipa.oz.user.inter.wwps.ComponentReceiver_cl ())._new_create (c, (new JP.go.ipa.oz.lib.standard._String_cl("WWPS_COMPONENT")));
// 17
    JP.go.ipa.oz.lang._Thread_if th = (JP.go.ipa.oz.lang._Thread_cl) (new JP.go.ipa.oz.lang._Thread_cl ())._new_create (cr);
  }
  
  public ComponentServer_cl () throws Exception { super (); }
  
}


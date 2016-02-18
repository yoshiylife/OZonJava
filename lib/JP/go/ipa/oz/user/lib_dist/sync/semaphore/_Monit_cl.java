package JP.go.ipa.oz.user.lib_dist.sync.semaphore;

public class _Monit_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.lib_dist.sync.semaphore._Monit_if {
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.system.OzCondition dummy = new JP.go.ipa.oz.system.OzCondition (this);
  
  public Object _new_create () throws Exception  {
// 17
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
    return this;
  }
  
  public void monit (long time) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 19
      wait (dummy, time);
    } finally {
      leave ();
    }
  }
  
  public _Monit_cl () throws Exception { super (); }
  
}


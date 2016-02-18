package JP.go.ipa.oz.user.secu;

public class ASTimer_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.secu.ASTimer_if {
  protected JP.go.ipa.oz.system.OzCondition end = new JP.go.ipa.oz.system.OzCondition (this);
  protected boolean isDone;
  
  public Object _new_create () throws Exception  {
    return this;
  }
  
  public void MethodDone () throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 6
      isDone = true;
// 6
      signal (end);
    } finally {
      leave ();
    }
  }
  
  public void invoke (JP.go.ipa.oz.user.secu._Conncection_if mr, int time) throws Exception  {
    checkSecureInvocation ();
// 8
    isDone = false;
// 9
    JP.go.ipa.oz.lang._Thread_if t = (JP.go.ipa.oz.lang._Thread_cl) (new JP.go.ipa.oz.lang._Thread_cl ())._new_create (mr);
// 10
    endWait (time);
// 11
    if (!isDone) {{
// 11
        JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_if e = (JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_cl) (new JP.go.ipa.oz.user.lib_dist.sync.timer._TimeOutException_cl ())._new_init ();
// 11
        throw new JP.go.ipa.oz.lang.OzException (e);
      }
    }
  }
  
  protected void endWait (int time) throws Exception  {
    enter ();
    try {
// 5
      if (!isDone) {
// 5
        wait (end, time);
      }
    } finally {
      leave ();
    }
  }
  
  public ASTimer_cl () throws Exception { super (); }
  
}


package JP.go.ipa.oz.user.lib_dist.sync.timer;

public class _ThisMethodRunnable_cl extends JP.go.ipa.oz.user.lib_dist.sync.timer._MethodRunnable_cl implements JP.go.ipa.oz.user.lib_dist.sync.timer._ThisMethodRunnable_if {
  JP.go.ipa.oz.lib.standard._String_if s;
  int i;
  JP.go.ipa.oz.user.lib_dist.sync.timer._ThisFoo_if obj;
  
  public Object _new_create (JP.go.ipa.oz.user.lib_dist.sync.timer._Timer_if t) throws Exception  {
// 16
    super._new_create (t);
    return this;
  }
  
  public void set (JP.go.ipa.oz.user.lib_dist.sync.timer._ThisFoo_if Obj, int I, JP.go.ipa.oz.lib.standard._String_if S) throws Exception  {
    checkSecureInvocation ();
// 18
    obj = Obj;
// 18
    i = I;
// 18
    s = S;
  }
  
  protected JP.go.ipa.oz.lang._Root_if MyMethod () throws Exception  {
// 21
    int foo$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
      try {
        foo$val$0 = obj.foo (i, s);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      foo$val$0 = obj.foo (i, s);
    }
// 21
    int ret = foo$val$0;
// 22
    JP.go.ipa.oz.lib.standard._Integer_if I = (JP.go.ipa.oz.lib.standard._Integer_cl) (new JP.go.ipa.oz.lib.standard._Integer_cl ())._new_breed (ret);
// 23
    return I;
  }
  
  public _ThisMethodRunnable_cl () throws Exception { super (); }
  
}


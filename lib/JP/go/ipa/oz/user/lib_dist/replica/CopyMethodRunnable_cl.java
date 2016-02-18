package JP.go.ipa.oz.user.lib_dist.replica;

public class CopyMethodRunnable_cl extends JP.go.ipa.oz.user.lib_dist.sync.timer._MethodRunnable_cl implements JP.go.ipa.oz.user.lib_dist.replica.CopyMethodRunnable_if {
  JP.go.ipa.oz.user.lib_dist.replica.CopyFoo_if fooObj;
  JP.go.ipa.oz.lib.standard._String_if primaryGOL;
  JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if copy;
  int flag;
  
  public Object _new_create (JP.go.ipa.oz.user.lib_dist.sync.timer._Timer_if t) throws Exception  {
// 622
    super._new_create (t);
    return this;
  }
  
  public final void set (JP.go.ipa.oz.user.lib_dist.replica.CopyFoo_if object, JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if cp, int fl, JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
    checkSecureInvocation ();
// 625
    fooObj = object;
// 626
    copy = cp;
// 627
    flag = fl;
// 628
    primaryGOL = gol;
  }
  
  protected final JP.go.ipa.oz.lang._Root_if MyMethod () throws Exception  {
// 631
    long foo$val$53;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fooObj)) {
      try {
        foo$val$53 = fooObj.foo (copy, flag, primaryGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      foo$val$53 = fooObj.foo (copy, flag, primaryGOL);
    }
// 631
    long ret = foo$val$53;
// 632
    JP.go.ipa.oz.lib.standard._Long_if L = (JP.go.ipa.oz.lib.standard._Long_cl) (new JP.go.ipa.oz.lib.standard._Long_cl ())._new_breed (ret);
// 633
    return L;
  }
  
  public CopyMethodRunnable_cl () throws Exception { super (); }
  
}


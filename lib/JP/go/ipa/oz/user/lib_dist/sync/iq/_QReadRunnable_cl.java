package JP.go.ipa.oz.user.lib_dist.sync.iq;

public class _QReadRunnable_cl extends JP.go.ipa.oz.lang._Runnable_cl implements JP.go.ipa.oz.user.lib_dist.sync.iq._QReadRunnable_if {
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.user.lib_dist.sync.iq._QStruct_if qs;
  
  public Object _new_create (JP.go.ipa.oz.user.lib_dist.sync.iq._QStruct_if s) throws Exception  {
// 18
    qs = s;
// 19
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
    return this;
  }
  
  public void run () throws Exception  {
    checkSecureInvocation ();
// 22
    JP.go.ipa.oz.lang._Root_if o = null;
// 22
    JP.go.ipa.oz.lib.standard._String_if s = null;
// 22
    int i = 0;
// 23
    /* for loop starting here */ {
      /* initialization part */
// 23
      i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < 10)) break;
        
        /* body */ _loop_1: {
// 24
          JP.go.ipa.oz.lang._Root_if read$val$3;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) qs)) {
            try {
              read$val$3 = qs.read ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            read$val$3 = qs.read ();
          }
// 24
          o = read$val$3;
// 25
          s = (JP.go.ipa.oz.lib.standard._String_if) (o);
// 26
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (s);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (s);
          }
        }
        /* iteration part */
// 23
        i++;
      }
    }
  }
  
  public _QReadRunnable_cl () throws Exception { super (); }
  
}


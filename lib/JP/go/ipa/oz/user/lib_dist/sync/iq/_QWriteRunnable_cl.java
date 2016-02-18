package JP.go.ipa.oz.user.lib_dist.sync.iq;

public class _QWriteRunnable_cl extends JP.go.ipa.oz.lang._Runnable_cl implements JP.go.ipa.oz.user.lib_dist.sync.iq._QWriteRunnable_if {
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.lib.standard._String_if label;
  JP.go.ipa.oz.user.lib_dist.sync.iq._QStruct_if qs;
  
  public Object _new_create (JP.go.ipa.oz.user.lib_dist.sync.iq._QStruct_if s, JP.go.ipa.oz.lib.standard._String_if S) throws Exception  {
// 19
    qs = s;
// 20
    label = S;
// 21
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
    return this;
  }
  
  public void run () throws Exception  {
    checkSecureInvocation ();
// 24
    int i = 0;
// 25
    /* for loop starting here */ {
      /* initialization part */
// 25
      i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < 10)) break;
        
        /* body */ _loop_1: {
// 26
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) qs)) {
            try {
              qs.write (label);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            qs.write (label);
          }
        }
        /* iteration part */
// 25
        i++;
      }
    }
  }
  
  public _QWriteRunnable_cl () throws Exception { super (); }
  
}


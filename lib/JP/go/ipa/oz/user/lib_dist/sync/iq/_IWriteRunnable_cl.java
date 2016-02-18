package JP.go.ipa.oz.user.lib_dist.sync.iq;

public class _IWriteRunnable_cl extends JP.go.ipa.oz.lang._Runnable_cl implements JP.go.ipa.oz.user.lib_dist.sync.iq._IWriteRunnable_if {
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.lib.standard._String_if label;
  JP.go.ipa.oz.user.lib_dist.sync.iq._IStruct_if is;
  
  public Object _new_create (JP.go.ipa.oz.user.lib_dist.sync.iq._IStruct_if s, JP.go.ipa.oz.lib.standard._String_if S) throws Exception  {
// 19
    is = s;
// 20
    label = S;
// 21
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
    return this;
  }
  
  public void run () throws Exception  {
    checkSecureInvocation ();
// 24
    JP.go.ipa.oz.lib.standard._String_if string$7 = (new JP.go.ipa.oz.lib.standard._String_cl("write begin"));
    
// 24
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.println (string$7);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.println (string$7);
    }
// 25
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) is)) {
      try {
        is.write (label);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      is.write (label);
    }
// 26
    JP.go.ipa.oz.lib.standard._String_if string$8 = (new JP.go.ipa.oz.lib.standard._String_cl("write end"));
    
// 26
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.println (string$8);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.println (string$8);
    }
  }
  
  public _IWriteRunnable_cl () throws Exception { super (); }
  
}


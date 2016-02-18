package JP.go.ipa.oz.user.lib_dist.sync.iq;

public class _IReadRunnable_cl extends JP.go.ipa.oz.lang._Runnable_cl implements JP.go.ipa.oz.user.lib_dist.sync.iq._IReadRunnable_if {
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.user.lib_dist.sync.iq._IStruct_if is;
  
  public Object _new_create (JP.go.ipa.oz.user.lib_dist.sync.iq._IStruct_if s) throws Exception  {
// 18
    is = s;
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
// 23
    JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl("read begin"));
    
// 23
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.println (string$0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.println (string$0);
    }
// 24
    JP.go.ipa.oz.lang._Root_if read$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) is)) {
      try {
        read$val$0 = is.read ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      read$val$0 = is.read ();
    }
// 24
    o = read$val$0;
// 25
    s = (JP.go.ipa.oz.lib.standard._String_if) (o);
// 26
    JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl("read end"));
    
// 26
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.println (string$1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.println (string$1);
    }
// 27
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
  
  public _IReadRunnable_cl () throws Exception { super (); }
  
}


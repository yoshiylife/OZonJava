package JP.go.ipa.oz.user.lib_dist.sync.timer;

public class _MyFoo_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.lib_dist.sync.timer._MyFoo_if {
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.system.OzCondition dummy = new JP.go.ipa.oz.system.OzCondition (this);
  
  public Object _new_create () throws Exception  {
// 17
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
    return this;
  }
  
  public int foo (int i, JP.go.ipa.oz.lib.standard._String_if s, int time) throws Exception  {
    checkSecureInvocation ();
// 26
    JP.go.ipa.oz.user.lib_dist.sync.timer._Timer_if t = (JP.go.ipa.oz.user.lib_dist.sync.timer._Timer_cl) (new JP.go.ipa.oz.user.lib_dist.sync.timer._Timer_cl ())._new_create ();
// 26
    JP.go.ipa.oz.user.lib_dist.sync.timer._MyMethodRunnable_if mmr = (JP.go.ipa.oz.user.lib_dist.sync.timer._MyMethodRunnable_cl) (new JP.go.ipa.oz.user.lib_dist.sync.timer._MyMethodRunnable_cl ())._new_create (t);
// 27
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mmr)) {
      try {
        mmr.set (this, i, s);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      mmr.set (this, i, s);
    }
// 28
    JP.go.ipa.oz.lib.standard._Integer_if i$1 = null;
// 28
    JP.go.ipa.oz.lang._Root_if invoke$val$1;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) t)) {
      try {
        invoke$val$1 = t.invoke (mmr, time);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      invoke$val$1 = t.invoke (mmr, time);
    }
// 28
    i$1 = (JP.go.ipa.oz.lib.standard._Integer_if) (invoke$val$1);
// 29
    int intValue$val$2;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) i$1)) {
      try {
        intValue$val$2 = i$1.intValue ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      intValue$val$2 = i$1.intValue ();
    }
// 29
    return intValue$val$2;
  }
  
  public int foo (int i, JP.go.ipa.oz.lib.standard._String_if S) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 19
      JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl("method foo start"));
      
// 19
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$2);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$2);
      }
// 20
      wait (dummy, 3000);
// 22
      JP.go.ipa.oz.lib.standard._String_if string$3 = (new JP.go.ipa.oz.lib.standard._String_cl("method foo end"));
      
// 22
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$3);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$3);
      }
// 23
      return i;
    } finally {
      leave ();
    }
  }
  
  public _MyFoo_cl () throws Exception { super (); }
  
}


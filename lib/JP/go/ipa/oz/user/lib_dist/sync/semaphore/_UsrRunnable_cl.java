package JP.go.ipa.oz.user.lib_dist.sync.semaphore;

public class _UsrRunnable_cl extends JP.go.ipa.oz.lang._Runnable_cl implements JP.go.ipa.oz.user.lib_dist.sync.semaphore._UsrRunnable_if {
  JP.go.ipa.oz.lib.standard._System_if system;
  boolean mode;
  JP.go.ipa.oz.lib.standard._String_if label;
  JP.go.ipa.oz.user.lib_dist.sync.semaphore._ModedBinarySemaphore_if mbs;
  
  public Object _new_create (JP.go.ipa.oz.user.lib_dist.sync.semaphore._ModedBinarySemaphore_if s, JP.go.ipa.oz.lib.standard._String_if l, boolean m) throws Exception  {
// 20
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 21
    label = l;
// 22
    mode = m;
// 23
    mbs = s;
    return this;
  }
  
  public void run () throws Exception  {
    checkSecureInvocation ();
// 26
    long l = 5000;
// 26
    JP.go.ipa.oz.user.lib_dist.sync.semaphore._Monit_if m = (JP.go.ipa.oz.user.lib_dist.sync.semaphore._Monit_cl) (new JP.go.ipa.oz.user.lib_dist.sync.semaphore._Monit_cl ())._new_create ();
// 27
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.println (label);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.println (label);
    }
// 27
    JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl(" P"));
    
// 27
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.println (string$0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.println (string$0);
    }
// 28
    if (mode) {
// 28
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mbs)) {
        try {
          mbs.exclusiveP ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        mbs.exclusiveP ();
      }
    } else {
// 28
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mbs)) {
        try {
          mbs.sharedP ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        mbs.sharedP ();
      }
    }
// 29
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.println (label);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.println (label);
    }
// 29
    JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl(" critical begin"));
    
// 29
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.println (string$1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.println (string$1);
    }
// 30
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) m)) {
      try {
        m.monit (l);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      m.monit (l);
    }
// 31
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.println (label);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.println (label);
    }
// 31
    JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl(" critical end and V"));
    
// 31
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.println (string$2);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.println (string$2);
    }
// 32
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) mbs)) {
      try {
        mbs.V ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      mbs.V ();
    }
  }
  
  public _UsrRunnable_cl () throws Exception { super (); }
  
}


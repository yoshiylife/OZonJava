package JP.go.ipa.oz.user.lib_dist.sync.iq;

public class _IReadRunnableTwice_cl extends JP.go.ipa.oz.lang._Runnable_cl implements JP.go.ipa.oz.user.lib_dist.sync.iq._IReadRunnableTwice_if {
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
    JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl("read begin"));
    
// 23
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.println (string$2);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.println (string$2);
    }
// 24
    JP.go.ipa.oz.lang._Root_if read$val$1;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) is)) {
      try {
        read$val$1 = is.read ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      read$val$1 = is.read ();
    }
// 24
    o = read$val$1;
// 25
    s = (JP.go.ipa.oz.lib.standard._String_if) (o);
// 26
    JP.go.ipa.oz.lib.standard._String_if string$3 = (new JP.go.ipa.oz.lib.standard._String_cl("read end"));
    
// 26
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.println (string$3);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.println (string$3);
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
// 29
    try {
// 30
      JP.go.ipa.oz.lib.standard._String_if string$4 = (new JP.go.ipa.oz.lib.standard._String_cl("read again begin"));
      
// 30
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$4);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$4);
      }
// 31
      JP.go.ipa.oz.lang._Root_if read$val$2;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) is)) {
        try {
          read$val$2 = is.read ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        read$val$2 = is.read ();
      }
// 31
      o = read$val$2;
// 32
      JP.go.ipa.oz.lib.standard._String_if string$5 = (new JP.go.ipa.oz.lib.standard._String_cl("read again end"));
      
// 32
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$5);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$5);
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_1) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
      if (_oz_exception_1 instanceof JP.go.ipa.oz.user.lib_dist.sync.iq._IStructReadException_if) {
        JP.go.ipa.oz.user.lib_dist.sync.iq._IStructReadException_if e = (JP.go.ipa.oz.user.lib_dist.sync.iq._IStructReadException_if) _oz_exception_1;
// 34
        JP.go.ipa.oz.lib.standard._String_if string$6 = (new JP.go.ipa.oz.lib.standard._String_cl("istruct read exception"));
        
// 34
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.println (string$6);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.println (string$6);
        }
      } else throw _exception_1;
    }
  }
  
  public _IReadRunnableTwice_cl () throws Exception { super (); }
  
}


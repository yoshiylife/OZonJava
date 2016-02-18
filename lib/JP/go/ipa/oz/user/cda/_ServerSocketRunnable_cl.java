package JP.go.ipa.oz.user.cda;

public class _ServerSocketRunnable_cl extends JP.go.ipa.oz.lang._Runnable_cl implements JP.go.ipa.oz.user.cda._ServerSocketRunnable_if {
  int port;
  JP.go.ipa.oz.user.cda._TargetCDAList_if targets;
  JP.go.ipa.oz.lib.standard._ServerSocket_if listen;
  JP.go.ipa.oz.user.cda._DeliveryFileCache_if cache;
  
  public Object _new_create (int i, JP.go.ipa.oz.user.cda._DeliveryFileCache_if c, JP.go.ipa.oz.user.cda._TargetCDAList_if t) throws Exception  {
// 20
    port = i;
// 20
    cache = c;
// 20
    targets = t;
    return this;
  }
  
  public void close () throws Exception  {
    checkSecureInvocation ();
// 23
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) listen)) {
      try {
        listen.close ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      listen.close ();
    }
  }
  
  public void run () throws Exception  {
    checkSecureInvocation ();
// 26
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 27
    JP.go.ipa.oz.user.cda._CDAdebug_if debug = (JP.go.ipa.oz.user.cda._CDAdebug_cl) (new JP.go.ipa.oz.user.cda._CDAdebug_cl ())._new_create ();
// 28
    try {
// 29
      listen = (JP.go.ipa.oz.lib.standard._ServerSocket_cl) (new JP.go.ipa.oz.lib.standard._ServerSocket_cl ())._new_breed (port);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_1) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
      if (_oz_exception_1 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
        JP.go.ipa.oz.lib.standard._IOException_if e = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_1;
// 31
        JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl("can not breed ServerSocket"));
        
// 31
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.println (string$0);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.println (string$0);
        }
      } else throw _exception_1;
    }
// 33
    try {
// 34
      while (true) {
        /* body */ _loop_1: {
// 35
          JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl("listening"));
          
// 35
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (string$1);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (string$1);
          }
// 36
          JP.go.ipa.oz.lib.standard._Socket_if accept$val$0;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) listen)) {
            try {
              accept$val$0 = listen.accept ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            accept$val$0 = listen.accept ();
          }
// 36
          JP.go.ipa.oz.lib.standard._Socket_if client = accept$val$0;
// 37
          JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl("accept"));
          
// 37
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
            try {
              debug.println (string$2);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            debug.println (string$2);
          }
// 38
          JP.go.ipa.oz.user.cda._fromExecutorRunnable_if fromE = (JP.go.ipa.oz.user.cda._fromExecutorRunnable_cl) (new JP.go.ipa.oz.user.cda._fromExecutorRunnable_cl ())._new_create (client, cache, targets);
// 39
          JP.go.ipa.oz.lang._Thread_if t = (JP.go.ipa.oz.lang._Thread_cl) (new JP.go.ipa.oz.lang._Thread_cl ())._new_create (fromE);
        }
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_2) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_2 = _exception_2.getOzException ();
      if (_oz_exception_2 instanceof JP.go.ipa.oz.lib.standard._UserException_if) {
        JP.go.ipa.oz.lib.standard._UserException_if e = (JP.go.ipa.oz.lib.standard._UserException_if) _oz_exception_2;
// 44
        JP.go.ipa.oz.lib.standard._String_if string$3 = (new JP.go.ipa.oz.lib.standard._String_cl("ClassDeliveryAgent failed to accept from executor or reply to executor, or server socket closed"));
        
// 44
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.println (string$3);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.println (string$3);
        }
      } else throw _exception_2;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 42
      JP.go.ipa.oz.lib.standard._String_if string$4 = (new JP.go.ipa.oz.lib.standard._String_cl("ClassDeliveryAgent failed to accept from executor or reply to executor, or server socket closed"));
      
// 42
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$4);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$4);
      }
    }
  }
  
  public _ServerSocketRunnable_cl () throws Exception { super (); }
  
}


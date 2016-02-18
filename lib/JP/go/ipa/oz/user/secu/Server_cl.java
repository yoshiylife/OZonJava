package JP.go.ipa.oz.user.secu;

public class Server_cl extends JP.go.ipa.oz.lang._Runnable_cl implements JP.go.ipa.oz.user.secu.Server_if {
  int port;
  int time;
  JP.go.ipa.oz.lib.standard._System_if s;
  JP.go.ipa.oz.user.secu.OzAuthenticationServer_if as;
  JP.go.ipa.oz.lib.standard._ServerSocket_if listen_socket;
  int x;
  JP.go.ipa.oz.user.secu.Debug_if d;
  
  public Object _new_create (int port, JP.go.ipa.oz.user.secu.OzAuthenticationServer_if as) throws Exception  {
// 23
    s = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 23
    ((JP.go.ipa.oz.user.secu.Server_cl)this).port = port;
// 23
    ((JP.go.ipa.oz.user.secu.Server_cl)this).as = as;
// 24
    d = (JP.go.ipa.oz.user.secu.Debug_cl) (new JP.go.ipa.oz.user.secu.Debug_cl ())._new_create ();
// 24
    int getDebug$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) as)) {
      try {
        getDebug$val$0 = as.getDebug ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getDebug$val$0 = as.getDebug ();
    }
// 24
    x = getDebug$val$0;
    return this;
  }
  
  public void run () throws Exception  {
    checkSecureInvocation ();
// 27
    JP.go.ipa.oz.lib.standard._Socket_if client = null;
// 28
    try {
// 29
      listen_socket = (JP.go.ipa.oz.lib.standard._ServerSocket_cl) (new JP.go.ipa.oz.lib.standard._ServerSocket_cl ())._new_breed (port);
// 30
      while (true) {
        /* body */ _loop_1: {
// 31
          JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl("listenning"));
          
// 31
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
            try {
              d.write (x, string$0);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            d.write (x, string$0);
          }
// 32
          JP.go.ipa.oz.lib.standard._Socket_if accept$val$1;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) listen_socket)) {
            try {
              accept$val$1 = listen_socket.accept ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            accept$val$1 = listen_socket.accept ();
          }
// 32
          if ((client = accept$val$1) != null) {{
// 33
              JP.go.ipa.oz.user.secu._Conncection_if c = (JP.go.ipa.oz.user.secu._Connection_cl) (new JP.go.ipa.oz.user.secu._Connection_cl ())._new_create (client, as);
// 33
              JP.go.ipa.oz.lang._Thread_if t = (JP.go.ipa.oz.lang._Thread_cl) (new JP.go.ipa.oz.lang._Thread_cl ())._new_create (c);
            }
          }
        }
      }
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 36
      JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl("Exception while listenning"));
      
// 36
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
        try {
          s.println (string$1);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        s.println (string$1);
      }
    }
  }
  
  public Server_cl () throws Exception { super (); }
  
}


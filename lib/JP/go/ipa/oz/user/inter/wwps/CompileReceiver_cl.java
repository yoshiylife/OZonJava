package JP.go.ipa.oz.user.inter.wwps;

public class CompileReceiver_cl extends JP.go.ipa.oz.user.inter.cgi.ReceiveThread_cl implements JP.go.ipa.oz.user.inter.wwps.CompileReceiver_if {
  JP.go.ipa.oz.user.inter.wwps.CompilerServer_if compiler_server;
  
  public Object _new_create (JP.go.ipa.oz.user.inter.cgi.OzCGI_if c, JP.go.ipa.oz.lib.standard._String_if sel) throws Exception  {
// 88
    super._new_create (c, sel);
// 89
    compiler_server = (JP.go.ipa.oz.user.inter.wwps.CompilerServer_cl) (new JP.go.ipa.oz.user.inter.wwps.CompilerServer_cl ())._new_create ();
    return this;
  }
  
  public Object _new_createForTest (JP.go.ipa.oz.user.inter.cgi.OzCGI_if c, JP.go.ipa.oz.lib.standard._String_if sel) throws Exception  {
// 99
    super._new_create (c, sel);
// 100
    compiler_server = (JP.go.ipa.oz.user.inter.wwps.CompilerServer_cl) (new JP.go.ipa.oz.user.inter.wwps.CompilerServer_cl ())._new_create ();
// 101
    test_mode = true;
    return this;
  }
  
  protected void atExit () throws Exception  {
// 108
    stopCell ();
  }
  
  protected void dispatch () throws Exception  {
// 50
    JP.go.ipa.oz.lib.standard._String_if command = null;
// 51
    JP.go.ipa.oz.lib.standard._String_if string$23 = (new JP.go.ipa.oz.lib.standard._String_cl("command"));
    
// 51
    JP.go.ipa.oz.lang._Root_if getValue$val$75;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        getValue$val$75 = html.getValue (string$23);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getValue$val$75 = html.getValue (string$23);
    }
// 51
    command = (JP.go.ipa.oz.lib.standard._String_if) (getValue$val$75);
// 53
    if (command == null) {{
// 54
        sendResult ((new JP.go.ipa.oz.lib.standard._String_cl("your request is illegal.")));
// 55
        return;
      }
    }
// 58
    JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 59
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
      try {
        sys.debugPrintln (command);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sys.debugPrintln (command);
    }
// 61
    JP.go.ipa.oz.lib.standard._String_if string$24 = (new JP.go.ipa.oz.lib.standard._String_cl("compile"));
    
// 61
    boolean isequal$val$76;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
      try {
        isequal$val$76 = command.isequal (string$24);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$76 = command.isequal (string$24);
    }
// 61
    if (isequal$val$76) {{
// 62
        JP.go.ipa.oz.user.inter.wwps.CompileThread_if runnable = (JP.go.ipa.oz.user.inter.wwps.CompileThread_cl) (new JP.go.ipa.oz.user.inter.wwps.CompileThread_cl ())._new_create (cgi, html, compiler_server);
// 63
        JP.go.ipa.oz.lang._Thread_if th = createThread (runnable);
// 64
        if (test_mode) {
// 64
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) th)) {
            try {
              th.join ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            th.join ();
          }
        }
      }
    } else {
// 66
      JP.go.ipa.oz.lib.standard._String_if string$25 = (new JP.go.ipa.oz.lib.standard._String_cl("compile_test"));
      
// 66
      boolean isequal$val$77;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
        try {
          isequal$val$77 = command.isequal (string$25);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$77 = command.isequal (string$25);
      }
// 66
      if (isequal$val$77) {{
// 67
          JP.go.ipa.oz.user.inter.wwps.CompileThread_if runnable = (JP.go.ipa.oz.user.inter.wwps.CompileThread_cl) (new JP.go.ipa.oz.user.inter.wwps.CompileThread_cl ())._new_createForTest (cgi, html, compiler_server);
// 68
          JP.go.ipa.oz.lang._Thread_if th = createThread (runnable);
// 69
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) th)) {
            try {
              th.join ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            th.join ();
          }
        }
      } else {
// 71
        JP.go.ipa.oz.lib.standard._String_if string$26 = (new JP.go.ipa.oz.lib.standard._String_cl("download"));
        
// 71
        boolean isequal$val$78;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
          try {
            isequal$val$78 = command.isequal (string$26);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$78 = command.isequal (string$26);
        }
// 71
        if (isequal$val$78) {{
// 72
            JP.go.ipa.oz.user.inter.wwps.DownloadThread_if runnable = (JP.go.ipa.oz.user.inter.wwps.DownloadThread_cl) (new JP.go.ipa.oz.user.inter.wwps.DownloadThread_cl ())._new_create (cgi, html, compiler_server);
// 73
            JP.go.ipa.oz.lang._Thread_if th = createThread (runnable);
// 74
            if (test_mode) {
// 74
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) th)) {
                try {
                  th.join ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                th.join ();
              }
            }
          }
        } else {{
// 77
            sendResult ((new JP.go.ipa.oz.lib.standard._String_cl("your request is illegal.")));
          }
        }
      }
    }
  }
  
  public CompileReceiver_cl () throws Exception { super (); }
  
}


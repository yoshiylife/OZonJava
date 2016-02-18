package JP.go.ipa.oz.user.inter.wwps;

public class RemoteReceiver_cl extends JP.go.ipa.oz.user.inter.cgi.ReceiveThread_cl implements JP.go.ipa.oz.user.inter.wwps.RemoteReceiver_if {
  
  public Object _new_create (JP.go.ipa.oz.user.inter.cgi.OzCGI_if c, JP.go.ipa.oz.lib.standard._String_if sel) throws Exception  {
// 80
    super._new_create (c, sel);
    return this;
  }
  
  public Object _new_createForTest (JP.go.ipa.oz.user.inter.cgi.OzCGI_if c, JP.go.ipa.oz.lib.standard._String_if sel) throws Exception  {
// 91
    super._new_create (c, sel);
// 92
    test_mode = true;
    return this;
  }
  
  protected void dispatch () throws Exception  {
// 47
    JP.go.ipa.oz.lib.standard._String_if command = null;
// 48
    JP.go.ipa.oz.lib.standard._String_if string$107 = (new JP.go.ipa.oz.lib.standard._String_cl("command"));
    
// 48
    JP.go.ipa.oz.lang._Root_if getValue$val$215;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        getValue$val$215 = html.getValue (string$107);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getValue$val$215 = html.getValue (string$107);
    }
// 48
    command = (JP.go.ipa.oz.lib.standard._String_if) (getValue$val$215);
// 50
    if (command == null) {{
// 51
        sendResult ((new JP.go.ipa.oz.lib.standard._String_cl("your request is illegal.")));
// 52
        return;
      }
    }
// 55
    JP.go.ipa.oz.lib.standard._String_if string$108 = (new JP.go.ipa.oz.lib.standard._String_cl("execute"));
    
// 55
    boolean isequal$val$216;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
      try {
        isequal$val$216 = command.isequal (string$108);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$216 = command.isequal (string$108);
    }
// 55
    if (isequal$val$216) {{
// 57
        JP.go.ipa.oz.user.inter.wwps.RemoteExecuteThread_if runnable = (JP.go.ipa.oz.user.inter.wwps.RemoteExecuteThread_cl) (new JP.go.ipa.oz.user.inter.wwps.RemoteExecuteThread_cl ())._new_create (cgi, html);
// 58
        JP.go.ipa.oz.lang._Thread_if th = createThread (runnable);
// 59
        if (test_mode) {
// 59
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
// 61
      JP.go.ipa.oz.lib.standard._String_if string$109 = (new JP.go.ipa.oz.lib.standard._String_cl("execute_test"));
      
// 61
      boolean isequal$val$217;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
        try {
          isequal$val$217 = command.isequal (string$109);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$217 = command.isequal (string$109);
      }
// 61
      if (isequal$val$217) {{
// 63
          JP.go.ipa.oz.user.inter.wwps.RemoteExecuteThread_if runnable = (JP.go.ipa.oz.user.inter.wwps.RemoteExecuteThread_cl) (new JP.go.ipa.oz.user.inter.wwps.RemoteExecuteThread_cl ())._new_createForTest (cgi, html);
// 64
          JP.go.ipa.oz.lang._Thread_if th = createThread (runnable);
// 65
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
      } else {{
// 68
          sendResult ((new JP.go.ipa.oz.lib.standard._String_cl("your request is illegal.")));
// 69
          return;
        }
      }
    }
  }
  
  public RemoteReceiver_cl () throws Exception { super (); }
  
}


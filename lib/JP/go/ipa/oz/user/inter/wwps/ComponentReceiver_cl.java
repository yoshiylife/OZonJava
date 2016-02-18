package JP.go.ipa.oz.user.inter.wwps;

public class ComponentReceiver_cl extends JP.go.ipa.oz.user.inter.cgi.ReceiveThread_cl implements JP.go.ipa.oz.user.inter.wwps.ComponentReceiver_if {
  
  public Object _new_create (JP.go.ipa.oz.user.inter.cgi.OzCGI_if c, JP.go.ipa.oz.lib.standard._String_if sel) throws Exception  {
// 109
    super._new_create (c, sel);
    return this;
  }
  
  public Object _new_createForTest (JP.go.ipa.oz.user.inter.cgi.OzCGI_if c, JP.go.ipa.oz.lib.standard._String_if sel, int count) throws Exception  {
// 120
    super._new_create (c, sel);
// 121
    test_mode = true;
// 122
    operation_count = count;
    return this;
  }
  
  protected void dispatch () throws Exception  {
// 58
    JP.go.ipa.oz.lib.standard._String_if command = null;
// 59
    JP.go.ipa.oz.lib.standard._String_if string$32 = (new JP.go.ipa.oz.lib.standard._String_cl("command"));
    
// 59
    JP.go.ipa.oz.lang._Root_if getValue$val$105;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        getValue$val$105 = html.getValue (string$32);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getValue$val$105 = html.getValue (string$32);
    }
// 59
    command = (JP.go.ipa.oz.lib.standard._String_if) (getValue$val$105);
// 61
    if (command == null) {{
// 62
        sendResult ((new JP.go.ipa.oz.lib.standard._String_cl("your request is illegal.")));
// 63
        return;
      }
    }
// 66
    JP.go.ipa.oz.lib.standard._String_if string$33 = (new JP.go.ipa.oz.lib.standard._String_cl("create"));
    
// 66
    boolean isequal$val$106;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
      try {
        isequal$val$106 = command.isequal (string$33);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$106 = command.isequal (string$33);
    }
// 66
    if (isequal$val$106) {{
// 68
        JP.go.ipa.oz.user.inter.wwps.CreateComponentThread_if runnable = (JP.go.ipa.oz.user.inter.wwps.CreateComponentThread_cl) (new JP.go.ipa.oz.user.inter.wwps.CreateComponentThread_cl ())._new_create (cgi, html);
// 69
        JP.go.ipa.oz.lang._Thread_if th = createThread (runnable);
// 70
        if (test_mode) {
// 70
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
// 72
      JP.go.ipa.oz.lib.standard._String_if string$34 = (new JP.go.ipa.oz.lib.standard._String_cl("create_test"));
      
// 72
      boolean isequal$val$107;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
        try {
          isequal$val$107 = command.isequal (string$34);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$107 = command.isequal (string$34);
      }
// 72
      if (isequal$val$107) {{
// 74
          JP.go.ipa.oz.user.inter.wwps.CreateComponentThread_if runnable = (JP.go.ipa.oz.user.inter.wwps.CreateComponentThread_cl) (new JP.go.ipa.oz.user.inter.wwps.CreateComponentThread_cl ())._new_createForTest (cgi, html);
// 75
          JP.go.ipa.oz.lang._Thread_if th = createThread (runnable);
// 76
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
// 78
        JP.go.ipa.oz.lib.standard._String_if string$35 = (new JP.go.ipa.oz.lib.standard._String_cl("browse"));
        
// 78
        boolean isequal$val$108;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
          try {
            isequal$val$108 = command.isequal (string$35);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$108 = command.isequal (string$35);
        }
// 78
        if (isequal$val$108) {{
// 80
            JP.go.ipa.oz.user.inter.wwps.BrowseComponentThread_if runnable = (JP.go.ipa.oz.user.inter.wwps.BrowseComponentThread_cl) (new JP.go.ipa.oz.user.inter.wwps.BrowseComponentThread_cl ())._new_create (cgi, html);
// 81
            JP.go.ipa.oz.lang._Thread_if th = createThread (runnable);
// 82
            if (test_mode) {
// 82
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
// 84
          JP.go.ipa.oz.lib.standard._String_if string$36 = (new JP.go.ipa.oz.lib.standard._String_cl("browse_subject"));
          
// 84
          boolean isequal$val$109;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
            try {
              isequal$val$109 = command.isequal (string$36);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            isequal$val$109 = command.isequal (string$36);
          }
// 84
          if (isequal$val$109) {{
// 86
              JP.go.ipa.oz.user.inter.wwps.BrowseComponentThread_if runnable = (JP.go.ipa.oz.user.inter.wwps.BrowseComponentThread_cl) (new JP.go.ipa.oz.user.inter.wwps.BrowseComponentThread_cl ())._new_create (cgi, html);
// 87
              JP.go.ipa.oz.lang._Thread_if th = createThread (runnable);
// 88
              if (test_mode) {
// 88
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
// 90
            JP.go.ipa.oz.lib.standard._String_if string$37 = (new JP.go.ipa.oz.lib.standard._String_cl("search"));
            
// 90
            boolean isequal$val$110;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
              try {
                isequal$val$110 = command.isequal (string$37);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              isequal$val$110 = command.isequal (string$37);
            }
// 90
            if (isequal$val$110) {{
// 92
                JP.go.ipa.oz.user.inter.wwps.SearchComponentThread_if runnable = (JP.go.ipa.oz.user.inter.wwps.SearchComponentThread_cl) (new JP.go.ipa.oz.user.inter.wwps.SearchComponentThread_cl ())._new_create (cgi, html);
// 93
                JP.go.ipa.oz.lang._Thread_if th = createThread (runnable);
// 94
                if (test_mode) {
// 94
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
// 97
                sendResult ((new JP.go.ipa.oz.lib.standard._String_cl("your request is illegal.")));
// 98
                return;
              }
            }
          }
        }
      }
    }
  }
  
  public ComponentReceiver_cl () throws Exception { super (); }
  
}


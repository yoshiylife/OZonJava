package JP.go.ipa.oz.user.inter.cgi;

public class OzCGIManagerThread_cl extends JP.go.ipa.oz.user.inter.cgi.ReceiveThread_cl implements JP.go.ipa.oz.user.inter.cgi.OzCGIManagerThread_if {
  
  public Object _new_create (JP.go.ipa.oz.user.inter.cgi.OzCGI_if c) throws Exception  {
// 26
    super._new_create (c, (new JP.go.ipa.oz.lib.standard._String_cl("OZCGI_MANAGE")));
    return this;
  }
  
  protected void dispatch () throws Exception  {
// 33
    JP.go.ipa.oz.lib.standard._String_if command = null;
// 34
    JP.go.ipa.oz.lib.standard._String_if string$28 = (new JP.go.ipa.oz.lib.standard._String_cl("command"));
    
// 34
    JP.go.ipa.oz.lang._Root_if getValue$val$126;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) html)) {
      try {
        getValue$val$126 = html.getValue (string$28);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getValue$val$126 = html.getValue (string$28);
    }
// 34
    command = (JP.go.ipa.oz.lib.standard._String_if) (getValue$val$126);
// 36
    if (command == null) {{
// 37
        sendResult ((new JP.go.ipa.oz.lib.standard._String_cl("your request is illegal.")));
// 38
        return;
      }
    }
// 41
    JP.go.ipa.oz.lib.standard._String_if string$29 = (new JP.go.ipa.oz.lib.standard._String_cl("quit"));
    
// 41
    boolean isequal$val$127;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) command)) {
      try {
        isequal$val$127 = command.isequal (string$29);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$127 = command.isequal (string$29);
    }
// 41
    if (isequal$val$127) {{
// 42
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cgi)) {
          try {
            cgi.quit ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          cgi.quit ();
        }
// 43
        sendResult ((new JP.go.ipa.oz.lib.standard._String_cl("OZCGI stopping...")));
      }
    } else {{
// 45
        sendResult ((new JP.go.ipa.oz.lib.standard._String_cl("your request is illegal.")));
      }
    }
  }
  
  public OzCGIManagerThread_cl () throws Exception { super (); }
  
}


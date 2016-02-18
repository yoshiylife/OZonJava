package JP.go.ipa.oz.user.ide;

public class GarageBrowser_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.GarageBrowser_if {
  JP.go.ipa.oz.user.garage.SGarage_if server;
  JP.go.ipa.oz.lib.standard._String_if serverGOL;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
// 42
    bindServer (gol);
    return this;
  }
  
  public Object _new_create () throws Exception  {
    return this;
  }
  
  public JP.go.ipa.oz.user.garage.SGarage_if getServer () throws Exception  {
    checkSecureInvocation ();
// 82
    return server;
  }
  
  protected boolean isValidGOL (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
    boolean bool$val$29;
    
    bool$val$29 = gol == null;
    if (!bool$val$29) {
// 158
      int length$val$1129;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gol)) {
        try {
          length$val$1129 = gol.length ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        length$val$1129 = gol.length ();
      }
      bool$val$29 = length$val$1129 == 0;
    }
// 158
    if (bool$val$29) {{
// 159
        return false;
      }
    } else {{
// 161
        return true;
      }
    }
  }
  
  public void replace (JP.go.ipa.oz.user.garage.Key_if key, JP.go.ipa.oz.user.ide.Summarizable_if sbl) throws Exception  {
    checkSecureInvocation ();
// 128
    checkKey (key);
// 129
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) server)) {
      try {
        server.replace (key, sbl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      server.replace (key, sbl);
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getServerGOL () throws Exception  {
    checkSecureInvocation ();
// 75
    return serverGOL;
  }
  
  public void replaceSummary (JP.go.ipa.oz.user.garage.Key_if key, JP.go.ipa.oz.user.ide.Summary_if sm) throws Exception  {
    checkSecureInvocation ();
// 136
    checkKey (key);
// 137
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) server)) {
      try {
        server.replaceSummary (key, sm);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      server.replaceSummary (key, sm);
    }
  }
  
  public void remove (JP.go.ipa.oz.user.garage.Key_if key) throws Exception  {
    checkSecureInvocation ();
// 120
    checkKey (key);
// 121
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) server)) {
      try {
        server.remove (key);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      server.remove (key);
    }
  }
  
  public void bindServer (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
    checkSecureInvocation ();
// 52
    JP.go.ipa.oz.lib.standard._IllegalArgumentException_if argEx = null;
// 54
    if (isValidGOL (gol)) {{
// 55
        serverGOL = gol;
// 56
        server = new JP.go.ipa.oz.user.garage.SGarage_pcl (serverGOL);
      }
    } else {{
// 58
        argEx = (JP.go.ipa.oz.lib.standard._IllegalArgumentException_cl) (new JP.go.ipa.oz.lib.standard._IllegalArgumentException_cl ())._new_init ((new JP.go.ipa.oz.lib.standard._String_cl("Invalid GOL")));
// 59
        throw new JP.go.ipa.oz.lang.OzException (argEx);
      }
    }
  }
  
  void checkKey (JP.go.ipa.oz.user.garage.Key_if key) throws Exception  {
// 171
    JP.go.ipa.oz.lib.standard._IllegalArgumentException_if argEx = null;
// 173
    if (key == null) {{
// 174
        argEx = (JP.go.ipa.oz.lib.standard._IllegalArgumentException_cl) (new JP.go.ipa.oz.lib.standard._IllegalArgumentException_cl ())._new_init ((new JP.go.ipa.oz.lib.standard._String_cl("Null key")));
// 175
        throw new JP.go.ipa.oz.lang.OzException (argEx);
      }
    }
  }
  
  public void quit () throws Exception  {
    checkSecureInvocation ();
  }
  
  public void setVisible (boolean v) throws Exception  {
    checkSecureInvocation ();
  }
  
  public JP.go.ipa.oz.user.ide.Summarizable_if get (JP.go.ipa.oz.user.garage.Key_if key) throws Exception  {
    checkSecureInvocation ();
// 67
    checkKey (key);
// 68
    JP.go.ipa.oz.user.ide.Summarizable_if get$val$1130;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) server)) {
      try {
        get$val$1130 = server.get (key);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$1130 = server.get (key);
    }
// 68
    return get$val$1130;
  }
  
  public void launch () throws Exception  {
    checkSecureInvocation ();
  }
  
  public void sync () throws Exception  {
    checkSecureInvocation ();
  }
  
  public JP.go.ipa.oz.user.garage.Key_if put (JP.go.ipa.oz.user.ide.Summarizable_if sbl, JP.go.ipa.oz.user.ide.Summary_if sm) throws Exception  {
    checkSecureInvocation ();
// 102
    JP.go.ipa.oz.user.garage.Key_if key = null;
// 104
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbl)) {
      try {
        sbl.setSummary (sm);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sbl.setSummary (sm);
    }
// 105
    JP.go.ipa.oz.user.garage.Key_if put$val$1131;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) server)) {
      try {
        put$val$1131 = server.put (sbl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$1131 = server.put (sbl);
    }
// 105
    key = put$val$1131;
// 107
    return key;
  }
  
  public JP.go.ipa.oz.user.garage.Key_if put (JP.go.ipa.oz.user.ide.Summarizable_if sbl) throws Exception  {
    checkSecureInvocation ();
// 95
    JP.go.ipa.oz.user.garage.Key_if put$val$1132;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) server)) {
      try {
        put$val$1132 = server.put (sbl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$1132 = server.put (sbl);
    }
// 95
    return put$val$1132;
  }
  
  public GarageBrowser_cl () throws Exception { super (); }
  
}


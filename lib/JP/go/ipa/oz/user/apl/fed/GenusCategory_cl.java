package JP.go.ipa.oz.user.apl.fed;

public class GenusCategory_cl extends JP.go.ipa.oz.user.apl.fed.FedRoot_cl implements JP.go.ipa.oz.user.apl.fed.GenusCategory_if {
  static final boolean _global_ = true;
  protected JP.go.ipa.oz.lib.standard._String_if categoryName;
  protected JP.go.ipa.oz.lib.standard._String_if type;
  
  public JP.go.ipa.oz.lib.standard._String_if getType () throws Exception  {
    checkSecureInvocation ();
// 43
    if (debug) {
// 43
      JP.go.ipa.oz.lib.standard._String_if string$5 = (new JP.go.ipa.oz.lib.standard._String_cl("GenusCategory#getType() enter & leave"));
      
// 43
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
// 44
    return type;
  }
  
  public void init () throws Exception  {
    checkSecureInvocation ();
// 14
    super.init ();
// 15
    categoryName = null;
// 16
    type = null;
  }
  
  public boolean isMemberOf (JP.go.ipa.oz.lib.standard._String_if s) throws Exception  {
    checkSecureInvocation ();
// 53
    boolean result = false;
// 54
    boolean isRed$val$4;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
      try {
        isRed$val$4 = s.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$4 = s.isRed ();
    }
// 54
    if (isRed$val$4) {
// 54
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (s);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (s);
      }
    }
// 55
    if (debug) {
// 55
      JP.go.ipa.oz.lib.standard._String_if string$6 = (new JP.go.ipa.oz.lib.standard._String_cl("GenusCategory#isMemberOf() enter"));
      
// 55
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$6);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$6);
      }
    }
// 56
    if (type == null) {{
// 57
        return false;
      }
    } else {{
// 59
        boolean isequal$val$5;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) type)) {
          try {
            isequal$val$5 = type.isequal (s);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$5 = type.isequal (s);
        }
// 59
        result = isequal$val$5;
      }
    }
// 61
    if (debug) {
// 61
      JP.go.ipa.oz.lib.standard._String_if string$7 = (new JP.go.ipa.oz.lib.standard._String_cl("GenusCategory#isMemberOf() leave"));
      
// 61
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$7);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$7);
      }
    }
// 62
    return result;
  }
  
  public void setType (JP.go.ipa.oz.lib.standard._String_if s) throws Exception  {
    checkSecureInvocation ();
// 35
    boolean isRed$val$6;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
      try {
        isRed$val$6 = s.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$6 = s.isRed ();
    }
// 35
    if (isRed$val$6) {
// 35
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (s);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (s);
      }
    }
// 36
    if (debug) {
// 36
      JP.go.ipa.oz.lib.standard._String_if string$8 = (new JP.go.ipa.oz.lib.standard._String_cl("GenusCategory#setType() enter"));
      
// 36
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$8);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$8);
      }
    }
// 37
    type = s;
// 38
    if (debug) {
// 38
      JP.go.ipa.oz.lib.standard._String_if string$9 = (new JP.go.ipa.oz.lib.standard._String_cl("GenusCategory#setType() leave"));
      
// 38
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$9);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$9);
      }
    }
  }
  
  public void setCategoryName (JP.go.ipa.oz.lib.standard._String_if s) throws Exception  {
    checkSecureInvocation ();
// 21
    boolean isRed$val$7;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
      try {
        isRed$val$7 = s.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$7 = s.isRed ();
    }
// 21
    if (isRed$val$7) {
// 21
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (s);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (s);
      }
    }
// 22
    if (debug) {
// 22
      JP.go.ipa.oz.lib.standard._String_if string$10 = (new JP.go.ipa.oz.lib.standard._String_cl("GenusCategory#setCategoryName() enter"));
      
// 22
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$10);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$10);
      }
    }
// 23
    categoryName = s;
// 24
    if (debug) {
// 24
      JP.go.ipa.oz.lib.standard._String_if string$11 = (new JP.go.ipa.oz.lib.standard._String_cl("GenusCategory#setCategoryName() leave"));
      
// 24
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$11);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$11);
      }
    }
  }
  
  public void quiet () throws Exception  {
    checkSecureInvocation ();
// 9
    flushCell ();
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getCategoryName () throws Exception  {
    checkSecureInvocation ();
// 29
    if (debug) {
// 29
      JP.go.ipa.oz.lib.standard._String_if string$12 = (new JP.go.ipa.oz.lib.standard._String_cl("GenusCategory#getCategoryName() enter & leave"));
      
// 29
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$12);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$12);
      }
    }
// 30
    return categoryName;
  }
  
  public GenusCategory_cl () { super ("JP.go.ipa.oz.user.apl.fed.GenusCategory_pcl"); }
  
  public GenusCategory_cl (String proxy_id) { super (proxy_id); }
  
}


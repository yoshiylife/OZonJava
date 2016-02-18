package JP.go.ipa.oz.user.apl.fed;

public class ResourceProxy_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.apl.fed.ResourceProxy_if {
  protected JP.go.ipa.oz.lib.standard._System_if system;
  protected JP.go.ipa.oz.lib.standard._String_if autoType;
  protected JP.go.ipa.oz.user.apl.fed.ResourceProxy_if previous;
  protected JP.go.ipa.oz.lib.standard._String_if resource;
  protected JP.go.ipa.oz.lib.standard._String_if resType;
  
  public Object _new_create () throws Exception  {
// 16
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 17
    resource = (new JP.go.ipa.oz.lib.standard._String_cl("Null"));
// 18
    previous = null;
// 19
    autoType = (new JP.go.ipa.oz.lib.standard._String_cl("Null"));
// 20
    resType = (new JP.go.ipa.oz.lib.standard._String_cl("Null"));
    return this;
  }
  
  public JP.go.ipa.oz.user.apl.fed.ResourceProxy_if instanciate (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if prev) throws Exception  {
    checkSecureInvocation ();
// 119
    JP.go.ipa.oz.user.apl.fed.ResourceProxy_if proxy = instanciate ();
// 120
    if (prev != null) {
// 121
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxy)) {
        try {
          proxy.setPrevious (prev);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        proxy.setPrevious (prev);
      }
    }
// 123
    return proxy;
  }
  
  public JP.go.ipa.oz.user.apl.fed.ResourceProxy_if instanciate () throws Exception  {
    checkSecureInvocation ();
// 107
    JP.go.ipa.oz.user.apl.fed.ResourceProxy_if proxy = null;
// 108
    proxy = (JP.go.ipa.oz.user.apl.fed.ResourceProxy_cl) (new JP.go.ipa.oz.user.apl.fed.ResourceProxy_cl ())._new_create ();
// 109
    if (resource != null) {
// 109
      proxy.setResource (resource);
    }
// 110
    if (autoType != null) {
// 110
      proxy.setAutonomyType (autoType);
    }
// 111
    if (resType != null) {
// 111
      proxy.setResourceType (resType);
    }
// 113
    return proxy;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getAutonomyType () throws Exception  {
    checkSecureInvocation ();
// 72
    return autoType;
  }
  
  public boolean isEqual (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if rp) throws Exception  {
    checkSecureInvocation ();
    boolean bool$val$5;
    
    boolean bool$val$6;
    
// 146
    JP.go.ipa.oz.lib.standard._String_if getAutonomyType$val$20;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rp)) {
      try {
        getAutonomyType$val$20 = rp.getAutonomyType ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getAutonomyType$val$20 = rp.getAutonomyType ();
    }
// 146
    boolean isequal$val$21;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) autoType)) {
      try {
        isequal$val$21 = autoType.isequal (getAutonomyType$val$20);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$21 = autoType.isequal (getAutonomyType$val$20);
    }
    bool$val$6 = isequal$val$21;
    if (bool$val$6) {
// 147
      JP.go.ipa.oz.lib.standard._String_if getResourceType$val$22;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rp)) {
        try {
          getResourceType$val$22 = rp.getResourceType ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getResourceType$val$22 = rp.getResourceType ();
      }
// 147
      boolean isequal$val$23;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) resType)) {
        try {
          isequal$val$23 = resType.isequal (getResourceType$val$22);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$23 = resType.isequal (getResourceType$val$22);
      }
      bool$val$6 = isequal$val$23;
    }
    bool$val$5 = bool$val$6;
    if (bool$val$5) {
// 148
      JP.go.ipa.oz.lib.standard._String_if getResource$val$24;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rp)) {
        try {
          getResource$val$24 = rp.getResource ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getResource$val$24 = rp.getResource ();
      }
// 148
      boolean isequal$val$25;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) resource)) {
        try {
          isequal$val$25 = resource.isequal (getResource$val$24);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$25 = resource.isequal (getResource$val$24);
      }
      bool$val$5 = isequal$val$25;
    }
// 146
    if (bool$val$5) {
// 150
      return true;
    }
// 150
    return false;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getResource () throws Exception  {
    checkSecureInvocation ();
// 50
    if (resource != null) {{
// 52
        return resource;
      }
    } else {
// 53
      if (previous != null) {{
// 55
          JP.go.ipa.oz.lib.standard._String_if getResource$val$26;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) previous)) {
            try {
              getResource$val$26 = previous.getResource ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getResource$val$26 = previous.getResource ();
          }
// 55
          return getResource$val$26;
        }
      }
    }
// 58
    return null;
  }
  
  public JP.go.ipa.oz.user.apl.fed.ResourceProxy_if getPrevious () throws Exception  {
    checkSecureInvocation ();
// 34
    return previous;
  }
  
  public void setResource (JP.go.ipa.oz.lib.standard._String_if resGol) throws Exception  {
    checkSecureInvocation ();
// 40
    boolean isRed$val$27;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) resGol)) {
      try {
        isRed$val$27 = resGol.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$27 = resGol.isRed ();
    }
// 40
    if (isRed$val$27) {
// 40
      turnGreen (resGol);
    }
// 41
    resource = resGol;
// 42
    if (previous != null) {
// 43
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) previous)) {
        try {
          previous.setResource (resource);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        previous.setResource (resource);
      }
    }
  }
  
  public void setAutonomyType (JP.go.ipa.oz.lib.standard._String_if type) throws Exception  {
    checkSecureInvocation ();
// 64
    boolean isRed$val$28;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) type)) {
      try {
        isRed$val$28 = type.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$28 = type.isRed ();
    }
// 64
    if (isRed$val$28) {
// 64
      turnGreen (type);
    }
// 65
    autoType = type;
  }
  
  public void setPrevious (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if prev) throws Exception  {
    checkSecureInvocation ();
// 26
    boolean isRed$val$29;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prev)) {
      try {
        isRed$val$29 = prev.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$29 = prev.isRed ();
    }
// 26
    if (isRed$val$29) {
// 26
      turnGreen (prev);
    }
// 27
    previous = prev;
  }
  
  public boolean isAcceptable (JP.go.ipa.oz.lib.standard._String_if aType, JP.go.ipa.oz.lib.standard._String_if rType) throws Exception  {
    checkSecureInvocation ();
// 92
    boolean isRed$val$30;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aType)) {
      try {
        isRed$val$30 = aType.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$30 = aType.isRed ();
    }
// 92
    if (isRed$val$30) {
// 92
      turnGreen (aType);
    }
// 93
    boolean isRed$val$31;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rType)) {
      try {
        isRed$val$31 = rType.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$31 = rType.isRed ();
    }
// 93
    if (isRed$val$31) {
// 93
      turnGreen (rType);
    }
    boolean bool$val$7;
    
    boolean bool$val$8;
    
    boolean bool$val$9;
    
    bool$val$9 = autoType != null;
    if (bool$val$9) {
      bool$val$9 = aType != null;
    }
    bool$val$8 = bool$val$9;
    if (bool$val$8) {
      bool$val$8 = resType != null;
    }
    bool$val$7 = bool$val$8;
    if (bool$val$7) {
      bool$val$7 = rType != null;
    }
// 94
    if (bool$val$7) {{
        boolean bool$val$10;
        
// 95
        boolean isequal$val$32;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) autoType)) {
          try {
            isequal$val$32 = autoType.isequal (aType);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$32 = autoType.isequal (aType);
        }
        bool$val$10 = isequal$val$32;
        if (bool$val$10) {
// 95
          boolean isequal$val$33;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) resType)) {
            try {
              isequal$val$33 = resType.isequal (rType);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            isequal$val$33 = resType.isequal (rType);
          }
          bool$val$10 = isequal$val$33;
        }
// 95
        if (bool$val$10) {{
// 97
            return true;
          }
        }
      }
    }
// 101
    return false;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getResourceType () throws Exception  {
    checkSecureInvocation ();
// 86
    return resType;
  }
  
  public void toGreen () throws Exception  {
    checkSecureInvocation ();
    boolean bool$val$11;
    
    bool$val$11 = resource != null;
    if (bool$val$11) {
// 137
      boolean isRed$val$34;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) resource)) {
        try {
          isRed$val$34 = resource.isRed ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isRed$val$34 = resource.isRed ();
      }
      bool$val$11 = isRed$val$34;
    }
// 137
    if (bool$val$11) {
// 137
      turnGreen (resource);
    }
    boolean bool$val$12;
    
    bool$val$12 = previous != null;
    if (bool$val$12) {
// 138
      boolean isRed$val$35;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) previous)) {
        try {
          isRed$val$35 = previous.isRed ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isRed$val$35 = previous.isRed ();
      }
      bool$val$12 = isRed$val$35;
    }
// 138
    if (bool$val$12) {
// 138
      turnGreen (previous);
    }
// 139
    if (previous != null) {
// 139
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) previous)) {
        try {
          previous.toGreen ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        previous.toGreen ();
      }
    }
    boolean bool$val$13;
    
    bool$val$13 = autoType != null;
    if (bool$val$13) {
// 140
      boolean isRed$val$36;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) autoType)) {
        try {
          isRed$val$36 = autoType.isRed ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isRed$val$36 = autoType.isRed ();
      }
      bool$val$13 = isRed$val$36;
    }
// 140
    if (bool$val$13) {
// 140
      turnGreen (autoType);
    }
    boolean bool$val$14;
    
    bool$val$14 = resType != null;
    if (bool$val$14) {
// 141
      boolean isRed$val$37;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) resType)) {
        try {
          isRed$val$37 = resType.isRed ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isRed$val$37 = resType.isRed ();
      }
      bool$val$14 = isRed$val$37;
    }
// 141
    if (bool$val$14) {
// 141
      turnGreen (resType);
    }
    boolean bool$val$15;
    
    bool$val$15 = system != null;
    if (bool$val$15) {
// 142
      boolean isRed$val$38;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          isRed$val$38 = system.isRed ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isRed$val$38 = system.isRed ();
      }
      bool$val$15 = isRed$val$38;
    }
// 142
    if (bool$val$15) {
// 142
      turnGreen (system);
    }
  }
  
  public void setResourceType (JP.go.ipa.oz.lib.standard._String_if type) throws Exception  {
    checkSecureInvocation ();
// 78
    boolean isRed$val$39;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) type)) {
      try {
        isRed$val$39 = type.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$39 = type.isRed ();
    }
// 78
    if (isRed$val$39) {
// 78
      turnGreen (type);
    }
// 79
    resType = type;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if asString () throws Exception  {
    checkSecureInvocation ();
// 128
    JP.go.ipa.oz.lib.standard._String_if string$13 = (new JP.go.ipa.oz.lib.standard._String_cl("ResourceProxy[autoType = "));
    
// 128
    JP.go.ipa.oz.lib.standard._String_if concat$val$40;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$13)) {
      try {
        concat$val$40 = string$13.concat (autoType);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$40 = string$13.concat (autoType);
    }
// 130
    JP.go.ipa.oz.lib.standard._String_if string$14 = (new JP.go.ipa.oz.lib.standard._String_cl(", resType = "));
    
// 128
    JP.go.ipa.oz.lib.standard._String_if concat$val$41;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$40)) {
      try {
        concat$val$41 = concat$val$40.concat (string$14);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$41 = concat$val$40.concat (string$14);
    }
// 128
    JP.go.ipa.oz.lib.standard._String_if concat$val$42;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$41)) {
      try {
        concat$val$42 = concat$val$41.concat (resType);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$42 = concat$val$41.concat (resType);
    }
// 132
    JP.go.ipa.oz.lib.standard._String_if string$15 = (new JP.go.ipa.oz.lib.standard._String_cl("]"));
    
// 128
    JP.go.ipa.oz.lib.standard._String_if concat$val$43;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$42)) {
      try {
        concat$val$43 = concat$val$42.concat (string$15);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$43 = concat$val$42.concat (string$15);
    }
// 128
    return concat$val$43;
  }
  
  public ResourceProxy_cl () throws Exception { super (); }
  
}


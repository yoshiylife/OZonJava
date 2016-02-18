package JP.go.ipa.oz.user.apl.fm;

public class Pointer_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.apl.fm.Pointer_if {
  JP.go.ipa.oz.lib.standard._String_if name;
  JP.go.ipa.oz.lib.standard._String_if location;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if loc, JP.go.ipa.oz.lib.standard._String_if nm) throws Exception  {
// 32
    location = loc;
// 33
    name = nm;
    return this;
  }
  
  public void setLocation (JP.go.ipa.oz.lib.standard._String_if loc) throws Exception  {
    checkSecureInvocation ();
// 52
    location = loc;
  }
  
  public void setName (JP.go.ipa.oz.lib.standard._String_if n) throws Exception  {
    checkSecureInvocation ();
// 70
    name = n;
  }
  
  public boolean isEqualPointer (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception  {
    checkSecureInvocation ();
// 120
    if (ptr == null) {
// 121
      return false;
    }
    boolean bool$val$1;
    
// 121
    JP.go.ipa.oz.lib.standard._String_if getLocation$val$17;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ptr)) {
      try {
        getLocation$val$17 = ptr.getLocation ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getLocation$val$17 = ptr.getLocation ();
    }
// 121
    boolean isequal$val$18;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) location)) {
      try {
        isequal$val$18 = location.isequal (getLocation$val$17);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$18 = location.isequal (getLocation$val$17);
    }
    bool$val$1 = isequal$val$18;
    if (bool$val$1) {
// 122
      JP.go.ipa.oz.lib.standard._String_if getName$val$19;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ptr)) {
        try {
          getName$val$19 = ptr.getName ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getName$val$19 = ptr.getName ();
      }
// 122
      boolean isequal$val$20;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) name)) {
        try {
          isequal$val$20 = name.isequal (getName$val$19);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$20 = name.isequal (getName$val$19);
      }
      bool$val$1 = isequal$val$20;
    }
// 121
    return (bool$val$1);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getName () throws Exception  {
    checkSecureInvocation ();
// 61
    return name;
  }
  
  public JP.go.ipa.oz.user.apl.fm.FMContainer_if container () throws Exception  {
    checkSecureInvocation ();
// 79
    JP.go.ipa.oz.user.apl.fm.FMContainer_if fed = new JP.go.ipa.oz.user.apl.fm.FMContainer_pcl (location);
// 80
    return fed;
  }
  
  public void toGreen () throws Exception  {
    checkSecureInvocation ();
// 137
    JP.go.ipa.oz.user.apl.fm.Overseer_if overseer = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 138
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (location);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (location);
    }
// 139
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (name);
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if asString () throws Exception  {
    checkSecureInvocation ();
// 128
    JP.go.ipa.oz.lib.standard._StringBuffer_if rtn = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("[location=")));
// 129
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$21;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rtn)) {
      try {
        append$val$21 = rtn.append (location);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$21 = rtn.append (location);
    }
// 130
    JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl(", name="));
    
// 130
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$22;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rtn)) {
      try {
        append$val$22 = rtn.append (string$0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$22 = rtn.append (string$0);
    }
// 131
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$23;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rtn)) {
      try {
        append$val$23 = rtn.append (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$23 = rtn.append (name);
    }
// 132
    JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl("]"));
    
// 132
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$24;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rtn)) {
      try {
        append$val$24 = rtn.append (string$1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$24 = rtn.append (string$1);
    }
// 133
    JP.go.ipa.oz.lib.standard._String_if asString$val$25;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rtn)) {
      try {
        asString$val$25 = rtn.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$25 = rtn.asString ();
    }
// 133
    return asString$val$25;
  }
  
  public JP.go.ipa.oz.user.apl.fm.FMObject_if stuff () throws Exception  {
    checkSecureInvocation ();
// 91
    JP.go.ipa.oz.user.apl.fm.FMObject_if rtn = null;
// 92
    JP.go.ipa.oz.user.apl.fm.FMContainer_if fed = null;
// 93
    JP.go.ipa.oz.user.apl.fm.Overseer_if overseer = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 94
    while (true) {
      if (!((fed = container ()) != null)) break;
      
      /* body */ _loop_1: {
// 95
        boolean contains$val$26;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fed)) {
          try {
            contains$val$26 = fed.contains (this);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          contains$val$26 = fed.contains (this);
        }
// 95
        if (contains$val$26) {{
// 96
            JP.go.ipa.oz.user.apl.fm.FMObject_if get$val$27;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fed)) {
              try {
                get$val$27 = fed.get (this);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              get$val$27 = fed.get (this);
            }
// 96
            rtn = get$val$27;
// 97
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
              try {
                overseer.permit (rtn);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              overseer.permit (rtn);
            }
// 99
            return rtn;
          }
        }
// 101
        JP.go.ipa.oz.user.apl.fm.Pointer_if find$val$28;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fed)) {
          try {
            find$val$28 = fed.find (this);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          find$val$28 = fed.find (this);
        }
// 101
        JP.go.ipa.oz.user.apl.fm.Pointer_if newPtr = find$val$28;
// 102
        if (newPtr == null) {
// 103
          break;
        }
// 104
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
          try {
            overseer.permit (newPtr);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          overseer.permit (newPtr);
        }
// 105
        JP.go.ipa.oz.lib.standard._String_if getLocation$val$29;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) newPtr)) {
          try {
            getLocation$val$29 = newPtr.getLocation ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getLocation$val$29 = newPtr.getLocation ();
        }
// 105
        location = getLocation$val$29;
// 106
        JP.go.ipa.oz.lib.standard._String_if getName$val$30;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) newPtr)) {
          try {
            getName$val$30 = newPtr.getName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getName$val$30 = newPtr.getName ();
        }
// 106
        name = getName$val$30;
      }
    }
// 109
    return null;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getLocation () throws Exception  {
    checkSecureInvocation ();
// 43
    return location;
  }
  
  public Pointer_cl () throws Exception { super (); }
  
}


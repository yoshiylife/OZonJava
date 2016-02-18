package JP.go.ipa.oz.user.ide;

abstract public class CIMember_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.CIMember_if {
  protected JP.go.ipa.oz.user.ide.CIPart_if declaringPart;
  protected JP.go.ipa.oz.lib.standard._String_if name;
  protected JP.go.ipa.oz.user.ide.CIAccessLevel_if accessLevel;
  protected JP.go.ipa.oz.user.ide.CIModifier_if modifier;
  
  protected JP.go.ipa.oz.lib.standard._String_if type2String (JP.go.ipa.oz.user.ide.CIType_if type, JP.go.ipa.oz.user.ide.School_if school) throws Exception  {
// 98
    JP.go.ipa.oz.lib.standard._String_if str = null;
// 99
    JP.go.ipa.oz.lib.standard._String_if cid = null;
// 100
    JP.go.ipa.oz.user.ide.CIClassType_if classType = null;
    boolean bool$val$7;
    
// 102
    boolean isPrimitive$val$19;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) type)) {
      try {
        isPrimitive$val$19 = type.isPrimitive ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isPrimitive$val$19 = type.isPrimitive ();
    }
    bool$val$7 = isPrimitive$val$19;
    if (!bool$val$7) {
      bool$val$7 = school == null;
    }
// 102
    if (bool$val$7) {{
// 103
        JP.go.ipa.oz.lib.standard._String_if asString$val$20;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) type)) {
          try {
            asString$val$20 = type.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$20 = type.asString ();
        }
// 103
        str = asString$val$20;
      }
    } else {
// 104
      boolean isClass$val$21;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) type)) {
        try {
          isClass$val$21 = type.isClass ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isClass$val$21 = type.isClass ();
      }
// 104
      if (isClass$val$21) {{
// 105
          classType = (JP.go.ipa.oz.user.ide.CIClassType_if) (type);
// 106
          boolean isOzInternalClass$val$22;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classType)) {
            try {
              isOzInternalClass$val$22 = classType.isOzInternalClass ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            isOzInternalClass$val$22 = classType.isOzInternalClass ();
          }
// 106
          if (isOzInternalClass$val$22) {{
// 107
              JP.go.ipa.oz.lib.standard._String_if asString$val$23;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) type)) {
                try {
                  asString$val$23 = type.asString ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                asString$val$23 = type.asString ();
              }
// 107
              str = asString$val$23;
            }
          } else {{
// 109
              JP.go.ipa.oz.lib.standard._String_if getCID$val$24;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classType)) {
                try {
                  getCID$val$24 = classType.getCID ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getCID$val$24 = classType.getCID ();
              }
// 109
              cid = getCID$val$24;
// 110
              JP.go.ipa.oz.lib.standard._String_if getNameOfInterface$val$25;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
                try {
                  getNameOfInterface$val$25 = school.getNameOfInterface (cid);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getNameOfInterface$val$25 = school.getNameOfInterface (cid);
              }
// 110
              str = getNameOfInterface$val$25;
// 111
              if (str == null) {{
// 112
                  str = cid;
                }
              }
            }
          }
        }
      } else {{
// 117
          JP.go.ipa.oz.lib.standard._String_if asString$val$26;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) type)) {
            try {
              asString$val$26 = type.asString ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            asString$val$26 = type.asString ();
          }
// 117
          str = asString$val$26;
        }
      }
    }
// 120
    return str;
  }
  
  protected void initParams (JP.go.ipa.oz.user.ide.CIAccessLevel_if acc, JP.go.ipa.oz.user.ide.CIModifier_if mod, JP.go.ipa.oz.lib.standard._String_if name, JP.go.ipa.oz.user.ide.CIPart_if decPart) throws Exception  {
// 88
    ((JP.go.ipa.oz.user.ide.CIMember_cl)this).accessLevel = acc;
// 89
    ((JP.go.ipa.oz.user.ide.CIMember_cl)this).modifier = mod;
// 90
    ((JP.go.ipa.oz.user.ide.CIMember_cl)this).name = name;
// 91
    ((JP.go.ipa.oz.user.ide.CIMember_cl)this).declaringPart = decPart;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getModifierAsString () throws Exception  {
    checkSecureInvocation ();
// 36
    JP.go.ipa.oz.lib.standard._String_if asString$val$27;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) modifier)) {
      try {
        asString$val$27 = modifier.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$27 = modifier.asString ();
    }
// 36
    return asString$val$27;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getAccessLevelAsString () throws Exception  {
    checkSecureInvocation ();
// 29
    JP.go.ipa.oz.lib.standard._String_if asString$val$28;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) accessLevel)) {
      try {
        asString$val$28 = accessLevel.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$28 = accessLevel.asString ();
    }
// 29
    return asString$val$28;
  }
  
  public abstract boolean isConstructor () throws Exception  ;
  public abstract boolean isAttribute () throws Exception  ;
  protected JP.go.ipa.oz.lib.standard._String_if getPrefixAsString () throws Exception  {
// 71
    JP.go.ipa.oz.lib.standard._StringBuffer_if sb = null;
// 73
    sb = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 74
    sb.append (getAccessLevelAsString ());
// 75
    if ((sb.length ()) != 0) {{
// 76
        sb.append ((new JP.go.ipa.oz.lib.standard._String_cl(" ")));
      }
    }
// 78
    sb.append (getModifierAsString ());
// 80
    return sb.asString ();
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getName () throws Exception  {
    checkSecureInvocation ();
// 50
    return name;
  }
  
  public abstract boolean isMethod () throws Exception  ;
  public JP.go.ipa.oz.user.ide.CIPart_if getDeclaringPart () throws Exception  {
    checkSecureInvocation ();
// 43
    return declaringPart;
  }
  
  public abstract JP.go.ipa.oz.lib.standard._String_if asString (JP.go.ipa.oz.user.ide.School_if s) throws Exception  ;
  public CIMember_cl () throws Exception { super (); }
  
}


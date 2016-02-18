package JP.go.ipa.oz.user.ide;

final public class CIAttribute_cl extends JP.go.ipa.oz.user.ide.CIMember_cl implements JP.go.ipa.oz.user.ide.CIAttribute_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.user.ide.CIType_if type;
  
  public Object _new_newCIAttribute (JP.go.ipa.oz.user.ide.CIAccessLevel_if acc, JP.go.ipa.oz.user.ide.CIModifier_if mod, JP.go.ipa.oz.user.ide.CIType_if type, JP.go.ipa.oz.lib.standard._String_if name, JP.go.ipa.oz.user.ide.CIPart_if decPart) throws Exception  {
// 24
    super.initParams (acc, mod, name, decPart);
// 25
    ((JP.go.ipa.oz.user.ide.CIAttribute_cl)this).type = type;
    return this;
  }
  
  public boolean isFinal () throws Exception  {
    checkSecureInvocation ();
// 114
    boolean isFinal$val$29;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) modifier)) {
      try {
        isFinal$val$29 = modifier.isFinal ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isFinal$val$29 = modifier.isFinal ();
    }
// 114
    return isFinal$val$29;
  }
  
  public boolean isProtected () throws Exception  {
    checkSecureInvocation ();
// 128
    boolean isProtected$val$30;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) accessLevel)) {
      try {
        isProtected$val$30 = accessLevel.isProtected ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isProtected$val$30 = accessLevel.isProtected ();
    }
// 128
    return isProtected$val$30;
  }
  
  public JP.go.ipa.oz.user.ide.CIType_if getType () throws Exception  {
    checkSecureInvocation ();
// 79
    return type;
  }
  
  public boolean isConstructor () throws Exception  {
    checkSecureInvocation ();
// 107
    return false;
  }
  
  public boolean isAttribute () throws Exception  {
    checkSecureInvocation ();
// 100
    return true;
  }
  
  public boolean isMethod () throws Exception  {
    checkSecureInvocation ();
// 121
    return false;
  }
  
  public boolean isTransient () throws Exception  {
    checkSecureInvocation ();
// 135
    boolean isTransient$val$31;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) modifier)) {
      try {
        isTransient$val$31 = modifier.isTransient ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isTransient$val$31 = modifier.isTransient ();
    }
// 135
    return isTransient$val$31;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getTypeAsString (JP.go.ipa.oz.user.ide.School_if school) throws Exception  {
    checkSecureInvocation ();
// 93
    return type2String (type, school);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getTypeAsString () throws Exception  {
    checkSecureInvocation ();
// 86
    JP.go.ipa.oz.lib.standard._String_if asString$val$32;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) type)) {
      try {
        asString$val$32 = type.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$32 = type.asString ();
    }
// 86
    return asString$val$32;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if asString (JP.go.ipa.oz.user.ide.School_if school) throws Exception  {
    checkSecureInvocation ();
// 50
    JP.go.ipa.oz.lib.standard._String_if rv = null;
// 51
    JP.go.ipa.oz.lib.standard._StringBuffer_if sb = null;
// 52
    JP.go.ipa.oz.user.ide.CIClassType_if classType = null;
    boolean bool$val$8;
    
// 54
    boolean isPrimitive$val$33;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) type)) {
      try {
        isPrimitive$val$33 = type.isPrimitive ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isPrimitive$val$33 = type.isPrimitive ();
    }
    bool$val$8 = isPrimitive$val$33;
    if (!bool$val$8) {
      bool$val$8 = school == null;
    }
// 54
    if (bool$val$8) {{
// 55
        rv = asString ();
      }
    } else {{
// 57
        classType = (JP.go.ipa.oz.user.ide.CIClassType_if) (type);
// 58
        boolean isOzInternalClass$val$34;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classType)) {
          try {
            isOzInternalClass$val$34 = classType.isOzInternalClass ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isOzInternalClass$val$34 = classType.isOzInternalClass ();
        }
// 58
        if (isOzInternalClass$val$34) {{
// 59
            rv = asString ();
          }
        } else {{
// 61
            sb = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 62
            sb.append (getPrefixAsString ());
// 63
            if ((sb.length ()) != 0) {{
// 64
                sb.append ((new JP.go.ipa.oz.lib.standard._String_cl(" ")));
              }
            }
// 66
            JP.go.ipa.oz.lib.standard._String_if getCID$val$35;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classType)) {
              try {
                getCID$val$35 = classType.getCID ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getCID$val$35 = classType.getCID ();
            }
// 66
            JP.go.ipa.oz.lib.standard._String_if getNameOfInterface$val$36;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
              try {
                getNameOfInterface$val$36 = school.getNameOfInterface (getCID$val$35);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getNameOfInterface$val$36 = school.getNameOfInterface (getCID$val$35);
            }
// 66
            JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$37;
            append$val$37 = sb.append (getNameOfInterface$val$36);
// 67
            JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl(" "));
            
// 66
            JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$38;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$37)) {
              try {
                append$val$38 = append$val$37.append (string$2);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              append$val$38 = append$val$37.append (string$2);
            }
// 67
            JP.go.ipa.oz.lib.standard._String_if getName$val$39;
            getName$val$39 = getName ();
// 66
            JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$40;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$38)) {
              try {
                append$val$40 = append$val$38.append (getName$val$39);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              append$val$40 = append$val$38.append (getName$val$39);
            }
// 68
            rv = sb.asString ();
          }
        }
      }
    }
// 72
    return rv;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if asString () throws Exception  {
    checkSecureInvocation ();
// 34
    JP.go.ipa.oz.lib.standard._StringBuffer_if sb = null;
// 36
    sb = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 37
    sb.append (getPrefixAsString ());
// 38
    if ((sb.length ()) != 0) {{
// 39
        sb.append ((new JP.go.ipa.oz.lib.standard._String_cl(" ")));
      }
    }
// 41
    JP.go.ipa.oz.lib.standard._String_if asString$val$41;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) type)) {
      try {
        asString$val$41 = type.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$41 = type.asString ();
    }
// 41
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$42;
    append$val$42 = sb.append (asString$val$41);
// 41
    JP.go.ipa.oz.lib.standard._String_if string$3 = (new JP.go.ipa.oz.lib.standard._String_cl(" "));
    
// 41
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$43;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$42)) {
      try {
        append$val$43 = append$val$42.append (string$3);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$43 = append$val$42.append (string$3);
    }
// 41
    JP.go.ipa.oz.lib.standard._String_if getName$val$44;
    getName$val$44 = getName ();
// 41
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$45;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$43)) {
      try {
        append$val$45 = append$val$43.append (getName$val$44);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$45 = append$val$43.append (getName$val$44);
    }
// 43
    return sb.asString ();
  }
  
  public CIAttribute_cl () throws Exception { super (); }
  
}


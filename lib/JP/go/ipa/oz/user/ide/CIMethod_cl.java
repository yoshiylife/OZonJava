package JP.go.ipa.oz.user.ide;

public class CIMethod_cl extends JP.go.ipa.oz.user.ide.CIMember_cl implements JP.go.ipa.oz.user.ide.CIMethod_if {
  protected boolean iAmConstructor;
  protected JP.go.ipa.oz.lib.standard._Sequence_if argTypeList;
  protected JP.go.ipa.oz.user.ide.CIType_if returnType;
  
  public Object _new_newCIMethod (JP.go.ipa.oz.user.ide.CIAccessLevel_if acc, JP.go.ipa.oz.user.ide.CIModifier_if mod, JP.go.ipa.oz.user.ide.CIType_if retType, JP.go.ipa.oz.lib.standard._String_if name, JP.go.ipa.oz.lib.standard._Sequence_if argTypeList, JP.go.ipa.oz.user.ide.CIPart_if decPart) throws Exception  {
// 26
    super.initParams (acc, mod, name, decPart);
// 27
    ((JP.go.ipa.oz.user.ide.CIMethod_cl)this).returnType = retType;
// 28
    ((JP.go.ipa.oz.user.ide.CIMethod_cl)this).argTypeList = argTypeList;
// 29
    ((JP.go.ipa.oz.user.ide.CIMethod_cl)this).iAmConstructor = false;
    return this;
  }
  
  public Object _new_newCIConstructor (JP.go.ipa.oz.lib.standard._String_if name, JP.go.ipa.oz.lib.standard._Sequence_if argTypeList, JP.go.ipa.oz.user.ide.CIPart_if decPart) throws Exception  {
// 36
    JP.go.ipa.oz.user.ide.CIAccessLevel_if acc = null;
// 37
    JP.go.ipa.oz.user.ide.CIModifier_if mod = null;
// 38
    JP.go.ipa.oz.user.ide.CIConstructorType_if cnstType = null;
// 40
    acc = (JP.go.ipa.oz.user.ide.CIAccessLevel_cl) (new JP.go.ipa.oz.user.ide.CIAccessLevel_cl ())._new_newCIAccessLevel (0);
// 41
    mod = (JP.go.ipa.oz.user.ide.CIModifier_cl) (new JP.go.ipa.oz.user.ide.CIModifier_cl ())._new_newCIModifier (0);
// 42
    super.initParams (acc, mod, name, decPart);
// 43
    cnstType = (JP.go.ipa.oz.user.ide.CIConstructorType_cl) (new JP.go.ipa.oz.user.ide.CIConstructorType_cl ())._new_newCIConstructorType ();
// 44
    ((JP.go.ipa.oz.user.ide.CIMethod_cl)this).returnType = cnstType;
// 45
    ((JP.go.ipa.oz.user.ide.CIMethod_cl)this).argTypeList = argTypeList;
// 46
    ((JP.go.ipa.oz.user.ide.CIMethod_cl)this).iAmConstructor = true;
    return this;
  }
  
  public boolean isFinal () throws Exception  {
    checkSecureInvocation ();
// 222
    boolean isFinal$val$77;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) modifier)) {
      try {
        isFinal$val$77 = modifier.isFinal ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isFinal$val$77 = modifier.isFinal ();
    }
// 222
    return isFinal$val$77;
  }
  
  public boolean isStatic () throws Exception  {
    checkSecureInvocation ();
// 250
    boolean isStatic$val$78;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) modifier)) {
      try {
        isStatic$val$78 = modifier.isStatic ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isStatic$val$78 = modifier.isStatic ();
    }
// 250
    return isStatic$val$78;
  }
  
  public JP.go.ipa.oz.user.ide.CIType_if getReturnType () throws Exception  {
    checkSecureInvocation ();
// 201
    return returnType;
  }
  
  public boolean isConstructor () throws Exception  {
    checkSecureInvocation ();
// 215
    return iAmConstructor;
  }
  
  public boolean isAttribute () throws Exception  {
    checkSecureInvocation ();
// 208
    return false;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getReturnTypeAsString (JP.go.ipa.oz.user.ide.School_if school) throws Exception  {
    checkSecureInvocation ();
// 194
    return type2String (returnType, school);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getReturnTypeAsString () throws Exception  {
    checkSecureInvocation ();
// 187
    JP.go.ipa.oz.lib.standard._String_if asString$val$79;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) returnType)) {
      try {
        asString$val$79 = returnType.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$79 = returnType.asString ();
    }
// 187
    return asString$val$79;
  }
  
  public boolean isPublic () throws Exception  {
    checkSecureInvocation ();
// 243
    boolean isPublic$val$80;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) accessLevel)) {
      try {
        isPublic$val$80 = accessLevel.isPublic ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isPublic$val$80 = accessLevel.isPublic ();
    }
// 243
    return isPublic$val$80;
  }
  
  public boolean isMethod () throws Exception  {
    checkSecureInvocation ();
// 229
    return !(iAmConstructor);
  }
  
  public boolean isOnce () throws Exception  {
    checkSecureInvocation ();
// 236
    boolean isOnce$val$81;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) modifier)) {
      try {
        isOnce$val$81 = modifier.isOnce ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isOnce$val$81 = modifier.isOnce ();
    }
// 236
    return isOnce$val$81;
  }
  
  public JP.go.ipa.oz.lib.standard._Iterator_if argumentTypes () throws Exception  {
    checkSecureInvocation ();
// 55
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$82;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) argTypeList)) {
      try {
        iterator$val$82 = argTypeList.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$82 = argTypeList.iterator ();
    }
// 55
    return iterator$val$82;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getArgumentTypeAsString (JP.go.ipa.oz.user.ide.School_if school) throws Exception  {
    checkSecureInvocation ();
// 139
    JP.go.ipa.oz.lib.standard._String_if str = null, strType = null;
// 140
    JP.go.ipa.oz.lib.standard._StringBuffer_if sb = null;
// 141
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 142
    int i = 0;
// 143
    JP.go.ipa.oz.user.ide.CIType_if type = null;
// 144
    JP.go.ipa.oz.user.ide.CIClassType_if classType = null;
// 146
    if (school == null) {{
// 147
        str = getReturnTypeAsString ();
      }
    } else {{
// 150
        sb = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 151
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$83;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) argTypeList)) {
          try {
            iterator$val$83 = argTypeList.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$83 = argTypeList.iterator ();
        }
// 151
        itr = iterator$val$83;
// 152
        /* for loop starting here */ {
          /* initialization part */
// 152
          i = 0;
          
          for (;;) {
            /* boolean expression part */
// 152
            boolean hasMoreElements$val$84;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
              try {
                hasMoreElements$val$84 = itr.hasMoreElements ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              hasMoreElements$val$84 = itr.hasMoreElements ();
            }
            if (!(hasMoreElements$val$84)) break;
            
            /* body */ _loop_1: {
// 153
              if (i != 0) {{
// 154
                  sb.append ((new JP.go.ipa.oz.lib.standard._String_cl(", ")));
                }
              }
// 156
              JP.go.ipa.oz.lang._Root_if nextElement$val$85;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
                try {
                  nextElement$val$85 = itr.nextElement ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                nextElement$val$85 = itr.nextElement ();
              }
// 156
              type = (JP.go.ipa.oz.user.ide.CIType_if) (nextElement$val$85);
// 157
              sb.append (type2String (type, school));
            }
            /* iteration part */
// 152
            i++;
          }
        }
// 177
        str = sb.asString ();
      }
    }
// 180
    return str;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getArgumentTypeAsString () throws Exception  {
    checkSecureInvocation ();
// 117
    JP.go.ipa.oz.lib.standard._StringBuffer_if sb = null;
// 118
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 119
    int i = 0;
// 120
    JP.go.ipa.oz.user.ide.CIType_if type = null;
// 122
    sb = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 123
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$86;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) argTypeList)) {
      try {
        iterator$val$86 = argTypeList.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$86 = argTypeList.iterator ();
    }
// 123
    itr = iterator$val$86;
// 124
    /* for loop starting here */ {
      /* initialization part */
// 124
      i = 0;
      
      for (;;) {
        /* boolean expression part */
// 124
        boolean hasMoreElements$val$87;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
          try {
            hasMoreElements$val$87 = itr.hasMoreElements ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          hasMoreElements$val$87 = itr.hasMoreElements ();
        }
        if (!(hasMoreElements$val$87)) break;
        
        /* body */ _loop_1: {
// 125
          if (i != 0) {{
// 126
              sb.append ((new JP.go.ipa.oz.lib.standard._String_cl(", ")));
            }
          }
// 128
          JP.go.ipa.oz.lang._Root_if nextElement$val$88;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
            try {
              nextElement$val$88 = itr.nextElement ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nextElement$val$88 = itr.nextElement ();
          }
// 128
          type = (JP.go.ipa.oz.user.ide.CIType_if) (nextElement$val$88);
// 129
          JP.go.ipa.oz.lib.standard._String_if asString$val$89;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) type)) {
            try {
              asString$val$89 = type.asString ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            asString$val$89 = type.asString ();
          }
// 129
          sb.append (asString$val$89);
        }
        /* iteration part */
// 124
        i++;
      }
    }
// 132
    return sb.asString ();
  }
  
  public JP.go.ipa.oz.lib.standard._String_if asString (JP.go.ipa.oz.user.ide.School_if school) throws Exception  {
    checkSecureInvocation ();
// 85
    JP.go.ipa.oz.lib.standard._String_if rv = null;
// 86
    JP.go.ipa.oz.lib.standard._StringBuffer_if sb = null;
// 87
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 88
    JP.go.ipa.oz.user.ide.CIType_if type = null;
// 89
    JP.go.ipa.oz.user.ide.CIClassType_if classType = null;
// 90
    int i = 0;
// 92
    if (school == null) {{
// 93
        rv = asString ();
      }
    } else {{
// 96
        sb = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 97
        if (isMethod ()) {{
// 98
            sb.append (getPrefixAsString ());
// 99
            if ((sb.length ()) != 0) {{
// 100
                sb.append ((new JP.go.ipa.oz.lib.standard._String_cl(" ")));
              }
            }
// 102
            JP.go.ipa.oz.lib.standard._String_if getReturnTypeAsString$val$90;
            getReturnTypeAsString$val$90 = getReturnTypeAsString (school);
// 102
            JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$91;
            append$val$91 = sb.append (getReturnTypeAsString$val$90);
// 102
            JP.go.ipa.oz.lib.standard._String_if string$4 = (new JP.go.ipa.oz.lib.standard._String_cl(" "));
            
// 102
            JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$92;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$91)) {
              try {
                append$val$92 = append$val$91.append (string$4);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              append$val$92 = append$val$91.append (string$4);
            }
          }
        }
// 105
        JP.go.ipa.oz.lib.standard._String_if getName$val$93;
        getName$val$93 = getName ();
// 105
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$94;
        append$val$94 = sb.append (getName$val$93);
// 106
        JP.go.ipa.oz.lib.standard._String_if string$5 = (new JP.go.ipa.oz.lib.standard._String_cl("("));
        
// 105
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$95;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$94)) {
          try {
            append$val$95 = append$val$94.append (string$5);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$95 = append$val$94.append (string$5);
        }
// 106
        JP.go.ipa.oz.lib.standard._String_if getArgumentTypeAsString$val$96;
        getArgumentTypeAsString$val$96 = getArgumentTypeAsString (school);
// 105
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$97;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$95)) {
          try {
            append$val$97 = append$val$95.append (getArgumentTypeAsString$val$96);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$97 = append$val$95.append (getArgumentTypeAsString$val$96);
        }
// 106
        JP.go.ipa.oz.lib.standard._String_if string$6 = (new JP.go.ipa.oz.lib.standard._String_cl(")"));
        
// 105
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$98;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$97)) {
          try {
            append$val$98 = append$val$97.append (string$6);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$98 = append$val$97.append (string$6);
        }
// 107
        rv = sb.asString ();
      }
    }
// 110
    return rv;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if asString () throws Exception  {
    checkSecureInvocation ();
// 62
    JP.go.ipa.oz.lib.standard._StringBuffer_if sb = null;
// 63
    JP.go.ipa.oz.user.ide.CIType_if type = null;
// 64
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 65
    int i = 0;
// 67
    sb = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 68
    if (isMethod ()) {{
// 69
        sb.append (getPrefixAsString ());
// 70
        if ((sb.length ()) != 0) {{
// 71
            sb.append ((new JP.go.ipa.oz.lib.standard._String_cl(" ")));
          }
        }
// 73
        JP.go.ipa.oz.lib.standard._String_if asString$val$99;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) returnType)) {
          try {
            asString$val$99 = returnType.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$99 = returnType.asString ();
        }
// 73
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$100;
        append$val$100 = sb.append (asString$val$99);
// 73
        JP.go.ipa.oz.lib.standard._String_if string$7 = (new JP.go.ipa.oz.lib.standard._String_cl(" "));
        
// 73
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$101;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$100)) {
          try {
            append$val$101 = append$val$100.append (string$7);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$101 = append$val$100.append (string$7);
        }
      }
    }
// 75
    JP.go.ipa.oz.lib.standard._String_if getName$val$102;
    getName$val$102 = getName ();
// 75
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$103;
    append$val$103 = sb.append (getName$val$102);
// 76
    JP.go.ipa.oz.lib.standard._String_if string$8 = (new JP.go.ipa.oz.lib.standard._String_cl("("));
    
// 75
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$104;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$103)) {
      try {
        append$val$104 = append$val$103.append (string$8);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$104 = append$val$103.append (string$8);
    }
// 76
    JP.go.ipa.oz.lib.standard._String_if getArgumentTypeAsString$val$105;
    getArgumentTypeAsString$val$105 = getArgumentTypeAsString ();
// 75
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$106;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$104)) {
      try {
        append$val$106 = append$val$104.append (getArgumentTypeAsString$val$105);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$106 = append$val$104.append (getArgumentTypeAsString$val$105);
    }
// 76
    JP.go.ipa.oz.lib.standard._String_if string$9 = (new JP.go.ipa.oz.lib.standard._String_cl(")"));
    
// 75
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$107;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) append$val$106)) {
      try {
        append$val$107 = append$val$106.append (string$9);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$107 = append$val$106.append (string$9);
    }
// 78
    return sb.asString ();
  }
  
  public CIMethod_cl () throws Exception { super (); }
  
}


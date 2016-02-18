package JP.go.ipa.oz.user.ide;

final public class CIPrimitiveType_cl extends JP.go.ipa.oz.user.ide.CIType_cl implements JP.go.ipa.oz.user.ide.CIPrimitiveType_if {
  static final boolean _final_ = true;
  char CHARACTER;
  char DOUBLE;
  char BOOLEAN;
  char CONDITION;
  char FLOAT;
  char LONG;
  char BYTE;
  char SHORT;
  char INTEGER;
  char VOID;
  
  public Object _new_newDoubleType () throws Exception  {
// 78
    init ();
// 79
    typeCode = DOUBLE;
    return this;
  }
  
  public Object _new_newConditionType () throws Exception  {
// 102
    init ();
// 103
    typeCode = CONDITION;
    return this;
  }
  
  public Object _new_newIntegerType () throws Exception  {
// 54
    init ();
// 55
    typeCode = INTEGER;
    return this;
  }
  
  public Object _new_newShortType () throws Exception  {
// 46
    init ();
// 47
    typeCode = SHORT;
    return this;
  }
  
  public Object _new_newCharacterType () throws Exception  {
// 86
    init ();
// 87
    typeCode = CHARACTER;
    return this;
  }
  
  public Object _new_newByteType () throws Exception  {
// 38
    init ();
// 39
    typeCode = BYTE;
    return this;
  }
  
  public Object _new_newFloatType () throws Exception  {
// 70
    init ();
// 71
    typeCode = FLOAT;
    return this;
  }
  
  public Object _new_newVoidType () throws Exception  {
// 30
    init ();
// 31
    typeCode = VOID;
    return this;
  }
  
  public Object _new_newBooleanType () throws Exception  {
// 94
    init ();
// 95
    typeCode = BOOLEAN;
    return this;
  }
  
  public Object _new_newLongType () throws Exception  {
// 62
    init ();
// 63
    typeCode = LONG;
    return this;
  }
  
  public boolean isBoolean () throws Exception  {
    checkSecureInvocation ();
// 199
    return typeIs (BOOLEAN);
  }
  
  public boolean isLong () throws Exception  {
    checkSecureInvocation ();
// 171
    return typeIs (LONG);
  }
  
  public boolean isPrimitive () throws Exception  {
    checkSecureInvocation ();
// 220
    return true;
  }
  
  public boolean isCondition () throws Exception  {
    checkSecureInvocation ();
// 206
    return typeIs (CONDITION);
  }
  
  public boolean isByte () throws Exception  {
    checkSecureInvocation ();
// 150
    return typeIs (BYTE);
  }
  
  boolean typeIs (char code) throws Exception  {
// 245
    return (typeCode == code);
  }
  
  public boolean isFloat () throws Exception  {
    checkSecureInvocation ();
// 178
    return typeIs (FLOAT);
  }
  
  void init () throws Exception  {
// 229
    VOID = 'V';
// 230
    BYTE = 'B';
// 231
    SHORT = 'S';
// 232
    INTEGER = 'I';
// 233
    LONG = 'J';
// 234
    FLOAT = 'F';
// 235
    DOUBLE = 'D';
// 236
    CHARACTER = 'C';
// 237
    BOOLEAN = 'Z';
// 238
    CONDITION = 'N';
  }
  
  public boolean isClass () throws Exception  {
    checkSecureInvocation ();
// 213
    return false;
  }
  
  public boolean isShort () throws Exception  {
    checkSecureInvocation ();
// 157
    return typeIs (SHORT);
  }
  
  public boolean isVoid () throws Exception  {
    checkSecureInvocation ();
// 143
    return typeIs (VOID);
  }
  
  public boolean isInteger () throws Exception  {
    checkSecureInvocation ();
// 164
    return typeIs (INTEGER);
  }
  
  public boolean isCharacter () throws Exception  {
    checkSecureInvocation ();
// 192
    return typeIs (CHARACTER);
  }
  
  public boolean isDouble () throws Exception  {
    checkSecureInvocation ();
// 185
    return typeIs (DOUBLE);
  }
  
  public JP.go.ipa.oz.lib.standard._String_if asString () throws Exception  {
    checkSecureInvocation ();
// 112
    if (typeCode == VOID) {{
// 113
        return (new JP.go.ipa.oz.lib.standard._String_cl("void"));
      }
    } else {
// 114
      if (typeCode == BYTE) {{
// 115
          return (new JP.go.ipa.oz.lib.standard._String_cl("byte"));
        }
      } else {
// 116
        if (typeCode == SHORT) {{
// 117
            return (new JP.go.ipa.oz.lib.standard._String_cl("short"));
          }
        } else {
// 118
          if (typeCode == INTEGER) {{
// 119
              return (new JP.go.ipa.oz.lib.standard._String_cl("int"));
            }
          } else {
// 120
            if (typeCode == LONG) {{
// 121
                return (new JP.go.ipa.oz.lib.standard._String_cl("long"));
              }
            } else {
// 122
              if (typeCode == FLOAT) {{
// 123
                  return (new JP.go.ipa.oz.lib.standard._String_cl("float"));
                }
              } else {
// 124
                if (typeCode == DOUBLE) {{
// 125
                    return (new JP.go.ipa.oz.lib.standard._String_cl("double"));
                  }
                } else {
// 126
                  if (typeCode == CHARACTER) {{
// 127
                      return (new JP.go.ipa.oz.lib.standard._String_cl("character"));
                    }
                  } else {
// 128
                    if (typeCode == BOOLEAN) {{
// 129
                        return (new JP.go.ipa.oz.lib.standard._String_cl("boolean"));
                      }
                    } else {
// 130
                      if (typeCode == CONDITION) {{
// 131
                          return (new JP.go.ipa.oz.lib.standard._String_cl("condition"));
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
// 134
    JP.go.ipa.oz.user.ide.CIException_if ex = null;
// 135
    ex = (JP.go.ipa.oz.user.ide.CIException_cl) (new JP.go.ipa.oz.user.ide.CIException_cl ())._new_newCIException ((new JP.go.ipa.oz.lib.standard._String_cl("unknown type code")));
// 136
    throw new JP.go.ipa.oz.lang.OzException (ex);
  }
  
  public CIPrimitiveType_cl () throws Exception { super (); }
  
}


package JP.go.ipa.oz.user.ide;

final public class CIModifier_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.CIModifier_if {
  static final boolean _final_ = true;
  boolean iAmStatic;
  boolean iAmTransient;
  boolean iAmAbstract;
  boolean iAmFinal;
  int UPPER;
  boolean iAmOnce;
  boolean iAmCell;
  boolean iAmLocked;
  
  public Object _new_newCIModifier (int mods) throws Exception  {
// 29
    initParams (mods);
    return this;
  }
  
  void initParams (int mods) throws Exception  {
// 127
    int quot = 0, remain = 0;
// 129
    UPPER = 0x4000;
// 130
    quot = mods % UPPER;
// 132
    quot = quot / 2;
// 133
    quot = quot / 2;
// 134
    quot = quot / 2;
// 135
    remain = quot % 2;
// 136
    if (remain == 1) {{
// 136
        iAmStatic = true;
      }
    }
// 137
    quot = quot / 2;
// 138
    remain = quot % 2;
// 139
    if (remain == 1) {{
// 139
        iAmFinal = true;
      }
    }
// 140
    quot = quot / 2;
// 141
    remain = quot % 2;
// 142
    if (remain == 1) {{
// 142
        iAmLocked = true;
      }
    }
// 143
    quot = quot / 2;
// 144
    quot = quot / 2;
// 145
    remain = quot % 2;
// 146
    if (remain == 1) {{
// 146
        iAmTransient = true;
      }
    }
// 147
    quot = quot / 2;
// 148
    quot = quot / 2;
// 149
    quot = quot / 2;
// 150
    remain = quot % 2;
// 151
    if (remain == 1) {{
// 151
        iAmAbstract = true;
      }
    }
// 152
    quot = quot / 2;
// 153
    quot = quot / 2;
// 154
    remain = quot % 2;
// 155
    if (remain == 1) {{
// 155
        iAmOnce = true;
      }
    }
// 156
    quot = quot / 2;
// 157
    remain = quot % 2;
// 158
    if (remain == 1) {{
// 158
        iAmCell = true;
      }
    }
  }
  
  public boolean isFinal () throws Exception  {
    checkSecureInvocation ();
// 83
    return iAmFinal;
  }
  
  public boolean isStatic () throws Exception  {
    checkSecureInvocation ();
// 76
    return iAmStatic;
  }
  
  public boolean isAbstract () throws Exception  {
    checkSecureInvocation ();
// 104
    return iAmAbstract;
  }
  
  public boolean isOnce () throws Exception  {
    checkSecureInvocation ();
// 111
    return iAmOnce;
  }
  
  public boolean isCell () throws Exception  {
    checkSecureInvocation ();
// 118
    return iAmCell;
  }
  
  public boolean isTransient () throws Exception  {
    checkSecureInvocation ();
// 97
    return iAmTransient;
  }
  
  public boolean isLocked () throws Exception  {
    checkSecureInvocation ();
// 90
    return iAmLocked;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if asString () throws Exception  {
    checkSecureInvocation ();
// 38
    JP.go.ipa.oz.lib.standard._StringBuffer_if sb = null;
// 39
    int length = 0;
// 41
    sb = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 42
    if (iAmAbstract) {{
// 43
        sb.append ((new JP.go.ipa.oz.lib.standard._String_cl("abstract ")));
      }
    }
// 45
    if (iAmStatic) {{
// 46
        sb.append ((new JP.go.ipa.oz.lib.standard._String_cl("static ")));
      }
    }
// 48
    if (iAmFinal) {{
// 49
        sb.append ((new JP.go.ipa.oz.lib.standard._String_cl("final ")));
      }
    }
// 51
    if (iAmLocked) {{
// 52
        sb.append ((new JP.go.ipa.oz.lib.standard._String_cl("locked ")));
      }
    }
// 54
    if (iAmTransient) {{
// 55
        sb.append ((new JP.go.ipa.oz.lib.standard._String_cl("transient ")));
      }
    }
// 57
    if (iAmOnce) {{
// 58
        sb.append ((new JP.go.ipa.oz.lib.standard._String_cl("once ")));
      }
    }
// 60
    if (iAmCell) {{
// 61
        sb.append ((new JP.go.ipa.oz.lib.standard._String_cl("cell ")));
      }
    }
// 64
    length = sb.length ();
    boolean bool$val$6;
    
    bool$val$6 = length != 0;
    if (bool$val$6) {
      bool$val$6 = sb.charAt (length - 1) == ' ';
    }
// 65
    if (bool$val$6) {{
// 66
        sb.setLength (length - 1);
      }
    }
// 69
    return sb.asString ();
  }
  
  public CIModifier_cl () throws Exception { super (); }
  
}


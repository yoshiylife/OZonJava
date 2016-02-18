package JP.go.ipa.oz.user.apl.fm;

public class Person_cl extends JP.go.ipa.oz.user.apl.fm.Actor_cl implements JP.go.ipa.oz.user.apl.fm.Person_if {
  JP.go.ipa.oz.lib.standard._Date_if birthDay;
  JP.go.ipa.oz.lib.standard._String_if bloodType;
  
  public Object _new_create (JP.go.ipa.oz.user.apl.fm.Person_if p) throws Exception  {
// 95
    super._new_create (p);
// 96
    JP.go.ipa.oz.lib.standard._String_if getBloodType$val$330;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) p)) {
      try {
        getBloodType$val$330 = p.getBloodType ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBloodType$val$330 = p.getBloodType ();
    }
// 96
    JP.go.ipa.oz.lib.standard._String_if pbloodType = getBloodType$val$330;
// 97
    if (pbloodType != null) {{
// 98
        bloodType = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (getBloodType ());
      }
    }
// 100
    JP.go.ipa.oz.lib.standard._Date_if getBirthDay$val$331;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) p)) {
      try {
        getBirthDay$val$331 = p.getBirthDay ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBirthDay$val$331 = p.getBirthDay ();
    }
// 100
    JP.go.ipa.oz.lib.standard._Date_if pbirthDay = getBirthDay$val$331;
// 101
    if (pbirthDay != null) {{
// 102
        long getTime$val$332;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pbirthDay)) {
          try {
            getTime$val$332 = pbirthDay.getTime ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getTime$val$332 = pbirthDay.getTime ();
        }
// 102
        birthDay = (JP.go.ipa.oz.lib.standard._Date_cl) (new JP.go.ipa.oz.lib.standard._Date_cl ())._new_breed (getTime$val$332);
      }
    }
    return this;
  }
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if nam) throws Exception  {
// 17
    super._new_create (nam);
    return this;
  }
  
  public Object _new_create () throws Exception  {
// 13
    super._new_create ();
    return this;
  }
  
  public boolean isEqualFMObject (JP.go.ipa.oz.user.apl.fm.FMObject_if obj) throws Exception  {
    checkSecureInvocation ();
// 41
    if (obj == null) {
// 41
      return false;
    }
// 42
    JP.go.ipa.oz.user.apl.fm.Person_if p = null;
// 42
    p = (JP.go.ipa.oz.user.apl.fm.Person_if) (obj);
// 43
    if (!super.isEqualFMObject (p)) {{
// 44
        return false;
      }
    }
// 46
    JP.go.ipa.oz.lib.standard._String_if getBloodType$val$333;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) p)) {
      try {
        getBloodType$val$333 = p.getBloodType ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBloodType$val$333 = p.getBloodType ();
    }
// 46
    JP.go.ipa.oz.lib.standard._String_if obloodType = getBloodType$val$333;
// 47
    if (bloodType == null) {{
// 48
        if (obloodType != null) {
// 48
          return false;
        }
      }
    } else {
// 49
      boolean isequal$val$334;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bloodType)) {
        try {
          isequal$val$334 = bloodType.isequal (obloodType);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$334 = bloodType.isequal (obloodType);
      }
// 49
      if (!isequal$val$334) {{
// 50
          return false;
        }
      }
    }
// 52
    JP.go.ipa.oz.lib.standard._Date_if getBirthDay$val$335;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) p)) {
      try {
        getBirthDay$val$335 = p.getBirthDay ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBirthDay$val$335 = p.getBirthDay ();
    }
// 52
    JP.go.ipa.oz.lib.standard._Date_if obirthDay = getBirthDay$val$335;
// 53
    if (birthDay == null) {{
// 54
        if (obirthDay != null) {
// 54
          return false;
        }
      }
    } else {
// 55
      boolean isEqualDate$val$336;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) birthDay)) {
        try {
          isEqualDate$val$336 = birthDay.isEqualDate (obirthDay);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isEqualDate$val$336 = birthDay.isEqualDate (obirthDay);
      }
// 55
      if (!isEqualDate$val$336) {{
// 56
          return false;
        }
      }
    }
// 58
    return true;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getBloodType () throws Exception  {
    checkSecureInvocation ();
// 29
    return bloodType;
  }
  
  public void init (JP.go.ipa.oz.lib.standard._String_if btype, JP.go.ipa.oz.lib.standard._Date_if birth) throws Exception  {
    checkSecureInvocation ();
// 21
    bloodType = btype;
// 22
    birthDay = birth;
  }
  
  public void trace (int mark) throws Exception  {
    checkSecureInvocation ();
// 107
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 108
    JP.go.ipa.oz.lib.standard._PrintWriter_if getStdout$val$337;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getStdout$val$337 = system.getStdout ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getStdout$val$337 = system.getStdout ();
    }
// 108
    JP.go.ipa.oz.lib.standard._PrintWriter_if pw = (JP.go.ipa.oz.lib.standard._PrintWriter_cl) (new JP.go.ipa.oz.lib.standard._PrintWriter_cl ())._new_breed (getStdout$val$337, true);
// 109
    JP.go.ipa.oz.lib.standard._String_if string$47 = (new JP.go.ipa.oz.lib.standard._String_cl("Person#trace("));
    
// 109
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (string$47);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (string$47);
    }
// 110
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (mark);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (mark);
    }
// 111
    JP.go.ipa.oz.lib.standard._String_if string$48 = (new JP.go.ipa.oz.lib.standard._String_cl(")"));
    
// 111
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.println (string$48);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.println (string$48);
    }
// 112
    JP.go.ipa.oz.lib.standard._String_if string$49 = (new JP.go.ipa.oz.lib.standard._String_cl("bloodType:"));
    
// 112
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (string$49);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (string$49);
    }
// 113
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.println (bloodType == null ? (new JP.go.ipa.oz.lib.standard._String_cl("null")) : bloodType);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.println (bloodType == null ? (new JP.go.ipa.oz.lib.standard._String_cl("null")) : bloodType);
    }
// 114
    JP.go.ipa.oz.lib.standard._String_if string$50 = (new JP.go.ipa.oz.lib.standard._String_cl("birthDay:"));
    
// 114
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (string$50);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (string$50);
    }
// 115
    JP.go.ipa.oz.lib.standard._String_if _conditional_val_3;
    if (birthDay == null) {
      _conditional_val_3 = (new JP.go.ipa.oz.lib.standard._String_cl("null"));
    } else {
// 115
      JP.go.ipa.oz.lib.standard._String_if asString$val$338;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) birthDay)) {
        try {
          asString$val$338 = birthDay.asString ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        asString$val$338 = birthDay.asString ();
      }
      _conditional_val_3 = asString$val$338;
    }
// 115
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.println (_conditional_val_3);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.println (_conditional_val_3);
    }
// 116
    JP.go.ipa.oz.lib.standard._String_if string$51 = (new JP.go.ipa.oz.lib.standard._String_cl("---- super ----"));
    
// 116
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.println (string$51);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.println (string$51);
    }
// 117
    super.trace (mark);
  }
  
  public JP.go.ipa.oz.user.apl.fm.FMObject_if cloneSelf () throws Exception  {
    checkSecureInvocation ();
// 90
    JP.go.ipa.oz.user.apl.fm.Person_if clone = (JP.go.ipa.oz.user.apl.fm.Person_cl) (new JP.go.ipa.oz.user.apl.fm.Person_cl ())._new_create (this);
// 91
    return clone;
  }
  
  public int update (JP.go.ipa.oz.user.apl.fm.FMObject_if obj) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 63
      JP.go.ipa.oz.user.apl.fm.Person_if p = null;
// 63
      p = (JP.go.ipa.oz.user.apl.fm.Person_if) (obj);
// 64
      int counter = updateWithoutLock (p);
// 65
      JP.go.ipa.oz.lib.standard._String_if getBloodType$val$339;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) p)) {
        try {
          getBloodType$val$339 = p.getBloodType ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getBloodType$val$339 = p.getBloodType ();
      }
// 65
      JP.go.ipa.oz.lib.standard._String_if obloodType = getBloodType$val$339;
// 66
      if (bloodType == null) {{
// 67
          if (obloodType != null) {{
// 68
              bloodType = obloodType;
// 69
              counter++;
            }
          }
        }
      } else {
// 71
        boolean isequal$val$340;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bloodType)) {
          try {
            isequal$val$340 = bloodType.isequal (obloodType);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$340 = bloodType.isequal (obloodType);
        }
// 71
        if (!isequal$val$340) {{
// 72
            bloodType = obloodType;
// 73
            counter++;
          }
        }
      }
// 75
      JP.go.ipa.oz.lib.standard._Date_if getBirthDay$val$341;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) p)) {
        try {
          getBirthDay$val$341 = p.getBirthDay ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getBirthDay$val$341 = p.getBirthDay ();
      }
// 75
      JP.go.ipa.oz.lib.standard._Date_if obirthDay = getBirthDay$val$341;
// 76
      if (birthDay == null) {{
// 77
          if (obirthDay != null) {{
// 78
              birthDay = obirthDay;
// 79
              counter++;
            }
          }
        }
      } else {
// 81
        boolean isEqualDate$val$342;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) birthDay)) {
          try {
            isEqualDate$val$342 = birthDay.isEqualDate (obirthDay);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isEqualDate$val$342 = birthDay.isEqualDate (obirthDay);
        }
// 81
        if (!isEqualDate$val$342) {{
// 82
            birthDay = obirthDay;
// 83
            counter++;
          }
        }
      }
// 85
      return counter;
    } finally {
      leave ();
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Date_if getBirthDay () throws Exception  {
    checkSecureInvocation ();
// 36
    return birthDay;
  }
  
  public Person_cl () throws Exception { super (); }
  
}


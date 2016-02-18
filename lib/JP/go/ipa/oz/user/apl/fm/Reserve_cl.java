package JP.go.ipa.oz.user.apl.fm;

public class Reserve_cl extends JP.go.ipa.oz.user.apl.fm.Relation_cl implements JP.go.ipa.oz.user.apl.fm.Reserve_if {
  int state;
  int startMinute;
  int startHour;
  int endMinute;
  int endHour;
  int day;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if nam) throws Exception  {
// 23
    super._new_create ();
// 24
    setName (nam);
// 25
    setState ((new JP.go.ipa.oz.lib.standard._String_cl("prereserve")));
    return this;
  }
  
  public Object _new_create () throws Exception  {
// 17
    super._new_create ();
// 18
    setName ((new JP.go.ipa.oz.lib.standard._String_cl("Unknown Reserve")));
// 19
    setState ((new JP.go.ipa.oz.lib.standard._String_cl("prereserve")));
    return this;
  }
  
  public void setState (JP.go.ipa.oz.lib.standard._String_if stat) throws Exception  {
    checkSecureInvocation ();
// 168
    JP.go.ipa.oz.lib.standard._String_if string$52 = (new JP.go.ipa.oz.lib.standard._String_cl("prereserve"));
    
// 168
    boolean equalsIgnoreCase$val$400;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) stat)) {
      try {
        equalsIgnoreCase$val$400 = stat.equalsIgnoreCase (string$52);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      equalsIgnoreCase$val$400 = stat.equalsIgnoreCase (string$52);
    }
// 168
    if (equalsIgnoreCase$val$400) {{
// 169
        setState (0);
      }
    } else {
// 170
      JP.go.ipa.oz.lib.standard._String_if string$53 = (new JP.go.ipa.oz.lib.standard._String_cl("reserve"));
      
// 170
      boolean equalsIgnoreCase$val$401;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) stat)) {
        try {
          equalsIgnoreCase$val$401 = stat.equalsIgnoreCase (string$53);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        equalsIgnoreCase$val$401 = stat.equalsIgnoreCase (string$53);
      }
// 170
      if (equalsIgnoreCase$val$401) {{
// 171
          setState (1);
        }
      } else {
// 172
        JP.go.ipa.oz.lib.standard._String_if string$54 = (new JP.go.ipa.oz.lib.standard._String_cl("cancel"));
        
// 172
        boolean equalsIgnoreCase$val$402;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) stat)) {
          try {
            equalsIgnoreCase$val$402 = stat.equalsIgnoreCase (string$54);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          equalsIgnoreCase$val$402 = stat.equalsIgnoreCase (string$54);
        }
// 172
        if (equalsIgnoreCase$val$402) {{
// 173
            setState (2);
          }
        } else {{
// 175
            setState (3);
          }
        }
      }
    }
  }
  
  public void setState (int stat) throws Exception  {
    checkSecureInvocation ();
// 155
    state = stat;
  }
  
  public int getStartHour () throws Exception  {
    checkSecureInvocation ();
// 109
    return startHour;
  }
  
  public int getEndMinute () throws Exception  {
    checkSecureInvocation ();
// 136
    return endMinute;
  }
  
  public int getStartMinute () throws Exception  {
    checkSecureInvocation ();
// 127
    return startMinute;
  }
  
  public void setDay (int date) throws Exception  {
    checkSecureInvocation ();
// 55
    day = date;
  }
  
  public void cancel () throws Exception  {
    checkSecureInvocation ();
// 143
    JP.go.ipa.oz.user.apl.fm.Scheduler_if sch = null;
// 145
    JP.go.ipa.oz.user.apl.fm.FMObject_if stuff$val$403;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dst)) {
      try {
        stuff$val$403 = dst.stuff ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      stuff$val$403 = dst.stuff ();
    }
// 145
    sch = (JP.go.ipa.oz.user.apl.fm.Scheduler_if) (stuff$val$403);
// 146
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sch)) {
      try {
        sch.cancel (this);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sch.cancel (this);
    }
  }
  
  public void trace (int mark) throws Exception  {
    checkSecureInvocation ();
// 180
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 181
    JP.go.ipa.oz.lib.standard._String_if string$55 = (new JP.go.ipa.oz.lib.standard._String_cl("Reserve#trace("));
    
// 182
    JP.go.ipa.oz.lib.standard._String_if string$56 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    
// 182
    JP.go.ipa.oz.lib.standard._String_if valueOf$val$404;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$56)) {
      try {
        valueOf$val$404 = string$56.valueOf (mark);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      valueOf$val$404 = string$56.valueOf (mark);
    }
// 181
    JP.go.ipa.oz.lib.standard._String_if concat$val$405;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$55)) {
      try {
        concat$val$405 = string$55.concat (valueOf$val$404);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$405 = string$55.concat (valueOf$val$404);
    }
// 182
    JP.go.ipa.oz.lib.standard._String_if string$57 = (new JP.go.ipa.oz.lib.standard._String_cl(")"));
    
// 181
    JP.go.ipa.oz.lib.standard._String_if concat$val$406;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$405)) {
      try {
        concat$val$406 = concat$val$405.concat (string$57);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$406 = concat$val$405.concat (string$57);
    }
// 183
    JP.go.ipa.oz.lib.standard._String_if string$58 = (new JP.go.ipa.oz.lib.standard._String_cl(" day:"));
    
// 181
    JP.go.ipa.oz.lib.standard._String_if concat$val$407;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$406)) {
      try {
        concat$val$407 = concat$val$406.concat (string$58);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$407 = concat$val$406.concat (string$58);
    }
// 183
    JP.go.ipa.oz.lib.standard._String_if string$59 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    
// 183
    JP.go.ipa.oz.lib.standard._String_if valueOf$val$408;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$59)) {
      try {
        valueOf$val$408 = string$59.valueOf (day);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      valueOf$val$408 = string$59.valueOf (day);
    }
// 181
    JP.go.ipa.oz.lib.standard._String_if concat$val$409;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$407)) {
      try {
        concat$val$409 = concat$val$407.concat (valueOf$val$408);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$409 = concat$val$407.concat (valueOf$val$408);
    }
// 184
    JP.go.ipa.oz.lib.standard._String_if string$60 = (new JP.go.ipa.oz.lib.standard._String_cl(" start:"));
    
// 181
    JP.go.ipa.oz.lib.standard._String_if concat$val$410;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$409)) {
      try {
        concat$val$410 = concat$val$409.concat (string$60);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$410 = concat$val$409.concat (string$60);
    }
// 184
    JP.go.ipa.oz.lib.standard._String_if string$61 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    
// 184
    JP.go.ipa.oz.lib.standard._String_if valueOf$val$411;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$61)) {
      try {
        valueOf$val$411 = string$61.valueOf (startHour);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      valueOf$val$411 = string$61.valueOf (startHour);
    }
// 181
    JP.go.ipa.oz.lib.standard._String_if concat$val$412;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$410)) {
      try {
        concat$val$412 = concat$val$410.concat (valueOf$val$411);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$412 = concat$val$410.concat (valueOf$val$411);
    }
// 185
    JP.go.ipa.oz.lib.standard._String_if string$62 = (new JP.go.ipa.oz.lib.standard._String_cl(":"));
    
// 181
    JP.go.ipa.oz.lib.standard._String_if concat$val$413;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$412)) {
      try {
        concat$val$413 = concat$val$412.concat (string$62);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$413 = concat$val$412.concat (string$62);
    }
// 185
    JP.go.ipa.oz.lib.standard._String_if string$63 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    
// 185
    JP.go.ipa.oz.lib.standard._String_if valueOf$val$414;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$63)) {
      try {
        valueOf$val$414 = string$63.valueOf (startMinute);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      valueOf$val$414 = string$63.valueOf (startMinute);
    }
// 181
    JP.go.ipa.oz.lib.standard._String_if concat$val$415;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$413)) {
      try {
        concat$val$415 = concat$val$413.concat (valueOf$val$414);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$415 = concat$val$413.concat (valueOf$val$414);
    }
// 186
    JP.go.ipa.oz.lib.standard._String_if string$64 = (new JP.go.ipa.oz.lib.standard._String_cl(" end:"));
    
// 181
    JP.go.ipa.oz.lib.standard._String_if concat$val$416;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$415)) {
      try {
        concat$val$416 = concat$val$415.concat (string$64);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$416 = concat$val$415.concat (string$64);
    }
// 186
    JP.go.ipa.oz.lib.standard._String_if string$65 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    
// 186
    JP.go.ipa.oz.lib.standard._String_if valueOf$val$417;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$65)) {
      try {
        valueOf$val$417 = string$65.valueOf (endHour);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      valueOf$val$417 = string$65.valueOf (endHour);
    }
// 181
    JP.go.ipa.oz.lib.standard._String_if concat$val$418;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$416)) {
      try {
        concat$val$418 = concat$val$416.concat (valueOf$val$417);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$418 = concat$val$416.concat (valueOf$val$417);
    }
// 187
    JP.go.ipa.oz.lib.standard._String_if string$66 = (new JP.go.ipa.oz.lib.standard._String_cl(":"));
    
// 181
    JP.go.ipa.oz.lib.standard._String_if concat$val$419;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$418)) {
      try {
        concat$val$419 = concat$val$418.concat (string$66);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$419 = concat$val$418.concat (string$66);
    }
// 187
    JP.go.ipa.oz.lib.standard._String_if string$67 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    
// 187
    JP.go.ipa.oz.lib.standard._String_if valueOf$val$420;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$67)) {
      try {
        valueOf$val$420 = string$67.valueOf (endMinute);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      valueOf$val$420 = string$67.valueOf (endMinute);
    }
// 181
    JP.go.ipa.oz.lib.standard._String_if concat$val$421;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$419)) {
      try {
        concat$val$421 = concat$val$419.concat (valueOf$val$420);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$421 = concat$val$419.concat (valueOf$val$420);
    }
// 181
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.println (concat$val$421);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.println (concat$val$421);
    }
// 188
    JP.go.ipa.oz.lib.standard._String_if string$68 = (new JP.go.ipa.oz.lib.standard._String_cl("---- super ----"));
    
// 188
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.println (string$68);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.println (string$68);
    }
// 189
    super.trace (mark);
  }
  
  public void init (int date, int sh, int sm, int eh, int em) throws Exception  {
    checkSecureInvocation ();
// 46
    setReserve (date, sh, sm, eh, em);
  }
  
  public int getDay () throws Exception  {
    checkSecureInvocation ();
// 100
    return day;
  }
  
  public void setStartMinute (int st) throws Exception  {
    checkSecureInvocation ();
// 82
    startMinute = st;
  }
  
  public void setStartHour (int st) throws Exception  {
    checkSecureInvocation ();
// 64
    startHour = st;
  }
  
  public int getEndHour () throws Exception  {
    checkSecureInvocation ();
// 118
    return endHour;
  }
  
  public void setEndHour (int ed) throws Exception  {
    checkSecureInvocation ();
// 73
    endHour = ed;
  }
  
  public void setReserve (int date, int sh, int sm, int eh, int em) throws Exception  {
    checkSecureInvocation ();
// 38
    day = date;
// 39
    startHour = sh;
// 40
    startMinute = sm;
// 41
    endHour = eh;
// 42
    endMinute = em;
  }
  
  public void setEndMinute (int ed) throws Exception  {
    checkSecureInvocation ();
// 91
    endMinute = ed;
  }
  
  public Reserve_cl () throws Exception { super (); }
  
}


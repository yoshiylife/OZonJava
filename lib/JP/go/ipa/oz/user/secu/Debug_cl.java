package JP.go.ipa.oz.user.secu;

public class Debug_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.secu.Debug_if {
  JP.go.ipa.oz.lib.standard._String_if p;
  
  public Object _new_create () throws Exception  {
// 16
    p = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    return this;
  }
  
  public void write (int j, JP.go.ipa.oz.lib.standard._String_if str, int i, int k) throws Exception  {
    checkSecureInvocation ();
// 74
    if (j == 1) {{
// 75
        JP.go.ipa.oz.lib.standard._System_if ss = null;
// 75
        ss = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 76
        JP.go.ipa.oz.lib.standard._PrintWriter_if o = ss.getStdout ();
// 77
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.print (p);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.print (p);
        }
// 77
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.print (str);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.print (str);
        }
// 77
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.print (i);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.print (i);
        }
// 77
        JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl(","));
        
// 77
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.print (string$0);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.print (string$0);
        }
// 77
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.println (k);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.println (k);
        }
// 77
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.flush ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.flush ();
        }
      }
    }
  }
  
  public void write (int j, JP.go.ipa.oz.lib.standard._String_if str, JP.go.ipa.oz.lib.standard._String_if str2, int i) throws Exception  {
    checkSecureInvocation ();
// 68
    if (j == 1) {{
// 69
        JP.go.ipa.oz.lib.standard._System_if ss = null;
// 69
        ss = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 70
        JP.go.ipa.oz.lib.standard._PrintWriter_if o = ss.getStdout ();
// 71
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.print (p);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.print (p);
        }
// 71
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.print (str);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.print (str);
        }
// 71
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.print (str2);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.print (str2);
        }
// 71
        JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl(","));
        
// 71
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.print (string$1);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.print (string$1);
        }
// 71
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.println (i);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.println (i);
        }
// 71
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.flush ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.flush ();
        }
      }
    }
  }
  
  public void write (int j, JP.go.ipa.oz.lib.standard._String_if str, JP.go.ipa.oz.lib.standard._String_if str2, JP.go.ipa.oz.lib.standard._String_if str3) throws Exception  {
    checkSecureInvocation ();
// 62
    if (j == 1) {{
// 63
        JP.go.ipa.oz.lib.standard._System_if ss = null;
// 63
        ss = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 64
        JP.go.ipa.oz.lib.standard._PrintWriter_if o = ss.getStdout ();
// 65
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.print (p);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.print (p);
        }
// 65
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.print (str);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.print (str);
        }
// 65
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.print (str2);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.print (str2);
        }
// 65
        JP.go.ipa.oz.lib.standard._String_if string$2 = (new JP.go.ipa.oz.lib.standard._String_cl(","));
        
// 65
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.print (string$2);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.print (string$2);
        }
// 65
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.println (str3);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.println (str3);
        }
// 65
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.flush ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.flush ();
        }
      }
    }
  }
  
  public void write (int j, JP.go.ipa.oz.lib.standard._String_if str, JP.go.ipa.oz.lib.standard._String_if str2) throws Exception  {
    checkSecureInvocation ();
// 56
    if (j == 1) {{
// 57
        JP.go.ipa.oz.lib.standard._System_if ss = null;
// 57
        ss = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 58
        JP.go.ipa.oz.lib.standard._PrintWriter_if o = ss.getStdout ();
// 59
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.print (p);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.print (p);
        }
// 59
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.print (str);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.print (str);
        }
// 59
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.println (str2);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.println (str2);
        }
// 59
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.flush ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.flush ();
        }
      }
    }
  }
  
  public void write (int j, JP.go.ipa.oz.lib.standard._String_if str, int i, JP.go.ipa.oz.lib.standard._String_if str2, int i2) throws Exception  {
    checkSecureInvocation ();
// 50
    if (j == 1) {{
// 51
        JP.go.ipa.oz.lib.standard._System_if ss = null;
// 51
        ss = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 52
        JP.go.ipa.oz.lib.standard._PrintWriter_if o = ss.getStdout ();
// 53
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.print (p);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.print (p);
        }
// 53
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.print (str);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.print (str);
        }
// 53
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.print (i);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.print (i);
        }
// 53
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.print (str2);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.print (str2);
        }
// 53
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.println (i2);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.println (i2);
        }
// 53
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.flush ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.flush ();
        }
      }
    }
  }
  
  public void write (int j, JP.go.ipa.oz.lib.standard._String_if str, int i, JP.go.ipa.oz.lib.standard._String_if str2) throws Exception  {
    checkSecureInvocation ();
// 44
    if (j == 1) {{
// 45
        JP.go.ipa.oz.lib.standard._System_if ss = null;
// 45
        ss = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 46
        JP.go.ipa.oz.lib.standard._PrintWriter_if o = ss.getStdout ();
// 47
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.print (p);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.print (p);
        }
// 47
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.print (str);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.print (str);
        }
// 47
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.print (i);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.print (i);
        }
// 47
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.println (str2);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.println (str2);
        }
// 47
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.flush ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.flush ();
        }
      }
    }
  }
  
  public void write (int j, JP.go.ipa.oz.lib.standard._String_if str, int i) throws Exception  {
    checkSecureInvocation ();
// 38
    if (j == 1) {{
// 39
        JP.go.ipa.oz.lib.standard._System_if ss = null;
// 39
        ss = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 40
        JP.go.ipa.oz.lib.standard._PrintWriter_if o = ss.getStdout ();
// 41
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.print (p);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.print (p);
        }
// 41
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.print (str);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.print (str);
        }
// 41
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.println (i);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.println (i);
        }
// 41
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.flush ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.flush ();
        }
      }
    }
  }
  
  public void write (int j, JP.go.ipa.oz.lib.standard._String_if str) throws Exception  {
    checkSecureInvocation ();
// 32
    if (j == 1) {{
// 33
        JP.go.ipa.oz.lib.standard._System_if ss = null;
// 33
        ss = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 34
        JP.go.ipa.oz.lib.standard._PrintWriter_if o = ss.getStdout ();
// 35
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.print (p);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.print (p);
        }
// 35
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.println (str);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.println (str);
        }
// 35
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
          try {
            o.flush ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          o.flush ();
        }
      }
    }
  }
  
  public void write (JP.go.ipa.oz.lib.standard._String_if str) throws Exception  {
    checkSecureInvocation ();
// 27
    JP.go.ipa.oz.lib.standard._System_if ss = null;
// 27
    ss = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 28
    JP.go.ipa.oz.lib.standard._PrintWriter_if o = ss.getStdout ();
// 29
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
      try {
        o.print (p);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      o.print (p);
    }
// 29
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
      try {
        o.println (str);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      o.println (str);
    }
// 29
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) o)) {
      try {
        o.flush ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      o.flush ();
    }
  }
  
  public void setP (JP.go.ipa.oz.lib.standard._String_if s) throws Exception  {
    checkSecureInvocation ();
// 19
    p = s;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if itoa (int a1) throws Exception  {
    checkSecureInvocation ();
// 22
    JP.go.ipa.oz.lib.standard._Integer_if iway1 = (JP.go.ipa.oz.lib.standard._Integer_cl) (new JP.go.ipa.oz.lib.standard._Integer_cl ())._new_breed (a1);
// 23
    JP.go.ipa.oz.lib.standard._String_if asString$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iway1)) {
      try {
        asString$val$0 = iway1.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$0 = iway1.asString ();
    }
// 23
    JP.go.ipa.oz.lib.standard._String_if ans1 = asString$val$0;
// 24
    return ans1;
  }
  
  public Debug_cl () throws Exception { super (); }
  
}


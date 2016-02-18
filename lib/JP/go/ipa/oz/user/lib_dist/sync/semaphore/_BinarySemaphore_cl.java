package JP.go.ipa.oz.user.lib_dist.sync.semaphore;

public class _BinarySemaphore_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.lib_dist.sync.semaphore._BinarySemaphore_if {
  JP.go.ipa.oz.system.OzCondition ex = new JP.go.ipa.oz.system.OzCondition (this);
  JP.go.ipa.oz.system.OzCondition co = new JP.go.ipa.oz.system.OzCondition (this);
  protected int sem;
  boolean notCoEmpty;
  
  public Object _new_create () throws Exception  {
// 59
    sem = 0;
// 60
    notCoEmpty = false;
    return this;
  }
  
  public void V () throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 45
      if (sem == -1) {{
// 46
          sem = 0;
// 47
          if (notCoEmpty) {
// 47
            signalAll (co);
          } else {
// 48
            signal (ex);
          }
        }
      } else {
// 49
        if (sem == 1) {{
// 50
            sem = 0;
// 51
            notCoEmpty = false;
// 52
            signal (ex);
          }
        } else {{
// 54
            sem--;
          }
        }
      }
    } finally {
      leave ();
    }
  }
  
  protected void P (boolean mode) throws Exception  {
// 30
    if (sem == 0) {{
// 31
        if (mode) {
// 31
          sem = -1;
        } else {
// 32
          sem++;
        }
      }
    } else {
// 33
      if (sem == -1) {{
// 34
          if (mode) {{
// 34
              wait (ex);
// 34
              sem = -1;
            }
          } else {{
// 35
              notCoEmpty = true;
// 35
              wait (co);
// 35
              sem++;
            }
          }
        }
      } else {{
// 37
          if (mode) {{
// 37
              wait (ex);
// 37
              sem = -1;
            }
          } else {
// 38
            sem++;
          }
        }
      }
    }
  }
  
  public void P () throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 24
      P (true);
    } finally {
      leave ();
    }
  }
  
  public _BinarySemaphore_cl () throws Exception { super (); }
  
}


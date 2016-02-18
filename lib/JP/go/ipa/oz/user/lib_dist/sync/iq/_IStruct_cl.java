package JP.go.ipa.oz.user.lib_dist.sync.iq;

public class _IStruct_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.lib_dist.sync.iq._IStruct_if {
  JP.go.ipa.oz.lang._Root_if val;
  JP.go.ipa.oz.system.OzCondition cond = new JP.go.ipa.oz.system.OzCondition (this);
  int flag;
  
  public Object _new_create () throws Exception  {
// 21
    flag = 0;
    return this;
  }
  
  public void write (JP.go.ipa.oz.lang._Root_if o) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 25
      if (flag == 1) {{
// 26
          JP.go.ipa.oz.user.lib_dist.sync.iq._IStructWriteException_if e = (JP.go.ipa.oz.user.lib_dist.sync.iq._IStructWriteException_cl) (new JP.go.ipa.oz.user.lib_dist.sync.iq._IStructWriteException_cl ())._new_init ();
// 27
          throw new JP.go.ipa.oz.lang.OzException (e);
        }
      } else {{
// 29
          val = o;
// 30
          if (flag == 0) {{
// 31
              flag = 1;
            }
          } else {{
// 33
              flag = 0;
// 34
              signal (cond);
            }
          }
        }
      }
    } finally {
      leave ();
    }
  }
  
  public JP.go.ipa.oz.lang._Root_if read () throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 40
      if (flag == -1) {{
// 41
          JP.go.ipa.oz.user.lib_dist.sync.iq._IStructReadException_if e = (JP.go.ipa.oz.user.lib_dist.sync.iq._IStructReadException_cl) (new JP.go.ipa.oz.user.lib_dist.sync.iq._IStructReadException_cl ())._new_init ();
// 42
          throw new JP.go.ipa.oz.lang.OzException (e);
        }
      } else {{
// 44
          if (flag == 0) {{
// 45
              flag = -1;
// 46
              wait (cond);
            }
          }
// 48
          flag = 0;
// 49
          return val;
        }
      }
    } finally {
      leave ();
    }
  }
  
  public _IStruct_cl () throws Exception { super (); }
  
}


package JP.go.ipa.oz.user.apl.fm;

public class Overseer_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.apl.fm.Overseer_if {
  
  public Object _new_create () throws Exception  {
    return this;
  }
  
  public void permit (JP.go.ipa.oz.lang._Root_if r) throws Exception  {
    checkSecureInvocation ();
    boolean bool$val$0;
    
    bool$val$0 = r != null;
    if (bool$val$0) {
// 10
      boolean isRed$val$16;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
        try {
          isRed$val$16 = r.isRed ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isRed$val$16 = r.isRed ();
      }
      bool$val$0 = isRed$val$16;
    }
// 10
    if (bool$val$0) {{
// 11
        turnGreen (r);
// 12
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
          try {
            r.toGreen ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          r.toGreen ();
        }
      }
    }
  }
  
  public Overseer_cl () throws Exception { super (); }
  
}


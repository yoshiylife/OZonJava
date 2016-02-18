package JP.go.ipa.oz.user.apl.fed;

public class ResourceLog_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.apl.fed.ResourceLog_if {
  protected JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.lib.standard._Date_if incoming;
  JP.go.ipa.oz.lib.standard._Date_if outgoing;
  
  public Object _new_create () throws Exception  {
// 11
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 12
    incoming = null;
// 13
    outgoing = null;
    return this;
  }
  
  public void in () throws Exception  {
    checkSecureInvocation ();
// 19
    incoming = (JP.go.ipa.oz.lib.standard._Date_cl) (new JP.go.ipa.oz.lib.standard._Date_cl ())._new_breed ();
  }
  
  public void toGreen () throws Exception  {
    checkSecureInvocation ();
    boolean bool$val$3;
    
    bool$val$3 = incoming != null;
    if (bool$val$3) {
// 44
      boolean isRed$val$18;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) incoming)) {
        try {
          isRed$val$18 = incoming.isRed ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isRed$val$18 = incoming.isRed ();
      }
      bool$val$3 = isRed$val$18;
    }
// 44
    if (bool$val$3) {
// 44
      turnGreen (incoming);
    }
    boolean bool$val$4;
    
    bool$val$4 = outgoing != null;
    if (bool$val$4) {
// 45
      boolean isRed$val$19;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) outgoing)) {
        try {
          isRed$val$19 = outgoing.isRed ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isRed$val$19 = outgoing.isRed ();
      }
      bool$val$4 = isRed$val$19;
    }
// 45
    if (bool$val$4) {
// 45
      turnGreen (outgoing);
    }
  }
  
  public void out () throws Exception  {
    checkSecureInvocation ();
// 26
    outgoing = (JP.go.ipa.oz.lib.standard._Date_cl) (new JP.go.ipa.oz.lib.standard._Date_cl ())._new_breed ();
  }
  
  public JP.go.ipa.oz.lib.standard._Date_if getOutTime () throws Exception  {
    checkSecureInvocation ();
// 39
    return outgoing;
  }
  
  public JP.go.ipa.oz.lib.standard._Date_if getInTime () throws Exception  {
    checkSecureInvocation ();
// 33
    return incoming;
  }
  
  public ResourceLog_cl () throws Exception { super (); }
  
}


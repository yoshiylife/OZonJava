package JP.go.ipa.oz.user.apl.fed;

public class Authenticator_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.apl.fed.Authenticator_if {
  
  public Object _new_create () throws Exception  {
    return this;
  }
  
  public void authorize (JP.go.ipa.oz.lang._Root_if obj) throws Exception  {
    checkSecureInvocation ();
// 10
    turnGreen (obj);
// 11
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
      try {
        obj.toGreen ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      obj.toGreen ();
    }
  }
  
  public Authenticator_cl () throws Exception { super (); }
  
}


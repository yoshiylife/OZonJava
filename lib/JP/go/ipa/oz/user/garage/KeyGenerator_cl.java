package JP.go.ipa.oz.user.garage;

public class KeyGenerator_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.garage.KeyGenerator_if {
  int theKey;
  
  public Object _new_create () throws Exception  {
// 21
    theKey = 0;
    return this;
  }
  
  public JP.go.ipa.oz.user.garage.Key_if generate () throws Exception  {
    checkSecureInvocation ();
// 29
    JP.go.ipa.oz.user.garage.Key_if key = null;
// 31
    theKey++;
// 32
    key = (JP.go.ipa.oz.user.garage.Key_cl) (new JP.go.ipa.oz.user.garage.Key_cl ())._new_create (theKey);
// 34
    return key;
  }
  
  public KeyGenerator_cl () throws Exception { super (); }
  
}


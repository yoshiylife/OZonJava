package JP.go.ipa.oz.user.garage;

public class Key_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.garage.Key_if {
  int value;
  
  public Object _new_create (int v) throws Exception  {
// 20
    value = v;
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if asString () throws Exception  {
    checkSecureInvocation ();
// 36
    JP.go.ipa.oz.lib.standard._String_if str = null, keyStr = null;
// 38
    str = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ();
// 39
    keyStr = str.valueOf (value);
// 41
    return keyStr;
  }
  
  public int asInt () throws Exception  {
    checkSecureInvocation ();
// 29
    return value;
  }
  
  public Key_cl () throws Exception { super (); }
  
}


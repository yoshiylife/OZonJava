package JP.go.ipa.oz.user.garage;

public class KeyComparator_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.garage.KeyComparator_if {
  
  public Object _new_create () throws Exception  {
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._Comparator_if duplicate () throws Exception  {
    checkSecureInvocation ();
// 50
    JP.go.ipa.oz.user.garage.KeyComparator_if kc = null;
// 52
    kc = (JP.go.ipa.oz.user.garage.KeyComparator_cl) (new JP.go.ipa.oz.user.garage.KeyComparator_cl ())._new_create ();
// 54
    return kc;
  }
  
  public boolean compare (JP.go.ipa.oz.lang._Root_if key1, JP.go.ipa.oz.lang._Root_if key2) throws Exception  {
    checkSecureInvocation ();
// 27
    JP.go.ipa.oz.user.garage.Key_if k1 = null, k2 = null;
// 29
    k1 = (JP.go.ipa.oz.user.garage.Key_if) (key1);
// 30
    k2 = (JP.go.ipa.oz.user.garage.Key_if) (key2);
// 32
    int asInt$val$9;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) k1)) {
      try {
        asInt$val$9 = k1.asInt ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asInt$val$9 = k1.asInt ();
    }
// 32
    int asInt$val$10;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) k2)) {
      try {
        asInt$val$10 = k2.asInt ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asInt$val$10 = k2.asInt ();
    }
// 32
    return asInt$val$9 == asInt$val$10;
  }
  
  public int hash (JP.go.ipa.oz.lang._Root_if key) throws Exception  {
    checkSecureInvocation ();
// 39
    JP.go.ipa.oz.user.garage.Key_if k = null;
// 41
    k = (JP.go.ipa.oz.user.garage.Key_if) (key);
// 43
    int asInt$val$11;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) k)) {
      try {
        asInt$val$11 = k.asInt ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asInt$val$11 = k.asInt ();
    }
// 43
    return asInt$val$11;
  }
  
  public KeyComparator_cl () throws Exception { super (); }
  
}


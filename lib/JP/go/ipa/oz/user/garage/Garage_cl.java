package JP.go.ipa.oz.user.garage;

public class Garage_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.garage.Garage_if {
  JP.go.ipa.oz.lib.standard._Dictionary_if valueTable;
  JP.go.ipa.oz.user.garage.KeyGenerator_if keyGen;
  
  public Object _new_create () throws Exception  {
// 23
    JP.go.ipa.oz.user.garage.KeyComparator_if keyComp = null;
// 25
    keyGen = (JP.go.ipa.oz.user.garage.KeyGenerator_cl) (new JP.go.ipa.oz.user.garage.KeyGenerator_cl ())._new_create ();
// 26
    keyComp = (JP.go.ipa.oz.user.garage.KeyComparator_cl) (new JP.go.ipa.oz.user.garage.KeyComparator_cl ())._new_create ();
// 27
    valueTable = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (keyComp);
    return this;
  }
  
  public void remove (JP.go.ipa.oz.user.garage.Key_if key) throws Exception  {
    checkSecureInvocation ();
// 69
    JP.go.ipa.oz.lib.standard._Dictionary_if remove$val$1;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) valueTable)) {
      try {
        remove$val$1 = valueTable.remove (key);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      remove$val$1 = valueTable.remove (key);
    }
  }
  
  public int size () throws Exception  {
    checkSecureInvocation ();
// 83
    int size$val$2;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) valueTable)) {
      try {
        size$val$2 = valueTable.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$2 = valueTable.size ();
    }
// 83
    return size$val$2;
  }
  
  public void replace (JP.go.ipa.oz.user.garage.Key_if key, JP.go.ipa.oz.lang._Root_if value) throws Exception  {
    checkSecureInvocation ();
// 76
    JP.go.ipa.oz.lib.standard._Dictionary_if put$val$3;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) valueTable)) {
      try {
        put$val$3 = valueTable.put (key, value);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$3 = valueTable.put (key, value);
    }
  }
  
  public JP.go.ipa.oz.user.garage.Key_if put (JP.go.ipa.oz.lang._Root_if value) throws Exception  {
    checkSecureInvocation ();
// 57
    JP.go.ipa.oz.user.garage.Key_if key = null;
// 59
    JP.go.ipa.oz.user.garage.Key_if generate$val$4;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) keyGen)) {
      try {
        generate$val$4 = keyGen.generate ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      generate$val$4 = keyGen.generate ();
    }
// 59
    key = generate$val$4;
// 60
    JP.go.ipa.oz.lib.standard._Dictionary_if put$val$5;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) valueTable)) {
      try {
        put$val$5 = valueTable.put (key, value);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$5 = valueTable.put (key, value);
    }
// 62
    return key;
  }
  
  public JP.go.ipa.oz.lib.standard._Collection_if keys () throws Exception  {
    checkSecureInvocation ();
// 50
    JP.go.ipa.oz.lib.standard._Set_if keys$val$6;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) valueTable)) {
      try {
        keys$val$6 = valueTable.keys ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      keys$val$6 = valueTable.keys ();
    }
// 50
    return keys$val$6;
  }
  
  public JP.go.ipa.oz.lib.standard._Iterator_if iterator () throws Exception  {
    checkSecureInvocation ();
// 43
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$7;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) valueTable)) {
      try {
        iterator$val$7 = valueTable.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$7 = valueTable.iterator ();
    }
// 43
    return iterator$val$7;
  }
  
  public JP.go.ipa.oz.lang._Root_if get (JP.go.ipa.oz.user.garage.Key_if key) throws Exception  {
    checkSecureInvocation ();
// 36
    JP.go.ipa.oz.lang._Root_if get$val$8;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) valueTable)) {
      try {
        get$val$8 = valueTable.get (key);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$8 = valueTable.get (key);
    }
// 36
    return get$val$8;
  }
  
  public Garage_cl () throws Exception { super (); }
  
}


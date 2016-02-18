package JP.go.ipa.oz.user.lib_dist.name;

public class _TroubleNameServers_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.lib_dist.name._TroubleNameServers_if {
  JP.go.ipa.oz.lib.standard._Dictionary_if list;
  
  public Object _new_create () throws Exception  {
// 284
    JP.go.ipa.oz.lib.standard._StringComparator_if sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 285
    list = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (sc);
    return this;
  }
  
  public void remove (JP.go.ipa.oz.lib.standard._String_if serverNSTRGOL) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 294
      JP.go.ipa.oz.lib.standard._Dictionary_if remove$val$509;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
        try {
          remove$val$509 = list.remove (serverNSTRGOL);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        remove$val$509 = list.remove (serverNSTRGOL);
      }
// 294
      list = remove$val$509;
    } finally {
      leave ();
    }
  }
  
  public boolean contains (JP.go.ipa.oz.lib.standard._String_if serverNSTRGOL) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 303
      boolean contains$val$510;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
        try {
          contains$val$510 = list.contains (serverNSTRGOL);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        contains$val$510 = list.contains (serverNSTRGOL);
      }
// 303
      return contains$val$510;
    } finally {
      leave ();
    }
  }
  
  public void replace (JP.go.ipa.oz.lib.standard._String_if serverNSTRGOL, JP.go.ipa.oz.lib.standard._Integer_if pn) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 298
      JP.go.ipa.oz.lib.standard._Dictionary_if remove$val$511;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
        try {
          remove$val$511 = list.remove (serverNSTRGOL);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        remove$val$511 = list.remove (serverNSTRGOL);
      }
// 298
      list = remove$val$511;
// 299
      JP.go.ipa.oz.lib.standard._Dictionary_if put$val$512;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
        try {
          put$val$512 = list.put (serverNSTRGOL, pn);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        put$val$512 = list.put (serverNSTRGOL, pn);
      }
// 299
      list = put$val$512;
    } finally {
      leave ();
    }
  }
  
  public void add (JP.go.ipa.oz.lib.standard._String_if serverNSTRGOL) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 289
      JP.go.ipa.oz.lib.standard._Integer_if Zero = (JP.go.ipa.oz.lib.standard._Integer_cl) (new JP.go.ipa.oz.lib.standard._Integer_cl ())._new_breed (0);
// 290
      JP.go.ipa.oz.lib.standard._Dictionary_if put$val$513;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
        try {
          put$val$513 = list.put (serverNSTRGOL, Zero);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        put$val$513 = list.put (serverNSTRGOL, Zero);
      }
// 290
      list = put$val$513;
    } finally {
      leave ();
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Dictionary_if get () throws Exception  {
    checkSecureInvocation ();
// 307
    return list;
  }
  
  public _TroubleNameServers_cl () throws Exception { super (); }
  
}


package JP.go.ipa.oz.user.lib_dist.sync.timer;

public class _ThisFoo_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.lib_dist.sync.timer._ThisFoo_if {
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.system.OzCondition dummy = new JP.go.ipa.oz.system.OzCondition (this);
  
  public Object _new_create () throws Exception  {
// 17
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
    return this;
  }
  
  public int foo (int i, JP.go.ipa.oz.lib.standard._String_if S) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 19
      JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl("method foo start"));
      
// 19
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$0);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$0);
      }
// 20
      wait (dummy, 3000);
// 22
      JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl("method foo end"));
      
// 22
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$1);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$1);
      }
// 23
      return i;
    } finally {
      leave ();
    }
  }
  
  public _ThisFoo_cl () throws Exception { super (); }
  
}


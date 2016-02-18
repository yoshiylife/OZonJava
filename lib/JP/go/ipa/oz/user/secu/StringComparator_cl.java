package JP.go.ipa.oz.user.secu;

public class StringComparator_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.secu.StringComparator_if {
  
  public Object _new_create () throws Exception  {
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._Comparator_if duplicate () throws Exception  {
    checkSecureInvocation ();
// 92
    return this;
  }
  
  public boolean compare (JP.go.ipa.oz.lang._Root_if t1, JP.go.ipa.oz.lang._Root_if t2) throws Exception  {
    checkSecureInvocation ();
// 88
    JP.go.ipa.oz.lib.standard._String_if a1 = null, a2 = null;
// 88
    a1 = (JP.go.ipa.oz.lib.standard._String_if) (t1);
// 88
    a2 = (JP.go.ipa.oz.lib.standard._String_if) (t2);
// 89
    boolean isequal$val$14;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) a1)) {
      try {
        isequal$val$14 = a1.isequal (a2);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$14 = a1.isequal (a2);
    }
// 89
    if (isequal$val$14) {
// 89
      return true;
    } else {
// 90
      return false;
    }
  }
  
  public int hash (JP.go.ipa.oz.lang._Root_if t) throws Exception  {
    checkSecureInvocation ();
// 93
    return 0;
  }
  
  public StringComparator_cl () throws Exception { super (); }
  
}


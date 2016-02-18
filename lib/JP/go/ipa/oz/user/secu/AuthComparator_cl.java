package JP.go.ipa.oz.user.secu;

public class AuthComparator_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.secu.AuthComparator_if {
  
  public Object _new_create () throws Exception  {
    return this;
  }
  
  public final JP.go.ipa.oz.lib.standard._Comparator_if duplicate () throws Exception  {
    checkSecureInvocation ();
// 70
    return this;
  }
  
  public final boolean compare (JP.go.ipa.oz.lang._Root_if t1, JP.go.ipa.oz.lang._Root_if t2) throws Exception  {
    checkSecureInvocation ();
// 66
    JP.go.ipa.oz.lib.standard._String_if a1 = null, a2 = null;
// 66
    a1 = (JP.go.ipa.oz.lib.standard._String_if) (t1);
// 66
    a2 = (JP.go.ipa.oz.lib.standard._String_if) (t2);
// 67
    boolean isequal$val$6;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) a1)) {
      try {
        isequal$val$6 = a1.isequal (a2);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$6 = a1.isequal (a2);
    }
// 67
    if (isequal$val$6) {
// 67
      return true;
    } else {
// 68
      return false;
    }
  }
  
  public final int hash (JP.go.ipa.oz.lang._Root_if t) throws Exception  {
    checkSecureInvocation ();
// 71
    return 0;
  }
  
  public AuthComparator_cl () throws Exception { super (); }
  
}


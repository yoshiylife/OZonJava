package JP.go.ipa.oz.user.lib_dist.tran;

public class _TIDComparator_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.lib_dist.tran._TIDComparator_if {
  
  public Object _new_create () throws Exception  {
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._Comparator_if duplicate () throws Exception  {
    checkSecureInvocation ();
// 40
    return this;
  }
  
  public boolean compare (JP.go.ipa.oz.lang._Root_if t1, JP.go.ipa.oz.lang._Root_if t2) throws Exception  {
    checkSecureInvocation ();
// 36
    JP.go.ipa.oz.user.lib_dist.tran._TID_if a1 = null, a2 = null;
// 36
    a1 = (JP.go.ipa.oz.user.lib_dist.tran._TID_if) (t1);
// 36
    a2 = (JP.go.ipa.oz.user.lib_dist.tran._TID_if) (t2);
// 37
    boolean equal$val$3;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) a1)) {
      try {
        equal$val$3 = a1.equal (a2);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      equal$val$3 = a1.equal (a2);
    }
// 37
    if (equal$val$3) {
// 37
      return true;
    } else {
// 38
      return false;
    }
  }
  
  public int hash (JP.go.ipa.oz.lang._Root_if t) throws Exception  {
    checkSecureInvocation ();
// 41
    return 0;
  }
  
  public _TIDComparator_cl () throws Exception { super (); }
  
}


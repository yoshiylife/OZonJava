package JP.go.ipa.oz.user.lib_dist.replica;

public class CopyRes_Comparator_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.lib_dist.replica.CopyRes_Comparator_if {
  
  public Object _new_create () throws Exception  {
    return this;
  }
  
  public final JP.go.ipa.oz.lib.standard._Comparator_if duplicate () throws Exception  {
    checkSecureInvocation ();
// 607
    return this;
  }
  
  public final boolean compare (JP.go.ipa.oz.lang._Root_if t1, JP.go.ipa.oz.lang._Root_if t2) throws Exception  {
    checkSecureInvocation ();
// 599
    JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if a1 = null, a2 = null;
// 600
    a1 = (JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if) (t1);
// 601
    a2 = (JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if) (t2);
// 602
    boolean equal$val$52;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) a1)) {
      try {
        equal$val$52 = a1.equal (a2);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      equal$val$52 = a1.equal (a2);
    }
// 602
    if (equal$val$52) {
// 603
      return true;
    } else {
// 605
      return false;
    }
  }
  
  public final int hash (JP.go.ipa.oz.lang._Root_if t) throws Exception  {
    checkSecureInvocation ();
// 608
    return 0;
  }
  
  public CopyRes_Comparator_cl () throws Exception { super (); }
  
}


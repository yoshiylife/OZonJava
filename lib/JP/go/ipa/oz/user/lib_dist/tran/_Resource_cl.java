package JP.go.ipa.oz.user.lib_dist.tran;

public class _Resource_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.lib_dist.tran._Resource_if {
  JP.go.ipa.oz.lang._Root_if ur;
  
  public Object _new_create (JP.go.ipa.oz.lang._Root_if u) throws Exception  {
// 17
    ur = u;
    return this;
  }
  
  public final void setUserResource (JP.go.ipa.oz.lang._Root_if u) throws Exception  {
    checkSecureInvocation ();
// 19
    ur = u;
  }
  
  public final JP.go.ipa.oz.lang._Root_if getUserResource () throws Exception  {
    checkSecureInvocation ();
// 18
    return ur;
  }
  
  public _Resource_cl () throws Exception { super (); }
  
}


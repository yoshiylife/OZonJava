package JP.go.ipa.oz.user.lib_dist.name;

public class _NameResource_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.lib_dist.name._NameResource_if {
  JP.go.ipa.oz.lib.standard._Dictionary_if systemmap;
  JP.go.ipa.oz.lib.standard._Dictionary_if branches;
  JP.go.ipa.oz.lib.standard._Dictionary_if ownermap;
  JP.go.ipa.oz.lib.standard._Set_if servers;
  
  public Object _new_create () throws Exception  {
// 35
    JP.go.ipa.oz.lib.standard._StringComparator_if sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 37
    ownermap = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (sc);
// 37
    branches = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (sc);
// 38
    systemmap = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (sc);
// 38
    servers = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (sc);
    return this;
  }
  
  public final void setSystemmap (JP.go.ipa.oz.lib.standard._Dictionary_if sm) throws Exception  {
    checkSecureInvocation ();
// 46
    systemmap = sm;
  }
  
  public final JP.go.ipa.oz.lib.standard._Dictionary_if getSystemmap () throws Exception  {
    checkSecureInvocation ();
// 42
    return systemmap;
  }
  
  public final JP.go.ipa.oz.lib.standard._Dictionary_if getBranches () throws Exception  {
    checkSecureInvocation ();
// 41
    return branches;
  }
  
  public final void setBranches (JP.go.ipa.oz.lib.standard._Dictionary_if br) throws Exception  {
    checkSecureInvocation ();
// 45
    branches = br;
  }
  
  public final JP.go.ipa.oz.lib.standard._Dictionary_if getOwnerMap () throws Exception  {
    checkSecureInvocation ();
// 40
    return ownermap;
  }
  
  public final JP.go.ipa.oz.lib.standard._Set_if getServers () throws Exception  {
    checkSecureInvocation ();
// 43
    return servers;
  }
  
  public final void setServers (JP.go.ipa.oz.lib.standard._Set_if s) throws Exception  {
    checkSecureInvocation ();
// 47
    servers = s;
  }
  
  public final void setOwnerMap (JP.go.ipa.oz.lib.standard._Dictionary_if om) throws Exception  {
    checkSecureInvocation ();
// 44
    ownermap = om;
  }
  
  public _NameResource_cl () throws Exception { super (); }
  
}


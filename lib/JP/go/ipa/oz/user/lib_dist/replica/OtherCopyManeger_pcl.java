package JP.go.ipa.oz.user.lib_dist.replica;

public class OtherCopyManeger_pcl extends JP.go.ipa.oz.user.lib_dist.tran._Transaction_pcl implements JP.go.ipa.oz.user.lib_dist.replica.OtherCopyManeger_if {
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    if (part != 2) return super.invoke (o);
    
    JP.go.ipa.oz.user.lib_dist.replica.OtherCopyManeger_if g = (JP.go.ipa.oz.user.lib_dist.replica.OtherCopyManeger_if) o;
    Object result;
    
    switch (selector) {
    default:
      throw new Exception ("OtherCopyManeger_pcl: invalid selector = " + selector);
    }
  }
  
  
  public OtherCopyManeger_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public OtherCopyManeger_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public OtherCopyManeger_pcl () throws Exception { super (); }
  
  
}


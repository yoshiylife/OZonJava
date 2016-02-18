package JP.go.ipa.oz.user.secu;

public class addGroupMember_pcl extends JP.go.ipa.oz.lang._Proxy_cl implements JP.go.ipa.oz.user.secu.addGroupMember_if {
  protected int part;
  
  protected int selector;
  
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    if (part != 1) return super.invoke (o);
    
    JP.go.ipa.oz.user.secu.addGroupMember_if g = (JP.go.ipa.oz.user.secu.addGroupMember_if) o;
    Object result;
    
    switch (selector) {
    default:
      throw new Exception ("addGroupMember_pcl: invalid selector = " + selector);
    }
  }
  
  
  public addGroupMember_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public addGroupMember_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public addGroupMember_pcl () throws Exception { super (); }
  
  
}


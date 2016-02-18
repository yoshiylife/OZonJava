package JP.go.ipa.oz.user.secu;

public class addGroup_pcl extends JP.go.ipa.oz.lang._Proxy_cl implements JP.go.ipa.oz.user.secu.addGroup_if {
  protected int part;
  
  protected int selector;
  
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    if (part != 1) return super.invoke (o);
    
    JP.go.ipa.oz.user.secu.addGroup_if g = (JP.go.ipa.oz.user.secu.addGroup_if) o;
    Object result;
    
    switch (selector) {
    default:
      throw new Exception ("addGroup_pcl: invalid selector = " + selector);
    }
  }
  
  
  public addGroup_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public addGroup_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public addGroup_pcl () throws Exception { super (); }
  
  
}


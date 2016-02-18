package JP.go.ipa.oz.user.misc.cell;

public class Stoppable_pcl extends JP.go.ipa.oz.lang._Proxy_cl implements JP.go.ipa.oz.user.misc.cell.Stoppable_if {
  protected int part;
  
  protected int selector;
  
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    if (part != 1) return super.invoke (o);
    
    JP.go.ipa.oz.user.misc.cell.Stoppable_if g = (JP.go.ipa.oz.user.misc.cell.Stoppable_if) o;
    Object result;
    
    switch (selector) {
    case 0:
      g.stop();
      return null;
    default:
      throw new Exception ("Stoppable_pcl: invalid selector = " + selector);
    }
  }
  
  
  
  public void stop () throws Exception {
    enter ();
    try {
      part = 1;
      selector = 0;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  public Stoppable_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public Stoppable_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public Stoppable_pcl () throws Exception { super (); }
  
  
}


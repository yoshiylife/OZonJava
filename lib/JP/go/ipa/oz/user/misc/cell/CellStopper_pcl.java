package JP.go.ipa.oz.user.misc.cell;

public class CellStopper_pcl extends JP.go.ipa.oz.lang._Proxy_cl implements JP.go.ipa.oz.user.misc.cell.CellStopper_if {
  protected int part;
  
  protected int selector;
  
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    if (part != 1) return super.invoke (o);
    
    JP.go.ipa.oz.user.misc.cell.CellStopper_if g = (JP.go.ipa.oz.user.misc.cell.CellStopper_if) o;
    Object result;
    
    switch (selector) {
    case 0:
      g.initialize();
      return null;
    case 1:
      g.quiet();
      return null;
    case 2:
      g.go();
      return null;
    default:
      throw new Exception ("CellStopper_pcl: invalid selector = " + selector);
    }
  }
  
  
  
  public void initialize () throws Exception {
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
  
  
  public void quiet () throws Exception {
    enter ();
    try {
      part = 1;
      selector = 1;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  
  public void go () throws Exception {
    enter ();
    try {
      part = 1;
      selector = 2;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  public CellStopper_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public CellStopper_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public CellStopper_pcl () throws Exception { super (); }
  
  
}


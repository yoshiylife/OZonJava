package JP.go.ipa.oz.user.apl.fed;

public class FedRoot_pcl extends JP.go.ipa.oz.lang._Proxy_cl implements JP.go.ipa.oz.user.apl.fed.FedRoot_if {
  protected int part;
  
  protected int selector;
  
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    if (part != 1) return super.invoke (o);
    
    JP.go.ipa.oz.user.apl.fed.FedRoot_if g = (JP.go.ipa.oz.user.apl.fed.FedRoot_if) o;
    Object result;
    
    switch (selector) {
    case 0:
      return g.god();
      
    case 1:
      g.debug(arg$0of1$flag);
      return null;
    case 2:
      g.init();
      return null;
    case 3:
      g.setClassName(arg$0of3$s);
      return null;
    case 4:
      return g.gol();
      
    case 5:
      g.debugInit();
      return null;
    case 6:
      return g.getClassName();
      
    case 7:
      g.quiet();
      return null;
    case 8:
      g.initialize();
      return null;
    default:
      throw new Exception ("FedRoot_pcl: invalid selector = " + selector);
    }
  }
  
  
  
  public final JP.go.ipa.oz.lib.standard._String_if god () throws Exception {
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
    return (JP.go.ipa.oz.lib.standard._String_if) join ();
  }
  
  boolean arg$0of1$flag;
  
  public void debug (boolean flag) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 1;
      arg$0of1$flag = flag;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of1$flag = false;
      leave ();
    }
    join ();
  }
  
  
  public void init () throws Exception {
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
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of3$s;
  
  public final void setClassName (JP.go.ipa.oz.lib.standard._String_if s) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 3;
      arg$0of3$s = s;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of3$s = null;
      leave ();
    }
    join ();
  }
  
  
  public final JP.go.ipa.oz.lib.standard._String_if gol () throws Exception {
    enter ();
    try {
      part = 1;
      selector = 4;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._String_if) join ();
  }
  
  
  public void debugInit () throws Exception {
    enter ();
    try {
      part = 1;
      selector = 5;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  
  public final JP.go.ipa.oz.lib.standard._String_if getClassName () throws Exception {
    enter ();
    try {
      part = 1;
      selector = 6;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._String_if) join ();
  }
  
  
  public void quiet () throws Exception {
    enter ();
    try {
      part = 1;
      selector = 7;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  
  public void initialize () throws Exception {
    enter ();
    try {
      part = 1;
      selector = 8;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  public FedRoot_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public FedRoot_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public FedRoot_pcl () throws Exception { super (); }
  
  
}


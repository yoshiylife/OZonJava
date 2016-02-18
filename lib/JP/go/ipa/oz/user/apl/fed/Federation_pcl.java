package JP.go.ipa.oz.user.apl.fed;

public class Federation_pcl extends JP.go.ipa.oz.user.apl.fed.Autonomy_pcl implements JP.go.ipa.oz.user.apl.fed.Federation_if {
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    if (part != 4) return super.invoke (o);
    
    JP.go.ipa.oz.user.apl.fed.Federation_if g = (JP.go.ipa.oz.user.apl.fed.Federation_if) o;
    Object result;
    
    switch (selector) {
    case 0:
      g.init();
      return null;
    case 1:
      return g.getAdapter(arg$0of1$resType, arg$1of1$pivots);
      
    case 2:
      g.addAutonomy(arg$0of2$autonomy);
      return null;
    case 3:
      g.removeAutonomy(arg$0of3$autonomy);
      return null;
    case 4:
      return g.findRelayProxy(arg$0of4$pivots, arg$1of4$adapter);
      
    case 5:
      return g.getAutonomies();
      
    default:
      throw new Exception ("Federation_pcl: invalid selector = " + selector);
    }
  }
  
  
  
  public void init () throws Exception {
    enter ();
    try {
      part = 4;
      selector = 0;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of1$resType;
  JP.go.ipa.oz.lib.standard._Set_if arg$1of1$pivots;
  
  public JP.go.ipa.oz.user.apl.fed.ResourceProxy_if getAdapter (JP.go.ipa.oz.lib.standard._String_if resType, JP.go.ipa.oz.lib.standard._Set_if pivots) throws Exception {
    enter ();
    try {
      part = 4;
      selector = 1;
      arg$0of1$resType = resType;
      arg$1of1$pivots = pivots;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of1$resType = null;
      arg$1of1$pivots = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of2$autonomy;
  
  public void addAutonomy (JP.go.ipa.oz.lib.standard._String_if autonomy) throws Exception {
    enter ();
    try {
      part = 4;
      selector = 2;
      arg$0of2$autonomy = autonomy;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of2$autonomy = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of3$autonomy;
  
  public void removeAutonomy (JP.go.ipa.oz.lib.standard._String_if autonomy) throws Exception {
    enter ();
    try {
      part = 4;
      selector = 3;
      arg$0of3$autonomy = autonomy;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of3$autonomy = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._Set_if arg$0of4$pivots;
  JP.go.ipa.oz.user.apl.fed.ResourceProxy_if arg$1of4$adapter;
  
  public JP.go.ipa.oz.user.apl.fed.ResourceProxy_if findRelayProxy (JP.go.ipa.oz.lib.standard._Set_if pivots, JP.go.ipa.oz.user.apl.fed.ResourceProxy_if adapter) throws Exception {
    enter ();
    try {
      part = 4;
      selector = 4;
      arg$0of4$pivots = pivots;
      arg$1of4$adapter = adapter;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of4$pivots = null;
      arg$1of4$adapter = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if) join ();
  }
  
  
  public JP.go.ipa.oz.lib.standard._Dictionary_if getAutonomies () throws Exception {
    enter ();
    try {
      part = 4;
      selector = 5;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._Dictionary_if) join ();
  }
  
  public Federation_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public Federation_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public Federation_pcl () throws Exception { super (); }
  
  
}


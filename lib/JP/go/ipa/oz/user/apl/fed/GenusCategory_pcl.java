package JP.go.ipa.oz.user.apl.fed;

public class GenusCategory_pcl extends JP.go.ipa.oz.user.apl.fed.FedRoot_pcl implements JP.go.ipa.oz.user.apl.fed.GenusCategory_if {
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    if (part != 2) return super.invoke (o);
    
    JP.go.ipa.oz.user.apl.fed.GenusCategory_if g = (JP.go.ipa.oz.user.apl.fed.GenusCategory_if) o;
    Object result;
    
    switch (selector) {
    case 0:
      return g.getType();
      
    case 1:
      g.init();
      return null;
    case 2:
      boolean rval$2 = g.isMemberOf(arg$0of2$s);
      return new Boolean(rval$2);
    case 3:
      g.setType(arg$0of3$s);
      return null;
    case 4:
      g.setCategoryName(arg$0of4$s);
      return null;
    case 5:
      g.quiet();
      return null;
    case 6:
      return g.getCategoryName();
      
    default:
      throw new Exception ("GenusCategory_pcl: invalid selector = " + selector);
    }
  }
  
  
  
  public JP.go.ipa.oz.lib.standard._String_if getType () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 0;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._String_if) join ();
  }
  
  
  public void init () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 1;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of2$s;
  
  public boolean isMemberOf (JP.go.ipa.oz.lib.standard._String_if s) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 2;
      arg$0of2$s = s;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of2$s = null;
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of3$s;
  
  public void setType (JP.go.ipa.oz.lib.standard._String_if s) throws Exception {
    enter ();
    try {
      part = 2;
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
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of4$s;
  
  public void setCategoryName (JP.go.ipa.oz.lib.standard._String_if s) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 4;
      arg$0of4$s = s;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of4$s = null;
      leave ();
    }
    join ();
  }
  
  
  public void quiet () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 5;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  
  public JP.go.ipa.oz.lib.standard._String_if getCategoryName () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 6;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._String_if) join ();
  }
  
  public GenusCategory_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public GenusCategory_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public GenusCategory_pcl () throws Exception { super (); }
  
  
}


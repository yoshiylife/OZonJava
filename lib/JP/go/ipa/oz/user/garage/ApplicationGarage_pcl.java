package JP.go.ipa.oz.user.garage;

public class ApplicationGarage_pcl extends JP.go.ipa.oz.user.garage.SGarage_pcl implements JP.go.ipa.oz.user.garage.ApplicationGarage_if {
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    if (part != 3) return super.invoke (o);
    
    JP.go.ipa.oz.user.garage.ApplicationGarage_if g = (JP.go.ipa.oz.user.garage.ApplicationGarage_if) o;
    Object result;
    
    switch (selector) {
    case 0:
      return g.getApplication(arg$0of0$key);
      
    case 1:
      return g.putApplication(arg$0of1$app);
      
    case 2:
      g.replaceApplication(arg$0of2$key, arg$1of2$app);
      return null;
    default:
      throw new Exception ("ApplicationGarage_pcl: invalid selector = " + selector);
    }
  }
  
  
  JP.go.ipa.oz.user.garage.Key_if arg$0of0$key;
  
  public JP.go.ipa.oz.user.ide.Application_if getApplication (JP.go.ipa.oz.user.garage.Key_if key) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 0;
      arg$0of0$key = key;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of0$key = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.ide.Application_if) join ();
  }
  
  JP.go.ipa.oz.user.ide.Application_if arg$0of1$app;
  
  public JP.go.ipa.oz.user.garage.Key_if putApplication (JP.go.ipa.oz.user.ide.Application_if app) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 1;
      arg$0of1$app = app;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of1$app = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.garage.Key_if) join ();
  }
  
  JP.go.ipa.oz.user.garage.Key_if arg$0of2$key;
  JP.go.ipa.oz.user.ide.Application_if arg$1of2$app;
  
  public void replaceApplication (JP.go.ipa.oz.user.garage.Key_if key, JP.go.ipa.oz.user.ide.Application_if app) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 2;
      arg$0of2$key = key;
      arg$1of2$app = app;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of2$key = null;
      arg$1of2$app = null;
      leave ();
    }
    join ();
  }
  
  public ApplicationGarage_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public ApplicationGarage_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public ApplicationGarage_pcl () throws Exception { super (); }
  
  
}


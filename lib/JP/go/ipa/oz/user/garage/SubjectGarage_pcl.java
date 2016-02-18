package JP.go.ipa.oz.user.garage;

public class SubjectGarage_pcl extends JP.go.ipa.oz.user.garage.SGarage_pcl implements JP.go.ipa.oz.user.garage.SubjectGarage_if {
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    if (part != 3) return super.invoke (o);
    
    JP.go.ipa.oz.user.garage.SubjectGarage_if g = (JP.go.ipa.oz.user.garage.SubjectGarage_if) o;
    Object result;
    
    switch (selector) {
    case 0:
      return g.getSubject(arg$0of0$key);
      
    case 1:
      g.replaceSubject(arg$0of1$key, arg$1of1$sbj);
      return null;
    case 2:
      return g.putSubject(arg$0of2$sbj);
      
    default:
      throw new Exception ("SubjectGarage_pcl: invalid selector = " + selector);
    }
  }
  
  
  JP.go.ipa.oz.user.garage.Key_if arg$0of0$key;
  
  public JP.go.ipa.oz.user.ide.Subject_if getSubject (JP.go.ipa.oz.user.garage.Key_if key) throws Exception {
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
    return (JP.go.ipa.oz.user.ide.Subject_if) join ();
  }
  
  JP.go.ipa.oz.user.garage.Key_if arg$0of1$key;
  JP.go.ipa.oz.user.ide.Subject_if arg$1of1$sbj;
  
  public void replaceSubject (JP.go.ipa.oz.user.garage.Key_if key, JP.go.ipa.oz.user.ide.Subject_if sbj) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 1;
      arg$0of1$key = key;
      arg$1of1$sbj = sbj;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of1$key = null;
      arg$1of1$sbj = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.ide.Subject_if arg$0of2$sbj;
  
  public JP.go.ipa.oz.user.garage.Key_if putSubject (JP.go.ipa.oz.user.ide.Subject_if sbj) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 2;
      arg$0of2$sbj = sbj;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of2$sbj = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.garage.Key_if) join ();
  }
  
  public SubjectGarage_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public SubjectGarage_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public SubjectGarage_pcl () throws Exception { super (); }
  
  
}


package JP.go.ipa.oz.user.garage;

public class SGarage_pcl extends JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_pcl implements JP.go.ipa.oz.user.garage.SGarage_if {
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    if (part != 2) return super.invoke (o);
    
    JP.go.ipa.oz.user.garage.SGarage_if g = (JP.go.ipa.oz.user.garage.SGarage_if) o;
    Object result;
    
    switch (selector) {
    case 0:
      return g.iterator();
      
    case 1:
      g.replace(arg$0of1$key, arg$1of1$sbl);
      return null;
    case 2:
      return g.getSummary(arg$0of2$key);
      
    case 3:
      g.stop();
      return null;
    case 4:
      g.remove(arg$0of4$key);
      return null;
    case 5:
      g.replaceSummary(arg$0of5$key, arg$1of5$sm);
      return null;
    case 6:
      return g.summaryIterator();
      
    case 7:
      return g.get(arg$0of7$key);
      
    case 8:
      return g.put(arg$0of8$sbl);
      
    default:
      throw new Exception ("SGarage_pcl: invalid selector = " + selector);
    }
  }
  
  
  
  public JP.go.ipa.oz.lib.standard._Iterator_if iterator () throws Exception {
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
    return (JP.go.ipa.oz.lib.standard._Iterator_if) join ();
  }
  
  JP.go.ipa.oz.user.garage.Key_if arg$0of1$key;
  JP.go.ipa.oz.user.ide.Summarizable_if arg$1of1$sbl;
  
  public void replace (JP.go.ipa.oz.user.garage.Key_if key, JP.go.ipa.oz.user.ide.Summarizable_if sbl) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 1;
      arg$0of1$key = key;
      arg$1of1$sbl = sbl;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of1$key = null;
      arg$1of1$sbl = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.garage.Key_if arg$0of2$key;
  
  public JP.go.ipa.oz.user.ide.Summary_if getSummary (JP.go.ipa.oz.user.garage.Key_if key) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 2;
      arg$0of2$key = key;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of2$key = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.ide.Summary_if) join ();
  }
  
  
  public void stop () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 3;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.garage.Key_if arg$0of4$key;
  
  public void remove (JP.go.ipa.oz.user.garage.Key_if key) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 4;
      arg$0of4$key = key;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of4$key = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.garage.Key_if arg$0of5$key;
  JP.go.ipa.oz.user.ide.Summary_if arg$1of5$sm;
  
  public void replaceSummary (JP.go.ipa.oz.user.garage.Key_if key, JP.go.ipa.oz.user.ide.Summary_if sm) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 5;
      arg$0of5$key = key;
      arg$1of5$sm = sm;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of5$key = null;
      arg$1of5$sm = null;
      leave ();
    }
    join ();
  }
  
  
  public JP.go.ipa.oz.lib.standard._Iterator_if summaryIterator () throws Exception {
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
    return (JP.go.ipa.oz.lib.standard._Iterator_if) join ();
  }
  
  JP.go.ipa.oz.user.garage.Key_if arg$0of7$key;
  
  public JP.go.ipa.oz.user.ide.Summarizable_if get (JP.go.ipa.oz.user.garage.Key_if key) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 7;
      arg$0of7$key = key;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of7$key = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.ide.Summarizable_if) join ();
  }
  
  JP.go.ipa.oz.user.ide.Summarizable_if arg$0of8$sbl;
  
  public JP.go.ipa.oz.user.garage.Key_if put (JP.go.ipa.oz.user.ide.Summarizable_if sbl) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 8;
      arg$0of8$sbl = sbl;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of8$sbl = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.garage.Key_if) join ();
  }
  
  public SGarage_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public SGarage_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public SGarage_pcl () throws Exception { super (); }
  
  
}


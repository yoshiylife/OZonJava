package JP.go.ipa.oz.user.apl.fed;

public class Autonomy_pcl extends JP.go.ipa.oz.user.apl.fed.GenusCategory_pcl implements JP.go.ipa.oz.user.apl.fed.Autonomy_if {
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    if (part != 3) return super.invoke (o);
    
    JP.go.ipa.oz.user.apl.fed.Autonomy_if g = (JP.go.ipa.oz.user.apl.fed.Autonomy_if) o;
    Object result;
    
    switch (selector) {
    case 0:
      g.setResourceProxyToCache(arg$0of0$proxy);
      return null;
    case 1:
      g.removeResource(arg$0of1$resource);
      return null;
    case 2:
      return g.findResourceProxy(arg$0of2$proxs, arg$1of2$resType, arg$2of2$autoType);
      
    case 3:
      return g.getResourceProxyByCache(arg$0of3$resGol);
      
    case 4:
      boolean rval$4 = g.containsResource(arg$0of4$resource);
      return new Boolean(rval$4);
    case 5:
      g.flushCache(arg$0of5$resGol);
      return null;
    case 6:
      g.flushCache();
      return null;
    case 7:
      g.init();
      return null;
    case 8:
      g.addResourceProxy(arg$0of8$proxy);
      return null;
    case 9:
      return g.getResourceProxies();
      
    case 10:
      return g.getCache();
      
    case 11:
      g.attachToFederation(arg$0of11$gol);
      return null;
    case 12:
      return g.getSurrogatePivots();
      
    case 13:
      g.removeResourceProxy(arg$0of13$proxy);
      return null;
    case 14:
      return g.getResourceProxy(arg$0of14$resType, arg$1of14$pivot, arg$2of14$autoType);
      
    case 15:
      return g.getFederations();
      
    case 16:
      return g.asString();
      
    case 17:
      g.addResource(arg$0of17$resource);
      return null;
    case 18:
      return g.findSurrogate(arg$0of18$resType, arg$1of18$autoType);
      
    case 19:
      return g.getAdapters();
      
    case 20:
      return g.exportResource(arg$0of20$pivots);
      
    case 21:
      return g.getAdapter(arg$0of21$resType, arg$1of21$pivots);
      
    case 22:
      return g.getAdapterPivots();
      
    case 23:
      return g.getResources();
      
    case 24:
      return g.findAdapter(arg$0of24$autoType, arg$1of24$resType);
      
    case 25:
      g.detachFromFederation(arg$0of25$gol);
      return null;
    case 26:
      return g.getSurrogates();
      
    case 27:
      return g.importResource(arg$0of27$gol);
      
    case 28:
      return g.importResource(arg$0of28$resGol, arg$1of28$pivot);
      
    default:
      throw new Exception ("Autonomy_pcl: invalid selector = " + selector);
    }
  }
  
  
  JP.go.ipa.oz.user.apl.fed.ResourceProxy_if arg$0of0$proxy;
  
  public void setResourceProxyToCache (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if proxy) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 0;
      arg$0of0$proxy = proxy;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of0$proxy = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of1$resource;
  
  public void removeResource (JP.go.ipa.oz.lib.standard._String_if resource) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 1;
      arg$0of1$resource = resource;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of1$resource = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._Set_if arg$0of2$proxs;
  JP.go.ipa.oz.lib.standard._String_if arg$1of2$resType;
  JP.go.ipa.oz.lib.standard._String_if arg$2of2$autoType;
  
  public JP.go.ipa.oz.user.apl.fed.ResourceProxy_if findResourceProxy (JP.go.ipa.oz.lib.standard._Set_if proxs, JP.go.ipa.oz.lib.standard._String_if resType, JP.go.ipa.oz.lib.standard._String_if autoType) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 2;
      arg$0of2$proxs = proxs;
      arg$1of2$resType = resType;
      arg$2of2$autoType = autoType;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of2$proxs = null;
      arg$1of2$resType = null;
      arg$2of2$autoType = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of3$resGol;
  
  public JP.go.ipa.oz.user.apl.fed.ResourceProxy_if getResourceProxyByCache (JP.go.ipa.oz.lib.standard._String_if resGol) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 3;
      arg$0of3$resGol = resGol;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of3$resGol = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of4$resource;
  
  public boolean containsResource (JP.go.ipa.oz.lib.standard._String_if resource) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 4;
      arg$0of4$resource = resource;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of4$resource = null;
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of5$resGol;
  
  public void flushCache (JP.go.ipa.oz.lib.standard._String_if resGol) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 5;
      arg$0of5$resGol = resGol;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of5$resGol = null;
      leave ();
    }
    join ();
  }
  
  
  public void flushCache () throws Exception {
    enter ();
    try {
      part = 3;
      selector = 6;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  
  public void init () throws Exception {
    enter ();
    try {
      part = 3;
      selector = 7;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.apl.fed.ResourceProxy_if arg$0of8$proxy;
  
  public void addResourceProxy (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if proxy) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 8;
      arg$0of8$proxy = proxy;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of8$proxy = null;
      leave ();
    }
    join ();
  }
  
  
  public JP.go.ipa.oz.lib.standard._Set_if getResourceProxies () throws Exception {
    enter ();
    try {
      part = 3;
      selector = 9;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._Set_if) join ();
  }
  
  
  public JP.go.ipa.oz.lib.standard._Set_if getCache () throws Exception {
    enter ();
    try {
      part = 3;
      selector = 10;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._Set_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of11$gol;
  
  public void attachToFederation (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 11;
      arg$0of11$gol = gol;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of11$gol = null;
      leave ();
    }
    join ();
  }
  
  
  public JP.go.ipa.oz.lib.standard._Set_if getSurrogatePivots () throws Exception {
    enter ();
    try {
      part = 3;
      selector = 12;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._Set_if) join ();
  }
  
  JP.go.ipa.oz.user.apl.fed.ResourceProxy_if arg$0of13$proxy;
  
  public void removeResourceProxy (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if proxy) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 13;
      arg$0of13$proxy = proxy;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of13$proxy = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of14$resType;
  JP.go.ipa.oz.lib.standard._String_if arg$1of14$pivot;
  JP.go.ipa.oz.lib.standard._String_if arg$2of14$autoType;
  
  public JP.go.ipa.oz.user.apl.fed.ResourceProxy_if getResourceProxy (JP.go.ipa.oz.lib.standard._String_if resType, JP.go.ipa.oz.lib.standard._String_if pivot, JP.go.ipa.oz.lib.standard._String_if autoType) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 14;
      arg$0of14$resType = resType;
      arg$1of14$pivot = pivot;
      arg$2of14$autoType = autoType;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of14$resType = null;
      arg$1of14$pivot = null;
      arg$2of14$autoType = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if) join ();
  }
  
  
  public JP.go.ipa.oz.lib.standard._Set_if getFederations () throws Exception {
    enter ();
    try {
      part = 3;
      selector = 15;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._Set_if) join ();
  }
  
  
  public JP.go.ipa.oz.lib.standard._String_if asString () throws Exception {
    enter ();
    try {
      part = 3;
      selector = 16;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._String_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of17$resource;
  
  public void addResource (JP.go.ipa.oz.lib.standard._String_if resource) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 17;
      arg$0of17$resource = resource;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of17$resource = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of18$resType;
  JP.go.ipa.oz.lib.standard._String_if arg$1of18$autoType;
  
  public JP.go.ipa.oz.user.apl.fed.ResourceProxy_if findSurrogate (JP.go.ipa.oz.lib.standard._String_if resType, JP.go.ipa.oz.lib.standard._String_if autoType) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 18;
      arg$0of18$resType = resType;
      arg$1of18$autoType = autoType;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of18$resType = null;
      arg$1of18$autoType = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if) join ();
  }
  
  
  public JP.go.ipa.oz.lib.standard._Set_if getAdapters () throws Exception {
    enter ();
    try {
      part = 3;
      selector = 19;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._Set_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._Set_if arg$0of20$pivots;
  
  public JP.go.ipa.oz.user.apl.fed.ResourceProxy_if exportResource (JP.go.ipa.oz.lib.standard._Set_if pivots) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 20;
      arg$0of20$pivots = pivots;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of20$pivots = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of21$resType;
  JP.go.ipa.oz.lib.standard._Set_if arg$1of21$pivots;
  
  public JP.go.ipa.oz.user.apl.fed.ResourceProxy_if getAdapter (JP.go.ipa.oz.lib.standard._String_if resType, JP.go.ipa.oz.lib.standard._Set_if pivots) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 21;
      arg$0of21$resType = resType;
      arg$1of21$pivots = pivots;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of21$resType = null;
      arg$1of21$pivots = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if) join ();
  }
  
  
  public JP.go.ipa.oz.lib.standard._Set_if getAdapterPivots () throws Exception {
    enter ();
    try {
      part = 3;
      selector = 22;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._Set_if) join ();
  }
  
  
  public JP.go.ipa.oz.lib.standard._Dictionary_if getResources () throws Exception {
    enter ();
    try {
      part = 3;
      selector = 23;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._Dictionary_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of24$autoType;
  JP.go.ipa.oz.lib.standard._String_if arg$1of24$resType;
  
  public JP.go.ipa.oz.user.apl.fed.ResourceProxy_if findAdapter (JP.go.ipa.oz.lib.standard._String_if autoType, JP.go.ipa.oz.lib.standard._String_if resType) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 24;
      arg$0of24$autoType = autoType;
      arg$1of24$resType = resType;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of24$autoType = null;
      arg$1of24$resType = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of25$gol;
  
  public void detachFromFederation (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 25;
      arg$0of25$gol = gol;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of25$gol = null;
      leave ();
    }
    join ();
  }
  
  
  public JP.go.ipa.oz.lib.standard._Set_if getSurrogates () throws Exception {
    enter ();
    try {
      part = 3;
      selector = 26;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._Set_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of27$gol;
  
  public JP.go.ipa.oz.user.apl.fed.ResourceProxy_if importResource (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 27;
      arg$0of27$gol = gol;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of27$gol = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of28$resGol;
  JP.go.ipa.oz.lib.standard._String_if arg$1of28$pivot;
  
  public JP.go.ipa.oz.user.apl.fed.ResourceProxy_if importResource (JP.go.ipa.oz.lib.standard._String_if resGol, JP.go.ipa.oz.lib.standard._String_if pivot) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 28;
      arg$0of28$resGol = resGol;
      arg$1of28$pivot = pivot;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of28$resGol = null;
      arg$1of28$pivot = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if) join ();
  }
  
  public Autonomy_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public Autonomy_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public Autonomy_pcl () throws Exception { super (); }
  
  
}


package JP.go.ipa.oz.user.lib_dist.replica;

public class CopyOfPeerCopyScheme_pcl extends JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_pcl implements JP.go.ipa.oz.user.lib_dist.replica.CopyOfPeerCopyScheme_if {
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    if (part != 3) return super.invoke (o);
    
    JP.go.ipa.oz.user.lib_dist.replica.CopyOfPeerCopyScheme_if g = (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPeerCopyScheme_if) o;
    Object result;
    
    switch (selector) {
    case 0:
      g.makeList(arg$0of0$list, arg$1of0$parent);
      return null;
    case 1:
      return g.getCopy(arg$0of1$cpGol);
      
    case 2:
      return g.getClientStub();
      
    case 3:
      boolean rval$3 = g.propagateAll();
      return new Boolean(rval$3);
    case 4:
      g.newCopyAt(arg$0of4$newCopy, arg$1of4$gol, arg$2of4$mngGol);
      return null;
    case 5:
      g.update();
      return null;
    case 6:
      g.addOtherCopy(arg$0of6$newRes);
      return null;
    default:
      throw new Exception ("CopyOfPeerCopyScheme_pcl: invalid selector = " + selector);
    }
  }
  
  
  JP.go.ipa.oz.lib.standard._Set_if arg$0of0$list;
  JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if arg$1of0$parent;
  
  public void makeList (JP.go.ipa.oz.lib.standard._Set_if list, JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if parent) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 0;
      arg$0of0$list = list;
      arg$1of0$parent = parent;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of0$list = null;
      arg$1of0$parent = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of1$cpGol;
  
  public JP.go.ipa.oz.user.lib_dist.replica.CopyOfPeerCopyScheme_if getCopy (JP.go.ipa.oz.lib.standard._String_if cpGol) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 1;
      arg$0of1$cpGol = cpGol;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of1$cpGol = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPeerCopyScheme_if) join ();
  }
  
  
  public JP.go.ipa.oz.user.lib_dist.replica.CopyOfPeerCopyScheme_if getClientStub () throws Exception {
    enter ();
    try {
      part = 3;
      selector = 2;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    return (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPeerCopyScheme_if) join ();
  }
  
  
  public boolean propagateAll () throws Exception {
    enter ();
    try {
      part = 3;
      selector = 3;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  JP.go.ipa.oz.user.lib_dist.replica.CopyOfPeerCopyScheme_if arg$0of4$newCopy;
  JP.go.ipa.oz.lib.standard._String_if arg$1of4$gol;
  JP.go.ipa.oz.lib.standard._String_if arg$2of4$mngGol;
  
  public void newCopyAt (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPeerCopyScheme_if newCopy, JP.go.ipa.oz.lib.standard._String_if gol, JP.go.ipa.oz.lib.standard._String_if mngGol) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 4;
      arg$0of4$newCopy = newCopy;
      arg$1of4$gol = gol;
      arg$2of4$mngGol = mngGol;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of4$newCopy = null;
      arg$1of4$gol = null;
      arg$2of4$mngGol = null;
      leave ();
    }
    join ();
  }
  
  
  public void update () throws Exception {
    enter ();
    try {
      part = 3;
      selector = 5;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if arg$0of6$newRes;
  
  public void addOtherCopy (JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if newRes) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 6;
      arg$0of6$newRes = newRes;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of6$newRes = null;
      leave ();
    }
    join ();
  }
  
  public CopyOfPeerCopyScheme_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public CopyOfPeerCopyScheme_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public CopyOfPeerCopyScheme_pcl () throws Exception { super (); }
  
  
}


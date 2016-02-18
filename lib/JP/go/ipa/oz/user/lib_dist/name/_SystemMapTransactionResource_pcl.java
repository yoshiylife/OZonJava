package JP.go.ipa.oz.user.lib_dist.name;

public class _SystemMapTransactionResource_pcl extends JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_pcl implements JP.go.ipa.oz.user.lib_dist.name._SystemMapTransactionResource_if {
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    if (part != 2) return super.invoke (o);
    
    JP.go.ipa.oz.user.lib_dist.name._SystemMapTransactionResource_if g = (JP.go.ipa.oz.user.lib_dist.name._SystemMapTransactionResource_if) o;
    Object result;
    
    switch (selector) {
    case 0:
      g.restored(arg$0of0$serverNSTRGOL);
      return null;
    case 1:
      g.troubleWith(arg$0of1$serverNSTRGOL);
      return null;
    case 2:
      g.troubleControlPollingStart();
      return null;
    case 3:
      g.debugPrint();
      return null;
    case 4:
      g.setDelimitor(arg$0of4$s);
      return null;
    case 5:
      return g.FindOwner(arg$0of5$path);
      
    case 6:
      g.putBranch(arg$0of6$path, arg$1of6$toGOL);
      return null;
    case 7:
      g.addMapping(arg$0of7$path, arg$1of7$to, arg$2of7$serverNSTGOL);
      return null;
    case 8:
      g.unBranched(arg$0of8$path);
      return null;
    case 9:
      g.setDomainName(arg$0of9$s);
      return null;
    case 10:
      boolean rval$10 = g.containServer(arg$0of10$serverGOL);
      return new Boolean(rval$10);
    case 11:
      g.RemoveNameServer(arg$0of11$serverGOL);
      return null;
    case 12:
      g.replaceBranch(arg$0of12$path, arg$1of12$toGOL);
      return null;
    case 13:
      g.AddNameServer(arg$0of13$serverGOL);
      return null;
    default:
      throw new Exception ("_SystemMapTransactionResource_pcl: invalid selector = " + selector);
    }
  }
  
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of0$serverNSTRGOL;
  
  public void restored (JP.go.ipa.oz.lib.standard._String_if serverNSTRGOL) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 0;
      arg$0of0$serverNSTRGOL = serverNSTRGOL;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of0$serverNSTRGOL = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of1$serverNSTRGOL;
  
  public void troubleWith (JP.go.ipa.oz.lib.standard._String_if serverNSTRGOL) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 1;
      arg$0of1$serverNSTRGOL = serverNSTRGOL;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of1$serverNSTRGOL = null;
      leave ();
    }
    join ();
  }
  
  
  public void troubleControlPollingStart () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 2;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  
  public void debugPrint () throws Exception {
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
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of4$s;
  
  public void setDelimitor (JP.go.ipa.oz.lib.standard._String_if s) throws Exception {
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
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of5$path;
  
  public JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if FindOwner (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 5;
      arg$0of5$path = path;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of5$path = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if) join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of6$path;
  JP.go.ipa.oz.lib.standard._String_if arg$1of6$toGOL;
  
  public void putBranch (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.lib.standard._String_if toGOL) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 6;
      arg$0of6$path = path;
      arg$1of6$toGOL = toGOL;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of6$path = null;
      arg$1of6$toGOL = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of7$path;
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$1of7$to;
  JP.go.ipa.oz.lib.standard._String_if arg$2of7$serverNSTGOL;
  
  public void addMapping (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.user.lib_dist.name._Path_if to, JP.go.ipa.oz.lib.standard._String_if serverNSTGOL) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 7;
      arg$0of7$path = path;
      arg$1of7$to = to;
      arg$2of7$serverNSTGOL = serverNSTGOL;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of7$path = null;
      arg$1of7$to = null;
      arg$2of7$serverNSTGOL = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of8$path;
  
  public void unBranched (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 8;
      arg$0of8$path = path;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of8$path = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of9$s;
  
  public void setDomainName (JP.go.ipa.oz.lib.standard._String_if s) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 9;
      arg$0of9$s = s;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of9$s = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of10$serverGOL;
  
  public boolean containServer (JP.go.ipa.oz.lib.standard._String_if serverGOL) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 10;
      arg$0of10$serverGOL = serverGOL;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of10$serverGOL = null;
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of11$serverGOL;
  
  public void RemoveNameServer (JP.go.ipa.oz.lib.standard._String_if serverGOL) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 11;
      arg$0of11$serverGOL = serverGOL;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of11$serverGOL = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of12$path;
  JP.go.ipa.oz.lib.standard._String_if arg$1of12$toGOL;
  
  public void replaceBranch (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.lib.standard._String_if toGOL) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 12;
      arg$0of12$path = path;
      arg$1of12$toGOL = toGOL;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of12$path = null;
      arg$1of12$toGOL = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of13$serverGOL;
  
  public void AddNameServer (JP.go.ipa.oz.lib.standard._String_if serverGOL) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 13;
      arg$0of13$serverGOL = serverGOL;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of13$serverGOL = null;
      leave ();
    }
    join ();
  }
  
  public _SystemMapTransactionResource_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public _SystemMapTransactionResource_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public _SystemMapTransactionResource_pcl () throws Exception { super (); }
  
  
}


package JP.go.ipa.oz.user.lib_dist.name;

public class _NameServerTransaction_pcl extends JP.go.ipa.oz.user.lib_dist.tran._Transaction_pcl implements JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_if {
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    if (part != 2) return super.invoke (o);
    
    JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_if g = (JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_if) o;
    Object result;
    
    switch (selector) {
    case 0:
      return g.renameEntry(arg$0of0$source, arg$1of0$target);
      
    case 1:
      g.putDirectoryAsBranch(arg$0of1$path);
      return null;
    case 2:
      g.putDirectoryAsBranch(arg$0of2$path, arg$1of2$dir);
      return null;
    case 3:
      int rval$3 = g.EntrySize(arg$0of3$path);
      return new Integer(rval$3);
    case 4:
      return g.getEntry(arg$0of4$path);
      
    case 5:
      return g.removeDirectory(arg$0of5$path);
      
    case 6:
      boolean rval$6 = g.containDirectory(arg$0of6$path);
      return new Boolean(rval$6);
    case 7:
      return g.OwnerNSTR(arg$0of7$path);
      
    case 8:
      g.unBranched(arg$0of8$path);
      return null;
    case 9:
      g.moveBranch(arg$0of9$path, arg$1of9$toGOL);
      return null;
    case 10:
      g.debugPrint();
      return null;
    case 11:
      return g.DirectorySet(arg$0of11$path);
      
    case 12:
      return g.getDirectory(arg$0of12$path);
      
    case 13:
      g.setSystemMapTransactionResource(arg$0of13$s);
      return null;
    case 14:
      g.setNameServerTransactionResource(arg$0of14$s);
      return null;
    case 15:
      return g.removeEntry(arg$0of15$path);
      
    case 16:
      g.removeNameServer();
      return null;
    case 17:
      int rval$17 = g.DirectorySize(arg$0of17$path);
      return new Integer(rval$17);
    case 18:
      return g.EntrySet(arg$0of18$path);
      
    case 19:
      g.putDirectory(arg$0of19$path);
      return null;
    case 20:
      g.putDirectory(arg$0of20$path, arg$1of20$subdir);
      return null;
    case 21:
      g.putEntry(arg$0of21$path, arg$1of21$ent);
      return null;
    case 22:
      boolean rval$22 = g.containEntry(arg$0of22$path);
      return new Boolean(rval$22);
    case 23:
      return g.renameDirectory(arg$0of23$source, arg$1of23$target);
      
    case 24:
      g.addNameServer();
      return null;
    case 25:
      g.putDirectoryAsMapping(arg$0of25$path, arg$1of25$to, arg$2of25$serverNSTGOL);
      return null;
    default:
      throw new Exception ("_NameServerTransaction_pcl: invalid selector = " + selector);
    }
  }
  
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of0$source;
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$1of0$target;
  
  public JP.go.ipa.oz.lang._Root_if renameEntry (JP.go.ipa.oz.user.lib_dist.name._Path_if source, JP.go.ipa.oz.user.lib_dist.name._Path_if target) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 0;
      arg$0of0$source = source;
      arg$1of0$target = target;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of0$source = null;
      arg$1of0$target = null;
      leave ();
    }
    return (JP.go.ipa.oz.lang._Root_if) join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of1$path;
  
  public void putDirectoryAsBranch (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 1;
      arg$0of1$path = path;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of1$path = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of2$path;
  JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if arg$1of2$dir;
  
  public void putDirectoryAsBranch (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if dir) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 2;
      arg$0of2$path = path;
      arg$1of2$dir = dir;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of2$path = null;
      arg$1of2$dir = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of3$path;
  
  public int EntrySize (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 3;
      arg$0of3$path = path;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of3$path = null;
      leave ();
    }
    Integer result = (Integer) join ();
    return result.intValue ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of4$path;
  
  public JP.go.ipa.oz.lang._Root_if getEntry (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 4;
      arg$0of4$path = path;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of4$path = null;
      leave ();
    }
    return (JP.go.ipa.oz.lang._Root_if) join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of5$path;
  
  public JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if removeDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
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
    return (JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if) join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of6$path;
  
  public boolean containDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 6;
      arg$0of6$path = path;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of6$path = null;
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of7$path;
  
  public JP.go.ipa.oz.lib.standard._String_if OwnerNSTR (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 7;
      arg$0of7$path = path;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of7$path = null;
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._String_if) join ();
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
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of9$path;
  JP.go.ipa.oz.lib.standard._String_if arg$1of9$toGOL;
  
  public void moveBranch (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.lib.standard._String_if toGOL) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 9;
      arg$0of9$path = path;
      arg$1of9$toGOL = toGOL;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of9$path = null;
      arg$1of9$toGOL = null;
      leave ();
    }
    join ();
  }
  
  
  public void debugPrint () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 10;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of11$path;
  
  public JP.go.ipa.oz.lib.standard._Set_if DirectorySet (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 11;
      arg$0of11$path = path;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of11$path = null;
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._Set_if) join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of12$path;
  
  public JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if getDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 12;
      arg$0of12$path = path;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of12$path = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of13$s;
  
  public void setSystemMapTransactionResource (JP.go.ipa.oz.lib.standard._String_if s) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 13;
      arg$0of13$s = s;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of13$s = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of14$s;
  
  public void setNameServerTransactionResource (JP.go.ipa.oz.lib.standard._String_if s) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 14;
      arg$0of14$s = s;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of14$s = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of15$path;
  
  public JP.go.ipa.oz.lang._Root_if removeEntry (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 15;
      arg$0of15$path = path;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of15$path = null;
      leave ();
    }
    return (JP.go.ipa.oz.lang._Root_if) join ();
  }
  
  
  public void removeNameServer () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 16;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of17$path;
  
  public int DirectorySize (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 17;
      arg$0of17$path = path;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of17$path = null;
      leave ();
    }
    Integer result = (Integer) join ();
    return result.intValue ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of18$path;
  
  public JP.go.ipa.oz.lib.standard._Set_if EntrySet (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 18;
      arg$0of18$path = path;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of18$path = null;
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._Set_if) join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of19$path;
  
  public void putDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 19;
      arg$0of19$path = path;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of19$path = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of20$path;
  JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if arg$1of20$subdir;
  
  public void putDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if subdir) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 20;
      arg$0of20$path = path;
      arg$1of20$subdir = subdir;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of20$path = null;
      arg$1of20$subdir = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of21$path;
  JP.go.ipa.oz.lang._Root_if arg$1of21$ent;
  
  public void putEntry (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.lang._Root_if ent) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 21;
      arg$0of21$path = path;
      arg$1of21$ent = ent;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of21$path = null;
      arg$1of21$ent = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of22$path;
  
  public boolean containEntry (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 22;
      arg$0of22$path = path;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of22$path = null;
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of23$source;
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$1of23$target;
  
  public JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if renameDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if source, JP.go.ipa.oz.user.lib_dist.name._Path_if target) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 23;
      arg$0of23$source = source;
      arg$1of23$target = target;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of23$source = null;
      arg$1of23$target = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if) join ();
  }
  
  
  public void addNameServer () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 24;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of25$path;
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$1of25$to;
  JP.go.ipa.oz.lib.standard._String_if arg$2of25$serverNSTGOL;
  
  public void putDirectoryAsMapping (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.user.lib_dist.name._Path_if to, JP.go.ipa.oz.lib.standard._String_if serverNSTGOL) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 25;
      arg$0of25$path = path;
      arg$1of25$to = to;
      arg$2of25$serverNSTGOL = serverNSTGOL;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of25$path = null;
      arg$1of25$to = null;
      arg$2of25$serverNSTGOL = null;
      leave ();
    }
    join ();
  }
  
  public _NameServerTransaction_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public _NameServerTransaction_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public _NameServerTransaction_pcl () throws Exception { super (); }
  
  
}


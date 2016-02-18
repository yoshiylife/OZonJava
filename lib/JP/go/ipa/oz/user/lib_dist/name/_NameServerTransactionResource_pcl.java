package JP.go.ipa.oz.user.lib_dist.name;

public class _NameServerTransactionResource_pcl extends JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_pcl implements JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_if {
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    if (part != 2) return super.invoke (o);
    
    JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_if g = (JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_if) o;
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
      g.putBranch(arg$0of3$path, arg$1of3$nd);
      return null;
    case 4:
      int rval$4 = g.EntrySize(arg$0of4$path);
      return new Integer(rval$4);
    case 5:
      g.setDelimitor(arg$0of5$s);
      return null;
    case 6:
      return g.getEntry(arg$0of6$path);
      
    case 7:
      return g.removeDirectory(arg$0of7$path);
      
    case 8:
      boolean rval$8 = g.containDirectory(arg$0of8$path);
      return new Boolean(rval$8);
    case 9:
      g.unBranched(arg$0of9$path);
      return null;
    case 10:
      g.debugPrint();
      return null;
    case 11:
      g.replaceBranch(arg$0of11$path, arg$1of11$toGOL);
      return null;
    case 12:
      return g.DirectorySet(arg$0of12$path);
      
    case 13:
      return g.getDirectory(arg$0of13$path);
      
    case 14:
      return g.removeEntry(arg$0of14$path);
      
    case 15:
      return g.getBranches();
      
    case 16:
      int rval$16 = g.DirectorySize(arg$0of16$path);
      return new Integer(rval$16);
    case 17:
      g.putBranchInOtherCell(arg$0of17$path);
      return null;
    case 18:
      return g.EntrySet(arg$0of18$path);
      
    case 19:
      g.putDirectory(arg$0of19$path);
      return null;
    case 20:
      g.putDirectory(arg$0of20$path, arg$1of20$subdir);
      return null;
    case 21:
      boolean rval$21 = g.ping();
      return new Boolean(rval$21);
    case 22:
      g.putEntry(arg$0of22$path, arg$1of22$ent);
      return null;
    case 23:
      boolean rval$23 = g.containEntry(arg$0of23$path);
      return new Boolean(rval$23);
    case 24:
      return g.renameDirectory(arg$0of24$source, arg$1of24$target);
      
    default:
      throw new Exception ("_NameServerTransactionResource_pcl: invalid selector = " + selector);
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
  JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if arg$1of3$nd;
  
  public void putBranch (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 3;
      arg$0of3$path = path;
      arg$1of3$nd = nd;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of3$path = null;
      arg$1of3$nd = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of4$path;
  
  public int EntrySize (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
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
    Integer result = (Integer) join ();
    return result.intValue ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of5$s;
  
  public void setDelimitor (JP.go.ipa.oz.lib.standard._String_if s) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 5;
      arg$0of5$s = s;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of5$s = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of6$path;
  
  public JP.go.ipa.oz.lang._Root_if getEntry (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
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
    return (JP.go.ipa.oz.lang._Root_if) join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of7$path;
  
  public JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if removeDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
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
    return (JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if) join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of8$path;
  
  public boolean containDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
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
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of9$path;
  
  public void unBranched (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 9;
      arg$0of9$path = path;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of9$path = null;
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
  JP.go.ipa.oz.lib.standard._String_if arg$1of11$toGOL;
  
  public void replaceBranch (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.lib.standard._String_if toGOL) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 11;
      arg$0of11$path = path;
      arg$1of11$toGOL = toGOL;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of11$path = null;
      arg$1of11$toGOL = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of12$path;
  
  public JP.go.ipa.oz.lib.standard._Set_if DirectorySet (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
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
    return (JP.go.ipa.oz.lib.standard._Set_if) join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of13$path;
  
  public JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if getDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 13;
      arg$0of13$path = path;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of13$path = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if) join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of14$path;
  
  public JP.go.ipa.oz.lang._Root_if removeEntry (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 14;
      arg$0of14$path = path;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of14$path = null;
      leave ();
    }
    return (JP.go.ipa.oz.lang._Root_if) join ();
  }
  
  
  public JP.go.ipa.oz.lib.standard._Set_if getBranches () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 15;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._Set_if) join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of16$path;
  
  public int DirectorySize (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 16;
      arg$0of16$path = path;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of16$path = null;
      leave ();
    }
    Integer result = (Integer) join ();
    return result.intValue ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of17$path;
  
  public void putBranchInOtherCell (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
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
    join ();
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
  
  
  public boolean ping () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 21;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of22$path;
  JP.go.ipa.oz.lang._Root_if arg$1of22$ent;
  
  public void putEntry (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.lang._Root_if ent) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 22;
      arg$0of22$path = path;
      arg$1of22$ent = ent;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of22$path = null;
      arg$1of22$ent = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of23$path;
  
  public boolean containEntry (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 23;
      arg$0of23$path = path;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of23$path = null;
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$0of24$source;
  JP.go.ipa.oz.user.lib_dist.name._Path_if arg$1of24$target;
  
  public JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if renameDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if source, JP.go.ipa.oz.user.lib_dist.name._Path_if target) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 24;
      arg$0of24$source = source;
      arg$1of24$target = target;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of24$source = null;
      arg$1of24$target = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if) join ();
  }
  
  public _NameServerTransactionResource_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public _NameServerTransactionResource_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public _NameServerTransactionResource_pcl () throws Exception { super (); }
  
  
}


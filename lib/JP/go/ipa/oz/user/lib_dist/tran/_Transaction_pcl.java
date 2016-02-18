package JP.go.ipa.oz.user.lib_dist.tran;

public class _Transaction_pcl extends JP.go.ipa.oz.lang._Proxy_cl implements JP.go.ipa.oz.user.lib_dist.tran._Transaction_if {
  protected int part;
  
  protected int selector;
  
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    if (part != 1) return super.invoke (o);
    
    JP.go.ipa.oz.user.lib_dist.tran._Transaction_if g = (JP.go.ipa.oz.user.lib_dist.tran._Transaction_if) o;
    Object result;
    
    switch (selector) {
    case 0:
      return g.getResource(arg$0of0$rg);
      
    case 1:
      return g.getResource(arg$0of1$rg, arg$1of1$time);
      
    case 2:
      g.lock(arg$0of2$res);
      return null;
    case 3:
      g.abortTran(arg$0of3$gol);
      return null;
    case 4:
      g.lockHead(arg$0of4$res, arg$1of4$lockMode, arg$2of4$time);
      return null;
    case 5:
      g.commit();
      return null;
    case 6:
      boolean rval$6 = g.isLock();
      return new Boolean(rval$6);
    case 7:
      g.setLockingResource(arg$0of7$rg);
      return null;
    case 8:
      g.setResourceTimeOut(arg$0of8$time);
      return null;
    case 9:
      int rval$9 = g.getMaxBlockingResource();
      return new Integer(rval$9);
    case 10:
      return g.getBlockingResources();
      
    case 11:
      int rval$11 = g.getLx();
      return new Integer(rval$11);
    default:
      throw new Exception ("_Transaction_pcl: invalid selector = " + selector);
    }
  }
  
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of0$rg;
  
  public JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if getResource (JP.go.ipa.oz.lib.standard._String_if rg) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 0;
      arg$0of0$rg = rg;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of0$rg = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of1$rg;
  int arg$1of1$time;
  
  public JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if getResource (JP.go.ipa.oz.lib.standard._String_if rg, int time) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 1;
      arg$0of1$rg = rg;
      arg$1of1$time = time;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of1$rg = null;
      arg$1of1$time = 0;
      leave ();
    }
    return (JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._Array_if arg$0of2$res;
  
  public final void lock (JP.go.ipa.oz.lib.standard._Array_if res) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 2;
      arg$0of2$res = res;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of2$res = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of3$gol;
  
  public final void abortTran (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 3;
      arg$0of3$gol = gol;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of3$gol = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._Array_if arg$0of4$res;
  int arg$1of4$lockMode;
  int arg$2of4$time;
  
  public final void lockHead (JP.go.ipa.oz.lib.standard._Array_if res, int lockMode, int time) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 4;
      arg$0of4$res = res;
      arg$1of4$lockMode = lockMode;
      arg$2of4$time = time;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of4$res = null;
      arg$1of4$lockMode = 0;
      arg$2of4$time = 0;
      leave ();
    }
    join ();
  }
  
  
  public final void commit () throws Exception {
    enter ();
    try {
      part = 1;
      selector = 5;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  
  public final boolean isLock () throws Exception {
    enter ();
    try {
      part = 1;
      selector = 6;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of7$rg;
  
  public final void setLockingResource (JP.go.ipa.oz.lib.standard._String_if rg) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 7;
      arg$0of7$rg = rg;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of7$rg = null;
      leave ();
    }
    join ();
  }
  
  int arg$0of8$time;
  
  public final void setResourceTimeOut (int time) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 8;
      arg$0of8$time = time;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of8$time = 0;
      leave ();
    }
    join ();
  }
  
  
  public final int getMaxBlockingResource () throws Exception {
    enter ();
    try {
      part = 1;
      selector = 9;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    Integer result = (Integer) join ();
    return result.intValue ();
  }
  
  
  public final JP.go.ipa.oz.lib.standard._Array_if getBlockingResources () throws Exception {
    enter ();
    try {
      part = 1;
      selector = 10;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._Array_if) join ();
  }
  
  
  public final int getLx () throws Exception {
    enter ();
    try {
      part = 1;
      selector = 11;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    Integer result = (Integer) join ();
    return result.intValue ();
  }
  
  public _Transaction_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public _Transaction_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public _Transaction_pcl () throws Exception { super (); }
  
  
}


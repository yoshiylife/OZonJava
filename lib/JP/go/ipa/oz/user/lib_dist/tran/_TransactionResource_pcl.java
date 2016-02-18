package JP.go.ipa.oz.user.lib_dist.tran;

public class _TransactionResource_pcl extends JP.go.ipa.oz.lang._Proxy_cl implements JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if {
  protected int part;
  
  protected int selector;
  
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    if (part != 1) return super.invoke (o);
    
    JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if g = (JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if) o;
    Object result;
    
    switch (selector) {
    case 0:
      return g.test();
      
    case 1:
      g.rollback(arg$0of1$t);
      return null;
    case 2:
      int rval$2 = g.lock(arg$0of2$t);
      return new Integer(rval$2);
    case 3:
      boolean rval$3 = g.commit(arg$0of3$t);
      return new Boolean(rval$3);
    case 4:
      g.unlock(arg$0of4$t);
      return null;
    case 5:
      return g.getLockingTransaction();
      
    case 6:
      boolean rval$6 = g.isReadyToCommit(arg$0of6$t);
      return new Boolean(rval$6);
    case 7:
      int rval$7 = g.block(arg$0of7$t, arg$1of7$lockMode);
      return new Integer(rval$7);
    case 8:
      int rval$8 = g.sharedLock(arg$0of8$t);
      return new Integer(rval$8);
    case 9:
      g.checkLockingTimeBody();
      return null;
    case 10:
      int rval$10 = g.getLockMode();
      return new Integer(rval$10);
    default:
      throw new Exception ("_TransactionResource_pcl: invalid selector = " + selector);
    }
  }
  
  
  
  public JP.go.ipa.oz.lib.standard._String_if test () throws Exception {
    enter ();
    try {
      part = 1;
      selector = 0;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._String_if) join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.tran._TID_if arg$0of1$t;
  
  public final void rollback (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 1;
      arg$0of1$t = t;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of1$t = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.tran._TID_if arg$0of2$t;
  
  public final int lock (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 2;
      arg$0of2$t = t;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of2$t = null;
      leave ();
    }
    Integer result = (Integer) join ();
    return result.intValue ();
  }
  
  JP.go.ipa.oz.user.lib_dist.tran._TID_if arg$0of3$t;
  
  public final boolean commit (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 3;
      arg$0of3$t = t;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of3$t = null;
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  JP.go.ipa.oz.user.lib_dist.tran._TID_if arg$0of4$t;
  
  public final void unlock (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 4;
      arg$0of4$t = t;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of4$t = null;
      leave ();
    }
    join ();
  }
  
  
  public final JP.go.ipa.oz.lib.standard._SList_if getLockingTransaction () throws Exception {
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
    return (JP.go.ipa.oz.lib.standard._SList_if) join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.tran._TID_if arg$0of6$t;
  
  public final boolean isReadyToCommit (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 6;
      arg$0of6$t = t;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of6$t = null;
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  JP.go.ipa.oz.user.lib_dist.tran._TID_if arg$0of7$t;
  int arg$1of7$lockMode;
  
  public final int block (JP.go.ipa.oz.user.lib_dist.tran._TID_if t, int lockMode) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 7;
      arg$0of7$t = t;
      arg$1of7$lockMode = lockMode;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of7$t = null;
      arg$1of7$lockMode = 0;
      leave ();
    }
    Integer result = (Integer) join ();
    return result.intValue ();
  }
  
  JP.go.ipa.oz.user.lib_dist.tran._TID_if arg$0of8$t;
  
  public final int sharedLock (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 8;
      arg$0of8$t = t;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of8$t = null;
      leave ();
    }
    Integer result = (Integer) join ();
    return result.intValue ();
  }
  
  
  public final void checkLockingTimeBody () throws Exception {
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
    join ();
  }
  
  
  public final int getLockMode () throws Exception {
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
    Integer result = (Integer) join ();
    return result.intValue ();
  }
  
  public _TransactionResource_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public _TransactionResource_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public _TransactionResource_pcl () throws Exception { super (); }
  
  
}


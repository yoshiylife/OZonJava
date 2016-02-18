package JP.go.ipa.oz.user.lib_dist.replica;

public class CopyScheme_pcl extends JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_pcl implements JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if {
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    if (part != 2) return super.invoke (o);
    
    JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if g = (JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if) o;
    Object result;
    
    switch (selector) {
    case 0:
      int rval$0 = g.getTimeOut();
      return new Integer(rval$0);
    case 1:
      boolean rval$1 = g.commitAll();
      return new Boolean(rval$1);
    case 2:
      g.setCpmGol(arg$0of2$gol);
      return null;
    case 3:
      boolean rval$3 = g.commit();
      return new Boolean(rval$3);
    case 4:
      return g.getClientStubCP();
      
    case 5:
      g.printCrushList();
      return null;
    case 6:
      g.setResourceTimeLimit(arg$0of6$time);
      return null;
    case 7:
      boolean rval$7 = g.propagateAllCP(arg$0of7$type);
      return new Boolean(rval$7);
    case 8:
      boolean rval$8 = g.isLive();
      return new Boolean(rval$8);
    case 9:
      g.setTid(arg$0of9$id);
      return null;
    case 10:
      g.printCopyList();
      return null;
    case 11:
      boolean rval$11 = g.propagate();
      return new Boolean(rval$11);
    case 12:
      g.setTimeOut(arg$0of12$time);
      return null;
    case 13:
      boolean rval$13 = g.removeCopyOf(arg$0of13$delGol);
      return new Boolean(rval$13);
    case 14:
      boolean rval$14 = g.lockAll();
      return new Boolean(rval$14);
    case 15:
      g.update(arg$0of15$gol);
      return null;
    case 16:
      g.update();
      return null;
    case 17:
      boolean rval$17 = g.lock();
      return new Boolean(rval$17);
    case 18:
      g.setCpManeger();
      return null;
    default:
      throw new Exception ("CopyScheme_pcl: invalid selector = " + selector);
    }
  }
  
  
  
  public final int getTimeOut () throws Exception {
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
    Integer result = (Integer) join ();
    return result.intValue ();
  }
  
  
  public boolean commitAll () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 1;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of2$gol;
  
  public final void setCpmGol (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 2;
      arg$0of2$gol = gol;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of2$gol = null;
      leave ();
    }
    join ();
  }
  
  
  public final boolean commit () throws Exception {
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
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  
  public final JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if getClientStubCP () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 4;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    return (JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if) join ();
  }
  
  
  public final void printCrushList () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 5;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  int arg$0of6$time;
  
  public final void setResourceTimeLimit (int time) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 6;
      arg$0of6$time = time;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of6$time = 0;
      leave ();
    }
    join ();
  }
  
  int arg$0of7$type;
  
  public boolean propagateAllCP (int type) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 7;
      arg$0of7$type = type;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of7$type = 0;
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  
  public final boolean isLive () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 8;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  int arg$0of9$id;
  
  public final void setTid (int id) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 9;
      arg$0of9$id = id;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of9$id = 0;
      leave ();
    }
    join ();
  }
  
  
  public final void printCopyList () throws Exception {
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
  
  
  public final boolean propagate () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 11;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  int arg$0of12$time;
  
  public final void setTimeOut (int time) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 12;
      arg$0of12$time = time;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of12$time = 0;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of13$delGol;
  
  public final boolean removeCopyOf (JP.go.ipa.oz.lib.standard._String_if delGol) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 13;
      arg$0of13$delGol = delGol;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of13$delGol = null;
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  
  public boolean lockAll () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 14;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of15$gol;
  
  public void update (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 15;
      arg$0of15$gol = gol;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of15$gol = null;
      leave ();
    }
    join ();
  }
  
  
  public void update () throws Exception {
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
  
  
  public final boolean lock () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 17;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  
  public final void setCpManeger () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 18;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  public CopyScheme_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public CopyScheme_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public CopyScheme_pcl () throws Exception { super (); }
  
  
}


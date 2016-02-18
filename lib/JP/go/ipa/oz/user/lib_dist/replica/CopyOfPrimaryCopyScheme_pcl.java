package JP.go.ipa.oz.user.lib_dist.replica;

public class CopyOfPrimaryCopyScheme_pcl extends JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_pcl implements JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if {
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    if (part != 3) return super.invoke (o);
    
    JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if g = (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if) o;
    Object result;
    
    switch (selector) {
    case 0:
      return g.getClientStub();
      
    case 1:
      g.update(arg$0of1$gol);
      return null;
    case 2:
      boolean rval$2 = g.propagateAll();
      return new Boolean(rval$2);
    case 3:
      return g.getPrimaryCopy();
      
    case 4:
      g.setPrimaryFlag(arg$0of4$flag);
      return null;
    case 5:
      g.primaryUpdate();
      return null;
    case 6:
      boolean rval$6 = g.newSecondaryCopyAt(arg$0of6$copy, arg$1of6$gol);
      return new Boolean(rval$6);
    case 7:
      boolean rval$7 = g.removeSecondaryCopyOf(arg$0of7$delGol);
      return new Boolean(rval$7);
    case 8:
      g.setAllPrimaryCopy(arg$0of8$newprim);
      return null;
    case 9:
      g.setAllPrimaryCopy(arg$0of9$newprim, arg$1of9$gol);
      return null;
    case 10:
      g.setPrimaryGOL(arg$0of10$gol);
      return null;
    case 11:
      g.setPrimaryCopy(arg$0of11$cp);
      return null;
    case 12:
      boolean rval$12 = g.commitAll();
      return new Boolean(rval$12);
    case 13:
      boolean rval$13 = g.lockAll();
      return new Boolean(rval$13);
    default:
      throw new Exception ("CopyOfPrimaryCopyScheme_pcl: invalid selector = " + selector);
    }
  }
  
  
  
  public JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if getClientStub () throws Exception {
    enter ();
    try {
      part = 3;
      selector = 0;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    return (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of1$gol;
  
  public void update (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 1;
      arg$0of1$gol = gol;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of1$gol = null;
      leave ();
    }
    join ();
  }
  
  
  public boolean propagateAll () throws Exception {
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
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  
  public JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if getPrimaryCopy () throws Exception {
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
    return (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if) join ();
  }
  
  boolean arg$0of4$flag;
  
  public void setPrimaryFlag (boolean flag) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 4;
      arg$0of4$flag = flag;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of4$flag = false;
      leave ();
    }
    join ();
  }
  
  
  public void primaryUpdate () throws Exception {
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
  
  JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if arg$0of6$copy;
  JP.go.ipa.oz.lib.standard._String_if arg$1of6$gol;
  
  public boolean newSecondaryCopyAt (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if copy, JP.go.ipa.oz.lib.standard._String_if gol) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 6;
      arg$0of6$copy = copy;
      arg$1of6$gol = gol;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of6$copy = null;
      arg$1of6$gol = null;
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of7$delGol;
  
  public boolean removeSecondaryCopyOf (JP.go.ipa.oz.lib.standard._String_if delGol) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 7;
      arg$0of7$delGol = delGol;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of7$delGol = null;
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if arg$0of8$newprim;
  
  public void setAllPrimaryCopy (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if newprim) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 8;
      arg$0of8$newprim = newprim;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of8$newprim = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if arg$0of9$newprim;
  JP.go.ipa.oz.lib.standard._String_if arg$1of9$gol;
  
  public void setAllPrimaryCopy (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if newprim, JP.go.ipa.oz.lib.standard._String_if gol) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 9;
      arg$0of9$newprim = newprim;
      arg$1of9$gol = gol;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of9$newprim = null;
      arg$1of9$gol = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of10$gol;
  
  public void setPrimaryGOL (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 10;
      arg$0of10$gol = gol;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of10$gol = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if arg$0of11$cp;
  
  public void setPrimaryCopy (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if cp) throws Exception {
    enter ();
    try {
      part = 3;
      selector = 11;
      arg$0of11$cp = cp;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of11$cp = null;
      leave ();
    }
    join ();
  }
  
  
  public boolean commitAll () throws Exception {
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
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  
  public boolean lockAll () throws Exception {
    enter ();
    try {
      part = 3;
      selector = 13;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  public CopyOfPrimaryCopyScheme_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public CopyOfPrimaryCopyScheme_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public CopyOfPrimaryCopyScheme_pcl () throws Exception { super (); }
  
  
}


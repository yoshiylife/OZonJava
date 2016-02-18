package JP.go.ipa.oz.user.apl.fm;

public class FMContainer_pcl extends JP.go.ipa.oz.lang._Proxy_cl implements JP.go.ipa.oz.user.apl.fm.FMContainer_if {
  protected int part;
  
  protected int selector;
  
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    if (part != 1) return super.invoke (o);
    
    JP.go.ipa.oz.user.apl.fm.FMContainer_if g = (JP.go.ipa.oz.user.apl.fm.FMContainer_if) o;
    Object result;
    
    switch (selector) {
    case 0:
      return g.getKarte(arg$0of0$ptr);
      
    case 1:
      g.commit(arg$0of1$obj);
      return null;
    case 2:
      g.trace(arg$0of2$mark);
      return null;
    case 3:
      g.remove(arg$0of3$ptr);
      return null;
    case 4:
      return g.find(arg$0of4$ptr);
      
    case 5:
      return g.add(arg$0of5$obj);
      
    case 6:
      return g.getIdentifier(arg$0of6$obj);
      
    case 7:
      boolean rval$7 = g.contains(arg$0of7$ptr);
      return new Boolean(rval$7);
    case 8:
      g.quiet();
      return null;
    case 9:
      return g.get(arg$0of9$ptr);
      
    case 10:
      g.initialize();
      return null;
    case 11:
      return g.move(arg$0of11$oid, arg$1of11$fid);
      
    default:
      throw new Exception ("FMContainer_pcl: invalid selector = " + selector);
    }
  }
  
  
  JP.go.ipa.oz.user.apl.fm.Pointer_if arg$0of0$ptr;
  
  public JP.go.ipa.oz.user.apl.fm.Karte_if getKarte (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 0;
      arg$0of0$ptr = ptr;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of0$ptr = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.apl.fm.Karte_if) join ();
  }
  
  JP.go.ipa.oz.user.apl.fm.FMObject_if arg$0of1$obj;
  
  public void commit (JP.go.ipa.oz.user.apl.fm.FMObject_if obj) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 1;
      arg$0of1$obj = obj;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of1$obj = null;
      leave ();
    }
    join ();
  }
  
  int arg$0of2$mark;
  
  public void trace (int mark) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 2;
      arg$0of2$mark = mark;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of2$mark = 0;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.apl.fm.Pointer_if arg$0of3$ptr;
  
  public void remove (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 3;
      arg$0of3$ptr = ptr;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of3$ptr = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.apl.fm.Pointer_if arg$0of4$ptr;
  
  public JP.go.ipa.oz.user.apl.fm.Pointer_if find (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 4;
      arg$0of4$ptr = ptr;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of4$ptr = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.apl.fm.Pointer_if) join ();
  }
  
  JP.go.ipa.oz.user.apl.fm.FMObject_if arg$0of5$obj;
  
  public JP.go.ipa.oz.user.apl.fm.Pointer_if add (JP.go.ipa.oz.user.apl.fm.FMObject_if obj) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 5;
      arg$0of5$obj = obj;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of5$obj = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.apl.fm.Pointer_if) join ();
  }
  
  JP.go.ipa.oz.user.apl.fm.FMObject_if arg$0of6$obj;
  
  public JP.go.ipa.oz.user.apl.fm.Pointer_if getIdentifier (JP.go.ipa.oz.user.apl.fm.FMObject_if obj) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 6;
      arg$0of6$obj = obj;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of6$obj = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.apl.fm.Pointer_if) join ();
  }
  
  JP.go.ipa.oz.user.apl.fm.Pointer_if arg$0of7$ptr;
  
  public boolean contains (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 7;
      arg$0of7$ptr = ptr;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of7$ptr = null;
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  
  public void quiet () throws Exception {
    enter ();
    try {
      part = 1;
      selector = 8;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.apl.fm.Pointer_if arg$0of9$ptr;
  
  public JP.go.ipa.oz.user.apl.fm.FMObject_if get (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 9;
      arg$0of9$ptr = ptr;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of9$ptr = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.apl.fm.FMObject_if) join ();
  }
  
  
  public void initialize () throws Exception {
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
    join ();
  }
  
  JP.go.ipa.oz.user.apl.fm.Pointer_if arg$0of11$oid;
  JP.go.ipa.oz.user.apl.fm.Pointer_if arg$1of11$fid;
  
  public JP.go.ipa.oz.user.apl.fm.Pointer_if move (JP.go.ipa.oz.user.apl.fm.Pointer_if oid, JP.go.ipa.oz.user.apl.fm.Pointer_if fid) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 11;
      arg$0of11$oid = oid;
      arg$1of11$fid = fid;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of11$oid = null;
      arg$1of11$fid = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.apl.fm.Pointer_if) join ();
  }
  
  public FMContainer_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public FMContainer_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public FMContainer_pcl () throws Exception { super (); }
  
  
}


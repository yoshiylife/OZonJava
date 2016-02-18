package JP.go.ipa.oz.user.apl.fm;

public class Archiver_pcl extends JP.go.ipa.oz.lang._Proxy_cl implements JP.go.ipa.oz.user.apl.fm.Archiver_if {
  protected int part;
  
  protected int selector;
  
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    if (part != 1) return super.invoke (o);
    
    JP.go.ipa.oz.user.apl.fm.Archiver_if g = (JP.go.ipa.oz.user.apl.fm.Archiver_if) o;
    Object result;
    
    switch (selector) {
    case 0:
      g.remove(arg$0of0$ptr);
      return null;
    case 1:
      g.initialize();
      return null;
    case 2:
      g.add(arg$0of2$oid, arg$1of2$nid);
      return null;
    case 3:
      g.quiet();
      return null;
    case 4:
      return g.find(arg$0of4$ptr);
      
    default:
      throw new Exception ("Archiver_pcl: invalid selector = " + selector);
    }
  }
  
  
  JP.go.ipa.oz.user.apl.fm.Pointer_if arg$0of0$ptr;
  
  public void remove (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception {
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
    join ();
  }
  
  
  public void initialize () throws Exception {
    enter ();
    try {
      part = 1;
      selector = 1;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.apl.fm.Pointer_if arg$0of2$oid;
  JP.go.ipa.oz.user.apl.fm.Pointer_if arg$1of2$nid;
  
  public void add (JP.go.ipa.oz.user.apl.fm.Pointer_if oid, JP.go.ipa.oz.user.apl.fm.Pointer_if nid) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 2;
      arg$0of2$oid = oid;
      arg$1of2$nid = nid;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of2$oid = null;
      arg$1of2$nid = null;
      leave ();
    }
    join ();
  }
  
  
  public void quiet () throws Exception {
    enter ();
    try {
      part = 1;
      selector = 3;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
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
  
  public Archiver_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public Archiver_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public Archiver_pcl () throws Exception { super (); }
  
  
}


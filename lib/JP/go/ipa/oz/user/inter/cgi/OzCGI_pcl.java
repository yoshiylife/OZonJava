package JP.go.ipa.oz.user.inter.cgi;

public class OzCGI_pcl extends JP.go.ipa.oz.lang._Proxy_cl implements JP.go.ipa.oz.user.inter.cgi.OzCGI_if {
  protected int part;
  
  protected int selector;
  
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    if (part != 1) return super.invoke (o);
    
    JP.go.ipa.oz.user.inter.cgi.OzCGI_if g = (JP.go.ipa.oz.user.inter.cgi.OzCGI_if) o;
    Object result;
    
    switch (selector) {
    case 0:
      return g.receiveRequest(arg$0of0$form_id);
      
    case 1:
      g.ping();
      return null;
    case 2:
      g.quit();
      return null;
    case 3:
      g.quiet();
      return null;
    case 4:
      g.go();
      return null;
    case 5:
      g.sendResult(arg$0of5$result);
      return null;
    default:
      throw new Exception ("OzCGI_pcl: invalid selector = " + selector);
    }
  }
  
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of0$form_id;
  
  public JP.go.ipa.oz.user.inter.cgi.HTMLData_if receiveRequest (JP.go.ipa.oz.lib.standard._String_if form_id) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 0;
      arg$0of0$form_id = form_id;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of0$form_id = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.inter.cgi.HTMLData_if) join ();
  }
  
  
  public void ping () throws Exception {
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
  
  
  public void quit () throws Exception {
    enter ();
    try {
      part = 1;
      selector = 2;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
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
  
  
  public void go () throws Exception {
    enter ();
    try {
      part = 1;
      selector = 4;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.user.inter.cgi.HTMLData_if arg$0of5$result;
  
  public void sendResult (JP.go.ipa.oz.user.inter.cgi.HTMLData_if result) throws Exception {
    enter ();
    try {
      part = 1;
      selector = 5;
      arg$0of5$result = result;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of5$result = null;
      leave ();
    }
    join ();
  }
  
  public OzCGI_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public OzCGI_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public OzCGI_pcl () throws Exception { super (); }
  
  
}


package JP.go.ipa.oz.user.garage;

public class ApplicationGarage_cl extends JP.go.ipa.oz.user.garage.SGarage_cl implements JP.go.ipa.oz.user.garage.ApplicationGarage_if {
  static final boolean _global_ = true;
  JP.go.ipa.oz.lib.standard._ClassLoader_if classLoader;
  
  protected void initialize () throws Exception  {
// 63
    super.initialize ();
  }
  
  public JP.go.ipa.oz.user.ide.Application_if getApplication (JP.go.ipa.oz.user.garage.Key_if key) throws Exception  {
    checkSecureInvocation ();
// 24
    JP.go.ipa.oz.user.ide.Application_if app = null;
// 26
    app = (JP.go.ipa.oz.user.ide.Application_if) (super.get (key));
// 28
    return app;
  }
  
  public JP.go.ipa.oz.user.garage.Key_if putApplication (JP.go.ipa.oz.user.ide.Application_if app) throws Exception  {
    checkSecureInvocation ();
// 37
    JP.go.ipa.oz.lib.standard._String_if cid = null;
// 39
    JP.go.ipa.oz.lib.standard._String_if getClassID$val$0;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) app)) {
      try {
        getClassID$val$0 = app.getClassID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getClassID$val$0 = app.getClassID ();
    }
// 39
    cid = getClassID$val$0;
// 40
    try {
// 41
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classLoader)) {
        try {
          classLoader.loadClass (cid);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        classLoader.loadClass (cid);
      }
    }
    catch (JP.go.ipa.oz.system.ExClassNotFoundException _exception_ex) {
      JP.go.ipa.oz.lang._Exception_if ex = new JP.go.ipa.oz.lang._Exception_cl (_exception_ex);
      
// 43
      throw _exception_ex;
    }
// 46
    return super.put (app);
  }
  
  protected void quiet () throws Exception  {
// 78
    classLoader = null;
// 79
    super.quiet ();
  }
  
  protected void go () throws Exception  {
// 70
    classLoader = (JP.go.ipa.oz.lib.standard._ClassLoader_cl) (new JP.go.ipa.oz.lib.standard._ClassLoader_cl ())._new_create ();
// 71
    super.go ();
  }
  
  public void replaceApplication (JP.go.ipa.oz.user.garage.Key_if key, JP.go.ipa.oz.user.ide.Application_if app) throws Exception  {
    checkSecureInvocation ();
// 53
    super.replace (key, app);
  }
  
  public ApplicationGarage_cl () { super ("JP.go.ipa.oz.user.garage.ApplicationGarage_pcl"); }
  
  public ApplicationGarage_cl (String proxy_id) { super (proxy_id); }
  
}


package JP.go.ipa.oz.user.garage;

public class SubjectGarage_cl extends JP.go.ipa.oz.user.garage.SGarage_cl implements JP.go.ipa.oz.user.garage.SubjectGarage_if {
  static final boolean _global_ = true;
  JP.go.ipa.oz.lib.standard._ClassLoader_if classLoader;
  
  protected void initialize () throws Exception  {
// 63
    super.initialize ();
  }
  
  public JP.go.ipa.oz.user.ide.Subject_if getSubject (JP.go.ipa.oz.user.garage.Key_if key) throws Exception  {
    checkSecureInvocation ();
// 24
    JP.go.ipa.oz.user.ide.Subject_if sbj = null;
// 26
    sbj = (JP.go.ipa.oz.user.ide.Subject_if) (super.get (key));
// 28
    return sbj;
  }
  
  public void replaceSubject (JP.go.ipa.oz.user.garage.Key_if key, JP.go.ipa.oz.user.ide.Subject_if sbj) throws Exception  {
    checkSecureInvocation ();
// 53
    super.replace (key, sbj);
  }
  
  public JP.go.ipa.oz.user.garage.Key_if putSubject (JP.go.ipa.oz.user.ide.Subject_if sbj) throws Exception  {
    checkSecureInvocation ();
// 37
    JP.go.ipa.oz.lib.standard._String_if pkgName = null;
// 39
    JP.go.ipa.oz.lib.standard._String_if getPackageName$val$23;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbj)) {
      try {
        getPackageName$val$23 = sbj.getPackageName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getPackageName$val$23 = sbj.getPackageName ();
    }
// 39
    pkgName = getPackageName$val$23;
// 40
    try {
// 41
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classLoader)) {
        try {
          classLoader.loadPackage (pkgName);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        classLoader.loadPackage (pkgName);
      }
    }
    catch (JP.go.ipa.oz.system.ExClassNotFoundException _exception_ex) {
      JP.go.ipa.oz.lang._Exception_if ex = new JP.go.ipa.oz.lang._Exception_cl (_exception_ex);
      
// 43
      throw _exception_ex;
    }
// 46
    return super.put (sbj);
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
  
  public SubjectGarage_cl () { super ("JP.go.ipa.oz.user.garage.SubjectGarage_pcl"); }
  
  public SubjectGarage_cl (String proxy_id) { super (proxy_id); }
  
}


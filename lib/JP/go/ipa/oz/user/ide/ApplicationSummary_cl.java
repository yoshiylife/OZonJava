package JP.go.ipa.oz.user.ide;

public class ApplicationSummary_cl extends JP.go.ipa.oz.user.ide.Summary_cl implements JP.go.ipa.oz.user.ide.ApplicationSummary_if {
  JP.go.ipa.oz.lib.standard._String_if name;
  JP.go.ipa.oz.lib.standard._String_if description;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if name, JP.go.ipa.oz.lib.standard._String_if dsc) throws Exception  {
// 41
    init (name, dsc);
    return this;
  }
  
  public Object _new_create () throws Exception  {
// 36
    init (null, null);
    return this;
  }
  
  public void setName (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 88
    ((JP.go.ipa.oz.user.ide.ApplicationSummary_cl)this).name = name;
  }
  
  public void describe () throws Exception  {
    checkSecureInvocation ();
  }
  
  void init (JP.go.ipa.oz.lib.standard._String_if name, JP.go.ipa.oz.lib.standard._String_if dsc) throws Exception  {
// 97
    ((JP.go.ipa.oz.user.ide.ApplicationSummary_cl)this).name = name;
// 98
    ((JP.go.ipa.oz.user.ide.ApplicationSummary_cl)this).description = dsc;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getName () throws Exception  {
    checkSecureInvocation ();
// 63
    return name;
  }
  
  public void setDescription (JP.go.ipa.oz.lib.standard._String_if dsc) throws Exception  {
    checkSecureInvocation ();
// 81
    ((JP.go.ipa.oz.user.ide.ApplicationSummary_cl)this).description = dsc;
  }
  
  public JP.go.ipa.oz.user.ide.Application_if retreiveApplication () throws Exception  {
    checkSecureInvocation ();
// 70
    JP.go.ipa.oz.user.ide.Application_if app = null;
// 72
    app = (JP.go.ipa.oz.user.ide.Application_if) (super.retreive ());
// 74
    return app;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getDescription () throws Exception  {
    checkSecureInvocation ();
// 56
    return description;
  }
  
  public ApplicationSummary_cl () throws Exception { super (); }
  
}


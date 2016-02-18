package JP.go.ipa.oz.user.inter.cgi;

public class OzCGIManager_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.inter.cgi.OzCGIManager_if {
  
  public Object _new_create (JP.go.ipa.oz.user.inter.cgi.OzCGI_if cgi) throws Exception  {
// 14
    JP.go.ipa.oz.user.inter.cgi.OzCGIManagerThread_if run = (JP.go.ipa.oz.user.inter.cgi.OzCGIManagerThread_cl) (new JP.go.ipa.oz.user.inter.cgi.OzCGIManagerThread_cl ())._new_create (cgi);
// 15
    JP.go.ipa.oz.lang._Thread_if th = (JP.go.ipa.oz.lang._Thread_cl) (new JP.go.ipa.oz.lang._Thread_cl ())._new_create (run);
    return this;
  }
  
  public OzCGIManager_cl () throws Exception { super (); }
  
}


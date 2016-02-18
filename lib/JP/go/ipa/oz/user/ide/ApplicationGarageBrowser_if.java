package JP.go.ipa.oz.user.ide;

public interface ApplicationGarageBrowser_if extends JP.go.ipa.oz.user.ide.GarageBrowser_if {
  
  JP.go.ipa.oz.user.garage.Key_if exportApplication (JP.go.ipa.oz.user.ide.Application_if app) throws Exception ;
  JP.go.ipa.oz.lib.standard._Frame_if getGUI () throws Exception ;
  void hideSummary (JP.go.ipa.oz.user.garage.Key_if key) throws Exception ;
  void hideSummary () throws Exception ;
  void exportReady (JP.go.ipa.oz.user.ide.ApplicationSummary_if s) throws Exception ;
  void importApplication (JP.go.ipa.oz.user.ide.ApplicationSummary_if summary) throws Exception ;
  void importApplication () throws Exception ;
  void showSummary (JP.go.ipa.oz.user.ide.ApplicationSummary_if summary) throws Exception ;
  void showSummary () throws Exception ;
}


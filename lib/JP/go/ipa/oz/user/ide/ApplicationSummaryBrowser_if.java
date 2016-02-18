package JP.go.ipa.oz.user.ide;

public interface ApplicationSummaryBrowser_if extends JP.go.ipa.oz.lib.standard._Frame_if {
  
  JP.go.ipa.oz.user.garage.Key_if getKey () throws Exception ;
  void show (JP.go.ipa.oz.user.ide.ApplicationSummary_if summary) throws Exception ;
  JP.go.ipa.oz.user.ide.ApplicationSummary_if getInputSummary () throws Exception ;
  JP.go.ipa.oz.user.ide.ApplicationSummary_if getSummary () throws Exception ;
}


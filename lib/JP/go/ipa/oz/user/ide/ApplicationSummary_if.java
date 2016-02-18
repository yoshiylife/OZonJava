package JP.go.ipa.oz.user.ide;

public interface ApplicationSummary_if extends JP.go.ipa.oz.user.ide.Summary_if {
  
  void setName (JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getName () throws Exception ;
  void setDescription (JP.go.ipa.oz.lib.standard._String_if dsc) throws Exception ;
  JP.go.ipa.oz.user.ide.Application_if retreiveApplication () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getDescription () throws Exception ;
}


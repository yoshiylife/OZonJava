package JP.go.ipa.oz.user.ide;

public interface ClassIDGenerator_if extends JP.go.ipa.oz.lang._Root_if {
  
  JP.go.ipa.oz.lib.standard._String_if generateImplementationID (JP.go.ipa.oz.lib.standard._String_if label) throws Exception ;
  JP.go.ipa.oz.lib.standard._Array_if getRuleOfImplementationID () throws Exception ;
  JP.go.ipa.oz.lib.standard._Array_if getRuleOfInterfaceID () throws Exception ;
  void setRuleOfImplementationID (JP.go.ipa.oz.lib.standard._Array_if rule) throws Exception ;
  void setRuleOfInterfaceID (JP.go.ipa.oz.lib.standard._Array_if rule) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if generateInterfaceID (JP.go.ipa.oz.lib.standard._String_if label) throws Exception ;
}


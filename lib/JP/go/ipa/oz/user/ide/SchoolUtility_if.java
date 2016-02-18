package JP.go.ipa.oz.user.ide;

public interface SchoolUtility_if extends JP.go.ipa.oz.lang._Root_if {
  
  JP.go.ipa.oz.lib.standard._String_if makeInterfaceID (JP.go.ipa.oz.lib.standard._String_if interfaceID) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if makeImplementationID (JP.go.ipa.oz.lib.standard._String_if implementationID) throws Exception ;
  void loadFromFile (JP.go.ipa.oz.lib.standard._String_if fileName, JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception ;
  void saveToFile (JP.go.ipa.oz.lib.standard._String_if fileName, JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception ;
}


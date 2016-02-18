package JP.go.ipa.oz.user.ide;

public interface SBUtility_if extends JP.go.ipa.oz.lang._Root_if {
  
  JP.go.ipa.oz.lib.standard._String_if getScriptPath () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getTmpDir () throws Exception ;
  JP.go.ipa.oz.lib.standard._StringBuffer_if constructScript (JP.go.ipa.oz.lib.standard._String_if ClassID, JP.go.ipa.oz.lib.standard._String_if GOL, JP.go.ipa.oz.lib.standard._String_if param) throws Exception ;
  JP.go.ipa.oz.lib.standard._StringBuffer_if constructScript () throws Exception ;
  void makeTmpDir () throws Exception ;
  void makeScriptFile (JP.go.ipa.oz.lib.standard._String_if scriptPath, JP.go.ipa.oz.lib.standard._StringBuffer_if script) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if makeGOD () throws Exception ;
  void makeScript (JP.go.ipa.oz.lib.standard._String_if ClassID, JP.go.ipa.oz.lib.standard._String_if GOL, JP.go.ipa.oz.lib.standard._String_if param) throws Exception ;
  void makeScript () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getPath () throws Exception ;
}


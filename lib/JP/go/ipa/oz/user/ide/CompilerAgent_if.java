package JP.go.ipa.oz.user.ide;

public interface CompilerAgent_if extends JP.go.ipa.oz.lang._Root_if {
  
  boolean compileOzFIlesForRelease (JP.go.ipa.oz.lib.standard._Array_if fileList, JP.go.ipa.oz.lib.standard._StringBuffer_if fullPath, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception ;
  void zipForRelease (JP.go.ipa.oz.lib.standard._String_if dirName, int flag, JP.go.ipa.oz.lib.standard._String_if zipFName) throws Exception ;
  boolean compileOzFIles (JP.go.ipa.oz.lib.standard._Array_if fileList, JP.go.ipa.oz.lib.standard._StringBuffer_if fullPath, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception ;
  boolean deleteAllFiles () throws Exception ;
  boolean compileModifiedLabels (JP.go.ipa.oz.lib.standard._Set_if labels) throws Exception ;
  JP.go.ipa.oz.user.ide.School_if getSchool () throws Exception ;
  boolean compileSubject (JP.go.ipa.oz.lib.standard._String_if dirName, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception ;
  boolean compile (JP.go.ipa.oz.lib.standard._String_if source, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception ;
  boolean compile (JP.go.ipa.oz.lib.standard._String_if source) throws Exception ;
  void deleteLabels (JP.go.ipa.oz.lib.standard._Set_if labels) throws Exception ;
  boolean existClassFileForRelease (JP.go.ipa.oz.lib.standard._String_if filename) throws Exception ;
  boolean compileSubjectForRelease (JP.go.ipa.oz.lib.standard._String_if dirName, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception ;
  boolean release (JP.go.ipa.oz.lib.standard._String_if dirName, int flag, JP.go.ipa.oz.lib.standard._String_if zipFName) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getKugiri () throws Exception ;
  boolean compileAuto (JP.go.ipa.oz.lib.standard._String_if dirName, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception ;
  boolean existClassFile (JP.go.ipa.oz.lib.standard._String_if filename) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getClassDir2 (JP.go.ipa.oz.lib.standard._String_if dirName) throws Exception ;
  JP.go.ipa.oz.lib.standard._Array_if getModFiles (JP.go.ipa.oz.lib.standard._String_if sourceDir, JP.go.ipa.oz.lib.standard._String_if classDir) throws Exception ;
  JP.go.ipa.oz.user.ide.Ozc_if getCompiler () throws Exception ;
  boolean compileInterface (JP.go.ipa.oz.lib.standard._String_if source, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception ;
  boolean compileInterface (JP.go.ipa.oz.lib.standard._String_if source) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if replace (JP.go.ipa.oz.lib.standard._String_if target, JP.go.ipa.oz.lib.standard._String_if oldString, JP.go.ipa.oz.lib.standard._String_if newString) throws Exception ;
  boolean deleteClassFiles (JP.go.ipa.oz.lib.standard._Array_if fileList) throws Exception ;
  void setCompiler (JP.go.ipa.oz.user.ide.Ozc_if ozc) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getReleaseDir () throws Exception ;
  JP.go.ipa.oz.lib.standard._Set_if relatedLabels (JP.go.ipa.oz.lib.standard._String_if dirName) throws Exception ;
  void setSchool (JP.go.ipa.oz.user.ide.School_if sc) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getClassDir (JP.go.ipa.oz.lib.standard._String_if dirName) throws Exception ;
}


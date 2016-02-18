package JP.go.ipa.oz.user.inter.wwps;

public interface CompilerAgent_if extends JP.go.ipa.oz.lang._Root_if {
  
  JP.go.ipa.oz.lib.standard._String_if getReleaseDir () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getKugiri () throws Exception ;
  boolean deleteAllFiles () throws Exception ;
  JP.go.ipa.oz.user.ide.School_if getSchool () throws Exception ;
  boolean compile (JP.go.ipa.oz.lib.standard._String_if source, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception ;
  boolean compile (JP.go.ipa.oz.lib.standard._String_if source) throws Exception ;
  void setSchool (JP.go.ipa.oz.user.ide.School_if sc) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getClassDir2 (JP.go.ipa.oz.lib.standard._String_if dirName) throws Exception ;
  boolean compileOzFIlesForRelease (JP.go.ipa.oz.lib.standard._Array_if fileList, JP.go.ipa.oz.lib.standard._StringBuffer_if fullPath, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception ;
  boolean deleteClassFiles (JP.go.ipa.oz.lib.standard._Array_if fileList) throws Exception ;
  boolean release (JP.go.ipa.oz.lib.standard._String_if dirName, int flag, JP.go.ipa.oz.lib.standard._String_if zipFName) throws Exception ;
  boolean existClassFileForRelease (JP.go.ipa.oz.lib.standard._String_if filename) throws Exception ;
  boolean compileInterface (JP.go.ipa.oz.lib.standard._String_if source, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception ;
  boolean compileInterface (JP.go.ipa.oz.lib.standard._String_if source) throws Exception ;
  void zipForRelease (JP.go.ipa.oz.lib.standard._String_if dirName, int flag, JP.go.ipa.oz.lib.standard._String_if zipFName) throws Exception ;
  boolean compileSubjectForRelease (JP.go.ipa.oz.lib.standard._String_if dirName, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getClassDir (JP.go.ipa.oz.lib.standard._String_if dirName) throws Exception ;
}


package JP.go.ipa.oz.user.ide;

public interface Project_if extends JP.go.ipa.oz.lang._Root_if {
  
  void addFile (JP.go.ipa.oz.lib.standard._String_if fileName) throws Exception ;
  void setProjectDir (JP.go.ipa.oz.lib.standard._String_if prjDir) throws Exception ;
  void setFiles (JP.go.ipa.oz.lib.standard._Array_if f) throws Exception ;
  void setProjectName (JP.go.ipa.oz.lib.standard._String_if prjName) throws Exception ;
  void removeAllFiles () throws Exception ;
  void removeFile (JP.go.ipa.oz.lib.standard._String_if fileName) throws Exception ;
  int getNumOfFiles () throws Exception ;
  JP.go.ipa.oz.lib.standard._Array_if getFiles () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getProjectName () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getProjectDir () throws Exception ;
}


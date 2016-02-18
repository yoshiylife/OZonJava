package JP.go.ipa.oz.user.ide;

public interface ProjectManager_if extends JP.go.ipa.oz.lib.standard._Frame_if {
  
  JP.go.ipa.oz.lib.standard._String_if getProjectName () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getEditor () throws Exception ;
  void setSchoolBrowser (JP.go.ipa.oz.user.ide.SchoolBrowser_if sb) throws Exception ;
  JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser () throws Exception ;
  JP.go.ipa.oz.lib.standard._Dictionary_if getProjects () throws Exception ;
  JP.go.ipa.oz.lib.standard._List_if getSrcList () throws Exception ;
  void initMenu () throws Exception ;
  void setProjects (JP.go.ipa.oz.lib.standard._Dictionary_if prj) throws Exception ;
  void setProjectDir (JP.go.ipa.oz.lib.standard._String_if projectDir) throws Exception ;
  void initGUI () throws Exception ;
  void setFName (JP.go.ipa.oz.lib.standard._String_if fileName) throws Exception ;
  void setProjectName (JP.go.ipa.oz.lib.standard._String_if prjName) throws Exception ;
  void activateListeners (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception ;
  void setEditor (JP.go.ipa.oz.lib.standard._String_if ed) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getProjectDir () throws Exception ;
  void deleteListeners () throws Exception ;
  void openEditor () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getFName () throws Exception ;
}


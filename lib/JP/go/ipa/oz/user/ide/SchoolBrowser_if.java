package JP.go.ipa.oz.user.ide;

public interface SchoolBrowser_if extends JP.go.ipa.oz.lib.standard._Frame_if {
  
  void setSchoolList (JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception ;
  JP.go.ipa.oz.lib.standard._MenuItem_if getMenuItemSubjectExportCL () throws Exception ;
  JP.go.ipa.oz.lib.standard._List_if getLstLabel () throws Exception ;
  void initMenu () throws Exception ;
  JP.go.ipa.oz.lib.standard._MenuItem_if getMenuItemAppResister () throws Exception ;
  JP.go.ipa.oz.user.ide.School_if getSchool () throws Exception ;
  void setProjectDir (JP.go.ipa.oz.lib.standard._String_if dir) throws Exception ;
  void initGUI () throws Exception ;
  void mergeSubject (JP.go.ipa.oz.user.ide.Subject_if subject) throws Exception ;
  JP.go.ipa.oz.lib.standard._Choice_if getChoSubject () throws Exception ;
  JP.go.ipa.oz.lib.standard._TextField_if getTxtImplID () throws Exception ;
  JP.go.ipa.oz.user.ide.ClassBrowser_if getClassBrowser () throws Exception ;
  void activateListeners (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception ;
  JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_if getApplicationGarageBrowser () throws Exception ;
  JP.go.ipa.oz.lib.standard._Checkbox_if getRbtnRelease () throws Exception ;
  JP.go.ipa.oz.lib.standard._Checkbox_if getRbtnDevelopment () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getProjectDir () throws Exception ;
  JP.go.ipa.oz.lib.standard._TextField_if getTxtIfID () throws Exception ;
  JP.go.ipa.oz.lib.standard._FileDialog_if getSaveFileDialog () throws Exception ;
  void deleteListeners () throws Exception ;
  JP.go.ipa.oz.lib.standard._FileDialog_if getOpenFileDialog () throws Exception ;
  JP.go.ipa.oz.user.ide.SubjectGarageBrowser_if getSubjectGarageBrowser () throws Exception ;
  JP.go.ipa.oz.lib.standard._MenuItem_if getMenuItemSubjectExportIF () throws Exception ;
}


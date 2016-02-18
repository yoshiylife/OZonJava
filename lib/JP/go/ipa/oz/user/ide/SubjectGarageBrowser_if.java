package JP.go.ipa.oz.user.ide;

public interface SubjectGarageBrowser_if extends JP.go.ipa.oz.user.ide.GarageBrowser_if {
  
  JP.go.ipa.oz.lib.standard._Frame_if getGUI () throws Exception ;
  void hideSummary (JP.go.ipa.oz.user.garage.Key_if key) throws Exception ;
  void hideSummary () throws Exception ;
  JP.go.ipa.oz.user.garage.Key_if exportSubject (JP.go.ipa.oz.user.ide.Subject_if sbj) throws Exception ;
  void exportReady (JP.go.ipa.oz.user.ide.SubjectSummary_if ss) throws Exception ;
  void showSummary (JP.go.ipa.oz.user.ide.SubjectSummary_if ss) throws Exception ;
  void showSummary () throws Exception ;
  void importSubject (JP.go.ipa.oz.user.ide.SubjectSummary_if ss) throws Exception ;
  void importSubject () throws Exception ;
}


package JP.go.ipa.oz.user.ide;

public interface PMController_if extends JP.go.ipa.oz.lib.standard._ActionListener_if {
  
  void compileAutoEvent () throws Exception ;
  void compileSubjectEvent () throws Exception ;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if getDlgQueue () throws Exception ;
  boolean checkSubjectState () throws Exception ;
  void setDlgQueue (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception ;
  void saveEvent () throws Exception ;
  void compileEvent (int flag) throws Exception ;
  void setDirEvent () throws Exception ;
  void destroyDlgQueue () throws Exception ;
  void refreshEvent () throws Exception ;
  void compileReleaseEvent () throws Exception ;
}


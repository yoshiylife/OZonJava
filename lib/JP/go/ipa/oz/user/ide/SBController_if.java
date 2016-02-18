package JP.go.ipa.oz.user.ide;

public interface SBController_if extends JP.go.ipa.oz.lib.standard._ActionListener_if {
  
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if getDlgQueue () throws Exception ;
  void importSubjectEvnet () throws Exception ;
  void setDlgQueue (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception ;
  void resisterApplicationEvnet () throws Exception ;
  void runEvent () throws Exception ;
  void classBrowserEvent (int flag) throws Exception ;
  void releaseEvent (int flag) throws Exception ;
  void exportEvnet () throws Exception ;
  void destroyDlgQueue () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getCIDofCell (JP.go.ipa.oz.lib.standard._String_if pkgName) throws Exception ;
  void importEvnet () throws Exception ;
}


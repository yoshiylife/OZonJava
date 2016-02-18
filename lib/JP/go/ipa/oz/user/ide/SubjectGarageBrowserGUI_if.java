package JP.go.ipa.oz.user.ide;

public interface SubjectGarageBrowserGUI_if extends JP.go.ipa.oz.lib.standard._Frame_if {
  
  void setServerGOL (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception ;
  void inputSummary (JP.go.ipa.oz.user.ide.Subject_if sbj) throws Exception ;
  void add (JP.go.ipa.oz.user.ide.SubjectSummary_if ss) throws Exception ;
  void remove (JP.go.ipa.oz.user.garage.Key_if key) throws Exception ;
  void list (JP.go.ipa.oz.lib.standard._Collection_if ssSet) throws Exception ;
  JP.go.ipa.oz.user.ide.SubjectSummary_if getSelectedSummary () throws Exception ;
  void clear () throws Exception ;
  void sort (JP.go.ipa.oz.user.ide.BinaryPredicate_if prd) throws Exception ;
  void sort () throws Exception ;
}


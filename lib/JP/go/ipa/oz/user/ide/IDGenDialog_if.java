package JP.go.ipa.oz.user.ide;

public interface IDGenDialog_if extends JP.go.ipa.oz.lib.standard._Dialog_if {
  
  JP.go.ipa.oz.user.ide.School_if getSchool () throws Exception ;
  JP.go.ipa.oz.lib.standard._Button_if getBtnCancel () throws Exception ;
  void generateID (JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception ;
  void generateID (JP.go.ipa.oz.user.ide.OzLabel_if label) throws Exception ;
  JP.go.ipa.oz.lib.standard._Choice_if getChoSubject () throws Exception ;
  JP.go.ipa.oz.lib.standard._Checkbox_if getRbtnSubject () throws Exception ;
  JP.go.ipa.oz.lib.standard._Button_if getBtnOK () throws Exception ;
  JP.go.ipa.oz.lib.standard._Checkbox_if getRbtnSelected () throws Exception ;
  JP.go.ipa.oz.user.ide.OzLabel_if getLabel () throws Exception ;
  JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser () throws Exception ;
  JP.go.ipa.oz.user.ide.ClassIDGenerator_if getIdGen () throws Exception ;
}


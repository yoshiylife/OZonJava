package JP.go.ipa.oz.user.ide;

public interface LabelEditDialog_if extends JP.go.ipa.oz.lib.standard._Dialog_if {
  
  JP.go.ipa.oz.lib.standard._Choice_if getChoSubject () throws Exception ;
  void modifyLabel () throws Exception ;
  JP.go.ipa.oz.lib.standard._Button_if getBtnOK () throws Exception ;
  JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser () throws Exception ;
}


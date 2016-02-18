package JP.go.ipa.oz.user.ide;

public interface CompileInfoDialog_if extends JP.go.ipa.oz.lib.standard._Dialog_if {
  
  void setButtonEnabled (boolean b) throws Exception ;
  void appendText (JP.go.ipa.oz.lib.standard._String_if appendText) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getTxtInfo () throws Exception ;
  void setTxtInfo (JP.go.ipa.oz.lib.standard._String_if tmp) throws Exception ;
}


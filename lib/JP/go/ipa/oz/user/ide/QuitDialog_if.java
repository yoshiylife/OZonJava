package JP.go.ipa.oz.user.ide;

public interface QuitDialog_if extends JP.go.ipa.oz.lib.standard._Dialog_if {
  
  void processWindowEvent (JP.go.ipa.oz.lib.standard._WindowEvent_if event) throws Exception ;
  JP.go.ipa.oz.lib.standard._Button_if getBtnNo () throws Exception ;
  JP.go.ipa.oz.lib.standard._Button_if getBtnYes () throws Exception ;
}


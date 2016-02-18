package JP.go.ipa.oz.user.launcher;

public interface LauncherGUI_if extends JP.go.ipa.oz.lib.standard._Frame_if {
  
  JP.go.ipa.oz.lib.standard._String_if getSelectedDirectory () throws Exception ;
  void setPath (JP.go.ipa.oz.lib.standard._String_if path) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getSelectedCell () throws Exception ;
  void changeDirectory (JP.go.ipa.oz.lib.standard._String_if dirName) throws Exception ;
  void createCell () throws Exception ;
  void sync () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getPath () throws Exception ;
}


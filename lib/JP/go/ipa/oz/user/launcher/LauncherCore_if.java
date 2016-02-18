package JP.go.ipa.oz.user.launcher;

public interface LauncherCore_if extends JP.go.ipa.oz.lang._Root_if {
  
  void installScriptFiles () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getCatalogGOL () throws Exception ;
  void setCatalogGOL (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception ;
  JP.go.ipa.oz.lib.standard._Frame_if getGUI () throws Exception ;
  void stop () throws Exception ;
  void createCell (JP.go.ipa.oz.lib.standard._String_if god, JP.go.ipa.oz.lib.standard._String_if cid) throws Exception ;
  void createCell (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception ;
  void createCell () throws Exception ;
  void setPath (JP.go.ipa.oz.lib.standard._String_if path) throws Exception ;
  void changeDirectory (JP.go.ipa.oz.lib.standard._String_if dirName) throws Exception ;
  void quit () throws Exception ;
  void startCell (JP.go.ipa.oz.lib.standard._String_if god) throws Exception ;
  void startCell () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getPath () throws Exception ;
  void launch () throws Exception ;
  void sync () throws Exception ;
}


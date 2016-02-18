package JP.go.ipa.oz.user.launcher;

public interface LauncherCellInformationDialog_if extends JP.go.ipa.oz.user.misc.gui.CenteredDialog_if {
  
  void setCatalogGOL (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception ;
  void setCID (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getInputCID () throws Exception ;
  void setGOD (JP.go.ipa.oz.lib.standard._String_if god) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getInputGOD () throws Exception ;
}


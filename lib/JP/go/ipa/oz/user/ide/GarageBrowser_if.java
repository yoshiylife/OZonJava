package JP.go.ipa.oz.user.ide;

public interface GarageBrowser_if extends JP.go.ipa.oz.lang._Root_if {
  
  JP.go.ipa.oz.user.garage.SGarage_if getServer () throws Exception ;
  void replace (JP.go.ipa.oz.user.garage.Key_if key, JP.go.ipa.oz.user.ide.Summarizable_if sbl) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getServerGOL () throws Exception ;
  void replaceSummary (JP.go.ipa.oz.user.garage.Key_if key, JP.go.ipa.oz.user.ide.Summary_if sm) throws Exception ;
  void remove (JP.go.ipa.oz.user.garage.Key_if key) throws Exception ;
  void bindServer (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception ;
  void quit () throws Exception ;
  void setVisible (boolean v) throws Exception ;
  JP.go.ipa.oz.user.ide.Summarizable_if get (JP.go.ipa.oz.user.garage.Key_if key) throws Exception ;
  void launch () throws Exception ;
  void sync () throws Exception ;
  JP.go.ipa.oz.user.garage.Key_if put (JP.go.ipa.oz.user.ide.Summarizable_if sbl, JP.go.ipa.oz.user.ide.Summary_if sm) throws Exception ;
  JP.go.ipa.oz.user.garage.Key_if put (JP.go.ipa.oz.user.ide.Summarizable_if sbl) throws Exception ;
}


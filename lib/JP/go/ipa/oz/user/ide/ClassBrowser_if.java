package JP.go.ipa.oz.user.ide;

public interface ClassBrowser_if extends JP.go.ipa.oz.lang._Root_if {
  static final boolean _final_ = true;
  
  JP.go.ipa.oz.lib.standard._Collection_if getSuperPartsOf (JP.go.ipa.oz.user.ide.CIPart_if part) throws Exception ;
  JP.go.ipa.oz.lib.standard._Collection_if getSuperPartsOf (JP.go.ipa.oz.lib.standard._Collection_if parts) throws Exception ;
  JP.go.ipa.oz.lib.standard._Collection_if getSuperCIDsOf (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception ;
  void refresh (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception ;
  void refresh () throws Exception ;
  JP.go.ipa.oz.user.ide.CIPart_if getPart (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getLabelNameOf (JP.go.ipa.oz.user.ide.CIPart_if part) throws Exception ;
  JP.go.ipa.oz.user.ide.School_if getSchool () throws Exception ;
  void show (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception ;
  JP.go.ipa.oz.lib.standard._Collection_if getReferingCIDsOf (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception ;
  JP.go.ipa.oz.lib.standard._Collection_if getAncestorPartsOf (JP.go.ipa.oz.user.ide.CIPart_if part) throws Exception ;
  void disposeAll () throws Exception ;
  void dispose (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception ;
  void disposeHierarchy () throws Exception ;
  JP.go.ipa.oz.lib.standard._Collection_if getInstantiatingCIDsOf (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception ;
  JP.go.ipa.oz.lib.standard._Collection_if getAncestorCIDsOf (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception ;
  void refreshHierarchy () throws Exception ;
  void showHierarchy () throws Exception ;
}


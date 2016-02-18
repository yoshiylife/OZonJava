package JP.go.ipa.oz.user.apl.fed;

public interface GenusCategory_if extends JP.go.ipa.oz.user.apl.fed.FedRoot_if {
  static final boolean _global_ = true;
  
  JP.go.ipa.oz.lib.standard._String_if getType () throws Exception ;
  boolean isMemberOf (JP.go.ipa.oz.lib.standard._String_if s) throws Exception ;
  void setType (JP.go.ipa.oz.lib.standard._String_if s) throws Exception ;
  void setCategoryName (JP.go.ipa.oz.lib.standard._String_if s) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getCategoryName () throws Exception ;
}


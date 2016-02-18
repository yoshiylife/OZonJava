package JP.go.ipa.oz.user.apl.fed;

public interface Federation_if extends JP.go.ipa.oz.user.apl.fed.Autonomy_if {
  static final boolean _global_ = true;
  
  void addAutonomy (JP.go.ipa.oz.lib.standard._String_if autonomy) throws Exception ;
  void removeAutonomy (JP.go.ipa.oz.lib.standard._String_if autonomy) throws Exception ;
  JP.go.ipa.oz.user.apl.fed.ResourceProxy_if findRelayProxy (JP.go.ipa.oz.lib.standard._Set_if pivots, JP.go.ipa.oz.user.apl.fed.ResourceProxy_if adapter) throws Exception ;
  JP.go.ipa.oz.lib.standard._Dictionary_if getAutonomies () throws Exception ;
}


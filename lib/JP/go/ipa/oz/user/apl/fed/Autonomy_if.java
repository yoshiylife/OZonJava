package JP.go.ipa.oz.user.apl.fed;

public interface Autonomy_if extends JP.go.ipa.oz.user.apl.fed.GenusCategory_if {
  static final boolean _global_ = true;
  
  void setResourceProxyToCache (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if proxy) throws Exception ;
  void removeResource (JP.go.ipa.oz.lib.standard._String_if resource) throws Exception ;
  JP.go.ipa.oz.user.apl.fed.ResourceProxy_if findResourceProxy (JP.go.ipa.oz.lib.standard._Set_if proxs, JP.go.ipa.oz.lib.standard._String_if resType, JP.go.ipa.oz.lib.standard._String_if autoType) throws Exception ;
  JP.go.ipa.oz.user.apl.fed.ResourceProxy_if getResourceProxyByCache (JP.go.ipa.oz.lib.standard._String_if resGol) throws Exception ;
  boolean containsResource (JP.go.ipa.oz.lib.standard._String_if resource) throws Exception ;
  void flushCache (JP.go.ipa.oz.lib.standard._String_if resGol) throws Exception ;
  void flushCache () throws Exception ;
  void addResourceProxy (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if proxy) throws Exception ;
  JP.go.ipa.oz.lib.standard._Set_if getResourceProxies () throws Exception ;
  JP.go.ipa.oz.lib.standard._Set_if getCache () throws Exception ;
  void attachToFederation (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception ;
  JP.go.ipa.oz.lib.standard._Set_if getSurrogatePivots () throws Exception ;
  void removeResourceProxy (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if proxy) throws Exception ;
  JP.go.ipa.oz.user.apl.fed.ResourceProxy_if getResourceProxy (JP.go.ipa.oz.lib.standard._String_if resType, JP.go.ipa.oz.lib.standard._String_if pivot, JP.go.ipa.oz.lib.standard._String_if autoType) throws Exception ;
  JP.go.ipa.oz.lib.standard._Set_if getFederations () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if asString () throws Exception ;
  void addResource (JP.go.ipa.oz.lib.standard._String_if resource) throws Exception ;
  JP.go.ipa.oz.user.apl.fed.ResourceProxy_if findSurrogate (JP.go.ipa.oz.lib.standard._String_if resType, JP.go.ipa.oz.lib.standard._String_if autoType) throws Exception ;
  JP.go.ipa.oz.lib.standard._Set_if getAdapters () throws Exception ;
  JP.go.ipa.oz.user.apl.fed.ResourceProxy_if exportResource (JP.go.ipa.oz.lib.standard._Set_if pivots) throws Exception ;
  JP.go.ipa.oz.user.apl.fed.ResourceProxy_if getAdapter (JP.go.ipa.oz.lib.standard._String_if resType, JP.go.ipa.oz.lib.standard._Set_if pivots) throws Exception ;
  JP.go.ipa.oz.lib.standard._Set_if getAdapterPivots () throws Exception ;
  JP.go.ipa.oz.lib.standard._Dictionary_if getResources () throws Exception ;
  JP.go.ipa.oz.user.apl.fed.ResourceProxy_if findAdapter (JP.go.ipa.oz.lib.standard._String_if autoType, JP.go.ipa.oz.lib.standard._String_if resType) throws Exception ;
  void detachFromFederation (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception ;
  JP.go.ipa.oz.lib.standard._Set_if getSurrogates () throws Exception ;
  JP.go.ipa.oz.user.apl.fed.ResourceProxy_if importResource (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception ;
  JP.go.ipa.oz.user.apl.fed.ResourceProxy_if importResource (JP.go.ipa.oz.lib.standard._String_if resGol, JP.go.ipa.oz.lib.standard._String_if pivot) throws Exception ;
}


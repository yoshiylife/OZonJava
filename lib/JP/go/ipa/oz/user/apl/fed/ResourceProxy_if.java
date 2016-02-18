package JP.go.ipa.oz.user.apl.fed;

public interface ResourceProxy_if extends JP.go.ipa.oz.lang._Root_if {
  
  JP.go.ipa.oz.user.apl.fed.ResourceProxy_if instanciate (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if prev) throws Exception ;
  JP.go.ipa.oz.user.apl.fed.ResourceProxy_if instanciate () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getAutonomyType () throws Exception ;
  boolean isEqual (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if rp) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getResource () throws Exception ;
  JP.go.ipa.oz.user.apl.fed.ResourceProxy_if getPrevious () throws Exception ;
  void setResource (JP.go.ipa.oz.lib.standard._String_if resGol) throws Exception ;
  void setAutonomyType (JP.go.ipa.oz.lib.standard._String_if type) throws Exception ;
  void setPrevious (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if prev) throws Exception ;
  boolean isAcceptable (JP.go.ipa.oz.lib.standard._String_if aType, JP.go.ipa.oz.lib.standard._String_if rType) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getResourceType () throws Exception ;
  void setResourceType (JP.go.ipa.oz.lib.standard._String_if type) throws Exception ;
}


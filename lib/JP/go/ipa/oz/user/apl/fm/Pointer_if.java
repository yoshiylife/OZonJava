package JP.go.ipa.oz.user.apl.fm;

public interface Pointer_if extends JP.go.ipa.oz.lang._Root_if {
  
  void setLocation (JP.go.ipa.oz.lib.standard._String_if loc) throws Exception ;
  void setName (JP.go.ipa.oz.lib.standard._String_if n) throws Exception ;
  boolean isEqualPointer (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getName () throws Exception ;
  JP.go.ipa.oz.user.apl.fm.FMContainer_if container () throws Exception ;
  JP.go.ipa.oz.user.apl.fm.FMObject_if stuff () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getLocation () throws Exception ;
}


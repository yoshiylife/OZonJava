package JP.go.ipa.oz.user.apl.fm;

public interface Relation_if extends JP.go.ipa.oz.lang._Root_if {
  
  void detach () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getRole (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception ;
  void disable () throws Exception ;
  JP.go.ipa.oz.user.apl.fm.FMObject_if get () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getDstRole () throws Exception ;
  void setName (JP.go.ipa.oz.lib.standard._String_if n) throws Exception ;
  void setSrcRole (JP.go.ipa.oz.lib.standard._String_if n) throws Exception ;
  boolean isAvailable () throws Exception ;
  void setRole (JP.go.ipa.oz.lib.standard._String_if n, JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception ;
  void attach (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception ;
  JP.go.ipa.oz.user.apl.fm.Pointer_if destination () throws Exception ;
  void setSource (JP.go.ipa.oz.user.apl.fm.Pointer_if s) throws Exception ;
  void enable () throws Exception ;
  void enable (boolean b) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getSrcRole () throws Exception ;
  void trace (int mark) throws Exception ;
  void setDstRole (JP.go.ipa.oz.lib.standard._String_if n) throws Exception ;
  boolean isEqualRelation (JP.go.ipa.oz.lib.standard._String_if n) throws Exception ;
  boolean isEqualRelation (JP.go.ipa.oz.user.apl.fm.Relation_if r) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getName () throws Exception ;
  JP.go.ipa.oz.user.apl.fm.Pointer_if getSource () throws Exception ;
  void delete () throws Exception ;
  void setDestination (JP.go.ipa.oz.user.apl.fm.Pointer_if d) throws Exception ;
  JP.go.ipa.oz.user.apl.fm.Relation_if cloneRelation () throws Exception ;
}


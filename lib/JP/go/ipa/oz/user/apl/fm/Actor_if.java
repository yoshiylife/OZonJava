package JP.go.ipa.oz.user.apl.fm;

public interface Actor_if extends JP.go.ipa.oz.user.apl.fm.FMObject_if {
  
  void setAccess (JP.go.ipa.oz.lib.standard._String_if access) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getPlace () throws Exception ;
  void setPlace (JP.go.ipa.oz.lib.standard._String_if place) throws Exception ;
  void setRole (JP.go.ipa.oz.user.apl.fm.Actor_if actor) throws Exception ;
  void setRole (JP.go.ipa.oz.lib.standard._String_if roleName) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getAccess () throws Exception ;
}


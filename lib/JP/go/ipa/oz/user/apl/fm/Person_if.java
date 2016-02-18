package JP.go.ipa.oz.user.apl.fm;

public interface Person_if extends JP.go.ipa.oz.user.apl.fm.Actor_if {
  
  JP.go.ipa.oz.lib.standard._String_if getBloodType () throws Exception ;
  void init (JP.go.ipa.oz.lib.standard._String_if btype, JP.go.ipa.oz.lib.standard._Date_if birth) throws Exception ;
  JP.go.ipa.oz.lib.standard._Date_if getBirthDay () throws Exception ;
}


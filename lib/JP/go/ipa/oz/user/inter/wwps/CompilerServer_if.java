package JP.go.ipa.oz.user.inter.wwps;

public interface CompilerServer_if extends JP.go.ipa.oz.lang._Root_if {
  
  void compile (JP.go.ipa.oz.lib.standard._String_if file_name, JP.go.ipa.oz.user.ide.School_if school, JP.go.ipa.oz.lib.standard._Writer_if log) throws Exception ;
  void registerSchool (JP.go.ipa.oz.lib.standard._String_if subject, JP.go.ipa.oz.user.ide.School_if school) throws Exception ;
  JP.go.ipa.oz.user.ide.School_if searchSchool (JP.go.ipa.oz.lib.standard._String_if subject) throws Exception ;
}


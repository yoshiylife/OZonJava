package JP.go.ipa.oz.user.launcher;

public interface GODOperator_if extends JP.go.ipa.oz.lang._Root_if {
  
  JP.go.ipa.oz.lib.standard._String_if toGOD (JP.go.ipa.oz.lib.standard._String_if path, JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if toGOD (JP.go.ipa.oz.lib.standard._String_if path) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if toPath (JP.go.ipa.oz.lib.standard._String_if god) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if toFullPath (JP.go.ipa.oz.lib.standard._String_if god) throws Exception ;
}


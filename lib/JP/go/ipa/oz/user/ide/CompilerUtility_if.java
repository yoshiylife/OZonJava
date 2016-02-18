package JP.go.ipa.oz.user.ide;

public interface CompilerUtility_if extends JP.go.ipa.oz.lang._Root_if {
  
  JP.go.ipa.oz.lib.standard._Set_if getInstanciatedCID (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception ;
  JP.go.ipa.oz.lib.standard._Set_if getDescendantCID (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if replace (JP.go.ipa.oz.lib.standard._String_if target, JP.go.ipa.oz.lib.standard._String_if oldString, JP.go.ipa.oz.lib.standard._String_if newString) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getSubjectName (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception ;
  JP.go.ipa.oz.lib.standard._Set_if getReferedCID (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception ;
}


package JP.go.ipa.oz.user.ide;

public interface Ozc_if extends JP.go.ipa.oz.lang._Root_if {
  
  boolean compile (JP.go.ipa.oz.lib.standard._String_if source, JP.go.ipa.oz.user.ide.School_if sc, JP.go.ipa.oz.lib.standard._Writer_if output, JP.go.ipa.oz.lib.standard._String_if dir) throws Exception ;
  boolean compile (JP.go.ipa.oz.lib.standard._String_if source, JP.go.ipa.oz.user.ide.School_if sc, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception ;
  boolean compile (JP.go.ipa.oz.lib.standard._String_if source, JP.go.ipa.oz.user.ide.School_if sc, JP.go.ipa.oz.lib.standard._String_if dir) throws Exception ;
  boolean compile (JP.go.ipa.oz.lib.standard._String_if source, JP.go.ipa.oz.user.ide.School_if sc) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if displayUsage () throws Exception ;
  boolean compileInterface (JP.go.ipa.oz.lib.standard._String_if source, JP.go.ipa.oz.user.ide.School_if sc, JP.go.ipa.oz.lib.standard._Writer_if output, JP.go.ipa.oz.lib.standard._String_if dir) throws Exception ;
  boolean compileInterface (JP.go.ipa.oz.lib.standard._String_if source, JP.go.ipa.oz.user.ide.School_if sc, JP.go.ipa.oz.lib.standard._Writer_if output) throws Exception ;
  boolean compileInterface (JP.go.ipa.oz.lib.standard._String_if source, JP.go.ipa.oz.user.ide.School_if sc, JP.go.ipa.oz.lib.standard._String_if dir) throws Exception ;
  boolean compileInterface (JP.go.ipa.oz.lib.standard._String_if source, JP.go.ipa.oz.user.ide.School_if sc) throws Exception ;
}


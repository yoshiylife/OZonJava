package JP.go.ipa.oz.user.ide;

public interface CIMethod_if extends JP.go.ipa.oz.user.ide.CIMember_if {
  
  boolean isFinal () throws Exception ;
  boolean isStatic () throws Exception ;
  JP.go.ipa.oz.user.ide.CIType_if getReturnType () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getReturnTypeAsString (JP.go.ipa.oz.user.ide.School_if school) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getReturnTypeAsString () throws Exception ;
  boolean isPublic () throws Exception ;
  boolean isOnce () throws Exception ;
  JP.go.ipa.oz.lib.standard._Iterator_if argumentTypes () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getArgumentTypeAsString (JP.go.ipa.oz.user.ide.School_if school) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getArgumentTypeAsString () throws Exception ;
}


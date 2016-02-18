package JP.go.ipa.oz.user.ide;

public interface CIMember_if extends JP.go.ipa.oz.lang._Root_if {
  
  JP.go.ipa.oz.lib.standard._String_if getModifierAsString () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getAccessLevelAsString () throws Exception ;
  boolean isConstructor () throws Exception ;
  boolean isAttribute () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getName () throws Exception ;
  boolean isMethod () throws Exception ;
  JP.go.ipa.oz.user.ide.CIPart_if getDeclaringPart () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if asString (JP.go.ipa.oz.user.ide.School_if s) throws Exception ;
}


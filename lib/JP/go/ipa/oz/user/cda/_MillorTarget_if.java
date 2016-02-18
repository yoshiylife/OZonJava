package JP.go.ipa.oz.user.cda;

public interface _MillorTarget_if extends JP.go.ipa.oz.lang._Root_if {
  
  boolean isClient () throws Exception ;
  void addTopPackageName (JP.go.ipa.oz.lib.standard._String_if GOL, JP.go.ipa.oz.lib.standard._String_if Name) throws Exception ;
  void setTime (JP.go.ipa.oz.lib.standard._String_if GOL, JP.go.ipa.oz.lib.standard._String_if Name, long time) throws Exception ;
  void add (JP.go.ipa.oz.lib.standard._String_if millorCDAGOL) throws Exception ;
  void setDefaults () throws Exception ;
  JP.go.ipa.oz.lib.standard._Set_if getTargetGOLs () throws Exception ;
  void versionupTopPackage (JP.go.ipa.oz.lib.standard._String_if GOL, JP.go.ipa.oz.lib.standard._String_if Name, long time) throws Exception ;
  JP.go.ipa.oz.lib.standard._Dictionary_if get (JP.go.ipa.oz.lib.standard._String_if GOL) throws Exception ;
  void removeTopPackageName (JP.go.ipa.oz.lib.standard._String_if GOL, JP.go.ipa.oz.lib.standard._String_if Name) throws Exception ;
}


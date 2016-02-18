package JP.go.ipa.oz.user.cda;

public interface _DeliveryFileCache_if extends JP.go.ipa.oz.lang._Root_if {
  
  void put (JP.go.ipa.oz.lib.standard._String_if topPackageName, JP.go.ipa.oz.user.cda._DeliveryFile_if df) throws Exception ;
  JP.go.ipa.oz.user.cda._DeliveryFile_if get (JP.go.ipa.oz.lib.standard._String_if codePath) throws Exception ;
}


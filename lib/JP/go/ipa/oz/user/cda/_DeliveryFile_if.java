package JP.go.ipa.oz.user.cda;

public interface _DeliveryFile_if extends JP.go.ipa.oz.lang._Root_if {
  
  JP.go.ipa.oz.lib.standard._String_if getTopPackageName () throws Exception ;
  long time () throws Exception ;
  int getLength () throws Exception ;
  void timeStamp (long l) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getPackageName () throws Exception ;
  JP.go.ipa.oz.lib.standard._ByteArray_if getContents () throws Exception ;
}


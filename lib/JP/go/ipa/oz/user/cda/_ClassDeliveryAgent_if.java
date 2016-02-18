package JP.go.ipa.oz.user.cda;

public interface _ClassDeliveryAgent_if extends JP.go.ipa.oz.user.misc.cell.Stoppable_if {
  static final boolean _global_ = true;
  
  void millorsAddTopPackageName (JP.go.ipa.oz.lib.standard._String_if target, JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
  JP.go.ipa.oz.lib.standard._ClassProperty_if getClassProperty (JP.go.ipa.oz.lib.standard._String_if codePath, JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
  JP.go.ipa.oz.user.cda._DeliveryFile_if millor (JP.go.ipa.oz.lib.standard._String_if topPackageName, long time) throws Exception ;
  int targetsPutAt (int at, JP.go.ipa.oz.lib.standard._String_if target) throws Exception ;
  JP.go.ipa.oz.user.cda._DeliveryFile_if leaveToSearchAndDelivery (JP.go.ipa.oz.lib.standard._String_if codePath) throws Exception ;
  boolean thisWriteInValid (JP.go.ipa.oz.user.cda._DeliveryFile_if df) throws Exception ;
  int targetsPut (JP.go.ipa.oz.lib.standard._String_if target) throws Exception ;
  JP.go.ipa.oz.lib.standard._Dictionary_if millorsGet (JP.go.ipa.oz.lib.standard._String_if target) throws Exception ;
  void targetsRemove (JP.go.ipa.oz.lib.standard._String_if target) throws Exception ;
  void millorsRemoveTopPackageName (JP.go.ipa.oz.lib.standard._String_if target, JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
  JP.go.ipa.oz.user.cda._DeliveryFile_if searchAndDelivery (JP.go.ipa.oz.lib.standard._String_if codePath) throws Exception ;
  void millorsAdd (JP.go.ipa.oz.lib.standard._String_if target) throws Exception ;
  void millorsWriteStart () throws Exception ;
  JP.go.ipa.oz.lib.standard._Array_if targetsTargets () throws Exception ;
  void modeWriteInValid () throws Exception ;
  void setInterval (int interval) throws Exception ;
  void modeCopyOnWrite () throws Exception ;
  JP.go.ipa.oz.lib.standard._ClassFile_if getClassFile (JP.go.ipa.oz.lib.standard._String_if codePath) throws Exception ;
  void targetsSetLeaveTo (JP.go.ipa.oz.lib.standard._String_if whom) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if targetsLeaveToWhom () throws Exception ;
  boolean thisCopyOnRight (JP.go.ipa.oz.user.cda._DeliveryFile_if df) throws Exception ;
  void millorsPollingStart () throws Exception ;
}


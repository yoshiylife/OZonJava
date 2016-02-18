package JP.go.ipa.oz.user.cda;

public interface _TargetCDAList_if extends JP.go.ipa.oz.lang._Root_if {
  
  JP.go.ipa.oz.lib.standard._String_if leaveToWhom () throws Exception ;
  void setLeaveTo (JP.go.ipa.oz.lib.standard._String_if s) throws Exception ;
  int targetsSize () throws Exception ;
  void remove (JP.go.ipa.oz.lib.standard._String_if target) throws Exception ;
  JP.go.ipa.oz.lib.standard._Array_if targets () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if next (int RetryNum) throws Exception ;
  void setDefaults () throws Exception ;
  int putAt (int at, JP.go.ipa.oz.lib.standard._String_if target) throws Exception ;
  int put (JP.go.ipa.oz.lib.standard._String_if target) throws Exception ;
}


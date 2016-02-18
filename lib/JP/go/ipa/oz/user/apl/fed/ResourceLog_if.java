package JP.go.ipa.oz.user.apl.fed;

public interface ResourceLog_if extends JP.go.ipa.oz.lang._Root_if {
  
  void in () throws Exception ;
  void out () throws Exception ;
  JP.go.ipa.oz.lib.standard._Date_if getOutTime () throws Exception ;
  JP.go.ipa.oz.lib.standard._Date_if getInTime () throws Exception ;
}


package JP.go.ipa.oz.user.apl.fm;

public interface Schedulable_if extends JP.go.ipa.oz.user.apl.fm.FMObject_if {
  
  void cancel (JP.go.ipa.oz.user.apl.fm.Reserve_if res) throws Exception ;
  JP.go.ipa.oz.user.apl.fm.ScheduleBoard_if getBoard () throws Exception ;
  boolean reserve (JP.go.ipa.oz.user.apl.fm.Reserve_if res) throws Exception ;
  JP.go.ipa.oz.lib.standard._SList_if confirm (JP.go.ipa.oz.user.apl.fm.Reserve_if res) throws Exception ;
}


package JP.go.ipa.oz.user.apl.fm;

public interface Scheduler_if extends JP.go.ipa.oz.user.apl.fm.FMObject_if {
  
  JP.go.ipa.oz.lib.standard._SList_if confirm (JP.go.ipa.oz.user.apl.fm.Reserve_if res) throws Exception ;
  void bindEntity (JP.go.ipa.oz.user.apl.fm.Schedulable_if entity) throws Exception ;
  void cancel (JP.go.ipa.oz.user.apl.fm.Reserve_if res) throws Exception ;
  boolean reserve (JP.go.ipa.oz.user.apl.fm.Reserve_if res) throws Exception ;
}


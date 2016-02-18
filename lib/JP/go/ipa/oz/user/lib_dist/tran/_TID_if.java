package JP.go.ipa.oz.user.lib_dist.tran;

public interface _TID_if extends JP.go.ipa.oz.lang._Root_if {
  
  JP.go.ipa.oz.lib.standard._String_if getTidGOL () throws Exception ;
  boolean equal (JP.go.ipa.oz.user.lib_dist.tran._TID_if tid) throws Exception ;
  void init () throws Exception ;
  void setID (int i) throws Exception ;
  void set (int i, JP.go.ipa.oz.lib.standard._String_if s) throws Exception ;
  int getID () throws Exception ;
  int getLockMode () throws Exception ;
  void setLockMode (int i) throws Exception ;
}


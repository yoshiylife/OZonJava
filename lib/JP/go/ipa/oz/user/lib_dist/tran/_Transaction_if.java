package JP.go.ipa.oz.user.lib_dist.tran;

public interface _Transaction_if {
  static final boolean _global_ = true;
  
  JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if getResource (JP.go.ipa.oz.lib.standard._String_if rg) throws Exception ;
  JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if getResource (JP.go.ipa.oz.lib.standard._String_if rg, int time) throws Exception ;
  void lock (JP.go.ipa.oz.lib.standard._Array_if res) throws Exception ;
  void abortTran (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception ;
  void lockHead (JP.go.ipa.oz.lib.standard._Array_if res, int lockMode, int time) throws Exception ;
  void commit () throws Exception ;
  boolean isLock () throws Exception ;
  void setLockingResource (JP.go.ipa.oz.lib.standard._String_if rg) throws Exception ;
  void setResourceTimeOut (int time) throws Exception ;
  int getMaxBlockingResource () throws Exception ;
  JP.go.ipa.oz.lib.standard._Array_if getBlockingResources () throws Exception ;
  int getLx () throws Exception ;
}


package JP.go.ipa.oz.user.lib_dist.tran;

public interface _TransactionResource_if {
  static final boolean _global_ = true;
  
  JP.go.ipa.oz.lib.standard._String_if test () throws Exception ;
  void rollback (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception ;
  int lock (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception ;
  boolean commit (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception ;
  void unlock (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception ;
  JP.go.ipa.oz.lib.standard._SList_if getLockingTransaction () throws Exception ;
  boolean isReadyToCommit (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception ;
  int block (JP.go.ipa.oz.user.lib_dist.tran._TID_if t, int lockMode) throws Exception ;
  int sharedLock (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception ;
  void checkLockingTimeBody () throws Exception ;
  int getLockMode () throws Exception ;
}


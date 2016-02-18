package JP.go.ipa.oz.user.lib_dist.tran;

public interface _Status_if extends JP.go.ipa.oz.lang._Root_if {
  
  void blockToLock () throws Exception ;
  void unlock (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception ;
  void init0 () throws Exception ;
  int getWaitUnlock () throws Exception ;
  boolean isInLockingTransaction (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception ;
  void setMaxBlockingTransaction (int i) throws Exception ;
  int getMaxBlockingTransaction () throws Exception ;
  void init () throws Exception ;
  void init (int ml, int mb) throws Exception ;
  JP.go.ipa.oz.lib.standard._SList_if getLockingTransaction () throws Exception ;
  void setLockingTimeLimit (int i) throws Exception ;
  boolean setBlockingTransaction (JP.go.ipa.oz.user.lib_dist.tran._TID_if t) throws Exception ;
  int getLockMode () throws Exception ;
  void setCommit (int i) throws Exception ;
  void setLockMode (int i) throws Exception ;
  int lockBody (JP.go.ipa.oz.user.lib_dist.tran._TID_if t, int i) throws Exception ;
  JP.go.ipa.oz.lib.standard._SList_if getBlockingTransaction () throws Exception ;
  int getLockingTransactionSize () throws Exception ;
  int getLockingTimeLimit () throws Exception ;
  void setMaxLockingTransaction (int i) throws Exception ;
  int getMaxLockingTransaction () throws Exception ;
  void setWaitUnlock (int i) throws Exception ;
  int getCommit () throws Exception ;
}


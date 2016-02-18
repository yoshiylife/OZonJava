package JP.go.ipa.oz.user.lib_dist.replica;

public interface CopyScheme_if extends JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if {
  static final boolean _global_ = true;
  
  int getTimeOut () throws Exception ;
  boolean commitAll () throws Exception ;
  void setCpmGol (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception ;
  boolean commit () throws Exception ;
  JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if getClientStubCP () throws Exception ;
  void printCrushList () throws Exception ;
  void setResourceTimeLimit (int time) throws Exception ;
  boolean propagateAllCP (int type) throws Exception ;
  boolean isLive () throws Exception ;
  void setTid (int id) throws Exception ;
  void printCopyList () throws Exception ;
  boolean propagate () throws Exception ;
  void setTimeOut (int time) throws Exception ;
  boolean removeCopyOf (JP.go.ipa.oz.lib.standard._String_if delGol) throws Exception ;
  boolean lockAll () throws Exception ;
  void update (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception ;
  void update () throws Exception ;
  boolean lock () throws Exception ;
  void setCpManeger () throws Exception ;
}


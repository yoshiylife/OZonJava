package JP.go.ipa.oz.user.lib_dist.name;

public interface _SystemMapTransactionResource_if extends JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if {
  static final boolean _global_ = true;
  
  void restored (JP.go.ipa.oz.lib.standard._String_if serverNSTRGOL) throws Exception ;
  void troubleWith (JP.go.ipa.oz.lib.standard._String_if serverNSTRGOL) throws Exception ;
  void troubleControlPollingStart () throws Exception ;
  void debugPrint () throws Exception ;
  void setDelimitor (JP.go.ipa.oz.lib.standard._String_if s) throws Exception ;
  JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if FindOwner (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception ;
  void putBranch (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.lib.standard._String_if toGOL) throws Exception ;
  void addMapping (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.user.lib_dist.name._Path_if to, JP.go.ipa.oz.lib.standard._String_if serverNSTGOL) throws Exception ;
  void unBranched (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception ;
  void setDomainName (JP.go.ipa.oz.lib.standard._String_if s) throws Exception ;
  boolean containServer (JP.go.ipa.oz.lib.standard._String_if serverGOL) throws Exception ;
  void RemoveNameServer (JP.go.ipa.oz.lib.standard._String_if serverGOL) throws Exception ;
  void replaceBranch (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.lib.standard._String_if toGOL) throws Exception ;
  void AddNameServer (JP.go.ipa.oz.lib.standard._String_if serverGOL) throws Exception ;
}


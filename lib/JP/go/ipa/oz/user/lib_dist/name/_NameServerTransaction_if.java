package JP.go.ipa.oz.user.lib_dist.name;

public interface _NameServerTransaction_if extends JP.go.ipa.oz.user.lib_dist.tran._Transaction_if {
  static final boolean _global_ = true;
  
  JP.go.ipa.oz.lang._Root_if renameEntry (JP.go.ipa.oz.user.lib_dist.name._Path_if source, JP.go.ipa.oz.user.lib_dist.name._Path_if target) throws Exception ;
  void putDirectoryAsBranch (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception ;
  void putDirectoryAsBranch (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if dir) throws Exception ;
  int EntrySize (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception ;
  JP.go.ipa.oz.lang._Root_if getEntry (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception ;
  JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if removeDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception ;
  boolean containDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if OwnerNSTR (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception ;
  void unBranched (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception ;
  void moveBranch (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.lib.standard._String_if toGOL) throws Exception ;
  void debugPrint () throws Exception ;
  JP.go.ipa.oz.lib.standard._Set_if DirectorySet (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception ;
  JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if getDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception ;
  void setSystemMapTransactionResource (JP.go.ipa.oz.lib.standard._String_if s) throws Exception ;
  void setNameServerTransactionResource (JP.go.ipa.oz.lib.standard._String_if s) throws Exception ;
  JP.go.ipa.oz.lang._Root_if removeEntry (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception ;
  void removeNameServer () throws Exception ;
  int DirectorySize (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception ;
  JP.go.ipa.oz.lib.standard._Set_if EntrySet (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception ;
  void putDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception ;
  void putDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if subdir) throws Exception ;
  void putEntry (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.lang._Root_if ent) throws Exception ;
  boolean containEntry (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception ;
  JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if renameDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if source, JP.go.ipa.oz.user.lib_dist.name._Path_if target) throws Exception ;
  void addNameServer () throws Exception ;
  void putDirectoryAsMapping (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.user.lib_dist.name._Path_if to, JP.go.ipa.oz.lib.standard._String_if serverNSTGOL) throws Exception ;
}


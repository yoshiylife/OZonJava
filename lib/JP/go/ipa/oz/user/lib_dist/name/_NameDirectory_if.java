package JP.go.ipa.oz.user.lib_dist.name;

public interface _NameDirectory_if extends JP.go.ipa.oz.lang._Root_if {
  
  JP.go.ipa.oz.lib.standard._Set_if DirectoryNameSet () throws Exception ;
  int EntrySize () throws Exception ;
  void BranchInOtherCell (JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
  JP.go.ipa.oz.lang._Root_if getEntry (JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
  JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if removeDirectory (JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
  boolean containDirectory (JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
  boolean debugPrint (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception ;
  boolean isBranch () throws Exception ;
  JP.go.ipa.oz.lib.standard._Set_if DirectorySet () throws Exception ;
  JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if getDirectory (JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
  void overputDirectory (JP.go.ipa.oz.lib.standard._String_if name, JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if dir) throws Exception ;
  JP.go.ipa.oz.lang._Root_if removeEntry (JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
  int DirectorySize () throws Exception ;
  JP.go.ipa.oz.lib.standard._Set_if EntryNameSet () throws Exception ;
  JP.go.ipa.oz.lib.standard._Set_if EntrySet () throws Exception ;
  void putDirectory (JP.go.ipa.oz.lib.standard._String_if name, JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if dir) throws Exception ;
  void putEntry (JP.go.ipa.oz.lib.standard._String_if name, JP.go.ipa.oz.lang._Root_if ent) throws Exception ;
  boolean containEntry (JP.go.ipa.oz.lib.standard._String_if name) throws Exception ;
}


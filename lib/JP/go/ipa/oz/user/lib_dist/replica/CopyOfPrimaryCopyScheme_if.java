package JP.go.ipa.oz.user.lib_dist.replica;

public interface CopyOfPrimaryCopyScheme_if extends JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if {
  static final boolean _global_ = true;
  
  JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if getClientStub () throws Exception ;
  boolean propagateAll () throws Exception ;
  JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if getPrimaryCopy () throws Exception ;
  void setPrimaryFlag (boolean flag) throws Exception ;
  void primaryUpdate () throws Exception ;
  boolean newSecondaryCopyAt (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if copy, JP.go.ipa.oz.lib.standard._String_if gol) throws Exception ;
  boolean removeSecondaryCopyOf (JP.go.ipa.oz.lib.standard._String_if delGol) throws Exception ;
  void setAllPrimaryCopy (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if newprim) throws Exception ;
  void setAllPrimaryCopy (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if newprim, JP.go.ipa.oz.lib.standard._String_if gol) throws Exception ;
  void setPrimaryGOL (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception ;
  void setPrimaryCopy (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPrimaryCopyScheme_if cp) throws Exception ;
}


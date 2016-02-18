package JP.go.ipa.oz.user.lib_dist.replica;

public interface CopyOfPeerCopyScheme_if extends JP.go.ipa.oz.user.lib_dist.replica.CopyScheme_if {
  static final boolean _global_ = true;
  
  void makeList (JP.go.ipa.oz.lib.standard._Set_if list, JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if parent) throws Exception ;
  JP.go.ipa.oz.user.lib_dist.replica.CopyOfPeerCopyScheme_if getCopy (JP.go.ipa.oz.lib.standard._String_if cpGol) throws Exception ;
  JP.go.ipa.oz.user.lib_dist.replica.CopyOfPeerCopyScheme_if getClientStub () throws Exception ;
  boolean propagateAll () throws Exception ;
  void newCopyAt (JP.go.ipa.oz.user.lib_dist.replica.CopyOfPeerCopyScheme_if newCopy, JP.go.ipa.oz.lib.standard._String_if gol, JP.go.ipa.oz.lib.standard._String_if mngGol) throws Exception ;
  void addOtherCopy (JP.go.ipa.oz.user.lib_dist.replica.CopyResource_if newRes) throws Exception ;
}


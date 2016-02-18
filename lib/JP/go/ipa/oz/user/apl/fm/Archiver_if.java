package JP.go.ipa.oz.user.apl.fm;

public interface Archiver_if {
  static final boolean _global_ = true;
  
  void remove (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception ;
  void initialize () throws Exception ;
  void add (JP.go.ipa.oz.user.apl.fm.Pointer_if oid, JP.go.ipa.oz.user.apl.fm.Pointer_if nid) throws Exception ;
  void quiet () throws Exception ;
  JP.go.ipa.oz.user.apl.fm.Pointer_if find (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception ;
}


package JP.go.ipa.oz.user.apl.fm;

public interface FMContainer_if {
  static final boolean _global_ = true;
  
  JP.go.ipa.oz.user.apl.fm.Karte_if getKarte (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception ;
  void commit (JP.go.ipa.oz.user.apl.fm.FMObject_if obj) throws Exception ;
  void trace (int mark) throws Exception ;
  void remove (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception ;
  JP.go.ipa.oz.user.apl.fm.Pointer_if find (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception ;
  JP.go.ipa.oz.user.apl.fm.Pointer_if add (JP.go.ipa.oz.user.apl.fm.FMObject_if obj) throws Exception ;
  JP.go.ipa.oz.user.apl.fm.Pointer_if getIdentifier (JP.go.ipa.oz.user.apl.fm.FMObject_if obj) throws Exception ;
  boolean contains (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception ;
  void quiet () throws Exception ;
  JP.go.ipa.oz.user.apl.fm.FMObject_if get (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception ;
  void initialize () throws Exception ;
  JP.go.ipa.oz.user.apl.fm.Pointer_if move (JP.go.ipa.oz.user.apl.fm.Pointer_if oid, JP.go.ipa.oz.user.apl.fm.Pointer_if fid) throws Exception ;
}


package JP.go.ipa.oz.user.apl.fm;

public interface TimePiece_if extends JP.go.ipa.oz.lang._Root_if {
  
  boolean isEqualTimePiece (JP.go.ipa.oz.user.apl.fm.TimePiece_if t) throws Exception ;
  void setName (JP.go.ipa.oz.lib.standard._String_if nam) throws Exception ;
  boolean isReservable () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getName () throws Exception ;
  void cancel () throws Exception ;
  void reserve () throws Exception ;
}


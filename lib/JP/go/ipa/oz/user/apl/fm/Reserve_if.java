package JP.go.ipa.oz.user.apl.fm;

public interface Reserve_if extends JP.go.ipa.oz.user.apl.fm.Relation_if {
  
  void setState (JP.go.ipa.oz.lib.standard._String_if stat) throws Exception ;
  void setState (int stat) throws Exception ;
  int getStartHour () throws Exception ;
  int getEndMinute () throws Exception ;
  int getStartMinute () throws Exception ;
  void setDay (int date) throws Exception ;
  void cancel () throws Exception ;
  void init (int date, int sh, int sm, int eh, int em) throws Exception ;
  int getDay () throws Exception ;
  void setStartMinute (int st) throws Exception ;
  void setStartHour (int st) throws Exception ;
  int getEndHour () throws Exception ;
  void setEndHour (int ed) throws Exception ;
  void setReserve (int date, int sh, int sm, int eh, int em) throws Exception ;
  void setEndMinute (int ed) throws Exception ;
}


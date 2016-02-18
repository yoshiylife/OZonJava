package JP.go.ipa.oz.user.apl.fm;

public interface ScheduleBoard_if extends JP.go.ipa.oz.lang._Root_if {
  
  JP.go.ipa.oz.user.apl.fm.ScheduleBoard_if cloneSelf () throws Exception ;
  void cancel (JP.go.ipa.oz.user.apl.fm.Reserve_if res) throws Exception ;
  void setGrid (int gd) throws Exception ;
  void setDays (int date) throws Exception ;
  int getInitTime () throws Exception ;
  void setInitTime (int time) throws Exception ;
  JP.go.ipa.oz.lib.standard._SList_if getTable () throws Exception ;
  int timeToPiece (int hour, int minute) throws Exception ;
  void reset () throws Exception ;
  int getSpan () throws Exception ;
  boolean isEqualScheduleBoard (JP.go.ipa.oz.user.apl.fm.ScheduleBoard_if s) throws Exception ;
  JP.go.ipa.oz.lib.standard._SList_if confirm (JP.go.ipa.oz.user.apl.fm.Reserve_if res) throws Exception ;
  void trace (int mark) throws Exception ;
  boolean reserve (int date, int start, int end) throws Exception ;
  boolean reserve (JP.go.ipa.oz.user.apl.fm.Reserve_if res) throws Exception ;
  int getPieceNum () throws Exception ;
  JP.go.ipa.oz.lib.standard._SList_if getSelectedSchedule (int date, int start, int end) throws Exception ;
  JP.go.ipa.oz.lib.standard._SList_if getSelectedSchedule (JP.go.ipa.oz.user.apl.fm.Reserve_if res) throws Exception ;
  void setSpan (int sp) throws Exception ;
  int getGrid () throws Exception ;
  int getDays () throws Exception ;
}


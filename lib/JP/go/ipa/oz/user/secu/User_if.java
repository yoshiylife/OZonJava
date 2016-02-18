package JP.go.ipa.oz.user.secu;

public interface User_if extends JP.go.ipa.oz.lang._Root_if {
  
  void setExDate (JP.go.ipa.oz.lib.standard._Date_if edate) throws Exception ;
  JP.go.ipa.oz.lib.standard._OzKey_if getKey () throws Exception ;
  JP.go.ipa.oz.lib.standard._OzKey_if getTicketKey () throws Exception ;
  void setTicketKey (JP.go.ipa.oz.lib.standard._OzKey_if ticketKey) throws Exception ;
  JP.go.ipa.oz.lib.standard._Date_if getExDate () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getName () throws Exception ;
}


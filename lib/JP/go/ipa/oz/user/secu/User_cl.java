package JP.go.ipa.oz.user.secu;

public class User_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.secu.User_if {
  JP.go.ipa.oz.lib.standard._Date_if edate;
  JP.go.ipa.oz.lib.standard._String_if name;
  JP.go.ipa.oz.lib.standard._OzKey_if ticketKey;
  JP.go.ipa.oz.lib.standard._OzKey_if key;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if name, JP.go.ipa.oz.lib.standard._OzKey_if key) throws Exception  {
// 20
    ((JP.go.ipa.oz.user.secu.User_cl)this).name = name;
// 20
    ((JP.go.ipa.oz.user.secu.User_cl)this).key = key;
    return this;
  }
  
  public void setExDate (JP.go.ipa.oz.lib.standard._Date_if edate) throws Exception  {
    checkSecureInvocation ();
// 24
    ((JP.go.ipa.oz.user.secu.User_cl)this).edate = edate;
  }
  
  public JP.go.ipa.oz.lib.standard._OzKey_if getKey () throws Exception  {
    checkSecureInvocation ();
// 23
    return key;
  }
  
  public JP.go.ipa.oz.lib.standard._OzKey_if getTicketKey () throws Exception  {
    checkSecureInvocation ();
// 27
    return ticketKey;
  }
  
  public void setTicketKey (JP.go.ipa.oz.lib.standard._OzKey_if ticketKey) throws Exception  {
    checkSecureInvocation ();
// 26
    ((JP.go.ipa.oz.user.secu.User_cl)this).ticketKey = ticketKey;
  }
  
  public JP.go.ipa.oz.lib.standard._Date_if getExDate () throws Exception  {
    checkSecureInvocation ();
// 25
    return edate;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getName () throws Exception  {
    checkSecureInvocation ();
// 22
    return name;
  }
  
  public User_cl () throws Exception { super (); }
  
}


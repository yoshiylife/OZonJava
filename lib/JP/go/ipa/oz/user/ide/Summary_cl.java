package JP.go.ipa.oz.user.ide;

abstract public class Summary_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.Summary_if {
  protected JP.go.ipa.oz.user.garage.Key_if theKey;
  protected JP.go.ipa.oz.lib.standard._String_if serverGOL;
  
  public JP.go.ipa.oz.user.garage.Key_if getKey () throws Exception  {
    checkSecureInvocation ();
// 40
    return theKey;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getLocation () throws Exception  {
    checkSecureInvocation ();
// 47
    return serverGOL;
  }
  
  public abstract void describe () throws Exception  ;
  public void setLocation (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
    checkSecureInvocation ();
// 86
    serverGOL = gol;
  }
  
  public void setLocation () throws Exception  {
    checkSecureInvocation ();
// 79
    serverGOL = getGOL ();
  }
  
  public void setKey (JP.go.ipa.oz.user.garage.Key_if key) throws Exception  {
    checkSecureInvocation ();
// 72
    theKey = key;
  }
  
  public JP.go.ipa.oz.user.ide.Summarizable_if retreive () throws Exception  {
    checkSecureInvocation ();
// 54
    JP.go.ipa.oz.user.garage.SGarage_if sg = null;
// 55
    JP.go.ipa.oz.user.ide.Summarizable_if sbl = null;
// 56
    JP.go.ipa.oz.user.garage.GarageException_if ex = null;
// 58
    if (serverGOL == null) {{
// 59
        ex = (JP.go.ipa.oz.user.garage.GarageException_cl) (new JP.go.ipa.oz.user.garage.GarageException_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl("null GOL")));
// 60
        throw new JP.go.ipa.oz.lang.OzException (ex);
      }
    }
// 62
    sg = new JP.go.ipa.oz.user.garage.SGarage_pcl (serverGOL);
// 63
    sbl = sg.get (theKey);
// 65
    return sbl;
  }
  
  public Summary_cl () throws Exception { super (); }
  
}


package JP.go.ipa.oz.user.ide;

public class Application_cl extends JP.go.ipa.oz.user.ide.Summarizable_cl implements JP.go.ipa.oz.user.ide.Application_if {
  JP.go.ipa.oz.lib.standard._String_if classID;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
// 35
    classID = cid;
    return this;
  }
  
  public void setClassID (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
    checkSecureInvocation ();
// 51
    classID = cid;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getClassID () throws Exception  {
    checkSecureInvocation ();
// 44
    return classID;
  }
  
  public Application_cl () throws Exception { super (); }
  
}


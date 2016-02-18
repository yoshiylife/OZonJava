package JP.go.ipa.oz.user.ide;

public class SubjectSummary_cl extends JP.go.ipa.oz.user.ide.Summary_cl implements JP.go.ipa.oz.user.ide.SubjectSummary_if {
  JP.go.ipa.oz.lib.standard._String_if myDescription;
  JP.go.ipa.oz.lib.standard._String_if myName;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if name, JP.go.ipa.oz.lib.standard._String_if dsc) throws Exception  {
// 41
    init (name, dsc);
    return this;
  }
  
  public Object _new_create () throws Exception  {
// 36
    init (null, null);
    return this;
  }
  
  public void setName (JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 88
    myName = name;
  }
  
  public void describe () throws Exception  {
    checkSecureInvocation ();
  }
  
  void init (JP.go.ipa.oz.lib.standard._String_if name, JP.go.ipa.oz.lib.standard._String_if dsc) throws Exception  {
// 97
    myName = name;
// 98
    myDescription = dsc;
  }
  
  public JP.go.ipa.oz.user.ide.Subject_if retreiveSubject () throws Exception  {
    checkSecureInvocation ();
// 70
    JP.go.ipa.oz.user.ide.Subject_if sbj = null;
// 72
    sbj = (JP.go.ipa.oz.user.ide.Subject_if) (super.retreive ());
// 74
    return sbj;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getName () throws Exception  {
    checkSecureInvocation ();
// 63
    return myName;
  }
  
  public void setDescription (JP.go.ipa.oz.lib.standard._String_if dsc) throws Exception  {
    checkSecureInvocation ();
// 81
    myDescription = dsc;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getDescription () throws Exception  {
    checkSecureInvocation ();
// 56
    return myDescription;
  }
  
  public SubjectSummary_cl () throws Exception { super (); }
  
}


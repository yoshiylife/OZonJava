package JP.go.ipa.oz.user.ide;

abstract public class Summarizable_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.Summarizable_if {
  protected JP.go.ipa.oz.user.ide.Summary_if summary;
  
  public void setSummary (JP.go.ipa.oz.user.ide.Summary_if sm) throws Exception  {
    checkSecureInvocation ();
// 45
    summary = sm;
  }
  
  public JP.go.ipa.oz.user.ide.Summary_if getSummary () throws Exception  {
    checkSecureInvocation ();
// 38
    return summary;
  }
  
  public Summarizable_cl () throws Exception { super (); }
  
}


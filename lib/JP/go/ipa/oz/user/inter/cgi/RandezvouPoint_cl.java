package JP.go.ipa.oz.user.inter.cgi;

public class RandezvouPoint_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.inter.cgi.RandezvouPoint_if {
  JP.go.ipa.oz.system.OzCondition randezvou = new JP.go.ipa.oz.system.OzCondition (this);
  JP.go.ipa.oz.user.inter.cgi.HTMLData_if html_obj;
  
  public Object _new_create () throws Exception  {
    return this;
  }
  
  public void setHtml (JP.go.ipa.oz.user.inter.cgi.HTMLData_if html) throws Exception  {
    checkSecureInvocation ();
// 164
    html_obj = html;
  }
  
  public void waitRandezvou () throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 169
      wait (randezvou);
    } finally {
      leave ();
    }
  }
  
  public void signalRandezvou () throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 174
      signal (randezvou);
    } finally {
      leave ();
    }
  }
  
  public JP.go.ipa.oz.user.inter.cgi.HTMLData_if getHtml () throws Exception  {
    checkSecureInvocation ();
// 157
    return html_obj;
  }
  
  public RandezvouPoint_cl () throws Exception { super (); }
  
}


package JP.go.ipa.oz.user.ide;

public class SubjectSummarySelectListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.SubjectSummarySelectListener_if {
  JP.go.ipa.oz.user.ide.SubjectGarageBrowser_if sgBrowser;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.SubjectGarageBrowser_if sgb) throws Exception  {
// 36
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq = null;
// 38
    eq = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 39
    super._new_newActionListener (eq);
// 40
    sgBrowser = sgb;
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if evt) throws Exception  {
    checkSecureInvocation ();
// 49
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sgBrowser)) {
      try {
        sgBrowser.showSummary ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sgBrowser.showSummary ();
    }
  }
  
  public SubjectSummarySelectListener_cl () throws Exception { super (); }
  
}


package JP.go.ipa.oz.user.ide;

public class ChoiceSubjectController_cl extends JP.go.ipa.oz.lib.standard._ItemListener_cl implements JP.go.ipa.oz.user.ide.ChoiceSubjectController_if {
  JP.go.ipa.oz.user.ide.SchoolBrowser_if sbr;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.SchoolBrowser_if s, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception  {
// 26
    super._new_newItemListener (q);
// 27
    sbr = s;
    return this;
  }
  
  public void itemStateChanged (JP.go.ipa.oz.lib.standard._ItemEvent_if event) throws Exception  {
    checkSecureInvocation ();
// 39
    JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$1113;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
      try {
        getChoSubject$val$1113 = sbr.getChoSubject ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getChoSubject$val$1113 = sbr.getChoSubject ();
    }
// 39
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$1114;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$1113)) {
      try {
        getSelectedItem$val$1114 = getChoSubject$val$1113.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$1114 = getChoSubject$val$1113.getSelectedItem ();
    }
// 39
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
      try {
        sbr.setSchoolList (getSelectedItem$val$1114);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sbr.setSchoolList (getSelectedItem$val$1114);
    }
  }
  
  public ChoiceSubjectController_cl () throws Exception { super (); }
  
}


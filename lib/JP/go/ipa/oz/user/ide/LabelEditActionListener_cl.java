package JP.go.ipa.oz.user.ide;

public class LabelEditActionListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.LabelEditActionListener_if {
  JP.go.ipa.oz.user.ide.LabelEditDialog_if dlg;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.LabelEditDialog_if l, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception  {
// 26
    super._new_newActionListener (q);
// 27
    dlg = l;
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if event) throws Exception  {
    checkSecureInvocation ();
// 39
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$692;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) event)) {
      try {
        getActionCommand$val$692 = event.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$692 = event.getActionCommand ();
    }
// 39
    JP.go.ipa.oz.lib.standard._String_if string$138 = (new JP.go.ipa.oz.lib.standard._String_cl("OK"));
    
// 39
    int compareTo$val$693;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getActionCommand$val$692)) {
      try {
        compareTo$val$693 = getActionCommand$val$692.compareTo (string$138);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compareTo$val$693 = getActionCommand$val$692.compareTo (string$138);
    }
// 39
    if (compareTo$val$693 == 0) {{
// 40
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
          try {
            dlg.modifyLabel ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          dlg.modifyLabel ();
        }
// 41
        JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$694;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
          try {
            getChoSubject$val$694 = dlg.getChoSubject ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$694 = dlg.getChoSubject ();
        }
// 41
        JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$695;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$694)) {
          try {
            getSelectedItem$val$695 = getChoSubject$val$694.getSelectedItem ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSelectedItem$val$695 = getChoSubject$val$694.getSelectedItem ();
        }
// 41
        JP.go.ipa.oz.lib.standard._String_if subject = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (getSelectedItem$val$695);
// 42
        JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser$val$696;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
          try {
            getSchoolBrowser$val$696 = dlg.getSchoolBrowser ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSchoolBrowser$val$696 = dlg.getSchoolBrowser ();
        }
// 42
        JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$697;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchoolBrowser$val$696)) {
          try {
            getChoSubject$val$697 = getSchoolBrowser$val$696.getChoSubject ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$697 = getSchoolBrowser$val$696.getChoSubject ();
        }
// 42
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$697)) {
          try {
            getChoSubject$val$697.select (subject);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$697.select (subject);
        }
// 43
        JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser$val$698;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
          try {
            getSchoolBrowser$val$698 = dlg.getSchoolBrowser ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSchoolBrowser$val$698 = dlg.getSchoolBrowser ();
        }
// 43
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchoolBrowser$val$698)) {
          try {
            getSchoolBrowser$val$698.setSchoolList (subject);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSchoolBrowser$val$698.setSchoolList (subject);
        }
// 44
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
          try {
            dlg.dispose ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          dlg.dispose ();
        }
// 45
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
          try {
            dlg.setVisible (false);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          dlg.setVisible (false);
        }
      }
    } else {{
// 48
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
          try {
            dlg.dispose ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          dlg.dispose ();
        }
// 49
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
          try {
            dlg.setVisible (false);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          dlg.setVisible (false);
        }
      }
    }
  }
  
  public LabelEditActionListener_cl () throws Exception { super (); }
  
}


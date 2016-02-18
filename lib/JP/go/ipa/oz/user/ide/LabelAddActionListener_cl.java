package JP.go.ipa.oz.user.ide;

public class LabelAddActionListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.LabelAddActionListener_if {
  JP.go.ipa.oz.user.ide.LabelAddDialog_if dlg;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.LabelAddDialog_if l, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception  {
// 26
    super._new_newActionListener (q);
// 27
    dlg = l;
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if event) throws Exception  {
    checkSecureInvocation ();
// 39
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$608;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) event)) {
      try {
        getActionCommand$val$608 = event.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$608 = event.getActionCommand ();
    }
// 39
    JP.go.ipa.oz.lib.standard._String_if string$135 = (new JP.go.ipa.oz.lib.standard._String_cl("OK"));
    
// 39
    int compareTo$val$609;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getActionCommand$val$608)) {
      try {
        compareTo$val$609 = getActionCommand$val$608.compareTo (string$135);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compareTo$val$609 = getActionCommand$val$608.compareTo (string$135);
    }
// 39
    if (compareTo$val$609 == 0) {{
// 40
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
          try {
            dlg.putLabel ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          dlg.putLabel ();
        }
// 41
        JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$610;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
          try {
            getChoSubject$val$610 = dlg.getChoSubject ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$610 = dlg.getChoSubject ();
        }
// 41
        JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$611;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$610)) {
          try {
            getSelectedItem$val$611 = getChoSubject$val$610.getSelectedItem ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSelectedItem$val$611 = getChoSubject$val$610.getSelectedItem ();
        }
// 41
        JP.go.ipa.oz.lib.standard._String_if subject = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (getSelectedItem$val$611);
// 42
        JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser$val$612;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
          try {
            getSchoolBrowser$val$612 = dlg.getSchoolBrowser ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSchoolBrowser$val$612 = dlg.getSchoolBrowser ();
        }
// 42
        JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$613;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchoolBrowser$val$612)) {
          try {
            getChoSubject$val$613 = getSchoolBrowser$val$612.getChoSubject ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$613 = getSchoolBrowser$val$612.getChoSubject ();
        }
// 42
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$613)) {
          try {
            getChoSubject$val$613.select (subject);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$613.select (subject);
        }
// 43
        JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser$val$614;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
          try {
            getSchoolBrowser$val$614 = dlg.getSchoolBrowser ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSchoolBrowser$val$614 = dlg.getSchoolBrowser ();
        }
// 43
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchoolBrowser$val$614)) {
          try {
            getSchoolBrowser$val$614.setSchoolList (subject);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSchoolBrowser$val$614.setSchoolList (subject);
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
  
  public LabelAddActionListener_cl () throws Exception { super (); }
  
}


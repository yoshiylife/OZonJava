package JP.go.ipa.oz.user.ide;

public class SubjectAddActionListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.SubjectAddActionListener_if {
  JP.go.ipa.oz.user.ide.SubjectAddDialog_if dlg;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.SubjectAddDialog_if s, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception  {
// 26
    super._new_newActionListener (q);
// 27
    dlg = s;
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if event) throws Exception  {
    checkSecureInvocation ();
// 39
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$739;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) event)) {
      try {
        getActionCommand$val$739 = event.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$739 = event.getActionCommand ();
    }
// 39
    JP.go.ipa.oz.lib.standard._String_if string$140 = (new JP.go.ipa.oz.lib.standard._String_cl("OK"));
    
// 39
    int compareTo$val$740;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getActionCommand$val$739)) {
      try {
        compareTo$val$740 = getActionCommand$val$739.compareTo (string$140);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compareTo$val$740 = getActionCommand$val$739.compareTo (string$140);
    }
// 39
    if (compareTo$val$740 == 0) {{
// 40
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
          try {
            dlg.addSubject ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          dlg.addSubject ();
        }
// 41
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
          try {
            dlg.dispose ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          dlg.dispose ();
        }
// 42
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
    }
  }
  
  public SubjectAddActionListener_cl () throws Exception { super (); }
  
}


package JP.go.ipa.oz.user.ide;

public class DuplicateMessageActionListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.DuplicateMessageActionListener_if {
  JP.go.ipa.oz.user.ide.DuplicateMessageDialog_if dlg;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.DuplicateMessageDialog_if s, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception  {
// 26
    super._new_newActionListener (q);
// 27
    dlg = s;
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if event) throws Exception  {
    checkSecureInvocation ();
// 38
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$1298;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) event)) {
      try {
        getActionCommand$val$1298 = event.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$1298 = event.getActionCommand ();
    }
// 38
    JP.go.ipa.oz.lib.standard._String_if string$251 = (new JP.go.ipa.oz.lib.standard._String_cl("OK"));
    
// 38
    int compareTo$val$1299;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getActionCommand$val$1298)) {
      try {
        compareTo$val$1299 = getActionCommand$val$1298.compareTo (string$251);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compareTo$val$1299 = getActionCommand$val$1298.compareTo (string$251);
    }
// 38
    if (compareTo$val$1299 == 0) {{
// 39
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
          try {
            dlg.dispose ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          dlg.dispose ();
        }
// 40
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
  
  public DuplicateMessageActionListener_cl () throws Exception { super (); }
  
}


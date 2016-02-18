package JP.go.ipa.oz.user.ide;

public class SetEditorActionListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.SetEditorActionListener_if {
  JP.go.ipa.oz.user.ide.SetEditorDialog_if editorDlg;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.SetEditorDialog_if s, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception  {
// 26
    super._new_newActionListener (q);
// 27
    editorDlg = s;
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if event) throws Exception  {
    checkSecureInvocation ();
// 39
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$433;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) event)) {
      try {
        getActionCommand$val$433 = event.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$433 = event.getActionCommand ();
    }
// 39
    JP.go.ipa.oz.lib.standard._String_if string$98 = (new JP.go.ipa.oz.lib.standard._String_cl("Set"));
    
// 39
    int compareTo$val$434;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getActionCommand$val$433)) {
      try {
        compareTo$val$434 = getActionCommand$val$433.compareTo (string$98);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compareTo$val$434 = getActionCommand$val$433.compareTo (string$98);
    }
// 39
    if (compareTo$val$434 == 0) {{
// 40
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) editorDlg)) {
          try {
            editorDlg.setEditor ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          editorDlg.setEditor ();
        }
// 41
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) editorDlg)) {
          try {
            editorDlg.dispose ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          editorDlg.dispose ();
        }
// 42
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) editorDlg)) {
          try {
            editorDlg.setVisible (false);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          editorDlg.setVisible (false);
        }
      }
    } else {{
// 44
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) editorDlg)) {
          try {
            editorDlg.dispose ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          editorDlg.dispose ();
        }
// 45
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) editorDlg)) {
          try {
            editorDlg.setVisible (false);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          editorDlg.setVisible (false);
        }
      }
    }
  }
  
  public SetEditorActionListener_cl () throws Exception { super (); }
  
}


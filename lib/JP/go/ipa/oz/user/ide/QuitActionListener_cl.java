package JP.go.ipa.oz.user.ide;

public class QuitActionListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.QuitActionListener_if {
  JP.go.ipa.oz.user.ide.QuitDialog_if quit;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.QuitDialog_if dlg, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception  {
// 26
    super._new_newActionListener (q);
// 27
    quit = dlg;
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if event) throws Exception  {
    checkSecureInvocation ();
// 39
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$424;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) event)) {
      try {
        getActionCommand$val$424 = event.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$424 = event.getActionCommand ();
    }
// 39
    JP.go.ipa.oz.lib.standard._String_if string$97 = (new JP.go.ipa.oz.lib.standard._String_cl("OK"));
    
// 39
    int compareTo$val$425;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getActionCommand$val$424)) {
      try {
        compareTo$val$425 = getActionCommand$val$424.compareTo (string$97);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compareTo$val$425 = getActionCommand$val$424.compareTo (string$97);
    }
// 39
    if (compareTo$val$425 == 0) {{
// 40
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) quit)) {
          try {
            quit.dispose ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          quit.dispose ();
        }
// 41
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) quit)) {
          try {
            quit.setVisible (false);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          quit.setVisible (false);
        }
// 42
        stopCell ();
      }
    } else {{
// 46
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) quit)) {
          try {
            quit.dispose ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          quit.dispose ();
        }
// 47
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) quit)) {
          try {
            quit.setVisible (false);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          quit.setVisible (false);
        }
      }
    }
  }
  
  public QuitActionListener_cl () throws Exception { super (); }
  
}


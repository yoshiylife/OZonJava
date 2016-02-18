package JP.go.ipa.oz.user.ide;

public class AddFileActionListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.AddFileActionListener_if {
  JP.go.ipa.oz.user.ide.AddFileDialog_if dlg;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.AddFileDialog_if a, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception  {
// 26
    super._new_newActionListener (q);
// 27
    dlg = a;
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if event) throws Exception  {
    checkSecureInvocation ();
// 39
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$13;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) event)) {
      try {
        getActionCommand$val$13 = event.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$13 = event.getActionCommand ();
    }
// 39
    JP.go.ipa.oz.lib.standard._String_if string$0 = (new JP.go.ipa.oz.lib.standard._String_cl("set dir"));
    
// 39
    int compareTo$val$14;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getActionCommand$val$13)) {
      try {
        compareTo$val$14 = getActionCommand$val$13.compareTo (string$0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compareTo$val$14 = getActionCommand$val$13.compareTo (string$0);
    }
// 39
    if (compareTo$val$14 == 0) {{
// 40
        JP.go.ipa.oz.lib.standard._Array_if getFilesInDirectory$val$15;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
          try {
            getFilesInDirectory$val$15 = dlg.getFilesInDirectory ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getFilesInDirectory$val$15 = dlg.getFilesInDirectory ();
        }
// 40
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
          try {
            dlg.setFiles (getFilesInDirectory$val$15);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          dlg.setFiles (getFilesInDirectory$val$15);
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
    } else {
// 44
      JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$16;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) event)) {
        try {
          getActionCommand$val$16 = event.getActionCommand ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getActionCommand$val$16 = event.getActionCommand ();
      }
// 44
      JP.go.ipa.oz.lib.standard._String_if string$1 = (new JP.go.ipa.oz.lib.standard._String_cl("Cancel"));
      
// 44
      int compareTo$val$17;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getActionCommand$val$16)) {
        try {
          compareTo$val$17 = getActionCommand$val$16.compareTo (string$1);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        compareTo$val$17 = getActionCommand$val$16.compareTo (string$1);
      }
// 44
      if (compareTo$val$17 == 0) {{
// 45
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
            try {
              dlg.setFiles (null);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            dlg.setFiles (null);
          }
// 46
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
            try {
              dlg.dispose ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            dlg.dispose ();
          }
// 47
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
// 50
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
            try {
              dlg.setNextDirectory ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            dlg.setNextDirectory ();
          }
        }
      }
    }
  }
  
  public AddFileActionListener_cl () throws Exception { super (); }
  
}


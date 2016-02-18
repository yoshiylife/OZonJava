package JP.go.ipa.oz.user.ide;

public class CompileInfoActionListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.CompileInfoActionListener_if {
  JP.go.ipa.oz.user.ide.CompileInfoDialog_if info;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.CompileInfoDialog_if i, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception  {
// 26
    super._new_newActionListener (q);
// 27
    info = i;
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if event) throws Exception  {
    checkSecureInvocation ();
// 39
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$243;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) event)) {
      try {
        getActionCommand$val$243 = event.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$243 = event.getActionCommand ();
    }
// 39
    JP.go.ipa.oz.lib.standard._String_if string$77 = (new JP.go.ipa.oz.lib.standard._String_cl("OK"));
    
// 39
    int compareTo$val$244;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getActionCommand$val$243)) {
      try {
        compareTo$val$244 = getActionCommand$val$243.compareTo (string$77);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compareTo$val$244 = getActionCommand$val$243.compareTo (string$77);
    }
// 39
    if (compareTo$val$244 == 0) {{
// 40
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) info)) {
          try {
            info.dispose ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          info.dispose ();
        }
// 41
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) info)) {
          try {
            info.setVisible (false);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          info.setVisible (false);
        }
      }
    }
  }
  
  public CompileInfoActionListener_cl () throws Exception { super (); }
  
}


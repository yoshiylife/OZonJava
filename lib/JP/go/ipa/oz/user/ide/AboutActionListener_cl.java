package JP.go.ipa.oz.user.ide;

public class AboutActionListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.AboutActionListener_if {
  JP.go.ipa.oz.user.ide.AboutDialog_if about;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.AboutDialog_if a, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception  {
// 26
    super._new_newActionListener (q);
// 27
    about = a;
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if event) throws Exception  {
    checkSecureInvocation ();
// 39
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$452;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) event)) {
      try {
        getActionCommand$val$452 = event.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$452 = event.getActionCommand ();
    }
// 39
    JP.go.ipa.oz.lib.standard._String_if string$100 = (new JP.go.ipa.oz.lib.standard._String_cl("OK"));
    
// 39
    int compareTo$val$453;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getActionCommand$val$452)) {
      try {
        compareTo$val$453 = getActionCommand$val$452.compareTo (string$100);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compareTo$val$453 = getActionCommand$val$452.compareTo (string$100);
    }
// 39
    if (compareTo$val$453 == 0) {{
// 40
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) about)) {
          try {
            about.dispose ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          about.dispose ();
        }
// 41
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) about)) {
          try {
            about.setVisible (false);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          about.setVisible (false);
        }
      }
    }
  }
  
  public AboutActionListener_cl () throws Exception { super (); }
  
}


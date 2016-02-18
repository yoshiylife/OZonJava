package JP.go.ipa.oz.user.ide;

public class IDGenItemListener_cl extends JP.go.ipa.oz.lib.standard._ItemListener_cl implements JP.go.ipa.oz.user.ide.IDGenItemListener_if {
  JP.go.ipa.oz.user.ide.IDGenDialog_if dlg;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.IDGenDialog_if i, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception  {
// 26
    super._new_newItemListener (q);
// 27
    dlg = i;
    return this;
  }
  
  public void itemStateChanged (JP.go.ipa.oz.lib.standard._ItemEvent_if event) throws Exception  {
    checkSecureInvocation ();
// 39
    JP.go.ipa.oz.lib.standard._Checkbox_if getRbtnSubject$val$844;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
      try {
        getRbtnSubject$val$844 = dlg.getRbtnSubject ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getRbtnSubject$val$844 = dlg.getRbtnSubject ();
    }
// 39
    boolean getState$val$845;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getRbtnSubject$val$844)) {
      try {
        getState$val$845 = getRbtnSubject$val$844.getState ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getState$val$845 = getRbtnSubject$val$844.getState ();
    }
// 39
    if (getState$val$845) {{
// 40
        JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$846;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
          try {
            getChoSubject$val$846 = dlg.getChoSubject ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$846 = dlg.getChoSubject ();
        }
// 40
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$846)) {
          try {
            getChoSubject$val$846.setEnabled (true);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$846.setEnabled (true);
        }
      }
    } else {{
// 42
        JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$847;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
          try {
            getChoSubject$val$847 = dlg.getChoSubject ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$847 = dlg.getChoSubject ();
        }
// 42
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$847)) {
          try {
            getChoSubject$val$847.setEnabled (false);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$847.setEnabled (false);
        }
      }
    }
  }
  
  public IDGenItemListener_cl () throws Exception { super (); }
  
}


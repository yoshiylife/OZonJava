package JP.go.ipa.oz.user.ide;

public class LabelSelectItemListener_cl extends JP.go.ipa.oz.lib.standard._ItemListener_cl implements JP.go.ipa.oz.user.ide.LabelSelectItemListener_if {
  JP.go.ipa.oz.user.ide.LabelDeleteDialog_if dlg;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.LabelDeleteDialog_if l, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception  {
// 26
    super._new_newItemListener (q);
// 27
    dlg = l;
    return this;
  }
  
  public void itemStateChanged (JP.go.ipa.oz.lib.standard._ItemEvent_if event) throws Exception  {
    checkSecureInvocation ();
// 39
    JP.go.ipa.oz.lib.standard._Checkbox_if getRbtnSubject$val$670;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
      try {
        getRbtnSubject$val$670 = dlg.getRbtnSubject ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getRbtnSubject$val$670 = dlg.getRbtnSubject ();
    }
// 39
    boolean getState$val$671;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getRbtnSubject$val$670)) {
      try {
        getState$val$671 = getRbtnSubject$val$670.getState ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getState$val$671 = getRbtnSubject$val$670.getState ();
    }
// 39
    if (getState$val$671) {{
// 40
        JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$672;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
          try {
            getChoSubject$val$672 = dlg.getChoSubject ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$672 = dlg.getChoSubject ();
        }
// 40
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$672)) {
          try {
            getChoSubject$val$672.setEnabled (true);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$672.setEnabled (true);
        }
      }
    } else {{
// 42
        JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$673;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
          try {
            getChoSubject$val$673 = dlg.getChoSubject ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$673 = dlg.getChoSubject ();
        }
// 42
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$673)) {
          try {
            getChoSubject$val$673.setEnabled (false);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$673.setEnabled (false);
        }
      }
    }
  }
  
  public LabelSelectItemListener_cl () throws Exception { super (); }
  
}


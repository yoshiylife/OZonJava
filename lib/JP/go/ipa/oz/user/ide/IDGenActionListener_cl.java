package JP.go.ipa.oz.user.ide;

public class IDGenActionListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.IDGenActionListener_if {
  JP.go.ipa.oz.user.ide.IDGenDialog_if dlg;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.IDGenDialog_if i, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception  {
// 26
    super._new_newActionListener (q);
// 27
    dlg = i;
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if event) throws Exception  {
    checkSecureInvocation ();
// 39
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$828;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) event)) {
      try {
        getActionCommand$val$828 = event.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$828 = event.getActionCommand ();
    }
// 39
    JP.go.ipa.oz.lib.standard._String_if string$149 = (new JP.go.ipa.oz.lib.standard._String_cl("OK"));
    
// 39
    int compareTo$val$829;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getActionCommand$val$828)) {
      try {
        compareTo$val$829 = getActionCommand$val$828.compareTo (string$149);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compareTo$val$829 = getActionCommand$val$828.compareTo (string$149);
    }
// 39
    if (compareTo$val$829 == 0) {{
// 40
        JP.go.ipa.oz.lib.standard._Checkbox_if getRbtnSelected$val$830;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
          try {
            getRbtnSelected$val$830 = dlg.getRbtnSelected ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getRbtnSelected$val$830 = dlg.getRbtnSelected ();
        }
// 40
        boolean getState$val$831;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getRbtnSelected$val$830)) {
          try {
            getState$val$831 = getRbtnSelected$val$830.getState ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getState$val$831 = getRbtnSelected$val$830.getState ();
        }
// 40
        if (getState$val$831) {{
// 41
            JP.go.ipa.oz.user.ide.OzLabel_if getLabel$val$832;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
              try {
                getLabel$val$832 = dlg.getLabel ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getLabel$val$832 = dlg.getLabel ();
            }
// 41
            if (getLabel$val$832 == null) {
// 41
              return;
            }
// 42
            JP.go.ipa.oz.user.ide.OzLabel_if getLabel$val$833;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
              try {
                getLabel$val$833 = dlg.getLabel ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getLabel$val$833 = dlg.getLabel ();
            }
// 42
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
              try {
                dlg.generateID (getLabel$val$833);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              dlg.generateID (getLabel$val$833);
            }
// 44
            JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser$val$834;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
              try {
                getSchoolBrowser$val$834 = dlg.getSchoolBrowser ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getSchoolBrowser$val$834 = dlg.getSchoolBrowser ();
            }
// 44
            JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser$val$835;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
              try {
                getSchoolBrowser$val$835 = dlg.getSchoolBrowser ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getSchoolBrowser$val$835 = dlg.getSchoolBrowser ();
            }
// 44
            JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$836;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchoolBrowser$val$835)) {
              try {
                getChoSubject$val$836 = getSchoolBrowser$val$835.getChoSubject ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getChoSubject$val$836 = getSchoolBrowser$val$835.getChoSubject ();
            }
// 44
            JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$837;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$836)) {
              try {
                getSelectedItem$val$837 = getChoSubject$val$836.getSelectedItem ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getSelectedItem$val$837 = getChoSubject$val$836.getSelectedItem ();
            }
// 44
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchoolBrowser$val$834)) {
              try {
                getSchoolBrowser$val$834.setSchoolList (getSelectedItem$val$837);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getSchoolBrowser$val$834.setSchoolList (getSelectedItem$val$837);
            }
          }
        } else {{
// 46
            JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$838;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
              try {
                getChoSubject$val$838 = dlg.getChoSubject ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getChoSubject$val$838 = dlg.getChoSubject ();
            }
// 46
            JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$839;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$838)) {
              try {
                getSelectedItem$val$839 = getChoSubject$val$838.getSelectedItem ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getSelectedItem$val$839 = getChoSubject$val$838.getSelectedItem ();
            }
// 46
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
              try {
                dlg.generateID (getSelectedItem$val$839);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              dlg.generateID (getSelectedItem$val$839);
            }
// 48
            JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser$val$840;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
              try {
                getSchoolBrowser$val$840 = dlg.getSchoolBrowser ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getSchoolBrowser$val$840 = dlg.getSchoolBrowser ();
            }
// 48
            JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser$val$841;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
              try {
                getSchoolBrowser$val$841 = dlg.getSchoolBrowser ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getSchoolBrowser$val$841 = dlg.getSchoolBrowser ();
            }
// 48
            JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$842;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchoolBrowser$val$841)) {
              try {
                getChoSubject$val$842 = getSchoolBrowser$val$841.getChoSubject ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getChoSubject$val$842 = getSchoolBrowser$val$841.getChoSubject ();
            }
// 48
            JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$843;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$842)) {
              try {
                getSelectedItem$val$843 = getChoSubject$val$842.getSelectedItem ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getSelectedItem$val$843 = getChoSubject$val$842.getSelectedItem ();
            }
// 48
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchoolBrowser$val$840)) {
              try {
                getSchoolBrowser$val$840.setSchoolList (getSelectedItem$val$843);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getSchoolBrowser$val$840.setSchoolList (getSelectedItem$val$843);
            }
          }
        }
// 50
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
          try {
            dlg.dispose ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          dlg.dispose ();
        }
// 51
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
// 55
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
          try {
            dlg.dispose ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          dlg.dispose ();
        }
// 56
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
  
  public IDGenActionListener_cl () throws Exception { super (); }
  
}


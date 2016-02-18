package JP.go.ipa.oz.user.ide;

public class LabelDeleteActionListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.LabelDeleteActionListener_if {
  JP.go.ipa.oz.user.ide.LabelDeleteDialog_if dlg;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.LabelDeleteDialog_if l, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception  {
// 26
    super._new_newActionListener (q);
// 27
    dlg = l;
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if event) throws Exception  {
    checkSecureInvocation ();
// 39
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$647;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) event)) {
      try {
        getActionCommand$val$647 = event.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$647 = event.getActionCommand ();
    }
// 39
    JP.go.ipa.oz.lib.standard._String_if string$137 = (new JP.go.ipa.oz.lib.standard._String_cl("OK"));
    
// 39
    int compareTo$val$648;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getActionCommand$val$647)) {
      try {
        compareTo$val$648 = getActionCommand$val$647.compareTo (string$137);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compareTo$val$648 = getActionCommand$val$647.compareTo (string$137);
    }
// 39
    if (compareTo$val$648 == 0) {{
// 40
        JP.go.ipa.oz.lib.standard._Checkbox_if getRbtnSubject$val$649;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
          try {
            getRbtnSubject$val$649 = dlg.getRbtnSubject ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getRbtnSubject$val$649 = dlg.getRbtnSubject ();
        }
// 40
        boolean getState$val$650;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getRbtnSubject$val$649)) {
          try {
            getState$val$650 = getRbtnSubject$val$649.getState ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getState$val$650 = getRbtnSubject$val$649.getState ();
        }
// 40
        if (getState$val$650) {{
// 41
            JP.go.ipa.oz.user.ide.School_if getSchool$val$651;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
              try {
                getSchool$val$651 = dlg.getSchool ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getSchool$val$651 = dlg.getSchool ();
            }
// 41
            JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$652;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
              try {
                getChoSubject$val$652 = dlg.getChoSubject ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getChoSubject$val$652 = dlg.getChoSubject ();
            }
// 41
            JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$653;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$652)) {
              try {
                getSelectedItem$val$653 = getChoSubject$val$652.getSelectedItem ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getSelectedItem$val$653 = getChoSubject$val$652.getSelectedItem ();
            }
// 41
            JP.go.ipa.oz.user.ide.School_if removeOzLabels$val$654;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchool$val$651)) {
              try {
                removeOzLabels$val$654 = getSchool$val$651.removeOzLabels (getSelectedItem$val$653);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              removeOzLabels$val$654 = getSchool$val$651.removeOzLabels (getSelectedItem$val$653);
            }
// 43
            JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser$val$655;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
              try {
                getSchoolBrowser$val$655 = dlg.getSchoolBrowser ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getSchoolBrowser$val$655 = dlg.getSchoolBrowser ();
            }
// 43
            JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser$val$656;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
              try {
                getSchoolBrowser$val$656 = dlg.getSchoolBrowser ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getSchoolBrowser$val$656 = dlg.getSchoolBrowser ();
            }
// 43
            JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$657;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchoolBrowser$val$656)) {
              try {
                getChoSubject$val$657 = getSchoolBrowser$val$656.getChoSubject ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getChoSubject$val$657 = getSchoolBrowser$val$656.getChoSubject ();
            }
// 43
            JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$658;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$657)) {
              try {
                getSelectedItem$val$658 = getChoSubject$val$657.getSelectedItem ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getSelectedItem$val$658 = getChoSubject$val$657.getSelectedItem ();
            }
// 43
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchoolBrowser$val$655)) {
              try {
                getSchoolBrowser$val$655.setSchoolList (getSelectedItem$val$658);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getSchoolBrowser$val$655.setSchoolList (getSelectedItem$val$658);
            }
          }
        } else {{
// 45
            JP.go.ipa.oz.lib.standard._String_if getLabelName$val$659;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
              try {
                getLabelName$val$659 = dlg.getLabelName ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getLabelName$val$659 = dlg.getLabelName ();
            }
// 45
            if (getLabelName$val$659 == null) {
// 45
              return;
            }
// 46
            JP.go.ipa.oz.user.ide.School_if getSchool$val$660;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
              try {
                getSchool$val$660 = dlg.getSchool ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getSchool$val$660 = dlg.getSchool ();
            }
// 46
            JP.go.ipa.oz.lib.standard._String_if getLabelName$val$661;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
              try {
                getLabelName$val$661 = dlg.getLabelName ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getLabelName$val$661 = dlg.getLabelName ();
            }
// 46
            JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser$val$662;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
              try {
                getSchoolBrowser$val$662 = dlg.getSchoolBrowser ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getSchoolBrowser$val$662 = dlg.getSchoolBrowser ();
            }
// 46
            JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$663;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchoolBrowser$val$662)) {
              try {
                getChoSubject$val$663 = getSchoolBrowser$val$662.getChoSubject ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getChoSubject$val$663 = getSchoolBrowser$val$662.getChoSubject ();
            }
// 46
            JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$664;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$663)) {
              try {
                getSelectedItem$val$664 = getChoSubject$val$663.getSelectedItem ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getSelectedItem$val$664 = getChoSubject$val$663.getSelectedItem ();
            }
// 46
            JP.go.ipa.oz.user.ide.School_if removeOzLabel$val$665;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchool$val$660)) {
              try {
                removeOzLabel$val$665 = getSchool$val$660.removeOzLabel (getLabelName$val$661, getSelectedItem$val$664);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              removeOzLabel$val$665 = getSchool$val$660.removeOzLabel (getLabelName$val$661, getSelectedItem$val$664);
            }
// 48
            JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser$val$666;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
              try {
                getSchoolBrowser$val$666 = dlg.getSchoolBrowser ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getSchoolBrowser$val$666 = dlg.getSchoolBrowser ();
            }
// 48
            JP.go.ipa.oz.user.ide.SchoolBrowser_if getSchoolBrowser$val$667;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlg)) {
              try {
                getSchoolBrowser$val$667 = dlg.getSchoolBrowser ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getSchoolBrowser$val$667 = dlg.getSchoolBrowser ();
            }
// 48
            JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$668;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchoolBrowser$val$667)) {
              try {
                getChoSubject$val$668 = getSchoolBrowser$val$667.getChoSubject ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getChoSubject$val$668 = getSchoolBrowser$val$667.getChoSubject ();
            }
// 48
            JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$669;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$668)) {
              try {
                getSelectedItem$val$669 = getChoSubject$val$668.getSelectedItem ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getSelectedItem$val$669 = getChoSubject$val$668.getSelectedItem ();
            }
// 48
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchoolBrowser$val$666)) {
              try {
                getSchoolBrowser$val$666.setSchoolList (getSelectedItem$val$669);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getSchoolBrowser$val$666.setSchoolList (getSelectedItem$val$669);
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
  
  public LabelDeleteActionListener_cl () throws Exception { super (); }
  
}


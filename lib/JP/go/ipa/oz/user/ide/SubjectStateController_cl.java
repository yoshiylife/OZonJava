package JP.go.ipa.oz.user.ide;

public class SubjectStateController_cl extends JP.go.ipa.oz.lib.standard._ItemListener_cl implements JP.go.ipa.oz.user.ide.SubjectStateController_if {
  JP.go.ipa.oz.user.ide.SchoolBrowser_if sb;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.SchoolBrowser_if s, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception  {
// 26
    super._new_newItemListener (q);
// 27
    sb = s;
    return this;
  }
  
  public void itemStateChanged (JP.go.ipa.oz.lib.standard._ItemEvent_if event) throws Exception  {
    checkSecureInvocation ();
// 39
    JP.go.ipa.oz.lib.standard._Checkbox_if getRbtnRelease$val$1115;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sb)) {
      try {
        getRbtnRelease$val$1115 = sb.getRbtnRelease ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getRbtnRelease$val$1115 = sb.getRbtnRelease ();
    }
// 39
    boolean getState$val$1116;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getRbtnRelease$val$1115)) {
      try {
        getState$val$1116 = getRbtnRelease$val$1115.getState ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getState$val$1116 = getRbtnRelease$val$1115.getState ();
    }
// 39
    if (getState$val$1116) {{
// 40
        JP.go.ipa.oz.user.ide.School_if getSchool$val$1117;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sb)) {
          try {
            getSchool$val$1117 = sb.getSchool ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSchool$val$1117 = sb.getSchool ();
        }
// 40
        JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$1118;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sb)) {
          try {
            getChoSubject$val$1118 = sb.getChoSubject ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$1118 = sb.getChoSubject ();
        }
// 40
        JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$1119;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$1118)) {
          try {
            getSelectedItem$val$1119 = getChoSubject$val$1118.getSelectedItem ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSelectedItem$val$1119 = getChoSubject$val$1118.getSelectedItem ();
        }
// 40
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchool$val$1117)) {
          try {
            getSchool$val$1117.toReleasState (getSelectedItem$val$1119);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSchool$val$1117.toReleasState (getSelectedItem$val$1119);
        }
// 41
        JP.go.ipa.oz.lib.standard._MenuItem_if getMenuItemSubjectExportIF$val$1120;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sb)) {
          try {
            getMenuItemSubjectExportIF$val$1120 = sb.getMenuItemSubjectExportIF ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getMenuItemSubjectExportIF$val$1120 = sb.getMenuItemSubjectExportIF ();
        }
// 41
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getMenuItemSubjectExportIF$val$1120)) {
          try {
            getMenuItemSubjectExportIF$val$1120.setEnabled (true);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getMenuItemSubjectExportIF$val$1120.setEnabled (true);
        }
// 42
        JP.go.ipa.oz.lib.standard._MenuItem_if getMenuItemSubjectExportCL$val$1121;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sb)) {
          try {
            getMenuItemSubjectExportCL$val$1121 = sb.getMenuItemSubjectExportCL ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getMenuItemSubjectExportCL$val$1121 = sb.getMenuItemSubjectExportCL ();
        }
// 42
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getMenuItemSubjectExportCL$val$1121)) {
          try {
            getMenuItemSubjectExportCL$val$1121.setEnabled (true);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getMenuItemSubjectExportCL$val$1121.setEnabled (true);
        }
// 43
        JP.go.ipa.oz.lib.standard._MenuItem_if getMenuItemAppResister$val$1122;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sb)) {
          try {
            getMenuItemAppResister$val$1122 = sb.getMenuItemAppResister ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getMenuItemAppResister$val$1122 = sb.getMenuItemAppResister ();
        }
// 43
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getMenuItemAppResister$val$1122)) {
          try {
            getMenuItemAppResister$val$1122.setEnabled (true);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getMenuItemAppResister$val$1122.setEnabled (true);
        }
      }
    } else {{
// 45
        JP.go.ipa.oz.user.ide.School_if getSchool$val$1123;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sb)) {
          try {
            getSchool$val$1123 = sb.getSchool ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSchool$val$1123 = sb.getSchool ();
        }
// 45
        JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$1124;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sb)) {
          try {
            getChoSubject$val$1124 = sb.getChoSubject ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$1124 = sb.getChoSubject ();
        }
// 45
        JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$1125;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$1124)) {
          try {
            getSelectedItem$val$1125 = getChoSubject$val$1124.getSelectedItem ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSelectedItem$val$1125 = getChoSubject$val$1124.getSelectedItem ();
        }
// 45
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchool$val$1123)) {
          try {
            getSchool$val$1123.toDevelopState (getSelectedItem$val$1125);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSchool$val$1123.toDevelopState (getSelectedItem$val$1125);
        }
// 46
        JP.go.ipa.oz.lib.standard._MenuItem_if getMenuItemSubjectExportIF$val$1126;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sb)) {
          try {
            getMenuItemSubjectExportIF$val$1126 = sb.getMenuItemSubjectExportIF ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getMenuItemSubjectExportIF$val$1126 = sb.getMenuItemSubjectExportIF ();
        }
// 46
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getMenuItemSubjectExportIF$val$1126)) {
          try {
            getMenuItemSubjectExportIF$val$1126.setEnabled (false);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getMenuItemSubjectExportIF$val$1126.setEnabled (false);
        }
// 47
        JP.go.ipa.oz.lib.standard._MenuItem_if getMenuItemSubjectExportCL$val$1127;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sb)) {
          try {
            getMenuItemSubjectExportCL$val$1127 = sb.getMenuItemSubjectExportCL ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getMenuItemSubjectExportCL$val$1127 = sb.getMenuItemSubjectExportCL ();
        }
// 47
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getMenuItemSubjectExportCL$val$1127)) {
          try {
            getMenuItemSubjectExportCL$val$1127.setEnabled (false);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getMenuItemSubjectExportCL$val$1127.setEnabled (false);
        }
// 48
        JP.go.ipa.oz.lib.standard._MenuItem_if getMenuItemAppResister$val$1128;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sb)) {
          try {
            getMenuItemAppResister$val$1128 = sb.getMenuItemAppResister ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getMenuItemAppResister$val$1128 = sb.getMenuItemAppResister ();
        }
// 48
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getMenuItemAppResister$val$1128)) {
          try {
            getMenuItemAppResister$val$1128.setEnabled (false);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getMenuItemAppResister$val$1128.setEnabled (false);
        }
      }
    }
  }
  
  public SubjectStateController_cl () throws Exception { super (); }
  
}


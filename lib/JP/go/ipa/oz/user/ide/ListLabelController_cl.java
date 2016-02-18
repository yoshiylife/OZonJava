package JP.go.ipa.oz.user.ide;

public class ListLabelController_cl extends JP.go.ipa.oz.lib.standard._ItemListener_cl implements JP.go.ipa.oz.user.ide.ListLabelController_if {
  JP.go.ipa.oz.user.ide.SchoolBrowser_if sbr;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.SchoolBrowser_if s, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception  {
// 26
    super._new_newItemListener (q);
// 27
    sbr = s;
    return this;
  }
  
  public void itemStateChanged (JP.go.ipa.oz.lib.standard._ItemEvent_if event) throws Exception  {
    checkSecureInvocation ();
// 39
    JP.go.ipa.oz.lib.standard._String_if labelName = null;
// 40
    JP.go.ipa.oz.lib.standard._List_if getLstLabel$val$1103;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
      try {
        getLstLabel$val$1103 = sbr.getLstLabel ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getLstLabel$val$1103 = sbr.getLstLabel ();
    }
// 40
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$1104;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getLstLabel$val$1103)) {
      try {
        getSelectedItem$val$1104 = getLstLabel$val$1103.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$1104 = getLstLabel$val$1103.getSelectedItem ();
    }
// 40
    labelName = getSelectedItem$val$1104;
// 41
    JP.go.ipa.oz.lib.standard._TextField_if getTxtIfID$val$1105;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
      try {
        getTxtIfID$val$1105 = sbr.getTxtIfID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getTxtIfID$val$1105 = sbr.getTxtIfID ();
    }
// 41
    JP.go.ipa.oz.user.ide.School_if getSchool$val$1106;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
      try {
        getSchool$val$1106 = sbr.getSchool ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchool$val$1106 = sbr.getSchool ();
    }
// 41
    JP.go.ipa.oz.user.ide.OzLabel_if getOzLabel$val$1107;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchool$val$1106)) {
      try {
        getOzLabel$val$1107 = getSchool$val$1106.getOzLabel (labelName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabel$val$1107 = getSchool$val$1106.getOzLabel (labelName);
    }
// 41
    JP.go.ipa.oz.lib.standard._String_if getInterfaceID$val$1108;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getOzLabel$val$1107)) {
      try {
        getInterfaceID$val$1108 = getOzLabel$val$1107.getInterfaceID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getInterfaceID$val$1108 = getOzLabel$val$1107.getInterfaceID ();
    }
// 41
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getTxtIfID$val$1105)) {
      try {
        getTxtIfID$val$1105.setText (getInterfaceID$val$1108);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getTxtIfID$val$1105.setText (getInterfaceID$val$1108);
    }
// 42
    JP.go.ipa.oz.lib.standard._TextField_if getTxtImplID$val$1109;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
      try {
        getTxtImplID$val$1109 = sbr.getTxtImplID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getTxtImplID$val$1109 = sbr.getTxtImplID ();
    }
// 42
    JP.go.ipa.oz.user.ide.School_if getSchool$val$1110;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
      try {
        getSchool$val$1110 = sbr.getSchool ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchool$val$1110 = sbr.getSchool ();
    }
// 42
    JP.go.ipa.oz.user.ide.OzLabel_if getOzLabel$val$1111;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchool$val$1110)) {
      try {
        getOzLabel$val$1111 = getSchool$val$1110.getOzLabel (labelName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabel$val$1111 = getSchool$val$1110.getOzLabel (labelName);
    }
// 42
    JP.go.ipa.oz.lib.standard._String_if getImplementationID$val$1112;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getOzLabel$val$1111)) {
      try {
        getImplementationID$val$1112 = getOzLabel$val$1111.getImplementationID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getImplementationID$val$1112 = getOzLabel$val$1111.getImplementationID ();
    }
// 42
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getTxtImplID$val$1109)) {
      try {
        getTxtImplID$val$1109.setText (getImplementationID$val$1112);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getTxtImplID$val$1109.setText (getImplementationID$val$1112);
    }
  }
  
  public ListLabelController_cl () throws Exception { super (); }
  
}


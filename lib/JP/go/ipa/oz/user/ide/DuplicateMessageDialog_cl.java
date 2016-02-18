package JP.go.ipa.oz.user.ide;

public class DuplicateMessageDialog_cl extends JP.go.ipa.oz.lib.standard._Dialog_cl implements JP.go.ipa.oz.user.ide.DuplicateMessageDialog_if {
  JP.go.ipa.oz.lib.standard._Label_if lblDuplicate;
  JP.go.ipa.oz.user.ide.School_if school;
  JP.go.ipa.oz.user.ide.SchoolBrowser_if schoolBrowser;
  JP.go.ipa.oz.lib.standard._Button_if btnOK;
  JP.go.ipa.oz.user.ide.DuplicateMessageActionListener_if deleteAL;
  JP.go.ipa.oz.lib.standard._List_if lstDuplicate;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Frame_if parent, boolean modal, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if queue) throws Exception  {
// 32
    super._new_newDialog (parent, modal);
// 34
    schoolBrowser = (JP.go.ipa.oz.user.ide.SchoolBrowser_if) (parent);
// 35
    JP.go.ipa.oz.user.ide.School_if getSchool$val$1300;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
      try {
        getSchool$val$1300 = schoolBrowser.getSchool ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchool$val$1300 = schoolBrowser.getSchool ();
    }
// 35
    school = getSchool$val$1300;
// 38
    JP.go.ipa.oz.lib.standard._BorderLayout_if grid1 = (JP.go.ipa.oz.lib.standard._BorderLayout_cl) (new JP.go.ipa.oz.lib.standard._BorderLayout_cl ())._new_newBorderLayout ();
// 39
    setLayout (grid1);
// 40
    addNotify ();
// 41
    setSize (300, 300);
// 42
    JP.go.ipa.oz.lib.standard._Font_if font = (JP.go.ipa.oz.lib.standard._Font_cl) (new JP.go.ipa.oz.lib.standard._Font_cl ())._new_newFont ((new JP.go.ipa.oz.lib.standard._String_cl("TimesRoman")), 12);
// 43
    lblDuplicate = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("   List of Duplicate Labels. Please modify them.")));
// 44
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblDuplicate)) {
      try {
        lblDuplicate.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lblDuplicate.setFont (font);
    }
// 45
    add ((new JP.go.ipa.oz.lib.standard._String_cl("North")), lblDuplicate);
// 46
    lstDuplicate = (JP.go.ipa.oz.lib.standard._List_cl) (new JP.go.ipa.oz.lib.standard._List_cl ())._new_newList (10);
// 48
    JP.go.ipa.oz.lib.standard._String_if lblName = null, dupLblName = null;
// 49
    JP.go.ipa.oz.lib.standard._StringBuffer_if tmp = null;
// 50
    JP.go.ipa.oz.lib.standard._Dictionary_if getDuplicates$val$1301;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        getDuplicates$val$1301 = school.getDuplicates ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getDuplicates$val$1301 = school.getDuplicates ();
    }
// 50
    JP.go.ipa.oz.lib.standard._Set_if keys$val$1302;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getDuplicates$val$1301)) {
      try {
        keys$val$1302 = getDuplicates$val$1301.keys ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      keys$val$1302 = getDuplicates$val$1301.keys ();
    }
// 50
    JP.go.ipa.oz.lib.standard._Set_if tmpSet = keys$val$1302;
// 51
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$1303;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpSet)) {
      try {
        iterator$val$1303 = tmpSet.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$1303 = tmpSet.iterator ();
    }
// 51
    JP.go.ipa.oz.lib.standard._Iterator_if tmpIterator = iterator$val$1303;
// 52
    while (true) {
// 52
      boolean hasMoreElements$val$1304;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpIterator)) {
        try {
          hasMoreElements$val$1304 = tmpIterator.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$1304 = tmpIterator.hasMoreElements ();
      }
      if (!(hasMoreElements$val$1304)) break;
      
      /* body */ _loop_1: {
// 53
        JP.go.ipa.oz.lang._Root_if nextElement$val$1305;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmpIterator)) {
          try {
            nextElement$val$1305 = tmpIterator.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$1305 = tmpIterator.nextElement ();
        }
// 53
        lblName = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$1305);
// 54
        JP.go.ipa.oz.lib.standard._Dictionary_if getDuplicates$val$1306;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
          try {
            getDuplicates$val$1306 = school.getDuplicates ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getDuplicates$val$1306 = school.getDuplicates ();
        }
// 54
        JP.go.ipa.oz.lang._Root_if get$val$1307;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getDuplicates$val$1306)) {
          try {
            get$val$1307 = getDuplicates$val$1306.get (lblName);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          get$val$1307 = getDuplicates$val$1306.get (lblName);
        }
// 54
        dupLblName = (JP.go.ipa.oz.lib.standard._String_if) (get$val$1307);
// 55
        tmp = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (lblName);
// 56
        tmp.append ((new JP.go.ipa.oz.lib.standard._String_cl(", ")));
// 57
        tmp.append (dupLblName);
// 58
        JP.go.ipa.oz.lib.standard._String_if asString$val$1308;
        asString$val$1308 = tmp.asString ();
// 58
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstDuplicate)) {
          try {
            lstDuplicate.addItem (asString$val$1308);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          lstDuplicate.addItem (asString$val$1308);
        }
      }
    }
// 60
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lstDuplicate)) {
      try {
        lstDuplicate.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lstDuplicate.setFont (font);
    }
// 61
    add ((new JP.go.ipa.oz.lib.standard._String_cl("Center")), lstDuplicate);
// 63
    JP.go.ipa.oz.lib.standard._FlowLayout_if flow = (JP.go.ipa.oz.lib.standard._FlowLayout_cl) (new JP.go.ipa.oz.lib.standard._FlowLayout_cl ())._new_newFlowLayout (1, 40, 3);
// 64
    JP.go.ipa.oz.lib.standard._Panel_if panel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (flow);
// 65
    add ((new JP.go.ipa.oz.lib.standard._String_cl("South")), panel);
// 66
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel)) {
      try {
        panel.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel.addNotify ();
    }
// 67
    btnOK = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("OK")));
// 68
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.setFont (font);
    }
// 69
    JP.go.ipa.oz.lib.standard._Component_if add$val$1309;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel)) {
      try {
        add$val$1309 = panel.add (btnOK);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$1309 = panel.add (btnOK);
    }
// 71
    setTitle ((new JP.go.ipa.oz.lib.standard._String_cl("DUPLICATE LABEL DIALOG")));
// 74
    deleteAL = (JP.go.ipa.oz.user.ide.DuplicateMessageActionListener_cl) (new JP.go.ipa.oz.user.ide.DuplicateMessageActionListener_cl ())._new_create (this, queue);
// 75
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.addActionListener (deleteAL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.addActionListener (deleteAL);
    }
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._Button_if getBtnOK () throws Exception  {
    checkSecureInvocation ();
// 101
    return btnOK;
  }
  
  public void setVisible (boolean b) throws Exception  {
    checkSecureInvocation ();
// 87
    JP.go.ipa.oz.lib.standard._Container_if getParent$val$1310;
    getParent$val$1310 = getParent ();
// 87
    JP.go.ipa.oz.lib.standard._Rectangle_if getBounds$val$1311;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getParent$val$1310)) {
      try {
        getBounds$val$1311 = getParent$val$1310.getBounds ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBounds$val$1311 = getParent$val$1310.getBounds ();
    }
// 87
    JP.go.ipa.oz.lib.standard._Rectangle_if bounds = getBounds$val$1311;
// 88
    JP.go.ipa.oz.lib.standard._Rectangle_if abounds = getBounds ();
// 89
    int getX$val$1312;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getX$val$1312 = bounds.getX ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getX$val$1312 = bounds.getX ();
    }
// 89
    int getWidth$val$1313;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getWidth$val$1313 = bounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$1313 = bounds.getWidth ();
    }
// 89
    int getWidth$val$1314;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getWidth$val$1314 = abounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$1314 = abounds.getWidth ();
    }
// 90
    int getY$val$1315;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getY$val$1315 = bounds.getY ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getY$val$1315 = bounds.getY ();
    }
// 90
    int getHeight$val$1316;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getHeight$val$1316 = bounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$1316 = bounds.getHeight ();
    }
// 90
    int getHeight$val$1317;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getHeight$val$1317 = abounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$1317 = abounds.getHeight ();
    }
// 89
    setLocation (getX$val$1312 + (getWidth$val$1313 - getWidth$val$1314) / 2, getY$val$1315 + (getHeight$val$1316 - getHeight$val$1317) / 2);
// 92
    super.setVisible (b);
  }
  
  public DuplicateMessageDialog_cl () throws Exception { super (); }
  
}


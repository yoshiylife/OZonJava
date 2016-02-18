package JP.go.ipa.oz.user.ide;

public class AboutDialog_cl extends JP.go.ipa.oz.lib.standard._Dialog_cl implements JP.go.ipa.oz.user.ide.AboutDialog_if {
  JP.go.ipa.oz.lib.standard._Button_if btnOK;
  JP.go.ipa.oz.lib.standard._Label_if lblVersion;
  JP.go.ipa.oz.user.ide.AboutActionListener_if aal;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Frame_if parent, boolean modal, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if queue, JP.go.ipa.oz.lib.standard._String_if msg, JP.go.ipa.oz.lib.standard._String_if title) throws Exception  {
// 62
    super._new_newDialog (parent, modal);
// 65
    JP.go.ipa.oz.lib.standard._BorderLayout_if border = (JP.go.ipa.oz.lib.standard._BorderLayout_cl) (new JP.go.ipa.oz.lib.standard._BorderLayout_cl ())._new_newBorderLayout ();
// 66
    setLayout (border);
// 67
    addNotify ();
// 68
    setSize (300, 100);
// 69
    JP.go.ipa.oz.lib.standard._Font_if font = (JP.go.ipa.oz.lib.standard._Font_cl) (new JP.go.ipa.oz.lib.standard._Font_cl ())._new_newFont ((new JP.go.ipa.oz.lib.standard._String_cl("TimesRoman")), 12);
// 70
    JP.go.ipa.oz.lib.standard._FlowLayout_if flow1 = (JP.go.ipa.oz.lib.standard._FlowLayout_cl) (new JP.go.ipa.oz.lib.standard._FlowLayout_cl ())._new_newFlowLayout ();
// 71
    JP.go.ipa.oz.lib.standard._Panel_if panel1 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (flow1);
// 72
    add ((new JP.go.ipa.oz.lib.standard._String_cl("Center")), panel1);
// 73
    lblVersion = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel (msg);
// 74
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblVersion)) {
      try {
        lblVersion.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lblVersion.setFont (font);
    }
// 75
    JP.go.ipa.oz.lib.standard._Component_if add$val$454;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        add$val$454 = panel1.add (lblVersion);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$454 = panel1.add (lblVersion);
    }
// 77
    JP.go.ipa.oz.lib.standard._FlowLayout_if flow2 = (JP.go.ipa.oz.lib.standard._FlowLayout_cl) (new JP.go.ipa.oz.lib.standard._FlowLayout_cl ())._new_newFlowLayout ();
// 78
    JP.go.ipa.oz.lib.standard._Panel_if panel2 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (flow2);
// 79
    add ((new JP.go.ipa.oz.lib.standard._String_cl("South")), panel2);
// 80
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        panel2.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel2.addNotify ();
    }
// 81
    btnOK = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("OK")));
// 82
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.setFont (font);
    }
// 83
    JP.go.ipa.oz.lib.standard._Component_if add$val$455;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$455 = panel2.add (btnOK);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$455 = panel2.add (btnOK);
    }
// 85
    setTitle (title);
// 88
    aal = (JP.go.ipa.oz.user.ide.AboutActionListener_cl) (new JP.go.ipa.oz.user.ide.AboutActionListener_cl ())._new_create (this, queue);
// 89
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.addActionListener (aal);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.addActionListener (aal);
    }
    return this;
  }
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Frame_if parent, boolean modal, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if queue) throws Exception  {
// 29
    super._new_newDialog (parent, modal);
// 32
    JP.go.ipa.oz.lib.standard._BorderLayout_if border = (JP.go.ipa.oz.lib.standard._BorderLayout_cl) (new JP.go.ipa.oz.lib.standard._BorderLayout_cl ())._new_newBorderLayout ();
// 33
    setLayout (border);
// 34
    addNotify ();
// 35
    setSize (300, 100);
// 36
    JP.go.ipa.oz.lib.standard._Font_if font = (JP.go.ipa.oz.lib.standard._Font_cl) (new JP.go.ipa.oz.lib.standard._Font_cl ())._new_newFont ((new JP.go.ipa.oz.lib.standard._String_cl("TimesRoman")), 12);
// 37
    JP.go.ipa.oz.lib.standard._FlowLayout_if flow1 = (JP.go.ipa.oz.lib.standard._FlowLayout_cl) (new JP.go.ipa.oz.lib.standard._FlowLayout_cl ())._new_newFlowLayout ();
// 38
    JP.go.ipa.oz.lib.standard._Panel_if panel1 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (flow1);
// 39
    add ((new JP.go.ipa.oz.lib.standard._String_cl("Center")), panel1);
// 40
    lblVersion = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("OZ Development Environment Ver.1.1")));
// 41
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblVersion)) {
      try {
        lblVersion.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lblVersion.setFont (font);
    }
// 42
    JP.go.ipa.oz.lib.standard._Component_if add$val$456;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        add$val$456 = panel1.add (lblVersion);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$456 = panel1.add (lblVersion);
    }
// 44
    JP.go.ipa.oz.lib.standard._FlowLayout_if flow2 = (JP.go.ipa.oz.lib.standard._FlowLayout_cl) (new JP.go.ipa.oz.lib.standard._FlowLayout_cl ())._new_newFlowLayout ();
// 45
    JP.go.ipa.oz.lib.standard._Panel_if panel2 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (flow2);
// 46
    add ((new JP.go.ipa.oz.lib.standard._String_cl("South")), panel2);
// 47
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        panel2.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel2.addNotify ();
    }
// 48
    btnOK = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("OK")));
// 49
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.setFont (font);
    }
// 50
    JP.go.ipa.oz.lib.standard._Component_if add$val$457;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$457 = panel2.add (btnOK);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$457 = panel2.add (btnOK);
    }
// 52
    setTitle ((new JP.go.ipa.oz.lib.standard._String_cl("Version Information")));
// 55
    aal = (JP.go.ipa.oz.user.ide.AboutActionListener_cl) (new JP.go.ipa.oz.user.ide.AboutActionListener_cl ())._new_create (this, queue);
// 56
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.addActionListener (aal);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.addActionListener (aal);
    }
    return this;
  }
  
  public void setVisible (boolean b) throws Exception  {
    checkSecureInvocation ();
// 101
    JP.go.ipa.oz.lib.standard._Container_if getParent$val$458;
    getParent$val$458 = getParent ();
// 101
    JP.go.ipa.oz.lib.standard._Rectangle_if getBounds$val$459;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getParent$val$458)) {
      try {
        getBounds$val$459 = getParent$val$458.getBounds ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBounds$val$459 = getParent$val$458.getBounds ();
    }
// 101
    JP.go.ipa.oz.lib.standard._Rectangle_if bounds = getBounds$val$459;
// 102
    JP.go.ipa.oz.lib.standard._Rectangle_if abounds = getBounds ();
// 103
    int getX$val$460;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getX$val$460 = bounds.getX ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getX$val$460 = bounds.getX ();
    }
// 103
    int getWidth$val$461;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getWidth$val$461 = bounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$461 = bounds.getWidth ();
    }
// 103
    int getWidth$val$462;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getWidth$val$462 = abounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$462 = abounds.getWidth ();
    }
// 104
    int getY$val$463;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getY$val$463 = bounds.getY ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getY$val$463 = bounds.getY ();
    }
// 104
    int getHeight$val$464;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getHeight$val$464 = bounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$464 = bounds.getHeight ();
    }
// 104
    int getHeight$val$465;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getHeight$val$465 = abounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$465 = abounds.getHeight ();
    }
// 103
    setLocation (getX$val$460 + (getWidth$val$461 - getWidth$val$462) / 2, getY$val$463 + (getHeight$val$464 - getHeight$val$465) / 2);
// 105
    super.setVisible (b);
  }
  
  public AboutDialog_cl () throws Exception { super (); }
  
}


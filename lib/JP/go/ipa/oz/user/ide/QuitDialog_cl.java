package JP.go.ipa.oz.user.ide;

public class QuitDialog_cl extends JP.go.ipa.oz.lib.standard._Dialog_cl implements JP.go.ipa.oz.user.ide.QuitDialog_if {
  JP.go.ipa.oz.user.ide.QuitActionListener_if qal;
  JP.go.ipa.oz.lib.standard._Label_if lblConfirm;
  JP.go.ipa.oz.lib.standard._Button_if btnNo;
  JP.go.ipa.oz.lib.standard._Button_if btnYes;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Frame_if parent, boolean modal, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if queue) throws Exception  {
// 30
    super._new_newDialog (parent, modal);
// 34
    JP.go.ipa.oz.lib.standard._BorderLayout_if border = (JP.go.ipa.oz.lib.standard._BorderLayout_cl) (new JP.go.ipa.oz.lib.standard._BorderLayout_cl ())._new_newBorderLayout ();
// 35
    setLayout (border);
// 36
    addNotify ();
// 37
    setSize (450, 130);
// 38
    JP.go.ipa.oz.lib.standard._Font_if font = (JP.go.ipa.oz.lib.standard._Font_cl) (new JP.go.ipa.oz.lib.standard._Font_cl ())._new_newFont ((new JP.go.ipa.oz.lib.standard._String_cl("TimesRoman")), 12);
// 39
    JP.go.ipa.oz.lib.standard._FlowLayout_if flow1 = (JP.go.ipa.oz.lib.standard._FlowLayout_cl) (new JP.go.ipa.oz.lib.standard._FlowLayout_cl ())._new_newFlowLayout ();
// 40
    JP.go.ipa.oz.lib.standard._Panel_if panel1 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (flow1);
// 41
    add ((new JP.go.ipa.oz.lib.standard._String_cl("Center")), panel1);
// 42
    lblConfirm = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("Would you like to quit the OZ Development Environment?")));
// 43
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblConfirm)) {
      try {
        lblConfirm.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lblConfirm.setFont (font);
    }
// 44
    JP.go.ipa.oz.lib.standard._Component_if add$val$426;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        add$val$426 = panel1.add (lblConfirm);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$426 = panel1.add (lblConfirm);
    }
// 46
    JP.go.ipa.oz.lib.standard._FlowLayout_if flow2 = (JP.go.ipa.oz.lib.standard._FlowLayout_cl) (new JP.go.ipa.oz.lib.standard._FlowLayout_cl ())._new_newFlowLayout (1, 20, 20);
// 47
    JP.go.ipa.oz.lib.standard._Panel_if panel2 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (flow2);
// 48
    add ((new JP.go.ipa.oz.lib.standard._String_cl("South")), panel2);
// 49
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        panel2.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel2.addNotify ();
    }
// 50
    btnYes = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("OK")));
// 51
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnYes)) {
      try {
        btnYes.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnYes.setFont (font);
    }
// 52
    JP.go.ipa.oz.lib.standard._Component_if add$val$427;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$427 = panel2.add (btnYes);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$427 = panel2.add (btnYes);
    }
// 53
    btnNo = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("Cancel")));
// 54
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnNo)) {
      try {
        btnNo.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnNo.setFont (font);
    }
// 55
    JP.go.ipa.oz.lib.standard._Component_if add$val$428;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$428 = panel2.add (btnNo);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$428 = panel2.add (btnNo);
    }
// 57
    setTitle ((new JP.go.ipa.oz.lib.standard._String_cl("Quit Dialog")));
// 62
    qal = (JP.go.ipa.oz.user.ide.QuitActionListener_cl) (new JP.go.ipa.oz.user.ide.QuitActionListener_cl ())._new_create (this, queue);
// 63
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnYes)) {
      try {
        btnYes.addActionListener (qal);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnYes.addActionListener (qal);
    }
// 64
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnNo)) {
      try {
        btnNo.addActionListener (qal);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnNo.addActionListener (qal);
    }
    return this;
  }
  
  public void processWindowEvent (JP.go.ipa.oz.lib.standard._WindowEvent_if event) throws Exception  {
    checkSecureInvocation ();
// 94
    ;
  }
  
  public JP.go.ipa.oz.lib.standard._Button_if getBtnNo () throws Exception  {
    checkSecureInvocation ();
// 112
    return btnNo;
  }
  
  public JP.go.ipa.oz.lib.standard._Button_if getBtnYes () throws Exception  {
    checkSecureInvocation ();
// 103
    return btnYes;
  }
  
  public void setVisible (boolean b) throws Exception  {
    checkSecureInvocation ();
// 76
    JP.go.ipa.oz.lib.standard._Container_if getParent$val$429;
    getParent$val$429 = getParent ();
// 76
    JP.go.ipa.oz.lib.standard._Rectangle_if getBounds$val$430;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getParent$val$429)) {
      try {
        getBounds$val$430 = getParent$val$429.getBounds ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBounds$val$430 = getParent$val$429.getBounds ();
    }
// 76
    JP.go.ipa.oz.lib.standard._Rectangle_if bounds = getBounds$val$430;
// 77
    int getX$val$431;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getX$val$431 = bounds.getX ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getX$val$431 = bounds.getX ();
    }
// 77
    int getY$val$432;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getY$val$432 = bounds.getY ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getY$val$432 = bounds.getY ();
    }
// 77
    setLocation (getX$val$431 + 50, getY$val$432 + 50);
// 78
    super.setVisible (b);
  }
  
  public QuitDialog_cl () throws Exception { super (); }
  
}


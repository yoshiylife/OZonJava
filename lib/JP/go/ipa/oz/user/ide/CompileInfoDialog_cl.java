package JP.go.ipa.oz.user.ide;

public class CompileInfoDialog_cl extends JP.go.ipa.oz.lib.standard._Dialog_cl implements JP.go.ipa.oz.user.ide.CompileInfoDialog_if {
  JP.go.ipa.oz.user.ide.CompileInfoActionListener_if editCtrl;
  JP.go.ipa.oz.lib.standard._TextArea_if txtInfo;
  JP.go.ipa.oz.lib.standard._Button_if btnOK;
  
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
    setSize (500, 500);
// 36
    txtInfo = (JP.go.ipa.oz.lib.standard._TextArea_cl) (new JP.go.ipa.oz.lib.standard._TextArea_cl ())._new_newTextArea (30, 120);
// 37
    add ((new JP.go.ipa.oz.lib.standard._String_cl("Center")), txtInfo);
// 38
    btnOK = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("OK")));
// 39
    JP.go.ipa.oz.lib.standard._FlowLayout_if flow = (JP.go.ipa.oz.lib.standard._FlowLayout_cl) (new JP.go.ipa.oz.lib.standard._FlowLayout_cl ())._new_newFlowLayout ();
// 40
    JP.go.ipa.oz.lib.standard._Panel_if panel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (flow);
// 41
    add ((new JP.go.ipa.oz.lib.standard._String_cl("South")), panel);
// 42
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel)) {
      try {
        panel.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel.addNotify ();
    }
// 43
    JP.go.ipa.oz.lib.standard._Component_if add$val$245;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel)) {
      try {
        add$val$245 = panel.add (btnOK);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$245 = panel.add (btnOK);
    }
// 44
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.setEnabled (false);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.setEnabled (false);
    }
// 45
    setTitle ((new JP.go.ipa.oz.lib.standard._String_cl("Compile Information")));
// 50
    editCtrl = (JP.go.ipa.oz.user.ide.CompileInfoActionListener_cl) (new JP.go.ipa.oz.user.ide.CompileInfoActionListener_cl ())._new_create (this, queue);
// 51
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.addActionListener (editCtrl);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.addActionListener (editCtrl);
    }
    return this;
  }
  
  public void setButtonEnabled (boolean b) throws Exception  {
    checkSecureInvocation ();
// 121
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnOK)) {
      try {
        btnOK.setEnabled (b);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnOK.setEnabled (b);
    }
  }
  
  public void appendText (JP.go.ipa.oz.lib.standard._String_if appendText) throws Exception  {
    checkSecureInvocation ();
// 111
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtInfo)) {
      try {
        txtInfo.append (appendText);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      txtInfo.append (appendText);
    }
// 112
    JP.go.ipa.oz.lib.standard._String_if string$78 = (new JP.go.ipa.oz.lib.standard._String_cl("\"\n"));
    
// 112
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtInfo)) {
      try {
        txtInfo.append (string$78);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      txtInfo.append (string$78);
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getTxtInfo () throws Exception  {
    checkSecureInvocation ();
// 102
    JP.go.ipa.oz.lib.standard._String_if getText$val$246;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtInfo)) {
      try {
        getText$val$246 = txtInfo.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$246 = txtInfo.getText ();
    }
// 102
    return getText$val$246;
  }
  
  public void setTxtInfo (JP.go.ipa.oz.lib.standard._String_if tmp) throws Exception  {
    checkSecureInvocation ();
// 93
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtInfo)) {
      try {
        txtInfo.setText (tmp);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      txtInfo.setText (tmp);
    }
  }
  
  public void setVisible (boolean b) throws Exception  {
    checkSecureInvocation ();
// 63
    JP.go.ipa.oz.lib.standard._Container_if getParent$val$247;
    getParent$val$247 = getParent ();
// 63
    JP.go.ipa.oz.lib.standard._Rectangle_if getBounds$val$248;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getParent$val$247)) {
      try {
        getBounds$val$248 = getParent$val$247.getBounds ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBounds$val$248 = getParent$val$247.getBounds ();
    }
// 63
    JP.go.ipa.oz.lib.standard._Rectangle_if bounds = getBounds$val$248;
// 64
    JP.go.ipa.oz.lib.standard._Rectangle_if abounds = getBounds ();
// 65
    int getX$val$249;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getX$val$249 = bounds.getX ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getX$val$249 = bounds.getX ();
    }
// 65
    int getWidth$val$250;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getWidth$val$250 = abounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$250 = abounds.getWidth ();
    }
// 65
    int getWidth$val$251;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getWidth$val$251 = bounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$251 = bounds.getWidth ();
    }
// 66
    int getY$val$252;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getY$val$252 = bounds.getY ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getY$val$252 = bounds.getY ();
    }
// 66
    int getHeight$val$253;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getHeight$val$253 = abounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$253 = abounds.getHeight ();
    }
// 66
    int getHeight$val$254;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getHeight$val$254 = bounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$254 = bounds.getHeight ();
    }
// 65
    setLocation (getX$val$249 + (getWidth$val$250 - getWidth$val$251) / 2, getY$val$252 + (getHeight$val$253 - getHeight$val$254) / 2);
// 68
    super.setVisible (b);
  }
  
  public CompileInfoDialog_cl () throws Exception { super (); }
  
}


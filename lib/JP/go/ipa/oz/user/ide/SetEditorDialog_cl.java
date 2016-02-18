package JP.go.ipa.oz.user.ide;

public class SetEditorDialog_cl extends JP.go.ipa.oz.lib.standard._Dialog_cl implements JP.go.ipa.oz.user.ide.SetEditorDialog_if {
  JP.go.ipa.oz.lib.standard._TextField_if txtEditor;
  JP.go.ipa.oz.user.ide.ProjectManager_if projectManager;
  JP.go.ipa.oz.user.ide.SetEditorActionListener_if editorAL;
  JP.go.ipa.oz.lib.standard._Button_if btnSet;
  JP.go.ipa.oz.lib.standard._Label_if lblMessage;
  JP.go.ipa.oz.lib.standard._Button_if btnCancel;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._Frame_if parent, boolean modal, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if queue) throws Exception  {
// 32
    super._new_newDialog (parent, modal);
// 34
    projectManager = (JP.go.ipa.oz.user.ide.ProjectManager_if) (parent);
// 37
    JP.go.ipa.oz.lib.standard._GridLayout_if grid1 = (JP.go.ipa.oz.lib.standard._GridLayout_cl) (new JP.go.ipa.oz.lib.standard._GridLayout_cl ())._new_newGridLayout (3, 1, 10, 10);
// 38
    setLayout (grid1);
// 39
    addNotify ();
// 40
    setSize (280, 130);
// 41
    JP.go.ipa.oz.lib.standard._Font_if font = (JP.go.ipa.oz.lib.standard._Font_cl) (new JP.go.ipa.oz.lib.standard._Font_cl ())._new_newFont ((new JP.go.ipa.oz.lib.standard._String_cl("TimesRoman")), 12);
// 42
    lblMessage = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("   Set your editor by full path.")));
// 43
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblMessage)) {
      try {
        lblMessage.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lblMessage.setFont (font);
    }
// 44
    add (lblMessage);
// 46
    JP.go.ipa.oz.lib.standard._FlowLayout_if flow1 = (JP.go.ipa.oz.lib.standard._FlowLayout_cl) (new JP.go.ipa.oz.lib.standard._FlowLayout_cl ())._new_newFlowLayout (1, 40, 3);
// 47
    JP.go.ipa.oz.lib.standard._Panel_if panel1 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (flow1);
// 48
    add (panel1);
// 49
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        panel1.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel1.addNotify ();
    }
// 50
    JP.go.ipa.oz.lib.standard._String_if getEditor$val$435;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectManager)) {
      try {
        getEditor$val$435 = projectManager.getEditor ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getEditor$val$435 = projectManager.getEditor ();
    }
// 50
    if (getEditor$val$435 != null) {
// 51
      JP.go.ipa.oz.lib.standard._String_if getEditor$val$436;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectManager)) {
        try {
          getEditor$val$436 = projectManager.getEditor ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getEditor$val$436 = projectManager.getEditor ();
      }
// 51
      txtEditor = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField (getEditor$val$436, 30);
    } else {
// 53
      txtEditor = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField (30);
    }
// 54
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtEditor)) {
      try {
        txtEditor.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      txtEditor.setFont (font);
    }
// 55
    JP.go.ipa.oz.lib.standard._Component_if add$val$437;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel1)) {
      try {
        add$val$437 = panel1.add (txtEditor);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$437 = panel1.add (txtEditor);
    }
// 57
    JP.go.ipa.oz.lib.standard._FlowLayout_if flow2 = (JP.go.ipa.oz.lib.standard._FlowLayout_cl) (new JP.go.ipa.oz.lib.standard._FlowLayout_cl ())._new_newFlowLayout (1, 40, 3);
// 58
    JP.go.ipa.oz.lib.standard._Panel_if panel2 = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (flow2);
// 59
    add (panel2);
// 60
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        panel2.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      panel2.addNotify ();
    }
// 61
    btnSet = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("Set")));
// 62
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnSet)) {
      try {
        btnSet.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnSet.setFont (font);
    }
// 63
    JP.go.ipa.oz.lib.standard._Component_if add$val$438;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$438 = panel2.add (btnSet);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$438 = panel2.add (btnSet);
    }
// 64
    btnCancel = (JP.go.ipa.oz.lib.standard._Button_cl) (new JP.go.ipa.oz.lib.standard._Button_cl ())._new_newButton ((new JP.go.ipa.oz.lib.standard._String_cl("Cancel")));
// 65
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnCancel)) {
      try {
        btnCancel.setFont (font);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnCancel.setFont (font);
    }
// 66
    JP.go.ipa.oz.lib.standard._Component_if add$val$439;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) panel2)) {
      try {
        add$val$439 = panel2.add (btnCancel);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$439 = panel2.add (btnCancel);
    }
// 68
    setTitle ((new JP.go.ipa.oz.lib.standard._String_cl("Set Editor Dialog")));
// 73
    editorAL = (JP.go.ipa.oz.user.ide.SetEditorActionListener_cl) (new JP.go.ipa.oz.user.ide.SetEditorActionListener_cl ())._new_create (this, queue);
// 74
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnSet)) {
      try {
        btnSet.addActionListener (editorAL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnSet.addActionListener (editorAL);
    }
// 75
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) btnCancel)) {
      try {
        btnCancel.addActionListener (editorAL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      btnCancel.addActionListener (editorAL);
    }
    return this;
  }
  
  public void setEditor () throws Exception  {
    checkSecureInvocation ();
    boolean bool$val$17;
    
// 117
    JP.go.ipa.oz.lib.standard._String_if getText$val$440;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtEditor)) {
      try {
        getText$val$440 = txtEditor.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$440 = txtEditor.getText ();
    }
    bool$val$17 = getText$val$440 == null;
    if (!bool$val$17) {
// 117
      JP.go.ipa.oz.lib.standard._String_if getText$val$441;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtEditor)) {
        try {
          getText$val$441 = txtEditor.getText ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getText$val$441 = txtEditor.getText ();
      }
// 117
      JP.go.ipa.oz.lib.standard._String_if string$99 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
      
// 117
      int compareTo$val$442;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getText$val$441)) {
        try {
          compareTo$val$442 = getText$val$441.compareTo (string$99);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        compareTo$val$442 = getText$val$441.compareTo (string$99);
      }
      bool$val$17 = compareTo$val$442 == 0;
    }
// 117
    if (bool$val$17) {
// 117
      return;
    }
// 118
    JP.go.ipa.oz.lib.standard._String_if getText$val$443;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) txtEditor)) {
      try {
        getText$val$443 = txtEditor.getText ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getText$val$443 = txtEditor.getText ();
    }
// 118
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) projectManager)) {
      try {
        projectManager.setEditor (getText$val$443);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      projectManager.setEditor (getText$val$443);
    }
  }
  
  public void setVisible (boolean b) throws Exception  {
    checkSecureInvocation ();
// 87
    JP.go.ipa.oz.lib.standard._Container_if getParent$val$444;
    getParent$val$444 = getParent ();
// 87
    JP.go.ipa.oz.lib.standard._Rectangle_if getBounds$val$445;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getParent$val$444)) {
      try {
        getBounds$val$445 = getParent$val$444.getBounds ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBounds$val$445 = getParent$val$444.getBounds ();
    }
// 87
    JP.go.ipa.oz.lib.standard._Rectangle_if bounds = getBounds$val$445;
// 88
    JP.go.ipa.oz.lib.standard._Rectangle_if abounds = getBounds ();
// 89
    int getX$val$446;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getX$val$446 = bounds.getX ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getX$val$446 = bounds.getX ();
    }
// 89
    int getWidth$val$447;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getWidth$val$447 = bounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$447 = bounds.getWidth ();
    }
// 89
    int getWidth$val$448;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getWidth$val$448 = abounds.getWidth ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getWidth$val$448 = abounds.getWidth ();
    }
// 90
    int getY$val$449;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getY$val$449 = bounds.getY ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getY$val$449 = bounds.getY ();
    }
// 90
    int getHeight$val$450;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) bounds)) {
      try {
        getHeight$val$450 = bounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$450 = bounds.getHeight ();
    }
// 90
    int getHeight$val$451;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) abounds)) {
      try {
        getHeight$val$451 = abounds.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$451 = abounds.getHeight ();
    }
// 89
    setLocation (getX$val$446 + (getWidth$val$447 - getWidth$val$448) / 2, getY$val$449 + (getHeight$val$450 - getHeight$val$451) / 2);
// 92
    super.setVisible (b);
  }
  
  public SetEditorDialog_cl () throws Exception { super (); }
  
}


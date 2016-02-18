package JP.go.ipa.oz.user.ide;

public class SubjectGarageBrowserMenuListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.SubjectGarageBrowserMenuListener_if {
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dialogQue;
  JP.go.ipa.oz.user.ide.SubjectGarageBrowser_if sgBrowser;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.SubjectGarageBrowser_if sgb) throws Exception  {
// 37
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq = null;
// 39
    eq = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 40
    super._new_newActionListener (eq);
// 41
    sgBrowser = sgb;
// 42
    dialogQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
    return this;
  }
  
  void execRefresh () throws Exception  {
// 116
    try {
// 117
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sgBrowser)) {
        try {
          sgBrowser.sync ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        sgBrowser.sync ();
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_1) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
      if (_oz_exception_1 instanceof JP.go.ipa.oz.user.garage.GarageException_if) {
        JP.go.ipa.oz.user.garage.GarageException_if ex = (JP.go.ipa.oz.user.garage.GarageException_if) _oz_exception_1;
// 119
        JP.go.ipa.oz.lib.standard._String_if getMessage$val$1162;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ex)) {
          try {
            getMessage$val$1162 = ex.getMessage ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getMessage$val$1162 = ex.getMessage ();
        }
// 119
        handleException (getMessage$val$1162);
      } else if (_oz_exception_1 instanceof JP.go.ipa.oz.lang._Root_if) {
        JP.go.ipa.oz.lang._Root_if o = (JP.go.ipa.oz.lang._Root_if) _oz_exception_1;
// 123
        handleException ((new JP.go.ipa.oz.lib.standard._String_cl("refresh failed")));
      } else throw _exception_1;
    }
    catch (JP.go.ipa.oz.system.ExCellNotFoundException _exception_ex) {
      JP.go.ipa.oz.lang._Exception_if ex = new JP.go.ipa.oz.lang._Exception_cl (_exception_ex);
      
// 121
      handleException ((new JP.go.ipa.oz.lib.standard._String_cl("catalog not found")));
    }
  }
  
  void execImport () throws Exception  {
// 93
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sgBrowser)) {
      try {
        sgBrowser.importSubject ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sgBrowser.importSubject ();
    }
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if evt) throws Exception  {
    checkSecureInvocation ();
// 51
    JP.go.ipa.oz.lib.standard._String_if cmd = null;
// 53
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$1163;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) evt)) {
      try {
        getActionCommand$val$1163 = evt.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$1163 = evt.getActionCommand ();
    }
// 53
    cmd = getActionCommand$val$1163;
// 55
    JP.go.ipa.oz.lib.standard._String_if string$229 = (new JP.go.ipa.oz.lib.standard._String_cl("close"));
    
// 55
    boolean isequal$val$1164;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
      try {
        isequal$val$1164 = cmd.isequal (string$229);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$1164 = cmd.isequal (string$229);
    }
// 55
    if (isequal$val$1164) {{
// 56
        execClose ();
      }
    } else {
// 57
      JP.go.ipa.oz.lib.standard._String_if string$230 = (new JP.go.ipa.oz.lib.standard._String_cl("import"));
      
// 57
      boolean isequal$val$1165;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
        try {
          isequal$val$1165 = cmd.isequal (string$230);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$1165 = cmd.isequal (string$230);
      }
// 57
      if (isequal$val$1165) {{
// 58
          execImport ();
        }
      } else {
// 59
        JP.go.ipa.oz.lib.standard._String_if string$231 = (new JP.go.ipa.oz.lib.standard._String_cl("input GOL"));
        
// 59
        boolean isequal$val$1166;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
          try {
            isequal$val$1166 = cmd.isequal (string$231);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$1166 = cmd.isequal (string$231);
        }
// 59
        if (isequal$val$1166) {{
// 60
            execInputGOL ();
          }
        } else {
// 61
          JP.go.ipa.oz.lib.standard._String_if string$232 = (new JP.go.ipa.oz.lib.standard._String_cl("refresh"));
          
// 61
          boolean isequal$val$1167;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
            try {
              isequal$val$1167 = cmd.isequal (string$232);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            isequal$val$1167 = cmd.isequal (string$232);
          }
// 61
          if (isequal$val$1167) {{
// 62
              execRefresh ();
            }
          } else {
// 63
            JP.go.ipa.oz.lib.standard._String_if string$233 = (new JP.go.ipa.oz.lib.standard._String_cl("remove"));
            
// 63
            boolean isequal$val$1168;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
              try {
                isequal$val$1168 = cmd.isequal (string$233);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              isequal$val$1168 = cmd.isequal (string$233);
            }
// 63
            if (isequal$val$1168) {{
// 64
                execRemove ();
              }
            } else {
// 65
              JP.go.ipa.oz.lib.standard._String_if string$234 = (new JP.go.ipa.oz.lib.standard._String_cl("show summary"));
              
// 65
              boolean isequal$val$1169;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
                try {
                  isequal$val$1169 = cmd.isequal (string$234);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                isequal$val$1169 = cmd.isequal (string$234);
              }
// 65
              if (isequal$val$1169) {{
// 66
                  execShowSummary ();
                }
              } else {
// 67
                JP.go.ipa.oz.lib.standard._String_if string$235 = (new JP.go.ipa.oz.lib.standard._String_cl("contact to trader"));
                
// 67
                boolean isequal$val$1170;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
                  try {
                    isequal$val$1170 = cmd.isequal (string$235);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  isequal$val$1170 = cmd.isequal (string$235);
                }
// 67
                if (isequal$val$1170) {{
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  void execShowSummary () throws Exception  {
// 145
    JP.go.ipa.oz.user.ide.SubjectGarageBrowserGUI_if gui = null;
// 146
    JP.go.ipa.oz.user.ide.SubjectSummary_if ss = null;
// 148
    JP.go.ipa.oz.lib.standard._Frame_if getGUI$val$1171;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sgBrowser)) {
      try {
        getGUI$val$1171 = sgBrowser.getGUI ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getGUI$val$1171 = sgBrowser.getGUI ();
    }
// 148
    gui = (JP.go.ipa.oz.user.ide.SubjectGarageBrowserGUI_if) (getGUI$val$1171);
// 149
    JP.go.ipa.oz.user.ide.SubjectSummary_if getSelectedSummary$val$1172;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
      try {
        getSelectedSummary$val$1172 = gui.getSelectedSummary ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedSummary$val$1172 = gui.getSelectedSummary ();
    }
// 149
    ss = getSelectedSummary$val$1172;
// 150
    if (ss != null) {{
// 151
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sgBrowser)) {
          try {
            sgBrowser.showSummary (ss);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          sgBrowser.showSummary (ss);
        }
      }
    }
  }
  
  void execRemove () throws Exception  {
// 131
    JP.go.ipa.oz.user.ide.SubjectGarageBrowserGUI_if gui = null;
// 132
    JP.go.ipa.oz.user.ide.SubjectSummary_if ss = null;
// 134
    JP.go.ipa.oz.lib.standard._Frame_if getGUI$val$1173;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sgBrowser)) {
      try {
        getGUI$val$1173 = sgBrowser.getGUI ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getGUI$val$1173 = sgBrowser.getGUI ();
    }
// 134
    gui = (JP.go.ipa.oz.user.ide.SubjectGarageBrowserGUI_if) (getGUI$val$1173);
// 135
    JP.go.ipa.oz.user.ide.SubjectSummary_if getSelectedSummary$val$1174;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
      try {
        getSelectedSummary$val$1174 = gui.getSelectedSummary ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedSummary$val$1174 = gui.getSelectedSummary ();
    }
// 135
    ss = getSelectedSummary$val$1174;
// 136
    if (ss != null) {{
// 137
        JP.go.ipa.oz.user.garage.Key_if getKey$val$1175;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ss)) {
          try {
            getKey$val$1175 = ss.getKey ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getKey$val$1175 = ss.getKey ();
        }
// 137
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sgBrowser)) {
          try {
            sgBrowser.remove (getKey$val$1175);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          sgBrowser.remove (getKey$val$1175);
        }
      }
    }
  }
  
  void handleException (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception  {
// 77
    JP.go.ipa.oz.user.misc.gui.ExceptionDialog_if exDialog = null;
// 79
    JP.go.ipa.oz.lib.standard._Frame_if getGUI$val$1176;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sgBrowser)) {
      try {
        getGUI$val$1176 = sgBrowser.getGUI ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getGUI$val$1176 = sgBrowser.getGUI ();
    }
// 79
    exDialog = (JP.go.ipa.oz.user.misc.gui.ExceptionDialog_cl) (new JP.go.ipa.oz.user.misc.gui.ExceptionDialog_cl ())._new_create (getGUI$val$1176, msg, dialogQue);
  }
  
  void execInputGOL () throws Exception  {
// 100
    JP.go.ipa.oz.user.misc.gui.StringInputDialog_if dialog = null;
// 101
    JP.go.ipa.oz.user.ide.GOLInputListenerForSubject_if listener = null;
// 102
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq = null;
// 104
    eq = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 105
    listener = (JP.go.ipa.oz.user.ide.GOLInputListenerForSubject_cl) (new JP.go.ipa.oz.user.ide.GOLInputListenerForSubject_cl ())._new_create (sgBrowser, eq);
// 106
    JP.go.ipa.oz.lib.standard._Frame_if getGUI$val$1177;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sgBrowser)) {
      try {
        getGUI$val$1177 = sgBrowser.getGUI ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getGUI$val$1177 = sgBrowser.getGUI ();
    }
// 106
    dialog = (JP.go.ipa.oz.user.misc.gui.StringInputDialog_cl) (new JP.go.ipa.oz.user.misc.gui.StringInputDialog_cl ())._new_create (getGUI$val$1177, (new JP.go.ipa.oz.lib.standard._String_cl("GOL Input Dialog")), (new JP.go.ipa.oz.lib.standard._String_cl("catalog GOL:")), 50, true);
// 108
    dialog.addStringInputListener (listener);
// 109
    dialog.show ();
  }
  
  void execClose () throws Exception  {
// 86
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sgBrowser)) {
      try {
        sgBrowser.setVisible (false);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sgBrowser.setVisible (false);
    }
  }
  
  public SubjectGarageBrowserMenuListener_cl () throws Exception { super (); }
  
}


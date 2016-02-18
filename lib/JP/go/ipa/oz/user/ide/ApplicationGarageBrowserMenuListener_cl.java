package JP.go.ipa.oz.user.ide;

public class ApplicationGarageBrowserMenuListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.ApplicationGarageBrowserMenuListener_if {
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dialogQue;
  JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_if gBrowser;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_if gb) throws Exception  {
// 38
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq = null;
// 40
    eq = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 41
    super._new_newActionListener (eq);
// 42
    gBrowser = gb;
// 43
    dialogQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
    return this;
  }
  
  void execRefresh () throws Exception  {
// 125
    try {
// 126
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gBrowser)) {
        try {
          gBrowser.sync ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        gBrowser.sync ();
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_1) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
      if (_oz_exception_1 instanceof JP.go.ipa.oz.user.garage.GarageException_if) {
        JP.go.ipa.oz.user.garage.GarageException_if ex = (JP.go.ipa.oz.user.garage.GarageException_if) _oz_exception_1;
// 128
        JP.go.ipa.oz.lib.standard._String_if getMessage$val$1244;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ex)) {
          try {
            getMessage$val$1244 = ex.getMessage ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getMessage$val$1244 = ex.getMessage ();
        }
// 128
        handleException (getMessage$val$1244);
      } else if (_oz_exception_1 instanceof JP.go.ipa.oz.lang._Root_if) {
        JP.go.ipa.oz.lang._Root_if o = (JP.go.ipa.oz.lang._Root_if) _oz_exception_1;
// 132
        handleException ((new JP.go.ipa.oz.lib.standard._String_cl("refresh failed")));
      } else throw _exception_1;
    }
    catch (JP.go.ipa.oz.system.ExCellNotFoundException _exception_ex) {
      JP.go.ipa.oz.lang._Exception_if ex = new JP.go.ipa.oz.lang._Exception_cl (_exception_ex);
      
// 130
      handleException ((new JP.go.ipa.oz.lib.standard._String_cl("catalog not found")));
    }
  }
  
  void execImport () throws Exception  {
// 94
    JP.go.ipa.oz.user.ide.ApplicationGarageBrowserGUI_if gui = null;
// 95
    JP.go.ipa.oz.user.ide.ApplicationSummary_if summary = null;
// 97
    JP.go.ipa.oz.lib.standard._Frame_if getGUI$val$1245;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gBrowser)) {
      try {
        getGUI$val$1245 = gBrowser.getGUI ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getGUI$val$1245 = gBrowser.getGUI ();
    }
// 97
    gui = (JP.go.ipa.oz.user.ide.ApplicationGarageBrowserGUI_if) (getGUI$val$1245);
// 98
    if (gui != null) {{
// 99
        JP.go.ipa.oz.user.ide.ApplicationSummary_if getSelectedSummary$val$1246;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
          try {
            getSelectedSummary$val$1246 = gui.getSelectedSummary ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSelectedSummary$val$1246 = gui.getSelectedSummary ();
        }
// 99
        summary = getSelectedSummary$val$1246;
// 100
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gBrowser)) {
          try {
            gBrowser.importApplication (summary);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          gBrowser.importApplication (summary);
        }
      }
    }
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if evt) throws Exception  {
    checkSecureInvocation ();
// 52
    JP.go.ipa.oz.lib.standard._String_if cmd = null;
// 54
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$1247;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) evt)) {
      try {
        getActionCommand$val$1247 = evt.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$1247 = evt.getActionCommand ();
    }
// 54
    cmd = getActionCommand$val$1247;
// 56
    JP.go.ipa.oz.lib.standard._String_if string$244 = (new JP.go.ipa.oz.lib.standard._String_cl("close"));
    
// 56
    boolean isequal$val$1248;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
      try {
        isequal$val$1248 = cmd.isequal (string$244);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$1248 = cmd.isequal (string$244);
    }
// 56
    if (isequal$val$1248) {{
// 57
        execClose ();
      }
    } else {
// 58
      JP.go.ipa.oz.lib.standard._String_if string$245 = (new JP.go.ipa.oz.lib.standard._String_cl("import"));
      
// 58
      boolean isequal$val$1249;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
        try {
          isequal$val$1249 = cmd.isequal (string$245);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$1249 = cmd.isequal (string$245);
      }
// 58
      if (isequal$val$1249) {{
// 59
          execImport ();
        }
      } else {
// 60
        JP.go.ipa.oz.lib.standard._String_if string$246 = (new JP.go.ipa.oz.lib.standard._String_cl("input GOL"));
        
// 60
        boolean isequal$val$1250;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
          try {
            isequal$val$1250 = cmd.isequal (string$246);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$1250 = cmd.isequal (string$246);
        }
// 60
        if (isequal$val$1250) {{
// 61
            execInputGOL ();
          }
        } else {
// 62
          JP.go.ipa.oz.lib.standard._String_if string$247 = (new JP.go.ipa.oz.lib.standard._String_cl("refresh"));
          
// 62
          boolean isequal$val$1251;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
            try {
              isequal$val$1251 = cmd.isequal (string$247);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            isequal$val$1251 = cmd.isequal (string$247);
          }
// 62
          if (isequal$val$1251) {{
// 63
              execRefresh ();
            }
          } else {
// 64
            JP.go.ipa.oz.lib.standard._String_if string$248 = (new JP.go.ipa.oz.lib.standard._String_cl("remove"));
            
// 64
            boolean isequal$val$1252;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
              try {
                isequal$val$1252 = cmd.isequal (string$248);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              isequal$val$1252 = cmd.isequal (string$248);
            }
// 64
            if (isequal$val$1252) {{
// 65
                execRemove ();
              }
            } else {
// 66
              JP.go.ipa.oz.lib.standard._String_if string$249 = (new JP.go.ipa.oz.lib.standard._String_cl("show summary"));
              
// 66
              boolean isequal$val$1253;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
                try {
                  isequal$val$1253 = cmd.isequal (string$249);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                isequal$val$1253 = cmd.isequal (string$249);
              }
// 66
              if (isequal$val$1253) {{
// 67
                  execShowSummary ();
                }
              } else {
// 68
                JP.go.ipa.oz.lib.standard._String_if string$250 = (new JP.go.ipa.oz.lib.standard._String_cl("contact to trader"));
                
// 68
                boolean isequal$val$1254;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
                  try {
                    isequal$val$1254 = cmd.isequal (string$250);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  isequal$val$1254 = cmd.isequal (string$250);
                }
// 68
                if (isequal$val$1254) {{
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
// 154
    JP.go.ipa.oz.user.ide.ApplicationGarageBrowserGUI_if gui = null;
// 155
    JP.go.ipa.oz.user.ide.ApplicationSummary_if summary = null;
// 157
    JP.go.ipa.oz.lib.standard._Frame_if getGUI$val$1255;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gBrowser)) {
      try {
        getGUI$val$1255 = gBrowser.getGUI ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getGUI$val$1255 = gBrowser.getGUI ();
    }
// 157
    gui = (JP.go.ipa.oz.user.ide.ApplicationGarageBrowserGUI_if) (getGUI$val$1255);
// 158
    JP.go.ipa.oz.user.ide.ApplicationSummary_if getSelectedSummary$val$1256;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
      try {
        getSelectedSummary$val$1256 = gui.getSelectedSummary ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedSummary$val$1256 = gui.getSelectedSummary ();
    }
// 158
    summary = getSelectedSummary$val$1256;
// 159
    if (summary != null) {{
// 160
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gBrowser)) {
          try {
            gBrowser.showSummary (summary);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          gBrowser.showSummary (summary);
        }
      }
    }
  }
  
  void execRemove () throws Exception  {
// 140
    JP.go.ipa.oz.user.ide.ApplicationGarageBrowserGUI_if gui = null;
// 141
    JP.go.ipa.oz.user.ide.ApplicationSummary_if summary = null;
// 143
    JP.go.ipa.oz.lib.standard._Frame_if getGUI$val$1257;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gBrowser)) {
      try {
        getGUI$val$1257 = gBrowser.getGUI ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getGUI$val$1257 = gBrowser.getGUI ();
    }
// 143
    gui = (JP.go.ipa.oz.user.ide.ApplicationGarageBrowserGUI_if) (getGUI$val$1257);
// 144
    JP.go.ipa.oz.user.ide.ApplicationSummary_if getSelectedSummary$val$1258;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
      try {
        getSelectedSummary$val$1258 = gui.getSelectedSummary ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedSummary$val$1258 = gui.getSelectedSummary ();
    }
// 144
    summary = getSelectedSummary$val$1258;
// 145
    if (summary != null) {{
// 146
        JP.go.ipa.oz.user.garage.Key_if getKey$val$1259;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summary)) {
          try {
            getKey$val$1259 = summary.getKey ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getKey$val$1259 = summary.getKey ();
        }
// 146
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gBrowser)) {
          try {
            gBrowser.remove (getKey$val$1259);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          gBrowser.remove (getKey$val$1259);
        }
      }
    }
  }
  
  void handleException (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception  {
// 78
    JP.go.ipa.oz.user.misc.gui.ExceptionDialog_if exDialog = null;
// 80
    JP.go.ipa.oz.lib.standard._Frame_if getGUI$val$1260;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gBrowser)) {
      try {
        getGUI$val$1260 = gBrowser.getGUI ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getGUI$val$1260 = gBrowser.getGUI ();
    }
// 80
    exDialog = (JP.go.ipa.oz.user.misc.gui.ExceptionDialog_cl) (new JP.go.ipa.oz.user.misc.gui.ExceptionDialog_cl ())._new_create (getGUI$val$1260, msg, dialogQue);
  }
  
  void execInputGOL () throws Exception  {
// 108
    JP.go.ipa.oz.user.misc.gui.StringInputDialog_if dialog = null;
// 109
    JP.go.ipa.oz.user.ide.GOLInputListenerForApplication_if listener = null;
// 110
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq = null;
// 112
    eq = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 113
    listener = (JP.go.ipa.oz.user.ide.GOLInputListenerForApplication_cl) (new JP.go.ipa.oz.user.ide.GOLInputListenerForApplication_cl ())._new_create (gBrowser, eq);
// 114
    JP.go.ipa.oz.lib.standard._Frame_if getGUI$val$1261;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gBrowser)) {
      try {
        getGUI$val$1261 = gBrowser.getGUI ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getGUI$val$1261 = gBrowser.getGUI ();
    }
// 114
    dialog = (JP.go.ipa.oz.user.misc.gui.StringInputDialog_cl) (new JP.go.ipa.oz.user.misc.gui.StringInputDialog_cl ())._new_create (getGUI$val$1261, (new JP.go.ipa.oz.lib.standard._String_cl("GOL Input Dialog")), (new JP.go.ipa.oz.lib.standard._String_cl("catalog GOL:")), 50, true);
// 117
    dialog.addStringInputListener (listener);
// 118
    dialog.show ();
  }
  
  void execClose () throws Exception  {
// 87
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gBrowser)) {
      try {
        gBrowser.setVisible (false);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      gBrowser.setVisible (false);
    }
  }
  
  public ApplicationGarageBrowserMenuListener_cl () throws Exception { super (); }
  
}


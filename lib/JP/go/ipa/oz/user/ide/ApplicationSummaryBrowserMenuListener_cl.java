package JP.go.ipa.oz.user.ide;

final public class ApplicationSummaryBrowserMenuListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.ApplicationSummaryBrowserMenuListener_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dialogQue;
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_if gBrowser;
  JP.go.ipa.oz.user.ide.ApplicationSummaryBrowser_if sBrowser;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_if gb, JP.go.ipa.oz.user.ide.ApplicationSummaryBrowser_if sb) throws Exception  {
// 40
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq = null;
// 42
    eq = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 43
    super._new_newActionListener (eq);
// 44
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 45
    dialogQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 46
    gBrowser = gb;
// 47
    sBrowser = sb;
    return this;
  }
  
  void doClose () throws Exception  {
// 92
    JP.go.ipa.oz.user.garage.Key_if key = null;
// 94
    JP.go.ipa.oz.user.garage.Key_if getKey$val$1214;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sBrowser)) {
      try {
        getKey$val$1214 = sBrowser.getKey ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getKey$val$1214 = sBrowser.getKey ();
    }
// 94
    key = getKey$val$1214;
// 95
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gBrowser)) {
      try {
        gBrowser.hideSummary (key);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      gBrowser.hideSummary (key);
    }
  }
  
  void doCancel () throws Exception  {
// 84
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gBrowser)) {
      try {
        gBrowser.exportReady (null);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      gBrowser.exportReady (null);
    }
// 85
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sBrowser)) {
      try {
        sBrowser.dispose ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sBrowser.dispose ();
    }
  }
  
  boolean isLegalInput (JP.go.ipa.oz.user.ide.ApplicationSummary_if summary) throws Exception  {
    boolean bool$val$37;
    
// 143
    JP.go.ipa.oz.lib.standard._String_if getName$val$1215;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summary)) {
      try {
        getName$val$1215 = summary.getName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getName$val$1215 = summary.getName ();
    }
// 143
    int length$val$1216;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) (getName$val$1215))) {
      try {
        length$val$1216 = (getName$val$1215).length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$1216 = (getName$val$1215).length ();
    }
    bool$val$37 = (length$val$1216 > 0);
    if (bool$val$37) {
// 144
      JP.go.ipa.oz.lib.standard._String_if getDescription$val$1217;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summary)) {
        try {
          getDescription$val$1217 = summary.getDescription ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getDescription$val$1217 = summary.getDescription ();
      }
// 144
      int length$val$1218;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) (getDescription$val$1217))) {
        try {
          length$val$1218 = (getDescription$val$1217).length ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        length$val$1218 = (getDescription$val$1217).length ();
      }
      bool$val$37 = (length$val$1218 > 0);
    }
// 143
    if (bool$val$37) {{
// 145
        return true;
      }
    } else {{
// 147
        return false;
      }
    }
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if evt) throws Exception  {
    checkSecureInvocation ();
// 56
    JP.go.ipa.oz.lib.standard._String_if cmd = null;
// 58
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$1219;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) evt)) {
      try {
        getActionCommand$val$1219 = evt.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$1219 = evt.getActionCommand ();
    }
// 58
    cmd = getActionCommand$val$1219;
// 59
    JP.go.ipa.oz.lib.standard._String_if string$236 = (new JP.go.ipa.oz.lib.standard._String_cl("\tApplicationSummaryBrowserMenuListener#actionPerformed"));
    
// 59
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.debugPrintln (string$236);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.debugPrintln (string$236);
    }
// 61
    if (cmd != null) {{
// 62
        JP.go.ipa.oz.lib.standard._String_if string$237 = (new JP.go.ipa.oz.lib.standard._String_cl("\t\tcmd="));
        
// 62
        JP.go.ipa.oz.lib.standard._String_if concat$val$1220;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$237)) {
          try {
            concat$val$1220 = string$237.concat (cmd);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$1220 = string$237.concat (cmd);
        }
// 62
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (concat$val$1220);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (concat$val$1220);
        }
      }
    }
// 65
    JP.go.ipa.oz.lib.standard._String_if string$238 = (new JP.go.ipa.oz.lib.standard._String_cl("close"));
    
// 65
    boolean isequal$val$1221;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
      try {
        isequal$val$1221 = cmd.isequal (string$238);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$1221 = cmd.isequal (string$238);
    }
// 65
    if (isequal$val$1221) {{
// 66
        doClose ();
      }
    } else {
// 67
      JP.go.ipa.oz.lib.standard._String_if string$239 = (new JP.go.ipa.oz.lib.standard._String_cl("cancel"));
      
// 67
      boolean isequal$val$1222;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
        try {
          isequal$val$1222 = cmd.isequal (string$239);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$1222 = cmd.isequal (string$239);
      }
// 67
      if (isequal$val$1222) {{
// 68
          doCancel ();
        }
      } else {
// 69
        JP.go.ipa.oz.lib.standard._String_if string$240 = (new JP.go.ipa.oz.lib.standard._String_cl("export"));
        
// 69
        boolean isequal$val$1223;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
          try {
            isequal$val$1223 = cmd.isequal (string$240);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$1223 = cmd.isequal (string$240);
        }
// 69
        if (isequal$val$1223) {{
// 70
            doExport ();
          }
        } else {
// 71
          JP.go.ipa.oz.lib.standard._String_if string$241 = (new JP.go.ipa.oz.lib.standard._String_cl("import"));
          
// 71
          boolean isequal$val$1224;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
            try {
              isequal$val$1224 = cmd.isequal (string$241);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            isequal$val$1224 = cmd.isequal (string$241);
          }
// 71
          if (isequal$val$1224) {{
// 72
              doImport ();
            }
          } else {
// 73
            JP.go.ipa.oz.lib.standard._String_if string$242 = (new JP.go.ipa.oz.lib.standard._String_cl("save"));
            
// 73
            boolean isequal$val$1225;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
              try {
                isequal$val$1225 = cmd.isequal (string$242);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              isequal$val$1225 = cmd.isequal (string$242);
            }
// 73
            if (isequal$val$1225) {{
// 74
                doSave ();
              }
            }
          }
        }
      }
    }
  }
  
  void doSave () throws Exception  {
// 127
    JP.go.ipa.oz.user.garage.Key_if key = null;
// 128
    JP.go.ipa.oz.user.ide.ApplicationSummary_if summary = null;
// 130
    JP.go.ipa.oz.user.ide.ApplicationSummary_if getInputSummary$val$1226;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sBrowser)) {
      try {
        getInputSummary$val$1226 = sBrowser.getInputSummary ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getInputSummary$val$1226 = sBrowser.getInputSummary ();
    }
// 130
    summary = getInputSummary$val$1226;
// 131
    if (isLegalInput (summary)) {{
// 132
        JP.go.ipa.oz.user.garage.Key_if getKey$val$1227;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sBrowser)) {
          try {
            getKey$val$1227 = sBrowser.getKey ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getKey$val$1227 = sBrowser.getKey ();
        }
// 132
        key = getKey$val$1227;
// 133
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gBrowser)) {
          try {
            gBrowser.replaceSummary (key, summary);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          gBrowser.replaceSummary (key, summary);
        }
      }
    } else {{
// 135
        handleException ((new JP.go.ipa.oz.lib.standard._String_cl("Insufficient input !\nPlease input at least one character in each field.")));
      }
    }
  }
  
  void doImport () throws Exception  {
// 102
    JP.go.ipa.oz.user.ide.ApplicationSummary_if summary = null;
// 104
    JP.go.ipa.oz.user.ide.ApplicationSummary_if getSummary$val$1228;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sBrowser)) {
      try {
        getSummary$val$1228 = sBrowser.getSummary ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSummary$val$1228 = sBrowser.getSummary ();
    }
// 104
    summary = getSummary$val$1228;
// 105
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
  
  void handleException (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception  {
// 155
    JP.go.ipa.oz.user.misc.gui.ExceptionDialog_if exDialog = null;
// 157
    exDialog = (JP.go.ipa.oz.user.misc.gui.ExceptionDialog_cl) (new JP.go.ipa.oz.user.misc.gui.ExceptionDialog_cl ())._new_create (sBrowser, msg, dialogQue);
  }
  
  void doExport () throws Exception  {
// 112
    JP.go.ipa.oz.user.ide.ApplicationSummary_if summary = null;
// 114
    JP.go.ipa.oz.user.ide.ApplicationSummary_if getInputSummary$val$1229;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sBrowser)) {
      try {
        getInputSummary$val$1229 = sBrowser.getInputSummary ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getInputSummary$val$1229 = sBrowser.getInputSummary ();
    }
// 114
    summary = getInputSummary$val$1229;
// 115
    if (isLegalInput (summary)) {{
// 116
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gBrowser)) {
          try {
            gBrowser.exportReady (summary);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          gBrowser.exportReady (summary);
        }
// 117
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sBrowser)) {
          try {
            sBrowser.dispose ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          sBrowser.dispose ();
        }
      }
    } else {{
// 119
        handleException ((new JP.go.ipa.oz.lib.standard._String_cl("Insufficient input !  Please input at least one character in each field.")));
      }
    }
  }
  
  public ApplicationSummaryBrowserMenuListener_cl () throws Exception { super (); }
  
}


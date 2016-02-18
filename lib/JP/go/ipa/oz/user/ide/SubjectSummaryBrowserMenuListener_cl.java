package JP.go.ipa.oz.user.ide;

final public class SubjectSummaryBrowserMenuListener_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.SubjectSummaryBrowserMenuListener_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dialogQue;
  JP.go.ipa.oz.user.ide.SubjectGarageBrowser_if sgBrowser;
  JP.go.ipa.oz.user.ide.SubjectSummaryBrowser_if ssBrowser;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.SubjectGarageBrowser_if sgb, JP.go.ipa.oz.user.ide.SubjectSummaryBrowser_if ssb) throws Exception  {
// 39
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq = null;
// 41
    eq = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 42
    super._new_newActionListener (eq);
// 43
    dialogQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 44
    sgBrowser = sgb;
// 45
    ssBrowser = ssb;
    return this;
  }
  
  void doClose () throws Exception  {
// 85
    JP.go.ipa.oz.user.garage.Key_if key = null;
// 87
    JP.go.ipa.oz.user.garage.Key_if getKey$val$1133;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ssBrowser)) {
      try {
        getKey$val$1133 = ssBrowser.getKey ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getKey$val$1133 = ssBrowser.getKey ();
    }
// 87
    key = getKey$val$1133;
// 88
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sgBrowser)) {
      try {
        sgBrowser.hideSummary (key);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sgBrowser.hideSummary (key);
    }
  }
  
  void doCancel () throws Exception  {
// 77
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sgBrowser)) {
      try {
        sgBrowser.exportReady (null);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sgBrowser.exportReady (null);
    }
// 78
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ssBrowser)) {
      try {
        ssBrowser.dispose ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      ssBrowser.dispose ();
    }
  }
  
  boolean isLegalInput (JP.go.ipa.oz.user.ide.SubjectSummary_if ss) throws Exception  {
    boolean bool$val$30;
    
// 136
    JP.go.ipa.oz.lib.standard._String_if getName$val$1134;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ss)) {
      try {
        getName$val$1134 = ss.getName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getName$val$1134 = ss.getName ();
    }
// 136
    int length$val$1135;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) (getName$val$1134))) {
      try {
        length$val$1135 = (getName$val$1134).length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$1135 = (getName$val$1134).length ();
    }
    bool$val$30 = (length$val$1135 > 0);
    if (bool$val$30) {
// 137
      JP.go.ipa.oz.lib.standard._String_if getDescription$val$1136;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ss)) {
        try {
          getDescription$val$1136 = ss.getDescription ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getDescription$val$1136 = ss.getDescription ();
      }
// 137
      int length$val$1137;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) (getDescription$val$1136))) {
        try {
          length$val$1137 = (getDescription$val$1136).length ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        length$val$1137 = (getDescription$val$1136).length ();
      }
      bool$val$30 = (length$val$1137 > 0);
    }
// 136
    if (bool$val$30) {{
// 138
        return true;
      }
    } else {{
// 140
        return false;
      }
    }
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if evt) throws Exception  {
    checkSecureInvocation ();
// 54
    JP.go.ipa.oz.lib.standard._String_if cmd = null;
// 56
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$1138;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) evt)) {
      try {
        getActionCommand$val$1138 = evt.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$1138 = evt.getActionCommand ();
    }
// 56
    cmd = getActionCommand$val$1138;
// 58
    JP.go.ipa.oz.lib.standard._String_if string$223 = (new JP.go.ipa.oz.lib.standard._String_cl("close"));
    
// 58
    boolean isequal$val$1139;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
      try {
        isequal$val$1139 = cmd.isequal (string$223);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$1139 = cmd.isequal (string$223);
    }
// 58
    if (isequal$val$1139) {{
// 59
        doClose ();
      }
    } else {
// 60
      JP.go.ipa.oz.lib.standard._String_if string$224 = (new JP.go.ipa.oz.lib.standard._String_cl("cancel"));
      
// 60
      boolean isequal$val$1140;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
        try {
          isequal$val$1140 = cmd.isequal (string$224);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$1140 = cmd.isequal (string$224);
      }
// 60
      if (isequal$val$1140) {{
// 61
          doCancel ();
        }
      } else {
// 62
        JP.go.ipa.oz.lib.standard._String_if string$225 = (new JP.go.ipa.oz.lib.standard._String_cl("export"));
        
// 62
        boolean isequal$val$1141;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
          try {
            isequal$val$1141 = cmd.isequal (string$225);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$1141 = cmd.isequal (string$225);
        }
// 62
        if (isequal$val$1141) {{
// 63
            doExport ();
          }
        } else {
// 64
          JP.go.ipa.oz.lib.standard._String_if string$226 = (new JP.go.ipa.oz.lib.standard._String_cl("import"));
          
// 64
          boolean isequal$val$1142;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
            try {
              isequal$val$1142 = cmd.isequal (string$226);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            isequal$val$1142 = cmd.isequal (string$226);
          }
// 64
          if (isequal$val$1142) {{
// 65
              doImport ();
            }
          } else {
// 66
            JP.go.ipa.oz.lib.standard._String_if string$227 = (new JP.go.ipa.oz.lib.standard._String_cl("save"));
            
// 66
            boolean isequal$val$1143;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cmd)) {
              try {
                isequal$val$1143 = cmd.isequal (string$227);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              isequal$val$1143 = cmd.isequal (string$227);
            }
// 66
            if (isequal$val$1143) {{
// 67
                doSave ();
              }
            }
          }
        }
      }
    }
  }
  
  void doSave () throws Exception  {
// 120
    JP.go.ipa.oz.user.garage.Key_if key = null;
// 121
    JP.go.ipa.oz.user.ide.SubjectSummary_if ss = null;
// 123
    JP.go.ipa.oz.user.ide.SubjectSummary_if getInputSummary$val$1144;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ssBrowser)) {
      try {
        getInputSummary$val$1144 = ssBrowser.getInputSummary ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getInputSummary$val$1144 = ssBrowser.getInputSummary ();
    }
// 123
    ss = getInputSummary$val$1144;
// 124
    if (isLegalInput (ss)) {{
// 125
        JP.go.ipa.oz.user.garage.Key_if getKey$val$1145;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ssBrowser)) {
          try {
            getKey$val$1145 = ssBrowser.getKey ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getKey$val$1145 = ssBrowser.getKey ();
        }
// 125
        key = getKey$val$1145;
// 126
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sgBrowser)) {
          try {
            sgBrowser.replaceSummary (key, ss);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          sgBrowser.replaceSummary (key, ss);
        }
      }
    } else {{
// 128
        handleException ((new JP.go.ipa.oz.lib.standard._String_cl("Insufficient input !\nPlease input at least one character in each field.")));
      }
    }
  }
  
  void doImport () throws Exception  {
// 95
    JP.go.ipa.oz.user.ide.SubjectSummary_if ss = null;
// 97
    JP.go.ipa.oz.user.ide.SubjectSummary_if getSummary$val$1146;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ssBrowser)) {
      try {
        getSummary$val$1146 = ssBrowser.getSummary ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSummary$val$1146 = ssBrowser.getSummary ();
    }
// 97
    ss = getSummary$val$1146;
// 98
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sgBrowser)) {
      try {
        sgBrowser.importSubject (ss);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sgBrowser.importSubject (ss);
    }
  }
  
  void handleException (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception  {
// 148
    JP.go.ipa.oz.user.misc.gui.ExceptionDialog_if exDialog = null;
// 150
    exDialog = (JP.go.ipa.oz.user.misc.gui.ExceptionDialog_cl) (new JP.go.ipa.oz.user.misc.gui.ExceptionDialog_cl ())._new_create (ssBrowser, msg, dialogQue);
  }
  
  void doExport () throws Exception  {
// 105
    JP.go.ipa.oz.user.ide.SubjectSummary_if ss = null;
// 107
    JP.go.ipa.oz.user.ide.SubjectSummary_if getInputSummary$val$1147;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ssBrowser)) {
      try {
        getInputSummary$val$1147 = ssBrowser.getInputSummary ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getInputSummary$val$1147 = ssBrowser.getInputSummary ();
    }
// 107
    ss = getInputSummary$val$1147;
// 108
    if (isLegalInput (ss)) {{
// 109
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sgBrowser)) {
          try {
            sgBrowser.exportReady (ss);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          sgBrowser.exportReady (ss);
        }
// 110
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ssBrowser)) {
          try {
            ssBrowser.dispose ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          ssBrowser.dispose ();
        }
      }
    } else {{
// 112
        handleException ((new JP.go.ipa.oz.lib.standard._String_cl("Insufficient input !\nPlease input at least one character in each field.")));
      }
    }
  }
  
  public SubjectSummaryBrowserMenuListener_cl () throws Exception { super (); }
  
}


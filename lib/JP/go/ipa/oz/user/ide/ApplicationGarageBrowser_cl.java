package JP.go.ipa.oz.user.ide;

public class ApplicationGarageBrowser_cl extends JP.go.ipa.oz.user.ide.GarageBrowser_cl implements JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_if {
  JP.go.ipa.oz.user.launcher.LauncherCore_if launcher;
  JP.go.ipa.oz.user.ide.ApplicationGarageBrowserGUI_if gui;
  JP.go.ipa.oz.lib.standard._Dictionary_if summaryViewTable;
  JP.go.ipa.oz.user.garage.ApplicationGarage_if catalog;
  JP.go.ipa.oz.user.launcher.LauncherCellInformationDialog_if launcherCellDialog;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dialogQue;
  JP.go.ipa.oz.system.OzCondition waitForInput = new JP.go.ipa.oz.system.OzCondition (this);
  JP.go.ipa.oz.user.ide.ApplicationSummary_if summaryToExport;
  JP.go.ipa.oz.user.ide.SchoolBrowser_if schoolBrowser;
  
  public Object _new_create (JP.go.ipa.oz.user.launcher.LauncherCellInformationDialog_if ld) throws Exception  {
// 74
    super._new_create ();
// 75
    launcher = null;
// 76
    launcherCellDialog = ld;
// 77
    schoolBrowser = null;
// 78
    init ();
    return this;
  }
  
  public Object _new_create (JP.go.ipa.oz.user.launcher.LauncherCore_if lc) throws Exception  {
// 63
    super._new_create ();
// 64
    launcher = lc;
// 65
    launcherCellDialog = null;
// 66
    schoolBrowser = null;
// 67
    init ();
    return this;
  }
  
  public Object _new_create (JP.go.ipa.oz.user.ide.SchoolBrowser_if sb) throws Exception  {
// 53
    super._new_create ();
// 54
    schoolBrowser = sb;
// 55
    launcher = null;
// 56
    init ();
    return this;
  }
  
  public Object _new_create () throws Exception  {
// 46
    super._new_create ();
    return this;
  }
  
  public JP.go.ipa.oz.user.garage.Key_if exportApplication (JP.go.ipa.oz.user.ide.Application_if app) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 110
      JP.go.ipa.oz.user.garage.Key_if key = null;
// 111
      JP.go.ipa.oz.user.garage.GarageException_if gEx = null;
// 112
      JP.go.ipa.oz.user.garage.GarageOperationCanceledException_if gopEx = null;
// 113
      JP.go.ipa.oz.user.ide.ApplicationSummary_if summary = null;
// 115
      launch ();
// 116
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
        try {
          gui.inputSummary (app);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        gui.inputSummary (app);
      }
// 117
      wait (waitForInput);
// 120
      if (summaryToExport == null) {{
// 121
          gopEx = (JP.go.ipa.oz.user.garage.GarageOperationCanceledException_cl) (new JP.go.ipa.oz.user.garage.GarageOperationCanceledException_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl("Export operation canceled")));
// 122
          throw new JP.go.ipa.oz.lang.OzException (gopEx);
        }
      }
// 125
      if (catalog == null) {{
// 126
          requestGOL ((new JP.go.ipa.oz.lib.standard._String_cl("catalog GOL:")));
        }
      }
// 128
      if (catalog == null) {{
// 129
          gEx = (JP.go.ipa.oz.user.garage.GarageException_cl) (new JP.go.ipa.oz.user.garage.GarageException_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl("Invalid GOL")));
// 130
          throw new JP.go.ipa.oz.lang.OzException (gEx);
        }
      }
// 133
      try {
// 134
        key = put (app, summaryToExport);
      }
      catch (JP.go.ipa.oz.lang.OzException _exception_1) {
        JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
        if (_oz_exception_1 instanceof JP.go.ipa.oz.lang._Root_if) {
          JP.go.ipa.oz.lang._Root_if o = (JP.go.ipa.oz.lang._Root_if) _oz_exception_1;
// 139
          gEx = (JP.go.ipa.oz.user.garage.GarageException_cl) (new JP.go.ipa.oz.user.garage.GarageException_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl("Catalog access failed")));
// 140
          throw new JP.go.ipa.oz.lang.OzException (gEx);
        } else throw _exception_1;
      }
      catch (JP.go.ipa.oz.system.ExCellNotFoundException _exception_ex) {
        JP.go.ipa.oz.lang._Exception_if ex = new JP.go.ipa.oz.lang._Exception_cl (_exception_ex);
        
// 136
        gEx = (JP.go.ipa.oz.user.garage.GarageException_cl) (new JP.go.ipa.oz.user.garage.GarageException_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl("Catalog access failed")));
// 137
        throw new JP.go.ipa.oz.lang.OzException (gEx);
      }
// 143
      JP.go.ipa.oz.user.ide.Summary_if getSummary$val$1279;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) catalog)) {
        try {
          getSummary$val$1279 = catalog.getSummary (key);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getSummary$val$1279 = catalog.getSummary (key);
      }
// 143
      summary = (JP.go.ipa.oz.user.ide.ApplicationSummary_if) (getSummary$val$1279);
// 144
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
        try {
          gui.add (summary);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        gui.add (summary);
      }
// 146
      return key;
    } finally {
      leave ();
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Frame_if getGUI () throws Exception  {
    checkSecureInvocation ();
// 153
    return gui;
  }
  
  void showException (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception  {
// 364
    JP.go.ipa.oz.user.misc.gui.ExceptionDialog_if exDialog = null;
// 366
    exDialog = (JP.go.ipa.oz.user.misc.gui.ExceptionDialog_cl) (new JP.go.ipa.oz.user.misc.gui.ExceptionDialog_cl ())._new_create (gui, msg, dialogQue);
  }
  
  void init () throws Exception  {
  }
  
  public void hideSummary (JP.go.ipa.oz.user.garage.Key_if key) throws Exception  {
    checkSecureInvocation ();
// 177
    JP.go.ipa.oz.user.ide.ApplicationSummaryBrowser_if summaryBrowser = null;
    boolean bool$val$40;
    
    bool$val$40 = summaryViewTable != null;
    if (bool$val$40) {
// 179
      int size$val$1280;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryViewTable)) {
        try {
          size$val$1280 = summaryViewTable.size ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        size$val$1280 = summaryViewTable.size ();
      }
      bool$val$40 = size$val$1280 > 0;
    }
// 179
    if (bool$val$40) {{
// 180
        JP.go.ipa.oz.lang._Root_if get$val$1281;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryViewTable)) {
          try {
            get$val$1281 = summaryViewTable.get (key);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          get$val$1281 = summaryViewTable.get (key);
        }
// 180
        summaryBrowser = (JP.go.ipa.oz.user.ide.ApplicationSummaryBrowser_if) (get$val$1281);
// 181
        if (summaryBrowser != null) {{
// 182
            JP.go.ipa.oz.lib.standard._Dictionary_if remove$val$1282;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryViewTable)) {
              try {
                remove$val$1282 = summaryViewTable.remove (key);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              remove$val$1282 = summaryViewTable.remove (key);
            }
// 183
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryBrowser)) {
              try {
                summaryBrowser.dispose ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              summaryBrowser.dispose ();
            }
          }
        }
      }
    }
  }
  
  public void hideSummary () throws Exception  {
    checkSecureInvocation ();
// 160
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 161
    JP.go.ipa.oz.user.ide.ApplicationSummaryBrowser_if summaryBrowser = null;
    boolean bool$val$41;
    
    bool$val$41 = summaryViewTable != null;
    if (bool$val$41) {
// 163
      int size$val$1283;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryViewTable)) {
        try {
          size$val$1283 = summaryViewTable.size ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        size$val$1283 = summaryViewTable.size ();
      }
      bool$val$41 = size$val$1283 > 0;
    }
// 163
    if (bool$val$41) {{
// 164
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$1284;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryViewTable)) {
          try {
            iterator$val$1284 = summaryViewTable.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$1284 = summaryViewTable.iterator ();
        }
// 164
        itr = iterator$val$1284;
// 165
        while (true) {
// 165
          boolean hasMoreElements$val$1285;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
            try {
              hasMoreElements$val$1285 = itr.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$1285 = itr.hasMoreElements ();
          }
          if (!(hasMoreElements$val$1285)) break;
          
          /* body */ _loop_1: {
// 166
            JP.go.ipa.oz.lang._Root_if nextElement$val$1286;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
              try {
                nextElement$val$1286 = itr.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$1286 = itr.nextElement ();
            }
// 166
            summaryBrowser = (JP.go.ipa.oz.user.ide.ApplicationSummaryBrowser_if) (nextElement$val$1286);
// 167
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryBrowser)) {
              try {
                summaryBrowser.dispose ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              summaryBrowser.dispose ();
            }
          }
        }
// 169
        JP.go.ipa.oz.lib.standard._Plural_if clear$val$1287;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryViewTable)) {
          try {
            clear$val$1287 = summaryViewTable.clear ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          clear$val$1287 = summaryViewTable.clear ();
        }
      }
    }
  }
  
  public void remove (JP.go.ipa.oz.user.garage.Key_if key) throws Exception  {
    checkSecureInvocation ();
// 259
    hideSummary (key);
// 260
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) catalog)) {
      try {
        catalog.remove (key);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      catalog.remove (key);
    }
// 261
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
      try {
        gui.remove (key);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      gui.remove (key);
    }
  }
  
  void requestGOL (JP.go.ipa.oz.lib.standard._String_if message) throws Exception  {
// 349
    JP.go.ipa.oz.user.misc.gui.StringInputDialog_if dialog = null;
// 350
    JP.go.ipa.oz.user.ide.GOLInputListenerForApplication_if listener = null;
// 351
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq = null;
// 353
    eq = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 354
    listener = (JP.go.ipa.oz.user.ide.GOLInputListenerForApplication_cl) (new JP.go.ipa.oz.user.ide.GOLInputListenerForApplication_cl ())._new_create (this, eq);
// 355
    dialog = (JP.go.ipa.oz.user.misc.gui.StringInputDialog_cl) (new JP.go.ipa.oz.user.misc.gui.StringInputDialog_cl ())._new_create (gui, (new JP.go.ipa.oz.lib.standard._String_cl("GOL Input Dialog")), message, 50, true);
// 356
    dialog.addStringInputListener (listener);
// 357
    dialog.show ();
  }
  
  public void exportReady (JP.go.ipa.oz.user.ide.ApplicationSummary_if s) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 102
      summaryToExport = s;
// 103
      signal (waitForInput);
    } finally {
      leave ();
    }
  }
  
  public void bindServer (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
    checkSecureInvocation ();
// 88
    if (gol != null) {{
// 89
        super.bindServer (gol);
// 90
        catalog = new JP.go.ipa.oz.user.garage.ApplicationGarage_pcl (gol);
// 91
        if (gui != null) {{
// 92
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
              try {
                gui.setServerGOL (gol);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              gui.setServerGOL (gol);
            }
// 93
            sync ();
          }
        }
      }
    }
  }
  
  public void quit () throws Exception  {
    checkSecureInvocation ();
// 245
    hideSummary ();
// 247
    if (gui != null) {{
// 248
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
          try {
            gui.dispose ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          gui.dispose ();
        }
      }
    }
// 250
    gui = null;
// 251
    summaryViewTable = null;
// 252
    catalog = null;
  }
  
  public void importApplication (JP.go.ipa.oz.user.ide.ApplicationSummary_if summary) throws Exception  {
    checkSecureInvocation ();
// 199
    JP.go.ipa.oz.user.ide.Application_if app = null;
// 200
    JP.go.ipa.oz.lib.standard._String_if cid = null;
    boolean bool$val$42;
    
    bool$val$42 = launcherCellDialog != null;
    if (!bool$val$42) {
      bool$val$42 = launcher != null;
    }
// 202
    if (bool$val$42) {{
// 203
        try {
// 204
          JP.go.ipa.oz.user.ide.Application_if retreiveApplication$val$1288;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summary)) {
            try {
              retreiveApplication$val$1288 = summary.retreiveApplication ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            retreiveApplication$val$1288 = summary.retreiveApplication ();
          }
// 204
          app = retreiveApplication$val$1288;
// 205
          JP.go.ipa.oz.lib.standard._String_if getClassID$val$1289;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) app)) {
            try {
              getClassID$val$1289 = app.getClassID ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getClassID$val$1289 = app.getClassID ();
          }
// 205
          cid = getClassID$val$1289;
// 206
          if (launcherCellDialog != null) {{
// 207
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) launcherCellDialog)) {
                try {
                  launcherCellDialog.setCID (cid);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                launcherCellDialog.setCID (cid);
              }
// 208
              JP.go.ipa.oz.lib.standard._String_if getServerGOL$val$1290;
              getServerGOL$val$1290 = getServerGOL ();
// 208
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) launcherCellDialog)) {
                try {
                  launcherCellDialog.setCatalogGOL (getServerGOL$val$1290);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                launcherCellDialog.setCatalogGOL (getServerGOL$val$1290);
              }
            }
          } else {
// 209
            if (launcher != null) {{
// 210
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) launcher)) {
                  try {
                    launcher.createCell (cid);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  launcher.createCell (cid);
                }
              }
            }
          }
// 212
          quit ();
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_2) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_2 = _exception_2.getOzException ();
          if (_oz_exception_2 instanceof JP.go.ipa.oz.lang._Root_if) {
            JP.go.ipa.oz.lang._Root_if o = (JP.go.ipa.oz.lang._Root_if) _oz_exception_2;
          } else throw _exception_2;
        }
        catch (JP.go.ipa.oz.system.ExCellNotFoundException _exception_ex) {
          JP.go.ipa.oz.lang._Exception_if ex = new JP.go.ipa.oz.lang._Exception_cl (_exception_ex);
          
        }
        catch (JP.go.ipa.oz.system.ExClassNotFoundException _exception_ex) {
          JP.go.ipa.oz.lang._Exception_if ex = new JP.go.ipa.oz.lang._Exception_cl (_exception_ex);
          
        }
      }
    }
  }
  
  public void importApplication () throws Exception  {
    checkSecureInvocation ();
// 192
    launch ();
  }
  
  public void showSummary (JP.go.ipa.oz.user.ide.ApplicationSummary_if summary) throws Exception  {
    checkSecureInvocation ();
// 298
    JP.go.ipa.oz.user.ide.ApplicationSummaryBrowser_if summaryBrowser = null;
// 299
    JP.go.ipa.oz.user.garage.Key_if key = null;
    boolean bool$val$43;
    
    bool$val$43 = gui != null;
    if (bool$val$43) {
      bool$val$43 = summary != null;
    }
// 301
    if (bool$val$43) {{
// 302
        JP.go.ipa.oz.user.garage.Key_if getKey$val$1291;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summary)) {
          try {
            getKey$val$1291 = summary.getKey ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getKey$val$1291 = summary.getKey ();
        }
// 302
        key = getKey$val$1291;
// 303
        JP.go.ipa.oz.lang._Root_if get$val$1292;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryViewTable)) {
          try {
            get$val$1292 = summaryViewTable.get (key);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          get$val$1292 = summaryViewTable.get (key);
        }
// 303
        summaryBrowser = (JP.go.ipa.oz.user.ide.ApplicationSummaryBrowser_if) (get$val$1292);
// 304
        if (summaryBrowser == null) {{
// 305
            summaryBrowser = (JP.go.ipa.oz.user.ide.ApplicationSummaryBrowser_cl) (new JP.go.ipa.oz.user.ide.ApplicationSummaryBrowser_cl ())._new_create (summary, this);
// 306
            JP.go.ipa.oz.lib.standard._Dictionary_if put$val$1293;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryViewTable)) {
              try {
                put$val$1293 = summaryViewTable.put (key, summaryBrowser);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              put$val$1293 = summaryViewTable.put (key, summaryBrowser);
            }
// 307
            summaryBrowser.show ();
          }
        } else {{
// 309
            summaryBrowser.show ();
          }
        }
      }
    }
  }
  
  public void showSummary () throws Exception  {
    checkSecureInvocation ();
// 284
    JP.go.ipa.oz.user.ide.ApplicationSummary_if summary = null;
// 286
    if (gui != null) {{
// 287
        JP.go.ipa.oz.user.ide.ApplicationSummary_if getSelectedSummary$val$1294;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
          try {
            getSelectedSummary$val$1294 = gui.getSelectedSummary ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSelectedSummary$val$1294 = gui.getSelectedSummary ();
        }
// 287
        summary = getSelectedSummary$val$1294;
// 288
        if (summary != null) {{
// 289
            showSummary (summary);
          }
        }
      }
    }
  }
  
  public void setVisible (boolean visible) throws Exception  {
    checkSecureInvocation ();
// 268
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 269
    JP.go.ipa.oz.user.ide.ApplicationSummaryBrowser_if summaryBrowser = null;
// 271
    if (!visible) {{
// 272
        hideSummary ();
      }
    }
// 275
    if (gui != null) {{
// 276
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
          try {
            gui.setVisible (visible);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          gui.setVisible (visible);
        }
      }
    }
  }
  
  public void launch () throws Exception  {
    checkSecureInvocation ();
// 228
    JP.go.ipa.oz.user.garage.KeyComparator_if keyComp = null;
// 230
    if (gui == null) {{
// 231
        gui = (JP.go.ipa.oz.user.ide.ApplicationGarageBrowserGUI_cl) (new JP.go.ipa.oz.user.ide.ApplicationGarageBrowserGUI_cl ())._new_create (this);
// 232
        dialogQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 233
        keyComp = (JP.go.ipa.oz.user.garage.KeyComparator_cl) (new JP.go.ipa.oz.user.garage.KeyComparator_cl ())._new_create ();
// 234
        summaryViewTable = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (keyComp);
      }
    }
// 237
    gui.setVisible (true);
// 238
    sync ();
  }
  
  public void sync () throws Exception  {
    checkSecureInvocation ();
// 318
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 319
    JP.go.ipa.oz.user.ide.ApplicationSummary_if summary = null;
// 320
    JP.go.ipa.oz.lib.standard._Set_if summarySet = null;
    boolean bool$val$44;
    
    bool$val$44 = catalog != null;
    if (bool$val$44) {
      bool$val$44 = gui != null;
    }
// 322
    if (bool$val$44) {{
// 323
        summarySet = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create ();
// 324
        JP.go.ipa.oz.lib.standard._Iterator_if summaryIterator$val$1295;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) catalog)) {
          try {
            summaryIterator$val$1295 = catalog.summaryIterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          summaryIterator$val$1295 = catalog.summaryIterator ();
        }
// 324
        itr = summaryIterator$val$1295;
// 325
        while (true) {
// 325
          boolean hasMoreElements$val$1296;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
            try {
              hasMoreElements$val$1296 = itr.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$1296 = itr.hasMoreElements ();
          }
          if (!(hasMoreElements$val$1296)) break;
          
          /* body */ _loop_1: {
// 326
            JP.go.ipa.oz.lang._Root_if nextElement$val$1297;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
              try {
                nextElement$val$1297 = itr.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$1297 = itr.nextElement ();
            }
// 326
            summary = (JP.go.ipa.oz.user.ide.ApplicationSummary_if) (nextElement$val$1297);
// 327
            summarySet.add (summary);
          }
        }
// 330
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
          try {
            gui.list (summarySet);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          gui.list (summarySet);
        }
// 331
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
          try {
            gui.toFront ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          gui.toFront ();
        }
      }
    }
  }
  
  public ApplicationGarageBrowser_cl () throws Exception { super (); }
  
}


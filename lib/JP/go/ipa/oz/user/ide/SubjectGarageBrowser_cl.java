package JP.go.ipa.oz.user.ide;

public class SubjectGarageBrowser_cl extends JP.go.ipa.oz.user.ide.GarageBrowser_cl implements JP.go.ipa.oz.user.ide.SubjectGarageBrowser_if {
  JP.go.ipa.oz.user.garage.SubjectGarage_if sGarage;
  JP.go.ipa.oz.user.ide.SubjectSummary_if ssToExport;
  JP.go.ipa.oz.user.ide.SubjectGarageBrowserGUI_if gui;
  JP.go.ipa.oz.lib.standard._Dictionary_if ssViewTable;
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dialogQue;
  JP.go.ipa.oz.system.OzCondition waitForInput = new JP.go.ipa.oz.system.OzCondition (this);
  JP.go.ipa.oz.user.ide.SchoolBrowser_if schoolBrowser;
  JP.go.ipa.oz.lib.standard._ClassLoader_if classLoader;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.SchoolBrowser_if sb, JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
// 59
    super._new_create (gol);
// 60
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 61
    init (sb, gol);
    return this;
  }
  
  public Object _new_create (JP.go.ipa.oz.user.ide.SchoolBrowser_if sb) throws Exception  {
// 50
    super._new_create ();
// 51
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 52
    init (sb, null);
    return this;
  }
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
// 41
    super._new_create (gol);
// 42
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 43
    init (null, gol);
    return this;
  }
  
  public Object _new_create () throws Exception  {
// 33
    super._new_create ();
// 34
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
    return this;
  }
  
  public void hideSummary (JP.go.ipa.oz.user.garage.Key_if key) throws Exception  {
    checkSecureInvocation ();
// 160
    JP.go.ipa.oz.user.ide.SubjectSummaryBrowser_if ssBrowser = null;
    boolean bool$val$33;
    
    bool$val$33 = ssViewTable != null;
    if (bool$val$33) {
// 162
      int size$val$1195;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ssViewTable)) {
        try {
          size$val$1195 = ssViewTable.size ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        size$val$1195 = ssViewTable.size ();
      }
      bool$val$33 = size$val$1195 > 0;
    }
// 162
    if (bool$val$33) {{
// 163
        JP.go.ipa.oz.lang._Root_if get$val$1196;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ssViewTable)) {
          try {
            get$val$1196 = ssViewTable.get (key);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          get$val$1196 = ssViewTable.get (key);
        }
// 163
        ssBrowser = (JP.go.ipa.oz.user.ide.SubjectSummaryBrowser_if) (get$val$1196);
// 164
        if (ssBrowser != null) {{
// 165
            JP.go.ipa.oz.lib.standard._Dictionary_if remove$val$1197;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ssViewTable)) {
              try {
                remove$val$1197 = ssViewTable.remove (key);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              remove$val$1197 = ssViewTable.remove (key);
            }
// 166
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
        }
      }
    }
  }
  
  public void hideSummary () throws Exception  {
    checkSecureInvocation ();
// 143
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 144
    JP.go.ipa.oz.user.ide.SubjectSummaryBrowser_if ssBrowser = null;
    boolean bool$val$34;
    
    bool$val$34 = ssViewTable != null;
    if (bool$val$34) {
// 146
      int size$val$1198;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ssViewTable)) {
        try {
          size$val$1198 = ssViewTable.size ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        size$val$1198 = ssViewTable.size ();
      }
      bool$val$34 = size$val$1198 > 0;
    }
// 146
    if (bool$val$34) {{
// 147
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$1199;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ssViewTable)) {
          try {
            iterator$val$1199 = ssViewTable.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$1199 = ssViewTable.iterator ();
        }
// 147
        itr = iterator$val$1199;
// 148
        while (true) {
// 148
          boolean hasMoreElements$val$1200;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
            try {
              hasMoreElements$val$1200 = itr.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$1200 = itr.hasMoreElements ();
          }
          if (!(hasMoreElements$val$1200)) break;
          
          /* body */ _loop_1: {
// 149
            JP.go.ipa.oz.lang._Root_if nextElement$val$1201;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
              try {
                nextElement$val$1201 = itr.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$1201 = itr.nextElement ();
            }
// 149
            ssBrowser = (JP.go.ipa.oz.user.ide.SubjectSummaryBrowser_if) (nextElement$val$1201);
// 150
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
        }
// 152
        JP.go.ipa.oz.lib.standard._Plural_if clear$val$1202;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ssViewTable)) {
          try {
            clear$val$1202 = ssViewTable.clear ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          clear$val$1202 = ssViewTable.clear ();
        }
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Frame_if getGUI () throws Exception  {
    checkSecureInvocation ();
// 136
    return gui;
  }
  
  public JP.go.ipa.oz.user.garage.Key_if exportSubject (JP.go.ipa.oz.user.ide.Subject_if sbj) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 93
      JP.go.ipa.oz.user.garage.Key_if key = null;
// 94
      JP.go.ipa.oz.user.garage.GarageException_if gEx = null;
// 95
      JP.go.ipa.oz.user.garage.GarageOperationCanceledException_if gopEx = null;
// 96
      JP.go.ipa.oz.user.ide.SubjectSummary_if ss = null;
// 98
      launch ();
// 99
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
        try {
          gui.inputSummary (sbj);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        gui.inputSummary (sbj);
      }
// 100
      wait (waitForInput);
// 103
      if (ssToExport == null) {{
// 104
          gopEx = (JP.go.ipa.oz.user.garage.GarageOperationCanceledException_cl) (new JP.go.ipa.oz.user.garage.GarageOperationCanceledException_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl("Export operation canceled")));
// 105
          throw new JP.go.ipa.oz.lang.OzException (gopEx);
        }
      }
// 108
      if (sGarage == null) {{
// 109
          requestGOL ((new JP.go.ipa.oz.lib.standard._String_cl("catalog GOL:")));
        }
      }
// 111
      if (sGarage == null) {{
// 112
          gEx = (JP.go.ipa.oz.user.garage.GarageException_cl) (new JP.go.ipa.oz.user.garage.GarageException_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl("Invalid GOL")));
// 113
          throw new JP.go.ipa.oz.lang.OzException (gEx);
        }
      }
// 116
      try {
// 117
        key = put (sbj, ssToExport);
      }
      catch (JP.go.ipa.oz.lang.OzException _exception_1) {
        JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
        if (_oz_exception_1 instanceof JP.go.ipa.oz.lang._Root_if) {
          JP.go.ipa.oz.lang._Root_if o = (JP.go.ipa.oz.lang._Root_if) _oz_exception_1;
// 122
          gEx = (JP.go.ipa.oz.user.garage.GarageException_cl) (new JP.go.ipa.oz.user.garage.GarageException_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl("Catalog access failed")));
// 123
          throw new JP.go.ipa.oz.lang.OzException (gEx);
        } else throw _exception_1;
      }
      catch (JP.go.ipa.oz.system.ExCellNotFoundException _exception_ex) {
        JP.go.ipa.oz.lang._Exception_if ex = new JP.go.ipa.oz.lang._Exception_cl (_exception_ex);
        
// 119
        gEx = (JP.go.ipa.oz.user.garage.GarageException_cl) (new JP.go.ipa.oz.user.garage.GarageException_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl("Catalog access failed")));
// 120
        throw new JP.go.ipa.oz.lang.OzException (gEx);
      }
// 126
      JP.go.ipa.oz.user.ide.Summary_if getSummary$val$1203;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sGarage)) {
        try {
          getSummary$val$1203 = sGarage.getSummary (key);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getSummary$val$1203 = sGarage.getSummary (key);
      }
// 126
      ss = (JP.go.ipa.oz.user.ide.SubjectSummary_if) (getSummary$val$1203);
// 127
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
        try {
          gui.add (ss);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        gui.add (ss);
      }
// 129
      return key;
    } finally {
      leave ();
    }
  }
  
  void requestGOL (JP.go.ipa.oz.lib.standard._String_if message) throws Exception  {
// 355
    JP.go.ipa.oz.user.misc.gui.StringInputDialog_if dialog = null;
// 356
    JP.go.ipa.oz.user.ide.GOLInputListenerForSubject_if listener = null;
// 357
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq = null;
// 359
    eq = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 360
    listener = (JP.go.ipa.oz.user.ide.GOLInputListenerForSubject_cl) (new JP.go.ipa.oz.user.ide.GOLInputListenerForSubject_cl ())._new_create (this, eq);
// 361
    dialog = (JP.go.ipa.oz.user.misc.gui.StringInputDialog_cl) (new JP.go.ipa.oz.user.misc.gui.StringInputDialog_cl ())._new_create (gui, (new JP.go.ipa.oz.lib.standard._String_cl("GOL Input Dialog")), message, 50, true);
// 362
    dialog.addStringInputListener (listener);
// 363
    dialog.show ();
  }
  
  void init (JP.go.ipa.oz.user.ide.SchoolBrowser_if sb, JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
// 328
    schoolBrowser = sb;
// 329
    if (gol != null) {{
// 330
        try {
// 331
          bindServer (gol);
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_2) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_2 = _exception_2.getOzException ();
          if (_oz_exception_2 instanceof JP.go.ipa.oz.lib.standard._IllegalArgumentException_if) {
            JP.go.ipa.oz.lib.standard._IllegalArgumentException_if ex = (JP.go.ipa.oz.lib.standard._IllegalArgumentException_if) _oz_exception_2;
          } else if (_oz_exception_2 instanceof JP.go.ipa.oz.lang._Root_if) {
            JP.go.ipa.oz.lang._Root_if o = (JP.go.ipa.oz.lang._Root_if) _oz_exception_2;
          } else throw _exception_2;
        }
      }
    }
  }
  
  public void sync () throws Exception  {
    checkSecureInvocation ();
// 295
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 296
    JP.go.ipa.oz.user.ide.SubjectSummary_if ss = null;
// 297
    JP.go.ipa.oz.lib.standard._Set_if ssSet = null;
    boolean bool$val$35;
    
    bool$val$35 = sGarage != null;
    if (bool$val$35) {
      bool$val$35 = gui != null;
    }
// 299
    if (bool$val$35) {{
// 300
        ssSet = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create ();
// 301
        JP.go.ipa.oz.lib.standard._Iterator_if summaryIterator$val$1204;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sGarage)) {
          try {
            summaryIterator$val$1204 = sGarage.summaryIterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          summaryIterator$val$1204 = sGarage.summaryIterator ();
        }
// 301
        itr = summaryIterator$val$1204;
// 302
        while (true) {
// 302
          boolean hasMoreElements$val$1205;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
            try {
              hasMoreElements$val$1205 = itr.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$1205 = itr.hasMoreElements ();
          }
          if (!(hasMoreElements$val$1205)) break;
          
          /* body */ _loop_1: {
// 303
            JP.go.ipa.oz.lang._Root_if nextElement$val$1206;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
              try {
                nextElement$val$1206 = itr.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$1206 = itr.nextElement ();
            }
// 303
            ss = (JP.go.ipa.oz.user.ide.SubjectSummary_if) (nextElement$val$1206);
// 304
            ssSet.add (ss);
          }
        }
// 307
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
          try {
            gui.list (ssSet);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          gui.list (ssSet);
        }
      }
    }
  }
  
  public void setVisible (boolean visible) throws Exception  {
    checkSecureInvocation ();
// 245
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 246
    JP.go.ipa.oz.user.ide.SubjectSummaryBrowser_if ssBrowser = null;
// 248
    if (!visible) {{
// 249
        hideSummary ();
      }
    }
// 252
    if (gui != null) {{
// 253
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
// 201
    JP.go.ipa.oz.user.garage.KeyComparator_if keyComp = null;
// 203
    if (gui == null) {{
// 204
        gui = (JP.go.ipa.oz.user.ide.SubjectGarageBrowserGUI_cl) (new JP.go.ipa.oz.user.ide.SubjectGarageBrowserGUI_cl ())._new_create (this);
// 205
        dialogQue = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 206
        keyComp = (JP.go.ipa.oz.user.garage.KeyComparator_cl) (new JP.go.ipa.oz.user.garage.KeyComparator_cl ())._new_create ();
// 207
        ssViewTable = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (keyComp);
      }
    }
// 210
    if (classLoader == null) {{
// 211
        classLoader = (JP.go.ipa.oz.lib.standard._ClassLoader_cl) (new JP.go.ipa.oz.lib.standard._ClassLoader_cl ())._new_create ();
      }
    }
// 214
    gui.setVisible (true);
  }
  
  public void quit () throws Exception  {
    checkSecureInvocation ();
// 221
    hideSummary ();
// 223
    if (gui != null) {{
// 224
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
// 226
    gui = null;
// 227
    ssViewTable = null;
// 228
    classLoader = null;
// 229
    sGarage = null;
  }
  
  public void remove (JP.go.ipa.oz.user.garage.Key_if key) throws Exception  {
    checkSecureInvocation ();
// 236
    hideSummary (key);
// 237
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sGarage)) {
      try {
        sGarage.remove (key);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sGarage.remove (key);
    }
// 238
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
  
  public void importSubject (JP.go.ipa.oz.user.ide.SubjectSummary_if ss) throws Exception  {
    checkSecureInvocation ();
// 182
    JP.go.ipa.oz.user.ide.Subject_if sbj = null;
// 184
    try {
// 185
      JP.go.ipa.oz.user.ide.Subject_if retreiveSubject$val$1207;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ss)) {
        try {
          retreiveSubject$val$1207 = ss.retreiveSubject ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        retreiveSubject$val$1207 = ss.retreiveSubject ();
      }
// 185
      sbj = retreiveSubject$val$1207;
// 186
      fetchClassFile (sbj);
// 187
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) schoolBrowser)) {
        try {
          schoolBrowser.mergeSubject (sbj);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        schoolBrowser.mergeSubject (sbj);
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_3) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_3 = _exception_3.getOzException ();
      if (_oz_exception_3 instanceof JP.go.ipa.oz.lang._Root_if) {
        JP.go.ipa.oz.lang._Root_if o = (JP.go.ipa.oz.lang._Root_if) _oz_exception_3;
      } else throw _exception_3;
    }
    catch (JP.go.ipa.oz.system.ExCellNotFoundException _exception_ex) {
      JP.go.ipa.oz.lang._Exception_if ex = new JP.go.ipa.oz.lang._Exception_cl (_exception_ex);
      
    }
    catch (JP.go.ipa.oz.system.ExClassNotFoundException _exception_ex) {
      JP.go.ipa.oz.lang._Exception_if ex = new JP.go.ipa.oz.lang._Exception_cl (_exception_ex);
      
    }
  }
  
  public void importSubject () throws Exception  {
    checkSecureInvocation ();
// 175
    launch ();
  }
  
  public void exportReady (JP.go.ipa.oz.user.ide.SubjectSummary_if ss) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 85
      ssToExport = ss;
// 86
      signal (waitForInput);
    } finally {
      leave ();
    }
  }
  
  void showException (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception  {
// 370
    JP.go.ipa.oz.user.misc.gui.ExceptionDialog_if exDialog = null;
// 372
    exDialog = (JP.go.ipa.oz.user.misc.gui.ExceptionDialog_cl) (new JP.go.ipa.oz.user.misc.gui.ExceptionDialog_cl ())._new_create (gui, msg, dialogQue);
  }
  
  public void showSummary (JP.go.ipa.oz.user.ide.SubjectSummary_if ss) throws Exception  {
    checkSecureInvocation ();
// 275
    JP.go.ipa.oz.user.ide.SubjectSummaryBrowser_if ssBrowser = null;
// 276
    JP.go.ipa.oz.user.garage.Key_if key = null;
    boolean bool$val$36;
    
    bool$val$36 = gui != null;
    if (bool$val$36) {
      bool$val$36 = ss != null;
    }
// 278
    if (bool$val$36) {{
// 279
        JP.go.ipa.oz.user.garage.Key_if getKey$val$1208;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ss)) {
          try {
            getKey$val$1208 = ss.getKey ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getKey$val$1208 = ss.getKey ();
        }
// 279
        key = getKey$val$1208;
// 280
        JP.go.ipa.oz.lang._Root_if get$val$1209;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ssViewTable)) {
          try {
            get$val$1209 = ssViewTable.get (key);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          get$val$1209 = ssViewTable.get (key);
        }
// 280
        ssBrowser = (JP.go.ipa.oz.user.ide.SubjectSummaryBrowser_if) (get$val$1209);
// 281
        if (ssBrowser == null) {{
// 282
            ssBrowser = (JP.go.ipa.oz.user.ide.SubjectSummaryBrowser_cl) (new JP.go.ipa.oz.user.ide.SubjectSummaryBrowser_cl ())._new_create (ss, this);
// 283
            JP.go.ipa.oz.lib.standard._Dictionary_if put$val$1210;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ssViewTable)) {
              try {
                put$val$1210 = ssViewTable.put (key, ssBrowser);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              put$val$1210 = ssViewTable.put (key, ssBrowser);
            }
// 284
            ssBrowser.show ();
          }
        } else {{
// 286
            ssBrowser.show ();
          }
        }
      }
    }
  }
  
  public void showSummary () throws Exception  {
    checkSecureInvocation ();
// 261
    JP.go.ipa.oz.user.ide.SubjectSummary_if ss = null;
// 263
    if (gui != null) {{
// 264
        JP.go.ipa.oz.user.ide.SubjectSummary_if getSelectedSummary$val$1211;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
          try {
            getSelectedSummary$val$1211 = gui.getSelectedSummary ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSelectedSummary$val$1211 = gui.getSelectedSummary ();
        }
// 264
        ss = getSelectedSummary$val$1211;
// 265
        if (ss != null) {{
// 266
            showSummary (ss);
          }
        }
      }
    }
  }
  
  void fetchClassFile (JP.go.ipa.oz.user.ide.Subject_if sbj) throws Exception  {
// 318
    JP.go.ipa.oz.lib.standard._String_if pkgName = null;
// 320
    JP.go.ipa.oz.lib.standard._String_if getPackageName$val$1212;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbj)) {
      try {
        getPackageName$val$1212 = sbj.getPackageName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getPackageName$val$1212 = sbj.getPackageName ();
    }
// 320
    pkgName = getPackageName$val$1212;
// 321
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classLoader)) {
      try {
        classLoader.loadPackage (pkgName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      classLoader.loadPackage (pkgName);
    }
  }
  
  JP.go.ipa.oz.user.garage.Key_if put (JP.go.ipa.oz.user.ide.Subject_if sbj, JP.go.ipa.oz.user.ide.SubjectSummary_if ss) throws Exception  {
// 343
    JP.go.ipa.oz.user.garage.Key_if key = null;
// 345
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbj)) {
      try {
        sbj.setSummary (ss);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sbj.setSummary (ss);
    }
// 346
    JP.go.ipa.oz.user.garage.Key_if putSubject$val$1213;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sGarage)) {
      try {
        putSubject$val$1213 = sGarage.putSubject (sbj);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putSubject$val$1213 = sGarage.putSubject (sbj);
    }
// 346
    key = putSubject$val$1213;
// 348
    return key;
  }
  
  public void bindServer (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
    checkSecureInvocation ();
// 71
    if (gol != null) {{
// 72
        super.bindServer (gol);
// 73
        sGarage = new JP.go.ipa.oz.user.garage.SubjectGarage_pcl (gol);
// 74
        if (gui != null) {{
// 75
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gui)) {
              try {
                gui.setServerGOL (gol);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              gui.setServerGOL (gol);
            }
// 76
            sync ();
          }
        }
      }
    }
  }
  
  public SubjectGarageBrowser_cl () throws Exception { super (); }
  
}


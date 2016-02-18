package JP.go.ipa.oz.user.ide;

public class ApplicationGarageBrowserGUI_cl extends JP.go.ipa.oz.lib.standard._Frame_cl implements JP.go.ipa.oz.user.ide.ApplicationGarageBrowserGUI_if {
  JP.go.ipa.oz.lib.standard._TextField_if serverGOLView;
  JP.go.ipa.oz.lib.standard._List_if listView;
  JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_if gBrowser;
  JP.go.ipa.oz.lib.standard._String_if serverGOL;
  JP.go.ipa.oz.user.ide.BinaryPredicate_if sortPredicate;
  JP.go.ipa.oz.lib.standard._Array_if summaryList;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_if agb) throws Exception  {
// 40
    super._new_newFrame ((new JP.go.ipa.oz.lib.standard._String_cl("Application Catalog Browser")));
// 41
    init (agb);
    return this;
  }
  
  void initGUI () throws Exception  {
// 202
    JP.go.ipa.oz.lib.standard._Panel_if serverPanel = null, listPanel = null;
// 203
    JP.go.ipa.oz.lib.standard._Label_if serverLabel = null, listLabel = null;
// 204
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 205
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 206
    JP.go.ipa.oz.lib.standard._Insets_if insets = null;
// 207
    JP.go.ipa.oz.user.ide.ApplicationSummarySelectListener_if selectListener = null;
// 208
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq = null;
// 209
    JP.go.ipa.oz.user.ide.ApplicationGarageBrowserMenuBar_if menubar = null;
// 211
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 212
    setLayout (layout);
// 215
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 216
    constraints.setFill (constraints.getBOTH ());
// 217
    constraints.setGridwidth (constraints.getREMAINDER ());
// 218
    constraints.setWeightx (1.0);
// 219
    insets = (JP.go.ipa.oz.lib.standard._Insets_cl) (new JP.go.ipa.oz.lib.standard._Insets_cl ())._new_newInsets (0, 0, 0, 0);
// 220
    constraints.setInsets (insets);
// 223
    serverPanel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout);
// 224
    insets.set (10, 10, 5, 10);
// 225
    layout.setConstraints (serverPanel, constraints);
// 226
    insets.set (0, 0, 0, 0);
// 228
    serverLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("server GOL:")));
// 229
    serverGOLView = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField (serverGOL, 50);
// 230
    layout.setConstraints (serverLabel, constraints);
// 231
    layout.setConstraints (serverGOLView, constraints);
// 232
    serverPanel.add (serverLabel);
// 233
    serverPanel.add (serverGOLView);
// 236
    listPanel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout);
// 237
    constraints.setWeighty (1.0);
// 238
    insets.set (10, 10, 5, 10);
// 239
    layout.setConstraints (listPanel, constraints);
// 240
    constraints.setWeighty (0.0);
// 241
    insets.set (0, 0, 0, 0);
// 243
    listLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("application list:")));
// 244
    listView = (JP.go.ipa.oz.lib.standard._List_cl) (new JP.go.ipa.oz.lib.standard._List_cl ())._new_newList (10);
// 245
    layout.setConstraints (listLabel, constraints);
// 246
    constraints.setWeighty (1.0);
// 247
    layout.setConstraints (listView, constraints);
// 248
    listPanel.add (listLabel);
// 249
    listPanel.add (listView);
// 251
    selectListener = (JP.go.ipa.oz.user.ide.ApplicationSummarySelectListener_cl) (new JP.go.ipa.oz.user.ide.ApplicationSummarySelectListener_cl ())._new_create (gBrowser);
// 252
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) listView)) {
      try {
        listView.addActionListener (selectListener);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      listView.addActionListener (selectListener);
    }
// 254
    add (serverPanel);
// 255
    add (listPanel);
// 256
    pack ();
// 259
    menubar = (JP.go.ipa.oz.user.ide.ApplicationGarageBrowserMenuBar_cl) (new JP.go.ipa.oz.user.ide.ApplicationGarageBrowserMenuBar_cl ())._new_create (gBrowser);
// 260
    setMenuBar (menubar);
  }
  
  public void setServerGOL (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
    checkSecureInvocation ();
// 152
    refreshServerGOL (gol);
  }
  
  public void inputSummary (JP.go.ipa.oz.user.ide.Application_if app) throws Exception  {
    checkSecureInvocation ();
// 90
    JP.go.ipa.oz.user.ide.ApplicationSummaryBrowser_if summaryBrowser = null;
// 92
    summaryBrowser = (JP.go.ipa.oz.user.ide.ApplicationSummaryBrowser_cl) (new JP.go.ipa.oz.user.ide.ApplicationSummaryBrowser_cl ())._new_createEditor (app, gBrowser);
  }
  
  void init (JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_if gb) throws Exception  {
// 185
    JP.go.ipa.oz.user.ide.LessApplicationSummary_if less = null;
// 187
    gBrowser = gb;
// 188
    JP.go.ipa.oz.lib.standard._String_if getServerGOL$val$1262;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) gBrowser)) {
      try {
        getServerGOL$val$1262 = gBrowser.getServerGOL ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getServerGOL$val$1262 = gBrowser.getServerGOL ();
    }
// 188
    serverGOL = getServerGOL$val$1262;
// 189
    if (serverGOL == null) {{
// 190
        serverGOL = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("")));
      }
    }
// 192
    less = (JP.go.ipa.oz.user.ide.LessApplicationSubjectSummary_cl) (new JP.go.ipa.oz.user.ide.LessApplicationSubjectSummary_cl ())._new_create ();
// 193
    sortPredicate = less;
// 195
    initGUI ();
  }
  
  public void add (JP.go.ipa.oz.user.ide.ApplicationSummary_if summary) throws Exception  {
    checkSecureInvocation ();
// 50
    int size = 0;
// 52
    if (summaryList == null) {{
// 53
        size = 1;
// 54
        summaryList = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (size);
      }
    } else {{
// 56
        size = summaryList.size () + 1;
// 57
        summaryList.resize (size);
      }
    }
// 59
    summaryList.putAt (size - 1, summary);
// 60
    JP.go.ipa.oz.lib.standard._String_if getName$val$1263;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summary)) {
      try {
        getName$val$1263 = summary.getName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getName$val$1263 = summary.getName ();
    }
// 60
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) listView)) {
      try {
        listView.add (getName$val$1263);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      listView.add (getName$val$1263);
    }
  }
  
  public void remove (JP.go.ipa.oz.user.garage.Key_if key) throws Exception  {
    checkSecureInvocation ();
// 120
    int size = 0, idx = 0, rmidx = 0;
// 121
    JP.go.ipa.oz.user.garage.Key_if key2 = null;
// 122
    JP.go.ipa.oz.user.garage.KeyComparator_if cmp = null;
// 123
    JP.go.ipa.oz.user.ide.ApplicationSummary_if summary = null;
// 125
    if (summaryList != null) {{
// 126
        int size$val$1264;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryList)) {
          try {
            size$val$1264 = summaryList.size ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          size$val$1264 = summaryList.size ();
        }
// 126
        size = size$val$1264;
// 127
        cmp = (JP.go.ipa.oz.user.garage.KeyComparator_cl) (new JP.go.ipa.oz.user.garage.KeyComparator_cl ())._new_create ();
// 128
        rmidx = -1;
// 129
        /* for loop starting here */ {
          /* initialization part */
// 129
          idx = 0;
          
          for (;;) {
            /* boolean expression part */
            if (!(idx < size)) break;
            
            /* body */ _loop_1: {
// 130
              JP.go.ipa.oz.lang._Root_if at$val$1265;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryList)) {
                try {
                  at$val$1265 = summaryList.at (idx);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                at$val$1265 = summaryList.at (idx);
              }
// 130
              summary = (JP.go.ipa.oz.user.ide.ApplicationSummary_if) (at$val$1265);
// 131
              JP.go.ipa.oz.user.garage.Key_if getKey$val$1266;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summary)) {
                try {
                  getKey$val$1266 = summary.getKey ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getKey$val$1266 = summary.getKey ();
              }
// 131
              key2 = getKey$val$1266;
// 132
              if (cmp.compare (key, key2)) {{
// 133
                  rmidx = idx;
// 134
                  break;
                }
              }
            }
            /* iteration part */
// 129
            idx++;
          }
        }
// 138
        if (rmidx != -1) {{
// 139
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) listView)) {
              try {
                listView.remove (rmidx);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              listView.remove (rmidx);
            }
// 140
            /* for loop starting here */ {
              /* initialization part */
// 140
              idx = rmidx + 1;
              
              for (;;) {
                /* boolean expression part */
                if (!(idx < size)) break;
                
                /* body */ _loop_1: {
// 141
                  JP.go.ipa.oz.lang._Root_if at$val$1267;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryList)) {
                    try {
                      at$val$1267 = summaryList.at (idx);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    at$val$1267 = summaryList.at (idx);
                  }
// 141
                  JP.go.ipa.oz.lib.standard._Array_if putAt$val$1268;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryList)) {
                    try {
                      putAt$val$1268 = summaryList.putAt (idx - 1, at$val$1267);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    putAt$val$1268 = summaryList.putAt (idx - 1, at$val$1267);
                  }
                }
                /* iteration part */
// 140
                idx++;
              }
            }
// 143
            JP.go.ipa.oz.lib.standard._Array_if resize$val$1269;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryList)) {
              try {
                resize$val$1269 = summaryList.resize (size - 1);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              resize$val$1269 = summaryList.resize (size - 1);
            }
          }
        }
      }
    }
  }
  
  void requestGOL () throws Exception  {
// 279
    JP.go.ipa.oz.user.misc.gui.StringInputDialog_if dialog = null;
// 280
    JP.go.ipa.oz.user.ide.GOLInputListenerForApplication_if listener = null;
// 281
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq = null;
// 283
    eq = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 284
    listener = (JP.go.ipa.oz.user.ide.GOLInputListenerForApplication_cl) (new JP.go.ipa.oz.user.ide.GOLInputListenerForApplication_cl ())._new_create (gBrowser, eq);
// 285
    dialog = (JP.go.ipa.oz.user.misc.gui.StringInputDialog_cl) (new JP.go.ipa.oz.user.misc.gui.StringInputDialog_cl ())._new_create (this, (new JP.go.ipa.oz.lib.standard._String_cl("GOL Input Dialog")), (new JP.go.ipa.oz.lib.standard._String_cl("catalog GOL:")), 50, true);
// 286
    dialog.addStringInputListener (listener);
// 287
    dialog.show ();
  }
  
  public void list (JP.go.ipa.oz.lib.standard._Collection_if summarySet) throws Exception  {
    checkSecureInvocation ();
// 99
    int size = 0, index = 0;
// 100
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 101
    JP.go.ipa.oz.user.ide.ApplicationSummary_if summary = null;
// 103
    if (summarySet != null) {{
// 104
        clear ();
// 105
        int size$val$1270;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summarySet)) {
          try {
            size$val$1270 = summarySet.size ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          size$val$1270 = summarySet.size ();
        }
// 105
        size = size$val$1270;
// 106
        summaryList = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (size);
// 107
        JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$1271;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summarySet)) {
          try {
            iterator$val$1271 = summarySet.iterator ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          iterator$val$1271 = summarySet.iterator ();
        }
// 107
        itr = iterator$val$1271;
// 108
        /* for loop starting here */ {
          /* initialization part */
// 108
          index = 0;
          
          for (;;) {
            /* boolean expression part */
// 108
            boolean hasMoreElements$val$1272;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
              try {
                hasMoreElements$val$1272 = itr.hasMoreElements ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              hasMoreElements$val$1272 = itr.hasMoreElements ();
            }
            if (!(hasMoreElements$val$1272)) break;
            
            /* body */ _loop_1: {
// 109
              JP.go.ipa.oz.lang._Root_if nextElement$val$1273;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
                try {
                  nextElement$val$1273 = itr.nextElement ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                nextElement$val$1273 = itr.nextElement ();
              }
// 109
              summary = (JP.go.ipa.oz.user.ide.ApplicationSummary_if) (nextElement$val$1273);
// 110
              JP.go.ipa.oz.lib.standard._Array_if putAt$val$1274;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryList)) {
                try {
                  putAt$val$1274 = summaryList.putAt (index, summary);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                putAt$val$1274 = summaryList.putAt (index, summary);
              }
// 111
              JP.go.ipa.oz.lib.standard._String_if getName$val$1275;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summary)) {
                try {
                  getName$val$1275 = summary.getName ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getName$val$1275 = summary.getName ();
              }
// 111
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) listView)) {
                try {
                  listView.add (getName$val$1275);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                listView.add (getName$val$1275);
              }
            }
            /* iteration part */
// 108
            index++;
          }
        }
      }
    }
  }
  
  public JP.go.ipa.oz.user.ide.ApplicationSummary_if getSelectedSummary () throws Exception  {
    checkSecureInvocation ();
// 75
    int index = 0;
// 76
    JP.go.ipa.oz.user.ide.ApplicationSummary_if summary = null;
// 78
    int getSelectedIndex$val$1276;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) listView)) {
      try {
        getSelectedIndex$val$1276 = listView.getSelectedIndex ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedIndex$val$1276 = listView.getSelectedIndex ();
    }
// 78
    index = getSelectedIndex$val$1276;
// 79
    if (index != -1) {{
// 80
        JP.go.ipa.oz.lang._Root_if at$val$1277;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryList)) {
          try {
            at$val$1277 = summaryList.at (index);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          at$val$1277 = summaryList.at (index);
        }
// 80
        summary = (JP.go.ipa.oz.user.ide.ApplicationSummary_if) (at$val$1277);
      }
    }
// 83
    return summary;
  }
  
  public void setVisible (boolean v) throws Exception  {
    checkSecureInvocation ();
// 159
    super.setVisible (v);
// 160
    if (v) {{
        boolean bool$val$39;
        
        bool$val$39 = serverGOL == null;
        if (!bool$val$39) {
// 161
          int length$val$1278;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) serverGOL)) {
            try {
              length$val$1278 = serverGOL.length ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            length$val$1278 = serverGOL.length ();
          }
          bool$val$39 = length$val$1278 == 0;
        }
// 161
        if (bool$val$39) {{
// 162
            requestGOL ();
          }
        }
      }
    }
  }
  
  public void clear () throws Exception  {
    checkSecureInvocation ();
// 67
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) listView)) {
      try {
        listView.removeAll ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      listView.removeAll ();
    }
// 68
    summaryList = null;
  }
  
  void refreshServerGOL (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
// 267
    if (gol != null) {{
// 268
        serverGOL = gol;
      }
    } else {{
// 270
        serverGOL = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("")));
      }
    }
// 272
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) serverGOLView)) {
      try {
        serverGOLView.setText (serverGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      serverGOLView.setText (serverGOL);
    }
  }
  
  public void sort (JP.go.ipa.oz.user.ide.BinaryPredicate_if prd) throws Exception  {
    checkSecureInvocation ();
  }
  
  public void sort () throws Exception  {
    checkSecureInvocation ();
  }
  
  public ApplicationGarageBrowserGUI_cl () throws Exception { super (); }
  
}


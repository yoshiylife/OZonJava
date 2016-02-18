package JP.go.ipa.oz.user.ide;

public class SubjectGarageBrowserGUI_cl extends JP.go.ipa.oz.lib.standard._Frame_cl implements JP.go.ipa.oz.user.ide.SubjectGarageBrowserGUI_if {
  JP.go.ipa.oz.lib.standard._TextField_if serverGOLView;
  JP.go.ipa.oz.lib.standard._List_if listView;
  JP.go.ipa.oz.user.ide.SubjectGarageBrowser_if sgBrowser;
  JP.go.ipa.oz.lib.standard._String_if serverGOL;
  JP.go.ipa.oz.user.ide.BinaryPredicate_if sortPredicate;
  JP.go.ipa.oz.lib.standard._Array_if summaryList;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.SubjectGarageBrowser_if sgb) throws Exception  {
// 40
    super._new_newFrame ((new JP.go.ipa.oz.lib.standard._String_cl("Subject Catalog Browser")));
// 41
    init (sgb);
    return this;
  }
  
  void initGUI () throws Exception  {
// 200
    JP.go.ipa.oz.lib.standard._Panel_if serverPanel = null, listPanel = null;
// 201
    JP.go.ipa.oz.lib.standard._Label_if serverLabel = null, listLabel = null;
// 202
    JP.go.ipa.oz.lib.standard._GridBagLayout_if layout = null;
// 203
    JP.go.ipa.oz.lib.standard._GridBagConstraints_if constraints = null;
// 204
    JP.go.ipa.oz.lib.standard._Insets_if insets = null;
// 205
    JP.go.ipa.oz.user.ide.SubjectSummarySelectListener_if ssListener = null;
// 206
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq = null;
// 207
    JP.go.ipa.oz.user.ide.SubjectGarageBrowserMenuBar_if menubar = null;
// 209
    layout = (JP.go.ipa.oz.lib.standard._GridBagLayout_cl) (new JP.go.ipa.oz.lib.standard._GridBagLayout_cl ())._new_newGridBagLayout ();
// 210
    setLayout (layout);
// 213
    constraints = (JP.go.ipa.oz.lib.standard._GridBagConstraints_cl) (new JP.go.ipa.oz.lib.standard._GridBagConstraints_cl ())._new_newGridBagConstraints ();
// 214
    constraints.setFill (constraints.getBOTH ());
// 215
    constraints.setGridwidth (constraints.getREMAINDER ());
// 216
    constraints.setWeightx (1.0);
// 217
    insets = (JP.go.ipa.oz.lib.standard._Insets_cl) (new JP.go.ipa.oz.lib.standard._Insets_cl ())._new_newInsets (0, 0, 0, 0);
// 218
    constraints.setInsets (insets);
// 221
    serverPanel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout);
// 222
    insets.set (10, 10, 5, 10);
// 223
    layout.setConstraints (serverPanel, constraints);
// 224
    insets.set (0, 0, 0, 0);
// 226
    serverLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("catalog GOL:")));
// 227
    serverGOLView = (JP.go.ipa.oz.lib.standard._TextField_cl) (new JP.go.ipa.oz.lib.standard._TextField_cl ())._new_newTextField (serverGOL, 50);
// 228
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) serverGOLView)) {
      try {
        serverGOLView.setEditable (false);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      serverGOLView.setEditable (false);
    }
// 229
    layout.setConstraints (serverLabel, constraints);
// 230
    layout.setConstraints (serverGOLView, constraints);
// 231
    serverPanel.add (serverLabel);
// 232
    serverPanel.add (serverGOLView);
// 235
    listPanel = (JP.go.ipa.oz.lib.standard._Panel_cl) (new JP.go.ipa.oz.lib.standard._Panel_cl ())._new_newPanel (layout);
// 236
    constraints.setWeighty (1.0);
// 237
    insets.set (10, 10, 5, 10);
// 238
    layout.setConstraints (listPanel, constraints);
// 239
    constraints.setWeighty (0.0);
// 240
    insets.set (0, 0, 0, 0);
// 242
    listLabel = (JP.go.ipa.oz.lib.standard._Label_cl) (new JP.go.ipa.oz.lib.standard._Label_cl ())._new_newLabel ((new JP.go.ipa.oz.lib.standard._String_cl("subject list:")));
// 243
    listView = (JP.go.ipa.oz.lib.standard._List_cl) (new JP.go.ipa.oz.lib.standard._List_cl ())._new_newList (10);
// 244
    layout.setConstraints (listLabel, constraints);
// 245
    constraints.setWeighty (1.0);
// 246
    layout.setConstraints (listView, constraints);
// 247
    listPanel.add (listLabel);
// 248
    listPanel.add (listView);
// 250
    ssListener = (JP.go.ipa.oz.user.ide.SubjectSummarySelectListener_cl) (new JP.go.ipa.oz.user.ide.SubjectSummarySelectListener_cl ())._new_create (sgBrowser);
// 251
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) listView)) {
      try {
        listView.addActionListener (ssListener);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      listView.addActionListener (ssListener);
    }
// 253
    add (serverPanel);
// 254
    add (listPanel);
// 255
    pack ();
// 258
    menubar = (JP.go.ipa.oz.user.ide.SubjectGarageBrowserMenuBar_cl) (new JP.go.ipa.oz.user.ide.SubjectGarageBrowserMenuBar_cl ())._new_create (sgBrowser);
// 259
    setMenuBar (menubar);
  }
  
  public void setServerGOL (JP.go.ipa.oz.lib.standard._String_if gol) throws Exception  {
    checkSecureInvocation ();
// 150
    refreshServerGOL (gol);
  }
  
  public void inputSummary (JP.go.ipa.oz.user.ide.Subject_if sbj) throws Exception  {
    checkSecureInvocation ();
// 90
    JP.go.ipa.oz.user.ide.SubjectSummaryBrowser_if ssBrowser = null;
// 92
    ssBrowser = (JP.go.ipa.oz.user.ide.SubjectSummaryBrowser_cl) (new JP.go.ipa.oz.user.ide.SubjectSummaryBrowser_cl ())._new_createEditor (sbj, sgBrowser);
  }
  
  void init (JP.go.ipa.oz.user.ide.SubjectGarageBrowser_if sgb) throws Exception  {
// 183
    JP.go.ipa.oz.user.ide.LessSubjectSummary_if less = null;
// 185
    sgBrowser = sgb;
// 186
    JP.go.ipa.oz.lib.standard._String_if getServerGOL$val$1178;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sgBrowser)) {
      try {
        getServerGOL$val$1178 = sgBrowser.getServerGOL ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getServerGOL$val$1178 = sgBrowser.getServerGOL ();
    }
// 186
    serverGOL = getServerGOL$val$1178;
// 187
    if (serverGOL == null) {{
// 188
        serverGOL = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("")));
      }
    }
// 190
    less = (JP.go.ipa.oz.user.ide.LessSubjectSummary_cl) (new JP.go.ipa.oz.user.ide.LessSubjectSummary_cl ())._new_create ();
// 191
    sortPredicate = less;
// 193
    initGUI ();
  }
  
  public void add (JP.go.ipa.oz.user.ide.SubjectSummary_if ss) throws Exception  {
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
    summaryList.putAt (size - 1, ss);
// 60
    JP.go.ipa.oz.lib.standard._String_if getName$val$1179;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ss)) {
      try {
        getName$val$1179 = ss.getName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getName$val$1179 = ss.getName ();
    }
// 60
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) listView)) {
      try {
        listView.add (getName$val$1179);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      listView.add (getName$val$1179);
    }
  }
  
  public void remove (JP.go.ipa.oz.user.garage.Key_if key) throws Exception  {
    checkSecureInvocation ();
// 118
    int size = 0, idx = 0, rmidx = 0;
// 119
    JP.go.ipa.oz.user.garage.Key_if key2 = null;
// 120
    JP.go.ipa.oz.user.garage.KeyComparator_if cmp = null;
// 121
    JP.go.ipa.oz.user.ide.SubjectSummary_if ss = null;
// 123
    if (summaryList != null) {{
// 124
        int size$val$1180;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryList)) {
          try {
            size$val$1180 = summaryList.size ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          size$val$1180 = summaryList.size ();
        }
// 124
        size = size$val$1180;
// 125
        cmp = (JP.go.ipa.oz.user.garage.KeyComparator_cl) (new JP.go.ipa.oz.user.garage.KeyComparator_cl ())._new_create ();
// 126
        rmidx = -1;
// 127
        /* for loop starting here */ {
          /* initialization part */
// 127
          idx = 0;
          
          for (;;) {
            /* boolean expression part */
            if (!(idx < size)) break;
            
            /* body */ _loop_1: {
// 128
              JP.go.ipa.oz.lang._Root_if at$val$1181;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryList)) {
                try {
                  at$val$1181 = summaryList.at (idx);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                at$val$1181 = summaryList.at (idx);
              }
// 128
              ss = (JP.go.ipa.oz.user.ide.SubjectSummary_if) (at$val$1181);
// 129
              JP.go.ipa.oz.user.garage.Key_if getKey$val$1182;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ss)) {
                try {
                  getKey$val$1182 = ss.getKey ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getKey$val$1182 = ss.getKey ();
              }
// 129
              key2 = getKey$val$1182;
// 130
              if (cmp.compare (key, key2)) {{
// 131
                  rmidx = idx;
// 132
                  break;
                }
              }
            }
            /* iteration part */
// 127
            idx++;
          }
        }
// 136
        if (rmidx != -1) {{
// 137
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) listView)) {
              try {
                listView.remove (rmidx);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              listView.remove (rmidx);
            }
// 138
            /* for loop starting here */ {
              /* initialization part */
// 138
              idx = rmidx + 1;
              
              for (;;) {
                /* boolean expression part */
                if (!(idx < size)) break;
                
                /* body */ _loop_1: {
// 139
                  JP.go.ipa.oz.lang._Root_if at$val$1183;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryList)) {
                    try {
                      at$val$1183 = summaryList.at (idx);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    at$val$1183 = summaryList.at (idx);
                  }
// 139
                  JP.go.ipa.oz.lib.standard._Array_if putAt$val$1184;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryList)) {
                    try {
                      putAt$val$1184 = summaryList.putAt (idx - 1, at$val$1183);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    putAt$val$1184 = summaryList.putAt (idx - 1, at$val$1183);
                  }
                }
                /* iteration part */
// 138
                idx++;
              }
            }
// 141
            JP.go.ipa.oz.lib.standard._Array_if resize$val$1185;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryList)) {
              try {
                resize$val$1185 = summaryList.resize (size - 1);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              resize$val$1185 = summaryList.resize (size - 1);
            }
          }
        }
      }
    }
  }
  
  void requestGOL () throws Exception  {
// 278
    JP.go.ipa.oz.user.misc.gui.StringInputDialog_if dialog = null;
// 279
    JP.go.ipa.oz.user.ide.GOLInputListenerForSubject_if listener = null;
// 280
    JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if eq = null;
// 282
    eq = (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._EventDispatchingQueue_cl ())._new_create ();
// 283
    listener = (JP.go.ipa.oz.user.ide.GOLInputListenerForSubject_cl) (new JP.go.ipa.oz.user.ide.GOLInputListenerForSubject_cl ())._new_create (sgBrowser, eq);
// 284
    dialog = (JP.go.ipa.oz.user.misc.gui.StringInputDialog_cl) (new JP.go.ipa.oz.user.misc.gui.StringInputDialog_cl ())._new_create (this, (new JP.go.ipa.oz.lib.standard._String_cl("GOL Input Dialog")), (new JP.go.ipa.oz.lib.standard._String_cl("catalog GOL:")), 50, true);
// 285
    dialog.addStringInputListener (listener);
// 286
    dialog.show ();
  }
  
  public void list (JP.go.ipa.oz.lib.standard._Collection_if ssSet) throws Exception  {
    checkSecureInvocation ();
// 99
    int size = 0, index = 0;
// 100
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 101
    JP.go.ipa.oz.user.ide.SubjectSummary_if ss = null;
// 103
    clear ();
// 104
    int size$val$1186;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ssSet)) {
      try {
        size$val$1186 = ssSet.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$1186 = ssSet.size ();
    }
// 104
    size = size$val$1186;
// 105
    summaryList = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (size);
// 106
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$1187;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ssSet)) {
      try {
        iterator$val$1187 = ssSet.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$1187 = ssSet.iterator ();
    }
// 106
    itr = iterator$val$1187;
// 107
    /* for loop starting here */ {
      /* initialization part */
// 107
      index = 0;
      
      for (;;) {
        /* boolean expression part */
// 107
        boolean hasMoreElements$val$1188;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
          try {
            hasMoreElements$val$1188 = itr.hasMoreElements ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          hasMoreElements$val$1188 = itr.hasMoreElements ();
        }
        if (!(hasMoreElements$val$1188)) break;
        
        /* body */ _loop_1: {
// 108
          JP.go.ipa.oz.lang._Root_if nextElement$val$1189;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
            try {
              nextElement$val$1189 = itr.nextElement ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nextElement$val$1189 = itr.nextElement ();
          }
// 108
          ss = (JP.go.ipa.oz.user.ide.SubjectSummary_if) (nextElement$val$1189);
// 109
          JP.go.ipa.oz.lib.standard._Array_if putAt$val$1190;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryList)) {
            try {
              putAt$val$1190 = summaryList.putAt (index, ss);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            putAt$val$1190 = summaryList.putAt (index, ss);
          }
// 110
          JP.go.ipa.oz.lib.standard._String_if getName$val$1191;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ss)) {
            try {
              getName$val$1191 = ss.getName ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getName$val$1191 = ss.getName ();
          }
// 110
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) listView)) {
            try {
              listView.add (getName$val$1191);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            listView.add (getName$val$1191);
          }
        }
        /* iteration part */
// 107
        index++;
      }
    }
  }
  
  public JP.go.ipa.oz.user.ide.SubjectSummary_if getSelectedSummary () throws Exception  {
    checkSecureInvocation ();
// 75
    int index = 0;
// 76
    JP.go.ipa.oz.user.ide.SubjectSummary_if ss = null;
// 78
    int getSelectedIndex$val$1192;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) listView)) {
      try {
        getSelectedIndex$val$1192 = listView.getSelectedIndex ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedIndex$val$1192 = listView.getSelectedIndex ();
    }
// 78
    index = getSelectedIndex$val$1192;
// 79
    if (index != -1) {{
// 80
        JP.go.ipa.oz.lang._Root_if at$val$1193;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) summaryList)) {
          try {
            at$val$1193 = summaryList.at (index);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          at$val$1193 = summaryList.at (index);
        }
// 80
        ss = (JP.go.ipa.oz.user.ide.SubjectSummary_if) (at$val$1193);
      }
    }
// 83
    return ss;
  }
  
  public void setVisible (boolean v) throws Exception  {
    checkSecureInvocation ();
// 157
    super.setVisible (v);
// 158
    if (v) {{
        boolean bool$val$32;
        
        bool$val$32 = serverGOL == null;
        if (!bool$val$32) {
// 159
          int length$val$1194;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) serverGOL)) {
            try {
              length$val$1194 = serverGOL.length ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            length$val$1194 = serverGOL.length ();
          }
          bool$val$32 = length$val$1194 == 0;
        }
// 159
        if (bool$val$32) {{
// 160
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
// 266
    if (gol != null) {{
// 267
        serverGOL = gol;
      }
    } else {{
// 269
        serverGOL = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("")));
      }
    }
// 271
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
  
  public SubjectGarageBrowserGUI_cl () throws Exception { super (); }
  
}


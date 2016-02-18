package JP.go.ipa.oz.user.ide;

public class SBController_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.SBController_if {
  JP.go.ipa.oz.user.ide.SchoolBrowser_if sbr;
  JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if dlgQueue;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.SchoolBrowser_if s, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception  {
// 28
    super._new_newActionListener (q);
// 30
    sbr = s;
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if getDlgQueue () throws Exception  {
    checkSecureInvocation ();
// 293
    return dlgQueue;
  }
  
  public void importSubjectEvnet () throws Exception  {
    checkSecureInvocation ();
// 182
    JP.go.ipa.oz.user.ide.SubjectGarageBrowser_if getSubjectGarageBrowser$val$987;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
      try {
        getSubjectGarageBrowser$val$987 = sbr.getSubjectGarageBrowser ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSubjectGarageBrowser$val$987 = sbr.getSubjectGarageBrowser ();
    }
// 182
    JP.go.ipa.oz.user.ide.SubjectGarageBrowser_if subjectGarageBrowser = getSubjectGarageBrowser$val$987;
// 183
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjectGarageBrowser)) {
      try {
        subjectGarageBrowser.importSubject ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      subjectGarageBrowser.importSubject ();
    }
  }
  
  public void setDlgQueue (JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception  {
    checkSecureInvocation ();
// 302
    dlgQueue = q;
  }
  
  public void resisterApplicationEvnet () throws Exception  {
    checkSecureInvocation ();
// 236
    releaseEvent (3);
  }
  
  public void runEvent () throws Exception  {
    checkSecureInvocation ();
// 177
    JP.go.ipa.oz.lib.standard._List_if getLstLabel$val$988;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
      try {
        getLstLabel$val$988 = sbr.getLstLabel ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getLstLabel$val$988 = sbr.getLstLabel ();
    }
// 177
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$989;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getLstLabel$val$988)) {
      try {
        getSelectedItem$val$989 = getLstLabel$val$988.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$989 = getLstLabel$val$988.getSelectedItem ();
    }
// 177
    if (getSelectedItem$val$989 == null) {
// 177
      return;
    }
// 178
    JP.go.ipa.oz.user.ide.SBUtility_if sbUtil = (JP.go.ipa.oz.user.ide.SBUtility_cl) (new JP.go.ipa.oz.user.ide.SBUtility_cl ())._new_create (sbr);
  }
  
  public void classBrowserEvent (int flag) throws Exception  {
    checkSecureInvocation ();
// 160
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz")));
// 161
    JP.go.ipa.oz.lib.standard._String_if ClassID = null;
// 162
    if (flag == 1) {
// 163
      JP.go.ipa.oz.lib.standard._TextField_if getTxtIfID$val$990;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
        try {
          getTxtIfID$val$990 = sbr.getTxtIfID ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getTxtIfID$val$990 = sbr.getTxtIfID ();
      }
// 163
      JP.go.ipa.oz.lib.standard._String_if getText$val$991;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getTxtIfID$val$990)) {
        try {
          getText$val$991 = getTxtIfID$val$990.getText ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getText$val$991 = getTxtIfID$val$990.getText ();
      }
// 163
      ClassID = getText$val$991;
    } else {
// 164
      if (flag == 2) {
// 165
        JP.go.ipa.oz.lib.standard._TextField_if getTxtImplID$val$992;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
          try {
            getTxtImplID$val$992 = sbr.getTxtImplID ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getTxtImplID$val$992 = sbr.getTxtImplID ();
        }
// 165
        JP.go.ipa.oz.lib.standard._String_if getText$val$993;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getTxtImplID$val$992)) {
          try {
            getText$val$993 = getTxtImplID$val$992.getText ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getText$val$993 = getTxtImplID$val$992.getText ();
        }
// 165
        ClassID = getText$val$993;
      }
    }
    boolean bool$val$26;
    
// 166
    JP.go.ipa.oz.lib.standard._String_if string$184 = (new JP.go.ipa.oz.lib.standard._String_cl("."));
    
// 166
    boolean startsWith$val$994;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ClassID)) {
      try {
        startsWith$val$994 = ClassID.startsWith (string$184);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$994 = ClassID.startsWith (string$184);
    }
    bool$val$26 = !(startsWith$val$994);
    if (bool$val$26) {
// 166
      JP.go.ipa.oz.lib.standard._Checkbox_if getRbtnDevelopment$val$995;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
        try {
          getRbtnDevelopment$val$995 = sbr.getRbtnDevelopment ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getRbtnDevelopment$val$995 = sbr.getRbtnDevelopment ();
      }
// 166
      boolean getState$val$996;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getRbtnDevelopment$val$995)) {
        try {
          getState$val$996 = getRbtnDevelopment$val$995.getState ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getState$val$996 = getRbtnDevelopment$val$995.getState ();
      }
      bool$val$26 = getState$val$996;
    }
// 166
    if (bool$val$26) {
// 167
      JP.go.ipa.oz.lib.standard._String_if string$185 = (new JP.go.ipa.oz.lib.standard._String_cl(".user."));
      
// 167
      JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$997;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
        try {
          append$val$997 = buf.append (string$185);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        append$val$997 = buf.append (string$185);
      }
    } else {
      boolean bool$val$27;
      
// 168
      JP.go.ipa.oz.lib.standard._String_if string$186 = (new JP.go.ipa.oz.lib.standard._String_cl("."));
      
// 168
      boolean startsWith$val$998;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ClassID)) {
        try {
          startsWith$val$998 = ClassID.startsWith (string$186);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        startsWith$val$998 = ClassID.startsWith (string$186);
      }
      bool$val$27 = !(startsWith$val$998);
      if (bool$val$27) {
// 168
        JP.go.ipa.oz.lib.standard._Checkbox_if getRbtnRelease$val$999;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
          try {
            getRbtnRelease$val$999 = sbr.getRbtnRelease ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getRbtnRelease$val$999 = sbr.getRbtnRelease ();
        }
// 168
        boolean getState$val$1000;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getRbtnRelease$val$999)) {
          try {
            getState$val$1000 = getRbtnRelease$val$999.getState ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getState$val$1000 = getRbtnRelease$val$999.getState ();
        }
        bool$val$27 = getState$val$1000;
      }
// 168
      if (bool$val$27) {
// 169
        JP.go.ipa.oz.lib.standard._String_if string$187 = (new JP.go.ipa.oz.lib.standard._String_cl(".user.released."));
        
// 169
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$1001;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
          try {
            append$val$1001 = buf.append (string$187);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$1001 = buf.append (string$187);
        }
      }
    }
// 170
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$1002;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        append$val$1002 = buf.append (ClassID);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$1002 = buf.append (ClassID);
    }
// 171
    try {
// 172
      JP.go.ipa.oz.user.ide.ClassBrowser_if getClassBrowser$val$1003;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
        try {
          getClassBrowser$val$1003 = sbr.getClassBrowser ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getClassBrowser$val$1003 = sbr.getClassBrowser ();
      }
// 172
      JP.go.ipa.oz.lib.standard._String_if asString$val$1004;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
        try {
          asString$val$1004 = buf.asString ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        asString$val$1004 = buf.asString ();
      }
// 172
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getClassBrowser$val$1003)) {
        try {
          getClassBrowser$val$1003.show (asString$val$1004);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getClassBrowser$val$1003.show (asString$val$1004);
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_2) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_2 = _exception_2.getOzException ();
      if (_oz_exception_2 instanceof JP.go.ipa.oz.user.ide.CIException_if) {
        JP.go.ipa.oz.user.ide.CIException_if ex = (JP.go.ipa.oz.user.ide.CIException_if) _oz_exception_2;
      } else throw _exception_2;
    }
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if event) throws Exception  {
    checkSecureInvocation ();
// 42
    JP.go.ipa.oz.lib.standard._Frame_if frame = sbr;
// 43
    JP.go.ipa.oz.lib.standard._StringBuffer_if fName = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 44
    JP.go.ipa.oz.lib.standard._String_if file = null, subjectName = null, menuItem = null;
// 45
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$1005;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) event)) {
      try {
        getActionCommand$val$1005 = event.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$1005 = event.getActionCommand ();
    }
// 45
    menuItem = getActionCommand$val$1005;
// 46
    JP.go.ipa.oz.lib.standard._String_if string$188 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    
// 46
    int compareTo$val$1006;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
      try {
        compareTo$val$1006 = menuItem.compareTo (string$188);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compareTo$val$1006 = menuItem.compareTo (string$188);
    }
// 46
    if (compareTo$val$1006 == 0) {{
      }
    } else {
// 48
      JP.go.ipa.oz.lib.standard._String_if string$189 = (new JP.go.ipa.oz.lib.standard._String_cl("import..."));
      
// 48
      int compareTo$val$1007;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
        try {
          compareTo$val$1007 = menuItem.compareTo (string$189);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        compareTo$val$1007 = menuItem.compareTo (string$189);
      }
// 48
      if (compareTo$val$1007 == 0) {{
// 49
          importEvnet ();
        }
      } else {
// 51
        JP.go.ipa.oz.lib.standard._String_if string$190 = (new JP.go.ipa.oz.lib.standard._String_cl("export..."));
        
// 51
        int compareTo$val$1008;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
          try {
            compareTo$val$1008 = menuItem.compareTo (string$190);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          compareTo$val$1008 = menuItem.compareTo (string$190);
        }
// 51
        if (compareTo$val$1008 == 0) {{
// 52
            exportEvnet ();
          }
        } else {
// 54
          JP.go.ipa.oz.lib.standard._String_if string$191 = (new JP.go.ipa.oz.lib.standard._String_cl("end"));
          
// 54
          int compareTo$val$1009;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
            try {
              compareTo$val$1009 = menuItem.compareTo (string$191);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            compareTo$val$1009 = menuItem.compareTo (string$191);
          }
// 54
          if (compareTo$val$1009 == 0) {{
// 55
              JP.go.ipa.oz.user.ide.QuitDialog_if quitDlg = (JP.go.ipa.oz.user.ide.QuitDialog_cl) (new JP.go.ipa.oz.user.ide.QuitDialog_cl ())._new_create (frame, true, dlgQueue);
// 56
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) quitDlg)) {
                try {
                  quitDlg.setVisible (true);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                quitDlg.setVisible (true);
              }
            }
          } else {
// 58
            JP.go.ipa.oz.lib.standard._String_if string$192 = (new JP.go.ipa.oz.lib.standard._String_cl("add class..."));
            
// 58
            int compareTo$val$1010;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
              try {
                compareTo$val$1010 = menuItem.compareTo (string$192);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              compareTo$val$1010 = menuItem.compareTo (string$192);
            }
// 58
            if (compareTo$val$1010 == 0) {{
// 59
                JP.go.ipa.oz.user.ide.LabelAddDialog_if lblAddDlg = (JP.go.ipa.oz.user.ide.LabelAddDialog_cl) (new JP.go.ipa.oz.user.ide.LabelAddDialog_cl ())._new_create (sbr, true, dlgQueue);
// 60
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblAddDlg)) {
                  try {
                    lblAddDlg.setVisible (true);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  lblAddDlg.setVisible (true);
                }
              }
            } else {
// 62
              JP.go.ipa.oz.lib.standard._String_if string$193 = (new JP.go.ipa.oz.lib.standard._String_cl("remove class..."));
              
// 62
              int compareTo$val$1011;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                try {
                  compareTo$val$1011 = menuItem.compareTo (string$193);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                compareTo$val$1011 = menuItem.compareTo (string$193);
              }
// 62
              if (compareTo$val$1011 == 0) {{
// 63
                  JP.go.ipa.oz.user.ide.LabelDeleteDialog_if lblDelDlg = (JP.go.ipa.oz.user.ide.LabelDeleteDialog_cl) (new JP.go.ipa.oz.user.ide.LabelDeleteDialog_cl ())._new_create (sbr, true, dlgQueue);
// 64
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblDelDlg)) {
                    try {
                      lblDelDlg.setVisible (true);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    lblDelDlg.setVisible (true);
                  }
                }
              } else {
// 66
                JP.go.ipa.oz.lib.standard._String_if string$194 = (new JP.go.ipa.oz.lib.standard._String_cl("rename class..."));
                
// 66
                int compareTo$val$1012;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                  try {
                    compareTo$val$1012 = menuItem.compareTo (string$194);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  compareTo$val$1012 = menuItem.compareTo (string$194);
                }
// 66
                if (compareTo$val$1012 == 0) {{
// 67
                    JP.go.ipa.oz.lib.standard._List_if getLstLabel$val$1013;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
                      try {
                        getLstLabel$val$1013 = sbr.getLstLabel ();
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      getLstLabel$val$1013 = sbr.getLstLabel ();
                    }
// 67
                    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$1014;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getLstLabel$val$1013)) {
                      try {
                        getSelectedItem$val$1014 = getLstLabel$val$1013.getSelectedItem ();
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      getSelectedItem$val$1014 = getLstLabel$val$1013.getSelectedItem ();
                    }
// 67
                    if (getSelectedItem$val$1014 == null) {
// 67
                      return;
                    }
// 68
                    JP.go.ipa.oz.lib.standard._List_if getLstLabel$val$1015;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
                      try {
                        getLstLabel$val$1015 = sbr.getLstLabel ();
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      getLstLabel$val$1015 = sbr.getLstLabel ();
                    }
// 68
                    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$1016;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getLstLabel$val$1015)) {
                      try {
                        getSelectedItem$val$1016 = getLstLabel$val$1015.getSelectedItem ();
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      getSelectedItem$val$1016 = getLstLabel$val$1015.getSelectedItem ();
                    }
// 68
                    JP.go.ipa.oz.lib.standard._String_if labelName = getSelectedItem$val$1016;
// 69
                    JP.go.ipa.oz.user.ide.LabelEditDialog_if lblEditDlg = (JP.go.ipa.oz.user.ide.LabelEditDialog_cl) (new JP.go.ipa.oz.user.ide.LabelEditDialog_cl ())._new_create (sbr, true, labelName, dlgQueue);
// 70
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) lblEditDlg)) {
                      try {
                        lblEditDlg.setVisible (true);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      lblEditDlg.setVisible (true);
                    }
                  }
                } else {
// 72
                  JP.go.ipa.oz.lib.standard._String_if string$195 = (new JP.go.ipa.oz.lib.standard._String_cl("add subject..."));
                  
// 72
                  int compareTo$val$1017;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                    try {
                      compareTo$val$1017 = menuItem.compareTo (string$195);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    compareTo$val$1017 = menuItem.compareTo (string$195);
                  }
// 72
                  if (compareTo$val$1017 == 0) {{
// 73
                      JP.go.ipa.oz.user.ide.SubjectAddDialog_if sbjAddDlg = (JP.go.ipa.oz.user.ide.SubjectAddDialog_cl) (new JP.go.ipa.oz.user.ide.SubjectAddDialog_cl ())._new_create (sbr, true, dlgQueue);
// 74
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbjAddDlg)) {
                        try {
                          sbjAddDlg.setVisible (true);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        sbjAddDlg.setVisible (true);
                      }
                    }
                  } else {
// 76
                    JP.go.ipa.oz.lib.standard._String_if string$196 = (new JP.go.ipa.oz.lib.standard._String_cl("remove subject..."));
                    
// 76
                    int compareTo$val$1018;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                      try {
                        compareTo$val$1018 = menuItem.compareTo (string$196);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      compareTo$val$1018 = menuItem.compareTo (string$196);
                    }
// 76
                    if (compareTo$val$1018 == 0) {{
// 77
                        JP.go.ipa.oz.user.ide.SubjectDeleteDialog_if sbjDelDlg = (JP.go.ipa.oz.user.ide.SubjectDeleteDialog_cl) (new JP.go.ipa.oz.user.ide.SubjectDeleteDialog_cl ())._new_create (sbr, true, dlgQueue);
// 78
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbjDelDlg)) {
                          try {
                            sbjDelDlg.setVisible (true);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          sbjDelDlg.setVisible (true);
                        }
                      }
                    } else {
// 80
                      JP.go.ipa.oz.lib.standard._String_if string$197 = (new JP.go.ipa.oz.lib.standard._String_cl("rename subject..."));
                      
// 80
                      int compareTo$val$1019;
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                        try {
                          compareTo$val$1019 = menuItem.compareTo (string$197);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        compareTo$val$1019 = menuItem.compareTo (string$197);
                      }
// 80
                      if (compareTo$val$1019 == 0) {{
// 81
                          JP.go.ipa.oz.user.ide.SubjectEditDialog_if sbjEditDlg = (JP.go.ipa.oz.user.ide.SubjectEditDialog_cl) (new JP.go.ipa.oz.user.ide.SubjectEditDialog_cl ())._new_create (sbr, true, dlgQueue);
// 82
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbjEditDlg)) {
                            try {
                              sbjEditDlg.setVisible (true);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            sbjEditDlg.setVisible (true);
                          }
                        }
                      } else {
// 84
                        JP.go.ipa.oz.lib.standard._String_if string$198 = (new JP.go.ipa.oz.lib.standard._String_cl("class ID Generate..."));
                        
// 84
                        int compareTo$val$1020;
                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                          try {
                            compareTo$val$1020 = menuItem.compareTo (string$198);
                          } finally {
                            changeRunningToGreen ();
                          }
                        } else {
                          compareTo$val$1020 = menuItem.compareTo (string$198);
                        }
// 84
                        if (compareTo$val$1020 == 0) {{
// 85
                            JP.go.ipa.oz.user.ide.IDGenDialog_if idGenDlg = (JP.go.ipa.oz.user.ide.IDGenDialog_cl) (new JP.go.ipa.oz.user.ide.IDGenDialog_cl ())._new_create (sbr, true, dlgQueue);
// 86
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) idGenDlg)) {
                              try {
                                idGenDlg.setVisible (true);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              idGenDlg.setVisible (true);
                            }
// 87
                            JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$1021;
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
                              try {
                                getChoSubject$val$1021 = sbr.getChoSubject ();
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              getChoSubject$val$1021 = sbr.getChoSubject ();
                            }
// 87
                            JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$1022;
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$1021)) {
                              try {
                                getSelectedItem$val$1022 = getChoSubject$val$1021.getSelectedItem ();
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              getSelectedItem$val$1022 = getChoSubject$val$1021.getSelectedItem ();
                            }
// 87
                            JP.go.ipa.oz.lib.standard._String_if subjectName$1 = getSelectedItem$val$1022;
// 88
                            JP.go.ipa.oz.user.ide.School_if getSchool$val$1023;
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
                              try {
                                getSchool$val$1023 = sbr.getSchool ();
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              getSchool$val$1023 = sbr.getSchool ();
                            }
// 88
                            JP.go.ipa.oz.user.ide.Subject_if getSubject$val$1024;
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchool$val$1023)) {
                              try {
                                getSubject$val$1024 = getSchool$val$1023.getSubject (subjectName$1);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              getSubject$val$1024 = getSchool$val$1023.getSubject (subjectName$1);
                            }
// 88
                            JP.go.ipa.oz.user.ide.Subject_if subject = getSubject$val$1024;
// 89
                            boolean isReleased$val$1025;
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
                              try {
                                isReleased$val$1025 = subject.isReleased ();
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              isReleased$val$1025 = subject.isReleased ();
                            }
// 89
                            if (isReleased$val$1025) {
// 90
                              JP.go.ipa.oz.user.ide.School_if getSchool$val$1026;
                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
                                try {
                                  getSchool$val$1026 = sbr.getSchool ();
                                } finally {
                                  changeRunningToGreen ();
                                }
                              } else {
                                getSchool$val$1026 = sbr.getSchool ();
                              }
// 90
                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchool$val$1026)) {
                                try {
                                  getSchool$val$1026.toReleasState (subjectName$1);
                                } finally {
                                  changeRunningToGreen ();
                                }
                              } else {
                                getSchool$val$1026.toReleasState (subjectName$1);
                              }
                            }
                          }
                        } else {
// 92
                          JP.go.ipa.oz.lib.standard._String_if string$199 = (new JP.go.ipa.oz.lib.standard._String_cl("select subjects..."));
                          
// 92
                          int compareTo$val$1027;
                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                            try {
                              compareTo$val$1027 = menuItem.compareTo (string$199);
                            } finally {
                              changeRunningToGreen ();
                            }
                          } else {
                            compareTo$val$1027 = menuItem.compareTo (string$199);
                          }
// 92
                          if (compareTo$val$1027 == 0) {{
// 93
                              JP.go.ipa.oz.user.ide.SubjectSelectDialog_if sbjSelDlg = (JP.go.ipa.oz.user.ide.SubjectSelectDialog_cl) (new JP.go.ipa.oz.user.ide.SubjectSelectDialog_cl ())._new_create (sbr, true, dlgQueue);
// 94
                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbjSelDlg)) {
                                try {
                                  sbjSelDlg.setVisible (true);
                                } finally {
                                  changeRunningToGreen ();
                                }
                              } else {
                                sbjSelDlg.setVisible (true);
                              }
                            }
                          } else {
// 96
                            JP.go.ipa.oz.lib.standard._String_if string$200 = (new JP.go.ipa.oz.lib.standard._String_cl("run..."));
                            
// 96
                            int compareTo$val$1028;
                            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                              try {
                                compareTo$val$1028 = menuItem.compareTo (string$200);
                              } finally {
                                changeRunningToGreen ();
                              }
                            } else {
                              compareTo$val$1028 = menuItem.compareTo (string$200);
                            }
// 96
                            if (compareTo$val$1028 == 0) {{
// 97
                                runEvent ();
                              }
                            } else {
// 99
                              JP.go.ipa.oz.lib.standard._String_if string$201 = (new JP.go.ipa.oz.lib.standard._String_cl("interface part.."));
                              
// 99
                              int compareTo$val$1029;
                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                                try {
                                  compareTo$val$1029 = menuItem.compareTo (string$201);
                                } finally {
                                  changeRunningToGreen ();
                                }
                              } else {
                                compareTo$val$1029 = menuItem.compareTo (string$201);
                              }
// 99
                              if (compareTo$val$1029 == 0) {{
// 100
                                  classBrowserEvent (1);
                                }
                              } else {
// 102
                                JP.go.ipa.oz.lib.standard._String_if string$202 = (new JP.go.ipa.oz.lib.standard._String_cl("implementaion part.."));
                                
// 102
                                int compareTo$val$1030;
                                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                                  try {
                                    compareTo$val$1030 = menuItem.compareTo (string$202);
                                  } finally {
                                    changeRunningToGreen ();
                                  }
                                } else {
                                  compareTo$val$1030 = menuItem.compareTo (string$202);
                                }
// 102
                                if (compareTo$val$1030 == 0) {{
// 103
                                    classBrowserEvent (2);
                                  }
                                } else {
// 105
                                  JP.go.ipa.oz.lib.standard._String_if string$203 = (new JP.go.ipa.oz.lib.standard._String_cl("interface part..."));
                                  
// 105
                                  int compareTo$val$1031;
                                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                                    try {
                                      compareTo$val$1031 = menuItem.compareTo (string$203);
                                    } finally {
                                      changeRunningToGreen ();
                                    }
                                  } else {
                                    compareTo$val$1031 = menuItem.compareTo (string$203);
                                  }
// 105
                                  if (compareTo$val$1031 == 0) {{
// 106
                                      releaseEvent (1);
                                    }
                                  } else {
// 108
                                    JP.go.ipa.oz.lib.standard._String_if string$204 = (new JP.go.ipa.oz.lib.standard._String_cl("implementation part..."));
                                    
// 108
                                    int compareTo$val$1032;
                                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                                      try {
                                        compareTo$val$1032 = menuItem.compareTo (string$204);
                                      } finally {
                                        changeRunningToGreen ();
                                      }
                                    } else {
                                      compareTo$val$1032 = menuItem.compareTo (string$204);
                                    }
// 108
                                    if (compareTo$val$1032 == 0) {{
// 109
                                        releaseEvent (2);
                                      }
                                    } else {
// 111
                                      JP.go.ipa.oz.lib.standard._String_if string$205 = (new JP.go.ipa.oz.lib.standard._String_cl("import subject..."));
                                      
// 111
                                      int compareTo$val$1033;
                                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                                        try {
                                          compareTo$val$1033 = menuItem.compareTo (string$205);
                                        } finally {
                                          changeRunningToGreen ();
                                        }
                                      } else {
                                        compareTo$val$1033 = menuItem.compareTo (string$205);
                                      }
// 111
                                      if (compareTo$val$1033 == 0) {{
// 112
                                          importSubjectEvnet ();
                                        }
                                      } else {
// 114
                                        JP.go.ipa.oz.lib.standard._String_if string$206 = (new JP.go.ipa.oz.lib.standard._String_cl("resister application..."));
                                        
// 114
                                        int compareTo$val$1034;
                                        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                                          try {
                                            compareTo$val$1034 = menuItem.compareTo (string$206);
                                          } finally {
                                            changeRunningToGreen ();
                                          }
                                        } else {
                                          compareTo$val$1034 = menuItem.compareTo (string$206);
                                        }
// 114
                                        if (compareTo$val$1034 == 0) {{
// 115
                                            resisterApplicationEvnet ();
                                          }
                                        } else {
// 117
                                          JP.go.ipa.oz.lib.standard._String_if string$207 = (new JP.go.ipa.oz.lib.standard._String_cl("version..."));
                                          
// 117
                                          int compareTo$val$1035;
                                          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) menuItem)) {
                                            try {
                                              compareTo$val$1035 = menuItem.compareTo (string$207);
                                            } finally {
                                              changeRunningToGreen ();
                                            }
                                          } else {
                                            compareTo$val$1035 = menuItem.compareTo (string$207);
                                          }
// 117
                                          if (compareTo$val$1035 == 0) {{
// 118
                                              JP.go.ipa.oz.user.ide.AboutDialog_if aboutDlg = (JP.go.ipa.oz.user.ide.AboutDialog_cl) (new JP.go.ipa.oz.user.ide.AboutDialog_cl ())._new_create (frame, true, dlgQueue);
// 119
                                              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) aboutDlg)) {
                                                try {
                                                  aboutDlg.setVisible (true);
                                                } finally {
                                                  changeRunningToGreen ();
                                                }
                                              } else {
                                                aboutDlg.setVisible (true);
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void releaseEvent (int flag) throws Exception  {
    checkSecureInvocation ();
// 188
    JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$1036;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
      try {
        getChoSubject$val$1036 = sbr.getChoSubject ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getChoSubject$val$1036 = sbr.getChoSubject ();
    }
// 188
    JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$1037;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$1036)) {
      try {
        getSelectedItem$val$1037 = getChoSubject$val$1036.getSelectedItem ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSelectedItem$val$1037 = getChoSubject$val$1036.getSelectedItem ();
    }
// 188
    JP.go.ipa.oz.lib.standard._String_if subjectName = getSelectedItem$val$1037;
// 189
    JP.go.ipa.oz.user.ide.School_if getSchool$val$1038;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
      try {
        getSchool$val$1038 = sbr.getSchool ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchool$val$1038 = sbr.getSchool ();
    }
// 189
    JP.go.ipa.oz.user.ide.Subject_if getSubject$val$1039;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchool$val$1038)) {
      try {
        getSubject$val$1039 = getSchool$val$1038.getSubject (subjectName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSubject$val$1039 = getSchool$val$1038.getSubject (subjectName);
    }
// 189
    JP.go.ipa.oz.user.ide.Subject_if subject = getSubject$val$1039;
// 190
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
      try {
        subject.setReleaseMode (flag);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      subject.setReleaseMode (flag);
    }
// 193
    JP.go.ipa.oz.user.ide.School_if getSchool$val$1040;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
      try {
        getSchool$val$1040 = sbr.getSchool ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSchool$val$1040 = sbr.getSchool ();
    }
// 193
    JP.go.ipa.oz.user.ide.CompilerAgent_if ozc = (JP.go.ipa.oz.user.ide.CompilerAgent_cl) (new JP.go.ipa.oz.user.ide.CompilerAgent_cl ())._new_create (getSchool$val$1040);
// 194
    JP.go.ipa.oz.lib.standard._String_if getProjectDir$val$1041;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
      try {
        getProjectDir$val$1041 = sbr.getProjectDir ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getProjectDir$val$1041 = sbr.getProjectDir ();
    }
// 194
    JP.go.ipa.oz.lib.standard._String_if string$208 = (new JP.go.ipa.oz.lib.standard._String_cl("test"));
    
// 194
    boolean release$val$1042;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozc)) {
      try {
        release$val$1042 = ozc.release (getProjectDir$val$1041, flag, string$208);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      release$val$1042 = ozc.release (getProjectDir$val$1041, flag, string$208);
    }
// 197
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 198
    JP.go.ipa.oz.lib.standard._String_if getOzHome$val$1043;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getOzHome$val$1043 = system.getOzHome ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzHome$val$1043 = system.getOzHome ();
    }
// 198
    JP.go.ipa.oz.lib.standard._String_if ozHome = getOzHome$val$1043;
// 199
    JP.go.ipa.oz.lib.standard._StringBuffer_if classPath = null;
// 200
    JP.go.ipa.oz.lib.standard._String_if kugiri = null;
// 201
    JP.go.ipa.oz.lib.standard._String_if string$209 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    
// 201
    boolean startsWith$val$1044;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
      try {
        startsWith$val$1044 = ozHome.startsWith (string$209);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$1044 = ozHome.startsWith (string$209);
    }
// 201
    if (startsWith$val$1044) {
// 202
      kugiri = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    } else {
// 204
      kugiri = (new JP.go.ipa.oz.lib.standard._String_cl("\\"));
    }
// 205
    classPath = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (ozHome);
// 206
    boolean endsWith$val$1045;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
      try {
        endsWith$val$1045 = ozHome.endsWith (kugiri);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      endsWith$val$1045 = ozHome.endsWith (kugiri);
    }
// 206
    if (!(endsWith$val$1045)) {
// 207
      classPath.append (kugiri);
    }
// 208
    classPath.append ((new JP.go.ipa.oz.lib.standard._String_cl("objects")));
// 209
    classPath.append (kugiri);
// 210
    classPath.append ((new JP.go.ipa.oz.lib.standard._String_cl("ide")));
// 211
    classPath.append (kugiri);
// 212
    classPath.append ((new JP.go.ipa.oz.lib.standard._String_cl("tmp")));
// 213
    classPath.append (kugiri);
// 214
    classPath.append ((new JP.go.ipa.oz.lib.standard._String_cl("test.zip")));
// 215
    JP.go.ipa.oz.lib.standard._File_if file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (classPath.asString ());
// 218
    JP.go.ipa.oz.lib.standard._String_if getPackageName$val$1046;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subject)) {
      try {
        getPackageName$val$1046 = subject.getPackageName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getPackageName$val$1046 = subject.getPackageName ();
    }
// 218
    JP.go.ipa.oz.lib.standard._String_if topPackageName = getPackageName$val$1046;
// 219
    JP.go.ipa.oz.lib.standard._LocalRepositoryManager_if localMgr = (JP.go.ipa.oz.lib.standard._LocalRepositoryManager_cl) (new JP.go.ipa.oz.lib.standard._LocalRepositoryManager_cl ())._new_create ();
// 220
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) localMgr)) {
      try {
        localMgr.add (file, topPackageName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      localMgr.add (file, topPackageName);
    }
    boolean bool$val$28;
    
    bool$val$28 = flag == 1;
    if (!bool$val$28) {
      bool$val$28 = flag == 2;
    }
// 222
    if (bool$val$28) {{
// 224
        JP.go.ipa.oz.user.ide.SubjectGarageBrowser_if getSubjectGarageBrowser$val$1047;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
          try {
            getSubjectGarageBrowser$val$1047 = sbr.getSubjectGarageBrowser ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSubjectGarageBrowser$val$1047 = sbr.getSubjectGarageBrowser ();
        }
// 224
        JP.go.ipa.oz.user.ide.SubjectGarageBrowser_if subjectGarageBrowser = getSubjectGarageBrowser$val$1047;
// 225
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjectGarageBrowser)) {
          try {
            subjectGarageBrowser.launch ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          subjectGarageBrowser.launch ();
        }
// 226
        JP.go.ipa.oz.user.garage.Key_if exportSubject$val$1048;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjectGarageBrowser)) {
          try {
            exportSubject$val$1048 = subjectGarageBrowser.exportSubject (subject);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          exportSubject$val$1048 = subjectGarageBrowser.exportSubject (subject);
        }
      }
    } else {
// 227
      if (flag == 3) {{
// 228
          JP.go.ipa.oz.user.ide.Application_if app = (JP.go.ipa.oz.user.ide.Application_cl) (new JP.go.ipa.oz.user.ide.Application_cl ())._new_create (getCIDofCell (topPackageName));
// 229
          JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_if getApplicationGarageBrowser$val$1049;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
            try {
              getApplicationGarageBrowser$val$1049 = sbr.getApplicationGarageBrowser ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getApplicationGarageBrowser$val$1049 = sbr.getApplicationGarageBrowser ();
          }
// 229
          JP.go.ipa.oz.user.ide.ApplicationGarageBrowser_if applGarageBrowser = getApplicationGarageBrowser$val$1049;
// 230
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) applGarageBrowser)) {
            try {
              applGarageBrowser.launch ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            applGarageBrowser.launch ();
          }
// 231
          JP.go.ipa.oz.user.garage.Key_if exportApplication$val$1050;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) applGarageBrowser)) {
            try {
              exportApplication$val$1050 = applGarageBrowser.exportApplication (app);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            exportApplication$val$1050 = applGarageBrowser.exportApplication (app);
          }
        }
      }
    }
  }
  
  public void exportEvnet () throws Exception  {
    checkSecureInvocation ();
// 145
    JP.go.ipa.oz.lib.standard._StringBuffer_if fName = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 146
    JP.go.ipa.oz.lib.standard._String_if file = null, subjectName = null;
// 147
    JP.go.ipa.oz.lib.standard._FileDialog_if getSaveFileDialog$val$1051;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
      try {
        getSaveFileDialog$val$1051 = sbr.getSaveFileDialog ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSaveFileDialog$val$1051 = sbr.getSaveFileDialog ();
    }
// 147
    JP.go.ipa.oz.lib.standard._String_if string$210 = (new JP.go.ipa.oz.lib.standard._String_cl("*.s"));
    
// 147
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSaveFileDialog$val$1051)) {
      try {
        getSaveFileDialog$val$1051.setFile (string$210);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSaveFileDialog$val$1051.setFile (string$210);
    }
// 148
    JP.go.ipa.oz.lib.standard._FileDialog_if getSaveFileDialog$val$1052;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
      try {
        getSaveFileDialog$val$1052 = sbr.getSaveFileDialog ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSaveFileDialog$val$1052 = sbr.getSaveFileDialog ();
    }
// 148
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSaveFileDialog$val$1052)) {
      try {
        getSaveFileDialog$val$1052.setVisible (true);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSaveFileDialog$val$1052.setVisible (true);
    }
// 149
    JP.go.ipa.oz.lib.standard._FileDialog_if getSaveFileDialog$val$1053;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
      try {
        getSaveFileDialog$val$1053 = sbr.getSaveFileDialog ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSaveFileDialog$val$1053 = sbr.getSaveFileDialog ();
    }
// 149
    JP.go.ipa.oz.lib.standard._String_if getFile$val$1054;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSaveFileDialog$val$1053)) {
      try {
        getFile$val$1054 = getSaveFileDialog$val$1053.getFile ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getFile$val$1054 = getSaveFileDialog$val$1053.getFile ();
    }
// 149
    file = getFile$val$1054;
// 150
    if (file != null) {{
// 151
        JP.go.ipa.oz.lib.standard._FileDialog_if getSaveFileDialog$val$1055;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
          try {
            getSaveFileDialog$val$1055 = sbr.getSaveFileDialog ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSaveFileDialog$val$1055 = sbr.getSaveFileDialog ();
        }
// 151
        JP.go.ipa.oz.lib.standard._String_if getDirectory$val$1056;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSaveFileDialog$val$1055)) {
          try {
            getDirectory$val$1056 = getSaveFileDialog$val$1055.getDirectory ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getDirectory$val$1056 = getSaveFileDialog$val$1055.getDirectory ();
        }
// 151
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$1057;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fName)) {
          try {
            append$val$1057 = fName.append (getDirectory$val$1056);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$1057 = fName.append (getDirectory$val$1056);
        }
// 152
        JP.go.ipa.oz.lib.standard._FileDialog_if getSaveFileDialog$val$1058;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
          try {
            getSaveFileDialog$val$1058 = sbr.getSaveFileDialog ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSaveFileDialog$val$1058 = sbr.getSaveFileDialog ();
        }
// 152
        JP.go.ipa.oz.lib.standard._String_if getFile$val$1059;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSaveFileDialog$val$1058)) {
          try {
            getFile$val$1059 = getSaveFileDialog$val$1058.getFile ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getFile$val$1059 = getSaveFileDialog$val$1058.getFile ();
        }
// 152
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$1060;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fName)) {
          try {
            append$val$1060 = fName.append (getFile$val$1059);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$1060 = fName.append (getFile$val$1059);
        }
// 154
        JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$1061;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
          try {
            getChoSubject$val$1061 = sbr.getChoSubject ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$1061 = sbr.getChoSubject ();
        }
// 154
        JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$1062;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$1061)) {
          try {
            getSelectedItem$val$1062 = getChoSubject$val$1061.getSelectedItem ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSelectedItem$val$1062 = getChoSubject$val$1061.getSelectedItem ();
        }
// 154
        subjectName = getSelectedItem$val$1062;
// 155
        JP.go.ipa.oz.user.ide.School_if getSchool$val$1063;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
          try {
            getSchool$val$1063 = sbr.getSchool ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSchool$val$1063 = sbr.getSchool ();
        }
// 155
        JP.go.ipa.oz.lib.standard._String_if asString$val$1064;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fName)) {
          try {
            asString$val$1064 = fName.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$1064 = fName.asString ();
        }
// 155
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchool$val$1063)) {
          try {
            getSchool$val$1063.saveToFile (asString$val$1064, subjectName);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSchool$val$1063.saveToFile (asString$val$1064, subjectName);
        }
      }
    }
  }
  
  public void destroyDlgQueue () throws Exception  {
    checkSecureInvocation ();
// 311
    boolean isDestroyed$val$1065;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlgQueue)) {
      try {
        isDestroyed$val$1065 = dlgQueue.isDestroyed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isDestroyed$val$1065 = dlgQueue.isDestroyed ();
    }
// 311
    if (!isDestroyed$val$1065) {
// 311
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dlgQueue)) {
        try {
          dlgQueue.destroy ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        dlgQueue.destroy ();
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getCIDofCell (JP.go.ipa.oz.lib.standard._String_if pkgName) throws Exception  {
    checkSecureInvocation ();
// 242
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 243
    JP.go.ipa.oz.lib.standard._String_if getOzHome$val$1066;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getOzHome$val$1066 = system.getOzHome ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzHome$val$1066 = system.getOzHome ();
    }
// 243
    JP.go.ipa.oz.lib.standard._String_if ozHome = getOzHome$val$1066;
// 244
    JP.go.ipa.oz.lib.standard._StringBuffer_if buf = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (ozHome);
// 245
    JP.go.ipa.oz.lib.standard._String_if string$211 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
    
// 245
    boolean startsWith$val$1067;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
      try {
        startsWith$val$1067 = ozHome.startsWith (string$211);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$1067 = ozHome.startsWith (string$211);
    }
// 245
    if (startsWith$val$1067) {{
// 246
        JP.go.ipa.oz.lib.standard._String_if string$212 = (new JP.go.ipa.oz.lib.standard._String_cl("/"));
        
// 246
        boolean endsWith$val$1068;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
          try {
            endsWith$val$1068 = ozHome.endsWith (string$212);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          endsWith$val$1068 = ozHome.endsWith (string$212);
        }
// 246
        if (endsWith$val$1068) {
// 247
          JP.go.ipa.oz.lib.standard._String_if string$213 = (new JP.go.ipa.oz.lib.standard._String_cl("objects/ide/tmp/"));
          
// 247
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$1069;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$1069 = buf.append (string$213);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$1069 = buf.append (string$213);
          }
        } else {
// 249
          JP.go.ipa.oz.lib.standard._String_if string$214 = (new JP.go.ipa.oz.lib.standard._String_cl("/objects/ide/tmp/"));
          
// 249
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$1070;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$1070 = buf.append (string$214);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$1070 = buf.append (string$214);
          }
        }
      }
    } else {{
// 251
        JP.go.ipa.oz.lib.standard._String_if string$215 = (new JP.go.ipa.oz.lib.standard._String_cl("\\"));
        
// 251
        boolean endsWith$val$1071;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHome)) {
          try {
            endsWith$val$1071 = ozHome.endsWith (string$215);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          endsWith$val$1071 = ozHome.endsWith (string$215);
        }
// 251
        if (endsWith$val$1071) {
// 252
          JP.go.ipa.oz.lib.standard._String_if string$216 = (new JP.go.ipa.oz.lib.standard._String_cl("objects\\ide\\tmp\\"));
          
// 252
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$1072;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$1072 = buf.append (string$216);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$1072 = buf.append (string$216);
          }
        } else {
// 254
          JP.go.ipa.oz.lib.standard._String_if string$217 = (new JP.go.ipa.oz.lib.standard._String_cl("\\objects\\ide\\tmp\\"));
          
// 254
          JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$1073;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
            try {
              append$val$1073 = buf.append (string$217);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            append$val$1073 = buf.append (string$217);
          }
        }
      }
    }
// 258
    JP.go.ipa.oz.lib.standard._String_if tmp = null;
// 259
    JP.go.ipa.oz.lib.standard._Array_if fileList = null;
// 260
    JP.go.ipa.oz.lib.standard._String_if asString$val$1074;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) buf)) {
      try {
        asString$val$1074 = buf.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$1074 = buf.asString ();
    }
// 260
    JP.go.ipa.oz.lib.standard._File_if file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (asString$val$1074);
// 261
    JP.go.ipa.oz.user.ide.ExtensionFilter_if classFilter = (JP.go.ipa.oz.user.ide.ExtensionFilter_cl) (new JP.go.ipa.oz.user.ide.ExtensionFilter_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl(".class")));
// 262
    JP.go.ipa.oz.lib.standard._Array_if list$val$1075;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
      try {
        list$val$1075 = file.list (classFilter);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      list$val$1075 = file.list (classFilter);
    }
// 262
    fileList = list$val$1075;
// 263
    if (fileList == null) {{
// 264
        return null;
      }
    } else {{
// 266
        int size$val$1076;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
          try {
            size$val$1076 = fileList.size ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          size$val$1076 = fileList.size ();
        }
// 266
        int max = size$val$1076;
// 267
        /* for loop starting here */ {
          /* initialization part */
          int i = 0;
          
          for (;;) {
            /* boolean expression part */
            if (!(i < max)) break;
            
            /* body */ _loop_1: {
// 268
              JP.go.ipa.oz.lang._Root_if at$val$1077;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
                try {
                  at$val$1077 = fileList.at (i);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                at$val$1077 = fileList.at (i);
              }
// 268
              tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$1077);
// 269
              JP.go.ipa.oz.lib.standard._String_if string$218 = (new JP.go.ipa.oz.lib.standard._String_cl("_pcl.class"));
              
// 269
              boolean endsWith$val$1078;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                try {
                  endsWith$val$1078 = tmp.endsWith (string$218);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                endsWith$val$1078 = tmp.endsWith (string$218);
              }
// 269
              if (endsWith$val$1078) {
// 270
                break;
              }
            }
            /* iteration part */
// 267
            i++;
          }
        }
      }
    }
// 275
    JP.go.ipa.oz.lib.standard._StringBuffer_if cid = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (pkgName);
// 276
    JP.go.ipa.oz.lib.standard._String_if string$219 = (new JP.go.ipa.oz.lib.standard._String_cl("."));
    
// 276
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$1079;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
      try {
        append$val$1079 = cid.append (string$219);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$1079 = cid.append (string$219);
    }
// 277
    JP.go.ipa.oz.lib.standard._String_if string$220 = (new JP.go.ipa.oz.lib.standard._String_cl("_"));
    
// 277
    int lastIndexOf$val$1080;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
      try {
        lastIndexOf$val$1080 = tmp.lastIndexOf (string$220);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$1080 = tmp.lastIndexOf (string$220);
    }
// 277
    JP.go.ipa.oz.lib.standard._String_if substring$val$1081;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
      try {
        substring$val$1081 = tmp.substring (0, lastIndexOf$val$1080);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$1081 = tmp.substring (0, lastIndexOf$val$1080);
    }
// 277
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$1082;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
      try {
        append$val$1082 = cid.append (substring$val$1081);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$1082 = cid.append (substring$val$1081);
    }
// 278
    JP.go.ipa.oz.lib.standard._String_if string$221 = (new JP.go.ipa.oz.lib.standard._String_cl("_cl"));
    
// 278
    JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$1083;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
      try {
        append$val$1083 = cid.append (string$221);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      append$val$1083 = cid.append (string$221);
    }
// 279
    JP.go.ipa.oz.lib.standard._String_if asString$val$1084;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
      try {
        asString$val$1084 = cid.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$1084 = cid.asString ();
    }
// 279
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.println (asString$val$1084);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.println (asString$val$1084);
    }
// 280
    JP.go.ipa.oz.lib.standard._String_if asString$val$1085;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
      try {
        asString$val$1085 = cid.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$1085 = cid.asString ();
    }
// 280
    return asString$val$1085;
  }
  
  public void importEvnet () throws Exception  {
    checkSecureInvocation ();
// 127
    JP.go.ipa.oz.lib.standard._StringBuffer_if fName = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed ();
// 128
    JP.go.ipa.oz.lib.standard._String_if file = null, subjectName = null;
// 129
    JP.go.ipa.oz.lib.standard._FileDialog_if getOpenFileDialog$val$1086;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
      try {
        getOpenFileDialog$val$1086 = sbr.getOpenFileDialog ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOpenFileDialog$val$1086 = sbr.getOpenFileDialog ();
    }
// 129
    JP.go.ipa.oz.lib.standard._String_if string$222 = (new JP.go.ipa.oz.lib.standard._String_cl("*.s"));
    
// 129
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getOpenFileDialog$val$1086)) {
      try {
        getOpenFileDialog$val$1086.setFile (string$222);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOpenFileDialog$val$1086.setFile (string$222);
    }
// 130
    JP.go.ipa.oz.lib.standard._FileDialog_if getOpenFileDialog$val$1087;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
      try {
        getOpenFileDialog$val$1087 = sbr.getOpenFileDialog ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOpenFileDialog$val$1087 = sbr.getOpenFileDialog ();
    }
// 130
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getOpenFileDialog$val$1087)) {
      try {
        getOpenFileDialog$val$1087.addNotify ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOpenFileDialog$val$1087.addNotify ();
    }
// 131
    JP.go.ipa.oz.lib.standard._FileDialog_if getOpenFileDialog$val$1088;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
      try {
        getOpenFileDialog$val$1088 = sbr.getOpenFileDialog ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOpenFileDialog$val$1088 = sbr.getOpenFileDialog ();
    }
// 131
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getOpenFileDialog$val$1088)) {
      try {
        getOpenFileDialog$val$1088.setVisible (true);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOpenFileDialog$val$1088.setVisible (true);
    }
// 132
    JP.go.ipa.oz.lib.standard._FileDialog_if getOpenFileDialog$val$1089;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
      try {
        getOpenFileDialog$val$1089 = sbr.getOpenFileDialog ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOpenFileDialog$val$1089 = sbr.getOpenFileDialog ();
    }
// 132
    JP.go.ipa.oz.lib.standard._String_if getFile$val$1090;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getOpenFileDialog$val$1089)) {
      try {
        getFile$val$1090 = getOpenFileDialog$val$1089.getFile ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getFile$val$1090 = getOpenFileDialog$val$1089.getFile ();
    }
// 132
    file = getFile$val$1090;
// 133
    if (file != null) {{
// 134
        JP.go.ipa.oz.lib.standard._FileDialog_if getOpenFileDialog$val$1091;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
          try {
            getOpenFileDialog$val$1091 = sbr.getOpenFileDialog ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getOpenFileDialog$val$1091 = sbr.getOpenFileDialog ();
        }
// 134
        JP.go.ipa.oz.lib.standard._String_if getDirectory$val$1092;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getOpenFileDialog$val$1091)) {
          try {
            getDirectory$val$1092 = getOpenFileDialog$val$1091.getDirectory ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getDirectory$val$1092 = getOpenFileDialog$val$1091.getDirectory ();
        }
// 134
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$1093;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fName)) {
          try {
            append$val$1093 = fName.append (getDirectory$val$1092);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$1093 = fName.append (getDirectory$val$1092);
        }
// 135
        JP.go.ipa.oz.lib.standard._FileDialog_if getOpenFileDialog$val$1094;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
          try {
            getOpenFileDialog$val$1094 = sbr.getOpenFileDialog ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getOpenFileDialog$val$1094 = sbr.getOpenFileDialog ();
        }
// 135
        JP.go.ipa.oz.lib.standard._String_if getFile$val$1095;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getOpenFileDialog$val$1094)) {
          try {
            getFile$val$1095 = getOpenFileDialog$val$1094.getFile ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getFile$val$1095 = getOpenFileDialog$val$1094.getFile ();
        }
// 135
        JP.go.ipa.oz.lib.standard._StringBuffer_if append$val$1096;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fName)) {
          try {
            append$val$1096 = fName.append (getFile$val$1095);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          append$val$1096 = fName.append (getFile$val$1095);
        }
// 137
        JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$1097;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
          try {
            getChoSubject$val$1097 = sbr.getChoSubject ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$1097 = sbr.getChoSubject ();
        }
// 137
        JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$1098;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$1097)) {
          try {
            getSelectedItem$val$1098 = getChoSubject$val$1097.getSelectedItem ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSelectedItem$val$1098 = getChoSubject$val$1097.getSelectedItem ();
        }
// 137
        subjectName = getSelectedItem$val$1098;
// 138
        JP.go.ipa.oz.user.ide.School_if getSchool$val$1099;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
          try {
            getSchool$val$1099 = sbr.getSchool ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSchool$val$1099 = sbr.getSchool ();
        }
// 138
        JP.go.ipa.oz.lib.standard._String_if asString$val$1100;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fName)) {
          try {
            asString$val$1100 = fName.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$1100 = fName.asString ();
        }
// 138
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSchool$val$1099)) {
          try {
            getSchool$val$1099.loadFromFile (asString$val$1100, subjectName);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSchool$val$1099.loadFromFile (asString$val$1100, subjectName);
        }
// 140
        JP.go.ipa.oz.lib.standard._Choice_if getChoSubject$val$1101;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
          try {
            getChoSubject$val$1101 = sbr.getChoSubject ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getChoSubject$val$1101 = sbr.getChoSubject ();
        }
// 140
        JP.go.ipa.oz.lib.standard._String_if getSelectedItem$val$1102;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getChoSubject$val$1101)) {
          try {
            getSelectedItem$val$1102 = getChoSubject$val$1101.getSelectedItem ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSelectedItem$val$1102 = getChoSubject$val$1101.getSelectedItem ();
        }
// 140
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sbr)) {
          try {
            sbr.setSchoolList (getSelectedItem$val$1102);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          sbr.setSchoolList (getSelectedItem$val$1102);
        }
      }
    }
  }
  
  public SBController_cl () throws Exception { super (); }
  
}


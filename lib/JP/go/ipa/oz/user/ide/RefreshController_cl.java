package JP.go.ipa.oz.user.ide;

public class RefreshController_cl extends JP.go.ipa.oz.lib.standard._ActionListener_cl implements JP.go.ipa.oz.user.ide.RefreshController_if {
  JP.go.ipa.oz.user.ide.ProjectManager_if prj;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.ProjectManager_if p, JP.go.ipa.oz.lib.standard._EventDispatchingQueue_if q) throws Exception  {
// 26
    super._new_newActionListener (q);
// 27
    prj = p;
    return this;
  }
  
  public void actionPerformed (JP.go.ipa.oz.lib.standard._ActionEvent_if event) throws Exception  {
    checkSecureInvocation ();
// 38
    JP.go.ipa.oz.lib.standard._String_if getActionCommand$val$557;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) event)) {
      try {
        getActionCommand$val$557 = event.getActionCommand ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getActionCommand$val$557 = event.getActionCommand ();
    }
// 38
    JP.go.ipa.oz.lib.standard._String_if string$130 = (new JP.go.ipa.oz.lib.standard._String_cl("Refresh"));
    
// 38
    int compareTo$val$558;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getActionCommand$val$557)) {
      try {
        compareTo$val$558 = getActionCommand$val$557.compareTo (string$130);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      compareTo$val$558 = getActionCommand$val$557.compareTo (string$130);
    }
// 38
    if (compareTo$val$558 == 0) {{
        boolean bool$val$20;
        
// 39
        JP.go.ipa.oz.lib.standard._String_if getProjectDir$val$559;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
          try {
            getProjectDir$val$559 = prj.getProjectDir ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getProjectDir$val$559 = prj.getProjectDir ();
        }
        bool$val$20 = getProjectDir$val$559 == null;
        if (!bool$val$20) {
// 39
          JP.go.ipa.oz.lib.standard._String_if getProjectDir$val$560;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
            try {
              getProjectDir$val$560 = prj.getProjectDir ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getProjectDir$val$560 = prj.getProjectDir ();
          }
// 39
          JP.go.ipa.oz.lib.standard._String_if string$131 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
          
// 39
          int compareTo$val$561;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getProjectDir$val$560)) {
            try {
              compareTo$val$561 = getProjectDir$val$560.compareTo (string$131);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            compareTo$val$561 = getProjectDir$val$560.compareTo (string$131);
          }
          bool$val$20 = compareTo$val$561 == 0;
        }
// 39
        if (bool$val$20) {
// 39
          return;
        }
// 40
        JP.go.ipa.oz.lib.standard._List_if getSrcList$val$562;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
          try {
            getSrcList$val$562 = prj.getSrcList ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSrcList$val$562 = prj.getSrcList ();
        }
// 40
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSrcList$val$562)) {
          try {
            getSrcList$val$562.removeAll ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSrcList$val$562.removeAll ();
        }
// 41
        JP.go.ipa.oz.lib.standard._Dictionary_if getProjects$val$563;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
          try {
            getProjects$val$563 = prj.getProjects ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getProjects$val$563 = prj.getProjects ();
        }
// 41
        JP.go.ipa.oz.lib.standard._Dictionary_if dict = getProjects$val$563;
// 42
        JP.go.ipa.oz.lib.standard._String_if projectName = null;
// 43
        JP.go.ipa.oz.lib.standard._String_if getProjectName$val$564;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
          try {
            getProjectName$val$564 = prj.getProjectName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getProjectName$val$564 = prj.getProjectName ();
        }
// 43
        projectName = getProjectName$val$564;
// 44
        JP.go.ipa.oz.user.ide.Project_if project = null;
// 45
        JP.go.ipa.oz.lang._Root_if get$val$565;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dict)) {
          try {
            get$val$565 = dict.get (projectName);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          get$val$565 = dict.get (projectName);
        }
// 45
        project = (JP.go.ipa.oz.user.ide.Project_if) (get$val$565);
// 46
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) project)) {
          try {
            project.removeAllFiles ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          project.removeAllFiles ();
        }
// 48
        JP.go.ipa.oz.lib.standard._Array_if fileList = null;
// 49
        JP.go.ipa.oz.lib.standard._String_if getProjectDir$val$566;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) project)) {
          try {
            getProjectDir$val$566 = project.getProjectDir ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getProjectDir$val$566 = project.getProjectDir ();
        }
// 49
        JP.go.ipa.oz.lib.standard._File_if file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (getProjectDir$val$566);
// 50
        JP.go.ipa.oz.user.ide.ExtensionFilter_if filter = (JP.go.ipa.oz.user.ide.ExtensionFilter_cl) (new JP.go.ipa.oz.user.ide.ExtensionFilter_cl ())._new_create ((new JP.go.ipa.oz.lib.standard._String_cl(".oz")));
// 51
        JP.go.ipa.oz.lib.standard._Array_if list$val$567;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) file)) {
          try {
            list$val$567 = file.list (filter);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          list$val$567 = file.list (filter);
        }
// 51
        fileList = list$val$567;
// 52
        if (fileList == null) {
// 52
          return;
        }
// 53
        JP.go.ipa.oz.lib.standard._String_if tmp = null;
// 54
        int max = 0;
// 55
        int size$val$568;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
          try {
            size$val$568 = fileList.size ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          size$val$568 = fileList.size ();
        }
// 55
        max = size$val$568;
// 56
        /* for loop starting here */ {
          /* initialization part */
          int i = 0;
          
          for (;;) {
            /* boolean expression part */
            if (!(i < max)) break;
            
            /* body */ _loop_1: {
// 57
              JP.go.ipa.oz.lang._Root_if at$val$569;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileList)) {
                try {
                  at$val$569 = fileList.at (i);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                at$val$569 = fileList.at (i);
              }
// 57
              tmp = (JP.go.ipa.oz.lib.standard._String_if) (at$val$569);
// 58
              JP.go.ipa.oz.lib.standard._String_if string$132 = (new JP.go.ipa.oz.lib.standard._String_cl("_cl.oz"));
              
// 58
              boolean endsWith$val$570;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                try {
                  endsWith$val$570 = tmp.endsWith (string$132);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                endsWith$val$570 = tmp.endsWith (string$132);
              }
// 58
              if (!(endsWith$val$570)) {{
// 59
                  JP.go.ipa.oz.lib.standard._List_if getSrcList$val$571;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) prj)) {
                    try {
                      getSrcList$val$571 = prj.getSrcList ();
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    getSrcList$val$571 = prj.getSrcList ();
                  }
// 59
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getSrcList$val$571)) {
                    try {
                      getSrcList$val$571.addItem (tmp);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    getSrcList$val$571.addItem (tmp);
                  }
// 60
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) project)) {
                    try {
                      project.addFile (tmp);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    project.addFile (tmp);
                  }
                }
              }
            }
            /* iteration part */
// 56
            i++;
          }
        }
      }
    }
  }
  
  public RefreshController_cl () throws Exception { super (); }
  
}


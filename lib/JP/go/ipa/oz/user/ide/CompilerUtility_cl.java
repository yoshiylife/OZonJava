package JP.go.ipa.oz.user.ide;

public class CompilerUtility_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.CompilerUtility_if {
  JP.go.ipa.oz.user.ide.School_if school;
  JP.go.ipa.oz.user.ide.ClassBrowser_if classBrowser;
  
  public Object _new_create (JP.go.ipa.oz.user.ide.School_if sc, JP.go.ipa.oz.user.ide.ClassBrowser_if cb) throws Exception  {
// 43
    classBrowser = cb;
// 44
    school = sc;
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if getInstanciatedCID (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
    checkSecureInvocation ();
// 86
    JP.go.ipa.oz.lib.standard._String_if subjectName = null, labelName = null, tmp = null, tmpCID = null;
// 87
    subjectName = getSubjectName (cid);
// 88
    JP.go.ipa.oz.lib.standard._String_if string$79 = (new JP.go.ipa.oz.lib.standard._String_cl("_"));
    
// 88
    int lastIndexOf$val$256;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
      try {
        lastIndexOf$val$256 = cid.lastIndexOf (string$79);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$256 = cid.lastIndexOf (string$79);
    }
// 88
    JP.go.ipa.oz.lib.standard._String_if substring$val$257;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
      try {
        substring$val$257 = cid.substring (0, lastIndexOf$val$256);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$257 = cid.substring (0, lastIndexOf$val$256);
    }
// 88
    tmpCID = substring$val$257;
// 90
    JP.go.ipa.oz.user.ide.OzLabel_if label = null;
// 91
    JP.go.ipa.oz.lib.standard._Dictionary_if getOzLabels$val$258;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        getOzLabels$val$258 = school.getOzLabels ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabels$val$258 = school.getOzLabels ();
    }
// 91
    JP.go.ipa.oz.lib.standard._Dictionary_if labels = getOzLabels$val$258;
// 92
    JP.go.ipa.oz.lib.standard._Set_if cids = null, results = null;
// 93
    JP.go.ipa.oz.lib.standard._StringComparator_if sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 94
    results = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (sc);
// 95
    JP.go.ipa.oz.lib.standard._Iterator_if labelItr = null, itr = null;
// 96
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$259;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labels)) {
      try {
        iterator$val$259 = labels.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$259 = labels.iterator ();
    }
// 96
    labelItr = iterator$val$259;
// 97
    while (true) {
// 97
      boolean hasMoreElements$val$260;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labelItr)) {
        try {
          hasMoreElements$val$260 = labelItr.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$260 = labelItr.hasMoreElements ();
      }
      if (!(hasMoreElements$val$260)) break;
      
      /* body */ _loop_1: {
// 98
        JP.go.ipa.oz.lang._Root_if nextElement$val$261;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labelItr)) {
          try {
            nextElement$val$261 = labelItr.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$261 = labelItr.nextElement ();
        }
// 98
        label = (JP.go.ipa.oz.user.ide.OzLabel_if) (nextElement$val$261);
// 99
        JP.go.ipa.oz.lib.standard._String_if getImplementationID$val$262;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) label)) {
          try {
            getImplementationID$val$262 = label.getImplementationID ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getImplementationID$val$262 = label.getImplementationID ();
        }
// 99
        labelName = getImplementationID$val$262;
// 100
        boolean startsWith$val$263;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labelName)) {
          try {
            startsWith$val$263 = labelName.startsWith (subjectName);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          startsWith$val$263 = labelName.startsWith (subjectName);
        }
// 100
        if (startsWith$val$263) {{
// 101
            JP.go.ipa.oz.lib.standard._String_if getOzLabelName$val$264;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) label)) {
              try {
                getOzLabelName$val$264 = label.getOzLabelName ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getOzLabelName$val$264 = label.getOzLabelName ();
            }
// 101
            JP.go.ipa.oz.lib.standard._String_if getImplementationID$val$265;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
              try {
                getImplementationID$val$265 = school.getImplementationID (getOzLabelName$val$264);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getImplementationID$val$265 = school.getImplementationID (getOzLabelName$val$264);
            }
// 101
            labelName = getImplementationID$val$265;
// 102
            JP.go.ipa.oz.lib.standard._Collection_if getInstantiatingCIDsOf$val$266;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classBrowser)) {
              try {
                getInstantiatingCIDsOf$val$266 = classBrowser.getInstantiatingCIDsOf (labelName);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getInstantiatingCIDsOf$val$266 = classBrowser.getInstantiatingCIDsOf (labelName);
            }
// 102
            cids = (JP.go.ipa.oz.lib.standard._Set_if) (getInstantiatingCIDsOf$val$266);
// 103
            JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$267;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cids)) {
              try {
                iterator$val$267 = cids.iterator ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              iterator$val$267 = cids.iterator ();
            }
// 103
            itr = iterator$val$267;
// 104
            while (true) {
// 104
              boolean hasMoreElements$val$268;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
                try {
                  hasMoreElements$val$268 = itr.hasMoreElements ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                hasMoreElements$val$268 = itr.hasMoreElements ();
              }
              if (!(hasMoreElements$val$268)) break;
              
              /* body */ _loop_2: {
// 105
                JP.go.ipa.oz.lang._Root_if nextElement$val$269;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
                  try {
                    nextElement$val$269 = itr.nextElement ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  nextElement$val$269 = itr.nextElement ();
                }
// 105
                tmp = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$269);
// 106
                JP.go.ipa.oz.lib.standard._String_if string$80 = (new JP.go.ipa.oz.lib.standard._String_cl("_"));
                
// 106
                int lastIndexOf$val$270;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                  try {
                    lastIndexOf$val$270 = tmp.lastIndexOf (string$80);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  lastIndexOf$val$270 = tmp.lastIndexOf (string$80);
                }
// 106
                JP.go.ipa.oz.lib.standard._String_if substring$val$271;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                  try {
                    substring$val$271 = tmp.substring (0, lastIndexOf$val$270);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  substring$val$271 = tmp.substring (0, lastIndexOf$val$270);
                }
// 106
                tmp = substring$val$271;
// 107
                int compareTo$val$272;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                  try {
                    compareTo$val$272 = tmp.compareTo (tmpCID);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  compareTo$val$272 = tmp.compareTo (tmpCID);
                }
// 107
                if (compareTo$val$272 == 0) {{
// 108
                    results.add (labelName);
                  }
                }
              }
            }
          }
        }
      }
    }
// 113
    return results;
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if getDescendantCID (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
    checkSecureInvocation ();
// 119
    JP.go.ipa.oz.lib.standard._String_if subjectName = null, labelName = null, tmp = null, tmpCID = null;
// 120
    subjectName = getSubjectName (cid);
// 121
    JP.go.ipa.oz.lib.standard._String_if string$81 = (new JP.go.ipa.oz.lib.standard._String_cl("_"));
    
// 121
    int lastIndexOf$val$273;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
      try {
        lastIndexOf$val$273 = cid.lastIndexOf (string$81);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$273 = cid.lastIndexOf (string$81);
    }
// 121
    JP.go.ipa.oz.lib.standard._String_if substring$val$274;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
      try {
        substring$val$274 = cid.substring (0, lastIndexOf$val$273);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$274 = cid.substring (0, lastIndexOf$val$273);
    }
// 121
    tmpCID = substring$val$274;
// 122
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 124
    JP.go.ipa.oz.user.ide.OzLabel_if label = null;
// 125
    JP.go.ipa.oz.lib.standard._Dictionary_if getOzLabels$val$275;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        getOzLabels$val$275 = school.getOzLabels ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabels$val$275 = school.getOzLabels ();
    }
// 125
    JP.go.ipa.oz.lib.standard._Dictionary_if labels = getOzLabels$val$275;
// 126
    JP.go.ipa.oz.lib.standard._Set_if cids = null, results = null;
// 127
    JP.go.ipa.oz.lib.standard._StringComparator_if sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 128
    results = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (sc);
// 129
    JP.go.ipa.oz.lib.standard._Iterator_if labelItr = null, itr = null;
// 130
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$276;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labels)) {
      try {
        iterator$val$276 = labels.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$276 = labels.iterator ();
    }
// 130
    labelItr = iterator$val$276;
// 131
    while (true) {
// 131
      boolean hasMoreElements$val$277;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labelItr)) {
        try {
          hasMoreElements$val$277 = labelItr.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$277 = labelItr.hasMoreElements ();
      }
      if (!(hasMoreElements$val$277)) break;
      
      /* body */ _loop_1: {
// 132
        JP.go.ipa.oz.lang._Root_if nextElement$val$278;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labelItr)) {
          try {
            nextElement$val$278 = labelItr.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$278 = labelItr.nextElement ();
        }
// 132
        label = (JP.go.ipa.oz.user.ide.OzLabel_if) (nextElement$val$278);
// 133
        JP.go.ipa.oz.lib.standard._String_if getImplementationID$val$279;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) label)) {
          try {
            getImplementationID$val$279 = label.getImplementationID ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getImplementationID$val$279 = label.getImplementationID ();
        }
// 133
        labelName = getImplementationID$val$279;
// 134
        boolean startsWith$val$280;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labelName)) {
          try {
            startsWith$val$280 = labelName.startsWith (subjectName);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          startsWith$val$280 = labelName.startsWith (subjectName);
        }
// 134
        if (startsWith$val$280) {{
// 135
            JP.go.ipa.oz.lib.standard._String_if getOzLabelName$val$281;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) label)) {
              try {
                getOzLabelName$val$281 = label.getOzLabelName ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getOzLabelName$val$281 = label.getOzLabelName ();
            }
// 135
            JP.go.ipa.oz.lib.standard._String_if getImplementationID$val$282;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
              try {
                getImplementationID$val$282 = school.getImplementationID (getOzLabelName$val$281);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getImplementationID$val$282 = school.getImplementationID (getOzLabelName$val$281);
            }
// 135
            labelName = getImplementationID$val$282;
// 136
            JP.go.ipa.oz.lib.standard._Collection_if getAncestorCIDsOf$val$283;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classBrowser)) {
              try {
                getAncestorCIDsOf$val$283 = classBrowser.getAncestorCIDsOf (labelName);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getAncestorCIDsOf$val$283 = classBrowser.getAncestorCIDsOf (labelName);
            }
// 136
            cids = (JP.go.ipa.oz.lib.standard._Set_if) (getAncestorCIDsOf$val$283);
// 137
            JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$284;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cids)) {
              try {
                iterator$val$284 = cids.iterator ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              iterator$val$284 = cids.iterator ();
            }
// 137
            itr = iterator$val$284;
// 138
            while (true) {
// 138
              boolean hasMoreElements$val$285;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
                try {
                  hasMoreElements$val$285 = itr.hasMoreElements ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                hasMoreElements$val$285 = itr.hasMoreElements ();
              }
              if (!(hasMoreElements$val$285)) break;
              
              /* body */ _loop_2: {
// 139
                JP.go.ipa.oz.lang._Root_if nextElement$val$286;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
                  try {
                    nextElement$val$286 = itr.nextElement ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  nextElement$val$286 = itr.nextElement ();
                }
// 139
                tmp = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$286);
// 140
                JP.go.ipa.oz.lib.standard._String_if string$82 = (new JP.go.ipa.oz.lib.standard._String_cl("_"));
                
// 140
                int lastIndexOf$val$287;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                  try {
                    lastIndexOf$val$287 = tmp.lastIndexOf (string$82);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  lastIndexOf$val$287 = tmp.lastIndexOf (string$82);
                }
// 140
                JP.go.ipa.oz.lib.standard._String_if substring$val$288;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                  try {
                    substring$val$288 = tmp.substring (0, lastIndexOf$val$287);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  substring$val$288 = tmp.substring (0, lastIndexOf$val$287);
                }
// 140
                tmp = substring$val$288;
// 141
                int compareTo$val$289;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                  try {
                    compareTo$val$289 = tmp.compareTo (tmpCID);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  compareTo$val$289 = tmp.compareTo (tmpCID);
                }
// 141
                if (compareTo$val$289 == 0) {{
// 142
                    results.add (labelName);
// 143
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                      try {
                        system.println (labelName);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      system.println (labelName);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
// 148
    return results;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if replace (JP.go.ipa.oz.lib.standard._String_if target, JP.go.ipa.oz.lib.standard._String_if oldString, JP.go.ipa.oz.lib.standard._String_if newString) throws Exception  {
    checkSecureInvocation ();
// 154
    int length$val$290;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) target)) {
      try {
        length$val$290 = target.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$290 = target.length ();
    }
// 154
    int lenTarget = length$val$290;
// 155
    int length$val$291;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) oldString)) {
      try {
        length$val$291 = oldString.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$291 = oldString.length ();
    }
// 155
    int lenOld = length$val$291;
// 156
    JP.go.ipa.oz.lib.standard._StringBuffer_if tmpString = null;
// 157
    /* for loop starting here */ {
      /* initialization part */
      int i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < lenTarget - lenOld + 1)) break;
        
        /* body */ _loop_1: {
// 158
          JP.go.ipa.oz.lib.standard._String_if substring$val$292;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) target)) {
            try {
              substring$val$292 = target.substring (i, i + lenOld);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            substring$val$292 = target.substring (i, i + lenOld);
          }
// 158
          int compareTo$val$293;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) (substring$val$292))) {
            try {
              compareTo$val$293 = (substring$val$292).compareTo (oldString);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            compareTo$val$293 = (substring$val$292).compareTo (oldString);
          }
// 158
          if (compareTo$val$293 == 0) {{
// 159
              JP.go.ipa.oz.lib.standard._String_if substring$val$294;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) target)) {
                try {
                  substring$val$294 = target.substring (0, i);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                substring$val$294 = target.substring (0, i);
              }
// 159
              tmpString = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (substring$val$294);
// 160
              tmpString.append (newString);
// 161
              if (lenTarget >= i + lenOld) {
// 162
                JP.go.ipa.oz.lib.standard._String_if substring$val$295;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) target)) {
                  try {
                    substring$val$295 = target.substring (i + lenOld);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  substring$val$295 = target.substring (i + lenOld);
                }
// 162
                tmpString.append (substring$val$295);
              }
// 163
              return tmpString.asString ();
            }
          }
        }
        /* iteration part */
// 157
        i++;
      }
    }
// 166
    return target;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getSubjectName (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
    checkSecureInvocation ();
// 172
    JP.go.ipa.oz.lib.standard._String_if subjectName = null;
// 173
    JP.go.ipa.oz.lib.standard._String_if string$83 = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.user.released."));
    
// 173
    boolean startsWith$val$296;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
      try {
        startsWith$val$296 = cid.startsWith (string$83);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$296 = cid.startsWith (string$83);
    }
// 173
    if (startsWith$val$296) {
// 174
      subjectName = replace (cid, (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.user.released.")), (new JP.go.ipa.oz.lib.standard._String_cl("")));
    } else {
// 175
      JP.go.ipa.oz.lib.standard._String_if string$84 = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.user."));
      
// 175
      boolean startsWith$val$297;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
        try {
          startsWith$val$297 = cid.startsWith (string$84);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        startsWith$val$297 = cid.startsWith (string$84);
      }
// 175
      if (startsWith$val$297) {
// 176
        subjectName = replace (cid, (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.user.")), (new JP.go.ipa.oz.lib.standard._String_cl("")));
      }
    }
// 177
    JP.go.ipa.oz.lib.standard._String_if string$85 = (new JP.go.ipa.oz.lib.standard._String_cl("."));
    
// 177
    int lastIndexOf$val$298;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjectName)) {
      try {
        lastIndexOf$val$298 = subjectName.lastIndexOf (string$85);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$298 = subjectName.lastIndexOf (string$85);
    }
// 177
    JP.go.ipa.oz.lib.standard._String_if substring$val$299;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subjectName)) {
      try {
        substring$val$299 = subjectName.substring (0, lastIndexOf$val$298);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$299 = subjectName.substring (0, lastIndexOf$val$298);
    }
// 177
    subjectName = substring$val$299;
// 178
    return subjectName;
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if getReferedCID (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
    checkSecureInvocation ();
// 53
    JP.go.ipa.oz.lib.standard._String_if subjectName = null, labelName = null, tmp = null, tmpCID = null;
// 54
    subjectName = getSubjectName (cid);
// 55
    JP.go.ipa.oz.lib.standard._String_if string$86 = (new JP.go.ipa.oz.lib.standard._String_cl("_"));
    
// 55
    int lastIndexOf$val$300;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
      try {
        lastIndexOf$val$300 = cid.lastIndexOf (string$86);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$300 = cid.lastIndexOf (string$86);
    }
// 55
    JP.go.ipa.oz.lib.standard._String_if substring$val$301;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
      try {
        substring$val$301 = cid.substring (0, lastIndexOf$val$300);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$301 = cid.substring (0, lastIndexOf$val$300);
    }
// 55
    tmpCID = substring$val$301;
// 57
    JP.go.ipa.oz.user.ide.OzLabel_if label = null;
// 58
    JP.go.ipa.oz.lib.standard._Dictionary_if getOzLabels$val$302;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
      try {
        getOzLabels$val$302 = school.getOzLabels ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzLabels$val$302 = school.getOzLabels ();
    }
// 58
    JP.go.ipa.oz.lib.standard._Dictionary_if labels = getOzLabels$val$302;
// 59
    JP.go.ipa.oz.lib.standard._Set_if cids = null, results = null;
// 60
    JP.go.ipa.oz.lib.standard._StringComparator_if sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 61
    results = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (sc);
// 62
    JP.go.ipa.oz.lib.standard._Iterator_if labelItr = null, itr = null;
// 63
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$303;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labels)) {
      try {
        iterator$val$303 = labels.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$303 = labels.iterator ();
    }
// 63
    labelItr = iterator$val$303;
// 64
    while (true) {
// 64
      boolean hasMoreElements$val$304;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labelItr)) {
        try {
          hasMoreElements$val$304 = labelItr.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$304 = labelItr.hasMoreElements ();
      }
      if (!(hasMoreElements$val$304)) break;
      
      /* body */ _loop_1: {
// 65
        JP.go.ipa.oz.lang._Root_if nextElement$val$305;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labelItr)) {
          try {
            nextElement$val$305 = labelItr.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$305 = labelItr.nextElement ();
        }
// 65
        label = (JP.go.ipa.oz.user.ide.OzLabel_if) (nextElement$val$305);
// 66
        JP.go.ipa.oz.lib.standard._String_if getImplementationID$val$306;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) label)) {
          try {
            getImplementationID$val$306 = label.getImplementationID ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getImplementationID$val$306 = label.getImplementationID ();
        }
// 66
        labelName = getImplementationID$val$306;
// 67
        boolean startsWith$val$307;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) labelName)) {
          try {
            startsWith$val$307 = labelName.startsWith (subjectName);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          startsWith$val$307 = labelName.startsWith (subjectName);
        }
// 67
        if (startsWith$val$307) {{
// 68
            JP.go.ipa.oz.lib.standard._String_if getOzLabelName$val$308;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) label)) {
              try {
                getOzLabelName$val$308 = label.getOzLabelName ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getOzLabelName$val$308 = label.getOzLabelName ();
            }
// 68
            JP.go.ipa.oz.lib.standard._String_if getImplementationID$val$309;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
              try {
                getImplementationID$val$309 = school.getImplementationID (getOzLabelName$val$308);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getImplementationID$val$309 = school.getImplementationID (getOzLabelName$val$308);
            }
// 68
            labelName = getImplementationID$val$309;
// 69
            JP.go.ipa.oz.lib.standard._Collection_if getReferingCIDsOf$val$310;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) classBrowser)) {
              try {
                getReferingCIDsOf$val$310 = classBrowser.getReferingCIDsOf (labelName);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getReferingCIDsOf$val$310 = classBrowser.getReferingCIDsOf (labelName);
            }
// 69
            cids = (JP.go.ipa.oz.lib.standard._Set_if) (getReferingCIDsOf$val$310);
// 70
            JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$311;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cids)) {
              try {
                iterator$val$311 = cids.iterator ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              iterator$val$311 = cids.iterator ();
            }
// 70
            itr = iterator$val$311;
// 71
            while (true) {
// 71
              boolean hasMoreElements$val$312;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
                try {
                  hasMoreElements$val$312 = itr.hasMoreElements ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                hasMoreElements$val$312 = itr.hasMoreElements ();
              }
              if (!(hasMoreElements$val$312)) break;
              
              /* body */ _loop_2: {
// 72
                JP.go.ipa.oz.lang._Root_if nextElement$val$313;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
                  try {
                    nextElement$val$313 = itr.nextElement ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  nextElement$val$313 = itr.nextElement ();
                }
// 72
                tmp = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$313);
// 73
                JP.go.ipa.oz.lib.standard._String_if string$87 = (new JP.go.ipa.oz.lib.standard._String_cl("_"));
                
// 73
                int lastIndexOf$val$314;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                  try {
                    lastIndexOf$val$314 = tmp.lastIndexOf (string$87);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  lastIndexOf$val$314 = tmp.lastIndexOf (string$87);
                }
// 73
                JP.go.ipa.oz.lib.standard._String_if substring$val$315;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                  try {
                    substring$val$315 = tmp.substring (0, lastIndexOf$val$314);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  substring$val$315 = tmp.substring (0, lastIndexOf$val$314);
                }
// 73
                tmp = substring$val$315;
// 74
                int compareTo$val$316;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tmp)) {
                  try {
                    compareTo$val$316 = tmp.compareTo (tmpCID);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  compareTo$val$316 = tmp.compareTo (tmpCID);
                }
// 74
                if (compareTo$val$316 == 0) {{
// 75
                    results.add (labelName);
                  }
                }
              }
            }
          }
        }
      }
    }
// 80
    return results;
  }
  
  public CompilerUtility_cl () throws Exception { super (); }
  
}


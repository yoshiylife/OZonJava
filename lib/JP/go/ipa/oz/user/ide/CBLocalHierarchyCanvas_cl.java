package JP.go.ipa.oz.user.ide;

final public class CBLocalHierarchyCanvas_cl extends JP.go.ipa.oz.lib.standard._Canvas_cl implements JP.go.ipa.oz.user.ide.CBLocalHierarchyCanvas_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.lib.standard._Array_if levelList;
  boolean notPositioned;
  int hSpace;
  JP.go.ipa.oz.lib.standard._Color_if classLabelColor;
  JP.go.ipa.oz.lib.standard._PaintDispatchingQueue_if pq;
  JP.go.ipa.oz.user.ide.CBIGraph_if graph;
  JP.go.ipa.oz.lib.standard._System_if system;
  int vSpace;
  int fontHeight;
  JP.go.ipa.oz.lib.standard._Insets_if boxInsets;
  JP.go.ipa.oz.lib.standard._Array_if levelWidthList;
  JP.go.ipa.oz.lib.standard._Insets_if areaInsets;
  JP.go.ipa.oz.lib.standard._Color_if classBoxColor;
  
  public Object _new_newCBLocalHierarchyCanvas (JP.go.ipa.oz.user.ide.CBIGraph_if g) throws Exception  {
// 33
    pq = (JP.go.ipa.oz.lib.standard._PaintDispatchingQueue_cl) (new JP.go.ipa.oz.lib.standard._PaintDispatchingQueue_cl ())._new_create ();
// 34
    super._new_newCanvas (pq);
// 36
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 37
    JP.go.ipa.oz.lib.standard._String_if string$19 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCBLocalHierarchyCanvas#new"));
    
// 37
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.debugPrintln (string$19);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.debugPrintln (string$19);
    }
// 39
    initParams (g);
// 40
    initGUI ();
    return this;
  }
  
  void initParams (JP.go.ipa.oz.user.ide.CBIGraph_if g) throws Exception  {
// 121
    JP.go.ipa.oz.lib.standard._String_if string$20 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCBLocalHierarchyCanvas#initParams"));
    
// 121
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.debugPrintln (string$20);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.debugPrintln (string$20);
    }
// 122
    graph = g;
// 123
    areaInsets = (JP.go.ipa.oz.lib.standard._Insets_cl) (new JP.go.ipa.oz.lib.standard._Insets_cl ())._new_newInsets (10, 10, 10, 10);
// 124
    boxInsets = (JP.go.ipa.oz.lib.standard._Insets_cl) (new JP.go.ipa.oz.lib.standard._Insets_cl ())._new_newInsets (2, 4, 4, 4);
// 125
    vSpace = 20;
// 126
    hSpace = 50;
// 127
    notPositioned = true;
  }
  
  void mkPositions (JP.go.ipa.oz.lib.standard._FontMetrics_if fm) throws Exception  {
// 195
    JP.go.ipa.oz.lib.standard._Collection_if list = null;
// 196
    JP.go.ipa.oz.user.ide.CBIGraphNode_if node = null;
// 197
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 198
    int boxLeft = 0, boxTop = 0, boxWidth = 0, boxHeight = 0, yMax = 0, vStep = 0;
// 199
    int nNodes = 0, nLevels = 0, level = 0;
// 200
    int index = 0;
// 201
    JP.go.ipa.oz.lib.standard._Integer_if maxWidthObj = null;
// 203
    JP.go.ipa.oz.lib.standard._String_if string$21 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCBLocalHierarchyCanvas#mkPositions"));
    
// 203
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.debugPrintln (string$21);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.debugPrintln (string$21);
    }
// 205
    mkLevels (fm);
// 207
    int getHeight$val$149;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fm)) {
      try {
        getHeight$val$149 = fm.getHeight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getHeight$val$149 = fm.getHeight ();
    }
// 207
    fontHeight = getHeight$val$149;
// 209
    int getLeft$val$150;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) areaInsets)) {
      try {
        getLeft$val$150 = areaInsets.getLeft ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getLeft$val$150 = areaInsets.getLeft ();
    }
// 209
    boxLeft = getLeft$val$150;
// 210
    int getTop$val$151;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) boxInsets)) {
      try {
        getTop$val$151 = boxInsets.getTop ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getTop$val$151 = boxInsets.getTop ();
    }
// 210
    int getBottom$val$152;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) boxInsets)) {
      try {
        getBottom$val$152 = boxInsets.getBottom ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBottom$val$152 = boxInsets.getBottom ();
    }
// 210
    boxHeight = fontHeight + getTop$val$151 + getBottom$val$152;
// 211
    vStep = boxHeight + vSpace;
// 212
    int size$val$153;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) levelList)) {
      try {
        size$val$153 = levelList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$153 = levelList.size ();
    }
// 212
    nLevels = size$val$153;
// 213
    /* for loop starting here */ {
      /* initialization part */
// 213
      level = nLevels - 1;
      
      for (;;) {
        /* boolean expression part */
        if (!(level >= 0)) break;
        
        /* body */ _loop_1: {
// 214
          JP.go.ipa.oz.lang._Root_if at$val$154;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) levelList)) {
            try {
              at$val$154 = levelList.at (level);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            at$val$154 = levelList.at (level);
          }
// 214
          list = (JP.go.ipa.oz.lib.standard._Collection_if) (at$val$154);
// 215
          JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$155;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
            try {
              iterator$val$155 = list.iterator ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            iterator$val$155 = list.iterator ();
          }
// 215
          itr = iterator$val$155;
// 216
          JP.go.ipa.oz.lang._Root_if at$val$156;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) levelWidthList)) {
            try {
              at$val$156 = levelWidthList.at (level);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            at$val$156 = levelWidthList.at (level);
          }
// 216
          maxWidthObj = (JP.go.ipa.oz.lib.standard._Integer_if) (at$val$156);
// 217
          int intValue$val$157;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) maxWidthObj)) {
            try {
              intValue$val$157 = maxWidthObj.intValue ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            intValue$val$157 = maxWidthObj.intValue ();
          }
// 217
          boxWidth = intValue$val$157;
// 218
          int getTop$val$158;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) areaInsets)) {
            try {
              getTop$val$158 = areaInsets.getTop ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getTop$val$158 = areaInsets.getTop ();
          }
// 218
          boxTop = getTop$val$158;
// 219
          yMax = 0;
// 220
          while (true) {
// 220
            boolean hasMoreElements$val$159;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
              try {
                hasMoreElements$val$159 = itr.hasMoreElements ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              hasMoreElements$val$159 = itr.hasMoreElements ();
            }
            if (!(hasMoreElements$val$159)) break;
            
            /* body */ _loop_2: {
// 221
              JP.go.ipa.oz.lang._Root_if nextElement$val$160;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
                try {
                  nextElement$val$160 = itr.nextElement ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                nextElement$val$160 = itr.nextElement ();
              }
// 221
              node = (JP.go.ipa.oz.user.ide.CBIGraphNode_if) (nextElement$val$160);
// 222
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) node)) {
                try {
                  node.setBounds (boxLeft, boxTop, boxWidth, boxHeight);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                node.setBounds (boxLeft, boxTop, boxWidth, boxHeight);
              }
// 223
              boxTop += vStep;
            }
          }
// 226
          if (yMax < (boxTop + boxHeight)) {{
// 227
              yMax = boxTop + boxHeight;
            }
          }
// 229
          boolean isEmpty$val$161;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
            try {
              isEmpty$val$161 = list.isEmpty ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            isEmpty$val$161 = list.isEmpty ();
          }
// 229
          if (!(isEmpty$val$161)) {{
// 230
              boxLeft += (boxWidth + hSpace);
            }
          }
        }
        /* iteration part */
// 213
        level--;
      }
    }
// 234
    int getRight$val$162;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) areaInsets)) {
      try {
        getRight$val$162 = areaInsets.getRight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getRight$val$162 = areaInsets.getRight ();
    }
// 235
    int getBottom$val$163;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) areaInsets)) {
      try {
        getBottom$val$163 = areaInsets.getBottom ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBottom$val$163 = areaInsets.getBottom ();
    }
// 234
    setSize (boxLeft + (getRight$val$162), yMax + (getBottom$val$163));
// 237
    notPositioned = false;
  }
  
  public void paint (JP.go.ipa.oz.lib.standard._Graphics_if g) throws Exception  {
    checkSecureInvocation ();
// 50
    if (notPositioned) {{
// 51
        JP.go.ipa.oz.lib.standard._FontMetrics_if fm = null;
// 52
        JP.go.ipa.oz.lib.standard._FontMetrics_if getFontMetrics$val$164;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) g)) {
          try {
            getFontMetrics$val$164 = g.getFontMetrics ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getFontMetrics$val$164 = g.getFontMetrics ();
        }
// 52
        fm = getFontMetrics$val$164;
// 53
        mkPositions (fm);
      }
    }
// 56
    drawHierarchy (g);
  }
  
  void mkLevels (JP.go.ipa.oz.lib.standard._FontMetrics_if fm) throws Exception  {
// 137
    JP.go.ipa.oz.lib.standard._SList_if list = null, nextList = null, oldList = null;
// 138
    JP.go.ipa.oz.user.ide.CBIGraphNode_if node = null, superNode = null;
// 139
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null, itrSuper = null;
// 140
    int level = 0;
// 141
    int maxWidth = 0, width = 0, hBoxInsets = 0;
// 142
    JP.go.ipa.oz.lib.standard._Integer_if maxWidthObj = null;
// 144
    JP.go.ipa.oz.lib.standard._String_if string$22 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCBLocalHierarchyCanvas#mkLevels"));
    
// 144
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.debugPrintln (string$22);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.debugPrintln (string$22);
    }
// 146
    int getLeft$val$165;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) boxInsets)) {
      try {
        getLeft$val$165 = boxInsets.getLeft ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getLeft$val$165 = boxInsets.getLeft ();
    }
// 146
    int getRight$val$166;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) boxInsets)) {
      try {
        getRight$val$166 = boxInsets.getRight ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getRight$val$166 = boxInsets.getRight ();
    }
// 146
    hBoxInsets = getLeft$val$165 + getRight$val$166;
// 148
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) graph)) {
      try {
        graph.clearMarks ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      graph.clearMarks ();
    }
// 149
    levelList = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (1);
// 150
    levelWidthList = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (1);
// 151
    JP.go.ipa.oz.user.ide.CBIGraphNode_if getPrimaryNode$val$167;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) graph)) {
      try {
        getPrimaryNode$val$167 = graph.getPrimaryNode ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getPrimaryNode$val$167 = graph.getPrimaryNode ();
    }
// 151
    node = getPrimaryNode$val$167;
// 152
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) node)) {
      try {
        node.setMark (true);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      node.setMark (true);
    }
// 153
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) node)) {
      try {
        node.setLevel (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      node.setLevel (0);
    }
// 154
    list = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create ();
// 155
    list.pushBack (node);
// 156
    JP.go.ipa.oz.lib.standard._String_if getLabelName$val$168;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) node)) {
      try {
        getLabelName$val$168 = node.getLabelName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getLabelName$val$168 = node.getLabelName ();
    }
// 156
    int stringWidth$val$169;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fm)) {
      try {
        stringWidth$val$169 = fm.stringWidth (getLabelName$val$168);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      stringWidth$val$169 = fm.stringWidth (getLabelName$val$168);
    }
// 156
    maxWidth = stringWidth$val$169 + hBoxInsets;
// 158
    /* for loop starting here */ {
      /* initialization part */
// 158
      level = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(!(list.isEmpty ()))) break;
        
        /* body */ _loop_1: {
// 159
          int size$val$170;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) levelList)) {
            try {
              size$val$170 = levelList.size ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            size$val$170 = levelList.size ();
          }
// 159
          if ((size$val$170) <= level) {{
// 160
              JP.go.ipa.oz.lib.standard._Array_if resize$val$171;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) levelList)) {
                try {
                  resize$val$171 = levelList.resize (level + 1);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                resize$val$171 = levelList.resize (level + 1);
              }
// 161
              JP.go.ipa.oz.lib.standard._Array_if resize$val$172;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) levelWidthList)) {
                try {
                  resize$val$172 = levelWidthList.resize (level + 1);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                resize$val$172 = levelWidthList.resize (level + 1);
              }
            }
          }
// 163
          JP.go.ipa.oz.lib.standard._Array_if putAt$val$173;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) levelList)) {
            try {
              putAt$val$173 = levelList.putAt (level, list);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            putAt$val$173 = levelList.putAt (level, list);
          }
// 164
          maxWidthObj = (JP.go.ipa.oz.lib.standard._Integer_cl) (new JP.go.ipa.oz.lib.standard._Integer_cl ())._new_breed (maxWidth);
// 165
          JP.go.ipa.oz.lib.standard._Array_if putAt$val$174;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) levelWidthList)) {
            try {
              putAt$val$174 = levelWidthList.putAt (level, maxWidthObj);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            putAt$val$174 = levelWidthList.putAt (level, maxWidthObj);
          }
// 166
          nextList = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create ();
// 167
          maxWidth = 0;
// 168
          itr = list.iterator ();
// 169
          while (true) {
// 169
            boolean hasMoreElements$val$175;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
              try {
                hasMoreElements$val$175 = itr.hasMoreElements ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              hasMoreElements$val$175 = itr.hasMoreElements ();
            }
            if (!(hasMoreElements$val$175)) break;
            
            /* body */ _loop_2: {
// 170
              JP.go.ipa.oz.lang._Root_if nextElement$val$176;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
                try {
                  nextElement$val$176 = itr.nextElement ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                nextElement$val$176 = itr.nextElement ();
              }
// 170
              node = (JP.go.ipa.oz.user.ide.CBIGraphNode_if) (nextElement$val$176);
// 171
              JP.go.ipa.oz.lib.standard._Iterator_if superNodes$val$177;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) node)) {
                try {
                  superNodes$val$177 = node.superNodes ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                superNodes$val$177 = node.superNodes ();
              }
// 171
              itrSuper = superNodes$val$177;
// 172
              while (true) {
// 172
                boolean hasMoreElements$val$178;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itrSuper)) {
                  try {
                    hasMoreElements$val$178 = itrSuper.hasMoreElements ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  hasMoreElements$val$178 = itrSuper.hasMoreElements ();
                }
                if (!(hasMoreElements$val$178)) break;
                
                /* body */ _loop_3: {
// 173
                  JP.go.ipa.oz.lang._Root_if nextElement$val$179;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itrSuper)) {
                    try {
                      nextElement$val$179 = itrSuper.nextElement ();
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    nextElement$val$179 = itrSuper.nextElement ();
                  }
// 173
                  superNode = (JP.go.ipa.oz.user.ide.CBIGraphNode_if) (nextElement$val$179);
// 174
                  boolean isMarked$val$180;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) superNode)) {
                    try {
                      isMarked$val$180 = superNode.isMarked ();
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    isMarked$val$180 = superNode.isMarked ();
                  }
// 174
                  if (isMarked$val$180) {{
// 175
                      int getLevel$val$181;
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) superNode)) {
                        try {
                          getLevel$val$181 = superNode.getLevel ();
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        getLevel$val$181 = superNode.getLevel ();
                      }
// 175
                      JP.go.ipa.oz.lang._Root_if at$val$182;
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) levelList)) {
                        try {
                          at$val$182 = levelList.at (getLevel$val$181);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        at$val$182 = levelList.at (getLevel$val$181);
                      }
// 175
                      oldList = (JP.go.ipa.oz.lib.standard._SList_if) (at$val$182);
// 176
                      JP.go.ipa.oz.lib.standard._Collection_if remove$val$183;
                      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) oldList)) {
                        try {
                          remove$val$183 = oldList.remove (superNode);
                        } finally {
                          changeRunningToGreen ();
                        }
                      } else {
                        remove$val$183 = oldList.remove (superNode);
                      }
                    }
                  }
// 178
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) superNode)) {
                    try {
                      superNode.setMark (true);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    superNode.setMark (true);
                  }
// 179
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) superNode)) {
                    try {
                      superNode.setLevel (level + 1);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    superNode.setLevel (level + 1);
                  }
// 180
                  nextList.pushBack (superNode);
// 181
                  JP.go.ipa.oz.lib.standard._String_if getLabelName$val$184;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) superNode)) {
                    try {
                      getLabelName$val$184 = superNode.getLabelName ();
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    getLabelName$val$184 = superNode.getLabelName ();
                  }
// 181
                  int stringWidth$val$185;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fm)) {
                    try {
                      stringWidth$val$185 = fm.stringWidth (getLabelName$val$184);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    stringWidth$val$185 = fm.stringWidth (getLabelName$val$184);
                  }
// 181
                  width = stringWidth$val$185 + hBoxInsets;
// 182
                  if (maxWidth < width) {{
// 183
                      maxWidth = width;
                    }
                  }
                }
              }
            }
          }
// 187
          list = nextList;
        }
        /* iteration part */
// 158
        level++;
      }
    }
  }
  
  void initGUI () throws Exception  {
// 107
    JP.go.ipa.oz.lib.standard._Color_if bgColor = null;
// 109
    JP.go.ipa.oz.lib.standard._String_if string$23 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCBLocalHierarchyCanvas#initGUI"));
    
// 109
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.debugPrintln (string$23);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.debugPrintln (string$23);
    }
// 110
    bgColor = (JP.go.ipa.oz.lib.standard._Color_cl) (new JP.go.ipa.oz.lib.standard._Color_cl ())._new_newColorAsWhite ();
// 111
    setBackground (bgColor);
// 113
    classBoxColor = (JP.go.ipa.oz.lib.standard._Color_cl) (new JP.go.ipa.oz.lib.standard._Color_cl ())._new_newColorAsYellow ();
// 114
    classLabelColor = (JP.go.ipa.oz.lib.standard._Color_cl) (new JP.go.ipa.oz.lib.standard._Color_cl ())._new_newColorAsBlack ();
  }
  
  void drawHierarchy (JP.go.ipa.oz.lib.standard._Graphics_if g) throws Exception  {
// 65
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null, itrSub = null;
// 66
    JP.go.ipa.oz.user.ide.CBIGraphNode_if node = null, subNode = null;
// 67
    int lineHStep = 0, lineVStep = 0;
// 68
    int x = 0, y = 0, w = 0, h = 0;
// 69
    int subX = 0, subY = 0;
// 70
    int boxLeftInsets = 0, boxBottomInsets = 0;
// 72
    int getLeft$val$186;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) boxInsets)) {
      try {
        getLeft$val$186 = boxInsets.getLeft ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getLeft$val$186 = boxInsets.getLeft ();
    }
// 72
    boxLeftInsets = getLeft$val$186;
// 73
    int getBottom$val$187;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) boxInsets)) {
      try {
        getBottom$val$187 = boxInsets.getBottom ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBottom$val$187 = boxInsets.getBottom ();
    }
// 73
    boxBottomInsets = getBottom$val$187;
// 74
    int getTop$val$188;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) boxInsets)) {
      try {
        getTop$val$188 = boxInsets.getTop ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getTop$val$188 = boxInsets.getTop ();
    }
// 74
    lineVStep = (fontHeight + boxBottomInsets + getTop$val$188) / 2;
// 75
    lineHStep = 5;
// 76
    JP.go.ipa.oz.lib.standard._Iterator_if nodes$val$189;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) graph)) {
      try {
        nodes$val$189 = graph.nodes ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nodes$val$189 = graph.nodes ();
    }
// 76
    itr = nodes$val$189;
// 77
    while (true) {
// 77
      boolean hasMoreElements$val$190;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
        try {
          hasMoreElements$val$190 = itr.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$190 = itr.hasMoreElements ();
      }
      if (!(hasMoreElements$val$190)) break;
      
      /* body */ _loop_1: {
// 78
        JP.go.ipa.oz.lang._Root_if nextElement$val$191;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
          try {
            nextElement$val$191 = itr.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$191 = itr.nextElement ();
        }
// 78
        node = (JP.go.ipa.oz.user.ide.CBIGraphNode_if) (nextElement$val$191);
// 79
        int getX$val$192;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) node)) {
          try {
            getX$val$192 = node.getX ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getX$val$192 = node.getX ();
        }
// 79
        x = getX$val$192;
// 80
        int getY$val$193;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) node)) {
          try {
            getY$val$193 = node.getY ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getY$val$193 = node.getY ();
        }
// 80
        y = getY$val$193;
// 81
        int getWidth$val$194;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) node)) {
          try {
            getWidth$val$194 = node.getWidth ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getWidth$val$194 = node.getWidth ();
        }
// 81
        w = getWidth$val$194;
// 82
        int getHeight$val$195;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) node)) {
          try {
            getHeight$val$195 = node.getHeight ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getHeight$val$195 = node.getHeight ();
        }
// 82
        h = getHeight$val$195;
// 88
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) g)) {
          try {
            g.drawRect (x, y, w, h);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          g.drawRect (x, y, w, h);
        }
// 89
        JP.go.ipa.oz.lib.standard._String_if getLabelName$val$196;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) node)) {
          try {
            getLabelName$val$196 = node.getLabelName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getLabelName$val$196 = node.getLabelName ();
        }
// 89
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) g)) {
          try {
            g.drawString (getLabelName$val$196, x + boxLeftInsets, y + h - boxBottomInsets);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          g.drawString (getLabelName$val$196, x + boxLeftInsets, y + h - boxBottomInsets);
        }
// 91
        JP.go.ipa.oz.lib.standard._Iterator_if subNodes$val$197;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) node)) {
          try {
            subNodes$val$197 = node.subNodes ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          subNodes$val$197 = node.subNodes ();
        }
// 91
        itrSub = subNodes$val$197;
// 92
        while (true) {
// 92
          boolean hasMoreElements$val$198;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itrSub)) {
            try {
              hasMoreElements$val$198 = itrSub.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$198 = itrSub.hasMoreElements ();
          }
          if (!(hasMoreElements$val$198)) break;
          
          /* body */ _loop_2: {
// 93
            JP.go.ipa.oz.lang._Root_if nextElement$val$199;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itrSub)) {
              try {
                nextElement$val$199 = itrSub.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$199 = itrSub.nextElement ();
            }
// 93
            subNode = (JP.go.ipa.oz.user.ide.CBIGraphNode_if) (nextElement$val$199);
// 94
            int getX$val$200;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subNode)) {
              try {
                getX$val$200 = subNode.getX ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getX$val$200 = subNode.getX ();
            }
// 94
            subX = getX$val$200;
// 95
            int getY$val$201;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subNode)) {
              try {
                getY$val$201 = subNode.getY ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getY$val$201 = subNode.getY ();
            }
// 95
            subY = getY$val$201;
// 96
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) g)) {
              try {
                g.drawLine (x + w + lineHStep, y + lineVStep, subX - lineHStep, subY + lineVStep);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              g.drawLine (x + w + lineHStep, y + lineVStep, subX - lineHStep, subY + lineVStep);
            }
          }
        }
      }
    }
  }
  
  public CBLocalHierarchyCanvas_cl () throws Exception { super (); }
  
}


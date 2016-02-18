package JP.go.ipa.oz.user.apl.fed;

public class Federation_cl extends JP.go.ipa.oz.user.apl.fed.Autonomy_cl implements JP.go.ipa.oz.user.apl.fed.Federation_if {
  static final boolean _global_ = true;
  JP.go.ipa.oz.lib.standard._Dictionary_if autos;
  
  JP.go.ipa.oz.lib.standard._Set_if getRelayPivots (JP.go.ipa.oz.lib.standard._Set_if pivots) throws Exception  {
// 129
    boolean isRed$val$153;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pivots)) {
      try {
        isRed$val$153 = pivots.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$153 = pivots.isRed ();
    }
// 129
    if (isRed$val$153) {
// 129
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (pivots);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (pivots);
      }
    }
// 130
    if (debug) {
// 130
      JP.go.ipa.oz.lib.standard._String_if string$79 = (new JP.go.ipa.oz.lib.standard._String_cl("FedRoot#getRelayPivots() enter"));
      
// 130
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$79);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$79);
      }
    }
// 131
    JP.go.ipa.oz.lib.standard._Iterator_if it = null;
// 132
    JP.go.ipa.oz.lib.standard._String_if pivot = null;
// 133
    JP.go.ipa.oz.lib.standard._Set_if list = null;
// 134
    JP.go.ipa.oz.lib.standard._StringComparator_if sc = null;
// 136
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$154;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pivots)) {
      try {
        iterator$val$154 = pivots.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$154 = pivots.iterator ();
    }
// 136
    it = iterator$val$154;
// 137
    JP.go.ipa.oz.lang._Root_if nextElement$val$155;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
      try {
        nextElement$val$155 = it.nextElement ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nextElement$val$155 = it.nextElement ();
    }
// 137
    pivot = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$155);
// 138
    sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 139
    list = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (sc);
// 140
    boolean contains$val$156;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) adapterPivots)) {
      try {
        contains$val$156 = adapterPivots.contains (pivot);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      contains$val$156 = adapterPivots.contains (pivot);
    }
// 140
    if (contains$val$156) {{
// 141
        list.add (pivot);
      }
    }
// 144
    pivots = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create ();
// 145
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$157;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) adapters)) {
      try {
        iterator$val$157 = adapters.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$157 = adapters.iterator ();
    }
// 145
    JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$157;
// 146
    while (true) {
// 146
      boolean hasMoreElements$val$158;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$158 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$158 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$158)) break;
      
      /* body */ _loop_1: {
// 147
        JP.go.ipa.oz.user.apl.fed.ResourceProxy_if adapter = null;
// 148
        JP.go.ipa.oz.lang._Root_if nextElement$val$159;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$159 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$159 = iter.nextElement ();
        }
// 148
        adapter = (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if) (nextElement$val$159);
// 149
        JP.go.ipa.oz.lib.standard._String_if getAutonomyType$val$160;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) adapter)) {
          try {
            getAutonomyType$val$160 = adapter.getAutonomyType ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getAutonomyType$val$160 = adapter.getAutonomyType ();
        }
// 149
        JP.go.ipa.oz.lib.standard._String_if autoType = getAutonomyType$val$160;
// 150
        if (list.contains (autoType)) {
// 151
          JP.go.ipa.oz.lib.standard._String_if getResourceType$val$161;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) adapter)) {
            try {
              getResourceType$val$161 = adapter.getResourceType ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getResourceType$val$161 = adapter.getResourceType ();
          }
// 151
          pivots.add (getResourceType$val$161);
        }
      }
    }
// 153
    if (debug) {
// 153
      JP.go.ipa.oz.lib.standard._String_if string$80 = (new JP.go.ipa.oz.lib.standard._String_cl("Federation#getRelayPivots() leave"));
      
// 153
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$80);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$80);
      }
    }
// 154
    return pivots;
  }
  
  public void init () throws Exception  {
    checkSecureInvocation ();
// 8
    super.init ();
// 9
    setClassName ((new JP.go.ipa.oz.lib.standard._String_cl("Federation")));
// 10
    JP.go.ipa.oz.lib.standard._StringComparator_if comp = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 11
    autos = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (comp, comp);
  }
  
  public JP.go.ipa.oz.user.apl.fed.ResourceProxy_if getAdapter (JP.go.ipa.oz.lib.standard._String_if resType, JP.go.ipa.oz.lib.standard._Set_if pivots) throws Exception  {
    checkSecureInvocation ();
// 76
    boolean isRed$val$162;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) resType)) {
      try {
        isRed$val$162 = resType.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$162 = resType.isRed ();
    }
// 76
    if (isRed$val$162) {
// 76
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (resType);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (resType);
      }
    }
// 77
    boolean isRed$val$163;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pivots)) {
      try {
        isRed$val$163 = pivots.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$163 = pivots.isRed ();
    }
// 77
    if (isRed$val$163) {
// 77
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (pivots);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (pivots);
      }
    }
// 78
    if (debug) {
// 78
      JP.go.ipa.oz.lib.standard._String_if string$81 = (new JP.go.ipa.oz.lib.standard._String_cl("FedRoot#getAdapter() enter"));
      
// 78
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$81);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$81);
      }
    }
// 79
    JP.go.ipa.oz.user.apl.fed.ResourceProxy_if adapter = null;
// 80
    JP.go.ipa.oz.lib.standard._Iterator_if it = null;
// 81
    JP.go.ipa.oz.lib.standard._String_if str = null;
// 82
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$164;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pivots)) {
      try {
        iterator$val$164 = pivots.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$164 = pivots.iterator ();
    }
// 82
    it = iterator$val$164;
// 83
    JP.go.ipa.oz.lang._Root_if nextElement$val$165;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
      try {
        nextElement$val$165 = it.nextElement ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nextElement$val$165 = it.nextElement ();
    }
// 83
    str = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$165);
// 85
    JP.go.ipa.oz.lib.standard._Iterator_if assocIterator$val$166;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) autos)) {
      try {
        assocIterator$val$166 = autos.assocIterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      assocIterator$val$166 = autos.assocIterator ();
    }
// 85
    JP.go.ipa.oz.lib.standard._Iterator_if iter = assocIterator$val$166;
// 86
    while (true) {
// 86
      boolean hasMoreElements$val$167;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$167 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$167 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$167)) break;
      
      /* body */ _loop_1: {
// 87
        JP.go.ipa.oz.lib.standard._Association_if assoc = null;
// 88
        JP.go.ipa.oz.lang._Root_if nextElement$val$168;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$168 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$168 = iter.nextElement ();
        }
// 88
        assoc = (JP.go.ipa.oz.lib.standard._Association_if) (nextElement$val$168);
// 89
        JP.go.ipa.oz.lib.standard._String_if type = null;
// 90
        JP.go.ipa.oz.lang._Root_if value$val$169;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) assoc)) {
          try {
            value$val$169 = assoc.value ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          value$val$169 = assoc.value ();
        }
// 90
        type = (JP.go.ipa.oz.lib.standard._String_if) (value$val$169);
// 91
        boolean isequal$val$170;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) resType)) {
          try {
            isequal$val$170 = resType.isequal (type);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$170 = resType.isequal (type);
        }
// 91
        if (isequal$val$170) {{
// 92
            JP.go.ipa.oz.lib.standard._String_if resGol = null;
// 93
            JP.go.ipa.oz.lang._Root_if key$val$171;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) assoc)) {
              try {
                key$val$171 = assoc.key ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              key$val$171 = assoc.key ();
            }
// 93
            resGol = (JP.go.ipa.oz.lib.standard._String_if) (key$val$171);
// 94
            JP.go.ipa.oz.user.apl.fed.Autonomy_if auto = new JP.go.ipa.oz.user.apl.fed.Autonomy_pcl (resGol);
// 95
            JP.go.ipa.oz.user.apl.fed.ResourceProxy_if exportResource$val$172;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auto)) {
              try {
                exportResource$val$172 = auto.exportResource (pivots);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              exportResource$val$172 = auto.exportResource (pivots);
            }
// 95
            adapter = exportResource$val$172;
// 96
            if (adapter != null) {{
// 97
                if (debug) {
// 97
                  JP.go.ipa.oz.lib.standard._String_if string$82 = (new JP.go.ipa.oz.lib.standard._String_cl("Federation#getAdapter() leave 1"));
                  
// 97
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                    try {
                      system.println (string$82);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    system.println (string$82);
                  }
                }
// 98
                return adapter;
              }
            }
          }
        }
      }
    }
// 104
    JP.go.ipa.oz.lib.standard._Set_if list = getRelayPivots (pivots);
// 105
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$173;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
      try {
        iterator$val$173 = list.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$173 = list.iterator ();
    }
// 105
    it = iterator$val$173;
// 106
    JP.go.ipa.oz.lang._Root_if nextElement$val$174;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
      try {
        nextElement$val$174 = it.nextElement ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nextElement$val$174 = it.nextElement ();
    }
// 106
    str = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$174);
// 107
    int size$val$175;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
      try {
        size$val$175 = list.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$175 = list.size ();
    }
// 107
    if (0 < size$val$175) {{
// 108
        adapter = getAdapter (resType, list);
// 109
        if (adapter != null) {{
// 110
            JP.go.ipa.oz.user.apl.fed.ResourceProxy_if proxy = findRelayProxy (pivots, adapter);
// 111
            if (proxy != null) {{
// 112
                if (debug) {
// 112
                  JP.go.ipa.oz.lib.standard._String_if string$83 = (new JP.go.ipa.oz.lib.standard._String_cl("Federation#getAdapter() leave 2"));
                  
// 112
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                    try {
                      system.println (string$83);
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    system.println (string$83);
                  }
                }
// 113
                JP.go.ipa.oz.user.apl.fed.ResourceProxy_if instanciate$val$176;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxy)) {
                  try {
                    instanciate$val$176 = proxy.instanciate (adapter);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  instanciate$val$176 = proxy.instanciate (adapter);
                }
// 113
                proxy = instanciate$val$176;
// 114
                JP.go.ipa.oz.lib.standard._String_if getResourceType$val$177;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) adapter)) {
                  try {
                    getResourceType$val$177 = adapter.getResourceType ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  getResourceType$val$177 = adapter.getResourceType ();
                }
// 114
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxy)) {
                  try {
                    proxy.setResourceType (getResourceType$val$177);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  proxy.setResourceType (getResourceType$val$177);
                }
// 115
                return proxy;
              }
            }
          }
        }
      }
    }
// 119
    if (debug) {
// 119
      JP.go.ipa.oz.lib.standard._String_if string$84 = (new JP.go.ipa.oz.lib.standard._String_cl("Federation#getAdapter() leave with null"));
      
// 119
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$84);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$84);
      }
    }
// 120
    return null;
  }
  
  public void addAutonomy (JP.go.ipa.oz.lib.standard._String_if autonomy) throws Exception  {
    checkSecureInvocation ();
// 29
    boolean isRed$val$178;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) autonomy)) {
      try {
        isRed$val$178 = autonomy.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$178 = autonomy.isRed ();
    }
// 29
    if (isRed$val$178) {
// 29
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (autonomy);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (autonomy);
      }
    }
// 30
    if (debug) {
// 30
      JP.go.ipa.oz.lib.standard._String_if string$85 = (new JP.go.ipa.oz.lib.standard._String_cl("Federation#addAutonomy() enter"));
      
// 30
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$85);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$85);
      }
    }
// 31
    boolean containsKey$val$179;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) autos)) {
      try {
        containsKey$val$179 = autos.containsKey (autonomy);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      containsKey$val$179 = autos.containsKey (autonomy);
    }
// 31
    if (!containsKey$val$179) {{
// 32
        JP.go.ipa.oz.user.apl.fed.Autonomy_if auto = new JP.go.ipa.oz.user.apl.fed.Autonomy_pcl (autonomy);
// 33
        JP.go.ipa.oz.lib.standard._String_if getType$val$180;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auto)) {
          try {
            getType$val$180 = auto.getType ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getType$val$180 = auto.getType ();
        }
// 33
        JP.go.ipa.oz.lib.standard._Dictionary_if put$val$181;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) autos)) {
          try {
            put$val$181 = autos.put (autonomy, getType$val$180);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          put$val$181 = autos.put (autonomy, getType$val$180);
        }
// 34
        if (debug) {
// 34
          JP.go.ipa.oz.lib.standard._String_if gol$val$182;
          gol$val$182 = this.gol ();
// 34
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (gol$val$182);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (gol$val$182);
          }
        }
// 35
        JP.go.ipa.oz.lib.standard._String_if gol$val$183;
        gol$val$183 = this.gol ();
// 35
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auto)) {
          try {
            auto.attachToFederation (gol$val$183);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          auto.attachToFederation (gol$val$183);
        }
      }
    }
// 37
    if (debug) {
// 37
      JP.go.ipa.oz.lib.standard._String_if string$86 = (new JP.go.ipa.oz.lib.standard._String_cl("Federation#addAutonomy() leave"));
      
// 37
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$86);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$86);
      }
    }
  }
  
  public void removeAutonomy (JP.go.ipa.oz.lib.standard._String_if autonomy) throws Exception  {
    checkSecureInvocation ();
// 46
    boolean isRed$val$184;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) autonomy)) {
      try {
        isRed$val$184 = autonomy.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$184 = autonomy.isRed ();
    }
// 46
    if (isRed$val$184) {
// 46
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (autonomy);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (autonomy);
      }
    }
// 47
    if (debug) {
// 47
      JP.go.ipa.oz.lib.standard._String_if string$87 = (new JP.go.ipa.oz.lib.standard._String_cl("Federation#removeAutonomy() enter"));
      
// 47
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$87);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$87);
      }
    }
// 48
    boolean containsKey$val$185;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) autos)) {
      try {
        containsKey$val$185 = autos.containsKey (autonomy);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      containsKey$val$185 = autos.containsKey (autonomy);
    }
// 48
    if (containsKey$val$185) {{
// 49
        JP.go.ipa.oz.lib.standard._Dictionary_if remove$val$186;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) autos)) {
          try {
            remove$val$186 = autos.remove (autonomy);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          remove$val$186 = autos.remove (autonomy);
        }
// 50
        JP.go.ipa.oz.user.apl.fed.Autonomy_if auto = new JP.go.ipa.oz.user.apl.fed.Autonomy_pcl (autonomy);
// 51
        if (debug) {
// 51
          JP.go.ipa.oz.lib.standard._String_if gol$val$187;
          gol$val$187 = this.gol ();
// 51
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
            try {
              system.println (gol$val$187);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            system.println (gol$val$187);
          }
        }
// 52
        JP.go.ipa.oz.lib.standard._String_if gol$val$188;
        gol$val$188 = this.gol ();
// 52
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auto)) {
          try {
            auto.detachFromFederation (gol$val$188);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          auto.detachFromFederation (gol$val$188);
        }
      }
    }
// 54
    if (debug) {
// 54
      JP.go.ipa.oz.lib.standard._String_if string$88 = (new JP.go.ipa.oz.lib.standard._String_cl("Federation#removeAutonomy() leave"));
      
// 54
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$88);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$88);
      }
    }
  }
  
  public JP.go.ipa.oz.user.apl.fed.ResourceProxy_if findRelayProxy (JP.go.ipa.oz.lib.standard._Set_if pivots, JP.go.ipa.oz.user.apl.fed.ResourceProxy_if adapter) throws Exception  {
    checkSecureInvocation ();
// 163
    boolean isRed$val$189;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pivots)) {
      try {
        isRed$val$189 = pivots.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$189 = pivots.isRed ();
    }
// 163
    if (isRed$val$189) {
// 163
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (pivots);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (pivots);
      }
    }
// 164
    boolean isRed$val$190;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) adapter)) {
      try {
        isRed$val$190 = adapter.isRed ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isRed$val$190 = adapter.isRed ();
    }
// 164
    if (isRed$val$190) {
// 164
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) auth)) {
        try {
          auth.authorize (adapter);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        auth.authorize (adapter);
      }
    }
// 165
    if (debug) {
// 165
      JP.go.ipa.oz.lib.standard._String_if string$89 = (new JP.go.ipa.oz.lib.standard._String_cl("FedRoot#findRelayProxy() enter"));
      
// 165
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$89);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$89);
      }
    }
// 166
    JP.go.ipa.oz.lib.standard._String_if getAutonomyType$val$191;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) adapter)) {
      try {
        getAutonomyType$val$191 = adapter.getAutonomyType ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getAutonomyType$val$191 = adapter.getAutonomyType ();
    }
// 166
    JP.go.ipa.oz.lib.standard._String_if autoType = getAutonomyType$val$191;
// 167
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$192;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) adapters)) {
      try {
        iterator$val$192 = adapters.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$192 = adapters.iterator ();
    }
// 167
    JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$192;
// 168
    while (true) {
// 168
      boolean hasMoreElements$val$193;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$193 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$193 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$193)) break;
      
      /* body */ _loop_1: {
// 169
        JP.go.ipa.oz.user.apl.fed.ResourceProxy_if proxy = null;
// 170
        JP.go.ipa.oz.lang._Root_if nextElement$val$194;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$194 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$194 = iter.nextElement ();
        }
// 170
        proxy = (JP.go.ipa.oz.user.apl.fed.ResourceProxy_if) (nextElement$val$194);
        boolean bool$val$17;
        
// 171
        JP.go.ipa.oz.lib.standard._String_if getResourceType$val$195;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxy)) {
          try {
            getResourceType$val$195 = proxy.getResourceType ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getResourceType$val$195 = proxy.getResourceType ();
        }
// 171
        boolean isequal$val$196;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) autoType)) {
          try {
            isequal$val$196 = autoType.isequal (getResourceType$val$195);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$196 = autoType.isequal (getResourceType$val$195);
        }
        bool$val$17 = isequal$val$196;
        if (bool$val$17) {
// 172
          JP.go.ipa.oz.lib.standard._String_if getAutonomyType$val$197;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) proxy)) {
            try {
              getAutonomyType$val$197 = proxy.getAutonomyType ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            getAutonomyType$val$197 = proxy.getAutonomyType ();
          }
// 172
          boolean contains$val$198;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pivots)) {
            try {
              contains$val$198 = pivots.contains (getAutonomyType$val$197);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            contains$val$198 = pivots.contains (getAutonomyType$val$197);
          }
          bool$val$17 = contains$val$198;
        }
// 171
        if (bool$val$17) {{
// 173
            if (debug) {
// 173
              JP.go.ipa.oz.lib.standard._String_if string$90 = (new JP.go.ipa.oz.lib.standard._String_cl("Federation#findRelayProxy() leave"));
              
// 173
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
                try {
                  system.println (string$90);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                system.println (string$90);
              }
            }
// 174
            return proxy;
          }
        }
      }
    }
// 177
    if (debug) {
// 177
      JP.go.ipa.oz.lib.standard._String_if string$91 = (new JP.go.ipa.oz.lib.standard._String_cl("Federation#findRelayProxy() leave with null"));
      
// 177
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
        try {
          system.println (string$91);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        system.println (string$91);
      }
    }
// 178
    return null;
  }
  
  public JP.go.ipa.oz.lib.standard._Dictionary_if getAutonomies () throws Exception  {
    checkSecureInvocation ();
// 15
    return autos;
  }
  
  public Federation_cl () { super ("JP.go.ipa.oz.user.apl.fed.Federation_pcl"); }
  
  public Federation_cl (String proxy_id) { super (proxy_id); }
  
}


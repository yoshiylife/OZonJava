package JP.go.ipa.oz.user.cda;

public class _ClassDeliveryAgent_cl extends JP.go.ipa.oz.user.misc.cell.Stoppable_cl implements JP.go.ipa.oz.user.cda._ClassDeliveryAgent_if {
  static final boolean _global_ = true;
  JP.go.ipa.oz.user.cda._DeliveryFileCache_if cache;
  JP.go.ipa.oz.user.cda._ServerSocketRunnable_if ssr;
  int port;
  JP.go.ipa.oz.lib.standard._String_if millorMode;
  JP.go.ipa.oz.user.cda._CopyOnRightRunnable_if copyOR;
  JP.go.ipa.oz.user.cda._PollingRunnable_if polling;
  JP.go.ipa.oz.user.cda._TargetCDAList_if targets;
  JP.go.ipa.oz.user.cda._MillorTarget_if millors;
  JP.go.ipa.oz.user.cda._MillorTarget_if millorsS;
  JP.go.ipa.oz.lib.standard._String_if host;
  boolean millorOn;
  
  public void millorsAddTopPackageName (JP.go.ipa.oz.lib.standard._String_if target, JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 486
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) millors)) {
      try {
        millors.addTopPackageName (target, name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      millors.addTopPackageName (target, name);
    }
  }
  
  public JP.go.ipa.oz.lib.standard._ClassProperty_if getClassProperty (JP.go.ipa.oz.lib.standard._String_if codePath, JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 585
    JP.go.ipa.oz.lib.standard._ClassProperty_if cp = (JP.go.ipa.oz.lib.standard._ClassProperty_cl) (new JP.go.ipa.oz.lib.standard._ClassProperty_cl ())._new_create (codePath, name);
// 587
    return cp;
  }
  
  public JP.go.ipa.oz.user.cda._DeliveryFile_if millor (JP.go.ipa.oz.lib.standard._String_if topPackageName, long time) throws Exception  {
    checkSecureInvocation ();
// 327
    JP.go.ipa.oz.user.cda._CDAdebug_if debug = (JP.go.ipa.oz.user.cda._CDAdebug_cl) (new JP.go.ipa.oz.user.cda._CDAdebug_cl ())._new_create ();
// 328
    JP.go.ipa.oz.lib.standard._String_if string$24 = (new JP.go.ipa.oz.lib.standard._String_cl("millor server begin"));
    
// 328
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.println (string$24);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.println (string$24);
    }
// 329
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.println (topPackageName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.println (topPackageName);
    }
// 330
    JP.go.ipa.oz.lib.standard._Long_if L = (JP.go.ipa.oz.lib.standard._Long_cl) (new JP.go.ipa.oz.lib.standard._Long_cl ())._new_breed (time);
// 330
    JP.go.ipa.oz.lib.standard._String_if asString$val$39;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) L)) {
      try {
        asString$val$39 = L.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$39 = L.asString ();
    }
// 330
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.println (asString$val$39);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.println (asString$val$39);
    }
// 331
    JP.go.ipa.oz.lib.standard._File_if f = JP.go.ipa.oz.lib.standard._LocalRepositoryManager_cl._static_get (topPackageName);
    boolean bool$val$2;
    
    bool$val$2 = (isSecurityOKasMillorClient ());
    if (bool$val$2) {
      bool$val$2 = (isMillorOK (topPackageName));
    }
// 332
    if (bool$val$2) {{
// 333
        long lastModified$val$40;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
          try {
            lastModified$val$40 = f.lastModified ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          lastModified$val$40 = f.lastModified ();
        }
// 333
        long lastTime = lastModified$val$40;
// 334
        L = (JP.go.ipa.oz.lib.standard._Long_cl) (new JP.go.ipa.oz.lib.standard._Long_cl ())._new_breed (lastTime);
// 334
        JP.go.ipa.oz.lib.standard._String_if asString$val$41;
        asString$val$41 = L.asString ();
// 334
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
          try {
            debug.println (asString$val$41);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          debug.println (asString$val$41);
        }
// 335
        if (lastTime != time) {{
// 336
            JP.go.ipa.oz.user.cda._DeliveryFile_if df = searchAndDelivery (topPackageName);
// 337
            if (df == null) {
// 337
              return null;
            }
// 338
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) df)) {
              try {
                df.timeStamp (lastTime);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              df.timeStamp (lastTime);
            }
// 339
            JP.go.ipa.oz.lib.standard._String_if string$25 = (new JP.go.ipa.oz.lib.standard._String_cl("millor server end"));
            
// 339
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
              try {
                debug.println (string$25);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              debug.println (string$25);
            }
// 340
            return df;
          }
        } else {
// 341
          return null;
        }
      }
    } else {
// 342
      return null;
    }
  }
  
  protected boolean isSecurityOKasMillorServer () throws Exception  {
// 570
    return true;
  }
  
  public int targetsPutAt (int at, JP.go.ipa.oz.lib.standard._String_if target) throws Exception  {
    checkSecureInvocation ();
// 447
    int putAt$val$42;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targets)) {
      try {
        putAt$val$42 = targets.putAt (at, target);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$42 = targets.putAt (at, target);
    }
// 447
    return putAt$val$42;
  }
  
  protected boolean isMillorOK (JP.go.ipa.oz.lib.standard._String_if topPackageName) throws Exception  {
// 571
    return true;
  }
  
  public JP.go.ipa.oz.user.cda._DeliveryFile_if leaveToSearchAndDelivery (JP.go.ipa.oz.lib.standard._String_if codePath) throws Exception  {
    checkSecureInvocation ();
// 244
    JP.go.ipa.oz.user.cda._DeliveryFile_if df = searchAndDelivery (codePath);
// 245
    if (df != null) {
// 245
      return df;
    }
// 246
    int RetryNum = 0;
// 247
    JP.go.ipa.oz.lib.standard._String_if targetCDAGOL = null;
// 248
    while (true) {
// 248
      JP.go.ipa.oz.lib.standard._String_if next$val$43;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targets)) {
        try {
          next$val$43 = targets.next (RetryNum);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        next$val$43 = targets.next (RetryNum);
      }
      if (!((targetCDAGOL = next$val$43) != null)) break;
      
      /* body */ _loop_1: {
// 249
        JP.go.ipa.oz.user.cda._ClassDeliveryAgent_if targetCDA = null;
// 249
        targetCDA = new JP.go.ipa.oz.user.cda._ClassDeliveryAgent_pcl (targetCDAGOL);
// 250
        df = targetCDA.searchAndDelivery (codePath);
// 251
        if (df != null) {
// 251
          break;
        }
// 252
        RetryNum++;
      }
    }
// 254
    return df;
  }
  
  protected void setInitial () throws Exception  {
// 137
    millorOn = false;
// 138
    millorMode = (new JP.go.ipa.oz.lib.standard._String_cl("polling"));
// 139
    JP.go.ipa.oz.lib.standard._String_if propVal = null;
// 140
    JP.go.ipa.oz.user.cda._CDAdebug_if debug = (JP.go.ipa.oz.user.cda._CDAdebug_cl) (new JP.go.ipa.oz.user.cda._CDAdebug_cl ())._new_create ();
// 141
    JP.go.ipa.oz.lib.standard._String_if string$26 = (new JP.go.ipa.oz.lib.standard._String_cl("setInitial start"));
    
// 141
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.println (string$26);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.println (string$26);
    }
// 143
    propVal = JP.go.ipa.oz.user.cda._CDAProperty_cl._static_getProp ((new JP.go.ipa.oz.lib.standard._String_cl("leaveTarget")));
// 144
    if (propVal != null) {{
// 145
        targetsSetLeaveTo (propVal);
// 146
        JP.go.ipa.oz.lib.standard._String_if string$27 = (new JP.go.ipa.oz.lib.standard._String_cl("leaveTarget---"));
        
// 146
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
          try {
            debug.println (string$27);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          debug.println (string$27);
        }
// 146
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
          try {
            debug.println (propVal);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          debug.println (propVal);
        }
      }
    }
// 149
    propVal = JP.go.ipa.oz.user.cda._CDAProperty_cl._static_getProp ((new JP.go.ipa.oz.lib.standard._String_cl("target")));
// 150
    if (propVal != null) {{
// 151
        int delind = 0;
// 151
        JP.go.ipa.oz.lib.standard._String_if carS = null, cdrS = propVal;
// 152
        while (true) {
// 152
          JP.go.ipa.oz.lib.standard._String_if string$28 = (new JP.go.ipa.oz.lib.standard._String_cl(","));
          
// 152
          int indexOf$val$44;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cdrS)) {
            try {
              indexOf$val$44 = cdrS.indexOf (string$28);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            indexOf$val$44 = cdrS.indexOf (string$28);
          }
          if (!((delind = indexOf$val$44) > 0)) break;
          
          /* body */ _loop_1: {
// 153
            JP.go.ipa.oz.lib.standard._String_if substring$val$45;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cdrS)) {
              try {
                substring$val$45 = cdrS.substring (0, delind);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              substring$val$45 = cdrS.substring (0, delind);
            }
// 153
            carS = substring$val$45;
// 154
            JP.go.ipa.oz.lib.standard._String_if substring$val$46;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cdrS)) {
              try {
                substring$val$46 = cdrS.substring (delind + 1);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              substring$val$46 = cdrS.substring (delind + 1);
            }
// 154
            cdrS = substring$val$46;
// 155
            JP.go.ipa.oz.lib.standard._String_if nowTarget = null;
// 156
            JP.go.ipa.oz.lib.standard._String_if string$29 = (new JP.go.ipa.oz.lib.standard._String_cl(":cda"));
            
// 156
            JP.go.ipa.oz.lib.standard._String_if concat$val$47;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) carS)) {
              try {
                concat$val$47 = carS.concat (string$29);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              concat$val$47 = carS.concat (string$29);
            }
// 156
            nowTarget = concat$val$47;
// 157
            targetsPut (nowTarget);
// 158
            JP.go.ipa.oz.lib.standard._String_if string$30 = (new JP.go.ipa.oz.lib.standard._String_cl("target---"));
            
// 158
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
              try {
                debug.println (string$30);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              debug.println (string$30);
            }
// 158
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
              try {
                debug.println (carS);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              debug.println (carS);
            }
          }
        }
// 160
        JP.go.ipa.oz.lib.standard._String_if nowTarget = null;
// 161
        JP.go.ipa.oz.lib.standard._String_if string$31 = (new JP.go.ipa.oz.lib.standard._String_cl(":cda"));
        
// 161
        JP.go.ipa.oz.lib.standard._String_if concat$val$48;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cdrS)) {
          try {
            concat$val$48 = cdrS.concat (string$31);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$48 = cdrS.concat (string$31);
        }
// 161
        nowTarget = concat$val$48;
// 162
        targetsPut (nowTarget);
// 163
        JP.go.ipa.oz.lib.standard._String_if string$32 = (new JP.go.ipa.oz.lib.standard._String_cl("target---"));
        
// 163
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
          try {
            debug.println (string$32);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          debug.println (string$32);
        }
// 163
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
          try {
            debug.println (cdrS);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          debug.println (cdrS);
        }
      }
    }
// 166
    propVal = JP.go.ipa.oz.user.cda._CDAProperty_cl._static_getProp ((new JP.go.ipa.oz.lib.standard._String_cl("millorMode")));
// 167
    if (propVal != null) {{
// 168
        JP.go.ipa.oz.lib.standard._String_if string$33 = (new JP.go.ipa.oz.lib.standard._String_cl("millorMode---"));
        
// 168
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
          try {
            debug.println (string$33);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          debug.println (string$33);
        }
// 168
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
          try {
            debug.println (propVal);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          debug.println (propVal);
        }
// 169
        JP.go.ipa.oz.lib.standard._String_if string$34 = (new JP.go.ipa.oz.lib.standard._String_cl("writeInValidate"));
        
// 169
        boolean isequal$val$49;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) propVal)) {
          try {
            isequal$val$49 = propVal.isequal (string$34);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$49 = propVal.isequal (string$34);
        }
// 169
        if (isequal$val$49) {{
// 170
            modeWriteInValid ();
// 171
            millorMode = (new JP.go.ipa.oz.lib.standard._String_cl("WIV"));
// 172
            JP.go.ipa.oz.lib.standard._String_if string$35 = (new JP.go.ipa.oz.lib.standard._String_cl("mode---WIV"));
            
// 172
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
              try {
                debug.println (string$35);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              debug.println (string$35);
            }
          }
        } else {
// 173
          JP.go.ipa.oz.lib.standard._String_if string$36 = (new JP.go.ipa.oz.lib.standard._String_cl("copyOnWrite"));
          
// 173
          boolean isequal$val$50;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) propVal)) {
            try {
              isequal$val$50 = propVal.isequal (string$36);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            isequal$val$50 = propVal.isequal (string$36);
          }
// 173
          if (isequal$val$50) {{
// 174
              modeCopyOnWrite ();
// 175
              millorMode = (new JP.go.ipa.oz.lib.standard._String_cl("COW"));
// 176
              JP.go.ipa.oz.lib.standard._String_if string$37 = (new JP.go.ipa.oz.lib.standard._String_cl("mode---COW"));
              
// 176
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
                try {
                  debug.println (string$37);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                debug.println (string$37);
              }
            }
          }
        }
      }
    }
// 180
    propVal = JP.go.ipa.oz.user.cda._CDAProperty_cl._static_getProp ((new JP.go.ipa.oz.lib.standard._String_cl("millorInterval")));
// 181
    if (propVal != null) {{
// 182
        int interval = JP.go.ipa.oz.user.cda._AtoI_cl._static_atoi (propVal);
// 183
        setInterval (interval);
// 184
        JP.go.ipa.oz.lib.standard._String_if string$38 = (new JP.go.ipa.oz.lib.standard._String_cl("millorInterval---"));
        
// 184
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
          try {
            debug.println (string$38);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          debug.println (string$38);
        }
// 184
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
          try {
            debug.println (propVal);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          debug.println (propVal);
        }
      }
    }
// 187
    propVal = JP.go.ipa.oz.user.cda._CDAProperty_cl._static_getProp ((new JP.go.ipa.oz.lib.standard._String_cl("millorStart")));
// 188
    if (propVal != null) {{
// 189
        JP.go.ipa.oz.lib.standard._String_if string$39 = (new JP.go.ipa.oz.lib.standard._String_cl("true"));
        
// 189
        boolean isequal$val$51;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) propVal)) {
          try {
            isequal$val$51 = propVal.isequal (string$39);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$51 = propVal.isequal (string$39);
        }
// 189
        if (isequal$val$51) {
// 189
          millorOn = true;
        }
// 190
        JP.go.ipa.oz.lib.standard._String_if string$40 = (new JP.go.ipa.oz.lib.standard._String_cl("millorStart---"));
        
// 190
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
          try {
            debug.println (string$40);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          debug.println (string$40);
        }
// 190
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
          try {
            debug.println (propVal);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          debug.println (propVal);
        }
      }
    }
// 193
    propVal = JP.go.ipa.oz.user.cda._CDAProperty_cl._static_getProp ((new JP.go.ipa.oz.lib.standard._String_cl("millor")));
// 194
    if (propVal != null) {{
// 195
        int delind = 0;
// 195
        JP.go.ipa.oz.lib.standard._String_if carS = null, cdrS = propVal;
// 196
        JP.go.ipa.oz.lib.standard._String_if string$41 = (new JP.go.ipa.oz.lib.standard._String_cl("millor---"));
        
// 196
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
          try {
            debug.println (string$41);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          debug.println (string$41);
        }
// 197
        while (true) {
// 197
          JP.go.ipa.oz.lib.standard._String_if string$42 = (new JP.go.ipa.oz.lib.standard._String_cl("&"));
          
// 197
          int indexOf$val$52;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cdrS)) {
            try {
              indexOf$val$52 = cdrS.indexOf (string$42);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            indexOf$val$52 = cdrS.indexOf (string$42);
          }
          if (!((delind = indexOf$val$52) > 0)) break;
          
          /* body */ _loop_1: {
// 198
            JP.go.ipa.oz.lib.standard._String_if substring$val$53;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cdrS)) {
              try {
                substring$val$53 = cdrS.substring (0, delind);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              substring$val$53 = cdrS.substring (0, delind);
            }
// 198
            carS = substring$val$53;
// 199
            JP.go.ipa.oz.lib.standard._String_if substring$val$54;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cdrS)) {
              try {
                substring$val$54 = cdrS.substring (delind + 1);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              substring$val$54 = cdrS.substring (delind + 1);
            }
// 199
            cdrS = substring$val$54;
// 200
            int delindIn = 0;
// 200
            JP.go.ipa.oz.lib.standard._String_if caarS = null, cadrS = null;
// 200
            JP.go.ipa.oz.lib.standard._String_if nowMT = null;
// 201
            JP.go.ipa.oz.lib.standard._String_if string$43 = (new JP.go.ipa.oz.lib.standard._String_cl(","));
            
// 201
            int indexOf$val$55;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) carS)) {
              try {
                indexOf$val$55 = carS.indexOf (string$43);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              indexOf$val$55 = carS.indexOf (string$43);
            }
// 201
            delindIn = indexOf$val$55;
// 202
            JP.go.ipa.oz.lib.standard._String_if substring$val$56;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) carS)) {
              try {
                substring$val$56 = carS.substring (0, delindIn);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              substring$val$56 = carS.substring (0, delindIn);
            }
// 202
            caarS = substring$val$56;
// 203
            JP.go.ipa.oz.lib.standard._String_if string$44 = (new JP.go.ipa.oz.lib.standard._String_cl(":cda"));
            
// 203
            JP.go.ipa.oz.lib.standard._String_if concat$val$57;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) caarS)) {
              try {
                concat$val$57 = caarS.concat (string$44);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              concat$val$57 = caarS.concat (string$44);
            }
// 203
            nowMT = concat$val$57;
// 204
            JP.go.ipa.oz.lib.standard._String_if substring$val$58;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) carS)) {
              try {
                substring$val$58 = carS.substring (delindIn + 1);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              substring$val$58 = carS.substring (delindIn + 1);
            }
// 204
            cadrS = substring$val$58;
// 205
            millorsAdd (nowMT);
// 206
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
              try {
                debug.println (nowMT);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              debug.println (nowMT);
            }
// 207
            while (true) {
// 207
              JP.go.ipa.oz.lib.standard._String_if string$45 = (new JP.go.ipa.oz.lib.standard._String_cl(","));
              
// 207
              int indexOf$val$59;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cadrS)) {
                try {
                  indexOf$val$59 = cadrS.indexOf (string$45);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                indexOf$val$59 = cadrS.indexOf (string$45);
              }
              if (!((delindIn = indexOf$val$59) > 0)) break;
              
              /* body */ _loop_2: {
// 208
                JP.go.ipa.oz.lib.standard._String_if substring$val$60;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cadrS)) {
                  try {
                    substring$val$60 = cadrS.substring (0, delindIn);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  substring$val$60 = cadrS.substring (0, delindIn);
                }
// 208
                caarS = substring$val$60;
// 209
                JP.go.ipa.oz.lib.standard._String_if substring$val$61;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cadrS)) {
                  try {
                    substring$val$61 = cadrS.substring (delindIn + 1);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  substring$val$61 = cadrS.substring (delindIn + 1);
                }
// 209
                cadrS = substring$val$61;
// 210
                millorsAddTopPackageName (nowMT, caarS);
// 211
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
                  try {
                    debug.println (caarS);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  debug.println (caarS);
                }
              }
            }
// 213
            caarS = cadrS;
// 214
            millorsAddTopPackageName (nowMT, caarS);
// 215
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
              try {
                debug.println (caarS);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              debug.println (caarS);
            }
          }
        }
// 217
        carS = cdrS;
// 218
        int delindIn = 0;
// 218
        JP.go.ipa.oz.lib.standard._String_if caarS = null, cadrS = null;
// 218
        JP.go.ipa.oz.lib.standard._String_if nowMT = null;
// 219
        JP.go.ipa.oz.lib.standard._String_if string$46 = (new JP.go.ipa.oz.lib.standard._String_cl(","));
        
// 219
        int indexOf$val$62;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) carS)) {
          try {
            indexOf$val$62 = carS.indexOf (string$46);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          indexOf$val$62 = carS.indexOf (string$46);
        }
// 219
        delindIn = indexOf$val$62;
// 220
        JP.go.ipa.oz.lib.standard._String_if substring$val$63;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) carS)) {
          try {
            substring$val$63 = carS.substring (0, delindIn);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          substring$val$63 = carS.substring (0, delindIn);
        }
// 220
        caarS = substring$val$63;
// 221
        JP.go.ipa.oz.lib.standard._String_if string$47 = (new JP.go.ipa.oz.lib.standard._String_cl(":cda"));
        
// 221
        JP.go.ipa.oz.lib.standard._String_if concat$val$64;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) caarS)) {
          try {
            concat$val$64 = caarS.concat (string$47);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$64 = caarS.concat (string$47);
        }
// 221
        nowMT = concat$val$64;
// 222
        JP.go.ipa.oz.lib.standard._String_if substring$val$65;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) carS)) {
          try {
            substring$val$65 = carS.substring (delindIn + 1);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          substring$val$65 = carS.substring (delindIn + 1);
        }
// 222
        cadrS = substring$val$65;
// 223
        millorsAdd (nowMT);
// 224
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
          try {
            debug.println (nowMT);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          debug.println (nowMT);
        }
// 225
        while (true) {
// 225
          JP.go.ipa.oz.lib.standard._String_if string$48 = (new JP.go.ipa.oz.lib.standard._String_cl(","));
          
// 225
          int indexOf$val$66;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cadrS)) {
            try {
              indexOf$val$66 = cadrS.indexOf (string$48);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            indexOf$val$66 = cadrS.indexOf (string$48);
          }
          if (!((delindIn = indexOf$val$66) > 0)) break;
          
          /* body */ _loop_1: {
// 226
            JP.go.ipa.oz.lib.standard._String_if substring$val$67;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cadrS)) {
              try {
                substring$val$67 = cadrS.substring (0, delindIn);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              substring$val$67 = cadrS.substring (0, delindIn);
            }
// 226
            caarS = substring$val$67;
// 227
            JP.go.ipa.oz.lib.standard._String_if substring$val$68;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cadrS)) {
              try {
                substring$val$68 = cadrS.substring (delindIn + 1);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              substring$val$68 = cadrS.substring (delindIn + 1);
            }
// 227
            cadrS = substring$val$68;
// 228
            millorsAddTopPackageName (nowMT, caarS);
// 229
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
              try {
                debug.println (caarS);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              debug.println (caarS);
            }
          }
        }
// 231
        caarS = cadrS;
// 232
        millorsAddTopPackageName (nowMT, caarS);
// 233
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
          try {
            debug.println (caarS);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          debug.println (caarS);
        }
      }
    }
  }
  
  public boolean thisWriteInValid (JP.go.ipa.oz.user.cda._DeliveryFile_if df) throws Exception  {
    checkSecureInvocation ();
// 383
    JP.go.ipa.oz.lib.standard._String_if getTopPackageName$val$69;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) df)) {
      try {
        getTopPackageName$val$69 = df.getTopPackageName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getTopPackageName$val$69 = df.getTopPackageName ();
    }
// 383
    JP.go.ipa.oz.lib.standard._String_if topPackageName = getTopPackageName$val$69;
    boolean bool$val$3;
    
    bool$val$3 = (isSecurityOKasMillorServer ());
    if (bool$val$3) {
      bool$val$3 = (isMillorOK (topPackageName));
    }
// 384
    if (bool$val$3) {{
// 385
        try {
// 386
          JP.go.ipa.oz.lib.standard._LocalRepositoryManager_cl._static_remove (topPackageName);
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_1) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
          if (_oz_exception_1 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
            JP.go.ipa.oz.lib.standard._IOException_if e = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_1;
// 388
            return false;
          } else throw _exception_1;
        }
        catch (java.lang.SecurityException _exception_e) {
          JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
          
// 390
          return false;
        }
// 392
        return true;
      }
    } else {{
// 394
        return false;
      }
    }
  }
  
  public int targetsPut (JP.go.ipa.oz.lib.standard._String_if target) throws Exception  {
    checkSecureInvocation ();
// 434
    int put$val$70;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targets)) {
      try {
        put$val$70 = targets.put (target);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$70 = targets.put (target);
    }
// 434
    return put$val$70;
  }
  
  public JP.go.ipa.oz.lib.standard._Dictionary_if millorsGet (JP.go.ipa.oz.lib.standard._String_if target) throws Exception  {
    checkSecureInvocation ();
// 522
    JP.go.ipa.oz.lib.standard._Dictionary_if get$val$71;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) millors)) {
      try {
        get$val$71 = millors.get (target);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$71 = millors.get (target);
    }
// 522
    return get$val$71;
  }
  
  public void targetsRemove (JP.go.ipa.oz.lib.standard._String_if target) throws Exception  {
    checkSecureInvocation ();
// 456
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targets)) {
      try {
        targets.remove (target);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      targets.remove (target);
    }
  }
  
  protected void initiallize () throws Exception  {
  }
  
  protected void quiet () throws Exception  {
// 51
    super.quiet ();
// 52
    flushCell ();
  }
  
  protected JP.go.ipa.oz.lib.standard._String_if getTopPackageName (JP.go.ipa.oz.lib.standard._String_if codePath, JP.go.ipa.oz.lib.standard._String_if fileName) throws Exception  {
// 301
    JP.go.ipa.oz.lib.standard._String_if string$49 = (new JP.go.ipa.oz.lib.standard._String_cl("."));
    
// 301
    int lastIndexOf$val$72;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileName)) {
      try {
        lastIndexOf$val$72 = fileName.lastIndexOf (string$49);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$72 = fileName.lastIndexOf (string$49);
    }
// 301
    JP.go.ipa.oz.lib.standard._String_if substring$val$73;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fileName)) {
      try {
        substring$val$73 = fileName.substring (0, lastIndexOf$val$72);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$73 = fileName.substring (0, lastIndexOf$val$72);
    }
// 301
    JP.go.ipa.oz.lib.standard._String_if name = substring$val$73;
// 303
    JP.go.ipa.oz.lib.standard._String_if topPackageName = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (codePath);
// 304
    int ind = 0;
// 305
    while (true) {
// 305
      JP.go.ipa.oz.lib.standard._String_if string$50 = (new JP.go.ipa.oz.lib.standard._String_cl("."));
      
// 305
      int lastIndexOf$val$74;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) topPackageName)) {
        try {
          lastIndexOf$val$74 = topPackageName.lastIndexOf (string$50);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        lastIndexOf$val$74 = topPackageName.lastIndexOf (string$50);
      }
      if (!((ind = lastIndexOf$val$74) > -1)) break;
      
      /* body */ _loop_1: {
// 307
        JP.go.ipa.oz.lib.standard._String_if nameCand = null;
// 308
        JP.go.ipa.oz.lib.standard._String_if substring$val$75;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) topPackageName)) {
          try {
            substring$val$75 = topPackageName.substring (1 + ind);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          substring$val$75 = topPackageName.substring (1 + ind);
        }
// 308
        nameCand = substring$val$75;
// 310
        boolean isequal$val$76;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nameCand)) {
          try {
            isequal$val$76 = nameCand.isequal (name);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isequal$val$76 = nameCand.isequal (name);
        }
// 310
        if (isequal$val$76) {
// 310
          return topPackageName;
        } else {
// 311
          JP.go.ipa.oz.lib.standard._String_if substring$val$77;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) topPackageName)) {
            try {
              substring$val$77 = topPackageName.substring (0, ind);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            substring$val$77 = topPackageName.substring (0, ind);
          }
// 311
          topPackageName = substring$val$77;
        }
      }
    }
// 313
    return null;
  }
  
  public void stop () throws Exception  {
    checkSecureInvocation ();
// 43
    JP.go.ipa.oz.user.cda._CDAdebug_if debug = (JP.go.ipa.oz.user.cda._CDAdebug_cl) (new JP.go.ipa.oz.user.cda._CDAdebug_cl ())._new_create ();
// 44
    JP.go.ipa.oz.lib.standard._String_if string$51 = (new JP.go.ipa.oz.lib.standard._String_cl("CDA stopCDA begin"));
    
// 44
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.println (string$51);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.println (string$51);
    }
// 45
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ssr)) {
      try {
        ssr.close ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      ssr.close ();
    }
// 46
    JP.go.ipa.oz.lib.standard._String_if string$52 = (new JP.go.ipa.oz.lib.standard._String_cl("server socket closed"));
    
// 46
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.println (string$52);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.println (string$52);
    }
// 47
    stopCell ();
  }
  
  public void millorsRemoveTopPackageName (JP.go.ipa.oz.lib.standard._String_if target, JP.go.ipa.oz.lib.standard._String_if name) throws Exception  {
    checkSecureInvocation ();
// 505
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) millors)) {
      try {
        millors.removeTopPackageName (target, name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      millors.removeTopPackageName (target, name);
    }
  }
  
  public JP.go.ipa.oz.user.cda._DeliveryFile_if searchAndDelivery (JP.go.ipa.oz.lib.standard._String_if codePath) throws Exception  {
    checkSecureInvocation ();
// 264
    JP.go.ipa.oz.user.cda._CDAdebug_if debug = (JP.go.ipa.oz.user.cda._CDAdebug_cl) (new JP.go.ipa.oz.user.cda._CDAdebug_cl ())._new_create ();
// 265
    JP.go.ipa.oz.lib.standard._File_if f = null;
// 266
    try {
// 267
      f = JP.go.ipa.oz.lib.standard._LocalRepositoryManager_cl._static_get (codePath);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_2) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_2 = _exception_2.getOzException ();
      if (_oz_exception_2 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
        JP.go.ipa.oz.lib.standard._IOException_if e = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_2;
// 278
        JP.go.ipa.oz.lib.standard._String_if string$53 = (new JP.go.ipa.oz.lib.standard._String_cl("searchAndDelivery IO exception"));
        
// 278
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
          try {
            debug.println (string$53);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          debug.println (string$53);
        }
// 279
        return null;
      } else throw _exception_2;
    }
    catch (JP.go.ipa.oz.system.ExClassNotFoundException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 275
      debug.println ((new JP.go.ipa.oz.lib.standard._String_cl("LocalRepositoryManager can not find")));
// 276
      return null;
    }
// 281
    int length = 0;
// 281
    long length$val$78;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
      try {
        length$val$78 = f.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$78 = f.length ();
    }
// 281
    length = (int) (length$val$78);
// 282
    JP.go.ipa.oz.lib.standard._Integer_if I = (JP.go.ipa.oz.lib.standard._Integer_cl) (new JP.go.ipa.oz.lib.standard._Integer_cl ())._new_breed (length);
// 282
    JP.go.ipa.oz.lib.standard._String_if asString$val$79;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) I)) {
      try {
        asString$val$79 = I.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$79 = I.asString ();
    }
// 282
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.println (asString$val$79);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.println (asString$val$79);
    }
// 283
    JP.go.ipa.oz.lib.standard._FileInputStream_if fis = (JP.go.ipa.oz.lib.standard._FileInputStream_cl) (new JP.go.ipa.oz.lib.standard._FileInputStream_cl ())._new_breed (f);
// 284
    JP.go.ipa.oz.lib.standard._ByteArray_if buffer = (JP.go.ipa.oz.lib.standard._ByteArray_cl) (new JP.go.ipa.oz.lib.standard._ByteArray_cl ())._new_create (length);
// 285
    JP.go.ipa.oz.lib.standard._String_if string$54 = (new JP.go.ipa.oz.lib.standard._String_cl("begin buffer"));
    
// 285
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.println (string$54);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.println (string$54);
    }
// 286
    int read$val$80;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fis)) {
      try {
        read$val$80 = fis.read (buffer);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      read$val$80 = fis.read (buffer);
    }
// 286
    if (read$val$80 != length) {{
// 287
        JP.go.ipa.oz.lib.standard._String_if string$55 = (new JP.go.ipa.oz.lib.standard._String_cl("buffer fail"));
        
// 287
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
          try {
            debug.println (string$55);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          debug.println (string$55);
        }
// 288
        return null;
      }
    }
// 290
    JP.go.ipa.oz.lib.standard._String_if getName$val$81;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) f)) {
      try {
        getName$val$81 = f.getName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getName$val$81 = f.getName ();
    }
// 290
    JP.go.ipa.oz.lib.standard._String_if fileName = getName$val$81;
// 291
    JP.go.ipa.oz.lib.standard._String_if topPackageName = getTopPackageName (codePath, fileName);
// 292
    if (topPackageName == null) {
// 292
      return null;
    }
// 293
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.println (topPackageName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.println (topPackageName);
    }
// 294
    JP.go.ipa.oz.user.cda._DeliveryFile_if df = (JP.go.ipa.oz.user.cda._DeliveryFile_cl) (new JP.go.ipa.oz.user.cda._DeliveryFile_cl ())._new_create (codePath, topPackageName, length, buffer);
// 295
    JP.go.ipa.oz.lib.standard._String_if string$56 = (new JP.go.ipa.oz.lib.standard._String_cl("end buffer"));
    
// 295
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
      try {
        debug.println (string$56);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      debug.println (string$56);
    }
// 296
    return df;
  }
  
  protected boolean isSecurityOKasMillorClient () throws Exception  {
// 569
    return true;
  }
  
  public void millorsAdd (JP.go.ipa.oz.lib.standard._String_if target) throws Exception  {
    checkSecureInvocation ();
// 467
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) millors)) {
      try {
        millors.add (target);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      millors.add (target);
    }
  }
  
  public void millorsWriteStart () throws Exception  {
    checkSecureInvocation ();
// 555
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) copyOR)) {
      try {
        copyOR.copyStart ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      copyOR.copyStart ();
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Array_if targetsTargets () throws Exception  {
    checkSecureInvocation ();
// 424
    JP.go.ipa.oz.lib.standard._Array_if targets$val$82;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targets)) {
      try {
        targets$val$82 = targets.targets ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      targets$val$82 = targets.targets ();
    }
// 424
    return targets$val$82;
  }
  
  public void modeWriteInValid () throws Exception  {
    checkSecureInvocation ();
// 538
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) copyOR)) {
      try {
        copyOR.modeWIV ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      copyOR.modeWIV ();
    }
  }
  
  public void setInterval (int interval) throws Exception  {
    checkSecureInvocation ();
// 563
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) copyOR)) {
      try {
        copyOR.setInterval (interval);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      copyOR.setInterval (interval);
    }
// 564
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) polling)) {
      try {
        polling.setInterval (interval);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      polling.setInterval (interval);
    }
  }
  
  public void modeCopyOnWrite () throws Exception  {
    checkSecureInvocation ();
// 545
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) copyOR)) {
      try {
        copyOR.modeCOW ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      copyOR.modeCOW ();
    }
  }
  
  public JP.go.ipa.oz.lib.standard._ClassFile_if getClassFile (JP.go.ipa.oz.lib.standard._String_if codePath) throws Exception  {
    checkSecureInvocation ();
// 599
    JP.go.ipa.oz.lib.standard._ClassFile_if cf = (JP.go.ipa.oz.lib.standard._ClassFile_cl) (new JP.go.ipa.oz.lib.standard._ClassFile_cl ())._new_create (codePath);
// 601
    return cf;
  }
  
  protected void go () throws Exception  {
// 55
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 56
    JP.go.ipa.oz.user.cda._CDAdebug_if debug = (JP.go.ipa.oz.user.cda._CDAdebug_cl) (new JP.go.ipa.oz.user.cda._CDAdebug_cl ())._new_create ();
// 57
    JP.go.ipa.oz.lib.standard._Array_if args = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (16);
// 57
    JP.go.ipa.oz.lib.standard._Array_if getArguments$val$83;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getArguments$val$83 = system.getArguments ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getArguments$val$83 = system.getArguments ();
    }
// 57
    args = getArguments$val$83;
// 60
    cache = (JP.go.ipa.oz.user.cda._DeliveryFileCache_cl) (new JP.go.ipa.oz.user.cda._DeliveryFileCache_cl ())._new_create ();
// 63
    targets = (JP.go.ipa.oz.user.cda._TargetCDAList_cl) (new JP.go.ipa.oz.user.cda._TargetCDAList_cl ())._new_create ();
// 66
    host = JP.go.ipa.oz.user.cda._CDAProperty_cl._static_getHost ();
// 67
    if (host == null) {{
// 68
        JP.go.ipa.oz.lib.standard._String_if string$57 = (new JP.go.ipa.oz.lib.standard._String_cl("Error! -- host of oz.classloader.deliveryAgent.url in oz.properties. cda can not go."));
        
// 68
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.println (string$57);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.println (string$57);
        }
// 69
        stopCell ();
      }
    } else {{
// 71
        port = JP.go.ipa.oz.user.cda._CDAProperty_cl._static_getPort ();
// 72
        if (port == -1) {{
// 73
            JP.go.ipa.oz.lib.standard._String_if string$58 = (new JP.go.ipa.oz.lib.standard._String_cl("Error! -- port of oz.classloader.deliveryAgent.url in oz.properties. cda can not go."));
            
// 73
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
              try {
                system.println (string$58);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              system.println (string$58);
            }
// 74
            stopCell ();
          }
        } else {{
// 93
            ssr = (JP.go.ipa.oz.user.cda._ServerSocketRunnable_cl) (new JP.go.ipa.oz.user.cda._ServerSocketRunnable_cl ())._new_create (port, cache, targets);
// 94
            JP.go.ipa.oz.lang._Thread_if t = (JP.go.ipa.oz.lang._Thread_cl) (new JP.go.ipa.oz.lang._Thread_cl ())._new_create (ssr);
// 97
            millors = (JP.go.ipa.oz.user.cda._MillorTarget_cl) (new JP.go.ipa.oz.user.cda._MillorTarget_cl ())._new_create (true);
// 98
            millorsS = (JP.go.ipa.oz.user.cda._MillorTarget_cl) (new JP.go.ipa.oz.user.cda._MillorTarget_cl ())._new_create (false);
// 99
            polling = (JP.go.ipa.oz.user.cda._PollingRunnable_cl) (new JP.go.ipa.oz.user.cda._PollingRunnable_cl ())._new_create (millors, cache);
// 100
            JP.go.ipa.oz.lang._Thread_if tMil = (JP.go.ipa.oz.lang._Thread_cl) (new JP.go.ipa.oz.lang._Thread_cl ())._new_create (polling);
// 101
            JP.go.ipa.oz.lib.standard._String_if string$59 = (new JP.go.ipa.oz.lib.standard._String_cl("millor5"));
            
// 101
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
              try {
                debug.println (string$59);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              debug.println (string$59);
            }
// 102
            copyOR = (JP.go.ipa.oz.user.cda._CopyOnRightRunnable_cl) (new JP.go.ipa.oz.user.cda._CopyOnRightRunnable_cl ())._new_create (millors, cache, false);
// 103
            JP.go.ipa.oz.lib.standard._String_if string$60 = (new JP.go.ipa.oz.lib.standard._String_cl("millor6"));
            
// 103
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
              try {
                debug.println (string$60);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              debug.println (string$60);
            }
// 104
            JP.go.ipa.oz.lang._Thread_if tCop = (JP.go.ipa.oz.lang._Thread_cl) (new JP.go.ipa.oz.lang._Thread_cl ())._new_create (copyOR);
// 107
            setInitial ();
// 110
            JP.go.ipa.oz.lib.standard._String_if mes = null;
// 111
            JP.go.ipa.oz.lib.standard._String_if string$61 = (new JP.go.ipa.oz.lib.standard._String_cl("CDA start."));
            
// 111
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
              try {
                system.println (string$61);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              system.println (string$61);
            }
// 112
            mes = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("ozclass socket host is ")));
// 112
            mes = mes.concat (host);
// 113
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
              try {
                system.println (mes);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              system.println (mes);
            }
// 114
            JP.go.ipa.oz.lib.standard._Integer_if Port = (JP.go.ipa.oz.lib.standard._Integer_cl) (new JP.go.ipa.oz.lib.standard._Integer_cl ())._new_breed (port);
// 115
            mes = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("ozclass socket port is ")));
// 116
            JP.go.ipa.oz.lib.standard._String_if asString$val$84;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) Port)) {
              try {
                asString$val$84 = Port.asString ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              asString$val$84 = Port.asString ();
            }
// 116
            mes = mes.concat (asString$val$84);
// 117
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
              try {
                system.println (mes);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              system.println (mes);
            }
// 120
            if (millorOn) {{
// 121
                JP.go.ipa.oz.lib.standard._String_if string$62 = (new JP.go.ipa.oz.lib.standard._String_cl("polling"));
                
// 121
                boolean isequal$val$85;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) millorMode)) {
                  try {
                    isequal$val$85 = millorMode.isequal (string$62);
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  isequal$val$85 = millorMode.isequal (string$62);
                }
// 121
                if (isequal$val$85) {{
// 122
                    sleepThread (1000);
// 123
                    millorsPollingStart ();
// 124
                    JP.go.ipa.oz.lib.standard._String_if string$63 = (new JP.go.ipa.oz.lib.standard._String_cl("polling milloring start"));
                    
// 124
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
                      try {
                        debug.println (string$63);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      debug.println (string$63);
                    }
                  }
                } else {{
// 126
                    sleepThread (1000);
// 127
                    millorsWriteStart ();
// 128
                    JP.go.ipa.oz.lib.standard._String_if string$64 = (new JP.go.ipa.oz.lib.standard._String_cl("WIV or COW milloring start"));
                    
// 128
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) debug)) {
                      try {
                        debug.println (string$64);
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      debug.println (string$64);
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
  
  public void targetsSetLeaveTo (JP.go.ipa.oz.lib.standard._String_if whom) throws Exception  {
    checkSecureInvocation ();
// 416
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targets)) {
      try {
        targets.setLeaveTo (whom);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      targets.setLeaveTo (whom);
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if targetsLeaveToWhom () throws Exception  {
    checkSecureInvocation ();
// 406
    JP.go.ipa.oz.lib.standard._String_if leaveToWhom$val$86;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) targets)) {
      try {
        leaveToWhom$val$86 = targets.leaveToWhom ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      leaveToWhom$val$86 = targets.leaveToWhom ();
    }
// 406
    return leaveToWhom$val$86;
  }
  
  public boolean thisCopyOnRight (JP.go.ipa.oz.user.cda._DeliveryFile_if df) throws Exception  {
    checkSecureInvocation ();
// 357
    JP.go.ipa.oz.lib.standard._String_if getTopPackageName$val$87;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) df)) {
      try {
        getTopPackageName$val$87 = df.getTopPackageName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getTopPackageName$val$87 = df.getTopPackageName ();
    }
// 357
    JP.go.ipa.oz.lib.standard._String_if topPackageName = getTopPackageName$val$87;
    boolean bool$val$4;
    
    bool$val$4 = (isSecurityOKasMillorServer ());
    if (bool$val$4) {
      bool$val$4 = (isMillorOK (topPackageName));
    }
// 358
    if (bool$val$4) {{
// 359
        try {
// 360
          JP.go.ipa.oz.lib.standard._LocalRepositoryManager_cl._static_remove (topPackageName);
// 361
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cache)) {
            try {
              cache.put (topPackageName, df);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            cache.put (topPackageName, df);
          }
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_3) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_3 = _exception_3.getOzException ();
          if (_oz_exception_3 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
            JP.go.ipa.oz.lib.standard._IOException_if e = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_3;
// 363
            return false;
          } else throw _exception_3;
        }
        catch (java.lang.SecurityException _exception_e) {
          JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
          
// 365
          return false;
        }
// 367
        return true;
      }
    } else {{
// 369
        return false;
      }
    }
  }
  
  public void millorsPollingStart () throws Exception  {
    checkSecureInvocation ();
// 531
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) polling)) {
      try {
        polling.pollingStart ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      polling.pollingStart ();
    }
  }
  
  public _ClassDeliveryAgent_cl () { super ("JP.go.ipa.oz.user.cda._ClassDeliveryAgent_pcl"); }
  
  public _ClassDeliveryAgent_cl (String proxy_id) { super (proxy_id); }
  
}


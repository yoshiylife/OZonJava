package JP.go.ipa.oz.user.lib_dist.name;

public class _NameServerTransaction_cl extends JP.go.ipa.oz.user.lib_dist.tran._Transaction_cl implements JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_if {
  static final boolean _global_ = true;
  JP.go.ipa.oz.lib.standard._String_if smtrGOL;
  JP.go.ipa.oz.lib.standard._String_if selfGOL;
  JP.go.ipa.oz.user.lib_dist.name._SystemMapTransactionResource_if smtr;
  JP.go.ipa.oz.lib.standard._String_if nstrGOL;
  JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_if nstr;
  
  public JP.go.ipa.oz.lang._Root_if renameEntry (JP.go.ipa.oz.user.lib_dist.name._Path_if source, JP.go.ipa.oz.user.lib_dist.name._Path_if target) throws Exception  {
    checkSecureInvocation ();
// 364
    JP.go.ipa.oz.lang._Root_if obj = null;
// 365
    begin ();
// 366
    JP.go.ipa.oz.lib.standard._Array_if res = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (1);
// 367
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$122;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$122 = res.putAt (0, nstrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$122 = res.putAt (0, nstrGOL);
    }
// 367
    lock (res);
// 368
    try {
// 369
      JP.go.ipa.oz.lang._Root_if renameEntry$val$123;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nstr)) {
        try {
          renameEntry$val$123 = nstr.renameEntry (source, target);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        renameEntry$val$123 = nstr.renameEntry (source, target);
      }
// 369
      obj = renameEntry$val$123;
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_1) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
      if (_oz_exception_1 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_1;
// 371
        JP.go.ipa.oz.lib.standard._Array_if putAt$val$124;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
          try {
            putAt$val$124 = res.putAt (0, smtrGOL);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          putAt$val$124 = res.putAt (0, smtrGOL);
        }
// 371
        lock (res);
// 372
        try {
// 373
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if FindOwner$val$125;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
            try {
              FindOwner$val$125 = smtr.FindOwner (source);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            FindOwner$val$125 = smtr.FindOwner (source);
          }
// 373
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if smv = FindOwner$val$125;
// 374
          JP.go.ipa.oz.lib.standard._String_if nameserverGOL$val$126;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              nameserverGOL$val$126 = smv.nameserverGOL ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nameserverGOL$val$126 = smv.nameserverGOL ();
          }
// 374
          JP.go.ipa.oz.lib.standard._String_if ownerGOL = nameserverGOL$val$126;
// 375
          JP.go.ipa.oz.user.lib_dist.name._Path_if tranpath$val$127;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              tranpath$val$127 = smv.tranpath ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            tranpath$val$127 = smv.tranpath ();
          }
// 375
          source = tranpath$val$127;
// 376
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if FindOwner$val$128;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
            try {
              FindOwner$val$128 = smtr.FindOwner (target);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            FindOwner$val$128 = smtr.FindOwner (target);
          }
// 376
          smv = FindOwner$val$128;
// 377
          JP.go.ipa.oz.user.lib_dist.name._Path_if tranpath$val$129;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              tranpath$val$129 = smv.tranpath ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            tranpath$val$129 = smv.tranpath ();
          }
// 377
          target = tranpath$val$129;
// 378
          boolean ismapping$val$130;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              ismapping$val$130 = smv.ismapping ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            ismapping$val$130 = smv.ismapping ();
          }
// 378
          if (ismapping$val$130) {{
// 379
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_pcl (ownerGOL);
// 380
              JP.go.ipa.oz.lang._Root_if renameEntry$val$131;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  renameEntry$val$131 = owner.renameEntry (source, target);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                renameEntry$val$131 = owner.renameEntry (source, target);
              }
// 380
              obj = renameEntry$val$131;
            }
          } else {{
// 382
              JP.go.ipa.oz.lib.standard._Array_if putAt$val$132;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
                try {
                  putAt$val$132 = res.putAt (0, ownerGOL);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                putAt$val$132 = res.putAt (0, ownerGOL);
              }
// 382
              lock (res);
// 383
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_pcl (ownerGOL);
// 384
              JP.go.ipa.oz.lang._Root_if renameEntry$val$133;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  renameEntry$val$133 = owner.renameEntry (source, target);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                renameEntry$val$133 = owner.renameEntry (source, target);
              }
// 384
              obj = renameEntry$val$133;
            }
          }
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_2) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_2 = _exception_2.getOzException ();
          if (_oz_exception_2 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_2;
// 386
            throw new JP.go.ipa.oz.lang.OzException (ee);
          } else if (_oz_exception_2 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_2;
// 388
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if eee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl ())._new_init ();
// 388
            throw new JP.go.ipa.oz.lang.OzException (eee);
          } else throw _exception_2;
        }
      } else throw _exception_1;
    }
// 391
    commit ();
// 392
    return obj;
  }
  
  public void putDirectoryAsBranch (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 101
    begin ();
// 102
    JP.go.ipa.oz.lib.standard._Array_if res = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (2);
// 103
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$134;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$134 = res.putAt (0, smtrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$134 = res.putAt (0, smtrGOL);
    }
// 103
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$135;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$135 = res.putAt (1, nstrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$135 = res.putAt (1, nstrGOL);
    }
// 104
    lock (res);
// 106
    try {
// 107
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nstr)) {
        try {
          nstr.putDirectoryAsBranch (path);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        nstr.putDirectoryAsBranch (path);
      }
// 108
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
        try {
          smtr.putBranch (path, nstrGOL);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        smtr.putBranch (path, nstrGOL);
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_3) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_3 = _exception_3.getOzException ();
      if (_oz_exception_3 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_3;
// 109
        throw new JP.go.ipa.oz.lang.OzException (e);
      } else throw _exception_3;
    }
// 110
    commit ();
  }
  
  public void putDirectoryAsBranch (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if dir) throws Exception  {
    checkSecureInvocation ();
// 82
    begin ();
// 83
    JP.go.ipa.oz.lib.standard._Array_if res = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (2);
// 84
    JP.go.ipa.oz.lib.standard._String_if string$106 = (new JP.go.ipa.oz.lib.standard._String_cl("smtr"));
    
// 84
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$136;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$136 = res.putAt (0, string$106);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$136 = res.putAt (0, string$106);
    }
// 84
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$137;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$137 = res.putAt (1, nstrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$137 = res.putAt (1, nstrGOL);
    }
// 85
    lock (res);
// 87
    try {
// 88
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nstr)) {
        try {
          nstr.putDirectoryAsBranch (path, dir);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        nstr.putDirectoryAsBranch (path, dir);
      }
// 89
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
        try {
          smtr.putBranch (path, nstrGOL);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        smtr.putBranch (path, nstrGOL);
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_4) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_4 = _exception_4.getOzException ();
      if (_oz_exception_4 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_4;
// 90
        throw new JP.go.ipa.oz.lang.OzException (e);
      } else throw _exception_4;
    }
// 91
    commit ();
  }
  
  public int EntrySize (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 401
    int size = 0;
// 402
    begin ();
// 403
    JP.go.ipa.oz.lib.standard._Array_if res = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (1);
// 404
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$138;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$138 = res.putAt (0, nstrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$138 = res.putAt (0, nstrGOL);
    }
// 404
    lock (res);
// 405
    try {
// 406
      int EntrySize$val$139;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nstr)) {
        try {
          EntrySize$val$139 = nstr.EntrySize (path);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        EntrySize$val$139 = nstr.EntrySize (path);
      }
// 406
      size = EntrySize$val$139;
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_5) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_5 = _exception_5.getOzException ();
      if (_oz_exception_5 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_5;
// 408
        JP.go.ipa.oz.lib.standard._Array_if putAt$val$140;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
          try {
            putAt$val$140 = res.putAt (0, smtrGOL);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          putAt$val$140 = res.putAt (0, smtrGOL);
        }
// 408
        lock (res);
// 409
        try {
// 410
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if FindOwner$val$141;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
            try {
              FindOwner$val$141 = smtr.FindOwner (path);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            FindOwner$val$141 = smtr.FindOwner (path);
          }
// 410
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if smv = FindOwner$val$141;
// 411
          JP.go.ipa.oz.lib.standard._String_if nameserverGOL$val$142;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              nameserverGOL$val$142 = smv.nameserverGOL ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nameserverGOL$val$142 = smv.nameserverGOL ();
          }
// 411
          JP.go.ipa.oz.lib.standard._String_if ownerGOL = nameserverGOL$val$142;
// 412
          JP.go.ipa.oz.user.lib_dist.name._Path_if tranpath$val$143;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              tranpath$val$143 = smv.tranpath ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            tranpath$val$143 = smv.tranpath ();
          }
// 412
          path = tranpath$val$143;
// 413
          boolean ismapping$val$144;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              ismapping$val$144 = smv.ismapping ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            ismapping$val$144 = smv.ismapping ();
          }
// 413
          if (ismapping$val$144) {{
// 414
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_pcl (ownerGOL);
// 415
              int EntrySize$val$145;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  EntrySize$val$145 = owner.EntrySize (path);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                EntrySize$val$145 = owner.EntrySize (path);
              }
// 415
              size = EntrySize$val$145;
            }
          } else {{
// 417
              JP.go.ipa.oz.lib.standard._Array_if putAt$val$146;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
                try {
                  putAt$val$146 = res.putAt (0, ownerGOL);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                putAt$val$146 = res.putAt (0, ownerGOL);
              }
// 417
              lock (res);
// 418
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_pcl (ownerGOL);
// 419
              int EntrySize$val$147;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  EntrySize$val$147 = owner.EntrySize (path);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                EntrySize$val$147 = owner.EntrySize (path);
              }
// 419
              size = EntrySize$val$147;
            }
          }
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_6) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_6 = _exception_6.getOzException ();
          if (_oz_exception_6 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_6;
// 421
            throw new JP.go.ipa.oz.lang.OzException (ee);
          } else if (_oz_exception_6 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_6;
// 423
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if eee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl ())._new_init ();
// 423
            throw new JP.go.ipa.oz.lang.OzException (eee);
          } else throw _exception_6;
        }
      } else throw _exception_5;
    }
// 426
    commit ();
// 427
    return size;
  }
  
  public JP.go.ipa.oz.lang._Root_if getEntry (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 285
    JP.go.ipa.oz.lang._Root_if obj = null;
// 286
    begin ();
// 287
    JP.go.ipa.oz.lib.standard._Array_if res = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (1);
// 288
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$148;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$148 = res.putAt (0, nstrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$148 = res.putAt (0, nstrGOL);
    }
// 288
    lock (res);
// 289
    try {
// 290
      JP.go.ipa.oz.lang._Root_if getEntry$val$149;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nstr)) {
        try {
          getEntry$val$149 = nstr.getEntry (path);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getEntry$val$149 = nstr.getEntry (path);
      }
// 290
      obj = getEntry$val$149;
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_7) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_7 = _exception_7.getOzException ();
      if (_oz_exception_7 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_7;
// 292
        JP.go.ipa.oz.lib.standard._Array_if putAt$val$150;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
          try {
            putAt$val$150 = res.putAt (0, smtrGOL);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          putAt$val$150 = res.putAt (0, smtrGOL);
        }
// 292
        lock (res);
// 293
        try {
// 294
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if FindOwner$val$151;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
            try {
              FindOwner$val$151 = smtr.FindOwner (path);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            FindOwner$val$151 = smtr.FindOwner (path);
          }
// 294
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if smv = FindOwner$val$151;
// 295
          JP.go.ipa.oz.lib.standard._String_if nameserverGOL$val$152;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              nameserverGOL$val$152 = smv.nameserverGOL ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nameserverGOL$val$152 = smv.nameserverGOL ();
          }
// 295
          JP.go.ipa.oz.lib.standard._String_if ownerGOL = nameserverGOL$val$152;
// 296
          JP.go.ipa.oz.user.lib_dist.name._Path_if tranpath$val$153;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              tranpath$val$153 = smv.tranpath ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            tranpath$val$153 = smv.tranpath ();
          }
// 296
          path = tranpath$val$153;
// 297
          boolean ismapping$val$154;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              ismapping$val$154 = smv.ismapping ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            ismapping$val$154 = smv.ismapping ();
          }
// 297
          if (ismapping$val$154) {{
// 298
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_pcl (ownerGOL);
// 299
              JP.go.ipa.oz.lang._Root_if getEntry$val$155;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  getEntry$val$155 = owner.getEntry (path);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getEntry$val$155 = owner.getEntry (path);
              }
// 299
              obj = getEntry$val$155;
            }
          } else {{
// 301
              JP.go.ipa.oz.lib.standard._Array_if putAt$val$156;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
                try {
                  putAt$val$156 = res.putAt (0, ownerGOL);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                putAt$val$156 = res.putAt (0, ownerGOL);
              }
// 301
              lock (res);
// 302
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_pcl (ownerGOL);
// 303
              JP.go.ipa.oz.lang._Root_if getEntry$val$157;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  getEntry$val$157 = owner.getEntry (path);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getEntry$val$157 = owner.getEntry (path);
              }
// 303
              obj = getEntry$val$157;
            }
          }
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_8) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_8 = _exception_8.getOzException ();
          if (_oz_exception_8 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_8;
// 305
            throw new JP.go.ipa.oz.lang.OzException (ee);
          } else if (_oz_exception_8 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_8;
// 307
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if eee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl ())._new_init ();
// 307
            throw new JP.go.ipa.oz.lang.OzException (eee);
          } else throw _exception_8;
        }
      } else throw _exception_7;
    }
// 310
    commit ();
// 311
    return obj;
  }
  
  protected void initialize () throws Exception  {
// 15
    d = (JP.go.ipa.oz.user.lib_dist.tran._Debug_cl) (new JP.go.ipa.oz.user.lib_dist.tran._Debug_cl ())._new_create ();
// 15
    x = 0;
// 16
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 16
    JP.go.ipa.oz.lib.standard._Array_if args = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (16);
// 17
    JP.go.ipa.oz.lib.standard._Array_if getArguments$val$158;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getArguments$val$158 = system.getArguments ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getArguments$val$158 = system.getArguments ();
    }
// 17
    args = getArguments$val$158;
// 18
    JP.go.ipa.oz.lang._Root_if at$val$159;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
      try {
        at$val$159 = args.at (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$159 = args.at (0);
    }
// 18
    selfGOL = (JP.go.ipa.oz.lib.standard._String_if) (at$val$159);
// 19
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.setP (selfGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.setP (selfGOL);
    }
// 20
    super.initialize (selfGOL);
// 21
    JP.go.ipa.oz.lang._Root_if at$val$160;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
      try {
        at$val$160 = args.at (1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$160 = args.at (1);
    }
// 21
    nstrGOL = (JP.go.ipa.oz.lib.standard._String_if) (at$val$160);
// 22
    nstr = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_pcl (nstrGOL);
// 23
    JP.go.ipa.oz.lang._Root_if at$val$161;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
      try {
        at$val$161 = args.at (2);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$161 = args.at (2);
    }
// 23
    smtrGOL = (JP.go.ipa.oz.lib.standard._String_if) (at$val$161);
// 24
    smtr = new JP.go.ipa.oz.user.lib_dist.name._SystemMapTransactionResource_pcl (smtrGOL);
  }
  
  public JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if removeDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 640
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd = null;
// 641
    begin ();
// 642
    JP.go.ipa.oz.lib.standard._Array_if res = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (1);
// 643
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$162;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$162 = res.putAt (0, nstrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$162 = res.putAt (0, nstrGOL);
    }
// 643
    lock (res);
// 644
    try {
// 645
      JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if removeDirectory$val$163;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nstr)) {
        try {
          removeDirectory$val$163 = nstr.removeDirectory (path);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        removeDirectory$val$163 = nstr.removeDirectory (path);
      }
// 645
      nd = removeDirectory$val$163;
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_9) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_9 = _exception_9.getOzException ();
      if (_oz_exception_9 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_9;
// 647
        JP.go.ipa.oz.lib.standard._Array_if putAt$val$164;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
          try {
            putAt$val$164 = res.putAt (0, smtrGOL);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          putAt$val$164 = res.putAt (0, smtrGOL);
        }
// 647
        lock (res);
// 648
        try {
// 649
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if FindOwner$val$165;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
            try {
              FindOwner$val$165 = smtr.FindOwner (path);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            FindOwner$val$165 = smtr.FindOwner (path);
          }
// 649
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if smv = FindOwner$val$165;
// 650
          JP.go.ipa.oz.lib.standard._String_if nameserverGOL$val$166;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              nameserverGOL$val$166 = smv.nameserverGOL ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nameserverGOL$val$166 = smv.nameserverGOL ();
          }
// 650
          JP.go.ipa.oz.lib.standard._String_if ownerGOL = nameserverGOL$val$166;
// 651
          JP.go.ipa.oz.user.lib_dist.name._Path_if tranpath$val$167;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              tranpath$val$167 = smv.tranpath ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            tranpath$val$167 = smv.tranpath ();
          }
// 651
          path = tranpath$val$167;
// 652
          boolean ismapping$val$168;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              ismapping$val$168 = smv.ismapping ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            ismapping$val$168 = smv.ismapping ();
          }
// 652
          if (ismapping$val$168) {{
// 653
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_pcl (ownerGOL);
// 654
              JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if removeDirectory$val$169;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  removeDirectory$val$169 = owner.removeDirectory (path);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                removeDirectory$val$169 = owner.removeDirectory (path);
              }
// 654
              nd = removeDirectory$val$169;
            }
          } else {{
// 656
              JP.go.ipa.oz.lib.standard._Array_if putAt$val$170;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
                try {
                  putAt$val$170 = res.putAt (0, ownerGOL);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                putAt$val$170 = res.putAt (0, ownerGOL);
              }
// 656
              lock (res);
// 657
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_pcl (ownerGOL);
// 658
              JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if removeDirectory$val$171;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  removeDirectory$val$171 = owner.removeDirectory (path);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                removeDirectory$val$171 = owner.removeDirectory (path);
              }
// 658
              nd = removeDirectory$val$171;
            }
          }
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_10) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_10 = _exception_10.getOzException ();
          if (_oz_exception_10 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_10;
// 660
            throw new JP.go.ipa.oz.lang.OzException (ee);
          } else if (_oz_exception_10 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_10;
// 662
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if eee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl ())._new_init ();
// 662
            throw new JP.go.ipa.oz.lang.OzException (eee);
          } else throw _exception_10;
        }
      } else throw _exception_9;
    }
// 665
    commit ();
// 666
    return nd;
  }
  
  public boolean containDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 557
    boolean tf = false;
// 558
    begin ();
// 559
    JP.go.ipa.oz.lib.standard._Array_if res = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (1);
// 560
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$172;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$172 = res.putAt (0, nstrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$172 = res.putAt (0, nstrGOL);
    }
// 560
    lock (res);
// 566
    boolean containDirectory$val$173;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nstr)) {
      try {
        containDirectory$val$173 = nstr.containDirectory (path);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      containDirectory$val$173 = nstr.containDirectory (path);
    }
// 566
    tf = containDirectory$val$173;
// 567
    if (!tf) {{
// 568
        JP.go.ipa.oz.lib.standard._Array_if putAt$val$174;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
          try {
            putAt$val$174 = res.putAt (0, smtrGOL);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          putAt$val$174 = res.putAt (0, smtrGOL);
        }
// 568
        lock (res);
// 569
        try {
// 570
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if FindOwner$val$175;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
            try {
              FindOwner$val$175 = smtr.FindOwner (path);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            FindOwner$val$175 = smtr.FindOwner (path);
          }
// 570
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if smv = FindOwner$val$175;
// 571
          JP.go.ipa.oz.lib.standard._String_if nameserverGOL$val$176;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              nameserverGOL$val$176 = smv.nameserverGOL ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nameserverGOL$val$176 = smv.nameserverGOL ();
          }
// 571
          JP.go.ipa.oz.lib.standard._String_if ownerGOL = nameserverGOL$val$176;
// 572
          JP.go.ipa.oz.user.lib_dist.name._Path_if tranpath$val$177;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              tranpath$val$177 = smv.tranpath ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            tranpath$val$177 = smv.tranpath ();
          }
// 572
          path = tranpath$val$177;
// 573
          boolean ismapping$val$178;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              ismapping$val$178 = smv.ismapping ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            ismapping$val$178 = smv.ismapping ();
          }
// 573
          if (ismapping$val$178) {{
// 574
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_pcl (ownerGOL);
// 575
              boolean containDirectory$val$179;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  containDirectory$val$179 = owner.containDirectory (path);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                containDirectory$val$179 = owner.containDirectory (path);
              }
// 575
              tf = containDirectory$val$179;
            }
          } else {{
// 577
              JP.go.ipa.oz.lib.standard._Array_if putAt$val$180;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
                try {
                  putAt$val$180 = res.putAt (0, ownerGOL);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                putAt$val$180 = res.putAt (0, ownerGOL);
              }
// 577
              lock (res);
// 578
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_pcl (ownerGOL);
// 579
              boolean containDirectory$val$181;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  containDirectory$val$181 = owner.containDirectory (path);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                containDirectory$val$181 = owner.containDirectory (path);
              }
// 579
              tf = containDirectory$val$181;
            }
          }
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_11) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_11 = _exception_11.getOzException ();
          if (_oz_exception_11 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_11;
// 587
            tf = false;
          } else if (_oz_exception_11 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_11;
// 588
            tf = false;
          } else throw _exception_11;
        }
      }
    }
// 591
    commit ();
// 592
    return tf;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if OwnerNSTR (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 136
    begin ();
// 137
    JP.go.ipa.oz.lib.standard._Array_if res = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (1);
// 138
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$182;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$182 = res.putAt (0, smtrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$182 = res.putAt (0, smtrGOL);
    }
// 139
    lock (res);
// 140
    JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if FindOwner$val$183;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
      try {
        FindOwner$val$183 = smtr.FindOwner (path);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      FindOwner$val$183 = smtr.FindOwner (path);
    }
// 140
    JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if smv = FindOwner$val$183;
// 141
    boolean ismapping$val$184;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
      try {
        ismapping$val$184 = smv.ismapping ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      ismapping$val$184 = smv.ismapping ();
    }
// 141
    if (ismapping$val$184) {{
// 142
        JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl ())._new_init ();
// 142
        throw new JP.go.ipa.oz.lang.OzException (e);
      }
    }
// 143
    JP.go.ipa.oz.lib.standard._String_if nameserverGOL$val$185;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
      try {
        nameserverGOL$val$185 = smv.nameserverGOL ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nameserverGOL$val$185 = smv.nameserverGOL ();
    }
// 143
    JP.go.ipa.oz.lib.standard._String_if ownerGOL = nameserverGOL$val$185;
// 144
    commit ();
// 145
    return ownerGOL;
  }
  
  public void unBranched (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 120
    begin ();
// 121
    JP.go.ipa.oz.lib.standard._Array_if res = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (2);
// 122
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$186;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$186 = res.putAt (0, smtrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$186 = res.putAt (0, smtrGOL);
    }
// 122
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$187;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$187 = res.putAt (1, nstrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$187 = res.putAt (1, nstrGOL);
    }
// 123
    lock (res);
// 125
    try {
// 126
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nstr)) {
        try {
          nstr.unBranched (path);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        nstr.unBranched (path);
      }
// 127
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
        try {
          smtr.unBranched (path);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        smtr.unBranched (path);
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_12) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_12 = _exception_12.getOzException ();
      if (_oz_exception_12 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_12;
// 128
        throw new JP.go.ipa.oz.lang.OzException (e);
      } else throw _exception_12;
    }
// 129
    commit ();
  }
  
  public void moveBranch (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.lib.standard._String_if toGOL) throws Exception  {
    checkSecureInvocation ();
// 58
    begin ();
// 59
    JP.go.ipa.oz.lib.standard._Array_if res = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (3);
// 60
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$188;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$188 = res.putAt (0, smtrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$188 = res.putAt (0, smtrGOL);
    }
// 60
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$189;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$189 = res.putAt (1, nstrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$189 = res.putAt (1, nstrGOL);
    }
// 60
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$190;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$190 = res.putAt (2, toGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$190 = res.putAt (2, toGOL);
    }
// 62
    lock (res);
// 63
    boolean containServer$val$191;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
      try {
        containServer$val$191 = smtr.containServer (toGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      containServer$val$191 = smtr.containServer (toGOL);
    }
// 63
    if (!(containServer$val$191)) {{
// 65
        JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl ())._new_init ();
// 65
        throw new JP.go.ipa.oz.lang.OzException (e);
      }
    }
// 68
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nstr)) {
      try {
        nstr.replaceBranch (path, toGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nstr.replaceBranch (path, toGOL);
    }
// 70
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
      try {
        smtr.replaceBranch (path, toGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      smtr.replaceBranch (path, toGOL);
    }
// 71
    commit ();
  }
  
  public void debugPrint () throws Exception  {
    checkSecureInvocation ();
// 42
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nstr)) {
      try {
        nstr.debugPrint ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nstr.debugPrint ();
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if DirectorySet (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 752
    JP.go.ipa.oz.lib.standard._Set_if dirs = null;
// 753
    begin ();
// 754
    JP.go.ipa.oz.lib.standard._Array_if res = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (1);
// 755
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$192;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$192 = res.putAt (0, nstrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$192 = res.putAt (0, nstrGOL);
    }
// 755
    lock (res);
// 756
    try {
// 757
      JP.go.ipa.oz.lib.standard._Set_if DirectorySet$val$193;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nstr)) {
        try {
          DirectorySet$val$193 = nstr.DirectorySet (path);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        DirectorySet$val$193 = nstr.DirectorySet (path);
      }
// 757
      dirs = DirectorySet$val$193;
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_13) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_13 = _exception_13.getOzException ();
      if (_oz_exception_13 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_13;
// 759
        JP.go.ipa.oz.lib.standard._Array_if putAt$val$194;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
          try {
            putAt$val$194 = res.putAt (0, smtrGOL);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          putAt$val$194 = res.putAt (0, smtrGOL);
        }
// 759
        lock (res);
// 760
        try {
// 761
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if FindOwner$val$195;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
            try {
              FindOwner$val$195 = smtr.FindOwner (path);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            FindOwner$val$195 = smtr.FindOwner (path);
          }
// 761
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if smv = FindOwner$val$195;
// 762
          JP.go.ipa.oz.lib.standard._String_if nameserverGOL$val$196;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              nameserverGOL$val$196 = smv.nameserverGOL ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nameserverGOL$val$196 = smv.nameserverGOL ();
          }
// 762
          JP.go.ipa.oz.lib.standard._String_if ownerGOL = nameserverGOL$val$196;
// 763
          JP.go.ipa.oz.user.lib_dist.name._Path_if tranpath$val$197;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              tranpath$val$197 = smv.tranpath ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            tranpath$val$197 = smv.tranpath ();
          }
// 763
          path = tranpath$val$197;
// 764
          boolean ismapping$val$198;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              ismapping$val$198 = smv.ismapping ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            ismapping$val$198 = smv.ismapping ();
          }
// 764
          if (ismapping$val$198) {{
// 765
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_pcl (ownerGOL);
// 766
              JP.go.ipa.oz.lib.standard._Set_if DirectorySet$val$199;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  DirectorySet$val$199 = owner.DirectorySet (path);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                DirectorySet$val$199 = owner.DirectorySet (path);
              }
// 766
              dirs = DirectorySet$val$199;
            }
          } else {{
// 768
              JP.go.ipa.oz.lib.standard._Array_if putAt$val$200;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
                try {
                  putAt$val$200 = res.putAt (0, ownerGOL);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                putAt$val$200 = res.putAt (0, ownerGOL);
              }
// 768
              lock (res);
// 769
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_pcl (ownerGOL);
// 770
              JP.go.ipa.oz.lib.standard._Set_if DirectorySet$val$201;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  DirectorySet$val$201 = owner.DirectorySet (path);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                DirectorySet$val$201 = owner.DirectorySet (path);
              }
// 770
              dirs = DirectorySet$val$201;
            }
          }
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_14) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_14 = _exception_14.getOzException ();
          if (_oz_exception_14 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_14;
// 772
            throw new JP.go.ipa.oz.lang.OzException (ee);
          } else if (_oz_exception_14 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_14;
// 774
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if eee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl ())._new_init ();
// 774
            throw new JP.go.ipa.oz.lang.OzException (eee);
          } else throw _exception_14;
        }
      } else throw _exception_13;
    }
// 777
    commit ();
// 778
    return dirs;
  }
  
  public JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if getDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 601
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd = null;
// 602
    begin ();
// 603
    JP.go.ipa.oz.lib.standard._Array_if res = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (1);
// 604
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$202;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$202 = res.putAt (0, nstrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$202 = res.putAt (0, nstrGOL);
    }
// 604
    lock (res);
// 605
    try {
// 606
      JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if getDirectory$val$203;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nstr)) {
        try {
          getDirectory$val$203 = nstr.getDirectory (path);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getDirectory$val$203 = nstr.getDirectory (path);
      }
// 606
      nd = getDirectory$val$203;
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_15) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_15 = _exception_15.getOzException ();
      if (_oz_exception_15 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_15;
// 608
        JP.go.ipa.oz.lib.standard._Array_if putAt$val$204;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
          try {
            putAt$val$204 = res.putAt (0, smtrGOL);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          putAt$val$204 = res.putAt (0, smtrGOL);
        }
// 608
        lock (res);
// 609
        try {
// 610
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if FindOwner$val$205;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
            try {
              FindOwner$val$205 = smtr.FindOwner (path);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            FindOwner$val$205 = smtr.FindOwner (path);
          }
// 610
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if smv = FindOwner$val$205;
// 611
          JP.go.ipa.oz.lib.standard._String_if nameserverGOL$val$206;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              nameserverGOL$val$206 = smv.nameserverGOL ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nameserverGOL$val$206 = smv.nameserverGOL ();
          }
// 611
          JP.go.ipa.oz.lib.standard._String_if ownerGOL = nameserverGOL$val$206;
// 612
          JP.go.ipa.oz.user.lib_dist.name._Path_if tranpath$val$207;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              tranpath$val$207 = smv.tranpath ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            tranpath$val$207 = smv.tranpath ();
          }
// 612
          path = tranpath$val$207;
// 613
          boolean ismapping$val$208;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              ismapping$val$208 = smv.ismapping ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            ismapping$val$208 = smv.ismapping ();
          }
// 613
          if (ismapping$val$208) {{
// 614
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_pcl (ownerGOL);
// 615
              JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if getDirectory$val$209;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  getDirectory$val$209 = owner.getDirectory (path);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getDirectory$val$209 = owner.getDirectory (path);
              }
// 615
              nd = getDirectory$val$209;
            }
          } else {{
// 617
              JP.go.ipa.oz.lib.standard._Array_if putAt$val$210;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
                try {
                  putAt$val$210 = res.putAt (0, ownerGOL);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                putAt$val$210 = res.putAt (0, ownerGOL);
              }
// 617
              lock (res);
// 618
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_pcl (ownerGOL);
// 619
              JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if getDirectory$val$211;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  getDirectory$val$211 = owner.getDirectory (path);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                getDirectory$val$211 = owner.getDirectory (path);
              }
// 619
              nd = getDirectory$val$211;
            }
          }
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_16) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_16 = _exception_16.getOzException ();
          if (_oz_exception_16 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_16;
// 621
            throw new JP.go.ipa.oz.lang.OzException (ee);
          } else if (_oz_exception_16 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_16;
// 623
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if eee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl ())._new_init ();
// 623
            throw new JP.go.ipa.oz.lang.OzException (eee);
          } else throw _exception_16;
        }
      } else throw _exception_15;
    }
// 626
    commit ();
// 627
    return nd;
  }
  
  public void setSystemMapTransactionResource (JP.go.ipa.oz.lib.standard._String_if s) throws Exception  {
    checkSecureInvocation ();
// 37
    smtrGOL = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (s);
// 38
    smtr = new JP.go.ipa.oz.user.lib_dist.name._SystemMapTransactionResource_pcl (smtrGOL);
  }
  
  public void setNameServerTransactionResource (JP.go.ipa.oz.lib.standard._String_if s) throws Exception  {
    checkSecureInvocation ();
// 32
    nstrGOL = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (s);
// 33
    nstr = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_pcl (nstrGOL);
  }
  
  public JP.go.ipa.oz.lang._Root_if removeEntry (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 321
    JP.go.ipa.oz.lang._Root_if obj = null;
// 322
    begin ();
// 323
    JP.go.ipa.oz.lib.standard._Array_if res = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (1);
// 324
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$212;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$212 = res.putAt (0, nstrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$212 = res.putAt (0, nstrGOL);
    }
// 324
    lock (res);
// 326
    try {
// 327
      JP.go.ipa.oz.lang._Root_if removeEntry$val$213;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nstr)) {
        try {
          removeEntry$val$213 = nstr.removeEntry (path);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        removeEntry$val$213 = nstr.removeEntry (path);
      }
// 327
      obj = removeEntry$val$213;
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_17) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_17 = _exception_17.getOzException ();
      if (_oz_exception_17 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_17;
// 330
        JP.go.ipa.oz.lib.standard._Array_if putAt$val$214;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
          try {
            putAt$val$214 = res.putAt (0, smtrGOL);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          putAt$val$214 = res.putAt (0, smtrGOL);
        }
// 330
        lock (res);
// 331
        try {
// 332
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if FindOwner$val$215;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
            try {
              FindOwner$val$215 = smtr.FindOwner (path);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            FindOwner$val$215 = smtr.FindOwner (path);
          }
// 332
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if smv = FindOwner$val$215;
// 334
          JP.go.ipa.oz.lib.standard._String_if nameserverGOL$val$216;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              nameserverGOL$val$216 = smv.nameserverGOL ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nameserverGOL$val$216 = smv.nameserverGOL ();
          }
// 334
          JP.go.ipa.oz.lib.standard._String_if ownerGOL = nameserverGOL$val$216;
// 335
          JP.go.ipa.oz.user.lib_dist.name._Path_if tranpath$val$217;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              tranpath$val$217 = smv.tranpath ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            tranpath$val$217 = smv.tranpath ();
          }
// 335
          path = tranpath$val$217;
// 336
          boolean ismapping$val$218;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              ismapping$val$218 = smv.ismapping ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            ismapping$val$218 = smv.ismapping ();
          }
// 336
          if (ismapping$val$218) {{
// 338
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_pcl (ownerGOL);
// 339
              JP.go.ipa.oz.lang._Root_if removeEntry$val$219;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  removeEntry$val$219 = owner.removeEntry (path);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                removeEntry$val$219 = owner.removeEntry (path);
              }
// 339
              obj = removeEntry$val$219;
            }
          } else {{
// 342
              JP.go.ipa.oz.lib.standard._Array_if putAt$val$220;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
                try {
                  putAt$val$220 = res.putAt (0, ownerGOL);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                putAt$val$220 = res.putAt (0, ownerGOL);
              }
// 342
              lock (res);
// 343
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_pcl (ownerGOL);
// 344
              JP.go.ipa.oz.lang._Root_if removeEntry$val$221;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  removeEntry$val$221 = owner.removeEntry (path);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                removeEntry$val$221 = owner.removeEntry (path);
              }
// 344
              obj = removeEntry$val$221;
            }
          }
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_18) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_18 = _exception_18.getOzException ();
          if (_oz_exception_18 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_18;
// 346
            throw new JP.go.ipa.oz.lang.OzException (ee);
          } else if (_oz_exception_18 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_18;
// 348
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if eee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl ())._new_init ();
// 348
            throw new JP.go.ipa.oz.lang.OzException (eee);
          } else throw _exception_18;
        }
      } else throw _exception_17;
    }
// 351
    commit ();
// 352
    return obj;
  }
  
  protected void quiet () throws Exception  {
// 29
    flushCell ();
  }
  
  public void removeNameServer () throws Exception  {
    checkSecureInvocation ();
// 162
    begin ();
// 163
    JP.go.ipa.oz.lib.standard._Array_if res = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (2);
// 164
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$222;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$222 = res.putAt (0, smtrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$222 = res.putAt (0, smtrGOL);
    }
// 164
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$223;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$223 = res.putAt (1, nstrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$223 = res.putAt (1, nstrGOL);
    }
// 165
    lock (res);
// 166
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
      try {
        smtr.RemoveNameServer (nstrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      smtr.RemoveNameServer (nstrGOL);
    }
// 167
    commit ();
  }
  
  public int DirectorySize (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 716
    int size = 0;
// 717
    begin ();
// 718
    JP.go.ipa.oz.lib.standard._Array_if res = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (1);
// 719
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$224;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$224 = res.putAt (0, nstrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$224 = res.putAt (0, nstrGOL);
    }
// 719
    lock (res);
// 720
    try {
// 721
      int DirectorySize$val$225;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nstr)) {
        try {
          DirectorySize$val$225 = nstr.DirectorySize (path);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        DirectorySize$val$225 = nstr.DirectorySize (path);
      }
// 721
      size = DirectorySize$val$225;
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_19) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_19 = _exception_19.getOzException ();
      if (_oz_exception_19 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_19;
// 723
        JP.go.ipa.oz.lib.standard._Array_if putAt$val$226;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
          try {
            putAt$val$226 = res.putAt (0, smtrGOL);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          putAt$val$226 = res.putAt (0, smtrGOL);
        }
// 723
        lock (res);
// 724
        try {
// 725
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if FindOwner$val$227;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
            try {
              FindOwner$val$227 = smtr.FindOwner (path);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            FindOwner$val$227 = smtr.FindOwner (path);
          }
// 725
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if smv = FindOwner$val$227;
// 726
          JP.go.ipa.oz.lib.standard._String_if nameserverGOL$val$228;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              nameserverGOL$val$228 = smv.nameserverGOL ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nameserverGOL$val$228 = smv.nameserverGOL ();
          }
// 726
          JP.go.ipa.oz.lib.standard._String_if ownerGOL = nameserverGOL$val$228;
// 727
          JP.go.ipa.oz.user.lib_dist.name._Path_if tranpath$val$229;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              tranpath$val$229 = smv.tranpath ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            tranpath$val$229 = smv.tranpath ();
          }
// 727
          path = tranpath$val$229;
// 728
          boolean ismapping$val$230;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              ismapping$val$230 = smv.ismapping ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            ismapping$val$230 = smv.ismapping ();
          }
// 728
          if (ismapping$val$230) {{
// 729
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_pcl (ownerGOL);
// 730
              int DirectorySize$val$231;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  DirectorySize$val$231 = owner.DirectorySize (path);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                DirectorySize$val$231 = owner.DirectorySize (path);
              }
// 730
              size = DirectorySize$val$231;
            }
          } else {{
// 732
              JP.go.ipa.oz.lib.standard._Array_if putAt$val$232;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
                try {
                  putAt$val$232 = res.putAt (0, ownerGOL);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                putAt$val$232 = res.putAt (0, ownerGOL);
              }
// 732
              lock (res);
// 733
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_pcl (ownerGOL);
// 734
              int DirectorySize$val$233;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  DirectorySize$val$233 = owner.DirectorySize (path);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                DirectorySize$val$233 = owner.DirectorySize (path);
              }
// 734
              size = DirectorySize$val$233;
            }
          }
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_20) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_20 = _exception_20.getOzException ();
          if (_oz_exception_20 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_20;
// 736
            throw new JP.go.ipa.oz.lang.OzException (ee);
          } else if (_oz_exception_20 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_20;
// 738
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if eee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl ())._new_init ();
// 738
            throw new JP.go.ipa.oz.lang.OzException (eee);
          } else throw _exception_20;
        }
      } else throw _exception_19;
    }
// 741
    commit ();
// 742
    return size;
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if EntrySet (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 437
    JP.go.ipa.oz.lib.standard._Set_if entries = null;
// 438
    begin ();
// 439
    JP.go.ipa.oz.lib.standard._Array_if res = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (1);
// 440
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$234;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$234 = res.putAt (0, nstrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$234 = res.putAt (0, nstrGOL);
    }
// 440
    lock (res);
// 441
    try {
// 442
      JP.go.ipa.oz.lib.standard._Set_if EntrySet$val$235;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nstr)) {
        try {
          EntrySet$val$235 = nstr.EntrySet (path);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        EntrySet$val$235 = nstr.EntrySet (path);
      }
// 442
      entries = EntrySet$val$235;
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_21) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_21 = _exception_21.getOzException ();
      if (_oz_exception_21 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_21;
// 444
        JP.go.ipa.oz.lib.standard._Array_if putAt$val$236;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
          try {
            putAt$val$236 = res.putAt (0, smtrGOL);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          putAt$val$236 = res.putAt (0, smtrGOL);
        }
// 444
        lock (res);
// 445
        try {
// 446
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if FindOwner$val$237;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
            try {
              FindOwner$val$237 = smtr.FindOwner (path);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            FindOwner$val$237 = smtr.FindOwner (path);
          }
// 446
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if smv = FindOwner$val$237;
// 447
          JP.go.ipa.oz.lib.standard._String_if nameserverGOL$val$238;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              nameserverGOL$val$238 = smv.nameserverGOL ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nameserverGOL$val$238 = smv.nameserverGOL ();
          }
// 447
          JP.go.ipa.oz.lib.standard._String_if ownerGOL = nameserverGOL$val$238;
// 448
          JP.go.ipa.oz.user.lib_dist.name._Path_if tranpath$val$239;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              tranpath$val$239 = smv.tranpath ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            tranpath$val$239 = smv.tranpath ();
          }
// 448
          path = tranpath$val$239;
// 449
          boolean ismapping$val$240;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              ismapping$val$240 = smv.ismapping ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            ismapping$val$240 = smv.ismapping ();
          }
// 449
          if (ismapping$val$240) {{
// 450
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_pcl (ownerGOL);
// 451
              JP.go.ipa.oz.lib.standard._Set_if EntrySet$val$241;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  EntrySet$val$241 = owner.EntrySet (path);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                EntrySet$val$241 = owner.EntrySet (path);
              }
// 451
              entries = EntrySet$val$241;
            }
          } else {{
// 453
              JP.go.ipa.oz.lib.standard._Array_if putAt$val$242;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
                try {
                  putAt$val$242 = res.putAt (0, ownerGOL);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                putAt$val$242 = res.putAt (0, ownerGOL);
              }
// 453
              lock (res);
// 454
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_pcl (ownerGOL);
// 455
              JP.go.ipa.oz.lib.standard._Set_if EntrySet$val$243;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  EntrySet$val$243 = owner.EntrySet (path);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                EntrySet$val$243 = owner.EntrySet (path);
              }
// 455
              entries = EntrySet$val$243;
            }
          }
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_22) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_22 = _exception_22.getOzException ();
          if (_oz_exception_22 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_22;
// 457
            throw new JP.go.ipa.oz.lang.OzException (ee);
          } else if (_oz_exception_22 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_22;
// 459
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if eee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl ())._new_init ();
// 459
            throw new JP.go.ipa.oz.lang.OzException (eee);
          } else throw _exception_22;
        }
      } else throw _exception_21;
    }
// 462
    commit ();
// 463
    return entries;
  }
  
  public void putDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 514
    begin ();
// 515
    JP.go.ipa.oz.lib.standard._Array_if res = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (1);
// 516
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$244;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$244 = res.putAt (0, nstrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$244 = res.putAt (0, nstrGOL);
    }
// 516
    lock (res);
// 518
    try {
// 519
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nstr)) {
        try {
          nstr.putDirectory (path);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        nstr.putDirectory (path);
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_23) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_23 = _exception_23.getOzException ();
      if (_oz_exception_23 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_23;
// 523
        JP.go.ipa.oz.lib.standard._Array_if putAt$val$245;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
          try {
            putAt$val$245 = res.putAt (0, smtrGOL);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          putAt$val$245 = res.putAt (0, smtrGOL);
        }
// 523
        lock (res);
// 525
        try {
// 526
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if FindOwner$val$246;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
            try {
              FindOwner$val$246 = smtr.FindOwner (path);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            FindOwner$val$246 = smtr.FindOwner (path);
          }
// 526
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if smv = FindOwner$val$246;
// 528
          JP.go.ipa.oz.lib.standard._String_if nameserverGOL$val$247;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              nameserverGOL$val$247 = smv.nameserverGOL ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nameserverGOL$val$247 = smv.nameserverGOL ();
          }
// 528
          JP.go.ipa.oz.lib.standard._String_if ownerGOL = nameserverGOL$val$247;
// 530
          JP.go.ipa.oz.user.lib_dist.name._Path_if tranpath$val$248;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              tranpath$val$248 = smv.tranpath ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            tranpath$val$248 = smv.tranpath ();
          }
// 530
          path = tranpath$val$248;
// 531
          boolean ismapping$val$249;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              ismapping$val$249 = smv.ismapping ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            ismapping$val$249 = smv.ismapping ();
          }
// 531
          if (ismapping$val$249) {{
// 532
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_pcl (ownerGOL);
// 533
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  owner.putDirectory (path);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                owner.putDirectory (path);
              }
            }
          } else {{
// 537
              JP.go.ipa.oz.lib.standard._Array_if putAt$val$250;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
                try {
                  putAt$val$250 = res.putAt (0, ownerGOL);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                putAt$val$250 = res.putAt (0, ownerGOL);
              }
// 537
              lock (res);
// 539
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_pcl (ownerGOL);
// 540
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  owner.putDirectory (path);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                owner.putDirectory (path);
              }
            }
          }
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_24) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_24 = _exception_24.getOzException ();
          if (_oz_exception_24 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_24;
// 543
            throw new JP.go.ipa.oz.lang.OzException (ee);
          } else if (_oz_exception_24 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_24;
// 545
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if eee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl ())._new_init ();
// 545
            throw new JP.go.ipa.oz.lang.OzException (eee);
          } else throw _exception_24;
        }
      } else throw _exception_23;
    }
// 548
    commit ();
  }
  
  public void putDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if subdir) throws Exception  {
    checkSecureInvocation ();
// 476
    begin ();
// 477
    JP.go.ipa.oz.lib.standard._Array_if res = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (1);
// 478
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$251;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$251 = res.putAt (0, nstrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$251 = res.putAt (0, nstrGOL);
    }
// 478
    lock (res);
// 480
    try {
// 481
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nstr)) {
        try {
          nstr.putDirectory (path, subdir);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        nstr.putDirectory (path, subdir);
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_25) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_25 = _exception_25.getOzException ();
      if (_oz_exception_25 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_25;
// 485
        JP.go.ipa.oz.lib.standard._Array_if putAt$val$252;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
          try {
            putAt$val$252 = res.putAt (0, smtrGOL);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          putAt$val$252 = res.putAt (0, smtrGOL);
        }
// 485
        lock (res);
// 487
        try {
// 488
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if FindOwner$val$253;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
            try {
              FindOwner$val$253 = smtr.FindOwner (path);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            FindOwner$val$253 = smtr.FindOwner (path);
          }
// 488
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if smv = FindOwner$val$253;
// 489
          JP.go.ipa.oz.lib.standard._String_if nameserverGOL$val$254;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              nameserverGOL$val$254 = smv.nameserverGOL ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nameserverGOL$val$254 = smv.nameserverGOL ();
          }
// 489
          JP.go.ipa.oz.lib.standard._String_if ownerGOL = nameserverGOL$val$254;
// 490
          JP.go.ipa.oz.user.lib_dist.name._Path_if tranpath$val$255;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              tranpath$val$255 = smv.tranpath ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            tranpath$val$255 = smv.tranpath ();
          }
// 490
          path = tranpath$val$255;
// 491
          boolean ismapping$val$256;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              ismapping$val$256 = smv.ismapping ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            ismapping$val$256 = smv.ismapping ();
          }
// 491
          if (ismapping$val$256) {{
// 492
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_pcl (ownerGOL);
// 493
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  owner.putDirectory (path, subdir);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                owner.putDirectory (path, subdir);
              }
            }
          } else {{
// 495
              JP.go.ipa.oz.lib.standard._Array_if putAt$val$257;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
                try {
                  putAt$val$257 = res.putAt (0, ownerGOL);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                putAt$val$257 = res.putAt (0, ownerGOL);
              }
// 495
              lock (res);
// 496
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_pcl (ownerGOL);
// 497
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  owner.putDirectory (path, subdir);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                owner.putDirectory (path, subdir);
              }
            }
          }
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_26) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_26 = _exception_26.getOzException ();
          if (_oz_exception_26 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_26;
// 499
            throw new JP.go.ipa.oz.lang.OzException (ee);
          } else if (_oz_exception_26 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_26;
// 501
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if eee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl ())._new_init ();
// 501
            throw new JP.go.ipa.oz.lang.OzException (eee);
          } else throw _exception_26;
        }
      } else throw _exception_25;
    }
// 504
    commit ();
  }
  
  public void putEntry (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.lang._Root_if ent) throws Exception  {
    checkSecureInvocation ();
// 211
    begin ();
// 212
    JP.go.ipa.oz.lib.standard._Array_if res = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (1);
// 213
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$258;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$258 = res.putAt (0, nstrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$258 = res.putAt (0, nstrGOL);
    }
// 213
    lock (res);
// 214
    try {
// 216
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nstr)) {
        try {
          nstr.putEntry (path, ent);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        nstr.putEntry (path, ent);
      }
// 218
      commit ();
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_27) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_27 = _exception_27.getOzException ();
      if (_oz_exception_27 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_27;
// 223
        JP.go.ipa.oz.lib.standard._Array_if putAt$val$259;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
          try {
            putAt$val$259 = res.putAt (0, smtrGOL);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          putAt$val$259 = res.putAt (0, smtrGOL);
        }
// 223
        lock (res);
// 224
        try {
// 225
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if FindOwner$val$260;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
            try {
              FindOwner$val$260 = smtr.FindOwner (path);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            FindOwner$val$260 = smtr.FindOwner (path);
          }
// 225
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if smv = FindOwner$val$260;
// 226
          JP.go.ipa.oz.lib.standard._String_if nameserverGOL$val$261;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              nameserverGOL$val$261 = smv.nameserverGOL ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nameserverGOL$val$261 = smv.nameserverGOL ();
          }
// 226
          JP.go.ipa.oz.lib.standard._String_if ownerGOL = nameserverGOL$val$261;
// 227
          JP.go.ipa.oz.user.lib_dist.name._Path_if tranpath$val$262;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              tranpath$val$262 = smv.tranpath ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            tranpath$val$262 = smv.tranpath ();
          }
// 227
          path = tranpath$val$262;
// 228
          boolean ismapping$val$263;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              ismapping$val$263 = smv.ismapping ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            ismapping$val$263 = smv.ismapping ();
          }
// 228
          if (ismapping$val$263) {{
// 229
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_pcl (ownerGOL);
// 230
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  owner.putEntry (path, ent);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                owner.putEntry (path, ent);
              }
            }
          } else {{
// 232
              JP.go.ipa.oz.lib.standard._Array_if putAt$val$264;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
                try {
                  putAt$val$264 = res.putAt (0, ownerGOL);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                putAt$val$264 = res.putAt (0, ownerGOL);
              }
// 232
              lock (res);
// 233
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_pcl (ownerGOL);
// 234
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  owner.putEntry (path, ent);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                owner.putEntry (path, ent);
              }
            }
          }
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_28) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_28 = _exception_28.getOzException ();
          if (_oz_exception_28 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_28;
// 236
            throw new JP.go.ipa.oz.lang.OzException (ee);
          } else if (_oz_exception_28 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_28;
// 238
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if eee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl ())._new_init ();
// 238
            throw new JP.go.ipa.oz.lang.OzException (eee);
          } else throw _exception_28;
        }
// 240
        commit ();
      } else throw _exception_27;
    }
  }
  
  public boolean containEntry (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 250
    boolean tf = false;
// 251
    begin ();
// 252
    JP.go.ipa.oz.lib.standard._Array_if res = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (1);
// 253
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$265;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$265 = res.putAt (0, nstrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$265 = res.putAt (0, nstrGOL);
    }
// 253
    lock (res);
// 254
    try {
// 255
      boolean containEntry$val$266;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nstr)) {
        try {
          containEntry$val$266 = nstr.containEntry (path);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        containEntry$val$266 = nstr.containEntry (path);
      }
// 255
      tf = containEntry$val$266;
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_29) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_29 = _exception_29.getOzException ();
      if (_oz_exception_29 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_29;
// 257
        JP.go.ipa.oz.lib.standard._Array_if putAt$val$267;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
          try {
            putAt$val$267 = res.putAt (0, smtrGOL);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          putAt$val$267 = res.putAt (0, smtrGOL);
        }
// 257
        lock (res);
// 258
        try {
// 259
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if FindOwner$val$268;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
            try {
              FindOwner$val$268 = smtr.FindOwner (path);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            FindOwner$val$268 = smtr.FindOwner (path);
          }
// 259
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if smv = FindOwner$val$268;
// 260
          JP.go.ipa.oz.lib.standard._String_if nameserverGOL$val$269;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              nameserverGOL$val$269 = smv.nameserverGOL ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nameserverGOL$val$269 = smv.nameserverGOL ();
          }
// 260
          JP.go.ipa.oz.lib.standard._String_if ownerGOL = nameserverGOL$val$269;
// 261
          JP.go.ipa.oz.user.lib_dist.name._Path_if tranpath$val$270;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              tranpath$val$270 = smv.tranpath ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            tranpath$val$270 = smv.tranpath ();
          }
// 261
          path = tranpath$val$270;
// 262
          boolean ismapping$val$271;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              ismapping$val$271 = smv.ismapping ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            ismapping$val$271 = smv.ismapping ();
          }
// 262
          if (ismapping$val$271) {{
// 263
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_pcl (ownerGOL);
// 264
              boolean containEntry$val$272;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  containEntry$val$272 = owner.containEntry (path);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                containEntry$val$272 = owner.containEntry (path);
              }
// 264
              tf = containEntry$val$272;
            }
          } else {{
// 266
              JP.go.ipa.oz.lib.standard._Array_if putAt$val$273;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
                try {
                  putAt$val$273 = res.putAt (0, ownerGOL);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                putAt$val$273 = res.putAt (0, ownerGOL);
              }
// 266
              lock (res);
// 267
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_pcl (ownerGOL);
// 268
              boolean containEntry$val$274;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  containEntry$val$274 = owner.containEntry (path);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                containEntry$val$274 = owner.containEntry (path);
              }
// 268
              tf = containEntry$val$274;
            }
          }
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_30) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_30 = _exception_30.getOzException ();
          if (_oz_exception_30 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_30;
// 270
            throw new JP.go.ipa.oz.lang.OzException (ee);
          } else if (_oz_exception_30 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_30;
// 272
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if eee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl ())._new_init ();
// 272
            throw new JP.go.ipa.oz.lang.OzException (eee);
          } else throw _exception_30;
        }
      } else throw _exception_29;
    }
// 275
    commit ();
// 276
    return tf;
  }
  
  protected void go () throws Exception  {
  }
  
  public JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if renameDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if source, JP.go.ipa.oz.user.lib_dist.name._Path_if target) throws Exception  {
    checkSecureInvocation ();
// 679
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd = null;
// 680
    begin ();
// 681
    JP.go.ipa.oz.lib.standard._Array_if res = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (1);
// 682
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$275;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$275 = res.putAt (0, nstrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$275 = res.putAt (0, nstrGOL);
    }
// 682
    lock (res);
// 683
    try {
// 684
      JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if renameDirectory$val$276;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nstr)) {
        try {
          renameDirectory$val$276 = nstr.renameDirectory (source, target);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        renameDirectory$val$276 = nstr.renameDirectory (source, target);
      }
// 684
      nd = renameDirectory$val$276;
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_31) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_31 = _exception_31.getOzException ();
      if (_oz_exception_31 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_31;
// 686
        JP.go.ipa.oz.lib.standard._Array_if putAt$val$277;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
          try {
            putAt$val$277 = res.putAt (0, smtrGOL);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          putAt$val$277 = res.putAt (0, smtrGOL);
        }
// 686
        lock (res);
// 687
        try {
// 688
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if FindOwner$val$278;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
            try {
              FindOwner$val$278 = smtr.FindOwner (source);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            FindOwner$val$278 = smtr.FindOwner (source);
          }
// 688
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if smv = FindOwner$val$278;
// 689
          JP.go.ipa.oz.lib.standard._String_if nameserverGOL$val$279;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              nameserverGOL$val$279 = smv.nameserverGOL ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nameserverGOL$val$279 = smv.nameserverGOL ();
          }
// 689
          JP.go.ipa.oz.lib.standard._String_if ownerGOL = nameserverGOL$val$279;
// 690
          JP.go.ipa.oz.user.lib_dist.name._Path_if tranpath$val$280;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              tranpath$val$280 = smv.tranpath ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            tranpath$val$280 = smv.tranpath ();
          }
// 690
          source = tranpath$val$280;
// 691
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if FindOwner$val$281;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
            try {
              FindOwner$val$281 = smtr.FindOwner (target);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            FindOwner$val$281 = smtr.FindOwner (target);
          }
// 691
          smv = FindOwner$val$281;
// 692
          JP.go.ipa.oz.user.lib_dist.name._Path_if tranpath$val$282;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              tranpath$val$282 = smv.tranpath ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            tranpath$val$282 = smv.tranpath ();
          }
// 692
          target = tranpath$val$282;
// 693
          boolean ismapping$val$283;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              ismapping$val$283 = smv.ismapping ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            ismapping$val$283 = smv.ismapping ();
          }
// 693
          if (ismapping$val$283) {{
// 694
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_pcl (ownerGOL);
// 695
              JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if renameDirectory$val$284;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  renameDirectory$val$284 = owner.renameDirectory (source, target);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                renameDirectory$val$284 = owner.renameDirectory (source, target);
              }
// 695
              nd = renameDirectory$val$284;
            }
          } else {{
// 697
              JP.go.ipa.oz.lib.standard._Array_if putAt$val$285;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
                try {
                  putAt$val$285 = res.putAt (0, ownerGOL);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                putAt$val$285 = res.putAt (0, ownerGOL);
              }
// 697
              lock (res);
// 698
              JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_pcl (ownerGOL);
// 699
              JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if renameDirectory$val$286;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
                try {
                  renameDirectory$val$286 = owner.renameDirectory (source, target);
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                renameDirectory$val$286 = owner.renameDirectory (source, target);
              }
// 699
              nd = renameDirectory$val$286;
            }
          }
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_32) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_32 = _exception_32.getOzException ();
          if (_oz_exception_32 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_32;
// 701
            throw new JP.go.ipa.oz.lang.OzException (ee);
          } else if (_oz_exception_32 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_32;
// 703
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if eee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl ())._new_init ();
// 703
            throw new JP.go.ipa.oz.lang.OzException (eee);
          } else throw _exception_32;
        }
      } else throw _exception_31;
    }
// 706
    commit ();
// 707
    return nd;
  }
  
  public void addNameServer () throws Exception  {
    checkSecureInvocation ();
// 152
    begin ();
// 153
    JP.go.ipa.oz.lib.standard._Array_if res = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (2);
// 154
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$287;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$287 = res.putAt (0, smtrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$287 = res.putAt (0, smtrGOL);
    }
// 154
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$288;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$288 = res.putAt (1, nstrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$288 = res.putAt (1, nstrGOL);
    }
// 155
    lock (res);
// 156
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
      try {
        smtr.AddNameServer (nstrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      smtr.AddNameServer (nstrGOL);
    }
// 157
    commit ();
  }
  
  public void putDirectoryAsMapping (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.user.lib_dist.name._Path_if to, JP.go.ipa.oz.lib.standard._String_if serverNSTGOL) throws Exception  {
    checkSecureInvocation ();
// 180
    begin ();
// 181
    JP.go.ipa.oz.lib.standard._Array_if res = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (2);
// 182
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$289;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$289 = res.putAt (0, smtrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$289 = res.putAt (0, smtrGOL);
    }
// 182
    JP.go.ipa.oz.lib.standard._Array_if putAt$val$290;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
      try {
        putAt$val$290 = res.putAt (1, nstrGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      putAt$val$290 = res.putAt (1, nstrGOL);
    }
// 182
    lock (res);
// 183
    try {
// 184
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nstr)) {
        try {
          nstr.putBranchInOtherCell (path);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        nstr.putBranchInOtherCell (path);
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_33) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_33 = _exception_33.getOzException ();
      if (_oz_exception_33 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_33;
// 187
        try {
// 188
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if FindOwner$val$291;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
            try {
              FindOwner$val$291 = smtr.FindOwner (path);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            FindOwner$val$291 = smtr.FindOwner (path);
          }
// 188
          JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if smv = FindOwner$val$291;
// 189
          JP.go.ipa.oz.lib.standard._String_if nameserverGOL$val$292;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              nameserverGOL$val$292 = smv.nameserverGOL ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nameserverGOL$val$292 = smv.nameserverGOL ();
          }
// 189
          JP.go.ipa.oz.lib.standard._String_if ownerGOL = nameserverGOL$val$292;
// 190
          JP.go.ipa.oz.user.lib_dist.name._Path_if tranpath$val$293;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
            try {
              tranpath$val$293 = smv.tranpath ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            tranpath$val$293 = smv.tranpath ();
          }
// 190
          path = tranpath$val$293;
// 191
          JP.go.ipa.oz.lib.standard._Array_if putAt$val$294;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) res)) {
            try {
              putAt$val$294 = res.putAt (1, ownerGOL);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            putAt$val$294 = res.putAt (1, ownerGOL);
          }
// 191
          lock (res);
// 192
          JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_if owner = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_pcl (ownerGOL);
// 193
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) owner)) {
            try {
              owner.putBranchInOtherCell (path);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            owner.putBranchInOtherCell (path);
          }
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_34) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_34 = _exception_34.getOzException ();
          if (_oz_exception_34 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if) _oz_exception_34;
// 194
            throw new JP.go.ipa.oz.lang.OzException (ee);
          } else if (_oz_exception_34 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_34;
// 196
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if eee = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl ())._new_init ();
// 196
            throw new JP.go.ipa.oz.lang.OzException (eee);
          } else throw _exception_34;
        }
      } else throw _exception_33;
    }
// 200
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smtr)) {
      try {
        smtr.addMapping (path, to, serverNSTGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      smtr.addMapping (path, to, serverNSTGOL);
    }
// 201
    commit ();
  }
  
  public _NameServerTransaction_cl () { super ("JP.go.ipa.oz.user.lib_dist.name._NameServerTransaction_pcl"); }
  
  public _NameServerTransaction_cl (String proxy_id) { super (proxy_id); }
  
}


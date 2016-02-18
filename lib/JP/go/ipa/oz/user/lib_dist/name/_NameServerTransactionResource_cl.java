package JP.go.ipa.oz.user.lib_dist.name;

public class _NameServerTransactionResource_cl extends JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_cl implements JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_if {
  static final boolean _global_ = true;
  JP.go.ipa.oz.lib.standard._String_if delimitor;
  JP.go.ipa.oz.user.lib_dist.name._NameResource_if nr;
  JP.go.ipa.oz.lib.standard._String_if selfGOL;
  
  public JP.go.ipa.oz.lang._Root_if renameEntry (JP.go.ipa.oz.user.lib_dist.name._Path_if source, JP.go.ipa.oz.user.lib_dist.name._Path_if target) throws Exception  {
    checkSecureInvocation ();
// 225
    JP.go.ipa.oz.user.lib_dist.name._Path_if sourcedirpath = null, targetdirpath = null;
// 226
    JP.go.ipa.oz.lib.standard._String_if sourcename = null, targetname = null;
// 227
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd = null;
// 228
    try {
// 229
      JP.go.ipa.oz.user.lib_dist.name._Path_if UpperPath$val$295;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) source)) {
        try {
          UpperPath$val$295 = source.UpperPath (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        UpperPath$val$295 = source.UpperPath (delimitor);
      }
// 229
      sourcedirpath = UpperPath$val$295;
// 230
      JP.go.ipa.oz.lib.standard._String_if LowerName$val$296;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) source)) {
        try {
          LowerName$val$296 = source.LowerName (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        LowerName$val$296 = source.LowerName (delimitor);
      }
// 230
      sourcename = LowerName$val$296;
// 231
      JP.go.ipa.oz.user.lib_dist.name._Path_if UpperPath$val$297;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) target)) {
        try {
          UpperPath$val$297 = target.UpperPath (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        UpperPath$val$297 = target.UpperPath (delimitor);
      }
// 231
      targetdirpath = UpperPath$val$297;
// 232
      JP.go.ipa.oz.lib.standard._String_if LowerName$val$298;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) target)) {
        try {
          LowerName$val$298 = target.LowerName (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        LowerName$val$298 = target.LowerName (delimitor);
      }
// 232
      targetname = LowerName$val$298;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 234
      JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl) (new JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl ())._new_init ();
// 234
      throw new JP.go.ipa.oz.lang.OzException (ee);
    }
// 235
    boolean isequal$val$299;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sourcedirpath)) {
      try {
        isequal$val$299 = sourcedirpath.isequal (targetdirpath);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$299 = sourcedirpath.isequal (targetdirpath);
    }
// 235
    if (isequal$val$299) {{
// 236
        try {
// 237
          nd = SearchOwnerMap (sourcedirpath);
        }
        catch (JP.go.ipa.oz.lang.OzException _exception_2) {
          JP.go.ipa.oz.lang._Root_if _oz_exception_2 = _exception_2.getOzException ();
          if (_oz_exception_2 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
            JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_2;
// 239
            throw new JP.go.ipa.oz.lang.OzException (e);
          } else throw _exception_2;
        }
// 240
        JP.go.ipa.oz.lang._Root_if removeEntry$val$300;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nd)) {
          try {
            removeEntry$val$300 = nd.removeEntry (sourcename);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          removeEntry$val$300 = nd.removeEntry (sourcename);
        }
// 240
        JP.go.ipa.oz.lang._Root_if obj = removeEntry$val$300;
// 241
        if (obj != null) {
// 241
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nd)) {
            try {
              nd.putEntry (targetname, obj);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            nd.putEntry (targetname, obj);
          }
        }
// 243
        return obj;
      }
    } else {{
// 245
        JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl) (new JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl ())._new_init ();
// 245
        throw new JP.go.ipa.oz.lang.OzException (ee);
      }
    }
  }
  
  public void putDirectoryAsBranch (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 656
    JP.go.ipa.oz.user.lib_dist.name._Path_if dirpath = null;
// 656
    JP.go.ipa.oz.lib.standard._String_if subdirname = null;
// 656
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd = null;
// 658
    try {
// 659
      JP.go.ipa.oz.user.lib_dist.name._Path_if UpperPath$val$301;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          UpperPath$val$301 = path.UpperPath (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        UpperPath$val$301 = path.UpperPath (delimitor);
      }
// 659
      dirpath = UpperPath$val$301;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 661
      JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl) (new JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl ())._new_init ();
// 661
      throw new JP.go.ipa.oz.lang.OzException (ee);
    }
// 667
    boolean isEmpty$val$302;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dirpath)) {
      try {
        isEmpty$val$302 = dirpath.isEmpty ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isEmpty$val$302 = dirpath.isEmpty ();
    }
// 667
    if (isEmpty$val$302) {{
// 668
        JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if dir = (JP.go.ipa.oz.user.lib_dist.name._NameDirectory_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameDirectory_cl ())._new_create ();
// 669
        JP.go.ipa.oz.lib.standard._Dictionary_if getOwnerMap$val$303;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
          try {
            getOwnerMap$val$303 = nr.getOwnerMap ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getOwnerMap$val$303 = nr.getOwnerMap ();
        }
// 669
        JP.go.ipa.oz.lib.standard._Dictionary_if ownermap = getOwnerMap$val$303;
// 670
        JP.go.ipa.oz.lib.standard._String_if asString$val$304;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
          try {
            asString$val$304 = path.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$304 = path.asString ();
        }
// 670
        JP.go.ipa.oz.lib.standard._Dictionary_if put$val$305;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ownermap)) {
          try {
            put$val$305 = ownermap.put (asString$val$304, dir);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          put$val$305 = ownermap.put (asString$val$304, dir);
        }
// 670
        ownermap = put$val$305;
// 671
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
          try {
            nr.setOwnerMap (ownermap);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nr.setOwnerMap (ownermap);
        }
// 672
        JP.go.ipa.oz.lib.standard._Dictionary_if getBranches$val$306;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
          try {
            getBranches$val$306 = nr.getBranches ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getBranches$val$306 = nr.getBranches ();
        }
// 672
        JP.go.ipa.oz.lib.standard._Dictionary_if branches = getBranches$val$306;
// 673
        JP.go.ipa.oz.lib.standard._String_if asString$val$307;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
          try {
            asString$val$307 = path.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$307 = path.asString ();
        }
// 673
        JP.go.ipa.oz.lib.standard._Dictionary_if put$val$308;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) branches)) {
          try {
            put$val$308 = branches.put (asString$val$307, dir);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          put$val$308 = branches.put (asString$val$307, dir);
        }
// 673
        branches = put$val$308;
// 674
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
          try {
            nr.setBranches (branches);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nr.setBranches (branches);
        }
// 675
        return;
      }
    }
// 677
    JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_cl ())._new_init ();
// 678
    throw new JP.go.ipa.oz.lang.OzException (e);
  }
  
  public void putDirectoryAsBranch (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if dir) throws Exception  {
    checkSecureInvocation ();
// 629
    JP.go.ipa.oz.user.lib_dist.name._Path_if dirpath = null;
// 629
    JP.go.ipa.oz.lib.standard._String_if subdirname = null;
// 629
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd = null;
// 630
    try {
// 631
      JP.go.ipa.oz.user.lib_dist.name._Path_if UpperPath$val$309;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          UpperPath$val$309 = path.UpperPath (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        UpperPath$val$309 = path.UpperPath (delimitor);
      }
// 631
      dirpath = UpperPath$val$309;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 633
      JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl) (new JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl ())._new_init ();
// 633
      throw new JP.go.ipa.oz.lang.OzException (ee);
    }
// 639
    boolean isEmpty$val$310;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) dirpath)) {
      try {
        isEmpty$val$310 = dirpath.isEmpty ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isEmpty$val$310 = dirpath.isEmpty ();
    }
// 639
    if (isEmpty$val$310) {{
// 640
        JP.go.ipa.oz.lib.standard._Dictionary_if getOwnerMap$val$311;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
          try {
            getOwnerMap$val$311 = nr.getOwnerMap ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getOwnerMap$val$311 = nr.getOwnerMap ();
        }
// 640
        JP.go.ipa.oz.lib.standard._Dictionary_if ownermap = getOwnerMap$val$311;
// 641
        JP.go.ipa.oz.lib.standard._String_if asString$val$312;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
          try {
            asString$val$312 = path.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$312 = path.asString ();
        }
// 641
        JP.go.ipa.oz.lib.standard._Dictionary_if put$val$313;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ownermap)) {
          try {
            put$val$313 = ownermap.put (asString$val$312, dir);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          put$val$313 = ownermap.put (asString$val$312, dir);
        }
// 641
        ownermap = put$val$313;
// 642
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
          try {
            nr.setOwnerMap (ownermap);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nr.setOwnerMap (ownermap);
        }
// 643
        JP.go.ipa.oz.lib.standard._Dictionary_if getBranches$val$314;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
          try {
            getBranches$val$314 = nr.getBranches ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getBranches$val$314 = nr.getBranches ();
        }
// 643
        JP.go.ipa.oz.lib.standard._Dictionary_if branches = getBranches$val$314;
// 644
        JP.go.ipa.oz.lib.standard._String_if asString$val$315;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
          try {
            asString$val$315 = path.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$315 = path.asString ();
        }
// 644
        JP.go.ipa.oz.lib.standard._Dictionary_if put$val$316;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) branches)) {
          try {
            put$val$316 = branches.put (asString$val$315, dir);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          put$val$316 = branches.put (asString$val$315, dir);
        }
// 644
        branches = put$val$316;
// 645
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
          try {
            nr.setBranches (branches);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nr.setBranches (branches);
        }
// 646
        return;
      }
    }
// 648
    JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_cl ())._new_init ();
// 649
    throw new JP.go.ipa.oz.lang.OzException (e);
  }
  
  public void putBranch (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd) throws Exception  {
    checkSecureInvocation ();
// 606
    JP.go.ipa.oz.lib.standard._Dictionary_if getOwnerMap$val$317;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getOwnerMap$val$317 = nr.getOwnerMap ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOwnerMap$val$317 = nr.getOwnerMap ();
    }
// 606
    JP.go.ipa.oz.lib.standard._Dictionary_if ownermap = getOwnerMap$val$317;
// 607
    ownermap = putSubDir (ownermap, path, nd);
// 608
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        nr.setOwnerMap (ownermap);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nr.setOwnerMap (ownermap);
    }
// 609
    JP.go.ipa.oz.lib.standard._Dictionary_if getBranches$val$318;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getBranches$val$318 = nr.getBranches ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBranches$val$318 = nr.getBranches ();
    }
// 609
    JP.go.ipa.oz.lib.standard._Dictionary_if branches = getBranches$val$318;
// 610
    JP.go.ipa.oz.lib.standard._String_if asString$val$319;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        asString$val$319 = path.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$319 = path.asString ();
    }
// 610
    JP.go.ipa.oz.lib.standard._Dictionary_if put$val$320;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) branches)) {
      try {
        put$val$320 = branches.put (asString$val$319, nd);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$320 = branches.put (asString$val$319, nd);
    }
// 610
    branches = put$val$320;
// 611
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        nr.setBranches (branches);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nr.setBranches (branches);
    }
  }
  
  protected void createResource () throws Exception  {
// 34
    nr = (JP.go.ipa.oz.user.lib_dist.name._NameResource_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameResource_cl ())._new_create ();
// 34
    r = (JP.go.ipa.oz.user.lib_dist.tran._Resource_cl) (new JP.go.ipa.oz.user.lib_dist.tran._Resource_cl ())._new_create (nr);
  }
  
  public int EntrySize (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 254
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd = null;
// 255
    try {
// 256
      nd = SearchOwnerMap (path);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_3) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_3 = _exception_3.getOzException ();
      if (_oz_exception_3 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_3;
// 258
        throw new JP.go.ipa.oz.lang.OzException (e);
      } else throw _exception_3;
    }
// 259
    int EntrySize$val$321;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nd)) {
      try {
        EntrySize$val$321 = nd.EntrySize ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      EntrySize$val$321 = nd.EntrySize ();
    }
// 259
    int size = EntrySize$val$321;
// 260
    return size;
  }
  
  public void setDelimitor (JP.go.ipa.oz.lib.standard._String_if s) throws Exception  {
    checkSecureInvocation ();
// 45
    delimitor = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (s);
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
    JP.go.ipa.oz.lib.standard._Array_if getArguments$val$322;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getArguments$val$322 = system.getArguments ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getArguments$val$322 = system.getArguments ();
    }
// 17
    args = getArguments$val$322;
// 18
    JP.go.ipa.oz.lang._Root_if at$val$323;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
      try {
        at$val$323 = args.at (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$323 = args.at (0);
    }
// 18
    selfGOL = (JP.go.ipa.oz.lib.standard._String_if) (at$val$323);
// 19
    JP.go.ipa.oz.lib.standard._String_if s0 = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("tmp0_")));
// 19
    JP.go.ipa.oz.lib.standard._String_if concat$val$324;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s0)) {
      try {
        concat$val$324 = s0.concat (selfGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$324 = s0.concat (selfGOL);
    }
// 19
    s0 = concat$val$324;
// 20
    JP.go.ipa.oz.lib.standard._String_if s1 = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("tmp1_")));
// 20
    JP.go.ipa.oz.lib.standard._String_if concat$val$325;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s1)) {
      try {
        concat$val$325 = s1.concat (selfGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$325 = s1.concat (selfGOL);
    }
// 20
    s1 = concat$val$325;
// 21
    JP.go.ipa.oz.lib.standard._String_if s2 = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("tmp2_")));
// 21
    JP.go.ipa.oz.lib.standard._String_if concat$val$326;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s2)) {
      try {
        concat$val$326 = s2.concat (selfGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$326 = s2.concat (selfGOL);
    }
// 21
    s2 = concat$val$326;
// 22
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.setP (selfGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.setP (selfGOL);
    }
// 23
    super.initialize (s0, s1, s2, selfGOL);
// 25
    JP.go.ipa.oz.lang._Root_if at$val$327;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
      try {
        at$val$327 = args.at (1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$327 = args.at (1);
    }
// 25
    delimitor = (JP.go.ipa.oz.lib.standard._String_if) (at$val$327);
// 26
    createResource ();
  }
  
  public JP.go.ipa.oz.lang._Root_if getEntry (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 179
    JP.go.ipa.oz.user.lib_dist.name._Path_if dirpath = null;
// 179
    JP.go.ipa.oz.lib.standard._String_if name = null;
// 179
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd = null;
// 180
    try {
// 181
      JP.go.ipa.oz.user.lib_dist.name._Path_if UpperPath$val$328;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          UpperPath$val$328 = path.UpperPath (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        UpperPath$val$328 = path.UpperPath (delimitor);
      }
// 181
      dirpath = UpperPath$val$328;
// 182
      JP.go.ipa.oz.lib.standard._String_if LowerName$val$329;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          LowerName$val$329 = path.LowerName (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        LowerName$val$329 = path.LowerName (delimitor);
      }
// 182
      name = LowerName$val$329;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 184
      JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl) (new JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl ())._new_init ();
// 184
      throw new JP.go.ipa.oz.lang.OzException (ee);
    }
// 185
    try {
// 186
      nd = SearchOwnerMap (dirpath);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_4) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_4 = _exception_4.getOzException ();
      if (_oz_exception_4 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_4;
// 188
        throw new JP.go.ipa.oz.lang.OzException (e);
      } else throw _exception_4;
    }
// 189
    JP.go.ipa.oz.lang._Root_if getEntry$val$330;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nd)) {
      try {
        getEntry$val$330 = nd.getEntry (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getEntry$val$330 = nd.getEntry (name);
    }
// 189
    JP.go.ipa.oz.lang._Root_if obj = getEntry$val$330;
// 190
    return obj;
  }
  
  public JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if removeDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 399
    JP.go.ipa.oz.user.lib_dist.name._Path_if dirpath = null;
// 399
    JP.go.ipa.oz.lib.standard._String_if subdirname = null;
// 399
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd = null;
// 400
    if (isBranch (path)) {{
// 401
        JP.go.ipa.oz.user.lib_dist.name._NameDirectoryBranchException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameDirectoryBranchException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameDirectoryBranchException_cl ())._new_init ();
// 401
        throw new JP.go.ipa.oz.lang.OzException (e);
      }
    }
// 402
    try {
// 403
      nd = SearchOwnerMap (path);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_5) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_5 = _exception_5.getOzException ();
      if (_oz_exception_5 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_5;
// 405
        throw new JP.go.ipa.oz.lang.OzException (e);
      } else throw _exception_5;
    }
// 406
    int EntrySize$val$331;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nd)) {
      try {
        EntrySize$val$331 = nd.EntrySize ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      EntrySize$val$331 = nd.EntrySize ();
    }
// 406
    int entrysize = EntrySize$val$331;
// 407
    int DirectorySize$val$332;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nd)) {
      try {
        DirectorySize$val$332 = nd.DirectorySize ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      DirectorySize$val$332 = nd.DirectorySize ();
    }
// 407
    int subdirsize = DirectorySize$val$332;
    boolean bool$val$0;
    
    bool$val$0 = (entrysize > 0);
    if (!bool$val$0) {
      bool$val$0 = (subdirsize > 0);
    }
// 408
    if (bool$val$0) {{
// 409
        JP.go.ipa.oz.user.lib_dist.name._NameDirectoryNotEmptyException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameDirectoryNotEmptyException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameDirectoryNotEmptyException_cl ())._new_init ();
// 409
        throw new JP.go.ipa.oz.lang.OzException (e);
      }
    }
// 410
    try {
// 411
      JP.go.ipa.oz.user.lib_dist.name._Path_if UpperPath$val$333;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          UpperPath$val$333 = path.UpperPath (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        UpperPath$val$333 = path.UpperPath (delimitor);
      }
// 411
      dirpath = UpperPath$val$333;
// 412
      JP.go.ipa.oz.lib.standard._String_if LowerName$val$334;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          LowerName$val$334 = path.LowerName (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        LowerName$val$334 = path.LowerName (delimitor);
      }
// 412
      subdirname = LowerName$val$334;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 414
      JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl) (new JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl ())._new_init ();
// 414
      throw new JP.go.ipa.oz.lang.OzException (ee);
    }
// 415
    nd = SearchOwnerMap (dirpath);
// 416
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if removeDirectory$val$335;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nd)) {
      try {
        removeDirectory$val$335 = nd.removeDirectory (subdirname);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      removeDirectory$val$335 = nd.removeDirectory (subdirname);
    }
// 416
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if subdir = removeDirectory$val$335;
// 417
    JP.go.ipa.oz.lib.standard._Dictionary_if getOwnerMap$val$336;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getOwnerMap$val$336 = nr.getOwnerMap ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOwnerMap$val$336 = nr.getOwnerMap ();
    }
// 417
    JP.go.ipa.oz.lib.standard._Dictionary_if ownermap = getOwnerMap$val$336;
// 418
    JP.go.ipa.oz.lib.standard._String_if asString$val$337;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        asString$val$337 = path.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$337 = path.asString ();
    }
// 418
    JP.go.ipa.oz.lib.standard._Dictionary_if remove$val$338;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ownermap)) {
      try {
        remove$val$338 = ownermap.remove (asString$val$337);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      remove$val$338 = ownermap.remove (asString$val$337);
    }
// 418
    ownermap = remove$val$338;
// 419
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        nr.setOwnerMap (ownermap);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nr.setOwnerMap (ownermap);
    }
// 420
    return subdir;
  }
  
  public boolean containDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 361
    try {
// 362
      SearchOwnerMap (path);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_6) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_6 = _exception_6.getOzException ();
      if (_oz_exception_6 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_6;
// 363
        return false;
      } else throw _exception_6;
    }
// 364
    return true;
  }
  
  public void unBranched (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 688
    JP.go.ipa.oz.user.lib_dist.name._Path_if dirpath = null;
// 688
    JP.go.ipa.oz.lib.standard._String_if subdirname = null;
// 689
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd = null;
// 689
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if parent = null;
// 692
    try {
// 693
      JP.go.ipa.oz.user.lib_dist.name._Path_if UpperPath$val$339;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          UpperPath$val$339 = path.UpperPath (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        UpperPath$val$339 = path.UpperPath (delimitor);
      }
// 693
      dirpath = UpperPath$val$339;
// 694
      JP.go.ipa.oz.lib.standard._String_if LowerName$val$340;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          LowerName$val$340 = path.LowerName (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        LowerName$val$340 = path.LowerName (delimitor);
      }
// 694
      subdirname = LowerName$val$340;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 696
      JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl) (new JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl ())._new_init ();
// 696
      throw new JP.go.ipa.oz.lang.OzException (ee);
    }
// 698
    try {
// 699
      nd = SearchOwnerMap (path);
// 700
      parent = SearchOwnerMap (dirpath);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_7) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_7 = _exception_7.getOzException ();
      if (_oz_exception_7 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_7;
// 701
        throw new JP.go.ipa.oz.lang.OzException (e);
      } else throw _exception_7;
    }
// 703
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if getDirectory$val$341;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) parent)) {
      try {
        getDirectory$val$341 = parent.getDirectory (subdirname);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getDirectory$val$341 = parent.getDirectory (subdirname);
    }
// 703
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if child = getDirectory$val$341;
// 704
    boolean isBranch$val$342;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) child)) {
      try {
        isBranch$val$342 = child.isBranch ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isBranch$val$342 = child.isBranch ();
    }
// 704
    if (!(isBranch$val$342)) {{
// 705
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_cl ())._new_init ();
// 705
        throw new JP.go.ipa.oz.lang.OzException (e);
      }
    }
// 707
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) parent)) {
      try {
        parent.overputDirectory (subdirname, nd);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      parent.overputDirectory (subdirname, nd);
    }
// 709
    JP.go.ipa.oz.lib.standard._Dictionary_if getBranches$val$343;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getBranches$val$343 = nr.getBranches ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBranches$val$343 = nr.getBranches ();
    }
// 709
    JP.go.ipa.oz.lib.standard._Dictionary_if branches = getBranches$val$343;
// 710
    JP.go.ipa.oz.lib.standard._String_if asString$val$344;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        asString$val$344 = path.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$344 = path.asString ();
    }
// 710
    JP.go.ipa.oz.lib.standard._Dictionary_if remove$val$345;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) branches)) {
      try {
        remove$val$345 = branches.remove (asString$val$344);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      remove$val$345 = branches.remove (asString$val$344);
    }
// 710
    branches = remove$val$345;
// 711
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        nr.setBranches (branches);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nr.setBranches (branches);
    }
// 712
    return;
  }
  
  public void debugPrint () throws Exception  {
    checkSecureInvocation ();
// 50
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 51
    JP.go.ipa.oz.lib.standard._PrintWriter_if getStdout$val$346;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getStdout$val$346 = system.getStdout ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getStdout$val$346 = system.getStdout ();
    }
// 51
    JP.go.ipa.oz.lib.standard._PrintWriter_if pw = getStdout$val$346;
// 52
    JP.go.ipa.oz.lib.standard._String_if string$107 = (new JP.go.ipa.oz.lib.standard._String_cl("NameServer ------ "));
    
// 52
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.print (string$107);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.print (string$107);
    }
// 52
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.println (selfGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.println (selfGOL);
    }
// 53
    JP.go.ipa.oz.lib.standard._Dictionary_if ownermap = null;
// 53
    JP.go.ipa.oz.lib.standard._Dictionary_if getOwnerMap$val$347;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getOwnerMap$val$347 = nr.getOwnerMap ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOwnerMap$val$347 = nr.getOwnerMap ();
    }
// 53
    ownermap = getOwnerMap$val$347;
// 54
    JP.go.ipa.oz.lib.standard._Iterator_if keyIterator$val$348;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ownermap)) {
      try {
        keyIterator$val$348 = ownermap.keyIterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      keyIterator$val$348 = ownermap.keyIterator ();
    }
// 54
    JP.go.ipa.oz.lib.standard._Iterator_if it = keyIterator$val$348;
// 55
    JP.go.ipa.oz.lib.standard._String_if string$108 = (new JP.go.ipa.oz.lib.standard._String_cl("  ownermap"));
    
// 55
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.println (string$108);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.println (string$108);
    }
// 56
    while (true) {
// 56
      boolean atEnd$val$349;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
        try {
          atEnd$val$349 = it.atEnd ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        atEnd$val$349 = it.atEnd ();
      }
      if (!(!(atEnd$val$349))) break;
      
      /* body */ _loop_1: {
// 57
        JP.go.ipa.oz.lib.standard._String_if pathname = null;
// 58
        JP.go.ipa.oz.lang._Root_if nextElement$val$350;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
          try {
            nextElement$val$350 = it.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$350 = it.nextElement ();
        }
// 58
        pathname = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$350);
// 59
        JP.go.ipa.oz.lib.standard._String_if string$109 = (new JP.go.ipa.oz.lib.standard._String_cl("    "));
        
// 59
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
          try {
            pw.print (string$109);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          pw.print (string$109);
        }
// 59
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
          try {
            pw.println (pathname);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          pw.println (pathname);
        }
      }
    }
// 61
    JP.go.ipa.oz.lib.standard._Dictionary_if branches = null;
// 61
    JP.go.ipa.oz.lib.standard._Dictionary_if getBranches$val$351;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getBranches$val$351 = nr.getBranches ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBranches$val$351 = nr.getBranches ();
    }
// 61
    branches = getBranches$val$351;
// 62
    JP.go.ipa.oz.lib.standard._Iterator_if keyIterator$val$352;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) branches)) {
      try {
        keyIterator$val$352 = branches.keyIterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      keyIterator$val$352 = branches.keyIterator ();
    }
// 62
    it = keyIterator$val$352;
// 63
    JP.go.ipa.oz.lib.standard._String_if string$110 = (new JP.go.ipa.oz.lib.standard._String_cl("  branches"));
    
// 63
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.println (string$110);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.println (string$110);
    }
// 64
    while (true) {
// 64
      boolean atEnd$val$353;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
        try {
          atEnd$val$353 = it.atEnd ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        atEnd$val$353 = it.atEnd ();
      }
      if (!(!(atEnd$val$353))) break;
      
      /* body */ _loop_1: {
// 65
        JP.go.ipa.oz.lib.standard._String_if pathname = null;
// 66
        JP.go.ipa.oz.lang._Root_if nextElement$val$354;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
          try {
            nextElement$val$354 = it.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$354 = it.nextElement ();
        }
// 66
        pathname = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$354);
// 67
        JP.go.ipa.oz.lib.standard._String_if string$111 = (new JP.go.ipa.oz.lib.standard._String_cl("    "));
        
// 67
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
          try {
            pw.print (string$111);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          pw.print (string$111);
        }
// 67
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
          try {
            pw.println (pathname);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          pw.println (pathname);
        }
      }
    }
// 69
    JP.go.ipa.oz.lib.standard._String_if string$112 = (new JP.go.ipa.oz.lib.standard._String_cl("------"));
    
// 69
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.println (string$112);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.println (string$112);
    }
// 70
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.flush ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.flush ();
    }
  }
  
  public void replaceBranch (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.lib.standard._String_if toGOL) throws Exception  {
    checkSecureInvocation ();
// 539
    JP.go.ipa.oz.lang._Root_if obj = null;
// 540
    JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_if to = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_pcl (toGOL);
// 541
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd = null;
// 542
    try {
// 543
      nd = SearchOwnerMap (path);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_8) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_8 = _exception_8.getOzException ();
      if (_oz_exception_8 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_8;
// 544
        throw new JP.go.ipa.oz.lang.OzException (e);
      } else throw _exception_8;
    }
// 545
    JP.go.ipa.oz.lib.standard._Dictionary_if getOwnerMap$val$355;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getOwnerMap$val$355 = nr.getOwnerMap ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOwnerMap$val$355 = nr.getOwnerMap ();
    }
// 545
    JP.go.ipa.oz.lib.standard._Dictionary_if ownermap = getOwnerMap$val$355;
// 550
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) to)) {
      try {
        to.putBranch (path, nd);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      to.putBranch (path, nd);
    }
// 554
    ownermap = removeSubDir (ownermap, path);
// 555
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        nr.setOwnerMap (ownermap);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nr.setOwnerMap (ownermap);
    }
// 559
    JP.go.ipa.oz.lib.standard._Dictionary_if getBranches$val$356;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getBranches$val$356 = nr.getBranches ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBranches$val$356 = nr.getBranches ();
    }
// 559
    JP.go.ipa.oz.lib.standard._Dictionary_if branches = getBranches$val$356;
// 560
    JP.go.ipa.oz.lib.standard._String_if asString$val$357;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        asString$val$357 = path.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$357 = path.asString ();
    }
// 560
    JP.go.ipa.oz.lang._Root_if get$val$358;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) branches)) {
      try {
        get$val$358 = branches.get (asString$val$357);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$358 = branches.get (asString$val$357);
    }
// 560
    if ((obj = get$val$358) == null) {{
// 563
        JP.go.ipa.oz.user.lib_dist.name._Path_if UpperPath$val$359;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
          try {
            UpperPath$val$359 = path.UpperPath (delimitor);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          UpperPath$val$359 = path.UpperPath (delimitor);
        }
// 563
        JP.go.ipa.oz.user.lib_dist.name._Path_if parentpath = UpperPath$val$359;
// 564
        JP.go.ipa.oz.lib.standard._String_if LowerName$val$360;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
          try {
            LowerName$val$360 = path.LowerName (delimitor);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          LowerName$val$360 = path.LowerName (delimitor);
        }
// 564
        JP.go.ipa.oz.lib.standard._String_if name = LowerName$val$360;
// 565
        JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if parentnd = null;
// 565
        JP.go.ipa.oz.lib.standard._String_if asString$val$361;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) parentpath)) {
          try {
            asString$val$361 = parentpath.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$361 = parentpath.asString ();
        }
// 565
        JP.go.ipa.oz.lang._Root_if get$val$362;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ownermap)) {
          try {
            get$val$362 = ownermap.get (asString$val$361);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          get$val$362 = ownermap.get (asString$val$361);
        }
// 565
        parentnd = (JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if) (get$val$362);
// 566
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) parentnd)) {
          try {
            parentnd.BranchInOtherCell (name);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          parentnd.BranchInOtherCell (name);
        }
      }
    } else {{
// 572
        JP.go.ipa.oz.lib.standard._Dictionary_if getBranches$val$363;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
          try {
            getBranches$val$363 = nr.getBranches ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getBranches$val$363 = nr.getBranches ();
        }
// 572
        JP.go.ipa.oz.lib.standard._Dictionary_if branches$1 = getBranches$val$363;
// 573
        JP.go.ipa.oz.lib.standard._String_if asString$val$364;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
          try {
            asString$val$364 = path.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$364 = path.asString ();
        }
// 573
        JP.go.ipa.oz.lib.standard._Dictionary_if remove$val$365;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) branches$1)) {
          try {
            remove$val$365 = branches$1.remove (asString$val$364);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          remove$val$365 = branches$1.remove (asString$val$364);
        }
// 573
        branches$1 = remove$val$365;
// 574
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
          try {
            nr.setBranches (branches$1);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nr.setBranches (branches$1);
        }
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if DirectorySet (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 496
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd = null;
// 497
    try {
// 498
      nd = SearchOwnerMap (path);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_9) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_9 = _exception_9.getOzException ();
      if (_oz_exception_9 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_9;
// 500
        throw new JP.go.ipa.oz.lang.OzException (e);
      } else throw _exception_9;
    }
// 501
    JP.go.ipa.oz.lib.standard._Set_if DirectorySet$val$366;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nd)) {
      try {
        DirectorySet$val$366 = nd.DirectorySet ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      DirectorySet$val$366 = nd.DirectorySet ();
    }
// 501
    JP.go.ipa.oz.lib.standard._Set_if subdirs = DirectorySet$val$366;
// 502
    return subdirs;
  }
  
  protected boolean isBranch (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
// 122
    JP.go.ipa.oz.lib.standard._Dictionary_if getBranches$val$367;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getBranches$val$367 = nr.getBranches ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBranches$val$367 = nr.getBranches ();
    }
// 122
    JP.go.ipa.oz.lib.standard._Dictionary_if branch = getBranches$val$367;
// 123
    JP.go.ipa.oz.lib.standard._String_if asString$val$368;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        asString$val$368 = path.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$368 = path.asString ();
    }
// 123
    boolean containsKey$val$369;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) branch)) {
      try {
        containsKey$val$369 = branch.containsKey (asString$val$368);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      containsKey$val$369 = branch.containsKey (asString$val$368);
    }
// 123
    return containsKey$val$369;
  }
  
  public JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if getDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 386
    return SearchOwnerMap (path);
  }
  
  protected void quiet () throws Exception  {
// 31
    flushCell ();
  }
  
  public JP.go.ipa.oz.lang._Root_if removeEntry (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 199
    JP.go.ipa.oz.user.lib_dist.name._Path_if dirpath = null;
// 199
    JP.go.ipa.oz.lib.standard._String_if name = null;
// 199
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd = null;
// 200
    try {
// 201
      JP.go.ipa.oz.user.lib_dist.name._Path_if UpperPath$val$370;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          UpperPath$val$370 = path.UpperPath (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        UpperPath$val$370 = path.UpperPath (delimitor);
      }
// 201
      dirpath = UpperPath$val$370;
// 202
      JP.go.ipa.oz.lib.standard._String_if LowerName$val$371;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          LowerName$val$371 = path.LowerName (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        LowerName$val$371 = path.LowerName (delimitor);
      }
// 202
      name = LowerName$val$371;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 204
      JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl) (new JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl ())._new_init ();
// 204
      throw new JP.go.ipa.oz.lang.OzException (ee);
    }
// 205
    try {
// 206
      nd = SearchOwnerMap (dirpath);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_10) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_10 = _exception_10.getOzException ();
      if (_oz_exception_10 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_10;
// 208
        throw new JP.go.ipa.oz.lang.OzException (e);
      } else throw _exception_10;
    }
// 209
    JP.go.ipa.oz.lang._Root_if obj = null;
// 210
    JP.go.ipa.oz.lang._Root_if removeEntry$val$372;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nd)) {
      try {
        removeEntry$val$372 = nd.removeEntry (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      removeEntry$val$372 = nd.removeEntry (name);
    }
// 210
    obj = removeEntry$val$372;
// 212
    return obj;
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if getBranches () throws Exception  {
    checkSecureInvocation ();
// 78
    JP.go.ipa.oz.lib.standard._Dictionary_if getBranches$val$373;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getBranches$val$373 = nr.getBranches ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBranches$val$373 = nr.getBranches ();
    }
// 78
    JP.go.ipa.oz.lib.standard._Dictionary_if branches = getBranches$val$373;
// 79
    JP.go.ipa.oz.lib.standard._Set_if keys$val$374;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) branches)) {
      try {
        keys$val$374 = branches.keys ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      keys$val$374 = branches.keys ();
    }
// 79
    return keys$val$374;
  }
  
  public int DirectorySize (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 481
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd = null;
// 482
    try {
// 483
      nd = SearchOwnerMap (path);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_11) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_11 = _exception_11.getOzException ();
      if (_oz_exception_11 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_11;
// 485
        throw new JP.go.ipa.oz.lang.OzException (e);
      } else throw _exception_11;
    }
// 486
    int DirectorySize$val$375;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nd)) {
      try {
        DirectorySize$val$375 = nd.DirectorySize ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      DirectorySize$val$375 = nd.DirectorySize ();
    }
// 486
    int num = DirectorySize$val$375;
// 487
    return num;
  }
  
  public void putBranchInOtherCell (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 330
    JP.go.ipa.oz.user.lib_dist.name._Path_if dirpath = null;
// 330
    JP.go.ipa.oz.lib.standard._String_if subdirname = null;
// 330
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd = null;
// 331
    try {
// 332
      JP.go.ipa.oz.user.lib_dist.name._Path_if UpperPath$val$376;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          UpperPath$val$376 = path.UpperPath (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        UpperPath$val$376 = path.UpperPath (delimitor);
      }
// 332
      dirpath = UpperPath$val$376;
// 333
      JP.go.ipa.oz.lib.standard._String_if LowerName$val$377;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          LowerName$val$377 = path.LowerName (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        LowerName$val$377 = path.LowerName (delimitor);
      }
// 333
      subdirname = LowerName$val$377;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 335
      JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl) (new JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl ())._new_init ();
// 335
      throw new JP.go.ipa.oz.lang.OzException (ee);
    }
// 336
    try {
// 337
      nd = SearchOwnerMap (dirpath);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_12) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_12 = _exception_12.getOzException ();
      if (_oz_exception_12 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_12;
// 339
        throw new JP.go.ipa.oz.lang.OzException (e);
      } else throw _exception_12;
    }
// 340
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nd)) {
      try {
        nd.BranchInOtherCell (subdirname);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nd.BranchInOtherCell (subdirname);
    }
  }
  
  protected JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if SearchOwnerMap (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
// 101
    JP.go.ipa.oz.lib.standard._Dictionary_if getOwnerMap$val$378;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getOwnerMap$val$378 = nr.getOwnerMap ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOwnerMap$val$378 = nr.getOwnerMap ();
    }
// 101
    JP.go.ipa.oz.lib.standard._Dictionary_if ownermap = getOwnerMap$val$378;
// 103
    JP.go.ipa.oz.lang._Root_if obj = null;
// 104
    try {
// 105
      JP.go.ipa.oz.lib.standard._String_if asString$val$379;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          asString$val$379 = path.asString ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        asString$val$379 = path.asString ();
      }
// 105
      JP.go.ipa.oz.lang._Root_if get$val$380;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ownermap)) {
        try {
          get$val$380 = ownermap.get (asString$val$379);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        get$val$380 = ownermap.get (asString$val$379);
      }
// 105
      obj = get$val$380;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 108
      JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if ee = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_cl ())._new_init ();
// 109
      throw new JP.go.ipa.oz.lang.OzException (ee);
    }
// 111
    if (obj == null) {{
// 113
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_cl ())._new_init ();
// 114
        throw new JP.go.ipa.oz.lang.OzException (e);
      }
    } else {{
// 116
        JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd = null;
// 116
        nd = (JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if) (obj);
// 117
        return nd;
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if EntrySet (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 269
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd = null;
// 270
    JP.go.ipa.oz.lib.standard._Set_if names = null;
// 271
    try {
// 272
      nd = SearchOwnerMap (path);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_13) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_13 = _exception_13.getOzException ();
      if (_oz_exception_13 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_13;
// 274
        throw new JP.go.ipa.oz.lang.OzException (e);
      } else throw _exception_13;
    }
// 275
    JP.go.ipa.oz.lib.standard._Set_if EntrySet$val$381;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nd)) {
      try {
        EntrySet$val$381 = nd.EntrySet ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      EntrySet$val$381 = nd.EntrySet ();
    }
// 275
    names = EntrySet$val$381;
// 276
    return names;
  }
  
  public void putDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 308
    JP.go.ipa.oz.user.lib_dist.name._Path_if dirpath = null;
// 308
    JP.go.ipa.oz.lib.standard._String_if subdirname = null;
// 308
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd = null;
// 311
    try {
// 312
      JP.go.ipa.oz.user.lib_dist.name._Path_if UpperPath$val$382;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          UpperPath$val$382 = path.UpperPath (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        UpperPath$val$382 = path.UpperPath (delimitor);
      }
// 312
      dirpath = UpperPath$val$382;
// 313
      JP.go.ipa.oz.lib.standard._String_if LowerName$val$383;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          LowerName$val$383 = path.LowerName (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        LowerName$val$383 = path.LowerName (delimitor);
      }
// 313
      subdirname = LowerName$val$383;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 315
      JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl) (new JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl ())._new_init ();
// 315
      throw new JP.go.ipa.oz.lang.OzException (ee);
    }
// 316
    try {
// 318
      nd = SearchOwnerMap (dirpath);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_14) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_14 = _exception_14.getOzException ();
      if (_oz_exception_14 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_14;
// 320
        throw new JP.go.ipa.oz.lang.OzException (e);
      } else throw _exception_14;
    }
// 321
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if subdir = (JP.go.ipa.oz.user.lib_dist.name._NameDirectory_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameDirectory_cl ())._new_create ();
// 322
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nd)) {
      try {
        nd.putDirectory (subdirname, subdir);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nd.putDirectory (subdirname, subdir);
    }
// 323
    JP.go.ipa.oz.lib.standard._Dictionary_if getOwnerMap$val$384;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getOwnerMap$val$384 = nr.getOwnerMap ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOwnerMap$val$384 = nr.getOwnerMap ();
    }
// 323
    JP.go.ipa.oz.lib.standard._Dictionary_if ownermap = getOwnerMap$val$384;
// 324
    JP.go.ipa.oz.lib.standard._String_if asString$val$385;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        asString$val$385 = path.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$385 = path.asString ();
    }
// 324
    JP.go.ipa.oz.lib.standard._Dictionary_if put$val$386;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ownermap)) {
      try {
        put$val$386 = ownermap.put (asString$val$385, subdir);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$386 = ownermap.put (asString$val$385, subdir);
    }
// 324
    ownermap = put$val$386;
// 325
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        nr.setOwnerMap (ownermap);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nr.setOwnerMap (ownermap);
    }
  }
  
  public void putDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if subdir) throws Exception  {
    checkSecureInvocation ();
// 287
    JP.go.ipa.oz.user.lib_dist.name._Path_if dirpath = null;
// 287
    JP.go.ipa.oz.lib.standard._String_if subdirname = null;
// 287
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd = null;
// 288
    try {
// 289
      JP.go.ipa.oz.user.lib_dist.name._Path_if UpperPath$val$387;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          UpperPath$val$387 = path.UpperPath (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        UpperPath$val$387 = path.UpperPath (delimitor);
      }
// 289
      dirpath = UpperPath$val$387;
// 290
      JP.go.ipa.oz.lib.standard._String_if LowerName$val$388;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          LowerName$val$388 = path.LowerName (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        LowerName$val$388 = path.LowerName (delimitor);
      }
// 290
      subdirname = LowerName$val$388;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 292
      JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl) (new JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl ())._new_init ();
// 292
      throw new JP.go.ipa.oz.lang.OzException (ee);
    }
// 293
    try {
// 294
      nd = SearchOwnerMap (dirpath);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_15) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_15 = _exception_15.getOzException ();
      if (_oz_exception_15 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_15;
// 296
        throw new JP.go.ipa.oz.lang.OzException (e);
      } else throw _exception_15;
    }
// 297
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nd)) {
      try {
        nd.putDirectory (subdirname, subdir);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nd.putDirectory (subdirname, subdir);
    }
// 298
    JP.go.ipa.oz.lib.standard._Dictionary_if getOwnerMap$val$389;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getOwnerMap$val$389 = nr.getOwnerMap ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOwnerMap$val$389 = nr.getOwnerMap ();
    }
// 298
    JP.go.ipa.oz.lib.standard._Dictionary_if ownermap = getOwnerMap$val$389;
// 299
    JP.go.ipa.oz.lib.standard._String_if asString$val$390;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        asString$val$390 = path.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$390 = path.asString ();
    }
// 299
    JP.go.ipa.oz.lib.standard._Dictionary_if put$val$391;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ownermap)) {
      try {
        put$val$391 = ownermap.put (asString$val$390, subdir);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$391 = ownermap.put (asString$val$390, subdir);
    }
// 299
    ownermap = put$val$391;
// 300
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        nr.setOwnerMap (ownermap);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nr.setOwnerMap (ownermap);
    }
  }
  
  public boolean ping () throws Exception  {
    checkSecureInvocation ();
// 42
    return true;
  }
  
  public void putEntry (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.lang._Root_if ent) throws Exception  {
    checkSecureInvocation ();
// 133
    JP.go.ipa.oz.user.lib_dist.name._Path_if dirpath = null;
// 133
    JP.go.ipa.oz.lib.standard._String_if name = null;
// 133
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd = null;
// 135
    try {
// 136
      JP.go.ipa.oz.user.lib_dist.name._Path_if UpperPath$val$392;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          UpperPath$val$392 = path.UpperPath (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        UpperPath$val$392 = path.UpperPath (delimitor);
      }
// 136
      dirpath = UpperPath$val$392;
// 137
      JP.go.ipa.oz.lib.standard._String_if LowerName$val$393;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          LowerName$val$393 = path.LowerName (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        LowerName$val$393 = path.LowerName (delimitor);
      }
// 137
      name = LowerName$val$393;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 141
      JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl) (new JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl ())._new_init ();
// 141
      throw new JP.go.ipa.oz.lang.OzException (ee);
    }
// 142
    try {
// 144
      nd = SearchOwnerMap (dirpath);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_16) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_16 = _exception_16.getOzException ();
      if (_oz_exception_16 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_16;
// 147
        throw new JP.go.ipa.oz.lang.OzException (e);
      } else throw _exception_16;
    }
// 148
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nd)) {
      try {
        nd.putEntry (name, ent);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nd.putEntry (name, ent);
    }
  }
  
  protected JP.go.ipa.oz.lib.standard._Dictionary_if putSubDir (JP.go.ipa.oz.lib.standard._Dictionary_if ownermap, JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd) throws Exception  {
// 582
    boolean isBranch$val$394;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nd)) {
      try {
        isBranch$val$394 = nd.isBranch ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isBranch$val$394 = nd.isBranch ();
    }
// 582
    if (isBranch$val$394) {
// 582
      return ownermap;
    }
// 583
    JP.go.ipa.oz.lib.standard._Set_if DirectoryNameSet$val$395;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nd)) {
      try {
        DirectoryNameSet$val$395 = nd.DirectoryNameSet ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      DirectoryNameSet$val$395 = nd.DirectoryNameSet ();
    }
// 583
    JP.go.ipa.oz.lib.standard._Set_if subDirNames = DirectoryNameSet$val$395;
// 584
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$396;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subDirNames)) {
      try {
        iterator$val$396 = subDirNames.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$396 = subDirNames.iterator ();
    }
// 584
    JP.go.ipa.oz.lib.standard._Iterator_if it = iterator$val$396;
// 585
    JP.go.ipa.oz.lib.standard._String_if asString$val$397;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        asString$val$397 = path.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$397 = path.asString ();
    }
// 585
    JP.go.ipa.oz.lib.standard._Dictionary_if put$val$398;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ownermap)) {
      try {
        put$val$398 = ownermap.put (asString$val$397, nd);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$398 = ownermap.put (asString$val$397, nd);
    }
// 585
    JP.go.ipa.oz.lib.standard._Dictionary_if nextownermap = put$val$398;
// 587
    while (true) {
// 587
      boolean atEnd$val$399;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
        try {
          atEnd$val$399 = it.atEnd ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        atEnd$val$399 = it.atEnd ();
      }
      if (!(!(atEnd$val$399))) break;
      
      /* body */ _loop_1: {
// 589
        JP.go.ipa.oz.lib.standard._String_if subdirname = null;
// 590
        JP.go.ipa.oz.user.lib_dist.name._Path_if subdirpath = null;
// 591
        JP.go.ipa.oz.lang._Root_if nextElement$val$400;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
          try {
            nextElement$val$400 = it.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$400 = it.nextElement ();
        }
// 591
        subdirname = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$400);
// 593
        JP.go.ipa.oz.user.lib_dist.name._Path_if makeLowerPath$val$401;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
          try {
            makeLowerPath$val$401 = path.makeLowerPath (delimitor, subdirname);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          makeLowerPath$val$401 = path.makeLowerPath (delimitor, subdirname);
        }
// 593
        subdirpath = makeLowerPath$val$401;
// 595
        JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if subnd = null;
// 595
        JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if getDirectory$val$402;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nd)) {
          try {
            getDirectory$val$402 = nd.getDirectory (subdirname);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getDirectory$val$402 = nd.getDirectory (subdirname);
        }
// 595
        subnd = getDirectory$val$402;
// 596
        nextownermap = putSubDir (nextownermap, subdirpath, subnd);
      }
    }
// 599
    return nextownermap;
  }
  
  protected JP.go.ipa.oz.lib.standard._Dictionary_if removeSubDir (JP.go.ipa.oz.lib.standard._Dictionary_if nowownermap, JP.go.ipa.oz.user.lib_dist.name._Path_if nowpath) throws Exception  {
// 517
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd = null;
// 517
    JP.go.ipa.oz.lib.standard._String_if asString$val$403;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nowpath)) {
      try {
        asString$val$403 = nowpath.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$403 = nowpath.asString ();
    }
// 517
    JP.go.ipa.oz.lang._Root_if get$val$404;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nowownermap)) {
      try {
        get$val$404 = nowownermap.get (asString$val$403);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$404 = nowownermap.get (asString$val$403);
    }
// 517
    nd = (JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if) (get$val$404);
// 518
    JP.go.ipa.oz.lib.standard._Set_if DirectoryNameSet$val$405;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nd)) {
      try {
        DirectoryNameSet$val$405 = nd.DirectoryNameSet ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      DirectoryNameSet$val$405 = nd.DirectoryNameSet ();
    }
// 518
    JP.go.ipa.oz.lib.standard._Set_if subDirNames = DirectoryNameSet$val$405;
// 519
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$406;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) subDirNames)) {
      try {
        iterator$val$406 = subDirNames.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$406 = subDirNames.iterator ();
    }
// 519
    JP.go.ipa.oz.lib.standard._Iterator_if it = iterator$val$406;
// 520
    JP.go.ipa.oz.lib.standard._String_if asString$val$407;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nowpath)) {
      try {
        asString$val$407 = nowpath.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$407 = nowpath.asString ();
    }
// 520
    JP.go.ipa.oz.lib.standard._Dictionary_if remove$val$408;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nowownermap)) {
      try {
        remove$val$408 = nowownermap.remove (asString$val$407);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      remove$val$408 = nowownermap.remove (asString$val$407);
    }
// 520
    JP.go.ipa.oz.lib.standard._Dictionary_if nextownermap = remove$val$408;
// 521
    while (true) {
// 521
      boolean atEnd$val$409;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
        try {
          atEnd$val$409 = it.atEnd ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        atEnd$val$409 = it.atEnd ();
      }
      if (!(!(atEnd$val$409))) break;
      
      /* body */ _loop_1: {
// 522
        JP.go.ipa.oz.lib.standard._String_if subdirname = null;
// 523
        JP.go.ipa.oz.user.lib_dist.name._Path_if subdirpath = null;
// 524
        JP.go.ipa.oz.lang._Root_if nextElement$val$410;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
          try {
            nextElement$val$410 = it.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$410 = it.nextElement ();
        }
// 524
        subdirname = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$410);
// 525
        JP.go.ipa.oz.user.lib_dist.name._Path_if makeLowerPath$val$411;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nowpath)) {
          try {
            makeLowerPath$val$411 = nowpath.makeLowerPath (delimitor, subdirname);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          makeLowerPath$val$411 = nowpath.makeLowerPath (delimitor, subdirname);
        }
// 525
        subdirpath = makeLowerPath$val$411;
// 526
        nextownermap = removeSubDir (nextownermap, subdirpath);
      }
    }
// 528
    return nextownermap;
  }
  
  public boolean containEntry (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 159
    JP.go.ipa.oz.user.lib_dist.name._Path_if dirpath = null;
// 159
    JP.go.ipa.oz.lib.standard._String_if name = null;
// 159
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd = null;
// 160
    try {
// 161
      JP.go.ipa.oz.user.lib_dist.name._Path_if UpperPath$val$412;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          UpperPath$val$412 = path.UpperPath (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        UpperPath$val$412 = path.UpperPath (delimitor);
      }
// 161
      dirpath = UpperPath$val$412;
// 162
      JP.go.ipa.oz.lib.standard._String_if LowerName$val$413;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
        try {
          LowerName$val$413 = path.LowerName (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        LowerName$val$413 = path.LowerName (delimitor);
      }
// 162
      name = LowerName$val$413;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 164
      JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl) (new JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl ())._new_init ();
// 164
      throw new JP.go.ipa.oz.lang.OzException (ee);
    }
// 165
    try {
// 166
      nd = SearchOwnerMap (dirpath);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_17) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_17 = _exception_17.getOzException ();
      if (_oz_exception_17 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_17;
// 168
        throw new JP.go.ipa.oz.lang.OzException (e);
      } else throw _exception_17;
    }
// 169
    boolean containEntry$val$414;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nd)) {
      try {
        containEntry$val$414 = nd.containEntry (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      containEntry$val$414 = nd.containEntry (name);
    }
// 169
    boolean tf = containEntry$val$414;
// 170
    return tf;
  }
  
  protected void go () throws Exception  {
  }
  
  public JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if renameDirectory (JP.go.ipa.oz.user.lib_dist.name._Path_if source, JP.go.ipa.oz.user.lib_dist.name._Path_if target) throws Exception  {
    checkSecureInvocation ();
// 434
    JP.go.ipa.oz.user.lib_dist.name._Path_if sourcedirpath = null;
// 434
    JP.go.ipa.oz.lib.standard._String_if sourcesubdirname = null;
// 434
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if nd = null;
// 435
    JP.go.ipa.oz.user.lib_dist.name._Path_if targetdirpath = null;
// 435
    JP.go.ipa.oz.lib.standard._String_if targetsubdirname = null;
// 438
    if (isBranch (source)) {{
// 439
        JP.go.ipa.oz.user.lib_dist.name._NameDirectoryBranchException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameDirectoryBranchException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameDirectoryBranchException_cl ())._new_init ();
// 439
        throw new JP.go.ipa.oz.lang.OzException (e);
      }
    }
// 441
    try {
// 442
      nd = SearchOwnerMap (source);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_18) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_18 = _exception_18.getOzException ();
      if (_oz_exception_18 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_18;
// 444
        throw new JP.go.ipa.oz.lang.OzException (e);
      } else throw _exception_18;
    }
// 446
    int EntrySize$val$415;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nd)) {
      try {
        EntrySize$val$415 = nd.EntrySize ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      EntrySize$val$415 = nd.EntrySize ();
    }
// 446
    int entrysize = EntrySize$val$415;
// 447
    int DirectorySize$val$416;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nd)) {
      try {
        DirectorySize$val$416 = nd.DirectorySize ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      DirectorySize$val$416 = nd.DirectorySize ();
    }
// 447
    int subdirsize = DirectorySize$val$416;
    boolean bool$val$1;
    
    bool$val$1 = (entrysize > 0);
    if (!bool$val$1) {
      bool$val$1 = (subdirsize > 0);
    }
// 448
    if (bool$val$1) {{
// 449
        JP.go.ipa.oz.user.lib_dist.name._NameDirectoryNotEmptyException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameDirectoryNotEmptyException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameDirectoryNotEmptyException_cl ())._new_init ();
// 449
        throw new JP.go.ipa.oz.lang.OzException (e);
      }
    }
// 451
    try {
// 452
      JP.go.ipa.oz.user.lib_dist.name._Path_if UpperPath$val$417;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) source)) {
        try {
          UpperPath$val$417 = source.UpperPath (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        UpperPath$val$417 = source.UpperPath (delimitor);
      }
// 452
      sourcedirpath = UpperPath$val$417;
// 453
      JP.go.ipa.oz.lib.standard._String_if LowerName$val$418;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) source)) {
        try {
          LowerName$val$418 = source.LowerName (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        LowerName$val$418 = source.LowerName (delimitor);
      }
// 453
      sourcesubdirname = LowerName$val$418;
// 454
      JP.go.ipa.oz.user.lib_dist.name._Path_if UpperPath$val$419;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) target)) {
        try {
          UpperPath$val$419 = target.UpperPath (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        UpperPath$val$419 = target.UpperPath (delimitor);
      }
// 454
      targetdirpath = UpperPath$val$419;
// 455
      JP.go.ipa.oz.lib.standard._String_if LowerName$val$420;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) target)) {
        try {
          LowerName$val$420 = target.LowerName (delimitor);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        LowerName$val$420 = target.LowerName (delimitor);
      }
// 455
      targetsubdirname = LowerName$val$420;
    }
    catch (JP.go.ipa.oz.system.ExException _exception_e) {
      JP.go.ipa.oz.lang._Exception_if e = new JP.go.ipa.oz.lang._Exception_cl (_exception_e);
      
// 457
      JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl) (new JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl ())._new_init ();
// 457
      throw new JP.go.ipa.oz.lang.OzException (ee);
    }
// 459
    boolean isequal$val$421;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sourcedirpath)) {
      try {
        isequal$val$421 = sourcedirpath.isequal (targetdirpath);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$421 = sourcedirpath.isequal (targetdirpath);
    }
// 459
    if (!(isequal$val$421)) {{
// 460
        JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_if ee = (JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl) (new JP.go.ipa.oz.user.lib_dist.name._PathStringIllegularException_cl ())._new_init ();
// 460
        throw new JP.go.ipa.oz.lang.OzException (ee);
      }
    }
// 462
    try {
// 463
      nd = SearchOwnerMap (sourcedirpath);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_19) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_19 = _exception_19.getOzException ();
      if (_oz_exception_19 instanceof JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) {
        JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServerOwnerMapException_if) _oz_exception_19;
// 465
        throw new JP.go.ipa.oz.lang.OzException (e);
      } else throw _exception_19;
    }
// 467
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if removeDirectory$val$422;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nd)) {
      try {
        removeDirectory$val$422 = nd.removeDirectory (sourcesubdirname);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      removeDirectory$val$422 = nd.removeDirectory (sourcesubdirname);
    }
// 467
    JP.go.ipa.oz.user.lib_dist.name._NameDirectory_if subdir = removeDirectory$val$422;
// 468
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nd)) {
      try {
        nd.putDirectory (targetsubdirname, subdir);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nd.putDirectory (targetsubdirname, subdir);
    }
// 469
    JP.go.ipa.oz.lib.standard._Dictionary_if getOwnerMap$val$423;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getOwnerMap$val$423 = nr.getOwnerMap ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOwnerMap$val$423 = nr.getOwnerMap ();
    }
// 469
    JP.go.ipa.oz.lib.standard._Dictionary_if ownermap = getOwnerMap$val$423;
// 470
    JP.go.ipa.oz.lib.standard._String_if asString$val$424;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) source)) {
      try {
        asString$val$424 = source.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$424 = source.asString ();
    }
// 470
    JP.go.ipa.oz.lib.standard._Dictionary_if remove$val$425;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ownermap)) {
      try {
        remove$val$425 = ownermap.remove (asString$val$424);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      remove$val$425 = ownermap.remove (asString$val$424);
    }
// 470
    ownermap = remove$val$425;
// 471
    JP.go.ipa.oz.lib.standard._String_if asString$val$426;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) target)) {
      try {
        asString$val$426 = target.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$426 = target.asString ();
    }
// 471
    JP.go.ipa.oz.lib.standard._Dictionary_if put$val$427;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ownermap)) {
      try {
        put$val$427 = ownermap.put (asString$val$426, subdir);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$427 = ownermap.put (asString$val$426, subdir);
    }
// 471
    ownermap = put$val$427;
// 472
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        nr.setOwnerMap (ownermap);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nr.setOwnerMap (ownermap);
    }
// 473
    return subdir;
  }
  
  public _NameServerTransactionResource_cl () { super ("JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_pcl"); }
  
  public _NameServerTransactionResource_cl (String proxy_id) { super (proxy_id); }
  
}


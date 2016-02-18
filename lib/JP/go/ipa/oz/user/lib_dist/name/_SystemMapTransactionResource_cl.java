package JP.go.ipa.oz.user.lib_dist.name;

public class _SystemMapTransactionResource_cl extends JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_cl implements JP.go.ipa.oz.user.lib_dist.name._SystemMapTransactionResource_if {
  static final boolean _global_ = true;
  JP.go.ipa.oz.user.lib_dist.name._PollingRunnable_if polling;
  JP.go.ipa.oz.user.lib_dist.name._TroubleNameServers_if troubleList;
  JP.go.ipa.oz.lib.standard._String_if domainname;
  JP.go.ipa.oz.lib.standard._String_if delimitor;
  JP.go.ipa.oz.user.lib_dist.name._NameResource_if nr;
  
  public JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if FindOwner (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 191
    JP.go.ipa.oz.lib.standard._Dictionary_if getSystemmap$val$445;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getSystemmap$val$445 = nr.getSystemmap ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSystemmap$val$445 = nr.getSystemmap ();
    }
// 191
    JP.go.ipa.oz.lib.standard._Dictionary_if systemmap = getSystemmap$val$445;
// 192
    JP.go.ipa.oz.lib.standard._String_if asString$val$446;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        asString$val$446 = path.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$446 = path.asString ();
    }
// 192
    JP.go.ipa.oz.user.lib_dist.name._Path_if p = (JP.go.ipa.oz.user.lib_dist.name._Path_cl) (new JP.go.ipa.oz.user.lib_dist.name._Path_cl ())._new_breed (asString$val$446);
// 193
    JP.go.ipa.oz.user.lib_dist.name._Path_if emp = (JP.go.ipa.oz.user.lib_dist.name._Path_cl) (new JP.go.ipa.oz.user.lib_dist.name._Path_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("")));
// 194
    JP.go.ipa.oz.lang._Root_if obj = null;
// 196
    JP.go.ipa.oz.lib.standard._String_if asString$val$447;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) p)) {
      try {
        asString$val$447 = p.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$447 = p.asString ();
    }
// 196
    JP.go.ipa.oz.lang._Root_if get$val$448;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) systemmap)) {
      try {
        get$val$448 = systemmap.get (asString$val$447);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$448 = systemmap.get (asString$val$447);
    }
// 196
    obj = get$val$448;
// 197
    while (true) {
      if (!(obj == null)) break;
      
      /* body */ _loop_1: {
// 199
        JP.go.ipa.oz.user.lib_dist.name._Path_if UpperPath$val$449;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) p)) {
          try {
            UpperPath$val$449 = p.UpperPath (delimitor);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          UpperPath$val$449 = p.UpperPath (delimitor);
        }
// 199
        p = UpperPath$val$449;
// 201
        boolean isEmpty$val$450;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) p)) {
          try {
            isEmpty$val$450 = p.isEmpty ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isEmpty$val$450 = p.isEmpty ();
        }
// 201
        if (isEmpty$val$450) {{
// 203
            JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl ())._new_init ();
// 204
            throw new JP.go.ipa.oz.lang.OzException (e);
          }
        }
// 206
        JP.go.ipa.oz.lib.standard._String_if asString$val$451;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) p)) {
          try {
            asString$val$451 = p.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$451 = p.asString ();
        }
// 206
        JP.go.ipa.oz.lang._Root_if get$val$452;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) systemmap)) {
          try {
            get$val$452 = systemmap.get (asString$val$451);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          get$val$452 = systemmap.get (asString$val$451);
        }
// 206
        obj = get$val$452;
      }
    }
// 210
    JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if smv = null;
// 210
    smv = (JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if) (obj);
// 211
    JP.go.ipa.oz.lib.standard._String_if nameserverGOL$val$453;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
      try {
        nameserverGOL$val$453 = smv.nameserverGOL ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nameserverGOL$val$453 = smv.nameserverGOL ();
    }
// 211
    JP.go.ipa.oz.lib.standard._String_if nameserverGOL = nameserverGOL$val$453;
// 213
    JP.go.ipa.oz.user.lib_dist.name._Path_if tranpath$val$454;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
      try {
        tranpath$val$454 = smv.tranpath ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      tranpath$val$454 = smv.tranpath ();
    }
// 213
    JP.go.ipa.oz.user.lib_dist.name._Path_if tranpath = tranpath$val$454;
// 215
    boolean isEmpty$val$455;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) tranpath)) {
      try {
        isEmpty$val$455 = tranpath.isEmpty ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isEmpty$val$455 = tranpath.isEmpty ();
    }
// 215
    if (isEmpty$val$455) {
// 215
      smv = (JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_cl) (new JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_cl ())._new_create (nameserverGOL, path, false);
    } else {{
// 220
        JP.go.ipa.oz.lib.standard._String_if asString$val$456;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
          try {
            asString$val$456 = path.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$456 = path.asString ();
        }
// 220
        JP.go.ipa.oz.user.lib_dist.name._Path_if origpath = (JP.go.ipa.oz.user.lib_dist.name._Path_cl) (new JP.go.ipa.oz.user.lib_dist.name._Path_cl ())._new_breed (asString$val$456);
// 221
        JP.go.ipa.oz.user.lib_dist.name._Path_if translateWith$val$457;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) origpath)) {
          try {
            translateWith$val$457 = origpath.translateWith (p, tranpath);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          translateWith$val$457 = origpath.translateWith (p, tranpath);
        }
// 221
        JP.go.ipa.oz.user.lib_dist.name._Path_if mappingpath = translateWith$val$457;
// 222
        smv = (JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_cl) (new JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_cl ())._new_create (nameserverGOL, mappingpath, true);
      }
    }
// 224
    return smv;
  }
  
  public void putBranch (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.lib.standard._String_if toGOL) throws Exception  {
    checkSecureInvocation ();
// 234
    JP.go.ipa.oz.lib.standard._Dictionary_if getSystemmap$val$458;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getSystemmap$val$458 = nr.getSystemmap ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSystemmap$val$458 = nr.getSystemmap ();
    }
// 234
    JP.go.ipa.oz.lib.standard._Dictionary_if systemmap = getSystemmap$val$458;
// 237
    JP.go.ipa.oz.lib.standard._String_if asString$val$459;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        asString$val$459 = path.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$459 = path.asString ();
    }
// 237
    boolean containsKey$val$460;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) systemmap)) {
      try {
        containsKey$val$460 = systemmap.containsKey (asString$val$459);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      containsKey$val$460 = systemmap.containsKey (asString$val$459);
    }
// 237
    if (containsKey$val$460) {{
// 239
        JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_if e = (JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameServiceSystemMapException_cl ())._new_init ();
// 240
        throw new JP.go.ipa.oz.lang.OzException (e);
      }
    } else {{
// 243
        JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if smv = (JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_cl) (new JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_cl ())._new_create (toGOL);
// 244
        JP.go.ipa.oz.lib.standard._String_if asString$val$461;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
          try {
            asString$val$461 = path.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$461 = path.asString ();
        }
// 244
        JP.go.ipa.oz.lib.standard._Dictionary_if put$val$462;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) systemmap)) {
          try {
            put$val$462 = systemmap.put (asString$val$461, smv);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          put$val$462 = systemmap.put (asString$val$461, smv);
        }
// 244
        systemmap = put$val$462;
      }
    }
// 247
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        nr.setSystemmap (systemmap);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nr.setSystemmap (systemmap);
    }
  }
  
  protected void createResource () throws Exception  {
// 39
    nr = (JP.go.ipa.oz.user.lib_dist.name._NameResource_cl) (new JP.go.ipa.oz.user.lib_dist.name._NameResource_cl ())._new_create ();
// 39
    r = (JP.go.ipa.oz.user.lib_dist.tran._Resource_cl) (new JP.go.ipa.oz.user.lib_dist.tran._Resource_cl ())._new_create (nr);
  }
  
  public void restored (JP.go.ipa.oz.lib.standard._String_if serverNSTRGOL) throws Exception  {
    checkSecureInvocation ();
// 174
    boolean contains$val$463;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) troubleList)) {
      try {
        contains$val$463 = troubleList.contains (serverNSTRGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      contains$val$463 = troubleList.contains (serverNSTRGOL);
    }
// 174
    boolean tf = contains$val$463;
// 175
    if (tf) {{
// 176
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) troubleList)) {
          try {
            troubleList.remove (serverNSTRGOL);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          troubleList.remove (serverNSTRGOL);
        }
// 177
        AddNameServer (serverNSTRGOL);
      }
    }
  }
  
  public void setDelimitor (JP.go.ipa.oz.lib.standard._String_if s) throws Exception  {
    checkSecureInvocation ();
// 51
    delimitor = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (s);
  }
  
  protected void initialize () throws Exception  {
// 19
    d = (JP.go.ipa.oz.user.lib_dist.tran._Debug_cl) (new JP.go.ipa.oz.user.lib_dist.tran._Debug_cl ())._new_create ();
// 19
    x = 0;
// 20
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 20
    JP.go.ipa.oz.lib.standard._Array_if args = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (16);
// 21
    JP.go.ipa.oz.lib.standard._Array_if getArguments$val$464;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getArguments$val$464 = system.getArguments ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getArguments$val$464 = system.getArguments ();
    }
// 21
    args = getArguments$val$464;
// 22
    JP.go.ipa.oz.lib.standard._String_if selfGOL = null;
// 22
    JP.go.ipa.oz.lang._Root_if at$val$465;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
      try {
        at$val$465 = args.at (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$465 = args.at (0);
    }
// 22
    selfGOL = (JP.go.ipa.oz.lib.standard._String_if) (at$val$465);
// 23
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) d)) {
      try {
        d.setP (selfGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      d.setP (selfGOL);
    }
// 24
    super.initialize ((new JP.go.ipa.oz.lib.standard._String_cl("tmp0_smtr")), (new JP.go.ipa.oz.lib.standard._String_cl("tmp1_smtr")), (new JP.go.ipa.oz.lib.standard._String_cl("tmp2_smtr")), selfGOL);
// 25
    domainname = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("")));
// 27
    JP.go.ipa.oz.lang._Root_if at$val$466;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) args)) {
      try {
        at$val$466 = args.at (1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      at$val$466 = args.at (1);
    }
// 27
    delimitor = (JP.go.ipa.oz.lib.standard._String_if) (at$val$466);
// 28
    troubleList = (JP.go.ipa.oz.user.lib_dist.name._TroubleNameServers_cl) (new JP.go.ipa.oz.user.lib_dist.name._TroubleNameServers_cl ())._new_create ();
// 29
    polling = (JP.go.ipa.oz.user.lib_dist.name._PollingRunnable_cl) (new JP.go.ipa.oz.user.lib_dist.name._PollingRunnable_cl ())._new_create (troubleList);
// 30
    JP.go.ipa.oz.lang._Thread_if tMil = (JP.go.ipa.oz.lang._Thread_cl) (new JP.go.ipa.oz.lang._Thread_cl ())._new_create (polling);
// 31
    createResource ();
  }
  
  public void troubleControlPollingStart () throws Exception  {
    checkSecureInvocation ();
// 43
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
  
  public void RemoveNameServer (JP.go.ipa.oz.lib.standard._String_if serverGOL) throws Exception  {
    checkSecureInvocation ();
// 117
    JP.go.ipa.oz.lib.standard._Set_if getServers$val$467;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getServers$val$467 = nr.getServers ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getServers$val$467 = nr.getServers ();
    }
// 117
    JP.go.ipa.oz.lib.standard._Set_if servers = getServers$val$467;
// 118
    JP.go.ipa.oz.lib.standard._Collection_if remove$val$468;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) servers)) {
      try {
        remove$val$468 = servers.remove (serverGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      remove$val$468 = servers.remove (serverGOL);
    }
// 119
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        nr.setServers (servers);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nr.setServers (servers);
    }
// 122
    JP.go.ipa.oz.lib.standard._Dictionary_if getSystemmap$val$469;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getSystemmap$val$469 = nr.getSystemmap ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSystemmap$val$469 = nr.getSystemmap ();
    }
// 122
    JP.go.ipa.oz.lib.standard._Dictionary_if systemmap = getSystemmap$val$469;
// 123
    JP.go.ipa.oz.lib.standard._Iterator_if assocIterator$val$470;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) systemmap)) {
      try {
        assocIterator$val$470 = systemmap.assocIterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      assocIterator$val$470 = systemmap.assocIterator ();
    }
// 123
    JP.go.ipa.oz.lib.standard._Iterator_if it = assocIterator$val$470;
// 124
    while (true) {
// 124
      boolean atEnd$val$471;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
        try {
          atEnd$val$471 = it.atEnd ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        atEnd$val$471 = it.atEnd ();
      }
      if (!(!atEnd$val$471)) break;
      
      /* body */ _loop_1: {
// 125
        JP.go.ipa.oz.lib.standard._Association_if a = null;
// 126
        JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if smv = null;
// 127
        JP.go.ipa.oz.lib.standard._String_if s = null;
// 128
        JP.go.ipa.oz.lang._Root_if nextElement$val$472;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
          try {
            nextElement$val$472 = it.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$472 = it.nextElement ();
        }
// 128
        a = (JP.go.ipa.oz.lib.standard._Association_if) (nextElement$val$472);
// 129
        JP.go.ipa.oz.lang._Root_if value$val$473;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) a)) {
          try {
            value$val$473 = a.value ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          value$val$473 = a.value ();
        }
// 129
        smv = (JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if) (value$val$473);
// 130
        JP.go.ipa.oz.lib.standard._String_if nameserverGOL$val$474;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
          try {
            nameserverGOL$val$474 = smv.nameserverGOL ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nameserverGOL$val$474 = smv.nameserverGOL ();
        }
// 130
        s = nameserverGOL$val$474;
// 131
        boolean equals$val$475;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) s)) {
          try {
            equals$val$475 = s.equals (serverGOL);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          equals$val$475 = s.equals (serverGOL);
        }
// 131
        if (equals$val$475) {{
// 132
            JP.go.ipa.oz.lang._Root_if key$val$476;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) a)) {
              try {
                key$val$476 = a.key ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              key$val$476 = a.key ();
            }
// 132
            JP.go.ipa.oz.lib.standard._Dictionary_if remove$val$477;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) systemmap)) {
              try {
                remove$val$477 = systemmap.remove (key$val$476);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              remove$val$477 = systemmap.remove (key$val$476);
            }
// 132
            systemmap = remove$val$477;
          }
        }
      }
    }
// 135
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        nr.setSystemmap (systemmap);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nr.setSystemmap (systemmap);
    }
  }
  
  public void unBranched (JP.go.ipa.oz.user.lib_dist.name._Path_if path) throws Exception  {
    checkSecureInvocation ();
// 272
    JP.go.ipa.oz.lib.standard._Dictionary_if getSystemmap$val$478;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getSystemmap$val$478 = nr.getSystemmap ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSystemmap$val$478 = nr.getSystemmap ();
    }
// 272
    JP.go.ipa.oz.lib.standard._Dictionary_if systemmap = getSystemmap$val$478;
// 273
    JP.go.ipa.oz.lib.standard._String_if asString$val$479;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        asString$val$479 = path.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$479 = path.asString ();
    }
// 273
    JP.go.ipa.oz.lib.standard._Dictionary_if remove$val$480;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) systemmap)) {
      try {
        remove$val$480 = systemmap.remove (asString$val$479);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      remove$val$480 = systemmap.remove (asString$val$479);
    }
// 273
    systemmap = remove$val$480;
// 274
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        nr.setSystemmap (systemmap);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nr.setSystemmap (systemmap);
    }
  }
  
  public void debugPrint () throws Exception  {
    checkSecureInvocation ();
// 55
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 56
    JP.go.ipa.oz.lib.standard._PrintWriter_if getStdout$val$481;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getStdout$val$481 = system.getStdout ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getStdout$val$481 = system.getStdout ();
    }
// 56
    JP.go.ipa.oz.lib.standard._PrintWriter_if pw = getStdout$val$481;
// 57
    JP.go.ipa.oz.lib.standard._String_if string$116 = (new JP.go.ipa.oz.lib.standard._String_cl("NameService ------"));
    
// 57
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.println (string$116);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.println (string$116);
    }
// 58
    JP.go.ipa.oz.lib.standard._Set_if servers = null;
// 58
    JP.go.ipa.oz.lib.standard._Set_if getServers$val$482;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getServers$val$482 = nr.getServers ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getServers$val$482 = nr.getServers ();
    }
// 58
    servers = getServers$val$482;
// 59
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$483;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) servers)) {
      try {
        iterator$val$483 = servers.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$483 = servers.iterator ();
    }
// 59
    JP.go.ipa.oz.lib.standard._Iterator_if it = iterator$val$483;
// 60
    JP.go.ipa.oz.lib.standard._String_if string$117 = (new JP.go.ipa.oz.lib.standard._String_cl("  serverGOL"));
    
// 60
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.println (string$117);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.println (string$117);
    }
// 61
    while (true) {
// 61
      boolean atEnd$val$484;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
        try {
          atEnd$val$484 = it.atEnd ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        atEnd$val$484 = it.atEnd ();
      }
      if (!(!(atEnd$val$484))) break;
      
      /* body */ _loop_1: {
// 62
        JP.go.ipa.oz.lib.standard._String_if serverGOL = null;
// 62
        JP.go.ipa.oz.lang._Root_if nextElement$val$485;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
          try {
            nextElement$val$485 = it.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$485 = it.nextElement ();
        }
// 62
        serverGOL = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$485);
// 63
        JP.go.ipa.oz.lib.standard._String_if string$118 = (new JP.go.ipa.oz.lib.standard._String_cl("    "));
        
// 63
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
          try {
            pw.print (string$118);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          pw.print (string$118);
        }
// 63
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
          try {
            pw.println (serverGOL);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          pw.println (serverGOL);
        }
      }
    }
// 65
    JP.go.ipa.oz.lib.standard._Dictionary_if systemmap = null;
// 65
    JP.go.ipa.oz.lib.standard._Dictionary_if getSystemmap$val$486;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getSystemmap$val$486 = nr.getSystemmap ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSystemmap$val$486 = nr.getSystemmap ();
    }
// 65
    systemmap = getSystemmap$val$486;
// 66
    JP.go.ipa.oz.lib.standard._Iterator_if keyIterator$val$487;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) systemmap)) {
      try {
        keyIterator$val$487 = systemmap.keyIterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      keyIterator$val$487 = systemmap.keyIterator ();
    }
// 66
    JP.go.ipa.oz.lib.standard._Iterator_if keyit = keyIterator$val$487;
// 67
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$488;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) systemmap)) {
      try {
        iterator$val$488 = systemmap.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$488 = systemmap.iterator ();
    }
// 67
    JP.go.ipa.oz.lib.standard._Iterator_if valit = iterator$val$488;
// 68
    JP.go.ipa.oz.lib.standard._String_if string$119 = (new JP.go.ipa.oz.lib.standard._String_cl("  systemmap"));
    
// 68
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.println (string$119);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.println (string$119);
    }
// 69
    while (true) {
// 69
      boolean atEnd$val$489;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) keyit)) {
        try {
          atEnd$val$489 = keyit.atEnd ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        atEnd$val$489 = keyit.atEnd ();
      }
      if (!(!(atEnd$val$489))) break;
      
      /* body */ _loop_1: {
// 70
        JP.go.ipa.oz.lib.standard._String_if pathname = null;
// 70
        JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if smv = null;
// 71
        JP.go.ipa.oz.lang._Root_if nextElement$val$490;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) keyit)) {
          try {
            nextElement$val$490 = keyit.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$490 = keyit.nextElement ();
        }
// 71
        pathname = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$490);
// 72
        JP.go.ipa.oz.lang._Root_if nextElement$val$491;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) valit)) {
          try {
            nextElement$val$491 = valit.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$491 = valit.nextElement ();
        }
// 72
        smv = (JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if) (nextElement$val$491);
// 73
        JP.go.ipa.oz.lib.standard._String_if string$120 = (new JP.go.ipa.oz.lib.standard._String_cl("    "));
        
// 73
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
          try {
            pw.print (string$120);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          pw.print (string$120);
        }
// 73
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
          try {
            pw.print (pathname);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          pw.print (pathname);
        }
// 74
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) smv)) {
          try {
            smv.debugPrint (pw);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          smv.debugPrint (pw);
        }
// 74
        JP.go.ipa.oz.lib.standard._String_if string$121 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
        
// 74
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
          try {
            pw.println (string$121);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          pw.println (string$121);
        }
      }
    }
// 76
    JP.go.ipa.oz.lib.standard._String_if string$122 = (new JP.go.ipa.oz.lib.standard._String_cl("------"));
    
// 76
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pw)) {
      try {
        pw.println (string$122);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      pw.println (string$122);
    }
// 77
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
// 252
    JP.go.ipa.oz.lib.standard._Dictionary_if getSystemmap$val$492;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getSystemmap$val$492 = nr.getSystemmap ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSystemmap$val$492 = nr.getSystemmap ();
    }
// 252
    JP.go.ipa.oz.lib.standard._Dictionary_if systemmap = getSystemmap$val$492;
// 257
    JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if smv = (JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_cl) (new JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_cl ())._new_create (toGOL);
// 258
    JP.go.ipa.oz.lib.standard._String_if asString$val$493;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        asString$val$493 = path.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$493 = path.asString ();
    }
// 258
    JP.go.ipa.oz.lib.standard._Dictionary_if put$val$494;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) systemmap)) {
      try {
        put$val$494 = systemmap.put (asString$val$493, smv);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$494 = systemmap.put (asString$val$493, smv);
    }
// 258
    systemmap = put$val$494;
// 265
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        nr.setSystemmap (systemmap);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nr.setSystemmap (systemmap);
    }
  }
  
  protected void quiet () throws Exception  {
// 36
    flushCell ();
  }
  
  public void setDomainName (JP.go.ipa.oz.lib.standard._String_if s) throws Exception  {
    checkSecureInvocation ();
// 47
    domainname = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (s);
  }
  
  public void AddNameServer (JP.go.ipa.oz.lib.standard._String_if serverGOL) throws Exception  {
    checkSecureInvocation ();
// 88
    JP.go.ipa.oz.lib.standard._Set_if getServers$val$495;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getServers$val$495 = nr.getServers ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getServers$val$495 = nr.getServers ();
    }
// 88
    JP.go.ipa.oz.lib.standard._Set_if servers = getServers$val$495;
// 89
    JP.go.ipa.oz.lib.standard._Set_if add$val$496;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) servers)) {
      try {
        add$val$496 = servers.add (serverGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$496 = servers.add (serverGOL);
    }
// 90
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        nr.setServers (servers);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nr.setServers (servers);
    }
// 93
    JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_if nstr = new JP.go.ipa.oz.user.lib_dist.name._NameServerTransactionResource_pcl (serverGOL);
// 94
    JP.go.ipa.oz.lib.standard._Set_if getBranches$val$497;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nstr)) {
      try {
        getBranches$val$497 = nstr.getBranches ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getBranches$val$497 = nstr.getBranches ();
    }
// 94
    JP.go.ipa.oz.lib.standard._Set_if branchpathes = getBranches$val$497;
// 95
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$498;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) branchpathes)) {
      try {
        iterator$val$498 = branchpathes.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$498 = branchpathes.iterator ();
    }
// 95
    JP.go.ipa.oz.lib.standard._Iterator_if it = iterator$val$498;
// 96
    JP.go.ipa.oz.lib.standard._Dictionary_if getSystemmap$val$499;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getSystemmap$val$499 = nr.getSystemmap ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSystemmap$val$499 = nr.getSystemmap ();
    }
// 96
    JP.go.ipa.oz.lib.standard._Dictionary_if systemmap = getSystemmap$val$499;
// 97
    JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if smv = (JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_cl) (new JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_cl ())._new_create (serverGOL);
// 98
    while (true) {
// 98
      boolean atEnd$val$500;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
        try {
          atEnd$val$500 = it.atEnd ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        atEnd$val$500 = it.atEnd ();
      }
      if (!(!atEnd$val$500)) break;
      
      /* body */ _loop_1: {
// 99
        JP.go.ipa.oz.user.lib_dist.name._Path_if p = null;
// 100
        JP.go.ipa.oz.lang._Root_if nextElement$val$501;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) it)) {
          try {
            nextElement$val$501 = it.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$501 = it.nextElement ();
        }
// 100
        p = (JP.go.ipa.oz.user.lib_dist.name._Path_if) (nextElement$val$501);
// 101
        JP.go.ipa.oz.lib.standard._String_if asString$val$502;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) p)) {
          try {
            asString$val$502 = p.asString ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          asString$val$502 = p.asString ();
        }
// 101
        JP.go.ipa.oz.lib.standard._Dictionary_if put$val$503;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) systemmap)) {
          try {
            put$val$503 = systemmap.put (asString$val$502, smv);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          put$val$503 = systemmap.put (asString$val$502, smv);
        }
// 101
        systemmap = put$val$503;
      }
    }
// 103
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        nr.setSystemmap (systemmap);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nr.setSystemmap (systemmap);
    }
  }
  
  protected void go () throws Exception  {
  }
  
  public void addMapping (JP.go.ipa.oz.user.lib_dist.name._Path_if path, JP.go.ipa.oz.user.lib_dist.name._Path_if to, JP.go.ipa.oz.lib.standard._String_if serverNSTGOL) throws Exception  {
    checkSecureInvocation ();
// 151
    JP.go.ipa.oz.lib.standard._Dictionary_if getSystemmap$val$504;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getSystemmap$val$504 = nr.getSystemmap ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getSystemmap$val$504 = nr.getSystemmap ();
    }
// 151
    JP.go.ipa.oz.lib.standard._Dictionary_if systemmap = getSystemmap$val$504;
// 152
    JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_if smv = (JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_cl) (new JP.go.ipa.oz.user.lib_dist.name._SystemMapValue_cl ())._new_create (serverNSTGOL, to, true);
// 153
    JP.go.ipa.oz.lib.standard._String_if asString$val$505;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) path)) {
      try {
        asString$val$505 = path.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$505 = path.asString ();
    }
// 153
    JP.go.ipa.oz.lib.standard._Dictionary_if put$val$506;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) systemmap)) {
      try {
        put$val$506 = systemmap.put (asString$val$505, smv);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      put$val$506 = systemmap.put (asString$val$505, smv);
    }
// 153
    systemmap = put$val$506;
// 154
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        nr.setSystemmap (systemmap);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      nr.setSystemmap (systemmap);
    }
// 155
    return;
  }
  
  public boolean containServer (JP.go.ipa.oz.lib.standard._String_if serverGOL) throws Exception  {
    checkSecureInvocation ();
// 107
    JP.go.ipa.oz.lib.standard._Set_if getServers$val$507;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) nr)) {
      try {
        getServers$val$507 = nr.getServers ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getServers$val$507 = nr.getServers ();
    }
// 107
    JP.go.ipa.oz.lib.standard._Set_if servers = getServers$val$507;
// 108
    boolean contains$val$508;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) servers)) {
      try {
        contains$val$508 = servers.contains (serverGOL);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      contains$val$508 = servers.contains (serverGOL);
    }
// 108
    return (contains$val$508);
  }
  
  public void troubleWith (JP.go.ipa.oz.lib.standard._String_if serverNSTRGOL) throws Exception  {
    checkSecureInvocation ();
// 164
    if (serverNSTRGOL != null) {{
// 165
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) troubleList)) {
          try {
            troubleList.add (serverNSTRGOL);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          troubleList.add (serverNSTRGOL);
        }
// 166
        RemoveNameServer (serverNSTRGOL);
      }
    }
  }
  
  public _SystemMapTransactionResource_cl () { super ("JP.go.ipa.oz.user.lib_dist.name._SystemMapTransactionResource_pcl"); }
  
  public _SystemMapTransactionResource_cl (String proxy_id) { super (proxy_id); }
  
}


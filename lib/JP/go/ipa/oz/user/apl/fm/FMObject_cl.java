package JP.go.ipa.oz.user.apl.fm;

public class FMObject_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.apl.fm.FMObject_if {
  protected JP.go.ipa.oz.lib.standard._Set_if relations;
  protected JP.go.ipa.oz.user.apl.fm.RelationComparator_if rc;
  protected JP.go.ipa.oz.lib.standard._String_if name;
  protected JP.go.ipa.oz.user.apl.fm.Pointer_if identifier;
  
  public Object _new_create (JP.go.ipa.oz.lib.standard._String_if oname, JP.go.ipa.oz.lib.standard._Set_if orelations, JP.go.ipa.oz.user.apl.fm.Pointer_if oid) throws Exception  {
// 500
    JP.go.ipa.oz.user.apl.fm.Overseer_if overseer = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 503
    name = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed (oname);
// 506
    rc = (JP.go.ipa.oz.user.apl.fm.RelationComparator_cl) (new JP.go.ipa.oz.user.apl.fm.RelationComparator_cl ())._new_create ();
// 507
    relations = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (rc);
// 509
    if (oid == null) {{
// 510
        return this;
      }
    }
// 513
    JP.go.ipa.oz.user.apl.fm.FMContainer_if fed = null;
// 514
    JP.go.ipa.oz.user.apl.fm.FMContainer_if container$val$82;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) oid)) {
      try {
        container$val$82 = oid.container ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      container$val$82 = oid.container ();
    }
// 514
    fed = container$val$82;
// 515
    JP.go.ipa.oz.user.apl.fm.Pointer_if add$val$83;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fed)) {
      try {
        add$val$83 = fed.add (this);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      add$val$83 = fed.add (this);
    }
// 515
    identifier = add$val$83;
// 516
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (identifier);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (identifier);
    }
// 519
    JP.go.ipa.oz.lib.standard._Iterator_if iter = null;
// 520
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$84;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) orelations)) {
      try {
        iterator$val$84 = orelations.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$84 = orelations.iterator ();
    }
// 520
    iter = iterator$val$84;
// 521
    while (true) {
// 521
      boolean hasMoreElements$val$85;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$85 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$85 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$85)) break;
      
      /* body */ _loop_1: {
// 522
        JP.go.ipa.oz.user.apl.fm.Relation_if orel = null;
// 523
        JP.go.ipa.oz.user.apl.fm.Relation_if rel = null;
// 524
        JP.go.ipa.oz.lang._Root_if nextElement$val$86;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$86 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$86 = iter.nextElement ();
        }
// 524
        orel = (JP.go.ipa.oz.user.apl.fm.Relation_if) (nextElement$val$86);
// 525
        JP.go.ipa.oz.user.apl.fm.Relation_if cloneRelation$val$87;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) orel)) {
          try {
            cloneRelation$val$87 = orel.cloneRelation ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          cloneRelation$val$87 = orel.cloneRelation ();
        }
// 525
        rel = cloneRelation$val$87;
// 526
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rel)) {
          try {
            rel.setSource (identifier);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          rel.setSource (identifier);
        }
// 527
        add (rel);
      }
    }
// 529
    commit ();
    return this;
  }
  
  public Object _new_create () throws Exception  {
// 19
    rc = (JP.go.ipa.oz.user.apl.fm.RelationComparator_cl) (new JP.go.ipa.oz.user.apl.fm.RelationComparator_cl ())._new_create ();
// 20
    relations = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (rc);
// 21
    name = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("UnKnown")));
    return this;
  }
  
  public JP.go.ipa.oz.user.apl.fm.RelationComparator_if getRelationComparator () throws Exception  {
    checkSecureInvocation ();
// 322
    return rc;
  }
  
  protected int updateWithoutLock (JP.go.ipa.oz.user.apl.fm.FMObject_if obj) throws Exception  {
// 126
    int counter = 0;
    boolean bool$val$7;
    
    bool$val$7 = identifier != null;
    if (bool$val$7) {
// 128
      JP.go.ipa.oz.user.apl.fm.Pointer_if getIdentifier$val$88;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
        try {
          getIdentifier$val$88 = obj.getIdentifier ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getIdentifier$val$88 = obj.getIdentifier ();
      }
// 128
      boolean isEqualPointer$val$89;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) identifier)) {
        try {
          isEqualPointer$val$89 = identifier.isEqualPointer (getIdentifier$val$88);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isEqualPointer$val$89 = identifier.isEqualPointer (getIdentifier$val$88);
      }
      bool$val$7 = (isEqualPointer$val$89 != true);
    }
// 128
    if (bool$val$7) {{
// 129
        JP.go.ipa.oz.user.apl.fm.Pointer_if getIdentifier$val$90;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
          try {
            getIdentifier$val$90 = obj.getIdentifier ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getIdentifier$val$90 = obj.getIdentifier ();
        }
// 129
        setIdentifierWithoutLock (getIdentifier$val$90);
// 130
        counter++;
      }
    }
    boolean bool$val$8;
    
    bool$val$8 = name != null;
    if (bool$val$8) {
// 132
      JP.go.ipa.oz.lib.standard._String_if getName$val$91;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
        try {
          getName$val$91 = obj.getName ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getName$val$91 = obj.getName ();
      }
// 132
      boolean isequal$val$92;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) name)) {
        try {
          isequal$val$92 = name.isequal (getName$val$91);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$92 = name.isequal (getName$val$91);
      }
      bool$val$8 = (isequal$val$92 != true);
    }
// 132
    if (bool$val$8) {{
// 133
        JP.go.ipa.oz.lib.standard._String_if getName$val$93;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
          try {
            getName$val$93 = obj.getName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getName$val$93 = obj.getName ();
        }
// 133
        setNameWithoutLock (getName$val$93);
// 134
        counter++;
      }
    }
// 137
    if (relations != null) {{
// 138
        JP.go.ipa.oz.lib.standard._Set_if getAllRelations$val$94;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
          try {
            getAllRelations$val$94 = obj.getAllRelations ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getAllRelations$val$94 = obj.getAllRelations ();
        }
// 138
        JP.go.ipa.oz.lib.standard._Set_if difference$val$95;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getAllRelations$val$94)) {
          try {
            difference$val$95 = getAllRelations$val$94.difference (relations);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          difference$val$95 = getAllRelations$val$94.difference (relations);
        }
// 138
        JP.go.ipa.oz.lib.standard._Set_if list = difference$val$95;
// 139
        int size$val$96;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
          try {
            size$val$96 = list.size ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          size$val$96 = list.size ();
        }
// 139
        if (0 < (size$val$96)) {{
// 140
            JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$97;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
              try {
                iterator$val$97 = list.iterator ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              iterator$val$97 = list.iterator ();
            }
// 140
            JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$97;
// 141
            while (true) {
// 141
              boolean hasMoreElements$val$98;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
                try {
                  hasMoreElements$val$98 = iter.hasMoreElements ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                hasMoreElements$val$98 = iter.hasMoreElements ();
              }
              if (!(hasMoreElements$val$98)) break;
              
              /* body */ _loop_1: {
// 142
                JP.go.ipa.oz.user.apl.fm.Relation_if r = null;
// 142
                JP.go.ipa.oz.lang._Root_if nextElement$val$99;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
                  try {
                    nextElement$val$99 = iter.nextElement ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  nextElement$val$99 = iter.nextElement ();
                }
// 142
                r = (JP.go.ipa.oz.user.apl.fm.Relation_if) (nextElement$val$99);
// 143
                addWithoutLock (r);
// 144
                counter++;
              }
            }
          }
        }
// 148
        JP.go.ipa.oz.lib.standard._Set_if getAllRelations$val$100;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
          try {
            getAllRelations$val$100 = obj.getAllRelations ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getAllRelations$val$100 = obj.getAllRelations ();
        }
// 148
        JP.go.ipa.oz.lib.standard._Set_if difference$val$101;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) relations)) {
          try {
            difference$val$101 = relations.difference (getAllRelations$val$100);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          difference$val$101 = relations.difference (getAllRelations$val$100);
        }
// 148
        list = difference$val$101;
// 149
        int size$val$102;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
          try {
            size$val$102 = list.size ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          size$val$102 = list.size ();
        }
// 149
        if (0 < (size$val$102)) {{
// 150
            JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$103;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
              try {
                iterator$val$103 = list.iterator ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              iterator$val$103 = list.iterator ();
            }
// 150
            JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$103;
// 151
            while (true) {
// 151
              boolean hasMoreElements$val$104;
              if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
                try {
                  hasMoreElements$val$104 = iter.hasMoreElements ();
                } finally {
                  changeRunningToGreen ();
                }
              } else {
                hasMoreElements$val$104 = iter.hasMoreElements ();
              }
              if (!(hasMoreElements$val$104)) break;
              
              /* body */ _loop_1: {
// 152
                JP.go.ipa.oz.user.apl.fm.Relation_if r = null;
// 152
                JP.go.ipa.oz.lang._Root_if nextElement$val$105;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
                  try {
                    nextElement$val$105 = iter.nextElement ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  nextElement$val$105 = iter.nextElement ();
                }
// 152
                r = (JP.go.ipa.oz.user.apl.fm.Relation_if) (nextElement$val$105);
// 153
                removeWithoutLock (r);
// 154
                counter++;
              }
            }
          }
        }
      }
    }
// 159
    return counter;
  }
  
  public JP.go.ipa.oz.user.apl.fm.FMObject_if cloneSelf () throws Exception  {
    checkSecureInvocation ();
// 490
    JP.go.ipa.oz.user.apl.fm.FMObject_if clone = null;
// 491
    clone = (JP.go.ipa.oz.user.apl.fm.FMObject_cl) (new JP.go.ipa.oz.user.apl.fm.FMObject_cl ())._new_create (name, relations, identifier);
// 492
    return clone;
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if getRelatedObjects (JP.go.ipa.oz.lib.standard._String_if relName) throws Exception  {
    checkSecureInvocation ();
// 429
    JP.go.ipa.oz.lib.standard._Set_if result = null;
// 430
    JP.go.ipa.oz.lib.standard._SList_if relList = null;
// 431
    JP.go.ipa.oz.lib.standard._Iterator_if iter = null;
// 433
    result = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create ();
// 434
    relList = findRelations (relName);
// 436
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$106;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) relList)) {
      try {
        iterator$val$106 = relList.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$106 = relList.iterator ();
    }
// 436
    iter = iterator$val$106;
// 437
    while (true) {
// 437
      boolean hasMoreElements$val$107;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$107 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$107 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$107)) break;
      
      /* body */ _loop_1: {
// 438
        JP.go.ipa.oz.user.apl.fm.Relation_if rel = null;
// 439
        JP.go.ipa.oz.lang._Root_if nextElement$val$108;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$108 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$108 = iter.nextElement ();
        }
// 439
        rel = (JP.go.ipa.oz.user.apl.fm.Relation_if) (nextElement$val$108);
// 440
        boolean isAvailable$val$109;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rel)) {
          try {
            isAvailable$val$109 = rel.isAvailable ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isAvailable$val$109 = rel.isAvailable ();
        }
// 440
        if (isAvailable$val$109) {{
// 441
            JP.go.ipa.oz.user.apl.fm.FMObject_if obj = null;
// 442
            JP.go.ipa.oz.user.apl.fm.FMObject_if get$val$110;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rel)) {
              try {
                get$val$110 = rel.get ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              get$val$110 = rel.get ();
            }
// 442
            obj = get$val$110;
// 443
            if (obj != null) {{
// 444
                result.add (obj);
              }
            }
          }
        }
      }
    }
// 449
    return result;
  }
  
  public void commit () throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 83
      JP.go.ipa.oz.lib.standard._String_if gol = null;
// 84
      JP.go.ipa.oz.lib.standard._String_if getLocation$val$111;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) identifier)) {
        try {
          getLocation$val$111 = identifier.getLocation ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getLocation$val$111 = identifier.getLocation ();
      }
// 84
      gol = getLocation$val$111;
// 85
      JP.go.ipa.oz.user.apl.fm.FMContainer_if fed = new JP.go.ipa.oz.user.apl.fm.FMContainer_pcl (gol);
// 86
      if (fed != null) {{
// 87
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fed)) {
            try {
              fed.commit (this);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            fed.commit (this);
          }
        }
      }
    } finally {
      leave ();
    }
  }
  
  public void setName (JP.go.ipa.oz.lib.standard._String_if n) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 168
      name = n;
    } finally {
      leave ();
    }
  }
  
  public JP.go.ipa.oz.lib.standard._SList_if findRelations (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception  {
    checkSecureInvocation ();
// 305
    JP.go.ipa.oz.user.apl.fm.RelationComparator_if rc = (JP.go.ipa.oz.user.apl.fm.RelationComparator_cl) (new JP.go.ipa.oz.user.apl.fm.RelationComparator_cl ())._new_create ();
// 306
    JP.go.ipa.oz.lib.standard._SList_if list = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create (rc);
// 307
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$112;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) relations)) {
      try {
        iterator$val$112 = relations.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$112 = relations.iterator ();
    }
// 307
    JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$112;
// 308
    while (true) {
// 308
      boolean hasMoreElements$val$113;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$113 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$113 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$113)) break;
      
      /* body */ _loop_1: {
// 309
        JP.go.ipa.oz.user.apl.fm.Relation_if rel = null;
// 309
        JP.go.ipa.oz.lang._Root_if nextElement$val$114;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$114 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$114 = iter.nextElement ();
        }
// 309
        rel = (JP.go.ipa.oz.user.apl.fm.Relation_if) (nextElement$val$114);
// 310
        JP.go.ipa.oz.user.apl.fm.Pointer_if destination$val$115;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rel)) {
          try {
            destination$val$115 = rel.destination ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          destination$val$115 = rel.destination ();
        }
// 310
        boolean isEqualPointer$val$116;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ptr)) {
          try {
            isEqualPointer$val$116 = ptr.isEqualPointer (destination$val$115);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isEqualPointer$val$116 = ptr.isEqualPointer (destination$val$115);
        }
// 310
        if (isEqualPointer$val$116) {{
// 311
            JP.go.ipa.oz.lib.standard._SList_if pushBack$val$117;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
              try {
                pushBack$val$117 = list.pushBack (rel);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              pushBack$val$117 = list.pushBack (rel);
            }
          }
        }
      }
    }
// 314
    return list;
  }
  
  public JP.go.ipa.oz.lib.standard._SList_if findRelations (JP.go.ipa.oz.lib.standard._String_if s) throws Exception  {
    checkSecureInvocation ();
// 284
    JP.go.ipa.oz.user.apl.fm.RelationComparator_if rc = (JP.go.ipa.oz.user.apl.fm.RelationComparator_cl) (new JP.go.ipa.oz.user.apl.fm.RelationComparator_cl ())._new_create ();
// 285
    JP.go.ipa.oz.lib.standard._SList_if list = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create (rc);
// 286
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$118;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) relations)) {
      try {
        iterator$val$118 = relations.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$118 = relations.iterator ();
    }
// 286
    JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$118;
// 287
    while (true) {
// 287
      boolean hasMoreElements$val$119;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$119 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$119 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$119)) break;
      
      /* body */ _loop_1: {
// 288
        JP.go.ipa.oz.user.apl.fm.Relation_if r = null;
// 288
        JP.go.ipa.oz.lang._Root_if nextElement$val$120;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$120 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$120 = iter.nextElement ();
        }
// 288
        r = (JP.go.ipa.oz.user.apl.fm.Relation_if) (nextElement$val$120);
// 289
        boolean isEqualRelation$val$121;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
          try {
            isEqualRelation$val$121 = r.isEqualRelation (s);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isEqualRelation$val$121 = r.isEqualRelation (s);
        }
// 289
        if (isEqualRelation$val$121) {{
// 290
            JP.go.ipa.oz.lib.standard._SList_if pushBack$val$122;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
              try {
                pushBack$val$122 = list.pushBack (r);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              pushBack$val$122 = list.pushBack (r);
            }
          }
        }
      }
    }
// 293
    return list;
  }
  
  public void toGreen () throws Exception  {
    checkSecureInvocation ();
// 335
    JP.go.ipa.oz.user.apl.fm.Overseer_if overseer = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 336
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (identifier);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (identifier);
    }
// 337
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (name);
    }
// 338
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (relations);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (relations);
    }
// 339
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$123;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) relations)) {
      try {
        iterator$val$123 = relations.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$123 = relations.iterator ();
    }
// 339
    JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$123;
// 340
    while (true) {
// 340
      boolean hasMoreElements$val$124;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$124 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$124 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$124)) break;
      
      /* body */ _loop_1: {
// 341
        JP.go.ipa.oz.user.apl.fm.Relation_if r = null;
// 341
        JP.go.ipa.oz.lang._Root_if nextElement$val$125;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$125 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$125 = iter.nextElement ();
        }
// 341
        r = (JP.go.ipa.oz.user.apl.fm.Relation_if) (nextElement$val$125);
// 342
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
          try {
            overseer.permit (r);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          overseer.permit (r);
        }
      }
    }
// 344
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) overseer)) {
      try {
        overseer.permit (rc);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      overseer.permit (rc);
    }
  }
  
  public boolean isEqualFMObject (JP.go.ipa.oz.user.apl.fm.FMObject_if obj) throws Exception  {
    checkSecureInvocation ();
// 533
    JP.go.ipa.oz.lib.standard._String_if oname = null;
// 534
    if (obj == null) {
// 534
      return false;
    }
// 535
    JP.go.ipa.oz.lib.standard._String_if getName$val$126;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
      try {
        getName$val$126 = obj.getName ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getName$val$126 = obj.getName ();
    }
// 535
    oname = getName$val$126;
    boolean bool$val$9;
    
    bool$val$9 = name == null;
    if (!bool$val$9) {
      bool$val$9 = oname == null;
    }
// 536
    if (bool$val$9) {{
        boolean bool$val$10;
        
        bool$val$10 = name == null;
        if (bool$val$10) {
          bool$val$10 = oname == null;
        }
// 537
        return (bool$val$10);
      }
    }
// 539
    boolean isequal$val$127;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) name)) {
      try {
        isequal$val$127 = name.isequal (oname);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$127 = name.isequal (oname);
    }
// 539
    return isequal$val$127;
  }
  
  public JP.go.ipa.oz.user.apl.fm.Pointer_if container () throws Exception  {
    checkSecureInvocation ();
// 63
    JP.go.ipa.oz.lib.standard._SList_if list = findRelations ((new JP.go.ipa.oz.lib.standard._String_cl("Pool")));
// 64
    JP.go.ipa.oz.user.apl.fm.FMObject_if obj = null;
// 65
    JP.go.ipa.oz.user.apl.fm.Pointer_if rtn = null;
// 66
    int size$val$128;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
      try {
        size$val$128 = list.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$128 = list.size ();
    }
// 66
    if (size$val$128 == 1) {{
// 67
        JP.go.ipa.oz.lang._Root_if first$val$129;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
          try {
            first$val$129 = list.first ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          first$val$129 = list.first ();
        }
// 67
        obj = (JP.go.ipa.oz.user.apl.fm.FMObject_if) (first$val$129);
// 68
        JP.go.ipa.oz.user.apl.fm.Pointer_if getIdentifier$val$130;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) obj)) {
          try {
            getIdentifier$val$130 = obj.getIdentifier ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getIdentifier$val$130 = obj.getIdentifier ();
        }
// 68
        rtn = getIdentifier$val$130;
      }
    } else {{
// 70
        rtn = null;
      }
    }
// 72
    return rtn;
  }
  
  void setIdentifierWithoutLock (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception  {
// 33
    identifier = ptr;
  }
  
  public void add (JP.go.ipa.oz.user.apl.fm.Relation_if r) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 192
      boolean contains$val$131;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) relations)) {
        try {
          contains$val$131 = relations.contains (r);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        contains$val$131 = relations.contains (r);
      }
// 192
      if (contains$val$131 != true) {{
// 193
          JP.go.ipa.oz.lib.standard._Set_if add$val$132;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) relations)) {
            try {
              add$val$132 = relations.add (r);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            add$val$132 = relations.add (r);
          }
        }
      }
    } finally {
      leave ();
    }
  }
  
  public JP.go.ipa.oz.user.apl.fm.FMContainer_if federation () throws Exception  {
    checkSecureInvocation ();
// 53
    JP.go.ipa.oz.user.apl.fm.FMContainer_if _conditional_val_0;
    if ((identifier != null)) {
// 53
      JP.go.ipa.oz.user.apl.fm.FMContainer_if container$val$133;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) identifier)) {
        try {
          container$val$133 = identifier.container ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        container$val$133 = identifier.container ();
      }
      _conditional_val_0 = container$val$133;
    } else {
      _conditional_val_0 = null;
    }
// 53
    return _conditional_val_0;
  }
  
  public void setIdentifier (JP.go.ipa.oz.user.apl.fm.Pointer_if ptr) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 30
      identifier = ptr;
    } finally {
      leave ();
    }
  }
  
  public JP.go.ipa.oz.user.apl.fm.FMObject_if getRelatedObject (JP.go.ipa.oz.lib.standard._String_if relName) throws Exception  {
    checkSecureInvocation ();
// 389
    JP.go.ipa.oz.lib.standard._SList_if relList = findRelations (relName);
// 391
    int size$val$134;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) relList)) {
      try {
        size$val$134 = relList.size ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      size$val$134 = relList.size ();
    }
// 391
    if (size$val$134 != 0) {{
// 392
        JP.go.ipa.oz.user.apl.fm.Relation_if rel = null;
// 392
        JP.go.ipa.oz.lang._Root_if first$val$135;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) relList)) {
          try {
            first$val$135 = relList.first ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          first$val$135 = relList.first ();
        }
// 392
        rel = (JP.go.ipa.oz.user.apl.fm.Relation_if) (first$val$135);
// 393
        JP.go.ipa.oz.user.apl.fm.FMObject_if get$val$136;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rel)) {
          try {
            get$val$136 = rel.get ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          get$val$136 = rel.get ();
        }
// 393
        return get$val$136;
      }
    }
// 396
    return null;
  }
  
  public void remove (JP.go.ipa.oz.user.apl.fm.Relation_if r) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 216
      boolean contains$val$137;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) relations)) {
        try {
          contains$val$137 = relations.contains (r);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        contains$val$137 = relations.contains (r);
      }
// 216
      if (contains$val$137 == true) {{
// 217
          JP.go.ipa.oz.lib.standard._Collection_if remove$val$138;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) relations)) {
            try {
              remove$val$138 = relations.remove (r);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            remove$val$138 = relations.remove (r);
          }
// 218
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
            try {
              r.delete ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            r.delete ();
          }
        }
      }
    } finally {
      leave ();
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if getAllRelations () throws Exception  {
    checkSecureInvocation ();
// 272
    return relations;
  }
  
  void setNameWithoutLock (JP.go.ipa.oz.lib.standard._String_if n) throws Exception  {
// 171
    name = n;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if asString () throws Exception  {
    checkSecureInvocation ();
// 328
    JP.go.ipa.oz.lib.standard._String_if string$12 = (new JP.go.ipa.oz.lib.standard._String_cl("["));
    
// 328
    JP.go.ipa.oz.lib.standard._String_if concat$val$139;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$12)) {
      try {
        concat$val$139 = string$12.concat (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$139 = string$12.concat (name);
    }
// 328
    JP.go.ipa.oz.lib.standard._String_if string$13 = (new JP.go.ipa.oz.lib.standard._String_cl("]"));
    
// 328
    JP.go.ipa.oz.lib.standard._String_if concat$val$140;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$139)) {
      try {
        concat$val$140 = concat$val$139.concat (string$13);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$140 = concat$val$139.concat (string$13);
    }
// 329
    JP.go.ipa.oz.lib.standard._String_if string$14 = (new JP.go.ipa.oz.lib.standard._String_cl(" identifier:"));
    
// 328
    JP.go.ipa.oz.lib.standard._String_if concat$val$141;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$140)) {
      try {
        concat$val$141 = concat$val$140.concat (string$14);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$141 = concat$val$140.concat (string$14);
    }
// 330
    JP.go.ipa.oz.lib.standard._String_if _conditional_val_1;
    if (identifier != null) {
// 330
      JP.go.ipa.oz.lib.standard._String_if getName$val$142;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) identifier)) {
        try {
          getName$val$142 = identifier.getName ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        getName$val$142 = identifier.getName ();
      }
      _conditional_val_1 = getName$val$142;
    } else {
      _conditional_val_1 = (new JP.go.ipa.oz.lib.standard._String_cl("null"));
    }
// 328
    JP.go.ipa.oz.lib.standard._String_if concat$val$143;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$141)) {
      try {
        concat$val$143 = concat$val$141.concat (_conditional_val_1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$143 = concat$val$141.concat (_conditional_val_1);
    }
// 328
    return concat$val$143;
  }
  
  public void trace (int mark) throws Exception  {
    checkSecureInvocation ();
// 543
    JP.go.ipa.oz.lib.standard._System_if system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 544
    JP.go.ipa.oz.lib.standard._String_if string$15 = (new JP.go.ipa.oz.lib.standard._String_cl("FMObject#trace("));
    
// 544
    JP.go.ipa.oz.lib.standard._String_if string$16 = (new JP.go.ipa.oz.lib.standard._String_cl(""));
    
// 544
    JP.go.ipa.oz.lib.standard._String_if valueOf$val$144;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$16)) {
      try {
        valueOf$val$144 = string$16.valueOf (mark);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      valueOf$val$144 = string$16.valueOf (mark);
    }
// 544
    JP.go.ipa.oz.lib.standard._String_if concat$val$145;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$15)) {
      try {
        concat$val$145 = string$15.concat (valueOf$val$144);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$145 = string$15.concat (valueOf$val$144);
    }
// 545
    JP.go.ipa.oz.lib.standard._String_if string$17 = (new JP.go.ipa.oz.lib.standard._String_cl(")"));
    
// 544
    JP.go.ipa.oz.lib.standard._String_if concat$val$146;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$145)) {
      try {
        concat$val$146 = concat$val$145.concat (string$17);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$146 = concat$val$145.concat (string$17);
    }
// 546
    JP.go.ipa.oz.lib.standard._String_if string$18 = (new JP.go.ipa.oz.lib.standard._String_cl(" Thread:"));
    
// 544
    JP.go.ipa.oz.lib.standard._String_if concat$val$147;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$146)) {
      try {
        concat$val$147 = concat$val$146.concat (string$18);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$147 = concat$val$146.concat (string$18);
    }
// 544
    JP.go.ipa.oz.lib.standard._String_if concat$val$148;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$147)) {
      try {
        concat$val$148 = concat$val$147.concat (runningIsGreen () ? (new JP.go.ipa.oz.lib.standard._String_cl("G")) : (new JP.go.ipa.oz.lib.standard._String_cl("R")));
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$148 = concat$val$147.concat (runningIsGreen () ? (new JP.go.ipa.oz.lib.standard._String_cl("G")) : (new JP.go.ipa.oz.lib.standard._String_cl("R")));
    }
// 547
    JP.go.ipa.oz.lib.standard._String_if string$19 = (new JP.go.ipa.oz.lib.standard._String_cl(" this:"));
    
// 544
    JP.go.ipa.oz.lib.standard._String_if concat$val$149;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$148)) {
      try {
        concat$val$149 = concat$val$148.concat (string$19);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$149 = concat$val$148.concat (string$19);
    }
// 544
    JP.go.ipa.oz.lib.standard._String_if concat$val$150;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$149)) {
      try {
        concat$val$150 = concat$val$149.concat (this.isGreen () ? (new JP.go.ipa.oz.lib.standard._String_cl("G")) : (new JP.go.ipa.oz.lib.standard._String_cl("R")));
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$150 = concat$val$149.concat (this.isGreen () ? (new JP.go.ipa.oz.lib.standard._String_cl("G")) : (new JP.go.ipa.oz.lib.standard._String_cl("R")));
    }
// 548
    JP.go.ipa.oz.lib.standard._String_if string$20 = (new JP.go.ipa.oz.lib.standard._String_cl(" name:"));
    
// 544
    JP.go.ipa.oz.lib.standard._String_if concat$val$151;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$150)) {
      try {
        concat$val$151 = concat$val$150.concat (string$20);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$151 = concat$val$150.concat (string$20);
    }
// 548
    boolean isGreen$val$152;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) name)) {
      try {
        isGreen$val$152 = name.isGreen ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isGreen$val$152 = name.isGreen ();
    }
// 544
    JP.go.ipa.oz.lib.standard._String_if concat$val$153;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$151)) {
      try {
        concat$val$153 = concat$val$151.concat (isGreen$val$152 ? (new JP.go.ipa.oz.lib.standard._String_cl("G")) : (new JP.go.ipa.oz.lib.standard._String_cl("R")));
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$153 = concat$val$151.concat (isGreen$val$152 ? (new JP.go.ipa.oz.lib.standard._String_cl("G")) : (new JP.go.ipa.oz.lib.standard._String_cl("R")));
    }
// 549
    JP.go.ipa.oz.lib.standard._String_if string$21 = (new JP.go.ipa.oz.lib.standard._String_cl("("));
    
// 544
    JP.go.ipa.oz.lib.standard._String_if concat$val$154;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$153)) {
      try {
        concat$val$154 = concat$val$153.concat (string$21);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$154 = concat$val$153.concat (string$21);
    }
// 544
    JP.go.ipa.oz.lib.standard._String_if concat$val$155;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$154)) {
      try {
        concat$val$155 = concat$val$154.concat (name);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$155 = concat$val$154.concat (name);
    }
// 549
    JP.go.ipa.oz.lib.standard._String_if string$22 = (new JP.go.ipa.oz.lib.standard._String_cl(")"));
    
// 544
    JP.go.ipa.oz.lib.standard._String_if concat$val$156;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$155)) {
      try {
        concat$val$156 = concat$val$155.concat (string$22);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$156 = concat$val$155.concat (string$22);
    }
// 550
    JP.go.ipa.oz.lib.standard._String_if string$23 = (new JP.go.ipa.oz.lib.standard._String_cl(" relations:"));
    
// 544
    JP.go.ipa.oz.lib.standard._String_if concat$val$157;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$156)) {
      try {
        concat$val$157 = concat$val$156.concat (string$23);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$157 = concat$val$156.concat (string$23);
    }
// 550
    boolean isGreen$val$158;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) relations)) {
      try {
        isGreen$val$158 = relations.isGreen ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isGreen$val$158 = relations.isGreen ();
    }
// 544
    JP.go.ipa.oz.lib.standard._String_if concat$val$159;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$157)) {
      try {
        concat$val$159 = concat$val$157.concat (isGreen$val$158 ? (new JP.go.ipa.oz.lib.standard._String_cl("G")) : (new JP.go.ipa.oz.lib.standard._String_cl("R")));
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$159 = concat$val$157.concat (isGreen$val$158 ? (new JP.go.ipa.oz.lib.standard._String_cl("G")) : (new JP.go.ipa.oz.lib.standard._String_cl("R")));
    }
// 551
    JP.go.ipa.oz.lib.standard._String_if string$24 = (new JP.go.ipa.oz.lib.standard._String_cl("("));
    
// 544
    JP.go.ipa.oz.lib.standard._String_if concat$val$160;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$159)) {
      try {
        concat$val$160 = concat$val$159.concat (string$24);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$160 = concat$val$159.concat (string$24);
    }
// 551
    JP.go.ipa.oz.lib.standard._String_if asString$val$161;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) relations)) {
      try {
        asString$val$161 = relations.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$161 = relations.asString ();
    }
// 544
    JP.go.ipa.oz.lib.standard._String_if concat$val$162;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$160)) {
      try {
        concat$val$162 = concat$val$160.concat (asString$val$161);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$162 = concat$val$160.concat (asString$val$161);
    }
// 551
    JP.go.ipa.oz.lib.standard._String_if string$25 = (new JP.go.ipa.oz.lib.standard._String_cl(")"));
    
// 544
    JP.go.ipa.oz.lib.standard._String_if concat$val$163;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$162)) {
      try {
        concat$val$163 = concat$val$162.concat (string$25);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$163 = concat$val$162.concat (string$25);
    }
// 552
    JP.go.ipa.oz.lib.standard._String_if string$26 = (new JP.go.ipa.oz.lib.standard._String_cl(" identifier:"));
    
// 544
    JP.go.ipa.oz.lib.standard._String_if concat$val$164;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$163)) {
      try {
        concat$val$164 = concat$val$163.concat (string$26);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$164 = concat$val$163.concat (string$26);
    }
// 553
    JP.go.ipa.oz.lib.standard._String_if _conditional_val_2;
    if (identifier != null) {
// 554
      boolean isGreen$val$165;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) identifier)) {
        try {
          isGreen$val$165 = identifier.isGreen ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isGreen$val$165 = identifier.isGreen ();
      }
// 555
      JP.go.ipa.oz.lib.standard._String_if asString$val$166;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) identifier)) {
        try {
          asString$val$166 = identifier.asString ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        asString$val$166 = identifier.asString ();
      }
// 554
      JP.go.ipa.oz.lib.standard._String_if concat$val$167;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) (isGreen$val$165 ? (new JP.go.ipa.oz.lib.standard._String_cl("G")) : (new JP.go.ipa.oz.lib.standard._String_cl("R"))))) {
        try {
          concat$val$167 = (isGreen$val$165 ? (new JP.go.ipa.oz.lib.standard._String_cl("G")) : (new JP.go.ipa.oz.lib.standard._String_cl("R"))).concat (asString$val$166);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        concat$val$167 = (isGreen$val$165 ? (new JP.go.ipa.oz.lib.standard._String_cl("G")) : (new JP.go.ipa.oz.lib.standard._String_cl("R"))).concat (asString$val$166);
      }
      _conditional_val_2 = concat$val$167;
    } else {
      _conditional_val_2 = (new JP.go.ipa.oz.lib.standard._String_cl("null"));
    }
// 544
    JP.go.ipa.oz.lib.standard._String_if concat$val$168;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$164)) {
      try {
        concat$val$168 = concat$val$164.concat (_conditional_val_2);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$168 = concat$val$164.concat (_conditional_val_2);
    }
// 544
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.println (concat$val$168);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.println (concat$val$168);
    }
  }
  
  void removeWithoutLock (JP.go.ipa.oz.user.apl.fm.Relation_if r) throws Exception  {
// 225
    boolean contains$val$169;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) relations)) {
      try {
        contains$val$169 = relations.contains (r);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      contains$val$169 = relations.contains (r);
    }
// 225
    if (contains$val$169 == true) {{
// 226
        JP.go.ipa.oz.lib.standard._Collection_if remove$val$170;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) relations)) {
          try {
            remove$val$170 = relations.remove (r);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          remove$val$170 = relations.remove (r);
        }
// 227
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
          try {
            r.delete ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          r.delete ();
        }
      }
    }
  }
  
  public JP.go.ipa.oz.user.apl.fm.Pointer_if getIdentifier () throws Exception  {
    checkSecureInvocation ();
// 42
    return identifier;
  }
  
  public JP.go.ipa.oz.user.apl.fm.Relation_if getRelation (JP.go.ipa.oz.user.apl.fm.Relation_if rel) throws Exception  {
    checkSecureInvocation ();
// 240
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$171;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) relations)) {
      try {
        iterator$val$171 = relations.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$171 = relations.iterator ();
    }
// 240
    JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$171;
// 241
    while (true) {
// 241
      boolean hasMoreElements$val$172;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$172 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$172 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$172)) break;
      
      /* body */ _loop_1: {
// 242
        JP.go.ipa.oz.user.apl.fm.Relation_if r = null;
// 242
        JP.go.ipa.oz.lang._Root_if nextElement$val$173;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$173 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$173 = iter.nextElement ();
        }
// 242
        r = (JP.go.ipa.oz.user.apl.fm.Relation_if) (nextElement$val$173);
// 243
        boolean isEqualRelation$val$174;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rel)) {
          try {
            isEqualRelation$val$174 = rel.isEqualRelation (r);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isEqualRelation$val$174 = rel.isEqualRelation (r);
        }
// 243
        if (isEqualRelation$val$174) {
// 244
          return r;
        }
      }
    }
// 246
    return null;
  }
  
  public int update (JP.go.ipa.oz.user.apl.fm.FMObject_if obj) throws Exception  {
    checkSecureInvocation ();
    enter ();
    try {
// 105
      return updateWithoutLock (obj);
    } finally {
      leave ();
    }
  }
  
  void addWithoutLock (JP.go.ipa.oz.user.apl.fm.Relation_if r) throws Exception  {
// 201
    boolean contains$val$175;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) relations)) {
      try {
        contains$val$175 = relations.contains (r);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      contains$val$175 = relations.contains (r);
    }
// 201
    if (contains$val$175 != true) {{
// 202
        JP.go.ipa.oz.lib.standard._Set_if add$val$176;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) relations)) {
          try {
            add$val$176 = relations.add (r);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          add$val$176 = relations.add (r);
        }
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getName () throws Exception  {
    checkSecureInvocation ();
// 179
    return name;
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if getRelations () throws Exception  {
    checkSecureInvocation ();
// 255
    JP.go.ipa.oz.user.apl.fm.RelationComparator_if rc = (JP.go.ipa.oz.user.apl.fm.RelationComparator_cl) (new JP.go.ipa.oz.user.apl.fm.RelationComparator_cl ())._new_create ();
// 256
    JP.go.ipa.oz.lib.standard._Set_if list = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (rc);
// 257
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$177;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) relations)) {
      try {
        iterator$val$177 = relations.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$177 = relations.iterator ();
    }
// 257
    JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$177;
// 258
    while (true) {
// 258
      boolean hasMoreElements$val$178;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$178 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$178 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$178)) break;
      
      /* body */ _loop_1: {
// 259
        JP.go.ipa.oz.user.apl.fm.Relation_if r = null;
// 259
        JP.go.ipa.oz.lang._Root_if nextElement$val$179;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$179 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$179 = iter.nextElement ();
        }
// 259
        r = (JP.go.ipa.oz.user.apl.fm.Relation_if) (nextElement$val$179);
// 260
        boolean isAvailable$val$180;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) r)) {
          try {
            isAvailable$val$180 = r.isAvailable ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isAvailable$val$180 = r.isAvailable ();
        }
// 260
        if (isAvailable$val$180) {
// 261
          JP.go.ipa.oz.lib.standard._Set_if add$val$181;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
            try {
              add$val$181 = list.add (r);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            add$val$181 = list.add (r);
          }
        }
      }
    }
// 263
    return list;
  }
  
  public JP.go.ipa.oz.lib.standard._Set_if getAllRelationName () throws Exception  {
    checkSecureInvocation ();
// 405
    JP.go.ipa.oz.lib.standard._Set_if list = getAllRelations ();
// 406
    JP.go.ipa.oz.lib.standard._StringComparator_if sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 407
    JP.go.ipa.oz.lib.standard._Set_if result = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (sc);
// 408
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$182;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) list)) {
      try {
        iterator$val$182 = list.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$182 = list.iterator ();
    }
// 408
    JP.go.ipa.oz.lib.standard._Iterator_if iter = iterator$val$182;
// 410
    while (true) {
// 410
      boolean hasMoreElements$val$183;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$183 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$183 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$183)) break;
      
      /* body */ _loop_1: {
// 411
        JP.go.ipa.oz.user.apl.fm.Relation_if rel = null;
// 411
        JP.go.ipa.oz.lang._Root_if nextElement$val$184;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$184 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$184 = iter.nextElement ();
        }
// 411
        rel = (JP.go.ipa.oz.user.apl.fm.Relation_if) (nextElement$val$184);
// 412
        JP.go.ipa.oz.lib.standard._String_if getName$val$185;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rel)) {
          try {
            getName$val$185 = rel.getName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getName$val$185 = rel.getName ();
        }
// 412
        JP.go.ipa.oz.lib.standard._Set_if add$val$186;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) result)) {
          try {
            add$val$186 = result.add (getName$val$185);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          add$val$186 = result.add (getName$val$185);
        }
      }
    }
// 415
    return result;
  }
  
  public void delete () throws Exception  {
    checkSecureInvocation ();
// 471
    JP.go.ipa.oz.user.apl.fm.FMContainer_if fed = null;
// 472
    JP.go.ipa.oz.lib.standard._Iterator_if iter = null;
// 474
    fed = federation ();
// 475
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$187;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) relations)) {
      try {
        iterator$val$187 = relations.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$187 = relations.iterator ();
    }
// 475
    iter = iterator$val$187;
// 476
    while (true) {
// 476
      boolean hasMoreElements$val$188;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
        try {
          hasMoreElements$val$188 = iter.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$188 = iter.hasMoreElements ();
      }
      if (!(hasMoreElements$val$188)) break;
      
      /* body */ _loop_1: {
// 477
        JP.go.ipa.oz.user.apl.fm.Relation_if rel = null;
// 478
        JP.go.ipa.oz.lang._Root_if nextElement$val$189;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) iter)) {
          try {
            nextElement$val$189 = iter.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$189 = iter.nextElement ();
        }
// 478
        rel = (JP.go.ipa.oz.user.apl.fm.Relation_if) (nextElement$val$189);
// 479
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rel)) {
          try {
            rel.delete ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          rel.delete ();
        }
      }
    }
// 482
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) fed)) {
      try {
        fed.remove (identifier);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      fed.remove (identifier);
    }
  }
  
  public JP.go.ipa.oz.user.apl.fm.Relation_if createRelation (JP.go.ipa.oz.user.apl.fm.Relation_if rel, JP.go.ipa.oz.user.apl.fm.FMObject_if destObj) throws Exception  {
    checkSecureInvocation ();
// 460
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rel)) {
      try {
        rel.detach ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      rel.detach ();
    }
// 461
    JP.go.ipa.oz.user.apl.fm.Pointer_if getIdentifier$val$190;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) destObj)) {
      try {
        getIdentifier$val$190 = destObj.getIdentifier ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getIdentifier$val$190 = destObj.getIdentifier ();
    }
// 461
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rel)) {
      try {
        rel.setDestination (getIdentifier$val$190);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      rel.setDestination (getIdentifier$val$190);
    }
// 462
    JP.go.ipa.oz.user.apl.fm.Pointer_if getIdentifier$val$191;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) destObj)) {
      try {
        getIdentifier$val$191 = destObj.getIdentifier ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getIdentifier$val$191 = destObj.getIdentifier ();
    }
// 462
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rel)) {
      try {
        rel.attach (getIdentifier$val$191);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      rel.attach (getIdentifier$val$191);
    }
// 464
    return rel;
  }
  
  public JP.go.ipa.oz.user.apl.fm.Relation_if createRelation (JP.go.ipa.oz.lib.standard._String_if relName, JP.go.ipa.oz.user.apl.fm.FMObject_if destObj) throws Exception  {
    checkSecureInvocation ();
// 358
    JP.go.ipa.oz.user.apl.fm.Relation_if rel = (JP.go.ipa.oz.user.apl.fm.Relation_cl) (new JP.go.ipa.oz.user.apl.fm.Relation_cl ())._new_create ();
// 359
    JP.go.ipa.oz.user.apl.fm.Overseer_if over = (JP.go.ipa.oz.user.apl.fm.Overseer_cl) (new JP.go.ipa.oz.user.apl.fm.Overseer_cl ())._new_create ();
// 360
    JP.go.ipa.oz.user.apl.fm.Pointer_if point = null;
// 362
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (relName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (relName);
    }
// 363
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) over)) {
      try {
        over.permit (destObj);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      over.permit (destObj);
    }
// 364
    JP.go.ipa.oz.user.apl.fm.Pointer_if getIdentifier$val$192;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) destObj)) {
      try {
        getIdentifier$val$192 = destObj.getIdentifier ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getIdentifier$val$192 = destObj.getIdentifier ();
    }
// 364
    point = getIdentifier$val$192;
// 366
    JP.go.ipa.oz.lib.standard._System_if sys = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 366
    JP.go.ipa.oz.lib.standard._String_if asString$val$193;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) destObj)) {
      try {
        asString$val$193 = destObj.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$193 = destObj.asString ();
    }
// 366
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
      try {
        sys.println (asString$val$193);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sys.println (asString$val$193);
    }
// 367
    JP.go.ipa.oz.lib.standard._String_if asString$val$194;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) point)) {
      try {
        asString$val$194 = point.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$194 = point.asString ();
    }
// 367
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
      try {
        sys.println (asString$val$194);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sys.println (asString$val$194);
    }
// 370
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rel)) {
      try {
        rel.setName (relName);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      rel.setName (relName);
    }
// 371
    JP.go.ipa.oz.lib.standard._String_if string$27 = (new JP.go.ipa.oz.lib.standard._String_cl("Set Name"));
    
// 371
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
      try {
        sys.println (string$27);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sys.println (string$27);
    }
// 372
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rel)) {
      try {
        rel.setSource (identifier);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      rel.setSource (identifier);
    }
// 373
    JP.go.ipa.oz.lib.standard._String_if string$28 = (new JP.go.ipa.oz.lib.standard._String_cl("Set Source"));
    
// 373
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
      try {
        sys.println (string$28);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sys.println (string$28);
    }
// 374
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rel)) {
      try {
        rel.setDestination (point);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      rel.setDestination (point);
    }
// 375
    JP.go.ipa.oz.lib.standard._String_if string$29 = (new JP.go.ipa.oz.lib.standard._String_cl("Set Destination"));
    
// 375
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
      try {
        sys.println (string$29);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sys.println (string$29);
    }
// 376
    add (rel);
// 377
    JP.go.ipa.oz.lib.standard._String_if string$30 = (new JP.go.ipa.oz.lib.standard._String_cl("Add Relation"));
    
// 377
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
      try {
        sys.println (string$30);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sys.println (string$30);
    }
// 378
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) rel)) {
      try {
        rel.attach (point);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      rel.attach (point);
    }
// 379
    JP.go.ipa.oz.lib.standard._String_if string$31 = (new JP.go.ipa.oz.lib.standard._String_cl("Attach Relation"));
    
// 379
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) sys)) {
      try {
        sys.println (string$31);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      sys.println (string$31);
    }
// 380
    return rel;
  }
  
  public FMObject_cl () throws Exception { super (); }
  
}


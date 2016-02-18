package JP.go.ipa.oz.user.ide;

final public class ClassBrowser_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.ClassBrowser_if {
  static final boolean _final_ = true;
  JP.go.ipa.oz.lib.standard._Dictionary_if partList;
  JP.go.ipa.oz.user.ide.School_if school;
  JP.go.ipa.oz.user.ide.CILoader_if ciLoader;
  JP.go.ipa.oz.lib.standard._String_if ROOT_IF_CID;
  JP.go.ipa.oz.lib.standard._System_if system;
  JP.go.ipa.oz.lib.standard._Dictionary_if superPartList;
  JP.go.ipa.oz.lib.standard._Dictionary_if partViewList;
  JP.go.ipa.oz.lib.standard._String_if ROOT_CL_CID;
  
  public Object _new_newClassBrowser (JP.go.ipa.oz.user.ide.School_if sc) throws Exception  {
// 29
    initParams (sc);
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._Collection_if getSuperPartsOf (JP.go.ipa.oz.user.ide.CIPart_if part) throws Exception  {
    checkSecureInvocation ();
// 296
    JP.go.ipa.oz.lib.standard._Collection_if rv = null;
// 298
    JP.go.ipa.oz.lib.standard._String_if getCID$val$375;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
      try {
        getCID$val$375 = part.getCID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getCID$val$375 = part.getCID ();
    }
// 298
    JP.go.ipa.oz.lang._Root_if get$val$376;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) superPartList)) {
      try {
        get$val$376 = superPartList.get (getCID$val$375);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$376 = superPartList.get (getCID$val$375);
    }
// 298
    rv = (JP.go.ipa.oz.lib.standard._Collection_if) (get$val$376);
// 299
    if (rv == null) {{
// 300
        rv = loadSuperCIsOf (part);
      }
    }
// 303
    return rv;
  }
  
  public JP.go.ipa.oz.lib.standard._Collection_if getSuperPartsOf (JP.go.ipa.oz.lib.standard._Collection_if parts) throws Exception  {
    checkSecureInvocation ();
// 278
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 279
    JP.go.ipa.oz.user.ide.CIPart_if part = null;
// 280
    JP.go.ipa.oz.lib.standard._Set_if rv = null, supers = null;
// 282
    rv = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create ();
// 283
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$377;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) parts)) {
      try {
        iterator$val$377 = parts.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$377 = parts.iterator ();
    }
// 283
    itr = iterator$val$377;
// 284
    while (true) {
// 284
      boolean hasMoreElements$val$378;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
        try {
          hasMoreElements$val$378 = itr.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$378 = itr.hasMoreElements ();
      }
      if (!(hasMoreElements$val$378)) break;
      
      /* body */ _loop_1: {
// 285
        JP.go.ipa.oz.lang._Root_if nextElement$val$379;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
          try {
            nextElement$val$379 = itr.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$379 = itr.nextElement ();
        }
// 285
        part = (JP.go.ipa.oz.user.ide.CIPart_if) (nextElement$val$379);
// 286
        rv = rv.union (getSuperPartsOf (part));
      }
    }
// 289
    return rv;
  }
  
  public JP.go.ipa.oz.lib.standard._Collection_if getSuperCIDsOf (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
    checkSecureInvocation ();
// 255
    JP.go.ipa.oz.lib.standard._Set_if cidList = null;
// 256
    JP.go.ipa.oz.lib.standard._StringComparator_if sc = null;
// 257
    JP.go.ipa.oz.lib.standard._Collection_if superPartList = null;
// 258
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 259
    JP.go.ipa.oz.user.ide.CIPart_if part = null;
// 261
    sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 262
    cidList = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (sc);
// 264
    part = loadCI (cid);
// 265
    superPartList = getSuperPartsOf (part);
// 266
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$380;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) superPartList)) {
      try {
        iterator$val$380 = superPartList.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$380 = superPartList.iterator ();
    }
// 266
    itr = iterator$val$380;
// 267
    while (true) {
// 267
      boolean hasMoreElements$val$381;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
        try {
          hasMoreElements$val$381 = itr.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$381 = itr.hasMoreElements ();
      }
      if (!(hasMoreElements$val$381)) break;
      
      /* body */ _loop_1: {
// 268
        JP.go.ipa.oz.lang._Root_if nextElement$val$382;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
          try {
            nextElement$val$382 = itr.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$382 = itr.nextElement ();
        }
// 268
        cidList.add (nextElement$val$382);
      }
    }
// 271
    return cidList;
  }
  
  public void refresh (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
    checkSecureInvocation ();
  }
  
  public void refresh () throws Exception  {
    checkSecureInvocation ();
  }
  
  JP.go.ipa.oz.lib.standard._Collection_if loadSuperCIsOf (JP.go.ipa.oz.user.ide.CIPart_if part) throws Exception  {
// 447
    JP.go.ipa.oz.lib.standard._SList_if rv = null;
// 448
    JP.go.ipa.oz.user.ide.CIImplementationPart_if implPart = null;
// 449
    JP.go.ipa.oz.user.ide.CIInterfacePart_if ifPart = null;
// 450
    JP.go.ipa.oz.lib.standard._String_if superCID = null;
// 451
    JP.go.ipa.oz.user.ide.CIPart_if superPart = null;
// 452
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 454
    JP.go.ipa.oz.lib.standard._String_if getCID$val$383;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
      try {
        getCID$val$383 = part.getCID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getCID$val$383 = part.getCID ();
    }
// 454
    JP.go.ipa.oz.lang._Root_if get$val$384;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) superPartList)) {
      try {
        get$val$384 = superPartList.get (getCID$val$383);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$384 = superPartList.get (getCID$val$383);
    }
// 454
    rv = (JP.go.ipa.oz.lib.standard._SList_if) (get$val$384);
// 455
    if (rv == null) {{
// 456
        rv = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create ();
// 457
        boolean isRoot$val$385;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
          try {
            isRoot$val$385 = part.isRoot ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isRoot$val$385 = part.isRoot ();
        }
// 457
        if (!(isRoot$val$385)) {{
// 458
            boolean isInterface$val$386;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
              try {
                isInterface$val$386 = part.isInterface ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              isInterface$val$386 = part.isInterface ();
            }
// 458
            if (isInterface$val$386) {{
// 459
                ifPart = (JP.go.ipa.oz.user.ide.CIInterfacePart_if) (part);
// 460
                JP.go.ipa.oz.lib.standard._Iterator_if superInterfaceCIDs$val$387;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ifPart)) {
                  try {
                    superInterfaceCIDs$val$387 = ifPart.superInterfaceCIDs ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  superInterfaceCIDs$val$387 = ifPart.superInterfaceCIDs ();
                }
// 460
                itr = superInterfaceCIDs$val$387;
// 461
                while (true) {
// 461
                  boolean hasMoreElements$val$388;
                  if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
                    try {
                      hasMoreElements$val$388 = itr.hasMoreElements ();
                    } finally {
                      changeRunningToGreen ();
                    }
                  } else {
                    hasMoreElements$val$388 = itr.hasMoreElements ();
                  }
                  if (!(hasMoreElements$val$388)) break;
                  
                  /* body */ _loop_1: {
// 462
                    JP.go.ipa.oz.lang._Root_if nextElement$val$389;
                    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
                      try {
                        nextElement$val$389 = itr.nextElement ();
                      } finally {
                        changeRunningToGreen ();
                      }
                    } else {
                      nextElement$val$389 = itr.nextElement ();
                    }
// 462
                    superCID = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$389);
// 463
                    superPart = loadCI (superCID);
// 464
                    rv.pushBack (superPart);
                  }
                }
              }
            } else {{
// 467
                implPart = (JP.go.ipa.oz.user.ide.CIImplementationPart_if) (part);
// 468
                JP.go.ipa.oz.lib.standard._String_if getSuperImplementationCID$val$390;
                if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implPart)) {
                  try {
                    getSuperImplementationCID$val$390 = implPart.getSuperImplementationCID ();
                  } finally {
                    changeRunningToGreen ();
                  }
                } else {
                  getSuperImplementationCID$val$390 = implPart.getSuperImplementationCID ();
                }
// 468
                superCID = getSuperImplementationCID$val$390;
// 469
                superPart = loadCI (superCID);
// 470
                rv.pushBack (superPart);
              }
            }
          }
        }
// 473
        JP.go.ipa.oz.lib.standard._String_if getCID$val$391;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
          try {
            getCID$val$391 = part.getCID ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getCID$val$391 = part.getCID ();
        }
// 473
        JP.go.ipa.oz.lib.standard._Dictionary_if put$val$392;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) superPartList)) {
          try {
            put$val$392 = superPartList.put (getCID$val$391, rv);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          put$val$392 = superPartList.put (getCID$val$391, rv);
        }
      }
    }
// 476
    return rv;
  }
  
  public JP.go.ipa.oz.user.ide.CIPart_if getPart (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
    checkSecureInvocation ();
// 184
    JP.go.ipa.oz.user.ide.CIPart_if part = null;
// 186
    part = loadCI (cid);
// 188
    return part;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if getLabelNameOf (JP.go.ipa.oz.user.ide.CIPart_if part) throws Exception  {
    checkSecureInvocation ();
// 159
    JP.go.ipa.oz.lib.standard._String_if name = null;
// 160
    JP.go.ipa.oz.lib.standard._String_if subjectName = null;
// 162
    if (school != null) {{
// 163
        boolean isInterface$val$393;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
          try {
            isInterface$val$393 = part.isInterface ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          isInterface$val$393 = part.isInterface ();
        }
// 163
        if (isInterface$val$393) {{
// 164
            JP.go.ipa.oz.lib.standard._String_if getCID$val$394;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
              try {
                getCID$val$394 = part.getCID ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getCID$val$394 = part.getCID ();
            }
// 164
            JP.go.ipa.oz.lib.standard._String_if getNameOfInterface$val$395;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
              try {
                getNameOfInterface$val$395 = school.getNameOfInterface (getCID$val$394);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getNameOfInterface$val$395 = school.getNameOfInterface (getCID$val$394);
            }
// 164
            name = getNameOfInterface$val$395;
          }
        } else {{
// 166
            JP.go.ipa.oz.lib.standard._String_if getCID$val$396;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
              try {
                getCID$val$396 = part.getCID ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getCID$val$396 = part.getCID ();
            }
// 166
            JP.go.ipa.oz.lib.standard._String_if getNameOfImplementation$val$397;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
              try {
                getNameOfImplementation$val$397 = school.getNameOfImplementation (getCID$val$396);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              getNameOfImplementation$val$397 = school.getNameOfImplementation (getCID$val$396);
            }
// 166
            name = getNameOfImplementation$val$397;
          }
        }
      }
    }
// 169
    if (name != null) {{
// 171
        JP.go.ipa.oz.user.ide.OzLabel_if getOzLabel$val$398;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) school)) {
          try {
            getOzLabel$val$398 = school.getOzLabel (name);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getOzLabel$val$398 = school.getOzLabel (name);
        }
// 171
        JP.go.ipa.oz.lib.standard._String_if getSubjectName$val$399;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) getOzLabel$val$398)) {
          try {
            getSubjectName$val$399 = getOzLabel$val$398.getSubjectName ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getSubjectName$val$399 = getOzLabel$val$398.getSubjectName ();
        }
// 171
        subjectName = getSubjectName$val$399;
      }
    } else {{
      }
    }
// 177
    return name;
  }
  
  public JP.go.ipa.oz.user.ide.School_if getSchool () throws Exception  {
    checkSecureInvocation ();
// 248
    return school;
  }
  
  public void show (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
    checkSecureInvocation ();
// 310
    JP.go.ipa.oz.user.ide.CIPart_if part = null;
// 311
    JP.go.ipa.oz.lib.standard._Collection_if ancestorParts = null;
// 315
    if (isOzInternalClass (cid)) {{
// 317
        return;
      }
    }
// 320
    part = loadCI (cid);
// 321
    ancestorParts = getAncestorPartsOf (part);
// 323
    if (ancestorParts == null) {{
      }
    }
// 327
    showPartView (part, ancestorParts);
  }
  
  boolean isRootCID (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
    boolean bool$val$12;
    
// 414
    boolean isequal$val$400;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
      try {
        isequal$val$400 = cid.isequal (ROOT_IF_CID);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isequal$val$400 = cid.isequal (ROOT_IF_CID);
    }
    bool$val$12 = isequal$val$400;
    if (!bool$val$12) {
// 414
      boolean isequal$val$401;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
        try {
          isequal$val$401 = cid.isequal (ROOT_CL_CID);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        isequal$val$401 = cid.isequal (ROOT_CL_CID);
      }
      bool$val$12 = isequal$val$401;
    }
// 414
    if (bool$val$12) {{
// 415
        return true;
      }
    } else {{
// 417
        return false;
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Collection_if getReferingCIDsOf (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
    checkSecureInvocation ();
// 199
    JP.go.ipa.oz.lib.standard._Set_if cidList = null;
// 200
    JP.go.ipa.oz.lib.standard._StringComparator_if sc = null;
// 201
    JP.go.ipa.oz.lib.standard._String_if refCID = null;
// 202
    JP.go.ipa.oz.user.ide.CIPart_if part = null;
// 203
    JP.go.ipa.oz.user.ide.CIMethodImplementation_if methodImpl = null;
// 204
    JP.go.ipa.oz.user.ide.CIImplementationPart_if implPart = null;
// 205
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null, cidItr = null;
// 209
    part = loadCI (cid);
// 210
    boolean isInterface$val$402;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
      try {
        isInterface$val$402 = part.isInterface ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isInterface$val$402 = part.isInterface ();
    }
// 210
    if (isInterface$val$402) {{
// 211
        JP.go.ipa.oz.user.ide.CIException_if ex = null;
// 212
        ex = (JP.go.ipa.oz.user.ide.CIException_cl) (new JP.go.ipa.oz.user.ide.CIException_cl ())._new_newCIException ((new JP.go.ipa.oz.lib.standard._String_cl("class ID not for implementation part")), cid);
// 213
        throw new JP.go.ipa.oz.lang.OzException (ex);
      }
    }
// 215
    implPart = (JP.go.ipa.oz.user.ide.CIImplementationPart_if) (part);
// 216
    sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 217
    cidList = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (sc);
// 220
    JP.go.ipa.oz.lib.standard._Iterator_if methods$val$403;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implPart)) {
      try {
        methods$val$403 = implPart.methods ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      methods$val$403 = implPart.methods ();
    }
// 220
    itr = methods$val$403;
// 221
    while (true) {
// 221
      boolean hasMoreElements$val$404;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
        try {
          hasMoreElements$val$404 = itr.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$404 = itr.hasMoreElements ();
      }
      if (!(hasMoreElements$val$404)) break;
      
      /* body */ _loop_1: {
// 222
        JP.go.ipa.oz.lang._Root_if nextElement$val$405;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
          try {
            nextElement$val$405 = itr.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$405 = itr.nextElement ();
        }
// 222
        methodImpl = (JP.go.ipa.oz.user.ide.CIMethodImplementation_if) (nextElement$val$405);
// 223
        JP.go.ipa.oz.lib.standard._Iterator_if referingCIDs$val$406;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) methodImpl)) {
          try {
            referingCIDs$val$406 = methodImpl.referingCIDs ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          referingCIDs$val$406 = methodImpl.referingCIDs ();
        }
// 223
        cidItr = referingCIDs$val$406;
// 224
        while (true) {
// 224
          boolean hasMoreElements$val$407;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cidItr)) {
            try {
              hasMoreElements$val$407 = cidItr.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$407 = cidItr.hasMoreElements ();
          }
          if (!(hasMoreElements$val$407)) break;
          
          /* body */ _loop_2: {
// 225
            JP.go.ipa.oz.lang._Root_if nextElement$val$408;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cidItr)) {
              try {
                nextElement$val$408 = cidItr.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$408 = cidItr.nextElement ();
            }
// 225
            refCID = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$408);
// 226
            cidList.add (refCID);
          }
        }
      }
    }
// 231
    JP.go.ipa.oz.lib.standard._Iterator_if constructors$val$409;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implPart)) {
      try {
        constructors$val$409 = implPart.constructors ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      constructors$val$409 = implPart.constructors ();
    }
// 231
    itr = constructors$val$409;
// 232
    while (true) {
// 232
      boolean hasMoreElements$val$410;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
        try {
          hasMoreElements$val$410 = itr.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$410 = itr.hasMoreElements ();
      }
      if (!(hasMoreElements$val$410)) break;
      
      /* body */ _loop_1: {
// 233
        JP.go.ipa.oz.lang._Root_if nextElement$val$411;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
          try {
            nextElement$val$411 = itr.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$411 = itr.nextElement ();
        }
// 233
        methodImpl = (JP.go.ipa.oz.user.ide.CIMethodImplementation_if) (nextElement$val$411);
// 234
        JP.go.ipa.oz.lib.standard._Iterator_if referingCIDs$val$412;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) methodImpl)) {
          try {
            referingCIDs$val$412 = methodImpl.referingCIDs ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          referingCIDs$val$412 = methodImpl.referingCIDs ();
        }
// 234
        cidItr = referingCIDs$val$412;
// 235
        while (true) {
// 235
          boolean hasMoreElements$val$413;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cidItr)) {
            try {
              hasMoreElements$val$413 = cidItr.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$413 = cidItr.hasMoreElements ();
          }
          if (!(hasMoreElements$val$413)) break;
          
          /* body */ _loop_2: {
// 236
            JP.go.ipa.oz.lang._Root_if nextElement$val$414;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cidItr)) {
              try {
                nextElement$val$414 = cidItr.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$414 = cidItr.nextElement ();
            }
// 236
            refCID = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$414);
// 237
            cidList.add (refCID);
          }
        }
      }
    }
// 241
    return cidList;
  }
  
  void disposePartView (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
// 366
    JP.go.ipa.oz.user.ide.CBPartView_if pv = null;
// 368
    JP.go.ipa.oz.lang._Root_if get$val$415;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) partViewList)) {
      try {
        get$val$415 = partViewList.get (cid);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$415 = partViewList.get (cid);
    }
// 368
    pv = (JP.go.ipa.oz.user.ide.CBPartView_if) (get$val$415);
// 369
    if (pv != null) {{
// 370
        JP.go.ipa.oz.lib.standard._Dictionary_if remove$val$416;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) partViewList)) {
          try {
            remove$val$416 = partViewList.remove (cid);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          remove$val$416 = partViewList.remove (cid);
        }
// 371
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) pv)) {
          try {
            pv.dispose ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          pv.dispose ();
        }
      }
    }
  }
  
  void showPartView (JP.go.ipa.oz.user.ide.CIPart_if part, JP.go.ipa.oz.lib.standard._Collection_if ancestorParts) throws Exception  {
// 483
    JP.go.ipa.oz.user.ide.CBPartView_if pv = null;
// 484
    JP.go.ipa.oz.lib.standard._String_if cid = null;
// 486
    JP.go.ipa.oz.lib.standard._String_if getCID$val$417;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
      try {
        getCID$val$417 = part.getCID ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getCID$val$417 = part.getCID ();
    }
// 486
    cid = getCID$val$417;
// 488
    JP.go.ipa.oz.lang._Root_if get$val$418;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) partViewList)) {
      try {
        get$val$418 = partViewList.get (cid);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      get$val$418 = partViewList.get (cid);
    }
// 488
    pv = (JP.go.ipa.oz.user.ide.CBPartView_if) (get$val$418);
// 489
    if (pv == null) {{
// 490
        pv = (JP.go.ipa.oz.user.ide.CBPartView_cl) (new JP.go.ipa.oz.user.ide.CBPartView_cl ())._new_newCBPartView (part, ancestorParts, this);
// 491
        JP.go.ipa.oz.lib.standard._String_if getCID$val$419;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
          try {
            getCID$val$419 = part.getCID ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getCID$val$419 = part.getCID ();
        }
// 491
        JP.go.ipa.oz.lib.standard._Dictionary_if put$val$420;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) partViewList)) {
          try {
            put$val$420 = partViewList.put (getCID$val$419, pv);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          put$val$420 = partViewList.put (getCID$val$419, pv);
        }
// 492
        pv.toFront ();
      }
    } else {{
// 494
        pv.setVisible (true);
// 495
        pv.toFront ();
      }
    }
  }
  
  public JP.go.ipa.oz.lib.standard._Collection_if getAncestorPartsOf (JP.go.ipa.oz.user.ide.CIPart_if part) throws Exception  {
    checkSecureInvocation ();
// 86
    JP.go.ipa.oz.lib.standard._Set_if rv = null;
// 87
    JP.go.ipa.oz.lib.standard._Array_if seedList = null;
// 88
    JP.go.ipa.oz.lib.standard._Collection_if basePartList = null, superPartList = null;
// 90
    rv = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create ();
// 91
    seedList = (JP.go.ipa.oz.lib.standard._Array_cl) (new JP.go.ipa.oz.lib.standard._Array_cl ())._new_create (1);
// 92
    seedList.putAt (0, part);
// 93
    basePartList = seedList;
// 94
    while (true) {
      if (!(!(basePartList.isEmpty ()))) break;
      
      /* body */ _loop_1: {
// 95
        superPartList = getSuperPartsOf (basePartList);
// 96
        rv = rv.union (superPartList);
// 97
        basePartList = superPartList;
      }
    }
// 100
    return rv;
  }
  
  public void disposeAll () throws Exception  {
    checkSecureInvocation ();
// 47
    JP.go.ipa.oz.lib.standard._String_if cid = null;
// 48
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 51
    JP.go.ipa.oz.lib.standard._Iterator_if keyIterator$val$421;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) partViewList)) {
      try {
        keyIterator$val$421 = partViewList.keyIterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      keyIterator$val$421 = partViewList.keyIterator ();
    }
// 51
    itr = keyIterator$val$421;
// 52
    while (true) {
// 52
      boolean hasMoreElements$val$422;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
        try {
          hasMoreElements$val$422 = itr.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$422 = itr.hasMoreElements ();
      }
      if (!(hasMoreElements$val$422)) break;
      
      /* body */ _loop_1: {
// 53
        JP.go.ipa.oz.lang._Root_if nextElement$val$423;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
          try {
            nextElement$val$423 = itr.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$423 = itr.nextElement ();
        }
// 53
        cid = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$423);
// 54
        dispose (cid);
      }
    }
  }
  
  boolean isOzInternalClass (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
    boolean bool$val$13;
    
// 401
    JP.go.ipa.oz.lib.standard._String_if string$57 = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.system."));
    
// 401
    boolean startsWith$val$424;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
      try {
        startsWith$val$424 = cid.startsWith (string$57);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$424 = cid.startsWith (string$57);
    }
    bool$val$13 = startsWith$val$424;
    if (!bool$val$13) {
// 402
      JP.go.ipa.oz.lib.standard._String_if string$58 = (new JP.go.ipa.oz.lib.standard._String_cl("java."));
      
// 402
      boolean startsWith$val$425;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
        try {
          startsWith$val$425 = cid.startsWith (string$58);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        startsWith$val$425 = cid.startsWith (string$58);
      }
      bool$val$13 = startsWith$val$425;
    }
// 401
    if (bool$val$13) {{
// 404
        return true;
      }
    }
// 407
    return false;
  }
  
  public void dispose (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
    checkSecureInvocation ();
// 40
    disposePartView (cid);
  }
  
  JP.go.ipa.oz.user.ide.CIPart_if loadCI (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
    enter ();
    try {
// 425
      JP.go.ipa.oz.user.ide.CIPart_if part = null;
// 426
      JP.go.ipa.oz.user.ide.OzLabel_if label = null;
// 430
      JP.go.ipa.oz.lang._Root_if get$val$426;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) partList)) {
        try {
          get$val$426 = partList.get (cid);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        get$val$426 = partList.get (cid);
      }
// 430
      part = (JP.go.ipa.oz.user.ide.CIPart_if) (get$val$426);
// 431
      if (part == null) {{
// 433
          JP.go.ipa.oz.user.ide.CIPart_if load$val$427;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ciLoader)) {
            try {
              load$val$427 = ciLoader.load (cid);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            load$val$427 = ciLoader.load (cid);
          }
// 433
          part = load$val$427;
// 434
          JP.go.ipa.oz.lib.standard._String_if getLabelNameOf$val$428;
          getLabelNameOf$val$428 = getLabelNameOf (part);
// 434
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
            try {
              part.setLabelName (getLabelNameOf$val$428);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            part.setLabelName (getLabelNameOf$val$428);
          }
// 435
          JP.go.ipa.oz.lib.standard._Dictionary_if put$val$429;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) partList)) {
            try {
              put$val$429 = partList.put (cid, part);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            put$val$429 = partList.put (cid, part);
          }
        }
      }
// 440
      return part;
    } finally {
      leave ();
    }
  }
  
  public void disposeHierarchy () throws Exception  {
    checkSecureInvocation ();
  }
  
  void initParams (JP.go.ipa.oz.user.ide.School_if sc) throws Exception  {
// 382
    JP.go.ipa.oz.lib.standard._StringComparator_if strComp = null;
// 384
    ((JP.go.ipa.oz.user.ide.ClassBrowser_cl)this).school = sc;
// 385
    strComp = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 386
    partList = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (strComp);
// 387
    partViewList = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (strComp);
// 388
    superPartList = (JP.go.ipa.oz.lib.standard._Dictionary_cl) (new JP.go.ipa.oz.lib.standard._Dictionary_cl ())._new_create (strComp);
// 389
    ((JP.go.ipa.oz.user.ide.ClassBrowser_cl)this).ciLoader = (JP.go.ipa.oz.user.ide.CILoader_cl) (new JP.go.ipa.oz.user.ide.CILoader_cl ())._new_newCILoader ();
// 391
    ROOT_IF_CID = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.lang._Root_if"));
// 392
    ROOT_CL_CID = (new JP.go.ipa.oz.lib.standard._String_cl("JP.go.ipa.oz.lang._Root_cl"));
// 394
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
  }
  
  public JP.go.ipa.oz.lib.standard._Collection_if getInstantiatingCIDsOf (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
    checkSecureInvocation ();
// 111
    JP.go.ipa.oz.lib.standard._Set_if cidList = null;
// 112
    JP.go.ipa.oz.lib.standard._StringComparator_if sc = null;
// 113
    JP.go.ipa.oz.lib.standard._String_if instCID = null;
// 114
    JP.go.ipa.oz.user.ide.CIPart_if part = null;
// 115
    JP.go.ipa.oz.user.ide.CIMethodImplementation_if methodImpl = null;
// 116
    JP.go.ipa.oz.user.ide.CIImplementationPart_if implPart = null;
// 117
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null, cidItr = null;
// 119
    part = loadCI (cid);
// 120
    boolean isInterface$val$430;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
      try {
        isInterface$val$430 = part.isInterface ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isInterface$val$430 = part.isInterface ();
    }
// 120
    if (isInterface$val$430) {{
// 121
        JP.go.ipa.oz.user.ide.CIException_if ex = null;
// 122
        ex = (JP.go.ipa.oz.user.ide.CIException_cl) (new JP.go.ipa.oz.user.ide.CIException_cl ())._new_newCIException ((new JP.go.ipa.oz.lib.standard._String_cl("class ID not for implementation part")), cid);
// 123
        throw new JP.go.ipa.oz.lang.OzException (ex);
      }
    }
// 126
    implPart = (JP.go.ipa.oz.user.ide.CIImplementationPart_if) (part);
// 127
    sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 128
    cidList = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (sc);
// 131
    JP.go.ipa.oz.lib.standard._Iterator_if methods$val$431;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implPart)) {
      try {
        methods$val$431 = implPart.methods ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      methods$val$431 = implPart.methods ();
    }
// 131
    itr = methods$val$431;
// 132
    while (true) {
// 132
      boolean hasMoreElements$val$432;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
        try {
          hasMoreElements$val$432 = itr.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$432 = itr.hasMoreElements ();
      }
      if (!(hasMoreElements$val$432)) break;
      
      /* body */ _loop_1: {
// 133
        JP.go.ipa.oz.lang._Root_if nextElement$val$433;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
          try {
            nextElement$val$433 = itr.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$433 = itr.nextElement ();
        }
// 133
        methodImpl = (JP.go.ipa.oz.user.ide.CIMethodImplementation_if) (nextElement$val$433);
// 134
        JP.go.ipa.oz.lib.standard._Iterator_if instantiatingCIDs$val$434;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) methodImpl)) {
          try {
            instantiatingCIDs$val$434 = methodImpl.instantiatingCIDs ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          instantiatingCIDs$val$434 = methodImpl.instantiatingCIDs ();
        }
// 134
        cidItr = instantiatingCIDs$val$434;
// 135
        while (true) {
// 135
          boolean hasMoreElements$val$435;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cidItr)) {
            try {
              hasMoreElements$val$435 = cidItr.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$435 = cidItr.hasMoreElements ();
          }
          if (!(hasMoreElements$val$435)) break;
          
          /* body */ _loop_2: {
// 136
            JP.go.ipa.oz.lang._Root_if nextElement$val$436;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cidItr)) {
              try {
                nextElement$val$436 = cidItr.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$436 = cidItr.nextElement ();
            }
// 136
            instCID = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$436);
// 137
            cidList.add (instCID);
          }
        }
      }
    }
// 142
    JP.go.ipa.oz.lib.standard._Iterator_if constructors$val$437;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) implPart)) {
      try {
        constructors$val$437 = implPart.constructors ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      constructors$val$437 = implPart.constructors ();
    }
// 142
    itr = constructors$val$437;
// 143
    while (true) {
// 143
      boolean hasMoreElements$val$438;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
        try {
          hasMoreElements$val$438 = itr.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$438 = itr.hasMoreElements ();
      }
      if (!(hasMoreElements$val$438)) break;
      
      /* body */ _loop_1: {
// 144
        JP.go.ipa.oz.lang._Root_if nextElement$val$439;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
          try {
            nextElement$val$439 = itr.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$439 = itr.nextElement ();
        }
// 144
        methodImpl = (JP.go.ipa.oz.user.ide.CIMethodImplementation_if) (nextElement$val$439);
// 145
        JP.go.ipa.oz.lib.standard._Iterator_if instantiatingCIDs$val$440;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) methodImpl)) {
          try {
            instantiatingCIDs$val$440 = methodImpl.instantiatingCIDs ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          instantiatingCIDs$val$440 = methodImpl.instantiatingCIDs ();
        }
// 145
        cidItr = instantiatingCIDs$val$440;
// 146
        while (true) {
// 146
          boolean hasMoreElements$val$441;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cidItr)) {
            try {
              hasMoreElements$val$441 = cidItr.hasMoreElements ();
            } finally {
              changeRunningToGreen ();
            }
          } else {
            hasMoreElements$val$441 = cidItr.hasMoreElements ();
          }
          if (!(hasMoreElements$val$441)) break;
          
          /* body */ _loop_2: {
// 147
            JP.go.ipa.oz.lang._Root_if nextElement$val$442;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cidItr)) {
              try {
                nextElement$val$442 = cidItr.nextElement ();
              } finally {
                changeRunningToGreen ();
              }
            } else {
              nextElement$val$442 = cidItr.nextElement ();
            }
// 147
            instCID = (JP.go.ipa.oz.lib.standard._String_if) (nextElement$val$442);
// 148
            cidList.add (instCID);
          }
        }
      }
    }
// 152
    return cidList;
  }
  
  public JP.go.ipa.oz.lib.standard._Collection_if getAncestorCIDsOf (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
    checkSecureInvocation ();
// 62
    JP.go.ipa.oz.lib.standard._Set_if cidList = null;
// 63
    JP.go.ipa.oz.lib.standard._StringComparator_if sc = null;
// 64
    JP.go.ipa.oz.lib.standard._Collection_if parts = null;
// 65
    JP.go.ipa.oz.lib.standard._Iterator_if itr = null;
// 66
    JP.go.ipa.oz.user.ide.CIPart_if part = null;
// 68
    part = loadCI (cid);
// 69
    parts = getAncestorPartsOf (part);
// 71
    sc = (JP.go.ipa.oz.lib.standard._StringComparator_cl) (new JP.go.ipa.oz.lib.standard._StringComparator_cl ())._new_create ();
// 72
    cidList = (JP.go.ipa.oz.lib.standard._Set_cl) (new JP.go.ipa.oz.lib.standard._Set_cl ())._new_create (sc);
// 73
    JP.go.ipa.oz.lib.standard._Iterator_if iterator$val$443;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) parts)) {
      try {
        iterator$val$443 = parts.iterator ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      iterator$val$443 = parts.iterator ();
    }
// 73
    itr = iterator$val$443;
// 74
    while (true) {
// 74
      boolean hasMoreElements$val$444;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
        try {
          hasMoreElements$val$444 = itr.hasMoreElements ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        hasMoreElements$val$444 = itr.hasMoreElements ();
      }
      if (!(hasMoreElements$val$444)) break;
      
      /* body */ _loop_1: {
// 75
        JP.go.ipa.oz.lang._Root_if nextElement$val$445;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) itr)) {
          try {
            nextElement$val$445 = itr.nextElement ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          nextElement$val$445 = itr.nextElement ();
        }
// 75
        part = (JP.go.ipa.oz.user.ide.CIPart_if) (nextElement$val$445);
// 76
        JP.go.ipa.oz.lib.standard._String_if getCID$val$446;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
          try {
            getCID$val$446 = part.getCID ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getCID$val$446 = part.getCID ();
        }
// 76
        cidList.add (getCID$val$446);
      }
    }
// 79
    return cidList;
  }
  
  public void refreshHierarchy () throws Exception  {
    checkSecureInvocation ();
  }
  
  public void showHierarchy () throws Exception  {
    checkSecureInvocation ();
  }
  
  public ClassBrowser_cl () throws Exception { super (); }
  
}


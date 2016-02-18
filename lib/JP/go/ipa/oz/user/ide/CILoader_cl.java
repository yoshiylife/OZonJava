package JP.go.ipa.oz.user.ide;

final public class CILoader_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.ide.CILoader_if {
  static final boolean _final_ = true;
  char IMPL_TYPE_CODE;
  JP.go.ipa.oz.lib.standard._String_if codeFileExtension;
  char fileSeparatorChar;
  char ATTRIBUTE_TYPE_CODE;
  JP.go.ipa.oz.lib.standard._String_if ciPathPrefix;
  JP.go.ipa.oz.lib.standard._System_if system;
  char CONSTRUCTOR_TYPE_CODE;
  JP.go.ipa.oz.lib.standard._String_if fileSeparator;
  char METHOD_TYPE_CODE;
  JP.go.ipa.oz.lib.standard._String_if ciFileExtension;
  char IF_TYPE_CODE;
  
  public Object _new_newCILoader () throws Exception  {
// 35
    system = (JP.go.ipa.oz.lib.standard._System_cl) (new JP.go.ipa.oz.lib.standard._System_cl ())._new_create ();
// 37
    initParams ();
    return this;
  }
  
  JP.go.ipa.oz.lib.standard._BufferedReader_if mkCIFileReader (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
// 120
    JP.go.ipa.oz.lib.standard._ClassProperty_if prop = null;
// 121
    JP.go.ipa.oz.lib.standard._InputStream_if is = null;
// 122
    JP.go.ipa.oz.lib.standard._InputStreamReader_if isReader = null;
// 123
    JP.go.ipa.oz.lib.standard._BufferedReader_if reader = null;
// 124
    JP.go.ipa.oz.lib.standard._String_if ciFileName = null;
// 125
    JP.go.ipa.oz.user.ide.CIException_if ciExp = null;
// 127
    ciFileName = cid2CIFileName (cid, ciFileExtension);
// 128
    if (ciFileName != null) {{
// 129
        JP.go.ipa.oz.lib.standard._String_if string$12 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCILoader#mkCIFileReader: ciFileName="));
        
// 129
        JP.go.ipa.oz.lib.standard._String_if concat$val$117;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$12)) {
          try {
            concat$val$117 = string$12.concat (ciFileName);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$117 = string$12.concat (ciFileName);
        }
// 129
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (concat$val$117);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (concat$val$117);
        }
      }
    }
// 131
    try {
// 132
      prop = (JP.go.ipa.oz.lib.standard._ClassProperty_cl) (new JP.go.ipa.oz.lib.standard._ClassProperty_cl ())._new_create (cid, ciFileName);
// 133
      is = prop.getInputStream ();
// 134
      isReader = (JP.go.ipa.oz.lib.standard._InputStreamReader_cl) (new JP.go.ipa.oz.lib.standard._InputStreamReader_cl ())._new_breed (is);
// 135
      reader = (JP.go.ipa.oz.lib.standard._BufferedReader_cl) (new JP.go.ipa.oz.lib.standard._BufferedReader_cl ())._new_breed (isReader);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_1) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_1 = _exception_1.getOzException ();
      if (_oz_exception_1 instanceof JP.go.ipa.oz.lib.standard._FileNotFoundException_if) {
        JP.go.ipa.oz.lib.standard._FileNotFoundException_if ex = (JP.go.ipa.oz.lib.standard._FileNotFoundException_if) _oz_exception_1;
// 137
        ciExp = (JP.go.ipa.oz.user.ide.CIException_cl) (new JP.go.ipa.oz.user.ide.CIException_cl ())._new_newCIException ((new JP.go.ipa.oz.lib.standard._String_cl("CI file not found")), cid);
// 138
        throw new JP.go.ipa.oz.lang.OzException (ciExp);
      } else if (_oz_exception_1 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
        JP.go.ipa.oz.lib.standard._IOException_if ex = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_1;
// 140
        ciExp = (JP.go.ipa.oz.user.ide.CIException_cl) (new JP.go.ipa.oz.user.ide.CIException_cl ())._new_newCIException ((new JP.go.ipa.oz.lib.standard._String_cl("CI file not ready to read")), cid);
// 141
        throw new JP.go.ipa.oz.lang.OzException (ciExp);
      } else throw _exception_1;
    }
// 144
    return reader;
  }
  
  void parseConstructorRecord (JP.go.ipa.oz.user.ide.CIPart_if part, JP.go.ipa.oz.lib.standard._String_if record, JP.go.ipa.oz.lib.standard._StringBuffer_if codeBuffer) throws Exception  {
// 388
    JP.go.ipa.oz.user.ide.CIRecordTokenizer_if rt = null, lt = null;
// 389
    JP.go.ipa.oz.lib.standard._String_if recType = null;
// 390
    JP.go.ipa.oz.lib.standard._String_if name = null;
// 391
    JP.go.ipa.oz.lib.standard._String_if strArgTypes = null;
// 392
    JP.go.ipa.oz.lib.standard._String_if strRefCIDs = null;
// 393
    JP.go.ipa.oz.lib.standard._String_if strInstCIDs = null;
// 394
    JP.go.ipa.oz.lib.standard._String_if strCodeInfo = null;
// 395
    JP.go.ipa.oz.lib.standard._SList_if argTypeList = null;
// 396
    JP.go.ipa.oz.lib.standard._SList_if refCIDList = null;
// 397
    JP.go.ipa.oz.lib.standard._SList_if instCIDList = null;
// 398
    JP.go.ipa.oz.lib.standard._String_if code = null;
// 399
    JP.go.ipa.oz.user.ide.CIMethodImplementation_if cnst = null;
// 401
    rt = (JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl) (new JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl ())._new_newCIRecordTokenizer (record);
// 402
    recType = rt.nextToken ();
// 403
    name = rt.nextToken ();
// 404
    strArgTypes = rt.nextList ();
// 405
    strRefCIDs = rt.nextList ();
// 406
    strInstCIDs = rt.nextList ();
// 407
    strCodeInfo = rt.nextList ();
// 410
    lt = (JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl) (new JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl ())._new_newCIRecordTokenizer (strArgTypes);
// 411
    argTypeList = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create ();
// 412
    while (true) {
      if (!(lt.hasMoreTokens ())) break;
      
      /* body */ _loop_1: {
// 413
        argTypeList.pushBack (parseType (lt.nextToken ()));
      }
    }
// 417
    lt = (JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl) (new JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl ())._new_newCIRecordTokenizer (strRefCIDs);
// 418
    refCIDList = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create ();
// 419
    while (true) {
      if (!(lt.hasMoreTokens ())) break;
      
      /* body */ _loop_1: {
// 420
        refCIDList.pushBack (lt.nextToken ());
      }
    }
// 424
    lt = (JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl) (new JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl ())._new_newCIRecordTokenizer (strInstCIDs);
// 425
    instCIDList = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create ();
// 426
    while (true) {
      if (!(lt.hasMoreTokens ())) break;
      
      /* body */ _loop_1: {
// 427
        instCIDList.pushBack (lt.nextToken ());
      }
    }
// 431
    if (codeBuffer != null) {{
// 432
        code = parseCodeInfo (codeBuffer, strCodeInfo);
      }
    } else {{
// 434
        code = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("code not available")));
      }
    }
// 437
    cnst = (JP.go.ipa.oz.user.ide.CIMethodImplementation_cl) (new JP.go.ipa.oz.user.ide.CIMethodImplementation_cl ())._new_newCIConstructorImplementation (name, argTypeList, refCIDList, instCIDList, code, part);
// 440
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
      try {
        part.addMember (cnst);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      part.addMember (cnst);
    }
  }
  
  JP.go.ipa.oz.user.ide.CIImplementationPart_if parseImplRecord (JP.go.ipa.oz.lib.standard._String_if record) throws Exception  {
// 355
    JP.go.ipa.oz.user.ide.CIRecordTokenizer_if rt = null;
// 356
    JP.go.ipa.oz.lib.standard._String_if rec_type = null;
// 357
    JP.go.ipa.oz.lib.standard._String_if cid = null;
// 358
    JP.go.ipa.oz.lib.standard._String_if strPrefix = null;
// 359
    JP.go.ipa.oz.lib.standard._String_if ifCID = null;
// 360
    JP.go.ipa.oz.lib.standard._String_if superImplCID = null;
// 361
    int intPrefix = 0;
// 362
    JP.go.ipa.oz.user.ide.CIAccessLevel_if accessLevel = null;
// 363
    JP.go.ipa.oz.user.ide.CIModifier_if modifier = null;
// 364
    JP.go.ipa.oz.user.ide.CIImplementationPart_if implPart = null;
// 366
    rt = (JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl) (new JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl ())._new_newCIRecordTokenizer (record);
// 367
    rec_type = rt.nextToken ();
// 368
    cid = rt.nextToken ();
// 369
    strPrefix = rt.nextToken ();
// 370
    ifCID = rt.nextToken ();
// 371
    superImplCID = rt.nextToken ();
// 373
    intPrefix = parseInteger (strPrefix);
// 374
    accessLevel = (JP.go.ipa.oz.user.ide.CIAccessLevel_cl) (new JP.go.ipa.oz.user.ide.CIAccessLevel_cl ())._new_newCIAccessLevel (intPrefix);
// 375
    modifier = (JP.go.ipa.oz.user.ide.CIModifier_cl) (new JP.go.ipa.oz.user.ide.CIModifier_cl ())._new_newCIModifier (intPrefix);
// 377
    implPart = (JP.go.ipa.oz.user.ide.CIImplementationPart_cl) (new JP.go.ipa.oz.user.ide.CIImplementationPart_cl ())._new_newCIImplementationPart (cid, accessLevel, modifier, ifCID, superImplCID);
// 380
    return implPart;
  }
  
  JP.go.ipa.oz.user.ide.CIModifier_if parseModifier (JP.go.ipa.oz.lib.standard._String_if str) throws Exception  {
// 536
    int val = 0;
// 537
    JP.go.ipa.oz.user.ide.CIModifier_if mods = null;
// 539
    val = parseInteger (str);
// 540
    mods = (JP.go.ipa.oz.user.ide.CIModifier_cl) (new JP.go.ipa.oz.user.ide.CIModifier_cl ())._new_newCIModifier (val);
// 542
    return mods;
  }
  
  void parseMethodRecord (JP.go.ipa.oz.user.ide.CIPart_if part, JP.go.ipa.oz.lib.standard._String_if record, JP.go.ipa.oz.lib.standard._StringBuffer_if codeBuffer) throws Exception  {
// 448
    JP.go.ipa.oz.user.ide.CIRecordTokenizer_if rt = null, lt = null;
// 449
    JP.go.ipa.oz.lib.standard._String_if recType = null;
// 450
    JP.go.ipa.oz.lib.standard._String_if name = null;
// 451
    JP.go.ipa.oz.lib.standard._String_if strPrefix = null;
// 452
    JP.go.ipa.oz.lib.standard._String_if strReturnType = null;
// 453
    JP.go.ipa.oz.lib.standard._String_if strArgTypeList = null;
// 454
    JP.go.ipa.oz.lib.standard._String_if strRefCIDList = null;
// 455
    JP.go.ipa.oz.lib.standard._String_if strInstCIDList = null;
// 456
    int intPrefix = 0;
// 457
    JP.go.ipa.oz.user.ide.CIAccessLevel_if accessLevel = null;
// 458
    JP.go.ipa.oz.user.ide.CIModifier_if modifier = null;
// 459
    JP.go.ipa.oz.user.ide.CIType_if returnType = null;
// 460
    JP.go.ipa.oz.lib.standard._SList_if argTypeList = null;
// 461
    JP.go.ipa.oz.lib.standard._SList_if refCIDList = null;
// 462
    JP.go.ipa.oz.lib.standard._SList_if instCIDList = null;
// 463
    JP.go.ipa.oz.lib.standard._String_if strCodeInfo = null;
// 464
    int i = 0;
// 466
    rt = (JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl) (new JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl ())._new_newCIRecordTokenizer (record);
// 467
    recType = rt.nextToken ();
// 468
    name = rt.nextToken ();
// 469
    strPrefix = rt.nextToken ();
// 470
    strReturnType = rt.nextToken ();
// 471
    strArgTypeList = rt.nextList ();
// 473
    intPrefix = parseInteger (strPrefix);
// 474
    accessLevel = (JP.go.ipa.oz.user.ide.CIAccessLevel_cl) (new JP.go.ipa.oz.user.ide.CIAccessLevel_cl ())._new_newCIAccessLevel (intPrefix);
// 475
    modifier = (JP.go.ipa.oz.user.ide.CIModifier_cl) (new JP.go.ipa.oz.user.ide.CIModifier_cl ())._new_newCIModifier (intPrefix);
// 476
    returnType = parseType (strReturnType);
// 479
    lt = (JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl) (new JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl ())._new_newCIRecordTokenizer (strArgTypeList);
// 480
    argTypeList = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create ();
// 481
    while (true) {
      if (!(lt.hasMoreTokens ())) break;
      
      /* body */ _loop_1: {
// 482
        argTypeList.pushBack (parseType (lt.nextToken ()));
      }
    }
// 485
    if (rt.hasMoreTokens ()) {{
// 487
        JP.go.ipa.oz.user.ide.CIMethodImplementation_if methodImpl = null;
// 488
        JP.go.ipa.oz.lib.standard._String_if code = null;
// 490
        strRefCIDList = rt.nextList ();
// 491
        strInstCIDList = rt.nextList ();
// 492
        strCodeInfo = rt.nextList ();
// 495
        lt = (JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl) (new JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl ())._new_newCIRecordTokenizer (strRefCIDList);
// 496
        refCIDList = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create ();
// 497
        while (true) {
          if (!(lt.hasMoreTokens ())) break;
          
          /* body */ _loop_1: {
// 498
            refCIDList.pushBack (lt.nextToken ());
          }
        }
// 502
        lt = (JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl) (new JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl ())._new_newCIRecordTokenizer (strInstCIDList);
// 503
        instCIDList = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create ();
// 504
        while (true) {
          if (!(lt.hasMoreTokens ())) break;
          
          /* body */ _loop_1: {
// 505
            instCIDList.pushBack (lt.nextToken ());
          }
        }
// 509
        if (codeBuffer != null) {{
// 510
            code = parseCodeInfo (codeBuffer, strCodeInfo);
          }
        } else {{
// 512
            code = (JP.go.ipa.oz.lib.standard._String_cl) (new JP.go.ipa.oz.lib.standard._String_cl ())._new_breed ((new JP.go.ipa.oz.lib.standard._String_cl("code not available")));
          }
        }
// 515
        methodImpl = (JP.go.ipa.oz.user.ide.CIMethodImplementation_cl) (new JP.go.ipa.oz.user.ide.CIMethodImplementation_cl ())._new_newCIMethodImplementation (accessLevel, modifier, returnType, name, argTypeList, refCIDList, instCIDList, code, part);
// 520
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
          try {
            part.addMember (methodImpl);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          part.addMember (methodImpl);
        }
      }
    } else {{
// 524
        JP.go.ipa.oz.user.ide.CIMethod_if methodIf = null;
// 526
        methodIf = (JP.go.ipa.oz.user.ide.CIMethod_cl) (new JP.go.ipa.oz.user.ide.CIMethod_cl ())._new_newCIMethod (accessLevel, modifier, returnType, name, argTypeList, part);
// 528
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
          try {
            part.addMember (methodIf);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          part.addMember (methodIf);
        }
      }
    }
  }
  
  void parseAttributeRecord (JP.go.ipa.oz.user.ide.CIPart_if part, JP.go.ipa.oz.lib.standard._String_if record) throws Exception  {
// 191
    JP.go.ipa.oz.user.ide.CIRecordTokenizer_if rt = null;
// 192
    JP.go.ipa.oz.lib.standard._String_if recType = null;
// 193
    JP.go.ipa.oz.lib.standard._String_if name = null;
// 194
    JP.go.ipa.oz.lib.standard._String_if strPrefix = null;
// 195
    JP.go.ipa.oz.lib.standard._String_if strType = null;
// 196
    int intPrefix = 0;
// 197
    JP.go.ipa.oz.user.ide.CIAccessLevel_if accessLevel = null;
// 198
    JP.go.ipa.oz.user.ide.CIModifier_if modifier = null;
// 199
    JP.go.ipa.oz.user.ide.CIType_if type = null;
// 200
    JP.go.ipa.oz.user.ide.CIAttribute_if att = null;
// 202
    rt = (JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl) (new JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl ())._new_newCIRecordTokenizer (record);
// 203
    recType = rt.nextToken ();
// 204
    name = rt.nextToken ();
// 205
    strPrefix = rt.nextToken ();
// 206
    strType = rt.nextToken ();
// 208
    type = parseType (strType);
// 209
    intPrefix = parseInteger (strPrefix);
// 210
    accessLevel = (JP.go.ipa.oz.user.ide.CIAccessLevel_cl) (new JP.go.ipa.oz.user.ide.CIAccessLevel_cl ())._new_newCIAccessLevel (intPrefix);
// 211
    modifier = (JP.go.ipa.oz.user.ide.CIModifier_cl) (new JP.go.ipa.oz.user.ide.CIModifier_cl ())._new_newCIModifier (intPrefix);
// 213
    att = (JP.go.ipa.oz.user.ide.CIAttribute_cl) (new JP.go.ipa.oz.user.ide.CIAttribute_cl ())._new_newCIAttribute (accessLevel, modifier, type, name, part);
// 214
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
      try {
        part.addMember (att);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      part.addMember (att);
    }
  }
  
  JP.go.ipa.oz.lib.standard._StringBuffer_if mkCodeBuffer (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
// 151
    JP.go.ipa.oz.lib.standard._ClassProperty_if prop = null;
// 152
    JP.go.ipa.oz.lib.standard._String_if codeFileName = null;
// 153
    JP.go.ipa.oz.lib.standard._StringBuffer_if buffer = null;
// 154
    JP.go.ipa.oz.lib.standard._CharArray_if chs = null;
// 155
    int length = 0;
// 156
    JP.go.ipa.oz.lib.standard._String_if line = null;
// 157
    JP.go.ipa.oz.lib.standard._InputStream_if is = null;
// 158
    JP.go.ipa.oz.lib.standard._InputStreamReader_if isReader = null;
// 159
    JP.go.ipa.oz.user.ide.CIException_if ciExp = null;
// 161
    codeFileName = cid2CIFileName (cid, codeFileExtension);
// 162
    try {
// 163
      prop = (JP.go.ipa.oz.lib.standard._ClassProperty_cl) (new JP.go.ipa.oz.lib.standard._ClassProperty_cl ())._new_create (cid, codeFileName);
// 164
      is = prop.getInputStream ();
// 165
      int available$val$118;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) is)) {
        try {
          available$val$118 = is.available ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        available$val$118 = is.available ();
      }
// 165
      length = available$val$118;
// 166
      isReader = (JP.go.ipa.oz.lib.standard._InputStreamReader_cl) (new JP.go.ipa.oz.lib.standard._InputStreamReader_cl ())._new_breed (is);
// 167
      chs = (JP.go.ipa.oz.lib.standard._CharArray_cl) (new JP.go.ipa.oz.lib.standard._CharArray_cl ())._new_create (length);
// 168
      isReader.read (chs, 0, length);
// 169
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) is)) {
        try {
          is.close ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        is.close ();
      }
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_2) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_2 = _exception_2.getOzException ();
      if (_oz_exception_2 instanceof JP.go.ipa.oz.lib.standard._FileNotFoundException_if) {
        JP.go.ipa.oz.lib.standard._FileNotFoundException_if ex = (JP.go.ipa.oz.lib.standard._FileNotFoundException_if) _oz_exception_2;
// 172
        chs = null;
      } else if (_oz_exception_2 instanceof JP.go.ipa.oz.lib.standard._IOException_if) {
        JP.go.ipa.oz.lib.standard._IOException_if ex = (JP.go.ipa.oz.lib.standard._IOException_if) _oz_exception_2;
// 175
        chs = null;
      } else throw _exception_2;
    }
// 178
    if (chs != null) {{
// 179
        buffer = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (chs.asString ());
      }
    } else {{
// 181
        buffer = null;
      }
    }
// 184
    return buffer;
  }
  
  void parseMembers (JP.go.ipa.oz.user.ide.CIPart_if part, JP.go.ipa.oz.lib.standard._BufferedReader_if reader) throws Exception  {
// 294
    JP.go.ipa.oz.lib.standard._String_if record = null;
// 295
    char recType = '\0';
// 296
    JP.go.ipa.oz.user.ide.CIException_if ex = null;
// 297
    JP.go.ipa.oz.lib.standard._StringBuffer_if codeBuffer = null;
// 299
    boolean isInterface$val$119;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
      try {
        isInterface$val$119 = part.isInterface ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      isInterface$val$119 = part.isInterface ();
    }
// 299
    if (!(isInterface$val$119)) {{
// 300
        JP.go.ipa.oz.lib.standard._String_if getCID$val$120;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) part)) {
          try {
            getCID$val$120 = part.getCID ();
          } finally {
            changeRunningToGreen ();
          }
        } else {
          getCID$val$120 = part.getCID ();
        }
// 300
        codeBuffer = mkCodeBuffer (getCID$val$120);
      }
    }
// 303
    while (true) {
// 303
      JP.go.ipa.oz.lib.standard._String_if readLine$val$121;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) reader)) {
        try {
          readLine$val$121 = reader.readLine ();
        } finally {
          changeRunningToGreen ();
        }
      } else {
        readLine$val$121 = reader.readLine ();
      }
      if (!((record = readLine$val$121) != null)) break;
      
      /* body */ _loop_1: {
// 304
        char charAt$val$122;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) record)) {
          try {
            charAt$val$122 = record.charAt (0);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          charAt$val$122 = record.charAt (0);
        }
// 304
        recType = charAt$val$122;
// 305
        if (recType == ATTRIBUTE_TYPE_CODE) {{
// 306
            parseAttributeRecord (part, record);
          }
        } else {
// 307
          if (recType == CONSTRUCTOR_TYPE_CODE) {{
// 308
              parseConstructorRecord (part, record, codeBuffer);
            }
          } else {
// 309
            if (recType == METHOD_TYPE_CODE) {{
// 310
                parseMethodRecord (part, record, codeBuffer);
              }
            } else {{
// 312
                ex = (JP.go.ipa.oz.user.ide.CIException_cl) (new JP.go.ipa.oz.user.ide.CIException_cl ())._new_newCIException ((new JP.go.ipa.oz.lib.standard._String_cl("CI file format error")));
// 313
                throw new JP.go.ipa.oz.lang.OzException (ex);
              }
            }
          }
        }
      }
    }
  }
  
  JP.go.ipa.oz.lib.standard._String_if cid2CIFileName (JP.go.ipa.oz.lib.standard._String_if cid, JP.go.ipa.oz.lib.standard._String_if extension) throws Exception  {
// 76
    int lindex = 0;
// 77
    JP.go.ipa.oz.lib.standard._String_if clname = null;
// 78
    JP.go.ipa.oz.lib.standard._StringBuffer_if name = null;
// 79
    JP.go.ipa.oz.user.ide.CIException_if ciExp = null;
// 81
    int lastIndexOf$val$123;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
      try {
        lastIndexOf$val$123 = cid.lastIndexOf ('.');
      } finally {
        changeRunningToGreen ();
      }
    } else {
      lastIndexOf$val$123 = cid.lastIndexOf ('.');
    }
// 81
    lindex = lastIndexOf$val$123;
// 82
    if (lindex == -1) {{
// 83
        ciExp = (JP.go.ipa.oz.user.ide.CIException_cl) (new JP.go.ipa.oz.user.ide.CIException_cl ())._new_newCIException ((new JP.go.ipa.oz.lib.standard._String_cl("Invalid class ID")), cid);
// 84
        throw new JP.go.ipa.oz.lang.OzException (ciExp);
      }
    }
// 87
    JP.go.ipa.oz.lib.standard._String_if substring$val$124;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) cid)) {
      try {
        substring$val$124 = cid.substring (lindex + 1);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$124 = cid.substring (lindex + 1);
    }
// 87
    clname = substring$val$124;
// 88
    name = (JP.go.ipa.oz.lib.standard._StringBuffer_cl) (new JP.go.ipa.oz.lib.standard._StringBuffer_cl ())._new_breed (clname);
// 89
    name.append (extension);
// 91
    return name.asString ();
  }
  
  JP.go.ipa.oz.user.ide.CIInterfacePart_if parseIfRecord (JP.go.ipa.oz.lib.standard._String_if record) throws Exception  {
// 323
    JP.go.ipa.oz.user.ide.CIRecordTokenizer_if rt = null, lt = null;
// 324
    JP.go.ipa.oz.lib.standard._String_if rec_type = null;
// 325
    JP.go.ipa.oz.lib.standard._String_if cid = null;
// 326
    JP.go.ipa.oz.lib.standard._String_if strModifiers = null;
// 327
    JP.go.ipa.oz.lib.standard._String_if ifCIDs = null;
// 328
    JP.go.ipa.oz.lib.standard._SList_if superIfCIDList = null;
// 329
    JP.go.ipa.oz.user.ide.CIModifier_if modifiers = null;
// 330
    JP.go.ipa.oz.user.ide.CIInterfacePart_if ifPart = null;
// 332
    rt = (JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl) (new JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl ())._new_newCIRecordTokenizer (record);
// 333
    rec_type = rt.nextToken ();
// 334
    cid = rt.nextToken ();
// 335
    strModifiers = rt.nextToken ();
// 336
    ifCIDs = rt.nextList ();
// 338
    modifiers = parseModifier (strModifiers);
// 340
    lt = (JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl) (new JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl ())._new_newCIRecordTokenizer (ifCIDs);
// 341
    superIfCIDList = (JP.go.ipa.oz.lib.standard._SList_cl) (new JP.go.ipa.oz.lib.standard._SList_cl ())._new_create ();
// 342
    while (true) {
      if (!(lt.hasMoreTokens ())) break;
      
      /* body */ _loop_1: {
// 343
        superIfCIDList.pushBack (lt.nextToken ());
      }
    }
// 346
    ifPart = (JP.go.ipa.oz.user.ide.CIInterfacePart_cl) (new JP.go.ipa.oz.user.ide.CIInterfacePart_cl ())._new_newCIInterfacePart (cid, modifiers, superIfCIDList);
// 348
    return ifPart;
  }
  
  int str2int (JP.go.ipa.oz.lib.standard._String_if str, int radix) throws Exception  {
// 615
    int rv = 0, i = 0, n = 0, length = 0;
// 616
    char ch = '\0';
// 617
    JP.go.ipa.oz.lib.standard._String_if num = (new JP.go.ipa.oz.lib.standard._String_cl("0123456789ABCDEF"));
// 619
    int length$val$125;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) str)) {
      try {
        length$val$125 = str.length ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      length$val$125 = str.length ();
    }
// 619
    length = length$val$125;
// 620
    JP.go.ipa.oz.lib.standard._String_if toUpperCase$val$126;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) str)) {
      try {
        toUpperCase$val$126 = str.toUpperCase ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      toUpperCase$val$126 = str.toUpperCase ();
    }
// 620
    str = toUpperCase$val$126;
// 621
    /* for loop starting here */ {
      /* initialization part */
// 621
      i = 0;
      
      for (;;) {
        /* boolean expression part */
        if (!(i < length)) break;
        
        /* body */ _loop_1: {
// 622
          char charAt$val$127;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) str)) {
            try {
              charAt$val$127 = str.charAt (i);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            charAt$val$127 = str.charAt (i);
          }
// 622
          n = num.indexOf (charAt$val$127);
// 623
          rv *= radix;
// 624
          rv += n;
        }
        /* iteration part */
// 621
        i++;
      }
    }
// 627
    return rv;
  }
  
  JP.go.ipa.oz.lib.standard._String_if parseCodeInfo (JP.go.ipa.oz.lib.standard._String_if codeInfoRecord, JP.go.ipa.oz.lib.standard._String_if codeBuffer) throws Exception  {
// 274
    JP.go.ipa.oz.user.ide.CIRecordTokenizer_if rt = null;
// 275
    JP.go.ipa.oz.lib.standard._String_if strOffset = null, strLength = null;
// 276
    int offset = 0, length = 0;
// 277
    JP.go.ipa.oz.lib.standard._String_if code = null;
// 279
    rt = (JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl) (new JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl ())._new_newCIRecordTokenizer (codeInfoRecord);
// 280
    strOffset = rt.nextToken ();
// 281
    strLength = rt.nextToken ();
// 282
    offset = str2int (strOffset, 10);
// 283
    length = str2int (strLength, 10);
// 285
    JP.go.ipa.oz.lib.standard._String_if substring$val$128;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) codeBuffer)) {
      try {
        substring$val$128 = codeBuffer.substring (offset, offset + length);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$128 = codeBuffer.substring (offset, offset + length);
    }
// 285
    code = substring$val$128;
// 287
    return code;
  }
  
  JP.go.ipa.oz.lib.standard._String_if parseCodeInfo (JP.go.ipa.oz.lib.standard._StringBuffer_if codeBuffer, JP.go.ipa.oz.lib.standard._String_if codeInfoRecord) throws Exception  {
// 252
    JP.go.ipa.oz.user.ide.CIRecordTokenizer_if rt = null;
// 253
    JP.go.ipa.oz.lib.standard._String_if strOffset = null, strLength = null;
// 254
    int offset = 0, length = 0;
// 255
    JP.go.ipa.oz.lib.standard._ByteArray_if buffer = null;
// 256
    JP.go.ipa.oz.lib.standard._String_if code = null;
// 258
    rt = (JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl) (new JP.go.ipa.oz.user.ide.CIRecordTokenizer_cl ())._new_newCIRecordTokenizer (codeInfoRecord);
// 259
    strOffset = rt.nextToken ();
// 260
    strLength = rt.nextToken ();
// 261
    offset = str2int (strOffset, 10);
// 262
    length = str2int (strLength, 10);
// 264
    JP.go.ipa.oz.lib.standard._String_if asString$val$129;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) codeBuffer)) {
      try {
        asString$val$129 = codeBuffer.asString ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      asString$val$129 = codeBuffer.asString ();
    }
// 264
    code = asString$val$129;
// 265
    JP.go.ipa.oz.lib.standard._String_if substring$val$130;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) code)) {
      try {
        substring$val$130 = code.substring (offset, offset + length);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      substring$val$130 = code.substring (offset, offset + length);
    }
// 265
    code = substring$val$130;
// 267
    return code;
  }
  
  void initParams () throws Exception  {
// 98
    JP.go.ipa.oz.lib.standard._String_if ozHomePath = null;
// 99
    JP.go.ipa.oz.lib.standard._File_if file = null;
// 101
    JP.go.ipa.oz.lib.standard._String_if getOzHome$val$131;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        getOzHome$val$131 = system.getOzHome ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getOzHome$val$131 = system.getOzHome ();
    }
// 101
    ozHomePath = getOzHome$val$131;
// 102
    file = (JP.go.ipa.oz.lib.standard._File_cl) (new JP.go.ipa.oz.lib.standard._File_cl ())._new_breed (ozHomePath);
// 103
    fileSeparator = file.getSeparator ();
// 104
    fileSeparatorChar = file.getSeparatorChar ();
// 105
    JP.go.ipa.oz.lib.standard._String_if concat$val$132;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ozHomePath)) {
      try {
        concat$val$132 = ozHomePath.concat (fileSeparator);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$132 = ozHomePath.concat (fileSeparator);
    }
// 105
    JP.go.ipa.oz.lib.standard._String_if string$13 = (new JP.go.ipa.oz.lib.standard._String_cl("lib"));
    
// 105
    JP.go.ipa.oz.lib.standard._String_if concat$val$133;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) concat$val$132)) {
      try {
        concat$val$133 = concat$val$132.concat (string$13);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$133 = concat$val$132.concat (string$13);
    }
// 105
    ciPathPrefix = concat$val$133;
// 106
    ciFileExtension = (new JP.go.ipa.oz.lib.standard._String_cl(".ci"));
// 107
    codeFileExtension = (new JP.go.ipa.oz.lib.standard._String_cl(".oz"));
// 109
    IF_TYPE_CODE = 'i';
// 110
    IMPL_TYPE_CODE = 'j';
// 111
    ATTRIBUTE_TYPE_CODE = 'a';
// 112
    CONSTRUCTOR_TYPE_CODE = 'c';
// 113
    METHOD_TYPE_CODE = 'm';
  }
  
  public JP.go.ipa.oz.user.ide.CIPart_if load (JP.go.ipa.oz.lib.standard._String_if cid) throws Exception  {
    checkSecureInvocation ();
// 46
    JP.go.ipa.oz.user.ide.CIPart_if part = null;
// 47
    JP.go.ipa.oz.lib.standard._String_if ciFilePath = null;
// 48
    JP.go.ipa.oz.lib.standard._BufferedReader_if reader = null;
// 50
    if (cid != null) {{
// 51
        JP.go.ipa.oz.lib.standard._String_if string$14 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCILoader#load: "));
        
// 51
        JP.go.ipa.oz.lib.standard._String_if concat$val$134;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$14)) {
          try {
            concat$val$134 = string$14.concat (cid);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$134 = string$14.concat (cid);
        }
// 51
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (concat$val$134);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (concat$val$134);
        }
      }
    }
// 54
    reader = mkCIFileReader (cid);
// 55
    try {
// 56
      part = parseCIFile (reader);
    }
    catch (JP.go.ipa.oz.lang.OzException _exception_3) {
      JP.go.ipa.oz.lang._Root_if _oz_exception_3 = _exception_3.getOzException ();
      if (_oz_exception_3 instanceof JP.go.ipa.oz.user.ide.CIException_if) {
        JP.go.ipa.oz.user.ide.CIException_if ciExp = (JP.go.ipa.oz.user.ide.CIException_if) _oz_exception_3;
// 58
        JP.go.ipa.oz.lib.standard._String_if string$15 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCILoader#load: parsing error !!!"));
        
// 58
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (string$15);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (string$15);
        }
// 59
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) ciExp)) {
          try {
            ciExp.setCID (cid);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          ciExp.setCID (cid);
        }
// 60
        throw new JP.go.ipa.oz.lang.OzException (ciExp);
      } else throw _exception_3;
    }
// 63
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) reader)) {
      try {
        reader.close ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      reader.close ();
    }
// 64
    JP.go.ipa.oz.lib.standard._String_if string$16 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCILoader#load: loaded - "));
    
// 64
    JP.go.ipa.oz.lib.standard._String_if concat$val$135;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$16)) {
      try {
        concat$val$135 = string$16.concat (cid);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      concat$val$135 = string$16.concat (cid);
    }
// 64
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
      try {
        system.debugPrintln (concat$val$135);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      system.debugPrintln (concat$val$135);
    }
// 66
    return part;
  }
  
  JP.go.ipa.oz.user.ide.CIPart_if parseCIFile (JP.go.ipa.oz.lib.standard._BufferedReader_if reader) throws Exception  {
// 221
    JP.go.ipa.oz.lib.standard._String_if record = null;
// 222
    JP.go.ipa.oz.user.ide.CIPart_if part = null;
// 223
    char recType = '\0';
// 224
    JP.go.ipa.oz.user.ide.CIException_if ex = null;
// 226
    JP.go.ipa.oz.lib.standard._String_if readLine$val$136;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) reader)) {
      try {
        readLine$val$136 = reader.readLine ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      readLine$val$136 = reader.readLine ();
    }
// 226
    record = readLine$val$136;
// 227
    if (record != null) {{
// 228
        JP.go.ipa.oz.lib.standard._String_if string$17 = (new JP.go.ipa.oz.lib.standard._String_cl("\tCILoader#parseCIFile: record="));
        
// 228
        JP.go.ipa.oz.lib.standard._String_if concat$val$137;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) string$17)) {
          try {
            concat$val$137 = string$17.concat (record);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          concat$val$137 = string$17.concat (record);
        }
// 228
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) system)) {
          try {
            system.debugPrintln (concat$val$137);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          system.debugPrintln (concat$val$137);
        }
// 229
        char charAt$val$138;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) record)) {
          try {
            charAt$val$138 = record.charAt (0);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          charAt$val$138 = record.charAt (0);
        }
// 229
        recType = charAt$val$138;
// 230
        if (recType == IF_TYPE_CODE) {{
// 231
            part = parseIfRecord (record);
          }
        } else {
// 232
          if (recType == IMPL_TYPE_CODE) {{
// 233
              part = parseImplRecord (record);
            }
          } else {{
// 235
              ex = (JP.go.ipa.oz.user.ide.CIException_cl) (new JP.go.ipa.oz.user.ide.CIException_cl ())._new_newCIException ((new JP.go.ipa.oz.lib.standard._String_cl("CI file format error")));
// 236
              throw new JP.go.ipa.oz.lang.OzException (ex);
            }
          }
        }
      }
    } else {{
// 239
        ex = (JP.go.ipa.oz.user.ide.CIException_cl) (new JP.go.ipa.oz.user.ide.CIException_cl ())._new_newCIException ((new JP.go.ipa.oz.lib.standard._String_cl("CI file read error")));
// 240
        throw new JP.go.ipa.oz.lang.OzException (ex);
      }
    }
// 243
    parseMembers (part, reader);
// 245
    return part;
  }
  
  JP.go.ipa.oz.user.ide.CIType_if parseType (JP.go.ipa.oz.lib.standard._String_if str) throws Exception  {
// 562
    JP.go.ipa.oz.user.ide.CIPrimitiveType_if pt = null;
// 563
    JP.go.ipa.oz.user.ide.CIClassType_if ct = null;
// 564
    JP.go.ipa.oz.lib.standard._String_if cid = null;
// 565
    JP.go.ipa.oz.user.ide.CIType_if type = null;
// 566
    JP.go.ipa.oz.lib.standard._String_if prim = (new JP.go.ipa.oz.lib.standard._String_cl("VBSIJFDCZN"));
// 567
    JP.go.ipa.oz.user.ide.CIException_if ex = null;
// 568
    char typeCode = '\0';
// 570
    char charAt$val$139;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) str)) {
      try {
        charAt$val$139 = str.charAt (0);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      charAt$val$139 = str.charAt (0);
    }
// 570
    typeCode = charAt$val$139;
// 571
    if (prim.indexOf (typeCode) != -1) {{
// 573
        if (typeCode == 'V') {{
// 574
            pt = (JP.go.ipa.oz.user.ide.CIPrimitiveType_cl) (new JP.go.ipa.oz.user.ide.CIPrimitiveType_cl ())._new_newVoidType ();
          }
        } else {
// 575
          if (typeCode == 'B') {{
// 576
              pt = (JP.go.ipa.oz.user.ide.CIPrimitiveType_cl) (new JP.go.ipa.oz.user.ide.CIPrimitiveType_cl ())._new_newByteType ();
            }
          } else {
// 577
            if (typeCode == 'S') {{
// 578
                pt = (JP.go.ipa.oz.user.ide.CIPrimitiveType_cl) (new JP.go.ipa.oz.user.ide.CIPrimitiveType_cl ())._new_newShortType ();
              }
            } else {
// 579
              if (typeCode == 'I') {{
// 580
                  pt = (JP.go.ipa.oz.user.ide.CIPrimitiveType_cl) (new JP.go.ipa.oz.user.ide.CIPrimitiveType_cl ())._new_newIntegerType ();
                }
              } else {
// 581
                if (typeCode == 'J') {{
// 582
                    pt = (JP.go.ipa.oz.user.ide.CIPrimitiveType_cl) (new JP.go.ipa.oz.user.ide.CIPrimitiveType_cl ())._new_newLongType ();
                  }
                } else {
// 583
                  if (typeCode == 'F') {{
// 584
                      pt = (JP.go.ipa.oz.user.ide.CIPrimitiveType_cl) (new JP.go.ipa.oz.user.ide.CIPrimitiveType_cl ())._new_newFloatType ();
                    }
                  } else {
// 585
                    if (typeCode == 'D') {{
// 586
                        pt = (JP.go.ipa.oz.user.ide.CIPrimitiveType_cl) (new JP.go.ipa.oz.user.ide.CIPrimitiveType_cl ())._new_newDoubleType ();
                      }
                    } else {
// 587
                      if (typeCode == 'C') {{
// 588
                          pt = (JP.go.ipa.oz.user.ide.CIPrimitiveType_cl) (new JP.go.ipa.oz.user.ide.CIPrimitiveType_cl ())._new_newCharacterType ();
                        }
                      } else {
// 589
                        if (typeCode == 'Z') {{
// 590
                            pt = (JP.go.ipa.oz.user.ide.CIPrimitiveType_cl) (new JP.go.ipa.oz.user.ide.CIPrimitiveType_cl ())._new_newBooleanType ();
                          }
                        } else {
// 591
                          if (typeCode == 'N') {{
// 592
                              pt = (JP.go.ipa.oz.user.ide.CIPrimitiveType_cl) (new JP.go.ipa.oz.user.ide.CIPrimitiveType_cl ())._new_newConditionType ();
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
        }
// 594
        type = pt;
      }
    } else {{
// 598
        if (typeCode == 'L') {{
// 599
            JP.go.ipa.oz.lib.standard._String_if substring$val$140;
            if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) str)) {
              try {
                substring$val$140 = str.substring (1);
              } finally {
                changeRunningToGreen ();
              }
            } else {
              substring$val$140 = str.substring (1);
            }
// 599
            cid = substring$val$140;
// 600
            ct = (JP.go.ipa.oz.user.ide.CIClassType_cl) (new JP.go.ipa.oz.user.ide.CIClassType_cl ())._new_newCIClassType (cid);
// 601
            type = ct;
          }
        } else {{
// 603
            ex = (JP.go.ipa.oz.user.ide.CIException_cl) (new JP.go.ipa.oz.user.ide.CIException_cl ())._new_newCIException ((new JP.go.ipa.oz.lib.standard._String_cl("CI file format error")));
// 604
            throw new JP.go.ipa.oz.lang.OzException (ex);
          }
        }
      }
    }
// 608
    return type;
  }
  
  int parseInteger (JP.go.ipa.oz.lib.standard._String_if str) throws Exception  {
// 549
    JP.go.ipa.oz.lib.standard._String_if string$18 = (new JP.go.ipa.oz.lib.standard._String_cl("0x"));
    
// 549
    boolean startsWith$val$141;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) str)) {
      try {
        startsWith$val$141 = str.startsWith (string$18);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      startsWith$val$141 = str.startsWith (string$18);
    }
// 549
    if (startsWith$val$141) {{
// 550
        JP.go.ipa.oz.lib.standard._String_if substring$val$142;
        if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) str)) {
          try {
            substring$val$142 = str.substring (2);
          } finally {
            changeRunningToGreen ();
          }
        } else {
          substring$val$142 = str.substring (2);
        }
// 550
        return str2int (substring$val$142, 16);
      }
    } else {
// 551
      char charAt$val$143;
      if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) str)) {
        try {
          charAt$val$143 = str.charAt (0);
        } finally {
          changeRunningToGreen ();
        }
      } else {
        charAt$val$143 = str.charAt (0);
      }
// 551
      if (charAt$val$143 == '0') {{
// 552
          JP.go.ipa.oz.lib.standard._String_if substring$val$144;
          if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) str)) {
            try {
              substring$val$144 = str.substring (1);
            } finally {
              changeRunningToGreen ();
            }
          } else {
            substring$val$144 = str.substring (1);
          }
// 552
          return str2int (substring$val$144, 8);
        }
      }
    }
// 555
    return str2int (str, 10);
  }
  
  public CILoader_cl () throws Exception { super (); }
  
}


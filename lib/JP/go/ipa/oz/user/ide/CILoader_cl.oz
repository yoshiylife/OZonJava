// OZ: CILoader


/**
 * CILoader
 * reads the class information from the class information file.
 *
 * @version  prop 1.2
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

final class CILoader
{

  String  ciPathPrefix;
  String  fileSeparator;
  char    fileSeparatorChar;
  String  ciFileExtension;
  String  codeFileExtension;

  char  IF_TYPE_CODE;
  char  IMPL_TYPE_CODE;
  char  ATTRIBUTE_TYPE_CODE;
  char  CONSTRUCTOR_TYPE_CODE;
  char  METHOD_TYPE_CODE;

  System  system;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newCILoader()
  {
    system => create();

    initParams();
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public CIPart load(String cid)
  {
    CIPart  part;
    String  ciFilePath;
    BufferedReader  reader;

    if (cid != null) {
      system->debugPrintln("\tCILoader#load: "->concat(cid));
    }
    
    reader = mkCIFileReader(cid);
    try {
      part = parseCIFile(reader);
    } catch (CIException ciExp) {
      system->debugPrintln("\tCILoader#load: parsing error !!!");
      ciExp->setCID(cid);
      throw ciExp;
    }

    reader->close();
    system->debugPrintln("\tCILoader#load: loaded - "->concat(cid));

    return part;
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  // @param  extension  ".ci" for CI File or ".oz" for source code file
  String cid2CIFileName(String cid, String extension)
  {
    int  lindex;
    String  clname;
    StringBuffer  name;
    CIException  ciExp;

    lindex = cid->lastIndexOf('.');
    if (lindex == -1) {
      ciExp => newCIException("Invalid class ID", cid);
      throw ciExp;
    }

    clname = cid->substring(lindex + 1);
    name => breed(clname);
    name->append(extension);

    return name->asString();
  }


  //--------------------------------------------------------------------
  void initParams()
  {
    String  ozHomePath;
    File  file;

    ozHomePath = system->getOzHome();
    file => breed(ozHomePath);
    fileSeparator = file->getSeparator();
    fileSeparatorChar = file->getSeparatorChar();
    ciPathPrefix = ozHomePath->concat(fileSeparator)->concat("lib");
    ciFileExtension = ".ci";
    codeFileExtension = ".oz";

    IF_TYPE_CODE           = 'i';
    IMPL_TYPE_CODE         = 'j';
    ATTRIBUTE_TYPE_CODE    = 'a';
    CONSTRUCTOR_TYPE_CODE  = 'c';
    METHOD_TYPE_CODE       = 'm';
  }


  //--------------------------------------------------------------------
  BufferedReader mkCIFileReader(String cid)
  {
    ClassProperty  prop;
    InputStream  is;
    InputStreamReader  isReader;
    BufferedReader  reader;
    String  ciFileName;
    CIException  ciExp;

    ciFileName = cid2CIFileName(cid, ciFileExtension);
    if (ciFileName != null) {
      system->debugPrintln("\tCILoader#mkCIFileReader: ciFileName="->concat(ciFileName));
    }
    try {
      prop => create(cid, ciFileName);
      is = prop->getInputStream();
      isReader => breed(is);
      reader => breed(isReader);
    } catch (FileNotFoundException ex) {
      ciExp => newCIException("CI file not found", cid);
      throw ciExp;
    } catch (IOException ex) {
      ciExp => newCIException("CI file not ready to read", cid);
      throw ciExp;
    }
    
    return reader;
  }


  //--------------------------------------------------------------------
  StringBuffer mkCodeBuffer(String cid)
  {
    ClassProperty  prop;
    String  codeFileName;
    StringBuffer  buffer;
    CharArray  chs;
    int  length;
    String  line;
    InputStream  is;
    InputStreamReader  isReader;
    CIException  ciExp;

    codeFileName = cid2CIFileName(cid, codeFileExtension);
    try {
      prop => create(cid, codeFileName);
      is = prop->getInputStream();
      length = is->available();
      isReader => breed(is);
      chs => create(length);
      isReader->read(chs, 0, length);
      is->close();
    } catch (FileNotFoundException ex) {
      // code file not found
      chs = null;
    } catch (IOException ex) {
      // code file not ready to read
      chs = null;
    }

    if (chs != null) {
      buffer => breed(chs->asString());
    } else {
      buffer = null;
    }

    return buffer;
  }


  //--------------------------------------------------------------------
  void parseAttributeRecord(CIPart part, String record)
  {
    CIRecordTokenizer     rt;
    String                recType;
    String                name;
    String                strPrefix;
    String                strType;
    int                   intPrefix;
    CIAccessLevel         accessLevel;
    CIModifier            modifier;
    CIType                type;
    CIAttribute           att;

    rt => newCIRecordTokenizer(record);
    recType         = rt->nextToken();        // "a"
    name            = rt->nextToken();        // name
    strPrefix       = rt->nextToken();        // access level & modifier
    strType         = rt->nextToken();        // type

    type = parseType(strType);
    intPrefix = parseInteger(strPrefix);
    accessLevel => newCIAccessLevel(intPrefix);
    modifier => newCIModifier(intPrefix);

    att => newCIAttribute(accessLevel, modifier, type, name, part);
    part->addMember(att);
  }


  //--------------------------------------------------------------------
  CIPart parseCIFile(BufferedReader reader)
  {
    String  record;
    CIPart  part;
    char  recType;
    CIException  ex;

    record = reader->readLine();
    if (record != null) {
      system->debugPrintln("\tCILoader#parseCIFile: record="->concat(record));
      recType = record->charAt(0);
      if (recType == IF_TYPE_CODE) {
        part = parseIfRecord(record);
      } else if (recType == IMPL_TYPE_CODE) {
        part = parseImplRecord(record);
      } else {
        ex =>newCIException("CI file format error");
        throw ex;
      }
    } else {
      ex =>newCIException("CI file read error");
      throw ex;
    }

    parseMembers(part, reader);

    return part;
  }


  //--------------------------------------------------------------------
  String parseCodeInfo(StringBuffer codeBuffer, String codeInfoRecord)
  {
    CIRecordTokenizer  rt;
    String  strOffset, strLength;
    int  offset, length;
    ByteArray  buffer;
    String  code;

    rt => newCIRecordTokenizer(codeInfoRecord);
    strOffset = rt->nextToken();
    strLength = rt->nextToken();
    offset = str2int(strOffset, 10);
    length = str2int(strLength, 10);

    code = codeBuffer->asString();
    code = code->substring(offset, offset + length);

    return code;
  }


  //--------------------------------------------------------------------
  String parseCodeInfo(String codeInfoRecord, String codeBuffer)
  {
    CIRecordTokenizer  rt;
    String  strOffset, strLength;
    int  offset, length;
    String  code;

    rt => newCIRecordTokenizer(codeInfoRecord);
    strOffset = rt->nextToken();
    strLength = rt->nextToken();
    offset = str2int(strOffset, 10);
    length = str2int(strLength, 10);

    code = codeBuffer->substring(offset, offset + length);

    return code;
  }


  //--------------------------------------------------------------------
  void parseMembers(CIPart part, BufferedReader reader)
  {
    String  record;
    char  recType;
    CIException  ex;
    StringBuffer  codeBuffer;

    if (!(part->isInterface())) {
      codeBuffer = mkCodeBuffer(part->getCID());
    }

    while ((record = reader->readLine()) != null) {
      recType = record->charAt(0);
      if (recType == ATTRIBUTE_TYPE_CODE) {
        parseAttributeRecord(part, record);
      } else if (recType == CONSTRUCTOR_TYPE_CODE) {
        parseConstructorRecord(part, record, codeBuffer);
      } else if (recType == METHOD_TYPE_CODE) {
        parseMethodRecord(part, record, codeBuffer);
      } else {
        ex => newCIException("CI file format error");
        throw ex;
      }
    }

  }


  //--------------------------------------------------------------------
  CIInterfacePart parseIfRecord(String record)
  {
    CIRecordTokenizer  rt, lt;
    String             rec_type;
    String             cid;
    String             strModifiers;
    String             ifCIDs;
    SList              superIfCIDList;  // SList<String:cid>
    CIModifier         modifiers;
    CIInterfacePart    ifPart;
    
    rt => newCIRecordTokenizer(record);
    rec_type        = rt->nextToken();        // "i"
    cid             = rt->nextToken();        // CID
    strModifiers    = rt->nextToken();        // modifiers
    ifCIDs          = rt->nextList();         // super interface CID list

    modifiers = parseModifier(strModifiers);

    lt => newCIRecordTokenizer(ifCIDs);
    superIfCIDList => create();
    while (lt->hasMoreTokens()) {
      superIfCIDList->pushBack(lt->nextToken());
    }

    ifPart => newCIInterfacePart(cid, modifiers, superIfCIDList);

    return ifPart;
  }


  //--------------------------------------------------------------------
  CIImplementationPart parseImplRecord(String record)
  {
    CIRecordTokenizer     rt;
    String                rec_type;
    String                cid;
    String                strPrefix;
    String                ifCID;
    String                superImplCID;
    int                   intPrefix;
    CIAccessLevel         accessLevel;
    CIModifier            modifier;
    CIImplementationPart  implPart;
    
    rt => newCIRecordTokenizer(record);
    rec_type        = rt->nextToken();        // "j"
    cid             = rt->nextToken();        // CID
    strPrefix       = rt->nextToken();        // access level & modifier
    ifCID           = rt->nextToken();        // interface CID
    superImplCID    = rt->nextToken();        // super impl. CID

    intPrefix = parseInteger(strPrefix);
    accessLevel => newCIAccessLevel(intPrefix);
    modifier => newCIModifier(intPrefix);

    implPart => newCIImplementationPart(cid, accessLevel, modifier,
                                        ifCID, superImplCID);

    return implPart;
  }


  //--------------------------------------------------------------------
  void parseConstructorRecord(CIPart part, String record,
                              StringBuffer codeBuffer)
  {
    CIRecordTokenizer     rt, lt;
    String                recType;
    String                name;
    String                strArgTypes;
    String                strRefCIDs;
    String                strInstCIDs;
    String                strCodeInfo;
    SList                 argTypeList;  // SList<CIType>
    SList                 refCIDList;   // SList<String>
    SList                 instCIDList;  // SList<String>
    String                code;
    CIMethodImplementation  cnst;

    rt => newCIRecordTokenizer(record);
    recType         = rt->nextToken();        // "c"
    name            = rt->nextToken();        // name
    strArgTypes     = rt->nextList();         // argument type list
    strRefCIDs      = rt->nextList();         // refering CIDs
    strInstCIDs     = rt->nextList();         // instanciating CIDs
    strCodeInfo     = rt->nextList();         // source code info.

    // argument type list
    lt => newCIRecordTokenizer(strArgTypes);
    argTypeList => create();
    while (lt->hasMoreTokens()) {
      argTypeList->pushBack(parseType(lt->nextToken()));
    }

    // refering CID list
    lt => newCIRecordTokenizer(strRefCIDs);
    refCIDList => create();
    while (lt->hasMoreTokens()) {
      refCIDList->pushBack(lt->nextToken());
    }

    // instantiating CID list
    lt => newCIRecordTokenizer(strInstCIDs);
    instCIDList => create();
    while (lt->hasMoreTokens()) {
      instCIDList->pushBack(lt->nextToken());
    }

    // source code
    if (codeBuffer != null) {
      code = parseCodeInfo(codeBuffer, strCodeInfo);
    } else {
      code => breed("code not available");
    }

    cnst => newCIConstructorImplementation(name, argTypeList,
                                           refCIDList, instCIDList,
                                           code, part);
    part->addMember(cnst);
  }


  //--------------------------------------------------------------------
  void parseMethodRecord(CIPart part, String record,
                         StringBuffer codeBuffer)
  {
    CIRecordTokenizer  rt, lt;
    String             recType;
    String             name;
    String             strPrefix;
    String             strReturnType;
    String             strArgTypeList;
    String             strRefCIDList;
    String             strInstCIDList;
    int                intPrefix;
    CIAccessLevel      accessLevel;
    CIModifier         modifier;
    CIType             returnType;
    SList              argTypeList;  // SList<CIType>
    SList              refCIDList;   // SList<String>
    SList              instCIDList;  // SList<String>
    String             strCodeInfo;
    int                i;

    rt => newCIRecordTokenizer(record);
    recType           = rt->nextToken();        // "m"
    name              = rt->nextToken();        // name
    strPrefix         = rt->nextToken();        // access level & modifier
    strReturnType     = rt->nextToken();        // return type
    strArgTypeList    = rt->nextList();         // argument type list

    intPrefix = parseInteger(strPrefix);
    accessLevel => newCIAccessLevel(intPrefix);
    modifier => newCIModifier(intPrefix);
    returnType = parseType(strReturnType);
    
    // argument type list
    lt => newCIRecordTokenizer(strArgTypeList);
    argTypeList => create();
    while (lt->hasMoreTokens()) {
      argTypeList->pushBack(parseType(lt->nextToken()));
    }

    if (rt->hasMoreTokens()) {
      // the record is a method implementation one
      CIMethodImplementation  methodImpl;
      String code;
      
      strRefCIDList  = rt->nextList();
      strInstCIDList = rt->nextList();
      strCodeInfo    = rt->nextList();

      // refering CID list
      lt => newCIRecordTokenizer(strRefCIDList);
      refCIDList => create();
      while (lt->hasMoreTokens()) {
        refCIDList->pushBack(lt->nextToken());
      }
    
      // instantiating CID list
      lt => newCIRecordTokenizer(strInstCIDList);
      instCIDList => create();
      while (lt->hasMoreTokens()) {
        instCIDList->pushBack(lt->nextToken());
      }
    
      // source code
      if (codeBuffer != null) {
        code = parseCodeInfo(codeBuffer, strCodeInfo);
      } else {
        code => breed("code not available");
      }

      methodImpl => newCIMethodImplementation(accessLevel, modifier,
                                              returnType, name,
                                              argTypeList,
                                              refCIDList, instCIDList,
                                              code, part);
      part->addMember(methodImpl);

    } else {
      // the record is a method interface one
      CIMethod  methodIf;

      methodIf => newCIMethod(accessLevel, modifier, returnType, name,
                              argTypeList, part);
      part->addMember(methodIf);
    }
  }


  //--------------------------------------------------------------------
  CIModifier parseModifier(String str)
  {
    int  val;
    CIModifier  mods;
    
    val = parseInteger(str);
    mods => newCIModifier(val);

    return mods;
  }


  //--------------------------------------------------------------------
  int parseInteger(String str)
  {
    if (str->startsWith("0x")) {
      return str2int(str->substring(2), 16);
    } else if(str->charAt(0) == '0') {
      return str2int(str->substring(1), 8);
    }

    return str2int(str, 10);
  }


  //--------------------------------------------------------------------
  CIType parseType(String str)
  {
    CIPrimitiveType  pt;
    CIClassType  ct;
    String  cid;
    CIType  type;
    String  prim = "VBSIJFDCZN";
    CIException  ex;
    char  typeCode;

    typeCode = str->charAt(0);
    if (prim->indexOf(typeCode) != -1) {
      // primtive type
      if (typeCode == 'V') {
        pt => newVoidType();
      } else if (typeCode == 'B') {
        pt => newByteType();
      } else if (typeCode == 'S') {
        pt => newShortType();
      } else if (typeCode == 'I') {
        pt => newIntegerType();
      } else if (typeCode == 'J') {
        pt => newLongType();
      } else if (typeCode == 'F') {
        pt => newFloatType();
      } else if (typeCode == 'D') {
        pt => newDoubleType();
      } else if (typeCode == 'C') {
        pt => newCharacterType();
      } else if (typeCode == 'Z') {
        pt => newBooleanType();
      } else if (typeCode == 'N') {
        pt => newConditionType();
      }
      type = pt;

    } else {
      // class type
      if (typeCode == 'L') {
        cid = str->substring(1);
        ct => newCIClassType(cid);
        type = ct;
      } else {
        ex => newCIException("CI file format error");
        throw ex;
      }
    }

    return type;
  }


  //--------------------------------------------------------------------
  int str2int(String str, int radix)
  {
    int  rv = 0, i, n, length;
    char  ch;
    String  num = "0123456789ABCDEF";

    length = str->length();
    str = str->toUpperCase();
    for (i = 0; i < length; i++) {
      n = num->indexOf(str->charAt(i));
      rv *= radix;
      rv += n;
    }

    return rv;
  }

}

// EoF


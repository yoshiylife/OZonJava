// OZ: class browser


/**
 * CIImplementationPart
 * 
 * @version  0.2.4
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

final class CIImplementationPart
  : *CIPart
{

  CIAccessLevel     accessLevel;
  String            ifCID;
  String            superImplCID;
  SList             attributeList;        // SList<CIAttribute>
  SList             constructorList;      // SList<CIConstructor>
  SList             publicMethodList;     // SList<CIMethod>
  SList             protectedMethodList;  // SList<CIMethod>
  SList             privateMethodList;    // SList<CIMethod>

  String            OZCELL_CID;  // .system.OzCell

  
  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newCIImplementationPart(String cid,
                              CIAccessLevel acc, CIModifier mod,
			      String ifCID, String superImplCID)
  {
    super->initParams(cid, mod);
    this->accessLevel = acc;
    this->ifCID = ifCID;
    this->superImplCID = superImplCID;

    this->attributeList => create();
    this->constructorList => create();
    this->publicMethodList => create();
    this->protectedMethodList => create();
    this->privateMethodList => create();

    OZCELL_CID = "JP.go.ipa.oz.system.OzCell";
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void addMember(CIMember mbr)
  {
    if (mbr->isAttribute()) {
      CIAttribute  att;
      att =| mbr;
      addAttribute(att);

    } else if (mbr->isConstructor()) {
      CIMethod  cnst;
      cnst =| mbr;
      addConstructor(cnst);

    } else if (mbr->isMethod()) {
      CIMethod  method;
      method =| mbr;
      addMethod(method);
    }
  }

  
  //--------------------------------------------------------------------
  public Iterator attributes()
  {
    return attributeList->iterator();
  }


  //--------------------------------------------------------------------
  public int getAttributeCount()
  {
    return attributeList->size();
  }


  //--------------------------------------------------------------------
  public Iterator constructors()
  {
    return constructorList->iterator();
  }


  //--------------------------------------------------------------------
  public int getConstructorCount()
  {
    return constructorList->size();
  }


  //--------------------------------------------------------------------
  public Iterator publicMethods()
  {
    return publicMethodList->iterator();
  }


  //--------------------------------------------------------------------
  public int getPublicMethodCount()
  {
    return publicMethodList->size();
  }


  //--------------------------------------------------------------------
  public Iterator protectedMethods()
  {
    return protectedMethodList->iterator();
  }


  //--------------------------------------------------------------------
  public int getProtectedMethodCount()
  {
    return protectedMethodList->size();
  }


  //--------------------------------------------------------------------
  public Iterator privateMethods()
  {
    return privateMethodList->iterator();
  }


  //--------------------------------------------------------------------
  public int getPrivateMethodCount()
  {
    return privateMethodList->size();
  }


  //--------------------------------------------------------------------
  public String getInterfaceCID()
  {
    return ifCID;
  }


  //--------------------------------------------------------------------
  public String getSuperImplementationCID()
  {
    return superImplCID;
  }


  //--------------------------------------------------------------------
  public boolean isInterface()
  {
    return false;
  }


  //--------------------------------------------------------------------
  public boolean isProtected()
  {
    return accessLevel->isProtected();
  }


  //--------------------------------------------------------------------
  public boolean isRoot()
  {
    boolean  rv;

    rv = super->isRoot();
    if (rv == false) {
      if (superImplCID->isequal(OZCELL_CID)) {
        rv = true;
      }
    }

    return rv;
  }
    

  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void addAttribute(CIAttribute att)
  {
    attributeList->pushBack(att);
  }
  

  //--------------------------------------------------------------------
  void addConstructor(CIMethod cnst)
  {
    constructorList->pushBack(cnst);
  }

  //--------------------------------------------------------------------
  protected void addMethod(CIMethod method)
  {
    CIMethodImplementation  methodImpl;

    super->addMethod(method);

    methodImpl =| method;
    if (methodImpl->isPublic()) {
      publicMethodList->pushBack(methodImpl);
    } else if (methodImpl->isProtected()) {
      protectedMethodList->pushBack(methodImpl);
    } else {
      privateMethodList->pushBack(methodImpl);
    }
  }

}

// EoF


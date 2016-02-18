// OZ DEV: Class Browser


/**
 * CIMethodImplementation
 * 
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CIMethodImplementation
  : *CIMethod
{

  Collection  refCIDList;   // Collection<String:CID>
  Collection  instCIDList;  // Collection<String:CID>
  String  code;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newCIMethodImplementation(CIAccessLevel acc, CIModifier mod,
                                CIType retType, String name,
                                Sequence argTypeList,
                                Collection refCIDList, Collection instCIDList,
                                String code, CIPart decPart)
  {
    super=>newCIMethod(acc, mod, retType, name, argTypeList, decPart);
    this->refCIDList = refCIDList;
    this->instCIDList = instCIDList;
    this->code = code;
  }


  //--------------------------------------------------------------------
  new newCIConstructorImplementation(String name, Sequence argTypeList,
                                     Collection refCIDList,
                                     Collection instCIDList,
                                     String code, CIPart decPart)
  {
    super=>newCIConstructor(name, argTypeList, decPart);
    this->refCIDList = refCIDList;
    this->instCIDList = instCIDList;
    this->code = code;
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public String getCode()
  {
    return code;
  }


  //--------------------------------------------------------------------
  public int getInstantiatingCIDCount()
  {
    return instCIDList->size();
  }
  

  //--------------------------------------------------------------------
  public int getReferingCIDCount()
  {
    return refCIDList->size();
  }


  //--------------------------------------------------------------------
  public Iterator instantiatingCIDs()
  {
    return instCIDList->iterator();
  }
  

  //--------------------------------------------------------------------
  public boolean isAbstract()
  {
    return modifier->isAbstract();
  }


  //--------------------------------------------------------------------
  public boolean isLocked()
  {
    return modifier->isLocked();
  }


  //--------------------------------------------------------------------
  public boolean isProtected()
  {
    return accessLevel->isProtected();
  }


  //--------------------------------------------------------------------
  public Iterator referingCIDs()
  {
    return refCIDList->iterator();
  }

}

// EoF


// OZ DEV: Class Browser


/**
 * CIClassType
 * 
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CIClassType
  : *CIType
{

  String  cid;


  ///////////////////////////////////////////////////////// constructors
  
  //--------------------------------------------------------------------
  new newCIClassType(String cid)
  {
    initParams(cid);
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public String asString()
  {
    return cid;
  }


  //--------------------------------------------------------------------
  public boolean isPrimitive()
  {
    return false;
  }


  //--------------------------------------------------------------------
  public boolean isClass()
  {
    return true;
  }


  //--------------------------------------------------------------------
  public boolean isOzInternalClass()
  {
    if (cid->startsWith("JP.go.ipa.oz.system.") ||
        cid->startsWith("java.")) {
      return true;
    } else {
      return false;
    }
  }


  //--------------------------------------------------------------------
  public String getCID()
  {
    return cid;
  }


  ////////////////////////////////////////////////////// private methods
  
  //--------------------------------------------------------------------
  void initParams(String cid)
  {
    typeCode = 'L';
    this->cid = cid;
  }

}

// EoF


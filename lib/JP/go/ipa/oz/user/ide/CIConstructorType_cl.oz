// OZ DEV: Class Browser


/**
 * CIConstructorType
 * 
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CIConstructorType
  : *CIType
{

  ///////////////////////////////////////////////////////// constructors
  
  //--------------------------------------------------------------------
  new newCIConstructorType()
  {
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public String asString()
  {
    return "new";
  }


  //--------------------------------------------------------------------
  public boolean isClass()
  {
    return false;
  }


  //--------------------------------------------------------------------
  public boolean isPrimitive()
  {
    return false;
  }

}

// EoF


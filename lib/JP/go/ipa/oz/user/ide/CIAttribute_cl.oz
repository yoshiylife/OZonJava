// DEV: Class Browser


/**
 * CIAttribute
 * 
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CIAttribute
  : *CIMember
{

  CIType  type;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newCIAttribute(CIAccessLevel acc, CIModifier mod, CIType type,
                     String name, CIPart decPart)
  {
    super->initParams(acc, mod, name, decPart);
    this->type = type;
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public String asString()
  {
    StringBuffer  sb;

    sb => breed();
    sb->append(getPrefixAsString());
    if ((sb->length()) != 0) {
      sb->append(" ");
    }
    sb->append(type->asString())->append(" ")->append(getName());

    return sb->asString();
  }


  //--------------------------------------------------------------------
  public String asString(School school)
  {
    String  rv;
    StringBuffer  sb;
    CIClassType  classType;

    if (type->isPrimitive() || school == null) {
      rv = asString();
    } else {
      classType =| type;
      if (classType->isOzInternalClass()) {
        rv = asString();
      } else {
        sb => breed();
        sb->append(getPrefixAsString());
        if ((sb->length()) != 0) {
          sb->append(" ");
        }
        sb->append(school->getNameOfInterface(classType->getCID()))
          ->append(" ")->append(getName());
        rv = sb->asString();
      }
    }

    return rv;
  }


  //--------------------------------------------------------------------
  public CIType getType()
  {
    return type;
  }


  //--------------------------------------------------------------------
  public String getTypeAsString()
  {
    return type->asString();
  }


  //--------------------------------------------------------------------
  public String getTypeAsString(School school)
  {
    return type2String(type, school);
  }


  //--------------------------------------------------------------------
  public boolean isAttribute()
  {
    return true;
  }


  //--------------------------------------------------------------------
  public boolean isConstructor()
  {
    return false;
  }


  //--------------------------------------------------------------------
  public boolean isFinal()
  {
    return modifier->isFinal();
  }


  //--------------------------------------------------------------------
  public boolean isMethod()
  {
    return false;
  }


  //--------------------------------------------------------------------
  public boolean isProtected()
  {
    return accessLevel->isProtected();
  }


  //--------------------------------------------------------------------
  public boolean isTransient()
  {
    return modifier->isTransient();
  }

}

// EoF


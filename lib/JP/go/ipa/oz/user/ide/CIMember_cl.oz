// OZ DEV: Class Browser


/**
 * CIMember
 * 
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

abstract class CIMember
{

  protected CIAccessLevel  accessLevel;
  protected CIModifier     modifier;
  protected String         name;
  protected CIPart         declaringPart;


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public abstract String asString(School s);


  //--------------------------------------------------------------------
  public String getAccessLevelAsString()
  {
    return accessLevel->asString();
  }


  //--------------------------------------------------------------------
  public String getModifierAsString()
  {
    return modifier->asString();
  }


  //--------------------------------------------------------------------
  public CIPart getDeclaringPart()
  {
    return declaringPart;
  }


  //--------------------------------------------------------------------
  public String getName()
  {
    return name;
  }


  //--------------------------------------------------------------------
  public abstract boolean isAttribute();


  //--------------------------------------------------------------------
  public abstract boolean isConstructor();


  //--------------------------------------------------------------------
  public abstract boolean isMethod();


  //////////////////////////////////////////////////// protected methods

  //--------------------------------------------------------------------
  protected String getPrefixAsString()
  {
    StringBuffer  sb;

    sb => breed();
    sb->append(getAccessLevelAsString());
    if ((sb->length()) != 0) {
      sb->append(" ");
    }
    sb->append(getModifierAsString());

    return sb->asString();
  }

  
  //--------------------------------------------------------------------
  protected void initParams(CIAccessLevel acc, CIModifier mod, String name,
                            CIPart decPart)
  {
    this->accessLevel = acc;
    this->modifier = mod;
    this->name = name;
    this->declaringPart = decPart;
  }


  //--------------------------------------------------------------------
  protected String type2String(CIType type, School school)
  {
    String  str;
    String  cid;
    CIClassType  classType;

    if (type->isPrimitive() || school == null) {
      str = type->asString();
    } else if (type->isClass()) {
      classType =| type;
      if (classType->isOzInternalClass()) {
        str = type->asString();
      } else {
        cid = classType->getCID();
        str = school->getNameOfInterface(cid);
        if (str == null) {
          str = cid;
        }
      }
    } else {
      // constructor
      str = type->asString();
    }

    return str;
  }

}

// EoF


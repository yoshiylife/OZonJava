/*
 Copyright(c) 1996-1998
 IPA, ETL, AT21, FSIABC, FXIS, InArc, MRI, NUL, SBC, Sharp, TEC, TIS

 All rights reserved.  No guarantee.
 This technology is a result of the Advanced Software  Enrichment 
 Project of Information-technology Promotion Agency, Japan (IPA).

 Permissions  to  use,  copy, modify and distribute this software
 are governed by the terms and conditions set forth in  the  file 
 COPYRIGHT, located on the top directory of this software.
 */

// OZ DEV: Class Browser


/**
 * CIMethod
 * 
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

class CIMethod
  : *CIMember
{

  protected CIType  returnType;
  protected Sequence  argTypeList;  // Sequence<CIType>
  protected boolean  iAmConstructor;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newCIMethod(CIAccessLevel acc, CIModifier mod, CIType retType,
                  String name, Sequence argTypeList, CIPart decPart)
  {
    super->initParams(acc, mod, name, decPart);
    this->returnType = retType;
    this->argTypeList = argTypeList;
    this->iAmConstructor = false;
  }


  //--------------------------------------------------------------------
  new newCIConstructor(String name, Sequence argTypeList, CIPart decPart)
  {
    CIAccessLevel  acc;
    CIModifier  mod;
    CIConstructorType  cnstType;

    acc => newCIAccessLevel(0);
    mod => newCIModifier(0);
    super->initParams(acc, mod, name, decPart);
    cnstType => newCIConstructorType();
    this->returnType = cnstType;
    this->argTypeList = argTypeList;
    this->iAmConstructor = true;
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public Iterator argumentTypes()
  {
    return argTypeList->iterator();
  }


  //--------------------------------------------------------------------
  public String asString()
  {
    StringBuffer  sb;
    CIType  type;
    Iterator  itr;
    int  i;

    sb => breed();
    if (isMethod()) {
      sb->append(getPrefixAsString());
      if ((sb->length()) != 0) {
        sb->append(" ");
      }
      sb->append(returnType->asString())->append(" ");
    }
    sb->append(getName())
      ->append("(")->append(getArgumentTypeAsString())->append(")");

    return sb->asString();
  }


  //--------------------------------------------------------------------
  public String asString(School school)
  {
    String  rv;
    StringBuffer  sb;
    Iterator  itr;
    CIType  type;
    CIClassType  classType;
    int  i;

    if (school == null) {
      rv = asString();

    } else {
      sb => breed();
      if (isMethod()) {
        sb->append(getPrefixAsString());
        if ((sb->length()) != 0) {
          sb->append(" ");
        }
        sb->append(getReturnTypeAsString(school))->append(" ");
      }

      sb->append(getName())
        ->append("(")->append(getArgumentTypeAsString(school))->append(")");
      rv = sb->asString();
    }

    return rv;
  }


  //--------------------------------------------------------------------
  public String getArgumentTypeAsString()
  {
    StringBuffer  sb;
    Iterator  itr;
    int  i;
    CIType  type;

    sb => breed();
    itr = argTypeList->iterator();
    for (i = 0; itr->hasMoreElements(); i++) {
      if (i != 0) {
	sb->append(", ");
      }
      type =| itr->nextElement();
      sb->append(type->asString());
    }

    return sb->asString();
  }


  //--------------------------------------------------------------------
  public String getArgumentTypeAsString(School school)
  {
    String  str, strType;
    StringBuffer  sb;
    Iterator  itr;
    int  i;
    CIType  type;
    CIClassType  classType;

    if (school == null) {
      str = getReturnTypeAsString();

    } else {
      sb => breed();
      itr = argTypeList->iterator();
      for (i = 0; itr->hasMoreElements(); i++) {
        if (i != 0) {
          sb->append(", ");
        }
        type =| itr->nextElement();
        sb->append(type2String(type, school));

        /*
        if (type->isPrimitive()) {
          sb->append(type->asString());
        } else {
          classType =| type;
          if (classType->isOzInternalClass()) {
            sb->append(classType->asString());
          } else {
            strType = school->getNameOfInterface(classType->getCID());
            if (strType == null) {
              sb->append(classType->asString());
            } else {
              sb->append(strType);
            }
          }
        }
        */
      }
      str = sb->asString();
    }

    return str;
  }


  //--------------------------------------------------------------------
  public String getReturnTypeAsString()
  {
    return returnType->asString();
  }


  //--------------------------------------------------------------------
  public String getReturnTypeAsString(School school)
  {
    return type2String(returnType, school);
  }


  //--------------------------------------------------------------------
  public CIType getReturnType()
  {
    return returnType;
  }


  //--------------------------------------------------------------------
  public boolean isAttribute()
  {
    return false;
  }

  
  //--------------------------------------------------------------------
  public boolean isConstructor()
  {
    return iAmConstructor;
  }

  
  //--------------------------------------------------------------------
  public boolean isFinal()
  {
    return modifier->isFinal();
  }


  //--------------------------------------------------------------------
  public boolean isMethod()
  {
    return !(iAmConstructor);
  }


  //--------------------------------------------------------------------
  public boolean isOnce()
  {
    return modifier->isOnce();
  }


  //--------------------------------------------------------------------
  public boolean isPublic()
  {
    return accessLevel->isPublic();
  }


  //--------------------------------------------------------------------
  public boolean isStatic()
  {
    return modifier->isStatic();
  }

}

// EoF


// DEV: Class Browser


/**
 * CIPrimitiveType
 * 
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CIPrimitiveType
  : *CIType
{

  char  VOID;
  char  BYTE;
  char  SHORT;
  char  INTEGER;
  char  LONG;
  char  FLOAT;
  char  DOUBLE;
  char  CHARACTER;
  char  BOOLEAN;
  char  CONDITION;


  //------------------------------------------------------------------
  new newVoidType()
  {
    init();
    typeCode = VOID;
  }


  //------------------------------------------------------------------
  new newByteType()
  {
    init();
    typeCode = BYTE;
  }


  //------------------------------------------------------------------
  new newShortType()
  {
    init();
    typeCode = SHORT;
  }


  //------------------------------------------------------------------
  new newIntegerType()
  {
    init();
    typeCode = INTEGER;
  }


  //------------------------------------------------------------------
  new newLongType()
  {
    init();
    typeCode = LONG;
  }


  //------------------------------------------------------------------
  new newFloatType()
  {
    init();
    typeCode = FLOAT;
  }


  //------------------------------------------------------------------
  new newDoubleType()
  {
    init();
    typeCode = DOUBLE;
  }


  //------------------------------------------------------------------
  new newCharacterType()
  {
    init();
    typeCode = CHARACTER;
  }


  //------------------------------------------------------------------
  new newBooleanType()
  {
    init();
    typeCode = BOOLEAN;
  }


  //------------------------------------------------------------------
  new newConditionType()
  {
    init();
    typeCode = CONDITION;
  }


  //////////////////////////////////////////////////// public methods
  
  //------------------------------------------------------------------
  public String asString()
  {
    if (typeCode == VOID) {
      return "void";
    } else if (typeCode == BYTE) {
      return "byte";
    } else if (typeCode == SHORT) {
      return "short";
    } else if (typeCode == INTEGER) {
      return "int";
    } else if (typeCode == LONG) {
      return "long";
    } else if (typeCode == FLOAT) {
      return "float";
    } else if (typeCode == DOUBLE) {
      return "double";
    } else if (typeCode == CHARACTER) {
      return "character";
    } else if (typeCode == BOOLEAN) {
      return "boolean";
    } else if (typeCode == CONDITION) {
      return "condition";
    }

    CIException  ex;
    ex => newCIException("unknown type code");
    throw ex;
  }


  //------------------------------------------------------------------
  public boolean isVoid()
  {
    return typeIs(VOID);
  }


  //------------------------------------------------------------------
  public boolean isByte()
  {
    return typeIs(BYTE);
  }


  //------------------------------------------------------------------
  public boolean isShort()
  {
    return typeIs(SHORT);
  }


  //------------------------------------------------------------------
  public boolean isInteger()
  {
    return typeIs(INTEGER);
  }


  //------------------------------------------------------------------
  public boolean isLong()
  {
    return typeIs(LONG);
  }


  //------------------------------------------------------------------
  public boolean isFloat()
  {
    return typeIs(FLOAT);
  }


  //------------------------------------------------------------------
  public boolean isDouble()
  {
    return typeIs(DOUBLE);
  }


  //------------------------------------------------------------------
  public boolean isCharacter()
  {
    return typeIs(CHARACTER);
  }


  //------------------------------------------------------------------
  public boolean isBoolean()
  {
    return typeIs(BOOLEAN);
  }


  //------------------------------------------------------------------
  public boolean isCondition()
  {
    return typeIs(CONDITION);
  }


  //------------------------------------------------------------------
  public boolean isClass()
  {
    return false;
  }


  //------------------------------------------------------------------
  public boolean isPrimitive()
  {
    return true;
  }


  //////////////////////////////////////////////////// private methods
  
  //------------------------------------------------------------------
  void init()
  {
    VOID       = 'V';
    BYTE       = 'B';
    SHORT      = 'S';
    INTEGER    = 'I';
    LONG       = 'J';
    FLOAT      = 'F';
    DOUBLE     = 'D';
    CHARACTER  = 'C';
    BOOLEAN    = 'Z';
    CONDITION  = 'N';
  }


  //--------------------------------------------------------------------
  boolean typeIs(char code)
  {
    return (typeCode == code);
  }

}

// EoF


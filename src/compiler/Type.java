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

/*
 * $Id: Type.java,v 0.17 1998-03-19 14:22:32+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.11.29
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representation any type, for OZ language compiler 
  */

class Type {
  /**
    * string of type 
    */
  protected String name;

  /**
    * encoded name for browser 
    */
  protected String encoded_name;

  /**
    * java class representaion
    */
  protected String java_class;

  /**
    * wild card type, for error status processing 
    */
  static final Type ANY = new Type ();

  /**
    * create a node of abstract syntax tree
    */
  protected Type () { name = "oz$any"; }

  /**
    * check, if type is class 
    * 
    * @return if so true, otherwise false
    */
  boolean isClass () { return false; }

  /**
    * check, if type is string class 
    * 
    * @return if so true, otherwise false
    */
  boolean isString () { return false; }

  /**
    * check, if type is void 
    * 
    * @return if so true, otherwise false
    */
  boolean isVoid () { return false; }

  /**
    * check, if type is bool 
    * 
    * @return if so true, otherwise false
    */
  boolean isBool () { return false; }

  /**
    * check, if type is char 
    * 
    * @return if so true, otherwise false
    */
  boolean isChar () { return false; }

  /**
    * check, if type is condition 
    * 
    * @return if so true, otherwise false
    */
  boolean isCondition () { return false; }

  /**
    * check, if type is primitive type 
    * 
    * @return if so true, otherwise false
    */
  boolean isPrimitive () { return false; }

  /**
    * check, if type is class type and class is abstract 
    * 
    * @return if so true, otherwise false
    */
  boolean isAbstract () { return false; }

  /**
    * checking whether type is exactly same 
    * 
    * @param e comparing type
    * @return if so true, otherwise false
    */
  boolean isSame (Type type) {
    try {
      if (compare (type) == 0) 
	return true;
      else
	return false;
    } catch (TypeMismatch e) {
      return false;
    }
  }

  /**
    * checking whether type is assignable type 
    * 
    * @param e comparing type
    * @return if so true, otherwise false
    */
  boolean isAssignable (Type type) {
    try {
      if (compare (type) >= 0) 
	return true;
      else 
	return false;
    } catch (TypeMismatch e) {
      return false;
    }
  }

  /**
    * checking whether type is same kind 
    * 
    * @param e comparing type
    * @return if so true, otherwise false
    */
  boolean isSameKind (Type type) {
    if (isClass () && !type.isClass () ||
	!isClass () && type.isClass () ||
	isBool () && !type.isBool () ||
	!isBool () && type.isBool () ||
	isChar () && !type.isChar () ||
	!isChar () && type.isChar () ||
	isVoid () && !type.isVoid () ||
	!isVoid () && type.isVoid ())
      return false;

    return true;
  }

  /**
    * check if this type is assinable to expression 
    * 
    * @param e comparing expression
    * @return if so true, otherwise false
    */
  boolean isAssignable (Expression e) {
    try {
      if (compare (e) >= 0) 
	return true;
      else 
	return false;
    } catch (TypeMismatch ex) {
      return false;
    }
  }

  /**
    * compare two types 
    *
    * @param type comparing type
    * @return if comparing type is same  0, if compatible 1, 
    *         otherwise throw TypeMismatch.
    */
  int compare (Type type) throws TypeMismatch { 
    /* not recognized expression */
    if (type == null) return 0;

    if (type == ANY || this == ANY)
      return 0;
    else
      throw new TypeMismatch ();
  }

  /**
    * compare with type of expression
    *
    * @param e comparing expression 
    * @return if comparing type is same  0, if compatible 1, 
    *         otherwise -1;
    */
  int compare (Expression e) throws TypeMismatch { 
    if (e.type == null) return 0;

    int diff = compare(e.type);
    if (diff >= 0)
      return diff;

    boolean minus = false;
    if (e instanceof UnaryExp) {
      UnaryExp uexp = (UnaryExp) e;
      if (uexp.operand instanceof Literal) 
	e = uexp.operand;
      if (uexp.kind == sym.MINUS)
	minus = true;
    }

    if (e instanceof Literal && e.type == PrimitiveType.INT) {
      try {
	String sval = ((Literal) e).getValue ();
	int val;


	if (sval.startsWith ("0x") || sval.startsWith ("0X")) 
	  val = Integer.parseInt (sval.substring (2), 16);
	  
	else if (sval.startsWith ("0") && sval.length () > 1)
	  val = Integer.parseInt (sval.substring (1), 8);
	else
	  val = Integer.parseInt (sval);

	if (minus)
	  val *= -1;

	if (this == PrimitiveType.BYTE) {
	  if (val >= Byte.MIN_VALUE && val <= Byte.MAX_VALUE) return 1;
	} else if (this == PrimitiveType.SHORT || this == PrimitiveType.CHAR) {
	  if (val >= Short.MIN_VALUE && val <= Short.MAX_VALUE) return 1;
	} else { /* int */
	  if (val >= Integer.MIN_VALUE && val <= Integer.MAX_VALUE) return 1;
	}
      } catch (NumberFormatException ex) {
	ozc.catchException (ex);
      }
    }

    return diff;
  }

  /**
    * override
    */
  public String toString () { return name; }

  /**
    * access for name field 
    * 
    * @return name
    */
  String getName () { return name; }

  /**
    * get java class represention 
    */
  String toStringAsClass () { return java_class; }
}

/* EOF */

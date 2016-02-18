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
 * $Id: Variable.java,v 0.1 1997-07-15 18:50:38+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1997.7.10
 */

package JP.go.ipa.oz.compiler;

/**
  * A interface representing variable
  *
  * @see Identifier
  * @see AttributeAccesssExp
  */

interface Variable {
  /**
    * state value
    */
  static final int NULL = 0x00;
  static final int ASSIGNED_GREEN = 0x01;
  static final int ASSIGNED_MAYBE_RED = 0x02;
  static final int UNKNOWN = 0x03;

  /**
    * change to NULL
    */
  void changeNull ();

  /**
    * change to ASSIGNED_GREEN
    */
  void changeGreen ();

  /**
    * change to ASSIGNED_MAYBE_RED
    */
  void changeMaybeRed ();

  /**
    * change to UNKNOWN
    */
  void changeUnknown ();

  /**
    * check if state is NULL
    *
    * @return if so true, otherwise false
    */
  boolean isNull ();

  /**
    * check if state is ASSIGNED_GREEN
    *
    * @return if so true, otherwise false
    */
  boolean isGreen ();

  /**
    * check if state is ASSIGNED_MAYBE_RED
    *
    * @return if so true, otherwise false
    */
  boolean isMaybeRed ();

  /**
    * check if state is UNKNOWN
    *
    * @return if so true, otherwise false
    */
  boolean isUnknown ();

  /**
    * acceess for state 
    *
    * @return state value
    */
  public int getState ();

  /**
    * copy state
    *
    * @param id variable
    */
  void copyState (Variable id);
}
/* EOF */

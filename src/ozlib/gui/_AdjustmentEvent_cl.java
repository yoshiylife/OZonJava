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

// OZ Class Library (AWT)


package JP.go.ipa.oz.lib.standard;


/**
 * AdjustmentEvent implementation
 *
 * @version  $Id: _AdjustmentEvent_cl.java,v 1.11 1997/07/04 02:27:06 nito Exp $
 * @see      _ActionEvent_if
 * @see      _AWTEvent_cl
 */


public class _AdjustmentEvent_cl
  extends    JP.go.ipa.oz.lib.standard._AWTEvent_cl
  implements JP.go.ipa.oz.lib.standard._AdjustmentEvent_if
{

  public final int getADJUSTMENT_FIRST() throws Exception
    { return _static_getADJUSTMENT_FIRST(); }

  public static final int _static_getADJUSTMENT_FIRST() throws Exception
    { return java.awt.event.AdjustmentEvent.ADJUSTMENT_FIRST; }

  public final int getADJUSTMENT_LAST() throws Exception
    { return _static_getADJUSTMENT_LAST(); }

  public static final int _static_getADJUSTMENT_LAST() throws Exception
    { return java.awt.event.AdjustmentEvent.ADJUSTMENT_LAST; }

  public final int getADJUSTMENT_VALUE_CHANGED() throws Exception
    { return _static_getADJUSTMENT_VALUE_CHANGED(); }

  public static final int _static_getADJUSTMENT_VALUE_CHANGED() throws Exception
    { return java.awt.event.AdjustmentEvent.ADJUSTMENT_VALUE_CHANGED; }

  public final int getUNIT_INCREMENT() throws Exception
    { return _static_getUNIT_INCREMENT(); }

  public static final int _static_getUNIT_INCREMENT() throws Exception
    { return java.awt.event.AdjustmentEvent.UNIT_INCREMENT; }

  public final int getUNIT_DECREMENT() throws Exception
    { return _static_getUNIT_DECREMENT(); }

  public static final int _static_getUNIT_DECREMENT() throws Exception
    { return java.awt.event.AdjustmentEvent.UNIT_DECREMENT; }

  public final int getBLOCK_DECREMENT() throws Exception
    { return _static_getBLOCK_DECREMENT(); }

  public static final int _static_getBLOCK_DECREMENT() throws Exception
    { return java.awt.event.AdjustmentEvent.BLOCK_DECREMENT; }

  public final int getBLOCK_INCREMENT() throws Exception
    { return _static_getBLOCK_INCREMENT(); }

  public static final int _static_getBLOCK_INCREMENT() throws Exception
    { return java.awt.event.AdjustmentEvent.BLOCK_INCREMENT; }

  public final int getTRACK() throws Exception
    { return _static_getTRACK(); }

  public static final int _static_getTRACK() throws Exception
    { return java.awt.event.AdjustmentEvent.TRACK; }


  static final java.lang.String  CN = "AdjustmentEvent";


  //================================================== constructors

  _AdjustmentEvent_cl(_OzAdjustmentEvent ae)
    throws Exception
  {
    _body = ae;
  }

  public _AdjustmentEvent_cl()
    throws Exception
  {
  }
  

  //======================================== OZ constructor implementation

  public java.lang.Object _new_newAdjustmentEvent(_Adjustable_if source, int id,
				      int type, int value)
    throws Exception
  {
    java.awt.Adjustable  arg_source
      = (java.awt.Adjustable)(((_OzHoldable)source).java());
    _OzAdjustmentEvent  e = new _OzAdjustmentEvent(arg_source, id, type, value);
    e.bind(this);
    _body = e;
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public _String_if asString() //@
    throws Exception
  {
    java.lang.String  rv_tmp = CN.concat("[");
    // some infromation may be included !!!
    rv_tmp = rv_tmp.concat("]");
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Adjustable_if getAdjustable()
    throws Exception
  {
    checkSecureInvocation();
    _OzHoldable  rv_tmp
      = (_OzHoldable)(((java.awt.event.AdjustmentEvent)_body).getAdjustable());
    if (rv_tmp == null) return null;
    _Adjustable_if  rv = (_Adjustable_if)(rv_tmp.oz());
    return rv;
  }

  //------------------------------------------------------------------
  public int getValue()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.event.AdjustmentEvent)_body).getValue();
  }

  //------------------------------------------------------------------
  public int getAdjustmentType()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.event.AdjustmentEvent)_body).getAdjustmentType();
  }

  //------------------------------------------------------------------
  public _String_if paramString()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.event.AdjustmentEvent)_body).paramString();
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

}

// EoF


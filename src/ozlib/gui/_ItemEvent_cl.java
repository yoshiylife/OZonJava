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
 * ItemEvent implementation
 *
 * @version  $Id: _ItemEvent_cl.java,v 1.9 1997/07/04 02:27:08 nito Exp $
 * @see      _ItemEvent_if
 * @see      _AWTEvent_cl
 */


public class _ItemEvent_cl
  extends    JP.go.ipa.oz.lib.standard._AWTEvent_cl
  implements JP.go.ipa.oz.lib.standard._ItemEvent_if
{

  public final int getITEM_FIRST() throws Exception
    { return _static_getITEM_FIRST(); }

  public static final int _static_getITEM_FIRST() throws Exception
    { return java.awt.event.ItemEvent.ITEM_FIRST; }

  public final int getITEM_LAST() throws Exception
    { return _static_getITEM_LAST(); }

  public static final int _static_getITEM_LAST() throws Exception
    { return java.awt.event.ItemEvent.ITEM_LAST; }

  public final int getITEM_STATE_CHANGED() throws Exception
    { return _static_getITEM_STATE_CHANGED(); }

  public static final int _static_getITEM_STATE_CHANGED() throws Exception
    { return java.awt.event.ItemEvent.ITEM_STATE_CHANGED; }

  public final int getSELECTED() throws Exception
    { return _static_getSELECTED(); }

  public static final int _static_getSELECTED() throws Exception
    { return java.awt.event.ItemEvent.SELECTED; }

  public final int getDESELECTED() throws Exception
    { return _static_getDESELECTED(); }

  public static final int _static_getDESELECTED() throws Exception
    { return java.awt.event.ItemEvent.DESELECTED; }


  static final java.lang.String  CN = "ItemEvent";


  //================================================== constructors

  _ItemEvent_cl(_OzItemEvent ie)
    throws Exception
  {
    _body = ie;
  }

  public _ItemEvent_cl()
    throws Exception
  {
  }


  //================================================== OZ constructors

  public java.lang.Object _new_newItemEvent(_ItemSelectable_if source, int id,
				JP.go.ipa.oz.lang._Root_if item,
				int stateChange)
    throws Exception
  {
    java.awt.ItemSelectable  arg_source
      = (java.awt.ItemSelectable)(((_OzHoldable)source).java());
    _OzItemEvent  e = new _OzItemEvent(arg_source, id, item, stateChange);
    e.bind(this);
    _body = e;
    return this;
  }


  //================================================== OZ methods

  //------------------------------------------------------------------
  public _String_if asString() //@
    throws Exception
  {
    java.lang.String  rv_tmp = CN.concat("[");
    // some infromation may be included !!!
    rv_tmp = rv_tmp.concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public JP.go.ipa.oz.lang._Root_if getItem()
    throws Exception
  {
    return (JP.go.ipa.oz.lang._Root_if)(((java.awt.event.ItemEvent)_body).getItem());
  }

  //------------------------------------------------------------------
  public _ItemSelectable_if getItemSelectable()
    throws Exception
  {
    _OzHoldable  rv_tmp= (_OzHoldable)(((java.awt.event.ItemEvent)_body).getItemSelectable());
    if (rv_tmp == null) return null;
    _ItemSelectable_if  rv = (_ItemSelectable_if)(rv_tmp.oz());
    return rv;
  }

  //------------------------------------------------------------------
  public int getStateChange()
    throws Exception
  {
    return ((java.awt.event.ItemEvent)_body).getStateChange();
  }

  //------------------------------------------------------------------
  public _String_if paramString()
    throws Exception
  {
    java.lang.String  rv_tmp = ((java.awt.event.ItemEvent)_body).paramString();
    if (rv_tmp == null) return null;
    _String_cl  rv = new _String_cl(rv_tmp);
    return rv;
  }

}

// EoF


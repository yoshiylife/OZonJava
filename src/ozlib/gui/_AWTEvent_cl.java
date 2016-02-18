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
 * AWTEvent implementation
 *
 * @version  $Id: _AWTEvent_cl.java,v 1.12 1997/09/17 04:18:00 nito Exp $
 * @see      _AWTEvent_cl
 * @see      _EventObject_cl
 */


public abstract class _AWTEvent_cl
  extends    JP.go.ipa.oz.lib.standard._EventObject_cl
  implements JP.go.ipa.oz.lib.standard._AWTEvent_if
{
  public final long getCOMPONENT_EVENT_MASK() throws Exception
    { return _static_getCOMPONENT_EVENT_MASK(); }

  public static final long _static_getCOMPONENT_EVENT_MASK() throws Exception
    { return java.awt.AWTEvent.COMPONENT_EVENT_MASK; }

  public final long getCONTAINER_EVENT_MASK() throws Exception
    { return _static_getCONTAINER_EVENT_MASK(); }

  public static final long _static_getCONTAINER_EVENT_MASK() throws Exception
    { return java.awt.AWTEvent.CONTAINER_EVENT_MASK; }

  public final long getFOCUS_EVENT_MASK() throws Exception
    { return _static_getFOCUS_EVENT_MASK(); }

  public static final long _static_getFOCUS_EVENT_MASK() throws Exception
    { return java.awt.AWTEvent.FOCUS_EVENT_MASK; }

  public final long getKEY_EVENT_MASK() throws Exception
    { return _static_getKEY_EVENT_MASK(); }

  public static final long _static_getKEY_EVENT_MASK() throws Exception
    { return java.awt.AWTEvent.KEY_EVENT_MASK; }

  public final long getMOUSE_EVENT_MASK() throws Exception
    { return _static_getMOUSE_EVENT_MASK(); }

  public static final long _static_getMOUSE_EVENT_MASK() throws Exception
    { return java.awt.AWTEvent.MOUSE_EVENT_MASK; }

  public final long getMOUSE_MOTION_EVENT_MASK() throws Exception
    { return _static_getMOUSE_MOTION_EVENT_MASK(); }

  public static final long _static_getMOUSE_MOTION_EVENT_MASK() throws Exception
    { return java.awt.AWTEvent.MOUSE_MOTION_EVENT_MASK; }

  public final long getWINDOW_EVENT_MASK() throws Exception
    { return _static_getWINDOW_EVENT_MASK(); }

  public static final long _static_getWINDOW_EVENT_MASK() throws Exception
    { return java.awt.AWTEvent.WINDOW_EVENT_MASK; }

  public final long getACTION_EVENT_MASK() throws Exception
    { return _static_getACTION_EVENT_MASK(); }

  public static final long _static_getACTION_EVENT_MASK() throws Exception
    { return java.awt.AWTEvent.ACTION_EVENT_MASK; }

  public final long getADJUSTMENT_EVENT_MASK() throws Exception
    { return _static_getADJUSTMENT_EVENT_MASK(); }

  public static final long _static_getADJUSTMENT_EVENT_MASK() throws Exception
    { return java.awt.AWTEvent.ADJUSTMENT_EVENT_MASK; }

  public final long getITEM_EVENT_MASK() throws Exception
    { return _static_getITEM_EVENT_MASK(); }

  public static final long _static_getITEM_EVENT_MASK() throws Exception
    { return java.awt.AWTEvent.ITEM_EVENT_MASK; }

  public final long getTEXT_EVENT_MASK() throws Exception
    { return _static_getTEXT_EVENT_MASK(); }

  public static final long _static_getTEXT_EVENT_MASK() throws Exception
    { return java.awt.AWTEvent.TEXT_EVENT_MASK; }

  public final int getRESERVED_ID_MAX() throws Exception
    { return _static_getRESERVED_ID_MAX(); }

  public static final int _static_getRESERVED_ID_MAX() throws Exception
    { return java.awt.AWTEvent.RESERVED_ID_MAX; }



  //================================================== constructors

  protected _AWTEvent_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public java.lang.Object _new_newAWTEvent(_Event_if event)
    throws Exception
  {
    return this;
  }

  public java.lang.Object _new_newAWTEvent(JP.go.ipa.oz.lang._Root_if source, int id)
    throws Exception
  {
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public int getID()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.AWTEvent)_body).getID();
  }

  //------------------------------------------------------------------
  public _String_if paramString()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.AWTEvent)_body).paramString();
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  public JP.go.ipa.oz.lang._Root_if getSource()
    throws Exception
  {
    _OzHoldable  j;
    checkSecureInvocation();
    j = (_OzHoldable)((java.util.EventObject)_body).getSource();
    return (JP.go.ipa.oz.lang._Root_if)(j.oz());
  }

  public _String_if asString() //@
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = CN.concat("[source=")
      .concat(((_String_cl)(getSource().asString()))._body)
      .concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

}

// EoF


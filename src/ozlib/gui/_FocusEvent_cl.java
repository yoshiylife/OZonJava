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
 * FocusEvent implementation
 *
 * @version  $Id: _FocusEvent_cl.java,v 1.10 1997/07/04 02:27:07 nito Exp $
 * @see      _FocusEvent_if
 * @see      _ComponentEvent_cl
 */


public class _FocusEvent_cl
  extends    JP.go.ipa.oz.lib.standard._ComponentEvent_cl
  implements JP.go.ipa.oz.lib.standard._FocusEvent_if
{

  public final int getFOCUS_FIRST() throws Exception
    { return _static_getFOCUS_FIRST(); }

  public static final int _static_getFOCUS_FIRST() throws Exception
    { return java.awt.event.FocusEvent.FOCUS_FIRST; }

  public final int getFOCUS_LAST() throws Exception
    { return _static_getFOCUS_LAST(); }

  public static final int _static_getFOCUS_LAST() throws Exception
    { return java.awt.event.FocusEvent.FOCUS_LAST; }

  public final int getFOCUS_GAINED() throws Exception
    { return _static_getFOCUS_GAINED(); }

  public static final int _static_getFOCUS_GAINED() throws Exception
    { return java.awt.event.FocusEvent.FOCUS_GAINED; }

  public final int getFOCUS_LOST() throws Exception
    { return _static_getFOCUS_LOST(); }

  public static final int _static_getFOCUS_LOST() throws Exception
    { return java.awt.event.FocusEvent.FOCUS_LOST; }


  static final java.lang.String  CN = "FocusEvent";


  //================================================== constructors

  _FocusEvent_cl(_OzFocusEvent fe)
    throws Exception
  {
    _body = fe;
  }

  public _FocusEvent_cl()
    throws Exception
  {
  }


  //================================================== OZ constructors

  //------------------------------------------------------------------
  public java.lang.Object _new_newFocusEvent(_Component_if source, int id, boolean temporary)
    throws Exception
  {
    java.awt.Component  arg_source = (java.awt.Component)(((_Component_cl)source)._body);
    _OzFocusEvent  e = new _OzFocusEvent(arg_source, id, temporary);
    e.bind(this);
    _body = e;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newFocusEvent(_Component_if source, int id)
    throws Exception
  {
    java.awt.Component  arg_source = (java.awt.Component)(((_Component_cl)source)._body);
    _OzFocusEvent  e = new _OzFocusEvent(arg_source, id);
    e.bind(this);
    _body = e;
    return this;
  }


  //======================================== OZ method implmentation

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
  public boolean isTemporary()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.event.FocusEvent)_body).isTemporary();
  }

  //------------------------------------------------------------------
  public _String_if paramString()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.event.ContainerEvent)_body).paramString();
    if (rv_tmp == null) return null;
    _String_cl  rv = new _String_cl(rv_tmp);
    return rv;
  }

}

// EoF


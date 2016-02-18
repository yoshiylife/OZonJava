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
 * PaintEvent implementation
 *
 * @version  $Id: _PaintEvent_cl.java,v 1.10 1997/07/04 02:27:09 nito Exp $
 * @see      _PaintEvent_if
 * @see      _ComponentEvent_cl
 */


public class _PaintEvent_cl
  extends JP.go.ipa.oz.lib.standard._ComponentEvent_cl
  implements JP.go.ipa.oz.lib.standard._PaintEvent_if
{

  public final int getPAINT_FIRST() throws Exception
    { return _static_getPAINT_FIRST(); }

  public static final int _static_getPAINT_FIRST() throws Exception
    { return java.awt.event.PaintEvent.PAINT_FIRST; }

  public final int getPAINT_LAST() throws Exception
    { return _static_getPAINT_LAST(); }

  public static final int _static_getPAINT_LAST() throws Exception
    { return java.awt.event.PaintEvent.PAINT_LAST; }

  public final int getPAINT() throws Exception
    { return _static_getPAINT(); }

  public static final int _static_getPAINT() throws Exception
    { return java.awt.event.PaintEvent.PAINT; }

  public final int getUPDATE() throws Exception
    { return _static_getUPDATE(); }

  public static final int _static_getUPDATE() throws Exception
    { return java.awt.event.PaintEvent.UPDATE; }



  static final java.lang.String  CN = "PaintEvent";


  //================================================== constructors

  _PaintEvent_cl(_OzPaintEvent e)
    throws Exception
  {
    _body = e;
  }

  public _PaintEvent_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public java.lang.Object _new_newPaintEvent(_Component_if source, int id, _Rectangle_if updateRect)
    throws Exception
  {
    java.awt.Component  arg_source = (java.awt.Component)(((_Component_cl)source)._body);
    java.awt.Rectangle  arg_updateRect = ((_Rectangle_cl)updateRect)._body;
    _OzPaintEvent  e = new _OzPaintEvent(arg_source, id, arg_updateRect);
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
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Rectangle_if getUpdateRect()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Rectangle  rv_tmp = ((java.awt.event.PaintEvent)_body).getUpdateRect();
    if (rv_tmp == null) return null;
    _Rectangle_if  rv = new _Rectangle_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public void setUpdateRect(_Rectangle_if updateRect)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Rectangle  arg_updateRect = ((_Rectangle_cl)updateRect)._body;
    ((java.awt.event.PaintEvent)_body).setUpdateRect(arg_updateRect);
  }

  //------------------------------------------------------------------
  public _String_if paramString()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.event.PaintEvent)_body).paramString();
    if (rv_tmp == null) return null;
    _String_cl  rv = new _String_cl(rv_tmp);
    return rv;
  }

}

// EoF


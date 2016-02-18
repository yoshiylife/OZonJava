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
 * _OzCanvas
 *
 * @version  $Id: _OzCanvas.java,v 1.7 1997/08/21 05:18:53 nito Exp $
 * @see      _Canvas_cl
 */


public final class _OzCanvas
  extends    java.awt.Canvas
  implements JP.go.ipa.oz.lib.standard._OzHoldable
{
  JP.go.ipa.oz.lang._Root_if  _oz;
  java.lang.Object              _java;
  _PaintDispatchingQueue_if paintQueue;

  static final int _PAINT_  = 0;
  static final int _UPDATE_ = 1;
  //================================================== constructors

  public _OzCanvas(_PaintDispatchingQueue_if queue)
    throws Exception
  {
    super();
    paintQueue = queue;
  }

  //================================================== methods
  public final void paint(java.awt.Graphics g)
  {
    try {
      _Graphics_if graphics = new _Graphics_cl(g.create());
      _Component_if component = (_Component_if)_oz;
      _PaintUnit_if unit = null;
      unit = (_PaintUnit_cl)
        (new _PaintUnit_cl()._new_create(component, graphics, _PAINT_));
      paintQueue.post(unit);
    } catch (Exception ex) {
    }
  }

  public final void update(java.awt.Graphics g)
  {
    try {
      _Graphics_if graphics = new _Graphics_cl(g.create());
      _Component_if component = (_Component_if)_oz;
      _PaintUnit_if unit = null;
      unit = (_PaintUnit_cl)
        (new _PaintUnit_cl()._new_create(component, graphics, _UPDATE_));
      paintQueue.post(unit);
    } catch (Exception ex) {
    }
  }


  public JP.go.ipa.oz.lang._Root_if oz()
    throws Exception
  {
    return _oz;
  }

  public java.lang.Object java()
    throws Exception
  {
    return _java;
  }

  public void bind(JP.go.ipa.oz.lang._Root_if ozobj)
    throws Exception
  {
    _oz = ozobj;
    _java = this;
  }

}

// EoF


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
 * Canvas implementation
 *
 * @version  $Id: _Canvas_cl.java,v 1.12 1997/08/20 05:18:52 nito Exp $
 * @see      _Component_cl
 * @see      _Canvas_if
 */


public class _Canvas_cl
  extends JP.go.ipa.oz.lib.standard._Component_cl
  implements JP.go.ipa.oz.lib.standard._Canvas_if
{

  final static java.lang.String  CN = "Canvas";
  _PaintDispatchingQueue_if paintDispatchingQueue;

  static final int _PAINT_ = 0;
  static final int _UPDATE_ = 1;
  //================================================== constructors

  _Canvas_cl(_OzCanvas c)
    throws Exception
  {
    _body = c;
  }

  public _Canvas_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public java.lang.Object _new_newCanvas(_PaintDispatchingQueue_if queue)
    throws Exception
  {
    checkSecureInvocation();
    paintDispatchingQueue = queue;
    _OzCanvas c = new _OzCanvas(queue);
    c.bind(this);
    _body = c;
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public void addNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Canvas)_body).addNotify();
  }

  //------------------------------------------------------------------
  public _String_if asString()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  dim = ((java.awt.Canvas)_body).getSize();
    java.lang.String  rv_tmp = CN.concat("[size=")
      .concat(java.lang.Integer.toString(dim.width)).concat("x")
      .concat(java.lang.Integer.toString(dim.height)).concat("]");
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public void paint(_Graphics_if g)
    throws Exception
  {
    // define with subclassing.
  }

  public final void dispatch(_Graphics_if g, int type) throws Exception
  {
    checkSecureInvocation();
    if      (type == _PAINT_)  paint(g);
    else if (type == _UPDATE_) update(g);
  }

  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((_String_cl)asString())._body;
//  }

}

// EoF


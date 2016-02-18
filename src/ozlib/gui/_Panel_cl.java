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
 * Panel implementation
 *
 * The default layout for Panel is FlowLayout.
 *
 * @version  $Id: _Panel_cl.java,v 1.10 1997/06/18 12:58:15 nito Exp $
 * @see      _Panel_if
 * @see      _Container_cl
 */


public class _Panel_cl
  extends    JP.go.ipa.oz.lib.standard._Container_cl
  implements JP.go.ipa.oz.lib.standard._Panel_if
{

  static final java.lang.String  CN = "Panel";


  //================================================== constructors

  _Panel_cl(_OzPanel p)
    throws Exception
  {
    _body = p;
  }

  public _Panel_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  //------------------------------------------------------------------
  public java.lang.Object _new_newPanel()
    throws Exception
  {
    _OzPanel  p = new _OzPanel();
    p.bind(this);
    _body = p;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newPanel(_LayoutManager_if layout)
    throws Exception
  {
    java.awt.LayoutManager  arg_layout = (java.awt.LayoutManager)(layout.java());
    _OzPanel  p = new _OzPanel(arg_layout);
    p.bind(this);
    _body = p;
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public void addNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Panel)_body).addNotify();
  }

  //------------------------------------------------------------------
  public _String_if asString()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  dim = ((java.awt.Panel)_body).getSize();
    java.lang.String  rv_tmp = CN.concat("[size=")
      .concat(java.lang.Integer.toString(dim.width)).concat("x")
      .concat(java.lang.Integer.toString(dim.height)).concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }


  //================================================== support methods

//  public java.lang.String toString()
//    throws Exception
//  {
//    return ((_String_cl)asString())._body;
//  }

}

// EoF


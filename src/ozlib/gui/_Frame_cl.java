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

// OZ Clsss Library (AWT)


package JP.go.ipa.oz.lib.standard;


/**
 * Frame implementation
 *
 * @version  $Id: _Frame_cl.java,v 1.12 1997/07/04 02:27:08 nito Exp $
 * @see      _Frame_if
 * @see      _Window_cl
 */


public class _Frame_cl
  extends    JP.go.ipa.oz.lib.standard._Window_cl
  implements JP.go.ipa.oz.lib.standard._Frame_if
{

  static final java.lang.String  CN = "Frame";


  //================================================== constructors

  _Frame_cl(_OzFrame f)
    throws Exception
  {
    _body = f;
  }

  public _Frame_cl()
    throws Exception
  {
  }
      

  //======================================== OZ constructor implementation

  //------------------------------------------------------------------
  public java.lang.Object _new_newFrame()
    throws Exception
  {
    _OzFrame  f = new _OzFrame();
    f.bind(this);
    _body = f;

    // set the default layout manager "BorderLayout"
    _BorderLayout_if lay = (_BorderLayout_if)new _BorderLayout_cl()._new_newBorderLayout();
    setLayout(lay);
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newFrame(_String_if title)
    throws Exception
  {
    java.lang.String  arg_title = ((_String_cl)title)._body;
    _OzFrame  f = new _OzFrame(arg_title);
    f.bind(this);
    _body = f;

    // set the default layout manager "BorderLayout"
    _BorderLayout_if lay = (_BorderLayout_if)new _BorderLayout_cl()._new_newBorderLayout();
    setLayout(lay);
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public void addNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Frame)_body).addNotify();
  }

  //------------------------------------------------------------------
  public synchronized _String_if asString()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  dim = ((java.awt.Frame)_body).getSize();
    java.lang.String  rv_tmp = CN.concat("[size=")
      .concat(java.lang.Integer.toString(dim.width)).concat("x")
      .concat(java.lang.Integer.toString(dim.height)).concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public void dispose() //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Frame)_body).dispose();
  }

  //public int getCursorType() {} //DEPRECATED ... Component#getCursor()

  //------------------------------------------------------------------
  //*public _Image_if getIconImage() {}

  //------------------------------------------------------------------
  public _MenuBar_if getMenuBar()
    throws Exception
  {
    checkSecureInvocation();
    _OzHoldable  rv_tmp = (_OzHoldable)(((java.awt.Frame)_body).getMenuBar());
    if (rv_tmp == null) return null;
    _MenuBar_if  rv = (_MenuBar_if)(rv_tmp.oz());
    return rv;
  }

  //------------------------------------------------------------------
  public _String_if getTitle()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.Frame)_body).getTitle();
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public boolean isResizable()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Frame)_body).isResizable();
  }

  //------------------------------------------------------------------
  public void remove(_MenuComponent_if m) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.MenuComponent  arg_m = (java.awt.MenuComponent)(((_MenuComponent_cl)m)._body);
    ((java.awt.Frame)_body).remove(arg_m);
  }

  //public void setCursor(int cursorType) {} //synchronized  //DEPRECATED ...Component#setCursor()

  //------------------------------------------------------------------
  public void setIconImage(_Image_if image) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Image  arg = (java.awt.Image)(((_Image_cl)image)._body);
    ((java.awt.Frame)_body).setIconImage(arg);
  }


  //------------------------------------------------------------------
  public void setMenuBar(_MenuBar_if mb) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.MenuBar  arg_mb = (java.awt.MenuBar)(((_MenuBar_cl)mb)._body);
    ((java.awt.Frame)_body).setMenuBar(arg_mb);
  }

  //------------------------------------------------------------------
  public void setResizable(boolean resizable) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Frame)_body).setResizable(resizable);
  }

  //------------------------------------------------------------------
  public void setTitle(_String_if title) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_title = ((_String_cl)title)._body;
    ((java.awt.Frame)_body).setTitle(arg_title);
  }


  //================================================== protected methods
  //protected String paramString() {}


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((_String_cl)asString())._body;
//  }

}

// EoF


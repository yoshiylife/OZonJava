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


/**
 * Dialog implementation
 *
 * @version  $Id: _Dialog_cl.java,v 1.9 1997/07/04 02:27:07 nito Exp $
 * @see      _Dialog_if
 * @see      _Window_cl
 */


package JP.go.ipa.oz.lib.standard;


public class _Dialog_cl
  extends JP.go.ipa.oz.lib.standard._Window_cl
  implements JP.go.ipa.oz.lib.standard._Dialog_if
{

  //================================================== constructors

  _Dialog_cl(_OzDialog d)
    throws Exception
  {
    _body = d;
  }

  public _Dialog_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implmentation

  //------------------------------------------------------------------
  public java.lang.Object _new_newDialog(_Frame_if parent)
    throws Exception
  {
    java.awt.Frame  arg_parent = (java.awt.Frame)(((_Frame_cl)parent)._body);
    _OzDialog  d = new _OzDialog(arg_parent);
    d.bind(this);
    _body = d;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newDialog(_Frame_if parent, boolean modal)
    throws Exception
  {
    java.awt.Frame  arg_parent = (java.awt.Frame)(((_Frame_cl)parent)._body);
    _OzDialog  d = new _OzDialog(arg_parent, modal);
    d.bind(this);
    _body = d;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newDialog(_Frame_if parent, _String_if title)
    throws Exception
  {
    java.awt.Frame  arg_parent = (java.awt.Frame)(((_Frame_cl)parent)._body);
    java.lang.String  arg_title = ((_String_cl)title)._body;
    _OzDialog  d = new _OzDialog(arg_parent, arg_title);
    d.bind(this);
    _body = d;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newDialog(_Frame_if parent, _String_if title, boolean modal)
    throws Exception
  {
    java.awt.Frame  arg_parent = (java.awt.Frame)(((_Frame_cl)parent)._body);
    java.lang.String  arg_title = ((_String_cl)title)._body;
    _OzDialog  d = new _OzDialog(arg_parent, arg_title, modal);
    d.bind(this);
    _body = d;
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public void addNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Dialog)_body).addNotify();
  }

  //------------------------------------------------------------------
  public _String_if asString() //@
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  dim = ((java.awt.Dialog)_body).getSize();
    java.lang.String  rv_tmp = CN.concat("[size=")
      .concat(java.lang.Integer.toString(dim.width)).concat("x")
      .concat(java.lang.Integer.toString(dim.height)).concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _String_if getTitle()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.Dialog)_body).getTitle();
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public boolean isModal()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Dialog)_body).isModal();
  }

  //------------------------------------------------------------------
  public boolean isResizable()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Dialog)_body).isResizable();
  }

  //------------------------------------------------------------------
  public void setModal(boolean b)
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Dialog)_body).setModal(b);
  }

  //------------------------------------------------------------------
  public void setResizable(boolean resizable) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Dialog)_body).setResizable(resizable);
  }

  //------------------------------------------------------------------
  public void setTitle(_String_if title) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_title = ((_String_cl)title)._body;
    ((java.awt.Dialog)_body).setTitle(arg_title);
  }

  //------------------------------------------------------------------
  public void show()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Dialog)_body).show();
  }


  //================================================== protected methods
  //protected String paramString()


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((_String_cl)asString())._body;
//  }

}

// EoF


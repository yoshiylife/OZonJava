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
 * PopupMenu implementation
 *
 * @version  $Id: _PopupMenu_cl.java,v 1.10 1997/06/24 07:11:17 nito Exp $
 * @see      _PopupMenu_if
 * @see      _Menu_cl
 */


public class _PopupMenu_cl
  extends    JP.go.ipa.oz.lib.standard._Menu_cl
  implements JP.go.ipa.oz.lib.standard._PopupMenu_if
{

  static final java.lang.String  CN = "PopupMenu";


  //================================================== constructors

  _PopupMenu_cl(_OzPopupMenu pm)
    throws Exception
  {
    _body = pm;
  }

  public _PopupMenu_cl()
    throws Exception
  {
  }

  //================================================== OZ constructors

  //------------------------------------------------------------------
  public java.lang.Object _new_newPopupMenu()
    throws Exception
  {
    _OzPopupMenu  pm = new _OzPopupMenu();
    pm.bind(this);
    _body = pm;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newPopupMenu(_String_if label)
    throws Exception
  {
    java.lang.String  arg_label = ((_String_cl)label)._body;
    _OzPopupMenu  pm = new _OzPopupMenu(arg_label);
    pm.bind(this);
    _body = pm;
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public void addNotify() //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.PopupMenu)_body).addNotify();
  }

  //------------------------------------------------------------------
  public _String_if asString() //@
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = CN.concat("[label=")
      .concat(((java.awt.PopupMenu)_body).getLabel())
      .concat(",count=").concat(java.lang.Integer.toString(getItemCount()))
      .concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public void show(_Component_if origin, int x, int y)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Component  arg_origin
      = (java.awt.Component)(((_Component_cl)origin)._body);
    ((java.awt.PopupMenu)_body).show(arg_origin, x, y);
  }


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((java.awt.MenuComponent)_body).toString();
//  }

}

// EoF


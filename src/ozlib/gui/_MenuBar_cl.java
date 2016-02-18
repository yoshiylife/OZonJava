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
 * MenuBar implementation
 *
 * @version  $Id: _MenuBar_cl.java,v 1.12 1997/07/04 02:27:08 nito Exp $
 * @see      _MenuBar_if
 * @see      _MenuComponent_cl
 */


public class _MenuBar_cl
  extends    JP.go.ipa.oz.lib.standard._MenuComponent_cl
  implements JP.go.ipa.oz.lib.standard._MenuBar_if
{

  static final java.lang.String  CN = "MenuBar";


  //================================================== constructors

  _MenuBar_cl(_OzMenuBar mb)
    throws Exception
  {
    _body = mb;
  }

  public _MenuBar_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public java.lang.Object _new_newMenuBar()
    throws Exception
  {
    _OzMenuBar  mb = new _OzMenuBar();
    mb.bind(this);
    _body = mb;
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public _Menu_if add(_Menu_if m)  //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Menu  arg_m = (java.awt.Menu)(((_Menu_cl)m)._body);
    ((java.awt.MenuBar)_body).add(arg_m);
    return m;
  }

  //------------------------------------------------------------------
  public void addNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.MenuBar)_body).addNotify();
  }

  //------------------------------------------------------------------
  public _String_if asString() //@
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = CN.concat("[").concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //public int countMenus(){} //DEPRECATED

  //------------------------------------------------------------------
  public void deleteShortcut(_MenuShortcut_if s)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.MenuShortcut  arg_s = ((_MenuShortcut_cl)s)._body;
    ((java.awt.MenuBar)_body).deleteShortcut(arg_s);
  }

  //------------------------------------------------------------------
  public _Menu_if getHelpMenu()
    throws Exception
  {
    checkSecureInvocation();
    _OzHoldable  rv_tmp = (_OzHoldable)(((java.awt.MenuBar)_body).getHelpMenu());
    if (rv_tmp == null) return null;
    _Menu_if  rv = (_Menu_if)(rv_tmp.oz());
    return rv;
  }

  //------------------------------------------------------------------
  public _Menu_if getMenu(int i)
    throws Exception
  {
    checkSecureInvocation();
    _OzHoldable  rv_tmp = (_OzHoldable)(((java.awt.MenuBar)_body).getMenu(i));
    if (rv_tmp == null) return null;
    _Menu_if  rv = (_Menu_if)(rv_tmp.oz());
    return rv;
  }

  //------------------------------------------------------------------
  public int getMenuCount()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.MenuBar)_body).getMenuCount();
  }

  //------------------------------------------------------------------
  public _MenuItem_if getShortcutMenuItem(_MenuShortcut_if s)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.MenuShortcut  arg_s = ((_MenuShortcut_cl)s)._body;
    _OzHoldable  rv_tmp = (_OzHoldable)(((java.awt.MenuBar)_body).getShortcutMenuItem(arg_s));
    if (rv_tmp == null) return null;
    _MenuItem_if  rv = (_MenuItem_if)(rv_tmp.oz());
    return rv;
  }

  //------------------------------------------------------------------
  public void remove(int index)  //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.MenuBar)_body).remove(index);
  }

  //------------------------------------------------------------------
  public void remove(_MenuComponent_if m)  //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.MenuComponent  arg_m = (java.awt.MenuComponent)(((_MenuComponent_cl)m)._body);
    ((java.awt.MenuBar)_body).remove(arg_m);
  }

  //------------------------------------------------------------------
  public void removeNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.MenuBar)_body).removeNotify();
  }

  //------------------------------------------------------------------
  public void setHelpMenu(_Menu_if m)  //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Menu  arg_m = (java.awt.Menu)(((_Menu_cl)m)._body);
    ((java.awt.MenuBar)_body).setHelpMenu(arg_m);
  }

  //------------------------------------------------------------------
  public _Iterator_if shortcuts()  //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.util.Enumeration enu = ((java.awt.MenuBar)_body).shortcuts();
    _Set_if set = (_Set_if)(new _Set_cl()._new_create());
    while (enu.hasMoreElements() == true) {
      set.add(new _MenuShortcut_cl((java.awt.MenuShortcut)(enu.nextElement())));
    }
    return set.iterator();
  }



  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((java.awt.MenuComponent)_body).toString();
//  }

}

// EoF


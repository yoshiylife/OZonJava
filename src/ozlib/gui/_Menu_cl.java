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
 * Menu implementation
 *
 * @version  $Id: _Menu_cl.java,v 1.12 1997/07/04 02:27:09 nito Exp $
 * @see      _Menu_if
 * @see      _MenuItem_if
 */


public class _Menu_cl
  extends    JP.go.ipa.oz.lib.standard._MenuItem_cl
  implements JP.go.ipa.oz.lib.standard._Menu_if
{

  static final java.lang.String  CN = "Menu";


  //================================================== constructors

  _Menu_cl(_OzMenu m)
    throws Exception
  {
    _body = m;
  }

  public _Menu_cl()
    throws Exception
  {
  }

  //======================================== OZ constructor implementation

  //------------------------------------------------------------------
  public java.lang.Object _new_newMenu()
    throws Exception
  {
    _OzMenu  m = new _OzMenu();
    m.bind(this);
    _body = m;
    return this;
  }
      
  //------------------------------------------------------------------
  public java.lang.Object _new_newMenu(_String_if label)
    throws Exception
  {
    java.lang.String  arg_label = ((_String_cl)label)._body;
    _OzMenu  m = new _OzMenu(arg_label);
    m.bind(this);
    _body = m;
    return this;
  }
      
  //------------------------------------------------------------------
  //@public java.lang.Object _new_newMenu(_String_if label, boolean tearOff);

  public java.lang.Object _new_newTearOffMenu(_String_if label) //@
    throws Exception
  {
    java.lang.String  arg_label = ((_String_cl)label)._body;
    _OzMenu  m = new _OzMenu(arg_label, true);
    m.bind(this);
    _body = m;
    return this;
  }
      

  //========================================  OZ method implementation

  //------------------------------------------------------------------
  public _MenuItem_if add(_MenuItem_if mi)  //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.MenuItem  arg_mi = (java.awt.MenuItem)(((_MenuItem_cl)mi)._body);
    ((java.awt.Menu)_body).add(arg_mi);
    return mi;
  }

  //------------------------------------------------------------------
  public void add(_String_if label)
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_label = ((_String_cl)label)._body;
    ((java.awt.Menu)_body).add(arg_label);
  }

  //------------------------------------------------------------------
  public void addNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Menu)_body).addNotify();
  }

  //------------------------------------------------------------------
  public void addSeparator()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Menu)_body).addSeparator();
  }

  //------------------------------------------------------------------
  public _String_if asString() //@
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = CN.concat("[label=")
      .concat(((java.awt.Menu)_body).getLabel())
      .concat(",count=").concat(java.lang.Integer.toString(getItemCount()))
      .concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //public int countItems(){} //DEPRECATED

  //------------------------------------------------------------------
  public void insert(_MenuItem_if mi, int index) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.MenuItem  arg_mi = ((java.awt.MenuItem)((_MenuItem_cl)mi)._body);
    ((java.awt.Menu)_body).insert(arg_mi, index);
  }

  //------------------------------------------------------------------
  public void insert(_String_if label, int index)
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_label = ((_String_cl)label)._body;
    ((java.awt.Menu)_body).insert(arg_label, index);
  }

  //------------------------------------------------------------------
  public void insertSeparator(int index)
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Menu)_body).insertSeparator(index);
  }

  //------------------------------------------------------------------
  public boolean isTearOff()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Menu)_body).isTearOff();
  }

  //------------------------------------------------------------------
  public _MenuItem_if getItem(int index)
    throws Exception
  {
    checkSecureInvocation();
    _OzHoldable  rv_tmp = (_OzHoldable)(((java.awt.Menu)_body).getItem(index));
    if (rv_tmp == null) return null;
    _MenuItem_if  rv = (_MenuItem_if)(rv_tmp.oz());
    return rv;
  }

  //------------------------------------------------------------------
  public int getItemCount()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Menu)_body).getItemCount();
  }

  //------------------------------------------------------------------
  public _String_if paramString()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.Menu)_body).paramString();
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public void remove(int index)  //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Menu)_body).remove(index);
  }

  //------------------------------------------------------------------
  public void remove(_MenuComponent_if item)  //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.MenuComponent  arg_item = (java.awt.MenuComponent)(((_MenuComponent_cl)item)._body);
    ((java.awt.Menu)_body).remove(arg_item);
  }

  //------------------------------------------------------------------
  public void removeAll()  // synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Menu)_body).removeAll();
  }

  //------------------------------------------------------------------
  public void removeNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Menu)_body).removeNotify();
  }


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((java.awt.MenuComponent)_body).toString();
//  }

}

// EoF


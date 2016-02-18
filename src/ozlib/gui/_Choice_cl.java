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
 * Choice implementation
 *
 * @version  $Id: _Choice_cl.java,v 1.12 1997/07/04 02:27:07 nito Exp $
 * @see      _Component_if
 * @see      _Choice_cl
 */


public class _Choice_cl
  extends    JP.go.ipa.oz.lib.standard._Component_cl
  implements JP.go.ipa.oz.lib.standard._Choice_if
{

  static final java.lang.String  CN = "Choice";


  //================================================== constructors

  _Choice_cl(_OzChoice c)
    throws Exception
  {
    _body = c;
  }

  public _Choice_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public java.lang.Object _new_newChoice()
    throws Exception
  {
    _OzChoice  c = new _OzChoice();
    c.bind(this);
    _body = c;
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public void add(_String_if item) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_item = ((_String_cl)item)._body;
    ((java.awt.Choice)_body).add(arg_item);
  }

  //------------------------------------------------------------------
  public void addItem(_String_if item) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_item = ((_String_cl)item)._body;
    ((java.awt.Choice)_body).addItem(arg_item);
  }

  //------------------------------------------------------------------
  public void addItemListener(_ItemListener_if l)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.ItemListener  arg_l = (java.awt.event.ItemListener)(((_ItemListener_cl)l)._body);
    ((java.awt.Choice)_body).addItemListener(arg_l);
  }

  //------------------------------------------------------------------
  public void addNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Choice)_body).addNotify();
  }

  //------------------------------------------------------------------
  public synchronized _String_if asString()
    throws Exception
  {
    checkSecureInvocation();
    int  count = getItemCount();
    java.lang.String  rv_tmp = CN.concat("[count=")
      .concat(java.lang.Integer.toString(count));
    // item-strings
    for (int i = 0; i < count; i++) {
      rv_tmp = rv_tmp.concat(",").concat(((java.awt.Choice)_body).getItem(i));
    }
    rv_tmp.concat("]");
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //public int countItems() //DEPRECATED

  //------------------------------------------------------------------
  public _String_if getItem(int index)
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.Choice)_body).getItem(index);
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public int getItemCount()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Choice)_body).getItemCount();
  }

  //------------------------------------------------------------------
  public int getSelectedIndex()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Choice)_body).getSelectedIndex();
  }

  //------------------------------------------------------------------
  public _String_if getSelectedItem() //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.Choice)_body).getSelectedItem();
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Collection_if getSelectedObjects() //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.Object[]  rv_tmp
      = ((java.awt.Choice)_body).getSelectedObjects();
    _Array_if  objects = null;
    if (rv_tmp != null && 0 < rv_tmp.length) {
      objects = (_Array_if)new _Array_cl()._new_create(rv_tmp.length);
      for (int i = 0; i < rv_tmp.length; i++) {
        objects.putAt(i, new _String_cl((java.lang.String)(rv_tmp[i])));
      }
    }
    return objects;
  }

  //------------------------------------------------------------------
  public void insert(_String_if item, int index) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_item = ((_String_cl)item)._body;
    ((java.awt.Choice)_body).insert(arg_item, index);
  }

  //------------------------------------------------------------------
  public void remove(_String_if item) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_item = ((_String_cl)item)._body;
    ((java.awt.Choice)_body).remove(arg_item);
  }

  //------------------------------------------------------------------
  public void remove(int position) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Choice)_body).remove(position);
  }

  //------------------------------------------------------------------
  public void removeAll() //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Choice)_body).removeAll();
  }

  //------------------------------------------------------------------
  public void removeItemListener(_ItemListener_if l)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.ItemListener  arg_l = ((_ItemListener_cl)l)._body;
    ((java.awt.Choice)_body).removeItemListener(arg_l);
  }

  //------------------------------------------------------------------
  public void select(int position) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Choice)_body).select(position);
  }

  //------------------------------------------------------------------
  public void select(_String_if str) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_str = ((_String_cl)str)._body;
    ((java.awt.Choice)_body).select(arg_str);
  }


  //================================================== protected methods
  //protected void processEvent(_AWTEvent_if e)
  //protected void processItemEvent(_ItemEvent_if e)
  //protected _String_if paramString()


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((_String_cl)asString())._body;
//  }

}

// EoF


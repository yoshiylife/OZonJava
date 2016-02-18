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
 * Checkbox implementation
 * --- A Checkbox object is a graphical user interface element
 * that has a boolean state.
 *
 * @version  $Id: _Checkbox_cl.java,v 1.12 1997/07/04 02:27:07 nito Exp $
 * @see      _Component_if
 * @see      _ItemSelectable_if
 * @see      _Checkbox_if
 */


public class _Checkbox_cl
  extends    JP.go.ipa.oz.lib.standard._Component_cl
  implements JP.go.ipa.oz.lib.standard._Checkbox_if
{

  static final java.lang.String  CN = "Checkbox";


  //================================================== constructors

  _Checkbox_cl(_OzCheckbox c)
    throws Exception
  {
    _body = c;
  }

  public _Checkbox_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  //------------------------------------------------------------------
  public java.lang.Object _new_newCheckbox()
    throws Exception
  {
    _OzCheckbox  c = new _OzCheckbox();
    c.bind(this);
    _body = c;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newCheckbox(_String_if label)
    throws Exception
  {
    java.lang.String  arg_label = ((_String_cl)label)._body;
    _OzCheckbox  c = new _OzCheckbox(arg_label);
    c.bind(this);
    _body = c;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newCheckbox(_String_if label, boolean state)
    throws Exception
  {
    java.lang.String  arg_label = ((_String_cl)label)._body;
    _OzCheckbox  c = new _OzCheckbox(arg_label, state);
    c.bind(this);
    _body = c;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newCheckbox(_String_if label, boolean state, _CheckboxGroup_if group)
    throws Exception
  {
    java.lang.String  arg_label = ((_String_cl)label)._body;
    java.awt.CheckboxGroup  arg_group = ((_CheckboxGroup_cl)group)._body;
    _OzCheckbox  c = new _OzCheckbox(arg_label, state, arg_group);
    c.bind(this);
    _body = c;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newCheckbox(_String_if label, _CheckboxGroup_if group, boolean state)
    throws Exception
  {
    java.lang.String  arg_label = ((_String_cl)label)._body;
    java.awt.CheckboxGroup  arg_group = ((_CheckboxGroup_cl)group)._body;
    _OzCheckbox  c = new _OzCheckbox(arg_label, arg_group, state);
    c.bind(this);
    _body = c;
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public void addItemListener(_ItemListener_if l)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.ItemListener  arg_l
      = (java.awt.event.ItemListener)(((_ItemListener_cl)l)._body);
    ((java.awt.Checkbox)_body).addItemListener(arg_l);
  }

  //------------------------------------------------------------------
  public void addNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Checkbox)_body).addNotify();
  }

  //------------------------------------------------------------------
  public _String_if asString()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  dim = ((java.awt.Checkbox)_body).getSize();
    java.lang.String  rv_tmp = CN.concat("[label=")
      .concat(((java.awt.Checkbox)_body).getLabel())
      .concat(",size=").concat(java.lang.Integer.toString(dim.width))
      .concat("x").concat(java.lang.Integer.toString(dim.height))
      .concat("]");
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _CheckboxGroup_if getCheckboxGroup()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.CheckboxGroup  rv_tmp = ((java.awt.Checkbox)_body).getCheckboxGroup();
    if (rv_tmp == null) return null;
    _CheckboxGroup_if  rv = new _CheckboxGroup_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _String_if getLabel()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.Checkbox)_body).getLabel();
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Collection_if getSelectedObjects()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.Object[]  rv_tmp
      = ((java.awt.Checkbox)_body).getSelectedObjects();
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
  public boolean getState()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Checkbox)_body).getState();
  }

  //------------------------------------------------------------------
  public void removeItemListener(_ItemListener_if l)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.ItemListener  arg_l = ((_ItemListener_cl)l)._body;
    ((java.awt.Checkbox)_body).removeItemListener(arg_l);
  }

  //------------------------------------------------------------------
  public void setCheckboxGroup(_CheckboxGroup_if g)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.CheckboxGroup  arg_g = ((_CheckboxGroup_cl)g)._body;
    ((java.awt.Checkbox)_body).setCheckboxGroup(arg_g);
  }

  //------------------------------------------------------------------
  public void setLabel(_String_if label) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_label = ((_String_cl)label)._body;
    ((java.awt.Checkbox)_body).setLabel(arg_label);
  }

  //------------------------------------------------------------------
  public void setState(boolean state)
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Checkbox)_body).setState(state);
  }


  //================================================== protected methods
  //protected _String_if paramString() {}
  //protected void processEvent(_AWTEvent_if e) {}
  //protected void processItemEvent(_ItemEvent_if e) {}


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((_String_cl)asString())._body;
//  }

}

// EoF


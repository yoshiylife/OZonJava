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
 * CheckboxMenuItem implementation
 *
 * @version  $Id: _CheckboxMenuItem_cl.java,v 1.12 1997/07/04 02:27:06 nito Exp $
 * @see      _CheckboxMenuItem_if
 */


public class _CheckboxMenuItem_cl
  extends    JP.go.ipa.oz.lib.standard._MenuItem_cl
  implements JP.go.ipa.oz.lib.standard._CheckboxMenuItem_if
{

  static final java.lang.String  CN = "CheckboxMenuItem";


  //================================================== constructors

  _CheckboxMenuItem_cl(_OzCheckboxMenuItem cmi)
    throws Exception
  {
    _body = cmi;
  }

  public _CheckboxMenuItem_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  //------------------------------------------------------------------
  public java.lang.Object _new_newCheckboxMenuItem()
    throws Exception
  {
    _OzCheckboxMenuItem  c = new _OzCheckboxMenuItem();
    c.bind(this);
    _body = c;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newCheckboxMenuItem(_String_if label)
    throws Exception
  {
    java.lang.String  arg_label = ((_String_cl)label)._body;
    _OzCheckboxMenuItem  c = new _OzCheckboxMenuItem(arg_label);
    c.bind(this);
    _body = c;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newCheckboxMenuItem(_String_if label, boolean state)
    throws Exception
  {
    java.lang.String  arg_label = ((_String_cl)label)._body;
    _OzCheckboxMenuItem  c = new _OzCheckboxMenuItem(arg_label, state);
    c.bind(this);
    _body = c;
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public void addNotify()
    throws Exception
  {
    ((java.awt.CheckboxMenuItem)_body).addNotify();
  }

  //------------------------------------------------------------------
  public void addItemListener(_ItemListener_if l) //synchronized
    throws Exception
  {
    java.awt.event.ItemListener  arg_l
      = (java.awt.event.ItemListener)(((_ItemListener_cl)l)._body);
    ((java.awt.CheckboxMenuItem)_body).addItemListener(arg_l);
  }

  //------------------------------------------------------------------
  public _String_if asString() //@
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = CN.concat("[label=")
      .concat(((java.awt.MenuItem)_body).getLabel())
      .concat(",state=").concat(getStateString())
      .concat("]");
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Collection_if getSelectedObjects() //synchronized
    throws Exception
  {
    java.lang.Object[]  rv_tmp
      = ((java.awt.CheckboxMenuItem)_body).getSelectedObjects();
    _Array_if  objects = null;
    if (rv_tmp != null && 0 < rv_tmp.length) {
      objects = (_Array_if)new _Array_cl()._new_create(rv_tmp.length);
      for (int i = 0; i < rv_tmp.length; i++) {
	objects.putAt(i, new _String_cl(((java.lang.String)rv_tmp[i])));
      }
    }
    return objects;
  }

  //------------------------------------------------------------------
  public boolean getState()
    throws Exception
  {
    return ((java.awt.CheckboxMenuItem)_body).getState();
  }

  java.lang.String getStateString()
    throws Exception
  {
    if (getState()) {
      return "true";
    } else {
      return "false";
    }
  }

  //------------------------------------------------------------------
  public _String_if paramString()
    throws Exception
  {
    java.lang.String  rv_tmp = ((java.awt.CheckboxMenuItem)_body).paramString();
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public void removeItemListener(_ItemListener_if l) //synchronized
    throws Exception
  {
    java.awt.event.ItemListener  arg_l = ((_ItemListener_cl)l)._body;
    ((java.awt.CheckboxMenuItem)_body).removeItemListener(arg_l);
  }

  //------------------------------------------------------------------
  public void setState(boolean b) //synchronized
    throws Exception
  {
    ((java.awt.CheckboxMenuItem)_body).setState(b);
  }


  //================================================== protected methods
  //protected void processEvent(_AWTEvent_if e) {}
  //protected void processItemEvent(_ItemEvent_if e) {}


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((java.awt.MenuComponent)_body).toString();
//  }

}

// EoF


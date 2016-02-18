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
 * CheckboxGroup implementation
 *
 * @version  $Id: _CheckboxGroup_cl.java,v 1.11 1997/07/04 02:27:06 nito Exp $
 * @see      _CheckboxGroup_if
 */


public class _CheckboxGroup_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._CheckboxGroup_if
{

  final static java.lang.String  CN = "CheckboxGroup";
  java.awt.CheckboxGroup  _body;


  // ================================================== constructors

  _CheckboxGroup_cl(java.awt.CheckboxGroup g)
    throws Exception
  {
    _body = g;
  }

  public _CheckboxGroup_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public java.lang.Object _new_newCheckboxGroup()
    throws Exception
  {
    _body = new java.awt.CheckboxGroup();
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public _String_if asString()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = _body.toString();
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //public _Checkbox_if getCurrent() {}  //DEPRECATED

  //------------------------------------------------------------------
  public _Checkbox_if getSelectedCheckbox()
    throws Exception
  {
    checkSecureInvocation();
    _OzCheckbox  rv_tmp = (_OzCheckbox)(_body.getSelectedCheckbox());
    if (rv_tmp == null) return null;
    _Checkbox_if  rv = (_Checkbox_if)(rv_tmp.oz());
    return rv;
  }

  //public void setCurrent(_Checkbox_if box); //synchronized  //DEPRECATED

  //------------------------------------------------------------------
  public void setSelectedCheckbox(_Checkbox_if box) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Checkbox  arg_box = (_OzCheckbox)(((_Checkbox_cl)box)._body);
    _body.setSelectedCheckbox(arg_box);
  }


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    java.lang.String  rv = _body.toString();
//    return rv;
//  }

}

// EoF

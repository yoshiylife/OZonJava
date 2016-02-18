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
 * Button implementation
 *
 * @version  $Id: _Button_cl.java,v 1.11 1997/07/04 02:27:06 nito Exp $
 * @see      _Component_cl
 * @see      _Button_if
 */


public class _Button_cl
  extends    JP.go.ipa.oz.lib.standard._Component_cl
  implements JP.go.ipa.oz.lib.standard._Button_if
{

  final static java.lang.String  CN = "Button";


  //================================================== constructors

  _Button_cl(_OzButton b)
    throws Exception
  {
    _body = b;
  }

  public _Button_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  //------------------------------------------------------------------
  public java.lang.Object _new_newButton()
    throws Exception
  {
    _OzButton  b = new _OzButton();
    b.bind(this);
    _body = b;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newButton(_String_if label)
    throws Exception
  {
    java.lang.String  arg_label = ((_String_cl)label)._body;
    _OzButton  b = new _OzButton(arg_label);
    b.bind(this);
    _body = b;
    return this;
  }
    

  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public void addActionListener(_ActionListener_if l) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.ActionListener  arg_l
      = (java.awt.event.ActionListener)(((_ActionListener_cl)l)._body);
    ((java.awt.Button)_body).addActionListener(arg_l);
  }

  //------------------------------------------------------------------
  public void addNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Button)_body).addNotify();
  }

  //------------------------------------------------------------------
  public _String_if asString() //@
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  dim = ((java.awt.Button)_body).getSize();
    java.lang.String  rv_tmp
      = CN.concat("[label=").concat(((java.awt.Button)_body).getLabel())
      .concat(",size=").concat(java.lang.Integer.toString(dim.width))
      .concat("x").concat(java.lang.Integer.toString(dim.height))
      .concat("]");
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _String_if getActionCommand()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.Button)_body).getActionCommand();
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _String_if getLabel()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.Button)_body).getLabel();
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public void removeActionListener(_ActionListener_if l) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.ActionListener  arg_l = ((_ActionListener_cl)l)._body;
    ((java.awt.Button)_body).removeActionListener(arg_l);
  }

  //------------------------------------------------------------------
  public void setActionCommand(_String_if command)
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_command = ((_String_cl)command)._body;
    ((java.awt.Button)_body).setActionCommand(arg_command);
  }

  //------------------------------------------------------------------
  public void setLabel(_String_if label)  //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_label = ((_String_cl)label)._body;
    ((java.awt.Button)_body).setLabel(arg_label);
  }


  //================================================== protected methods
  //protected String paramString(){}
  //protected void processActionEvent(_ActionEvent_if e){}
  //protected void processEvent(_AWTEvent_if e){}


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((_String_cl)asString())._body;
//  }

}

// EoF


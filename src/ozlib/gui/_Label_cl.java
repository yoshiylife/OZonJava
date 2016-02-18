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
 * Label implementation
 *
 * @version  $Id: _Label_cl.java,v 1.10 1997/06/18 12:58:11 nito Exp $
 * @see      _Label_if
 * @see      _Component_cl
 */


public class _Label_cl
  extends    JP.go.ipa.oz.lib.standard._Component_cl
  implements JP.go.ipa.oz.lib.standard._Label_if
{

  static final java.lang.String  CN = "Label";


  //================================================== constructors

  _Label_cl(_OzHoldable l)
    throws Exception
  {
    _body = l;
  }

  public _Label_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  //------------------------------------------------------------------
  public java.lang.Object _new_newLabel()
    throws Exception
  {
    _OzLabel  l = new _OzLabel();
    l.bind(this);
    _body = l;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newLabel(_String_if text)
    throws Exception
  {
    java.lang.String  arg_text = ((_String_cl)text)._body;
    _OzLabel  l = new _OzLabel(arg_text);
    l.bind(this);
    _body = l;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newLeftAlignedLabel(_String_if text) //@
    throws Exception
  {
    java.lang.String  arg_text = ((_String_cl)text)._body;
    _OzLabel  l = new _OzLabel(arg_text, java.awt.Label.LEFT);
    l.bind(this);
    _body = l;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newCenterAlignedLabel(_String_if text)
    throws Exception
  {
    java.lang.String  arg_text = ((_String_cl)text)._body;
    _OzLabel  l = new _OzLabel(arg_text, java.awt.Label.CENTER);
    l.bind(this);
    _body = l;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newRightAlignedLabel(_String_if text)
    throws Exception
  {
    java.lang.String  arg_text = ((_String_cl)text)._body;
    _OzLabel  l = new _OzLabel(arg_text, java.awt.Label.RIGHT);
    l.bind(this);
    _body = l;
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public void addNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Label)_body).addNotify();
  }

  //------------------------------------------------------------------
  public void alignToCenter() //@
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Label)_body).setAlignment(java.awt.Label.CENTER);
  }

  //------------------------------------------------------------------
  public void alignToLeft() //@
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Label)_body).setAlignment(java.awt.Label.LEFT);
  }

  //------------------------------------------------------------------
  public void alignToRight() //@
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Label)_body).setAlignment(java.awt.Label.RIGHT);
  }

  //------------------------------------------------------------------
  public _String_if asString() //@
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = CN.concat("[alignment=")
      .concat(getAlignmentString()).concat("text=")
      .concat(((java.awt.Label)_body).getText()).concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //@public int getAlignment(){}

  //------------------------------------------------------------------
  /**
   * Return the alignment-string instead of integer
   * like java.awt.Label#getAlignment.
   */
  java.lang.String getAlignmentString() //@
    throws Exception
  {
    switch (((java.awt.Label)_body).getAlignment()) {
    case java.awt.Label.LEFT:
      return "left";
    case java.awt.Label.CENTER:
      return "center";
    case java.awt.Label.RIGHT:
      return "right";
    }
    return "unknown";
  }

  //------------------------------------------------------------------
  public boolean isAlignedToCenter() //@
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Label)_body).getAlignment() == java.awt.Label.CENTER;
  }

  //------------------------------------------------------------------
  public boolean isAlignedToLeft() //@
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Label)_body).getAlignment() == java.awt.Label.LEFT;
  }

  //------------------------------------------------------------------
  public boolean isAlignedToRight() //@
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Label)_body).getAlignment() == java.awt.Label.RIGHT;
  }

  //------------------------------------------------------------------
  public _String_if getText()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.Label)_body).getText();
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //@public void setAlignment(int alignment) //synchronized

  //------------------------------------------------------------------
  public void setText(_String_if text) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_text = ((_String_cl)text)._body;
    ((java.awt.Label)_body).setText(arg_text);
  }


  //================================================== protected methods
  //protected String paramString(){}


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((_String_cl)asString())._body;
//  }

}

// EoF


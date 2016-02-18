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
 * TextField implementation
 *
 * @version  $Id: _TextField_cl.java,v 1.13 1997/12/17 09:14:23 nito Exp $
 * @see      _TextField_if
 * @see      _Component_cl
 */


public class _TextField_cl
  extends    JP.go.ipa.oz.lib.standard._Component_cl
  implements JP.go.ipa.oz.lib.standard._TextField_if
{

  static final java.lang.String  CN = "TextField";


  //================================================== constructors

  _TextField_cl(_OzTextField f)
    throws Exception
  {
    _body = f;
  }

  public _TextField_cl()
    throws Exception
  {
  }


  //================================================== OZ constructors

  //------------------------------------------------------------------
  public java.lang.Object _new_newTextField()
    throws Exception
  {
    _OzTextField  f = new _OzTextField();
    f.bind(this);
    _body = f;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newTextField(_String_if text)
    throws Exception
  {
    java.lang.String  arg_text = ((_String_cl)text)._body;
    _OzTextField  f = new _OzTextField(arg_text);
    f.bind(this);
    _body = f;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newTextField(int columns)
    throws Exception
  {
    _OzTextField  f = new _OzTextField(columns);
    f.bind(this);
    _body = f;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newTextField(_String_if text, int columns)
    throws Exception
  {
    java.lang.String  arg_text = ((_String_cl)text)._body;
    _OzTextField  f = new _OzTextField(arg_text, columns);
    f.bind(this);
    _body = f;
    return this;
  }


  //============================== OZ method implementation for TextComponent

  //------------------------------------------------------------------
  public void addTextListener(_TextListener_if l)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.TextListener  arg_l = (java.awt.event.TextListener)(((_TextListener_cl)l)._body);
    ((java.awt.TextField)_body).addTextListener(arg_l);
  }

  //------------------------------------------------------------------
  public _String_if asString()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = CN.concat("[size=")
      .concat(java.lang.Integer.toString(getColumns()))
      .concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public boolean isEditable()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.TextField)_body).isEditable();
  }

  //------------------------------------------------------------------
  public int getCaretPosition()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.TextField)_body).getCaretPosition();
  }

  //------------------------------------------------------------------
  public int getSelectionEnd() //synchronized
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.TextField)_body).getSelectionEnd();
  }

  //------------------------------------------------------------------
  public int getSelectionStart() //synchronized
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.TextField)_body).getSelectionStart();
  }

  //------------------------------------------------------------------
  public _String_if getSelectedText() //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.TextField)_body).getSelectedText();
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _String_if getText() //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.TextField)_body).getText();
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public void removeNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.TextField)_body).removeNotify();
  }

  //------------------------------------------------------------------
  public void removeTextListener(_TextListener_if l)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.TextListener  arg_l = ((_TextListener_cl)l)._body;
    ((java.awt.TextField)_body).removeTextListener(arg_l);
  }

  //------------------------------------------------------------------
  public void select(int selectionStart, int selectionEnd) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.TextField)_body).select(selectionStart, selectionEnd);
  }

  //------------------------------------------------------------------
  public void selectAll() //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.TextField)_body).selectAll();
  }

  //------------------------------------------------------------------
  public void setCaretPosition(int position)
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.TextField)_body).setCaretPosition(position);
  }

  //------------------------------------------------------------------
  public void setEditable(boolean b) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.TextField)_body).setEditable(b);
  }

  //------------------------------------------------------------------
  public void setSelectionEnd(int selectionEnd) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.TextField)_body).setSelectionEnd(selectionEnd);
  }

  //------------------------------------------------------------------
  public void setSelectionStart(int selectionStart) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.TextField)_body).setSelectionStart(selectionStart);
  }

  //------------------------------------------------------------------
  public void setText(_String_if text) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_text = ((_String_cl)text)._body;
    ((java.awt.TextField)_body).setText(arg_text);
  }


  //============================== OZ method implementation for TextField

  //------------------------------------------------------------------
  public void addActionListener(_ActionListener_if l) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.ActionListener  arg_l = (java.awt.event.ActionListener)(((_ActionListener_cl)l)._body);
    ((java.awt.TextField)_body).addActionListener(arg_l);
  }

  //------------------------------------------------------------------
  public void addNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.TextField)_body).addNotify();
  }

  //------------------------------------------------------------------
  public boolean echoCharIsSet()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.TextField)_body).echoCharIsSet();
  }

  //------------------------------------------------------------------
  public int getColumns()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.TextField)_body).getColumns();
  }

  //------------------------------------------------------------------
  public char getEchoChar()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.TextField)_body).getEchoChar();
  }

  //------------------------------------------------------------------
  public _Dimension_if getMinimumSize()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  rv_tmp = ((java.awt.TextField)_body).getMinimumSize();
    if (rv_tmp == null) return null;
    _Dimension_if  rv = new _Dimension_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Dimension_if getMinimumSize(int columns)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  rv_tmp = ((java.awt.TextField)_body).getMinimumSize(columns);
    if (rv_tmp == null) return null;
    _Dimension_if  rv = new _Dimension_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Dimension_if getPreferredSize()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  rv_tmp = ((java.awt.TextField)_body).getPreferredSize();
    if (rv_tmp == null) return null;
    _Dimension_if  rv = new _Dimension_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Dimension_if getPreferredSize(int columns)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  rv_tmp = ((java.awt.TextField)_body).getPreferredSize(columns);
    if (rv_tmp == null) return null;
    _Dimension_if  rv = new _Dimension_cl(rv_tmp);
    return rv;
  }

  //public _Dimension_if minimumSize() //DEPRECATED
  //public _Dimension_if minimumSize(int columns) //DEPRECATED
  //public _Dimension_if preferredSize(int columns) //DEPRECATED
  //public _Dimension_if preferredSize() //DEPRECATED

  //------------------------------------------------------------------
  public void removeActionListener(_ActionListener_if l) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.ActionListener  arg_l = ((_ActionListener_cl)l)._body;
    ((java.awt.TextField)_body).removeActionListener(arg_l);
  }

  //------------------------------------------------------------------
  public void setColumns(int columns)
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.TextField)_body).setColumns(columns);
  }

  //------------------------------------------------------------------
  public void setEchoChar(char c)
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.TextField)_body).setEchoChar(c);
  }

  //public void setEchoCharacter(char c) //DEPRECATED


  //================================================== protected methods
  //protected void processEvent(_AWTEvent_if)
  //protected void processActionEvent(_ActionEvent_if)
  //protected _String_if paramString()


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((_String_cl)asString())._body;
//  }

}

// EoF


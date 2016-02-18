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
 * TextArea implementation
 *
 * @version  $Id: _TextArea_cl.java,v 1.14 1997/07/04 02:27:09 nito Exp $
 * @see      _TextArea_if
 * @see      _Component_cl
 */


public class _TextArea_cl
  extends    JP.go.ipa.oz.lib.standard._Component_cl
  implements JP.go.ipa.oz.lib.standard._TextArea_if
{
  public final int getSCROLLBARS_BOTH() throws Exception
    { return _static_getSCROLLBARS_BOTH(); }

  public static final int _static_getSCROLLBARS_BOTH() throws Exception
    { return java.awt.TextArea.SCROLLBARS_BOTH; }

  public final int getSCROLLBARS_VERTICAL_ONLY() throws Exception
    { return _static_getSCROLLBARS_VERTICAL_ONLY(); }

  public static final int _static_getSCROLLBARS_VERTICAL_ONLY() throws Exception
    { return java.awt.TextArea.SCROLLBARS_VERTICAL_ONLY; }

  public final int getSCROLLBARS_HORIZONTAL_ONLY() throws Exception
    { return _static_getSCROLLBARS_HORIZONTAL_ONLY(); }

  public static final int _static_getSCROLLBARS_HORIZONTAL_ONLY() throws Exception
    { return java.awt.TextArea.SCROLLBARS_HORIZONTAL_ONLY; }

  public final int getSCROLLBARS_NONE() throws Exception
    { return _static_getSCROLLBARS_NONE(); }

  public static final int _static_getSCROLLBARS_NONE() throws Exception
    { return java.awt.TextArea.SCROLLBARS_NONE; }



  static final java.lang.String  CN = "TextArea";


  //================================================== constructors

  _TextArea_cl(_OzTextArea ta)
    throws Exception
  {
    _body = ta;
  }

  public _TextArea_cl()
    throws Exception
  {
  }

  //================================================== OZ constructors

  //------------------------------------------------------------------
  public java.lang.Object _new_newTextArea()
    throws Exception
  {
    _OzTextArea  a = new _OzTextArea();
    a.bind(this);
    _body = a;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newTextArea(_String_if text)
    throws Exception
  {
    java.lang.String  arg_text = ((_String_cl)text)._body;
    _OzTextArea  a = new _OzTextArea(arg_text);
    a.bind(this);
    _body = a;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newTextArea(int rows, int columns)
    throws Exception
  {
    _OzTextArea  a = new _OzTextArea(rows, columns);
    a.bind(this);
    _body = a;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newTextArea(_String_if text, int rows, int columns)
    throws Exception
  {
    java.lang.String  arg_text = ((_String_cl)text)._body;
    _OzTextArea  a = new _OzTextArea(arg_text, rows, columns);
    a.bind(this);
    _body = a;
    return this;
  }

  //------------------------------------------------------------------
  //@public java.lang.Object _new_newTextArea(_String_if text, int rows, int columns, int scrollbars)

  //------------------------------------------------------------------
  public java.lang.Object _new_newTextAreaWithHorizontalScrollbar(_String_if text, int rows, int columns) //@
    throws Exception
  {
    java.lang.String  arg_text = ((_String_cl)text)._body;
    _OzTextArea  a = new _OzTextArea(arg_text, rows, columns, java.awt.TextArea.SCROLLBARS_HORIZONTAL_ONLY);
    a.bind(this);
    _body = a;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newTextAreaWithVerticalScrollbar(_String_if text, int rows, int columns) //@
    throws Exception
  {
    java.lang.String  arg_text = ((_String_cl)text)._body;
    _OzTextArea  a = new _OzTextArea(arg_text, rows, columns, java.awt.TextArea.SCROLLBARS_VERTICAL_ONLY);
    a.bind(this);
    _body = a;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newTextAreaWithBothScrollbars(_String_if text, int rows, int columns) //@
    throws Exception
  {
    java.lang.String  arg_text = ((_String_cl)text)._body;
    _OzTextArea  a = new _OzTextArea(arg_text, rows, columns, java.awt.TextArea.SCROLLBARS_BOTH);
    a.bind(this);
    _body = a;
    return this;
  }


  //============================== OZ method implementation for TextComponent

  //------------------------------------------------------------------
  public void addTextListener(_TextListener_if l)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.TextListener  arg_l = (java.awt.event.TextListener)(((_TextListener_cl)l)._body);
    ((java.awt.TextArea)_body).addTextListener(arg_l);
  }

  //------------------------------------------------------------------
  public _String_if asString()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = CN.concat("[size=")
      .concat(java.lang.Integer.toString(getColumns())).concat("x")
      .concat(java.lang.Integer.toString(getRows())).concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public boolean isEditable()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.TextArea)_body).isEditable();
  }

  //------------------------------------------------------------------
  public int getCaretPosition()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.TextArea)_body).getCaretPosition();
  }

  //------------------------------------------------------------------
  public int getSelectionEnd() //synchronized
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.TextArea)_body).getSelectionEnd();
  }

  //------------------------------------------------------------------
  public int getSelectionStart() //synchronized
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.TextArea)_body).getSelectionStart();
  }

  //------------------------------------------------------------------
  public _String_if getSelectedText() //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.TextArea)_body).getSelectedText();
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _String_if getText() //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.TextArea)_body).getText();
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public void removeNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.TextArea)_body).removeNotify();
  }

  //------------------------------------------------------------------
  public void removeTextListener(_TextListener_if l)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.TextListener  arg_l = ((_TextListener_cl)l)._body;
    ((java.awt.TextArea)_body).removeTextListener(arg_l);
  }

  //------------------------------------------------------------------
  public void select(int selectionStart, int selectionEnd) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.TextArea)_body).select(selectionStart, selectionEnd);
  }

  //------------------------------------------------------------------
  public void selectAll() //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.TextArea)_body).selectAll();
  }

  //------------------------------------------------------------------
  public void setCaretPosition(int position)
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.TextArea)_body).setCaretPosition(position);
  }

  //------------------------------------------------------------------
  public void setEditable(boolean b) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.TextArea)_body).setEditable(b);
  }

  //------------------------------------------------------------------
  public void setSelectionEnd(int selectionEnd) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.TextArea)_body).setSelectionEnd(selectionEnd);
  }

  //------------------------------------------------------------------
  public void setSelectionStart(int selectionStart) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.TextArea)_body).setSelectionStart(selectionStart);
  }

  //------------------------------------------------------------------
  public void setText(_String_if text) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_text = ((_String_cl)text)._body;
    ((java.awt.TextArea)_body).setText(arg_text);
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public void addNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.TextArea)_body).addNotify();
  }

  //------------------------------------------------------------------
  public void append(_String_if str) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_str = ((_String_cl)str)._body;
    ((java.awt.TextArea)_body).append(arg_str);
  }

  //public void appendText(_String_if) //DEPRECATED

  //------------------------------------------------------------------
  public int getColumns()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.TextArea)_body).getColumns();
  }

  //------------------------------------------------------------------
  public _Dimension_if getMinimumSize()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  rv_tmp = ((java.awt.TextArea)_body).getMinimumSize();
    if (rv_tmp == null) return null;
    _Dimension_cl  rv = new _Dimension_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Dimension_if getMinimumSize(int rows, int columns)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  rv_tmp = ((java.awt.TextArea)_body).getMinimumSize(rows, columns);
    if (rv_tmp == null) return null;
    _Dimension_cl  rv = new _Dimension_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Dimension_if getPreferredSize()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  rv_tmp = ((java.awt.TextArea)_body).getPreferredSize();
    if (rv_tmp == null) return null;
    _Dimension_cl  rv = new _Dimension_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Dimension_if getPreferredSize(int rows, int columns)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  rv_tmp = ((java.awt.TextArea)_body).getPreferredSize(rows, columns);
    if (rv_tmp == null) return null;
    _Dimension_cl  rv = new _Dimension_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public int getRows()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.TextArea)_body).getRows();
  }

  //------------------------------------------------------------------
  public int getScrollbarVisibility()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.TextArea)_body).getScrollbarVisibility();
  }

  //------------------------------------------------------------------
  public void insert(_String_if str, int pos) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_str = ((_String_cl)str)._body;
    ((java.awt.TextArea)_body).insert(arg_str, pos);
  }

  //public void insertText(_String_if str, int pos) //DEPRECATED
  //public _Dimension_if minimumSize() //DEPRECATED
  //public _Dimension_if minimumSize(int rows, int columns) //DEPRECATED
  //public _Dimension_if preferredSize() //DEPRECATED
  //public _Dimension_if preferredSize(int rows, int columns) //DEPRECATED

  //------------------------------------------------------------------
  public void replaceRange(_String_if str, int start, int end) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_str = ((_String_cl)str)._body;
    ((java.awt.TextArea)_body).replaceRange(arg_str, start, end);
  }

  //public void replaceText(_String_if str, int start, int end) //DEPRECATED

  //------------------------------------------------------------------
  public void setColumns(int columns)
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.TextArea)_body).setColumns(columns);
  }

  //------------------------------------------------------------------
  public void setRows(int rows)
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.TextArea)_body).setRows(rows);
  }


  //================================================== protected methods
  //protected _String_if paramString()


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((_String_cl)asString())._body;
//  }

}

// EoF


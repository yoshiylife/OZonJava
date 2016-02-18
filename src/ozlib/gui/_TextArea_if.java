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

// OZ CLass Library (AWT)


package JP.go.ipa.oz.lib.standard;


/**
 * TextArea interface
 *
 * @version  $Id: _TextArea_if.java,v 1.10 1997/06/24 07:11:17 nito Exp $
 * @see      _TextComponent_if
 */


public interface _TextArea_if
  extends JP.go.ipa.oz.lib.standard._TextComponent_if
{

  public int getSCROLLBARS_BOTH() throws Exception;
  public int getSCROLLBARS_VERTICAL_ONLY() throws Exception;
  public int getSCROLLBARS_HORIZONTAL_ONLY() throws Exception;
  public int getSCROLLBARS_NONE() throws Exception;

  //================================================== OZ methods
  public void addTextListener(_TextListener_if l) throws Exception;
  public _String_if asString() throws Exception;
  public boolean isEditable() throws Exception;
  public int getCaretPosition() throws Exception;
  public int getSelectionEnd() throws Exception;
  public int getSelectionStart() throws Exception;
  public _String_if getSelectedText() throws Exception;
  public _String_if getText() throws Exception;
  public void removeNotify() throws Exception;
  public void removeTextListener(_TextListener_if l) throws Exception;
  public void select(int selectionStart, int selectionEnd) throws Exception;
  public void selectAll() throws Exception;
  public void setCaretPosition(int position) throws Exception;
  public void setEditable(boolean b) throws Exception;
  public void setSelectionEnd(int selectionEnd) throws Exception;
  public void setSelectionStart(int selectionStart) throws Exception;
  public void setText(_String_if text) throws Exception;
  public void addNotify() throws Exception;
  public void append(_String_if str) throws Exception;
  public int getColumns() throws Exception;
  public int getRows() throws Exception;
  public int getScrollbarVisibility() throws Exception;
  public void insert(_String_if str, int pos) throws Exception;
  public void replaceRange(_String_if str, int start, int end) throws Exception;
  public void setColumns(int columns) throws Exception;
  public void setRows(int rows) throws Exception;
  public _Dimension_if getMinimumSize() throws Exception;
  public _Dimension_if getMinimumSize(int rows, int columns) throws Exception;
  public _Dimension_if getPreferredSize() throws Exception;
  public _Dimension_if getPreferredSize(int rows, int columns) throws Exception;
}

// EoF


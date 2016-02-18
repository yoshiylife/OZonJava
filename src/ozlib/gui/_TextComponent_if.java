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
 * TextComponent interface
 *
 * @version  $Id: _TextComponent_if.java,v 1.7 1997/06/13 08:49:56 nito Exp $
 * @see      _Component_if
 */


public interface _TextComponent_if
  extends JP.go.ipa.oz.lib.standard._Component_if
{


  //================================================== OZ public methods
  public void addTextListener(_TextListener_if l) throws Exception;
  public boolean isEditable() throws Exception;
  public int getCaretPosition() throws Exception;
  public int getSelectionEnd() throws Exception; //synchronized
  public int getSelectionStart() throws Exception; //synchronized
  public _String_if getSelectedText() throws Exception; //synchronized
  public _String_if getText() throws Exception; //synchronized
  public void removeNotify() throws Exception;
  public void removeTextListener(_TextListener_if l) throws Exception;
  public void select(int selectionStart, int selectionEnd) throws Exception; //synchronized
  public void selectAll() throws Exception; //synchronized
  public void setCaretPosition(int position) throws Exception;
  public void setEditable(boolean b) throws Exception; //synchronized
  public void setSelectionEnd(int selectionEnd) throws Exception; //synchronized
  public void setSelectionStart(int selectionStart) throws Exception; //synchronized
  public void setText(_String_if text) throws Exception; //synchronized

}

// EoF


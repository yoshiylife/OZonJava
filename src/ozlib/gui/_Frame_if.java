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
 * Frame interface
 *
 * The default layout for Frame is BorderLayout.
 *
 * @version  $Id: _Frame_if.java,v 1.7 1997/06/24 07:11:15 nito Exp $
 * @see      _Window_if
 * @see      _MenuContainer_if
 */


public interface _Frame_if
  extends JP.go.ipa.oz.lib.standard._Window_if,
          JP.go.ipa.oz.lib.standard._MenuContainer_if
{


  //================================================== OZ public methods
  public void addNotify() throws Exception;
  public void dispose() throws Exception; //synchronized
  //public int getCursorType() throws Exception;  //DEPRECATED ... Component#GetCursor()
  //*public _Image_if getIconImage() throws Exception;
  public _MenuBar_if getMenuBar() throws Exception;
  public _String_if getTitle() throws Exception;
  public boolean isResizable() throws Exception;
  //protected _String_if paramString() throws Exception;
  public void remove(_MenuComponent_if m) throws Exception; //synchronized
  //public void setCursor(int cursorType) throws Exception; //synchronized  //DEPRECATED ... Component#setCursor()
  public void setIconImage(_Image_if image) throws Exception; //synchronized
  public void setMenuBar(_MenuBar_if mb) throws Exception; //synchronized
  public void setResizable(boolean resizable) throws Exception; //synchronized
  public void setTitle(_String_if title) throws Exception; //synchronized
  public _String_if asString() throws Exception;

}

// EoF


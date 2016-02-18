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
 * ScrollPane interface
 *
 * @version  $Id: _ScrollPane_if.java,v 1.10 1997/07/01 02:29:17 nito Exp $
 * @see      _Container_if
 */


public interface _ScrollPane_if
  extends JP.go.ipa.oz.lib.standard._Container_if
{

  public int getSCROLLBARS_AS_NEEDED() throws Exception;
  public int getSCROLLBARS_ALWAYS() throws Exception;
  public int getSCROLLBARS_NEVER() throws Exception;

  //================================================== OZ methods
  public void addNotify() throws Exception;
  public void doLayout() throws Exception;
  public _Adjustable_if getHAdjustable() throws Exception;
  public int getHScrollbarHeight() throws Exception;
  public int getScrollbarDisplayPolicy() throws Exception;
  public _Point_if getScrollPosition() throws Exception;
  public _Dimension_if getViewportSize() throws Exception;
  public _Adjustable_if getVAdjustable() throws Exception;
  public int getVScrollbarWidth() throws Exception;
  //public void layout() throws Exception; //DEPRECATED
  public _String_if paramString() throws Exception;
  public void printComponents(_Graphics_if g) throws Exception;
  public void setLayout(_LayoutManager_if mgr) throws Exception; //final
  public void setDefaultLayout() throws Exception;
  public void setScrollPosition(int x, int y) throws Exception;
  public void setScrollPosition(_Point_if p) throws Exception;
  public _String_if asString() throws Exception;

}

// EoF


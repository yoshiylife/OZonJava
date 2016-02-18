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
 * MouseEvent interface
 *
 * @version  $Id: _MouseEvent_if.java,v 1.7 1997/06/24 07:11:16 nito Exp $
 * @see      _InputEvent_if
 */


public interface _MouseEvent_if
  extends JP.go.ipa.oz.lib.standard._InputEvent_if
{

  public int getMOUSE_FIRST() throws Exception;
  public int getMOUSE_LAST() throws Exception;
  public int getMOUSE_CLICKED() throws Exception;
  public int getMOUSE_PRESSED() throws Exception;
  public int getMOUSE_RELEASED() throws Exception;
  public int getMOUSE_MOVED() throws Exception;
  public int getMOUSE_ENTERED() throws Exception;
  public int getMOUSE_EXITED() throws Exception;
  public int getMOUSE_DRAGGED() throws Exception;
  //================================================== OZ methods
  public int getX() throws Exception;
  public int getY() throws Exception;
  public _Point_if getPoint() throws Exception;
  public void translatePoint(int x, int y) throws Exception; //synchronized
  public int getClickCount() throws Exception;
  public boolean isPopupTrigger() throws Exception;
  public _String_if paramString() throws Exception;
  public _String_if asString() throws Exception;

}

// EoF


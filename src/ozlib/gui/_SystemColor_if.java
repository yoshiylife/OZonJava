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
 * SystemColor interface
 *
 * @version  $Id: _SystemColor_if.java,v 1.8 1997/06/24 07:11:17 nito Exp $
 * @see      _Color_if
 */


public interface _SystemColor_if
  extends JP.go.ipa.oz.lib.standard._Color_if
{

  public int getDESKTOP() throws Exception;
  public int getACTIVE_CAPTION() throws Exception;
  public int getACTIVE_CAPTION_TEXT() throws Exception;
  public int getACTIVE_CAPTION_BORDER() throws Exception;
  public int getINACTIVE_CAPTION() throws Exception;
  public int getINACTIVE_CAPTION_TEXT() throws Exception;
  public int getINACTIVE_CAPTION_BORDER() throws Exception;
  public int getWINDOW() throws Exception;
  public int getWINDOW_BORDER() throws Exception;
  public int getWINDOW_TEXT() throws Exception;
  public int getMENU() throws Exception;
  public int getMENU_TEXT() throws Exception;
  public int getTEXT() throws Exception;
  public int getTEXT_TEXT() throws Exception;
  public int getTEXT_HIGHLIGHT() throws Exception;
  public int getTEXT_HIGHLIGHT_TEXT() throws Exception;
  public int getTEXT_INACTIVE_TEXT() throws Exception;
  public int getCONTROL() throws Exception;
  public int getCONTROL_TEXT() throws Exception;
  public int getCONTROL_HIGHLIGHT() throws Exception;
  public int getCONTROL_LT_HIGHLIGHT() throws Exception;
  public int getCONTROL_SHADOW() throws Exception;
  public int getCONTROL_DK_SHADOW() throws Exception;
  public int getSCROLLBAR() throws Exception;
  public int getINFO() throws Exception;
  public int getINFO_TEXT() throws Exception;
  public int getNUM_COLORS() throws Exception;
  public _SystemColor_if getDesktop() throws Exception;
  public _SystemColor_if getActiveCaption() throws Exception;
  public _SystemColor_if getActiveCaptionText() throws Exception;
  public _SystemColor_if getActiveCaptionBorder() throws Exception;
  public _SystemColor_if getInactiveCaption() throws Exception;
  public _SystemColor_if getInactiveCaptionText() throws Exception;
  public _SystemColor_if getInactiveCaptionBorder() throws Exception;
  public _SystemColor_if getWindow() throws Exception;
  public _SystemColor_if getWindowBorder() throws Exception;
  public _SystemColor_if getWindowText() throws Exception;
  public _SystemColor_if getMenu() throws Exception;
  public _SystemColor_if getMenuText() throws Exception;
  public _SystemColor_if getText() throws Exception;
  public _SystemColor_if getTextText() throws Exception;
  public _SystemColor_if getTextHighlight() throws Exception;
  public _SystemColor_if getTextHighlightText() throws Exception;
  public _SystemColor_if getTextInactiveText() throws Exception;
  public _SystemColor_if getControl() throws Exception;
  public _SystemColor_if getControlText() throws Exception;
  public _SystemColor_if getControlHighlight() throws Exception;
  public _SystemColor_if getControlLtHighlight() throws Exception;
  public _SystemColor_if getControlShadow() throws Exception;
  public _SystemColor_if getControlDkShadow() throws Exception;
  public _SystemColor_if getScrollbar() throws Exception;
  public _SystemColor_if getInfo() throws Exception;
  public _SystemColor_if getInfoText() throws Exception;

  //================================================== OZ methods
  public _Color_if getDesktopColor() throws Exception; //@
  public _Color_if getActiveCaptionColor() throws Exception; //@
  public _Color_if getActiveCaptionTextColor() throws Exception; //@
  public _Color_if getActiveCaptionBorderColor() throws Exception; //@
  public _Color_if getInactiveCaptionColor() throws Exception; //@
  public _Color_if getInactiveCaptionTextColor() throws Exception; //@
  public _Color_if getInactiveCaptionBorderColor() throws Exception; //@
  public _Color_if getWindowColor() throws Exception; //@
  public _Color_if getWindowBorderColor() throws Exception; //@
  public _Color_if getWindowTextColor() throws Exception; //@
  public _Color_if getMenuColor() throws Exception; //@
  public _Color_if getMenuTextColor() throws Exception; //@
  public _Color_if getTextColor() throws Exception; //@
  public _Color_if getTextTextColor() throws Exception; //@
  public _Color_if getTextHighlightColor() throws Exception; //@
  public _Color_if getTextHighlightTextColor() throws Exception; //@
  public _Color_if getTextInactiveTextColor() throws Exception; //@
  public _Color_if getControlColor() throws Exception; //@
  public _Color_if getControlTextColor() throws Exception; //@
  public _Color_if getControlHighlightColor() throws Exception; //@
  public _Color_if getControlLtHighlightColor() throws Exception; //@
  public _Color_if getControlShadowColor() throws Exception; //@
  public _Color_if getControlDkShadowColor() throws Exception; //@
  public _Color_if getScrollbarColor() throws Exception; //@
  public _Color_if getInfoColor() throws Exception; //@
  public _Color_if getInfoTextColor() throws Exception; //@

  public int getRGB() throws Exception;
  public _String_if asString() throws Exception;

}

// EoF


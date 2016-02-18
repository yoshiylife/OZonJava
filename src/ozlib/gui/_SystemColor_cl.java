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
 * SystemColor implementation
 *
 * @version  $Id: _SystemColor_cl.java,v 1.12 1997/07/04 02:27:09 nito Exp $
 * @see      _SystemColor_if
 * @see      _Color_cl
 */


public final class _SystemColor_cl
  extends    JP.go.ipa.oz.lib.standard._Color_cl
  implements JP.go.ipa.oz.lib.standard._SystemColor_if
{

  public final int getDESKTOP() throws Exception
    { return _static_getDESKTOP(); }

  public static final int _static_getDESKTOP() throws Exception
    { return java.awt.SystemColor.DESKTOP; }

  public final int getACTIVE_CAPTION() throws Exception
    { return _static_getACTIVE_CAPTION(); }

  public static final int _static_getACTIVE_CAPTION() throws Exception
    { return java.awt.SystemColor.ACTIVE_CAPTION; }

  public final int getACTIVE_CAPTION_TEXT() throws Exception
    { return _static_getACTIVE_CAPTION_TEXT(); }

  public static final int _static_getACTIVE_CAPTION_TEXT() throws Exception
    { return java.awt.SystemColor.ACTIVE_CAPTION_TEXT; }

  public final int getACTIVE_CAPTION_BORDER() throws Exception
    { return _static_getACTIVE_CAPTION_BORDER(); }

  public static final int _static_getACTIVE_CAPTION_BORDER() throws Exception
    { return java.awt.SystemColor.ACTIVE_CAPTION_BORDER; }

  public final int getINACTIVE_CAPTION() throws Exception
    { return _static_getINACTIVE_CAPTION(); }

  public static final int _static_getINACTIVE_CAPTION() throws Exception
    { return java.awt.SystemColor.INACTIVE_CAPTION; }

  public final int getINACTIVE_CAPTION_TEXT() throws Exception
    { return _static_getINACTIVE_CAPTION_TEXT(); }

  public static final int _static_getINACTIVE_CAPTION_TEXT() throws Exception
    { return java.awt.SystemColor.INACTIVE_CAPTION_TEXT; }

  public final int getINACTIVE_CAPTION_BORDER() throws Exception
    { return _static_getINACTIVE_CAPTION_BORDER(); }

  public static final int _static_getINACTIVE_CAPTION_BORDER() throws Exception
    { return java.awt.SystemColor.INACTIVE_CAPTION_BORDER; }

  public final int getWINDOW() throws Exception
    { return _static_getWINDOW(); }

  public static final int _static_getWINDOW() throws Exception
    { return java.awt.SystemColor.WINDOW; }

  public final int getWINDOW_BORDER() throws Exception
    { return _static_getWINDOW_BORDER(); }

  public static final int _static_getWINDOW_BORDER() throws Exception
    { return java.awt.SystemColor.WINDOW_BORDER; }

  public final int getWINDOW_TEXT() throws Exception
    { return _static_getWINDOW_TEXT(); }

  public static final int _static_getWINDOW_TEXT() throws Exception
    { return java.awt.SystemColor.WINDOW_TEXT; }

  public final int getMENU() throws Exception
    { return _static_getMENU(); }

  public static final int _static_getMENU() throws Exception
    { return java.awt.SystemColor.MENU; }

  public final int getMENU_TEXT() throws Exception
    { return _static_getMENU_TEXT(); }

  public static final int _static_getMENU_TEXT() throws Exception
    { return java.awt.SystemColor.MENU_TEXT; }

  public final int getTEXT() throws Exception
    { return _static_getTEXT(); }

  public static final int _static_getTEXT() throws Exception
    { return java.awt.SystemColor.TEXT; }

  public final int getTEXT_TEXT() throws Exception
    { return _static_getTEXT_TEXT(); }

  public static final int _static_getTEXT_TEXT() throws Exception
    { return java.awt.SystemColor.TEXT_TEXT; }

  public final int getTEXT_HIGHLIGHT() throws Exception
    { return _static_getTEXT_HIGHLIGHT(); }

  public static final int _static_getTEXT_HIGHLIGHT() throws Exception
    { return java.awt.SystemColor.TEXT_HIGHLIGHT; }

  public final int getTEXT_HIGHLIGHT_TEXT() throws Exception
    { return _static_getTEXT_HIGHLIGHT_TEXT(); }

  public static final int _static_getTEXT_HIGHLIGHT_TEXT() throws Exception
    { return java.awt.SystemColor.TEXT_HIGHLIGHT_TEXT; }

  public final int getTEXT_INACTIVE_TEXT() throws Exception
    { return _static_getTEXT_INACTIVE_TEXT(); }

  public static final int _static_getTEXT_INACTIVE_TEXT() throws Exception
    { return java.awt.SystemColor.TEXT_INACTIVE_TEXT; }

  public final int getCONTROL() throws Exception
    { return _static_getCONTROL(); }

  public static final int _static_getCONTROL() throws Exception
    { return java.awt.SystemColor.CONTROL; }

  public final int getCONTROL_TEXT() throws Exception
    { return _static_getCONTROL_TEXT(); }

  public static final int _static_getCONTROL_TEXT() throws Exception
    { return java.awt.SystemColor.CONTROL_TEXT; }

  public final int getCONTROL_HIGHLIGHT() throws Exception
    { return _static_getCONTROL_HIGHLIGHT(); }

  public static final int _static_getCONTROL_HIGHLIGHT() throws Exception
    { return java.awt.SystemColor.CONTROL_HIGHLIGHT; }

  public final int getCONTROL_LT_HIGHLIGHT() throws Exception
    { return _static_getCONTROL_LT_HIGHLIGHT(); }

  public static final int _static_getCONTROL_LT_HIGHLIGHT() throws Exception
    { return java.awt.SystemColor.CONTROL_LT_HIGHLIGHT; }

  public final int getCONTROL_SHADOW() throws Exception
    { return _static_getCONTROL_SHADOW(); }

  public static final int _static_getCONTROL_SHADOW() throws Exception
    { return java.awt.SystemColor.CONTROL_SHADOW; }

  public final int getCONTROL_DK_SHADOW() throws Exception
    { return _static_getCONTROL_DK_SHADOW(); }

  public static final int _static_getCONTROL_DK_SHADOW() throws Exception
    { return java.awt.SystemColor.CONTROL_DK_SHADOW; }

  public final int getSCROLLBAR() throws Exception
    { return _static_getSCROLLBAR(); }

  public static final int _static_getSCROLLBAR() throws Exception
    { return java.awt.SystemColor.SCROLLBAR; }

  public final int getINFO() throws Exception
    { return _static_getINFO(); }

  public static final int _static_getINFO() throws Exception
    { return java.awt.SystemColor.INFO; }

  public final int getINFO_TEXT() throws Exception
    { return _static_getINFO_TEXT(); }

  public static final int _static_getINFO_TEXT() throws Exception
    { return java.awt.SystemColor.INFO_TEXT; }

  public final int getNUM_COLORS() throws Exception
    { return _static_getNUM_COLORS(); }

  public static final int _static_getNUM_COLORS() throws Exception
    { return java.awt.SystemColor.NUM_COLORS; }

  public final _SystemColor_if getDesktop() throws Exception
    { return _static_getDesktop(); }

  public static final _SystemColor_if _static_getDesktop() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.desktop); }

  public final _SystemColor_if getActiveCaption() throws Exception
    { return _static_getActiveCaption(); }

  public static final _SystemColor_if _static_getActiveCaption() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.activeCaption); }

  public final _SystemColor_if getActiveCaptionText() throws Exception
    { return _static_getActiveCaptionText(); }

  public static final _SystemColor_if _static_getActiveCaptionText() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.activeCaptionText); }

  public final _SystemColor_if getActiveCaptionBorder() throws Exception
    { return _static_getActiveCaptionBorder(); }

  public static final _SystemColor_if _static_getActiveCaptionBorder() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.activeCaptionBorder); }

  public final _SystemColor_if getInactiveCaption() throws Exception
    { return _static_getInactiveCaption(); }

  public static final _SystemColor_if _static_getInactiveCaption() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.inactiveCaption); }

  public final _SystemColor_if getInactiveCaptionText() throws Exception
    { return _static_getInactiveCaptionText(); }

  public static final _SystemColor_if _static_getInactiveCaptionText() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.inactiveCaptionText); }

  public final _SystemColor_if getInactiveCaptionBorder() throws Exception
    { return _static_getInactiveCaptionBorder(); }

  public static final _SystemColor_if _static_getInactiveCaptionBorder() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.inactiveCaptionBorder); }

  public final _SystemColor_if getWindow() throws Exception
    { return _static_getWindow(); }

  public static final _SystemColor_if _static_getWindow() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.window); }

  public final _SystemColor_if getWindowBorder() throws Exception
    { return _static_getWindowBorder(); }

  public static final _SystemColor_if _static_getWindowBorder() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.windowBorder); }

  public final _SystemColor_if getWindowText() throws Exception
    { return _static_getWindowText(); }

  public static final _SystemColor_if _static_getWindowText() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.windowText); }

  public final _SystemColor_if getMenu() throws Exception
    { return _static_getMenu(); }

  public static final _SystemColor_if _static_getMenu() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.menu); }

  public final _SystemColor_if getMenuText() throws Exception
    { return _static_getMenuText(); }

  public static final _SystemColor_if _static_getMenuText() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.menuText); }

  public final _SystemColor_if getText() throws Exception
    { return _static_getText(); }

  public static final _SystemColor_if _static_getText() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.text); }

  public final _SystemColor_if getTextText() throws Exception
    { return _static_getTextText(); }

  public static final _SystemColor_if _static_getTextText() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.textText); }

  public final _SystemColor_if getTextHighlight() throws Exception
    { return _static_getTextHighlight(); }

  public static final _SystemColor_if _static_getTextHighlight() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.textHighlight); }

  public final _SystemColor_if getTextHighlightText() throws Exception
    { return _static_getTextHighlightText(); }

  public static final _SystemColor_if _static_getTextHighlightText() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.textHighlightText); }

  public final _SystemColor_if getTextInactiveText() throws Exception
    { return _static_getTextInactiveText(); }

  public static final _SystemColor_if _static_getTextInactiveText() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.textInactiveText); }

  public final _SystemColor_if getControl() throws Exception
    { return _static_getControl(); }

  public static final _SystemColor_if _static_getControl() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.control); }

  public final _SystemColor_if getControlText() throws Exception
    { return _static_getControlText(); }

  public static final _SystemColor_if _static_getControlText() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.controlText); }

  public final _SystemColor_if getControlHighlight() throws Exception
    { return _static_getControlHighlight(); }

  public static final _SystemColor_if _static_getControlHighlight() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.controlHighlight); }

  public final _SystemColor_if getControlLtHighlight() throws Exception
    { return _static_getControlLtHighlight(); }

  public static final _SystemColor_if _static_getControlLtHighlight() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.controlLtHighlight); }

  public final _SystemColor_if getControlShadow() throws Exception
    { return _static_getControlShadow(); }

  public static final _SystemColor_if _static_getControlShadow() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.controlShadow); }

  public final _SystemColor_if getControlDkShadow() throws Exception
    { return _static_getControlDkShadow(); }

  public static final _SystemColor_if _static_getControlDkShadow() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.controlDkShadow); }

  public final _SystemColor_if getScrollbar() throws Exception
    { return _static_getScrollbar(); }

  public static final _SystemColor_if _static_getScrollbar() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.scrollbar); }

  public final _SystemColor_if getInfo() throws Exception
    { return _static_getInfo(); }

  public static final _SystemColor_if _static_getInfo() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.info); }

  public final _SystemColor_if getInfoText() throws Exception
    { return _static_getInfoText(); }

  public static final _SystemColor_if _static_getInfoText() throws Exception
    { return new _SystemColor_cl(java.awt.SystemColor.infoText); }



  static final java.lang.String  CN = "SystemColor";


  //================================================== constructors

  _SystemColor_cl(java.awt.SystemColor sc)
    throws Exception
  {
    _body = sc;
  }

  public _SystemColor_cl()
    throws Exception
  {
  }


  //================================================== OZ constructors

  public java.lang.Object _new_newSystemColor()
    throws Exception
  {
    return this;
  }


  //================================================== OZ public method

  //------------------------------------------------------------------
  public _String_if asString() //@
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = CN.concat("[");
    rv_tmp = rv_tmp.concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getDesktopColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv_tmp = new _SystemColor_cl(java.awt.SystemColor.desktop);
    if (rv_tmp == null) return null;
    _Color_if  rv = (_Color_if)(new _Color_cl()._new_newColor(rv_tmp.getRGB()));
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getActiveCaptionColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv = new _SystemColor_cl(java.awt.SystemColor.activeCaption);
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getActiveCaptionTextColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv = new _SystemColor_cl(java.awt.SystemColor.activeCaptionText);
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getActiveCaptionBorderColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv_tmp = new _SystemColor_cl(java.awt.SystemColor.activeCaptionBorder);
    if (rv_tmp == null) return null;
    _Color_if  rv = (_Color_if)(new _Color_cl()._new_newColor(rv_tmp.getRGB()));
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getInactiveCaptionColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv = new _SystemColor_cl(java.awt.SystemColor.inactiveCaption);
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getInactiveCaptionTextColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv = new _SystemColor_cl(java.awt.SystemColor.inactiveCaptionText);
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getInactiveCaptionBorderColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv = new _SystemColor_cl(java.awt.SystemColor.inactiveCaptionBorder);
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getWindowColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv = new _SystemColor_cl(java.awt.SystemColor.window);
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getWindowBorderColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv = new _SystemColor_cl(java.awt.SystemColor.windowBorder);
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getWindowTextColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv = new _SystemColor_cl(java.awt.SystemColor.windowText);
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getMenuColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv = new _SystemColor_cl(java.awt.SystemColor.menu);
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getMenuTextColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv = new _SystemColor_cl(java.awt.SystemColor.menuText);
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getTextColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv = new _SystemColor_cl(java.awt.SystemColor.text);
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getTextTextColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv = new _SystemColor_cl(java.awt.SystemColor.textText);
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getTextHighlightColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv = new _SystemColor_cl(java.awt.SystemColor.textHighlight);
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getTextHighlightTextColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv = new _SystemColor_cl(java.awt.SystemColor.textHighlightText);
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getTextInactiveTextColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv = new _SystemColor_cl(java.awt.SystemColor.textInactiveText);
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getControlColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv = new _SystemColor_cl(java.awt.SystemColor.control);
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getControlTextColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv = new _SystemColor_cl(java.awt.SystemColor.controlText);
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getControlHighlightColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv = new _SystemColor_cl(java.awt.SystemColor.controlHighlight);
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getControlLtHighlightColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv = new _SystemColor_cl(java.awt.SystemColor.controlLtHighlight);
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getControlShadowColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv = new _SystemColor_cl(java.awt.SystemColor.controlShadow);
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getControlDkShadowColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv = new _SystemColor_cl(java.awt.SystemColor.controlDkShadow);
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getScrollbarColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv = new _SystemColor_cl(java.awt.SystemColor.scrollbar);
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getInfoColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv = new _SystemColor_cl(java.awt.SystemColor.info);
    return rv;
  }

  //------------------------------------------------------------------
  public final _Color_if getInfoTextColor() //@
    throws Exception
  {
    checkSecureInvocation();
    _SystemColor_if  rv = new _SystemColor_cl(java.awt.SystemColor.infoText);
    return rv;
  }

  //------------------------------------------------------------------
  public int getRGB()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.SystemColor)_body).getRGB();
  }


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((_String_cl)asString())._body;
//  }

}

// EoF


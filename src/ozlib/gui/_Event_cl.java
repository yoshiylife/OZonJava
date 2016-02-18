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
 * Event implementation
 *
 * @version  $Id: _Event_cl.java,v 1.13 1997/06/24 07:11:14 nito Exp $
 */


public class _Event_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._Event_if
{

  public final int getSHIFT_MASK() throws Exception
    { return _static_getSHIFT_MASK(); }

  public static final int _static_getSHIFT_MASK() throws Exception
    { return java.awt.Event.SHIFT_MASK; }

  public final int getCTRL_MASK() throws Exception
    { return _static_getCTRL_MASK(); }

  public static final int _static_getCTRL_MASK() throws Exception
    { return java.awt.Event.CTRL_MASK; }

  public final int getMETA_MASK() throws Exception
    { return _static_getMETA_MASK(); }

  public static final int _static_getMETA_MASK() throws Exception
    { return java.awt.Event.META_MASK; }

  public final int getALT_MASK() throws Exception
    { return _static_getALT_MASK(); }

  public static final int _static_getALT_MASK() throws Exception
    { return java.awt.Event.ALT_MASK; }

  public final int getHOME() throws Exception
    { return _static_getHOME(); }

  public static final int _static_getHOME() throws Exception
    { return java.awt.Event.HOME; }

  public final int getEND() throws Exception
    { return _static_getEND(); }

  public static final int _static_getEND() throws Exception
    { return java.awt.Event.END; }

  public final int getPGUP() throws Exception
    { return _static_getPGUP(); }

  public static final int _static_getPGUP() throws Exception
    { return java.awt.Event.PGUP; }

  public final int getPGDN() throws Exception
    { return _static_getPGDN(); }

  public static final int _static_getPGDN() throws Exception
    { return java.awt.Event.PGDN; }

  public final int getUP() throws Exception
    { return _static_getUP(); }

  public static final int _static_getUP() throws Exception
    { return java.awt.Event.UP; }

  public final int getDOWN() throws Exception
    { return _static_getDOWN(); }

  public static final int _static_getDOWN() throws Exception
    { return java.awt.Event.DOWN; }

  public final int getLEFT() throws Exception
    { return _static_getLEFT(); }

  public static final int _static_getLEFT() throws Exception
    { return java.awt.Event.LEFT; }

  public final int getRIGHT() throws Exception
    { return _static_getRIGHT(); }

  public static final int _static_getRIGHT() throws Exception
    { return java.awt.Event.RIGHT; }

  public final int getF1() throws Exception
    { return _static_getF1(); }

  public static final int _static_getF1() throws Exception
    { return java.awt.Event.F1; }

  public final int getF2() throws Exception
    { return _static_getF2(); }

  public static final int _static_getF2() throws Exception
    { return java.awt.Event.F2; }

  public final int getF3() throws Exception
    { return _static_getF3(); }

  public static final int _static_getF3() throws Exception
    { return java.awt.Event.F3; }

  public final int getF4() throws Exception
    { return _static_getF4(); }

  public static final int _static_getF4() throws Exception
    { return java.awt.Event.F4; }

  public final int getF5() throws Exception
    { return _static_getF5(); }

  public static final int _static_getF5() throws Exception
    { return java.awt.Event.F5; }

  public final int getF6() throws Exception
    { return _static_getF6(); }

  public static final int _static_getF6() throws Exception
    { return java.awt.Event.F6; }

  public final int getF7() throws Exception
    { return _static_getF7(); }

  public static final int _static_getF7() throws Exception
    { return java.awt.Event.F7; }

  public final int getF8() throws Exception
    { return _static_getF8(); }

  public static final int _static_getF8() throws Exception
    { return java.awt.Event.F8; }

  public final int getF9() throws Exception
    { return _static_getF9(); }

  public static final int _static_getF9() throws Exception
    { return java.awt.Event.F9; }

  public final int getF10() throws Exception
    { return _static_getF10(); }

  public static final int _static_getF10() throws Exception
    { return java.awt.Event.F10; }

  public final int getF11() throws Exception
    { return _static_getF11(); }

  public static final int _static_getF11() throws Exception
    { return java.awt.Event.F11; }

  public final int getF12() throws Exception
    { return _static_getF12(); }

  public static final int _static_getF12() throws Exception
    { return java.awt.Event.F12; }

  public final int getPRINT_SCREEN() throws Exception
    { return _static_getPRINT_SCREEN(); }

  public static final int _static_getPRINT_SCREEN() throws Exception
    { return java.awt.Event.PRINT_SCREEN; }

  public final int getSCROLL_LOCK() throws Exception
    { return _static_getSCROLL_LOCK(); }

  public static final int _static_getSCROLL_LOCK() throws Exception
    { return java.awt.Event.SCROLL_LOCK; }

  public final int getCAPS_LOCK() throws Exception
    { return _static_getCAPS_LOCK(); }

  public static final int _static_getCAPS_LOCK() throws Exception
    { return java.awt.Event.CAPS_LOCK; }

  public final int getNUM_LOCK() throws Exception
    { return _static_getNUM_LOCK(); }

  public static final int _static_getNUM_LOCK() throws Exception
    { return java.awt.Event.NUM_LOCK; }

  public final int getPAUSE() throws Exception
    { return _static_getPAUSE(); }

  public static final int _static_getPAUSE() throws Exception
    { return java.awt.Event.PAUSE; }

  public final int getINSERT() throws Exception
    { return _static_getINSERT(); }

  public static final int _static_getINSERT() throws Exception
    { return java.awt.Event.INSERT; }

  public final int getENTER() throws Exception
    { return _static_getENTER(); }

  public static final int _static_getENTER() throws Exception
    { return java.awt.Event.ENTER; }

  public final int getBACK_SPACE() throws Exception
    { return _static_getBACK_SPACE(); }

  public static final int _static_getBACK_SPACE() throws Exception
    { return java.awt.Event.BACK_SPACE; }

  public final int getTAB() throws Exception
    { return _static_getTAB(); }

  public static final int _static_getTAB() throws Exception
    { return java.awt.Event.TAB; }

  public final int getESCAPE() throws Exception
    { return _static_getESCAPE(); }

  public static final int _static_getESCAPE() throws Exception
    { return java.awt.Event.ESCAPE; }

  public final int getDELETE() throws Exception
    { return _static_getDELETE(); }

  public static final int _static_getDELETE() throws Exception
    { return java.awt.Event.DELETE; }

  public final int getWINDOW_DESTROY() throws Exception
    { return _static_getWINDOW_DESTROY(); }

  public static final int _static_getWINDOW_DESTROY() throws Exception
    { return java.awt.Event.WINDOW_DESTROY; }

  public final int getWINDOW_EXPOSE() throws Exception
    { return _static_getWINDOW_EXPOSE(); }

  public static final int _static_getWINDOW_EXPOSE() throws Exception
    { return java.awt.Event.WINDOW_EXPOSE; }

  public final int getWINDOW_ICONIFY() throws Exception
    { return _static_getWINDOW_ICONIFY(); }

  public static final int _static_getWINDOW_ICONIFY() throws Exception
    { return java.awt.Event.WINDOW_ICONIFY; }

  public final int getWINDOW_DEICONIFY() throws Exception
    { return _static_getWINDOW_DEICONIFY(); }

  public static final int _static_getWINDOW_DEICONIFY() throws Exception
    { return java.awt.Event.WINDOW_DEICONIFY; }

  public final int getWINDOW_MOVED() throws Exception
    { return _static_getWINDOW_MOVED(); }

  public static final int _static_getWINDOW_MOVED() throws Exception
    { return java.awt.Event.WINDOW_MOVED; }

  public final int getKEY_PRESS() throws Exception
    { return _static_getKEY_PRESS(); }

  public static final int _static_getKEY_PRESS() throws Exception
    { return java.awt.Event.KEY_PRESS; }

  public final int getKEY_RELEASE() throws Exception
    { return _static_getKEY_RELEASE(); }

  public static final int _static_getKEY_RELEASE() throws Exception
    { return java.awt.Event.KEY_RELEASE; }

  public final int getKEY_ACTION() throws Exception
    { return _static_getKEY_ACTION(); }

  public static final int _static_getKEY_ACTION() throws Exception
    { return java.awt.Event.KEY_ACTION; }

  public final int getKEY_ACTION_RELEASE() throws Exception
    { return _static_getKEY_ACTION_RELEASE(); }

  public static final int _static_getKEY_ACTION_RELEASE() throws Exception
    { return java.awt.Event.KEY_ACTION_RELEASE; }

  public final int getMOUSE_DOWN() throws Exception
    { return _static_getMOUSE_DOWN(); }

  public static final int _static_getMOUSE_DOWN() throws Exception
    { return java.awt.Event.MOUSE_DOWN; }

  public final int getMOUSE_UP() throws Exception
    { return _static_getMOUSE_UP(); }

  public static final int _static_getMOUSE_UP() throws Exception
    { return java.awt.Event.MOUSE_UP; }

  public final int getMOUSE_MOVE() throws Exception
    { return _static_getMOUSE_MOVE(); }

  public static final int _static_getMOUSE_MOVE() throws Exception
    { return java.awt.Event.MOUSE_MOVE; }

  public final int getMOUSE_ENTER() throws Exception
    { return _static_getMOUSE_ENTER(); }

  public static final int _static_getMOUSE_ENTER() throws Exception
    { return java.awt.Event.MOUSE_ENTER; }

  public final int getMOUSE_EXIT() throws Exception
    { return _static_getMOUSE_EXIT(); }

  public static final int _static_getMOUSE_EXIT() throws Exception
    { return java.awt.Event.MOUSE_EXIT; }

  public final int getMOUSE_DRAG() throws Exception
    { return _static_getMOUSE_DRAG(); }

  public static final int _static_getMOUSE_DRAG() throws Exception
    { return java.awt.Event.MOUSE_DRAG; }

  public final int getSCROLL_LINE_UP() throws Exception
    { return _static_getSCROLL_LINE_UP(); }

  public static final int _static_getSCROLL_LINE_UP() throws Exception
    { return java.awt.Event.SCROLL_LINE_UP; }

  public final int getSCROLL_LINE_DOWN() throws Exception
    { return _static_getSCROLL_LINE_DOWN(); }

  public static final int _static_getSCROLL_LINE_DOWN() throws Exception
    { return java.awt.Event.SCROLL_LINE_DOWN; }

  public final int getSCROLL_PAGE_UP() throws Exception
    { return _static_getSCROLL_PAGE_UP(); }

  public static final int _static_getSCROLL_PAGE_UP() throws Exception
    { return java.awt.Event.SCROLL_PAGE_UP; }

  public final int getSCROLL_PAGE_DOWN() throws Exception
    { return _static_getSCROLL_PAGE_DOWN(); }

  public static final int _static_getSCROLL_PAGE_DOWN() throws Exception
    { return java.awt.Event.SCROLL_PAGE_DOWN; }

  public final int getSCROLL_ABSOLUTE() throws Exception
    { return _static_getSCROLL_ABSOLUTE(); }

  public static final int _static_getSCROLL_ABSOLUTE() throws Exception
    { return java.awt.Event.SCROLL_ABSOLUTE; }

  public final int getSCROLL_BEGIN() throws Exception
    { return _static_getSCROLL_BEGIN(); }

  public static final int _static_getSCROLL_BEGIN() throws Exception
    { return java.awt.Event.SCROLL_BEGIN; }

  public final int getSCROLL_END() throws Exception
    { return _static_getSCROLL_END(); }

  public static final int _static_getSCROLL_END() throws Exception
    { return java.awt.Event.SCROLL_END; }

  public final int getLIST_SELECT() throws Exception
    { return _static_getLIST_SELECT(); }

  public static final int _static_getLIST_SELECT() throws Exception
    { return java.awt.Event.LIST_SELECT; }

  public final int getLIST_DESELECT() throws Exception
    { return _static_getLIST_DESELECT(); }

  public static final int _static_getLIST_DESELECT() throws Exception
    { return java.awt.Event.LIST_DESELECT; }

  public final int getACTION_EVENT() throws Exception
    { return _static_getACTION_EVENT(); }

  public static final int _static_getACTION_EVENT() throws Exception
    { return java.awt.Event.ACTION_EVENT; }

  public final int getLOAD_FILE() throws Exception
    { return _static_getLOAD_FILE(); }

  public static final int _static_getLOAD_FILE() throws Exception
    { return java.awt.Event.LOAD_FILE; }

  public final int getSAVE_FILE() throws Exception
    { return _static_getSAVE_FILE(); }

  public static final int _static_getSAVE_FILE() throws Exception
    { return java.awt.Event.SAVE_FILE; }

  public final int getGOT_FOCUS() throws Exception
    { return _static_getGOT_FOCUS(); }

  public static final int _static_getGOT_FOCUS() throws Exception
    { return java.awt.Event.GOT_FOCUS; }

  public final int getLOST_FOCUS() throws Exception
    { return _static_getLOST_FOCUS(); }

  public static final int _static_getLOST_FOCUS() throws Exception
    { return java.awt.Event.LOST_FOCUS; }

  public JP.go.ipa.oz.lang._Root_if getTarget()
    throws Exception
  {
    return (JP.go.ipa.oz.lang._Root_if)(((_OzHoldable)_body.target).oz());
  }

  public long getWhen()
    throws Exception
  {
    return _body.when;
  }

  public int getId()
    throws Exception
  {
    return _body.id;
  }

  public int getX()
    throws Exception
  {
    return _body.x;
  }

  public int getY()
    throws Exception
  {
    return _body.y;
  }

  public int getKey()
    throws Exception
  {
    return _body.key;
  }

  public int getModifiers()
    throws Exception
  {
    return _body.modifiers;
  }

  public int getClickCount()
    throws Exception
  {
    return _body.clickCount;
  }

  public JP.go.ipa.oz.lang._Root_if getArgument()
    throws Exception
  {
    return (JP.go.ipa.oz.lang._Root_if)(((_OzHoldable)_body.arg).oz());
  }

  public _Event_if getEvent()
    throws Exception
  {
    return new _Event_cl(_body.evt);
  }


  final static java.lang.String  CN = "Event";
  java.awt.Event  _body;

  
  //================================================== constructors

  _Event_cl(java.awt.Event e)
    throws Exception
  {
    _body = e;
  }

  public _Event_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  /**------------------------------------------------------------------
   */
  public java.lang.Object _new_newEvent(JP.go.ipa.oz.lang._Root_if target,
                            long when, int id, int x, int y,
                            int key, int modifiers,
                            JP.go.ipa.oz.lang._Root_if arg)
    throws Exception
  {
    _body = new java.awt.Event(target, when, id, x, y, key, modifiers, arg);
    return this;
  }

  /**------------------------------------------------------------------
   */
  public java.lang.Object _new_newEvent(JP.go.ipa.oz.lang._Root_if target,
                            long when, int id, int x, int y, int key,
                            int modifiers)
    throws Exception
  {
    _body = new java.awt.Event(target, when, id, x, y, key, modifiers);
    return this;
  }

  /**------------------------------------------------------------------
   */
  public java.lang.Object _new_newEvent(JP.go.ipa.oz.lang._Root_if target, int id,
                            JP.go.ipa.oz.lang._Root_if arg)
    throws Exception
  {
    _body = new java.awt.Event(target, id, arg);
    return this;
  }


  //======================================== OZ method implementation

  /**------------------------------------------------------------------
   */
  public synchronized _String_if asString() //@
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = _body.toString();
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  /**------------------------------------------------------------------
   */
  public boolean controlDown()
    throws Exception
  {
    checkSecureInvocation();
    return _body.controlDown();
  }

  /**------------------------------------------------------------------
   */
  public boolean metaDown()
    throws Exception
  {
    checkSecureInvocation();
    return _body.metaDown();
  }

  /**------------------------------------------------------------------
   */
  public boolean shiftDown()
    throws Exception
  {
    checkSecureInvocation();
    return _body.shiftDown();
  }

  /**------------------------------------------------------------------
   */
  public void translate(int x, int y)
    throws Exception
  {
    checkSecureInvocation();
    _body.translate(x, y);
  }


  //================================================== protected methods
  //protected String paramString() {}


  //======================================== support method implementation

//  public java.lang.String toString()
//  {
//    java.lang.String  rv = _body.toString();
//    return rv;
//  }

}

// EoF

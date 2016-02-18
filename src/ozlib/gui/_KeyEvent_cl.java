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
 * KeyEvent implementation
 *
 * @version  $Id: _KeyEvent_cl.java,v 1.11 1997/07/04 02:27:08 nito Exp $
 * @see      _KeyEvent_if
 * @see      _InputEvent_cl
 */


public class _KeyEvent_cl
  extends    JP.go.ipa.oz.lib.standard._InputEvent_cl
  implements JP.go.ipa.oz.lib.standard._KeyEvent_if
{

  public final int getKEY_FIRST() throws Exception
    { return _static_getKEY_FIRST(); }

  public static final int _static_getKEY_FIRST() throws Exception
    { return java.awt.event.KeyEvent.KEY_FIRST; }

  public final int getKEY_LAST() throws Exception
    { return _static_getKEY_LAST(); }

  public static final int _static_getKEY_LAST() throws Exception
    { return java.awt.event.KeyEvent.KEY_LAST; }

  public final int getKEY_TYPED() throws Exception
    { return _static_getKEY_TYPED(); }

  public static final int _static_getKEY_TYPED() throws Exception
    { return java.awt.event.KeyEvent.KEY_TYPED; }

  public final int getKEY_PRESSED() throws Exception
    { return _static_getKEY_PRESSED(); }

  public static final int _static_getKEY_PRESSED() throws Exception
    { return java.awt.event.KeyEvent.KEY_PRESSED; }

  public final int getKEY_RELEASED() throws Exception
    { return _static_getKEY_RELEASED(); }

  public static final int _static_getKEY_RELEASED() throws Exception
    { return java.awt.event.KeyEvent.KEY_RELEASED; }

  public final int getVK_ENTER() throws Exception
    { return _static_getVK_ENTER(); }

  public static final int _static_getVK_ENTER() throws Exception
    { return java.awt.event.KeyEvent.VK_ENTER; }

  public final int getVK_BACK_SPACE() throws Exception
    { return _static_getVK_BACK_SPACE(); }

  public static final int _static_getVK_BACK_SPACE() throws Exception
    { return java.awt.event.KeyEvent.VK_BACK_SPACE; }

  public final int getVK_TAB() throws Exception
    { return _static_getVK_TAB(); }

  public static final int _static_getVK_TAB() throws Exception
    { return java.awt.event.KeyEvent.VK_TAB; }

  public final int getVK_CANCEL() throws Exception
    { return _static_getVK_CANCEL(); }

  public static final int _static_getVK_CANCEL() throws Exception
    { return java.awt.event.KeyEvent.VK_CANCEL; }

  public final int getVK_CLEAR() throws Exception
    { return _static_getVK_CLEAR(); }

  public static final int _static_getVK_CLEAR() throws Exception
    { return java.awt.event.KeyEvent.VK_CLEAR; }

  public final int getVK_SHIFT() throws Exception
    { return _static_getVK_SHIFT(); }

  public static final int _static_getVK_SHIFT() throws Exception
    { return java.awt.event.KeyEvent.VK_SHIFT; }

  public final int getVK_CONTROL() throws Exception
    { return _static_getVK_CONTROL(); }

  public static final int _static_getVK_CONTROL() throws Exception
    { return java.awt.event.KeyEvent.VK_CONTROL; }

  public final int getVK_ALT() throws Exception
    { return _static_getVK_ALT(); }

  public static final int _static_getVK_ALT() throws Exception
    { return java.awt.event.KeyEvent.VK_ALT; }

  public final int getVK_PAUSE() throws Exception
    { return _static_getVK_PAUSE(); }

  public static final int _static_getVK_PAUSE() throws Exception
    { return java.awt.event.KeyEvent.VK_PAUSE; }

  public final int getVK_CAPS_LOCK() throws Exception
    { return _static_getVK_CAPS_LOCK(); }

  public static final int _static_getVK_CAPS_LOCK() throws Exception
    { return java.awt.event.KeyEvent.VK_CAPS_LOCK; }

  public final int getVK_SPACE() throws Exception
    { return _static_getVK_SPACE(); }

  public static final int _static_getVK_SPACE() throws Exception
    { return java.awt.event.KeyEvent.VK_SPACE; }

  public final int getVK_PAGE_UP() throws Exception
    { return _static_getVK_PAGE_UP(); }

  public static final int _static_getVK_PAGE_UP() throws Exception
    { return java.awt.event.KeyEvent.VK_PAGE_UP; }

  public final int getVK_PAGE_DOWN() throws Exception
    { return _static_getVK_PAGE_DOWN(); }

  public static final int _static_getVK_PAGE_DOWN() throws Exception
    { return java.awt.event.KeyEvent.VK_PAGE_DOWN; }

  public final int getVK_END() throws Exception
    { return _static_getVK_END(); }

  public static final int _static_getVK_END() throws Exception
    { return java.awt.event.KeyEvent.VK_END; }

  public final int getVK_HOME() throws Exception
    { return _static_getVK_HOME(); }

  public static final int _static_getVK_HOME() throws Exception
    { return java.awt.event.KeyEvent.VK_HOME; }

  public final int getVK_LEFT() throws Exception
    { return _static_getVK_LEFT(); }

  public static final int _static_getVK_LEFT() throws Exception
    { return java.awt.event.KeyEvent.VK_LEFT; }

  public final int getVK_UP() throws Exception
    { return _static_getVK_UP(); }

  public static final int _static_getVK_UP() throws Exception
    { return java.awt.event.KeyEvent.VK_UP; }

  public final int getVK_RIGHT() throws Exception
    { return _static_getVK_RIGHT(); }

  public static final int _static_getVK_RIGHT() throws Exception
    { return java.awt.event.KeyEvent.VK_RIGHT; }

  public final int getVK_DOWN() throws Exception
    { return _static_getVK_DOWN(); }

  public static final int _static_getVK_DOWN() throws Exception
    { return java.awt.event.KeyEvent.VK_DOWN; }

  public final int getVK_COMMA() throws Exception
    { return _static_getVK_COMMA(); }

  public static final int _static_getVK_COMMA() throws Exception
    { return java.awt.event.KeyEvent.VK_COMMA; }

  public final int getVK_PERIOD() throws Exception
    { return _static_getVK_PERIOD(); }

  public static final int _static_getVK_PERIOD() throws Exception
    { return java.awt.event.KeyEvent.VK_PERIOD; }

  public final int getVK_SLASH() throws Exception
    { return _static_getVK_SLASH(); }

  public static final int _static_getVK_SLASH() throws Exception
    { return java.awt.event.KeyEvent.VK_SLASH; }

  public final int getVK_0() throws Exception
    { return _static_getVK_0(); }

  public static final int _static_getVK_0() throws Exception
    { return java.awt.event.KeyEvent.VK_0; }

  public final int getVK_1() throws Exception
    { return _static_getVK_1(); }

  public static final int _static_getVK_1() throws Exception
    { return java.awt.event.KeyEvent.VK_1; }

  public final int getVK_2() throws Exception
    { return _static_getVK_2(); }

  public static final int _static_getVK_2() throws Exception
    { return java.awt.event.KeyEvent.VK_2; }

  public final int getVK_3() throws Exception
    { return _static_getVK_3(); }

  public static final int _static_getVK_3() throws Exception
    { return java.awt.event.KeyEvent.VK_3; }

  public final int getVK_4() throws Exception
    { return _static_getVK_4(); }

  public static final int _static_getVK_4() throws Exception
    { return java.awt.event.KeyEvent.VK_4; }

  public final int getVK_5() throws Exception
    { return _static_getVK_5(); }

  public static final int _static_getVK_5() throws Exception
    { return java.awt.event.KeyEvent.VK_5; }

  public final int getVK_6() throws Exception
    { return _static_getVK_6(); }

  public static final int _static_getVK_6() throws Exception
    { return java.awt.event.KeyEvent.VK_6; }

  public final int getVK_7() throws Exception
    { return _static_getVK_7(); }

  public static final int _static_getVK_7() throws Exception
    { return java.awt.event.KeyEvent.VK_7; }

  public final int getVK_8() throws Exception
    { return _static_getVK_8(); }

  public static final int _static_getVK_8() throws Exception
    { return java.awt.event.KeyEvent.VK_8; }

  public final int getVK_9() throws Exception
    { return _static_getVK_9(); }

  public static final int _static_getVK_9() throws Exception
    { return java.awt.event.KeyEvent.VK_9; }

  public final int getVK_SEMICOLON() throws Exception
    { return _static_getVK_SEMICOLON(); }

  public static final int _static_getVK_SEMICOLON() throws Exception
    { return java.awt.event.KeyEvent.VK_SEMICOLON; }

  public final int getVK_EQUALS() throws Exception
    { return _static_getVK_EQUALS(); }

  public static final int _static_getVK_EQUALS() throws Exception
    { return java.awt.event.KeyEvent.VK_EQUALS; }

  public final int getVK_A() throws Exception
    { return _static_getVK_A(); }

  public static final int _static_getVK_A() throws Exception
    { return java.awt.event.KeyEvent.VK_A; }

  public final int getVK_B() throws Exception
    { return _static_getVK_B(); }

  public static final int _static_getVK_B() throws Exception
    { return java.awt.event.KeyEvent.VK_B; }

  public final int getVK_C() throws Exception
    { return _static_getVK_C(); }

  public static final int _static_getVK_C() throws Exception
    { return java.awt.event.KeyEvent.VK_C; }

  public final int getVK_D() throws Exception
    { return _static_getVK_D(); }

  public static final int _static_getVK_D() throws Exception
    { return java.awt.event.KeyEvent.VK_D; }

  public final int getVK_E() throws Exception
    { return _static_getVK_E(); }

  public static final int _static_getVK_E() throws Exception
    { return java.awt.event.KeyEvent.VK_E; }

  public final int getVK_F() throws Exception
    { return _static_getVK_F(); }

  public static final int _static_getVK_F() throws Exception
    { return java.awt.event.KeyEvent.VK_F; }

  public final int getVK_G() throws Exception
    { return _static_getVK_G(); }

  public static final int _static_getVK_G() throws Exception
    { return java.awt.event.KeyEvent.VK_G; }

  public final int getVK_H() throws Exception
    { return _static_getVK_H(); }

  public static final int _static_getVK_H() throws Exception
    { return java.awt.event.KeyEvent.VK_H; }

  public final int getVK_I() throws Exception
    { return _static_getVK_I(); }

  public static final int _static_getVK_I() throws Exception
    { return java.awt.event.KeyEvent.VK_I; }

  public final int getVK_J() throws Exception
    { return _static_getVK_J(); }

  public static final int _static_getVK_J() throws Exception
    { return java.awt.event.KeyEvent.VK_J; }

  public final int getVK_K() throws Exception
    { return _static_getVK_K(); }

  public static final int _static_getVK_K() throws Exception
    { return java.awt.event.KeyEvent.VK_K; }

  public final int getVK_L() throws Exception
    { return _static_getVK_L(); }

  public static final int _static_getVK_L() throws Exception
    { return java.awt.event.KeyEvent.VK_L; }

  public final int getVK_M() throws Exception
    { return _static_getVK_M(); }

  public static final int _static_getVK_M() throws Exception
    { return java.awt.event.KeyEvent.VK_M; }

  public final int getVK_N() throws Exception
    { return _static_getVK_N(); }

  public static final int _static_getVK_N() throws Exception
    { return java.awt.event.KeyEvent.VK_N; }

  public final int getVK_O() throws Exception
    { return _static_getVK_O(); }

  public static final int _static_getVK_O() throws Exception
    { return java.awt.event.KeyEvent.VK_O; }

  public final int getVK_P() throws Exception
    { return _static_getVK_P(); }

  public static final int _static_getVK_P() throws Exception
    { return java.awt.event.KeyEvent.VK_P; }

  public final int getVK_Q() throws Exception
    { return _static_getVK_Q(); }

  public static final int _static_getVK_Q() throws Exception
    { return java.awt.event.KeyEvent.VK_Q; }

  public final int getVK_R() throws Exception
    { return _static_getVK_R(); }

  public static final int _static_getVK_R() throws Exception
    { return java.awt.event.KeyEvent.VK_R; }

  public final int getVK_S() throws Exception
    { return _static_getVK_S(); }

  public static final int _static_getVK_S() throws Exception
    { return java.awt.event.KeyEvent.VK_S; }

  public final int getVK_T() throws Exception
    { return _static_getVK_T(); }

  public static final int _static_getVK_T() throws Exception
    { return java.awt.event.KeyEvent.VK_T; }

  public final int getVK_U() throws Exception
    { return _static_getVK_U(); }

  public static final int _static_getVK_U() throws Exception
    { return java.awt.event.KeyEvent.VK_U; }

  public final int getVK_V() throws Exception
    { return _static_getVK_V(); }

  public static final int _static_getVK_V() throws Exception
    { return java.awt.event.KeyEvent.VK_V; }

  public final int getVK_W() throws Exception
    { return _static_getVK_W(); }

  public static final int _static_getVK_W() throws Exception
    { return java.awt.event.KeyEvent.VK_W; }

  public final int getVK_X() throws Exception
    { return _static_getVK_X(); }

  public static final int _static_getVK_X() throws Exception
    { return java.awt.event.KeyEvent.VK_X; }

  public final int getVK_Y() throws Exception
    { return _static_getVK_Y(); }

  public static final int _static_getVK_Y() throws Exception
    { return java.awt.event.KeyEvent.VK_Y; }

  public final int getVK_Z() throws Exception
    { return _static_getVK_Z(); }

  public static final int _static_getVK_Z() throws Exception
    { return java.awt.event.KeyEvent.VK_Z; }

  public final int getVK_OPEN_BRACKET() throws Exception
    { return _static_getVK_OPEN_BRACKET(); }

  public static final int _static_getVK_OPEN_BRACKET() throws Exception
    { return java.awt.event.KeyEvent.VK_OPEN_BRACKET; }

  public final int getVK_BACK_SLASH() throws Exception
    { return _static_getVK_BACK_SLASH(); }

  public static final int _static_getVK_BACK_SLASH() throws Exception
    { return java.awt.event.KeyEvent.VK_BACK_SLASH; }

  public final int getVK_CLOSE_BRACKET() throws Exception
    { return _static_getVK_CLOSE_BRACKET(); }

  public static final int _static_getVK_CLOSE_BRACKET() throws Exception
    { return java.awt.event.KeyEvent.VK_CLOSE_BRACKET; }

  public final int getVK_NUMPAD0() throws Exception
    { return _static_getVK_NUMPAD0(); }

  public static final int _static_getVK_NUMPAD0() throws Exception
    { return java.awt.event.KeyEvent.VK_NUMPAD0; }

  public final int getVK_NUMPAD1() throws Exception
    { return _static_getVK_NUMPAD1(); }

  public static final int _static_getVK_NUMPAD1() throws Exception
    { return java.awt.event.KeyEvent.VK_NUMPAD1; }

  public final int getVK_NUMPAD2() throws Exception
    { return _static_getVK_NUMPAD2(); }

  public static final int _static_getVK_NUMPAD2() throws Exception
    { return java.awt.event.KeyEvent.VK_NUMPAD2; }

  public final int getVK_NUMPAD3() throws Exception
    { return _static_getVK_NUMPAD3(); }

  public static final int _static_getVK_NUMPAD3() throws Exception
    { return java.awt.event.KeyEvent.VK_NUMPAD3; }

  public final int getVK_NUMPAD4() throws Exception
    { return _static_getVK_NUMPAD4(); }

  public static final int _static_getVK_NUMPAD4() throws Exception
    { return java.awt.event.KeyEvent.VK_NUMPAD4; }

  public final int getVK_NUMPAD5() throws Exception
    { return _static_getVK_NUMPAD5(); }

  public static final int _static_getVK_NUMPAD5() throws Exception
    { return java.awt.event.KeyEvent.VK_NUMPAD5; }

  public final int getVK_NUMPAD6() throws Exception
    { return _static_getVK_NUMPAD6(); }

  public static final int _static_getVK_NUMPAD6() throws Exception
    { return java.awt.event.KeyEvent.VK_NUMPAD6; }

  public final int getVK_NUMPAD7() throws Exception
    { return _static_getVK_NUMPAD7(); }

  public static final int _static_getVK_NUMPAD7() throws Exception
    { return java.awt.event.KeyEvent.VK_NUMPAD7; }

  public final int getVK_NUMPAD8() throws Exception
    { return _static_getVK_NUMPAD8(); }

  public static final int _static_getVK_NUMPAD8() throws Exception
    { return java.awt.event.KeyEvent.VK_NUMPAD8; }

  public final int getVK_NUMPAD9() throws Exception
    { return _static_getVK_NUMPAD9(); }

  public static final int _static_getVK_NUMPAD9() throws Exception
    { return java.awt.event.KeyEvent.VK_NUMPAD9; }

  public final int getVK_MULTIPLY() throws Exception
    { return _static_getVK_MULTIPLY(); }

  public static final int _static_getVK_MULTIPLY() throws Exception
    { return java.awt.event.KeyEvent.VK_MULTIPLY; }

  public final int getVK_ADD() throws Exception
    { return _static_getVK_ADD(); }

  public static final int _static_getVK_ADD() throws Exception
    { return java.awt.event.KeyEvent.VK_ADD; }

  public final int getVK_SEPARATER() throws Exception
    { return _static_getVK_SEPARATER(); }

  public static final int _static_getVK_SEPARATER() throws Exception
    { return java.awt.event.KeyEvent.VK_SEPARATER; }

  public final int getVK_SUBTRACT() throws Exception
    { return _static_getVK_SUBTRACT(); }

  public static final int _static_getVK_SUBTRACT() throws Exception
    { return java.awt.event.KeyEvent.VK_SUBTRACT; }

  public final int getVK_DECIMAL() throws Exception
    { return _static_getVK_DECIMAL(); }

  public static final int _static_getVK_DECIMAL() throws Exception
    { return java.awt.event.KeyEvent.VK_DECIMAL; }

  public final int getVK_DIVIDE() throws Exception
    { return _static_getVK_DIVIDE(); }

  public static final int _static_getVK_DIVIDE() throws Exception
    { return java.awt.event.KeyEvent.VK_DIVIDE; }

  public final int getVK_F1() throws Exception
    { return _static_getVK_F1(); }

  public static final int _static_getVK_F1() throws Exception
    { return java.awt.event.KeyEvent.VK_F1; }

  public final int getVK_F2() throws Exception
    { return _static_getVK_F2(); }

  public static final int _static_getVK_F2() throws Exception
    { return java.awt.event.KeyEvent.VK_F2; }

  public final int getVK_F3() throws Exception
    { return _static_getVK_F3(); }

  public static final int _static_getVK_F3() throws Exception
    { return java.awt.event.KeyEvent.VK_F3; }

  public final int getVK_F4() throws Exception
    { return _static_getVK_F4(); }

  public static final int _static_getVK_F4() throws Exception
    { return java.awt.event.KeyEvent.VK_F4; }

  public final int getVK_F5() throws Exception
    { return _static_getVK_F5(); }

  public static final int _static_getVK_F5() throws Exception
    { return java.awt.event.KeyEvent.VK_F5; }

  public final int getVK_F6() throws Exception
    { return _static_getVK_F6(); }

  public static final int _static_getVK_F6() throws Exception
    { return java.awt.event.KeyEvent.VK_F6; }

  public final int getVK_F7() throws Exception
    { return _static_getVK_F7(); }

  public static final int _static_getVK_F7() throws Exception
    { return java.awt.event.KeyEvent.VK_F7; }

  public final int getVK_F8() throws Exception
    { return _static_getVK_F8(); }

  public static final int _static_getVK_F8() throws Exception
    { return java.awt.event.KeyEvent.VK_F8; }

  public final int getVK_F9() throws Exception
    { return _static_getVK_F9(); }

  public static final int _static_getVK_F9() throws Exception
    { return java.awt.event.KeyEvent.VK_F9; }

  public final int getVK_F10() throws Exception
    { return _static_getVK_F10(); }

  public static final int _static_getVK_F10() throws Exception
    { return java.awt.event.KeyEvent.VK_F10; }

  public final int getVK_F11() throws Exception
    { return _static_getVK_F11(); }

  public static final int _static_getVK_F11() throws Exception
    { return java.awt.event.KeyEvent.VK_F11; }

  public final int getVK_F12() throws Exception
    { return _static_getVK_F12(); }

  public static final int _static_getVK_F12() throws Exception
    { return java.awt.event.KeyEvent.VK_F12; }

  public final int getVK_DELETE() throws Exception
    { return _static_getVK_DELETE(); }

  public static final int _static_getVK_DELETE() throws Exception
    { return java.awt.event.KeyEvent.VK_DELETE; }

  public final int getVK_NUM_LOCK() throws Exception
    { return _static_getVK_NUM_LOCK(); }

  public static final int _static_getVK_NUM_LOCK() throws Exception
    { return java.awt.event.KeyEvent.VK_NUM_LOCK; }

  public final int getVK_SCROLL_LOCK() throws Exception
    { return _static_getVK_SCROLL_LOCK(); }

  public static final int _static_getVK_SCROLL_LOCK() throws Exception
    { return java.awt.event.KeyEvent.VK_SCROLL_LOCK; }

  public final int getVK_PRINTSCREEN() throws Exception
    { return _static_getVK_PRINTSCREEN(); }

  public static final int _static_getVK_PRINTSCREEN() throws Exception
    { return java.awt.event.KeyEvent.VK_PRINTSCREEN; }

  public final int getVK_INSERT() throws Exception
    { return _static_getVK_INSERT(); }

  public static final int _static_getVK_INSERT() throws Exception
    { return java.awt.event.KeyEvent.VK_INSERT; }

  public final int getVK_HELP() throws Exception
    { return _static_getVK_HELP(); }

  public static final int _static_getVK_HELP() throws Exception
    { return java.awt.event.KeyEvent.VK_HELP; }

  public final int getVK_META() throws Exception
    { return _static_getVK_META(); }

  public static final int _static_getVK_META() throws Exception
    { return java.awt.event.KeyEvent.VK_META; }

  public final int getVK_BACK_QUOTE() throws Exception
    { return _static_getVK_BACK_QUOTE(); }

  public static final int _static_getVK_BACK_QUOTE() throws Exception
    { return java.awt.event.KeyEvent.VK_BACK_QUOTE; }

  public final int getVK_QUOTE() throws Exception
    { return _static_getVK_QUOTE(); }

  public static final int _static_getVK_QUOTE() throws Exception
    { return java.awt.event.KeyEvent.VK_QUOTE; }

  public final int getVK_FINAL() throws Exception
    { return _static_getVK_FINAL(); }

  public static final int _static_getVK_FINAL() throws Exception
    { return java.awt.event.KeyEvent.VK_FINAL; }

  public final int getVK_CONVERT() throws Exception
    { return _static_getVK_CONVERT(); }

  public static final int _static_getVK_CONVERT() throws Exception
    { return java.awt.event.KeyEvent.VK_CONVERT; }

  public final int getVK_NONCONVERT() throws Exception
    { return _static_getVK_NONCONVERT(); }

  public static final int _static_getVK_NONCONVERT() throws Exception
    { return java.awt.event.KeyEvent.VK_NONCONVERT; }

  public final int getVK_ACCEPT() throws Exception
    { return _static_getVK_ACCEPT(); }

  public static final int _static_getVK_ACCEPT() throws Exception
    { return java.awt.event.KeyEvent.VK_ACCEPT; }

  public final int getVK_MODECHANGE() throws Exception
    { return _static_getVK_MODECHANGE(); }

  public static final int _static_getVK_MODECHANGE() throws Exception
    { return java.awt.event.KeyEvent.VK_MODECHANGE; }

  public final int getVK_KANA() throws Exception
    { return _static_getVK_KANA(); }

  public static final int _static_getVK_KANA() throws Exception
    { return java.awt.event.KeyEvent.VK_KANA; }

  public final int getVK_KANJI() throws Exception
    { return _static_getVK_KANJI(); }

  public static final int _static_getVK_KANJI() throws Exception
    { return java.awt.event.KeyEvent.VK_KANJI; }

  public final int getVK_UNDEFINED() throws Exception
    { return _static_getVK_UNDEFINED(); }

  public static final int _static_getVK_UNDEFINED() throws Exception
    { return java.awt.event.KeyEvent.VK_UNDEFINED; }

  public final char getCHAR_UNDEFINED() throws Exception
    { return _static_getCHAR_UNDEFINED(); }

  public static final char _static_getCHAR_UNDEFINED() throws Exception
    { return java.awt.event.KeyEvent.CHAR_UNDEFINED; }


  static final java.lang.String  CN = "KeyEvent";


  //================================================== constructors

  _KeyEvent_cl(_OzKeyEvent e)
    throws Exception
  {
    _body = e;
  }

  public _KeyEvent_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  //------------------------------------------------------------------
  public java.lang.Object _new_newKeyEvent(_Component_if source, int id, long when,
			       int modifiers, int keyCode)
    throws Exception
  {
    java.awt.Component  arg_source
      = (java.awt.Component)(((_Component_cl)source)._body);
    _OzKeyEvent  e = new _OzKeyEvent(arg_source, id, when, modifiers, keyCode);
    e.bind(this);
    _body = e;
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newKeyEvent(_Component_if source, int id, long when,
			       int modifiers, int keyCode, char keyChar)
    throws Exception
  {
    java.awt.Component  arg_source
      = (java.awt.Component)((((_Component_cl)source)._body).java());
    _OzKeyEvent  e = new _OzKeyEvent(arg_source, id, when, modifiers, keyCode, keyChar);
    e.bind(this);
    _body = e;
    return this;
  }

  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public _String_if asString() //@
    throws Exception
  {
    java.lang.String  rv_tmp = CN.concat("[");
    // some infromation may be included !!!
    rv_tmp = rv_tmp.concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public char getKeyChar()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.event.KeyEvent)_body).getKeyChar();
  }

  //------------------------------------------------------------------
  public int getKeyCode()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.event.KeyEvent)_body).getKeyCode();
  }

  //------------------------------------------------------------------
  public _String_if getKeyModifiersText(int modifiers) //static
    throws Exception
  {
    checkSecureInvocation();
    return _static_getKeyModifiersText(modifiers);
  }

  public static _String_if _static_getKeyModifiersText(int modifiers)
    throws Exception
  {
    java.lang.String  rv_tmp = java.awt.event.KeyEvent.getKeyModifiersText(modifiers);
    if (rv_tmp == null) return null;
    _String_cl  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _String_if getKeyText(int keyCode) //static
    throws Exception
  {
    checkSecureInvocation();
    return _static_getKeyText(keyCode);
  }

  public _String_if _static_getKeyText(int keyCode)
    throws Exception
  {
    java.lang.String  rv_tmp = java.awt.event.KeyEvent.getKeyText(keyCode);
    if (rv_tmp == null) return null;
    _String_cl  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public boolean isActionKey()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.event.KeyEvent)_body).isActionKey();
  }

  //------------------------------------------------------------------
  public _String_if paramString()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.event.KeyEvent)_body).paramString();
    if (rv_tmp == null) return null;
    _String_cl  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public void setKeyChar(char keyChar)
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.event.KeyEvent)_body).setKeyChar(keyChar);
  }

  //------------------------------------------------------------------
  public void setKeyCode(int keyCode)
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.event.KeyEvent)_body).setKeyCode(keyCode);
  }

  //------------------------------------------------------------------
  public void setModifiers(int modifiers)
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.event.KeyEvent)_body).setModifiers(modifiers);
  }

}

// EoF


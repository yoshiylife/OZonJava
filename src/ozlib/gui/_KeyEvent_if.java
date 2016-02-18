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
 * KeyEvent interface
 *
 * @version  $Id: _KeyEvent_if.java,v 1.8 1997/06/24 07:11:15 nito Exp $
 * @see      _InputEvent_if
 */


public interface _KeyEvent_if
  extends JP.go.ipa.oz.lib.standard._InputEvent_if
{

  public int getKEY_FIRST() throws Exception;
  public int getKEY_LAST() throws Exception;
  public int getKEY_TYPED() throws Exception;
  public int getKEY_PRESSED() throws Exception;
  public int getKEY_RELEASED() throws Exception;
  public int getVK_ENTER() throws Exception;
  public int getVK_BACK_SPACE() throws Exception;
  public int getVK_TAB() throws Exception;
  public int getVK_CANCEL() throws Exception;
  public int getVK_CLEAR() throws Exception;
  public int getVK_SHIFT() throws Exception;
  public int getVK_CONTROL() throws Exception;
  public int getVK_ALT() throws Exception;
  public int getVK_PAUSE() throws Exception;
  public int getVK_CAPS_LOCK() throws Exception;
  public int getVK_SPACE() throws Exception;
  public int getVK_PAGE_UP() throws Exception;
  public int getVK_PAGE_DOWN() throws Exception;
  public int getVK_END() throws Exception;
  public int getVK_HOME() throws Exception;
  public int getVK_LEFT() throws Exception;
  public int getVK_UP() throws Exception;
  public int getVK_RIGHT() throws Exception;
  public int getVK_DOWN() throws Exception;
  public int getVK_COMMA() throws Exception;
  public int getVK_PERIOD() throws Exception;
  public int getVK_SLASH() throws Exception;
  public int getVK_0() throws Exception;
  public int getVK_1() throws Exception;
  public int getVK_2() throws Exception;
  public int getVK_3() throws Exception;
  public int getVK_4() throws Exception;
  public int getVK_5() throws Exception;
  public int getVK_6() throws Exception;
  public int getVK_7() throws Exception;
  public int getVK_8() throws Exception;
  public int getVK_9() throws Exception;
  public int getVK_SEMICOLON() throws Exception;
  public int getVK_EQUALS() throws Exception;
  public int getVK_A() throws Exception;
  public int getVK_B() throws Exception;
  public int getVK_C() throws Exception;
  public int getVK_D() throws Exception;
  public int getVK_E() throws Exception;
  public int getVK_F() throws Exception;
  public int getVK_G() throws Exception;
  public int getVK_H() throws Exception;
  public int getVK_I() throws Exception;
  public int getVK_J() throws Exception;
  public int getVK_K() throws Exception;
  public int getVK_L() throws Exception;
  public int getVK_M() throws Exception;
  public int getVK_N() throws Exception;
  public int getVK_O() throws Exception;
  public int getVK_P() throws Exception;
  public int getVK_Q() throws Exception;
  public int getVK_R() throws Exception;
  public int getVK_S() throws Exception;
  public int getVK_T() throws Exception;
  public int getVK_U() throws Exception;
  public int getVK_V() throws Exception;
  public int getVK_W() throws Exception;
  public int getVK_X() throws Exception;
  public int getVK_Y() throws Exception;
  public int getVK_Z() throws Exception;
  public int getVK_OPEN_BRACKET() throws Exception;
  public int getVK_BACK_SLASH() throws Exception;
  public int getVK_CLOSE_BRACKET() throws Exception;
  public int getVK_NUMPAD0() throws Exception;
  public int getVK_NUMPAD1() throws Exception;
  public int getVK_NUMPAD2() throws Exception;
  public int getVK_NUMPAD3() throws Exception;
  public int getVK_NUMPAD4() throws Exception;
  public int getVK_NUMPAD5() throws Exception;
  public int getVK_NUMPAD6() throws Exception;
  public int getVK_NUMPAD7() throws Exception;
  public int getVK_NUMPAD8() throws Exception;
  public int getVK_NUMPAD9() throws Exception;
  public int getVK_MULTIPLY() throws Exception;
  public int getVK_ADD() throws Exception;
  public int getVK_SEPARATER() throws Exception;
  public int getVK_SUBTRACT() throws Exception;
  public int getVK_DECIMAL() throws Exception;
  public int getVK_DIVIDE() throws Exception;
  public int getVK_F1() throws Exception;
  public int getVK_F2() throws Exception;
  public int getVK_F3() throws Exception;
  public int getVK_F4() throws Exception;
  public int getVK_F5() throws Exception;
  public int getVK_F6() throws Exception;
  public int getVK_F7() throws Exception;
  public int getVK_F8() throws Exception;
  public int getVK_F9() throws Exception;
  public int getVK_F10() throws Exception;
  public int getVK_F11() throws Exception;
  public int getVK_F12() throws Exception;
  public int getVK_DELETE() throws Exception;
  public int getVK_NUM_LOCK() throws Exception;
  public int getVK_SCROLL_LOCK() throws Exception;
  public int getVK_PRINTSCREEN() throws Exception;
  public int getVK_INSERT() throws Exception;
  public int getVK_HELP() throws Exception;
  public int getVK_META() throws Exception;
  public int getVK_BACK_QUOTE() throws Exception;
  public int getVK_QUOTE() throws Exception;
  public int getVK_FINAL() throws Exception;
  public int getVK_CONVERT() throws Exception;
  public int getVK_NONCONVERT() throws Exception;
  public int getVK_ACCEPT() throws Exception;
  public int getVK_MODECHANGE() throws Exception;
  public int getVK_KANA() throws Exception;
  public int getVK_KANJI() throws Exception;
  public int getVK_UNDEFINED() throws Exception;
  public char getCHAR_UNDEFINED() throws Exception;

  //================================================== OZ methods
  public char getKeyChar() throws Exception;
  public int getKeyCode() throws Exception;
  public _String_if getKeyModifiersText(int modifiers) throws Exception; //static
  public _String_if getKeyText(int keyCode) throws Exception; //static
  public boolean isActionKey() throws Exception;
  public _String_if paramString() throws Exception;
  public void setKeyChar(char keyChar) throws Exception;
  public void setKeyCode(int keyCode) throws Exception;
  public void setModifiers(int modifiers) throws Exception;
  public _String_if asString() throws Exception;

}

// EoF


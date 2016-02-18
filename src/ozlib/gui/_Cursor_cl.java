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
 * Cursor implementation
 *
 * @version  $Id: _Cursor_cl.java,v 1.11 1997/06/18 12:58:09 nito Exp $
 * @see      _Cursor_if
 */


public class _Cursor_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._Cursor_if
{

  public final int getDEFAULT_CURSOR() throws Exception
    { return _static_getDEFAULT_CURSOR(); }

  public static final int _static_getDEFAULT_CURSOR() throws Exception
    { return java.awt.Cursor.DEFAULT_CURSOR; }

  public final int getCROSSHAIR_CURSOR() throws Exception
    { return _static_getCROSSHAIR_CURSOR(); }

  public static final int _static_getCROSSHAIR_CURSOR() throws Exception
    { return java.awt.Cursor.CROSSHAIR_CURSOR; }

  public final int getTEXT_CURSOR() throws Exception
    { return _static_getTEXT_CURSOR(); }

  public static final int _static_getTEXT_CURSOR() throws Exception
    { return java.awt.Cursor.TEXT_CURSOR; }

  public final int getWAIT_CURSOR() throws Exception
    { return _static_getWAIT_CURSOR(); }

  public static final int _static_getWAIT_CURSOR() throws Exception
    { return java.awt.Cursor.WAIT_CURSOR; }

  public final int getSW_RESIZE_CURSOR() throws Exception
    { return _static_getSW_RESIZE_CURSOR(); }

  public static final int _static_getSW_RESIZE_CURSOR() throws Exception
    { return java.awt.Cursor.SW_RESIZE_CURSOR; }

  public final int getSE_RESIZE_CURSOR() throws Exception
    { return _static_getSE_RESIZE_CURSOR(); }

  public static final int _static_getSE_RESIZE_CURSOR() throws Exception
    { return java.awt.Cursor.SE_RESIZE_CURSOR; }

  public final int getNW_RESIZE_CURSOR() throws Exception
    { return _static_getNW_RESIZE_CURSOR(); }

  public static final int _static_getNW_RESIZE_CURSOR() throws Exception
    { return java.awt.Cursor.NW_RESIZE_CURSOR; }

  public final int getNE_RESIZE_CURSOR() throws Exception
    { return _static_getNE_RESIZE_CURSOR(); }

  public static final int _static_getNE_RESIZE_CURSOR() throws Exception
    { return java.awt.Cursor.NE_RESIZE_CURSOR; }

  public final int getN_RESIZE_CURSOR() throws Exception
    { return _static_getN_RESIZE_CURSOR(); }

  public static final int _static_getN_RESIZE_CURSOR() throws Exception
    { return java.awt.Cursor.N_RESIZE_CURSOR; }

  public final int getS_RESIZE_CURSOR() throws Exception
    { return _static_getS_RESIZE_CURSOR(); }

  public static final int _static_getS_RESIZE_CURSOR() throws Exception
    { return java.awt.Cursor.S_RESIZE_CURSOR; }

  public final int getW_RESIZE_CURSOR() throws Exception
    { return _static_getW_RESIZE_CURSOR(); }

  public static final int _static_getW_RESIZE_CURSOR() throws Exception
    { return java.awt.Cursor.W_RESIZE_CURSOR; }

  public final int getE_RESIZE_CURSOR() throws Exception
    { return _static_getE_RESIZE_CURSOR(); }

  public static final int _static_getE_RESIZE_CURSOR() throws Exception
    { return java.awt.Cursor.E_RESIZE_CURSOR; }

  public final int getHAND_CURSOR() throws Exception
    { return _static_getHAND_CURSOR(); }

  public static final int _static_getHAND_CURSOR() throws Exception
    { return java.awt.Cursor.HAND_CURSOR; }

  public final int getMOVE_CURSOR() throws Exception
    { return _static_getMOVE_CURSOR(); }

  public static final int _static_getMOVE_CURSOR() throws Exception
    { return java.awt.Cursor.MOVE_CURSOR; }



  static final java.lang.String  CN = "Cursor";
  java.awt.Cursor  _body;


  //================================================== constructors

  _Cursor_cl(java.awt.Cursor c)
    throws Exception
  {
    _body = c;
  }

  public _Cursor_cl()
    throws Exception
  {
  }
  

  //======================================== OZ constructor implementation

  //------------------------------------------------------------------
  public java.lang.Object _new_newDefaultCursor() //@
    throws Exception
  {
    _body = new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR);
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newCrossHairCursor() //@
    throws Exception
  {
    _body = new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR);
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newTextCursor() //@
    throws Exception
  {
    _body = new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR);
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newWaitCursor() //@
    throws Exception
  {
    _body = new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR);
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newSWResizeCursor() //@
    throws Exception
  {
    _body = new java.awt.Cursor(java.awt.Cursor.SW_RESIZE_CURSOR);
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newSEResizeCursor() //@
    throws Exception
  {
    _body = new java.awt.Cursor(java.awt.Cursor.SE_RESIZE_CURSOR);
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newNWResizeCursor() //@
    throws Exception
  {
    _body = new java.awt.Cursor(java.awt.Cursor.NW_RESIZE_CURSOR);
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newNEResizeCursor() //@
    throws Exception
  {
    _body = new java.awt.Cursor(java.awt.Cursor.NE_RESIZE_CURSOR);
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newNResizeCursor() //@
    throws Exception
  {
    _body = new java.awt.Cursor(java.awt.Cursor.N_RESIZE_CURSOR);
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newSResizeCursor() //@
    throws Exception
  {
    _body = new java.awt.Cursor(java.awt.Cursor.S_RESIZE_CURSOR);
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newWResizeCursor() //@
    throws Exception
  {
    _body = new java.awt.Cursor(java.awt.Cursor.W_RESIZE_CURSOR);
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newEResizeCursor() //@
    throws Exception
  {
    _body = new java.awt.Cursor(java.awt.Cursor.E_RESIZE_CURSOR);
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newHandCursor() //@
    throws Exception
  {
    _body = new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR);
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newMoveCursor() //@
    throws Exception
  {
    _body = new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR);
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public _String_if asString() //@
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = CN.concat("[type=")
      .concat(java.lang.Integer.toString(getType())).concat("]");
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Cursor_if getDefaultCursor() //static
    throws Exception
  {
    checkSecureInvocation();
    return _static_getDefaultCursor();
  }

  public static _Cursor_if _static_getDefaultCursor()
    throws Exception
  {
    java.awt.Cursor  rv_tmp = java.awt.Cursor.getDefaultCursor();
    _Cursor_if  rv = new _Cursor_cl(rv_tmp);
    return rv;
  }

  //@public _Cursor_if getPredefinedCursor(int type) //static

  //------------------------------------------------------------------
  int getType()
    throws Exception
  {
    return _body.getType();
  }

  /**------------------------------------------------------------------
   */
  /*
  public int hashCode()
  {
    return _body.hashCode();
  }
  */

  //------------------------------------------------------------------
  public boolean isDefault() //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.getType() == java.awt.Cursor.DEFAULT_CURSOR;
  }

  //------------------------------------------------------------------
  public boolean isCrossHair() //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.getType() == java.awt.Cursor.CROSSHAIR_CURSOR;
  }

  //------------------------------------------------------------------
  public boolean isText() //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.getType() == java.awt.Cursor.TEXT_CURSOR;
  }

  //------------------------------------------------------------------
  public boolean isWait() //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.getType() == java.awt.Cursor.WAIT_CURSOR;
  }

  //------------------------------------------------------------------
  public boolean isSWResize() //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.getType() == java.awt.Cursor.SW_RESIZE_CURSOR;
  }

  //------------------------------------------------------------------
  public boolean isSEResize() //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.getType() == java.awt.Cursor.SE_RESIZE_CURSOR;
  }

  //------------------------------------------------------------------
  public boolean isNWResize() //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.getType() == java.awt.Cursor.NW_RESIZE_CURSOR;
  }

  //------------------------------------------------------------------
  public boolean isNEResize() //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.getType() == java.awt.Cursor.NE_RESIZE_CURSOR;
  }

  //------------------------------------------------------------------
  public boolean isNResize() //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.getType() == java.awt.Cursor.N_RESIZE_CURSOR;
  }

  //------------------------------------------------------------------
  public boolean isSResize() //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.getType() == java.awt.Cursor.S_RESIZE_CURSOR;
  }

  //------------------------------------------------------------------
  public boolean isWResize() //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.getType() == java.awt.Cursor.W_RESIZE_CURSOR;
  }

  //------------------------------------------------------------------
  public boolean isEResize() //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.getType() == java.awt.Cursor.E_RESIZE_CURSOR;
  }

  //------------------------------------------------------------------
  public boolean isHand() //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.getType() == java.awt.Cursor.HAND_CURSOR;
  }

  //------------------------------------------------------------------
  public boolean isMove() //@
    throws Exception
  {
    checkSecureInvocation();
    return _body.getType() == java.awt.Cursor.MOVE_CURSOR;
  }


  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((_String_cl)asString())._body;
//  }

}

// EoF

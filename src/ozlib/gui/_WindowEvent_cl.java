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
 * WindowEvent implementation
 *
 * @version  $Id: _WindowEvent_cl.java,v 1.10 1997/07/04 02:27:10 nito Exp $
 * @see      _WindowEvent_if
 * @see      _ComponentEvent_cl
 */


public class _WindowEvent_cl
  extends    JP.go.ipa.oz.lib.standard._ComponentEvent_cl
  implements JP.go.ipa.oz.lib.standard._WindowEvent_if
{

  public final int getWINDOW_FIRST() throws Exception
    { return _static_getWINDOW_FIRST(); }

  public static final int _static_getWINDOW_FIRST() throws Exception
    { return java.awt.event.WindowEvent.WINDOW_FIRST; }

  public final int getWINDOW_LAST() throws Exception
    { return _static_getWINDOW_LAST(); }

  public static final int _static_getWINDOW_LAST() throws Exception
    { return java.awt.event.WindowEvent.WINDOW_LAST; }

  public final int getWINDOW_OPENED() throws Exception
    { return _static_getWINDOW_OPENED(); }

  public static final int _static_getWINDOW_OPENED() throws Exception
    { return java.awt.event.WindowEvent.WINDOW_OPENED; }

  public final int getWINDOW_CLOSING() throws Exception
    { return _static_getWINDOW_CLOSING(); }

  public static final int _static_getWINDOW_CLOSING() throws Exception
    { return java.awt.event.WindowEvent.WINDOW_CLOSING; }

  public final int getWINDOW_CLOSED() throws Exception
    { return _static_getWINDOW_CLOSED(); }

  public static final int _static_getWINDOW_CLOSED() throws Exception
    { return java.awt.event.WindowEvent.WINDOW_CLOSED; }

  public final int getWINDOW_ICONIFIED() throws Exception
    { return _static_getWINDOW_ICONIFIED(); }

  public static final int _static_getWINDOW_ICONIFIED() throws Exception
    { return java.awt.event.WindowEvent.WINDOW_ICONIFIED; }

  public final int getWINDOW_DEICONIFIED() throws Exception
    { return _static_getWINDOW_DEICONIFIED(); }

  public static final int _static_getWINDOW_DEICONIFIED() throws Exception
    { return java.awt.event.WindowEvent.WINDOW_DEICONIFIED; }

  public final int getWINDOW_ACTIVATED() throws Exception
    { return _static_getWINDOW_ACTIVATED(); }

  public static final int _static_getWINDOW_ACTIVATED() throws Exception
    { return java.awt.event.WindowEvent.WINDOW_ACTIVATED; }

  public final int getWINDOW_DEACTIVATED() throws Exception
    { return _static_getWINDOW_DEACTIVATED(); }

  public static final int _static_getWINDOW_DEACTIVATED() throws Exception
    { return java.awt.event.WindowEvent.WINDOW_DEACTIVATED; }



  static final java.lang.String  CN = "WindowEvent";


  //================================================== constructors

  _WindowEvent_cl(_OzWindowEvent e)
    throws Exception
  {
    _body = e;
  }

  public _WindowEvent_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public java.lang.Object _new_newWindowEvent(_Window_if source, int id)
    throws Exception
  {
    java.awt.Window  arg_source = (java.awt.Window)(((_Window_cl)source)._body);
    _OzWindowEvent  e = new _OzWindowEvent(arg_source, id);
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
  public _Window_if getWindow()
    throws Exception
  {
    checkSecureInvocation();
    _OzHoldable  rv_tmp = (_OzHoldable)(((java.awt.event.WindowEvent)_body).getWindow());
    if (rv_tmp == null) return null;
    _Window_if  rv = (_Window_if)(rv_tmp.oz());
    return rv;
  }

  //------------------------------------------------------------------
  public _String_if paramString()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.event.WindowEvent)_body).paramString();
    if (rv_tmp == null) return null;
    _String_cl  rv = new _String_cl(rv_tmp);
    return rv;
  }

}

// EoF


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
 * MouseEvent implementation
 *
 * @version  $Id: _MouseEvent_cl.java,v 1.10 1997/07/04 02:27:09 nito Exp $
 * @see      _MouseEvent_if
 * @see      _InputEvent_cl
 */


public class _MouseEvent_cl
  extends    JP.go.ipa.oz.lib.standard._InputEvent_cl
  implements JP.go.ipa.oz.lib.standard._MouseEvent_if
{

  public final int getMOUSE_FIRST() throws Exception
    { return _static_getMOUSE_FIRST(); }
  public static final int _static_getMOUSE_FIRST() throws Exception
    { return java.awt.event.MouseEvent.MOUSE_FIRST; }

  public final int getMOUSE_LAST() throws Exception
    { return _static_getMOUSE_LAST(); }
  public static final int _static_getMOUSE_LAST() throws Exception
    { return java.awt.event.MouseEvent.MOUSE_LAST; }

  public final int getMOUSE_CLICKED() throws Exception
    { return _static_getMOUSE_CLICKED(); }
  public static final int _static_getMOUSE_CLICKED() throws Exception
    { return java.awt.event.MouseEvent.MOUSE_CLICKED; }

  public final int getMOUSE_PRESSED() throws Exception
    { return _static_getMOUSE_PRESSED(); }
  public static final int _static_getMOUSE_PRESSED() throws Exception
    { return java.awt.event.MouseEvent.MOUSE_PRESSED; }

  public final int getMOUSE_RELEASED() throws Exception
    { return _static_getMOUSE_RELEASED(); }
  public static final int _static_getMOUSE_RELEASED() throws Exception
    { return java.awt.event.MouseEvent.MOUSE_RELEASED; }

  public final int getMOUSE_MOVED() throws Exception
    { return _static_getMOUSE_MOVED(); }
  public static final int _static_getMOUSE_MOVED() throws Exception
    { return java.awt.event.MouseEvent.MOUSE_MOVED; }

  public final int getMOUSE_ENTERED() throws Exception
    { return _static_getMOUSE_ENTERED(); }
  public static final int _static_getMOUSE_ENTERED() throws Exception
    { return java.awt.event.MouseEvent.MOUSE_ENTERED; }

  public final int getMOUSE_EXITED() throws Exception
    { return _static_getMOUSE_EXITED(); }
  public static final int _static_getMOUSE_EXITED() throws Exception
    { return java.awt.event.MouseEvent.MOUSE_EXITED; }

  public final int getMOUSE_DRAGGED() throws Exception
    { return _static_getMOUSE_DRAGGED(); }
  public static final int _static_getMOUSE_DRAGGED() throws Exception
    { return java.awt.event.MouseEvent.MOUSE_DRAGGED; }



  static final java.lang.String  CN = "MouseEvent";


  //================================================== constructors

  _MouseEvent_cl(_OzMouseEvent e)
    throws Exception
  {
    _body = e;
  }

  public _MouseEvent_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public java.lang.Object _new_newMouseEvent(_Component_if source, int id, long when,
				 int modifiers, int x, int y,
				 int clickCount, boolean popupTrigger)
    throws Exception
  {
    java.awt.Component  arg_source
      = (java.awt.Component)(((_Component_cl)source)._body);
    _OzMouseEvent  e
      = new _OzMouseEvent(arg_source, id, when, modifiers, x, y,
			  clickCount, popupTrigger);
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
  public int getX()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.event.MouseEvent)_body).getX();
  }

  //------------------------------------------------------------------
  public int getY()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.event.MouseEvent)_body).getY();
  }

  //------------------------------------------------------------------
  public _Point_if getPoint()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Point  rv_tmp = ((java.awt.event.MouseEvent)_body).getPoint();
    _Point_if  rv = new _Point_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public void translatePoint(int x, int y) //synchronized
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.event.MouseEvent)_body).translatePoint(x, y);
  }

  //------------------------------------------------------------------
  public int getClickCount()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.event.MouseEvent)_body).getClickCount();
  }

  //------------------------------------------------------------------
  public boolean isPopupTrigger()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.event.MouseEvent)_body).isPopupTrigger();
  }

  //------------------------------------------------------------------
  public _String_if paramString()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp = ((java.awt.event.MouseEvent)_body).paramString();
    if (rv_tmp == null) return null;
    _String_cl  rv = new _String_cl(rv_tmp);
    return rv;
  }

}

// EoF


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
 * _OzMouseMotionListener
 *
 * @version  $Id: _OzMouseMotionListener.java,v 1.7 1997/07/18 01:56:44 nito Exp $
 * @see      _MouseMotionListener_cl
 */


public final class _OzMouseMotionListener
  implements JP.go.ipa.oz.lib.standard._OzHoldable,
             java.awt.event.MouseMotionListener
{
  JP.go.ipa.oz.lang._Root_if  _oz;
  java.lang.Object            _java;
  _EventDispatchingQueue_if eventQueue;

  static final int _MOUSEDRAGGED_ = 0;
  static final int _MOUSEMOVED_ = 1;
  //================================================== constructors

  _OzMouseMotionListener(_EventDispatchingQueue_if queue)
    throws Exception
  {
    eventQueue = queue;
  }

  //================================================== methods

  // delegate the event to wrapper object
  //------------------------------------------------------------------
  public void mouseDragged(java.awt.event.MouseEvent e)
  {
    try {
      _EventListener_if listener = null;
      _EventObject_if object = null;
      listener = (_EventListener_if)_oz;
      _OzMouseEvent  arg_e = new _OzMouseEvent(e.getComponent(), e.getID(), e.getWhen(), e.getModifiers(), e.getX(), e.getY(), e.getClickCount(), e.isPopupTrigger());
      object = new _MouseEvent_cl(arg_e);
      _EventUnit_if event = null;
      event = (_EventUnit_cl)
        (new _EventUnit_cl()._new_create(listener, object, _MOUSEDRAGGED_));
      eventQueue.post (event);
    } catch (Exception ex) {
//      _RuntimeException_if ex_oz
//      = (_RuntimeException_cl)
//         (new _RuntimeException_cl()._new_init(ex.getMessage()));
//      throw new JP.go.ipa.oz.lang.OzException(ex_oz);
    }   
  }

  //------------------------------------------------------------------
  public void mouseMoved(java.awt.event.MouseEvent e)
  {
    try {
      _EventListener_if listener = null;
      _EventObject_if object = null;
      listener = (_EventListener_if)_oz;
      _OzMouseEvent  arg_e = new _OzMouseEvent(e.getComponent(), e.getID(), e.getWhen(), e.getModifiers(), e.getX(), e.getY(), e.getClickCount(), e.isPopupTrigger());
      object = new _MouseEvent_cl(arg_e);
      _EventUnit_if event = null;
      event = (_EventUnit_cl)
        (new _EventUnit_cl()._new_create(listener, object, _MOUSEMOVED_));
      eventQueue.post (event);
    } catch (Exception ex) {
//      _RuntimeException_if ex_oz
//      = (_RuntimeException_cl)
//         (new _RuntimeException_cl()._new_init(ex.getMessage()));
//      throw new JP.go.ipa.oz.lang.OzException(ex_oz);
    }   
  }

  public JP.go.ipa.oz.lang._Root_if oz()
    throws Exception
  {
    return _oz;
  }

  public java.lang.Object java()
    throws Exception
  {
    return _java;
  }

  public void bind(JP.go.ipa.oz.lang._Root_if ozobj)
    throws Exception
  {
    _oz = ozobj;
    _java = this;
  }

}

// EoF


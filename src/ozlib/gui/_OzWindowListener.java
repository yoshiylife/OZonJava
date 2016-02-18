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
 * _OzWindowListener
 *
 * @version  $Id: _OzWindowListener.java,v 1.7 1997/07/18 01:56:45 nito Exp $
 * @see      _WindowListener_cl
 */


public final class _OzWindowListener
  implements JP.go.ipa.oz.lib.standard._OzHoldable,
             java.awt.event.WindowListener
{
  JP.go.ipa.oz.lang._Root_if  _oz;
  java.lang.Object            _java;
  _EventDispatchingQueue_if eventQueue;

  static final int _WINDOWACTIVATED_ = 0;
  static final int _WINDOWCLOSED_ = 1;
  static final int _WINDOWCLOSING_ = 2;
  static final int _WINDOWDEACTIVATED_ = 3;
  static final int _WINDOWDEICONIFIED_ = 4;
  static final int _WINDOWICONIFIED_ = 5;
  static final int _WINDOWOPENED_ = 6;
  //================================================== constructors

  _OzWindowListener(_EventDispatchingQueue_if queue)
    throws Exception
  {
    eventQueue = queue;
  }

  //================================================== methods

  // delegate the event to wrapper object
  //------------------------------------------------------------------
  public void windowActivated(java.awt.event.WindowEvent e)
  {
    try {
      _EventListener_if listener = null;
      _EventObject_if object = null;
      listener = (_EventListener_if)_oz;
      _OzWindowEvent  arg_e = new _OzWindowEvent(e.getWindow(), e.getID());
      object = new _WindowEvent_cl(arg_e);
      _EventUnit_if event = null;
      event = (_EventUnit_cl)
        (new _EventUnit_cl()._new_create(listener, object, _WINDOWACTIVATED_));
      eventQueue.post (event);
    } catch (Exception ex) {
//      _RuntimeException_if ex_oz
//      = (_RuntimeException_cl)
//         (new _RuntimeException_cl()._new_init(ex.getMessage()));
//      throw new JP.go.ipa.oz.lang.OzException(ex_oz);
    }   
  }

  //------------------------------------------------------------------
  public void windowClosed(java.awt.event.WindowEvent e)
  {
    try {
      _EventListener_if listener = null;
      _EventObject_if object = null;
      listener = (_EventListener_if)_oz;
      _OzWindowEvent  arg_e = new _OzWindowEvent(e.getWindow(), e.getID());
      object = new _WindowEvent_cl(arg_e);
      _EventUnit_if event = null;
      event = (_EventUnit_cl)
        (new _EventUnit_cl()._new_create(listener, object, _WINDOWCLOSED_));
      eventQueue.post (event);
    } catch (Exception ex) {
//      _RuntimeException_if ex_oz
//      = (_RuntimeException_cl)
//         (new _RuntimeException_cl()._new_init(ex.getMessage()));
//      throw new JP.go.ipa.oz.lang.OzException(ex_oz);
    }   
  }

  //------------------------------------------------------------------
  public void windowClosing(java.awt.event.WindowEvent e)
  {
    try {
      _EventListener_if listener = null;
      _EventObject_if object = null;
      listener = (_EventListener_if)_oz;
      _OzWindowEvent  arg_e = new _OzWindowEvent(e.getWindow(), e.getID());
      object = new _WindowEvent_cl(arg_e);
      _EventUnit_if event = null;
      event = (_EventUnit_cl)
        (new _EventUnit_cl()._new_create(listener, object, _WINDOWCLOSING_));
      eventQueue.post (event);
    } catch (Exception ex) {
//      _RuntimeException_if ex_oz
//      = (_RuntimeException_cl)
//         (new _RuntimeException_cl()._new_init(ex.getMessage()));
//      throw new JP.go.ipa.oz.lang.OzException(ex_oz);
    }   
  }

  //------------------------------------------------------------------
  public void windowDeactivated(java.awt.event.WindowEvent e)
  {
    try {
      _EventListener_if listener = null;
      _EventObject_if object = null;
      listener = (_EventListener_if)_oz;
      _OzWindowEvent  arg_e = new _OzWindowEvent(e.getWindow(), e.getID());
      object = new _WindowEvent_cl(arg_e);
      _EventUnit_if event = null;
      event = (_EventUnit_cl)
        (new _EventUnit_cl()._new_create(listener, object, _WINDOWDEACTIVATED_));
      eventQueue.post (event);
    } catch (Exception ex) {
//      _RuntimeException_if ex_oz
//      = (_RuntimeException_cl)
//         (new _RuntimeException_cl()._new_init(ex.getMessage()));
//      throw new JP.go.ipa.oz.lang.OzException(ex_oz);
    }   
  }

  //------------------------------------------------------------------
  public void windowDeiconified(java.awt.event.WindowEvent e)
  {
    try {
      _EventListener_if listener = null;
      _EventObject_if object = null;
      listener = (_EventListener_if)_oz;
      _OzWindowEvent  arg_e = new _OzWindowEvent(e.getWindow(), e.getID());
      object = new _WindowEvent_cl(arg_e);
      _EventUnit_if event = null;
      event = (_EventUnit_cl)
        (new _EventUnit_cl()._new_create(listener, object, _WINDOWDEICONIFIED_));
      eventQueue.post (event);
    } catch (Exception ex) {
//      _RuntimeException_if ex_oz
//      = (_RuntimeException_cl)
//         (new _RuntimeException_cl()._new_init(ex.getMessage()));
//      throw new JP.go.ipa.oz.lang.OzException(ex_oz);
    }   
  }

  //------------------------------------------------------------------
  public void windowIconified(java.awt.event.WindowEvent e)
  {
    try {
      _EventListener_if listener = null;
      _EventObject_if object = null;
      listener = (_EventListener_if)_oz;
      _OzWindowEvent  arg_e = new _OzWindowEvent(e.getWindow(), e.getID());
      object = new _WindowEvent_cl(arg_e);
      _EventUnit_if event = null;
      event = (_EventUnit_cl)
        (new _EventUnit_cl()._new_create(listener, object, _WINDOWICONIFIED_));
      eventQueue.post (event);
    } catch (Exception ex) {
//      _RuntimeException_if ex_oz
//      = (_RuntimeException_cl)
//         (new _RuntimeException_cl()._new_init(ex.getMessage()));
//      throw new JP.go.ipa.oz.lang.OzException(ex_oz);
    }   
  }

  //------------------------------------------------------------------
  public void windowOpened(java.awt.event.WindowEvent e)
  {
    try {
      _EventListener_if listener = null;
      _EventObject_if object = null;
      listener = (_EventListener_if)_oz;
      _OzWindowEvent  arg_e = new _OzWindowEvent(e.getWindow(), e.getID());
      object = new _WindowEvent_cl(arg_e);
      _EventUnit_if event = null;
      event = (_EventUnit_cl)
        (new _EventUnit_cl()._new_create(listener, object, _WINDOWOPENED_));
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


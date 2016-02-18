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


/**
 * WindowListener implementation
 *
 * @version  $Id: _WindowListener_cl.java,v 1.11 1997/07/18 05:46:13 nito Exp $
 * @see      _WindowListener_if
 */


package JP.go.ipa.oz.lib.standard;


public abstract class _WindowListener_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._WindowListener_if
{

  _OzWindowListener  _body;
  _EventDispatchingQueue_if eventDispatchingQueue;

  static final int _WINDOWACTIVATED_ = 0;
  static final int _WINDOWCLOSED_ = 1;
  static final int _WINDOWCLOSING_ = 2;
  static final int _WINDOWDEACTIVATED_ = 3;
  static final int _WINDOWDEICONIFIED_ = 4;
  static final int _WINDOWICONIFIED_ = 5;
  static final int _WINDOWOPENED_ = 6;
  //================================================== constructors

  public _WindowListener_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public java.lang.Object _new_newWindowListener(_EventDispatchingQueue_if queue)
    throws Exception
  {
    checkSecureInvocation();
    eventDispatchingQueue = queue;
    _OzWindowListener  l = new _OzWindowListener(queue);
    l.bind(this);
    _body = l;
    return this;
  }


  //======================================== OZ method implementation

  public final void dispatch(_EventObject_if object, int type) throws Exception
  {
    checkSecureInvocation();
    _WindowEvent_if event = null;
    event = (_WindowEvent_if) (object);
    if      (type == _WINDOWACTIVATED_)   windowActivated(event);
    else if (type == _WINDOWCLOSED_)      windowClosed(event);
    else if (type == _WINDOWCLOSING_)     windowClosing(event);
    else if (type == _WINDOWDEACTIVATED_) windowDeactivated(event);
    else if (type == _WINDOWDEICONIFIED_) windowDeiconified(event);
    else if (type == _WINDOWICONIFIED_)   windowIconified(event);
    else if (type == _WINDOWOPENED_)      windowOpened(event);
  }

  public void windowActivated(_WindowEvent_if e) throws Exception {}
  public void windowClosed(_WindowEvent_if e) throws Exception {}
  public void windowClosing(_WindowEvent_if e) throws Exception {}
  public void windowDeactivated(_WindowEvent_if e) throws Exception {}
  public void windowDeiconified(_WindowEvent_if e) throws Exception {}
  public void windowIconified(_WindowEvent_if e) throws Exception {}
  public void windowOpened(_WindowEvent_if e) throws Exception {}

}

// EoF


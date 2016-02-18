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
 * MouseMotionListener implementation
 *
 * @version  $Id: _MouseMotionListener_cl.java,v 1.11 1997/07/18 05:46:13 nito Exp $
 * @see      _MouseMotionListener_if
 */


package JP.go.ipa.oz.lib.standard;


public abstract class _MouseMotionListener_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._MouseMotionListener_if
{

  _OzMouseMotionListener  _body;
  _EventDispatchingQueue_if eventDispatchingQueue;

  static final int _MOUSEDRAGGED_ = 0;
  static final int _MOUSEMOVED_ = 1;
  //================================================== constructors

  public _MouseMotionListener_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public java.lang.Object _new_newMouseMotionListener(_EventDispatchingQueue_if queue)
    throws Exception
  {
    checkSecureInvocation();
    eventDispatchingQueue = queue;
    _OzMouseMotionListener  l = new _OzMouseMotionListener(queue);
    l.bind(this);
    _body = l;
    return this;
  }


  //======================================== OZ method implementation

  public final void dispatch(_EventObject_if object, int type) throws Exception
  {
    checkSecureInvocation();
    _MouseEvent_if event = null;
    event = (_MouseEvent_if) (object);
    if      (type == _MOUSEDRAGGED_) mouseDragged(event);
    else if (type == _MOUSEMOVED_) mouseMoved(event);
  }

  public void mouseDragged(_MouseEvent_if e) throws Exception {}
  public void mouseMoved(_MouseEvent_if e) throws Exception {}

}

// EoF


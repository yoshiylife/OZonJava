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
 * ComponentListener implementation
 *
 * @version  $Id: _ComponentListener_cl.java,v 1.11 1997/07/18 05:46:12 nito Exp $
 * @see      _ComponentListener_if
 */


public abstract class _ComponentListener_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._ComponentListener_if
{

  _OzComponentListener  _body;
  _EventDispatchingQueue_if eventDispatchingQueue;

  static final int _COMPONENTHIDDEN_ = 0;
  static final int _COMPONENTMOVED_ = 1;
  static final int _COMPONENTRESIZED_ = 2;
  static final int _COMPONENTSHOWN_ = 3;
  //================================================== constructors

  public _ComponentListener_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public java.lang.Object _new_newComponentListener(_EventDispatchingQueue_if queue)
    throws Exception
  {
    checkSecureInvocation();
    eventDispatchingQueue = queue;
    _OzComponentListener  l = new _OzComponentListener(queue);
    l.bind(this);
    _body = l;
    return this;
  }


  //======================================== OZ method implementation

  public final void dispatch(_EventObject_if object, int type) throws Exception
  {
    checkSecureInvocation();
    _ComponentEvent_if event = null;
    event = (_ComponentEvent_if) (object);
    if      (type == _COMPONENTHIDDEN_)  componentHidden(event);
    else if (type == _COMPONENTMOVED_)   componentMoved(event);
    else if (type == _COMPONENTRESIZED_) componentResized(event);
    else if (type == _COMPONENTSHOWN_)   componentShown(event);
  }

  public void componentHidden(_ComponentEvent_if e) throws Exception {}
  public void componentMoved(_ComponentEvent_if e) throws Exception {}
  public void componentResized(_ComponentEvent_if e) throws Exception {}
  public void componentShown(_ComponentEvent_if e) throws Exception {}
}

// EoF


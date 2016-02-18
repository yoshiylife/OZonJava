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
 * ContainerListener implementation
 *
 * @version  $Id: _ContainerListener_cl.java,v 1.11 1997/07/18 05:46:12 nito Exp $
 * @see      _ContainerListener_if
 */


public abstract class _ContainerListener_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._ContainerListener_if
{

  _OzContainerListener  _body;
  _EventDispatchingQueue_if eventDispatchingQueue;

  static final int _COMPONENTADDED_ = 0;
  static final int _COMPONENTREMOVED_ = 1;
  //================================================== constructors

  public _ContainerListener_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public java.lang.Object _new_newContainerListener(_EventDispatchingQueue_if queue)
    throws Exception
  {
    checkSecureInvocation();
    eventDispatchingQueue = queue;
    _OzContainerListener  l = new _OzContainerListener(queue);
    l.bind(this);
    _body = l;
    return this;
  }


  //======================================== OZ method implementation
  public final void dispatch(_EventObject_if object, int type) throws Exception
  {
    checkSecureInvocation();
    _ContainerEvent_if event = null;
    event = (_ContainerEvent_if) (object);
    if      (type == _COMPONENTADDED_)   componentAdded(event);
    else if (type == _COMPONENTREMOVED_) componentRemoved(event);
  }

  public void componentAdded(_ContainerEvent_if e) throws Exception {}
  public void componentRemoved(_ContainerEvent_if e) throws Exception {}
}

// EoF


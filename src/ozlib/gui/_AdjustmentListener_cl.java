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
 * AdjustmentListener implementation
 *
 * @version  $Id: _AdjustmentListener_cl.java,v 1.11 1997/07/18 05:46:12 nito Exp $
 * @see      _AdjustmentListener_if
 */


public abstract class _AdjustmentListener_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._AdjustmentListener_if
{

  _OzAdjustmentListener  _body;
  _EventDispatchingQueue_if eventDispatchingQueue;

  static final int _ADJUSTMENTVALUECHANGED_ = 0;
  //================================================== constructors

  public _AdjustmentListener_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public java.lang.Object _new_newAdjustmentListener(_EventDispatchingQueue_if queue)
    throws Exception
  {
    checkSecureInvocation();
    eventDispatchingQueue = queue;
    _OzAdjustmentListener  l = new _OzAdjustmentListener(queue);
    l.bind(this);
    _body = l;
    return this;
  }


  //================================================== OZ methods

  public final void dispatch(_EventObject_if object, int type) throws Exception
  {
    checkSecureInvocation();
    _AdjustmentEvent_if event = null;
    event = (_AdjustmentEvent_if) (object);
    if (type == _ADJUSTMENTVALUECHANGED_) adjustmentValueChanged(event);
  }

  public void adjustmentValueChanged(_AdjustmentEvent_if e) throws Exception {}

}

// EoF


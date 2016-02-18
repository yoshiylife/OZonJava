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
 * _OzAdjustmentListener
 *
 * @version  $Id: _OzAdjustmentListener.java,v 1.7 1997/07/18 01:56:44 nito Exp $
 * @see      _AdjustmentListener_cl
 */


public final class _OzAdjustmentListener
  implements JP.go.ipa.oz.lib.standard._OzHoldable,
             java.awt.event.AdjustmentListener
{
  JP.go.ipa.oz.lang._Root_if  _oz;
  java.lang.Object            _java;
  _EventDispatchingQueue_if   eventQueue;

  static final int _ADJUSTMENTVALUECHANGED_ = 0;
  //================================================== constructors

  _OzAdjustmentListener(_EventDispatchingQueue_if queue)
    throws Exception
  {
    eventQueue = queue;
  }

  //================================================== methods

  // delegate the event to wrapper object
  public void adjustmentValueChanged(java.awt.event.AdjustmentEvent e)
  {
    try {
      _EventListener_if listener = null;
      _EventObject_if object = null;
      listener = (_EventListener_if)_oz;
      _OzAdjustmentEvent arg_e = new _OzAdjustmentEvent(e.getAdjustable(), e.getID(), e.getAdjustmentType(), e.getValue());
      object = new _AdjustmentEvent_cl(arg_e);
      _EventUnit_if event = null;
      event = (_EventUnit_cl)
        (new _EventUnit_cl()._new_create(listener, object, _ADJUSTMENTVALUECHANGED_));
      eventQueue.post(event);
    } catch (Exception ex) {
//      _UserException_if ex_oz
//        = (_RuntimeException_cl)
//          (new _RuntimeException_cl()._new_init(ex.getMessage()));
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


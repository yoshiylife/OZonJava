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

/*
 * $Id: _PaintDispatchingQueue_cl.java,v 1.1 1997/08/20 05:18:53 nito Exp $
 */
package JP.go.ipa.oz.lib.standard;

public final class _PaintDispatchingQueue_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements _PaintDispatchingQueue_if
{
  JP.go.ipa.oz.system.OzCondition notEmpty
    = new JP.go.ipa.oz.system.OzCondition (this);
  _PaintQueueSlot_if queue;
  boolean willFree;
  
  public Object _new_create () throws Exception
  {
    queue = null;
    _PaintDispatcher_if dispatch
      = (_PaintDispatcher_cl)(new _PaintDispatcher_cl()._new_create(this));
    if (isGreen ()) {
      turnRed (this);
    }
    JP.go.ipa.oz.lang._Thread_if t
      = (JP.go.ipa.oz.lang._Thread_cl)
	(new JP.go.ipa.oz.lang._Thread_cl()._new_create(dispatch));
    return this;
  }
  
  public final void post(_PaintUnit_if unit) throws Exception
  {
    checkSecureInvocation ();
    enter ();
    try {
      _PaintQueueSlot_if slot
	= (_PaintQueueSlot_cl)(new _PaintQueueSlot_cl()._new_create(unit));
      if (queue == null) {
          queue = slot;
          signal (notEmpty);
      } else {
        _PaintQueueSlot_if q = queue;
         while (true) {
           if (!(q != null)) break;
           q = q.getNext();
         }
         if (changeThreadRedIfNecessary((JP.go.ipa.oz.system.OzSecure) q)) {
           try {
             q.setNext (slot);
           } finally {
             changeRunningToGreen();
           }
         } else {
           q.setNext(slot);
         }
      }
    } finally {
      leave ();
    }
  }
  
  public final _PaintUnit_if take() throws Exception
  {
    checkSecureInvocation();
    enter();
    try {
      while (true) {
        if (!(queue == null)) break;
        wait (notEmpty, 0);
        if (willFree) return null;
      }
      _PaintQueueSlot_if slot = queue;
      queue = queue.getNext();
      return slot.take();
    } finally {
      leave ();
    }
  }
  
  
  public final void destroy() throws Exception
  {
    checkSecureInvocation();
    enter();
    try {
      willFree = true;
      signal (notEmpty);
    } finally {
      leave ();
    }
  }

  public final boolean isDestroyed() throws Exception
  {
    return willFree;
  }
 
  public _PaintDispatchingQueue_cl() throws Exception
  {
    super ();
    willFree = false;
  }
  
}


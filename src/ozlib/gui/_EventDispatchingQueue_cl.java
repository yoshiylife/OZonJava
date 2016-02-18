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
 * $Id: _EventDispatchingQueue_cl.java,v 1.4 1997/07/18 05:46:12 nito Exp $
 */
package JP.go.ipa.oz.lib.standard;

public final class _EventDispatchingQueue_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements _EventDispatchingQueue_if
{
  JP.go.ipa.oz.system.OzCondition notEmpty
    = new JP.go.ipa.oz.system.OzCondition (this);
  _EventQueueSlot_if queue;
  boolean willFree;
  
  public Object _new_create () throws Exception
  {
    queue = null;
    _EventDispatcher_if dispatch
      = (_EventDispatcher_cl)(new _EventDispatcher_cl()._new_create(this));
    if (isGreen ()) {
      turnRed (this);
    }
    JP.go.ipa.oz.lang._Thread_if t
      = (JP.go.ipa.oz.lang._Thread_cl)
	(new JP.go.ipa.oz.lang._Thread_cl()._new_create(dispatch));
    return this;
  }
  
  public final void post(_EventUnit_if event) throws Exception
  {
    checkSecureInvocation ();
    enter ();
    try {
      _EventQueueSlot_if slot
	= (_EventQueueSlot_cl)(new _EventQueueSlot_cl()._new_create(event));
      if (queue == null) {
          queue = slot;
          signal (notEmpty);
      } else {
        _EventQueueSlot_if q = queue;
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
  
  public final _EventUnit_if take() throws Exception
  {
    checkSecureInvocation();
    enter();
    try {
      while (true) {
        if (!(queue == null)) break;
        wait (notEmpty, 0);
        if (willFree) return null;
      }
      _EventQueueSlot_if slot = queue;
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
 
  public _EventDispatchingQueue_cl () throws Exception
  {
    super ();
    willFree = false;
  }
  
}


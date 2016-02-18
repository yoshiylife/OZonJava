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
 * $Id: _EventDispatcher_cl.java,v 1.4 1997/07/18 05:46:12 nito Exp $
 */
package JP.go.ipa.oz.lib.standard;

public final class _EventDispatcher_cl
  extends    JP.go.ipa.oz.lang._Runnable_cl
  implements _EventDispatcher_if
{
  _EventDispatchingQueue_if eventQueue;
  
  public Object _new_create(_EventDispatchingQueue_if queue) throws Exception
  {
    eventQueue = queue;
    return this;
  }
  
  public void run() throws Exception
  {
    checkSecureInvocation();
    _EventUnit_if event = null;
    while (true) {
      if (changeThreadRedIfNecessary((JP.go.ipa.oz.system.OzSecure)eventQueue)) {
        try {
          event = eventQueue.take();
        } finally {
          changeRunningToGreen();
        }
      } else {
        event = eventQueue.take();
      }
      
      if (event == null) break;
      
      dispatch(event);
    }
  }
  
  void dispatch(_EventUnit_if event) throws Exception  {
    _EventListener_if listener = null;
    _EventObject_if object = null;
    _EventListener_if getEventListenerVal;
    if (changeThreadRedIfNecessary((JP.go.ipa.oz.system.OzSecure)event)) {
      try {
        getEventListenerVal = event.getEventListener();
      } finally {
        changeRunningToGreen();
      }
    } else {
      getEventListenerVal = event.getEventListener();
    }
    listener = getEventListenerVal;
    boolean isRedVal;
    if (changeThreadRedIfNecessary((JP.go.ipa.oz.system.OzSecure)listener)) {
      try {
        isRedVal = listener.isRed();
      } finally {
        changeRunningToGreen();
      }
    } else {
      isRedVal = listener.isRed();
    }
    if (isRedVal) {{
        return;
      }
    }
    _EventObject_if getEventObjectVal;
    int type = -1;
    if (changeThreadRedIfNecessary((JP.go.ipa.oz.system.OzSecure)event)) {
      try {
        getEventObjectVal = event.getEventObject();
        type = event.getEventType();
      } finally {
        changeRunningToGreen();
      }
    } else {
      getEventObjectVal = event.getEventObject();
      type = event.getEventType();
    }
    object = getEventObjectVal;
    if (changeThreadRedIfNecessary((JP.go.ipa.oz.system.OzSecure)listener)) {
      try {
        listener.dispatch(object, type);
      } finally {
        changeRunningToGreen();
      }
    } else {
      listener.dispatch (object, type);
    }
  }
  
  public _EventDispatcher_cl () throws Exception { super (); }
}


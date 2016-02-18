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
 * $Id: _EventUnit_cl.java,v 1.2 1997/07/17 07:36:44 nito Exp $
 */
package JP.go.ipa.oz.lib.standard;

final public class _EventUnit_cl
  extends  JP.go.ipa.oz.lang._Root_cl
implements _EventUnit_if {
  _EventObject_if eventObject;
  _EventListener_if eventListener;
  int eventType;
  
  public Object _new_create(_EventListener_if listener, _EventObject_if object, int type)
  throws Exception
  {
    eventListener = listener;
    eventObject = object;
    eventType = type;
    return this;
  }
  
  public _EventListener_if getEventListener() throws Exception
  {
    checkSecureInvocation();
    return eventListener;
  }
  
  public _EventObject_if getEventObject() throws Exception
  {
    checkSecureInvocation();
    return eventObject;
  }
  
  public int getEventType() throws Exception
  {
    checkSecureInvocation();
    return eventType;
  }
  
  public _EventUnit_cl() throws Exception { super (); }
  
}


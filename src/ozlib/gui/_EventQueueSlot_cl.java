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
 * $Id: _EventQueueSlot_cl.java,v 1.2 1997/07/17 07:48:43 nito Exp $
 */
package JP.go.ipa.oz.lib.standard;

public final class _EventQueueSlot_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements _EventQueueSlot_if
{
  _EventQueueSlot_if next;
  _EventUnit_if content;
  
  public Object _new_create(_EventUnit_if event) throws Exception
  {
    content = event;
    next = null;
    return this;
  }
  
  public void setNext(_EventQueueSlot_if slot) throws Exception
  {
    checkSecureInvocation();
    next = slot;
  }
  
  public _EventQueueSlot_if getNext() throws Exception
  {
    checkSecureInvocation();
    return next;
  }
  
  public _EventUnit_if take() throws Exception
  {
    checkSecureInvocation();
    return content;
  }
  
  public _EventQueueSlot_cl () throws Exception { super (); }
  
}


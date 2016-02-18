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
 * $Id: _PaintQueueSlot_cl.java,v 1.1 1997/08/20 05:18:53 nito Exp $
 */
package JP.go.ipa.oz.lib.standard;

public final class _PaintQueueSlot_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements _PaintQueueSlot_if
{
  _PaintQueueSlot_if next;
  _PaintUnit_if content;
  
  public Object _new_create(_PaintUnit_if unit) throws Exception
  {
    content = unit;
    next = null;
    return this;
  }
  
  public void setNext(_PaintQueueSlot_if slot) throws Exception
  {
    checkSecureInvocation();
    next = slot;
  }
  
  public _PaintQueueSlot_if getNext() throws Exception
  {
    checkSecureInvocation();
    return next;
  }
  
  public _PaintUnit_if take() throws Exception
  {
    checkSecureInvocation();
    return content;
  }
  
  public _PaintQueueSlot_cl() throws Exception { super(); }
  
}


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
 * $Id: _EventQueueSlot_if.java,v 1.1 1997/07/16 08:29:18 nito Exp $
 */
package JP.go.ipa.oz.lib.standard;

public interface _EventQueueSlot_if extends JP.go.ipa.oz.lang._Root_if
{
  void setNext(_EventQueueSlot_if slot) throws Exception;
  _EventQueueSlot_if getNext() throws Exception;
  _EventUnit_if take() throws Exception;
}
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
 * $Id: _EventUnit_if.java,v 1.2 1997/07/17 07:36:44 nito Exp $
 */
package JP.go.ipa.oz.lib.standard;

public interface _EventUnit_if extends JP.go.ipa.oz.lang._Root_if
{
  _EventListener_if getEventListener() throws Exception;
  _EventObject_if getEventObject() throws Exception;
  int getEventType() throws Exception;
}


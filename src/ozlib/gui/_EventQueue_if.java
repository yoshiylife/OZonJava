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
 * EventQueue interface
 *
 * @version  $Id: _EventQueue_if.java,v 1.5 1997/06/13 08:49:49 nito Exp $
 */


public interface _EventQueue_if
  extends JP.go.ipa.oz.lang._Root_if
{


  //================================================== OZ public methods
  public _AWTEvent_if getNextEvent() throws Exception; //synchronized
  public _AWTEvent_if peekEvent() throws Exception; //synchronized
  public _AWTEvent_if peekEvent(int id) throws Exception; //synchronized
  public void postEvent(_AWTEvent_if theEvent) throws Exception; //synchronized

}

// EoF


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
 * AWTEvent interface
 *
 * @version  $Id: _AWTEvent_if.java,v 1.8 1997/09/17 04:18:00 nito Exp $
 * @see      _EventObject_if
 */


public interface _AWTEvent_if
  extends JP.go.ipa.oz.lib.standard._EventObject_if
{

  public long getCOMPONENT_EVENT_MASK() throws Exception;
  public long getCONTAINER_EVENT_MASK() throws Exception;
  public long getFOCUS_EVENT_MASK() throws Exception;
  public long getKEY_EVENT_MASK() throws Exception;
  public long getMOUSE_EVENT_MASK() throws Exception;
  public long getMOUSE_MOTION_EVENT_MASK() throws Exception;
  public long getWINDOW_EVENT_MASK() throws Exception;
  public long getACTION_EVENT_MASK() throws Exception;
  public long getADJUSTMENT_EVENT_MASK() throws Exception;
  public long getITEM_EVENT_MASK() throws Exception;
  public long getTEXT_EVENT_MASK() throws Exception;
  public int getRESERVED_ID_MAX() throws Exception;

  //================================================== OZ methods
  public int getID() throws Exception;
  public _String_if paramString() throws Exception;

  public JP.go.ipa.oz.lang._Root_if getSource() throws Exception;
  public _String_if asString() throws Exception;

}

// EoF


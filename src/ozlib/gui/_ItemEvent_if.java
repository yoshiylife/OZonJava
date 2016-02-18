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
 * ItemEvent interface
 *
 * @version  $Id: _ItemEvent_if.java,v 1.7 1997/06/24 07:11:15 nito Exp $
 * @see      _AWTEvent_if
 */


public interface _ItemEvent_if
  extends JP.go.ipa.oz.lib.standard._AWTEvent_if
{

  public int getITEM_FIRST() throws Exception;
  public int getITEM_LAST() throws Exception;
  public int getITEM_STATE_CHANGED() throws Exception;
  public int getSELECTED() throws Exception;
  public int getDESELECTED() throws Exception;

  //================================================== OZ methods
  public JP.go.ipa.oz.lang._Root_if getItem() throws Exception;
  public _ItemSelectable_if getItemSelectable() throws Exception;
  public int getStateChange() throws Exception;
  public _String_if paramString() throws Exception;
  public _String_if asString() throws Exception;

}

// EoF


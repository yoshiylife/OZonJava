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
 * InputEvent interface
 *
 * @version  $Id: _InputEvent_if.java,v 1.6 1997/06/13 08:49:51 nito Exp $
 * @see      _InputEvent_if
 */


public interface _InputEvent_if
  extends JP.go.ipa.oz.lib.standard._ComponentEvent_if
{

  public int getSHIFT_MASK() throws Exception;
  public int getCTRL_MASK() throws Exception;
  public int getMETA_MASK() throws Exception;
  public int getALT_MASK() throws Exception;
  public int getBUTTON1_MASK() throws Exception;
  public int getBUTTON2_MASK() throws Exception;
  public int getBUTTON3_MASK() throws Exception;


  //================================================== OZ methods
  public void consume() throws Exception;
  public int getModifiers() throws Exception;
  public long getWhen() throws Exception;
  public boolean isAltDown() throws Exception;
  public boolean isConsumed() throws Exception;
  public boolean isControlDown() throws Exception;
  public boolean isMetaDown() throws Exception;
  public boolean isShiftDown() throws Exception;

}

// EoF


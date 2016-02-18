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
 * ActionEvent implementation
 *
 * @version  $Id: _ActionEvent_if.java,v 1.7 1997/06/24 07:11:13 nito Exp $
 * @see      _AWTEvent_if
 */


public interface _ActionEvent_if
  extends JP.go.ipa.oz.lib.standard._AWTEvent_if
{

  public int getSHIFT_MASK() throws Exception;
  public int getCTRL_MASK() throws Exception;
  public int getMETA_MASK() throws Exception;
  public int getALT_MASK() throws Exception;
  public int getACTION_FIRST() throws Exception;
  public int getACTION_LAST() throws Exception;
  public int getACTION_PERFORMED() throws Exception;

  //================================================== OZ methods
  public _String_if getActionCommand() throws Exception;
  public int getModifiers() throws Exception;
  public _String_if paramString() throws Exception;
  public _String_if asString() throws Exception;

}

// EoF


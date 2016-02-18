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
 * FocusEvent interface
 *
 * @version  $Id: _FocusEvent_if.java,v 1.7 1997/06/24 07:11:14 nito Exp $
 * @see      _ComponentEvent_if
 */


public interface _FocusEvent_if
  extends JP.go.ipa.oz.lib.standard._ComponentEvent_if
{

  public int getFOCUS_FIRST() throws Exception;
  public int getFOCUS_LAST() throws Exception;
  public int getFOCUS_GAINED() throws Exception;
  public int getFOCUS_LOST() throws Exception;

  //================================================== OZ methods
  public boolean isTemporary() throws Exception;
  public _String_if paramString() throws Exception;
  public _String_if asString() throws Exception;

}

// EoF


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
 * PaintEvent interface
 *
 * @version  $Id: _PaintEvent_if.java,v 1.7 1997/06/24 07:11:16 nito Exp $
 * @see      _ComponentEvent_if
 */


public interface _PaintEvent_if
  extends JP.go.ipa.oz.lib.standard._ComponentEvent_if
{

  public int getPAINT_FIRST() throws Exception;
  public int getPAINT_LAST() throws Exception;
  public int getPAINT() throws Exception;
  public int getUPDATE() throws Exception;

  //================================================== OZ methods
  public _Rectangle_if getUpdateRect() throws Exception;
  public void setUpdateRect(_Rectangle_if updateRect) throws Exception;
  public _String_if paramString() throws Exception;
  public _String_if asString() throws Exception;

}

// EoF


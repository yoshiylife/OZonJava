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
 * WindowEvent interface
 *
 * @version  $Id: _WindowEvent_if.java,v 1.10 1997/06/24 07:11:17 nito Exp $
 * @see      _ComponentEvent_if
 */


public interface _WindowEvent_if
  extends JP.go.ipa.oz.lib.standard._ComponentEvent_if
{

  public int getWINDOW_FIRST() throws Exception;
  public int getWINDOW_LAST() throws Exception;
  public int getWINDOW_OPENED() throws Exception;
  public int getWINDOW_CLOSING() throws Exception;
  public int getWINDOW_CLOSED() throws Exception;
  public int getWINDOW_ICONIFIED() throws Exception;
  public int getWINDOW_DEICONIFIED() throws Exception;
  public int getWINDOW_ACTIVATED() throws Exception;
  public int getWINDOW_DEACTIVATED() throws Exception;


  //================================================== OZ methods
  public _Window_if getWindow() throws Exception;
  public _String_if paramString() throws Exception;
  public _String_if asString() throws Exception;

 }

// EoF


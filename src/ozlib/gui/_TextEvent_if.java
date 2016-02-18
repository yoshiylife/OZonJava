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
 * TextEvent interface
 *
 * @version  $Id: _TextEvent_if.java,v 1.7 1997/06/24 07:11:17 nito Exp $
 * @see      _AWTEvent_if
 */


public interface _TextEvent_if
  extends JP.go.ipa.oz.lib.standard._AWTEvent_if
{

  public int getTEXT_FIRST() throws Exception;
  public int getTEXT_LAST() throws Exception;
  public int getTEXT_VALUE_CHANGED() throws Exception;

  //================================================== OZ methods
  public _String_if asString() throws Exception;
  public _String_if paramString() throws Exception;

}

// EoF


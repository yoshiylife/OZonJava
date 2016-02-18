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
 * FocusListener interface
 *
 * @version  $Id: _FocusListener_if.java,v 1.4 1997/06/13 08:49:50 nito Exp $
 * @see      _FocusListener_if
 */


public interface _FocusListener_if
  extends JP.go.ipa.oz.lib.standard._EventListener_if
{

  //================================================== OZ methods
  public void focusGained(_FocusEvent_if e) throws Exception;
  public void focusLost(_FocusEvent_if e) throws Exception;

}

// EoF


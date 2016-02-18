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


/**
 * Panel interface
 * The default layout for Panel is FlowLayout.
 *
 * @version  $Id: _Panel_if.java,v 1.6 1997/06/24 07:11:16 nito Exp $
 * @see      _Container_if
 */


package JP.go.ipa.oz.lib.standard;


public interface _Panel_if
  extends JP.go.ipa.oz.lib.standard._Container_if
{


  //================================================== OZ methods
  public void addNotify() throws Exception;
  public _String_if asString() throws Exception;

}

// EoF


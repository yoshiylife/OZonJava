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
 * Canvas interface
 *
 * @version  $Id: _Canvas_if.java,v 1.6 1997/06/24 07:11:13 nito Exp $
 * @see      _Component_if
 * @see      _Button_if
 */


public interface _Canvas_if
  extends JP.go.ipa.oz.lib.standard._Component_if
{


  //================================================== OZ public methods
  public void addNotify() throws Exception;
  public void paint(_Graphics_if g) throws Exception;
  public _String_if asString() throws Exception;

}

// EoF

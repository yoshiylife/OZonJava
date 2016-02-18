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
 * MenuShortcut interface
 *
 * @version  $Id: _MenuShortcut_if.java,v 1.8 1997/06/24 07:11:16 nito Exp $
 * @see      _MenuShortcut_cl
 */


public interface _MenuShortcut_if
  extends JP.go.ipa.oz.lang._Root_if
{


  //================================================== OZ public methods
  public int getKey() throws Exception;
  public boolean usesShiftModifier() throws Exception;

  //================================================== protected methods
  //protected String paramString() throws Exception;
  public _String_if asString() throws Exception;

  //================================================== support methods
//  public java.lang.String toString();

}

// EoF

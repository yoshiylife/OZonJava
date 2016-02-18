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
 * Width interface
 *
 * @version  $Id: _Width_if.java,v 1.3 1997/06/13 08:49:57 nito Exp $
 * @see      _Width_cl
 */


public interface _Width_if
  extends JP.go.ipa.oz.lang._Root_if
{
  //================================================== OZ public methods
  public int getWidth() throws Exception; //@
  public void setWidth(int w) throws Exception; //@
}

// EoF

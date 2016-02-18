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
 * ColorModel interface
 *
 * @version  $Id: _ColorModel_if.java,v 1.6 1997/06/24 07:11:13 nito Exp $
 */


package JP.go.ipa.oz.lib.standard;


public interface _ColorModel_if
  extends JP.go.ipa.oz.lang._Root_if
{

  //protected void breed_ColorModel(int bits) throws Exception;

  //================================================== OZ public methods
  // public _ColorModel_if getRGBdefault() throws Exception;  // static
  public int getPixelSize() throws Exception;
  public int getRed(int pixel) throws Exception;
  public int getGreen(int pixel) throws Exception;
  public int getBlue(int pixel) throws Exception;
  public int getAlpha(int pixel) throws Exception;
  public int getRGB(int pixel) throws Exception;
  public void finalize() throws Exception;
}

// EoF


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
 * Pixel implementation
 *
 * @version  $Id: _Pixel_cl.java,v 1.5 1997/06/19 05:12:09 nito Exp $
 */


public final class _Pixel_cl
  extends JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._Pixel_if
{

  final static java.lang.String  CN = "Pixel";
  private int  pixel;


  //================================================== constructors

  public _Pixel_cl() throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public final java.lang.Object _new_newPixel(int p)
    throws Exception
  {
    pixel = p;
    return this;
  }

  //================================================== OZ methods
  public final int getPixel()
    { return pixel; }

  public final void setPixel(int p)
    { pixel = p; }

}

// EoF

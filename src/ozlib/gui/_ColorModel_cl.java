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
 * ColorModel implementation
 *
 * @version  $Id: _ColorModel_cl.java,v 1.4 1997/06/13 08:49:47 nito Exp $
 * @see      _ColorModel_if
 */


public abstract class _ColorModel_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._ColorModel_if
{

  java.awt.image.ColorModel  _body;


  //================================================== constructors

  _ColorModel_cl(java.awt.image.ColorModel cm)
    throws Exception
  {
    _body = cm;
  }

  protected _ColorModel_cl()
    throws Exception
  {
  }


  //================================================== OZ constructors

  protected void breed_ColorModel(int bits)
    throws Exception
  {
  }


  //================================================== OZ methods

  //------------------------------------------------------------------
  /*
   *public _ColorModel_if getRGBdefault()  // static
    throws Exception
  {
    return static_getRGBdefault();
  }
  */
  /*
   *protected _ColorModel_if static_getRGBdefault()
    throws Exception
  {
    java.awt.image.ColorModel  rv_tmp = _body.getRGBdefault();
    _ColorModel_cl  rv = new _ColorModel_cl(rv_tmp);
    return rv;
  }
  */

  //------------------------------------------------------------------
  public int getPixelSize()
    throws Exception
  {
    return _body.getPixelSize();
  }

  //------------------------------------------------------------------
  public abstract int getRed(int pixel);;
  public abstract int getGreen(int pixel);
  public abstract int getBlue(int pixel);
  public abstract int getAlpha(int pixel);

  //------------------------------------------------------------------
  public int getRGB(int pixel)
    throws Exception
  {
    return _body.getRGB(pixel);
  }

  //------------------------------------------------------------------
  public void finalize()
    throws Exception
  {
    _body.finalize();
  }

}

// EoF


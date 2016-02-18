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
 * ImageObserver interface
 *
 * @version  $If$
 */


public abstract class _ImageObserver_cl
  extends JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._ImageObserver_if
{


  final static java.lang.String  CN = "ImageObserver";
  java.awt.image.ImageObserver  _body;


  //================================================== constructors

  protected _ImageObserver_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  protected java.lang.Object _new_newImageObserver()
    throws Exception
  {
    return this;
  }

  /*
    public static final int WIDTH = 1;
    public static final int HEIGHT = 2;
    public static final int PROPERTIES = 4;
    public static final int SOMEBITS = 8;
    public static final int FRAMEBITS = 16;
    public static final int ALLBITS = 32;
    public static final int ERROR = 64;
    public static final int ABORT = 128;
  */

  //================================================== OZ methods
  public final int getWIDTH() throws Exception
    { return _static_getWIDTH(); }

  public static final int _static_getWIDTH() throws Exception
    { return java.awt.image.ImageObserver.WIDTH; }

  public final int getHEIGHT() throws Exception
    { return _static_getHEIGHT(); }

  public static final int _static_getHEIGHT() throws Exception
    { return java.awt.image.ImageObserver.HEIGHT; }

  public final int getPROPERTIES() throws Exception
    { return _static_getPROPERTIES(); }

  public static final int _static_getPROPERTIES() throws Exception
    { return java.awt.image.ImageObserver.PROPERTIES; }

  public final int getSOMEBITS() throws Exception
    { return _static_getSOMEBITS(); }

  public static final int _static_getSOMEBITS() throws Exception
    { return java.awt.image.ImageObserver.SOMEBITS; }

  public final int getFRAMEBITS() throws Exception
    { return _static_getFRAMEBITS(); }

  public static final int _static_getFRAMEBITS() throws Exception
    { return java.awt.image.ImageObserver.FRAMEBITS; }

  public final int getALLBITS() throws Exception
    { return _static_getALLBITS(); }

  public static final int _static_getALLBITS() throws Exception
    { return java.awt.image.ImageObserver.ALLBITS; }

  public final int getERROR() throws Exception
    { return _static_getERROR(); }

  public static final int _static_getERROR() throws Exception
    { return java.awt.image.ImageObserver.ERROR; }

  public final int getABORT() throws Exception
    { return _static_getABORT(); }

  public static final int _static_getABORT() throws Exception
    { return java.awt.image.ImageObserver.ABORT; }

  public abstract boolean imageUpdate(_Image_if img, int infoflags,
			     int x, int y, int width, int height) throws Exception;

}

// EoF

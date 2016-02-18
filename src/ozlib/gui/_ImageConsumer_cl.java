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
 * ImageConsumer interface
 *
 * @version  $Id: _ImageConsumer_cl.java,v 1.6 1997/06/19 09:57:39 nito Exp $
 */


public abstract class _ImageConsumer_cl
  extends JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._ImageConsumer_if
{

  final static java.lang.String  CN = "ImageConsumer";
  java.awt.image.ImageConsumer  _body;


  //================================================== constructors

  protected _ImageConsumer_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  protected java.lang.Object _new_newImageConsumer()
    throws Exception
  {
    return this;
  }

  /*
    public static final int RANDOMPIXELORDER;
    public static final int TOPDOWNLEFTRIGHT;
    public static final int COMPLETESCANLINES;
    public static final int SINGLEPASS;
    public static final int SINGLEFRAME;
    public static final int IMAGEERROR;
    public static final int SINGLEFRAMEDONE;
    public static final int STATICIMAGEDONE;
    public static final int IMAGEABORTED;
  */


  //================================================== OZ methods
  public final int getRANDOMPIXELORDER() throws Exception
    { return _static_getRANDOMPIXELORDER(); }

  public static final int _static_getRANDOMPIXELORDER() throws Exception
    { return java.awt.image.ImageConsumer.RANDOMPIXELORDER; }

  public final int getTOPDOWNLEFTRIGHT() throws Exception
    { return _static_getTOPDOWNLEFTRIGHT(); }

  public static final int _static_getTOPDOWNLEFTRIGHT() throws Exception
    { return java.awt.image.ImageConsumer.TOPDOWNLEFTRIGHT; }

  public final int getCOMPLETESCANLINES() throws Exception
    { return _static_getCOMPLETESCANLINES(); }

  public static final int _static_getCOMPLETESCANLINES() throws Exception
    { return java.awt.image.ImageConsumer.COMPLETESCANLINES; }

  public final int getSINGLEPASS() throws Exception
    { return _static_getSINGLEPASS(); }

  public static final int _static_getSINGLEPASS() throws Exception
    { return java.awt.image.ImageConsumer.SINGLEPASS; }

  public final int getSINGLEFRAME() throws Exception
    { return _static_getSINGLEFRAME(); }

  public static final int _static_getSINGLEFRAME() throws Exception
    { return java.awt.image.ImageConsumer.SINGLEFRAME; }

  public final int getIMAGEERROR() throws Exception
    { return _static_getIMAGEERROR(); }

  public static final int _static_getIMAGEERROR() throws Exception
    { return java.awt.image.ImageConsumer.IMAGEERROR; }

  public final int getSINGLEFRAMEDONE() throws Exception
    { return _static_getSINGLEFRAMEDONE(); }

  public static final int _static_getSINGLEFRAMEDONE() throws Exception
    { return java.awt.image.ImageConsumer.SINGLEFRAMEDONE; }

  public final int getSTATICIMAGEDONE() throws Exception
    { return _static_getSTATICIMAGEDONE(); }

  public static final int _static_getSTATICIMAGEDONE() throws Exception
    { return java.awt.image.ImageConsumer.STATICIMAGEDONE; }

  public final int getIMAGEABORTED() throws Exception
    { return _static_getIMAGEABORTED(); }

  public static final int _static_getIMAGEABORTED() throws Exception
    { return java.awt.image.ImageConsumer.IMAGEABORTED; }

  public abstract void setDimensions(int width, int height) throws Exception;
  public void setProperties(_Dictionary_if props) throws Exception
  {
    checkSecureInvocation();
    if (!(props.isEmpty())) {
      JP.go.ipa.oz.lang._Root_if key = null;
      java.util.Hashtable ht = new java.util.Hashtable();
      _Iterator_if it = props.keyIterator();
      while ((key = it.nextElement()) != null) {
	ht.put(key, props.get(key));
      }
      _body.setProperties(ht);
    }
  }
  public abstract void setColorModel(_ColorModel_if model) throws Exception;
  public abstract void setHints(int hintflag) throws Exception;
  public abstract void setPixels(int x, int y, int w, int h, _ColorModel_if model,
			_ByteArray_if pixels, int off, int scansize) throws Exception;
  public abstract void setPixels(int x, int y, int w, int h, _ColorModel_if model,
			_Array_if pixels, int off, int scansize) throws Exception;
  public abstract void imageComplete(int status) throws Exception;

}

// EoF

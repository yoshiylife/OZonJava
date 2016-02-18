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
 * Image implementation
 *
 * @version  $Id: _Image_cl.java,v 1.12 1997/07/04 02:27:08 nito Exp $
 * @see      _Image_if
 */


public abstract class _Image_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._Image_if
{

  public final int getSCALE_DEFAULT() throws Exception
    { return _static_getSCALE_DEFAULT(); }

  public static final int _static_getSCALE_DEFAULT() throws Exception
    { return java.awt.Image.SCALE_DEFAULT; }

  public final int getSCALE_FAST() throws Exception
    { return _static_getSCALE_FAST(); }

  public static final int _static_getSCALE_FAST() throws Exception
    { return java.awt.Image.SCALE_FAST; }

  public final int getSCALE_SMOOTH() throws Exception
    { return _static_getSCALE_SMOOTH(); }

  public static final int _static_getSCALE_SMOOTH() throws Exception
    { return java.awt.Image.SCALE_SMOOTH; }

  public final int getSCALE_REPLICATE() throws Exception
    { return _static_getSCALE_REPLICATE(); }

  public static final int _static_getSCALE_REPLICATE() throws Exception
    { return java.awt.Image.SCALE_REPLICATE; }

  public final int getSCALE_AREA_AVERAGING() throws Exception
    { return _static_getSCALE_AREA_AVERAGING(); }

  public static final int _static_getSCALE_AREA_AVERAGING() throws Exception
    { return java.awt.Image.SCALE_AREA_AVERAGING; }

//  public final int getUndefinedProperty() throws Exception
//    { return _static_getUndefinedProperty(); }

//  public static final int _static_getUndefinedProperty() throws Exception
//    { return java.awt.Image.UndefinedProperty; }


  static final java.lang.String  CN = "Image";
  java.awt.Image  _body;


  //================================================== constructors

  public _Image_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  public java.lang.Object _new_newImage()
    throws Exception
  {
    return this;
  }


  //======================================== OZ public method implementation

  public abstract void flushResources() throws Exception; //<flush
  public abstract _Graphics_if getGraphics() throws Exception;
  public abstract int getHeight(_ImageObserver_if observer) throws Exception;
  public abstract JP.go.ipa.oz.lang._Root_if getProperty(_String_if name,
							 _ImageObserver_if observer) throws Exception;

  /*
   *public _Image_if getScaledInstance(int width, int height, int hints)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Image  rv_tmp = _body.getScaledInstance(width, height, hints);
    if (rv_tmp == null) return null;
    _Image_if  rv = new _Image_cl(rv_tmp);
    return rv;
  }
  */
    
  public abstract _ImageProducer_if getSource() throws Exception;
  public abstract int getWidth(_ImageObserver_if observer) throws Exception;

}

// EoF


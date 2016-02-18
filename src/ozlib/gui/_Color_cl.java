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
 * Color implementation
 *
 * @version  $Id: _Color_cl.java,v 1.14 1997/07/04 02:27:07 nito Exp $
 * @see      _Color_if
 */


public class _Color_cl
  extends    JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._Color_if
{

  static final java.lang.String  CN = "Color";
  java.awt.Color  _body;


  //================================================== constructors

  _Color_cl(java.awt.Color c)
    throws Exception
  {
    _body = c;
  }

  public _Color_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  //------------------------------------------------------------------
  public java.lang.Object _new_newColor(int r, int g, int b)
    throws Exception
  {
    _body = new java.awt.Color(r, g, b);
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newColor(int rgb)
    throws Exception
  {
    _body = new java.awt.Color(rgb);
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newColor(float r, float g, float b)
    throws Exception
  {
    _body = new java.awt.Color(r, g, b);
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newColorAsWhite()
    throws Exception
  {
    _body = new java.awt.Color(java.awt.Color.white.getRGB());
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newColorAsBlack()
    throws Exception
  {
    _body = new java.awt.Color(java.awt.Color.black.getRGB());
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newColorAsRed()
    throws Exception
  {
    _body = new java.awt.Color(java.awt.Color.red.getRGB());
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newColorAsPink()
    throws Exception
  {
    _body = new java.awt.Color(java.awt.Color.pink.getRGB());
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newColorAsOrange()
    throws Exception
  {
    _body = new java.awt.Color(java.awt.Color.orange.getRGB());
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newColorAsYellow()
    throws Exception
  {
    _body = new java.awt.Color(java.awt.Color.yellow.getRGB());
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newColorAsGreen()
    throws Exception
  {
    _body = new java.awt.Color(java.awt.Color.green.getRGB());
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newColorAsMagenta()
    throws Exception
  {
    _body = new java.awt.Color(java.awt.Color.magenta.getRGB());
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newColorAsCyan()
    throws Exception
  {
    _body = new java.awt.Color(java.awt.Color.cyan.getRGB());
    return this;
  }

  //------------------------------------------------------------------
  public java.lang.Object _new_newColorAsBlue()
    throws Exception
  {
    _body = new java.awt.Color(java.awt.Color.blue.getRGB());
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public _String_if asString()
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  rv_tmp
      = CN.concat("[r=").concat(java.lang.Integer.toString(_body.getRed()))
      .concat(",g=").concat(java.lang.Integer.toString(_body.getGreen()))
      .concat(",b=").concat(java.lang.Integer.toString(_body.getBlue()))
      .concat("]");
    if (rv_tmp == null) return null;
    _String_if  rv = new _String_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Color_if brighter()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Color  rv_tmp = _body.brighter();
    if (rv_tmp == null) return null;
    _Color_if  rv = new _Color_cl(rv_tmp);
    return rv;
  }
    
  //------------------------------------------------------------------
  public _Color_if darker()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Color  rv_tmp = _body.darker();
    if (rv_tmp == null) return null;
    _Color_if  rv = new _Color_cl(rv_tmp);
    return rv;
  }
    
  /**------------------------------------------------------------------
   */
  public _Color_if decode(_String_if nm) //static
    throws Exception
  {
    checkSecureInvocation();
    _Color_if  rv;
    try {
      rv = _static_decode(nm);
    } catch (JP.go.ipa.oz.lang.OzException ex) {
      throw ex;
    }
    return rv;
  }

  public static _Color_if _static_decode(_String_if nm)
    throws Exception
  {
    java.lang.String  arg_nm = ((_String_cl)nm)._body;
    java.awt.Color  rv_tmp = null;
    try {
      rv_tmp = java.awt.Color.decode(arg_nm);
    } catch (java.lang.NumberFormatException ex) {
      _NumberFormatException_if ozex
	= (_NumberFormatException_cl)(new _NumberFormatException_cl()._new_init(ex.getMessage()));
      throw new JP.go.ipa.oz.lang.OzException(ozex);
    }
    if (rv_tmp == null) return null;
    _Color_if  rv = new _Color_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public int getBlue()
    throws Exception
  {
    checkSecureInvocation();
    return _body.getBlue();
  }
    
  //------------------------------------------------------------------
  public _Color_if getColor(_String_if nm) //static
    throws Exception
  {
    checkSecureInvocation();
    return _static_getColor(nm);
  }

  public static _Color_if _static_getColor(_String_if nm)
    throws Exception
  {
    java.lang.String  arg_nm = ((_String_cl)nm)._body;
    java.awt.Color  rv_tmp = java.awt.Color.getColor(arg_nm);
    if (rv_tmp == null) return null;
    _Color_if  rv = new _Color_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Color_if getColor(_String_if nm, _Color_if v) //static
    throws Exception
  {
    checkSecureInvocation();
    return _static_getColor(nm, v);
  }

  public static _Color_if _static_getColor(_String_if nm, _Color_if v)
    throws Exception
  {
    java.lang.String  arg_nm = ((_String_cl)nm)._body;
    java.awt.Color  arg_v = ((_Color_cl)v)._body;
    java.awt.Color  rv_tmp = java.awt.Color.getColor(arg_nm, arg_v);
    if (rv_tmp == null) return null;
    _Color_if  rv = new _Color_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Color_if getColor(_String_if nm, int v) //static
    throws Exception
  {
    checkSecureInvocation();
    return _static_getColor(nm, v);
  }

  public static _Color_if _static_getColor(_String_if nm, int v)
    throws Exception
  {
    java.lang.String  arg_nm = ((_String_cl)nm)._body;
    java.awt.Color  rv_tmp = java.awt.Color.getColor(arg_nm, v);
    if (rv_tmp == null) return null;
    _Color_if  rv = new _Color_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public int getGreen()
    throws Exception
  {
    checkSecureInvocation();
    return _body.getGreen();
  }
    
  //------------------------------------------------------------------
  public _Color_if getHSBColor(float h, float s, float b) //static
    throws Exception
  {
    checkSecureInvocation();
    return _static_getHSBColor(h, s, b);
  }

  public static _Color_if _static_getHSBColor(float h, float s, float b)
    throws Exception
  {
    java.awt.Color  rv_tmp = java.awt.Color.getHSBColor(h, s, b);
    if (rv_tmp == null) return null;
    _Color_if  rv = new _Color_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public int getRed()
    throws Exception
  {
    checkSecureInvocation();
    return _body.getRed();
  }

  //------------------------------------------------------------------
  public int getRGB()
    throws Exception
  {
    checkSecureInvocation();
    return _body.getRGB();
  }

  // public int hashCode()  // in Root
    
  //------------------------------------------------------------------
  public int HSBtoRGB(float hue, float saturation, float brightness) //static
    throws Exception
  {
    checkSecureInvocation();
    return _static_HSBtoRGB(hue, saturation, brightness);
  }
    
  public static int _static_HSBtoRGB(float hue, float saturation, float brightness)
    throws Exception
  {
    return java.awt.Color.HSBtoRGB(hue, saturation, brightness);
  }
    
  //------------------------------------------------------------------
  public _HSBColorValue_if RGBtoHSB(int r, int g, int b, _HSBColorValue_if hsb) //static
    throws Exception
  {
    checkSecureInvocation();
    return _static_RGBtoHSB(r, g, b, hsb);
  }
    
  public _HSBColorValue_if _static_RGBtoHSB(int r, int g, int b, _HSBColorValue_if hsb)
    throws Exception
  {
    float[] hsbvals = new float[3];
    float[] rethsbvals;
    hsbvals[0] = hsb.getHue();
    hsbvals[1] = hsb.getSaturation();
    hsbvals[2] = hsb.getBrightness();
    rethsbvals = java.awt.Color.RGBtoHSB(r, g, b, hsbvals);
    return (_HSBColorValue_if)(new _HSBColorValue_cl()._new_newHSBColor(rethsbvals[0], rethsbvals[1], rethsbvals[2]));
  }
    

  //================================================== support methods

//  public java.lang.String toString()
//  {
//    return ((_String_cl)asString())._body;
//  }

}

// EoF


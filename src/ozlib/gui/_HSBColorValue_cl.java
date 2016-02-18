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
 * HSBColorValue implementation
 *
 * @version  $Id: _HSBColorValue_cl.java,v 1.5 1997/06/17 07:13:58 nito Exp $
 * @see      _HSBColorValue_cl
 */


public class _HSBColorValue_cl
  extends JP.go.ipa.oz.lang._Root_cl
  implements JP.go.ipa.oz.lib.standard._HSBColorValue_if
{

  final static java.lang.String  CN = "HSBColorValue";
  float  hue;
  float  saturation;
  float  brightness;

    
  //================================================== constructors

  _HSBColorValue_cl(float h, float s, float b)
    throws Exception
  {
    hue = h;
    saturation = s;
    brightness = b;
  }

  public _HSBColorValue_cl()
    throws Exception
  {
  }


  //======================================== OZ constructor implementation

  /**------------------------------------------------------------------
   */
  public java.lang.Object _new_newHSBColor(float h, float s, float b)
    throws Exception
  {
    hue = h;
    saturation = s;
    brightness = b;
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public void setHSB(_HSBColorValue_if hsb) //@
    throws Exception
  {
    hue = hsb.getHue();
    saturation = hsb.getSaturation();
    brightness = hsb.getBrightness();
  }

  //------------------------------------------------------------------
  public void setHSB(float h, float s, float b) //@
    throws Exception
  {
    hue = h;
    saturation = s;
    brightness = b;
  }

  //------------------------------------------------------------------
  public _HSBColorValue_if duplicate() //@
    throws Exception
  {
    return new _HSBColorValue_cl(hue, saturation, brightness);
  }

  //------------------------------------------------------------------
  public float getHue() //@
    throws Exception
  {
    return hue;
  }

  //------------------------------------------------------------------
  public void setHue(float h) //@
    throws Exception
  {
    hue = h;
  }

  //------------------------------------------------------------------
  public float getSaturation() //@
    throws Exception
  {
    return saturation;
  }

  //------------------------------------------------------------------
  public void setSaturation(float s) //@
    throws Exception
  {
    saturation = s;
  }

  //------------------------------------------------------------------
  public float getBrightness() //@
    throws Exception
  {
    return brightness;
  }

  //------------------------------------------------------------------
  public void setBrightness(float b) //@
    throws Exception
  {
    brightness = b;
  }

}

// EoF

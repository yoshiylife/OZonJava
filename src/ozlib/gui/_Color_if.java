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
 * Color interface
 *
 * @version  $Id: _Color_if.java,v 1.13 1997/06/24 07:11:13 nito Exp $
 * @see      _Color_cl
 */


public interface _Color_if
  extends JP.go.ipa.oz.lang._Root_if
{


  //================================================== OZ methods
  public _Color_if brighter() throws Exception;
  public _Color_if darker() throws Exception;
  public _Color_if decode(_String_if nm)  throws Exception;
  public int getBlue() throws Exception;
  public _Color_if getColor(_String_if nm) throws Exception; //static
  public _Color_if getColor(_String_if nm, _Color_if v) throws Exception; //static
  public _Color_if getColor(_String_if nm, int v) throws Exception; //static
  public int getGreen() throws Exception;
  public _Color_if getHSBColor(float h, float s, float b) throws Exception; //static
  public int getRed() throws Exception;
  public int getRGB() throws Exception;
  public int HSBtoRGB(float hue, float saturation, float brightness) throws Exception; //static
  public _HSBColorValue_if RGBtoHSB(int r, int g, int b, _HSBColorValue_if hsb) throws Exception; //static
  public _String_if asString() throws Exception;

  //================================================== support methods
  //public java.lang.String toString();

}

// EoF

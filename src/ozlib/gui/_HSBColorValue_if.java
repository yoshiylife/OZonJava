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
 * HSBColorValue interface
 *
 * @version  $Id: _HSBColorValue_if.java,v 1.3 1997/06/13 08:49:51 nito Exp $
 * @see      _HSBColorValue_cl
 */


public interface _HSBColorValue_if
  extends JP.go.ipa.oz.lang._Root_if
{
  //================================================== OZ public methods
  public void setHSB(_HSBColorValue_if hsb) throws Exception; //@
  public void setHSB(float h, float s, float b) throws Exception; //@
  public _HSBColorValue_if duplicate() throws Exception; //@
  public float getHue() throws Exception; //@
  public void setHue(float h) throws Exception; //@
  public float getSaturation() throws Exception; //@
  public void setSaturation(float s) throws Exception; //@
  public float getBrightness() throws Exception; //@
  public void setBrightness(float b) throws Exception; //@
}

// EoF

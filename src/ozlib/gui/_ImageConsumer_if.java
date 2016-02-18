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
 * @version  $Id: _ImageConsumer_if.java,v 1.9 1997/06/19 09:57:39 nito Exp $
 */


public interface _ImageConsumer_if
  extends JP.go.ipa.oz.lang._Root_if
{

  //================================================== OZ methods
  public int getRANDOMPIXELORDER() throws Exception;
  public int getTOPDOWNLEFTRIGHT() throws Exception;
  public int getCOMPLETESCANLINES() throws Exception;
  public int getSINGLEPASS() throws Exception;
  public int getSINGLEFRAME() throws Exception;
  public int getIMAGEERROR() throws Exception;
  public int getSINGLEFRAMEDONE() throws Exception;
  public int getSTATICIMAGEDONE() throws Exception;
  public int getIMAGEABORTED() throws Exception;
  public void setDimensions(int width, int height) throws Exception;
  public void setProperties(_Dictionary_if props) throws Exception;
  public void setColorModel(_ColorModel_if model) throws Exception;
  public void setHints(int hintflag) throws Exception;
  public void setPixels(int x, int y, int w, int h, _ColorModel_if model,
			_ByteArray_if pixels, int off, int scansize) throws Exception;
  public void setPixels(int x, int y, int w, int h, _ColorModel_if model,
			_Sequence_if pixels, int off, int scansize) throws Exception;
  public void imageComplete(int status) throws Exception;

}

// EoF


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
 * @version  $Id: _ImageObserver_if.java,v 1.6 1997/06/13 08:49:51 nito Exp $
 */


public interface _ImageObserver_if
  extends JP.go.ipa.oz.lang._Root_if
{

  //================================================== OZ methods
  public int getWIDTH() throws Exception;
  public int getHEIGHT() throws Exception;
  public int getPROPERTIES() throws Exception;
  public int getSOMEBITS() throws Exception;
  public int getFRAMEBITS() throws Exception;
  public int getALLBITS() throws Exception;
  public int getERROR() throws Exception;
  public int getABORT() throws Exception;
  public boolean imageUpdate(_Image_if img, int infoflags,
			     int x, int y, int width, int height) throws Exception;

}

// EoF


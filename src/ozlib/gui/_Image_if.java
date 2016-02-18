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
 * Image interface
 *
 * @version  $Id: _Image_if.java,v 1.9 1997/06/24 07:11:15 nito Exp $
 * @see      _Image_cl
 */



public interface _Image_if
  extends JP.go.ipa.oz.lang._Root_if
{

    public int getSCALE_DEFAULT() throws Exception;
    public int getSCALE_FAST() throws Exception;
    public int getSCALE_SMOOTH() throws Exception;
    public int getSCALE_REPLICATE() throws Exception;
    public int getSCALE_AREA_AVERAGING() throws Exception;
//    public int getUndefinedProperty() throws Exception;

  //================================================== OZ public methods
  public void flushResources() throws Exception;  //<flush
  public _Graphics_if getGraphics() throws Exception;
  public int getHeight(_ImageObserver_if observer) throws Exception;
  public JP.go.ipa.oz.lang._Root_if getProperty(_String_if name,
							 _ImageObserver_if observer) throws Exception;
  //*public _Image_if getScaledInstance(int width, int height, int hints) throws Exception;
  public _ImageProducer_if getSource() throws Exception;
  public int getWidth(_ImageObserver_if observer) throws Exception;

}

// EoF


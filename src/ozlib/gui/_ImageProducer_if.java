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
 * ImageProducer interface
 *
 * @version  $Id: _ImageProducer_if.java,v 1.5 1997/06/13 08:49:51 nito Exp $
 */


public interface _ImageProducer_if
  extends JP.go.ipa.oz.lang._Root_if
{

  //================================================== OZ methods
  public void addConsumer(_ImageConsumer_if ic) throws Exception;
  public boolean isConsumer(_ImageConsumer_if ic) throws Exception;
  public void removeConsumer(_ImageConsumer_if ic) throws Exception;
  public void requestTopDownLeftRightResend(_ImageConsumer_if ic) throws Exception;
  public void startProduction(_ImageConsumer_if ic) throws Exception;

}

// EoF


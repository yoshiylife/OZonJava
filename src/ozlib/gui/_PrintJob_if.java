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
 * PrintJob interface
 *
 * @version  $Id: _PrintJob_if.java,v 1.5 1997/06/13 08:49:55 nito Exp $
 * @see      _PrintJob_cl
 */


public interface _PrintJob_if
  extends JP.go.ipa.oz.lang._Root_if
{


  //================================================== OZ methods
  public _Graphics_if getGraphics() throws Exception;
  public _Dimension_if getPageDimension() throws Exception;
  public int getPageResolution() throws Exception;
  public boolean lastPageFirst() throws Exception;
  public void end() throws Exception;
  public void finalize() throws Exception;

}

// EoF


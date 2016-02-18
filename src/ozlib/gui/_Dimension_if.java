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
 * Dimension interface
 *
 * @version  $Id: _Dimension_if.java,v 1.9 1997/06/24 07:11:14 nito Exp $
 * @see      _Dimension_cl
 */


public interface _Dimension_if
  extends JP.go.ipa.oz.lang._Root_if
{


  //================================================== OZ public methods
  public int getHeight() throws Exception; //@
  public int getWidth() throws Exception; //@
  public _Dimension_if getSize() throws Exception;
  public void setHeight(int height) throws Exception; //@
  public void setSize(_Dimension_if d) throws Exception;
  public void setSize(int width, int height) throws Exception;
  public void setWidth(int width) throws Exception; //@
  public _String_if asString() throws Exception;

  //================================================== support methods
//  public java.lang.String toString();

}

// EoF

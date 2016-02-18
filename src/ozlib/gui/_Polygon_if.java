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
 * Polygon interface
 *
 * @version  $Id: _Polygon_if.java,v 1.11 1997/06/24 07:11:17 nito Exp $
 * @see      _Polygon_cl
 */


public interface _Polygon_if
  extends JP.go.ipa.oz.lib.standard._Shape_if
{


  // The following constructors are not used in OZ,
  // because we don't have an array data type.

  //================================================== OZ public methods
  public _Sequence_if getPoints() throws Exception;  //@
  public void setPoints(_Sequence_if points) throws Exception;  //@
  public void addPoint(_Point_if p) throws Exception;
  public void addPoint(int x, int y) throws Exception;
  public boolean contains(_Point_if p) throws Exception;
  public boolean contains(int x, int y) throws Exception;
  public _Rectangle_if getBounds() throws Exception;
  public int getNumberOfPoints() throws Exception;  //@
  public _Point_if getPointAt(int i) throws Exception;  //@
  public void translate(int deltaX, int deltaY) throws Exception;
  public _String_if asString() throws Exception;

  //================================================== support methods
//  public java.lang.String toString();

}

// EoF

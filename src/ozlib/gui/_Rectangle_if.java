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
 * Rectangle interface
 *
 * @version  $Id: _Rectangle_if.java,v 1.9 1997/06/24 07:11:17 nito Exp $
 * @see      _Rectangle_cl
 */


public interface _Rectangle_if
  extends JP.go.ipa.oz.lib.standard._Shape_if
{


  //================================================== OZ methods
  public void add(int newx, int newy) throws Exception;
  public void add(_Point_if pt) throws Exception;
  public void add(_Rectangle_if r) throws Exception;
  public boolean contains(_Point_if p) throws Exception;
  public boolean contains(int x, int y) throws Exception;
  public _Rectangle_if getBounds() throws Exception;
  public _Point_if getLocation() throws Exception;
  public int getHeight() throws Exception; //@
  public _Dimension_if getSize() throws Exception;
  public int getX() throws Exception; //@
  public int getY() throws Exception; //@
  public int getWidth() throws Exception; //@
  public void grow(int h, int v) throws Exception;
  public boolean intersects(_Rectangle_if r) throws Exception;
  public _Rectangle_if intersection(_Rectangle_if r) throws Exception;
  public boolean isEmpty() throws Exception;
  public void setBounds(int x, int y, int width, int height) throws Exception;
  public void setBounds(_Rectangle_if r) throws Exception;
  public void setHeight(int height) throws Exception; //@
  public void setLocation(_Point_if p) throws Exception;
  public void setLocation(int x, int y) throws Exception;
  public void setSize(_Dimension_if d) throws Exception;
  public void setSize(int width, int height) throws Exception;
  public void setWidth(int width) throws Exception; //@
  public void setX(int x) throws Exception; //@
  public void setY(int y) throws Exception; //@
  public void translate(int x, int y) throws Exception;
  public _Rectangle_if union(_Rectangle_if r) throws Exception;
  public _String_if asString() throws Exception;

  //================================================== support methods
//  public java.lang.String toString();

}

// EoF

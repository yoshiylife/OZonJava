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
 * Point interface
 *
 * @version  $Id: _Point_if.java,v 1.9 1997/06/24 07:11:17 nito Exp $
 * @see      _Point_cl
 */


public interface _Point_if
  extends JP.go.ipa.oz.lang._Root_if
{


  //================================================== OZ public methods
  public _Point_if getLocation() throws Exception;
  public int getX() throws Exception; //@
  public int getY() throws Exception; //@
  public void move(int x, int y) throws Exception;
  public void setLocation(_Point_if p) throws Exception;
  public void setLocation(int x, int y) throws Exception;
  public void setX(int x) throws Exception; //@
  public void setY(int y) throws Exception; //@
  public void translate(int x, int y) throws Exception;
  public _String_if asString() throws Exception;

  //================================================== support methods
//  public java.lang.String toString();

}

// EoF

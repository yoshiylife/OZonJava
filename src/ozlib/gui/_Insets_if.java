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


/**
 * Insets interface
 *
 * @version  $Id: _Insets_if.java,v 1.11 1997/06/24 07:11:15 nito Exp $
 * @see      _Insets_cl, _Duplicatable_if
 */


package JP.go.ipa.oz.lib.standard;


public interface _Insets_if
  extends JP.go.ipa.oz.lib.standard._Duplicatable_if
{
  //================================================== OZ methods
  public JP.go.ipa.oz.lang._Root_if duplicate() throws Exception;
  public int getBottom() throws Exception; //@
  public int getLeft() throws Exception; //@
  public int getRight() throws Exception; //@
  public int getTop() throws Exception; //@
  public void set(int top, int left, int bottom, int right) throws Exception; //@
  public void setBottom(int bottom) throws Exception; //@
  public void setLeft(int left) throws Exception; //@
  public void setRight(int right) throws Exception; //@
  public void setTop(int top) throws Exception; //@
  public _String_if asString() throws Exception;

  //================================================== support methods
//  public java.lang.String toString();

}

// EoF

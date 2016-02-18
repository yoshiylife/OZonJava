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
 * GridBagConstraints interface
 *
 * @version  $Id: _GridBagConstraints_if.java,v 1.9 1997/06/18 12:58:10 nito Exp $
 * @see      _GridBagLayout_if
 */


public interface _GridBagConstraints_if
  extends JP.go.ipa.oz.lib.standard._Duplicatable_if
{

  public int getRELATIVE() throws Exception;
  public int getREMAINDER() throws Exception;
  public int getNONE() throws Exception;
  public int getBOTH() throws Exception;
  public int getHORIZONTAL() throws Exception;
  public int getVERTICAL() throws Exception;
  public int getCENTER() throws Exception;
  public int getNORTH() throws Exception;
  public int getNORTHEAST() throws Exception;
  public int getEAST() throws Exception;
  public int getSOUTHEAST() throws Exception;
  public int getSOUTH() throws Exception;
  public int getSOUTHWEST() throws Exception;
  public int getWEST() throws Exception;
  public int getNORTHWEST() throws Exception;

  public int getGridx() throws Exception;
  public void setGridx(int arg) throws Exception;
  public int getGridy() throws Exception;
  public void setGridy(int arg) throws Exception;
  public int getGridwidth() throws Exception;
  public void setGridwidth(int arg) throws Exception;
  public int getGridheight() throws Exception;
  public void setGridheight(int arg) throws Exception;
  public double getWeightx() throws Exception;
  public void setWeightx(double arg) throws Exception;
  public double getWeighty() throws Exception;
  public void setWeighty(double arg) throws Exception;
  public int getAnchor() throws Exception;
  public void setAnchor(int arg) throws Exception;
  public int getFill() throws Exception;
  public void setFill(int arg) throws Exception;
  public _Insets_if getInsets() throws Exception;
  public void setInsets(_Insets_if arg) throws Exception;
  public int getIpadx() throws Exception;
  public void setIpadx(int arg) throws Exception;
  public int getIpady() throws Exception;
  public void setIpady(int arg) throws Exception;


  //================================================== OZ methods
  public JP.go.ipa.oz.lang._Root_if duplicate() throws Exception; //<clone

}

// EoF


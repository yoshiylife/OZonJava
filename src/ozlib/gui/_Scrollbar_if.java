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
 * Scrollbar interface
 *
 * @version  $Id: _Scrollbar_if.java,v 1.8 1997/06/24 07:11:17 nito Exp $
 * @see      _Component_if
 * @see      _Adjustable_if
 */


public interface _Scrollbar_if
  extends JP.go.ipa.oz.lib.standard._Component_if,
          JP.go.ipa.oz.lib.standard._Adjustable_if
{

  public int getHORIZONTAL() throws Exception;
  public int getVERTICAL() throws Exception;

  //================================================== OZ methods
  public void addAdjustmentListener(_AdjustmentListener_if l) throws Exception;
  public int getBlockIncrement() throws Exception;
  public void addNotify() throws Exception;
  //public int getLineIncrement() throws Exception; //DEPRECATED ... getUnitIncrement
  public int getMaximum() throws Exception;
  public int getMinimum() throws Exception;
  public int getOrientation() throws Exception;
  //public int getPageIncrement() throws Exception; //DEPRECATED ... getBlockIncrement
  public int getUnitIncrement() throws Exception;
  public int getValue() throws Exception;
  //public int getVisible() throws Exception; //DEPRECATED ... getVisibleAmount
  public int getVisibleAmount() throws Exception;
  public boolean isHorizontal() throws Exception; //@
  public boolean isVertical() throws Exception; //@
  public void removeAdjustmentListener(_AdjustmentListener_if l) throws Exception; //synchronized
  public void setBlockIncrement(int v) throws Exception; //synchronized
  //public void setLineIncrement(int v) throws Exception; //synchronized //DEPRECATED ... setUnitIncrement
  public void setMaximum(int newMaximum) throws Exception; //synchronized
  public void setMinimum(int newMinimum) throws Exception; //synchronized
  //@public void setOrientation(int orientation) throws Exception; //synchronized
  public void setOrientationToHorizontal() throws Exception; //@
  public void setOrientationToVertical() throws Exception; //@
  //public void setPageIncrement(int v) throws Exception; //DEPRECATED ... setBlockIncrement
  public void setUnitIncrement(int v) throws Exception; //synchronized
  public void setValue(int newValue) throws Exception; //synchronized
  public void setValues(int value, int visible, int minimum, int maximum) throws Exception; //synchronized
  public void setVisibleAmount(int newAmount) throws Exception; //synchronized
  public _String_if asString() throws Exception;

}

// EoF


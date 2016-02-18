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
 * Adjustable interface
 *
 * @version  $Id: _Adjustable_if.java,v 1.7 1997/06/13 08:49:45 nito Exp $
 */


public interface _Adjustable_if
  extends JP.go.ipa.oz.lang._Root_if
{

  //================================================== OZ methods
  public int getHORIZONTAL() throws Exception;
  public int getVERTICAL() throws Exception;

  public void addAdjustmentListener(_AdjustmentListener_if l) throws Exception;
  public int getBlockIncrement() throws Exception;
  public int getMaximum() throws Exception;
  public int getMinimum() throws Exception;
  public int getOrientation() throws Exception;
  public int getUnitIncrement() throws Exception;
  public int getValue() throws Exception;
  public int getVisibleAmount() throws Exception;
  public void removeAdjustmentListener(_AdjustmentListener_if l) throws Exception;
  public void setBlockIncrement(int b) throws Exception;
  public void setMaximum(int max) throws Exception;
  public void setMinimum(int min) throws Exception;
  public void setUnitIncrement(int u) throws Exception;
  public void setValue(int v) throws Exception;
  public void setVisibleAmount(int v) throws Exception;

}

// EoF


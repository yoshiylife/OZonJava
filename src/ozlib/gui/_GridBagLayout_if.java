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
 * GridBagLayout interface
 *
 * @version  $Id: _GridBagLayout_if.java,v 1.9 1997/07/01 02:32:26 nito Exp $
 * @see      _LayoutManager2_if
 * @see      _GridBagConstraints_if
 */


public interface _GridBagLayout_if
  extends JP.go.ipa.oz.lib.standard._LayoutManager2_if
{

  //================================================== OZ costructors

  //================================================== OZ methods
//  public void addLayoutComponent(_String_if name, _Component_if comp) throws Exception;
//  public void addLayoutComponent(_Component_if comp,
//				 JP.go.ipa.oz.lang._Root_if constraints) throws Exception;
//  public _GridBagConstraints_if getConstraints(_Component_if comp) throws Exception;
//  public float getLayoutAlignmentX(_Container_if parent) throws Exception;
//  public float getLayoutAlignmentY(_Container_if parent) throws Exception;
//  //public int[][] getLayoutDimensions() throws Exception;
//  public _Point_if getLayoutOrigin() throws Exception;
//  //public double[][] getLayoutWeights() throws Exception;
//  public void layoutContainer(_Container_if parent) throws Exception;
//  public _Point_if location(int x, int y) throws Exception;
//  public void invalidateLayout(_Container_if target) throws Exception;
//  public _Dimension_if maximumLayoutSize(_Container_if target) throws Exception;
//  public _Dimension_if minimumLayoutSize(_Container_if parent) throws Exception;
//  public _Dimension_if preferredLayoutSize(_Container_if parent) throws Exception;
//  public void removeLayoutComponent(_Component_if comp) throws Exception;
  public void setConstraints(_Component_if comp, _GridBagConstraints_if constraints) throws Exception;
  public java.lang.Object java() throws Exception;

}

// EoF


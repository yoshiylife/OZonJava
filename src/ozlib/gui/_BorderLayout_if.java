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
 * BorderLayout interface
 *
 * @version  $Id: _BorderLayout_if.java,v 1.10 1997/07/25 02:19:37 nito Exp $
 * @see      _LayoutManager2_if
 * @see      _BorderLayout_cl
 */


public interface _BorderLayout_if
  extends JP.go.ipa.oz.lib.standard._LayoutManager2_if
{

    public _String_if getNORTH() throws Exception;
    public _String_if getSOUTH() throws Exception;
    public _String_if getEAST() throws Exception;
    public _String_if getWEST() throws Exception;
    public _String_if getCENTER() throws Exception;
//
//
//  //================================================== OZ public methods
//  public void addLayoutComponent(_Component_if comp,
//				 JP.go.ipa.oz.lang._Root_if constraints) throws Exception;
//  //public void addLayoutComponent(_String_if name, _Component_if comp) throws Exception; //DEPRECATED
//  public int getHgap() throws Exception;
//  public float getLayoutAlignmentX(_Container_if parent) throws Exception;
//  public float getLayoutAlignmentY(_Container_if parent) throws Exception;
//  public int getVgap() throws Exception;
//  public void invalidateLayout(_Container_if target) throws Exception;
//  public void layoutContainer(_Container_if target) throws Exception;
//  public _Dimension_if maximumLayoutSize(_Container_if target) throws Exception;
//  public _Dimension_if minimumLayoutSize(_Container_if target) throws Exception;
//  public _Dimension_if preferredLayoutSize(_Container_if target) throws Exception;
//  public void removeLayoutComponent(_Component_if comp) throws Exception;
//  public void setHgap(int hgap) throws Exception;
//  public void setVgap(int vgap) throws Exception;
    public java.lang.Object java() throws Exception;

}

// EoF


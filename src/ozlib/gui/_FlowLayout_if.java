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
 * FlowLayout interface
 *
 * @version  $Id: _FlowLayout_if.java,v 1.10 1997/07/25 02:19:37 nito Exp $
 * @see      _LayoutManager_if
 */


public interface _FlowLayout_if
  extends JP.go.ipa.oz.lib.standard._LayoutManager_if
{

    public int getLEFT() throws Exception;
    public int getCENTER() throws Exception;
    public int getRIGHT() throws Exception;
//
//
//  //================================================== OZ methods
//  public void addLayoutComponent(_String_if name, _Component_if comp) throws Exception;
//  public int getAlignment() throws Exception;
//  public int getHgap() throws Exception;
//  public int getVgap() throws Exception;
//  public void layoutContainer(_Container_if target) throws Exception;
//  public _Dimension_if minimumLayoutSize(_Container_if target) throws Exception;
//  public _Dimension_if preferredLayoutSize(_Container_if target) throws Exception;
//  public void removeLayoutComponent(_Component_if comp) throws Exception;
//  public void setAlignment(int align) throws Exception;
//  public void setHgap(int hgap) throws Exception;
//  public void setVgap(int vgap) throws Exception;
  public java.lang.Object java() throws Exception;

}

// EoF

